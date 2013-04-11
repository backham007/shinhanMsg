package com.igo.testro.msg.tcmng.dto;


/**
 * <p>
 * 프로그램명:TcDetailDto.java<br/>
 * 설명 : 테스트케이스 상세<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 18. : ksj :테스트케이스 상세 DTO
 * </ul> 
 * </p>
 */
public class TcDetailDto {
	//테스트케이스ID
	private String tsCaseID;
	//테스트케이스일련번호
	private String tsCaseNO;
	//테스트데이터ID
	private String tsdataID;
	//테스트데이터명
	private String tsdataName;
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
	public String getTsCaseNO() {
		return tsCaseNO;
	}
	public void setTsCaseNO(String tsCaseNO) {
		this.tsCaseNO = tsCaseNO;
	}
	public String getTsdataID() {
		return tsdataID;
	}
	public void setTsdataID(String tsdataID) {
		this.tsdataID = tsdataID;
	}
	public String getTsdataName() {
		return tsdataName;
	}
	public void setTsdataName(String tsdataName) {
		this.tsdataName = tsdataName;
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
