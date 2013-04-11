package com.igo.testro.msg.cmn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.cmn.utils.DateUtil;
import com.igo.testro.msg.cmn.biz.PopUserPassBiz;
import com.igo.testro.msg.cmn.dto.PopUserPassDto;

/**
 * <p>
 * 프로그램명:PopUserPassController.java<br/>
 * 설명 : 비밀번호 변경<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */

@Controller
public class PopUserPassController {

	@Autowired
	private PopUserPassBiz popUserPassBiz;
	
	/**
	 * <p>
	 * 메소드 설명 : 비밀번호 변경
	 * <p> 
	 * @param request,response,popUserPassDto
	 * @return mav
	 */
	@RequestMapping("msg.popUserPass.popUserPass.do")
	@LogInfo(description="비밀번호 변경 팝업 호출")
	public void viewMemberList(){
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 사용자 비밀번호 변경
	 * <p> 
	 * @param request,response,popUserPassDto
	 * @return mav
	 */
	@RequestMapping("msg.userPassSave.popUserPass.do")
	@LogInfo(description="사용자 비밀번호 변경")
	public ModelAndView userPassSave(HttpServletRequest request,HttpServletResponse response,PopUserPassDto popUserPassDto){	
		ModelAndView mav = new ModelAndView();
		
		popUserPassDto.setUsrID(request.getParameter("usrID"));
		popUserPassDto.setOldPass(request.getParameter("oldPass"));
		popUserPassDto.setNewPass1(request.getParameter("newPass1"));
		popUserPassDto.setNewPass2(request.getParameter("newPass2"));
		popUserPassDto.setLastModfiYMS(DateUtil.getDateString());
		mav.addObject("intupdate",popUserPassBiz.userPassSave(popUserPassDto));
		mav.setViewName("jsonView");
		return mav;
	}
}
