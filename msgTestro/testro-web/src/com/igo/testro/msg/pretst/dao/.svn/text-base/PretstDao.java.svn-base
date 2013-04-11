package com.igo.testro.msg.pretst.dao;

import java.util.HashMap;
import java.util.Map;



import com.igo.testro.das.SqlMapper;
import com.igo.testro.msg.pretst.dto.TesDataDetailDto;
import com.igo.testro.msg.pretst.dto.TesDataDto;

/**
 * <p>
 * 프로그램명:MemberDao.java<br/>
 * 설명 : 회원목록 화면에 관련된 Dao 클래스<br/>
 * 변경이력<br/>
 * <ul>
 * </ul> 
 * </p>
 */
public class PretstDao {


	
	/**
	 * 거래코드가 같을경우 삭제 
	 */
	public void registerTcMngDelete(String tranCd,String tsdataIdNum){
		Map<String,String> param = new HashMap<String,String>();
		param.put("tranCd", tranCd);	//채널구분코드
		param.put("tsdataIdNum", tsdataIdNum);	
		//테스트 데이터 기본 저장
		SqlMapper.getSqlClient("TESTRO_DB").delete("pretst.deleteTesData",param);
		SqlMapper.getSqlClient("TESTRO_DB").delete("pretst.deleteTesDataDetail",param);
	}
	
	
	//테스트 데이터 기본 저장 03TABLE
	public void registerTcMng(TesDataDto tesDataDto){
		SqlMapper.getSqlClient("TESTRO_DB").insert("pretst.registerTesData", tesDataDto);
	}
	
	//테스트 데이터 상세 저장 04TABLE
	public void registerTcMngDetail(TesDataDetailDto tesDto){
		SqlMapper.getSqlClient("TESTRO_DB").insert("pretst.registerTesDataDetail", tesDto);
	}
	
	
	
	/**
	 * tesdata03 테이블에서 tsdataId 값가져오기
	 */
	@SuppressWarnings("unchecked")
	public String getTsdataID(String tranCd){
		String tsDataId = (String)SqlMapper.getSqlClient("TESTRO_DB").queryForObject("pretst.getTesDataIdNum", tranCd.trim());
		return tsDataId;
	}

		

}
