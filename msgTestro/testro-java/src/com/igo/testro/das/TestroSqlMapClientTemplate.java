package com.igo.testro.das;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.JdbcUpdateAffectedIncorrectNumberOfRowsException;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.jdbc.support.JdbcAccessor;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.SqlMapClientOperations;
import org.springframework.util.Assert;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ibatis.sqlmap.client.SqlMapSession;
import com.ibatis.sqlmap.client.event.RowHandler;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;

public class TestroSqlMapClientTemplate extends JdbcAccessor implements SqlMapClientOperations{
	
	private static final String DB2 = "jdbc:db2";

	private static final String DERBY = "jdbc:derby";

	final ITestroLogger logger = TestroLogHelper.getFramework();
	
	private SqlMapClient sqlMapClient;


	/**
	 * Create a new SqlMapClientTemplate.
	 */
	public TestroSqlMapClientTemplate() {
	}

	/**
	 * Create a new SqlMapTemplate.
	 * @param sqlMapClient iBATIS SqlMapClient that defines the mapped statements
	 */
	public TestroSqlMapClientTemplate(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
		afterPropertiesSet();
	}

	/**
	 * Create a new SqlMapTemplate.
	 * @param dataSource JDBC DataSource to obtain connections from
	 * @param sqlMapClient iBATIS SqlMapClient that defines the mapped statements
	 */
	public TestroSqlMapClientTemplate(DataSource dataSource, SqlMapClient sqlMapClient) {
		setDataSource(dataSource);
		setSqlMapClient(sqlMapClient);
		afterPropertiesSet();
	}


	/**
	 * Set the iBATIS Database Layer SqlMapClient that defines the mapped statements.
	 */
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * Return the iBATIS Database Layer SqlMapClient that this template works with.
	 */
	public SqlMapClient getSqlMapClient() {
		return this.sqlMapClient;
	}

	/**
	 * If no DataSource specified, use SqlMapClient's DataSource.
	 * @see com.ibatis.sqlmap.client.SqlMapClient#getDataSource()
	 */
	@Override
	public DataSource getDataSource() {
		DataSource ds = super.getDataSource();
		return (ds != null ? ds : this.sqlMapClient.getDataSource());
	}

	@Override
	public void afterPropertiesSet() {
		if (this.sqlMapClient == null) {
			throw new IllegalArgumentException("Property 'sqlMapClient' is required");
		}
		super.afterPropertiesSet();
	}


	/**
	 * Execute the given data access action on a SqlMapExecutor.
	 * @param action callback object that specifies the data access action
	 * @return a result object returned by the action, or <code>null</code>
	 * @throws DataAccessException in case of SQL Maps errors
	 */
	public <T> T execute(SqlMapClientCallback<T> action) throws DataAccessException {
		Assert.notNull(action, "Callback object must not be null");
		Assert.notNull(this.sqlMapClient, "No SqlMapClient specified");

		// We always need to use a SqlMapSession, as we need to pass a Spring-managed
		// Connection (potentially transactional) in. This shouldn't be necessary if
		// we run against a TransactionAwareDataSourceProxy underneath, but unfortunately
		// we still need it to make iBATIS batch execution work properly: If iBATIS
		// doesn't recognize an existing transaction, it automatically executes the
		// batch for every single statement...

		SqlMapSession session = this.sqlMapClient.openSession();
		if (logger.isDebugEnabled()) {
			logger.debug("Opened SqlMapSession [" + session + "] for iBATIS operation");
		}
		Connection ibatisCon = null;

		try {
			Connection springCon = null;
			DataSource dataSource = getDataSource();
			boolean transactionAware = (dataSource instanceof TransactionAwareDataSourceProxy);

			// Obtain JDBC Connection to operate on...
			try {
				ibatisCon = session.getCurrentConnection();
				if (ibatisCon == null) {
					springCon = (transactionAware ?
							dataSource.getConnection() : DataSourceUtils.doGetConnection(dataSource));
					
					String jdbcUrl = springCon.getMetaData().getURL();
					if (logger.isDebugEnabled()) logger.debug("JDBC URL : [" + jdbcUrl + "]");
					
					// driver명을 체크하여 derby, db2 일 경우 TRANSACTION_READ_UNCOMMITTED로 설정해준다.
					if (jdbcUrl.startsWith(DERBY) || jdbcUrl.startsWith(DB2)) {
						springCon.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
						if (logger.isDebugEnabled()) logger.debug("connection setTransactionIsolation : [TRANSACTION_READ_UNCOMMITTED]");
					}
					
					session.setUserConnection(springCon);
					if (logger.isDebugEnabled()) {
						logger.debug("Obtained JDBC Connection [" + springCon + "] for iBATIS operation");
					}
				}
				else {
					if (logger.isDebugEnabled()) {
						logger.debug("Reusing JDBC Connection [" + ibatisCon + "] for iBATIS operation");
					}
				}
			}
			catch (SQLException ex) {
				throw new CannotGetJdbcConnectionException("Could not get JDBC Connection", ex);
			}

			// Execute given callback...
			try {
				return action.doInSqlMapClient(session);
			}
			catch (SQLException ex) {
				throw getExceptionTranslator().translate("SqlMapClient operation", null, ex);
			}
			finally {
				try {
					if (springCon != null) {
						if (transactionAware) {
							springCon.close();
						}
						else {
							DataSourceUtils.doReleaseConnection(springCon, dataSource);
						}
					}
				}
				catch (Throwable ex) {
					logger.debug("Could not close JDBC Connection", ex);
				}
			}

			// Processing finished - potentially session still to be closed.
		}
		finally {
			// Only close SqlMapSession if we know we've actually opened it
			// at the present level.
			if (ibatisCon == null) {
				session.close();
			}
		}
	}

	/**
	 * Execute the given data access action on a SqlMapExecutor,
	 * expecting a List result.
	 * @param action callback object that specifies the data access action
	 * @return the List result
	 * @throws DataAccessException in case of SQL Maps errors
	 * @deprecated as of Spring 3.0 - not really needed anymore with generic
	 * {@link #execute} method
	 */
	@Deprecated
	public List executeWithListResult(SqlMapClientCallback<List> action) throws DataAccessException {
		return execute(action);
	}

	/**
	 * Execute the given data access action on a SqlMapExecutor,
	 * expecting a Map result.
	 * @param action callback object that specifies the data access action
	 * @return the Map result
	 * @throws DataAccessException in case of SQL Maps errors
	 * @deprecated as of Spring 3.0 - not really needed anymore with generic
	 * {@link #execute} method
	 */
	@Deprecated
	public Map executeWithMapResult(SqlMapClientCallback<Map> action) throws DataAccessException {
		return execute(action);
	}


	public Object queryForObject(String statementName) throws DataAccessException {
		return queryForObject(statementName, null);
	}

	public Object queryForObject(final String statementName, final Object parameterObject)
			throws DataAccessException {

		return execute(new SqlMapClientCallback<Object>() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				return executor.queryForObject(statementName, parameterObject);
			}
		});
	}

	public Object queryForObject(
			final String statementName, final Object parameterObject, final Object resultObject)
			throws DataAccessException {

		return execute(new SqlMapClientCallback<Object>() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				return executor.queryForObject(statementName, parameterObject, resultObject);
			}
		});
	}

	public List queryForList(String statementName) throws DataAccessException {
		return queryForList(statementName, null);
	}

	public List queryForList(final String statementName, final Object parameterObject)
			throws DataAccessException {

		return execute(new SqlMapClientCallback<List>() {
			public List doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				return executor.queryForList(statementName, parameterObject);
			}
		});
	}

	public List queryForList(String statementName, int skipResults, int maxResults)
			throws DataAccessException {

		return queryForList(statementName, null, skipResults, maxResults);
	}

	public List queryForList(
			final String statementName, final Object parameterObject, final int skipResults, final int maxResults)
			throws DataAccessException {

		return execute(new SqlMapClientCallback<List>() {
			public List doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				return executor.queryForList(statementName, parameterObject, skipResults, maxResults);
			}
		});
	}

	public void queryWithRowHandler(String statementName, RowHandler rowHandler)
			throws DataAccessException {

		queryWithRowHandler(statementName, null, rowHandler);
	}

	public void queryWithRowHandler(
			final String statementName, final Object parameterObject, final RowHandler rowHandler)
			throws DataAccessException {

		execute(new SqlMapClientCallback<Object>() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				executor.queryWithRowHandler(statementName, parameterObject, rowHandler);
				return null;
			}
		});
	}

	public Map queryForMap(
			final String statementName, final Object parameterObject, final String keyProperty)
			throws DataAccessException {

		return execute(new SqlMapClientCallback<Map>() {
			public Map doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				return executor.queryForMap(statementName, parameterObject, keyProperty);
			}
		});
	}

	public Map queryForMap(
			final String statementName, final Object parameterObject, final String keyProperty, final String valueProperty)
			throws DataAccessException {

		return execute(new SqlMapClientCallback<Map>() {
			public Map doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				return executor.queryForMap(statementName, parameterObject, keyProperty, valueProperty);
			}
		});
	}

	public Object insert(String statementName) throws DataAccessException {
		return insert(statementName, null);
	}

	public Object insert(final String statementName, final Object parameterObject)
			throws DataAccessException {

		return execute(new SqlMapClientCallback<Object>() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				return executor.insert(statementName, parameterObject);
			}
		});
	}

	public int update(String statementName) throws DataAccessException {
		return update(statementName, null);
	}

	public int update(final String statementName, final Object parameterObject)
			throws DataAccessException {

		return execute(new SqlMapClientCallback<Integer>() {
			public Integer doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				return executor.update(statementName, parameterObject);
			}
		});
	}

	public void update(String statementName, Object parameterObject, int requiredRowsAffected)
			throws DataAccessException {

		int actualRowsAffected = update(statementName, parameterObject);
		if (actualRowsAffected != requiredRowsAffected) {
			throw new JdbcUpdateAffectedIncorrectNumberOfRowsException(
					statementName, requiredRowsAffected, actualRowsAffected);
		}
	}

	public int delete(String statementName) throws DataAccessException {
		return delete(statementName, null);
	}

	public int delete(final String statementName, final Object parameterObject)
			throws DataAccessException {

		return execute(new SqlMapClientCallback<Integer>() {
			public Integer doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				return executor.delete(statementName, parameterObject);
			}
		});
	}

	public void delete(String statementName, Object parameterObject, int requiredRowsAffected)
			throws DataAccessException {

		int actualRowsAffected = delete(statementName, parameterObject);
		if (actualRowsAffected != requiredRowsAffected) {
			throw new JdbcUpdateAffectedIncorrectNumberOfRowsException(
					statementName, requiredRowsAffected, actualRowsAffected);
		}
	}
}
