package com.igo.testro.msg.AutoData.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import com.igo.testro.cmn.utils.DateUtil;
import com.igo.testro.das.SqlMapper;
import com.igo.testro.msg.AutoData.dto.UsrinputdatamngDto;

/**
 * <p>
 * 프로그램명 : UsrinputdatamngDao.java<br/>
 * 설명 : 사용자 입력 데이터 관리<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */
public class UsrinputdatamngDao {
	
	/**
	 * <p>
	 * 메소드 설명 : 사용자 입력데이터 기본 조회 카운터
	 * <p> 
	 * @param param
	 * @return (Integer) SqlMapper.getSqlClient("TESTRO_DB").queryForObject("Usrinputdatamng.serachCnt",param)
	 */
	@SuppressWarnings("unchecked")
	public int searchCnt(Map param){
		return (Integer) SqlMapper.getSqlClient("TESTRO_DB").queryForObject("Usrinputdatamng.serachCnt",param);
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 상세 데이터 조회 카운터
	 * <p> 
	 * @param param
	 * @return (Integer) SqlMapper.getSqlClient("TESTRO_DB").queryForObject("Usrinputdatamng.detailSearchCnt",param)
	 */
	@SuppressWarnings("unchecked")
	public int detailSearchCnt(Map param){
		return (Integer) SqlMapper.getSqlClient("TESTRO_DB").queryForObject("Usrinputdatamng.detailSearchCnt",param);
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 사용자 입력데이터 기본 조회
	 * <p> 
	 * @param param
	 * @return (ArrayList<UsrinputdatamngDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("Usrinputdatamng.serachList",param, (Integer)param.get("startnum") ,(Integer)param.get("endnum"))
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<UsrinputdatamngDto> searchList( Map param){
		return (ArrayList<UsrinputdatamngDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("Usrinputdatamng.serachList",param, (Integer)param.get("startnum") ,(Integer)param.get("endnum"));
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 데이터 재조회
	 * <p> 
	 * @param param
	 * @return (ArrayList<UsrinputdatamngDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("Usrinputdatamng.reserachList",param, (Integer)param.get("startnum") ,(Integer)param.get("endnum")
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<UsrinputdatamngDto> researchList( Map param){
		return (ArrayList<UsrinputdatamngDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("Usrinputdatamng.reserachList",param, (Integer)param.get("startnum") ,(Integer)param.get("endnum"));
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 데이터 저장 카운터
	 * <p> 
	 * @param usrinputdatamngDto
	 * @return result
	 */
	public int countUsrinputdatamngInfo(UsrinputdatamngDto usrinputdatamngDto) {
		int result = ((UsrinputdatamngDto)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("Usrinputdatamng.countUsrinputdatamngList", usrinputdatamngDto)).getCntYn();
		return result;
	}
		
	/**
	 * <p>
	 * 메소드 설명 : 데이터 저장(기존에 있을경우)
	 * <p> 
	 * @param usrinputdatamngDto
	 */
	public void updateUsrinputdatamng(UsrinputdatamngDto usrinputdatamngDto) {
		Iterator<UsrinputdatamngDto> iter = usrinputdatamngDto.getUsrinputdatamngList().iterator();
		while(iter.hasNext()){
			UsrinputdatamngDto QaltyDto = iter.next();
			QaltyDto.setDelYMS(DateUtil.getDateString());
			SqlMapper.getSqlClient("TESTRO_DB").update("Usrinputdatamng.updateUsrinputdatamng",QaltyDto);
		}
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 데이터 저장(신규일 있을경우)
	 * <p> 
	 * @param usrinputdatamngDto
	 */
	public void insertUsrinputdatamng(UsrinputdatamngDto usrinputdatamngDto) {
		Iterator<UsrinputdatamngDto> iter = usrinputdatamngDto.getUsrinputdatamngList().iterator();
		while(iter.hasNext()){
			UsrinputdatamngDto QaltyDto = iter.next();
			QaltyDto.setFldId(usrinputdatamngDto.getFldId());
			QaltyDto.setDelYMS(DateUtil.getDateString());
			SqlMapper.getSqlClient("TESTRO_DB").insert("Usrinputdatamng.insertUsrinputdatamng",QaltyDto);
		}
	}

	/**
	 * <p>
	 * 메소드 설명 : 데이터 행 삭제
	 * <p> 
	 * @param usrinputdatamngDto
	 */
	@SuppressWarnings("unchecked")
	public static void getDelete(UsrinputdatamngDto usrinputdatamngDto) {
		SqlMapper.getSqlClient("TESTRO_DB").update("Usrinputdatamng.getDelete", usrinputdatamngDto);
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 상세 데이터 조회
	 * <p> 
	 * @param param
	 * @return (ArrayList<UsrinputdatamngDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("Usrinputdatamng.detailSerachList",param, (Integer)param.get("startnum") ,(Integer)param.get("endnum"))
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<UsrinputdatamngDto> detailSearchList(Map param){
		return (ArrayList<UsrinputdatamngDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("Usrinputdatamng.detailSerachList",param, (Integer)param.get("startnum") ,(Integer)param.get("endnum"));
	}

	/**
	 * <p>
	 * 메소드 설명 : 상세 데이터 전부 삭제
	 * <p> 
	 * @param usrinputdatamngDto
	 */
	public void detailDeleteUsrinputdatamng(UsrinputdatamngDto usrinputdatamngDto) {
		SqlMapper.getSqlClient("TESTRO_DB").delete("Usrinputdatamng.detailDeleteUsrinputdatamng",usrinputdatamngDto);	
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 상세 데이터 저장
	 * <p> 
	 * @param usrinputdatamngDto
	 */
	public void detailInsertUsrinputdatamng(UsrinputdatamngDto usrinputdatamngDto) {
		Iterator<UsrinputdatamngDto> iter = usrinputdatamngDto.getUsrinputdatamngList().iterator();
		int i = 1;
		while(iter.hasNext()){
			UsrinputdatamngDto QaltyDto = iter.next();
			QaltyDto.setListNo(String.valueOf(i));
			QaltyDto.setDelYMS(DateUtil.getDateString());
			SqlMapper.getSqlClient("TESTRO_DB").insert("Usrinputdatamng.detailInsertUsrinputdatamng",QaltyDto);
			i++;
		}
	}

}
