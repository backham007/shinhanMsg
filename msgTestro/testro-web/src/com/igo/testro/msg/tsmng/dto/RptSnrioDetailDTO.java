package com.igo.testro.msg.tsmng.dto;

import java.util.List;

import com.igo.testro.msg.cmn.execute.dto.RptTestDataDetailDTO;

/**
 * <p>
 * 프로그램명:RptSnrioDetailDTO.java<br/>
 * 설명 : 테스트 시나리오 상세 실적 DTO<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 7. : 김기태 : 최초작성
 * </ul> 
 * </p>
 */
@SuppressWarnings("serial")
public class RptSnrioDetailDTO extends TestSnrioDetailDTO{
	private long acmplNth;
	private long tsdataAcmplNth;
	private String rsultSucssYN;
	private String chkYN;
	
	private List<RptTestDataDetailDTO> inputRptTestDataDetailDTOs;
	private List<RptTestDataDetailDTO> outputRptTestDataDetailDTOs;
	
	public long getAcmplNth() {
		return acmplNth;
	}
	public void setAcmplNth(long acmplNth) {
		this.acmplNth = acmplNth;
	}
	public long getTsdataAcmplNth() {
		return tsdataAcmplNth;
	}
	public void setTsdataAcmplNth(long tsdataAcmplNth) {
		this.tsdataAcmplNth = tsdataAcmplNth;
	}
	public String getRsultSucssYN() {
		return rsultSucssYN;
	}
	public void setRsultSucssYN(String rsultSucssYN) {
		this.rsultSucssYN = rsultSucssYN;
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
	public String getChkYN() {
		return chkYN;
	}
	public void setChkYN(String chkYN) {
		this.chkYN = chkYN;
	}
}
