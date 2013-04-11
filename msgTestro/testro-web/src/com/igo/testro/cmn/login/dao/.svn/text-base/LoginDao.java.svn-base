package com.igo.testro.cmn.login.dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.igo.testro.cmn.login.dto.LoginDto;
import com.igo.testro.das.SqlMapper;

/**
 * <p>
 * 프로그램명:LoginDao.java<br/>
 * 설명 : 로그인 dao<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 13. : 안도현 : 최초작성
 * </ul> 
 * </p>
 */
public class LoginDao {

	/**
	 * <p>
	 * 로그인 정보 가져오기
	 * <p>
	 * @param param
	 * @return 
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public LoginDto getuserinfo(Map param) throws DataAccessException{
		return (LoginDto)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("login.getuserinfo", param);
	}


	/**
	 * <p>
	 * 사용자프로젝트 기본정보
	 * <p>
	 * @param param
	 * @return
	 * @throws DataAccessException
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public LoginDto getprojectinfo(Map param) throws DataAccessException{
		return (LoginDto)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("login.getprojectinfo", param);
	}

	/**
	 * <p>
	 * 사용자 유무 확인
	 * <p>
	 * @param param
	 * @return
	 * @throws DataAccessException
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int getuserIdCount(Map param) throws DataAccessException{
		return (Integer)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("login.getuserIdCount", param);
	}
	
	/**
	 * <p>
	 * 패스워드 확인
	 * <p>
	 * @param param
	 * @return
	 * @throws DataAccessException
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int getuserPwCount(Map param) throws DataAccessException{
		return (Integer)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("login.getuserPwCount", param);
	}
	
	
	/**
	 * <p>
	 * 사용자 정보 가져오기
	 * <p>
	 * @param param userId
	 * @return 
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public LoginDto getUserIdInfo(String usrid) throws DataAccessException{
		return (LoginDto)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("login.getUserIdInfo", usrid);
	}
	
}
