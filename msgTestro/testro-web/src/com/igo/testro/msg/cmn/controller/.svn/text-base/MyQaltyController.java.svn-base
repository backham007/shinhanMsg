package com.igo.testro.msg.cmn.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.cmn.login.LoginCheck;
import com.igo.testro.cmn.login.dto.LoginDto;
import com.igo.testro.cmn.utils.DateUtil;
import com.igo.testro.msg.cmn.biz.MyQaltyBiz;
import com.igo.testro.msg.cmn.dto.MyQaltyDto;
import com.igo.testro.preference.TestroPreference;

/**
 * <p>
 * 프로그램명:MyQaltyController.java<br/>
 * 설명 : 나의 프로젝트 정보설정<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */
@Controller
public class MyQaltyController {
	
	@Autowired
	private MyQaltyBiz myQaltyBiz;
	
	@Autowired
	private LoginCheck loginCheck;
	
	/**
	 * <p>
	 * 메소드 설명 : 나의 프로젝트 정보설정
	 * <p> 
	 * @param request,response
	 * @return mav
	 */
	@RequestMapping("msg.myQalty.myQalty.do")
	@LogInfo(description="나의 프로젝트 정보설정")
	public ModelAndView viewMemberList(HttpSession session){
		ModelAndView mav = new ModelAndView();
		ModelMap modelMap = new ModelMap();
		String[] mciPropArray = TestroPreference.getInstance().getProperty("CONN_SEVER_LIST", TestroPreference.USER).split(",");
		List mciArray = new ArrayList();
		for(int i =0; i < mciPropArray.length; i++){
			Map mciPropMap = new HashMap();
			String[] splitname = mciPropArray[i].split(":");
			mciPropMap.put("key", splitname[0]);
			mciPropMap.put("val", splitname[1]);
			mciArray.add(mciPropMap);
		}
		
		modelMap.addAttribute("mciPropArray", mciPropArray);
		mav.addObject("mciArray", mciArray);
		
		return mav;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 나의 프로젝트 환경설정
	 * <p> 
	 * @param request,response
	 * @return mav
	 */
	@RequestMapping("msg.myConfiguration.myConfiguration.do")
	@LogInfo(description="나의 프로젝트  환경설정")
	public ModelAndView myConfiguration(HttpSession session){
		ModelAndView mav = new ModelAndView();
		ModelMap modelMap = new ModelMap();
		String[] mciPropArray = TestroPreference.getInstance().getProperty("CONN_SEVER_LIST", TestroPreference.USER).split(",");
		List mciArray = new ArrayList();
		for(int i =0; i < mciPropArray.length; i++){
			Map mciPropMap = new HashMap();
			String[] splitname = mciPropArray[i].split(":");
			mciPropMap.put("key", splitname[0]);
			mciPropMap.put("val", splitname[1]);
			mciArray.add(mciPropMap);
		}
		
		modelMap.addAttribute("mciPropArray", mciPropArray);
		mav.addObject("mciArray", mciArray);
		
		return mav;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 나의 프로젝트 단계정보 조회
	 * <p> 
	 * @param request,response
	 * @return mav
	 */
	@RequestMapping("msg.GetMyQaltyAction.myQalty.do")
	@LogInfo(description="나의 프로젝트 단계정보 조회")
	public ModelAndView getlist(HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView mav = new ModelAndView();

		mav.addAllObjects(myQaltyBiz.getlist(request));
		mav.setViewName("jsonView");

		return mav;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 프로젝트 정보 설정 저장
	 * <p> 
	 * @param session,request,detailDTO,jgGridData
	 * @return mav
	 */
	@RequestMapping("msg.RegisterMyQaltyAction.myQalty.do")
	@LogInfo(description="프로젝트 정보 설정 저장")
	public ModelAndView applyProject(HttpSession session, HttpServletRequest request, MyQaltyDto detailDTO,@RequestParam("jgGridData") String jgGridData){	
		
		JSONObject jsonArray = JSONObject.fromObject(jgGridData);
		
		detailDTO.setProjNo((String)jsonArray.get("projNo"));
		detailDTO.setProjName((String)jsonArray.get("projName"));
		detailDTO.setTestStgeName((String)jsonArray.get("testStgeName"));
		detailDTO.setTestStartYMS(((String)jsonArray.get("testStartYMS")).replace("-", "") + "000000");
		detailDTO.setTestEndYMS(((String)jsonArray.get("testEndYMS")).replace("-", "") + "235959");
		detailDTO.setLastModfiYMS(DateUtil.getDateString());
		detailDTO.setLastModfiEmpid(request.getParameter("usrId"));
		detailDTO.setConnSevrDstcd(request.getParameter("connSevrDstcd"));
		myQaltyBiz.registerMyQaltyInfo(detailDTO);	
		
		//세션 저장
		LoginDto userinfo = (LoginDto)session.getAttribute("userinfo");
		userinfo.setProjno((String)jsonArray.get("projNo"));
		userinfo.setProjname((String)jsonArray.get("projName"));
		userinfo.setTeststartyms(((String)jsonArray.get("testStartYMS")).replace("-", "") + "000000");
		userinfo.setTestendyms(((String)jsonArray.get("testEndYMS")).replace("-", "") + "235959");
		userinfo.setTeststgename((String)jsonArray.get("testStgeName"));
		
		String connSevrDstcd = detailDTO.getConnSevrDstcd();
		//테스트대상 시스템이 설정 되어 있지 않을 경우 기본 01 개발로 해준다.
		if("".equals(connSevrDstcd)){
			String[] mciPropArray = TestroPreference.getInstance().getProperty("CONN_SEVER_LIST", TestroPreference.USER).split(",");
			String[] splitname = mciPropArray[0].split(":");
			userinfo.setConnsevrdstcd(splitname[0]);
			userinfo.setConnsevrdstcdnm(splitname[1]);
		}
		loginCheck.setLoginInfo(request, userinfo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 테스트 환경설정 저장
	 * <p> 
	 * @param session,request,response
	 * @return mav
	 */
	@RequestMapping("msg.RegisterTestEnviAction.myQalty.do")
	@LogInfo(description="테스트 환경설정 저장")
	public ModelAndView configurationProject(HttpSession session, HttpServletRequest request, MyQaltyDto detailDTO){	
		
		LoginDto userinfo = (LoginDto)session.getAttribute("userinfo");

		detailDTO.setConnSevrDstcd(request.getParameter("connSevrDstcd"));
		detailDTO.setLastModfiEmpid(request.getParameter("usrId"));
		detailDTO.setLastModfiYMS(DateUtil.getDateString());
		myQaltyBiz.registerTestEnvi(detailDTO);
		
		userinfo.setConnsevrdstcd(detailDTO.getConnSevrDstcd());
		userinfo.setConnsevrdstcdnm(request.getParameter("connSevrDstcdnm"));
		loginCheck.setLoginInfo(request, userinfo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsonView");
		return mav;

	}

	/**
	 * <p>
	 * 메소드 설명 : 프로젝트 삭제
	 * <p> 
	 * @param request,response,detailDTO
	 * @return mav
	 */
	@RequestMapping("msg.getProjectDelete.MyQalty.do")
	@LogInfo(description="프로젝트 삭제")
	public ModelAndView getProjectDelete(HttpServletRequest request, HttpServletResponse response, MyQaltyDto detailDTO){	
		
		ModelAndView mav = new ModelAndView();
		detailDTO.setProjNo(request.getParameter("projNo"));
		detailDTO.setTestStgeName(request.getParameter("testStgeName"));
		
		mav.addObject("ProjCheck",myQaltyBiz.getProjectDelete(detailDTO));
		mav.setViewName("jsonView");
		return mav;
	}
}
