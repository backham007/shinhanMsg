package com.igo.testro.msg.myLatestWork.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.igo.testro.exception.BizException;
import com.igo.testro.msg.myLatestWork.dao.MyLatestWorkDao;
import com.igo.testro.msg.myLatestWork.dto.myLatestWorkDto;

/**
 * <p>
 * 프로그램명:MyLatestWorkBiz.java<br/>
 * 설명 : 나의 최근 작업 관리 <br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 2. : parkminho : 내용
 * </ul> 
 * </p>
 */
public class MyLatestWorkBiz {
	
	@Autowired
	private MyLatestWorkDao myLatestWorkDao; 

	/**
	 * <p>
	 * 메소드 설명 : 나의 최근작업 조회 
	 * <p>
	 * @param paramDto
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Map getListMyLatestWork(myLatestWorkDto paramDto) {
		ArrayList<myLatestWorkDto> resultList = new ArrayList<myLatestWorkDto>();
		Map outputMap = new HashMap();
		
		try{
		if (paramDto.getSearchGubun().equals("01")) {           //testcase
			if (paramDto.getSubSearch().equals("01")) {         //테스트케이스명
				paramDto.setObjName(paramDto.getKeyword());
			} else if (paramDto.getSubSearch().equals("02")) {  //테스트케이스ID
				paramDto.setObjId(paramDto.getKeyword());
			} else if (paramDto.getSubSearch().equals("03")) {  // 거래코드
				paramDto.setTranCd(paramDto.getKeyword());
			}
			paramDto.setRecords(myLatestWorkDao.getCountListTestCase(paramDto));
			resultList = myLatestWorkDao.getListTestCase(paramDto);
		} else if (paramDto.getSearchGubun().equals("02")) {   //testsinario
			if (paramDto.getSubSearch().equals("01")) {        // 시나리오명
				paramDto.setObjName(paramDto.getKeyword());
			} else if (paramDto.getSubSearch().equals("02")) { // 시나리오 ID
				paramDto.setObjId(paramDto.getKeyword());
			}
			paramDto.setRecords(myLatestWorkDao.getCountListTestsinario(paramDto));
			resultList =  myLatestWorkDao.getListTestsinario(paramDto);
		} else if (paramDto.getSearchGubun().equals("03")) {  //report
			if (paramDto.getSubSearch().equals("01")) {       // 테스트 명
				paramDto.setObjName(paramDto.getKeyword());
			}
			if(paramDto.getSidx().equals("lastModfiYMS")) paramDto.setSidx("cretnYMS");  // 결과보고서는 최종수정일이 없고, 생성일이 있음.
			paramDto.setRecords(myLatestWorkDao.getCountListReport(paramDto));
			resultList = myLatestWorkDao.getListReport(paramDto);
		}
		int totalRows = paramDto.getRecords();
		
		if(totalRows > 500) totalRows = 500; //최근 500건 만 표시..
		outputMap.put("rows", resultList);
		outputMap.put("records",totalRows);
		outputMap.put("page", paramDto.getPage());
		outputMap.put("total", paramDto.getTotal());
		}catch (Exception e) {
			throw new BizException("MSG_MYWORK0001","",e);
		}
		return outputMap;
	}

	/**
	 * <p>
	 * 메소드 설명 : 최근 작업 삭제
	 * <p>
	 * @param paramDto
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteMyLatestWork(myLatestWorkDto paramDto) {
		
		int nDelCount = 0;
		try{
			String[] objIds = paramDto.getObjIds();
			String[] acmplnths = paramDto.getAcmplnths();
			for (int i = 0; i < objIds.length; i++) {
				
				paramDto.setObjId(objIds[i]);
				paramDto.setAcmplnth(acmplnths[i]);
				
				if(paramDto.getSearchGubun().equals("01")){//testcase
					nDelCount = myLatestWorkDao.deleteTestcase(paramDto);
				}else if(paramDto.getSearchGubun().equals("02")){//testsinario
					nDelCount = myLatestWorkDao.deleteTestsnro(paramDto);
				}else if(paramDto.getSearchGubun().equals("03")){//report
					if(objIds[i].startsWith("C")) paramDto.setReportGubun("01"); //테스트 케이스
					else paramDto.setReportGubun("02");                          //테스트 시나리오
					nDelCount = myLatestWorkDao.deleteReport(paramDto);
				}
			}
		}catch (Exception e) {
			throw new BizException("MSG_MYWORK0002","",e);
		}
		
		return nDelCount;
		
		
	}

}
