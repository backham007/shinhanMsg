package com.igo.testro.cmn.sysmng.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.igo.testro.cmn.dto.GridBaseDto;
import com.igo.testro.cmn.sysmng.dto.LoggerMngDto;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.logger.TestroLoggerMng;

/**
 * 
 * <p>
 * 프로그램명:LoggerMngBiz.java<br/>
 * 설명 : 로그관리 Biz<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 16. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class LoggerMngBiz {
	
	final ITestroLogger logger = TestroLogHelper.getBiz();
	
	/**
	 * 
	 * <p>
	 * 로그정보리스트 조회
	 * <p>
	 * @param gridBaseDto 그리드기본DTO 
	 * @return 로그정보리스트 및 그리드 페이징변수
	 */
	public Map<String, Object> getListLoggerInfo(GridBaseDto gridBaseDto) {
		
		Map<String, Object> outputMap = new HashMap<String, Object>();
		
		ArrayList<Map<String, String>> listLoggerInfo = TestroLoggerMng.getInstance().getListLoggerInfo();
		ArrayList<LoggerMngDto> loggerInfoList = new ArrayList<LoggerMngDto>();
		
		for (Map<String, String> map : listLoggerInfo) {
			LoggerMngDto loggerInfoDto = new LoggerMngDto();
			loggerInfoDto.setLogName(map.get(TestroLoggerMng.NAME));
			loggerInfoDto.setLogFilePath(map.get(TestroLoggerMng.LOG_FILE_PATH));
			loggerInfoDto.setLogLevel(map.get(TestroLoggerMng.LEVEL));
			loggerInfoDto.setOrgLogLevel(map.get(TestroLoggerMng.ORG_LEVEL));
			if (logger.isDebugEnabled()) logger.debug("loggerInfoDto : [" + loggerInfoDto +"]");
			loggerInfoList.add(loggerInfoDto);
		}
		
		outputMap.put("rows", loggerInfoList );                          //조회된 list 데이터
		outputMap.put("records", loggerInfoList.size());                       //조회된 총건수
		outputMap.put("page", 1);                            // 조회 요청페이지
		outputMap.put("total",  loggerInfoList.size());//총 페이지수
		return outputMap;
	}
	
	/**
	 * 
	 * <p>
	 * 로그레벨변경
	 * <p>
	 * @param logName 로그명
	 * @param level 로그레벨
	 */
	public void modifyLoggerLevel(String logName, String level) {
		TestroLoggerMng.getInstance().modifyLoggerLevel(logName, level);
	}

}
