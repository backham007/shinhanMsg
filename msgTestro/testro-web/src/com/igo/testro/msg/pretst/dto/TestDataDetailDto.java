package com.igo.testro.msg.pretst.dto;

import com.igo.testro.dto.AbstractDTO;

/**
 * 
 * <p>
 * 프로그램명:TestDataDetailDto.java<br/>
 * 설명 : 테스트데이터상세<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 18. : KoJaeHyeong : 최초작성
 * </ul> 
 * </p>
 */
public class TestDataDetailDto extends AbstractDTO{
	
	//테스트데이터ID
	private String tsdataID;
	//테스트데이터일련번호
	private String tsdataNO;
	//테스트데이터필드명
	private String tsdataFldName;
	//테스트데이터필드데이터
	private String tsdataFldData;
	//테스트데이터필드구분
	private String tscsFldDiv;
	//테스트데이터필드타입
	private String tscsFldType;
	//테스트데이터필드속성
	private String tscsFldAttrib;
	//테스트데이터필드크기내용
	private String tscsFldSizeCnt;
	//테스트데이터필드설명
	private String tscsFldDesc;
	//테스트데이터사용자필드설명
	private String tscsUsrFldDesc;
	//반복부전체회차필드명
	private String rptCntName;
	//반복부명
	private String rptName;
	//반복부회차
	private String rptCnt;
	//최종변경자ID
	private String lastModfiID;
	//최종변경일시
	private String lastModfiYMS;
	//비고
	private String rmark;
	
	public String getTsdataID() {
		return tsdataID;
	}
	public void setTsdataID(String tsdataID) {
		this.tsdataID = tsdataID;
	}
	public String getTsdataNO() {
		return tsdataNO;
	}
	public void setTsdataNO(String tsdataNO) {
		this.tsdataNO = tsdataNO;
	}
	public String getTsdataFldName() {
		return tsdataFldName;
	}
	public void setTsdataFldName(String tsdataFldName) {
		this.tsdataFldName = tsdataFldName;
	}
	public String getTsdataFldData() {
		return tsdataFldData;
	}
	public void setTsdataFldData(String tsdataFldData) {
		this.tsdataFldData = tsdataFldData;
	}
	public String getTscsFldDiv() {
		return tscsFldDiv;
	}
	public void setTscsFldDiv(String tscsFldDiv) {
		this.tscsFldDiv = tscsFldDiv;
	}
	public String getTscsFldType() {
		return tscsFldType;
	}
	public void setTscsFldType(String tscsFldType) {
		this.tscsFldType = tscsFldType;
	}
	public String getTscsFldAttrib() {
		return tscsFldAttrib;
	}
	public void setTscsFldAttrib(String tscsFldAttrib) {
		this.tscsFldAttrib = tscsFldAttrib;
	}
	public String getTscsFldSizeCnt() {
		return tscsFldSizeCnt;
	}
	public void setTscsFldSizeCnt(String tscsFldSizeCnt) {
		this.tscsFldSizeCnt = tscsFldSizeCnt;
	}
	public String getTscsFldDesc() {
		return tscsFldDesc;
	}
	public void setTscsFldDesc(String tscsFldDesc) {
		this.tscsFldDesc = tscsFldDesc;
	}
	public String getTscsUsrFldDesc() {
		return tscsUsrFldDesc;
	}
	public void setTscsUsrFldDesc(String tscsUsrFldDesc) {
		this.tscsUsrFldDesc = tscsUsrFldDesc;
	}
	public String getRptCntName() {
		return rptCntName;
	}
	public void setRptCntName(String rptCntName) {
		this.rptCntName = rptCntName;
	}
	public String getRptName() {
		return rptName;
	}
	public void setRptName(String rptName) {
		this.rptName = rptName;
	}
	public String getRptCnt() {
		return rptCnt;
	}
	public void setRptCnt(String rptCnt) {
		this.rptCnt = rptCnt;
	}
	public String getLastModfiID() {
		return lastModfiID;
	}
	public void setLastModfiID(String lastModfiID) {
		this.lastModfiID = lastModfiID;
	}
	public String getLastModfiYMS() {
		return lastModfiYMS;
	}
	public void setLastModfiYMS(String lastModfiYMS) {
		this.lastModfiYMS = lastModfiYMS;
	}
	public String getRmark() {
		return rmark;
	}
	public void setRmark(String rmark) {
		this.rmark = rmark;
	}
	
	
	
}
