package com.igo.testro.msg.report.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.msg.report.biz.ReportBiz;

@Controller
public class ReportController {
	
	final Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private ReportBiz reportBiz;
	
	/**
	 * <p>
	 * 결과보고서 상세 초기 호출
	 * <p>
	 * @param request
	 * @param response
	 * @return
	 */
	@LogInfo(description="결과보고서 상세 초기 호출")
	@RequestMapping("msg.report.reportDetail.do")
	public ModelAndView reportDetail(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		Map param = new HashMap();
		String tscaseid  = "";//케이스id
		String tssnrioid = "";//시나리오id
		String gubun    = request.getParameter("gubun"); //01:케이스 02:시나리오
		String acmplnth = request.getParameter("acmplnth"); //회차
		String tsDataId = request.getParameter("tsdataid"); //테스트데이터Id
		String tsDataAcmplnth = request.getParameter("tsdataacmplnth"); //테스트데이터회차
		String tabGubun = request.getParameter("tabgubun"); //탭구분(0:테스트결과,1:입력데이터,2:출력데이터,3:체크포인트,4:결함관리,5:결함조치)
		String defNo = request.getParameter("defNo"); //결함순번
		
		if("01".equals(gubun)){	//케이스
			tscaseid = request.getParameter("tscaseid");
			param.put("tscaseid", tscaseid);
			param.put("acmplnth", acmplnth);
			
			mav.addObject("tsCaseID", tscaseid);
		}else if("02".equals(gubun)){	//시나리오
			tssnrioid = request.getParameter("tssnrioid");
			param.put("tssnrioid", tssnrioid);
			param.put("acmplnth", acmplnth);
			
			mav.addObject("tssnroId", tssnrioid);
		}
		
		param.put("gubun", gubun); //케이스 시나리오 구분
		Map outputMap = reportBiz.getRptTsRsultMain(param);
		if(tsDataId == null || "".equals(tsDataId) || tsDataAcmplnth == null || "".equals(tsDataAcmplnth)){
			tsDataId = (String)outputMap.get("firstTsDataId");
			tsDataAcmplnth = (String)outputMap.get("firstTsDataAcmplnth");
		}
		mav.addAllObjects(outputMap);
		mav.addObject("tsDataId", tsDataId);
		mav.addObject("tsDataAcmplnth", tsDataAcmplnth);
		mav.addObject("tabGubun", tabGubun);
		mav.addObject("defNo", defNo);
		mav.setViewName("msg.report.reportDetail");
		return mav;
	}
	
	/**
	 * <p>
	 * 테스트 결과
	 * <p>
	 * @param request
	 * @param response
	 * @return
	 */
	@LogInfo(description="테스트 결과")
	@RequestMapping("msg.report.getTestResult.do")
	public ModelAndView getTestResult(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		Map param = new HashMap();
		String tsdataid       = request.getParameter("tsDataId");       //테스트데이타id
		String tsdataacmplnth = request.getParameter("tsDataAcmplnth"); //데이타회차
		String gubun    = request.getParameter("gubun"); //01:케이스 02:시나리오
		param.put("tsdataid", tsdataid);
		param.put("tsdataacmplnth", tsdataacmplnth);
		param.put("gubun", gubun);
		mav.addAllObjects(reportBiz.getTestResult(param));
		mav.setViewName("msg.report.testResult");
		return mav;
	}
	
	/**
	 * <p>
	 * 입력데이터
	 * <p>
	 * @param request
	 * @param response
	 * @return
	 */
	@LogInfo(description="입력데이터")
	@RequestMapping("msg.report.getListInputData.do")
	public ModelAndView getListInputData(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Map param = new HashMap();
		String tsDataId       = request.getParameter("tsDataId");       //테스트데이타id
		String tsDataAcmplnth = request.getParameter("tsDataAcmplnth"); //데이타회차
		param.put("tsDataId", tsDataId);
		param.put("tsDataAcmplnth", tsDataAcmplnth);
		param.put("tableName", "RPTDATA02");
		mav.addAllObjects(reportBiz.getListInOutData(param));
		mav.setViewName("msg.report.inOutData");
		return mav;
	}
	
	/**
	 * <p>
	 * 출력데이터
	 * <p>
	 * @param request
	 * @param response
	 * @return
	 */
	@LogInfo(description="출력데이터")
	@RequestMapping("msg.report.getListOutputData.do")
	public ModelAndView getListOutputData(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Map param = new HashMap();
		String tsDataId       = request.getParameter("tsDataId");       //테스트데이타id
		String tsDataAcmplnth = request.getParameter("tsDataAcmplnth"); //데이타회차
		param.put("tsDataId", tsDataId);
		param.put("tsDataAcmplnth", tsDataAcmplnth);
		param.put("tableName", "RPTDATA03");
		mav.addAllObjects(reportBiz.getListInOutData(param));
		mav.setViewName("msg.report.inOutData");
		return mav;
	}
	
	/**
	 * <p>
	 * 체크포인트실적데이터
	 * <p>
	 * @param request
	 * @param response
	 * @return
	 */
	@LogInfo(description="체크포인트실적데이터")
	@RequestMapping("msg.report.getListCheckPoint.do")
	public ModelAndView getListCheckPoint(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Map param = new HashMap();
		String tsDataId       = request.getParameter("tsDataId");       //테스트데이타id
		String tsDataAcmplnth = request.getParameter("tsDataAcmplnth"); //데이타회차
		param.put("tsDataId", tsDataId);
		param.put("tsDataAcmplnth", tsDataAcmplnth);
		mav.addAllObjects(reportBiz.getListCheckPoint(param));
		mav.setViewName("msg.report.checkPoint");
		return mav;
	}
}
