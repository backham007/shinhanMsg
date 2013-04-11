package com.igo.testro.msg.AutoData.dto;

import java.util.List;

import com.igo.testro.dto.AbstractDTO;

/**
 * <p>
 * 프로그램명 : UsrinputdatamngDto.java<br/>
 * 설명 : 사용자 입력 데이터 관리<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */
public class UsrinputdatamngDto extends AbstractDTO {
	
	//필드 ID
	private String fldId;
	//필드 이름
	private String fldName;
	//필드 설명
	private String fldDesc;
	//삭제 여부
	private String delYN;
	//작성자ID
	private String writeId;
	//작성자 명
	private String writeName;
	//삭제 일시
	private String delYMS;
	//비고
	private String rmark;
	//리스트 카운터
	private int listNum;
	//사용자 체크 
	private int CntYn;
	//데이터 리스트
	private List<UsrinputdatamngDto> usrinputdatamngList;
	//출력순서번호
	private String outptseqNo;
	//출력순서번호
	private String ListNo;
	//상세필드명
	private String dtailFldName;
	//상세필드설명
	private String dtailFlddEsc;

	public String getFldId() {
		return fldId;
	}
	public void setFldId(String fldId) {
		this.fldId = fldId;
	}
	public String getFldName() {
		return fldName;
	}
	public void setFldName(String fldName) {
		this.fldName = fldName;
	}
	public String getFldDesc() {
		return fldDesc;
	}
	public void setFldDesc(String fldDesc) {
		this.fldDesc = fldDesc;
	}
	public String getDelYN() {
		return delYN;
	}
	public void setDelYN(String delYN) {
		this.delYN = delYN;
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
	public String getDelYMS() {
		return delYMS;
	}
	public void setDelYMS(String delYMS) {
		this.delYMS = delYMS;
	}
	public String getRmark() {
		return rmark;
	}
	public void setRmark(String rmark) {
		this.rmark = rmark;
	}
	public int getListNum() {
		return listNum;
	}
	public void setListNum(int i) {
		this.listNum = i;
	}
	public int getCntYn() {
		return CntYn;
	}
	public void setCntYn(int cntYn) {
		CntYn = cntYn;
	}
	public List<UsrinputdatamngDto> getUsrinputdatamngList() {
		return usrinputdatamngList;
	}
	public void setUsrinputdatamngList(List<UsrinputdatamngDto> usrinputdatamngList) {
		this.usrinputdatamngList = usrinputdatamngList;
	}
	public String getOutptseqNo() {
		return outptseqNo;
	}
	public void setOutptseqNo(String outptseqNo) {
		this.outptseqNo = outptseqNo;
	}
	public String getDtailFldName() {
		return dtailFldName;
	}
	public void setDtailFldName(String dtailFldName) {
		this.dtailFldName = dtailFldName;
	}
	public String getDtailFlddEsc() {
		return dtailFlddEsc;
	}
	public void setDtailFlddEsc(String dtailFlddEsc) {
		this.dtailFlddEsc = dtailFlddEsc;
	}
	public String getListNo() {
		return ListNo;
	}
	public void setListNo(String listNo) {
		ListNo = listNo;
	}
	

	
	
	

	
}
