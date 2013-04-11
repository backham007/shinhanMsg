package com.igo.testro.msg.cmn.execute.dao;

import com.igo.testro.das.SqlMapper;
import com.igo.testro.msg.cmn.execute.dto.RptCheckPointDTO;
import com.igo.testro.msg.cmn.execute.dto.RptTestDataBasicDTO;
import com.igo.testro.msg.cmn.execute.dto.RptTestDataDetailDTO;

/**
 * <p>
 * 프로그램명:TestDataExecuteDao.java<br/>
 * 설명 : 테스트 데이터 실행 Dao<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 7. : 김기태 : 최초작성
 * </ul> 
 * </p>
 */
public class TestDataExecuteDao {

	/**
	 * <p>
	 * 테스트 데이터 실적테이블 수행순서 가져온다
	 * <p>
	 * @param tsdataID 테스트데이터
	 * @return 수행순서
	 */
	public int getRptDataNextAcmplNth(String tsdataID) {
		Integer result = (Integer)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("testDataExecute.getRptDataNextAcmplNth", tsdataID);
		if(result == null){
			result = new Integer(1);
		}
		return result.intValue();
	}

	/**
	 * <p>
	 * 테스트데이터기본실적을 저장한다.
	 * <p>
	 * @param rptTestDataBasicDTO - 테스트데이터기본실적정보
	 */
	public void registerRptTestDataBasic(RptTestDataBasicDTO rptTestDataBasicDTO) {
		SqlMapper.getSqlClient("TESTRO_DB").insert("testDataExecute.registerRptTestDataBasic", rptTestDataBasicDTO);
	}

	/**
	 * <p>
	 * 테스트데이터입력상세실적을 저장한다.
	 * <p>
	 * @param rptTestDataDetailDTO - 테스트데이터입력상세실적정보
	 */
	public void registerRptTestDataDetail(RptTestDataDetailDTO rptTestDataDetailDTO) {
		SqlMapper.getSqlClient("TESTRO_DB").insert("testDataExecute.registerRptTestDataDetail", rptTestDataDetailDTO);
	}
	
	/**
	 * <p>
	 * 테스트데이터출력상세실적을 저장한다.
	 * <p>
	 * @param rptTestDataDetailDTO - 테스트데이터출력상세실적정보
	 */
	public void registerRptTestDataDetail2(RptTestDataDetailDTO rptTestDataDetailDTO) {
		SqlMapper.getSqlClient("TESTRO_DB").insert("testDataExecute.registerRptTestDataDetail2", rptTestDataDetailDTO);
	}

	/**
	 * <p>
	 * 체크포인트실적을 저장한다.
	 * <p>
	 * @param rptCheckPointDTO - 체크포인트실적 정보
	 */
	public void registerRptCheckPoint(RptCheckPointDTO rptCheckPointDTO) {
		SqlMapper.getSqlClient("TESTRO_DB").insert("testDataExecute.registerRptCheckPoint", rptCheckPointDTO);
	}

}
