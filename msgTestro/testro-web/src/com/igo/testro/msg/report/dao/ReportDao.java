package com.igo.testro.msg.report.dao;

import java.util.ArrayList;
import java.util.Map;

import com.igo.testro.das.SqlMapper;
import com.igo.testro.msg.report.dto.RptCaseInfoDto;
import com.igo.testro.msg.report.dto.RptCheckpointDto;
import com.igo.testro.msg.report.dto.RptInOutDataDto;
import com.igo.testro.msg.report.dto.RptSnrioInfoDto;
import com.igo.testro.msg.report.dto.RptTsResultDto;

/**
 * <p>
 * 프로그램명:ReportDetailDao.java<br/>
 * 설명 : 결과보고서 dao<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 25. : 안도현 : 최초작성
 * </ul> 
 * </p>
 */
public class ReportDao {
	
	/**
	 * <p>
	 * 테스트케이스 기본실적 조회
	 * <p>
	 * @param param
	 * @return
	 */
	
	@SuppressWarnings("unchecked")
	public RptCaseInfoDto getTsCaseBasic( Map param){
		return (RptCaseInfoDto)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("report.getTsCaseBasic",param);
	}
	
	/**
	 * <p>
	 * 테스트케이스 상세실적 조회
	 * <p>
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<RptCaseInfoDto> getListTsCaseData( Map param){
		return (ArrayList<RptCaseInfoDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("report.getListTsCaseData",param);
	}

	/**
	 * <p>
	 * 테스트시나리오 기본실적 조회
	 * <p>
	 * @param param
	 * @return
	 */
	
	@SuppressWarnings("unchecked")
	public RptSnrioInfoDto getTsSnrioBasic( Map param){
		return (RptSnrioInfoDto)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("report.getTsSnrioBasic",param);
	}
	
	/**
	 * <p>
	 * 테스트시나리오 상세실적 조회
	 * <p>
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<RptSnrioInfoDto> getListTsSnrioData( Map param){
		return (ArrayList<RptSnrioInfoDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("report.getListTsSnrioData",param);
	}
	
	/**
	 * <p>
	 * 테스트케이스 테스트결과
	 * <p>
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public RptTsResultDto getTestCaseResult( Map param){
		return (RptTsResultDto)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("report.getTestCaseResult",param);
	}
	
	/**
	 * <p>
	 * 테스트시나리오 테스트결과
	 * <p>
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public RptTsResultDto getTestSnrioResult( Map param){
		return (RptTsResultDto)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("report.getTestSnrioResult",param);
	}
	
	/**
	 * <p>
	 * 테스트 입출력 데이터 기본
	 * <p>
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public RptInOutDataDto getInOutDataBasic( Map param){
		return (RptInOutDataDto)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("report.getInOutDataBasic",param);
	}
	
	/**
	 * <p>
	 * 테스트 입출력 데이터 상세 리스트
	 * <p>
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<RptInOutDataDto> getListInOutDataDetail( Map param){
		return (ArrayList<RptInOutDataDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("report.getListInOutDataDetail",param);
	}
	
	/**
	 * <p>
	 * 체크포인트 상세 리스트
	 * <p>
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<RptCheckpointDto> getListCheckPoint( Map param){
		return (ArrayList<RptCheckpointDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("report.getListCheckPoint",param);
	}	
}
