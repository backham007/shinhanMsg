package com.igo.testro.das.dbcp;

import javax.sql.DataSource;
import org.springframework.beans.factory.FactoryBean;
import com.igo.testro.das.SqlMapper;

/**
 * 
 * <p>
 * 프로그램명:TestroDataSource.java<br/>
 * 설명 : webcontext에 올려진 빈으로 동적 context의 빈을 이어주는 역할을 담당한다.<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 16. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class TestroDataSource implements FactoryBean<DataSource> {

	public DataSource getObject() throws Exception {
		
		//TODO 나중에 jndi에서 문제가 발생할수 있는 코드 이므로 반드시 확인해야함 
		return SqlMapper.getInstance().getTranDs();
	}

	public Class<?> getObjectType() {
		return DataSource.class;
	}

	public boolean isSingleton() {
		return true;
	}

}
