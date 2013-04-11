package com.igo.testro.msg.flaw.controller;

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
import com.igo.testro.cmn.login.LoginCheck;
import com.igo.testro.cmn.login.dto.LoginDto;
import com.igo.testro.cmn.utils.DateUtil;
import com.igo.testro.msg.flaw.biz.FlawBiz;
import com.igo.testro.msg.flaw.dto.FlawDto;


/**
 * 
 * <p>
 * 프로그램명:FlawController.java<br/>
 * 설명 : 결함관리Controller<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 13. : KoJaeHyeong : 최초작성
 * </ul> 
 * </p>
 */
@Controller
public class FlawController {
	
	@Autowired
	private FlawBiz flawBiz;
	
	/**
	 * 
	 * <p>
	 * 보고서상세 - 결함관리화면호출
	 * <p>
	 * @return ModelAndView
	 */
	@LogInfo(description="보고서상세 - 결함관리화면")
	@RequestMapping("msg.flaw.flawMng.do")
	public ModelAndView flawMng(@RequestParam("tsDataId")String tsDataId, @RequestParam("tsDataAcmplnth")String acmplNth){
		ModelAndView mv = new ModelAndView();
		mv.addObject("tsDataId", tsDataId);
		mv.addObject("acmplNth", acmplNth);
		mv.setViewName("msg/flaw/flawMng");
		return mv;
	}
	
	/**
	 * 
	 * <p>
	 * 결함관리 조회
	 * <p>
	 * @param tsDataId 테스트데이터ID
	 * @param acmplNth 수행회차
	 * @return ModelAndView
	 */
	@LogInfo(description="결함관리 조회")
	@RequestMapping("msg.flaw.getListFlaw.do")
	public ModelAndView getListFlaw(@RequestParam("tsDataId")String tsDataId, @RequestParam("acmplNth")String acmplNth){
		List<FlawDto> flawDtoList = flawBiz.getListFlaw(tsDataId, acmplNth);
		
		Map outputMap = new HashMap();
		outputMap.put("rows",flawDtoList);
		
		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(outputMap);
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * 
	 * <p>
	 * 결함관리 신규
	 * <p>
	 * @param request HttpServletRequest
	 * @return ModelAndView
	 */
	@LogInfo(description="결함관리 신규")
	@RequestMapping("msg.flaw.registerFlaw.do")
	public ModelAndView registerFlaw(HttpServletRequest request){
		
		//세션정보
		LoginDto userinfoDto = (LoginDto)request.getSession(false).getAttribute(LoginCheck.USERINFO);
		
		FlawDto flawDto = new FlawDto();
		flawDto.setTsDataId(request.getParameter("tsDataId"));	//테스트데이터ID
		flawDto.setAcmplNth(request.getParameter("acmplNth"));	//수행회차
		flawDto.setTscsTranTypeCd(request.getParameter("tscsTranTypeCd"));	//거래유형코드
		flawDto.setTscsDefRnDstCd(request.getParameter("tscsDefRnDstCd"));	//결함유형코드
		flawDto.setDefSeverity(request.getParameter("defSeverity"));	//결함심각도
		flawDto.setPriActionsCd(request.getParameter("priActionsCd"));	//조치우선순위코드
		flawDto.setDefErrCd(request.getParameter("defErrCd"));	//결함에러코드
		flawDto.setDefErrPrg(request.getParameter("defErrPrg"));	//결함에러발생프로그램명
		flawDto.setTestOpinCtnt(request.getParameter("testOpinCtnt"));	//테스트의견내용(결함내용)
		flawDto.setDefDisusrId(request.getParameter("defDisusrId"));	//결함배분사용자ID
		flawDto.setDefDisusrNm(request.getParameter("defDisusrNm"));	//결함배분자명
		flawDto.setActUsrId(request.getParameter("actUsrId"));	//조치사용자ID
		flawDto.setActUsrNm(request.getParameter("actUsrNm"));	//조치사용자명
		flawDto.setDefCd(request.getParameter("defCd"));	//결함진행구분코드
		flawDto.setActCloseYMS(request.getParameter("actCloseYMS"));	//조치완료예정일시
		flawDto.setDefRegYMS(DateUtil.getDateString());	//결함등록일시
		flawDto.setDefRegId(userinfoDto.getUsrid());	//결함등록사용자ID
		flawDto.setDefRegNm(userinfoDto.getUsrname());	//결함등록자명
		flawDto.setLastModfiId(userinfoDto.getUsrid());	//최종변경사용자ID
		flawDto.setLastModfiYMS(DateUtil.getDateString());	//최종변경일시		
		
		//결함관리 신규등록
		flawBiz.registerFlaw(flawDto);
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * 
	 * <p>
	 * 결함관리 수정
	 * <p>
	 * @param request HttpServletRequest
	 * @return ModelAndView
	 */
	@LogInfo(description="결함관리 수정")
	@RequestMapping("msg.flaw.modifyFlaw.do")
	public ModelAndView modifyFlaw(HttpServletRequest request){
		
		//세션정보
		LoginDto userinfoDto = (LoginDto)request.getSession(false).getAttribute(LoginCheck.USERINFO);
		
		FlawDto flawDto = new FlawDto();
		flawDto.setTsDataId(request.getParameter("tsDataId"));	//테스트데이터ID
		flawDto.setAcmplNth(request.getParameter("acmplNth"));	//수행회차
		flawDto.setDefNo(request.getParameter("defNo"));	//결함일련번호
		flawDto.setTscsTranTypeCd(request.getParameter("tscsTranTypeCd"));	//거래유형코드
		flawDto.setTscsDefRnDstCd(request.getParameter("tscsDefRnDstCd"));	//결함유형코드
		flawDto.setDefSeverity(request.getParameter("defSeverity"));	//결함심각도
		flawDto.setPriActionsCd(request.getParameter("priActionsCd"));	//조치우선순위코드
		flawDto.setDefErrCd(request.getParameter("defErrCd"));	//결함에러코드
		flawDto.setDefErrPrg(request.getParameter("defErrPrg"));	//결함에러발생프로그램명
		flawDto.setTestOpinCtnt(request.getParameter("testOpinCtnt"));	//테스트의견내용(결함내용)
		flawDto.setDefDisusrId(request.getParameter("defDisusrId"));	//결함배분사용자ID
		flawDto.setDefDisusrNm(request.getParameter("defDisusrNm"));	//결함배분자명
		flawDto.setActUsrId(request.getParameter("actUsrId"));	//조치사용자ID
		flawDto.setActUsrNm(request.getParameter("actUsrNm"));	//조치사용자명
		flawDto.setDefCd(request.getParameter("defCd"));	//결함진행구분코드
		flawDto.setActCloseYMS(request.getParameter("actCloseYMS"));	//조치완료예정일시
		flawDto.setLastModfiId(userinfoDto.getUsrid());	//최종변경사용자ID
		flawDto.setLastModfiYMS(DateUtil.getDateString());	//최종변경일시		
		
		//결함관리 수정
		flawBiz.modifyFlaw(flawDto);
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * 
	 * <p>
	 * 결함관리 삭제
	 * <p>
	 * @param tsDataId 테스트데이터ID
	 * @param acmplNth 수행회차
	 * @param defNo 결함일련번호
	 * @return ModelAndView
	 */
	@LogInfo(description="결함관리 삭제")
	@RequestMapping("msg.flaw.deleteFlaw.do")
	public ModelAndView deleteFlaw(@RequestParam("tsDataId")String tsDataId, @RequestParam("acmplNth")String acmplNth, @RequestParam("defNo")String defNo){
		
		//결함관리 삭제
		flawBiz.deleteFlaw(tsDataId, acmplNth, defNo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * 
	 * <p>
	 * 보고서상세 - 결함조치화면
	 * <p>
	 * @return ModelAndView
	 */
	@LogInfo(description="보고서상세 - 결함조치화면")
	@RequestMapping("msg.flaw.flawTreat.do")
	public ModelAndView flawTreat(@RequestParam("tsDataId")String tsDataId, @RequestParam("tsDataAcmplnth")String acmplNth){
		ModelAndView mv = new ModelAndView();
		mv.addObject("tsDataId", tsDataId);
		mv.addObject("acmplNth", acmplNth);
		mv.setViewName("msg/flaw/flawTreat");
		return mv;
	}
	
	/**
	 * 
	 * <p>
	 * 결함조치 수정
	 * <p>
	 * @param request HttpServletRequest
	 * @return ModelAndView
	 */
	@LogInfo(description="결함조치 수정")
	@RequestMapping("msg.flaw.modifyTreat.do")
	public ModelAndView modifyTreat(HttpServletRequest request){
		
		//세션정보
		LoginDto userinfoDto = (LoginDto)request.getSession(false).getAttribute(LoginCheck.USERINFO);
		
		FlawDto flawDto = new FlawDto();
		flawDto.setTsDataId(request.getParameter("tsDataId"));	//테스트데이터ID
		flawDto.setAcmplNth(request.getParameter("acmplNth"));	//수행회차
		flawDto.setDefNo(request.getParameter("defNo"));	//결함일련번호
		
		flawDto.setDefDomainCd(request.getParameter("defDomainCd"));	 //결함발생영역코드
		flawDto.setDefCauseCd(request.getParameter("defCauseCd"));       //결함발생원인코드
		flawDto.setDefActContent(request.getParameter("defActContent")); //결함에러조치내용
		flawDto.setReTestYMS(request.getParameter("reTestYMS"));         //재테스트일시
		flawDto.setReTestRsult(request.getParameter("reTestRsult"));     //재테스트결과
		flawDto.setTreatFnshYn(request.getParameter("treatFnshYn"));     //조치완료여부
		flawDto.setTreatFnshYMS(DateUtil.getDateString());   			 //조치완료일시
		flawDto.setDefCd(request.getParameter("defCd"));	             //결함진행구분코드
		flawDto.setLastModfiId(userinfoDto.getUsrid());	                 //최종변경사용자ID
		flawDto.setLastModfiYMS(DateUtil.getDateString());	             //최종변경일시
		
		//결함조치 수정
		flawBiz.modifyTreat(flawDto);
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * 
	 * <p>
	 * 나의결함조회화면
	 * <p>
	 * @return ModelAndView
	 */
	@LogInfo(description="나의결함조회화면")
	@RequestMapping("msg.flaw.myFlawList.do")
	public ModelAndView myflawList(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("msg/flaw/myFlawList");
		return mv;
	}
	
	/**
	 * 
	 * <p>
	 * 나의재테스트조회화면
	 * <p>
	 * @return ModelAndView
	 */
	@LogInfo(description="나의재테스트조회화면")
	@RequestMapping("msg.flaw.myReTestList.do")
	public ModelAndView myReTestList(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("msg/flaw/myReTestList");
		return mv;
	}
	
	/**
	 * 
	 * <p>
	 * 나의테스트케이스결함조회
	 * <p>
	 * @param request HttpServletRequest
	 * @return ModelAndView
	 */
	@LogInfo(description="나의테스트케이스결함조회")
	@RequestMapping("msg.flaw.getListMyTCFlaw.do")
	public ModelAndView getListMyTCFlaw(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(flawBiz.getListMyTCFlaw(request));
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * 
	 * <p>
	 * 나의테스트시나리오결함조회
	 * <p>
	 * @param request HttpServletRequest
	 * @return ModelAndView
	 */
	@LogInfo(description="나의테스트시나리오결함조회")
	@RequestMapping("msg.flaw.getListMyTSFlaw.do")
	public ModelAndView getListMyTSFlaw(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(flawBiz.getListMyTSFlaw(request));
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * 
	 * <p>
	 * 나의테스트케이스재테스트 조회
	 * <p>
	 * @param request HttpServletRequest
	 * @return ModelAndView
	 */
	@LogInfo(description="나의테스트케이스재테스트 조회")
	@RequestMapping("msg.flaw.getListMyTCReTest.do")
	public ModelAndView getListMyTCReTest(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(flawBiz.getListMyTCReTest(request));
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * 
	 * <p>
	 * 나의테스트시나리오재테스트 조회
	 * <p>
	 * @param request HttpServletRequest
	 * @return ModelAndView
	 */
	@LogInfo(description="나의테스트시나리오재테스트 조회")
	@RequestMapping("msg.flaw.getListMyTSReTest.do")
	public ModelAndView getListMyTSReTest(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(flawBiz.getListMyTSReTest(request));
		mv.setViewName("jsonView");
		return mv;
	}
}
