package com.igo.testro.svclistener;


import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.DispatcherServlet;

import com.igo.testro.constant.PropertyKey;
import com.igo.testro.exception.FrameworkException;
import com.igo.testro.infra.ILoginCheck;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.preference.LinkedProperties;
import com.igo.testro.preference.TestroPreference;
import com.igo.testro.service.ServiceFinder;

/**
 * <p>
 * 프로그램명:TestroDispatcherServlet.java<br/>
 * 설명 : DispatcherServlet extends class<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 10. : 안도현 : 최초작성</li>
 * </ul> 
 * </p>
 */
public class TestroDispatcherServlet extends DispatcherServlet {
	
	private static final String FALSE = "false";
	private static final String MSG_TESTRO0004 = "MSG_TESTRO0004";
	final ITestroLogger logger = TestroLogHelper.getBiz();
	private static final String LOGIN_PASS_URL = "LOGIN_PASS_URL";
	private static final String LOGIN_URL = "LOGIN_URL";
	private static String ERRMSG_FILE = "errcodeMessage.prop";


	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.DispatcherServlet#doService(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestDispatcher  dispath;
		boolean pass_gubun = true; //true(로그인 체크시) 
		String requri = request.getRequestURI().split("\\/")[2];
		String pass_url = TestroPreference.getInstance().getProperty(LOGIN_PASS_URL, TestroPreference.MASTER);
		String[] pass_url_list =  pass_url.split("[|]");
		boolean sessionNullYn = false;
		
		sessionNullYn = notValidLogin(request, response); // null: true, not null: false
		
		if( sessionNullYn ){
			
			//로그인체크 필요 여부 check
			for (int i = 0; i < pass_url_list.length; i++) {
				logger.debug("requri:["+requri+"]pass_url_list["+i+"]:["+pass_url_list[i]+"]");
				if( requri.equals( pass_url_list[i] ) ){
					pass_gubun = false;
					break;
				}
			}
			
		}
		
		logger.debug("request.getRequestURI()==>"+request.getRequestURI());
		logger.debug("sessionNullYn==>"+sessionNullYn);
		logger.debug("requri==>"+requri);
		logger.debug("pass_gubun==>"+pass_gubun);
		
		if (pass_gubun) {
			if (notValidLogin(request, response)) {
				logger.debug("==== 로그인여부 false ====");
				String loginUrl = TestroPreference.getInstance().getProperty(
						LOGIN_URL, TestroPreference.MASTER);
				//request.getRequestDispatcher(loginUrl);
				dispath = getServletContext().getRequestDispatcher(loginUrl);
				
				String headerValue = request.getHeader("X-Requested-With");
				if (headerValue != null && "XMLHttpRequest".equals(headerValue)) {
					String configPath = System.getProperty("CONFIG_PATH");
					LinkedProperties props = new LinkedProperties();
					try {
						
						FileInputStream fileInputStream = new FileInputStream(new File(configPath + "/"
								+ ERRMSG_FILE));
						props.load(fileInputStream);
					} catch (Exception e) {
						throw new FrameworkException("[errdodeMesssage.prop] 파일을 읽는도중 에러가발생하였습니다.", e);
					} 
					response.setContentType("application/json;charset=UTF-8");
					PrintWriter writer = response.getWriter();
					writer.print("{\"errCd\":\""+ MSG_TESTRO0004 + "\",\"errMsg\":\"" + props.getProperty(MSG_TESTRO0004)+ "\"}");
					
				} else {
					dispath.forward(request, response);
				}
				
				return;
			}
		}
		super.doService(request, response);
	}
	
	
	/**
	 * <p>
	 * 로그인정보를 확인해서 필요한데 되어 있지않으면 로그인 페이지로 redirect
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param context
	 * @return 로그인에 부합되지 않으면 true 로그인에 부합되면 false
	 * @throws FrameworkException
	 * @throws ServletException
	 */
	private boolean notValidLogin(HttpServletRequest request,
			HttpServletResponse response) throws FrameworkException,
			ServletException{
		String loginCheckYn = TestroPreference.getInstance().getProperty(PropertyKey.LOGIN_CHECK_YN.getCode(), TestroPreference.MASTER);
		if (logger.isDebugEnabled()) logger.debug("LOGIN_CHECK_YN : [" + loginCheckYn + "]");
		if (FALSE.equals(loginCheckYn)) return false;
		ILoginCheck loginCheck = (ILoginCheck) ServiceFinder.getInstance()
				.getService("loginCheck", ServiceFinder.WEB);
		if (!loginCheck.isLogin(request)) {//checkLogin = true,를 설정 해놓은 경우  ===>로그인안 되어 있는 경우
			return true;
		}
		return false;
	}

}
