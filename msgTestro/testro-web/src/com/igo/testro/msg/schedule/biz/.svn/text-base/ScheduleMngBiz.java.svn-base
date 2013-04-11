package com.igo.testro.msg.schedule.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.schedule.dao.ScheduleMngDao;
import com.igo.testro.msg.schedule.dto.ScheduleMngDto;

/**
 * 
 * <p>
 * 프로그램명 : ScheduleMngBiz.java<br/>
 * 설명 : 테스트예약 실행관리 BIZ<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 23. : kangwoo : 최초작성
 *	  <li>2012. 3. 19. : kangwoo : 주석보완
 * </ul> 
 * </p>
 */
public class ScheduleMngBiz {
	
	
	final ITestroLogger logger = TestroLogHelper.getBiz();
	
	@Autowired
	private ScheduleMngDao scheduleMngDao;
	
	/**
	 * 
	 * <p>
	 * 테스트 예약 정보 조회
	 * <p>
	 * @param scheduleMngDto 테스트예약실행관리DTO
	 * @return 조회된 예약목록 및 그리드 페이지변수
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Map<String, Object> getListSchedule(ScheduleMngDto scheduleMngDto) {
		
		Map<String, Object> outputMap = new HashMap<String, Object>();
		scheduleMngDto.setRecords(scheduleMngDao.getListScheduleTotal(scheduleMngDto));
		List<ScheduleMngDto> listSchedule = scheduleMngDao.getListSchedule(scheduleMngDto);
		
		outputMap.put("rows", listSchedule);                          
		outputMap.put("records", scheduleMngDto.getRecords());
		outputMap.put("page", scheduleMngDto.getPage());
		outputMap.put("total", scheduleMngDto.getTotal());
		return outputMap;
	}
	
	/**
	 * 
	 * <p>
	 * 테스트/시나리오목록 조회
	 * <p>
	 * @param scheduleMngDto 테스트예약실행관리DTO
	 * @return 조회된 테스트/시나리오목록 및 그리드 페이지변수
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Map<String, Object> getListTestCase(ScheduleMngDto scheduleMngDto) {
		
		Map<String, Object> outputMap = new HashMap<String, Object>();
		scheduleMngDto.setRecords(scheduleMngDao.getListTestCaseTotal(scheduleMngDto));
		List<ScheduleMngDto> listSchedule = scheduleMngDao.getListTestCase(scheduleMngDto);
		
		outputMap.put("rows", listSchedule );                    //조회된 list 데이터
		outputMap.put("records", scheduleMngDto.getRecords());   //조회된 총건수
		outputMap.put("page", scheduleMngDto.getPage());         // 조회 요청페이지
		outputMap.put("total", scheduleMngDto.getTotal());       //총 페이지수
		return outputMap;
	}
	
	/**
	 * 
	 * <p>
	 * 테스트예약 실행항목 등록
	 * <p>
	 * @param scheduleMngDto 테스트예약실행관리DTO
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void registerSchedule(ScheduleMngDto scheduleMngDto) {
		scheduleMngDao.registerSchedule(scheduleMngDto);
	}
	
	/**
	 * 
	 * <p>
	 * 테스트예약 실행항목 수정
	 * <p>
	 * @param scheduleMngDto 테스트예약실행관리DTO
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void modifySchedule(ScheduleMngDto scheduleMngDto) {
		scheduleMngDao.modifySchedule(scheduleMngDto);
	}
	
	/**
	 * 
	 * <p>
	 * 테스트예약 실행항목 삭제
	 * <p>
	 * @param scheduleMngDto 테스트예약실행관리DTO
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteSchedule(ScheduleMngDto scheduleMngDto) {
		scheduleMngDao.deleteSchedule(scheduleMngDto);
		
	}
	
	/**
	 * 
	 * <p>
	 * 테스트예약 실행항목 조회
	 * <p>
	 * @param scheduleMngDto 테스트예약실행관리DTO
	 * @return 테스트예약실행관리DTO
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public ScheduleMngDto getSchedule(ScheduleMngDto scheduleMngDto) {
		return scheduleMngDao.getSchedule(scheduleMngDto);
	}
}
