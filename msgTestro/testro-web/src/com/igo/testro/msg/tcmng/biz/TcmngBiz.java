package com.igo.testro.msg.tcmng.biz;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.ezmorph.bean.MorphDynaBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.igo.testro.cmn.login.dao.LoginDao;
import com.igo.testro.cmn.login.dto.LoginDto;
import com.igo.testro.cmn.utils.DateUtil;
import com.igo.testro.cmn.utils.TransUtil;
import com.igo.testro.exception.BizException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.cmn.biz.MngSeqIdBiz;
import com.igo.testro.msg.cmn.execute.biz.TestDataExecuteBiz;
import com.igo.testro.msg.cmn.execute.dto.RptTestDataBasicDTO;
import com.igo.testro.msg.layout.biz.ILayoutBiz;
import com.igo.testro.msg.layout.dto.LayoutDetailDto;
import com.igo.testro.msg.layout.dto.LayoutDto;
import com.igo.testro.msg.pretst.dto.TestDataDetailDto;
import com.igo.testro.msg.pretst.dto.TestDataDto;
import com.igo.testro.msg.tcmng.dao.CheckPointDao;
import com.igo.testro.msg.tcmng.dao.TcmngDao;
import com.igo.testro.msg.tcmng.dto.CheckPointDTO;
import com.igo.testro.msg.tcmng.dto.RptCaseDetailDto;
import com.igo.testro.msg.tcmng.dto.RptCaseDto;
import com.igo.testro.msg.tcmng.dto.TcDetailDto;
import com.igo.testro.msg.tcmng.dto.TcDto;

public class TcmngBiz {
	final ITestroLogger logger = TestroLogHelper.getBiz();
	
	String sussYN = "Y";
	String detailSussYN = "Y";
	String sussMSG = "거래성공";
	
	@Autowired
	private TcmngDao tcmngDao;
	
	@Autowired
	private ILayoutBiz layoutBiz;
	
	@Autowired
	private LoginDao loginDao;
	
	@Autowired
	private CheckPointDao checkPointDao;
	
	@Autowired
	private TestDataExecuteBiz testDataExecuteBiz;

	@Autowired
	private MngSeqIdBiz mngSeqIdBiz;
	
	
	/**
	 * <p>
	 * 테스트케이스 정보 가져오기
	 * </p>
	 * @param tsCaseID 테스트케이스ID
	 * @return TcDto 테스트케이스Dto
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public TcDto getTcInfo(String tsCaseID) {
		//테스트케이스정보 가져오기
		TcDto tcDto = tcmngDao.getTsCaseInfo(tsCaseID);
		
		return tcDto;
	}
	
	
	/**
	 * <p>
	 * 기본 테스트데이터 가져오기
	 * </p>
	 * <p>
	 * Map에 그리드에서 매핑시킬 키값과 Value를 담는다.
	 * 키값은 헤더부와 개별부의 필드명이 중복되어 문제가 발생될수 있기 때문에 H:헤더부, I:개별부로 String을 붙여서 만든다.
	 * 그리드의 반복부를 더블 클릭했을때 팝업에 필요한 값을 Map에 담으며, 키값 또한 위와 같은 방법으로 만들되 끝에 반복부의 값을 알리는 G를 붙인다.
	 * </p>
	 * @param Map(chnlDstcd : 채널코드, tranCd : 거래코드);
	 * @return Map 기본테스트데이터(key:value로 담는다.)
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Map getBasicsData(Map pramMap) {
		try{
			Map gridMap = new HashMap(); 
			
			//기본 테스트데이터
			TestDataDto basicsData = tcmngDao.getBasicsData(pramMap);
	
			if(basicsData != null){
				
				String tsdataFldName = "";
				int rptCnt = 1;
				
				//기본 테스트데이터 상세(tesData04)
				List<TestDataDetailDto> tdBasicsDetailList = tcmngDao.getTdBasicsDetailList(basicsData.getTsdataID());
				
				for(int i = 0; i < tdBasicsDetailList.size(); i++){
					gridMap.put("tsdataID"	, basicsData.getTsdataID());
					gridMap.put("tsdataName", basicsData.getTsdataName());
					gridMap.put("tsdataDesc", basicsData.getTsdataDesc());
					
					//헤더부|개별부(01:헤더부, 02:개별부)
					if("01".equals(tdBasicsDetailList.get(i).getTscsFldDiv())){
						//반복부필드의 값 체크
						if(null != tdBasicsDetailList.get(i).getRptName() && !"".equals(tdBasicsDetailList.get(i).getRptName())){
							for(int j = 0; j < tdBasicsDetailList.size(); j++){
								if(tdBasicsDetailList.get(i).getRptName().equals(tdBasicsDetailList.get(j).getRptCntName())){
									if(!tsdataFldName.equals(tdBasicsDetailList.get(j).getTsdataFldName())){
										tsdataFldName = tdBasicsDetailList.get(j).getTsdataFldName();
										rptCnt = 1;
									}
									
									String fldData = "";
									if(tdBasicsDetailList.get(i).getTsdataFldData() != null) fldData = tdBasicsDetailList.get(i).getTsdataFldData(); 
									
									String rptData = (String)gridMap.get(tdBasicsDetailList.get(j).getTsdataFldName()+"||-HG");
									if(rptData == null){
										rptData = "[{\""+tdBasicsDetailList.get(i).getTsdataFldName()+"\":\""+fldData+"\"}]";
									} else if(String.valueOf(rptCnt).equals(tdBasicsDetailList.get(i).getRptCnt().trim())) {
										rptData = rptData.substring(0, rptData.length()-2) + ",\"" + tdBasicsDetailList.get(i).getTsdataFldName()+"\":\""+fldData+"\"}]";
									} else if(!String.valueOf(rptCnt).equals(tdBasicsDetailList.get(i).getRptCnt().trim())) {
										rptData = rptData.substring(0, rptData.length()-1) + ",{\"" + tdBasicsDetailList.get(i).getTsdataFldName()+"\":\""+fldData+"\"}]";
										rptCnt++;
									}
									gridMap.put(tdBasicsDetailList.get(j).getTsdataFldName()+"||-HG", rptData);
									break;
								}
							}
						} else {
							gridMap.put(tdBasicsDetailList.get(i).getTsdataFldName()+"||-H", tdBasicsDetailList.get(i).getTsdataFldData());
						}
					}else if("02".equals(tdBasicsDetailList.get(i).getTscsFldDiv())){
						//반복부필드의 값 체크
						if(null != tdBasicsDetailList.get(i).getRptName() && !"".equals(tdBasicsDetailList.get(i).getRptName())){
							for(int j = 0; j < tdBasicsDetailList.size(); j++){
								if(tdBasicsDetailList.get(i).getRptName().equals(tdBasicsDetailList.get(j).getRptCntName())){
									if(!tsdataFldName.equals(tdBasicsDetailList.get(j).getTsdataFldName())){
										tsdataFldName = tdBasicsDetailList.get(j).getTsdataFldName();
										rptCnt = 1;
									}
									
									String fldData = "";
									if(tdBasicsDetailList.get(i).getTsdataFldData() != null) fldData = tdBasicsDetailList.get(i).getTsdataFldData();
									
									String rptData = (String)gridMap.get(tdBasicsDetailList.get(j).getTsdataFldName()+"||-IG");
									if(rptData == null){
										rptData = "[{\""+tdBasicsDetailList.get(i).getTsdataFldName()+"\":\""+fldData+"\"}]";
									} else if(String.valueOf(rptCnt).equals(tdBasicsDetailList.get(i).getRptCnt().trim())) {
										rptData = rptData.substring(0, rptData.length()-2) + ",\"" + tdBasicsDetailList.get(i).getTsdataFldName()+"\":\""+fldData+"\"}]";
									} else if(!String.valueOf(rptCnt).equals(tdBasicsDetailList.get(i).getRptCnt().trim())) {
										rptData = rptData.substring(0, rptData.length()-1) + ",{\"" + tdBasicsDetailList.get(i).getTsdataFldName()+"\":\""+fldData+"\"}]";
										rptCnt++;
									}
									gridMap.put(tdBasicsDetailList.get(j).getTsdataFldName()+"||-IG", rptData);
									break;
								}
							}
						} else {
							gridMap.put(tdBasicsDetailList.get(i).getTsdataFldName()+"||-I", tdBasicsDetailList.get(i).getTsdataFldData());
						}
					}
				}//for end
			}//for end
			
			return gridMap;
		}catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_TCMNGX0001","",e);
		}
	}
	
	
	/**
	 * <p>
	 * 테스트케이스의 데이터 가져오기
	 * </p>
	 * <p>
	 * Map에 그리드에서 매핑시킬 키값과 Value를 담는다.
	 * 키값은 헤더부와 개별부의 필드명이 중복되어 문제가 발생될수 있기 때문에 H:헤더부, I:개별부로 String을 붙여서 만든다.
	 * 그리드의 반복부를 더블 클릭했을때 팝업에 필요한 값을 Map에 담으며, 키값 또한 위와 같은 방법으로 만들되 끝에 반복부의 값을 알리는 G를 붙인다.
	 * Map으로 담은 후 List에 ADD하여 return한다.
	 * </p>
	 * @param tsCaseID 테스트케이스ID
	 * @return List 테스트데이터(key:value) Map을 담은 List
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public List getChkTcInfo(String tsCaseID) {
		try{
			//테스트케이스 리스트
			List<TestDataDto> testDataDtoList = tcmngDao.getTdList(tsCaseID);
			List<Map> testDataMapList = new ArrayList<Map>();
			
			HashMap<String, String> parmap = new HashMap<String, String>();
			
			for(int i = 0; i < testDataDtoList.size(); i++){
				//헤더부|개별부(01:헤더부, 02:개별부)
				List<TestDataDetailDto> testDataDetailDtoList = new ArrayList<TestDataDetailDto>();
				parmap.put("tsdataID", testDataDtoList.get(i).getTsdataID());
				
				//테스트데이터 상세 리스트
				testDataDetailDtoList = tcmngDao.getTdDetailList(parmap);
				
				Map gridMap = new HashMap(); 
				gridMap.put("tsdataID"	, testDataDtoList.get(i).getTsdataID());
				gridMap.put("tsdataName", testDataDtoList.get(i).getTsdataName());
				gridMap.put("tsdataDesc", testDataDtoList.get(i).getTsdataDesc());
				gridMap.put("chkYN",  testDataDtoList.get(i).getChkYN());
				
				String tsdataFldName = "";
				int rptCnt = 1;
				
				for(int j = 0; j < testDataDetailDtoList.size(); j++){
					//헤더부|개별부(01:헤더부, 02:개별부)
					if("01".equals(testDataDetailDtoList.get(j).getTscsFldDiv())){
						//반복부필드의 값 체크
						if(null != testDataDetailDtoList.get(j).getRptName() && !"".equals(testDataDetailDtoList.get(j).getRptName())){	//빈복부 필드
							
							for(int k = 0; k < testDataDetailDtoList.size(); k++){
								if(testDataDetailDtoList.get(j).getRptName().equals(testDataDetailDtoList.get(k).getRptCntName())){
									if(!tsdataFldName.equals(testDataDetailDtoList.get(k).getTsdataFldName())){
										tsdataFldName = testDataDetailDtoList.get(k).getTsdataFldName();
										rptCnt = 1;
									}
									
									String fldData = "";
									if(testDataDetailDtoList.get(j).getTsdataFldData() != null) fldData = testDataDetailDtoList.get(j).getTsdataFldData();
									
									String rptData = (String)gridMap.get(testDataDetailDtoList.get(k).getTsdataFldName()+"||-HG");
									if(rptData == null){
										rptData = "[{\""+testDataDetailDtoList.get(j).getTsdataFldName()+"\":\""+fldData+"\"}]";
									} else if(String.valueOf(rptCnt).equals(testDataDetailDtoList.get(j).getRptCnt().trim())) {
										rptData = rptData.substring(0, rptData.length()-2) + ",\"" + testDataDetailDtoList.get(j).getTsdataFldName()+"\":\""+fldData+"\"}]";
									} else if(!String.valueOf(rptCnt).equals(testDataDetailDtoList.get(j).getRptCnt().trim())) {
										rptData = rptData.substring(0, rptData.length()-1) + ",{\"" + testDataDetailDtoList.get(j).getTsdataFldName()+"\":\""+fldData+"\"}]";
										rptCnt++;
									}
									gridMap.put(testDataDetailDtoList.get(k).getTsdataFldName()+"||-HG", rptData);
									break;
								}
							}
						} else {
							gridMap.put(testDataDetailDtoList.get(j).getTsdataFldName()+"||-H", testDataDetailDtoList.get(j).getTsdataFldData());
						}
					}else if("02".equals(testDataDetailDtoList.get(j).getTscsFldDiv())){
						//반복부필드의 값 체크
						if(null != testDataDetailDtoList.get(j).getRptName() && !"".equals(testDataDetailDtoList.get(j).getRptName())){	//빈복부 필드
														
							for(int k = 0; k < testDataDetailDtoList.size(); k++){
								if(testDataDetailDtoList.get(j).getRptName().equals(testDataDetailDtoList.get(k).getRptCntName())){
									if(!tsdataFldName.equals(testDataDetailDtoList.get(k).getTsdataFldName())){
										tsdataFldName = testDataDetailDtoList.get(k).getTsdataFldName();
										rptCnt = 1;
									}
									
									String fldData = "";
									if(testDataDetailDtoList.get(j).getTsdataFldData() != null) fldData = testDataDetailDtoList.get(j).getTsdataFldData();
									
									String rptData = (String)gridMap.get(testDataDetailDtoList.get(k).getTsdataFldName()+"||-IG");
									if(rptData == null){
										rptData = "[{\""+testDataDetailDtoList.get(j).getTsdataFldName()+"\":\""+fldData+"\"}]";
									} else if(String.valueOf(rptCnt).equals(testDataDetailDtoList.get(j).getRptCnt().trim())) {
										rptData = rptData.substring(0, rptData.length()-2) + ",\"" + testDataDetailDtoList.get(j).getTsdataFldName()+"\":\""+fldData+"\"}]";
									} else if(!String.valueOf(rptCnt).equals(testDataDetailDtoList.get(j).getRptCnt().trim())) {
										rptData = rptData.substring(0, rptData.length()-1) + ",{\"" + testDataDetailDtoList.get(j).getTsdataFldName()+"\":\""+fldData+"\"}]";
										rptCnt++;
									}
									gridMap.put(testDataDetailDtoList.get(k).getTsdataFldName()+"||-IG", rptData);
									break;
								}
							}
						} else {
							gridMap.put(testDataDetailDtoList.get(j).getTsdataFldName()+"||-I", testDataDetailDtoList.get(j).getTsdataFldData());
						}
					}
				}//end for
				testDataMapList.add(gridMap);
			}//end for
			
			return testDataMapList;
		}catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_TCMNGX0002","",e);
		}
	}
	
	/**
	 * <p>
	 * 테스트케이스추가시 그리드에 매핑시킬 데이터들을 map에 담기
	 * </p>
	 * <p>
	 * Map에 그리드에서 매핑시킬 키값과 Value를 담는다.
	 * 키값은 헤더부와 개별부의 필드명이 중복되어 문제가 발생될수 있기 때문에 H:헤더부, I:개별부로 String을 붙여서 만든다.
	 * 그리드의 반복부를 더블 클릭했을때 팝업에 필요한 값을 Map에 담으며, 키값 또한 위와 같은 방법으로 만들되 끝에 반복부의 값을 알리는 G를 붙인다.
	 * Map으로 담은 후 List에 ADD하여 return한다.
	 * </p>
	 * @param request
	 * @return List 테스트데이터(key:value) Map을 담은 List
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public List getTcmngAddList(HttpServletRequest request) {
		try{
			//View에서 넘어온 tsDataID List
			List tsDataList = JSONArray.fromObject(request.getParameter("tsDataIDList"));
			//리턴 해줄 변수
			List gridDataList = new ArrayList();
			
			
			for(int i = 0; i < tsDataList.size(); i++){
				Map gridMap = new HashMap(); 
				String tsDataID = (String)tsDataList.get(i);
				
				TestDataDto testDataDto = tcmngDao.getTsData(tsDataID);
				List<TestDataDetailDto> testDataDetailDtoList = tcmngDao.getTsDataDetailList(tsDataID);
				
				gridMap.put("tsdataID", testDataDto.getTsdataID());
				gridMap.put("tsdataName", testDataDto.getTsdataName());
				gridMap.put("tsdataDesc", testDataDto.getTsdataDesc());
				gridMap.put("chkYN", testDataDto.getChkYN());
				
				String tsdataFldName = "";
				int rptCnt = 1;
				
				for(int j = 0; j < testDataDetailDtoList.size(); j++){
					//헤더부|개별부(01:헤더부, 02:개별부)
					if("01".equals(testDataDetailDtoList.get(j).getTscsFldDiv())){
						//반복부필드의 값 체크
						if(null != testDataDetailDtoList.get(j).getRptName() && !"".equals(testDataDetailDtoList.get(j).getRptName())){	//빈복부 필드
							for(int k = 0; k < testDataDetailDtoList.size(); k++){
								if(testDataDetailDtoList.get(j).getRptName().equals(testDataDetailDtoList.get(k).getRptCntName())){
									if(!tsdataFldName.equals(testDataDetailDtoList.get(k).getTsdataFldName())){
										tsdataFldName = testDataDetailDtoList.get(k).getTsdataFldName();
										rptCnt = 1;
									}
									
									String fldData = "";
									if(testDataDetailDtoList.get(j).getTsdataFldData() != null) fldData = testDataDetailDtoList.get(j).getTsdataFldData();
									
									String rptData = (String)gridMap.get(testDataDetailDtoList.get(k).getTsdataFldName()+"||-HG");
									if(rptData == null){
										rptData = "[{\""+testDataDetailDtoList.get(j).getTsdataFldName()+"\":\""+fldData+"\"}]";
									} else if(String.valueOf(rptCnt).equals(testDataDetailDtoList.get(j).getRptCnt().trim())) {
										rptData = rptData.substring(0, rptData.length()-2) + ",\"" + testDataDetailDtoList.get(j).getTsdataFldName()+"\":\""+fldData+"\"}]";
									} else if(!String.valueOf(rptCnt).equals(testDataDetailDtoList.get(j).getRptCnt().trim())) {
										rptData = rptData.substring(0, rptData.length()-1) + ",{\"" + testDataDetailDtoList.get(j).getTsdataFldName()+"\":\""+fldData+"\"}]";
										rptCnt++;
									}
									gridMap.put(testDataDetailDtoList.get(k).getTsdataFldName()+"||-HG", rptData);
									break;
								}
							}
						} else {
							gridMap.put(testDataDetailDtoList.get(j).getTsdataFldName()+"||-H", testDataDetailDtoList.get(j).getTsdataFldData());
						}
					}else if("02".equals(testDataDetailDtoList.get(j).getTscsFldDiv())){
						//반복부필드의 값 체크
						if(null != testDataDetailDtoList.get(j).getRptName() && !"".equals(testDataDetailDtoList.get(j).getRptName())){	//빈복부 필드
							for(int k = 0; k < testDataDetailDtoList.size(); k++){
								
								if(testDataDetailDtoList.get(j).getRptName().equals(testDataDetailDtoList.get(k).getRptCntName())){
									if(!tsdataFldName.equals(testDataDetailDtoList.get(k).getTsdataFldName())){
										tsdataFldName = testDataDetailDtoList.get(k).getTsdataFldName();
										rptCnt = 1;
									}
									
									String fldData = "";
									if(testDataDetailDtoList.get(j).getTsdataFldData() != null) fldData = testDataDetailDtoList.get(j).getTsdataFldData();
									
									String rptData = (String)gridMap.get(testDataDetailDtoList.get(k).getTsdataFldName()+"||-IG");
									if(rptData == null){
										rptData = "[{\""+testDataDetailDtoList.get(j).getTsdataFldName()+"\":\""+fldData+"\"}]";
									} else if(String.valueOf(rptCnt).equals(testDataDetailDtoList.get(j).getRptCnt().trim())) {
										rptData = rptData.substring(0, rptData.length()-2) + ",\"" + testDataDetailDtoList.get(j).getTsdataFldName()+"\":\""+fldData+"\"}]";
									} else if(!String.valueOf(rptCnt).equals(testDataDetailDtoList.get(j).getRptCnt().trim())) {
										rptData = rptData.substring(0, rptData.length()-1) + ",{\"" + testDataDetailDtoList.get(j).getTsdataFldName()+"\":\""+fldData+"\"}]";
										rptCnt++;
									}
									gridMap.put(testDataDetailDtoList.get(k).getTsdataFldName()+"||-IG", rptData);
									break;
								}
							}
						} else {
							gridMap.put(testDataDetailDtoList.get(j).getTsdataFldName()+"||-I", testDataDetailDtoList.get(j).getTsdataFldData());
						}
					}
				}//end for
				
				gridDataList.add(gridMap);
			}
			
			return gridDataList;
		}catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_TCMNGX0002","",e);
		}
	}
	
	/**
	 * <p>
	 * 테스트케이스 저장
	 * </p>
	 * <p>
	 * 1. 테스트케이스의 ID 존재유무를 파악하여 수정 및 생성(수정일 경우 테스트케이스ID의 상세정보를 삭제)
	 * 2. 거래코드에 해당하는 레이아웃을 조회하여 레이아웃DTO에 데이터를 담을 준비를 한다.
	 * 3. 그리드에서 전달받은 테스트데이터ID의 길이를 if문 분기(tsDataId.length < 16 : 신규생성, tsDataId.length > 16 : 사본, tsDataId.length < 16 : 신규생성)
	 * 	3.1 신규생성 	: 테스트데이터ID를 생성후 레이아웃DTO에 SET 저장
	 *  3.2 사본 		: 테스트데이터ID를 생성후 레이아웃DTO에 SET
	 *    3.2.1		     원본 테스트데이터ID에 해당하는 체크포인트를 DB에 조회하여 없으면 미설정 있으면 설정|미설정 여부를 판별하여 레이아웃에 SET 저장
	 *    3.2.2		     원본 테스트데이터ID에 해당하는 체크포인트가 존재시 원본 테스트데이터ID에 해당하는 체크포인트를 DB조회 후 테스트데이터ID만 변경하여 체크포인트 저장  
	 * 	3.2 원본 		: 테스트데이터ID 전달받아 레이아웃DTO에 SET 저장
	 * 4. 테스트데이터 상세처리 function 호출
	 * 5. 체크포인트 Hidden값 여부를 판별하여 값이 존재할 경우 체크포인트 처리 function 호출
	 * 6. 테스트케이스 상세 저장
	 * </p>
	 * @param request
	 * @param loginDto
	 * @return Map(tsCaseId 테스트케이스ID, tsDataIDList 테스트데이터ID)
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public synchronized Map doTcSave(HttpServletRequest request, LoginDto loginDto)  throws Exception{
		try{
			JSONArray jsonGridDataList = JSONArray.fromObject(request.getParameter("jgGridData"));
			
			//View의 그리드에 tsDataID값 세팅하기 위함.
			List tsDataIDList = new ArrayList();
			Map returnMap = new HashMap();
			
			String chnlDstcd 	= (request.getParameter("chnlDstcd").trim());
			String tranCd	 	= (request.getParameter("tranCd").trim());
			String tranName	 	= (request.getParameter("tranName").trim());
			String firstTsCaseID	= (request.getParameter("tsCaseID").trim());
			String tsCaseID		= (request.getParameter("tsCaseID").trim());
			String tsCaseName	= (request.getParameter("tsCaseName").trim());
			String tsCaseDesc	= (request.getParameter("tsCaseDesc").trim());
			
			//Login 사용자 정보 가져오기
			String writeId		= (request.getParameter("usrid").trim());
			String writeName 	= (request.getParameter("usrname").trim());
			
			//현재시간 
			String createYms = DateUtil.getDateString();
			
			//테스트데이터 ID List
			List<TestDataDto> tdDetailIdList = new ArrayList<TestDataDto>();
			//테스트케이스 기본
			TcDto tcDto = new TcDto();
			//테스트케이스 상세
			TcDetailDto tcDetailDto = new TcDetailDto();
			
			
			//테스트케이스 기본 Dto set
			tcDto.setTsCaseName(tsCaseName);
			tcDto.setTsCaseDesc(tsCaseDesc);
			tcDto.setChnlDstcd(chnlDstcd);
			tcDto.setTranCd(tranCd);
			tcDto.setTranName(tranName);
			tcDto.setDelYN("N");
			tcDto.setLastModfiID(writeId);
			tcDto.setLastModfiYMS(createYms);
			tcDto.setWriteID(writeId);
			tcDto.setWriteName(writeName);
			tcDto.setCretnYMS(createYms);
			
			//테스트케이스 상세 Dto set
			tcDetailDto.setLastModfiID(writeId);
			tcDetailDto.setLastModfiYMS(createYms);
			
			//기존테스트케이스 저장  처리
			if(tsCaseID != null && !("").equals(tsCaseID)){
				//테스트케이스 기본|상세 Dto에 set
				tcDto.setTsCaseID(tsCaseID);
				tcDetailDto.setTsCaseID(tsCaseID);
				
				try{
					//테스트케이스 기본 Update
					tcmngDao.modTestCase(tcDto);
				}catch (Exception e) {
					logger.error("", e);
					throw new BizException("MSG_TCMNGX0004","",e);
				}
				
				try{
					//테스트케이스 상세 Delete
					tcmngDao.delTestCaseDetail(tsCaseID);
				}catch (Exception e) {
					logger.error("", e);
					throw new BizException("MSG_TCMNGX0005","",e);
				}
				
			//테스트케이스 신규등록시 및 다른이름으로 저장 처리
			}else{
				try{
					tsCaseID = mngSeqIdBiz.getNewSeqId(MngSeqIdBiz.TEST_CASE, MngSeqIdBiz.TYPE_MSG);
				}catch (Exception e) {
					logger.error("", e);
					throw new BizException("MSG_TCMNGX0006","",e);
				}
				
				//테스트케이스 기본|상세 Dto에 set
				tcDto.setTsCaseID(tsCaseID);
				tcDetailDto.setTsCaseID(tsCaseID);
				
				try{
					//테스트케이스 기본 Insert
					tcmngDao.regTestCase(tcDto);
				}catch (Exception e) {
					logger.error("", e);
					throw new BizException("MSG_TCMNGX0007","",e);
				}
			}
			
			/*------------- 레이아웃 가져오기  시작---------------- */
			List<LayoutDetailDto> layoutDetailDtoList = new ArrayList<LayoutDetailDto>();
			LayoutDto layoutDto = layoutBiz.getLayout(chnlDstcd, tranCd, "I");
			
			//테스트데이터 상세
			if(layoutDto != null){
				
				layoutDetailDtoList = layoutDto.getHeaderList();
	
				//헤더부 레이아웃
				if(layoutDetailDtoList.size() > 0){
					layoutDto.setHeaderList(layoutDetailDtoList);
				}
				
				layoutDetailDtoList = layoutDto.getInviList();
				//개별부 레이아웃
				if(layoutDetailDtoList.size() > 0){
					layoutDto.setInviList(layoutDetailDtoList);
				}
			}
			/*------------- 레이아웃 가져오기  끝 ---------------- */
			
			for (Object objGridDataList : jsonGridDataList) {
				String chkYN = "N";
				//화면에서 받은 그리드 데이터
				Map gridDataMap = (Map)JSONObject.toBean((JSONObject)objGridDataList, Map.class);
				
				//tsdata01 insert|delete dto
				TestDataDto testDataDto = new TestDataDto();
				
				//헤더부|개별부 일련번호 시작점
				int startNum = 0;
				int rptCntNo = 0;
				
				String tsdataID = "";
							
				testDataDto.setTsdataName((String)gridDataMap.get("tsdataName"));
				testDataDto.setTsdataDesc((String)gridDataMap.get("tsdataDesc"));
				testDataDto.setTranCd(tranCd);
				testDataDto.setTranName(tranName);
				testDataDto.setChnlDstcd(chnlDstcd);
				
				testDataDto.setDelYN("N");
				testDataDto.setWriteID(writeId);
				testDataDto.setWriteName(writeName);
				testDataDto.setCretnYMS(createYms);
				testDataDto.setLastModfiID(writeName);
				testDataDto.setLastModfiYMS(createYms);
				
				
				/*------------- 테스트데이터 기본|상세 저장 시작 ---------------- */
				//신규생성
				if(16 > ((String)gridDataMap.get("tsdataID")).length()){
					try{
						tsdataID = mngSeqIdBiz.getNewSeqId(MngSeqIdBiz.TEST_DATA, MngSeqIdBiz.TYPE_MSG);
					}catch (Exception e) {
						logger.error("", e);
						throw new BizException("MSG_TCMNGX0008","",e);
					}
					
					//테스트데이터 ID List에 저장(추후 테스트케이스 상세에 저장)
					tdDetailIdList.add(testDataDto);
					
					//체크포인트 여부확인
					if ("".equals(gridDataMap.get("chkYNVal"))){
						testDataDto.setChkYN("N");
					}else{
						testDataDto.setChkYN(getTesChek((List<MorphDynaBean>)gridDataMap.get("chkYNVal")));
					}
					
					//테스트데이터01 Insert
					testDataDto.setTsdataID(tsdataID);
					
					try{
						tcmngDao.regTestData(testDataDto);
					}catch (Exception e) {
						logger.error("", e);
						throw new BizException("MSG_TCMNGX0009","",e);
					}
					
					
					/*------------- 상세-신규생성 헤더 시작 ---------------- */
					if(layoutDto.getHeaderList() != null){
						Map<String, Integer> rtnMap = regTcDetail(layoutDto.getHeaderList(), gridDataMap, "01", tsdataID, startNum, rptCntNo, loginDto);
						startNum = rtnMap.get("startNo");
						rptCntNo = rtnMap.get("rptCntNo");
						
					}
					
					/*------------- 상세-신규생성 개별 시작 ---------------- */
					if(layoutDto.getInviList() != null){
						regTcDetail(layoutDto.getInviList(), gridDataMap, "02", tsdataID, startNum, rptCntNo, loginDto);
					}
					
				//사본
				}else if(16 < ((String)gridDataMap.get("tsdataID")).length() || "".equals(firstTsCaseID)){
						
					try{
						tsdataID = mngSeqIdBiz.getNewSeqId(MngSeqIdBiz.TEST_DATA, MngSeqIdBiz.TYPE_MSG);
					}catch (Exception e) {
						logger.error("", e);
						throw new BizException("MSG_TCMNGX0008","",e);
					}
					
					//테스트데이터 ID List에 저장(추후 테스트케이스 상세에 저장)
					tdDetailIdList.add(testDataDto);
					
					//체크포인트 여부확인
					if ("".equals(gridDataMap.get("chkYNVal"))){
						//사본의 원본ID를 추출하여 체크포인트 select
						List<CheckPointDTO> checkPointDTOList = checkPointDao.getListCheckPoint(((String)gridDataMap.get("tsdataID")).substring(0, 16));
						
						if(checkPointDTOList.size() != 0){
							for(int i = 0; i < checkPointDTOList.size(); i++){
								if("Y".equals(checkPointDTOList.get(i).getChkYN())){
									chkYN = "Y";
									break;
								};
							}
							testDataDto.setChkYN(chkYN);
							
							//원본 체크포인트 select하여 신규ID로 변경후 저장 
							for (CheckPointDTO checkPointDTO : checkPointDTOList) {
								checkPointDTO.setTsdataID(tsdataID);
								tcmngDao.regTesChek(checkPointDTO);
							}
						}else{
							testDataDto.setChkYN(chkYN);
						}
					}else{
						testDataDto.setChkYN(getTesChek((List<MorphDynaBean>)gridDataMap.get("chkYNVal")));
					}
					
					//테스트데이터01 Insert
					testDataDto.setTsdataID(tsdataID);
					try{
						tcmngDao.regTestData(testDataDto);
					}catch (Exception e) {
						logger.error("", e);
						throw new BizException("MSG_TCMNGX0009","",e);
					}
					
					/*------------- 상세-신규생성 헤더 시작 ---------------- */
					if(layoutDto.getHeaderList() != null){
						Map<String, Integer> rtnMap = regTcDetail(layoutDto.getHeaderList(), gridDataMap, "01", tsdataID, startNum, rptCntNo, loginDto);
						startNum = rtnMap.get("startNo");
						rptCntNo = rtnMap.get("rptCntNo");
					}
					
					/*------------- 상세-신규생성 개별 시작 ---------------- */
					if(layoutDto.getInviList() != null){
						regTcDetail(layoutDto.getInviList(), gridDataMap, "02", tsdataID, startNum, rptCntNo, loginDto);
					}
					
				//원본
				}else{
					tsdataID = (String)gridDataMap.get("tsdataID");
					
					//테스트데이터 ID List에 저장(추후 테스트케이스 상세에 저장)
					tdDetailIdList.add(testDataDto);
					
					//체크포인트 여부확인(값이 존재 하지 않을시 변경된 값이 없기 때문에 없데이트를 해줄 필요가 없다.)
					if (!"".equals(gridDataMap.get("chkYNVal"))){
						testDataDto.setChkYN(getTesChek((List<MorphDynaBean>)gridDataMap.get("chkYNVal")));
					}
					
					//테스트데이터01 Update
					testDataDto.setTsdataID(tsdataID);
					try{
						tcmngDao.modTestData(testDataDto);
					}catch (Exception e) {
						logger.error("", e);
						throw new BizException("MSG_TCMNGX0010","",e);
					}
				
					try{
						//테스트데이터02 Delete
						tcmngDao.delTestDetailData(tsdataID);
					}catch (Exception e) {
						logger.error("", e);
						throw new BizException("MSG_TCMNGX0011","",e);
					}
					
					/*------------- 상세-신규생성 헤더 시작 ---------------- */
					if(layoutDto.getHeaderList() != null){
						Map<String, Integer> rtnMap = regTcDetail(layoutDto.getHeaderList(), gridDataMap, "01", tsdataID, startNum, rptCntNo, loginDto);
						startNum = rtnMap.get("startNo");
						rptCntNo = rtnMap.get("rptCntNo");
					}
					
					/*------------- 상세-신규생성 개별 시작 ---------------- */
					if(layoutDto.getInviList() != null){
						regTcDetail(layoutDto.getInviList(), gridDataMap, "02", tsdataID, startNum, rptCntNo, loginDto);
					}
				}
				
				//View의 그리드에 tsDataID값 세팅하기 위함.
				tsDataIDList.add(tsdataID);
				
				if (logger.isDebugEnabled()) logger.debug("gridDataMap : [" + gridDataMap + "]");
				
				//입력받은 체크포인트 값이 없을 경우 체크포인트 저장 패스!
				if ("".equals(gridDataMap.get("chkYNVal"))) continue; 
				
				List<MorphDynaBean> chkList = (List<MorphDynaBean>)gridDataMap.get("chkYNVal");
				
				//체크포인트 처리
				regTesChek(tsdataID, writeId, writeName, chkList);
			}// end for
		
			try{
				//테스트케이스 상세 등록
				tcmngDao.regTestCaseDetail(tcDetailDto, tdDetailIdList);
			}catch (Exception e) {
				logger.error("", e);
				throw new BizException("MSG_TCMNGX0012","",e);
			}
			
			returnMap.put("tsCaseID", tsCaseID);
			returnMap.put("tsDataIDList", tsDataIDList);
			
			return returnMap;
		}catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_TCMNGX0003","",e);
		}
		
	}// end function doTcSave()
	
	
	/**
	 * <p>
	 * 테스트데이터 상세 저장(공통함수)
	 * </p>
	 * <p>
	 * 1. 레이아웃(개별부|헤더부)를 for문을 돌면서 gridDataMap에서 데이터를 뽑아낸다.
	 * 	  - gridDataMap는 그리드에서 전달 받은 값으로 맵형태를 가지며 키 값은 레이아웃의 필드데이터+H or I(헤더부 or 개별부)으로 처리
	 * 1.1 for문을 돌면서 레이아웃의 RptName에 값 존재 유무를 판별하여 반복부를 처리한다.(미존재:일반필드 데이터, 존재:반복부 데이터)
	 * 1.1.1 일반필드 데이터 : 테스트데이터상세Dto에 레이아웃의 정보를 SET 저장
	 * 1.1.2 반복부 데이터 : 일반필드 데이터를 ADD한 List에서 역으로 for문을 돌면서 레이아웃 반복부명에 해당하는 반복부명과 반복횟수를 찾아낸다.
	 * 1.1.2.1 반복부 횟수만큼 for문을 돌고 또한  레이아웃의 size만큼 for문을 돌면서 테스트데이터를 저장한다. 
	 * </p>
	 * @param layoutDetailDtoList(레이아웃List(헤더, 개별))
	 * @param gridDataMap(그리드에서 받은 데이터 Row)
	 * @param fldDiv(01:헤더, 02:개별)
	 * @param startNum 일련번호
	 * @param loginDto 로그인Dto
	 * @return TsdataNo 다음 일련번호
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	private Map<String, Integer> regTcDetail(List<LayoutDetailDto> layoutDetailDtoList, Map gridDataMap, String fldDiv, String tsdataID, int startNum, int rptCntNo, LoginDto loginDto)  throws Exception{
		//일련번호 시작 초기화
		int startNo = startNum;
		//저장한 데스트데이터를 임시로 저장
		List<TestDataDetailDto> tempTestDataDetailDtoList = new ArrayList<TestDataDetailDto>();
		
		for(int i = 0; i < layoutDetailDtoList.size(); i++){
			LayoutDetailDto layoutDetailDto = layoutDetailDtoList.get(i);
			TestDataDetailDto testDataDetailDto = new TestDataDetailDto();
			
			String fldData = "";
			String fldRptData = "";
			
			//헤더부 개별부 구분
			if(fldDiv.equals("01")){
				fldData 	= (String)gridDataMap.get(layoutDetailDto.getFldName()+"||-H");
			}else{
				fldData 	= (String)gridDataMap.get(layoutDetailDto.getFldName()+"||-I");
			}
			
			//일반필드일 경우
			if(layoutDetailDto.getRptName() == null || "".equals(layoutDetailDto.getRptName())){
				//tsdata02 테이블에 insert 할 데이터 testDataDetailDto Set
				testDataDetailDto.setTsdataID(tsdataID);									//테스트데이터필드ID
				testDataDetailDto.setTsdataNO(Integer.toString(startNo++));					//테스트데이터필드일련번호
				testDataDetailDto.setTsdataFldName(layoutDetailDto.getFldName());			//테스트데이터필드명
				testDataDetailDto.setTsdataFldData(fldData);								//테스트데이터필드데이터
				testDataDetailDto.setTscsFldDiv(fldDiv);									//테스트데이터필드구분("01":헤더, "02":개별)
				testDataDetailDto.setTscsFldType(layoutDetailDto.getFldType());				//테스트데이터필드타입
				testDataDetailDto.setTscsFldAttrib(layoutDetailDto.getFldAttrib());			//테스트데이터필드속성
				testDataDetailDto.setTscsFldSizeCnt(layoutDetailDto.getTscsFldSize());		//테스트데이터필드크기
				testDataDetailDto.setTscsFldDesc(layoutDetailDto.getTscsFldDesc());			//테스트데이터필드설명
				testDataDetailDto.setLastModfiID(loginDto.getUsrid());						//최종변경자ID
				testDataDetailDto.setLastModfiYMS(DateUtil.getDateString());				//최종변경일시
				testDataDetailDto.setRmark(layoutDetailDto.getRmark());						//비고
				if("03".equals(layoutDetailDto.getFldAttrib())){
					testDataDetailDto.setRptCntName("RPT"+String.valueOf(rptCntNo));		//반복부명
					rptCntNo++;
				}else{
					testDataDetailDto.setRptCntName("");									//반복부명
				}
				testDataDetailDto.setRptName("");											//반복부전체회차필드명
				testDataDetailDto.setRptCnt("");											//반복부회차
				
				try{	
					//tsdata02 테이블에 insert 한다.
					tcmngDao.regTestDataDetail(testDataDetailDto);
				}catch (Exception e) {
					logger.error("", e);
					throw new BizException("MSG_TCMNGX0013","",e);
				}
				
				tempTestDataDetailDtoList.add(testDataDetailDto);
			}else{
				//반복부명
				String rptFldName = layoutDetailDto.getRptName();
				
				//반복횟수, 반복부명 가져오기
				int rtpCount = 0;
				String rptName = null;
				for(int j = tempTestDataDetailDtoList.size()-1 ; j >= 0 ; j--){
					TestDataDetailDto tempTestDataDetailDto = tempTestDataDetailDtoList.get(j);
					if(rptFldName.equals(tempTestDataDetailDto.getTsdataFldName())){
						if("hex".equals(tempTestDataDetailDto.getTscsFldType())){	//hex
							rtpCount = TransUtil.parseHex(tempTestDataDetailDto.getTsdataFldData());
						} else {
							rtpCount = Integer.parseInt(tempTestDataDetailDto.getTsdataFldData().trim());
						}
						//반복부명
						rptName = tempTestDataDetailDto.getRptCntName();
					}
				}
				
				//반복부 파싱이 끝난후 레이아웃 인덱스 위치
				int nextIndex = i;
				
				//반복횟수만큼 반복한다
				for(int j = 0 ; j < rtpCount ; j++){
					
					List<MorphDynaBean> jsonDataList;
					
					//반복데이터 가져오기
					if(fldDiv.equals("01")){
						jsonDataList = (List<MorphDynaBean>)gridDataMap.get(rptFldName+"||-HG");
					}else{
						jsonDataList = (List<MorphDynaBean>)gridDataMap.get(rptFldName+"||-IG");
					}
					
					MorphDynaBean rptDataMap = jsonDataList.get(j);
					
					int k = i;
					for( ; k < layoutDetailDtoList.size() ; k++){
						if(!rptFldName.equals(layoutDetailDtoList.get(k).getRptName())){	//반복부가 끝나면 첫번째로 되돌아간다
							break;
						} else {	//반복부일 경우
							
							//바이트를 파싱하여 DTO에 추가한다
							TestDataDetailDto rptTestDataDetailDto = new TestDataDetailDto();
							
							//DTO필드속성 세팅
							rptTestDataDetailDto.setTsdataID(tsdataID);											//테스트데이터필드ID
							rptTestDataDetailDto.setTsdataNO(String.valueOf(startNo++));						//테스트데이터필드일련번호
							rptTestDataDetailDto.setTsdataFldName(layoutDetailDtoList.get(k).getFldName());		//테스트데이터필드명
							rptTestDataDetailDto.setTsdataFldData((String)rptDataMap.get(layoutDetailDtoList.get(k).getFldName()));	//테스트데이터필드데이터
							rptTestDataDetailDto.setTscsFldDiv(fldDiv);											//테스트데이터필드구분("01":헤더, "02":개별)
							rptTestDataDetailDto.setTscsFldType(layoutDetailDtoList.get(k).getFldType());		//테스트데이터필드타입
							rptTestDataDetailDto.setTscsFldAttrib(layoutDetailDtoList.get(k).getFldAttrib());	//테스트데이터필드속성
							rptTestDataDetailDto.setTscsFldSizeCnt(layoutDetailDtoList.get(k).getTscsFldSize());//테스트데이터필드크기
							rptTestDataDetailDto.setTscsFldDesc(layoutDetailDtoList.get(k).getTscsFldDesc());	//테스트데이터필드
							rptTestDataDetailDto.setLastModfiID(loginDto.getUsrid());							//최종변경자ID
							rptTestDataDetailDto.setLastModfiYMS(DateUtil.getDateString());						//최종변경일시
							rptTestDataDetailDto.setRmark(layoutDetailDto.getRmark());							//비고
							rptTestDataDetailDto.setRptCntName("");
							rptTestDataDetailDto.setRptName(rptName);											//반복부전체회차필드명
							rptTestDataDetailDto.setRptCnt(String.valueOf(j+1));								//반복부회차
						
							try{
								//tsdata02 테이블에 insert 한다.
								tcmngDao.regTestDataDetail(rptTestDataDetailDto);
							}catch (Exception e) {
								logger.error("", e);
								throw new BizException("MSG_TCMNGX0013","",e);
							}
							
						}
						nextIndex = k;	//반복부의 마지막 인덱스
					}
				}
				i = nextIndex;
			}
			
		}
		
		Map<String, Integer> rtnMap = new HashMap<String, Integer>();
		rtnMap.put("startNo", startNo);
		rtnMap.put("rptCntNo", rptCntNo);
		
		return rtnMap;
	}
	
	
	/**
	 * <p>
	 * 테스트데이터 체크포인트(공통함수)
	 * </p>
	 * <p>
	 * 1. 레이아웃을 조회한다.
	 * 2. 레이아웃의 size만큼 for문을 돌면서 전달받은 체크포인트의 키값과 일치하는 데이터를 찾는다.
	 * 2.1 일치하는 데이터가 존재시  checkPointDTO에 데이터를 담고  List에 ADD한다.
	 * 3. 테스트ID에 해당하는 체크포인트를 DB에서 삭제처리
	 * 4. checkPointDTO를 담은 List의 size만큼 for문을 돌면서 체크포인트를 저장
	 * </p>
	 * @param pTsdataID 테스트데이터ID
	 * @param writeId 	작성자ID
	 * @param writeName 작성자명
	 * @param pChkList 	입력받은 체크포인트 List
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void regTesChek(String pTsdataID, String writeId, String writeName, List<MorphDynaBean> pChkList){
		
		//체크포인트 리스트
		List<MorphDynaBean> chkList = pChkList;
		
		//테스트데이터 기본 정보
		TestDataDto testDataDto = tcmngDao.getTsData(pTsdataID);
		
		String chnlDstcd = testDataDto.getChnlDstcd();
		String tranCd	=  testDataDto.getTranCd();
		String tsdataID = pTsdataID;
		String cretnYMS = DateUtil.getDateString();		//현재날짜시간
		
		/*------------- 레이아웃 가져오기  시작---------------- */
		LayoutDto layoutDto = layoutBiz.getLayout(chnlDstcd, tranCd, "O");
		List<LayoutDetailDto> layoutDetailDtoList = new ArrayList<LayoutDetailDto>();
		
		//테스트데이터 상세
		if(layoutDto != null){
			//헤더부 레이아웃
			layoutDetailDtoList = layoutDto.getHeaderList();
						
			//개별부 레이아웃
			if(layoutDto.getInviList().size() > 0){
				layoutDetailDtoList.addAll(layoutDto.getInviList());
			}
		}
		/*------------- 레이아웃 가져오기  끝 ---------------- */
		
		List<CheckPointDTO> checkPointList = new ArrayList<CheckPointDTO>();
		
		for(int i = 0; i < layoutDetailDtoList.size(); i++){
			LayoutDetailDto rstLayoutDto = layoutDetailDtoList.get(i);	//layOut
			for (MorphDynaBean bean : chkList) {
				//레이아웃에 필드명과 일치하는 데이터 확인
				if(rstLayoutDto.getFldName().equals(bean.get("tsdataFldName"))){
					CheckPointDTO checkPointDTO = new CheckPointDTO();
					
					checkPointDTO.setTsdataID(tsdataID);
					checkPointDTO.setChkNO(i+1);
					checkPointDTO.setTsdataFldName((String)bean.get("tsdataFldName"));
					checkPointDTO.setTsdataDesc((String)rstLayoutDto.getTscsFldDesc());
					checkPointDTO.setChkPointExpcCtnt((String)bean.get("chkPointExpcCtnt"));
					checkPointDTO.setChkYN((String)bean.get("chkYN"));
					checkPointDTO.setTscsFldDesc((String)rstLayoutDto.getTscsFldDesc());
					checkPointDTO.setTscsFldDiv((String)bean.get("tscsFldDiv"));
					checkPointDTO.setTscsFldType(rstLayoutDto.getFldType());
					checkPointDTO.setTscsFldAttrib(rstLayoutDto.getFldAttrib());
					checkPointDTO.setWriteID(writeId);
					checkPointDTO.setWriteName(writeName);
					checkPointDTO.setCretnYMS(cretnYMS);
					checkPointDTO.setLastModfiID(writeName);
					checkPointDTO.setLastModfiYMS(cretnYMS);
					
					checkPointList.add(checkPointDTO);
				}
			}
		}
		
		try{	
			//기존 체크포인트 삭제
			tcmngDao.delTesChek(tsdataID);
		}catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_TCMNGX0014","",e);
		}
		
		
		//체크포인트 저장
		for (CheckPointDTO checkPointDTO : checkPointList) {
			if(logger.isDebugEnabled()) logger.debug("checkPointDTO : " + checkPointDTO);
			
			try{
				tcmngDao.regTesChek(checkPointDTO);
			}catch (Exception e) {
				logger.error("", e);
				throw new BizException("MSG_TCMNGX0015","",e);
			}
		}
	}
	
	
	/**
	 * <p>
	 * 테스트데이터 체크포인트 설정여부
	 * </p>
	 * @param pChkList 입력받은 체크포인트 List
	 * @return String 설정여부(Y:설정, N:미설정)
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public String getTesChek(List<MorphDynaBean> pChkList){
		
		//체크포인트 리스트
		List<MorphDynaBean> chkList = pChkList;
		String chkYN = "N";
		
		for (MorphDynaBean bean : chkList) {
			if("Y".equals((String)bean.get("chkYN"))){
				chkYN = "Y";
				break;
			};
		}
		return chkYN;
	}


	/**
	 * <p>
	 * 테스트케이스 실행
	 * </p>
	 * @param tsCaseID 	테스트케이스ID
	 * @param usrid		작성자ID
	 * @param tsDataID	테스트데이터ID
	 * @param acmplNth	회차
	 * @return Map		회차, 성공여부(Y:성공, N:실패)
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Map firstExcuteTc(HttpServletRequest request) {
		Map returnMap = new HashMap();
		
		String tsCaseID = request.getParameter("tsCaseID");
		String usrid = request.getParameter("usrid");
		
		String tsDataID = request.getParameter("tsDataID");
		String acmplNth = request.getParameter("acmplNth");
		
		detailSussYN = "Y";		//실행결과 초기화
		String returnAcmplNth = excuteTc(tsCaseID, tsDataID, usrid, acmplNth, null);
		
		
		returnMap.put("acmplNth", returnAcmplNth);
		returnMap.put("sussYN", detailSussYN);
		
		return returnMap;
	}
	
	
	/**
	 * <p>
	 * 테스트케이스 실행(화면실행 및 스케쥴러실행)
	 * </p>
	 * <p>
	 * 공통으로 사용하는 function으로 화면에서 실행 및 스케쥴러에 의한 실행에 대하여 처리
	 * 화면에서 실행될경우 인자값 모두를 받으며 스케쥴러에 의하여 실행될경우는 pTsCaseID와 pUsrid만 받고 나머지는 인자값은 null로 받는다.
	 * 1. 사용자ID를 통하여 사용자 정보 및 프로젝트정보를 조회 하여 loginDto에 담는다.
	 * 2. 전달받은 인자값중 pAcmplNth(수행회차)의 값 존재 유무를 파악하여 수행회차를 설정한다.
	 * 3. 전달받은 인자값중tsDataID(테스트데이터ID)의 값 존재 유무를 파악하여 화면에서의 실행인지 스케쥴러에 의한 실행인지를 판별한다.
	 * 3.1 화면의 실행
	 * 3.1.1  전문실행 및 테스트데이터 실적 저장 처리 BIZ를 호출하여 결과 값을 리턴 받는다.
	 * 3.1.2 리턴받은 값을 rptCaseDetailDto에 SET하여 테스트케이스상세실적 저장처리
	 * 3.1.2 테스트결과를 테스트케이스실적에 Update한다.
	 * 3.2 스케쥴러의 실행
	 * 3.2.1  테스트케이스에 해당하는 테스트데이터List를 조회한다.
	 * 3.2.1 list의 size만큼 for문을 돌면서 전문실행 및 테스트데이터 실적 저장 처리 BIZ를 호출하여 결과 값을 리턴 받고 테스트케이스상세실적을 저장한다. 
	 * 3.2.2 테스트결과를 테스트케이스실적에 Update한다.
	 * </p>
	 * @param tsCaseID 		테스트케이스ID
	 * @param tsDataIDList	실행할 테스트데이터ID List
	 * @param pAcmplNth		회차
	 * @return String 		수행회차
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public synchronized String excuteTc(String pTsCaseID, String tsDataID, String pUsrid, String pAcmplNth, String connSevrDstCd) {
		try{
			RptCaseDto rptCaseDto = new RptCaseDto();
			Map param = new HashMap();
			
			//테스트케이스 ID
			String tsCaseID = pTsCaseID;
			//로그인 정보
			String usrid = pUsrid;
			
			param.put("usrid", pUsrid);
			
			LoginDto userinfo;
			LoginDto projectinfo;
			
			userinfo = loginDao.getUserIdInfo(usrid);
			if( null != userinfo){
				projectinfo = loginDao.getprojectinfo(param);
				if( null != projectinfo){
					userinfo.setProjno(projectinfo.getProjno());
					userinfo.setProjname(projectinfo.getProjname());
					userinfo.setTeststgename(projectinfo.getTeststgename());
					if(connSevrDstCd == null){
						userinfo.setConnsevrdstcd(projectinfo.getConnsevrdstcd());
					} else {
						userinfo.setConnsevrdstcd(connSevrDstCd);
					}
					userinfo.setTeststartyms(projectinfo.getTeststartyms());
					userinfo.setTestendyms(projectinfo.getTestendyms());
					
				}else{
					userinfo.setProjname("정보없음");
					userinfo.setTeststgename("정보없음");
				}
			}
			if (logger.isDebugEnabled()) logger.debug("#########로그인 사용자 정보 STR##############################");
			if (logger.isDebugEnabled()) logger.debug("userinfo.getUsrid       ==>"+userinfo.getUsrid       ());
			if (logger.isDebugEnabled()) logger.debug("userinfo.getUsrname     ==>"+userinfo.getUsrname     ());
			if (logger.isDebugEnabled()) logger.debug("userinfo.getUsrlevel    ==>"+userinfo.getUsrlevel    ());
			if (logger.isDebugEnabled()) logger.debug("userinfo.getProjno      ==>"+userinfo.getProjno      ());
			if (logger.isDebugEnabled()) logger.debug("userinfo.getProjname    ==>"+userinfo.getProjname    ());
			if (logger.isDebugEnabled()) logger.debug("userinfo.getTeststgename==>"+userinfo.getTeststgename());
			if (logger.isDebugEnabled()) logger.debug("userinfo.getTeststartyms==>"+userinfo.getTeststartyms());
			if (logger.isDebugEnabled()) logger.debug("userinfo.getTestendyms  ==>"+userinfo.getTestendyms  ());
			if (logger.isDebugEnabled()) logger.debug("#########로그인 사용자 정보 END##############################");
	
			TcDto tcDto = tcmngDao.getTsCaseInfo(tsCaseID);
			
			if (logger.isDebugEnabled()) logger.debug("#########테스트케이스 정보  STR##############################");
			if (logger.isDebugEnabled()) logger.debug("tcDto.getTsCaseID()   ==>"+tcDto.getTsCaseID());
			if (logger.isDebugEnabled()) logger.debug("tcDto.getTsCaseName() ==>"+tcDto.getTsCaseName());
			if (logger.isDebugEnabled()) logger.debug("tcDto.getTsCaseDesc() ==>"+tcDto.getTsCaseDesc());
			if (logger.isDebugEnabled()) logger.debug("tcDto.getChnlDstcd()  ==>"+tcDto.getChnlDstcd());
			if (logger.isDebugEnabled()) logger.debug("tcDto.getTranCd()     ==>"+tcDto.getTranCd());
			if (logger.isDebugEnabled()) logger.debug("tcDto.getTranName()   ==>"+tcDto.getTranName());
			if (logger.isDebugEnabled()) logger.debug("tcDto.getWriteID()    ==>"+tcDto.getWriteID());
			if (logger.isDebugEnabled()) logger.debug("tcDto.getWriteName()  ==>"+tcDto.getWriteName());
			if (logger.isDebugEnabled()) logger.debug("#########테스트케이스 정보 END##############################");
			
			String  tstrID = userinfo.getUsrid();
			String  tstrName = userinfo.getUsrname();
			String  mgrLvelDstcd = userinfo.getUsrlevel();
			String  connSevrDstcd = userinfo.getConnsevrdstcd();
			String  projNo = userinfo.getProjno();
			String  projName = userinfo.getProjname();
			String  testStgeName = userinfo.getTeststgename();
	
			tsCaseID = tcDto.getTsCaseID();
			String tsCaseName = tcDto.getTsCaseName();
			String tsCaseDesc = tcDto.getTsCaseDesc();
			String chnlDstcd =  tcDto.getChnlDstcd();
			String tranCd = tcDto.getTranCd();
			String tranName = tcDto.getTranName();
			String writeID = tstrID;
			String writeName = tstrName;
			
			String cretnYMS = DateUtil.getDateString();	//현재날짜시간
			String lastModfiID	= tcDto.getWriteID();
			String lastModfiYMS = DateUtil.getDateString();
			
			String strDate = DateUtil.getDateString();	//현재날짜시간(시간을 동일하게 저장하기 위해)
			
	
			rptCaseDto.setTsCaseID(tsCaseID);			//테스트케이스ID
			rptCaseDto.setTsCaseName(tsCaseName);		//테스트케이스명
			rptCaseDto.setTsCaseDesc(tsCaseDesc);		//테스트케이스설명
			rptCaseDto.setChnlDstcd(chnlDstcd);			//채널코드
			rptCaseDto.setTranCd(tranCd);				//거래코드
			rptCaseDto.setTranName(tranName);			//거래코드명
			rptCaseDto.setMgrLvelDstcd(mgrLvelDstcd);	//관리자레벨구분코드
			rptCaseDto.setConnSevrDstcd(connSevrDstcd);	//접속서버구분코드
			rptCaseDto.setProjNo(projNo);				//프로젝트번호
			rptCaseDto.setProjName(projName);			//프로젝트명
			rptCaseDto.setTstrID(tstrID);				//테스터사용자ID
			rptCaseDto.setTstrName(tstrName);			//테스터명
			rptCaseDto.setTestStartYMS(strDate);		//테스트시작일시
			rptCaseDto.setTestEndYMS("");				//테스트종료일시
			rptCaseDto.setTestStgeName(testStgeName);	//테스트단계명
			rptCaseDto.setWriteID(writeID);				//작성자ID
			rptCaseDto.setWriteName(writeName);			//작성자명
			rptCaseDto.setCretnYMS(strDate);			//생성일시
			rptCaseDto.setLastModfiID(lastModfiID);		//최종변경자ID
			rptCaseDto.setLastModfiYMS(strDate);		//최종변경일시
			
			
			String strAcmplNth = "";					//수행회차 
			int acmplNth = 0;
			if("".equals(pAcmplNth) || pAcmplNth == null){
				
				acmplNth = registerRptCase(rptCaseDto, tsCaseID);
				
				//거래성공여부 초기화
				sussYN = "Y";
				sussMSG = "거래성공";
			}else{
				acmplNth = Integer.parseInt(pAcmplNth);	
				rptCaseDto.setAcmplNth(acmplNth);				//수행회차
			}
			
			//실행할 테스트데이터 리스트
			if(tsDataID != null && !"".equals(tsDataID)){
				Map parMap = new HashMap();
				parMap.put("tsCaseID", tsCaseID);
				parMap.put("acmplNth", acmplNth);
				
				//일련번호 받아오기
				int tsCaseNoSeq = tcmngDao.getTsCaseNo(parMap).intValue();
				String tsCaseNo = new DecimalFormat("000").format(tsCaseNoSeq);
				
				//전문실행 및 테스트데이터 실적 저장 처리
				RptTestDataBasicDTO rptTestDataBasicDTO = testDataExecuteBiz.executeTestData(tsDataID, userinfo);
				
				RptCaseDetailDto rptCaseDetailDto = new RptCaseDetailDto();
				rptCaseDetailDto.setTsCaseID(tsCaseID);
				rptCaseDetailDto.setAcmplNth(acmplNth);
				rptCaseDetailDto.setTsCaseNo(tsCaseNo);
				rptCaseDetailDto.setTsDataID(rptTestDataBasicDTO.getTsdataID());
				rptCaseDetailDto.setTsDataName(rptTestDataBasicDTO.getTsdataName());
				rptCaseDetailDto.setTsDataAcmpLnth(rptTestDataBasicDTO.getAcmplNth());
				rptCaseDetailDto.setRsultSucssYN(rptTestDataBasicDTO.getRsultSucssYN());
				rptCaseDetailDto.setLastModfiID(lastModfiID);
				rptCaseDetailDto.setLastModfiYMS(strDate);
				
				detailSussYN = rptTestDataBasicDTO.getRsultSucssYN();
				try{
					//테스트케이스 상세실적 저장
					tcmngDao.regRptCaseDetail(rptCaseDetailDto);
				}catch (Exception e) {
					logger.error("", e);
					throw new BizException("MSG_TCMNGX0018","",e);
				}
				
				if(!"Y".equals(rptTestDataBasicDTO.getRsultSucssYN())){
					sussYN = "N";
					sussMSG = "거래실패";
				}
				
				rptCaseDto.setRsultSucssYN(sussYN);
				rptCaseDto.setRsultMsg(sussMSG);
				rptCaseDto.setTestEndYMS(strDate);
				
				try{
					//테스트케이스 기본실적 수정
					tcmngDao.modRptCase(rptCaseDto);
				}catch (Exception e) {
					logger.error("", e);
					throw new BizException("MSG_TCMNGX0019","",e);
				}
			}else{
				// 스케쥴러에서 실행함.
				List<TestDataDto> testDataDtoList = tcmngDao.getTdList(tsCaseID);
				String rsultSussYN = "Y";
				String rsultSussMSG = "거래성공";
				
				for(int i = 0; i < testDataDtoList.size(); i++){
					Map parMap = new HashMap();
					parMap.put("tsCaseID", tsCaseID);
					parMap.put("acmplNth", acmplNth);
					
					//일련번호 받아오기
					int tsCaseNoSeq = tcmngDao.getTsCaseNo(parMap).intValue();
					String tsCaseNo = new DecimalFormat("000").format(tsCaseNoSeq);
					
					//전문실행 및 테스트데이터 실적 저장 처리
					RptTestDataBasicDTO rptTestDataBasicDTO = testDataExecuteBiz.executeTestData(testDataDtoList.get(i).getTsdataID(), userinfo);
					
					RptCaseDetailDto rptCaseDetailDto = new RptCaseDetailDto();
					rptCaseDetailDto.setTsCaseID(tsCaseID);
					rptCaseDetailDto.setAcmplNth(acmplNth);
					rptCaseDetailDto.setTsCaseNo(tsCaseNo);
					rptCaseDetailDto.setTsDataID(rptTestDataBasicDTO.getTsdataID());
					rptCaseDetailDto.setTsDataName(rptTestDataBasicDTO.getTsdataName());
					rptCaseDetailDto.setTsDataAcmpLnth(rptTestDataBasicDTO.getAcmplNth());
					rptCaseDetailDto.setRsultSucssYN(rptTestDataBasicDTO.getRsultSucssYN());
					rptCaseDetailDto.setLastModfiID(lastModfiID);
					rptCaseDetailDto.setLastModfiYMS(DateUtil.getDateString());
				
					try{
						//테스트케이스 상세실적 저장
						tcmngDao.regRptCaseDetail(rptCaseDetailDto);
					}catch (Exception e) {
						logger.error("", e);
						throw new BizException("MSG_TCMNGX0018","",e);
					}
					
					if(!"Y".equals(rptTestDataBasicDTO.getRsultSucssYN())){
						rsultSussYN = "N";
						rsultSussMSG = "거래실패";
					}
				}//for end
				
				rptCaseDto.setRsultSucssYN(rsultSussYN);
				rptCaseDto.setRsultMsg(rsultSussMSG);
				rptCaseDto.setTestEndYMS(DateUtil.getDateString());
			
				try{
					//테스트케이스 기본실적 수정
					tcmngDao.modRptCase(rptCaseDto);
				}catch (Exception e) {
					logger.error("", e);
					throw new BizException("MSG_TCMNGX0019","",e);
				}
				
			}
			return Integer.toString(acmplNth); //수행회차 리턴
		}catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_TCMNGX0016","",e);
		}
	}

	/**
	 * 
	 * <p>
	 * 테스트케이스기본실적 저장
	 * <p>
	 * @param rptCaseDto 테스트케이스기본실적 DTO
	 * @param tsCaseID 테스트케이스ID
	 * @return
	 */
	private synchronized int registerRptCase(RptCaseDto rptCaseDto, String tsCaseID) {
		String strAcmplNth;
		int acmplNth;
		//수행회차 받아오기
		strAcmplNth = tcmngDao.getAcmplNth(tsCaseID);
		if(strAcmplNth == null){
			acmplNth = 1;
		}else{
			acmplNth = Integer.parseInt(strAcmplNth) + 1;	
		}
		
		rptCaseDto.setAcmplNth(acmplNth);				//수행회차
		
		try{
			//테스트케이스기본실적 저장
			tcmngDao.regRptCase(rptCaseDto);			
		}catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_TCMNGX0017","",e);
		}
		return acmplNth;
	}
	

	/**
	 * <p>
	 * 테스트데이터의 체크포인트 리스트 조회
	 * </p>
	 * @param tsDataIDList 	체크된 테스트데이터ID
	 * @param tsCaseID		테스트케이스ID
	 * @return List			CheckPointDTO를 담은 List
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public ArrayList<CheckPointDTO> getListCheckDTO(
		List<LayoutDetailDto> detailAllList, String tsdataID) {
		
		try{	
			ArrayList<CheckPointDTO> checkPointDTOs = new ArrayList<CheckPointDTO>();
			for(int i = 0; i < detailAllList.size(); i++){
				LayoutDetailDto layoutDetailDto = detailAllList.get(i);	//layOut을 담음
				
				CheckPointDTO checkPointDTO = new CheckPointDTO();
				checkPointDTO.setChkYN("");
				checkPointDTO.setTsdataFldName(layoutDetailDto.getFldName());
				checkPointDTO.setTsdataFld(layoutDetailDto.getFldName()+"(" + layoutDetailDto.getTscsFldDesc() + ")");
				checkPointDTO.setChkPointExpcCtnt("");
				checkPointDTO.setTscsFldDiv(layoutDetailDto.getFldDiv());
				checkPointDTO.setTscsFldSize(layoutDetailDto.getTscsFldSize());
				
				checkPointDTOs.add(checkPointDTO);
			}
			
			if(tsdataID != null && !"".equals(tsdataID) ){
				List<CheckPointDTO> dtos = checkPointDao.getListCheckPoint(tsdataID);
				
				for(CheckPointDTO dto :  checkPointDTOs){
					String tsdataFldName =  dto.getTsdataFldName();
					if(tsdataFldName == null){
						tsdataFldName = "";
					}else{
						tsdataFldName = tsdataFldName.trim();
					}
					
					for(CheckPointDTO dto2 : dtos){
						if(tsdataFldName.equals(dto2.getTsdataFldName())){
							dto.setChkYN(dto2.getChkYN());
							dto.setChkPointExpcCtnt(dto2.getChkPointExpcCtnt());
							
							break;
						}
					}
				}
			}
			return checkPointDTOs;

			}catch (Exception e) {
				logger.error("", e);
				throw new BizException("MSG_CHKPOP0001","",e);
			}
	}
}
