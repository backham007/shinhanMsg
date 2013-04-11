package com.igo.testro.msg.pretst.dto;

import java.util.List;

import com.igo.testro.dto.AbstractDTO;
import com.igo.testro.msg.tcmng.dto.CheckPointDTO;

/**
 * 
 * <p>
 * 프로그램명:TestDataDto.java<br/>
 * 설명 : 테스트데이터 기본<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 18. : KoJaeHyeong : 최초작성
 * </ul> 
 * </p>
 */
public class TestDataDto extends AbstractDTO{
	
	//테스트데이터ID
	private String tsdataID;
	//테스트데이터명
	private String tsdataName;
	//테스트데이터설명
	private String tsdataDesc;
	//채널구분코드(전문 : 01: 단말, 02: 자동화기기, 03: 인터넷뱅킹, 04: 콜센터)
	private String chnlDstcd;
	//스크립트ID
	private String scrptID;
	//거래코드
	private String tranCd;
	//거래명
	private String tranName;
	//관리자레벨구분코드(00:default, 01:대외업무관리자,02:대외업무담당자,03:테스터)
	private String mgrLvelDstcd;
	//생성구분코드(01.관리자, 02.사용자, 03.슈퍼바이저)
	private String createDivCd;
	//대외제공여부(미제공(default):'0', 제공:'1')
	private String osidOferYn;
	//체크포인트설정여부(체크포인트설정시 'Y')
	private String chkYN;
	//삭제여부(삭제시 'Y')
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
	
	//헤더부
	private List<TestDataDetailDto> headerList;
	//개별부
	private List<TestDataDetailDto> inviList;
	//해더부와 개별부 상세 리스트
	private List<TestDataDetailDto> detailAllList;
	
	//체크포인트 내역
	private List<CheckPointDTO> checkPointList;
	
	//거래결과성공여부(Y:성공,N:실패)
	private String rsultSucssYn;
	
	public String getRsultSucssYn() {
		return rsultSucssYn;
	}
	public void setRsultSucssYn(String rsultSucssYn) {
		this.rsultSucssYn = rsultSucssYn;
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
	public String getMgrLvelDstcd() {
		return mgrLvelDstcd;
	}
	public void setMgrLvelDstcd(String mgrLvelDstcd) {
		this.mgrLvelDstcd = mgrLvelDstcd;
	}
	public String getCreateDivCd() {
		return createDivCd;
	}
	public void setCreateDivCd(String createDivCd) {
		this.createDivCd = createDivCd;
	}
	public String getOsidOferYn() {
		return osidOferYn;
	}
	public void setOsidOferYn(String osidOferYn) {
		this.osidOferYn = osidOferYn;
	}
	public String getChkYN() {
		return chkYN;
	}
	public void setChkYN(String chkYN) {
		this.chkYN = chkYN;
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
	public List<TestDataDetailDto> getHeaderList() {
		return headerList;
	}
	public void setHeaderList(List<TestDataDetailDto> headerList) {
		this.headerList = headerList;
	}
	public List<TestDataDetailDto> getInviList() {
		return inviList;
	}
	public void setInviList(List<TestDataDetailDto> inviList) {
		this.inviList = inviList;
	}
	public String getTsdataDesc() {
		return tsdataDesc;
	}
	public void setTsdataDesc(String tsdataDesc) {
		this.tsdataDesc = tsdataDesc;
	}
	public List<TestDataDetailDto> getDetailAllList() {
		return detailAllList;
	}
	public void setDetailAllList(List<TestDataDetailDto> detailAllList) {
		this.detailAllList = detailAllList;
	}
	public List<CheckPointDTO> getCheckPointList() {
		return checkPointList;
	}
	public void setCheckPointList(List<CheckPointDTO> checkPointList) {
		this.checkPointList = checkPointList;
	}	
}
