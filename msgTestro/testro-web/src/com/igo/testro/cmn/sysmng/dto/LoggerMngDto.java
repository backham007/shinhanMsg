package com.igo.testro.cmn.sysmng.dto;

import com.igo.testro.dto.AbstractDTO;

/**
 * 
 * <p>
 * 프로그램명:LoggInfoDto.java<br/>
 * 설명 : 로그레벨관리 DTO<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 15. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class LoggerMngDto extends AbstractDTO{
	
	private static final long serialVersionUID = 1L;
	
	// 로그명 
	private String logName;
	
	// 로그파일경로
	private String logFilePath;
	
	// 로그레벨
	private String logLevel;
	
	// 기본레벨
	private String orgLogLevel;
	
	public String getLogName() {
		return logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

	public String getLogFilePath() {
		return logFilePath;
	}

	public void setLogFilePath(String logFilePath) {
		this.logFilePath = logFilePath;
	}

	public String getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}

	public String getOrgLogLevel() {
		return orgLogLevel;
	}

	public void setOrgLogLevel(String orgLogLevel) {
		this.orgLogLevel = orgLogLevel;
	}
}
