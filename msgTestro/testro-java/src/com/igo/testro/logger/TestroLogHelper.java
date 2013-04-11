package com.igo.testro.logger;

/**
 * 
 * <p>
 * 프로그램명:TestroLogHelper.java<br/>
 * 설명 : 로거를 가저오는 API<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 23. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class TestroLogHelper {
	
	private static final String BIZ = "log.testro.biz";
	private static final String PREFERENCE = "log.testro.preference";
	private static final String BOOTSTRAP = "log.testro.bootstrap";
	private static final String FRAMEWORK = "log.testro.framework";
	private static final String SCHEDULE = "log.testro.schedule";

	public static ITestroLogger getBootstrap(){
		return TestroLoggerFactory.getLogger(BOOTSTRAP);
	}
	
	public static ITestroLogger getPreference(){
		return TestroLoggerFactory.getLogger(PREFERENCE);
	}
	
	public static ITestroLogger getBiz(){
		return TestroLoggerFactory.getLogger(BIZ);
	}
	
	
	public static ITestroLogger getFramework(){
		return TestroLoggerFactory.getLogger(FRAMEWORK);
	}
	
	public static ITestroLogger getSchedule(){
		return TestroLoggerFactory.getLogger(SCHEDULE);
	}
	
	
	public static ITestroLogger getLogger(String name){
		return TestroLoggerFactory.getLogger(name);
	}
}
