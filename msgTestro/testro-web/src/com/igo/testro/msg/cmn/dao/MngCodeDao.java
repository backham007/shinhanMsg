package com.igo.testro.msg.cmn.dao;

import java.util.ArrayList;

import com.igo.testro.das.SqlMapper;
import com.igo.testro.msg.cmn.dto.MngCodeDto;

public class MngCodeDao {
	
	
	/**
	 * <p>
	 * 메소드 설명 : 코드 목록 조회
	 * <p>
	 * @param mngUserDto
	 * @return
	 */
	public ArrayList<MngCodeDto> getListMngCode(MngCodeDto paramDto) {
		return (ArrayList<MngCodeDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("mngCode.getListMngCode", paramDto);
	}
}
