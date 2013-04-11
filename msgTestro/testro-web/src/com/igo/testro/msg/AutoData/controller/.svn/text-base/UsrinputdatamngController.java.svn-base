package com.igo.testro.msg.AutoData.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.cmn.utils.StringUtil;
import com.igo.testro.msg.AutoData.biz.UsrinputdatamngBiz;
import com.igo.testro.msg.AutoData.dto.UsrinputdatamngDto;

/**
 * <p>
 * 프로그램명 : UsrinputdatamngController.java<br/>
 * 설명 : 사용자 입력 데이터 관리<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */
@Controller
public class UsrinputdatamngController {
	@Autowired
	private UsrinputdatamngBiz usrinputdatamngBiz;
	
	/**
	 * <p>
	 * 메소드 설명 : 사용자 입력 데이터 관리
	 * <p> 
	 * @param request
	 * @return modelMap
	 */
	@RequestMapping("msg.usrinputdatamng.usrinputdatamng.do")
	@LogInfo(description="사용자 입력 데이터 관리 팝업 호출")
	public ModelMap viewMemberList(HttpServletRequest request){
		String listCount = request.getParameter("listCount");
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("listCount", listCount);
		return modelMap;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 사용자 입력데이터 기본 조회
	 * <p> 
	 * @param request,response
	 * @return mav
	 */
	@RequestMapping("msg.searchList.usrinputdatamng.do")
	@LogInfo(description="사용자 입력 데이터 기본 조회")
	public ModelAndView searchList(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		mav.addAllObjects(usrinputdatamngBiz.searchList(request));
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 데이터 재조회
	 * <p> 
	 * @param request,response
	 * @return mav
	 */
	@RequestMapping("msg.researchList.usrinputdatamng.do")
	@LogInfo(description="데이터 재조회")
	public ModelAndView researchList(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		mav.addAllObjects(usrinputdatamngBiz.researchList(request));
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 데이터 저장(기존에 있을경우)
	 * <p> 
	 * @param request,response,usrinputdatamngDto,jgGridData
	 * @return mav
	 */
	@RequestMapping("msg.insertList.usrinputdatamng.do")
	@LogInfo(description="데이터 저장(기존에 있을경우)")
	public ModelAndView insertList(HttpServletRequest request,HttpServletResponse response,UsrinputdatamngDto usrinputdatamngDto,@RequestParam("jgGridData") String jgGridData){
		String sourc = StringUtil.nvl(request.getParameter("sourc"),"");
		List<UsrinputdatamngDto> myQaltyList = new ArrayList<UsrinputdatamngDto>();
		JSONArray jsonArray = JSONArray.fromObject(jgGridData);
		
		for (Object object : jsonArray) {
			JSONObject jsonObject = (JSONObject)object;
			UsrinputdatamngDto myQaltyDto = (UsrinputdatamngDto) JSONObject.toBean((JSONObject)object, UsrinputdatamngDto.class);				
			myQaltyList.add(myQaltyDto);
		}
		
		usrinputdatamngDto.setUsrinputdatamngList(myQaltyList);
		usrinputdatamngBiz.insertUsrinputdatamng(usrinputdatamngDto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 데이터 저장(신규일 있을경우)
	 * <p> 
	 * @param request,response
	 * @return mav
	 */
	@RequestMapping("msg.newinsertList.usrinputdatamng.do")
	@LogInfo(description="데이터 저장(신규일 있을경우)")
	public ModelAndView newinsertList(HttpServletRequest request,HttpServletResponse response,UsrinputdatamngDto usrinputdatamngDto,@RequestParam("jgGridData") String jgGridData){
		List<UsrinputdatamngDto> myQaltyList = new ArrayList<UsrinputdatamngDto>();
		JSONArray jsonArray = JSONArray.fromObject(jgGridData);
		for (Object object : jsonArray) {
			JSONObject jsonObject = (JSONObject)object;
			UsrinputdatamngDto myQaltyDto = (UsrinputdatamngDto) JSONObject.toBean((JSONObject)object, UsrinputdatamngDto.class);				
			myQaltyList.add(myQaltyDto);
			
		}

		usrinputdatamngDto.setUsrinputdatamngList(myQaltyList);
		usrinputdatamngBiz.newinsertUsrinputdatamng(usrinputdatamngDto);
		ModelAndView mav = new ModelAndView();
		mav.addObject("fidId" , usrinputdatamngDto.getFldId());
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 상세 데이터 저장
	 * <p> 
	 * @param request,response,usrinputdatamngDto,jgGridData
	 * @return mav
	 */
	@RequestMapping("msg.detailInsertList.usrinputdatamng.do")
	@LogInfo(description="상세 데이터 저장")
	public ModelAndView detailInsertList(HttpServletRequest request,HttpServletResponse response,UsrinputdatamngDto usrinputdatamngDto,@RequestParam("jgGridData") String jgGridData){
		List<UsrinputdatamngDto> myQaltyList = new ArrayList<UsrinputdatamngDto>();
		JSONArray jsonArray = JSONArray.fromObject(jgGridData);
		
		for (Object object : jsonArray) {
			JSONObject jsonObject = (JSONObject)object;
			
			UsrinputdatamngDto myQaltyDto = (UsrinputdatamngDto) JSONObject.toBean((JSONObject)object, UsrinputdatamngDto.class);				
			myQaltyList.add(myQaltyDto);
		}
		
		usrinputdatamngDto.setUsrinputdatamngList(myQaltyList);
		
		usrinputdatamngDto.setFldId(request.getParameter("fldNum"));
		usrinputdatamngBiz.detailInsertUsrinputdatamng(usrinputdatamngDto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 데이터 행 삭제
	 * <p> 
	 * @param request,response,usrinputdatamngDto
	 * @return mav
	 */
	@RequestMapping("msg.getdelete.usrinputdatamng.do")
	@LogInfo(description="데이터 행 삭제")
	public ModelAndView getDelete(HttpServletRequest request,HttpServletResponse response, UsrinputdatamngDto usrinputdatamngDto){	
		
		ModelAndView mav = new ModelAndView();
		usrinputdatamngDto.setFldId(request.getParameter("fldId"));
		
		mav.addObject(usrinputdatamngBiz.getDelete(usrinputdatamngDto));
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 상세 데이터 조회
	 * <p> 
	 * @param request,response
	 * @return mav
	 */
	@RequestMapping("msg.detailSearchList.usrinputdatamng.do")
	@LogInfo(description="상세 데이터 조회")
	public ModelAndView detailSearchList(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		mav.addAllObjects(usrinputdatamngBiz.detailSearchList(request));
		mav.setViewName("jsonView");
		return mav;
	}
}
