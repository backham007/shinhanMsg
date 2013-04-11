package com.igo.testro.msg.tcmng.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.igo.testro.exception.BizException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.pretst.dto.TestDataDto;
import com.igo.testro.msg.tcmng.dao.TcmngAddDao;
import com.igo.testro.msg.tcmng.dto.TcDto;

/**
 * <p>
 * 프로그램명:TcmngAddBiz.java<br/>
 * 설명 : <br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 18. : ksj : 내용
 * </ul> 
 * </p>
 */
public class TcmngAddBiz {
	final ITestroLogger logger = TestroLogHelper.getBiz();
	
	@Autowired
	private TcmngAddDao tcmngAddDao;
	
	/**
	 * <p>
	 * 테스트케이스 리스트 가져오기
	 * </p>
	 * @param request(페이지정보, 조회조건)
	 * @return Map(테스트케이스총건수, 테스트케이스리스트)
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Map getTcList(HttpServletRequest request) {
		try{
			Map outputMap = new HashMap();
			Map param = new HashMap();
			int startnum = 0;
			int endnum = 0;
			int page = Integer.parseInt(request.getParameter("page"));
			int rows = Integer.parseInt(request.getParameter("rows")) ;
			
			startnum = (page - 1) * rows;
			endnum   = (rows * page);
			
			String inqType 		= request.getParameter("inqType");
			String textfiled	= request.getParameter("textfield");
			String writeName	= request.getParameter("writeName");
			String startDt	= request.getParameter("startDt");
			String endDt	= request.getParameter("endDt");
			
			param.put("startnum", startnum);
			param.put("endnum", endnum);
			param.put("sidx", request.getParameter("sidx"));
			param.put("sord", request.getParameter("sord"));
			param.put("writeName", writeName);
			param.put("startDt", startDt);
			param.put("endDt", endDt);
			
			//테스트케이스 추가이므로  거래코드를 항상 조회 조건으로 갖는다.
			param.put("tranCd", request.getParameter("tranCd"));
	
			if("tsCaseName".equals(inqType)){
				param.put("tsCaseName", textfiled);
			}else if("tsCaseDesc".equals(inqType)){
				param.put("tsCaseID", textfiled);
			}else if("tsCaseID".equals(inqType)){
				param.put("tsCaseID", textfiled);
			}else if("tranCd".equals(inqType)){
				param.put("tranCd", textfiled);
			}
			
			//테스트케이스 총건수
			int totCnt = tcmngAddDao.getTcTotCnt(param);
			
			//테스트케이스 리스트
			ArrayList<TcDto> tcList = tcmngAddDao.getTcList(param);
		
			outputMap.put("rows"	, tcList );                      	//테스트케이스 리스트
			outputMap.put("records"	, totCnt);                       	//총건수
			outputMap.put("page"	, page);                            //현재 페이지
			outputMap.put("total"	, Math.ceil((double)totCnt/rows));	//총 페이지 수
			
			return outputMap;
		}catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_TCMPOP0001","",e);
		}
	}	
	
	/**
	 * <p>
	 * 테스트데이터 리스트 가져오기
	 * </p>
	 * @param tsCaseID 테스트케이스ID
	 * @return Map(테스트데이터총건수, 테스트데이터리스트)
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Map getTdList(HttpServletRequest request) {
		try{
			Map outputMap = new HashMap();
			Map param = new HashMap();
			
			param.put("tsCaseID", request.getParameter("tsCaseID"));
			
			//테스트데이터 총건수
			int totCnt = tcmngAddDao.getTdTotCnt(param);
			
			//테스트데이터 리스트
			ArrayList<TestDataDto> tdList = tcmngAddDao.getTdList(param);
		
			outputMap.put("rows"	, tdList );                      	//테스트케이스 리스트    
			outputMap.put("records"	, totCnt);                       	//총건수           
			
			return outputMap;
		}catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_TCMPOP0002","",e);
		}
	}	
	
	/**
	 * <p>
	 * 테스트데이터 상세 리스트 가져오기
	 * </p>
	 * @param tsdataID 테스트데이터ID
	 * @return TestDataDto 테스트데이터상세
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public TestDataDto getTdDetailList(HttpServletRequest request) {
		try{
			TestDataDto tdDto = new TestDataDto();
			
			Map outputMap = new HashMap();
			Map param = new HashMap();
			
			param.put("tsdataID", request.getParameter("tsdataID"));
			
			//헤더부
			param.put("tscsFldDiv", "01");
			tdDto.setHeaderList(tcmngAddDao.getTdDetailList(param));
			//개별부
			param.put("tscsFldDiv", "02");
			tdDto.setInviList(tcmngAddDao.getTdDetailList(param));
			
			return tdDto;
		}catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_TCMPOP0003","",e);
		}
	}	
}
