package com.igo.testro.msg.AutoData.biz;

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
import com.igo.testro.msg.AutoData.dao.UsrinputdatamngDao;
import com.igo.testro.msg.AutoData.dto.UsrinputdatamngDto;

/**
 * <p>
 * 프로그램명 : UsrinputdatamngBiz.java<br/>
 * 설명 : 사용자 입력 데이터 관리<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */
public class UsrinputdatamngBiz {
	final ITestroLogger logger = TestroLogHelper.getBiz();
	@Autowired
	private UsrinputdatamngDao usrinputdatamngDao;

	/**
	 * <p>
	 * 메소드 설명 : 사용자 입력데이터 기본 조회
	 * <p> 
	 * <p>사용자 입력데이터 기본을 조회 하는데, 필드명과 작성자를 입력할 경우
	 * <P>입력값에 대한 목록을 조회 한다.
	 * @param request HttpServletRequest
	 * @return outputMap 생성 데이터 값
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Map searchList(HttpServletRequest request) {
		Map outputMap = new HashMap();									//출력 데이터 값들 담기
		Map param = new HashMap();										//조회 하기 위해 필요한 값 담기
		int startnum = 0;												//시작값
		int endnum = 0;													//마지막값
		try{
			int page = Integer.parseInt(request.getParameter("page")) ;	//현재 페이지
			int rows = Integer.parseInt(request.getParameter("rows")) ;	//한페이지에 표시할 row수
			
			startnum = (page - 1) * rows;								//시작값
			endnum   = (rows * page) - 1;								//마지막값
			param.put("startnum", startnum);							//시작값 담기
			param.put("endnum", endnum);								//마지막값 담기
			param.put("sidx", request.getParameter("sidx"));			//sortor 이름
			param.put("sord", request.getParameter("sord"));			//sortor 방식
			param.put("fldName", request.getParameter("fldName"));						//필드명
			param.put("writeName", request.getParameter("writeName"));					//작성자명
			UsrinputdatamngDto usrinputdatamngDto = new UsrinputdatamngDto();			//usrinputdatamngDto 생성
			ArrayList<UsrinputdatamngDto> dlist= usrinputdatamngDao.searchList(param);	//조회값 List에 담기
			int totcnt = usrinputdatamngDao.searchCnt(param);							//총건수
			int listNum = Integer.valueOf(request.getParameter("rows"));
			outputMap.put("rows", dlist );                       		//테스트케이스 리스트
			outputMap.put("records", totcnt);                    		//총건수
			outputMap.put("page", page);                          		//현재 페이지
			outputMap.put("total",  Math.ceil((double)totcnt/rows));	//총 페이지 수
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_USRMNG0001","", e);
		} 
		return outputMap;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 데이터 재조회
	 * <p> 
	 * <P>데이터 저장후에 다시 재조회를 한다.
	 * @param request HttpServletRequest
	 * @return outputMap 생성 데이터 값
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Map researchList(HttpServletRequest request) {
		Map outputMap = new HashMap();
		Map param = new HashMap();
		int startnum = 0;
		int endnum = 0;
		try{
			int page = Integer.parseInt(request.getParameter("page")) ;
			int rows = Integer.parseInt(request.getParameter("rows")) ;
			
			startnum = (page - 1) * rows;
			endnum   = (rows * page) - 1;
			param.put("startnum", startnum);
			param.put("endnum", endnum);
			param.put("sidx", request.getParameter("sidx"));
			param.put("sord", request.getParameter("sord"));
			param.put("fldId", request.getParameter("fldId"));						//필드명
			UsrinputdatamngDto usrinputdatamngDto = new UsrinputdatamngDto();
			ArrayList<UsrinputdatamngDto> dlist= usrinputdatamngDao.researchList(param);
			int totcnt = usrinputdatamngDao.searchCnt(param);
			int listNum = Integer.valueOf(request.getParameter("rows"));
			outputMap.put("rows", dlist );                       
			outputMap.put("records", totcnt);                    			
			outputMap.put("page", page);                          			
			outputMap.put("total",  Math.ceil((double)totcnt/rows));		
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_USRMNG0001","", e);
		} 
		return outputMap;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 데이터 저장(기존에 있을경우)
	 * <p> 
	 * <p>기존에 데이터가 있을경우 새로운 데이터를 삽입한다.
	 * @param usrinputdatamngDto 전문레이아웃DTO
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public synchronized void insertUsrinputdatamng (UsrinputdatamngDto usrinputdatamngDto) {
		try{
			int totCnt = usrinputdatamngDao.countUsrinputdatamngInfo(usrinputdatamngDto)+1;	//필드명 갯수 카운트
			usrinputdatamngDto.setFldId(String.valueOf(totCnt));							//카운트에 +1한값을 입력
			usrinputdatamngDao.updateUsrinputdatamng(usrinputdatamngDto);					//값 저장
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_USRMNG0002","", e);
		} 
	} 
	
	/**
	 * <p>
	 * 메소드 설명 : 데이터 저장(신규일 있을경우)
	 * <p> 
	 * <p>기존에 데이터가 없을경우 새로운 데이터를 삽입한다.
	 * @param usrinputdatamngDto 전문레이아웃DTO
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public synchronized void newinsertUsrinputdatamng(UsrinputdatamngDto usrinputdatamngDto) {
		try{
			int totCnt = usrinputdatamngDao.countUsrinputdatamngInfo(usrinputdatamngDto)+1;	//필드명 갯수 카운트
			usrinputdatamngDto.setFldId(String.valueOf(totCnt));							//카운트에 +1한값을 입력
			usrinputdatamngDao.insertUsrinputdatamng(usrinputdatamngDto);					//값 저장
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_USRMNG0002","", e);
		} 
	}

	/**
	 * <p>
	 * 메소드 설명 : 데이터 행 삭제
	 * <p> 
	 * <p>선택한 행의 데이터를 삭제 한다.
	 * @param usrinputdatamngDto 전문레이아웃DTO
	 * @return result 성공 여부를 구분
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int getDelete(UsrinputdatamngDto usrinputdatamngDto) {
		int result = 0;												//성공 여부를 구분하기 위한 변수
		try{
			UsrinputdatamngDao.getDelete(usrinputdatamngDto);		//행 삭제
			result = 1;												//삭제후 변수 입력
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_USRMNG0003","", e);
		} 
		return result;
	}

	/**
	 * <p>
	 * 메소드 설명 : 상세 데이터 조회
	 * <p> 
	 * <p>선택한 필드명에 대한 필드 데이터를 조회한다.
	 * @param request HttpServletRequest
	 * @return outputMap 생성 데이터 값
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Map detailSearchList(HttpServletRequest request) {
		Map outputMap = new HashMap();
		Map param = new HashMap();
		int startnum = 0;
		int endnum = 0;
		try{
			int page = Integer.parseInt(request.getParameter("page")) ;
			int rows = Integer.parseInt(request.getParameter("rows")) ;
			
			startnum = (page - 1) * rows;
			endnum   = (rows * page) - 1;
			param.put("startnum", startnum);
			param.put("endnum", endnum);
			param.put("sidx", request.getParameter("sidx"));
			param.put("sord", request.getParameter("sord"));
			param.put("fldId", request.getParameter("fldId"));					//필드명
			UsrinputdatamngDto usrinputdatamngDto = new UsrinputdatamngDto();
			ArrayList<UsrinputdatamngDto> dlist= usrinputdatamngDao.detailSearchList(param);
			int totcnt = usrinputdatamngDao.detailSearchCnt(param);
			int listNum = Integer.valueOf(request.getParameter("rows"));
			outputMap.put("rows", dlist );                       
			outputMap.put("records", totcnt);                    
			outputMap.put("page", page);                          
			outputMap.put("total",  Math.ceil((double)totcnt/rows));
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_USRMNG0001","", e);
		}
		return outputMap;
	}

	/**
	 * <p>
	 * 메소드 설명 : 상세 데이터 저장
	 * <p> 
	 * <p>기존데이터를 다 삭제 하고 새로운 데이터를 삽입한다.
	 * @param usrinputdatamngDto 전문레이아웃DTO
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void detailInsertUsrinputdatamng(UsrinputdatamngDto usrinputdatamngDto){
		try{
		usrinputdatamngDao.detailDeleteUsrinputdatamng(usrinputdatamngDto);		//기존 데이터 삭제
		usrinputdatamngDao.detailInsertUsrinputdatamng(usrinputdatamngDto);		//새로운 데이터 저장
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_USRMNG0002","", e);
		} 
	}
}
