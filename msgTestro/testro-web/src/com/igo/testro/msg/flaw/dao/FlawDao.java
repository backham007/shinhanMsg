package com.igo.testro.msg.flaw.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.igo.testro.das.SqlMapper;
import com.igo.testro.msg.flaw.dto.FlawDto;

/**
 * 
 * <p>
 * 프로그램명:FlawDao.java<br/>
 * 설명 : 결함관리DAO<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 20. : KoJaeHyeong : 최초작성
 * </ul> 
 * </p>
 */
public class FlawDao {

	/**
	 * 
	 * <p>
	 * 결함관리 조회
	 * <p>
	 * @param tsDataId 테스트데이터ID
	 * @param acmplNth 수행회차
	 * @return List<FlawDto> 결함DTO List 
	 */
	public List<FlawDto> getListFlaw(String tsDataId, String acmplNth) {
		
		Map<String,String> param = new HashMap<String,String>();
		param.put("tsDataId", tsDataId);	//테스트데이터ID
		param.put("acmplNth", acmplNth);	//수행회차
		
		return (List<FlawDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("flaw.getListFlaw", param);
	}
	
	/**
	 * 
	 * <p>
	 * 결함관리 신규
	 * <p>
	 * @param flawDto 결함DTO
	 */
	public void registerFlaw(FlawDto flawDto) {
		SqlMapper.getSqlClient("TESTRO_DB").insert("flaw.registerFlaw", flawDto);
	}
	
	/**
	 * 
	 * <p>
	 * 결함관리 수정
	 * <p>
	 * @param flawDto 결함DTO
	 * @return int 수정건수
	 */
	public int modifyFlaw(FlawDto flawDto) {
		return SqlMapper.getSqlClient("TESTRO_DB").update("flaw.modifyFlaw", flawDto);
	}
	
	/**
	 * 
	 * <p>
	 * 결함관리 삭제
	 * <p>
	 * @param tsDataId 테스트데이터ID
	 * @param acmplNth 수행회차
	 * @param defNo 결함일련번호
	 * @return int 삭제건수
	 */
	public int deleteFlaw(String tsDataId, String acmplNth, String defNo) {
		Map<String,String> param = new HashMap<String,String>();
		param.put("tsDataId", tsDataId);	//테스트데이터ID
		param.put("acmplNth", acmplNth);	//수행회차
		param.put("defNo", defNo);	//결함일련번호
		
		int delCount = 0;
		
		delCount = SqlMapper.getSqlClient("TESTRO_DB").delete("flaw.deleteFlaw", param);
		
		return delCount;
	}
	
	/**
	 * 
	 * <p>
	 * 결함조치 수정
	 * <p>
	 * @param flawDto 결함DTO
	 * @return int 수정건수
	 */
	public int modifyTreat(FlawDto flawDto) {
		return SqlMapper.getSqlClient("TESTRO_DB").update("flaw.modifyTreat", flawDto);
	}
	
	/**
	 * 
	 * <p>
	 * 나의테스트케이스결함조회 건수
	 * <p>
	 * @param param 조회파라메터
	 * @return int 조회건수
	 */
	public int getListMyTCFlawCnt(Map param) {
		return (Integer)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("flaw.getListMyTCFlawCnt", param);
	}
	
	/**
	 * 
	 * <p>
	 * 나의테스트케이스결함조회
	 * <p>
	 * @param param 조회파라메터
	 * @return List<FlawDto> 결함DTO List 
	 */
	public List<FlawDto> getListMyTCFlaw(Map param) {
		return (List<FlawDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("flaw.getListMyTCFlaw", param, (Integer)param.get("startnum"), (Integer)param.get("endnum"));
	}
	
	/**
	 * 
	 * <p>
	 * 나의테스트시나리오결함조회 건수
	 * <p>
	 * @param param 조회파라메터
	 * @return int 조회건수
	 */
	public int getListMyTSFlawCnt(Map param) {
		return (Integer)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("flaw.getListMyTSFlawCnt", param);
	}
	
	/**
	 * 
	 * <p>
	 * 나의테스트시나리오결함조회
	 * <p>
	 * @param param 조회파라메터
	 * @return List<FlawDto> 결함DTO List 
	 */
	public List<FlawDto> getListMyTSFlaw(Map param) {
		return (List<FlawDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("flaw.getListMyTSFlaw", param, (Integer)param.get("startnum"), (Integer)param.get("endnum"));
	}
	
	/**
	 * 
	 * <p>
	 * 나의테스트케이스재테스트 조회 건수
	 * <p>
	 * @param param 조회파라메터
	 * @return int 조회건수
	 */
	public int getListMyTCReTestCnt(Map param) {
		return (Integer)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("flaw.getListMyTCReTestCnt", param);
	}
	
	/**
	 * 
	 * <p>
	 * 나의테스트케이스재테스트 조회
	 * <p>
	 * @param param 조회파라메터
	 * @return List<FlawDto> 결함DTO List 
	 */
	public List<FlawDto> getListMyTCReTest(Map param) {
		return (List<FlawDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("flaw.getListMyTCReTest", param, (Integer)param.get("startnum"), (Integer)param.get("endnum"));
	}
	
	/**
	 * 
	 * <p>
	 * 나의테스트시나리오재테스트 조회 건수
	 * <p>
	 * @param param 조회파라메터
	 * @return int 조회건수
	 */
	public int getListMyTSReTestCnt(Map param) {
		return (Integer)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("flaw.getListMyTSReTestCnt", param);
	}
	
	/**
	 * 
	 * <p>
	 * 나의테스트시나리오재테스트 조회
	 * <p>
	 * @param param 조회파라메터
	 * @return List<FlawDto> 결함DTO List 
	 */
	public List<FlawDto> getListMyTSReTest(Map param) {
		return (List<FlawDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("flaw.getListMyTSReTest", param, (Integer)param.get("startnum"), (Integer)param.get("endnum"));
	}
}

