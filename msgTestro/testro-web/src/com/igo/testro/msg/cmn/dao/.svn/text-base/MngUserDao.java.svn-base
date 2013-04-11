package com.igo.testro.msg.cmn.dao;

import java.util.ArrayList;
import java.util.Map;

import com.igo.testro.das.SqlMapper;
import com.igo.testro.msg.cmn.dto.MngUserDto;

/**
 * <p>
 * 프로그램명:MngUserDao.java<br/>
 * 설명 : 사용자 정보 관리<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */

public class MngUserDao {

	/**
	 * <p>
	 * 메소드 설명 : 사용자 정보 카운터
	 * <p> 
	 * @param param 
	 * @return (Integer) SqlMapper.getSqlClient("TESTRO_DB").queryForObject("MngUser.getCnt")
	 */
	@SuppressWarnings("unchecked")
	public int getCnt(Map param){
		return (Integer) SqlMapper.getSqlClient("TESTRO_DB").queryForObject("MngUser.getCnt",param);
	}

	/**
	 * <p>
	 * 메소드 설명 : 사용자 정보 조회(레벨01)
	 * <p> 
	 * @param param
	 * @return (ArrayList<MngUserDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("MngUser.getlist",param, (Integer)param.get("startnum") ,(Integer)param.get("endnum"))
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<MngUserDto> getlist( Map param){
		return (ArrayList<MngUserDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("MngUser.getlist",param, (Integer)param.get("startnum") ,(Integer)param.get("endnum"));
	}

	/**
	 * <p>
	 * 메소드 설명 : 사용자 정보 조회(레벨02)
	 * <p> 
	 * @param param
	 * @return (ArrayList<MngUserDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("MngUser.getlistlowLevel",param, (Integer)param.get("startnum") ,(Integer)param.get("endnum"))
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<MngUserDto> getlistlowLevel( Map param){
		return (ArrayList<MngUserDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("MngUser.getlistlowLevel",param, (Integer)param.get("startnum") ,(Integer)param.get("endnum"));
	}

	/**
	 * <p>
	 * 메소드 설명 : 사용자 리스트 행 삭제(Y로 변경)
	 * <p> 
	 * @param mngUserDto
	 */
	@SuppressWarnings("unchecked")
	public void deletUserTestInfo(MngUserDto mngUserDto) {
		//사용자 정보 삭제 여부(Y로 변경)
		SqlMapper.getSqlClient("TESTRO_DB").update("MngUser.updateUserTestInfo", mngUserDto);
		//사용자 삭제 여부 (Y로 변경)
		SqlMapper.getSqlClient("TESTRO_DB").update("MngUser.updateUserInfo", mngUserDto);
	}
}
