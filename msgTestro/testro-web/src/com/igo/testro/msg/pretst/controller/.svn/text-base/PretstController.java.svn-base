package com.igo.testro.msg.pretst.controller;


import java.io.UnsupportedEncodingException;
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
import com.igo.testro.cmn.utils.TransUtil;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.cmn.execute.biz.IExecuteBiz;
import com.igo.testro.msg.cmn.execute.dto.ExecuteDto;
import com.igo.testro.msg.layout.biz.ILayoutBiz;
import com.igo.testro.msg.layout.dto.LayoutDetailDto;
import com.igo.testro.msg.pretst.biz.PretstBiz;
import com.igo.testro.msg.pretst.dto.TesDataDto;
import com.igo.testro.msg.pretst.dto.TestDataDto;





@Controller
public class PretstController {
	
	@Autowired
	private IExecuteBiz executeBiz;
	
	@Autowired
	private ILayoutBiz layoutBiz;
	
	@Autowired
	private PretstBiz pretstBiz;
	
	ExecuteDto executeDto = new ExecuteDto();
	
	final ITestroLogger logger = TestroLogHelper.getBiz();
	/**
	 * 거래테스트 화면
	 */
	@RequestMapping("msg.pretst.pretst.do")
	public ModelAndView getlistPretst(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("msg/pretst/pretst");
		return mav;
	}
	
	
	/**
	 * 입력도우미 화면
	 */
	@RequestMapping("msg.pretst.createAutoData.do")
	public ModelAndView createAutoData(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("msg/pretst/createAutoData");
		return mav;
	}
	
	/**
	 * 테스트 실행
	 * @param chnlDstcd 채널구분코드
	 * @param tranCd 	거래코드
	 * @param fldData1 	헤더부  필드값
	 * @param fldData2 	개별부 필드값
	 * inputHexFlet 입력부원본데이터
	 * outputHexFlet 출력부원본데이터
	 * @throws UnsupportedEncodingException 
	 */
	@LogInfo(description="테스트 실행")
	@RequestMapping("msg.pretst.getPretstResult.do")
	public ModelAndView mciExecute(@RequestParam("tranName") String tranName,
									@RequestParam("chnlDstcd")String chnlDstcd, 
									@RequestParam("tranCd")String tranCd,
									HttpServletRequest request) throws UnsupportedEncodingException{
		String[] fldData1 = request.getParameterValues("fldData1");
		String[] fldData2 = request.getParameterValues("fldData2");
		
		LoginDto userinfoDto = (LoginDto)request.getSession(false).getAttribute(LoginCheck.USERINFO);
		TestDataDto testDataDto = new TestDataDto();
		testDataDto = pretstBiz.inviExecute(tranName,chnlDstcd,tranCd,fldData1,fldData2,request); //입력부 데이터 셋팅
		
		ModelAndView mv = new ModelAndView();
		String connsevrdstcd = userinfoDto.getConnsevrdstcd();    //접속서버구분코드 
		executeDto = executeBiz.mciExecute(connsevrdstcd, chnlDstcd, tranCd, testDataDto);
		String inputHexFlet = "";
		if(null != executeDto.getInputBytes()){
			inputHexFlet = new String(executeDto.getInputBytes(),"euc-kr");   //입력
		}
		String outputHexFlet = "";
		if(null != executeDto.getOutputBytes()){
			outputHexFlet = new String(executeDto.getOutputBytes(),"euc-kr"); //출력
		}
		mv.setViewName("msg/pretst/pretstResult");
		mv.addObject("executeDto", executeDto);
		mv.addObject("tranName", tranName);
		mv.addObject("inputHexFlet", inputHexFlet);    //입력 원본데이터
		mv.addObject("outputHexFlet", outputHexFlet);  //출력 원본데이터 
		return mv;
		    
	}
	
	
	
	/**
	 * 반복부 입력 화면
	 ** @param chnlDstcd 채널구분코드
	 * @param tranCd 거래코드
	 * @param fldDiv 필드구성(01:헤더,02:개별)
	 * @param fldName 필드명(반복회차의 필드명)
	 * 반복부필드를 조회후 반복부값을 셋팅
	 */
	@LogInfo(description="반복부 입력")
	@RequestMapping("msg.pretst.rptInput.do")
	public ModelAndView getRtInput(@RequestParam("chnlDstcd")String chnlDstcd, 
									@RequestParam("tranCd")String tranCd, 
									@RequestParam("fldDiv")String fldDiv, 
									@RequestParam("fldName")String fldName){
		ModelAndView mav = new ModelAndView();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<LayoutDetailDto> LayoutDetailDtoList = layoutBiz.getListRptLayout(chnlDstcd, tranCd, fldDiv, fldName);
		returnMap.put("rows", LayoutDetailDtoList); 
			
		mav.addAllObjects(returnMap);
		mav.addObject("fldName2", fldName);     //반복부fidName 한개 이상  반복부 구분
		mav.setViewName("msg/pretst/rptInput");
		return mav;
		
	} 
	
	
	/**
	 * 테스트 케이스 데이터 저장후 활용
	 * 같은 거래코드가 존재할시 TESDATA03,TESDATA04테이블에 해당  데이터를 삭제후 INSERT
	 */
	@LogInfo(description="테스트 케이스 데이터 저장후 활용")
	@RequestMapping("msg.pretst.excuteTcMng.do")
	public ModelAndView registerTcMng(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();   											//테스트케이스관리 - 데스트케이스 구성 리스트 사용
		LoginDto userinfoDto = (LoginDto)request.getSession(false).getAttribute(LoginCheck.USERINFO);
		
		TesDataDto tesDataDto = new TesDataDto(); 							//테스트기본 데이터 03TABLE
			tesDataDto.setChnlDstcd(request.getParameter("chnlDstcd"));		//채널구분
			tesDataDto.setTranCd(request.getParameter("tranCd"));			//거래코드
			tesDataDto.setTranName(request.getParameter("tranName"));		//거래명
			tesDataDto.setTsdataName(request.getParameter("tsdataName"));	//테스트케이스명
			tesDataDto.setTsdataDesc(request.getParameter("tsdataDesc"));   //테스트케이스설명
			tesDataDto.setWriteID(userinfoDto.getUsrid());					//작성자ID
			tesDataDto.setWriteName(userinfoDto.getUsrname());				//작성자명
			tesDataDto.setLastModfiID(userinfoDto.getUsrid());				//최종변경자ID
			tesDataDto.setLastModfiYMS(DateUtil.getDateString());			//최종변경일시
			String tsdataID = pretstBiz.registerTcMng(request,executeDto,tesDataDto); 
			map.put("tsDataID", tsdataID);									//테스트 기본 데이터 저장후 활용  테스트데이터ID
			map.put("chnlDstcd", request.getParameter("chnlDstcd"));		//테스트 기본 데이터 저장후 활용  채널구분코드
			map.put("tranCd", request.getParameter("tranCd"));				//테스트 기본 데이터 저장후 활용	 거래코드
			map.put("tranName", request.getParameter("tranName"));			//테스트 기본 데이터 저장후 활용  거래명

		mv.addAllObjects(map);
		mv.setViewName("msg/tcmng/tcmng");
		return mv;
	
	}

	
	
	/**
	 *  입력도우미
	 * HexString 가져오기
	 *
	 */
	@LogInfo(description="입력도우미")
	@RequestMapping("msg.pretst.hexString.do")
	public ModelAndView getRtInput(@RequestParam("hexName")String hexName ){
		ModelAndView mav = new ModelAndView();
		
		try {
			String hexString = TransUtil.byteArrayToHex(hexName.getBytes("euc-kr"));  //EUC-KR Decoder 변환
			mav.addObject("hexString", hexString);     								  //Return HexString
			mav.setViewName("jsonView");
			
		} catch (UnsupportedEncodingException e) {
			logger.error("", e);
			e.printStackTrace();
		}
		
		return mav;
		
	} 
	
	
}