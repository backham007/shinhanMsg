package com.igo.testro.schedule.dto;

import com.igo.testro.dto.AbstractDTO;

/**
 * 
 * <p>
 * 프로그램명:ScheduleDto.java<br/>
 * 설명 : 스케줄 설정 DTO<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 22. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class ScheduleDto extends AbstractDTO{
	
	private static final long serialVersionUID = 1L;

	private String msgScheduleName;
	
	private boolean runnable;
	
	private String executeBeanServieName;
	
	private String invokeMethod;
	
	private String ParamDateFormat;


	public boolean isRunnable() {
		return runnable;
	}

	public void setRunnable(boolean runnable) {
		this.runnable = runnable;
	}

	public String getExecuteBeanServieName() {
		return executeBeanServieName;
	}

	public void setExecuteBeanServieName(String executeBeanServieName) {
		this.executeBeanServieName = executeBeanServieName;
	}

	public String getInvokeMethod() {
		return invokeMethod;
	}

	public void setInvokeMethod(String invokeMethod) {
		this.invokeMethod = invokeMethod;
	}

	public String getParamDateFormat() {
		return ParamDateFormat;
	}

	public void setParamDateFormat(String paramDateFormat) {
		ParamDateFormat = paramDateFormat;
	}

	public String getMsgScheduleName() {
		return msgScheduleName;
	}

	public void setMsgScheduleName(String msgScheduleName) {
		this.msgScheduleName = msgScheduleName;
	}
	
	
}
