package com.igo.testro.msg.tcmng.dto;

import java.util.List;

/**
 * <p>
 * 프로그램명:TcDto.java<br/>
 * 설명 : 테스트케이스 기본<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 18. : ksj : 테스트케이스 기본 DTO
 * </ul> 
 * </p>
 */
public class TcDto {
	
	//테스트케이스ID
	private String tsCaseID;
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
	//삭제여부
	private String delYN;
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
	
	List<TcDetailDto> tcDetailList;

	public String getTsCaseID() {
		return tsCaseID;
	}

	public void setTsCaseID(String tsCaseID) {
		this.tsCaseID = tsCaseID;
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

	public String getDelYN() {
		return delYN;
	}

	public void setDelYN(String delYN) {
		this.delYN = delYN;
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

	public List<TcDetailDto> getTcDetailList() {
		return tcDetailList;
	}

	public void setTcDetailList(List<TcDetailDto> tcDetailList) {
		this.tcDetailList = tcDetailList;
	}

}
