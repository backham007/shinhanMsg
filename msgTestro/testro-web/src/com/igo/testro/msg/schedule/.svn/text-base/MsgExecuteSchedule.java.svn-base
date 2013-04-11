package com.igo.testro.msg.schedule;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import com.igo.testro.exception.FrameworkException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.schedule.dao.ScheduleMngDao;
import com.igo.testro.msg.schedule.dto.ScheduleMngDto;
import com.igo.testro.msg.tcmng.biz.TcmngBiz;
import com.igo.testro.msg.tsmng.biz.TsExecuteBiz;

/**
 * 
 * <p>
 * 프로그램명:MsgExecuteSchedule.java<br/>
 * 설명 : 스케줄러가 일분에 한번씩 호출하는 서비스<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 9. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class MsgExecuteSchedule {
	
	final ITestroLogger logger = TestroLogHelper.getSchedule();
	
	private Format formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	
	@Autowired
	private ScheduleMngDao scheduleMngDao;
	
	@Autowired
	private TcmngBiz tcmngBiz;
	
	@Autowired
	private TsExecuteBiz  tsExecuteBiz ;
	
	private ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 100,
			0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
	
	/**
	 * 
	 * <p>
	 * Timer에서 받은 date을 가지고 테스트예약 실행목록을 조회하여<br/>
	 * 쓰레드로 각각의 테스트/시나리오를 실행한다.
	 * 
	 * <p>
	 * @param date 예약실행시간
	 */
	public void executeSchedule(String date) {
		List<ScheduleMngDto> listRegist = scheduleMngDao.getListRegist(date);
		
		for (ScheduleMngDto scheduleMngDto : listRegist) {
			try {
				executor.execute(new FutureTask<Object>(new ExecuteScheduleTask(scheduleMngDto, logger, date)));
			} catch (Exception e) {
				logger.error("", e);
			}
		}
	}
	
	
	/**
	 * 
	 * <p>
	 * 프로그램명 : MsgExecuteSchedule.java<br/>
	 * 설명 : 테스트/시나리오를 실행하는 Callable 클래스<br/>
	 * 변경이력<br/>
	 * <ul>
	 *	  <li>2012. 3. 19. : kangwoo : 최초작성
	 * </ul> 
	 * </p>
	 */
	class ExecuteScheduleTask implements Callable<Object>  {
		private ScheduleMngDto scheduleMngDto;
		private ITestroLogger logger;
		private String date;
		
		/**
		 * 
		 * <p>
		 * ExecuteScheduleTask 생성자<br/>
		 * <p>
		 * @param scheduleMngDto 테스트예약실행관리DTO
		 * @param logger 로거
		 * @param date 예약실행시간
		 */
		public ExecuteScheduleTask(ScheduleMngDto scheduleMngDto, ITestroLogger logger, String date) {
			this.scheduleMngDto = scheduleMngDto;
			this.logger = logger;
			this.date = date;
		}
		
		/**
		 * 
		 * <p>
		 * 쓰레드 실행 메소드
		 * <p>
		 * @return null
		 * @throws Exception
		 */
		public Object call() throws Exception {
			long acmplnTh = 0;
			String success = "Y";
			
			String tsDataId = scheduleMngDto.getTsDataId();
			long jobSno = scheduleMngDto.getJobSno();
			String testUnitCd = scheduleMngDto.getTestUnitCd();
			
			
			String prevTime = formatter.format(new Date(System.currentTimeMillis()));
			
			ScheduleMngDto dto = new ScheduleMngDto();
			dto.setTsDataId(tsDataId);
			dto.setJobSno(jobSno);
			
			// 예약작업실행상태구분코드(01:미실행, 02:실행중, 03:실행완료)
			dto.setJobExeStusCd("02");
			dto.setLastModfiYms(prevTime);
			
			scheduleMngDao.modifyScheduleResult(dto);
			
			try {
				// 01 : 테스트케이스 실행
				if ("01".equals(testUnitCd)) {
					if (logger.isInfoEnabled()) logger.info("==================================");
					if (logger.isInfoEnabled()) logger.info("테스트케이스 실행");
					if (logger.isInfoEnabled()) logger.info("----------------------------------");
					if (logger.isInfoEnabled()) logger.info("테스트데이터ID : [" + tsDataId + "]");
					if (logger.isInfoEnabled()) logger.info("작업예약일시 : [" + date + "]");
					if (logger.isInfoEnabled()) logger.info("테스트대상시스템코드 : [" + scheduleMngDto.getConnSevrDstCd() + "]");
					if (logger.isInfoEnabled()) logger.info("작업자ID : [" + scheduleMngDto.getWriteId() + "]");
					if (logger.isInfoEnabled()) logger.info("==================================");
					
					acmplnTh = Long.parseLong(tcmngBiz.excuteTc(dto.getTsDataId(), null, scheduleMngDto.getWriteId(), null, scheduleMngDto.getConnSevrDstCd())); 
				
				// 01 : 테스트시나리오 실행
				} else if ("02".equals(testUnitCd)) {
					if (logger.isInfoEnabled()) logger.info("==================================");
					if (logger.isInfoEnabled()) logger.info("테스트시나리오 실행");
					if (logger.isInfoEnabled()) logger.info("----------------------------------");
					if (logger.isInfoEnabled()) logger.info("테스트데이터ID : [" + tsDataId + "]");
					if (logger.isInfoEnabled()) logger.info("작업예약일시 : [" + date + "]");
					if (logger.isInfoEnabled()) logger.info("테스트대상시스템코드 : [" + scheduleMngDto.getConnSevrDstCd() + "]");
					if (logger.isInfoEnabled()) logger.info("작업자ID : [" + scheduleMngDto.getWriteId() + "]");
					if (logger.isInfoEnabled()) logger.info("==================================");
					
					acmplnTh = tsExecuteBiz.executeTsSnrio(dto.getTsDataId(), scheduleMngDto.getWriteId(), scheduleMngDto.getConnSevrDstCd());
				} else {
					throw new FrameworkException("존재하지 않는 테스트단위구분코드입니다.");
				}
			} catch (Throwable e) {
				success = "N";
				logger.error("", e);
			} finally {
				String lastTime = formatter.format(new Date(System.currentTimeMillis()));
				ScheduleMngDto resultDto = new ScheduleMngDto();
				resultDto.setTsDataId(tsDataId);
				resultDto.setJobSno(jobSno);
				resultDto.setAcmplnTh(acmplnTh);
				resultDto.setJobSucssYn(success);
				// 예약작업실행상태구분코드(01:미실행, 02:실행중, 03:실행완료)
				resultDto.setJobExeStusCd("03");
				resultDto.setJobExeYms(lastTime);
				resultDto.setLastModfiYms(lastTime);
				scheduleMngDao.modifyScheduleResult(resultDto);
			}
			
			return null;
		}
	}
}

