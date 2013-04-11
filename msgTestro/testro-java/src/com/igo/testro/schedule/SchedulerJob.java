package com.igo.testro.schedule;

import java.lang.reflect.Method;
import com.igo.testro.exception.FrameworkException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.service.ServiceFinder;

/**
 * 
 * <p>
 * 프로그램명:SchedulerJob.java<br/>
 * 설명 : 스케줄설정에서 정의된 executeBeanServie를 실행시킨다. <br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 23. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class SchedulerJob implements Runnable{
	
	private String formatedTime;
	private String executeBeanServieName;
	private String invokeMethod;
	
	final ITestroLogger logger = TestroLogHelper.getSchedule();
	
	public SchedulerJob(String executeBeanServieName, String invokeMethod, String formatedTime) {
		this.formatedTime = formatedTime;
		this.executeBeanServieName = executeBeanServieName;
		this.invokeMethod = invokeMethod;
	}

	public void run() {
		if (logger.isDebugEnabled()) logger.debug("=============================================");
		if (logger.isDebugEnabled()) logger.debug("executeBeanServieName : [" + executeBeanServieName + "]");
		if (logger.isDebugEnabled()) logger.debug("invokeMethod : [" + invokeMethod + "]");
		if (logger.isDebugEnabled()) logger.debug("formatedTime : [" + formatedTime + "]");
		if (logger.isDebugEnabled()) logger.debug("=============================================");
		try {
			Object executeBean = ServiceFinder.getInstance().getService(executeBeanServieName, ServiceFinder.WEB);
			Method method = executeBean.getClass().getMethod(invokeMethod, String.class);
			method.invoke(executeBean, formatedTime);
		} catch (FrameworkException e) {
			logger.error(e);
			throw e;
		} catch (Exception e) {
			logger.error(e);
			throw new FrameworkException("executeBeanServie invoke method refletion error..", e);
		}
	}
}
