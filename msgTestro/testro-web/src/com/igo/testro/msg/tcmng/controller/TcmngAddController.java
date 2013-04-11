package com.igo.testro.msg.tcmng.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.msg.pretst.dto.TestDataDto;
import com.igo.testro.msg.tcmng.biz.TcmngAddBiz;

/**
 * <p>
 * 프로그램명:TcmngAddController.java<br/>
 * 설명 : <br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 18. : ksj : 내용
 * </ul> 
 * </p>
 */
@Controller
public class TcmngAddController {
	
	@Autowired
	private TcmngAddBiz tcmngAddBiz;
	
	/**
	 * <p>
	 * 테스트케이스 추가 화면 호출
	 * </p>
	 * @param
	 * @return ModelAndView
	 */
	@LogInfo(description="테스트케이스추가 팝업을 엽니다.")
	@RequestMapping("msg.tcmng.getTcmngAdd.do")
	public ModelAndView tcmngInfo(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("msg/tcmng/tcmngAdd");
		return mv;
	}
	
	/**
	 * <p>
	 * 테스트케이스 목록 조회
	 * </p>
	 * @param	request
	 * @param	response
	 * @return 	ModelAndView
	 */
	@LogInfo(description="테스트케이스 목록을 조회 합니다.")
	@RequestMapping("msg.tcmng.getTcmngAddTcList.do")
	public ModelAndView getTcList(HttpServletRequest request,HttpServletResponse response){
		Map rstMap = tcmngAddBiz.getTcList(request);
		
		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(rstMap);
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * <p>
	 * 테스트케이스 리스트 클릭_테스트데이터 목록 조회
	 * </p>
	 * @param	request
	 * @param	response
	 * @return	ModelAndView
	 */
	@LogInfo(description="테스트데이터 목록을 조회 합니다.")
	@RequestMapping("msg.tcmng.getTcmngAddTdList.do")
	public ModelAndView getTdList(HttpServletRequest request,HttpServletResponse response){
		Map rstMap = tcmngAddBiz.getTdList(request);

		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(rstMap);
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * <p>
	 * 테스트케이스 리스트 클릭_테스트데이터 상세 목록 조회
	 * </p>
	 * @param	request
	 * @param	response
	 * @return	ModelAndView
	 */
	@LogInfo(description="테스트데이터의 상세 목록을 조회합니다.")
	@RequestMapping("msg.layout.getTcmngAddTdDetailList.do")
	public ModelAndView getTdDetail(HttpServletRequest request,HttpServletResponse response){
		TestDataDto tdDto = new TestDataDto(); 
			
		tdDto = tcmngAddBiz.getTdDetailList(request);

		ModelAndView mv = new ModelAndView();
		mv.addObject("dataDetailDto", tdDto);
		mv.setViewName("msg/tcmng/tdDetail");
		return mv;
	}
}
