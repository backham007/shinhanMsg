package com.igo.testro.exception.resolver;

import java.io.File;
import java.io.FileInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.dao.DataAccessException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import com.igo.testro.exception.BizException;
import com.igo.testro.exception.FrameworkException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.preference.LinkedProperties;

/**
 * 
 * <p>
 * 프로그램명:BaseExceptionResolver.java<br/>
 * 설명 : HandlerExceptionResolver 구현 클래스<br/>
 * controller에서 오류가 발생할경우 해당되는 오류코드에 따라 메세지를 만들어 error.jsp페이지로 분기해분다.<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 14. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class BaseExceptionResolver implements HandlerExceptionResolver {

	private static final String CMN_SERVICE_EXCEL_UPLOAD_DO = "cmn.service.excelUpload.do";
	private static String ERRMSG_FILE = "errcodeMessage.prop";
	private String view = null;
	private static LinkedProperties props = new LinkedProperties();
	final ITestroLogger bLogger = TestroLogHelper.getBiz();
	final ITestroLogger fLogger = TestroLogHelper.getFramework();
	
	static {
		String configPath = System.getProperty("CONFIG_PATH");
		try {
			FileInputStream fileInputStream = new FileInputStream(new File(configPath + "/"
					+ ERRMSG_FILE));
			props.load(fileInputStream);
		} catch (Exception e) {
			throw new FrameworkException("[errdodeMesssage.prop] 파일을 읽는도중 에러가발생하였습니다.", e);
		} 
	}
	
	/**
	 * 
	 * <p>
	 * setView
	 * <p>
	 * @param view
	 */
	public void setView(String view) {
		this.view = view;
	}
	
	/**
	 * 
	 * <p>
	 * 오류코드에 해당되는 메시지를 찾아 error.jsp로 호출해준다.
	 * <p>
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param obj
	 * @param exception
	 * @return
	 */
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception exception) {
		
		if (fLogger.isDebugEnabled()) fLogger.debug("exception : [" + exception + "]");
		String message = null;
		String errorCode = null;
		if (exception instanceof BizException) {
			bLogger.error("resolveException proccess..", exception);
			errorCode = ((BizException) exception).getErrorCode();
			message = props.getProperty(errorCode);
			if (bLogger.isInfoEnabled()) bLogger.info("errorCode : [" + errorCode + "]      message : [" + message + "]");
		} else if (exception instanceof FrameworkException) {
			bLogger.error("resolveException proccess..", exception);
			errorCode = "MSG_TESTRO0001";
			message = props.getProperty(errorCode);
		} else if (exception instanceof DataAccessException) {
			bLogger.error("ibatis DataAccessException error..", exception);
			errorCode = "MSG_TESTRO0002";
			message = props.getProperty(errorCode);
		} else {
			bLogger.error("resolveException proccess..", exception);
			errorCode = "MSG_TESTRO0003";
			message = props.getProperty(errorCode) + " [" + exception.getMessage() + "]";
		}
		
		if (fLogger.isDebugEnabled()) fLogger.debug("errMassege : [" + message + "]");
		
		String headerValue = request.getHeader("X-Requested-With");
		
		if (headerValue != null && "XMLHttpRequest".equals(headerValue)) {
			view = "jsonView";
		}
		
		// grid exel upload를 위한 예외처리
		if (fLogger.isDebugEnabled()) fLogger.debug("request.getRequestURI() : " + request.getRequestURI());
		String requestURI = request.getRequestURI();
		int lastIdx = requestURI.lastIndexOf("/");
		String url = requestURI.substring(lastIdx+1);
		if (fLogger.isDebugEnabled()) fLogger.debug("url :" + url);
		if (CMN_SERVICE_EXCEL_UPLOAD_DO.equals(url)) view = "gridFileView";
		
		ModelAndView mv = new ModelAndView(view);
		mv.addObject("errCd", errorCode);
		mv.addObject("errMsg", message);
		return mv;
	}

}
