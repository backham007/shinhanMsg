package com.igo.testro.msg.schedule.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.igo.testro.anot.LogInfo;
import com.igo.testro.cmn.login.dto.LoginDto;
import com.igo.testro.cmn.utils.DateUtil;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.schedule.biz.ScheduleMngBiz;
import com.igo.testro.msg.schedule.dto.ScheduleMngDto;

/**
 * 
 * <p>
 * 프로그램명 : ScheduleMngController.java<br/>
 * 설명 : 테스트예약 실행관리 Controller<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 23. : kangwoo : 최초작성
 *	  <li>2012. 3. 19. : kangwoo : 주석보완
 * </ul> 
 * </p>
 */
@Controller
public class ScheduleMngController {
	
	ITestroLogger logger = TestroLogHelper.getBiz();
	
	@Autowired
	private ScheduleMngBiz scheduleMngBiz;
	
	/**
	 * 
	 * <p>
	 * 테스트예약 등록관리 화면을 호출한다.
	 * <p>
	 * @return
	 */
	@RequestMapping(value="msg.schedule.scheduleMng.do")
	@LogInfo(description="테스트예약 실행관리 화면 호출")
	public void scheduleMng(){
	}
	
	/**
	 * 
	 * <p>
	 * [팝업]테스트 예약설정 수정 화면을 호출한다.
	 * <p>
	 * @param scheduleMngDto 테스트예약실행관리DTO
	 * @return ModelAndView
	 */
	@RequestMapping(value="msg.schedule.popModifySchedule.do")
	@LogInfo(description="[팝업]테스트 예약설정 수정 화면을 호출한다.")
	public ModelAndView popModifySchedule(ScheduleMngDto scheduleMngDto){
		ModelAndView mav = new ModelAndView();
		ScheduleMngDto result = scheduleMngBiz.getSchedule(scheduleMngDto);
		mav.addObject("result", result);
		return mav;
	}
	
	/**
	 * 
	 * <p>
	 * [팝업]테스트 예약설정 등록 화면을 호출한다.
	 * <p>
	 * @return
	 */
	@RequestMapping(value="msg.schedule.popRegisterSchedule.do")
	@LogInfo(description="[팝업]테스트 예약설정 등록 화면을 호출한다.")
	public void popRegisterSchedule(){
				
	}
	
	
	/**
	 * 
	 * <p>
	 * [팝업]테스트/시나리오 조회를 조회한다.
	 * <p>
	 * @param scheduleMngDto 테스트예약실행관리DTO
	 * @return ModelAndView
	 */
	@RequestMapping(value="msg.schedule.getListTestCase.do")
	@LogInfo(description="[팝업]테스트/시나리오 조회를 조회한다.")
	public ModelAndView getListTestCase(ScheduleMngDto scheduleMngDto){
		ModelAndView mav = new ModelAndView();
		Map<String, Object> scheduleList = scheduleMngBiz.getListTestCase(scheduleMngDto);
		mav.addAllObjects(scheduleList);
		mav.setViewName("jsonView");
		return mav;
	}
	
	
	/**
	 * 
	 * <p>
	 * [팝업]테스트예약설정 등록한다.
	 * <p>
	 * @param request HttpServletRequest
	 * @param scheduleMngDto 테스트예약실행관리DTO
	 * @return ModelAndView
	 */
	@RequestMapping(value="msg.schedule.registerSchedule.do")
	@LogInfo(description="[팝업]테스트예약설정 등록한다.")
	public ModelAndView registerSchedule(HttpServletRequest request, ScheduleMngDto scheduleMngDto){
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		LoginDto sessionInfo = (LoginDto) session.getAttribute("userinfo");
		String dateString = DateUtil.getDateString();

		scheduleMngDto.setLastModfiId(sessionInfo.getUsrid());
		scheduleMngDto.setLastModfiYms(dateString);
		scheduleMngDto.setCretnYms(dateString);
		scheduleMngDto.setJobExeStusCd("01");
		scheduleMngDto.setWriteId(sessionInfo.getUsrid());
		scheduleMngDto.setWriteName(sessionInfo.getUsrname());
		
		if (logger.isDebugEnabled()) logger.debug("ScheduleMngDto : [" + scheduleMngDto + "]");
		scheduleMngBiz.registerSchedule(scheduleMngDto);
		mav.addObject("return", "success");
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * 
	 * <p>
	 * 테스트 예약설정을 수정한다.
	 * <p>
	 * @param request HttpServletRequest
	 * @param scheduleMngDto 테스트예약실행관리DTO
	 * @return ModelAndView
	 */
	@RequestMapping(value="msg.schedule.modifySchedule.do")
	@LogInfo(description="테스트 예약설정을 수정한다.")
	public ModelAndView modifySchedule(HttpServletRequest request, ScheduleMngDto scheduleMngDto){
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		LoginDto sessionInfo = (LoginDto) session.getAttribute("userinfo");
		scheduleMngDto.setLastModfiId(sessionInfo.getUsrid());
		scheduleMngDto.setLastModfiYms(DateUtil.getDateString());
		scheduleMngBiz.modifySchedule(scheduleMngDto);
		mav.addObject("return", "success");
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * 
	 * <p>
	 * 예약등록관리 목록을 조회한다.
	 * <p>
	 * @param scheduleMngDto 테스트예약실행관리DTO
	 * @return ModelAndView
	 */
	@RequestMapping(value="msg.schedule.getListSchedule.do")
	@LogInfo(description="예약등록관리 목록을 조회한다.")
	public ModelAndView getListSchedule(ScheduleMngDto scheduleMngDto) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> scheduleList = scheduleMngBiz.getListSchedule(scheduleMngDto);
		mav.addAllObjects(scheduleList);
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * 
	 * <p>
	 * 예약등록관리 목록을 삭제한다.
	 * <p>
	 * @param jgGridData 삭제할 그리드의 JSON String
	 * @return ModelAndView
	 */
	@RequestMapping(value="msg.schedule.deleteSchedule.do")
	@LogInfo(description="예약등록관리 목록을 삭제한다.")
	public ModelAndView deleteSchedule(@RequestParam("jgGridData") String jgGridData) {
		ModelAndView mav = new ModelAndView();
		JSONArray jsonArray = JSONArray.fromObject(jgGridData);
		for (Object object : jsonArray) { 
			ScheduleMngDto scheduleMngDto = (ScheduleMngDto) JSONObject.toBean((JSONObject) object, ScheduleMngDto.class);
			scheduleMngBiz.deleteSchedule(scheduleMngDto);
		}
		mav.addObject("return", "success");
		mav.setViewName("jsonView");
		return mav;
	}
	
	
}
