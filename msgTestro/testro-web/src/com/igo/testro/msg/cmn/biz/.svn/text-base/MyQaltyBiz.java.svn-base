package com.igo.testro.msg.cmn.biz;

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
import com.igo.testro.msg.cmn.dao.MyQaltyDao;
import com.igo.testro.msg.cmn.dto.MyQaltyDto;

/**
 * <p>
 * 프로그램명:MyQaltyBiz.java<br/>
 * 설명 : 나의 프로젝트 정보설정<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */

public class MyQaltyBiz {
	final ITestroLogger logger = TestroLogHelper.getBiz();
	@Autowired
	private MyQaltyDao myQaltyDao;
	
	/**
	 * <p>
	 * 메소드 설명 : 나의 프로젝트 단계정보 조회
	 * <p> 
	 * <p>나의 프로젝트 단계 정보를 조회 한다.
	 * <p>프로젝트명을 입력할 경우 입력에 해당되는 프로젝트를 조회 한다.
	 * @param request HttpServletRequest
	 * @return outputMap 생성 데이터 값
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Map getlist(HttpServletRequest request){
		Map outputMap = new HashMap();
		Map param = new HashMap();
		int startnum = 0;
		int endnum = 0;
		try{
			int page = Integer.parseInt(request.getParameter("page")) ;
			int rows = Integer.parseInt(request.getParameter("rows")) ;
			
			startnum = (page - 1) * rows;
			endnum   = (rows * page);
			param.put("startnum", startnum);
			param.put("endnum", endnum);
			param.put("sidx", request.getParameter("sidx"));
			param.put("sord", request.getParameter("sord"));
			param.put("projName", request.getParameter("projName"));			//프로젝트 명
			
			ArrayList<MyQaltyDto> dlist= myQaltyDao.getlist(param);
			int totcnt = myQaltyDao.getCnt(param);
			outputMap.put("rows", dlist );                       
			outputMap.put("records", totcnt);                    
			outputMap.put("page", page);                          
			outputMap.put("total",  Math.ceil((double)totcnt/rows));
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_MYUSER0001","", e);
		} 
		return outputMap;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 프로젝트 정보 설정 저장
	 * <p> 
	 * <p>선택한 프로젝트를 자신의 프로젝트 정보에 저장한다.
	 * <p>저장을 하면서 controller에서 세션에 값을 담아 준다.
	 * @param conditionDTO 전문레이아웃DTO
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void registerMyQaltyInfo(MyQaltyDto conditionDTO){
		try{
			conditionDTO.setUsrID(conditionDTO.getLastModfiEmpid());		//usrID 담아두기
			
			int totCnt = myQaltyDao.countMyQaltyInfo(conditionDTO);			//중복여부 체크 
			if( totCnt == 0){												//중복데이터가 없을경우
				myQaltyDao.registerMyQaltyInfo(conditionDTO);				//insert 해준다
			} else {														//중복데이터가 있을경우
				myQaltyDao.updateMyQaltyInfo(conditionDTO);					//update 해준다.
			}
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_MYUSER0002","", e);
		} 
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 테스트 환경설정 저장
	 * <p> 
	 * <p>테스트 대상 시스템을 설정후 환경설정을 저장한다.
	 * @param detailDTO 전문레이아웃DTO
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void registerTestEnvi(MyQaltyDto detailDTO){
		try{
			myQaltyDao.registerTestEnvi(detailDTO);						//테스트 환경 설정을 저장
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_MYUSER0003","", e);
		} 
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 프로젝트 삭제
	 * <p> 
	 * <p> 선택한 프로젝트를 삭제한다.
	 * @param detailDTO 전문레이아웃DTO
	 * @return result 삭제 여부 구분
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int getProjectDelete(MyQaltyDto detailDTO) {
		//RPTCASE01 중복 확인
		int count = myQaltyDao.countRptCase01(detailDTO);					
		int result = 0;
		try{
			if(count == 0){
				//RPTNRO01 중복 확인
				int RptCount = myQaltyDao.countRptSNRO01(detailDTO);
				if(RptCount == 0){
					//프로젝트 명  삭제
					myQaltyDao.getProjectDelete(detailDTO);
					result = 1;
				}
			}	
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_MYUSER0004","", e);
		} 
		return result;
	}
}
