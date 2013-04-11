package com.igo.testro.msg.layout.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.msg.layout.biz.ILayoutBiz;
import com.igo.testro.msg.layout.dto.LayoutDetailDto;
import com.igo.testro.msg.layout.dto.LayoutDto;


/**
 * 
 * <p>
 * 프로그램명:LayoutController.java<br/>
 * 설명 : 전문관리기<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 13. : KoJaeHyeong : 최초작성
 * </ul> 
 * </p>
 */
@Controller
public class LayoutController {
	@Autowired
	private ILayoutBiz layoutBiz;
	
	/**
	 * 
	 * <p>
	 * 전문관리화면
	 * <p>
	 * @return ModelAndView
	 */
	@LogInfo(description="전문관리화면")
	@RequestMapping("msg.layout.layoutMng.do")
	public ModelAndView layoutMng(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("msg/layout/layoutMng");
		return mv;
	}
	
	/**
	 * 
	 * <p>
	 * 전문저장팝업화면
	 * <p>
	 * @param request
	 * @return ModelAndView
	 */
	@LogInfo(description="전문저장팝업화면")
	@RequestMapping("msg.layout.registerLayoutPop.do")
	public ModelAndView newLayoutPop(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("msg/layout/registerLayoutPop");
		return mv;
	}
	
	/**
	 * 
	 * <p>
	 * 전문레이아웃조회
	 * <p>
	 * @param chnlDstcd 채널구분코드
	 * @param tranCd 거래코드
	 * @return ModelAndView
	 */
	@LogInfo(description="전문레이아웃조회")
	@RequestMapping("msg.layout.getLayout.do")
	public ModelAndView getLayout(@RequestParam("chnlDstcd")String chnlDstcd, @RequestParam("tranCd")String tranCd){
		LayoutDto layout = layoutBiz.getLayout(chnlDstcd, tranCd, null);
		
		Map outputMap = new HashMap();
		outputMap.put("rows",layout.getInviList());
		outputMap.put("layout",layout);
		
		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(outputMap);
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * 
	 * <p>
	 * 전문레이아웃 존재여부체크
	 * <p>
	 * @param chnlDstcd 채널구분코드
	 * @param tranCd 거래코드
	 * @return ModelAndView
	 */
	@LogInfo(description="전문레이아웃 존재여부체크")
	@RequestMapping("msg.layout.getLayoutCnt.do")
	public ModelAndView getLayoutCnt(@RequestParam("chnlDstcd")String chnlDstcd, @RequestParam("tranCd")String tranCd){
		LayoutDto layout = layoutBiz.getLayoutCnt(chnlDstcd, tranCd);
		
		Map outputMap = new HashMap();
		if(layout == null){
			outputMap.put("result","ok");
		} else {
			outputMap.put("result","fail");
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(outputMap);
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * 
	 * <p>
	 * 전문레이아웃저장
	 * <p>
	 * @param request HttpServletRequest
	 * @return ModelAndView
	 */
	@LogInfo(description="전문레이아웃저장")
	@RequestMapping("msg.layout.registerLayout.do")
	public ModelAndView registerLayout(HttpServletRequest request){
	
		//전문레이아웃DTO 기본 데이터 세팅
		LayoutDto layoutDto = new LayoutDto(); 
		layoutDto.setChnlDstcd(request.getParameter("chnlDstcd"));	//채널구분
		layoutDto.setTranCd(request.getParameter("tranCd"));	//거래코드
		layoutDto.setTranName(request.getParameter("tranName"));	//거래명
		layoutDto.setFldDiv(request.getParameter("fldDiv"));	//필드구성
		layoutDto.setRefTranCd(request.getParameter("refTranCd"));	//참조거래코드
		layoutDto.setWriteId(request.getParameter("writeId"));	//작성자ID
		layoutDto.setWriteName(request.getParameter("writeName"));	//작성자명
		layoutDto.setCretnYMS(request.getParameter("cretnYMS"));	//생성일시
		
		//전문레이아웃DTO 상세 데이터 세팅
		List<LayoutDetailDto> inviList = new ArrayList<LayoutDetailDto>();
		
		//그리드데이터 파싱
		JSONArray jsonArray = JSONArray.fromObject(request.getParameter("jgGridData"));
		for (Object object : jsonArray) {
			LayoutDetailDto layoutDetailDto = (LayoutDetailDto) JSONObject.toBean((JSONObject)object, LayoutDetailDto.class);
			inviList.add(layoutDetailDto);
		}
		
		//저장할 그리드데이터를 개별부상세리스트에 담는다
		layoutDto.setInviList(inviList);
		
		//전문레이아웃저장
		layoutBiz.registerLayout(request, layoutDto);
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * 
	 * <p>
	 * 전문레이아웃삭제
	 * <p>
	 * @param request HttpServletRequest
	 * @return ModelAndView
	 */
	@LogInfo(description="전문레이아웃삭제")
	@RequestMapping("msg.layout.deleteLayout.do")
	public ModelAndView deleteLayout(HttpServletRequest request){
		
		String chnlDstcd = request.getParameter("chnlDstcd");	//채널구분
		String tranCd = request.getParameter("tranCd");	//거래코드
		String tranName = request.getParameter("tranName");	//거래명
		
		layoutBiz.deleteLayout(request, chnlDstcd, tranCd, tranName);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * <p>
	 * 레이아웃 목록조회(팝업)
	 * <p>
	 * @param request HttpServletRequest
	 * @return ModelAndView
	 */
	@LogInfo(description="레이아웃 목록조회(팝업)")
	@RequestMapping("msg.layout.layout.do")
	public ModelAndView getListLayout(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.addObject("chnlDstcd", request.getParameter("chnlDstcd"));	//채널구분코드
		mav.addObject("fldDiv", request.getParameter("fldDiv"));	//헤더부, 개별부 조회 구분(all:모두,01:헤더부,02:개별부 기본값=02)
		mav.setViewName("msg/layout/layout");
		return mav;
	}

	/**
	 * <p>
	 * 레이아웃 목록조회(그리드)
	 * <p>
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	@LogInfo(description="레이아웃 목록조회(그리드)")
	@RequestMapping("msg.layout.getListLayout.do")
	public ModelAndView getListLayout(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		
		mav.addAllObjects(layoutBiz.getListLayout(request));
		mav.setViewName("jsonView");
		return mav;
	}



	/**
	 * <p>
	 * 전문레이아웃조회
	 * <p>
	 * @param chnlDstcd
	 * @param tranCd
	 * @return
	 */
	@LogInfo(description="전문레이아웃조회")
	@RequestMapping("msg.layout.getlayoutDiv.do")
	public ModelAndView getInviList(@RequestParam("chnlDstcd")String chnlDstcd, @RequestParam("tranCd")String tranCd){
		ModelMap modelMap = new ModelMap();
		ModelAndView mav = new ModelAndView();
		LayoutDto layout = layoutBiz.getLayout(chnlDstcd, tranCd, null);
		modelMap.addAttribute("layout", layout);
		mav.addObject("layout", layout);
		mav.addObject("fldDiv", layout.getFldDiv());
		mav.setViewName("msg/layout/layoutDiv"); 

		return mav;
	}
	
	/**
	 * 
	 * 거래테스트 조회
	 * 
	 * @param chnlDstcd
	 * @param tranCd
	 * 
	 */
	@LogInfo(description="거래테스트 조회")
	@RequestMapping("msg.layout.getPretstDiv.do")
	public ModelAndView getPretstList(@RequestParam("chnlDstcd")String chnlDstcd, @RequestParam("tranCd")String tranCd){
		ModelAndView mav = new ModelAndView();
		LayoutDto layout = layoutBiz.getLayout(chnlDstcd, tranCd, "I");
		
		String result = "OK"; 
		if(layout == null) result = "";
		
		mav.setViewName("msg/pretst/pretstDiv");
		mav.addObject("layout", layout);
		mav.addObject("result", result);
		return mav;
	}
}
