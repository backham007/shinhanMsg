package com.igo.testro.svclistener.init;

import javax.servlet.ServletContextEvent;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.web.context.ContextLoaderListener;

import com.igo.testro.das.SqlMapper;
import com.igo.testro.exception.FrameworkException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.service.ServiceFinder;


/**
 * 
 * <p>
 * 프로그램명:TestroContextListener.java<br/>
 * 설명 : spring ContextLoaderListener 확장프로그램<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 10. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class TestroContextListener extends ContextLoaderListener {
	
	ITestroLogger logger = null;
	private IBootstrap testroBootstrap = (IBootstrap) new TestroBootstrap();
	
	/**
	 * 
	 * <p>
	 * context 초기화
	 * <p>
	 * @param event
	 */
	public void contextInitialized(ServletContextEvent event) {
		
		// testro bootstrap 실행
		testroBootstrap.Initialized();
		super.contextInitialized(event);
		
		ServiceFinder.getInstance().init(event.getServletContext());
		logger = TestroLogHelper.getBootstrap();
		
		try {
			// user bootstrap 실행
			if (logger.isInfoEnabled()) logger.info("user bootstrap Initialized start..");
			IBootstrap bootstrap = (IBootstrap)ServiceFinder.getInstance().getService("bootstrap");
			bootstrap.Initialized();
			if (logger.isInfoEnabled()) logger.info("user bootstrap Initialized end..");
		} catch (FrameworkException e) {
			e.printStackTrace();
			if (logger.isInfoEnabled()) logger.info("별도의 사용자 bootstrap이 정의 되지 않았습니다.");
		}
	}
	
	/**
	 * 
	 * <p>
	 * context 종료
	 * <p>
	 * @param event
	 */
	public void contextDestroyed(ServletContextEvent event) {
		
		try {
			
			// user bootstrap 실행
			if (logger.isInfoEnabled()) logger.info("user bootstrap destroyed start..");
			IBootstrap bootstrap = (IBootstrap)ServiceFinder.getInstance().getService("bootstrap");
			bootstrap.destroyed();
			if (logger.isInfoEnabled()) logger.info("user bootstrap destroyed end..");
			
			// testro bootstrap 실행
			if (logger.isInfoEnabled()) logger.info("testro bootstrap contextDestroyed start..");
			testroBootstrap.destroyed();
			if (logger.isInfoEnabled()) logger.info("testro bootstrap contextDestroyed end..");
			
			super.contextDestroyed(event);
			
		} catch (FrameworkException e) {
			e.printStackTrace();
			if (logger != null) logger.error("testro bootstrap contextDestroyed error..", e);
		}
		super.contextDestroyed(event);
		
	}
}
