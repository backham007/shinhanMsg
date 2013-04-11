package com.igo.testro.msg.schedule.dao;

import java.util.List;
import com.igo.testro.cmn.dto.GridBaseDto;
import com.igo.testro.das.SqlMapper;
import com.igo.testro.msg.schedule.dto.ScheduleMngDto;

/**
 * 
 * <p>
 * 프로그램명 : ScheduleMngDao.java<br/>
 * 설명 : 테스트예약 등록실행 관리 DAO<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 24. : kangwoo : 최초작성
 *	  <li>2012. 3. 19. : kangwoo : 주석보완
 * </ul> 
 * </p>
 */
public class ScheduleMngDao {
	
	/**
	 * 
	 * <p>
	 * 테스트 예약 실행목록  조회
	 * <p>
	 * @param jobResrvYms 예약실행시간
	 * @return 테스트 예약 실행목록
	 */
	@SuppressWarnings("unchecked")
	public List<ScheduleMngDto> getListRegist(String jobResrvYms) {
		return (List<ScheduleMngDto>)SqlMapper.
			getSqlClient("TESTRO_DB").queryForList("scheduleMng.getListRegist", jobResrvYms);
		
	}
	
	/**
	 * 
	 * <p>
	 * 테스트 예약 실행결과  수정
	 * <p>
	 * @param scheduleMngDto 테스트예약실행관리DTO
	 */
	public void modifyScheduleResult(ScheduleMngDto scheduleMngDto) {
		SqlMapper.getSqlClient("TESTRO_DB").update("scheduleMng.modifyScheduleResult", scheduleMngDto);
	}
	
	/**
	 * 
	 * <p>
	 * 테스트 예약 실행목록  조회
	 * <p>
	 * @param scheduleMngDto 테스트예약실행관리DTO
	 * @return 테스트 예약 실행목록
	 */
	@SuppressWarnings("unchecked")
	public List<ScheduleMngDto> getListSchedule(ScheduleMngDto scheduleMngDto) {
		List<ScheduleMngDto> result = (List<ScheduleMngDto>)SqlMapper.
			getSqlClient("TESTRO_DB").queryForList("scheduleMng.getListSchedule", scheduleMngDto, scheduleMngDto.getStartnum(), scheduleMngDto.getEndnum());
		return result;
	}
	
	/**
	 * 
	 * <p>
	 * 테스트/시나리오 목록 조회
	 * <p>
	 * @param scheduleMngDto 테스트예약실행관리DTO
	 * @return 테스트/시나리오 목록
	 */
	@SuppressWarnings("unchecked")
	public List<ScheduleMngDto> getListTestCase(ScheduleMngDto scheduleMngDto) {
		List<ScheduleMngDto> result = (List<ScheduleMngDto>)SqlMapper.
		getSqlClient("TESTRO_DB").queryForList("scheduleMng.getListTestCase", scheduleMngDto, scheduleMngDto.getStartnum(), scheduleMngDto.getEndnum());
		return result;
	}
	
	/**
	 * 
	 * <p>
	 * 테스트 예약 실행항목 등록
	 * <p>
	 * @param scheduleMngDto 테스트예약실행관리DTO
	 */
	public synchronized void registerSchedule(ScheduleMngDto scheduleMngDto) {
		SqlMapper.getSqlClient("TESTRO_DB").insert("scheduleMng.registerSchedule", scheduleMngDto);
	}
	
	/**
	 * 
	 * <p>
	 * 테스트 예약 실행항목 수정
	 * <p>
	 * @param scheduleMngDto 테스트예약실행관리DTO
	 */
	public void modifySchedule(ScheduleMngDto scheduleMngDto) {
		SqlMapper.getSqlClient("TESTRO_DB").insert("scheduleMng.modifySchedule", scheduleMngDto);
		
	}
	
	/**
	 * 
	 * <p>
	 * 테스트 예약 실행항목 삭제
	 * <p>
	 * @param scheduleMngDto 테스트예약실행관리DTO
	 */
	public void deleteSchedule(ScheduleMngDto scheduleMngDto) {
		SqlMapper.getSqlClient("TESTRO_DB").insert("scheduleMng.deleteSchedule", scheduleMngDto);
		
	}
	
	/**
	 * 
	 * <p>
	 * 테스트 예약 실행목록 총건수 조회
	 * <p>
	 * @param scheduleMngDto 테스트예약실행관리DTO
	 * @return 테스트 예약 실행목록 총건수
	 */
	public int getListScheduleTotal(ScheduleMngDto scheduleMngDto) {
		return (Integer) SqlMapper.getSqlClient("TESTRO_DB").queryForObject("scheduleMng.getListSchedule_total", scheduleMngDto);
	}
	
	/**
	 * 
	 * <p>
	 * 테스트 예약 실행항목 조회
	 * <p>
	 * @param scheduleMngDto 테스트예약실행관리DTO
	 * @return 테스트 예약 실행항목
	 */
	public ScheduleMngDto getSchedule(ScheduleMngDto scheduleMngDto) {
		return (ScheduleMngDto) SqlMapper.getSqlClient("TESTRO_DB").queryForObject("scheduleMng.getSchedule", scheduleMngDto);
	}
	
	/**
	 * 
	 * <p>
	 * 테스트/시나리오 목록 총건수 조회
	 * <p>
	 * @param scheduleMngDto 테스트예약실행관리DTO
	 * @return 테스트/시나리오 목록 총건수
	 */
	public int getListTestCaseTotal(GridBaseDto scheduleMngDto) {
		return (Integer) SqlMapper.getSqlClient("TESTRO_DB").queryForObject("scheduleMng.getListTestCase_total", scheduleMngDto);
	}

}
