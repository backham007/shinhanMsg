package com.igo.testro.msg.cmn.dao;

import java.util.ArrayList;
import java.util.Map;

import com.igo.testro.das.SqlMapper;
import com.igo.testro.msg.cmn.dto.MyQaltyDto;

/**
 * <p>
 * 프로그램명:MyQaltyDao.java<br/>
 * 설명 : 나의 프로젝트 정보설정<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */
public class MyQaltyDao{

	/**
	 * <p>
	 * 메소드 설명 : 사용자 정보 체크
	 * <p> 
	 * @param param 
	 * @return (Integer) SqlMapper.getSqlClient("TESTRO_DB").queryForObject("MyQalty.getCnt")
	 */
	public int getCnt(Map param){
		return (Integer) SqlMapper.getSqlClient("TESTRO_DB").queryForObject("MyQalty.getCnt",param);
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 나의 프로젝트 단계정보 조회
	 * <p> 
	 * @param param
	 * @return (ArrayList<MyQaltyDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("MyQalty.getlist",param, (Integer)param.get("startnum") ,(Integer)param.get("endnum"))
	 */
	public ArrayList<MyQaltyDto> getlist( Map param){
		return (ArrayList<MyQaltyDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("MyQalty.getlist",param, (Integer)param.get("startnum") ,(Integer)param.get("endnum"));
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 사용자 아이디 체크
	 * <p> 
	 * @param request,response
	 * @return mav
	 */
	public int countMyQaltyInfo(MyQaltyDto basicDTO){
		return ((MyQaltyDto)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("MyQalty.countMyQaltyInfo", basicDTO)).getCntYn();
		//return ((MyQaltyDto)getSqlMapClientTemplate().queryForObject("testconf.countMyQaltyList",basicDTO)).getCntYn();
	}
	
	/**
	 * <p>
	 * 메소드 설명 : RPTCASE01 중복 확인
	 * <p> 
	 * @param request,response
	 * @return mav
	 */
	public int countRptCase01(MyQaltyDto basicDTO){
		int result = ((MyQaltyDto)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("MyQalty.countRptCase01", basicDTO)).getCntYn();
		return result;
		//return ((MyQaltyDto)getSqlMapClientTemplate().queryForObject("testconf.countMyQaltyList",basicDTO)).getCntYn();
	}
	
	/**
	 * <p>
	 * 메소드 설명 : RPTNRO01 중복 확인
	 * <p> 
	 * @param request,response
	 * @return mav
	 */
	public int countRptSNRO01(MyQaltyDto basicDTO){
		int result = ((MyQaltyDto)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("MyQalty.countRptSNRO01", basicDTO)).getCntYn();
		return result;
		//return ((MyQaltyDto)getSqlMapClientTemplate().queryForObject("testconf.countMyQaltyList",basicDTO)).getCntYn();
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 프로젝트 정보 신규 등록
	 * <p> 
	 * @param basicDTO
	 */
	public void registerMyQaltyInfo(MyQaltyDto basicDTO){	
		SqlMapper.getSqlClient("TESTRO_DB").insert("MyQalty.registerMyQaltyList", basicDTO);
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 프로젝트 정보 업데이트
	 * <p> 
	 * @param basicDTO
	 */
	public void updateMyQaltyInfo(MyQaltyDto basicDTO){
		SqlMapper.getSqlClient("TESTRO_DB").update("MyQalty.userUpdateMyQaltyList", basicDTO);
		SqlMapper.getSqlClient("TESTRO_DB").update("MyQalty.updateMyQaltyList", basicDTO);
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 테스트 환경설정 저장
	 * <p> 
	 * @param detailDTO
	 */
	public void registerTestEnvi(MyQaltyDto detailDTO){
		SqlMapper.getSqlClient("TESTRO_DB").update("MyQalty.registerTestEnvi",detailDTO);
	}

	/**
	 * <p>
	 * 메소드 설명 : 프로젝트 삭제
	 * <p> 
	 * @param myQaltyDto
	 */
	public void getProjectDelete(MyQaltyDto myQaltyDto) {
		SqlMapper.getSqlClient("TESTRO_DB").delete("MyQalty.getProjectDelete", myQaltyDto);
	}
}
