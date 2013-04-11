package com.igo.testro.msg.statistics.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.igo.testro.cmn.utils.StringUtil;
import com.igo.testro.exception.BizException;
import com.igo.testro.msg.statistics.dao.StatisticsDao;
import com.igo.testro.msg.statistics.dto.DefPrgsStsDto;
import com.igo.testro.msg.statistics.dto.RptParamDTO;
import com.igo.testro.msg.statistics.dto.StatisticDto;

/**
 * <p>
 * 프로그램명:StatisticsBiz.java<br/>
 * 설명 : 단계별 진척 현황 조회<br/>
 * 변경이력<br/>
 * <ul>
 * <li>2012. 2. 14. : parkminho : 내용
 * </ul>
 * </p>
 */
public class StatisticsBiz {

	@Autowired
	StatisticsDao statisticsDao;

	public void setStatisticsDao(StatisticsDao statisticsDao) {
		this.statisticsDao = statisticsDao;
	}

	/**
	 * <p>
	 * 메소드 설명 : 단계별 진척 현황을 조회 조건에 따라 조회 한다.
	 * <p>
	 * 
	 * @param daoParam
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Map getTestPrgsSts(RptParamDTO bizParam) {

		List<StatisticDto> resultList = new ArrayList<StatisticDto>();
		try {
			// 날짜에서'-' 없애기
			if (bizParam.getTestStartYMS() != null
					&& !"".equals(bizParam.getTestStartYMS())) {
				bizParam.setTestStartYMS(bizParam.getTestStartYMS().replace(
						"-", ""));
			}
			if (bizParam.getTestEndYMS() != null
					&& !"".equals(bizParam.getTestEndYMS())) {
				bizParam.setTestEndYMS(bizParam.getTestEndYMS()
						.replace("-", ""));
			}
			ArrayList<StatisticDto> dlist = new ArrayList<StatisticDto>();
			if (bizParam.getSearchGubun() != null
					&& "01".equals(bizParam.getSearchGubun())) { // 테스트 케이스 
				resultList = (ArrayList<StatisticDto>) statisticsDao
						.getTscsTestPrgsSts(bizParam);
			} else if (bizParam.getSearchGubun() != null
					&& "02".equals(bizParam.getSearchGubun())) { // 테스트 시나리오
				resultList = (ArrayList<StatisticDto>) statisticsDao
						.getSnroTestPrgsSts(bizParam);

			}
		} catch (Exception e) {
			throw new BizException("MSG_STSMNG0001", "", e);
		}
		Map outputMap = new HashMap();
		outputMap.put("rows", resultList);

		return outputMap;
	}

	/**
	 * <p>
	 * 메소드 설명 : 개인별 진척 현황을 조회 조건에 따라 조회 한다.
	 * <p>
	 * 
	 * @param bizParam
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Map getPrvtTestPrgsSts(RptParamDTO bizParam) {

		ArrayList<StatisticDto> dlist = new ArrayList<StatisticDto>();
		try {
			// 날짜에서'-' 없애기
			if (bizParam.getTestStartYMS() != null
					&& !"".equals(bizParam.getTestStartYMS())) {
				bizParam.setTestStartYMS(bizParam.getTestStartYMS().replace(
						"-", ""));
			}
			if (bizParam.getTestEndYMS() != null
					&& !"".equals(bizParam.getTestEndYMS())) {
				bizParam.setTestEndYMS(bizParam.getTestEndYMS()
						.replace("-", ""));
			}
			if (bizParam.getSearchGubun().equals("01")) {  // 테스트 케이스
				dlist = (ArrayList<StatisticDto>) statisticsDao
						.getTscsPrvtTestPrgsSts(bizParam);
			} else if (bizParam.getSearchGubun().equals("02")) {  // 테스트 시나리오
				dlist = (ArrayList<StatisticDto>) statisticsDao
						.getSnroPrvtTestPrgsSts(bizParam);

			}
		} catch (Exception e) {

			throw new BizException("MSG_STSMNG0002", "", e);
		}
		Map outputMap = new HashMap();
		outputMap.put("rows", dlist);

		return outputMap;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 부서별 진척 현황을 조회 조건에 따라 조회 한다.
	 * <p>
	 * 
	 * @param bizParam
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Map getDeptTestPrgsSts(RptParamDTO bizParam) {

		ArrayList<StatisticDto> dlist = new ArrayList<StatisticDto>();
		try {
			// 날짜에서'-' 없애기
			if (bizParam.getTestStartYMS() != null
					&& !"".equals(bizParam.getTestStartYMS())) {
				bizParam.setTestStartYMS(bizParam.getTestStartYMS().replace(
						"-", ""));
			}
			if (bizParam.getTestEndYMS() != null
					&& !"".equals(bizParam.getTestEndYMS())) {
				bizParam.setTestEndYMS(bizParam.getTestEndYMS()
						.replace("-", ""));
			}
			if (bizParam.getSearchGubun().equals("01")) {  // 테스트 케이스
				dlist = (ArrayList<StatisticDto>) statisticsDao
						.getTscsDeptTestPrgsSts(bizParam);
			} else if (bizParam.getSearchGubun().equals("02")) {  // 테스트 시나리오
				dlist = (ArrayList<StatisticDto>) statisticsDao
						.getSnroDeptTestPrgsSts(bizParam);
			}
		} catch (Exception e) {
			throw new BizException("MSG_STSMNG0005", "", e);
		}
		Map outputMap = new HashMap();
		outputMap.put("rows", dlist);
		return outputMap;
	}

	/**
	 * <p>
	 * 메소드 설명 : 결함 총괄표목록을 조회 조건에 따라 조회 한다.
	 * <p>
	 * 
	 * @param bizParam
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Map getDefPrgsSts(RptParamDTO bizParam) {

		// 날짜에서'-' 없애기
		if (bizParam.getTestStartYMS() != null
				&& !"".equals(bizParam.getTestStartYMS())) {
			bizParam.setTestStartYMS(bizParam.getTestStartYMS().replace(
					"-", ""));
		}
		if (bizParam.getTestEndYMS() != null
				&& !"".equals(bizParam.getTestEndYMS())) {
			bizParam.setTestEndYMS(bizParam.getTestEndYMS()
					.replace("-", ""));
		}
		
		Map outputMap = new HashMap();
		bizParam.setRecords(statisticsDao.getCountDefPrgsSts(bizParam)); // 결함총괄표목록 건수 구하기.(페이징 처리 TOTAL 값 필요..)
		ArrayList<DefPrgsStsDto> resultList = new ArrayList<DefPrgsStsDto>();
		try {

			resultList = statisticsDao.getDefPrgsSts(bizParam);
			for (DefPrgsStsDto defPrgsStsDto : resultList) {
				defPrgsStsDto.setFlawId(StringUtil.rpad(defPrgsStsDto
						.getTsdataId(), 20, '0')
						+ StringUtil.lpad(defPrgsStsDto.getTsdataAcmplNth(), 3,
								'0')
						+ StringUtil.lpad(defPrgsStsDto.getDefNo(), 3, '0'));
			}
		} catch (Exception e) {
			throw new BizException("MSG_STSMNG0004", "", e);
		}
        int totalRows = bizParam.getRecords();
//        if(totalRows>500) totalRows = 500;
        
		outputMap.put("records",totalRows);
		outputMap.put("page", bizParam.getPage());
		outputMap.put("total", bizParam.getTotal());
		outputMap.put("rows", resultList);
		return outputMap;
	}

}
