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
 * 프로그램명:TestPrgsStsController.java<br/>
 * 설명 : 개인별 진척 현황 조회<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 14. : parkminho : 내용
 * </ul> 
 * </p>
 */
@Controller
public class PrvtTestPrgsStsController {
	
	@Autowired
	private StatisticsBiz statisticsBiz;
	
	final ITestroLogger logger = TestroLogHelper.getBiz();
	
	public void setStatisticsBiz(StatisticsBiz statisticsBiz) {
		this.statisticsBiz = statisticsBiz;
	}

	/**
	 * <p>
	 * 메소드 설명 : 개인별 진척 현황 조회 화면으로 이동
	 * <p>
	 * @return
	 */
	@RequestMapping("msg.statistics.prvtTestPrgsSts.do")
	@LogInfo(description="개인별 진척 현황 조회 화면으로 이동")
	public ModelAndView moveTestPrgsSts(){
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	/**
	 * <p>
	 * 메소드 설명 : 개인별 진척 현황 조회
	 * <p>
	 * @return
	 */
	@RequestMapping("msg.statistics.getPrvtTestPrgsSts.do")
	@LogInfo(description="개인별 진척 현황 조회")
	public ModelAndView getTestPrgsSts(RptParamDTO paramDTO){
		ModelAndView mav = new ModelAndView();
		mav.addAllObjects(statisticsBiz.getPrvtTestPrgsSts(paramDTO));
//		mav.setViewName("statistics.TestPrgsSts");
		mav.setViewName("jsonView");
		return mav;
	}

}
