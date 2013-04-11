package com.igo.testro.msg.myLatestWork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.myLatestWork.biz.MyLatestWorkBiz;
import com.igo.testro.msg.myLatestWork.dto.myLatestWorkDto;
/**
 * <p>
 * 프로그램명:MyLatestWorkController.java<br/>
 * 설명 : 나의 최근 작업 관리<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 2. : parkminho : 내용
 * </ul> 
 * </p>
 */
@Controller
public class MyLatestWorkController {
	
	@Autowired
	private MyLatestWorkBiz myLatestWorkBiz;
	
	final ITestroLogger logger = TestroLogHelper.getBiz();
	/**
	 * <p>
	 * 메소드 설명 : 나의 최근 작업 조회 화면 이동.
	 * <p>
	 * @return
	 */
	@RequestMapping("msg.myLatestWork.myLatestWork.do")
	@LogInfo(description="나의 최근 작업 조회 화면 이동 합니다.")
	public ModelAndView myLatestWork(){
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 나의 최근 작업 조회
	 * <p>
	 * @param paramDto
	 * @return
	 */
	@RequestMapping("msg.myLatestWork.getListMyLatestWork.do")
	@LogInfo(description="나의 최근 작업 조회 합니다.")
	public ModelAndView getListMngCode(myLatestWorkDto paramDto){
		ModelAndView mav = new ModelAndView();
		mav.addAllObjects(myLatestWorkBiz.getListMyLatestWork(paramDto));
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 나의 최근 작업 삭제
	 * <p>
	 * @param paramDto
	 * @return
	 */
	@RequestMapping("msg.myLatestWork.deleteMyLatestWork.do")
	@LogInfo(description="나의 최근 작업 삭제 합니다.")
	public ModelAndView deleteMyLatestWork(myLatestWorkDto paramDto){
		ModelAndView mav = new ModelAndView();
		myLatestWorkBiz.deleteMyLatestWork(paramDto);
		mav.setViewName("jsonView");
		return mav;
	}
	
}
