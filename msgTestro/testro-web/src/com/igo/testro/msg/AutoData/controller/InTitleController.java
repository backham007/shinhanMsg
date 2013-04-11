package com.igo.testro.msg.AutoData.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.msg.AutoData.biz.InTitleBiz;

/**
 * <p>
 * 프로그램명:InTitleController.java<br/>
 * 설명 : 입력 도우미<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */
@Controller
public class InTitleController {
	

	@Autowired
	InTitleBiz inTitleBiz;
	
	/**
	 * <p>
	 * 메소드 설명 : 입력 도우미
	 * <p> 
	 * @param request
	 * @return modelMap
	 */
	@RequestMapping("msg.inTitle.inTitle.do")
	@LogInfo(description="입력 도우미 팝업 호출")
	public ModelMap viewMemberList(HttpServletRequest request){
		ModelMap modelMap = new ModelMap();
		String gubun = request.getParameter("Gubun");
		modelMap.addAttribute("gubun", gubun);
		return modelMap;
	}
}
