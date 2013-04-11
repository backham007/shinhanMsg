package com.igo.testro.das;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.igo.testro.bean.util.TestroBeanUtil;
import com.igo.testro.constant.DataSouceType;
import com.igo.testro.exception.FrameworkException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.preference.TestroPreference;

/**
 * 
 * <p>
 * 프로그램명:SqlMapper.java<br/>
 * 설명 : sqlMapClientTemplat 객체를 가져오는 클래스<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 8. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class SqlMapper {
	
	private static final String JNDI_NAME = "jndiName";
	private static final String TYPE = "type";
	private static final String TRANSACTION = "transaction";
	private static final String DATA_SOURCE_LIST = "DATA_SOURCE_LIST";
	private static final String PROP = ".prop";
	private static final String DATA_SOURCE = "dataSource.";
	private static final String CONFIG_PATH = "CONFIG_PATH";
	final ITestroLogger logger = TestroLogHelper.getFramework();
	private static GenericApplicationContext ctx = new GenericApplicationContext();
	private static SqlMapper instance = null;
	private String tranDs = "";
	
	
	/**
	 * 
	 * <p>
	 * SqlMapper singleton 메소드
	 * <p>
	 * @return
	 * @throws FrameworkException
	 */
	public static SqlMapper getInstance() throws FrameworkException {
		if (instance == null) {
			synchronized (SqlMapper.class) {
				if (instance == null) {
					instance = new SqlMapper();
				}
			}
		}
		return instance;
	}


	/**
	 * 
	 * <p>
	 * SqlMapClientTemplate를 확장한 TestroSqlMapClient객체를 가져온다.
	 * <p>
	 * @param testroSqlMap bean id
	 * @return
	 */
	public static TestroSqlMapClientTemplate getSqlClient(String testroSqlMap){
		TestroSqlMapClient service = (TestroSqlMapClient) ctx.getBean(testroSqlMap);
		return service.getSqlMapClientTemplate();
	}
	
	
	/**
	 * 
	 * <p>
	 * slqMap 초기화
	 * <p>
	 */
	public void init() {
		String dataSourceList = TestroPreference.getInstance().getProperty(DATA_SOURCE_LIST);
		
		if (dataSourceList == null || "".equals(dataSourceList)) return;
		String[] dsList = dataSourceList.split("[|]");
		
		Properties props = new Properties();
		
		for (int i = 0; i < dsList.length; i++) {
			props.clear();
			FileInputStream fileInputStream = null;
	        try {
	        	
	        	String ds = dsList[i];
				String dsFileNm = DATA_SOURCE + ds + PROP;
				String dsConfPath = TestroPreference.getInstance().getProperty(CONFIG_PATH) 
				+ "/" + TestroPreference.getInstance().convConfFolder() + "/" + dsFileNm;
	        	
				fileInputStream = new FileInputStream(new File(dsConfPath));
				props.load(fileInputStream);
				createTransMng(ds, props);
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new FrameworkException("SqlMap init error..", e);
			} finally {
				try {fileInputStream.close();} catch (Exception ignore){}
			}
			
			
		}
	}

	
	/**
	 * 
	 * <p>
	 * 트랜잭션 설정을 위한 spring bean동적 생성
	 * <p>
	 * @param dataSource
	 * @param props
	 */
	public void createTransMng(String dataSource, Properties props) {
		
		if ("true".equals(props.getProperty(TRANSACTION))) {
			tranDs = "ds_" + dataSource;
		}
		
		// 1. dataSource bean 생성
		
		if (DataSouceType.JNDI.getCode().equals(props.getProperty(TYPE))) {
			BeanDefinitionBuilder bDBuilder = BeanDefinitionBuilder.rootBeanDefinition(JndiObjectFactoryBean.class);
			bDBuilder.addPropertyValue(JNDI_NAME, props.getProperty(JNDI_NAME));
			ctx.registerBeanDefinition("ds_" + dataSource, bDBuilder.getBeanDefinition());
			
			Object dsBean = (Object) ctx.getBean("ds_" + dataSource);
			
		} else if (DataSouceType.JDBC.getCode().equals(props.getProperty(TYPE))) {
			
			BeanDefinitionBuilder bDBuilder = BeanDefinitionBuilder.rootBeanDefinition(BasicDataSource.class);
			bDBuilder.setDestroyMethodName("close");
			ctx.registerBeanDefinition("ds_" + dataSource, bDBuilder.getBeanDefinition());
			
			BasicDataSource dsBean = (BasicDataSource) ctx.getBean("ds_" + dataSource);
			TestroBeanUtil.copyPropeToBean(props, dsBean);
		}
		
		try {
			
			// 2. SqlMapClientFactoryBean bean 생성
			BeanDefinitionBuilder bDBuilder3 = BeanDefinitionBuilder.rootBeanDefinition(SqlMapClientFactoryBean.class);
			bDBuilder3.addPropertyReference("dataSource", "ds_" + dataSource);
			bDBuilder3.addPropertyValue("configLocation", props.getProperty("configLocation"));
			ctx.registerBeanDefinition("sqlmap_" + dataSource, bDBuilder3.getBeanDefinition());
			
			// 3. TestroSqlMapClient bean 생성
			BeanDefinitionBuilder bDBuilder4 = BeanDefinitionBuilder.rootBeanDefinition(TestroSqlMapClient.class);
			bDBuilder4.addPropertyReference("sqlMapClient", "sqlmap_" + dataSource);
			ctx.registerBeanDefinition(dataSource, bDBuilder4.getBeanDefinition());
			
			
		} catch (IllegalArgumentException e) {
			throw new FrameworkException("createTransMng error..", e);
		}
	}

	
	public DataSource getTranDs() {
		if ("".equals(tranDs)) return new BasicDataSource(); 
		return (DataSource) ctx.getBean(tranDs);
	}


	public void deleteTestroSqlMapClient(String dsName) {
		ctx.removeBeanDefinition(dsName);
	}
	

}
