package com.igo.testro.msg.cmn.dao;

import com.igo.testro.das.SqlMapper;
import com.igo.testro.msg.cmn.dto.PopUserPassDto;

/**
 * <p>
 * 프로그램명:PopUserPassDao.java<br/>
 * 설명 : 비밀번호 변경<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */

public class PopUserPassDao {
	/**
	 * <p>
	 * 메소드 설명 : 사용자 비밀번호 변경
	 * <p> 
	 * @param popUserPassDto
	 * @return result
	 */
	@SuppressWarnings("unchecked")
	public Object userPassSave(PopUserPassDto popUserPassDto) {
		int result =  SqlMapper.getSqlClient("TESTRO_DB").update("PopUserPass.userPassSave", popUserPassDto);	
		return result;
	}
}
