package com.igo.testro.msg.tsmng.biz;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.ezmorph.bean.MorphDynaBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.igo.testro.cmn.login.dto.LoginDto;
import com.igo.testro.cmn.utils.DateUtil;
import com.igo.testro.cmn.utils.TransUtil;
import com.igo.testro.exception.BizException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.layout.biz.ILayoutBiz;
import com.igo.testro.msg.layout.dto.LayoutDetailDto;
import com.igo.testro.msg.layout.dto.LayoutDto;
import com.igo.testro.msg.pretst.dto.TestDataDetailDto;
import com.igo.testro.msg.pretst.dto.TestDataDto;
import com.igo.testro.msg.tcmng.dto.CheckPointDTO;

/**
 * <p>
 * 프로그램명:TdDetailBiz.java<br/>
 * 설명 : 테스트 데이터 수정 Biz<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 13. : 김기태 : 내용
 * </ul> 
 * </p>
 */
public class TdDetailBiz {
	final ITestroLogger logger = TestroLogHelper.getBiz();
	
	@Autowired
	private ILayoutBiz layoutBiz;
	
	/**
	 * <p>
	 * 반복부 내용을 Map형태로 가져온다.
	 * <p>
	 * @param testDataDto - 반복부가 있는 테스트 데이터 정보
	 * @return - 반복부 Map
	 */
	public Map<String, List<Map<String, String>>> getRptMap(TestDataDto testDataDto) {
		List<TestDataDetailDto> detailDtos = new ArrayList<TestDataDetailDto>();
		detailDtos.addAll(testDataDto.getHeaderList());
		detailDtos.addAll(testDataDto.getInviList());
		
		Map<String, List<Map<String, String>>> rptMap = new HashMap<String, List<Map<String, String>>>();
		
		String rptFldName = "";
		int rptCnt = 1;
		
		/* 2012.03.27 고재형 기존소스보존
		for(TestDataDetailDto dto : detailDtos){
			if(rptCnt > 0){
				rptMap.get(rptFldName).add(dto.getTsdataFldData());
				rptCnt--;
			}else if("03".equals(dto.getTscsFldAttrib())){
				rptFldName = dto.getTsdataFldName();
				dto.setTsdataFldData(Integer.parseInt(dto.getTsdataFldData())+"");
				rptCnt = Integer.parseInt(dto.getTsdataFldData()) * 2;
				rptMap.put(rptFldName, new ArrayList<String>());
			}
		}*/
		
		for(TestDataDetailDto dto : detailDtos){
			if("03".equals(dto.getTscsFldAttrib())){
				rptFldName = dto.getTsdataFldName();
			} else if(dto.getRptName() != null && !"".equals(dto.getRptName())){
				
				if(rptMap.get(rptFldName) == null){
					List<Map<String, String>> rptDataList = new ArrayList<Map<String, String>>();
					
					Map<String, String> dataMap = new HashMap<String, String>();
					dataMap.put(dto.getTsdataFldName(), dto.getTsdataFldData());
					rptDataList.add(dataMap);
					
					rptMap.put(rptFldName, rptDataList);
					rptCnt = 1;
				} else if(String.valueOf(rptCnt).equals(dto.getRptCnt().trim())){
					rptMap.get(rptFldName).get(rptCnt-1).put(dto.getTsdataFldName(), dto.getTsdataFldData());
				} else if(!String.valueOf(rptCnt).equals(dto.getRptCnt().trim())){
					Map<String, String> dataMap = new HashMap<String, String>();
					dataMap.put(dto.getTsdataFldName(), dto.getTsdataFldData());
					rptMap.get(rptFldName).add(dataMap);
					
					rptCnt++;
				}
			}
		}
		
		return rptMap;
	}

	/**
	 * <p>
	 * JSON 형태의 테스트 데이터를 DTO 타입으로 변경
	 * <p>
	 * @param strTestData JSON 형태의 테스트 데이터
	 * @return DTO 타입 테스트 데이터
	 */
	public TestDataDto getJsonTdInfo(String strTestData) {
		JSONObject jsonTestData = JSONObject.fromObject(strTestData);
		
		TestDataDto testDataDto = new TestDataDto();
		
		try {
			BeanUtils.copyProperties(testDataDto, jsonTestData);
		
			//헤더부
			List<TestDataDetailDto> headerList = new ArrayList<TestDataDetailDto>();
			testDataDto.setHeaderList(headerList);
			for(Object objHeader : jsonTestData.getJSONArray("headerList")){
				TestDataDetailDto header = new TestDataDetailDto();
				BeanUtils.copyProperties(header, JSONObject.fromObject(objHeader));
				
				headerList.add(header);
			}
			
			//개별부
			List<TestDataDetailDto> inviList = new ArrayList<TestDataDetailDto>();
			testDataDto.setInviList(inviList);
			for(Object objInvi : jsonTestData.getJSONArray("inviList")){
				TestDataDetailDto invi = new TestDataDetailDto();
				BeanUtils.copyProperties(invi, JSONObject.fromObject(objInvi));
				
				inviList.add(invi);
			}
			
			//체크포인트
			List<CheckPointDTO> checkPointList = new ArrayList<CheckPointDTO>();
			testDataDto.setCheckPointList(checkPointList);
			for(Object objCheckPoint : jsonTestData.getJSONArray("checkPointList")){
				CheckPointDTO checkPointDTO = new CheckPointDTO();
				BeanUtils.copyProperties(checkPointDTO, JSONObject.fromObject(objCheckPoint));
				
				checkPointList.add(checkPointDTO);
			}
		} catch (IllegalAccessException e) {
			logger.error("", e);
			throw new BizException("MSG_TSNMNG0002","", e);
		} catch (InvocationTargetException e) {
			logger.error("", e);
			throw new BizException("MSG_TSNMNG0002","", e);
		}
		
		return testDataDto;
	}

	/**
	 * <p>
	 * 테스트데이터 수정
	 * <p>
	 * @param testDataDto - 테스트데이터 정보
	 * @param tsdataNO - 테스트데이터일련번호
	 * @param tsdataFldName - 테스트데이터필드명
	 * @param tsdataFldData - 테스트데이터필드데이터
	 * @param tscsFldDiv - 테스트데이터필드구분
	 * @param tscsFldType - 테스트데이터필드타입
	 * @param tscsFldAttrib - 테스트데이터필드속성
	 * @param tscsFldSizeCnt - 테스트데이터필드크기내용
	 * @param tscsFldDesc - 테스트데이터필드설명
	 * @param tscsUsrFldDesc - 테스트데이터사용자필드설명
	 * @param rmark - 비고
	 * @param chkYNVal - 체크포인트정보
	 * @param strRptMap - 반복부 정보
	 * @param loginDto - 로그인 사용자 정보
	 */
	public void modifyTdDetail(
			TestDataDto testDataDto
			, String[] tsdataNO
			, String[] tsdataFldName
			, String[] tsdataFldData
			, String[] tscsFldDiv
			, String[] tscsFldType
			, String[] tscsFldAttrib
			, String[] tscsFldSizeCnt
			, String[] tscsFldDesc
			, String[] tscsUsrFldDesc
			, String[] rmark
			, String chkYNVal
			, String strRptMap
			, LoginDto loginDto) {
		
		String lastModfiID = loginDto.getUsrid();
		String lastModfiYMS = DateUtil.getDateString();
		
		LayoutDto layoutDto = layoutBiz.getLayout(testDataDto.getChnlDstcd(), testDataDto.getTranCd(), "I");	//레이아웃조회
		JSONObject jsonRptMap = JSONObject.fromObject(strRptMap);
		Set<String> keys = jsonRptMap.keySet();
		Map<String, List> rptMap = new HashMap<String, List>();  //반복부값  해쉬맵
		
		for(String k : keys){
			ArrayList<Object> a = (ArrayList<Object>) JSONArray.toCollection((JSONArray.fromObject(jsonRptMap.get(k))));
			rptMap.put(k, a);
		}
		
		int fieldIndex = 0;	//일반필드 데이터 인덱스
		int dataNO = 1;	//데이터 순번
		
		String rptFldName = "";	//반복부필드명
		String rptName = "";	//반복부명
		int rptNum = 0;	//반복부번호
		int rtpCount = 0;	//반복횟수
		
		List<LayoutDetailDto> layoutDetailDtoList = layoutDto.getHeaderList();	//헤더부 레이아웃
		List<TestDataDetailDto> testDataDetailDtoList = new ArrayList<TestDataDetailDto>();	//헤더부 데이터
		
		for (int i = 0 ; i < layoutDetailDtoList.size() ; i++) {	//레이아웃리스트를 순회한다
			LayoutDetailDto layoutDetailDto = layoutDetailDtoList.get(i);
			
			if(layoutDetailDto.getRptName() == null || "".equals(layoutDetailDto.getRptName())){	//반복부 필드가 아닐경우
				TestDataDetailDto testDataDetailDto = new TestDataDetailDto();
				testDataDetailDto.setTsdataID(testDataDto.getTsdataID());
				testDataDetailDto.setTsdataNO(String.valueOf(dataNO++));
				testDataDetailDto.setTsdataFldName(tsdataFldName[fieldIndex].trim());
				testDataDetailDto.setTscsFldDiv(tscsFldDiv[fieldIndex].trim());
				testDataDetailDto.setTscsFldType(tscsFldType[fieldIndex].trim());
				testDataDetailDto.setTscsFldAttrib(tscsFldAttrib[fieldIndex].trim());
				testDataDetailDto.setTscsFldSizeCnt(tscsFldSizeCnt[fieldIndex].trim());
				testDataDetailDto.setTscsFldDesc(tscsFldDesc[fieldIndex].trim());
				testDataDetailDto.setTscsUsrFldDesc(tscsUsrFldDesc[fieldIndex].trim());
				testDataDetailDto.setLastModfiID(lastModfiID);
				testDataDetailDto.setLastModfiYMS(lastModfiYMS);
				testDataDetailDto.setRmark(rmark[fieldIndex].trim());
				testDataDetailDto.setTsdataFldData(tsdataFldData[fieldIndex].trim());
				fieldIndex++;
				
				if("03".equals(layoutDetailDto.getFldAttrib())){
					rptFldName = testDataDetailDto.getTsdataFldName();
					rptName = "RPT" + rptNum++;
					testDataDetailDto.setRptCntName(rptName);
					if("hex".equals(testDataDetailDto.getTscsFldType())){	//hex
						rtpCount = TransUtil.parseHex(testDataDetailDto.getTsdataFldData());
					} else {
						rtpCount = Integer.parseInt(testDataDetailDto.getTsdataFldData().trim());
					}
				}
				
				testDataDetailDtoList.add(testDataDetailDto);
				
			} else {	//반복부 필드일 경우
				
				List<MorphDynaBean> tdFidData = rptMap.get(layoutDetailDto.getRptName().trim());  //반복부값
				
				//반복부 파싱이 끝난후 레이아웃 인덱스 위치
				int nextIndex = i;
				
				//반복횟수만큼 반복한다
				for(int j = 0 ; j < rtpCount ; j++){
					int k = i;
					for( ; k < layoutDetailDtoList.size() ; k++){
						if(!rptFldName.equals(layoutDetailDtoList.get(k).getRptName())){	//반복부가 끝나면 첫번째로 되돌아간다
							break;
						} else {	//반복부일 경우
							
							TestDataDetailDto testDataDetailDto = new TestDataDetailDto();
							testDataDetailDto.setTsdataID(testDataDto.getTsdataID());
							testDataDetailDto.setTsdataNO(String.valueOf(dataNO++));
							testDataDetailDto.setTsdataFldName(layoutDetailDtoList.get(k).getFldName());
							testDataDetailDto.setTsdataFldData((String)tdFidData.get(j).get(layoutDetailDtoList.get(k).getFldName()));
							testDataDetailDto.setTscsFldDiv(layoutDetailDtoList.get(k).getFldDiv());
							testDataDetailDto.setTscsFldType(layoutDetailDtoList.get(k).getFldType());
							testDataDetailDto.setTscsFldAttrib(layoutDetailDtoList.get(k).getFldDiv());
							testDataDetailDto.setTscsFldSizeCnt(layoutDetailDtoList.get(k).getTscsFldSize());
							testDataDetailDto.setTscsFldDesc(layoutDetailDtoList.get(k).getTscsFldDesc());
							//testDataDetailDto.setTscsUsrFldDesc("");
							testDataDetailDto.setRptName(rptName);
							testDataDetailDto.setRptCnt(String.valueOf(j+1));
							testDataDetailDto.setLastModfiID(lastModfiID);
							testDataDetailDto.setLastModfiYMS(lastModfiYMS);
							//rptDto.setRmark("");
							testDataDetailDtoList.add(testDataDetailDto);
						}
						nextIndex = k;	//반복부의 마지막 인덱스
					}
				}
				
				i = nextIndex;
			}
		}
		testDataDto.setHeaderList(testDataDetailDtoList);
		
		layoutDetailDtoList = layoutDto.getInviList();	//개별부 레이아웃
		testDataDetailDtoList = new ArrayList<TestDataDetailDto>();	//개별부 데이터
		
		for (int i = 0 ; i < layoutDetailDtoList.size() ; i++) {	//레이아웃리스트를 순회한다
			LayoutDetailDto layoutDetailDto = layoutDetailDtoList.get(i);
			
			if(layoutDetailDto.getRptName() == null || "".equals(layoutDetailDto.getRptName())){	//반복부 필드가 아닐경우
				TestDataDetailDto testDataDetailDto = new TestDataDetailDto();
				testDataDetailDto.setTsdataID(testDataDto.getTsdataID());
				testDataDetailDto.setTsdataNO(String.valueOf(dataNO++));
				testDataDetailDto.setTsdataFldName(tsdataFldName[fieldIndex].trim());
				testDataDetailDto.setTscsFldDiv(tscsFldDiv[fieldIndex].trim());
				testDataDetailDto.setTscsFldType(tscsFldType[fieldIndex].trim());
				testDataDetailDto.setTscsFldAttrib(tscsFldAttrib[fieldIndex].trim());
				testDataDetailDto.setTscsFldSizeCnt(tscsFldSizeCnt[fieldIndex].trim());
				testDataDetailDto.setTscsFldDesc(tscsFldDesc[fieldIndex].trim());
				testDataDetailDto.setTscsUsrFldDesc(tscsUsrFldDesc[fieldIndex].trim());
				testDataDetailDto.setLastModfiID(lastModfiID);
				testDataDetailDto.setLastModfiYMS(lastModfiYMS);
				testDataDetailDto.setRmark(rmark[fieldIndex].trim());
				testDataDetailDto.setTsdataFldData(tsdataFldData[fieldIndex].trim());
				fieldIndex++;
				
				if("03".equals(layoutDetailDto.getFldAttrib())){
					rptFldName = testDataDetailDto.getTsdataFldName();
					rptName = "RPT" + rptNum++;
					testDataDetailDto.setRptCntName(rptName);
					if("hex".equals(testDataDetailDto.getTscsFldType())){	//hex
						rtpCount = TransUtil.parseHex(testDataDetailDto.getTsdataFldData());
					} else {
						rtpCount = Integer.parseInt(testDataDetailDto.getTsdataFldData().trim());
					}
				}
				
				testDataDetailDtoList.add(testDataDetailDto);
				
			} else {	//반복부 필드일 경우
				
				List<MorphDynaBean> tdFidData = rptMap.get(layoutDetailDto.getRptName().trim());  //반복부값
				int jsonRptIndex = 0;
				
				//반복부 파싱이 끝난후 레이아웃 인덱스 위치
				int nextIndex = i;
				
				//반복횟수만큼 반복한다
				for(int j = 0 ; j < rtpCount ; j++){
					int k = i;
					for( ; k < layoutDetailDtoList.size() ; k++){
						if(!rptFldName.equals(layoutDetailDtoList.get(k).getRptName())){	//반복부가 끝나면 첫번째로 되돌아간다
							break;
						} else {	//반복부일 경우
							
							TestDataDetailDto testDataDetailDto = new TestDataDetailDto();
							testDataDetailDto.setTsdataID(testDataDto.getTsdataID());
							testDataDetailDto.setTsdataNO(String.valueOf(dataNO++));
							testDataDetailDto.setTsdataFldName(layoutDetailDtoList.get(k).getFldName());
							testDataDetailDto.setTsdataFldData((String)tdFidData.get(j).get(layoutDetailDtoList.get(k).getFldName()));
							testDataDetailDto.setTscsFldDiv(layoutDetailDtoList.get(k).getFldDiv());
							testDataDetailDto.setTscsFldType(layoutDetailDtoList.get(k).getFldType());
							testDataDetailDto.setTscsFldAttrib(layoutDetailDtoList.get(k).getFldDiv());
							testDataDetailDto.setTscsFldSizeCnt(layoutDetailDtoList.get(k).getTscsFldSize());
							testDataDetailDto.setTscsFldDesc(layoutDetailDtoList.get(k).getTscsFldDesc());
							//testDataDetailDto.setTscsUsrFldDesc("");
							testDataDetailDto.setRptName(rptName);
							testDataDetailDto.setRptCnt(String.valueOf(j+1));
							testDataDetailDto.setLastModfiID(lastModfiID);
							testDataDetailDto.setLastModfiYMS(lastModfiYMS);
							//rptDto.setRmark("");
							testDataDetailDtoList.add(testDataDetailDto);
						}
						nextIndex = k;	//반복부의 마지막 인덱스
					}
				}
				
				i = nextIndex;
			}
		}
		testDataDto.setInviList(testDataDetailDtoList);
		
		//체크포인트
		List<CheckPointDTO> checkPointDTOs = new ArrayList<CheckPointDTO>();
		testDataDto.setCheckPointList(checkPointDTOs);
		
		JSONArray jsonArrayChkYNVal = JSONArray.fromObject(chkYNVal);
		for(int i=0, cnt=jsonArrayChkYNVal.size(); i<cnt; i++){
			CheckPointDTO dto = (CheckPointDTO) JSONObject.toBean(JSONObject.fromObject(jsonArrayChkYNVal.get(i)), CheckPointDTO.class);
			checkPointDTOs.add(dto);
		}
	}	
}
