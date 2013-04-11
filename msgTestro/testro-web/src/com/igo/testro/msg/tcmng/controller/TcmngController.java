package com.igo.testro.msg.tcmng.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.igo.testro.anot.LogInfo;
import com.igo.testro.cmn.login.LoginCheck;
import com.igo.testro.cmn.login.dto.LoginDto;
import com.igo.testro.cmn.utils.StringUtil;
import com.igo.testro.msg.layout.biz.ILayoutBiz;
import com.igo.testro.msg.layout.dto.LayoutDetailDto;
import com.igo.testro.msg.layout.dto.LayoutDto;
import com.igo.testro.msg.tcmng.biz.TcmngBiz;
import com.igo.testro.msg.tcmng.dto.CheckPointDTO;
import com.igo.testro.msg.tcmng.dto.TcDto;
import com.igo.testro.preference.TestroPreference;


/**
 * <p>
 * 프로그램명:TcmngController.java<br/>
 * 설명 : <br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 18. : ksj : 내용
 * </ul> 
 * </p>
 */
@Controller
public class TcmngController {
	
	@Autowired
	private TcmngBiz tcmngBiz;
	
	@Autowired
	private ILayoutBiz layoutBiz;
	
	
	
	/**
	 * <p>
	 * 테스트케이스 관리 화면 호출
	 * </p>
	 * @param	request
	 * @return	ModelAndView
	 */
	@LogInfo(description="테스트케이스관리 화면을 호출합니다.")
	@RequestMapping("msg.tcmng.tcmng.do")
	public ModelAndView memberList(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		Map returnMap 	= new HashMap();	//리턴값들을 담은 Map
		TcDto tcDto = new TcDto();
		
		if(request.getParameter("tsCaseID") != null){
			tcDto = tcmngBiz.getTcInfo((String)request.getParameter("tsCaseID"));
			
			if(tcDto != null){
				returnMap.put("tranCd", 	tcDto.getTranCd());
				returnMap.put("tranName", 	tcDto.getTranName());
				returnMap.put("chnlDstcd", 	tcDto.getChnlDstcd());
				returnMap.put("tsCaseID", 	tcDto.getTsCaseID());
				returnMap.put("tsCaseName", tcDto.getTsCaseName());
				returnMap.put("tsCaseDesc", tcDto.getTsCaseDesc());
			}
		}
		
		returnMap.put("tcDataMaxCnt", TestroPreference.getInstance().getProperty("TC_DATA_MAX_CNT", TestroPreference.USER)); //테스트케이스 테스트데이터 최대등록건수
		
		mv.addAllObjects(returnMap);
		mv.setViewName("msg/tcmng/tcmng");
		return mv;
	}
	

	/**
	 * <p>
	 * 기본 테스트 데이터 출력
	 * </p>
	 * @param	chnlDstcd 	채널코드
	 * @param	tranCd 		거래코드
	 * @return	ModelAndView
	 */
	@LogInfo(description="기본테스트데이터를 조회 합니다.")
	@RequestMapping("msg.tcmng.getBasicsData.do")
	public ModelAndView getBasicsData(@RequestParam("chnlDstcd")String chnlDstcd, @RequestParam("tranCd")String tranCd){
		List<LayoutDetailDto> HLayoutDetailDtoList = new ArrayList<LayoutDetailDto>(); 
		List<LayoutDetailDto> ILayoutDetailDtoList = new ArrayList<LayoutDetailDto>(); 
		List<LayoutDetailDto> layoutDetailDtoList = new ArrayList<LayoutDetailDto>(); 
		LayoutDto rstLayoutDto = new LayoutDto();	//layOut을 담음
		ModelAndView mv = new ModelAndView();
		Map parmMap 	= new HashMap();	//파라미터를 담은 Map
		Map returnMap 	= new HashMap();	//리턴값들을 담은 Map
		
		LayoutDto layoutDto = layoutBiz.getLayout(chnlDstcd, tranCd, "I");
		
		//기본데이터 그리드 레이아웃 만들기
		if(layoutDto != null){
			HLayoutDetailDtoList = layoutDto.getHeaderList();

			//헤더부 레이아웃
			if(HLayoutDetailDtoList.size() > 0){
				for(int i = 0; HLayoutDetailDtoList.size() > i; i++ ){
					if(HLayoutDetailDtoList.get(i).getRptName() == null || "".equals(HLayoutDetailDtoList.get(i).getRptName())){
						layoutDetailDtoList.add(HLayoutDetailDtoList.get(i));
					}
				}
			}
			
			ILayoutDetailDtoList = layoutDto.getInviList();
			//개별부 레이아웃
			if(ILayoutDetailDtoList.size() > 0){
				for(int i = 0; ILayoutDetailDtoList.size() > i; i++ ){
					if(ILayoutDetailDtoList.get(i).getRptName() == null || "".equals(ILayoutDetailDtoList.get(i).getRptName())){
						layoutDetailDtoList.add(ILayoutDetailDtoList.get(i));
					}
				}
			}
		}
		
		rstLayoutDto.setDetailAllList(layoutDetailDtoList);
		
		parmMap.put("chnlDstcd", chnlDstcd);
		parmMap.put("tranCd", tranCd);
		//기본 테스트데이터 가져오기
		Map basicsTestData = tcmngBiz.getBasicsData(parmMap);
		
		returnMap.put("layout", rstLayoutDto);
		returnMap.put("rows",  JSONObject.fromObject(basicsTestData).toString());
		
		mv.addAllObjects(returnMap);
		mv.setViewName("msg/tcmng/tcmngBasicsGrid");
		return mv;
	}
	
	
	/**
	 * <p>
	 * default Layout 가져오기
	 * </p>
	 * @param	chnlDstcd	채널코드
	 * @param	tranCd		거래코드
	 * @return	ModelAndView
	 */
	@LogInfo(description="레이아웃정보를 조회 합니다.")
	@RequestMapping("msg.tcmng.getLayoutDefault.do")
	public ModelAndView getLayoutDefault(@RequestParam("chnlDstcd")String chnlDstcd, @RequestParam("tranCd")String tranCd){
		List<LayoutDetailDto> HLayoutDetailDtoList = new ArrayList<LayoutDetailDto>(); 
		List<LayoutDetailDto> ILayoutDetailDtoList = new ArrayList<LayoutDetailDto>(); 
		List<LayoutDetailDto> layoutDetailDtoList = new ArrayList<LayoutDetailDto>();
		LayoutDto rstLayoutDto = new LayoutDto();
		ModelAndView mv = new ModelAndView();
		Map returnMap = new HashMap();
		
		LayoutDto layoutDto = layoutBiz.getLayout(chnlDstcd, tranCd, "I");
		
		//기본데이터 그리드 레이아웃 만들기
		if(layoutDto != null){
			HLayoutDetailDtoList = layoutDto.getHeaderList();

			//헤더부 레이아웃
			if(HLayoutDetailDtoList.size() > 0){
				for(int i = 0; HLayoutDetailDtoList.size() > i; i++ ){
					if(HLayoutDetailDtoList.get(i).getRptName() == null || "".equals(HLayoutDetailDtoList.get(i).getRptName())){
						layoutDetailDtoList.add(HLayoutDetailDtoList.get(i));
					}
				}
			}
			
			ILayoutDetailDtoList = layoutDto.getInviList();
			//개별부 레이아웃
			if(ILayoutDetailDtoList.size() > 0){
				for(int i = 0; ILayoutDetailDtoList.size() > i; i++ ){
					if(ILayoutDetailDtoList.get(i).getRptName() == null || "".equals(ILayoutDetailDtoList.get(i).getRptName())){
						layoutDetailDtoList.add(ILayoutDetailDtoList.get(i));
					}
				}
			}
		}
		
		rstLayoutDto.setDetailAllList(layoutDetailDtoList);
		
		returnMap.put("layout", rstLayoutDto);
		
		mv.addAllObjects(returnMap);
		mv.setViewName("msg/tcmng/tcmngDefaultGrid");
		return mv;
	}
	
	/**
	 * <p>
	 * 테스트케이스의 데이터 가져오기
	 * </p>
	 * @param	tsCaseID	테스트케이스ID
	 * @param	chnlDstcd	채널코드
	 * @param	tranCd		거래코드
	 * @return	ModelAndView
	 */
	@LogInfo(description="테스트케이스의 테스트데이터 목록을 조회 합니다.")
	@RequestMapping("msg.tcmng.getChkTcInfo.do")
	public ModelAndView getChkTcInfo(@RequestParam("tsCaseID")String tsCaseID, @RequestParam("chnlDstcd")String chnlDstcd, @RequestParam("tranCd")String tranCd){
		ModelAndView mv = new ModelAndView();
		Map returnMap = new HashMap();
		List<Map> testDataMapList = tcmngBiz.getChkTcInfo(tsCaseID);
		
		LayoutDto rstLayoutDto = new LayoutDto();
		List<LayoutDetailDto> HLayoutDetailDtoList = new ArrayList<LayoutDetailDto>(); 
		List<LayoutDetailDto> ILayoutDetailDtoList = new ArrayList<LayoutDetailDto>();
		List<LayoutDetailDto> layoutDetailDtoList = new ArrayList<LayoutDetailDto>();
		
		LayoutDto layoutDto = layoutBiz.getLayout(chnlDstcd, tranCd, "I");
		
		//기본데이터 그리드 레이아웃 만들기
		if(layoutDto != null){
			HLayoutDetailDtoList = layoutDto.getHeaderList();

			//헤더부 레이아웃
			if(HLayoutDetailDtoList.size() > 0){
				for(int i = 0; HLayoutDetailDtoList.size() > i; i++ ){
					if(HLayoutDetailDtoList.get(i).getRptName() == null || "".equals(HLayoutDetailDtoList.get(i).getRptName())){
						layoutDetailDtoList.add(HLayoutDetailDtoList.get(i));
					}
				}
			}
			
			ILayoutDetailDtoList = layoutDto.getInviList();
			//개별부 레이아웃
			if(ILayoutDetailDtoList.size() > 0){
				for(int i = 0; ILayoutDetailDtoList.size() > i; i++ ){
					if(ILayoutDetailDtoList.get(i).getRptName() == null || "".equals(ILayoutDetailDtoList.get(i).getRptName())){
						layoutDetailDtoList.add(ILayoutDetailDtoList.get(i));
					}
				}
			}
		}
		
		rstLayoutDto.setDetailAllList(layoutDetailDtoList);
		
		returnMap.put("layout", rstLayoutDto);
		returnMap.put("rows",  JSONSerializer.toJSON(testDataMapList).toString());
		mv.addAllObjects(returnMap);
		mv.setViewName("msg/tcmng/tcmngGrid");
		return mv;
	}
	
	/**
	 * <p>
	 *  테스트케이스추가시 그리드에 매핑시킬 데이터들을 map에 담기
	 * </p>
	 * @param	request
	 * @return	ModelAndView
	 */
	@LogInfo(description="테스트케이스의 테스트데이터 목록을 조회 합니다.")
	@RequestMapping("msg.tcmng.getTcmngAddList.do")
	public ModelAndView getTcmngAddList(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		List gridDataList = tcmngBiz.getTcmngAddList(request);
		
		mv.addObject("gridDataList", gridDataList);
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	 * <p>
	 * 테스트케이스 저장 팝업 호출
	 * </p>
	 * @param
	 * @return	ModelAndView
	 */
	@LogInfo(description="테스트케이스의 저장 팝업을 호출합니다.")
	@RequestMapping("msg.tcmng.tcmngReg.do")
	public ModelAndView regTcmngPop(){
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("msg/tcmng/tcmngReg");
		return mv;
	}
	
	
	/**
	 * <p>
	 * 테스트케이스의 저장 
	 * </p>
	 * @param	request
	 * @param	session
	 * @return	ModelAndView
	 */
	@LogInfo(description="테스트케이스를 저장합니다.")
	@RequestMapping("msg.tcmng.doTcSave.do")
	public ModelAndView doTcSave(HttpServletRequest request, HttpSession session) throws Exception{
		LoginDto loginDto = (LoginDto) session.getAttribute(LoginCheck.USERINFO);
		ModelAndView mv = new ModelAndView();

		mv.addAllObjects(tcmngBiz.doTcSave(request, loginDto));
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	 * <p>
	 * 테스트케이스의 실행
	 * </p>
	 * @param	request
	 * @return	ModelAndView
	 */
	@LogInfo(description="테스트케이스를 실행 합니다.")
	@RequestMapping("msg.tcmng.excuteTc.do")
	public ModelAndView firstExcuteTc(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		
		Map returnMap = tcmngBiz.firstExcuteTc(request);
		
		mv.addObject("acmplNth", returnMap.get("acmplNth"));
		mv.addObject("sussYN", returnMap.get("sussYN"));
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * <p>
	 * 테스트데이터의 체크포인트 조회
	 * </p>
	 * @param	request
	 * @return	ModelAndView
	 */
	@LogInfo(description="테스트데이터의 체크포인트를 조회 합니다.")
	@RequestMapping("msg.tcmng.getListTesCheck.do")
	public ModelAndView getTesCheck(HttpServletRequest request){
		String chnlDstcd =request.getParameter("chnlDstcd");
		String tranCd =request.getParameter("tranCd");
		String tsdataID =request.getParameter("tsdataID");
		String chkYNVal =request.getParameter("chkYNVal");
		List<LayoutDetailDto> HLayoutDetailDtoList = new ArrayList<LayoutDetailDto>(); 
		List<LayoutDetailDto> ILayoutDetailDtoList = new ArrayList<LayoutDetailDto>(); 
		List<LayoutDetailDto> layoutDetailDtoList = new ArrayList<LayoutDetailDto>();
		LayoutDto rstLayoutDto = new LayoutDto();	//layOut을 담음
		ModelAndView mv = new ModelAndView();
		Map parmMap 	= new HashMap();	//파라미터를 담은 Map
		Map returnMap 	= new HashMap();	//리턴값들을 담은 Map
		
		LayoutDto layoutDto = layoutBiz.getLayout(chnlDstcd, tranCd, "O");
		
		ArrayList<CheckPointDTO> checkPointDTOs = new ArrayList<CheckPointDTO>();
		
		if(chkYNVal != null && !"".equals(chkYNVal) && !"\"\"".equals(chkYNVal)){
			JSONArray jsonArray = JSONArray.fromObject(chkYNVal);
			
			int chkNO = 0;
			
			//레이아웃에 맞춰 체크포인트 DTO구성
			for(LayoutDetailDto layoutDetailDto : layoutDto.getHeaderList()){
				
				//반복부 필드는 체크포인트로 활용하지 않음
				if(!StringUtil.isEmptyString(layoutDetailDto.getRptName())){
					continue;
				}
				
				boolean findFlag = false;	//레이아웃에 테스트데이터가 존재하는지 여부
				
				for(Object o : jsonArray){
					CheckPointDTO dto = (CheckPointDTO) JSONObject.toBean(JSONObject.fromObject(o), CheckPointDTO.class);
					
					if(layoutDetailDto.getFldName().equals(dto.getTsdataFldName())){
						dto.setChkNO(chkNO++);
						checkPointDTOs.add(dto);
						findFlag = true;
						break;
					}
				}
				
				if(findFlag == false){	//체크포인트 데이터에 없는 레이아웃은 체크포인트에 추가한다
					CheckPointDTO dto = new CheckPointDTO();
					dto.setChkNO(chkNO++);
					dto.setTsdataFldName(layoutDetailDto.getFldName());
					dto.setChkPointExpcCtnt("");
					dto.setChkYN("");
					dto.setTscsFldDiv(layoutDetailDto.getFldDiv());
					dto.setTsdataFld(layoutDetailDto.getFldName()+"("+layoutDetailDto.getTscsFldDesc()+")");
					
					checkPointDTOs.add(dto);
				}
			}
			for(LayoutDetailDto layoutDetailDto : layoutDto.getInviList()){
				
				//반복부 필드는 체크포인트로 활용하지 않음
				if(!StringUtil.isEmptyString(layoutDetailDto.getRptName())){
					continue;
				}
				
				boolean findFlag = false;	//레이아웃에 테스트데이터가 존재하는지 여부
				
				for(Object o : jsonArray){
					CheckPointDTO dto = (CheckPointDTO) JSONObject.toBean(JSONObject.fromObject(o), CheckPointDTO.class);
					
					if(layoutDetailDto.getFldName().equals(dto.getTsdataFldName())){
						dto.setChkNO(chkNO++);
						checkPointDTOs.add(dto);
						findFlag = true;
						break;
					}
				}
				
				if(findFlag == false){	//체크포인트 데이터에 없는 레이아웃은 체크포인트에 추가한다
					CheckPointDTO dto = new CheckPointDTO();
					dto.setChkNO(chkNO++);
					dto.setTsdataFldName(layoutDetailDto.getFldName());
					dto.setChkPointExpcCtnt("");
					dto.setChkYN("");
					dto.setTscsFldDiv(layoutDetailDto.getFldDiv());
					dto.setTsdataFld(layoutDetailDto.getFldName()+"("+layoutDetailDto.getTscsFldDesc()+")");
					
					checkPointDTOs.add(dto);
				}
			}
		}
		
		if(checkPointDTOs.size() == 0){
			//테스트데이터 상세
			if(layoutDto != null){
				HLayoutDetailDtoList = layoutDto.getHeaderList();
	
				//헤더부 레이아웃
				if(HLayoutDetailDtoList.size() > 0){
					for(LayoutDetailDto layoutDetailDto : HLayoutDetailDtoList){
						
						//반복부 필드는 체크포인트로 활용하지 않음
						if(!StringUtil.isEmptyString(layoutDetailDto.getRptName())){
							continue;
						}
						
						layoutDetailDtoList.add(layoutDetailDto);
					}
				}
				
				ILayoutDetailDtoList = layoutDto.getInviList();
				//개별부 레이아웃
				if(ILayoutDetailDtoList.size() > 0){
					for(LayoutDetailDto layoutDetailDto : ILayoutDetailDtoList){
						
						//반복부 필드는 체크포인트로 활용하지 않음
						if(!StringUtil.isEmptyString(layoutDetailDto.getRptName())){
							continue;
						}
						
						layoutDetailDtoList.add(layoutDetailDto);
					}
				}
			}
			rstLayoutDto.setDetailAllList(layoutDetailDtoList);
			
			checkPointDTOs = tcmngBiz.getListCheckDTO(rstLayoutDto.getDetailAllList(), tsdataID);
			
//			for(CheckPointDTO dto : checkPointDTOs){
//				jsonArray.add(JSONObject.fromObject(dto));
//			}
		}
		
		//returnMap.put("rows",  JSONArray.fromObject(checkPointDTOs));
		mv.addObject("checkPointDTOs", checkPointDTOs);
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * <p>
	 * 체크포인트 팝업 호출
	 * </p>
	 * @param
	 * @return
	 */
	@LogInfo(description="체크포인트 팝업을 호출 합니다.")
	@RequestMapping("msg.tcmng.getTesCheck.do")
	public String openTesCheck(){
		return "msg/tcmng/tcmngTesCheck";
	}
	
	
	
}
