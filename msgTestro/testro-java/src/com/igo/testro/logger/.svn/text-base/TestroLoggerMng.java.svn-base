package com.igo.testro.logger;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Appender;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;

import com.igo.testro.das.SqlMapper;
import com.igo.testro.exception.FrameworkException;

/**
 * 
 * <p>
 * 프로그램명:TestroLoggerMng.java<br/>
 * 설명 : 로거의 레벨정보를 관리한다.<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 15. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class TestroLoggerMng {
	
	public static final String ORG_LEVEL = "orgLogLevel";
	public static final String LOG_FILE_PATH = "logFilePath";
	public static final String LEVEL = "level";
	public static final String NAME = "name";
	private static ArrayList<Map<String, String>> orgLoggerInfoList;
	private static TestroLoggerMng instance;
	final ITestroLogger logger = TestroLogHelper.getBootstrap();
	
	public static TestroLoggerMng getInstance() throws FrameworkException {
		if (instance == null) {
			synchronized (SqlMapper.class) {
				if (instance == null) {
					instance = new TestroLoggerMng();
					orgLoggerInfoList = instance.getListLoggerInfo();
					if (instance.logger.isDebugEnabled()) {
						instance.logger.debug("orgLoggerInfoList : [" + orgLoggerInfoList + "]");
					}
				}
			}
		}
		return instance;
	}
	
	
	/**
	 * 
	 * <p>
	 * 로거정보 조회
	 * <p>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Map<String, String>> getListLoggerInfo() {
		
		
		List<String> loggerNameList = TestroLoggerFactory.loggerNameList;
		ArrayList<Map<String, String>> loggerInfoList = new ArrayList<Map<String, String>>();
		
		for (int i = 0; i < loggerNameList.size(); i++) {
			String loggerName = loggerNameList.get(i);
			ITestroLogger log = TestroLoggerFactory.getLogger(loggerName);
			Level level = log.getLevel();
			Enumeration<Appender> allAppenders = log.getAllAppenders();
			String logFilePath = "";
			
			while (allAppenders.hasMoreElements()) {
				Appender appender = allAppenders.nextElement();
				if (appender instanceof DailyRollingFileAppender && appender instanceof FileAppender) {
					FileAppender fileAppender = (FileAppender) appender;
					if (!"".equals(logFilePath)) {
						logFilePath = logFilePath + ", " + fileAppender.getFile();
					} else {
						logFilePath = fileAppender.getFile();
					}
				}
				
			}
			
			LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
			linkedHashMap.put(NAME, loggerName);
			linkedHashMap.put(LEVEL, level==null? "" : level.toString());
			linkedHashMap.put(LOG_FILE_PATH, logFilePath);
			if (orgLoggerInfoList == null) {
				linkedHashMap.put(ORG_LEVEL, level==null? "" : level.toString());
			} else {
				linkedHashMap.put(ORG_LEVEL, orgLoggerInfoList.get(i).get(LEVEL));
			}
			
			if (logger.isDebugEnabled()) logger.debug("logger Info : [" + linkedHashMap + "]");
			
			loggerInfoList.add(linkedHashMap);
		}
		
		return loggerInfoList;
	}
	
	/**
	 * 
	 * <p>
	 * 로그레벨 변경
	 * <p>
	 * @param logName 로그명
	 * @param level 로그레벨
	 */
	public void modifyLoggerLevel(String logName, String level) {
		ITestroLogger log = TestroLoggerFactory.getLogger(logName);
		Level modyfyLevel = Level.toLevel(level);
		log.setLevel(modyfyLevel);
		if (logger.isDebugEnabled()) logger.debug("modify log level : [" + log.getLevel() + "]");
	}
	
	
	
}
