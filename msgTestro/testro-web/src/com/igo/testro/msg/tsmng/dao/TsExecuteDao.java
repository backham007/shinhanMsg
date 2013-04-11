package com.igo.testro.msg.tsmng.dao;

import com.igo.testro.das.SqlMapper;
import com.igo.testro.msg.tsmng.dto.RptSnrioBasicDTO;
import com.igo.testro.msg.tsmng.dto.RptSnrioDetailDTO;

/**
 * <p>
 * 프로그램명:TsExecuteDao.java<br/>
 * 설명 : 테스트데이터 실행 Dao<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 7. : 김기태 : 최초작성
 * </ul> 
 * </p>
 */
public class TsExecuteDao {

	/**
	 * <p>
	 * 테스트 시나리오 실적을 저장
	 * <p>
	 * @param rptSnrioBasicDTO - 테스트 시나리오 실적정보
	 */
	public void registerRptSnrio(RptSnrioBasicDTO rptSnrioBasicDTO) {
		SqlMapper.getSqlClient("TESTRO_DB").insert("tsExecute.registerRptSnrio", rptSnrioBasicDTO);
	}

	/**
	 * <p>
	 * 다음 테스트 수행회차를 가져온다. 
	 * <p>
	 * @param tsSnrioID - 테스트시나리오 아이디
	 * @return 수행회차
	 */
	public int getRptSnrioNextAcmplNth(String tsSnrioID) {
		Integer result = (Integer)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("tsExecute.getRptSnrioNextAcmplNth", tsSnrioID);
		if(result == null){
			result = new Integer(1);
		}
		return result.intValue();
	}

	/**
	 * <p>
	 * 테스트 시나리오 실적정보를 수정한다.
	 * <p>
	 * @param rptSnrioBasicDTO - 테스트시나리오 실적정보 
	 */
	public void modifyRptSnrio(RptSnrioBasicDTO rptSnrioBasicDTO) {
		SqlMapper.getSqlClient("TESTRO_DB").update("tsExecute.modifyRptSnrio", rptSnrioBasicDTO);
	}

	/**
	 * <p>
	 * 테스트 시나리오 상세 실적 정보를 저장한다.
	 * <p>
	 * @param rptSnrioDetailDTO - 테스트시나리오 상세 실적정보
	 */
	public void registerRptSnrioDetail(RptSnrioDetailDTO rptSnrioDetailDTO) {
		SqlMapper.getSqlClient("TESTRO_DB").insert("tsExecute.registerRptSnrioDetail", rptSnrioDetailDTO);
	}

}
