package com.igo.testro.msg.cmn.dao;

import java.util.Map;

import com.igo.testro.das.SqlMapper;

/**
 * <p>
 * 프로그램명:MngSeqIdDao.java<br/>
 * 설명 : seq ID 관리 Dao<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 7. : 김기태 : 최초작성
 * </ul> 
 * </p>
 */
public class MngSeqIdDao {

	/**
	 * <p>
	 * 현재 MAX seq ID를 가져온다.
	 * <p>
	 * @param params - 파라메터
	 * @return
	 */
	public String getCurrentSeqId(Map<String, Object> params) {
		return (String) SqlMapper.getSqlClient("TESTRO_DB").queryForObject("mngSeqId.getCurrentSeqId", params);
	}
}
