package com.igo.testro.msg.exeSts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.msg.exeSts.biz.ExeStsBiz;
import com.igo.testro.msg.statistics.dto.RptParamDTO;

/**
 * <p>
 * 프로그램명:TestPrgsStsController.java<br/>
 * 설명 : 테스트 수행현황 조회<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 14. : parkminho : 내용
 * </ul> 
 * </p>
 */
@Controller
public class ExeStsController {
	
	@Autowired
	private ExeStsBiz exeStsBiz;
	

	/**
	 * <p>
	 * 메소드 설명 : 테스트 수행 현황 팝업
	 * <p>
	 * 
	 * @return
	 */
	@RequestMapping("msg.exeSts.exeSts.do")
	@LogInfo(description="[팝업]테스트 수행 현황으로 이동 합니다.")
	public ModelAndView moveTestPrgsSts() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	/**
	 * <p>
	 * 메소드 설명  : 테스트 수행 현황 조회
	 * <p>
	 * @param paramDTO
	 * @return
	 */
	@RequestMapping("msg.exeSts.getExeSts.do")
	@LogInfo(description="[팝업]테스트 수행 현황을 조회 합니다.")
	public ModelAndView getExeStsLst(RptParamDTO paramDTO) {
		ModelAndView mav = new ModelAndView();

		mav.addAllObjects(exeStsBiz.getExeStsLst(paramDTO));
		mav.setViewName("jsonView");
		return mav;
	}

}
