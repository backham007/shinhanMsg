package com.igo.testro.msg.statistics.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import com.igo.testro.das.SqlMapper;
import com.igo.testro.msg.statistics.dto.DefPrgsStsDto;
import com.igo.testro.msg.statistics.dto.RptParamDTO;
import com.igo.testro.msg.statistics.dto.StatisticDto;


/**
 * <p>
 * 프로그램명:StatisticsDao.java<br/>
 * 설명 : 통계 보고서 조회 Dao(단계별 진척현황,개인별 진척현황,결함 총괄표 조회)<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 24. : parkminho : 내용
 * </ul> 
 * </p>
 */
public class StatisticsDao {
	
	/**
	 * <p>
	 * 메소드 설명 : 테스트케이스 단계별 진척현황 조회 
	 * <p>
	 * @param daoParam
	 * @return
	 * @throws DataAccessException
	 */
	public List<StatisticDto> getTscsTestPrgsSts(RptParamDTO daoParam) throws DataAccessException{
			return (ArrayList<StatisticDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("statistics.getTscsTestPrgsSts", daoParam);		
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 시나리오 단계별 진척현황 조회
	 * <p>
	 * @param daoParam
	 * @return
	 * @throws DataAccessException
	 */
	public List<StatisticDto> getSnroTestPrgsSts(RptParamDTO daoParam) throws DataAccessException{
			return (ArrayList<StatisticDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("statistics.getSnroTestPrgsSts", daoParam);		
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 테스트케이스 개인별 진척현황 조회
	 * <p>
	 * @param daoParam
	 * @return
	 * @throws DataAccessException
	 */
	public ArrayList<StatisticDto> getTscsPrvtTestPrgsSts(RptParamDTO daoParam) throws DataAccessException{
			return (ArrayList<StatisticDto>) SqlMapper.getSqlClient("TESTRO_DB").queryForList("statistics.getTscsPrvtTestPrgsSts", daoParam);		
	}
	/**
	 * <p>
	 * 메소드 설명 : 시나리오 개인별 진척현황 조회
	 * <p>
	 * @param daoParam
	 * @return
	 * @throws DataAccessException
	 */
	public ArrayList<StatisticDto> getSnroPrvtTestPrgsSts(RptParamDTO daoParam) throws DataAccessException{
			return (ArrayList<StatisticDto>) SqlMapper.getSqlClient("TESTRO_DB").queryForList("statistics.getSnroPrvtTestPrgsSts", daoParam);		
	}

	/**
	 * <p>
	 * 메소드 설명 : 테스트케이스 부서별 진척현황 조회
	 * <p>
	 * @param daoParam
	 * @return
	 * @throws DataAccessException
	 */
	public ArrayList<StatisticDto> getTscsDeptTestPrgsSts(RptParamDTO daoParam) throws DataAccessException{
			return (ArrayList<StatisticDto>) SqlMapper.getSqlClient("TESTRO_DB").queryForList("statistics.getTscsDeptTestPrgsSts", daoParam);		
	}
	/**
	 * <p>
	 * 메소드 설명 : 시나리오 부서별 진척현황 조회
	 * <p>
	 * @param daoParam
	 * @return
	 * @throws DataAccessException
	 */
	public ArrayList<StatisticDto> getSnroDeptTestPrgsSts(RptParamDTO daoParam) throws DataAccessException{
			return (ArrayList<StatisticDto>) SqlMapper.getSqlClient("TESTRO_DB").queryForList("statistics.getSnroDeptTestPrgsSts", daoParam);		
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 결함 총괄표 조회
	 * <p>
	 * @param bizParam
	 * @return
	 * @throws DataAccessException
	 */
	public ArrayList<DefPrgsStsDto> getDefPrgsSts(RptParamDTO bizParam) throws DataAccessException{

		
		return (ArrayList<DefPrgsStsDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("statistics.getDefPrgsSts",bizParam,bizParam.getStartnum(),bizParam.getEndnum());
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 결함 총괄표 목록 갯수 조회
	 * <p>
	 * @param bizParam
	 * @return
	 * @throws DataAccessException
	 */
	public int getCountDefPrgsSts(RptParamDTO bizParam) throws DataAccessException{
		
		return (Integer)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("statistics.getCountDefPrgsSts",bizParam);
	}
}
