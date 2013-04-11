package com.igo.testro.msg.report.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.exception.BizException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.report.biz.ResultReportBiz;
import com.igo.testro.msg.report.dto.EmpGridParamDto;
import com.igo.testro.msg.report.dto.ReportGridParamDto;
import com.igo.testro.preference.TestroPreference;


/**
 * <p>
 * 프로그램명:ResultReportController.java<br/>
 * 설명 : 결과보고서 리스트 <br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 28. : d : 내용
 * </ul> 
 * </p>
 */
@Controller
public class ResultReportController {
	
	ITestroLogger logger = TestroLogHelper.getBiz();
	
	@Autowired
	private ResultReportBiz resultReportBiz;
	
	/**
	 * <p>
	 * 결과보고서 view
	 * <p>
	 * @return
	 */
	@RequestMapping("msg.report.resultReport.do")
	public ModelAndView getlistV(){
		ModelAndView mav = new ModelAndView();
		ModelMap modelMap = new ModelMap();
		String[] mciPropArray = TestroPreference.getInstance().getProperty("CONN_SEVER_LIST", TestroPreference.USER).split(",");
		List mciArray = new ArrayList();
		for(int i =0; i < mciPropArray.length; i++){
			Map mciPropMap = new HashMap();
			String[] splitname = mciPropArray[i].split(":");
			mciPropMap.put("key", splitname[0]);
			mciPropMap.put("val", splitname[1]);
			mciArray.add(mciPropMap);
		}
		modelMap.addAttribute("mciPropArray", mciPropArray);
		mav.addObject("mciArray", mciArray);
		return mav;
	}
	
	/**
	 * <p>
	 * 시나리오 리스트 조회
	 * <p>
	 * @param dto
	 * @return
	 */
	@RequestMapping("msg.report.resultReportSearch.do")
	public ModelAndView getListTestSenario(ReportGridParamDto dto){
		ModelAndView mav = new ModelAndView();
		Map<String, Object> reportList = null;
		
		try {
			if ("01".equals(dto.getTesdiv())) { //테스트케이스
				reportList = resultReportBiz.getListTestCase(dto);
			} else if ("02".equals(dto.getTesdiv())) { //테스트 시나리오
				reportList = resultReportBiz.getListTestSenario(dto);
			}
		} catch (DataAccessException e) {
			logger.error("", e);
			throw new BizException("MSG_REPORT0001","", e);
		}
		mav.addAllObjects(reportList);
		mav.setViewName("jsonView");
		return mav;
	}

	/**
	 * <p>
	 * 직원정보조회 View
	 * <p>
	 * @param dto
	 */
	@RequestMapping("msg.report.empSrchpop.do")
	public void getPjtEmp(EmpGridParamDto dto){
	}
	
	/**
	 * <p>
	 * 직원정보조회(조회)
	 * <p>
	 * @param dto
	 * @return
	 */
	@RequestMapping("msg.report.getPjtEmpLst.do")
	public ModelAndView getPjtEmpLst(EmpGridParamDto dto){
		ModelAndView mav = new ModelAndView();
		try {
			mav.addAllObjects(resultReportBiz.getPjtEmpLst(dto));
		} catch (DataAccessException e) {
			logger.error("", e);
			throw new BizException("MSG_EMPSHR0001","", e);
		}
		mav.setViewName("jsonView");
		return mav;
	}
	
}
