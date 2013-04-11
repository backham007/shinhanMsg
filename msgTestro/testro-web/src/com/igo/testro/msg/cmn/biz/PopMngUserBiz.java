package com.igo.testro.msg.cmn.biz;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.igo.testro.exception.BizException;
import com.igo.testro.logger.ITestroLogger;
import com.igo.testro.logger.TestroLogHelper;
import com.igo.testro.msg.cmn.dao.PopMngUserDao;
import com.igo.testro.msg.cmn.dto.PopMngUserDto;

/**
 * <p>
 * 프로그램명:PopMngUserBiz.java<br/>
 * 설명 : 나의 프로젝트 관리<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */

public class PopMngUserBiz {
	final ITestroLogger logger = TestroLogHelper.getBiz();
	@Autowired
	private PopMngUserDao popMngUserDao;
	
	/**
	 * <p>
	 * 메소드 설명 : 사용자 ID 중복 체크
	 * <p> 
	 * <p>사용자 ID 중복 여부를 체크 한다.
	 * @param request HttpServletRequest
	 * @return totcnt 체크리턴값
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int getCheck(HttpServletRequest request){
		int totcnt = 0;												//리턴값 변수
		try{
			String usrID = request.getParameter("usrID");			//사용자 아이디
			totcnt = popMngUserDao.getCheck(usrID);					//사용자 아이디 체크
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_MNGUSR0003","", e);
		}
		return totcnt;
	}
	/**
	 * <p>
	 * 메소드 설명 : 사용자 비밀번호 초기화
	 * <p> 
	 * <p> 초기화 버튼클릭시 "testro01"로 비밀번호를 초기화 시켜준다.
	 * @param popMngUserdto 전문레이아웃DTO
	 * @return popMngUserDao.getClearPass(popMngUserdto) 비밀번호변경후리턴
	 */	
	@Transactional(propagation = Propagation.REQUIRED)
	public int getClearPass(PopMngUserDto popMngUserdto) {
		return popMngUserDao.getClearPass(popMngUserdto);			//사용자 비밀번호 초기화
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 사용자 아이디 저장 및 수정
	 * <p> 
	 * <p>신규일경우 사용자 ID를 체크 하여 중복일경우와 삭제일경우를 체크한다.
	 * <p>신규일 경우는 새롭게 생성하거나 기존에 삭제 했을경우는 중복일경우에는 업데이트를 한다.
	 * <p>사용자 정보를 수정할경우는 ID를 체크하고 업데이트 한다.
	 * @param popMngUserdto 전문레이아웃DTO
	 * @return totcnt 체크리턴값
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Object getUserIdSave(PopMngUserDto popMngUserdto) {

		String usrID = popMngUserdto.getUsrID();					//사용자 ID
		String newInsert = popMngUserdto.getNewInsert();			//신규, 수정 구분 값
		
		int totcnt = popMngUserDao.getCheck(usrID);					//ID체크 후 값
		try{
			if("Y".equals(newInsert)){			//사용자 정보 저장
				if(1 == totcnt){
					totcnt = 1;											//중복일 경우 
				}else{
					int delYNcnt = popMngUserDao.getDelYNCheck(usrID);	//삭제 여부 체크
					if(delYNcnt ==0){
						popMngUserDao.getUserIdInsert(popMngUserdto);	//신규일 경우
					}else{
						popMngUserDao.getUserIdNewUpdate(popMngUserdto);	//기존에 삭제 했을경우
					}
					totcnt = 0;												//저장후리턴값
				}	
			}else if("N".equals(newInsert)){		//사용자 정보 수정
				int result =popMngUserDao.getUserIdUpdate(popMngUserdto);	//사용자 정보 수정
				if(1 == result){
					totcnt = 0;												//성공시
				}else{
					totcnt = 2;												//실패시
				}
			}
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_MNGUSR0004","", e);
		}
		return totcnt;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 수정시 데이터 조회
	 * <p> 
	 * <p>수정일 경우 ID를 가지고 값을 조회 한다.
	 * @param popMngUserdto 전문레이아웃DTO
	 * @return userName 이름값 리턴
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public String nameSearch(PopMngUserDto popMngUserDto) {
		String userName ="";										//사용자 이름 변수
		try{
			userName = popMngUserDao.nameSearch(popMngUserDto);		//사용자 정보 조회
		} catch (Exception e) {
			logger.error("", e);
			throw new BizException("MSG_MNGUSR0001","", e);
		}
		return userName;
	}
}
