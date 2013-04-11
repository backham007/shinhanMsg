package com.igo.testro.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.igo.testro.dto.TestroLoginDTO;
import com.igo.testro.infra.ILoginCheck;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.service.ServiceFinder;
import com.igo.testro.thread.ThreadAttribute;

public class LogInterceptor extends HandlerInterceptorAdapter {
	
	final ITestroLogger logger = TestroLogHelper.getBiz();
	
	public boolean preHandle(HttpServletRequest request,
			   HttpServletResponse response, Object handler) throws Exception {
		
		String strInfoLog = "";
		
		ILoginCheck loginCheck = (ILoginCheck) ServiceFinder.getInstance()
			.getService("loginCheck", ServiceFinder.WEB);
		if (loginCheck.isLogin(request)) {
			HttpSession session = request.getSession();
			TestroLoginDTO loginDTO = (TestroLoginDTO) session.getAttribute("userinfo");
			String usrid = loginDTO.getUsrid();
			String usrname = loginDTO.getUsrname();
			
			strInfoLog = "사용자ID : [" + usrid + "] 사용자명 : [" + usrname + "]  ";
			Map<String, Object> threadData = ThreadAttribute.get();
			threadData.put("USER_INFO", strInfoLog);
		}
		return true;
	}
}
