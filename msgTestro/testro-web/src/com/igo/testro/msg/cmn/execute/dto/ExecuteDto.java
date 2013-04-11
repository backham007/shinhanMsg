package com.igo.testro.msg.cmn.execute.dto;

import com.igo.testro.dto.AbstractDTO;
import com.igo.testro.msg.pretst.dto.TestDataDto;

/**
 * 
 * <p>
 * 프로그램명:executeDto.java<br/>
 * 설명 : 테스트실행<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 17. : KoJaeHyeong : 최초작성
 * </ul> 
 * </p>
 */
public class ExecuteDto extends AbstractDTO{
	
	//접속서버구분코드
	private String connSevrDstcd;
	//채널구분코드(전문 : 01: 단말, 02: 자동화기기, 03: 인터넷뱅킹, 04: 콜센터)
	private String chnlDstcd;
	//거래코드
	private String tranCd;
	//입력전문Dto
	private TestDataDto inputDto;
	//출력전문Dto
	private TestDataDto outputDto;
	//입력전문Bytes
	private byte[] inputBytes;
	//출력전문Bytes
	private byte[] outputBytes;
	//테스트시작일
	private String startTime;
	//테스트종료일
	private String endTime;
	//테스트소요시간
	private String elapsedTime;
	//거래결과성공여부(Y:성공,N:실패)
	private String rsultSucssYn;
	//거래결과메시지
	private String rsultMsg;
	//전문길이필드의 Size
	private String lengthFldSize;
	//전문길이필드의 속성(hex,text,num)
	private String lengthFldType;
	
	public String getConnSevrDstcd() {
		return connSevrDstcd;
	}
	public void setConnSevrDstcd(String connSevrDstcd) {
		this.connSevrDstcd = connSevrDstcd;
	}
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
	public byte[] getInputBytes() {
		return inputBytes;
	}
	public void setInputBytes(byte[] inputBytes) {
		this.inputBytes = inputBytes;
	}
	public byte[] getOutputBytes() {
		return outputBytes;
	}
	public void setOutputBytes(byte[] outputBytes) {
		this.outputBytes = outputBytes;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getElapsedTime() {
		return elapsedTime;
	}
	public void setElapsedTime(String elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	public TestDataDto getInputDto() {
		return inputDto;
	}
	public void setInputDto(TestDataDto inputDto) {
		this.inputDto = inputDto;
	}
	public TestDataDto getOutputDto() {
		return outputDto;
	}
	public void setOutputDto(TestDataDto outputDto) {
		this.outputDto = outputDto;
	}
	public String getRsultSucssYn() {
		return rsultSucssYn;
	}
	public void setRsultSucssYn(String rsultSucssYn) {
		this.rsultSucssYn = rsultSucssYn;
	}
	public String getRsultMsg() {
		return rsultMsg;
	}
	public void setRsultMsg(String rsultMsg) {
		this.rsultMsg = rsultMsg;
	}
	public String getLengthFldType() {
		return lengthFldType;
	}
	public void setLengthFldType(String lengthFldType) {
		this.lengthFldType = lengthFldType;
	}
	public String getLengthFldSize() {
		return lengthFldSize;
	}
	public void setLengthFldSize(String lengthFldSize) {
		this.lengthFldSize = lengthFldSize;
	}
	
	
}
