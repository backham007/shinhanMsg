package com.igo.testro.msg.report.dto;

import com.igo.testro.dto.AbstractDTO;

/**
 * <p>
 * 프로그램명:RptTestCaseDto.java<br/>
 * 설명 : 결과보고서 테스트 케이스<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 28. : 안도현 : 최초작성
 * </ul> 
 * </p>
 */
public class RptTestCaseDto extends AbstractDTO{
	private String tscaseid     ;
	private String acmplnth     ;
	private String connsevrdstcd;
	private String tscasename   ;
	private String projname     ;
	private String teststgename ;
	private String rsultmsg     ;
	private String teststartyms ;
	private String testendyms   ;
	private String writeid      ;
	private String writename    ;
	private String successcnt   ;
	private String failcnt      ;
	private String rsultsucssyn;
	private String connsevrdstcdnm;
	public String getTscaseid() {
		return tscaseid;
	}
	public void setTscaseid(String tscaseid) {
		this.tscaseid = tscaseid;
	}
	public String getAcmplnth() {
		return acmplnth;
	}
	public void setAcmplnth(String acmplnth) {
		this.acmplnth = acmplnth;
	}
	public String getConnsevrdstcd() {
		return connsevrdstcd;
	}
	public void setConnsevrdstcd(String connsevrdstcd) {
		this.connsevrdstcd = connsevrdstcd;
	}
	public String getTscasename() {
		return tscasename;
	}
	public void setTscasename(String tscasename) {
		this.tscasename = tscasename;
	}
	public String getProjname() {
		return projname;
	}
	public void setProjname(String projname) {
		this.projname = projname;
	}
	public String getRsultmsg() {
		return rsultmsg;
	}
	public void setRsultmsg(String rsultmsg) {
		this.rsultmsg = rsultmsg;
	}
	public String getTeststartyms() {
		return teststartyms;
	}
	public void setTeststartyms(String teststartyms) {
		this.teststartyms = teststartyms;
	}
	public String getTestendyms() {
		return testendyms;
	}
	public void setTestendyms(String testendyms) {
		this.testendyms = testendyms;
	}
	public String getWriteid() {
		return writeid;
	}
	public void setWriteid(String writeid) {
		this.writeid = writeid;
	}
	public String getWritename() {
		return writename;
	}
	public void setWritename(String writename) {
		this.writename = writename;
	}
	public String getSuccesscnt() {
		return successcnt;
	}
	public void setSuccesscnt(String successcnt) {
		this.successcnt = successcnt;
	}
	public String getFailcnt() {
		return failcnt;
	}
	public void setFailcnt(String failcnt) {
		this.failcnt = failcnt;
	}
	public String getRsultsucssyn() {
		return rsultsucssyn;
	}
	public void setRsultsucssyn(String rsultsucssyn) {
		this.rsultsucssyn = rsultsucssyn;
	}
	public String getTeststgename() {
		return teststgename;
	}
	public void setTeststgename(String teststgename) {
		this.teststgename = teststgename;
	}
	public String getConnsevrdstcdnm() {
		return connsevrdstcdnm;
	}
	public void setConnsevrdstcdnm(String connsevrdstcdnm) {
		this.connsevrdstcdnm = connsevrdstcdnm;
	}



}
