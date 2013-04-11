package com.igo.testro.testcase;

import javax.servlet.ServletContextEvent;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.WebApplicationContext;

import com.igo.testro.svclistener.init.TestroContextListener;

/**
 * 
 * <p>
 * 프로그램명:TestroTestCase.java<br/>
 * 설명 : 웹프레임워크 bean 테스트케이스<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 16. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class TestroTestCase {
	
	protected static MockServletContext mockServletContext;
	protected static MockHttpServletRequest mockHttpServletRequest; 
	protected static WebApplicationContext applicationContext = null;
	
	/**
	 * 
	 * <p>
	 * 테스트를 위한 초기화 작업
	 * <p>
	 * @param configPath CONFIG_PATH경로
	 * @param contextConfigLocations bean을 정의한 application context 경로들
	 */
	@SuppressWarnings("static-access")
	protected static void init(String configPath, String... contextConfigLocations) {
		System.setProperty("CONFIG_PATH", configPath);
		String contextConfigLocation = "";
		for (String location : contextConfigLocations) {
			contextConfigLocation = contextConfigLocation + location + " ";
		}
		
		mockServletContext = new MockServletContext("/WebContent", new FileSystemResourceLoader());
		mockServletContext.addInitParameter("contextConfigLocation", contextConfigLocation.trim()); 
		
		TestroContextListener testroContextLoader = new TestroContextListener(); 
		testroContextLoader.contextInitialized(new ServletContextEvent(mockServletContext));
		
		applicationContext = testroContextLoader.getCurrentWebApplicationContext();
	}
	
}
