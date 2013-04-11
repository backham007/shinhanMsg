package com.igo.testro.msg.exeSts.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.igo.testro.das.SqlMapper;
import com.igo.testro.msg.exeSts.dto.ExeStsRsltDTO;
import com.igo.testro.msg.statistics.dto.RptParamDTO;


public class ExeStsDao {
	
	/**
	 * <p>
	 * 메소드 설명 : 시나리오 테스트 수행 현황.
	 * <p>
	 * @param daoParam
	 * @return
	 * @throws DataAccessException
	 */
	public List<ExeStsRsltDTO> getSnroExeStsLst(RptParamDTO daoParam) throws DataAccessException{
		
			return (ArrayList<ExeStsRsltDTO>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("exests.getSnroExeStsLst", daoParam);		
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 테스트케이스 테스트 수행 현황.
	 * <p>
	 * @param daoParam
	 * @return
	 */
	public ArrayList<ExeStsRsltDTO> getTscsExeStsLst(RptParamDTO daoParam) {
			return (ArrayList<ExeStsRsltDTO>) SqlMapper.getSqlClient("TESTRO_DB").queryForList("exests.getTscsExeStsLst", daoParam);		
	}
}
