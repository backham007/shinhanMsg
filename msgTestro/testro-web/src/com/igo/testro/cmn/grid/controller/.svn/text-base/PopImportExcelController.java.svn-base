package com.igo.testro.cmn.grid.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.igo.testro.anot.LogInfo;

/**
 * 
 * <p>
 * 프로그램명:PopImportExcelController.java<br/>
 * 설명 : 엑셀업로드 팝업 Controller<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 29. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
@Controller
public class PopImportExcelController {
	
	/**
	 * 
	 * <p>
	 * 엑셀 불러오기 팝업창 호출
	 * <p>
	 */
	@RequestMapping(value="cmn.grid.popImportExcel.do")
	@LogInfo(description="엑셀 불러오기 팝업창 호출")
	public ModelAndView popImportGrid(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("limitRowCnt", request.getParameter("limitRowCnt"));
		mav.addObject("tcDataMaxCnt", request.getParameter("tcDataMaxCnt"));
		return mav;
	}
}
