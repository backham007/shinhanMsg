package com.igo.testro.msg.tsmng.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONSerializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.cmn.login.LoginCheck;
import com.igo.testro.cmn.login.dto.LoginDto;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.pretst.dto.TestDataDto;
import com.igo.testro.msg.tsmng.biz.TdDetailBiz;
import com.igo.testro.msg.tsmng.biz.TsMngBiz;

/**
 * <p>
 * 프로그램명:TdDetailController.java<br/>
 * 설명 : 테스트 데이터 수정 Controller<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 7. : 김기태 : 최초작성
 * </ul> 
 * </p>
 */
@Controller
public class TdDetailController {
	final ITestroLogger logger = TestroLogHelper.getBiz();

	@Autowired
	private TsMngBiz tsMngBiz;
	@Autowired
	private TdDetailBiz tdDetailBiz;
	
	/**
	 * <p>
	 * 테스트 데이터 상세 팝업을 연다.
	 * <p>
	 * @param selInd - 선택된 그리드의 index
	 * @return ModelMap
	 */
	@LogInfo(description="테스트 데이터 상세 팝업을 연다.")
	@RequestMapping("msg.tsmng.tdDetail.do")
	public ModelMap openTdDetail(
			@RequestParam("selInd")String selInd){
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("selInd", selInd);
		return modelMap;
	}
	
	/**
	 * <p>
	 * 테스트 데이터를 가져온다.
	 * <p>
	 * @param tsdataID - 테스트데이터 ID
	 * @return ModelAndView
	 */
	@LogInfo(description="테스트 데이터를 가져온다.")
	@RequestMapping("msg.tsmng.getTdInfo.do")
	public ModelAndView getTdInfo(
			@RequestParam("tsdataID")String tsdataID){
		ModelAndView mav = new ModelAndView();
		
		TestDataDto testDataDto =  tsMngBiz.getTdInfo(tsdataID);
		
		//반복부가 있으면 map에 추가한다.
		Map<String, List<Map<String, String>>> rptMap = tdDetailBiz.getRptMap(testDataDto);
		
		mav.addObject("testDataDto", testDataDto);
		mav.addObject("chkYNVal", JSONSerializer.toJSON(testDataDto.getCheckPointList()).toString());
		mav.addObject("rptMap", JSONSerializer.toJSON(rptMap).toString());
		mav.setViewName("msg/tsmng/tdDetail");
		
		return mav;
	}
	

	/**
	 * <p>
	 * 부모창에서 테스트 데이터를 가져온다.
	 * <p>
	 * @param strTestData - 테스트데이터 JSON정보
	 * @return ModelAndView
	 */
	@LogInfo(description="테스트 데이터를 가져온다.")
	@RequestMapping("msg.tsmng.getJsonTdInfo.do")
	public ModelAndView getJsonTdInfo(
			@RequestParam("selTd")String strTestData){
		ModelAndView mav = new ModelAndView();
		
		TestDataDto testDataDto = tdDetailBiz.getJsonTdInfo(strTestData);
		
		//반복부가 있으면 map에 추가한다.
		Map<String, List<Map<String, String>>> rptMap = tdDetailBiz.getRptMap(testDataDto);
			
		mav.addObject("testDataDto", testDataDto);
		mav.addObject("chkYNVal", JSONSerializer.toJSON(testDataDto.getCheckPointList()).toString());
		mav.addObject("rptMap", JSONSerializer.toJSON(rptMap).toString());
		mav.setViewName("msg/tsmng/tdDetail");
		
		return mav;
	}
	
	/**
	 * <p>
	 * 테스트데이터 수정
	 * <p>
	 * @param session - 세션
	 * @param testDataDto - 테스트데이터 정보
	 * @param tsdataNO - 테스트데이터일련번호
	 * @param tsdataFldName - 테스트데이터필드명
	 * @param tsdataFldData - 테스트데이터필드데이터
	 * @param tscsFldDiv - 테스트데이터필드구분
	 * @param tscsFldType - 테스트데이터필드타입
	 * @param tscsFldAttrib - 테스트데이터필드속성
	 * @param tscsFldSizeCnt - 테스트데이터필드크기내용
	 * @param tscsFldDesc - 테스트데이터필드설명
	 * @param tscsUsrFldDesc - 테스트데이터사용자필드설명
	 * @param rmark - 비고
	 * @param chkYNVal - 체크포인트정보
	 * @param strRptMap - 반복부 정보
	 * @return ModelAndView
	 */
	@LogInfo(description="테스트데이터 수정")
	@RequestMapping("msg.tsmng.modifyTdDetail.do")
	public ModelAndView modifyTdDetail(
			HttpSession session
			, TestDataDto testDataDto
			, @RequestParam("tsdataNO")String[] tsdataNO
			, @RequestParam("tsdataFldName")String[] tsdataFldName
			, @RequestParam("tsdataFldData")String[] tsdataFldData
			, @RequestParam("tscsFldDiv")String[] tscsFldDiv
			, @RequestParam("tscsFldType")String[] tscsFldType
			, @RequestParam("tscsFldAttrib")String[] tscsFldAttrib
			, @RequestParam("tscsFldSizeCnt")String[] tscsFldSizeCnt
			, @RequestParam("tscsFldDesc")String[] tscsFldDesc
			, @RequestParam("tscsUsrFldDesc")String[] tscsUsrFldDesc
			, @RequestParam("rmark")String[] rmark
			, @RequestParam("chkYNVal")String chkYNVal
			, @RequestParam("rptMap")String strRptMap){
		
		LoginDto loginDto = (LoginDto) session.getAttribute(LoginCheck.USERINFO);
		
		tdDetailBiz.modifyTdDetail(
				testDataDto
				, tsdataNO
				, tsdataFldName
				, tsdataFldData
				, tscsFldDiv
				, tscsFldType
				, tscsFldAttrib
				, tscsFldSizeCnt
				, tscsFldDesc
				, tscsUsrFldDesc
				, rmark
				, chkYNVal
				, strRptMap
				, loginDto);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("testDataDto", testDataDto);
		mav.setViewName("jsonView");
		return mav;
	}

	
}
