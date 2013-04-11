package com.igo.testro.msg.statistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.statistics.biz.StatisticsBiz;
import com.igo.testro.msg.statistics.dto.RptParamDTO;

/**
 * <p>
 * 프로그램명:DefPrgsStsController.java<br/>
 * 설명 : 결함 총괄표 조회<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 22. : parkminho : 내용
 * </ul> 
 * </p>
 */
@Controller
public class DefPrgsStsController {
	
	@Autowired
	private StatisticsBiz statisticsBiz;
	final ITestroLogger logger = TestroLogHelper.getBiz();

	/**
	 * <p>
	 * 메소드 설명 : 결함 총괄표 화면 이동.
	 * <p>
	 * @return
	 */
	@RequestMapping("msg.statistics.defPrgsSts.do")
	@LogInfo(description="결함 총괄표 화면으로 이동 합니다.")
	public ModelAndView moveTestPrgsSts() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	/**
	 * <p>
	 * 메소드 설명 : 결함 총괄표 조회.
	 * <p>
	 * @param paramDTO
	 * @return
	 */
	@RequestMapping("msg.statistics.getDefPrgsSts.do")
	@LogInfo(description="결함 총괄표 조회 합니다.")
	public ModelAndView getExeStsLst(RptParamDTO paramDTO) {
		ModelAndView mav = new ModelAndView();
		mav.addAllObjects(statisticsBiz.getDefPrgsSts(paramDTO));
		// mav.setViewName("statistics.TestPrgsSts");
		mav.setViewName("jsonView");
		return mav;
	}

}
