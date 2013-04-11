package com.igo.testro.msg.tcmng.dao;

import java.util.ArrayList;
import java.util.List;

import com.igo.testro.das.SqlMapper;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.tcmng.dto.CheckPointDTO;

/**
 * <p>
 * 프로그램명:CheckPointDao.java<br/>
 * 설명 : <br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 19. : ksj : 내용
 * </ul> 
 * </p>
 */
public class CheckPointDao {
	final ITestroLogger logger = TestroLogHelper.getBiz();
	
	/**
	 * 
	 * <p>
	 * 체크포인트 목록 조회
	 * <p>
	 * @param tsdataID 				테스트데이터ID
	 * @return List<CheckPointDTO>	CheckPointDTO List
	 */
	@SuppressWarnings("unchecked")
	public List<CheckPointDTO> getListCheckPoint(String tsdataID) {
		if (logger.isDebugEnabled()) logger.debug("getListCheckPoint()");
		return (ArrayList<CheckPointDTO>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("checkPoint.getListCheckPoint", tsdataID);
	}

}
