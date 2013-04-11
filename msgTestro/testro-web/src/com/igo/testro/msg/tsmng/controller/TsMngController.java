package com.igo.testro.msg.tsmng.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.cmn.login.LoginCheck;
import com.igo.testro.cmn.login.dto.LoginDto;
import com.igo.testro.cmn.utils.DateUtil;
import com.igo.testro.msg.tsmng.biz.TsExecuteBiz;
import com.igo.testro.msg.tsmng.biz.TsMngBiz;
import com.igo.testro.msg.tsmng.dto.IODataUseDTO;
import com.igo.testro.msg.tsmng.dto.RptSnrioBasicDTO;
import com.igo.testro.msg.tsmng.dto.RptSnrioDetailDTO;
import com.igo.testro.msg.tsmng.dto.TestSnrioBasicDTO;
import com.igo.testro.msg.tsmng.dto.TestSnrioDetailDTO;
import com.igo.testro.preference.TestroPreference;

/**
 * <p>
 * 프로그램명:TsMngController.java<br/>
 * 설명 : 테스트시나리오관리 Controller<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 10. : 김기태 : 최초작성
 * </ul> 
 * </p>
 */
@Controller
public class TsMngController {
	
	@Autowired
	private TsMngBiz tsMngBiz;
	@Autowired
	private TsExecuteBiz tsExecuteBiz;
	
	/**
	 * <p>
	 * 테스트 시나리오 관리 페이지 열기
	 * <p>
	 */
	@LogInfo(description="테스트 시나리오 관리 페이지 열기")
	@RequestMapping("msg.tsmng.tsmng.do")
	public ModelMap viewTsMng(
			HttpSession session,
			HttpServletRequest request){
		String tssnroId = (String)request.getParameter("tssnroId");
		
		LoginDto loginDto = (LoginDto) session.getAttribute(LoginCheck.USERINFO);
		
		String tsDataMaxCnt = TestroPreference.getInstance().getProperty("TS_DATA_MAX_CNT", TestroPreference.USER);	//테스트시나리오 테스트데이터 최대등록건수
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("tsDataMaxCnt",tsDataMaxCnt);
		modelMap.addAttribute("teststartyms", DateUtil.convertShortQuicsFormat(loginDto.getTeststartyms()));
		modelMap.addAttribute("testendyms", DateUtil.convertShortQuicsFormat(loginDto.getTestendyms()));
		if(tssnroId != null && !"".equals(tssnroId)){
			modelMap.addAttribute("tssnroId", tssnroId);
		}
		
		return modelMap;
	}
	
	/**
	 * <p>
	 * 테스트 시나리오 정보 가져오기
	 * <p>
	 * @param tsSnrioID - 테스트 시나리오 ID
	 * @return ModelAndView
	 */
	@LogInfo(description="테스트 시나리오 정보 가져오기")
	@RequestMapping("msg.tsmng.getTsInfo.do")
	public ModelAndView getTsInfo(
			@RequestParam("tsSnrioID")String tsSnrioID){
		TestSnrioBasicDTO testSnrioBasicDTO = tsMngBiz.getTsInfo(tsSnrioID);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("testSnrioBasicDTO", testSnrioBasicDTO);
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * <p>
	 * 저장 팝업 열기
	 * <p>
	 * @param session - 세션
	 * @param tsSnrioID - 테스트 시나리오 아이디
	 * @return ModelMap
	 */
	@LogInfo(description="저장 팝업 열기")
	@RequestMapping("msg.tsmng.tsSave.do")
	public ModelMap openSave(
			HttpSession session
			, @RequestParam("tsSnrioID") String tsSnrioID){
		TestSnrioBasicDTO testSnrioBasicDTO = new TestSnrioBasicDTO();
		if(tsSnrioID != null && !"".equals(tsSnrioID)){
			testSnrioBasicDTO = tsMngBiz.getTsBasicInfo(tsSnrioID);
		}
		
		LoginDto loginDto = (LoginDto) session.getAttribute(LoginCheck.USERINFO);
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("testSnrioBasicDTO", testSnrioBasicDTO);
		modelMap.addAttribute("teststartyms", DateUtil.convertShortQuicsFormat(loginDto.getTeststartyms()));
		modelMap.addAttribute("testendyms", DateUtil.convertShortQuicsFormat(loginDto.getTestendyms()));
		return modelMap;
	}
	
	/**
	 * <p>
	 * 테스트 시나리오저장
	 * <p>
	 * @param session - 세션
	 * @param tsSnrioID - 테스트시나리오아이디
	 * @param tsSnrioName - 테스트시나리오명
	 * @param tsSnrioDesc - 테스트시나리오설명
	 * @param strTestSnrioDetailDTOList - 테스트시나리오상세 정보
	 * @param strIODataUseDTOList - 입출력값활용값 정보
	 * @return ModelAndView
	 */
	@LogInfo(description="테스트 시나리오저장")
	@RequestMapping("msg.tsmng.registerTsInfo.do")
	public ModelAndView registerTsInfo(
			HttpSession session
			, @RequestParam("tsSnrioID") String tsSnrioID
			, @RequestParam("tsSnrioName") String tsSnrioName
			, @RequestParam("tsSnrioDesc") String tsSnrioDesc
			, @RequestParam("testSnrioDetailDTOList") String strTestSnrioDetailDTOList
			, @RequestParam("iODataUseDTOList") String strIODataUseDTOList
			, @RequestParam("testDataDTOList") String strTestDataDTOList){
		
		// 새로 저장인지??
		boolean isNew = tsSnrioID == null || "".equals(tsSnrioID);
		
		LoginDto loginDto = (LoginDto) session.getAttribute(LoginCheck.USERINFO);
		
		JSONArray jsonArrayTsDetailDTOList = JSONArray.fromObject(strTestSnrioDetailDTOList);
		JSONArray jsonArrayIODataUseDTOList = JSONArray.fromObject(strIODataUseDTOList);
		JSONArray jsonArrayTestDataDTOList = JSONArray.fromObject(strTestDataDTOList);
		
		TestSnrioBasicDTO testSnrioBasicDTO = tsMngBiz.registerTsInfo(
				tsSnrioID
				, tsSnrioName
				, tsSnrioDesc
				, jsonArrayTsDetailDTOList
				, jsonArrayIODataUseDTOList
				, jsonArrayTestDataDTOList
				, isNew
				, loginDto);
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("testSnrioBasicDTO", testSnrioBasicDTO);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	/**
	 * <p>
	 * 테스트 시나리오 실행
	 * <p>
	 * @param session - 세션
	 * @param strRowData - 테스트 시나리오 상세 정보
	 * @param tsSnrioID - 테스트시나리오 아이디
	 * @param isLast - 마지막 실행인지 여부
	 * @param strIOData - 입출력값 정보
	 * @return
	 */
	@LogInfo(description="테스트 시나리오 실행")
	@RequestMapping("msg.tsmng.executeTsAct.do")
	public ModelAndView executeTsAct(
			HttpSession session
			, @RequestParam("rowData") String strRowData
			, @RequestParam("tsSnrioID") String tsSnrioID
			, @RequestParam("isLast") boolean isLast
			, @RequestParam("iOData") String strIOData){
		LoginDto loginDto = (LoginDto) session.getAttribute(LoginCheck.USERINFO);
		TestSnrioDetailDTO rowData = (TestSnrioDetailDTO) JSONObject.toBean(JSONObject.fromObject(strRowData), TestSnrioDetailDTO.class);
		
		//테스트 시나리오 아이디가 있으면 첫 테스트 데이터 실행이다.
		if(tsSnrioID != null && !"".equals(tsSnrioID.trim())){
			RptSnrioBasicDTO rptSnrioBasicDTO = tsExecuteBiz.registerRptSnrio(tsSnrioID, loginDto);
			session.setAttribute("rptSnrioBasicDTO", rptSnrioBasicDTO);
		}
		
		//세션에서 테스트 시나리오 실적을 가져온다.
		RptSnrioBasicDTO rptSnrioBasicDTO = (RptSnrioBasicDTO)session.getAttribute("rptSnrioBasicDTO");
		
		//입출력값 활용 JSON-->DTO
		List<IODataUseDTO> ioDataUseDTOs = new ArrayList<IODataUseDTO>();
		JSONArray jsonIOData = JSONArray.fromObject(strIOData);
		for(Object o : jsonIOData){
			IODataUseDTO ioDataUseDTO = (IODataUseDTO) JSONObject.toBean(JSONObject.fromObject(o), IODataUseDTO.class);
			ioDataUseDTOs.add(ioDataUseDTO);
		}
		
		//테스트 시나리오 상세를 실행
		RptSnrioDetailDTO rptSnrioDetailDTO = tsExecuteBiz.executeTestData(rowData, loginDto, rptSnrioBasicDTO, ioDataUseDTOs);
		rptSnrioDetailDTO.setTsSnrioID(rptSnrioBasicDTO.getTsSnrioID());
		rptSnrioDetailDTO.setAcmplNth(rptSnrioBasicDTO.getAcmplNth());
		rptSnrioBasicDTO.getRptSnrioDetailDTOs().add(rptSnrioDetailDTO);
		
		
		ModelAndView mav = new ModelAndView();
		
		String result = "success";
		
		String resultTssnrioid = "";
		long resultAcmplnth = 0;
		
		//테스트 시나리오 상세 실적의 성공여부가 실패이면 시나리오 기본 실적에도 실패로 셋팅
		if("N".equals(rptSnrioDetailDTO.getRsultSucssYN())){
			rptSnrioBasicDTO.setRsultSucssYN("N");
			//tsExecuteBiz.modifyRptSnrio(rptSnrioBasicDTO);
			//session.removeAttribute("rptSnrioBasicDTO");
			//result = "fail";
		}
		
		//마지막 실행일 경우
		if(isLast){
			//성공실패여부가 없으면 성공으로 셋팅
			if(rptSnrioBasicDTO.getRsultSucssYN() == null || "".equals(rptSnrioBasicDTO.getRsultSucssYN())){
				rptSnrioBasicDTO.setRsultSucssYN("Y");
			}
			//성공실패여부 수정
			tsExecuteBiz.modifyRptSnrio(rptSnrioBasicDTO);
			resultTssnrioid = rptSnrioBasicDTO.getTsSnrioID();
			resultAcmplnth = rptSnrioBasicDTO.getAcmplNth();
			//세션에서 시나리오 실적 삭제
			session.removeAttribute("rptSnrioBasicDTO");
			mav.addObject("rptSnrioBasicDTO", rptSnrioBasicDTO);
		}
		
		mav.addObject("result", result);
		mav.addObject("resultTssnrioid", resultTssnrioid);
		mav.addObject("resultAcmplnth", resultAcmplnth);
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * <p>
	 * 테스트 데이터 불러오기
	 * <p>
	 * @param strTsdataIds - 테스트데이터 아이디 정보 
	 * @return ModelAndView
	 */
	@SuppressWarnings("unchecked")
	@LogInfo(description="테스트 데이터 불러오기")
	@RequestMapping("msg.tsmng.getListTdInfo.do")
	public ModelAndView getListTdInfo(
			@RequestParam("jsonTsdataIds") String strTsdataIds){
		List<String> arrTsdataIds = (ArrayList<String>) JSONArray.toCollection(JSONArray.fromObject(strTsdataIds), String.class);
		
		TestSnrioBasicDTO appendTestSnrioBasicDTO = tsMngBiz.getListAppendTdInfo(arrTsdataIds);
			
		ModelAndView mav = new ModelAndView();
		mav.addObject("testSnrioBasicDTO", appendTestSnrioBasicDTO);
		mav.setViewName("jsonView");
		return mav;
	}
}
