package com.igo.testro.msg.cmn.dao;

import com.igo.testro.das.SqlMapper;
import com.igo.testro.msg.cmn.dto.MyQaltyDto;
import com.igo.testro.msg.cmn.dto.PopMngUserDto;

/**
 * <p>
 * 프로그램명:PopMyQaltyDao.java<br/>
 * 설명 : 사용자 관리<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */
public class PopMyQaltyDao {
	/**
	 * <p>
	 * 메소드 설명 : 프로젝트 번호 중복 체크
	 * <p> 
	 * @param projNo
	 * @return (Integer)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("PopMyQalty.getCheck",projNo)
	 */
	@SuppressWarnings("unchecked")
	public int getCheck(String projNo){
		return  (Integer)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("PopMyQalty.getCheck",projNo);
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 테스트 단계 중복 체크
	 * <p> 
	 * @param projNo
	 * @return (Integer)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("PopMyQalty.getCheck",projNo)
	 */
	public int projectStepCheckMngUser(MyQaltyDto myQaltyDto) {
		int result = (Integer)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("PopMyQalty.projectStepCheckMngUser",myQaltyDto);
		return result;
	}
	/**
	 * <p>
	 * 메소드 설명 : 프로젝트 저장
	 * <p> 
	 * @param myQaltyDto
	 * @return result
	 */
	public Object getProjectInsert(MyQaltyDto myQaltyDto) {
		String result = (String) SqlMapper.getSqlClient("TESTRO_DB").insert("PopMyQalty.getProjectInsert", myQaltyDto);
		return result;
	}

	/**
	 * <p>
	 * 메소드 설명 : 첫화면 프로젝트 조회
	 * <p> 
	 * @param myQaltyDto
	 * @return (MyQaltyDto)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("PopMyQalty.projectSearch", myQaltyDto)
	 */
	public MyQaltyDto projectSearch(MyQaltyDto myQaltyDto) {
		return (MyQaltyDto)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("PopMyQalty.projectSearch", myQaltyDto);
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 프로젝트 수정
	 * <p> 
	 * @param myQaltyDto
	 * @return result
	 */
	public int getProjectUpdate(MyQaltyDto myQaltyDto) {
		int result = SqlMapper.getSqlClient("TESTRO_DB").update("PopMyQalty.getprojectUpdate", myQaltyDto);
		return result;
	}

}
