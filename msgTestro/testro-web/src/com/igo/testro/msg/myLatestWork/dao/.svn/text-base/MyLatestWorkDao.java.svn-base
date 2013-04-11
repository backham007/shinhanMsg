package com.igo.testro.msg.myLatestWork.dao;

import java.util.ArrayList;

import com.igo.testro.das.SqlMapper;
import com.igo.testro.msg.myLatestWork.dto.myLatestWorkDto;

/**
 * <p>
 * 프로그램명:MyLatestWorkDao.java<br/>
 * 설명 : 나의 최근 작업 관리 Dao<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 2. : parkminho : 내용
 * </ul> 
 * </p>
 */
public class MyLatestWorkDao {

	/**
	 * <p>
	 * 메소드 설명 : 나의 최근 작업 조회[테스트케이스]
	 * <p>
	 * @param paramDto
	 * @return
	 */
	public ArrayList<myLatestWorkDto> getListTestCase(myLatestWorkDto paramDto) {
		
		int endNum = paramDto.getEndnum();
		if( endNum > 500 ) endNum = 500; // 최근 500건만 조회
		return (ArrayList<myLatestWorkDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("myLatestWork.getListTestCase",paramDto,paramDto.getStartnum(),endNum);
	}
	/**
	 * <p>
	 * 메소드 설명 : 나의 최근 작업 조회[테스트시나리오]
	 * <p>
	 * @param paramDto
	 * @return
	 */
	public ArrayList<myLatestWorkDto> getListTestsinario(myLatestWorkDto paramDto) {
		
		int endNum = paramDto.getEndnum();
		if( endNum > 500 ) endNum = 500; // 최근 500건만 조회
		return (ArrayList<myLatestWorkDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("myLatestWork.getListTestsinario",paramDto, paramDto.getStartnum(),endNum);
	}
	/**
	 * <p>
	 * 메소드 설명 : 나의 최근 작업 조회[결과보고서]
	 * <p>
	 * @param paramDto
	 * @return
	 */
	public ArrayList<myLatestWorkDto> getListReport(myLatestWorkDto paramDto) {
		
		int endNum = paramDto.getEndnum();
		if( endNum > 500 ) endNum = 500; // 최근 500건만 조회
		return (ArrayList<myLatestWorkDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("myLatestWork.getListReport",paramDto,paramDto.getStartnum(),endNum);
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 나의 최근 작업 조회[결과보고서] 갯수
	 * <p>
	 * @param paramDto
	 * @return
	 */
	public int getCountListReport(myLatestWorkDto paramDto){
		return (Integer)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("myLatestWork.getCountListReport",paramDto);
	}
	/**
	 * <p>
	 * 메소드 설명 : 나의 최근 작업 조회[테스트케이스] 갯수
	 * <p>
	 * @param paramDto
	 * @return
	 */
	public int getCountListTestCase(myLatestWorkDto paramDto){
		return (Integer)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("myLatestWork.getCountListTestCase",paramDto);
	}
	/**
	 * <p>
	 * 메소드 설명 : 나의 최근 작업 조회[시나리오] 갯수
	 * <p>
	 * @param paramDto
	 * @return
	 */
	public int getCountListTestsinario(myLatestWorkDto paramDto){
		return (Integer)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("myLatestWork.getCountListTestsinario",paramDto);
	}
	
	/**
	 * <p>
	 * 메소드 설명 : 나의 최근 작업 삭제[테스트케이스]
	 * <p>
	 * @param paramDto
	 * @return
	 */
	public int deleteTestcase(myLatestWorkDto paramDto){
			   SqlMapper.getSqlClient("TESTRO_DB").delete("myLatestWork.deleteTestcase02",paramDto);
		return SqlMapper.getSqlClient("TESTRO_DB").delete("myLatestWork.deleteTestcase01",paramDto);
	}
	/**
	 * <p>
	 * 메소드 설명 : 나의 최근 작업 삭제[테스트시나리오]
	 * <p>
	 * @param paramDto
	 * @return
	 */
	public int deleteTestsnro(myLatestWorkDto paramDto){
		
			   SqlMapper.getSqlClient("TESTRO_DB").delete("myLatestWork.deleteTestsnro02",paramDto);
		return SqlMapper.getSqlClient("TESTRO_DB").delete("myLatestWork.deleteTestsnro01",paramDto);
	}
	/**
	 * <p>
	 * 메소드 설명 : 나의 최근 작업 삭제[결과 보고서]
	 * <p>
	 * @param paramDto
	 * @return
	 */
	public int deleteReport(myLatestWorkDto paramDto) {
		if(paramDto.getReportGubun().equals("01")){
			
			       SqlMapper.getSqlClient("TESTRO_DB").delete("myLatestWork.deleteTestcaseReport02",paramDto);
			return SqlMapper.getSqlClient("TESTRO_DB").delete("myLatestWork.deleteTestcaseReport01",paramDto);
		}else if(paramDto.getReportGubun().equals("02")){
			
				   SqlMapper.getSqlClient("TESTRO_DB").delete("myLatestWork.deleteTestsnroReport02",paramDto);
			return SqlMapper.getSqlClient("TESTRO_DB").delete("myLatestWork.deleteTestsnroReport01",paramDto);
		}
		return 0;
	}

}
