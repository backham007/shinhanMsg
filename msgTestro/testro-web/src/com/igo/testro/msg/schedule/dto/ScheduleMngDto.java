package com.igo.testro.msg.schedule.dto;

import com.igo.testro.cmn.dto.GridBaseDto;

/**
 * 
 * <p>
 * 프로그램명:ScheduleMngDto.java<br/>
 * 설명 : 테스트예약 실행관리 DTO<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 23. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class ScheduleMngDto extends GridBaseDto{

	private static final long serialVersionUID = 1L;
	
	// 테스트데이터ID
	private String tsDataId;
	
	// 예약실행순번
	private long jobSno;
	
	// 테스트단위구분코드
	private String testUnitCd;

	// 작업예약일시
	private String jobResrvYms;

	// 실행일자 시작 검색일자
	private String startJobResrvYms;
	
	// 실행일자 마지막 검색조건
	private String endJobResrvYms;
	
	// 예약작업내용
	private String jobResrvCnt;

	// 테스트명
	private String testName;

	// 테스트설명
	private String testDesc;

	// 테스트설명
	private String connSevrDstCd;
	
	// 생성일시
	private String cretnYms;
	
	// 작성자ID
	private String writeId;

	// 작성자명
	private String writeName;
	
	// 작업실행일시
	private String jobExeYms;

	// 수행회차
	private long acmplnTh;

	// 예약작업성공여부
	private String jobSucssYn;

	// 예약작업실행상태구분코드
	private String jobExeStusCd;

	// 최종변경사용자ID
	private String lastModfiId;

	// 최종변경일시
	private String lastModfiYms;

	// 비고
	private String rmark;
	
	public String getTsDataId() {
		return tsDataId;
	}

	public void setTsDataId(String tsDataId) {
		this.tsDataId = tsDataId;
	}

	public long getJobSno() {
		return jobSno;
	}

	public void setJobSno(long jobSno) {
		this.jobSno = jobSno;
	}

	public String getTestUnitCd() {
		return testUnitCd;
	}

	public void setTestUnitCd(String testUnitCd) {
		this.testUnitCd = testUnitCd;
	}

	public String getJobResrvYms() {
		return jobResrvYms;
	}

	public void setJobResrvYms(String jobResrvYms) {
		this.jobResrvYms = jobResrvYms;
	}

	public String getJobResrvCnt() {
		return jobResrvCnt;
	}

	public void setJobResrvCnt(String jobResrvCnt) {
		this.jobResrvCnt = jobResrvCnt;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestDesc() {
		return testDesc;
	}

	public void setTestDesc(String testDesc) {
		this.testDesc = testDesc;
	}

	public String getCretnYms() {
		return cretnYms;
	}

	public void setCretnYms(String cretnYms) {
		this.cretnYms = cretnYms;
	}

	public String getWriteId() {
		return writeId;
	}

	public void setWriteId(String writeId) {
		this.writeId = writeId;
	}

	public String getWriteName() {
		return writeName;
	}

	public void setWriteName(String writeName) {
		this.writeName = writeName;
	}

	public String getJobExeYms() {
		return jobExeYms;
	}

	public void setJobExeYms(String jobExeYms) {
		this.jobExeYms = jobExeYms;
	}

	public long getAcmplnTh() {
		return acmplnTh;
	}

	public void setAcmplnTh(long acmplnTh) {
		this.acmplnTh = acmplnTh;
	}

	public String getJobSucssYn() {
		return jobSucssYn;
	}

	public void setJobSucssYn(String jobSucssYn) {
		this.jobSucssYn = jobSucssYn;
	}

	public String getJobExeStusCd() {
		return jobExeStusCd;
	}

	public void setJobExeStusCd(String jobExeStusCd) {
		this.jobExeStusCd = jobExeStusCd;
	}

	public String getLastModfiId() {
		return lastModfiId;
	}

	public void setLastModfiId(String lastModfiId) {
		this.lastModfiId = lastModfiId;
	}

	public String getLastModfiYms() {
		return lastModfiYms;
	}

	public void setLastModfiYms(String lastModfiYms) {
		this.lastModfiYms = lastModfiYms;
	}

	public String getRmark() {
		return rmark;
	}

	public void setRmark(String rmark) {
		this.rmark = rmark;
	}

	public String getStartJobResrvYms() {
		return startJobResrvYms;
	}

	public void setStartJobResrvYms(String startJobResrvYms) {
		this.startJobResrvYms = startJobResrvYms;
	}

	public String getEndJobResrvYms() {
		return endJobResrvYms;
	}

	public void setEndJobResrvYms(String endJobResrvYms) {
		this.endJobResrvYms = endJobResrvYms;
	}

	public String getConnSevrDstCd() {
		return connSevrDstCd;
	}

	public void setConnSevrDstCd(String connSevrDstCd) {
		this.connSevrDstCd = connSevrDstCd;
	}

}
