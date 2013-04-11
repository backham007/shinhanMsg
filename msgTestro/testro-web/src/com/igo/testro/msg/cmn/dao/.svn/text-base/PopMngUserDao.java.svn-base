package com.igo.testro.msg.cmn.dao;

import com.igo.testro.das.SqlMapper;
import com.igo.testro.msg.cmn.dto.PopMngUserDto;

/**
 * <p>
 * 프로그램명:PopMngUserDao.java<br/>
 * 설명 : 나의 프로젝트 관리<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */
public class PopMngUserDao {
	
	/**
	 * <p>
	 * 메소드 설명 : 사용자 ID 중복 체크
	 * <p> 
	 * @param usrID
	 * @return (Integer)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("PopMngUser.getCheck",usrID)
	 */
	@SuppressWarnings("unchecked")
	public int getCheck(String usrID){
		return  (Integer)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("PopMngUser.getCheck",usrID);
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 사용자 DELYN 중복 체크
	 * <p> 
	 * @param usrID
	 * @return (Integer)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("PopMngUser.getCheck",usrID)
	 */
	@SuppressWarnings("unchecked")
	public int getDelYNCheck(String usrID){
		return  (Integer)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("PopMngUser.getDelYNCheck",usrID);
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 사용자 비밀번호 초기화
	 * <p> 
	 * @param popMngUserdto
	 * @return result
	 */
	public int getClearPass(PopMngUserDto popMngUserdto) {
		int result = SqlMapper.getSqlClient("TESTRO_DB").update("PopMngUser.getclearPass", popMngUserdto);
		return result;	
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 사용자 아이디 저장
	 * <p> 
	 * @param popMngUserdto
	 * @return result
	 */
	public Object getUserIdInsert(PopMngUserDto popMngUserdto) {
		String result = (String) SqlMapper.getSqlClient("TESTRO_DB").insert("PopMngUser.getUserIdInsert", popMngUserdto);
		return result;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 사용자 아이디 수정
	 * <p> 
	 * @param popMngUserdto
	 * @return result
	 */
	public int getUserIdUpdate(PopMngUserDto popMngUserdto) {
		int result = SqlMapper.getSqlClient("TESTRO_DB").update("PopMngUser.getUserIdUpdate", popMngUserdto);
		return result;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 삭제 아이디에 새로운 아이디 생성(덮어쓰기)
	 * <p> 
	 * @param popMngUserdto
	 * @return result
	 */
	public int getUserIdNewUpdate(PopMngUserDto popMngUserdto) {
		int result = SqlMapper.getSqlClient("TESTRO_DB").update("PopMngUser.getUserIdNewUpdate", popMngUserdto);
		return result;
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 수정시 데이터 조회
	 * <p> 
	 * @param popMngUserdto
	 * @return usrName
	 */
	public String nameSearch(PopMngUserDto popMngUserDto) {
		String usrName = ((PopMngUserDto)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("PopMngUser.nameSearch", popMngUserDto)).getUsrName();
		popMngUserDto.setUsrName(usrName);
		String usrLevel = ((PopMngUserDto)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("PopMngUser.UsrLevelSearch", popMngUserDto)).getUsrLevel();
		popMngUserDto.setUsrLevel(usrLevel);
		return usrName;
	}
}
