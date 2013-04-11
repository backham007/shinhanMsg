package com.igo.testro.msg.tcmng.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.igo.testro.das.SqlMapper;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.pretst.dto.TestDataDetailDto;
import com.igo.testro.msg.pretst.dto.TestDataDto;
import com.igo.testro.msg.tcmng.dto.TcDto;


/**
 * <p>
 * 프로그램명:TcmngAddDao.java<br/>
 * 설명 : <br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 19. : ksj : 내용
 * </ul> 
 * </p>
 */
public class TcmngAddDao {
	
	final ITestroLogger logger = TestroLogHelper.getBiz();
	
	/**
	 * 
	 * <p>
	 * 테스트케이스 총 건수 조회
	 * <p>
	 * @param map
	 * @return Integer 총건수
	 */
	public Integer getTcTotCnt(Map map) {
		if (logger.isDebugEnabled()) logger.debug("getTcTotCnt()");
		return (Integer)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("tcmngAdd.getTcTotCnt", map);
	}
	
	/**
	 * 
	 * <p>
	 * 테스트케이스 목록 조회
	 * <p>
	 * @param map
	 * @return ArrayList<TcDto> 테스트케이스Dto List
	 */
	public ArrayList<TcDto> getTcList(Map map) {
		if (logger.isDebugEnabled()) logger.debug("getTcList()");
		ArrayList<TcDto> result = null;
		result = (ArrayList<TcDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("tcmngAdd.getTcTotList", map, (Integer)map.get("startnum") ,(Integer)map.get("endnum"));
		return result;
	}
	
	/**
	 * 
	 * <p>
	 * 테스트데이터 총건수 조회
	 * <p>
	 * @param map
	 * @return Integer 테스트데이터 총건수
	 */
	public Integer getTdTotCnt(Map map) {
		if (logger.isDebugEnabled()) logger.debug("getTdTotCnt()");
		return (Integer)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("tcmngAdd.getTdTotCnt", map);
	}
	
	/**
	 * 
	 * <p>
	 * 테스트데이터 목록 조회
	 * <p>
	 * @param map
	 * @return ArrayList<TestDataDto> 테스트데이터Dto List
	 */
	public ArrayList<TestDataDto> getTdList(Map map) {
		if (logger.isDebugEnabled()) logger.debug("getTdList()");
		ArrayList<TestDataDto> result = null;
		result = (ArrayList<TestDataDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("tcmngAdd.getTdTotList", map);
		return result;
	}

	/**
	 * 
	 * <p>
	 * 테스트데이터 상세 목록 조회
	 * <p>
	 * @param map
	 * @return List<TestDataDetailDto> 테스트데이터상세Dto List
	 */
	public List<TestDataDetailDto> getTdDetailList(Map map) {
		if (logger.isDebugEnabled()) logger.debug("getTdDetailList()");
		List<TestDataDetailDto> result = null;
		result = (List<TestDataDetailDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("tcmngAdd.getTdDetailList", map);
		return result;
	}
}
