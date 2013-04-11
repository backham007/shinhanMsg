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
import com.igo.testro.msg.tcmng.biz.TcmngInfoBiz;


/**
 * <p>
 * 프로그램명:TemplateTcController.java<br/>
 * 설명 : 테스트케이스 불러오기<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 10. : ksj : 내용
 * </ul> 
 * </p>
 */
@Controller
public class TcmngInfoController {
	
	@Autowired
	private TcmngInfoBiz tcmngInfoBiz;
	
	/**
	 * <p>
	 * 테스트케이스 불러오기 화면 호출
	 * </p>
	 * @param
	 * @return ModelAndView
	 */
	@LogInfo(description="테스트케이스추가 팝업을 엽니다.")
	@RequestMapping("msg.tcmng.getTcmngInfo.do")
	public ModelAndView tcmngInfo(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("msg/tcmng/tcmngInfo");
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
	@RequestMapping("msg.tcmng.getTcList.do")
	public ModelAndView getTcList(HttpServletRequest request,HttpServletResponse response){
		Map rstMap = tcmngInfoBiz.getTcList(request);
		
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
	@RequestMapping("msg.tcmng.getTdList.do")
	public ModelAndView getTdList(HttpServletRequest request,HttpServletResponse response){
		Map rstMap = tcmngInfoBiz.getTdList(request);

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
	@RequestMapping("msg.layout.getTdDetailList.do")
	public ModelAndView getTdDetail(HttpServletRequest request,HttpServletResponse response){
		TestDataDto tdDto = new TestDataDto(); 
			
		tdDto = tcmngInfoBiz.getTdDetailList(request);

		ModelAndView mv = new ModelAndView();
		mv.addObject("dataDetailDto", tdDto);
		mv.setViewName("msg/tcmng/tdDetail");
		return mv;
	}
}
