package com.igo.testro.cmn.sysmng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;


/**
 * 
 * <p>
 * 프로그램명:LoginController.java<br/>
 * 설명 : 시스템관리 로그인<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 15. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
@Controller
public class LoginController {
	
	
	final ITestroLogger logger = TestroLogHelper.getBiz();
	
	/**
	 * 
	 * <p>
	 * 시스템환경관리 로그인
	 * <p>
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value="console.do")
	private ModelAndView login(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cmn/sysmng/login");
		return mv;
	}
}
