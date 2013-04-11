package com.igo.testro.msg.tsmng.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.igo.testro.das.SqlMapper;
import com.igo.testro.msg.pretst.dto.TestDataDetailDto;
import com.igo.testro.msg.pretst.dto.TestDataDto;
import com.igo.testro.msg.tcmng.dto.CheckPointDTO;
import com.igo.testro.msg.tsmng.dto.IODataUseDTO;
import com.igo.testro.msg.tsmng.dto.TestSnrioBasicDTO;
import com.igo.testro.msg.tsmng.dto.TestSnrioDetailDTO;

/**
 * <p>
 * 프로그램명:TsMngDao.java<br/>
 * 설명 : 테스트 시나리오 관리 Dao<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 7. : 김기태 : 최초작성
 * </ul> 
 * </p>
 */
public class TsMngDao {

	/**
	 * <p>
	 * 테스트 시나리오 정보를 가져온다.
	 * <p>
	 * @param tsSnrioID - 테스트 시나리오 아이디
	 * @return 테스트 시나리오 정보
	 */
	public TestSnrioBasicDTO getTsBasicInfo(String tsSnrioID) {
		return (TestSnrioBasicDTO)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("tsmng.getTsBasicInfo", tsSnrioID);
	}

	/**
	 * <p>
	 * 테스트 시나리오 상세 정보를 가져온다.
	 * <p>
	 * @param params - 파라메터
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TestSnrioDetailDTO> getListTsDetailInfo(Map<String, Object> params) {
		return (ArrayList<TestSnrioDetailDTO>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("tsList.getListTsDetailInfo", params);
	}

	/**
	 * <p>
	 * 입출력값 활용 정보를 가져온다.
	 * <p>
	 * @param tsSnrioID - 테스트 시나리오 아이디
	 * @param tsSnrioNO - 테스트 시나리오 수행순서
	 * @return 입출력값활용 정보
	 */
	@SuppressWarnings("unchecked")
	public List<IODataUseDTO> getListIoDataUseDTO(String tsSnrioID, String tsSnrioNO) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tsSnrioID", tsSnrioID);
		params.put("tsSnrioNO", tsSnrioNO);
		return (ArrayList<IODataUseDTO>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("tsmng.getListIoDataUseDTO", params);
	}

	/**
	 * <p>
	 * 테스트 시나리오 정보를 저장한다.
	 * <p>
	 * @param testSnrioBasicDTO - 테스트 시나리오 정보
	 */
	public void registerTsBasicInfo(TestSnrioBasicDTO testSnrioBasicDTO) {
		SqlMapper.getSqlClient("TESTRO_DB").insert("tsmng.registerTsBasicInfo", testSnrioBasicDTO);
	}

	/**
	 * <p>
	 * 테스트 시나리오 상세 정보를 저장한다.
	 * <p>
	 * @param testSnrioDetailDTOList - 테스트 시나리오 상세 정보
	 */
	public void registerTsDetailInfo(List<TestSnrioDetailDTO> testSnrioDetailDTOList) {
		
		//TODO 인서트할때 DTO변경하여 for문으로 저장
		for (TestSnrioDetailDTO testSnrioDetailDTO : testSnrioDetailDTOList) {
			SqlMapper.getSqlClient("TESTRO_DB").insert("tsmng.registerTsDetailInfo", testSnrioDetailDTO);
		}
	}

	/**
	 * <p>
	 * 입출력값 활용을 저장한다.
	 * <p>
	 * @param ioDataUseDTOList - 입출력값 활용정보
	 */
	public void registerIODataUseInfo(List<IODataUseDTO> ioDataUseDTOList) {
		for (IODataUseDTO ioDataUseDTO : ioDataUseDTOList) {
			SqlMapper.getSqlClient("TESTRO_DB").insert("tsmng.registerIODataUseInfo", ioDataUseDTO);
		}
	}

	/**
	 * <p>
	 * 테스트 시나리오 정보를 수정한다.
	 * <p>
	 * @param testSnrioBasicDTO - 테스트 시나리오 정보
	 */
	public void modifyTsBasicInfo(TestSnrioBasicDTO testSnrioBasicDTO) {
		SqlMapper.getSqlClient("TESTRO_DB").update("tsmng.modifyTsBasicInfo", testSnrioBasicDTO);
	}

	/**
	 * <p>
	 * 테스트 시나리오 상세 정보를 삭제한다.
	 * <p>
	 * @param testSnrioBasicDTO - 테스트 시나리오 정보
	 */
	public void deleteTsDetailInfo(TestSnrioBasicDTO testSnrioBasicDTO) {
		SqlMapper.getSqlClient("TESTRO_DB").delete("tsmng.deleteTsDetailInfo", testSnrioBasicDTO);
	}

	/**
	 * <p>
	 * 입출력값 활용을 삭제한다.
	 * <p>
	 * @param testSnrioBasicDTO - 테스트 시나리오 정보
	 */
	public void deleteIODataUseInfo(TestSnrioBasicDTO testSnrioBasicDTO) {
		SqlMapper.getSqlClient("TESTRO_DB").delete("tsmng.deleteIODataUseInfo", testSnrioBasicDTO);
	}

	/**
	 * <p>
	 * 테스트 데이터 정보를 가져온다.
	 * <p>
	 * @param arrTsdataIds - 테스트 데이터 아이디 정보
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TestDataDto> getListTdInfo(List<String> arrTsdataIds){
		return (ArrayList<TestDataDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("tsmng.getListTdInfo", arrTsdataIds);
	}

	/**
	 * <p>
	 * 테스트 데이터 저장 한다.
	 * <p>
	 * @param testDataDto - 테스트 데이터 정보
	 */
	public void registerTdBasicInfo(TestDataDto testDataDto) {
		SqlMapper.getSqlClient("TESTRO_DB").insert("tsmng.registerTdBasicInfo", testDataDto);
	}

	/**
	 * <p>
	 * 테스트 데이터 상세를 저장 한다.
	 * <p>
	 * @param testDataDetailDtos - 테스트데이터 상세 정보
	 */
	public void registerTdDetailInfo(List<TestDataDetailDto> testDataDetailDtos) {
		for (TestDataDetailDto testDataDetailDto : testDataDetailDtos) {
			SqlMapper.getSqlClient("TESTRO_DB").insert("tsmng.registerTdDetailInfo", testDataDetailDto);
		}
	}

	/**
	 * <p>
	 * 체크포인트를 저장한다.
	 * <p>
	 * @param checkPointList - 체크포인트 정보
	 */
	public void registerCheckPoint(List<CheckPointDTO> checkPointList) {
		for (CheckPointDTO checkPointDTO : checkPointList) {
			SqlMapper.getSqlClient("TESTRO_DB").insert("tsmng.registerCheckPoint", checkPointDTO);
		}
	}
	
	/**
	 * <p>
	 * 테스트 데이터 기본 정보 가져온다
	 * <p>
	 * @param tsdataID - 테스트데이터 아이디
	 * @return 테스트데이터 정보
	 */
	public TestDataDto getTdBaseInfo(String tsdataID) {
		return (TestDataDto)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("tsmng.getTdBaseInfo", tsdataID);
	}
	
	/**
	 * <p>
	 * 테스트데이터 상세 정보를 가져온다.
	 * <p>
	 * @param param - 파라메터
	 * @return 테스트데이터 상세 정보
	 */
	@SuppressWarnings("unchecked")
	public List<TestDataDetailDto> getListTdList(Map<String, String> param) {
		return (List<TestDataDetailDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("tsmng.getListTdList", param);
	}
	
	/**
	 * <p>
	 * 체크포인트를 가져온다.
	 * <p>
	 * @param tsdataID - 테스트 데이터 아이디
	 * @return 체크포인트 정보
	 */
	@SuppressWarnings("unchecked")
	public List<CheckPointDTO> getListCheckPoint(String tsdataID) {
		return (ArrayList<CheckPointDTO>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("tsmng.getListCheckPoint", tsdataID);
	}

}
