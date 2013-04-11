package com.igo.testro.msg.report.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.report.dao.ResultReportDao;
import com.igo.testro.msg.report.dto.EmpGridParamDto;
import com.igo.testro.msg.report.dto.EmpInfoDto;
import com.igo.testro.msg.report.dto.ReportGridParamDto;
import com.igo.testro.msg.report.dto.RptTestCaseDto;
import com.igo.testro.msg.report.dto.RptTestSenarioDto;

/**
 * <p>
 * 프로그램명:ResultReportBiz.java<br/>
 * 설명 : 결함보고서 조회biz<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 28. : 안도현 : 최초작성
 * </ul> 
 * </p>
 */
public class ResultReportBiz {
	final ITestroLogger logger = TestroLogHelper.getBiz();
	
	@Autowired
	private ResultReportDao resultReportDao;
	
	/**
	 * <p>
	 * 시나리오 리스트
	 * <p>
	 * @param paramDto
	 * @return
	 */
	public Map<String, Object> getListTestSenario(ReportGridParamDto dto){
		Map<String, Object> outputMap = new HashMap<String, Object>();
		dto.setRecords(resultReportDao.getListTestSenarioCount(dto));
		List<RptTestSenarioDto> list = resultReportDao.getListTestSenario(dto);
		outputMap.put("rows", list);                          
		outputMap.put("records", dto.getRecords());
		outputMap.put("page", dto.getPage());
		outputMap.put("total", dto.getTotal());
		return outputMap;
	}
	
	/**
	 * <p>
	 * 케이스리스트
	 * <p>
	 * @param paramDto
	 * @return
	 */
	public Map<String, Object> getListTestCase(ReportGridParamDto dto){
		Map<String, Object> outputMap = new HashMap<String, Object>();
		dto.setRecords(resultReportDao.getListTestCaseCount(dto));
		List<RptTestCaseDto> list = resultReportDao.getListTestCase(dto);
		outputMap.put("rows", list);                          
		outputMap.put("records", dto.getRecords());
		outputMap.put("page", dto.getPage());
		outputMap.put("total", dto.getTotal());
		return outputMap;
	}

	/**
	 * <p>
	 * 직원정보 리스트
	 * <p>
	 * @param dto
	 * @return
	 */
	public Map<String, Object> getPjtEmpLst(EmpGridParamDto dto){
		Map<String, Object> outputMap = new HashMap<String, Object>();
		dto.setRecords(resultReportDao.getPjtEmpLstCnt(dto));
		List<EmpInfoDto> list = resultReportDao.getPjtEmpLst(dto);
		outputMap.put("rows", list);                          
		outputMap.put("records", dto.getRecords());
		outputMap.put("page", dto.getPage());
		outputMap.put("total", dto.getTotal());
		return outputMap;
	}
	
	
}
