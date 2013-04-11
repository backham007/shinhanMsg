package com.igo.testro.msg.tsmng.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.msg.tsmng.biz.TsListBiz;

/**
 * <p>
 * 프로그램명:TsListController.java<br/>
 * 설명 : 테스트시나리오 불러오기 Controller<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 17. : 김기태 : 최초작성
 * </ul> 
 * </p>
 */
@Controller
public class TsListController {
	
	@Autowired
	private TsListBiz tsListBiz;
	
	/**
	 * <p>
	 * 테스트시나리오 불러오기 팝업창을 연다
	 * <p>
	 */
	@LogInfo(description="테스트시나리오 불러오기 팝업창을 연다")
	@RequestMapping("msg.tsmng.tsList.do")
	public void openTsList(){
	}
	
	
	/**
	 * <p>
	 * Grid를 위한 테스트 시나리오 기본 List 불러오기
	 * <p>
	 * @param searchType 검색조건
	 * @param searchText 검색내용
	 * @param writeName 작성자
	 * @param startDate 검색시작일
	 * @param endDate 검색종료일
	 * @return Grid 리턴 데이터
	 */
	@LogInfo(description="Grid를 위한 테스트 시나리오 기본 List 불러오기")
	@RequestMapping("msg.tsmng.getListTsInfo.do")
	public ModelAndView getListTsInfo(
			@RequestParam("searchType")String searchType
			, @RequestParam("searchText")String searchText
			, @RequestParam("writeName")String writeName
			, @RequestParam("startDate")String startDate
			, @RequestParam("endDate")String endDate
			, @RequestParam("page")int page
			, @RequestParam("rows")int rows
			, @RequestParam("sidx")String sidx
			, @RequestParam("sord")String sord){
		
		//특수문자 제거
		//searchText = tsListBiz.sqlInjectionReplacer(searchText);
		//writeName = tsListBiz.sqlInjectionReplacer(writeName);
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("writeName", writeName);
		
		
		//날짜에서'-' 없애기
		if(startDate != null && !"".equals(startDate)){
			params.put("startDate", startDate.replace("-", ""));
		}			
		if(endDate != null && !"".equals(endDate)){
			params.put("endDate", endDate.replace("-", ""));
		}
		
		//화면단의 조회구분 셋팅
		if(searchType != null && "02".equals(searchType)){
			params.put("tsSnrioID", searchText);
		}else if(searchType != null && "01".equals(searchType)){
			params.put("tsSnrioName", searchText);
		}
		
		//페이지 관련 조건
		params.put("page", page);
		params.put("rows", rows);
		params.put("sidx", sidx);
		params.put("sord", sord);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addAllObjects(tsListBiz.getListTsInfo(params));
		mav.setViewName("jsonView");
		return mav;
	}
	
	
	/**
	 * <p>
	 * Grid를 위한 테스트 시나리오 상세 List 불러오기
	 * <p>
	 * @param tsSnrioID 조회할 테스트 시나리오 Id
	 * @return Grid 리턴 데이터 
	 */
	@LogInfo(description="Grid를 위한 테스트 시나리오 상세 List 불러오기")
	@RequestMapping("msg.tsmng.getListTsDetailInfo.do")
	public ModelAndView getListTsDetailInfo(
			@RequestParam("tsSnrioID")String tsSnrioID
			, @RequestParam("page")int page
			, @RequestParam("rows")int rows
			, @RequestParam("sidx")String sidx
			, @RequestParam("sord")String sord){
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("tsSnrioID", tsSnrioID);
		params.put("page", page);
		params.put("rows", rows);
		params.put("sidx", sidx);
		params.put("sord", sord);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addAllObjects(tsListBiz.getListTsDetailInfo(params));
		mav.setViewName("jsonView");
		return mav;
	}
}
