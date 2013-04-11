package com.igo.testro.msg.report.dto;

/**
 * <p>
 * 프로그램명:RptTestSenarioDto.java<br/>
 * 설명 : 결과보고서 시나리오<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 28. : 안도현 : 최초작성
 * </ul> 
 * </p>
 */
public class RptTestSenarioDto {
	private String tssnrioid    ;
	private String acmplnth     ;
	private String connsevrdstcd;
	private String tssnrioname  ;
	private String projname     ;
	private String rsultmsg     ;
	private String teststartyms ;
	private String testendyms   ;
	private String writeid      ;
	private String writename    ;
	private String rsultsucssyn ;
	private String successcnt   ;
	private String failcnt      ;
	private String defcount     ;
	private String treatcount   ;
	public String getTssnrioid() {
		return tssnrioid;
	}
	public void setTssnrioid(String tssnrioid) {
		this.tssnrioid = tssnrioid;
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
	public String getTssnrioname() {
		return tssnrioname;
	}
	public void setTssnrioname(String tssnrioname) {
		this.tssnrioname = tssnrioname;
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
	public String getRsultsucssyn() {
		return rsultsucssyn;
	}
	public void setRsultsucssyn(String rsultsucssyn) {
		this.rsultsucssyn = rsultsucssyn;
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
	public String getDefcount() {
		return defcount;
	}
	public void setDefcount(String defcount) {
		this.defcount = defcount;
	}
	public String getTreatcount() {
		return treatcount;
	}
	public void setTreatcount(String treatcount) {
		this.treatcount = treatcount;
	}
}
