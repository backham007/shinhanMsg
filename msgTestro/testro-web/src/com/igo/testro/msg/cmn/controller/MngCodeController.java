package com.igo.testro.msg.cmn.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.msg.cmn.biz.MngCodeBiz;
import com.igo.testro.msg.cmn.dto.MngCodeDto;

/**
 * <p>
 * 프로그램명:MngCodeController.java<br/>
 * 설명 : 코드 목록 조회<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 27. : parkminho : 내용
 * </ul> 
 * </p>
 */
@Controller
public class MngCodeController {
	
	@Autowired
	private MngCodeBiz mngCodeBiz;
	
	
	/**
	 * <p>
	 * 메소드 설명 : 코드 목록 조회
	 * <p>
	 * @param paramDto
	 * @return
	 */
	@RequestMapping("msg.cmn.getListMngCode.do")
	@LogInfo(description="코드 목록을 조회 합니다.")
	public ModelAndView getListMngCode(MngCodeDto paramDto){
		ModelAndView mav = new ModelAndView();
		Map outputMap = new HashMap();
		outputMap.put("list", mngCodeBiz.getListMngCode(paramDto));
		mav.addAllObjects(outputMap);
		mav.setViewName("jsonView");
		return mav;
	}
}
