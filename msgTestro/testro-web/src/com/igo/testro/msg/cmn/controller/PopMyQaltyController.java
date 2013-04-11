package com.igo.testro.msg.cmn.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.cmn.utils.DateUtil;
import com.igo.testro.exception.BizException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.cmn.biz.PopMyQaltyBiz;
import com.igo.testro.msg.cmn.dto.MyQaltyDto;
import com.igo.testro.util.CharUtil;

/**
 * <p>
 * 프로그램명:PopMyQaltyController.java<br/>
 * 설명 : 사용자 관리<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */
@Controller
public class PopMyQaltyController {
	@Autowired
	private PopMyQaltyBiz popMyQaltyBiz;
	
	final ITestroLogger logger = TestroLogHelper.getBiz();
	
	/**
	 * <p>
	 * 메소드 설명 : 나의 프로젝트 관리 팝업 호출
	 * <p>
	 * @param myQaltyDto
	 * @param request
	 * @param newSave
	 * @param projNo
	 * @param lastModfiEmpLevel
	 * @return
	 */
	@RequestMapping("msg.popMyQalty.popMyQalty.do")
	@LogInfo(description="나의 프로젝트 관리 팝업 호출")
	public ModelMap viewMemberList(MyQaltyDto myQaltyDto,HttpServletRequest request,@RequestParam("newSave")String newSave,@RequestParam("testStgeName")String testStgeName,@RequestParam("projNo")String projNo,@RequestParam("lastModfiEmpLevel")String lastModfiEmpLevel){
		ModelMap modelMap = new ModelMap();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date currentTime = new Date();
		String date = formatter.format(currentTime);
		modelMap.addAttribute("newSave", newSave);
		modelMap.addAttribute("projNo", projNo);
		if("N".equals(newSave)){
			myQaltyDto.setProjNo(CharUtil.convUrlParam(projNo));
			myQaltyDto.setTestStgeName(CharUtil.convUrlParam(testStgeName));
			MyQaltyDto listDto = popMyQaltyBiz.projectSearch(myQaltyDto);
			modelMap.addAttribute("projNo",listDto.getProjNo());
			modelMap.addAttribute("projName",listDto.getProjName());
			modelMap.addAttribute("TestStgeName",listDto.getTestStgeName());
			modelMap.addAttribute("startDate",DateUtil.convertShortQuicsFormat(listDto.getTestStartYMS()));
			modelMap.addAttribute("endDate",DateUtil.convertShortQuicsFormat(listDto.getTestEndYMS()));
		}
		modelMap.addAttribute("date", date);
		modelMap.addAttribute("lastModfiEmpLevel", lastModfiEmpLevel);
		return modelMap;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 프로젝트 번호 중복 체크
	 * <p> 
	 * @param request,response,myQaltyDto
	 * @return mav
	 */
	@RequestMapping("msg.checkMngUser.popMyQalty.do")
	@LogInfo(description="프로젝트 번호 중복 체크")
	public ModelAndView userIdCheck(HttpServletRequest request,HttpServletResponse response,MyQaltyDto myQaltyDto){	
		ModelAndView mav = new ModelAndView();
		
		myQaltyDto.setProjNo(request.getParameter("projNo"));
		
		mav.addObject("check",popMyQaltyBiz.getCheck(request));
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 테스트 단계 중복 체크
	 * <p> 
	 * @param request,response,myQaltyDto
	 * @return mav
	 */
	@RequestMapping("msg.projectStepCheckMngUser.popMyQalty.do")
	@LogInfo(description="프로젝트 번호 중복 체크")
	public ModelAndView projectStepCheckMngUser(HttpServletRequest request,HttpServletResponse response,MyQaltyDto myQaltyDto){	
		ModelAndView mav = new ModelAndView();
		
		myQaltyDto.setProjNo(request.getParameter("projectNo"));
		myQaltyDto.setTestStgeName(request.getParameter("projectStep"));
		
		mav.addObject("check",popMyQaltyBiz.projectStepCheckMngUser(myQaltyDto));
		mav.setViewName("jsonView");
		return mav;
	}
	/**
	 * <p>
	 * 메소드 설명 : 프로젝트 저장
	 * <p> 
	 * @param request,response,myQaltyDto
	 * @return mav
	 */
	@RequestMapping("msg.saveMyQalty.popMyQalty.do")
	@LogInfo(description="프로젝트 저장")
	public ModelAndView userIdsave(HttpServletRequest request,HttpServletResponse response,MyQaltyDto myQaltyDto){	
		ModelAndView mav = new ModelAndView();
		
		myQaltyDto.setProjNo(request.getParameter("projNo"));
		myQaltyDto.setProjName(request.getParameter("projName"));
		myQaltyDto.setTestStgeName(request.getParameter("TestStgeName"));
		myQaltyDto.setTestStartYMS(request.getParameter("startDate").replace("-", "")+ "000000");
		myQaltyDto.setTestEndYMS(request.getParameter("endDate").replace("-", "")+ "235959");
		myQaltyDto.setLastModfiYMS(DateUtil.getDateString());
		myQaltyDto.setLastModfiEmpid(request.getParameter("usrId"));
		myQaltyDto.setNewInsert(request.getParameter("newInsert"));
		mav.addObject("userIdSave",popMyQaltyBiz.insertProject(myQaltyDto));
		mav.addObject("newInsert",request.getParameter("newInsert"));
		mav.setViewName("jsonView");
		return mav;
	}
}
