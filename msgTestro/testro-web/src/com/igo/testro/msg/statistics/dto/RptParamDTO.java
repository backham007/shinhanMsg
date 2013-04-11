package com.igo.testro.msg.statistics.dto;

import com.igo.testro.cmn.dto.GridBaseDto;
import com.igo.testro.dto.AbstractDTO;

public class RptParamDTO  extends GridBaseDto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String sidx;        	// ordey by 필드명
	private String sord;        	// asc or desc
	private String searchGubun; 	// 조회 구분(01: 테스트케이스 , 02: 테스트시나리오)
	private String tranCd;      	// 거래코드
	private String tranName;    	// 거래코드 명
	private String tstrName;    	// 테스트 명
	private String tstrId;      	// 테스트 ID
	private String deptNo;      	// 부서번호
	private String deptName;      	// 부서명
	private String projNo;      	// 프로젝트 번호
	private String testStgeName;    // 테스트 스테이지 명
	private String connSevrDstcd;   // 실행서버
	private String testStartYMS;	// 테스트 시작일
	private String testEndYMS;	    // 테스트 종료일
	private String mgrLvelDstcd;	// 관리구분코드
	private String defCd;           // 결함 진행 구분
	
	
	public String getTranName() {
		return tranName;
	}
	public void setTranName(String tranName) {
		this.tranName = tranName;
	}
	public String getDefCd() {
		return defCd;
	}
	public void setDefCd(String defCd) {
		this.defCd = defCd;
	}
	public String getMgrLvelDstcd() {
		return mgrLvelDstcd;
	}
	public void setMgrLvelDstcd(String mgrLvelDstcd) {
		this.mgrLvelDstcd = mgrLvelDstcd;
	}
	public String getSidx() {
		return sidx;
	}
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
	public String getSord() {
		return sord;
	}
	public void setSord(String sord) {
		this.sord = sord;
	}
	public String getSearchGubun() {
		return searchGubun;
	}
	public void setSearchGubun(String searchGubun) {
		this.searchGubun = searchGubun;
	}
	public String getTranCd() {
		return tranCd;
	}
	public void setTranCd(String tranCd) {
		this.tranCd = tranCd;
	}
	public String getTstrName() {
		return tstrName;
	}
	public void setTstrName(String tstrName) {
		this.tstrName = tstrName;
	}
	public String getTstrId() {
		return tstrId;
	}
	public void setTstrId(String tstrId) {
		this.tstrId = tstrId;
	}
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
	public String getConnSevrDstcd() {
		return connSevrDstcd;
	}
	public void setConnSevrDstcd(String connSevrDstcd) {
		this.connSevrDstcd = connSevrDstcd;
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
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
	
	

}
