package com.igo.testro.msg.AutoData.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.msg.AutoData.biz.IncdecdatamngBiz;
import com.igo.testro.msg.AutoData.dto.IncdecdatamngDto;

/**
 * <p>
 * 프로그램명:IncdecdatamngController.java<br/>
 * 설명 : 증감 데이터 입력<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */
@Controller
public class IncdecdatamngController {
	final Logger logger = Logger.getLogger(getClass());
	@Autowired
	private IncdecdatamngBiz incdecdatamngBiz;
	/**
	 * <p>
	 * 메소드 설명 : 증감 데이터 입력
	 * <p> 
	 * @param request,response
	 * @return modelMap
	 */
	@RequestMapping("msg.incdecdatamng.incdecdatamng.do")
	@LogInfo(description="증감 데이터 입력 팝업 호출")
	public ModelMap viewMemberList(HttpServletRequest request){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date currentTime = new Date();
		String date = formatter.format(currentTime);
		String listCount = request.getParameter("listCount");
		ModelMap modelMap = new ModelMap();
		
		modelMap.addAttribute("listCount", listCount);
		modelMap.addAttribute("date", date);
		return modelMap;
		
	}
	/**
	 * <p>
	 * 메소드 설명 : 증감데이터 입력 생성
	 * <p> 
	 * @param request,response
	 * @return mav
	 */
	@RequestMapping("msg.incdecdatamng.createlist.do")	
	@LogInfo(description="증감 데이터 입력 값 생성")
	public ModelAndView getlist(HttpServletRequest request,HttpServletResponse response) {
		
		String paramStartDate = request.getParameter("startDate");
		String paraminqrGbn   = request.getParameter("inqrGbn");
		String paramendDate   = request.getParameter("endDate");
		String paramstartVal  = request.getParameter("startVal");
		String paramendVal    = request.getParameter("endVal");
		String paramstep      = request.getParameter("step");
		
		ModelAndView mav      = new ModelAndView();
		IncdecdatamngDto dataDTO = new IncdecdatamngDto();
		String dstName=null;
		
		dataDTO.setDstCd(paraminqrGbn);
		if("amt".equals(dataDTO.getDstCd())){
			dstName ="숫자";
		}else if("date".equals(dataDTO.getDstCd())){
			dstName ="날짜";
		}
		dataDTO.setDstName(dstName);	
		dataDTO.setStartDate(paramStartDate);
		dataDTO.setEndDate(paramendDate);	
		dataDTO.setStartVal(paramstartVal);
		dataDTO.setEndVal(paramendVal);
		dataDTO.setStep(paramstep);

		mav.addAllObjects(incdecdatamngBiz.createIncDecData(dataDTO));
		mav.setViewName("jsonView");
		
		return mav;
	}	
}

