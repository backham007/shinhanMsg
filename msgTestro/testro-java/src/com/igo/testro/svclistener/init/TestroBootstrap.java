package com.igo.testro.svclistener.init;

import org.apache.commons.dbcp.BasicDataSource;

import com.igo.testro.das.SqlMapper;
import com.igo.testro.exception.FrameworkException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.logger.TestroLoggerFactory;
import com.igo.testro.preference.TestroPreference;
import com.igo.testro.schedule.ScheduleMng;
import com.igo.testro.service.ServiceFinder;

/**
 * bootstrap 설정
 * @author kangwoo
 *
 */
public class TestroBootstrap implements IBootstrap {
	
	final ITestroLogger logger = TestroLogHelper.getBootstrap();
	
	/**
	 * 초기화 작업
	 */
	public void Initialized() {
		
		// 1. preference 정보를 읽어온다.
		try {
			TestroPreference.getInstance();
		} catch (FrameworkException e) {
			e.printStackTrace();
		}
		
		// 2. logger 생성
		TestroLoggerFactory.resourceConfigure();
		if (logger.isInfoEnabled()) logger.info("logger 생성 완료..");
		
		// 3. sqlMapClient 초기화
		SqlMapper.getInstance().init();
		
		// 4. 스케쥴러 실행
		ScheduleMng.getInstance().init();
	}

	/**
	 * 마무리 작업
	 */
	public void destroyed() {
		
		// 스케쥴러 종료
		ScheduleMng.getInstance().destroy();
		if (logger.isInfoEnabled()) logger.info("logger 생성 완료..");
		
	}
}
