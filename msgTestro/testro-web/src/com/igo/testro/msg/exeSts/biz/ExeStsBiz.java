package com.igo.testro.msg.exeSts.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.igo.testro.exception.BizException;
import com.igo.testro.msg.exeSts.dao.ExeStsDao;
import com.igo.testro.msg.exeSts.dto.ExeStsRsltDTO;
import com.igo.testro.msg.statistics.dto.RptParamDTO;

/**
 * <p>
 * 프로그램명:StatisticsBiz.java<br/>
 * 설명 : 테스트 수행현황 현황 조회<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 14. : parkminho : 내용
 * </ul> 
 * </p>
 */
public class ExeStsBiz {
    
	@Autowired

	private ExeStsDao exeStsDao;
	
	public void setExeStsDao(ExeStsDao exeStsDao) {
		this.exeStsDao = exeStsDao;
	}


	/**
	 * <p>
	 * 메소드 설명 : 테스트 수행 현황 조회 
	 * <p>
	 * @param daoParam
	 * @return 
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Map getExeStsLst(RptParamDTO bizParam) {
		
		List<ExeStsRsltDTO> resultList = new ArrayList<ExeStsRsltDTO>();
		try{
			//날짜에서'-' 없애기
			if(bizParam.getTestStartYMS() != null && !"".equals(bizParam.getTestStartYMS())){
				bizParam.setTestStartYMS(bizParam.getTestStartYMS().replace("-", ""));
			}			
			if(bizParam.getTestEndYMS() != null && !"".equals(bizParam.getTestEndYMS())){
				bizParam.setTestEndYMS(bizParam.getTestEndYMS().replace("-", ""));
			}
			
			if(bizParam.getSearchGubun() != null && "02".equals(bizParam.getSearchGubun())){ //시나리오
				resultList= (ArrayList<ExeStsRsltDTO>) exeStsDao.getSnroExeStsLst(bizParam);
			}else if(bizParam.getSearchGubun() != null && "01".equals(bizParam.getSearchGubun())){ //테스트케이스
				resultList= (ArrayList<ExeStsRsltDTO>) exeStsDao.getTscsExeStsLst(bizParam);
			}
		}catch(Exception e){
			throw new BizException("MSG_STSMNG0004","",e);
		}
		Map outputMap = new HashMap();
		outputMap.put("rows",resultList);
		
		return outputMap;
	}
}
