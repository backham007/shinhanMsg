package com.igo.testro.msg.cmn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.cmn.utils.DateUtil;
import com.igo.testro.msg.cmn.biz.PopMngUserBiz;
import com.igo.testro.msg.cmn.dto.PopMngUserDto;

/**
 * <p>
 * 프로그램명:PopMngUserController.java<br/>
 * 설명 : 나의 프로젝트 관리<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */
@Controller
public class PopMngUserController {
	@Autowired
	private PopMngUserBiz popMngUserBiz;
	
	/**
	 * <p>
	 * 메소드 설명 : 사용자 관리 팝업 호출
	 * <p> 
	 * @param request,response,popMngUserdto
	 * @return mav
	 */
	@RequestMapping("msg.popMngUser.popMngUser.do")
	@LogInfo(description="사용자 관리 팝업 호출")
	public ModelMap viewMemberList(PopMngUserDto popMngUserDto,HttpServletRequest request,@RequestParam("newSave")String newSave,@RequestParam("usrID")String usrID,@RequestParam("lastModfiEmpLevel")String lastModfiEmpLevel){

		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("newSave", newSave);
		modelMap.addAttribute("usrID", usrID);
		if("N".equals(newSave)){
			popMngUserDto.setUsrID(usrID);
			popMngUserBiz.nameSearch(popMngUserDto);
			modelMap.addAttribute("usrName", popMngUserDto.getUsrName());
			modelMap.addAttribute("usrLevel", popMngUserDto.getUsrLevel());
		}
		modelMap.addAttribute("lastModfiEmpLevel", lastModfiEmpLevel);
		
		return modelMap;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 사용자 ID 중복 체크
	 * <p> 
	 * @param request,response,popMngUserdto
	 * @return mav
	 */
	@RequestMapping("msg.checkMngUser.popMngUser.do")
	@LogInfo(description="사용자 ID 중복 체크")
	public ModelAndView userIdCheck(HttpServletRequest request,HttpServletResponse response,PopMngUserDto popMngUserdto){	
		ModelAndView mav = new ModelAndView();
		
		popMngUserdto.setUsrID(request.getParameter("usrID"));
		
		mav.addObject("check",popMngUserBiz.getCheck(request));
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 사용자 비밀번호 초기화
	 * <p> 
	 * @param request,response,popMngUserdto
	 * @return mav
	 */
	@RequestMapping("msg.clearMngUser.popMngUser.do")
	@LogInfo(description="사용자 비밀번호 초기화")
	public ModelAndView userIdclear(HttpServletRequest request,HttpServletResponse response,PopMngUserDto popMngUserdto){	
		ModelAndView mav = new ModelAndView();
		
		popMngUserdto.setUsrID(request.getParameter("usrID"));
		popMngUserdto.setUsrName(request.getParameter("usrName"));
		
		mav.addObject("clearCheck",popMngUserBiz.getClearPass(popMngUserdto));
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 사용자 아이디 저장 및 수정
	 * <p> 
	 * @param request,response,popMngUserdto
	 * @return mav
	 */
	@RequestMapping("msg.saveMngUser.popMngUser.do")
	@LogInfo(description="사용자 아이디 저장 및 수정")
	public ModelAndView userIdsave(HttpServletRequest request,HttpServletResponse response,PopMngUserDto popMngUserdto){	
		ModelAndView mav = new ModelAndView();
		
		popMngUserdto.setUsrID(request.getParameter("usrID"));
		popMngUserdto.setUsrName(request.getParameter("usrName"));
		popMngUserdto.setUsrLevel(request.getParameter("usrLevel"));
		popMngUserdto.setNewInsert(request.getParameter("newInsert"));
		popMngUserdto.setLastModfiId(request.getParameter("sessionId"));
		popMngUserdto.setLastModfiYMS(DateUtil.getDateString());
		mav.addObject("userIdSave",popMngUserBiz.getUserIdSave(popMngUserdto));
		mav.addObject("newInsert",request.getParameter("newInsert"));
		mav.setViewName("jsonView");
		return mav;
	}
}
