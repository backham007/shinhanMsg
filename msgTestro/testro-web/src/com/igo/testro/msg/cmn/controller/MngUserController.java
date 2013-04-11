package com.igo.testro.msg.cmn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.msg.cmn.biz.MngUserBiz;
import com.igo.testro.msg.cmn.dto.MngUserDto;

/**
 * <p>
 * 프로그램명:MngUserController.java<br/>
 * 설명 : 사용자 정보 관리<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */

@Controller
public class MngUserController {
	
	@Autowired
	private MngUserBiz mngUserBiz;
	
	/**
	 * <p>
	 * 메소드 설명 : 사용자 정보 관리 호출
	 * <p> 
	 * @param request,response
	 * @return mav
	 */
	@RequestMapping("msg.mngUser.mngUser.do")
	@LogInfo(description="사용자 정보 관리 팝업 호출")
	public void viewMemberList(){
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 사용자 정보 조회
	 * <p> 
	 * @param request,response
	 * @return mav
	 */
	@RequestMapping("msg.MngUserSearch.mngUser.do")
	@LogInfo(description="사용자 정보 조회")
	public ModelAndView getListSearch(HttpServletRequest request,HttpServletResponse response){			
		ModelAndView mav = new ModelAndView();		
		mav.addAllObjects(mngUserBiz.getlist(request));
		mav.setViewName("jsonView");
		return mav;
	}

	/**
	 * <p>
	 * 메소드 설명 : 사용자 리스트 행 삭제
	 * <p> 
	 * @param request,response,mngUserDto
	 * @return mav
	 */
	@RequestMapping("msg.MngUserDelete.mngUser.do")
	@LogInfo(description="사용자 리스트 행 삭제")
	public ModelAndView getDelete(HttpServletRequest request,HttpServletResponse response, MngUserDto mngUserDto){	
		
		ModelAndView mav = new ModelAndView();
		mngUserDto.setUsrID(request.getParameter("usrID"));
		mngUserDto.setUsrName(request.getParameter("usrName"));
		mngUserDto.setProjNo(request.getParameter("projNo"));
		mav.addObject(mngUserBiz.getDelete(mngUserDto));
		mav.setViewName("jsonView");
		return mav;
	}
}
