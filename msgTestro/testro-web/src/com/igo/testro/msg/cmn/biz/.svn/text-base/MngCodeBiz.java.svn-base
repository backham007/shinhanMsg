package com.igo.testro.msg.cmn.biz;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.igo.testro.exception.BizException;
import com.igo.testro.msg.cmn.dao.MngCodeDao;
import com.igo.testro.msg.cmn.dto.MngCodeDto;

/**
 * <p>
 * 프로그램명:MngCodeBiz.java<br/>
 * 설명 : 코드 목록 조회<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 27. : parkminho : 내용
 * </ul> 
 * </p>
 */
public class MngCodeBiz {

	@Autowired
	private MngCodeDao mngCodeDao;
	/**
	 * <p>
	 * 메소드 설명 : 코드 목록 조회
	 * <p> 
	 * @param paramDto
	 * @return
	 */
	@Transactional(readOnly = true)
	public ArrayList<MngCodeDto> getListMngCode(MngCodeDto paramDto){
		ArrayList<MngCodeDto> result = new ArrayList<MngCodeDto>();
//		try {
			
			result = mngCodeDao.getListMngCode(paramDto);
			
//		} catch (Exception e) {
//
//			throw new BizException("","",null);
//		}
	
		return result;
	}
	
}
