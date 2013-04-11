package com.igo.testro.msg.report.dao;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.igo.testro.das.SqlMapper;
import com.igo.testro.msg.report.dto.EmpGridParamDto;
import com.igo.testro.msg.report.dto.EmpInfoDto;
import com.igo.testro.msg.report.dto.ReportGridParamDto;
import com.igo.testro.msg.report.dto.RptTestCaseDto;
import com.igo.testro.msg.report.dto.RptTestSenarioDto;

/**
 * <p>
 * 프로그램명:ResultReportDao.java<br/>
 * 설명 : 결과보고서 조회<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 28. : 안도현 : 최초작성
 * </ul> 
 * </p>
 */
public class ResultReportDao {
	
	
	/**
	 * <p>
	 * 시나리오 리스트 count
	 * <p>
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int getListTestSenarioCount(ReportGridParamDto dto){
		List<RptTestSenarioDto> dtoList = (List<RptTestSenarioDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("report.getListTestSenarioCount",dto);
		return dtoList.size();
	}
	
	/**
	 * <p>
	 * 시나리오 리스트
	 * <p>
	 * @param param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public List<RptTestSenarioDto> getListTestSenario(ReportGridParamDto dto){
		return (List<RptTestSenarioDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("report.getListTestSenario",dto, dto.getStartnum() ,dto.getEndnum());
	}

	/**
	 * <p>
	 * 케이스 리스트 count
	 * <p>
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int getListTestCaseCount(ReportGridParamDto dto){
		List<RptTestCaseDto> dtoList = (List<RptTestCaseDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("report.getListTestCaseCount",dto);
		return dtoList.size();
	}
	
	/**
	 * <p>
	 * 케이스 리스트
	 * <p>
	 * @param param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public List<RptTestCaseDto> getListTestCase(ReportGridParamDto dto){
		return (List<RptTestCaseDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("report.getListTestCase",dto, dto.getStartnum() ,dto.getEndnum());
	}

	/**
	 * <p>
	 * 직원정보리스트 count
	 * <p>
	 * @param dto
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int getPjtEmpLstCnt(EmpGridParamDto dto){
		return (Integer) SqlMapper.getSqlClient("TESTRO_DB").queryForObject("report.getPjtEmpLstCnt",dto);
	}
	
	/**
	 * <p>
	 * 직원정보 리스트
	 * <p>
	 * @param dto
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public List<EmpInfoDto> getPjtEmpLst(EmpGridParamDto dto){
		return (List<EmpInfoDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("report.getPjtEmpLst",dto, dto.getStartnum() ,dto.getEndnum());
	}
	
	
}
