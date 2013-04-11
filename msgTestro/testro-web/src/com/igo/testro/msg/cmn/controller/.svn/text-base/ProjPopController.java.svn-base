package com.igo.testro.msg.cmn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.msg.cmn.biz.ProjPopBiz;
import com.igo.testro.msg.cmn.dto.ProjPopDto;


/**
 * 
 * <p>
 * 프로그램명:ProjPopController.java<br/>
 * 설명 : 프로젝트조회 팝업 Controller<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 21. : KoJaeHyeong : 최초작성
 * </ul> 
 * </p>
 */
@Controller
public class ProjPopController {
	
	@Autowired
	private ProjPopBiz projPopBiz;
	
	/**
	 * 
	 * <p>
	 * 프로젝트조회 팝업화면
	 * <p>
	 * @return ModelAndView
	 */
	@LogInfo(description="프로젝트조회 팝업화면")
	@RequestMapping("msg.cmn.projPop.do")
	public ModelAndView projPop(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("msg/cmn/projPop");
		return mv;
	}
	
	/**
	 * 
	 * <p>
	 * 프로젝트 조회
	 * <p>
	 * @param request HttpServletRequest
	 * @return ModelAndView
	 */
	@LogInfo(description="프로젝트 조회")
	@RequestMapping("msg.cmn.getListProj.do")
	public ModelAndView getListProj(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(projPopBiz.getListProj(request));
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * 
	 * <p>
	 * 테스트단계 조회
	 * <p>
	 * @param projNo 프로젝트번호
	 * @return ModelAndView
	 */
	@LogInfo(description="테스트단계 조회")
	@RequestMapping("msg.cmn.getListTestStgeName.do")
	public ModelAndView getListTestStgeName(@RequestParam("projNo")String projNo){
		
		Map outputMap = new HashMap();
		outputMap.put("list",projPopBiz.getListTestStgeName(projNo));
		
		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(outputMap);
		mv.setViewName("jsonView");
		return mv;
	}
}
