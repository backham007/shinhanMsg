package com.igo.testro.msg.exeSts.dto;

import com.igo.testro.dto.AbstractDTO;

public class ExeStsRsltDTO extends AbstractDTO{

	String seq;
	String tscaseId;
	String acmplNth;
	String tscaseName;
	String connsevrDstcd;
	int    tdCount;
	int    succTdData;
	int    failTdData;
	int    noneExeTdData;
	String testStartYMS;
	String writeName;
	String tstrName;
	String writeId;
	String rsultSucssYn;
	String tscaseDesc;
	String tssnrioDesc;
	
	public String getConnsevrDstcd() {
		return connsevrDstcd;
	}
	public void setConnsevrDstcd(String connsevrDstcd) {
		this.connsevrDstcd = connsevrDstcd;
	}
	public String getTssnrioDesc() {
		return tssnrioDesc;
	}
	public void setTssnrioDesc(String tssnrioDesc) {
		this.tssnrioDesc = tssnrioDesc;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getTscaseId() {
		return tscaseId;
	}
	public void setTscaseId(String tscaseId) {
		this.tscaseId = tscaseId;
	}
	public String getAcmplNth() {
		return acmplNth;
	}
	public void setAcmplNth(String acmplNth) {
		this.acmplNth = acmplNth;
	}
	public String getTscaseName() {
		return tscaseName;
	}
	public void setTscaseName(String tscaseName) {
		this.tscaseName = tscaseName;
	}
	public int getTdCount() {
		return tdCount;
	}
	public void setTdCount(int tdCount) {
		this.tdCount = tdCount;
	}
	public int getSuccTdData() {
		return succTdData;
	}
	public void setSuccTdData(int succTdData) {
		this.succTdData = succTdData;
	}
	public int getFailTdData() {
		return failTdData;
	}
	public void setFailTdData(int failTdData) {
		this.failTdData = failTdData;
	}
	public int getNoneExeTdData() {
		return noneExeTdData;
	}
	public void setNoneExeTdData(int noneExeTdData) {
		this.noneExeTdData = noneExeTdData;
	}
	public String getTestStartYMS() {
		return testStartYMS;
	}
	public void setTestStartYMS(String testStartYMS) {
		this.testStartYMS = testStartYMS;
	}
	public String getWriteName() {
		return writeName;
	}
	public void setWriteName(String writeName) {
		this.writeName = writeName;
	}
	public String getTstrName() {
		return tstrName;
	}
	public void setTstrName(String tstrName) {
		this.tstrName = tstrName;
	}
	public String getWriteId() {
		return writeId;
	}
	public void setWriteId(String writeId) {
		this.writeId = writeId;
	}
	public String getRsultSucssYn() {
		return rsultSucssYn;
	}
	public void setRsultSucssYn(String rsultSucssYn) {
		this.rsultSucssYn = rsultSucssYn;
	}
	public String getTscaseDesc() {
		return tscaseDesc;
	}
	public void setTscaseDesc(String tscaseDesc) {
		this.tscaseDesc = tscaseDesc;
	}
	
	
}
