package com.igo.testro.schedule;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.w3c.dom.NodeList;

import com.igo.testro.exception.FrameworkException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.schedule.dto.ScheduleDto;
import com.igo.testro.service.ServiceFinder;

/**
 * 
 * <p>
 * 프로그램명:TestroTimer.java<br/>
 * 설명 : 타이머로 1분간격으로 Thread pool을 통해 해당 서비스를 호출해준다.<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 23. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class TestroTimer implements Runnable{
	
	final ITestroLogger logger = TestroLogHelper.getSchedule();

	public boolean stop = false;
	private List<ScheduleDto> scheduleList;
	private Format formatter;
	
	private ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 30,
			0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
	
	 

	public TestroTimer(List<ScheduleDto> scheduleList) {
		this.scheduleList = scheduleList;
	}

	public void run() {
		
		long currentTimeMillis = System.currentTimeMillis();
		long currentSec = (currentTimeMillis/1000) % 60;
		long initSleepSec = 60-currentSec;
		
		try {
			Thread.sleep(initSleepSec * 1000);
			
			long prevTime = (currentTimeMillis/1000-currentSec) * 1000;
			formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			
			if (logger.isDebugEnabled()) logger.debug("courrentTime : [" + formatter.format(currentTimeMillis) + "]");
			if (logger.isDebugEnabled()) logger.debug("prevTime : [" + formatter.format(prevTime) + "]");
			
			while(!stop) {
				long scheduleTime = (prevTime/1000 + 60) * 1000;
				Date date = new Date(scheduleTime);
				
				for (ScheduleDto schedule : scheduleList) {
					if (!schedule.isRunnable()) continue; 
					formatter = new SimpleDateFormat(schedule.getParamDateFormat());
					String formatedTime = formatter.format(date);
					SchedulerJob schedulerJob = new SchedulerJob(schedule.getExecuteBeanServieName(), schedule.getInvokeMethod(), formatedTime);
					executor.execute(schedulerJob);
				}
				
				currentTimeMillis = System.currentTimeMillis();
				long nowTime = (currentTimeMillis/1000) * 1000;
				long delayTime = nowTime - scheduleTime;
				
				// 딜레이 시간이 일분이상일경우의 처리 중요함
				if (delayTime > 60*1000) {
					long delayMin = delayTime/(60*1000);
					long delayMiliSec = delayTime%(60*1000);
					for (int i = 0; i < delayMin; i++) {
						scheduleTime = (prevTime/1000 + 60) * 1000;
						prevTime = scheduleTime;
						Date date2 = new Date(scheduleTime);
						for (ScheduleDto schedule : scheduleList) {
							if (!schedule.isRunnable()) continue; 
							formatter = new SimpleDateFormat(schedule.getParamDateFormat());
							String formatedTime = formatter.format(date2);
							SchedulerJob schedulerJob = new SchedulerJob(schedule.getExecuteBeanServieName(), schedule.getInvokeMethod(), formatedTime);
							executor.execute(schedulerJob);
						}
					}
					delayTime = delayMiliSec;
				}
				
				prevTime = scheduleTime;
				Thread.sleep(60*1000 - delayTime);
			}
		} catch (InterruptedException e) {
			logger.error(e);
			throw new FrameworkException("Testro Timer error..", e);
		}
	}
}
