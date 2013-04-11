package com.igo.testro.msg.cmn.execute.dto;

import java.util.List;

import com.igo.testro.msg.pretst.dto.TestDataDto;

/**
 * <p>
 * 프로그램명:RptTestDataBasicDTO.java<br/>
 * 설명 : 테스트데이터기본 실적 DTO<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 7. : 김기태 : 최초작성
 * </ul> 
 * </p>
 */
@SuppressWarnings("serial")
public class RptTestDataBasicDTO extends TestDataDto{
	private long acmplNth;
	private String scriptID;
	private String projNO;
	private String projName;
	private String tstrID;
	private String tstrName;
	private String rsultSucssYN;
	private String rsultMsg;
	private String rsultImgFileYN;
	private String testStartYMS;
	private String testEndYMS;
	private String elapsedTime;
	private String testStgeName;
	
	private List<RptTestDataDetailDTO> inputRptTestDataDetailDTOs;
	private List<RptTestDataDetailDTO> outputRptTestDataDetailDTOs;
	private List<RptCheckPointDTO> rptCheckPointDTOs;
	
	public long getAcmplNth() {
		return acmplNth;
	}
	public void setAcmplNth(long acmplNth) {
		this.acmplNth = acmplNth;
	}
	public String getScriptID() {
		return scriptID;
	}
	public void setScriptID(String scriptID) {
		this.scriptID = scriptID;
	}
	public String getProjNO() {
		return projNO;
	}
	public void setProjNO(String projNO) {
		this.projNO = projNO;
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
	public List<RptTestDataDetailDTO> getInputRptTestDataDetailDTOs() {
		return inputRptTestDataDetailDTOs;
	}
	public void setInputRptTestDataDetailDTOs(
			List<RptTestDataDetailDTO> inputRptTestDataDetailDTOs) {
		this.inputRptTestDataDetailDTOs = inputRptTestDataDetailDTOs;
	}
	public List<RptTestDataDetailDTO> getOutputRptTestDataDetailDTOs() {
		return outputRptTestDataDetailDTOs;
	}
	public void setOutputRptTestDataDetailDTOs(
			List<RptTestDataDetailDTO> outputRptTestDataDetailDTOs) {
		this.outputRptTestDataDetailDTOs = outputRptTestDataDetailDTOs;
	}
	public List<RptCheckPointDTO> getRptCheckPointDTOs() {
		return rptCheckPointDTOs;
	}
	public void setRptCheckPointDTOs(List<RptCheckPointDTO> rptCheckPointDTOs) {
		this.rptCheckPointDTOs = rptCheckPointDTOs;
	}
	public String getElapsedTime() {
		return elapsedTime;
	}
	public void setElapsedTime(String elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	
}
