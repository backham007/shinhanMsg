package com.igo.testro.msg.tcmng.dao;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.igo.testro.das.SqlMapper;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.pretst.dto.TestDataDetailDto;
import com.igo.testro.msg.pretst.dto.TestDataDto;
import com.igo.testro.msg.tcmng.dto.CheckPointDTO;
import com.igo.testro.msg.tcmng.dto.RptCaseDetailDto;
import com.igo.testro.msg.tcmng.dto.RptCaseDto;
import com.igo.testro.msg.tcmng.dto.TcDetailDto;
import com.igo.testro.msg.tcmng.dto.TcDto;

public class TcmngDao {

	final ITestroLogger logger = TestroLogHelper.getBiz();
	
	/**
	 * <p>
	 * 기본테스트데이터 기본 조회
	 * </p>
	 * @param Map(chnlDstcd, tranCd)
	 * @return TestDataDto 기본테스트데이터Dto
	 */
	public TestDataDto getBasicsData(Map pramMap) {
		if (logger.isDebugEnabled()) logger.debug("getBasicsData()");
		TestDataDto testDataDto = (TestDataDto)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("tcmng.getBasicsData", pramMap);
		return testDataDto;
	}

	
	/**
	 * <p>
	 * 기본테스트데이터 상세 조회
	 * </p>
	 * @param tsDataID 테스트데이터ID
	 * @return List<TestDataDetailDto>	테스트데이터상세Dto List
	 */
	public List<TestDataDetailDto> getTdBasicsDetailList(String tsdataID) {
		if (logger.isDebugEnabled()) logger.debug("getTdBasicsDetailList()");
		List<TestDataDetailDto> testDataDetailDtoList = (List)SqlMapper.getSqlClient("TESTRO_DB").queryForList("tcmng.getTdBasicsDetailList", tsdataID);
		return testDataDetailDtoList;
	}
	
	
	/**
	 * <p>
	 * 테스트케이스 기본 조회
	 * </p>
	 * @param tsCaseID 테스트케이스ID
	 * @return List<TestDataDto> 테스트데이터Dto List
	 */
	public List<TestDataDto> getTdList(String tsCaseID) {
		if (logger.isDebugEnabled()) logger.debug("getTdList()");
		List<TestDataDto> result = (List<TestDataDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("tcmng.getTdList", tsCaseID);
		return result;
	}

	/**
	 * <p>
	 * 테스트데이터 상세 조회
	 * </p>
	 * @param parMap
	 * @return List<TestDataDetailDto>	테스트데이터상세Dto List
	 */
	public List<TestDataDetailDto> getTdDetailList(HashMap<String, String> parMap) {
		if (logger.isDebugEnabled()) logger.debug("getTdDetailList()");
		List<TestDataDetailDto> result = (List<TestDataDetailDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("tcmng.getTdDetailList", parMap);
		return result;
	}
	
	/**
	 * <p>
	 * 테스트데이터 ID로 기본정보 조회
	 * </p>
	 * @param tsCaseID 		테스트케이스ID
	 * @return TestDataDto	테스트데이터Dto
	 */
	public TestDataDto getTsData(String tsCaseID) {
		if (logger.isDebugEnabled()) logger.debug("getTsData()");
		TestDataDto testDataDto = (TestDataDto)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("tcmng.getTsData", tsCaseID);
		return testDataDto;
	}
	
	/**
	 * <p>
	 * 테스트데이터 ID로 기본상세 조회
	 * </p>
	 * @param tsdataID 테스트데이터ID
	 * @return List<TestDataDetailDto> 테스트데이터상세Dto List
	 */
	public List<TestDataDetailDto> getTsDataDetailList(String tsdataID) {
		if (logger.isDebugEnabled()) logger.debug("getTsDataDetailList()");
		List<TestDataDetailDto> testDataDetailDtoList = (List<TestDataDetailDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("tcmng.getTsDataDetailList", tsdataID);
		return testDataDetailDtoList;
	}
	

	/**
	 * <p>
	 * 테스트케이스 기본 수정
	 * </p>
	 * @param tcDto 테스트케이스Dto
	 * @return
	 */
	public void modTestCase(TcDto tcDto) {
		if (logger.isDebugEnabled()) logger.debug("modTestCase()");
		SqlMapper.getSqlClient("TESTRO_DB").update("tcmng.modTestCase", tcDto);
	}
		
	/**
	 * <p>
	 * 테스트케이스 기본 저장
	 * </p>
	 * @param tcDto 테스트케이스Dto
	 * @return
	 */
	public void regTestCase(TcDto tcDto) {
		if (logger.isDebugEnabled()) logger.debug("regTestCase()");
		SqlMapper.getSqlClient("TESTRO_DB").insert("tcmng.regTestCase", tcDto);
	}
	
	
	/**
	 * <p>
	 * 테스트케이스 상세 등록
	 * </p>
	 * @param tcDetailDto 테스트케이스상세Dto
	 * @param tdDetailIdList 테스트데이터상세ID List
	 * @return
	 */
	public void regTestCaseDetail(TcDetailDto tcDetailDto, List<TestDataDto> tdDetailIdList) {
		if (logger.isDebugEnabled()) logger.debug("regTestCaseDetail()");
		for(int i = 0; i < tdDetailIdList.size(); i++){
			tcDetailDto.setTsdataID((String)tdDetailIdList.get(i).getTsdataID());
			tcDetailDto.setTsdataName((String)tdDetailIdList.get(i).getTsdataName());
			tcDetailDto.setTsCaseNO(new DecimalFormat("000").format(i+1));
			SqlMapper.getSqlClient("TESTRO_DB").insert("tcmng.regTestCaseDetail", tcDetailDto);
		}
	}
	
	
	/**
	 * <p>
	 * 테스트케이스 상세 삭제
	 * </p>
	 * @param tsCaseID 테스트케이스ID
	 * @return
	 */
	public void delTestCaseDetail(String tsCaseID) {
		if (logger.isDebugEnabled()) logger.debug("delTestCaseDetail()");
		SqlMapper.getSqlClient("TESTRO_DB").delete("tcmng.delTestCaseDetail", tsCaseID);
	}
	
	
	/**
	 * <p>
	 * 테스트데이터 기본 수정
	 * </p>
	 * @param testDataDto 테스트데이터Dto
	 * @return
	 */
	public void modTestData(TestDataDto testDataDto) {
		if (logger.isDebugEnabled()) logger.debug("modTestData()");
		SqlMapper.getSqlClient("TESTRO_DB").update("tcmng.modTestData", testDataDto);
	}
	
	
	/**
	 * <p>
	 * 테스트데이터 기본 저장
	 * </p>
	 * @param testDataDto 테스트데이터Dto
	 * @return
	 */
	public void regTestData(TestDataDto testDataDto) {
		if (logger.isDebugEnabled()) logger.debug("regTestData()");
		SqlMapper.getSqlClient("TESTRO_DB").insert("tcmng.regTestData", testDataDto);
	}

	
	/**
	 * <p>
	 * 테스트데이터 상세 저장
	 * </p>
	 * @param testDataDetailDto 테스트데이터상세Dto
	 * @return
	 */
	public void regTestDataDetail(TestDataDetailDto testDataDetailDto) {
		if (logger.isDebugEnabled()) logger.debug("regTestDataDetail()");
		SqlMapper.getSqlClient("TESTRO_DB").insert("tcmng.regTestDataDetail", testDataDetailDto);
	}

	
	/**
	 * <p>
	 * 테스트데이터 상세 삭제
	 * </p>
	 * @param tsdataID 테스트케이스ID
	 * @return
	 */
	public void delTestDetailData(String tsdataID) {
		if (logger.isDebugEnabled()) logger.debug("delTestDetailData()");
		SqlMapper.getSqlClient("TESTRO_DB").delete("tcmng.delTestDetailData", tsdataID);
	}

	/**
	 * <p>
	 * 테스트케이스 정보 가져오기
	 * </p>
	 * @param tsCaseID	테스트케이스ID
	 * @return TcDto	테스트케이스Dto
	 */
	public TcDto getTsCaseInfo(String tsCaseID) {
		if (logger.isDebugEnabled()) logger.debug("getTsCaseInfo()");
		TcDto tcDto = (TcDto)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("tcmng.getTsCaseInfo", tsCaseID);
		return tcDto;
	}

	
	

	/**
	 * <p>
	 * 테스트케이스기본실적 수행회차 조회
	 * </p>
	 * @param tsCaseID	테스트케이스ID
	 * @return String 	수행회차
	 */
	public String getAcmplNth(String tsCaseID) {
		if (logger.isDebugEnabled()) logger.debug("getAcmplNth()");
		String acmplNth = (String)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("tcmng.getAcmplNth", tsCaseID);
		return acmplNth;
	}

	
	/**
	 * <p>
	 * 테스트케이스기본실적 저장
	 * </p>
	 * @param rptCaseDto 테스트케이스실적Dto
	 * @return 
	 */
	public void regRptCase(RptCaseDto rptCaseDto) {
		if (logger.isDebugEnabled()) logger.debug("regRptCase()");
		SqlMapper.getSqlClient("TESTRO_DB").insert("tcmng.regRptCase", rptCaseDto);
	}

	/**
	 * <p>
	 * 테스트케이스상세실적 일련번호 조회
	 * </p>
	 * @param parMap
	 * @return Integer 일련번호
	 */
	public Integer getTsCaseNo(Map parMap) {
		if (logger.isDebugEnabled()) logger.debug("getTsCaseNo()");
		String tsCaseNo = (String)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("tcmng.getTsCaseNo", parMap);
		
		if(tsCaseNo == null){
			tsCaseNo = "0";
		}
		return new Integer(tsCaseNo)+1;
	}

	/**
	 * <p>
	 * 테스트케이스상세실적 저장
	 * </p>
	 * @param rptCaseDetailDto 테스트케이스상세실적Dto
	 * @return 
	 */	
	public void regRptCaseDetail(RptCaseDetailDto rptCaseDetailDto) {
		if (logger.isDebugEnabled()) logger.debug("regRptCaseDetail()");
		SqlMapper.getSqlClient("TESTRO_DB").insert("tcmng.regRptCaseDetail", rptCaseDetailDto);
	}
	
	
	/**
	 * <p>
	 * 테스트케이스기본실적 수정
	 * </p>
	 * @param rptCaseDto 테스트케이스실적Dto
	 * @return 
	 */
	public void modRptCase(RptCaseDto rptCaseDto) {
		if (logger.isDebugEnabled()) logger.debug("modRptCase()");
		SqlMapper.getSqlClient("TESTRO_DB").update("tcmng.modRptCase", rptCaseDto);
	}


	/**
	 * <p>
	 * 체크포인트 삭제
	 * </p>
	 * @param tsDataID 테스트데이터ID
	 * @return 
	 */
	public void delTesChek(String tsDataID) {
		if (logger.isDebugEnabled()) logger.debug("delTesChek()");
		SqlMapper.getSqlClient("TESTRO_DB").delete("tcmng.delTesChek", tsDataID);
		
	}
	
	
	/**
	 * <p>
	 * 체크포인트 저장
	 * </p>
	 * @param checkPointDTO 체크포인트Dto
	 * @return 
	 */
	public void regTesChek(CheckPointDTO checkPointDTO) {
		if (logger.isDebugEnabled()) logger.debug("regTesChek()");
		SqlMapper.getSqlClient("TESTRO_DB").insert("tcmng.regTesChek", checkPointDTO);
	}
}
