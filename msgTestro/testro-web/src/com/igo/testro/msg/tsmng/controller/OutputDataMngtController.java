package com.igo.testro.msg.tsmng.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.cmn.utils.StringUtil;
import com.igo.testro.msg.layout.biz.ILayoutBiz;
import com.igo.testro.msg.layout.dto.LayoutDetailDto;
import com.igo.testro.msg.layout.dto.LayoutDto;
import com.igo.testro.msg.tsmng.dto.IODataUseDTO;
import com.igo.testro.util.CharUtil;

/**
 * <p>
 * 프로그램명:OutputDataMngtController.java<br/>
 * 설명 : 입출력값 활용 Controller<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 21. : 김기태 : 최초작성
 * </ul> 
 * </p>
 */
@Controller
public class OutputDataMngtController {
	@Autowired
	private ILayoutBiz layoutBiz;
	
	/**
	 * <p>
	 * 입출력값 활용 팝업을 연다.
	 * <p>
	 * @param tsSnrioID 부모창에서 넘어온 테스트시나리오 아이디
	 * @param tsSnrioNO 부모창에서 넘어온 사용테스트데이터순번
	 * @param tsdataID 부모창에서 넘어온 테스트데이터 아이디
	 * @return 팝업창에 사용할 ModelMap
	 */
	@LogInfo(description="입출력값 활용 팝업을 연다.")
	@RequestMapping("msg.tsmng.outputdatamng.do")
	public ModelMap openOutputDataMng(
			@RequestParam("tsSnrioID")String tsSnrioID
			, @RequestParam("tsSnrioNO")String tsSnrioNO
			, @RequestParam("tsdataID")String tsdataID
			, @RequestParam("chnlDstcd")String chnlDstcd
			, @RequestParam("tranCd")String tranCd){
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("tsSnrioID", tsSnrioID);
		modelMap.addAttribute("tsSnrioNO", tsSnrioNO);
		modelMap.addAttribute("tsdataID", CharUtil.convUrlParam(tsdataID));
		modelMap.addAttribute("chnlDstcd", chnlDstcd);
		modelMap.addAttribute("tranCd", tranCd);
		
		return modelMap;
	}
	
	
	/**
	 * <p>
	 * 조건식 도움말 팝업을 연다.
	 * <p>
	 */
	@LogInfo(description="조건식 도움말 팝업을 연다.")
	@RequestMapping("msg.tsmng.popupHelp.do")
	public void openPopupHelp(){
	}
	
	/**
	 * <p>
	 * 컬럼조회 팝업을 연다
	 * <p>
	 * @param fldIO - 입출력값구분 정보
	 * @param chnlDstcd - 채널구분코드
	 * @param tranCd - 거래코드
	 * @param inputBoxName - 입출력값셀렉트박스이름
	 * @return ModelAndView
	 */
	@LogInfo(description="컬럼조회 팝업을 연다")
	@RequestMapping("msg.tsmng.openPopupColNameLst.do")
	public ModelAndView openPopupColNameLst(
			@RequestParam("fldIO")String fldIO
			, @RequestParam("chnlDstcd")String chnlDstcd
			, @RequestParam("tranCd")String tranCd
			, @RequestParam("inputBoxName")String inputBoxName){
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("fldIO", fldIO);
		mav.addObject("chnlDstcd", chnlDstcd);
		mav.addObject("tranCd", tranCd);
		mav.addObject("inputBoxName", inputBoxName);
		
		mav.setViewName("msg/tsmng/colNameLst");
		
		return mav;
	}
	
	/**
	 * <p>
	 * 컬럼정보를 가져온다.
	 * <p>
	 * @param fldIO - 입출력값구분 정보
	 * @param chnlDstcd - 채널구분코드
	 * @param tranCd - 거래코드
	 * @return ModelAndView
	 */
	@LogInfo(description="컬럼정보를 가져온다.")
	@RequestMapping("msg.tsmng.getMciIOMap.do")
	public ModelAndView getMciIOMap(
			@RequestParam("fldIO")String fldIO
			, @RequestParam("chnlDstcd")String chnlDstcd
			, @RequestParam("tranCd")String tranCd){
		
		LayoutDto layoutDto = layoutBiz.getLayout(chnlDstcd, tranCd, fldIO);
		
		/*
		Iterator<LayoutDetailDto> iter = layoutDto.getInviList().iterator();
		
		//반복부가 있는 개별부는 제거 한다.
		ArrayList<LayoutDetailDto> inviList = new ArrayList<LayoutDetailDto>();
		while (iter.hasNext()) {
			LayoutDetailDto dto = iter.next();
			String rptName = dto.getRptName();
			
			if(rptName != null && "".equals(rptName.trim())){
				inviList.add(dto);
			}else{
				inviList.add(dto);
			}
		}*/
		
		ArrayList<LayoutDetailDto> allList = new ArrayList<LayoutDetailDto>();
		
		String rptName = "";
		String newRptName = "";
		int rptCnt = 0;
		
		Iterator<LayoutDetailDto> iter = layoutDto.getHeaderList().iterator();
		while (iter.hasNext()) {
			LayoutDetailDto dto = iter.next();
			
			if("03".equals(dto.getFldAttrib())){
				rptName = dto.getFldName();
				newRptName = "RPT"+String.valueOf(rptCnt++);
			} else if(dto.getRptName() != null && rptName.equals(dto.getRptName())){
				dto.setRptName(newRptName);
			}
			
			allList.add(dto);
		}
		
		iter = layoutDto.getInviList().iterator();
		while (iter.hasNext()) {
			LayoutDetailDto dto = iter.next();
			
			if("03".equals(dto.getFldAttrib())){
				rptName = dto.getFldName();
				newRptName = "RPT"+String.valueOf(rptCnt++);
			} else if(dto.getRptName() != null && rptName.equals(dto.getRptName())){
				dto.setRptName(newRptName);
			}
			
			allList.add(dto);
		}
		
		ModelAndView mav = new ModelAndView();
//		mav.addObject("rows", inviList);
		mav.addObject("rows", allList);
		mav.addObject("layout", layoutDto);
		
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	/**
	 * <p>
	 * 개별부 일괄맵핑정보 조회
	 * <p>
	 * @param preChnlDstcd
	 * @param preTranCd
	 * @param preFldIO
	 * @param useChnlDstcd
	 * @param useTranCd
	 * @param useFldIO
	 * @return
	 */
	@LogInfo(description="개별부 일괄맵핑정보 조회")
	@RequestMapping("msg.tsmng.getListInviMapping.do")
	public ModelAndView getListInviMapping(
			@RequestParam("preChnlDstcd")String preChnlDstcd
			, @RequestParam("preTranCd")String preTranCd
			, @RequestParam("preFldIO")String preFldIO
			, @RequestParam("useChnlDstcd")String useChnlDstcd
			, @RequestParam("useTranCd")String useTranCd
			, @RequestParam("useFldIO")String useFldIO){
				
		LayoutDto preLayoutDto = layoutBiz.getLayout(preChnlDstcd, preTranCd, preFldIO);
		LayoutDto useLayoutDto = layoutBiz.getLayout(useChnlDstcd, useTranCd, useFldIO);
		List<IODataUseDTO> mappingList = new ArrayList<IODataUseDTO>(); 	
		
		for(LayoutDetailDto preLayoutDetailDto : preLayoutDto.getInviList()){
			for(LayoutDetailDto useLayoutDetailDto : useLayoutDto.getInviList()){
				if(preLayoutDetailDto.getFldName().equals(useLayoutDetailDto.getFldName()) &&
					"01".equals(preLayoutDetailDto.getFldAttrib()) &&
					"01".equals(useLayoutDetailDto.getFldAttrib()) &&
					StringUtil.isEmptyString(preLayoutDetailDto.getRptName()) &&
							StringUtil.isEmptyString(useLayoutDetailDto.getRptName())){
					
					IODataUseDTO iODataUseDTO = new IODataUseDTO();
					iODataUseDTO.setPreFldName(preLayoutDetailDto.getFldName());
					iODataUseDTO.setPreFldDesc(preLayoutDetailDto.getTscsFldDesc());
					iODataUseDTO.setUseFldName(useLayoutDetailDto.getFldName());
					iODataUseDTO.setUseFldDesc(useLayoutDetailDto.getTscsFldDesc());
					
					mappingList.add(iODataUseDTO);
					break;
				}
			}
		}
				
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", mappingList);
		
		mav.setViewName("jsonView");
		
		return mav;
	}
}
