package com.igo.testro.msg.tcmng.dto;

/**
 * <p>
 * 프로그램명:RptCaseDetailDto.java<br/>
 * 설명 : 테스트케이스상세실적<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 28. : ksj : 내용
 * </ul> 
 * </p>
 */
public class RptCaseDetailDto {
	//테스트케이스ID
	private String tsCaseID;
	//수행회차
	private int acmplNth;
	//테스트데이터일련번호
	private String tsCaseNo;
	//테스트데이터ID
	private String tsDataID;
	//테스트데이터명
	private String tsDataName;
	//테스트데이터수행회차
	private long tsDataAcmpLnth;
	//성공여부(Y:성공, N:실패)
	private String rsultSucssYN;
	//최종변경자ID
	private String lastModfiID;
	//최종변경일시
	private String lastModfiYMS;
	//비고
	private String rmark;
	
	
	public String getTsCaseID() {
		return tsCaseID;
	}
	public void setTsCaseID(String tsCaseID) {
		this.tsCaseID = tsCaseID;
	}
	public int getAcmplNth() {
		return acmplNth;
	}
	public void setAcmplNth(int acmplNth) {
		this.acmplNth = acmplNth;
	}
	public String getTsCaseNo() {
		return tsCaseNo;
	}
	public void setTsCaseNo(String tsCaseNo) {
		this.tsCaseNo = tsCaseNo;
	}
	public String getTsDataID() {
		return tsDataID;
	}
	public void setTsDataID(String tsDataID) {
		this.tsDataID = tsDataID;
	}
	public String getTsDataName() {
		return tsDataName;
	}
	public void setTsDataName(String tsDataName) {
		this.tsDataName = tsDataName;
	}
	public long getTsDataAcmpLnth() {
		return tsDataAcmpLnth;
	}
	public void setTsDataAcmpLnth(long tsDataAcmpLnth) {
		this.tsDataAcmpLnth = tsDataAcmpLnth;
	}
	public String getRsultSucssYN() {
		return rsultSucssYN;
	}
	public void setRsultSucssYN(String rsultSucssYN) {
		this.rsultSucssYN = rsultSucssYN;
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
