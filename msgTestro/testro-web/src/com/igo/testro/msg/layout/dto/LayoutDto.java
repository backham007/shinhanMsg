package com.igo.testro.msg.layout.dto;

import java.util.List;

import com.igo.testro.dto.AbstractDTO;

/**
 * 
 * <p>
 * 프로그램명:LayoutDto.java<br/>
 * 설명 : 레이아웃<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 13. : KoJaeHyeong : 최초작성
 * </ul> 
 * </p>
 */
public class LayoutDto extends AbstractDTO{
	
	//채널구분코드(전문 : 01: 단말, 02: 자동화기기, 03: 인터넷뱅킹, 04: 콜센터)
	private String chnlDstcd;
	//채널구분명
	private String ChnlDstcdName;
	//거래코드
	private String tranCd;
	//거래명
	private String tranName;
	//필드구성(01:헤더,02:개별)
	private String fldDiv;
	//필드구성명
	private String fldDivName;
	//참조거래코드(헤더의 거래코드값)
	private String refTranCd;
	//작성자ID
	private String writeId;
	//작성자명
	private String writeName;
	//생성일시
	private String cretnYMS;
	//최종변경자ID
	private String lastModfiId;
	//최종변경일시
	private String lastModfiYMS;
	//비고
	private String rmark;
	
	//헤더부
	private List<LayoutDetailDto> headerList;
	//개별부
	private List<LayoutDetailDto> inviList;
	//헤더부와개별부
	private List<LayoutDetailDto> detailAllList;
	
	
	public String getChnlDstcd() {
		return chnlDstcd;
	}
	public void setChnlDstcd(String chnlDstcd) {
		this.chnlDstcd = chnlDstcd;
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
	public String getFldDiv() {
		return fldDiv;
	}
	public void setFldDiv(String fldDiv) {
		this.fldDiv = fldDiv;
	}
	public String getRefTranCd() {
		return refTranCd;
	}
	public void setRefTranCd(String refTranCd) {
		this.refTranCd = refTranCd;
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
	public List<LayoutDetailDto> getHeaderList() {
		return headerList;
	}
	public void setHeaderList(List<LayoutDetailDto> headerList) {
		this.headerList = headerList;
	}
	public List<LayoutDetailDto> getInviList() {
		return inviList;
	}
	public void setInviList(List<LayoutDetailDto> inviList) {
		this.inviList = inviList;
	}
	public String getChnlDstcdName() {
		return ChnlDstcdName;
	}
	public void setChnlDstcdName(String chnlDstcdName) {
		ChnlDstcdName = chnlDstcdName;
	}
	public String getWriteId() {
		return writeId;
	}
	public void setWriteId(String writeId) {
		this.writeId = writeId;
	}
	public String getLastModfiId() {
		return lastModfiId;
	}
	public void setLastModfiId(String lastModfiId) {
		this.lastModfiId = lastModfiId;
	}
	public List<LayoutDetailDto> getDetailAllList() {
		return detailAllList;
	}
	public void setDetailAllList(List<LayoutDetailDto> detailAllList) {
		this.detailAllList = detailAllList;
	}
	public String getFldDivName() {
		return fldDivName;
	}
	public void setFldDivName(String fldDivName) {
		this.fldDivName = fldDivName;
	}
	
}
