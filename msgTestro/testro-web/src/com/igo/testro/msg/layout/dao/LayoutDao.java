package com.igo.testro.msg.layout.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.igo.testro.cmn.utils.DateUtil;
import com.igo.testro.das.SqlMapper;
import com.igo.testro.msg.layout.dto.LayoutDetailDto;
import com.igo.testro.msg.layout.dto.LayoutDto;

/**
 * 
 * <p>
 * 프로그램명:LayoutDao.java<br/>
 * 설명 : 전문관리 Dao<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 13. : KoJaeHyeong : 최초작성
 * </ul> 
 * </p>
 */
public class LayoutDao {

	/**
	 * 
	 * <p>
	 * 전문레이아웃 기본조회
	 * <p>
	 * @param chnlDstcd 채널구분코드
	 * @param tranCd 거래코드
	 * @return LayoutDto 전문레이아웃DTO
	 */
	public LayoutDto getLayoutBasic(String chnlDstcd, String tranCd) {
		
		Map<String,String> param = new HashMap<String,String>();
		param.put("chnlDstcd", chnlDstcd);
		param.put("tranCd", tranCd);
		
		List<LayoutDto> layoutDtoList = (ArrayList)SqlMapper.getSqlClient("TESTRO_DB").queryForList("layout.getLayoutBasic", param);
		if(layoutDtoList.size() > 0){
			return layoutDtoList.get(0);
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * <p>
	 * 전문레이아웃 상세조회
	 * <p>
	 * @param chnlDstcd 채널구분코드
	 * @param tranCd 거래코드
	 * @param fldIO 입출력 구분 ('I' / 'O')
	 * @return List<LayoutDetailDto> 전문레이아웃상세DTO List
	 */
	public List<LayoutDetailDto> getListLayoutDetail(String chnlDstcd, String tranCd, String fldIO) {
		
		Map<String,String> param = new HashMap<String,String>();
		param.put("chnlDstcd", chnlDstcd);
		param.put("tranCd", tranCd);
		param.put("fldIO", fldIO);
		
		return (List<LayoutDetailDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("layout.getListLayoutDetail", param);
	}
	
	/**
	 * 
	 * <p>
	 * 전문레이아웃 상세조회(반복부)
	 * <p>
	 * @param chnlDstcd 채널구분코드
	 * @param tranCd 거래코드
	 * @param fldIO 입출력 구분 ('I' / 'O')
	 * @param fldName 필드명(반복회차의 필드명)
	 * @return List<LayoutDetailDto> 전문레이아웃상세DTO List
	 */
	public List<LayoutDetailDto> getListLayoutDetail(String chnlDstcd, String tranCd, String fldIO, String fldName) {
		
		Map<String,String> param = new HashMap<String,String>();
		param.put("chnlDstcd", chnlDstcd);
		param.put("tranCd", tranCd);
		param.put("fldIO", fldIO);
		param.put("fldName", fldName);
		
		return (List<LayoutDetailDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("layout.getListLayoutDetail", param);
	}
	
	/**
	 * 
	 * <p>
	 * 전문레이아웃 저장
	 * <p>
	 * @param layoutDto 전문레이아웃DTO
	 */
	public void registerLayout(LayoutDto layoutDto){
		//레이아웃기본 저장
		SqlMapper.getSqlClient("TESTRO_DB").insert("layout.registerLayoutBasic", layoutDto);
		
		Iterator<LayoutDetailDto> iter = layoutDto.getInviList().iterator();
		
		int inputCnt = 1;	//필드순번
		
		while(iter.hasNext()){
			
			LayoutDetailDto layoutDetailDto = iter.next();
			layoutDetailDto.setChnlDstcd(layoutDto.getChnlDstcd());	//채널구분코드
			layoutDetailDto.setTranCd(layoutDto.getTranCd());	//거래코드
			layoutDetailDto.setFldDiv(layoutDto.getFldDiv());	//필드구분
			layoutDetailDto.setTranNO(String.valueOf(inputCnt++));	//필드순번
			layoutDetailDto.setLastModfiId(layoutDto.getLastModfiId());	//변경자ID
			layoutDetailDto.setLastModfiYMS(DateUtil.getDateString());	//변경일시
			
			//레이아웃상세 저장
			SqlMapper.getSqlClient("TESTRO_DB").insert("layout.registerLayoutDetail", layoutDetailDto);
		}
	}
		
	/**
	 * 
	 * <p>
	 * 전문레이아웃 삭제
	 * <p>
	 * @param chnlDstcd 채널구분코드
	 * @param tranCd 거래코드
	 * @return int 삭제 거래코드 건수
	 */
	public int deleteLayout(String chnlDstcd, String tranCd) {
		Map<String,String> param = new HashMap<String,String>();
		param.put("chnlDstcd", chnlDstcd);	//채널구분코드
		param.put("tranCd", tranCd);	//거래코드
		
		int delCount = 0;
		
		SqlMapper.getSqlClient("TESTRO_DB").delete("layout.deleteLayoutDetail", param);	//레이아웃상세 삭제
		delCount = SqlMapper.getSqlClient("TESTRO_DB").delete("layout.deleteLayoutBasic", param);	//레이아웃기본 삭제
		
		return delCount;
	}
	
	/**
	 * 
	 * <p>
	 * 레이아웃변경로그 입력
	 * <p>
	 * @param layoutDto
	 */
	public void registerLayoutLog(LayoutDto layoutDto, String content){
		
		Map param = new HashMap();
		param.put("chnlDstcd", layoutDto.getChnlDstcd());
		param.put("tranCd", layoutDto.getTranCd());
		param.put("tranName", layoutDto.getTranName());
		param.put("content", content);
		param.put("writeId", layoutDto.getWriteId());
		param.put("writeName", layoutDto.getWriteName());
		param.put("delYMS", layoutDto.getLastModfiYMS());
		
		SqlMapper.getSqlClient("TESTRO_DB").insert("layout.registerLayoutLog", param);
	}

	/**
	 * <p>
	 * 그리드 총건수 
	 * <p>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public int getCnt(Map param){
		return (Integer) SqlMapper.getSqlClient("TESTRO_DB").queryForObject("layout.getCnt", param);
	}
	
	/**
	 * <p>
	 * 레이아웃 목록조회(그리드)
	 * <p>
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<LayoutDto> getListLayout( Map param){
		
		return (ArrayList<LayoutDto>)SqlMapper.getSqlClient("TESTRO_DB").queryForList("layout.getListLayout",param, (Integer)param.get("startnum") ,(Integer)param.get("endnum"));
	}
}

