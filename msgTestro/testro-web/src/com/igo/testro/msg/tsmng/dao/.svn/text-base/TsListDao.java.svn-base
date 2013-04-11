package com.igo.testro.msg.tsmng.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.igo.testro.das.SqlMapper;
import com.igo.testro.msg.tsmng.dto.TestSnrioBasicDTO;
import com.igo.testro.msg.tsmng.dto.TestSnrioDetailDTO;

/**
 * <p>
 * 프로그램명:TsListDao.java<br/>
 * 설명 : 테스트시나리오 불러오기 Dao<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 17. : 김기태 : 최초작성
 * </ul> 
 * </p>
 */
public class TsListDao {

	/**
	 * <p>
	 * 테스트 시나리오 기본 List 불러오기
	 * <p>
	 * @param params 검색조건
	 * @return 테스트시나리오기본 List
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<TestSnrioBasicDTO> getListTsInfo(
			HashMap<String, Object> params) {
		
		return (ArrayList<TestSnrioBasicDTO>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("tsList.getListTsInfo", params, (Integer)params.get("startnum") ,(Integer)params.get("endnum"));
	}

	/**
	 * <p>
	 * 테스트 시나리오 상세 List 불러오기
	 * <p>
	 * @param tsSnrioID 검색할 테스트시나리오 Id
	 * @return 테스트시나리오상세 List
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<TestSnrioDetailDTO> getListTsDetailInfo(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		return (ArrayList<TestSnrioDetailDTO>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("tsList.getListTsDetailInfo", params, (Integer)params.get("startnum") ,(Integer)params.get("endnum"));
	}

	/**
	 * <p>
	 * 테스트 시나리오 갯수를 가져온다.
	 * <p>
	 * @param params - 파라메터
	 * @return 테스트 시나리오 갯수
	 */
	public int getTsCnt(HashMap<String, Object> params) {
		return (Integer) SqlMapper.getSqlClient("TESTRO_DB").queryForObject("tsList.getTsCnt", params);
	}

	/**
	 * <p>
	 * 테스트 시나리오 상세 갯수를 가져온다
	 * <p>
	 * @param params - 파라메터
	 * @return 테스트 시나리오 상세갯수
	 */
	public int getTsDetailCnt(HashMap<String, Object> params) {
		return (Integer) SqlMapper.getSqlClient("TESTRO_DB").queryForObject("tsList.getTsDetailCnt", params);
	}

}
