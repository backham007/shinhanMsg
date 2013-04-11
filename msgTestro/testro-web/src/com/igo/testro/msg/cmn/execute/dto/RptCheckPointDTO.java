package com.igo.testro.msg.cmn.execute.dto;

import com.igo.testro.msg.tcmng.dto.CheckPointDTO;

/**
 * <p>
 * 프로그램명:RptCheckPointDTO.java<br/>
 * 설명 : 체크포인트 실적 DTO<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 7. : 김기태 : 최초작성
 * </ul> 
 * </p>
 */
@SuppressWarnings("serial")
public class RptCheckPointDTO extends CheckPointDTO{
	private long acmplNth;
	private String chkPointSucssYN;
	private String chkPointOuptCtnt;
	public long getAcmplNth() {
		return acmplNth;
	}
	public void setAcmplNth(long acmplNth) {
		this.acmplNth = acmplNth;
	}
	public String getChkPointSucssYN() {
		return chkPointSucssYN;
	}
	public void setChkPointSucssYN(String chkPointSucssYN) {
		this.chkPointSucssYN = chkPointSucssYN;
	}
	public String getChkPointOuptCtnt() {
		return chkPointOuptCtnt;
	}
	public void setChkPointOuptCtnt(String chkPointOuptCtnt) {
		this.chkPointOuptCtnt = chkPointOuptCtnt;
	}
}
