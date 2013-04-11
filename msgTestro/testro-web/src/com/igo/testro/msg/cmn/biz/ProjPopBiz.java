package com.igo.testro.msg.cmn.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.igo.testro.cmn.utils.DateUtil;
import com.igo.testro.exception.BizException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.cmn.dao.ProjPopDao;
import com.igo.testro.msg.cmn.dto.ProjPopDto;

/**
 * 
 * <p>
 * 프로그램명:ProjPopBiz.java<br/>
 * 설명 : 프로젝트조회 BIZ<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 21. : KoJaeHyeong : 최초작성
 * </ul> 
 * </p>
 */
public class ProjPopBiz {
	
	@Autowired
	private ProjPopDao projPopDao;
	
	final ITestroLogger logger = TestroLogHelper.getBiz();	//logger
	
	/**
	 * 
	 * <p>
	 * 프로젝트조회(페이징)
	 * <p>
	 * @param request HttpServletRequest
	 * @return Map 조회결과
	 */
	@Transactional(readOnly = true)
	public Map getListProj(HttpServletRequest request){
		
		try{
			Map outputMap = new HashMap();
			Map param = new HashMap();
			int startnum = 0;
			int endnum = 0;
			int page = Integer.parseInt(request.getParameter("page")) ;
			int rows = Integer.parseInt(request.getParameter("rows")) ;
			
			startnum = (page - 1) * rows;
			endnum   = (rows * page);
			param.put("startnum", startnum);
			param.put("endnum", endnum);
			param.put("sidx", request.getParameter("sidx"));
			param.put("sord", request.getParameter("sord"));
			
			param.put("projNoName", request.getParameter("projNoName"));	//프로젝트번호 OR 프로젝트명
			param.put("testStartYMS", request.getParameter("testStartYMS"));	//테스트시작일자
			param.put("testEndYMS", request.getParameter("testEndYMS"));	//테스트종료일자
			
			List<ProjPopDto> projPopDtoList = projPopDao.getListProj(param);
			//테스트시작일자,종료일자 날짜포맷팅(YYYY-MM-DD)
			for(ProjPopDto projPopDto : projPopDtoList){
				projPopDto.setTestStartYMS(DateUtil.convertShortQuicsFormat(projPopDto.getTestStartYMS()));
				projPopDto.setTestEndYMS(DateUtil.convertShortQuicsFormat(projPopDto.getTestEndYMS()));
			}
			int totcnt = projPopDao.getListProjCnt(param);
			
			outputMap.put("rows", projPopDtoList );                          //조회된 list 데이터
			outputMap.put("records", totcnt);                       //조회된 총건수
			outputMap.put("page", page);                            // 조회 요청페이지
			outputMap.put("total",  Math.ceil((double)totcnt/rows));//총 페이지수
			
			return outputMap;
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_PROPOP0001","", e);
		}
	}
	
	/**
	 * 
	 * <p>
	 * 테스트단계 조회
	 * <p>
	 * @param projNo 프로젝트번호
	 * @return List<ProjPopDto> 프로젝트조회DTO List
	 */
	@Transactional(readOnly = true)
	public List<ProjPopDto> getListTestStgeName(String projNo){
		try{
			return projPopDao.getListTestStgeName(projNo);
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_PROPOP0002","", e);
		}
	}
}
 