package com.igo.testro.msg.tcmng.dto;

import java.util.List;

/**
 * <p>
 * 프로그램명:RptCaseDto.java<br/>
 * 설명 : 테스트케이스기본실적<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 28. : ksj : 내용
 * </ul> 
 * </p>
 */
public class RptCaseDto {
	//테스트케이스ID
	private String tsCaseID;
	//수행회차
	private int acmplNth;
	//테스트케이스명
	private String tsCaseName;
	//테스트케이스설명
	private String tsCaseDesc;
	//채널구분코드
	private String chnlDstcd;
	//스크립트ID
	private String scrptID;
	//거래코드
	private String tranCd;
	//거래코드명
	private String tranName;
	//매핑여부
	private String mapYN;
	//관리자레벨구분코드
	private String mgrLvelDstcd;
	//대외제공여부
	private String osidOferYn;
	//접속서버구분코드
	private String connSevrDstcd;
	//프로젝트번호
	private String projNo;
	//프로젝트명
	private String projName;
	//테스터사용자ID
	private String tstrID;
	//테스터명
	private String tstrName;
	//거래결과성공여부(성공 : Y, 실패 : N)
	private String rsultSucssYN;
	//결과메시지
	private String rsultMsg;
	//결과이미지파일여부
	private String rsultImgFileYN;
	//테스트시작일시
	private String testStartYMS;
	//테스트종료일시
	private String testEndYMS;
	//테스트단계명
	private String testStgeName;
	//작성자ID
	private String writeID;
	//작성자명
	private String writeName;
	//생성일시
	private String cretnYMS;
	//최종변경자ID
	private String lastModfiID;
	//최종변경일시
	private String lastModfiYMS;
	//비고
	private String rmark;
	//테스트케이스상세실적 List
	private List rptCaseDetailList;
	
	
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
	public String getTsCaseName() {
		return tsCaseName;
	}
	public void setTsCaseName(String tsCaseName) {
		this.tsCaseName = tsCaseName;
	}
	public String getTsCaseDesc() {
		return tsCaseDesc;
	}
	public void setTsCaseDesc(String tsCaseDesc) {
		this.tsCaseDesc = tsCaseDesc;
	}
	public String getChnlDstcd() {
		return chnlDstcd;
	}
	public void setChnlDstcd(String chnlDstcd) {
		this.chnlDstcd = chnlDstcd;
	}
	public String getScrptID() {
		return scrptID;
	}
	public void setScrptID(String scrptID) {
		this.scrptID = scrptID;
	}
	public String getTranCd() {
		return tranCd;
	}
	public void setTranCd(String tranCd) {
		this.tranCd = tranCd;
	}
	public String getTranName() {
		return tranName;
	}
	public void setTranName(String tranName) {
		this.tranName = tranName;
	}
	public String getMapYN() {
		return mapYN;
	}
	public void setMapYN(String mapYN) {
		this.mapYN = mapYN;
	}
	public String getMgrLvelDstcd() {
		return mgrLvelDstcd;
	}
	public void setMgrLvelDstcd(String mgrLvelDstcd) {
		this.mgrLvelDstcd = mgrLvelDstcd;
	}
	public String getOsidOferYn() {
		return osidOferYn;
	}
	public void setOsidOferYn(String osidOferYn) {
		this.osidOferYn = osidOferYn;
	}
	public String getConnSevrDstcd() {
		return connSevrDstcd;
	}
	public void setConnSevrDstcd(String connSevrDstcd) {
		this.connSevrDstcd = connSevrDstcd;
	}
	public String getProjNo() {
		return projNo;
	}
	public void setProjNo(String projNo) {
		this.projNo = projNo;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public String getTstrID() {
		return tstrID;
	}
	public void setTstrID(String tstrID) {
		this.tstrID = tstrID;
	}
	public String getTstrName() {
		return tstrName;
	}
	public void setTstrName(String tstrName) {
		this.tstrName = tstrName;
	}
	public String getRsultSucssYN() {
		return rsultSucssYN;
	}
	public void setRsultSucssYN(String rsultSucssYN) {
		this.rsultSucssYN = rsultSucssYN;
	}
	public String getRsultMsg() {
		return rsultMsg;
	}
	public void setRsultMsg(String rsultMsg) {
		this.rsultMsg = rsultMsg;
	}
	public String getRsultImgFileYN() {
		return rsultImgFileYN;
	}
	public void setRsultImgFileYN(String rsultImgFileYN) {
		this.rsultImgFileYN = rsultImgFileYN;
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
	public String getTestStgeName() {
		return testStgeName;
	}
	public void setTestStgeName(String testStgeName) {
		this.testStgeName = testStgeName;
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
	public List getRptCaseDetailList() {
		return rptCaseDetailList;
	}
	public void setRptCaseDetailList(List rptCaseDetailList) {
		this.rptCaseDetailList = rptCaseDetailList;
	}

}
