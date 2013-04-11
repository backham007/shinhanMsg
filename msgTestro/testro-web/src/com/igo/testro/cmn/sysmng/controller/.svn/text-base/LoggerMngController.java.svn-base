package com.igo.testro.cmn.sysmng.controller;

import java.util.Map;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.igo.testro.anot.LogInfo;
import com.igo.testro.cmn.dto.GridBaseDto;
import com.igo.testro.cmn.sysmng.biz.LoggerMngBiz;
import com.igo.testro.cmn.sysmng.dto.LoggerMngDto;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;

/**
 * 
 * <p>
 * 프로그램명:LoggerMngController.java<br/>
 * 설명 : 로그레벨관리 Controller<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 15. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
@Controller
public class LoggerMngController {
	
	final ITestroLogger logger = TestroLogHelper.getBiz();
	
	@Autowired
	private LoggerMngBiz loggerMngBiz;
	
	/**
	 * 
	 * <p>
	 * 로그레벨관리화면 호출
	 * <p>
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value="cmn.sysmng.loggerMng.do")
	@LogInfo(description="로그레벨관리화면을 호출한다.")
	private void loggerMng(){
	}
	
	
	/**
	 * 
	 * <p>
	 * 로그정보를 조회한다.
	 * <p>
	 * @param gridBaseDto 그리드기본DTO
	 * @return ModelAndView
	 */
	@RequestMapping(value="cmn.sysmng.getListLoggerInfo.do")
	@LogInfo(description="로그정보를 조회한다.")
	public ModelAndView getListLoggerInfo(GridBaseDto gridBaseDto) {
		if (logger.isDebugEnabled()) logger.debug("grid base dto : [" + gridBaseDto + "]");
		ModelAndView mav = new ModelAndView();
		Map<String, Object> listLoggerInfo = loggerMngBiz.getListLoggerInfo(gridBaseDto);
		mav.addAllObjects(listLoggerInfo);
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * 
	 * <p>
	 * 로그정보 변경
	 * <p>
	 * @param jgGridData 로그정보 JSON String
	 * @return ModelAndView
	 */
	@RequestMapping(value="cmn.sysmng.modifyLoggerLevel.do")
	@LogInfo(description="로그레벨을  변경한다.")
	public ModelAndView modifyLoggerLevel(@RequestParam("jgGridData") String jgGridData) {
		ModelAndView mav = new ModelAndView();
	 	JSONObject fromObject = JSONObject.fromObject(jgGridData);
	 	LoggerMngDto loggerInfo = (LoggerMngDto)JSONObject.toBean(fromObject, LoggerMngDto.class);
		if (logger.isDebugEnabled()) logger.debug("loggerInfo : [" + loggerInfo + "]");
		loggerMngBiz.modifyLoggerLevel(loggerInfo.getLogName(), loggerInfo.getLogLevel());
		mav.addObject("return", "success");
		mav.setViewName("jsonView");
		return mav;
	}
}
