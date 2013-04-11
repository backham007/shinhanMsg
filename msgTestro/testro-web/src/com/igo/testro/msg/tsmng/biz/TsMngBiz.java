package com.igo.testro.msg.tsmng.biz;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.igo.testro.cmn.login.dto.LoginDto;
import com.igo.testro.cmn.utils.DateUtil;
import com.igo.testro.cmn.utils.TransUtil;
import com.igo.testro.exception.BizException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.cmn.biz.MngSeqIdBiz;
import com.igo.testro.msg.layout.biz.ILayoutBiz;
import com.igo.testro.msg.layout.dto.LayoutDetailDto;
import com.igo.testro.msg.layout.dto.LayoutDto;
import com.igo.testro.msg.pretst.dto.TestDataDetailDto;
import com.igo.testro.msg.pretst.dto.TestDataDto;
import com.igo.testro.msg.tcmng.dto.CheckPointDTO;
import com.igo.testro.msg.tsmng.dao.TsMngDao;
import com.igo.testro.msg.tsmng.dto.IODataUseDTO;
import com.igo.testro.msg.tsmng.dto.TestSnrioBasicDTO;
import com.igo.testro.msg.tsmng.dto.TestSnrioDetailDTO;

/**
 * <p>
 * 프로그램명:TsMngBiz.java<br/>
 * 설명 : 테스트 시나리오 관리 Biz<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 9. : 김기태 : 최초작성
 * </ul> 
 * </p>
 */
public class TsMngBiz {
	final ITestroLogger logger = TestroLogHelper.getBiz();
	
	@Autowired
	private TsMngDao tsMngDao;
	@Autowired
	private MngSeqIdBiz mngSeqIdBiz;
	@Autowired
	private ILayoutBiz layoutBiz;
	
	/**
	 * <p>
	 * 테스트 시나리오 가져오기
	 * <p>
	 * <p>테스트 시나리오 기본 정보 가져옴
	 * <p>테스트 시나리오 상세 정보 가져옴
	 * <p>입출력값 정보를 가져옴
	 * @param tsSnrioID - 테스트 시나리오 아이디
	 * @return 테스트 시나리오 정보
	 */
	@Transactional(readOnly = true)
	public TestSnrioBasicDTO getTsInfo(String tsSnrioID) {
		//테스트 시나리오 기본 정보 가져옴
		TestSnrioBasicDTO testSnrioBasicDTO = this.getTsBasicInfo(tsSnrioID);
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("tsSnrioID", tsSnrioID);
		params.put("sidx", "tsSnrioNO");
		params.put("sord", "asc");
		
		//테스트 시나리오 상세 정보 가져옴
		List<TestSnrioDetailDTO> testSnrioDetailDTOs = tsMngDao.getListTsDetailInfo(params);
		testSnrioBasicDTO.setTestSnrioDetailDTOList(testSnrioDetailDTOs);
		
		List<String> tsdataIDs = new ArrayList<String>();
		if(testSnrioDetailDTOs != null){
			for(TestSnrioDetailDTO testSnrioDetailDTO : testSnrioDetailDTOs){
				//입출력값 정보를 가져옴
				if("Y".equals(testSnrioDetailDTO.getUseIO())){
					testSnrioDetailDTO.setIoDataUseDTOList(tsMngDao.getListIoDataUseDTO(tsSnrioID, testSnrioDetailDTO.getTsSnrioNO()));
				}
				
				tsdataIDs.add(testSnrioDetailDTO.getTsdataID());
			}
		}
		
		//테스트 데이터는 시나리오 상세수만큼 빈 List를 넣는다
		testSnrioBasicDTO.setTestDataDtos(new ArrayList<TestDataDto>(tsdataIDs.size()));
		
		return testSnrioBasicDTO;
	}
	
	/**
	 * <p>
	 * 테스트 시나리오 기본 정보가져오기
	 * <p>
	 * @param tsSnrioID - 테스트 시나리오 아이디
	 * @return 테스트 시나리오 기본정보
	 */
	@Transactional(readOnly = true)
	public TestSnrioBasicDTO getTsBasicInfo(String tsSnrioID) {
		return tsMngDao.getTsBasicInfo(tsSnrioID);
	}
	
	/**
	 * <p>
	 * 테스트 시나리오 저장
	 * <p>
	 * <p>테스트 시나리오 기본저장
	 * <p>테스트 데이터가 복사본이거나 수정본이면 저장
	 * <p>테스트 시나리오 상세를 저장
	 * @param tsSnrioDesc 
	 * @param tsSnrioName 
	 * @param tsSnrioID2 
	 * @param testSnrioBasicDTO - 테스트 시나리오 정보
	 * @param isNew - 다른이름 저장인지 여부
	 * @return - 테스트 시나리오 정보
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public TestSnrioBasicDTO registerTsInfo(
			String tsSnrioID
			, String tsSnrioName
			, String tsSnrioDesc
			, JSONArray jsonArrayTsDetailDTOList
			, JSONArray jsonArrayIODataUseDTOList
			, JSONArray jsonArrayTestDataDTOList
			, boolean isNew
			, LoginDto loginDto) {
		
		String loginUsrId = loginDto.getUsrid();
		String loginUsrName = loginDto.getUsrname();
		String currentDate = DateUtil.getDateString();
		
		TestSnrioBasicDTO testSnrioBasicDTO = new TestSnrioBasicDTO();
		try {
			//저장할 테스트 시나리오 기본 정보 저장
			testSnrioBasicDTO.setTsSnrioID(tsSnrioID);
			testSnrioBasicDTO.setTsSnrioName(tsSnrioName);
			testSnrioBasicDTO.setTsSnrioDesc(tsSnrioDesc);
			if(isNew){//다른이름 저장이면 작성자와 작성일 새로 셋팅
				testSnrioBasicDTO.setWriteID(loginUsrId);
				testSnrioBasicDTO.setWriteName(loginUsrName);
				testSnrioBasicDTO.setCretnYMS(currentDate);
			}
			testSnrioBasicDTO.setLastModfiID(loginUsrId);
			testSnrioBasicDTO.setLastModfiYMS(currentDate);
			
			//테스트 시나리오 기본정보를 저장하거나 수정한다.		
			if(isNew){//다른이름 저장이면 테스트시나리오 기본을 저장한다.
				//새로운 시나리오 아이디를 가져온다.
				tsSnrioID = this.registerTsBasicInfo(testSnrioBasicDTO);
			}else{//단순 저장이면 시나리오 기본을 수정, 테스시나리오 상세 삭제, 입출력값활용 삭제
				tsMngDao.modifyTsBasicInfo(testSnrioBasicDTO);
				tsMngDao.deleteTsDetailInfo(testSnrioBasicDTO);
				tsMngDao.deleteIODataUseInfo(testSnrioBasicDTO);
			}
			
			//저장할 테스트 시나리오 상세
			List<TestSnrioDetailDTO> testSnrioDetailDTOList = new ArrayList<TestSnrioDetailDTO>();
			testSnrioBasicDTO.setTestSnrioDetailDTOList(testSnrioDetailDTOList);
			
			for(int i=0, cnt=jsonArrayTsDetailDTOList.size(); i<cnt; i++){
				//테스트 데이터 상세 담기
				JSONObject jsonTsDetailDTO = JSONObject.fromObject(jsonArrayTsDetailDTOList.get(i));
				TestSnrioDetailDTO testSnrioDetailDTO = (TestSnrioDetailDTO) JSONObject.toBean(jsonTsDetailDTO, TestSnrioDetailDTO.class);
				testSnrioDetailDTO.setTsSnrioID(tsSnrioID);
				testSnrioDetailDTO.setLastModfiID(loginUsrId);
				testSnrioDetailDTO.setLastModfiYMS(currentDate);
				testSnrioDetailDTOList.add(testSnrioDetailDTO);
				
				//테스트 데이터가 수정본이면 저장한다.
				if("E".equals(testSnrioDetailDTO.getIsCopy())){
					//테스트 데이터 담기
					JSONObject jsonTestDataDto = jsonArrayTestDataDTOList.getJSONObject(i);
					TestDataDto testDataDto = new TestDataDto();
					
					BeanUtils.copyProperties(testDataDto, jsonTestDataDto);
					//헤더부리스트
					List<TestDataDetailDto> headerList = new ArrayList<TestDataDetailDto>();
					testDataDto.setHeaderList(headerList);
					for(Object jsonHeader : jsonTestDataDto.getJSONArray("headerList")){
						TestDataDetailDto header = (TestDataDetailDto) JSONObject.toBean((JSONObject)jsonHeader, TestDataDetailDto.class);
						headerList.add(header);
					}
					//개별부리스트
					List<TestDataDetailDto> inviList = new ArrayList<TestDataDetailDto>();
					testDataDto.setInviList(inviList);
					for(Object jsonInvi : jsonTestDataDto.getJSONArray("inviList")){
						TestDataDetailDto invi = (TestDataDetailDto) JSONObject.toBean((JSONObject)jsonInvi, TestDataDetailDto.class);
						inviList.add(invi);
					}
					//체크포인트리스트
					List<CheckPointDTO> checkPointList = new ArrayList<CheckPointDTO>();
					testDataDto.setCheckPointList(checkPointList);
					for(Object jsonCheckPoint : jsonTestDataDto.getJSONArray("checkPointList")){
						CheckPointDTO checkPoint = (CheckPointDTO) JSONObject.toBean((JSONObject)jsonCheckPoint, CheckPointDTO.class);
						checkPointList.add(checkPoint);
					}
					
					testDataDto.setWriteID(loginUsrId);
					testDataDto.setWriteName(loginUsrName);
					testDataDto.setCretnYMS(currentDate);
					testDataDto.setLastModfiID(loginUsrId);
					testDataDto.setLastModfiYMS(currentDate);
					String tsdataID = this.registerTdDataInfo(testDataDto);
					
					//테스트시나리오 상세에 반영한다.
					testSnrioDetailDTO.setTsdataID(tsdataID);
					
				}else if(isNew || "Y".equals(testSnrioDetailDTO.getIsCopy())){ //테스트 데이터가 복사본이면 DB에서 읽어온 후 새로 저장한다.
					String tsdataID = testSnrioDetailDTO.getTsdataID().split("-")[0].trim();
					
					TestDataDto testDataDto = this.getTdInfo(tsdataID);
					
					testDataDto.setWriteID(loginUsrId);
					testDataDto.setWriteName(loginUsrName);
					testDataDto.setCretnYMS(currentDate);
					testDataDto.setLastModfiID(loginUsrId);
					testDataDto.setLastModfiYMS(currentDate);
					tsdataID = this.registerTdDataInfo(testDataDto);
					
					//테스트시나리오 상세에 반영한다.
					testSnrioDetailDTO.setTsdataID(tsdataID);
				}
				
				//저장할 입출력값활용 넣기
				List<IODataUseDTO> ioDataUseDTOList = new ArrayList<IODataUseDTO>();
				JSONArray jsonArrayIODataUseDTO = JSONArray.fromObject(jsonArrayIODataUseDTOList.get(i));
				for(Object o : jsonArrayIODataUseDTO){
					JSONObject iODataDTO = JSONObject.fromObject(o);
					IODataUseDTO ioDataUseDTO = (IODataUseDTO) JSONObject.toBean(iODataDTO, IODataUseDTO.class);
					ioDataUseDTO.setTsSnrioID(tsSnrioID);
					ioDataUseDTO.setTsSnrioNO(testSnrioDetailDTO.getTsSnrioNO());
					ioDataUseDTO.setLastModfiID(loginUsrId);
					ioDataUseDTO.setLastModfiYMS(currentDate);
					
					ioDataUseDTOList.add(ioDataUseDTO);
				}
				//입출력값 활용 저장
				if(ioDataUseDTOList.size() > 0){
					tsMngDao.registerIODataUseInfo(ioDataUseDTOList);
				}
				testSnrioDetailDTO.setIoDataUseDTOList(ioDataUseDTOList);
			}
			
			//테스트 시나리오 상세 저장
			tsMngDao.registerTsDetailInfo(testSnrioDetailDTOList);
			
		} catch (IllegalAccessException e) {
			logger.error("", e);
			throw new BizException("MSG_TSNMNG0001","", e);
		} catch (InvocationTargetException e) {
			logger.error("", e);
			throw new BizException("MSG_TSNMNG0001","", e);
		}
		
		return testSnrioBasicDTO;
	}

	/**
	 * <p>
	 * 테스트 시나리오 기본을 저장한다.
	 * <p>
	 * @param testSnrioBasicDTO - 테스트시나리오 기본정보
	 * @return tsSnrioID
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public synchronized String registerTsBasicInfo(TestSnrioBasicDTO testSnrioBasicDTO) {
		String tsSnrioID = mngSeqIdBiz.getNewSeqId(MngSeqIdBiz.TEST_SNRO, MngSeqIdBiz.TYPE_MSG);
		testSnrioBasicDTO.setTsSnrioID(tsSnrioID);
		tsMngDao.registerTsBasicInfo(testSnrioBasicDTO);
		
		return tsSnrioID;
	}

	/**
	 * <p>
	 * 테스트 데이터 저장
	 * <p>
	 * <p>새로운 테스트데이터ID 채번
	 * <p>헤더부,개별부 상세 저장
	 * <p>체크포인트 저장
	 * <p>테스트데이터 기본 저장
	 * @param testDataDto - 저장할 테스트 데이터 정보
	 * @return tsdataID
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public synchronized String registerTdDataInfo(TestDataDto testDataDto) {
		String writeID = testDataDto.getWriteID();
		String writeName = testDataDto.getWriteName();
		String cretnYMS = testDataDto.getCretnYMS();
		
		//새로운 테스트 데이터 ID를 가져온다.
		String tsdataID = mngSeqIdBiz.getNewSeqId(MngSeqIdBiz.TEST_DATA, MngSeqIdBiz.TYPE_MSG);
		testDataDto.setTsdataID(tsdataID);
		
		//헤더부 저장
		for(TestDataDetailDto header : testDataDto.getHeaderList()){
			header.setTsdataID(tsdataID);
			header.setLastModfiID(writeID);
			header.setLastModfiYMS(cretnYMS);
		}
		tsMngDao.registerTdDetailInfo(testDataDto.getHeaderList());
		
		//개별부 저장
		for(TestDataDetailDto invi : testDataDto.getInviList()){
			invi.setTsdataID(tsdataID);
			invi.setLastModfiID(writeID);
			invi.setLastModfiYMS(cretnYMS);
		}
		tsMngDao.registerTdDetailInfo(testDataDto.getInviList());
		
		//체크포인트 저장
		boolean isChkYN = false;//테스트데이터용 체크포인트 설정여부
		if(testDataDto.getCheckPointList().size() > 0){
			isChkYN = this.registerCheckPoint(testDataDto, testDataDto.getCheckPointList(), writeID, writeName, cretnYMS);
		}
		
		//테스트 데이터 기본 저장
		testDataDto.setChkYN(isChkYN? "Y": "N");
		tsMngDao.registerTdBasicInfo(testDataDto);
		
		return tsdataID;
	}

	/**
	 * <p>
	 * 체크리스트를 저장한다.
	 * <p>
	 * <p>전문레이아웃 조회
	 * <p>조회된 레이아웃으로 체크포인트를 만든다.
	 * <p>체크포인트를 저장한다
	 * 
	 * @param testDataDto - 테스트데이터 정보
	 * @param checkPointList - 체크포인트 정보
	 * @param writeID - 사용자 ID
	 * @param writeName - 사용자 이름
	 * @param cretnYMS - 작성일시
	 * @return 체크포인트 설정여부
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean registerCheckPoint(
			TestDataDto testDataDto
			, List<CheckPointDTO> checkPointList
			, String writeID
			, String writeName
			, String cretnYMS) {
		
		boolean result = false;
		
		String chnlDstcd = testDataDto.getChnlDstcd();
		String tranCd	=  testDataDto.getTranCd();
		String tsdataID = testDataDto.getTsdataID();
		
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
		
		//레이아웃으로 체크포인트를 만든다.
		for(int i = 0; i < layoutDetailDtoList.size(); i++){
			LayoutDetailDto rstLayoutDto = layoutDetailDtoList.get(i);	//layOut
			for (CheckPointDTO dto : checkPointList) {
				if(rstLayoutDto.getFldName().equals(dto.getTsdataFldName())){
					dto.setTsdataID(tsdataID);
					dto.setChkNO(i+1);
					dto.setTsdataDesc((String)rstLayoutDto.getTscsFldDesc());
					dto.setTscsFldDesc((String)rstLayoutDto.getTscsFldDesc());
					dto.setTscsFldType(rstLayoutDto.getFldType());
					dto.setTscsFldAttrib(rstLayoutDto.getFldAttrib());
					dto.setWriteID(writeID);
					dto.setWriteName(writeName);
					dto.setCretnYMS(cretnYMS);
					dto.setLastModfiID(writeName);
					dto.setLastModfiYMS(cretnYMS);
					
					result = result || "Y".equals(dto.getChkYN().trim());
				}
			}
		}
		
		//체크포인트 저장
		tsMngDao.registerCheckPoint(checkPointList);
		
		return result;
	}

	/**
	 * <p>
	 * 테스트 데이터, 테스트 시나리오 상세 가져오기
	 * <p>
	 * <p>기존 테스트 케이스에서 추가일경우
	 * <p>테스트 데이터 아이디 리스트를 가져온다.
	 * <p>테스트 데이터 리스트를 토대로 시나리오 상세를 만든다.
	 * <p>테스트 데이터는 갯수만큼 빈 List만 넣어준다.
	 * 
	 * @param arrTsdataIds - 테스트 데이터 아이디 list
	 * @return 테스트 데이터, 테스트 시나리오 상세 정보
	 */
	@Transactional(readOnly = true)
	public TestSnrioBasicDTO getListAppendTdInfo(List<String> arrTsdataIds) {
		TestSnrioBasicDTO testSnrioBasicDTO = new TestSnrioBasicDTO();
		
		List<TestSnrioDetailDTO> testSnrioDetailDTOs = new ArrayList<TestSnrioDetailDTO>();
		//테스트 데이터 아이디를 가져온다.
		List<TestDataDto> testDataDtos = this.getListTdInfo(arrTsdataIds);
		
		//테스트 데이터를 토대로 시나리오 상세를 만든다.
		for(TestDataDto testDataDto : testDataDtos){
			TestSnrioDetailDTO testSnrioDetailDTO = new TestSnrioDetailDTO();
			testSnrioDetailDTO.setTsSnrioID("");
			testSnrioDetailDTO.setTsSnrioNO("");
			testSnrioDetailDTO.setTsdataID(testDataDto.getTsdataID() + " - 사본");
			testSnrioDetailDTO.setTsdataName(testDataDto.getTsdataName());
			testSnrioDetailDTO.setTsCaseID("");
			testSnrioDetailDTO.setChnlDstcd(testDataDto.getChnlDstcd());
			testSnrioDetailDTO.setTranCd(testDataDto.getTranCd());
			testSnrioDetailDTO.setTranName(testDataDto.getTranName());
			testSnrioDetailDTO.setUseIO("N");
			testSnrioDetailDTO.setCretnYMS(testDataDto.getCretnYMS());
			testSnrioDetailDTO.setIoDataUseDTOList(new ArrayList<IODataUseDTO>());
			testSnrioDetailDTO.setIsCopy("Y");
			testSnrioDetailDTOs.add(testSnrioDetailDTO);
		}
		
		testSnrioBasicDTO.setTestSnrioDetailDTOList(testSnrioDetailDTOs);
		//테스트 데이터는 갯수만큼 빈 List만 넣어준다.
		testSnrioBasicDTO.setTestDataDtos(new ArrayList<TestDataDto>(testDataDtos.size()));
		
		return testSnrioBasicDTO;
	}

	/**
	 * <p>
	 * 테스트 데이터 정보를 가져온다.
	 * <p>
	 * @param arrTsdataIds - 테스트 아이디 정보
	 * @return 테스트 데이터 정보
	 */
	@Transactional(readOnly = true)
	public List<TestDataDto> getListTdInfo(List<String> arrTsdataIds) {
		List<TestDataDto> testDataDtos = new ArrayList<TestDataDto>();
		
		for(String tsdataID : arrTsdataIds){
			TestDataDto dto = this.getTdInfo(tsdataID);
			testDataDtos.add(dto);
		}
		
		return testDataDtos;
	}
	
	/**
	 * <p>
	 * 테스트데이터 정보를 가져온다.
	 * <p>
	 * @param tsdataID - 데스트데이터ID
	 * @return - 테스트데이터 정보
	 */
	@Transactional(readOnly = true)
	public TestDataDto getTdInfo(String tsdataID) {
		TestDataDto testDataDto = tsMngDao.getTdBaseInfo(tsdataID);
		if(testDataDto != null){
			Map<String, String> param = new HashMap<String, String>();
			param.put("tsdataID", tsdataID);
			
			//레이아웃에 맞추기 위해 레이아웃 조회
			LayoutDto layoutDto = layoutBiz.getLayout(testDataDto.getChnlDstcd(), testDataDto.getTranCd(), "I");
			
			int tsdataNO = 1;
			int rptNum = 0;
			
			if(layoutDto != null){
				if(layoutDto.getHeaderList() != null){
					param.put("tscsFldDiv", "01");//헤더부 조회
					List<TestDataDetailDto> testDataDetailDtoList = tsMngDao.getListTdList(param);	//헤더부 데이터
					List<LayoutDetailDto> layoutDetailDtoList = layoutDto.getHeaderList();	//헤더부 레이아웃
					List<TestDataDetailDto> newTestDataDetailDtoList = new ArrayList<TestDataDetailDto>();	//레이아웃에 맞춘 테스트데이터 리스트
					
					for (int i = 0 ; i < layoutDetailDtoList.size() ; i++) {	//레이아웃리스트를 순회한다
						LayoutDetailDto layoutDetailDto = layoutDetailDtoList.get(i);
						
						if(layoutDetailDto.getRptName() == null || "".equals(layoutDetailDto.getRptName())){	//반복부 필드가 아닐경우
							boolean findFlag = false;	//레이아웃에 테스트데이터가 존재하는지 여부
							
							for (int j = 0; j < testDataDetailDtoList.size() ; j++) {	//데이터리스트를 순회한다
								TestDataDetailDto testDataDetailDto = testDataDetailDtoList.get(j);
								
								if(layoutDetailDto.getFldName().equals(testDataDetailDto.getTsdataFldName())){	//데이터와 레이아웃이 같은것을 찾는다
									if("03".equals(layoutDetailDto.getFldAttrib())){
										testDataDetailDto.setRptCntName("RPT"+rptNum++);
									}
									
									testDataDetailDto.setTsdataNO(String.valueOf(tsdataNO++));
									
									newTestDataDetailDtoList.add(testDataDetailDto);	//기존 테스트데이터를 추가한다
									findFlag = true;
									break;
								}
							}
							
							if(findFlag == false){	//데이터가 레이아웃에 없는경우
								TestDataDetailDto testDataDetailDto = new TestDataDetailDto();
								testDataDetailDto.setTsdataID(tsdataID);
								testDataDetailDto.setTsdataNO(String.valueOf(tsdataNO++));
								testDataDetailDto.setTsdataFldName(layoutDetailDto.getFldName());
								testDataDetailDto.setTsdataFldData("");
								testDataDetailDto.setTscsFldDiv(layoutDetailDto.getFldDiv());
								testDataDetailDto.setTscsFldType(layoutDetailDto.getFldType());
								testDataDetailDto.setTscsFldAttrib(layoutDetailDto.getFldAttrib());
								testDataDetailDto.setTscsFldSizeCnt(layoutDetailDto.getTscsFldSize());
								testDataDetailDto.setTscsFldDesc(layoutDetailDto.getTscsFldDesc());
								if("03".equals(layoutDetailDto.getFldAttrib())){
									testDataDetailDto.setRptCntName("RPT"+rptNum++);	//반복부회차필드에 반복부별명을 입력한다
								}
								
								newTestDataDetailDtoList.add(testDataDetailDto);	//테스트데이터를 만들어 추가한다
							}
							
						} else {	//반복부 필드일 경우
							
							//반복부명
							String rptFldName = layoutDetailDto.getRptName();
							
							//반복횟수, 반복부명 가져오기
							int rtpCount = 0;
							String rptName = null;
							for(int j = newTestDataDetailDtoList.size()-1 ; j >= 0 ; j--){
								TestDataDetailDto testDataDetailDto = newTestDataDetailDtoList.get(j);
								if(rptFldName.equals(testDataDetailDto.getTsdataFldName())){
									if("hex".equals(testDataDetailDto.getTscsFldType())){	//hex
										rtpCount = TransUtil.parseHex(testDataDetailDto.getTsdataFldData());
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
							for(int j = 1 ; j <= rtpCount ; j++){
								int k = i;
								for( ; k < layoutDetailDtoList.size() ; k++){
									if(!rptFldName.equals(layoutDetailDtoList.get(k).getRptName())){	//반복부가 끝나면 첫번째로 되돌아간다
										break;
									} else {	//반복부일 경우
										boolean findFlag = false;	//레이아웃에 테스트데이터가 존재하는지 여부
										
										for (int z = 0; z < testDataDetailDtoList.size() ; z++) {	//데이터리스트를 순회한다
											TestDataDetailDto testDataDetailDto = testDataDetailDtoList.get(z);
											
											if(layoutDetailDtoList.get(k).getFldName().equals(testDataDetailDto.getTsdataFldName()) &&
												rptName.equals(testDataDetailDto.getRptName()) &&
												j == Integer.parseInt(testDataDetailDto.getRptCnt().trim())){	//데이터와 레이아웃이 같은것을 찾는다
												
												testDataDetailDto.setTsdataNO(String.valueOf(tsdataNO++));
												testDataDetailDto.setRptName(rptName);
												
												newTestDataDetailDtoList.add(testDataDetailDto);	//기존 테스트데이터를 추가한다
												findFlag = true;
												break;
											}
										}
										
										if(findFlag == false){	//데이터가 레이아웃에 없는경우
											TestDataDetailDto testDataDetailDto = new TestDataDetailDto();
											testDataDetailDto.setTsdataID(tsdataID);
											testDataDetailDto.setTsdataNO(String.valueOf(tsdataNO++));
											testDataDetailDto.setTsdataFldName(layoutDetailDtoList.get(k).getFldName());
											testDataDetailDto.setTsdataFldData("");
											testDataDetailDto.setTscsFldDiv(layoutDetailDtoList.get(k).getFldDiv());
											testDataDetailDto.setTscsFldType(layoutDetailDtoList.get(k).getFldType());
											testDataDetailDto.setTscsFldAttrib(layoutDetailDtoList.get(k).getFldAttrib());
											testDataDetailDto.setTscsFldSizeCnt(layoutDetailDtoList.get(k).getTscsFldSize());
											testDataDetailDto.setTscsFldDesc(layoutDetailDtoList.get(k).getTscsFldDesc());
											testDataDetailDto.setRptName(rptName);
											testDataDetailDto.setRptCnt(String.valueOf(j));
											
											newTestDataDetailDtoList.add(testDataDetailDto);	//테스트데이터를 만들어 추가한다
										}
									}
									nextIndex = k;	//반복부의 마지막 인덱스
								}
							}
							
							i = nextIndex;
							
						}
					}
					testDataDto.setHeaderList(newTestDataDetailDtoList);
				}
				
				if(layoutDto.getInviList() != null){
					param.put("tscsFldDiv", "02");//개별부 조회
					List<TestDataDetailDto> testDataDetailDtoList = tsMngDao.getListTdList(param);	//개별부 데이터
					List<LayoutDetailDto> layoutDetailDtoList = layoutDto.getInviList();	//개별부 레이아웃
					List<TestDataDetailDto> newTestDataDetailDtoList = new ArrayList<TestDataDetailDto>();	//레이아웃에 맞춘 테스트데이터 리스트
					
					for (int i = 0 ; i < layoutDetailDtoList.size() ; i++) {	//레이아웃리스트를 순회한다
						LayoutDetailDto layoutDetailDto = layoutDetailDtoList.get(i);
						
						if(layoutDetailDto.getRptName() == null || "".equals(layoutDetailDto.getRptName())){	//반복부 필드가 아닐경우
							boolean findFlag = false;	//레이아웃에 테스트데이터가 존재하는지 여부
							
							for (int j = 0; j < testDataDetailDtoList.size() ; j++) {	//데이터리스트를 순회한다
								TestDataDetailDto testDataDetailDto = testDataDetailDtoList.get(j);
								
								if(layoutDetailDto.getFldName().equals(testDataDetailDto.getTsdataFldName())){	//데이터와 레이아웃이 같은것을 찾는다
									if("03".equals(layoutDetailDto.getFldAttrib())){
										testDataDetailDto.setRptCntName("RPT"+rptNum++);
									}
									
									testDataDetailDto.setTsdataNO(String.valueOf(tsdataNO++));
									
									newTestDataDetailDtoList.add(testDataDetailDto);	//기존 테스트데이터를 추가한다
									findFlag = true;
									break;
								}
							}
							
							if(findFlag == false){	//데이터가 레이아웃에 없는경우
								TestDataDetailDto testDataDetailDto = new TestDataDetailDto();
								testDataDetailDto.setTsdataID(tsdataID);
								testDataDetailDto.setTsdataNO(String.valueOf(tsdataNO++));
								testDataDetailDto.setTsdataFldName(layoutDetailDto.getFldName());
								testDataDetailDto.setTsdataFldData("");
								testDataDetailDto.setTscsFldDiv(layoutDetailDto.getFldDiv());
								testDataDetailDto.setTscsFldType(layoutDetailDto.getFldType());
								testDataDetailDto.setTscsFldAttrib(layoutDetailDto.getFldAttrib());
								testDataDetailDto.setTscsFldSizeCnt(layoutDetailDto.getTscsFldSize());
								testDataDetailDto.setTscsFldDesc(layoutDetailDto.getTscsFldDesc());
								if("03".equals(layoutDetailDto.getFldAttrib())){
									testDataDetailDto.setRptCntName("RPT"+rptNum++);	//반복부회차필드에 반복부별명을 입력한다
								}
								
								newTestDataDetailDtoList.add(testDataDetailDto);	//테스트데이터를 만들어 추가한다
							}
							
						} else {	//반복부 필드일 경우
							
							//반복부명
							String rptFldName = layoutDetailDto.getRptName();
							
							//반복횟수, 반복부명 가져오기
							int rtpCount = 0;
							String rptName = null;
							for(int j = newTestDataDetailDtoList.size()-1 ; j >= 0 ; j--){
								TestDataDetailDto testDataDetailDto = newTestDataDetailDtoList.get(j);
								if(rptFldName.equals(testDataDetailDto.getTsdataFldName())){
									if("hex".equals(testDataDetailDto.getTscsFldType())){	//hex
										rtpCount = TransUtil.parseHex(testDataDetailDto.getTsdataFldData());
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
							for(int j = 1 ; j <= rtpCount ; j++){
								int k = i;
								for( ; k < layoutDetailDtoList.size() ; k++){
									if(!rptFldName.equals(layoutDetailDtoList.get(k).getRptName())){	//반복부가 끝나면 첫번째로 되돌아간다
										break;
									} else {	//반복부일 경우
										boolean findFlag = false;	//레이아웃에 테스트데이터가 존재하는지 여부
										
										for (int z = 0; z < testDataDetailDtoList.size() ; z++) {	//데이터리스트를 순회한다
											TestDataDetailDto testDataDetailDto = testDataDetailDtoList.get(z);
											
											if(layoutDetailDtoList.get(k).getFldName().equals(testDataDetailDto.getTsdataFldName()) &&
												rptName.equals(testDataDetailDto.getRptName()) &&
												j == Integer.parseInt(testDataDetailDto.getRptCnt().trim())){	//데이터와 레이아웃이 같은것을 찾는다
												
												testDataDetailDto.setTsdataNO(String.valueOf(tsdataNO++));
												testDataDetailDto.setRptName(rptName);
												
												newTestDataDetailDtoList.add(testDataDetailDto);	//기존 테스트데이터를 추가한다
												findFlag = true;
												break;
											}
										}
										
										if(findFlag == false){	//데이터가 레이아웃에 없는경우
											TestDataDetailDto testDataDetailDto = new TestDataDetailDto();
											testDataDetailDto.setTsdataID(tsdataID);
											testDataDetailDto.setTsdataNO(String.valueOf(tsdataNO++));
											testDataDetailDto.setTsdataFldName(layoutDetailDtoList.get(k).getFldName());
											testDataDetailDto.setTsdataFldData("");
											testDataDetailDto.setTscsFldDiv(layoutDetailDtoList.get(k).getFldDiv());
											testDataDetailDto.setTscsFldType(layoutDetailDtoList.get(k).getFldType());
											testDataDetailDto.setTscsFldAttrib(layoutDetailDtoList.get(k).getFldAttrib());
											testDataDetailDto.setTscsFldSizeCnt(layoutDetailDtoList.get(k).getTscsFldSize());
											testDataDetailDto.setTscsFldDesc(layoutDetailDtoList.get(k).getTscsFldDesc());
											testDataDetailDto.setRptName(rptName);
											testDataDetailDto.setRptCnt(String.valueOf(j));
											
											newTestDataDetailDtoList.add(testDataDetailDto);	//테스트데이터를 만들어 추가한다
										}
									}
									nextIndex = k;	//반복부의 마지막 인덱스
								}
							}
							
							i = nextIndex;
							
						}
					}
					testDataDto.setInviList(newTestDataDetailDtoList);
				}
			}
			
			testDataDto.setCheckPointList(tsMngDao.getListCheckPoint(tsdataID));
		}
		return testDataDto;
	}
}
