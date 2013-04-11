package com.igo.testro.msg.tsmng.dto;

import com.igo.testro.dto.AbstractDTO;

/**
 * <p>
 * 프로그램명:IODataUseDTO.java<br/>
 * 설명 : 입출력값 활용 DTO<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 22. : 김기태 : 최초작성
 * </ul> 
 * </p>
 */
@SuppressWarnings("serial")
public class IODataUseDTO extends AbstractDTO{
	private String tsSnrioID;
	private String tsSnrioNO;
	private int tsIONO;
	private String tscsFldAttrib;
	private String preSnrioNO;
	private String preFldDiv;
	private String preFldName;
	private String preFldDesc;
	private String preFldAttrib;
	private String preFldRptName;
	private String preFldRptCnt;
	private String useFldDiv;
	private String useFldName;
	private String useFldDesc;
	private String useFldAttrib;
	private String useFldRptName;
	private String useFldRptCnt;
	private String cndnStylCtnt;
	private String lastModfiID;
	private String lastModfiYMS;
	private String rmark;
	
	private String divisionIO;
	
	private String preFld;
	private String useFld;
	
	public String getTsSnrioID() {
		return tsSnrioID;
	}
	public void setTsSnrioID(String tsSnrioID) {
		this.tsSnrioID = tsSnrioID;
	}
	public String getTsSnrioNO() {
		return tsSnrioNO;
	}
	public void setTsSnrioNO(String tsSnrioNO) {
		this.tsSnrioNO = tsSnrioNO;
	}
	public int getTsIONO() {
		return tsIONO;
	}
	public void setTsIONO(int tsIONO) {
		this.tsIONO = tsIONO;
	}
	public String getPreSnrioNO() {
		return preSnrioNO;
	}
	public void setPreSnrioNO(String preSnrioNO) {
		this.preSnrioNO = preSnrioNO;
	}
	public String getPreFldName() {
		return preFldName;
	}
	public void setPreFldName(String preFldName) {
		this.preFldName = preFldName;
	}
	public String getPreFldDesc() {
		return preFldDesc;
	}
	public void setPreFldDesc(String preFldDesc) {
		this.preFldDesc = preFldDesc;
	}
	public String getUseFldName() {
		return useFldName;
	}
	public void setUseFldName(String useFldName) {
		this.useFldName = useFldName;
	}
	public String getUseFldDesc() {
		return useFldDesc;
	}
	public void setUseFldDesc(String useFldDesc) {
		this.useFldDesc = useFldDesc;
	}
	public String getCndnStylCtnt() {
		return cndnStylCtnt;
	}
	public void setCndnStylCtnt(String cndnStylCtnt) {
		this.cndnStylCtnt = cndnStylCtnt;
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
	public String getTscsFldAttrib() {
		return tscsFldAttrib;
	}
	public void setTscsFldAttrib(String tscsFldAttrib) {
		this.tscsFldAttrib = tscsFldAttrib;
	}
	public String getDivisionIO() {
		return divisionIO;
	}
	public void setDivisionIO(String divisionIO) {
		this.divisionIO = divisionIO;
	}
	public String getPreFld() {
		return preFld;
	}
	public void setPreFld(String preFld) {
		this.preFld = preFld;
	}
	public String getUseFld() {
		return useFld;
	}
	public void setUseFld(String useFld) {
		this.useFld = useFld;
	}
	public String getPreFldDiv() {
		return preFldDiv;
	}
	public void setPreFldDiv(String preFldDiv) {
		this.preFldDiv = preFldDiv;
	}
	public String getPreFldRptCnt() {
		return preFldRptCnt;
	}
	public void setPreFldRptCnt(String preFldRptCnt) {
		this.preFldRptCnt = preFldRptCnt;
	}
	public String getUseFldDiv() {
		return useFldDiv;
	}
	public void setUseFldDiv(String useFldDiv) {
		this.useFldDiv = useFldDiv;
	}
	public String getUseFldRptCnt() {
		return useFldRptCnt;
	}
	public void setUseFldRptCnt(String useFldRptCnt) {
		this.useFldRptCnt = useFldRptCnt;
	}
	public String getPreFldAttrib() {
		return preFldAttrib;
	}
	public void setPreFldAttrib(String preFldAttrib) {
		this.preFldAttrib = preFldAttrib;
	}
	public String getUseFldAttrib() {
		return useFldAttrib;
	}
	public void setUseFldAttrib(String useFldAttrib) {
		this.useFldAttrib = useFldAttrib;
	}
	public String getPreFldRptName() {
		return preFldRptName;
	}
	public void setPreFldRptName(String preFldRptName) {
		this.preFldRptName = preFldRptName;
	}
	public String getUseFldRptName() {
		return useFldRptName;
	}
	public void setUseFldRptName(String useFldRptName) {
		this.useFldRptName = useFldRptName;
	}
}
