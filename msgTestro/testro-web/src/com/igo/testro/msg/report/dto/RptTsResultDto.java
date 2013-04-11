package com.igo.testro.msg.report.dto;

/**
 * <p>
 * 프로그램명:RptTsResultDto.java<br/>
 * 설명 : 결과보고서 (테스트결과)<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 24. : 안도현 : 최초작성
 * </ul> 
 * </p>
 */
public class RptTsResultDto {
	private String trancd	    ; /*거래코드*/
	private String tranname	    ; /*거래명*/
	private String tscaseid	    ; /*테스트케이스ID*/
	private String tscasename	;/*테스트케이스명*/
	private String tscasedesc	;/*테스트케이스설명*/
	private String tssnrioid	;/*테스트시나리오ID*/
	private String tssnrioname	;/*테스트시나리오명*/
	private String tssnriodesc	;/*테스트시나리오설명*/
	private String tsdataid	    ; /*테스트데이터ID*/
	private String acmplnth	    ; /*테스트데이터회차*/
	private String tsdataname	;/*테스트데이터명*/
	private String tsdatadesc	;/*테스트데이터설명*/
    private String teststartyms	;/*테스트시작일시*/
    private String testendyms	;/*테스트종료일시*/
    private String elapsedtime	;/*테스트종료일시*/
    private String chekyn       ;/* 체크포인트 여부 */
	private String rsultsucssyn	;/*거래결과성공여부*/
	public String getTrancd() {
		return trancd;
	}
	public void setTrancd(String trancd) {
		this.trancd = trancd;
	}
	public String getTranname() {
		return tranname;
	}
	public void setTranname(String tranname) {
		this.tranname = tranname;
	}
	public String getTscaseid() {
		return tscaseid;
	}
	public void setTscaseid(String tscaseid) {
		this.tscaseid = tscaseid;
	}
	public String getTscasename() {
		return tscasename;
	}
	public void setTscasename(String tscasename) {
		this.tscasename = tscasename;
	}
	public String getTscasedesc() {
		return tscasedesc;
	}
	public void setTscasedesc(String tscasedesc) {
		this.tscasedesc = tscasedesc;
	}
	public String getTsdataid() {
		return tsdataid;
	}
	public void setTsdataid(String tsdataid) {
		this.tsdataid = tsdataid;
	}
	public String getTsdataname() {
		return tsdataname;
	}
	public void setTsdataname(String tsdataname) {
		this.tsdataname = tsdataname;
	}
	public String getTsdatadesc() {
		return tsdatadesc;
	}
	public void setTsdatadesc(String tsdatadesc) {
		this.tsdatadesc = tsdatadesc;
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
	public String getChekyn() {
		return chekyn;
	}
	public void setChekyn(String chekyn) {
		this.chekyn = chekyn;
	}
	public String getRsultsucssyn() {
		return rsultsucssyn;
	}
	public void setRsultsucssyn(String rsultsucssyn) {
		this.rsultsucssyn = rsultsucssyn;
	}
	public String getTssnrioid() {
		return tssnrioid;
	}
	public void setTssnrioid(String tssnrioid) {
		this.tssnrioid = tssnrioid;
	}
	public String getTssnrioname() {
		return tssnrioname;
	}
	public void setTssnrioname(String tssnrioname) {
		this.tssnrioname = tssnrioname;
	}
	public String getTssnriodesc() {
		return tssnriodesc;
	}
	public void setTssnriodesc(String tssnriodesc) {
		this.tssnriodesc = tssnriodesc;
	}
	public String getAcmplnth() {
		return acmplnth;
	}
	public void setAcmplnth(String acmplnth) {
		this.acmplnth = acmplnth;
	}
	public String getElapsedtime() {
		return elapsedtime;
	}
	public void setElapsedtime(String elapsedtime) {
		this.elapsedtime = elapsedtime;
	}
	
	
}
