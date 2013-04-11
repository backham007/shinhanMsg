package com.igo.testro.msg.cmn.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.igo.testro.das.SqlMapper;
import com.igo.testro.msg.cmn.dto.ProjPopDto;

/**
 * 
 * <p>
 * 프로그램명:ProjPopDao.java<br/>
 * 설명 : 프로젝트조회 DAO<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 21. : KoJaeHyeong : 최초작성
 * </ul> 
 * </p>
 */
public class ProjPopDao {

	/**
	 * 
	 * <p>
	 * 프로젝트조회 건수
	 * <p>
	 * @param param 파라메터Map
	 * @return int 프로젝트조회 건수 
	 */
	public int getListProjCnt(Map param){
		return (Integer) SqlMapper.getSqlClient("TESTRO_DB").queryForObject("projPop.getListProjCnt", param);
	}
	
	/**
	 * 
	 * <p>
	 * 프로젝트조회
	 * <p>
	 * @param param 파라메터Map
	 * @return List<ProjPopDto> 프로젝트조회DTO List
	 */
	public List<ProjPopDto> getListProj(Map param){
		return (List<ProjPopDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("projPop.getListProj", param, (Integer)param.get("startnum"), (Integer)param.get("endnum"));
	}
	
	/**
	 * 
	 * <p>
	 * 테스트단계명 조회
	 * <p>
	 * @param projNo 프로젝트번호
	 * @return List<ProjPopDto> 프로젝트조회DTO List
	 */
	public List<ProjPopDto> getListTestStgeName(String projNo){
		Map<String,String> param = new HashMap<String,String>();
		param.put("projNo", projNo);
		
		return (List<ProjPopDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("projPop.getListTestStgeName", param);
	}
}

