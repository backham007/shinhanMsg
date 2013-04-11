package com.igo.testro.cmn.sysmng.controller;

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
 * 프로그램명:PopLicenseController.java<br/>
 * 설명 : 라이센스 팝업 호출<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 4. 12. : 고재형 : 최초작성</li>
 * </ul> 
 * </p>
 */

@Controller
public class PopLicenseController {

	/**
	 * <p>
	 * 메소드 설명 : 라이센스 팝업 호출
	 * <p> 
	 * @param request,response,popUserPassDto
	 * @return mav
	 */
	@RequestMapping("cmn.sysmng.popLicense.do")
	@LogInfo(description="비밀번호 변경 팝업 호출")
	public void viewLicensePop(){
	}
}
