package com.igo.testro.msg.cmn.biz;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.igo.testro.exception.BizException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.cmn.dao.PopMyQaltyDao;
import com.igo.testro.msg.cmn.dto.MyQaltyDto;

/**
 * <p>
 * 프로그램명:PopMyQaltyBiz.java<br/>
 * 설명 : 사용자 관리<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */

public class PopMyQaltyBiz {
	final ITestroLogger logger = TestroLogHelper.getBiz();
	@Autowired
	private PopMyQaltyDao popMyQaltyDao;
	
	/**
	 * <p>
	 * 메소드 설명 : 프로젝트 번호 중복 체크
	 * <p> 
	 * @param request HttpServletRequest
	 * @return totcnt 체크리턴값
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int getCheck(HttpServletRequest request){
		
		String projNo = request.getParameter("projNo");		//프로젝트번호
		int totcnt = 0;										//리턴값 변수
		try{
			totcnt = popMyQaltyDao.getCheck(projNo);		//번호 중복 체크
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_MYUSER0005","", e);
		}
		return totcnt;
	}
	/**
	 * <p>
	 * 메소드 설명 : 테스트 단계 중복 체크
	 * <p> 
	 * <p> 프로젝트 번호를 가지고 와서 테스트 단계 중복 여부를 판단한다.
	 * @param myQaltyDto 전문레이아웃DTO
	 * @return totcnt 체크리턴값
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Object projectStepCheckMngUser(MyQaltyDto myQaltyDto) {
		int totcnt = 0;														//리턴값 변수
		try{
			totcnt = popMyQaltyDao.projectStepCheckMngUser(myQaltyDto);		//테스트 단계 중복 체크
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_MYUSER0005","", e);
		}
		return totcnt;
	}
	/**
	 * <p>
	 * 메소드 설명 : 프로젝트 저장
	 * <p> 
	 * @param myQaltyDto 전문레이아웃DTO
	 * @return totcnt 체크리턴값
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Object insertProject(MyQaltyDto myQaltyDto) {
		String newInsert = myQaltyDto.getNewInsert();				//프로젝트 신규, 수정 판단 변수
		int totcnt = 0;												//리턴값 변수
		try{
			totcnt = popMyQaltyDao.projectStepCheckMngUser(myQaltyDto);
			if("Y".equals(newInsert)){								// 프로젝트 저장
				if(1 == totcnt){
					totcnt = 1;										//중복일경우
				}else{
					popMyQaltyDao.getProjectInsert(myQaltyDto);		//신규 추가
					totcnt = 0;										//신규 추가후 변수값
				}	
			}
			else if("N".equals(newInsert)){							// 프로젝트 수정
				int result =popMyQaltyDao.getProjectUpdate(myQaltyDto);
				if(1 == result){
					totcnt = 2;										//수정완료후 변수 값
				}else{
					totcnt = 1;										//수정실패후 변수 값
				}
			}
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_MYUSER0006","", e);
		}
		return totcnt;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 첫화면 프로젝트 조회
	 * <p> 
	 * <p>수정시 ID값을 가지고 값들을 조회하여 출력한다.
	 * @param myQaltyDto 전문레이아웃DTO
	 * @return popMyQaltyDao.projectSearch(myQaltyDto)  조회값 리턴
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public MyQaltyDto projectSearch(MyQaltyDto myQaltyDto) {
		return popMyQaltyDao.projectSearch(myQaltyDto);				//수정시 화면에 출력될 값 조회
	}

}
