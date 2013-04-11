package com.igo.testro.msg.AutoData.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.msg.AutoData.biz.AutoDataBiz;
import com.igo.testro.util.CharUtil;

/**
 * <p>
 * 프로그램명:AutoDataController.java<br/>
 * 설명 : 데이터 자동 생성<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */
@Controller
public class AutoDataController {
	
	@Autowired
	AutoDataBiz autoDataBiz;
	
	/**
	 * <p>
	 * 메소드 설명 : 데이터 자동 생성
	 * <p> 
	 * @param request
	 * @return modelMap
	 */
	@RequestMapping("msg.autoData.autoData.do")
	@LogInfo(description="데이터 자동 생성 팝업 호출")
	public ModelAndView viewMemberList(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String totalarray = CharUtil.convUrlParam(request.getParameter("totalarray"));
		mav.addObject("totalarray", totalarray);
		mav.setViewName("msg/autoData/autoData");
		
		return mav;
	}
}
