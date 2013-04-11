package com.igo.testro.msg.tcmng.dto;


/**
 * <p>
 * 프로그램명:TesInfoDto.java<br/>
 * 설명 : 프로젝트정보<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 18. : ksj : 프로젝트 정보 DTO
 * </ul> 
 * </p>
 */
public class TesInfoDto {
	
	//품질관리프로젝트번호
	private String projNo;
	//테스트단계명
	private String testStgeName;
	//품질관리프로젝트명
	private String projName;
	//테스트시작일시
	private String testStartYMS;
	//테스트종료일시
	private String testEndYMS;
	//최종변경직원번호
	private String lastModfiEmpid;
	//최종변경일시
	private String lastModfiYMS;
	//비고
	private String rmark;
	
	
	public String getProjNo() {
		return projNo;
	}
	public void setProjNo(String projNo) {
		this.projNo = projNo;
	}
	public String getTestStgeName() {
		return testStgeName;
	}
	public void setTestStgeName(String testStgeName) {
		this.testStgeName = testStgeName;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public String getTestStartYMS() {
		return testStartYMS;
	}
	public void setTestStartYMS(String testStartYMS) {
		this.testStartYMS = testStartYMS;
	}
	public String getTestEndYMS() {
		return testEndYMS;
	}
	public void setTestEndYMS(String testEndYMS) {
		this.testEndYMS = testEndYMS;
	}
	public String getLastModfiEmpid() {
		return lastModfiEmpid;
	}
	public void setLastModfiEmpid(String lastModfiEmpid) {
		this.lastModfiEmpid = lastModfiEmpid;
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
