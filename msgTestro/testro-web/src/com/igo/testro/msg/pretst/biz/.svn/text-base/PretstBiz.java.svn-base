package com.igo.testro.msg.pretst.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import net.sf.ezmorph.bean.MorphDynaBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.igo.testro.cmn.login.LoginCheck;
import com.igo.testro.cmn.login.dto.LoginDto;
import com.igo.testro.cmn.utils.DateUtil;
import com.igo.testro.cmn.utils.TransUtil;
import com.igo.testro.exception.BizException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.cmn.biz.MngSeqIdBiz;
import com.igo.testro.msg.cmn.execute.dto.ExecuteDto;
import com.igo.testro.msg.layout.biz.ILayoutBiz;
import com.igo.testro.msg.layout.dto.LayoutDetailDto;
import com.igo.testro.msg.layout.dto.LayoutDto;
import com.igo.testro.msg.pretst.dao.PretstDao;
import com.igo.testro.msg.pretst.dto.TesDataDetailDto;
import com.igo.testro.msg.pretst.dto.TesDataDto;
import com.igo.testro.msg.pretst.dto.TestDataDetailDto;
import com.igo.testro.msg.pretst.dto.TestDataDto;


public class PretstBiz {
	@Autowired
	private PretstDao pretstDao;
	@Autowired
	private ILayoutBiz layoutBiz;
	@Autowired
	private MngSeqIdBiz mngSeqIdBiz;
	
	final ITestroLogger logger = TestroLogHelper.getBiz();
	/**
	 * 기본테스트 데이터 저장
	 *거래코드로 TESDATA03조회후 같은 값이 있으면 tsdataId를 받아옴
	 *같은거래코드가 있을시 TESDATA03에서 삭제
	 *tsdataId받아와서 TESDATA04에서 삭제 
	 *tsdataID키값  생성후 TESDATA03 TESDATA04 테이블에 값 셋팅
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public synchronized String registerTcMng(HttpServletRequest request ,ExecuteDto executeDto,TesDataDto tesDataDto)throws BizException{
		LoginDto userinfoDto = (LoginDto)request.getSession(false).getAttribute(LoginCheck.USERINFO);
		String tranCd=request.getParameter("tranCd");
		String tsdataIdNum = pretstDao.getTsdataID(tranCd);  	//거래코드있는지 확인하고  있으면  테스트데이터ID값 구하기
		if(tsdataIdNum == null){
			tsdataIdNum ="";
		}
		try{
			pretstDao.registerTcMngDelete(tranCd ,tsdataIdNum);  // 거래코드가 있으면 삭제 , 상세 테스트데이터ID 삭제
		}catch (Exception e) {
			logger.error("", e);
			throw  new  BizException("MSG_PRETST0005","",e);
		}
		String tsdataID = mngSeqIdBiz.getNewSeqId(MngSeqIdBiz.TEST_DATA3, MngSeqIdBiz.TYPE_MSG);  //테스트데이터ID 값구하기
		tesDataDto.setTsdataID(tsdataID);     		//테스트데이터ID값 셋팅
		try{
			pretstDao.registerTcMng(tesDataDto);    // 기본테이블 TESDATA03 insert
		}catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_PRETST0001","",e);
		}
		try{
			
			//상세테이블 insert
			List<TesDataDetailDto> headerList = new ArrayList<TesDataDetailDto>();
			List<TesDataDetailDto> inviList = new ArrayList<TesDataDetailDto>();
			tesDataDto.setHeaderList(headerList);
			tesDataDto.setInviList(inviList);
			TesDataDetailDto tesDto= new TesDataDetailDto();
			TestDataDto tesData = executeDto.getInputDto();
			List<TestDataDetailDto> tesHeaderList = tesData.getHeaderList();
			int index = 1; 
			
			//헤더부
				for(int i=0; i<tesHeaderList.size(); i++){
					TestDataDetailDto testDto = tesHeaderList.get(i);
					tesDto.setTsdataFldName(testDto.getTsdataFldName());  	//테스트데이터필드명
					tesDto.setTsdataFldData(testDto.getTsdataFldData());	//테스트데이터필드데이터
					tesDto.setTscsFldType(testDto.getTscsFldType());		//테스트데이터필드타입
					tesDto.setTscsFldAttrib(testDto.getTscsFldAttrib());	//테스트데이터필드속성
					tesDto.setTscsFldSizeCnt(testDto.getTscsFldSizeCnt());	//테스트데이터필드크기내용
					tesDto.setTscsFldDesc(testDto.getTscsFldDesc());		//테스트데이터필드설명
					tesDto.setLastModfiID(userinfoDto.getUsrid());			//최종변경자ID
					tesDto.setLastModfiYMS(DateUtil.getDateString());		//최종변경일시
					tesDto.setRptName(testDto.getRptName());				//반복부명
					tesDto.setRptCntName(testDto.getRptCntName());			//반복부전체회차필드명
					tesDto.setRptCnt(testDto.getRptCnt());					//반복부회차
					tesDto.setTscsFldDiv("01");								//테스트데이터필드구분(헤더부)
					tesDto.setTsdataID(tsdataID);							//테스트데이터ID
					tesDto.setTsdataNO(Integer.toString(index++));			//테스트데이터일련번호
					headerList.add(tesDto);
					pretstDao.registerTcMngDetail(tesDto);					//상세TESDATA04 INSERT
				}
				List<TestDataDetailDto> tesInviList = tesData.getInviList();
				//개별부
				for(int i=0; i<tesInviList.size(); i++){
					TestDataDetailDto testDto = tesInviList.get(i);
					
					tesDto.setTsdataFldName(testDto.getTsdataFldName());   	//테스트데이터필드명      
					tesDto.setTsdataFldData(testDto.getTsdataFldData());   	//테스트데이터필드데이터    
					tesDto.setTscsFldType(testDto.getTscsFldType());       	//테스트데이터필드타입     
					tesDto.setTscsFldAttrib(testDto.getTscsFldAttrib());   	//테스트데이터필드속성     
					tesDto.setTscsFldSizeCnt(testDto.getTscsFldSizeCnt()); 	//테스트데이터필드크기내용   
					tesDto.setTscsFldDesc(testDto.getTscsFldDesc());       	//테스트데이터필드설명     
					tesDto.setLastModfiID(userinfoDto.getUsrid());         	//최종변경자ID        
					tesDto.setLastModfiYMS(DateUtil.getDateString());      	//최종변경일시         
					tesDto.setRptName(testDto.getRptName());               	//반복부명           
					tesDto.setRptCntName(testDto.getRptCntName());         	//반복부전체회차필드명     
					tesDto.setRptCnt(testDto.getRptCnt());                 	//반복부회차          
					tesDto.setTscsFldDiv("02");                            	//테스트데이터필드구분    (개별부) 
					tesDto.setTsdataID(tsdataID);                          	//테스트데이터ID       
					tesDto.setTsdataNO(Integer.toString(index++));         	//테스트데이터일련번호     
					inviList.add(tesDto);
					pretstDao.registerTcMngDetail(tesDto);				   	//상세TESDATA04 INSERT
				}
				return tsdataID;
		}catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_PRETST0002","",e);
		}
		
		
	}

	
	/**
	 * 
	 * <p>
	 * 테스트실행 반복부입력
	 * <p>
	 * @param chnlDstcd 채널구분코드
	 * @param tranCd	거래코드
	 * @param fldData1	헤더부 필드값
	 * @param fldData2	개별부 필드값
	 * strRptMap  반복부데이터값
	 * @return testDataDto
	 * 반복부 필드가 있을경우 반복부필드값 셋팅
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public TestDataDto inviExecute( String tranName, String chnlDstcd, String tranCd, 
			String[] fldData1, String[] fldData2, HttpServletRequest request){
		
		
		String strRptMap = request.getParameter("rptMap");       	//반복부 테이터 값
		
		JSONObject jsonRptMap = JSONObject.fromObject(strRptMap);
		Set<String> keys = jsonRptMap.keySet();
		Map<String, List> rptMap = new HashMap<String, List>();  //반복부값  해쉬맵
		
		for(String k : keys){
			ArrayList<Object> a = (ArrayList<Object>) JSONArray.toCollection((JSONArray.fromObject(jsonRptMap.get(k))));
			rptMap.put(k, a);
		}
		
		int rptCntNo = 0;
		int tsdataNO = 0;
		int fldDataIndex = 0;
		TestDataDto testDataDto = new TestDataDto();
		LayoutDto layoutDto = layoutBiz.getLayout(chnlDstcd, tranCd, "I");
		
		List<TestDataDetailDto> headerList = new ArrayList<TestDataDetailDto>();
		try{
			for(int i = 0 ; i < layoutDto.getHeaderList().size() ; i++){
				
				LayoutDetailDto layoutDetailDto = layoutDto.getHeaderList().get(i);
				
				//일반필드일 경우
				if(layoutDetailDto.getRptName() == null || "".equals(layoutDetailDto.getRptName())){
					
					//바이트를 파싱하여 DTO에 추가한다
					TestDataDetailDto testDataDetailDto = new TestDataDetailDto();
					//DTO필드속성 세팅
					testDataDetailDto.setTsdataNO(String.valueOf(tsdataNO++));				//테스트데이터 일련번호
					testDataDetailDto.setTsdataFldName(layoutDetailDto.getFldName());		//테스트데이터 필드명
					testDataDetailDto.setTscsFldDiv(layoutDetailDto.getFldDiv());			//테스트데이터필드 구분
					testDataDetailDto.setTscsFldType(layoutDetailDto.getFldType());			//테스트데이터필드 타입
					testDataDetailDto.setTscsFldAttrib(layoutDetailDto.getFldAttrib());		//테스트데이터필드 속성
					testDataDetailDto.setTscsFldSizeCnt(layoutDetailDto.getTscsFldSize());	//테스트데이터필드 크기
					testDataDetailDto.setTscsFldDesc(layoutDetailDto.getTscsFldDesc());		//테스트데이터필드 한글명
					testDataDetailDto.setTsdataFldData(fldData1[fldDataIndex++]);    					//헤더부필드데이터
					if("03".equals(layoutDetailDto.getFldAttrib())){						//테스트데이터필드 속성 03반복부 필
						testDataDetailDto.setRptCntName("RPT"+String.valueOf(rptCntNo));	//반복부회차네임 셋팅 
						rptCntNo++;
					}
					
					headerList.add(testDataDetailDto);
					
				} else {	//반복부필드일 경우
					List<MorphDynaBean> tdFidData = rptMap.get(layoutDetailDto.getRptName().trim());  //반복부값
					//반복부명
					String rptFldName = layoutDetailDto.getRptName();
					
					//반복횟수, 반복부명 가져오기
					int rtpCount = 0;
					String rptName = null;
					
					for(int j = headerList.size()-1 ; j >= 0 ; j--){
						TestDataDetailDto testDataDetailDto = headerList.get(j);
						if(rptFldName.equals(testDataDetailDto.getTsdataFldName())){
							if(testDataDetailDto.getTsdataFldData() == null || "".equals(testDataDetailDto.getTsdataFldData())){
								break;
							}
							if("hex".equals(testDataDetailDto.getTscsFldType())){	//hex
								rtpCount = TransUtil.parseHex(testDataDetailDto.getTsdataFldData().trim());
							} else {
								rtpCount = Integer.parseInt(testDataDetailDto.getTsdataFldData().trim());
							}
							//반복부명
							rptName = testDataDetailDto.getRptCntName();
						}
					}
					
					//반복부 파싱이 끝난후 레이아웃 인덱스 위치
					int nextIndex = i;
					
					//반복횟수만큼 반복한다
					for(int j = 0 ; j < rtpCount ; j++){
						int k = i;
						for( ; k < layoutDto.getHeaderList().size() ; k++){
							if(!rptFldName.equals(layoutDto.getHeaderList().get(k).getRptName())){	//반복부가 끝나면 첫번째로 되돌아간다
								break;
							} else {	//반복부일 경우
								//바이트를 파싱하여 DTO에 추가한다
								TestDataDetailDto testDataDetailDto = new TestDataDetailDto();
								//DTO필드속성 세팅
								testDataDetailDto.setTsdataNO(String.valueOf(tsdataNO++));	//테스트데이터 일련번호
								testDataDetailDto.setTsdataFldName(layoutDto.getHeaderList().get(k).getFldName());	//테스트데이터 필드명
								testDataDetailDto.setTscsFldDiv(layoutDto.getHeaderList().get(k).getFldDiv());	//테스트데이터필드 구분
								testDataDetailDto.setTscsFldType(layoutDto.getHeaderList().get(k).getFldType());	//테스트데이터필드 타입
								testDataDetailDto.setTscsFldAttrib(layoutDto.getHeaderList().get(k).getFldAttrib());	//테스트데이터필드 속성
								testDataDetailDto.setTscsFldSizeCnt(layoutDto.getHeaderList().get(k).getTscsFldSize());	//테스트데이터필드 크기
								testDataDetailDto.setTscsFldDesc(layoutDto.getHeaderList().get(k).getTscsFldDesc());	//테스트데이터필드 한글명
								testDataDetailDto.setTsdataFldData((String)tdFidData.get(j).get(layoutDto.getHeaderList().get(k).getFldName()));	//반복부 데이터 값 입력
								testDataDetailDto.setRptName(rptName);	//반복부명
								testDataDetailDto.setRptCnt(String.valueOf(j+1));	//반복부회차
								headerList.add(testDataDetailDto);
								
							}
							nextIndex = k;	//반복부의 마지막 인덱스
						}
					}
					
					i = nextIndex;
					
				}
			}
			testDataDto.setHeaderList(headerList);
		}catch (Exception e) {
			logger.error("",e);
			throw new BizException("MSG_PRETST0003","",e);
		}
		
		
		fldDataIndex = 0;
		
		List<TestDataDetailDto> inviList = new ArrayList<TestDataDetailDto>();
		try{
			for(int i = 0 ; i < layoutDto.getInviList().size() ; i++){
				
				LayoutDetailDto layoutDetailDto = layoutDto.getInviList().get(i);
				
				//일반필드일 경우
				if(layoutDetailDto.getRptName() == null || "".equals(layoutDetailDto.getRptName())){
					
					//바이트를 파싱하여 DTO에 추가한다
					TestDataDetailDto testDataDetailDto = new TestDataDetailDto();
					//DTO필드속성 세팅
					testDataDetailDto.setTsdataNO(String.valueOf(tsdataNO++));				//테스트데이터 일련번호
					testDataDetailDto.setTsdataFldName(layoutDetailDto.getFldName());		//테스트데이터 필드명
					testDataDetailDto.setTscsFldDiv(layoutDetailDto.getFldDiv());			//테스트데이터필드 구분
					testDataDetailDto.setTscsFldType(layoutDetailDto.getFldType());			//테스트데이터필드 타입
					testDataDetailDto.setTscsFldAttrib(layoutDetailDto.getFldAttrib());		//테스트데이터필드 속성
					testDataDetailDto.setTscsFldSizeCnt(layoutDetailDto.getTscsFldSize());	//테스트데이터필드 크기
					testDataDetailDto.setTscsFldDesc(layoutDetailDto.getTscsFldDesc());		//테스트데이터필드 한글명
					testDataDetailDto.setTsdataFldData(fldData2[fldDataIndex++]);						//개별부 필드데이터 
					if("03".equals(layoutDetailDto.getFldAttrib())){						//테스트데이터필드 속성 03이면 반복부필드
						testDataDetailDto.setRptCntName("RPT"+String.valueOf(rptCntNo));	//반복부회차네임 셋팅
						rptCntNo++;
					}
					
					inviList.add(testDataDetailDto);
					
				} else {	//반복부필드일 경우
					List<MorphDynaBean> tdFidData = rptMap.get(layoutDetailDto.getRptName().trim());	//반복부값
					
					
					//반복부명
					String rptFldName = layoutDetailDto.getRptName();
					
					//반복횟수, 반복부명 가져오기
					int rtpCount = 0;
					String rptName = null;
					
					for(int j = inviList.size()-1 ; j >= 0 ; j--){
						TestDataDetailDto testDataDetailDto = inviList.get(j);
						if(rptFldName.equals(testDataDetailDto.getTsdataFldName())){
							if(testDataDetailDto.getTsdataFldData() == null || "".equals(testDataDetailDto.getTsdataFldData())){
								break;
							}
							if("hex".equals(testDataDetailDto.getTscsFldType())){	//hex
								rtpCount = TransUtil.parseHex(testDataDetailDto.getTsdataFldData());
							} else {
								rtpCount = Integer.parseInt(testDataDetailDto.getTsdataFldData());
							}
							//반복부명
							rptName = testDataDetailDto.getRptCntName();
						}
					}
					
					//반복부 파싱이 끝난후 레이아웃 인덱스 위치
					int nextIndex = i;
					
					//반복횟수만큼 반복한다
					for(int j = 0 ; j < rtpCount ; j++){
						int k = i;
						for( ; k < layoutDto.getInviList().size() ; k++){
							if(!rptFldName.equals(layoutDto.getInviList().get(k).getRptName())){	//반복부가 끝나면 첫번째로 되돌아간다
								break;
							} else {	//반복부일 경우
								//바이트를 파싱하여 DTO에 추가한다
								TestDataDetailDto testDataDetailDto = new TestDataDetailDto();
								//DTO필드속성 세팅
								testDataDetailDto.setTsdataNO(String.valueOf(tsdataNO++));								//테스트데이터 일련번호
								testDataDetailDto.setTsdataFldName(layoutDto.getInviList().get(k).getFldName());		//테스트데이터 필드명
								testDataDetailDto.setTscsFldDiv(layoutDto.getInviList().get(k).getFldDiv());			//테스트데이터필드 구분
								testDataDetailDto.setTscsFldType(layoutDto.getInviList().get(k).getFldType());			//테스트데이터필드 타입
								testDataDetailDto.setTscsFldAttrib(layoutDto.getInviList().get(k).getFldAttrib());		//테스트데이터필드 속성
								testDataDetailDto.setTscsFldSizeCnt(layoutDto.getInviList().get(k).getTscsFldSize());	//테스트데이터필드 크기
								testDataDetailDto.setTscsFldDesc(layoutDto.getInviList().get(k).getTscsFldDesc());		//테스트데이터필드 한글명 
								testDataDetailDto.setTsdataFldData((String)tdFidData.get(j).get(layoutDto.getInviList().get(k).getFldName()));								//반복부데이터 입력
								testDataDetailDto.setRptName(rptName);	//반복부명
								testDataDetailDto.setRptCnt(String.valueOf(j+1));	//반복부회차
								inviList.add(testDataDetailDto);
								
							}
							nextIndex = k;	//반복부의 마지막 인덱스
						}
					}
					
					i = nextIndex;
					
				}
			}
			testDataDto.setInviList(inviList);
		
		}catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_PRETST0004","",e);
		}
		
		return testDataDto;
	}
	
	
}
