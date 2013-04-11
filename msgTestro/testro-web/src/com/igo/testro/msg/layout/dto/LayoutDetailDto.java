package com.igo.testro.msg.layout.dto;

import com.igo.testro.dto.AbstractDTO;

/**
 * 
 * <p>
 * 프로그램명:LayoutDetailDto.java<br/>
 * 설명 : 레이아웃상세<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 13. : KoJaeHyeong : 최초작성
 * </ul> 
 * </p>
 */
public class LayoutDetailDto extends AbstractDTO{
	
	//채널구분코드(전문 : 01: 단말, 02: 자동화기기, 03: 인터넷뱅킹, 04: 콜센터)
	private String chnlDstcd;
	//거래코드
	private String tranCd;
	//입출력구분('I'/'O')
	private String fldIO;
	//거래코드일련번호
	private String tranNO;
	//필드명
	private String fldName;
	//필드데이터
	private String fldData;
	//필드구성(01:헤더, 02:개별)
	private String fldDiv;
	//필드타입(text, num, hex)
	private String fldType;
	//필드속성(01:일반, 02:체크포인트, 03:반복)
	private String fldAttrib;
	//필드속성(전문관리에서만 사용 - 03:반복 제외)
	private String fldAttrib2;
	//필수필드여부
	private String reqYn;
	//편집가능여부
	private String editYn;
	//필드사이즈
	private String tscsFldSize;
	//필드설명(한글명)
	private String tscsFldDesc;
	//정렬타입(좌/우측 정렬('L,'R'))
	private String ranType;
	//빈값데이터
	private String fillData;
	//반복부명
	private String rptName;
	//최종변경자ID
	private String lastModfiId;
	//최종변경일시
	private String lastModfiYMS;
	//비고
	private String rmark;
	
	
	public String getChnlDstcd() {
		return chnlDstcd;
	}
	public void setChnlDstcd(String chnlDstcd) {
		this.chnlDstcd = chnlDstcd;
	}
	public String getTranCd() {
		return tranCd;
	}
	public void setTranCd(String tranCd) {
		this.tranCd = tranCd;
	}
	public String getFldIO() {
		return fldIO;
	}
	public void setFldIO(String fldIO) {
		this.fldIO = fldIO;
	}
	public String getTranNO() {
		return tranNO;
	}
	public void setTranNO(String tranNO) {
		this.tranNO = tranNO;
	}
	public String getFldName() {
		return fldName;
	}
	public void setFldName(String fldName) {
		this.fldName = fldName;
	}
	public String getFldData() {
		return fldData;
	}
	public void setFldData(String fldData) {
		this.fldData = fldData;
	}
	public String getFldDiv() {
		return fldDiv;
	}
	public void setFldDiv(String fldDiv) {
		this.fldDiv = fldDiv;
	}
	public String getFldType() {
		return fldType;
	}
	public void setFldType(String fldType) {
		this.fldType = fldType;
	}
	public String getFldAttrib() {
		return fldAttrib;
	}
	public void setFldAttrib(String fldAttrib) {
		this.fldAttrib = fldAttrib;
	}
	public String getTscsFldSize() {
		return tscsFldSize;
	}
	public void setTscsFldSize(String tscsFldSize) {
		this.tscsFldSize = tscsFldSize;
	}
	public String getTscsFldDesc() {
		return tscsFldDesc;
	}
	public void setTscsFldDesc(String tscsFldDesc) {
		this.tscsFldDesc = tscsFldDesc;
	}
	public String getRanType() {
		return ranType;
	}
	public void setRanType(String ranType) {
		this.ranType = ranType;
	}
	public String getFillData() {
		return fillData;
	}
	public void setFillData(String fillData) {
		this.fillData = fillData;
	}
	public String getRptName() {
		return rptName;
	}
	public void setRptName(String rptName) {
		this.rptName = rptName;
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
	public String getLastModfiId() {
		return lastModfiId;
	}
	public void setLastModfiId(String lastModfiId) {
		this.lastModfiId = lastModfiId;
	}
	public String getFldAttrib2() {
		return fldAttrib2;
	}
	public void setFldAttrib2(String fldAttrib2) {
		this.fldAttrib2 = fldAttrib2;
	}
	public String getReqYn() {
		return reqYn;
	}
	public void setReqYn(String reqYn) {
		this.reqYn = reqYn;
	}
	public String getEditYn() {
		return editYn;
	}
	public void setEditYn(String editYn) {
		this.editYn = editYn;
	}	
	
}
