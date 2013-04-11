package com.igo.testro.cmn.sysmng.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.cmn.dto.GridBaseDto;
import com.igo.testro.cmn.sysmng.biz.SysEnvVarMngBiz;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;


/**
 * 
 * <p>
 * 프로그램명:SysEnvVarMngController.java<br/>
 * 설명 : 시스템환경변수 관리<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 15. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
@Controller
public class SysEnvVarMngController {
	
	final ITestroLogger logger = TestroLogHelper.getBiz();
	
	@Autowired
	private SysEnvVarMngBiz envVarMngBiz;
	
	
	/**
	 * 
	 * <p>
	 * 시스템환경변수 관리
	 * <p>
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value="cmn.sysmng.sysEnvVarMng.do")
	@LogInfo(description="시스템환경변수조회 화면을 호출한다.")
	private void SysEnvVarMng(){
	}
	
	
	/**
	 * 
	 * <p>
	 * 시스템환경변수 리스트 조회
	 * <p>
	 * @param dto 그리드기본DTO
	 * @return ModelAndView
	 */
	@RequestMapping(value="cmn.sysmng.getListSysConfInfo.do")
	@LogInfo(description="시스템환경변수 리스트 조회")
	public ModelAndView getListSysConfInfo(GridBaseDto gridBaseDto) {
		
		if (logger.isDebugEnabled()) logger.debug("grid base dto : [" + gridBaseDto + "]");
		ModelAndView mav = new ModelAndView();
		Map<String, Object> sysConfInfoList = envVarMngBiz.getListSysConfInfo(gridBaseDto);
		mav.addAllObjects(sysConfInfoList);
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * 
	 * <p>
	 * 시스템환경변수를 다시 읽어온다.
	 * <p>
	 * @return ModelAndView
	 */
	@RequestMapping(value="cmn.sysmng.executeReload.do")
	@LogInfo(description="시스템환경변수를 다시 읽어온다.")
	public ModelAndView executeReload() {
		ModelAndView mav = new ModelAndView();
		envVarMngBiz.executeReload();
		mav.addObject("return", "success");
		mav.setViewName("jsonView");
		return mav;
	}
	
	

}
