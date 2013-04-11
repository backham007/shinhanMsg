package com.igo.testro.msg.cmn.dto;

import com.igo.testro.dto.AbstractDTO;

/**
 * 
 * <p>
 * 프로그램명:ProjPopDto.java<br/>
 * 설명 : 프로젝트조회 DTO<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 21. : KoJaeHyeong : 최초작성
 * </ul> 
 * </p>
 */
public class ProjPopDto extends AbstractDTO{
	
	private String projNo;	//프로젝트번호
	private String testStgeName;	//테스트단계명
	private String projName;	//프로젝트번호
	private String testStartYMS;	//테스트시작일시
	private String testEndYMS;	//테스트종료일시
	private String lastModfiId;	//최종변경직원번호
	private String lastModfiYMS;	//최종변경일시
	private String rmark;	//비고
	
	
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
	public String getLastModfiId() {
		return lastModfiId;
	}
	public void setLastModfiId(String lastModfiId) {
		this.lastModfiId = lastModfiId;
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
