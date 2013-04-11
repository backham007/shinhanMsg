package com.igo.testro.cmn.login.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.cmn.login.LoginCheck;
import com.igo.testro.cmn.login.biz.LoginBiz;
import com.igo.testro.cmn.login.dto.LoginDto;
import com.igo.testro.exception.BizException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;


/**
 * <p>
 * 프로그램명:ExcuteloginController.java<br/>
 * 설명 : 로그인 controller<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 10. : 안도현 : 최초작성
 * </ul> 
 * </p>
 */
@Controller
public class ExcuteloginController {
	
	final ITestroLogger logger = TestroLogHelper.getBiz();
	
	@Autowired
	private LoginBiz loginBiz;
	@Autowired
	private LoginCheck loginCheck;
	
	/**
	 * <p>
	 * 로그인 (View)페이지 최초호출
	 * <p>
	 * @param request
	 */
	@RequestMapping("cmn.login.do")
	public String login(HttpServletRequest request){
		boolean loginYn = loginCheck.isLogin(request);
		if(loginYn){
			return "msg.myQalty.myQalty"; 
		}
		return "cmn.login";
	}
	
	/**
	 * <p>
	 * 로그인
	 * <p>
	 * @param request
	 * @return
	 */
	@RequestMapping("cmn.login.excutelogin.do")
	public ModelAndView excutelogin(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		Map outputMap = new HashMap();
		Map param = new HashMap();
		String message="";
		param.put("usrid", request.getParameter("usrid"));
		param.put("usrpwd", request.getParameter("usrpwd"));
		
		try {
			message = loginBiz.getusercheck(param);
			logger.debug("사용자 체크 메세지==>" + message);
			if ("".equals(message)) {
				LoginDto userinfo = loginBiz.getuserinfo(param);
				loginCheck.setLoginInfo(request, userinfo);
				outputMap.put("userinfo", userinfo);
			}
		} catch (DataAccessException e) {
			logger.error("", e);
			throw new BizException("MSG_LOGINN0001","", e);
		}
		outputMap.put("message", message );
		mav.addAllObjects(outputMap);
		mav.setViewName("jsonView");
		return mav;
	}

	/**
	 * <p>
	 * 로그아웃
	 * <p>
	 * @param request
	 * @return
	 */
	@RequestMapping("cmn.login.excutelogout.do")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		loginCheck.delLoginSession(request);
		return "cmn.login";
	}

	/**
	 * <p>
	 * 세션체크 jsp 호출
	 * <p>
	 * @param request
	 */
	@RequestMapping("cmn.login.sessionCheck.do")
	public String sessionView(HttpServletRequest request){
		return "cmn.sessionCheck";
	}
	
}
