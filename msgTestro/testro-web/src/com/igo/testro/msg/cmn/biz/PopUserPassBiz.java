package com.igo.testro.msg.cmn.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.igo.testro.msg.cmn.dao.PopUserPassDao;
import com.igo.testro.msg.cmn.dto.PopUserPassDto;

/**
 * <p>
 * 프로그램명:PopUserPassBiz.java<br/>
 * 설명 : 비밀번호 변경<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */

public class PopUserPassBiz {
	@Autowired
	private PopUserPassDao popUserPassDao;
	/**
	 * <p>
	 * 메소드 설명 : 사용자 비밀번호 변경
	 * <p> 
	 * <p>비밀번호 초기화 또는 최초 가입한 아이디일 경우 비밀번호를 변경하는 팝업이다.
	 * <p>비밀번호 변경하고 싶을경우 변경한다.
	 * @param popUserPassDto 전문레이아웃DTO
	 * @return popUserPassDao.userPassSave(popUserPassDto)	
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Object userPassSave(PopUserPassDto popUserPassDto) {
		return popUserPassDao.userPassSave(popUserPassDto);			//비밀번호 변경
	}
}
