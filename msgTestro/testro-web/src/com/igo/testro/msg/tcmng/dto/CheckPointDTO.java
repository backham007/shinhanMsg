package com.igo.testro.msg.tcmng.dto;

import com.igo.testro.dto.AbstractDTO;

@SuppressWarnings("serial")
public class CheckPointDTO extends AbstractDTO{
	private String tsdataID;			//테스트데이터ID
	private int chkNO;					//체크포인트 일련번호
	private String tsdataDesc;			//테스트데이터설명
	private String tsdataFldName;		//테스트데이터필드명
	private String tscsFldDesc;			//테스트데이터필드설명
	private String tscsUsrFldDesc;		//테스트데이터사용자필드설명
	private String chkPointExpcCtnt;	//체크포인트기대내용
	private String chkYN;				//체크포인트설정여부
	private String tscsFldDiv;			//테스트데이터필드구분
	private String tscsFldType;			//테스트데이터필드타입
	private String tscsFldAttrib;		//테스트데이터필드속성
	private String rptCntName;			//반복부전체회차필드명
	private String rptName;				//반복부명
	private String rptCnt;				//반복부회차
	private String writeID;				//작성자ID
	private String writeName;			//작성자명
	private String cretnYMS;			//생성일시
	private String lastModfiID;			//최종변경자ID
	private String lastModfiYMS;		//최종변경일시
	private String rmark;				//비고
	private String tscsFldSize;			//테스트데이터 필드사이즈
	
	public String getTscsFldSize() {
		return tscsFldSize;
	}
	public void setTscsFldSize(String tscsFldSize) {
		this.tscsFldSize = tscsFldSize;
	}
	private String tsdataFld;
	
	public String getTsdataID() {
		return tsdataID;
	}
	public void setTsdataID(String tsdataID) {
		this.tsdataID = tsdataID;
	}
	public int getChkNO() {
		return chkNO;
	}
	public void setChkNO(int chkNO) {
		this.chkNO = chkNO;
	}
	public String getTsdataDesc() {
		return tsdataDesc;
	}
	public void setTsdataDesc(String tsdataDesc) {
		this.tsdataDesc = tsdataDesc;
	}
	public String getTsdataFldName() {
		return tsdataFldName;
	}
	public void setTsdataFldName(String tsdataFldName) {
		this.tsdataFldName = tsdataFldName;
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
	public String getChkPointExpcCtnt() {
		return chkPointExpcCtnt;
	}
	public void setChkPointExpcCtnt(String chkPointExpcCtnt) {
		this.chkPointExpcCtnt = chkPointExpcCtnt;
	}
	public String getWriteID() {
		return writeID;
	}
	public void setWriteID(String writeID) {
		this.writeID = writeID;
	}
	public String getWriteName() {
		return writeName;
	}
	public void setWriteName(String writeName) {
		this.writeName = writeName;
	}
	public String getCretnYMS() {
		return cretnYMS;
	}
	public void setCretnYMS(String cretnYMS) {
		this.cretnYMS = cretnYMS;
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
	public String getChkYN() {
		return chkYN;
	}
	public void setChkYN(String chkYN) {
		this.chkYN = chkYN;
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
	public String getTsdataFld() {
		return tsdataFld;
	}
	public void setTsdataFld(String tsdataFld) {
		this.tsdataFld = tsdataFld;
	}

}
