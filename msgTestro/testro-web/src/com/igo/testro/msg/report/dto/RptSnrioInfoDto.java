package com.igo.testro.msg.report.dto;

/**
 * <p>
 * 프로그램명:RptSnrioInfoDto.java<br/>
 * 설명 : 결과보고서 시나리오 기본<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 1. : 고재형 : 최초작성
 * </ul> 
 * </p>
 */
public class RptSnrioInfoDto {
	private String projno	   ;   /*프로젝트번호    */
	private String projname	   ; /*프로젝트명      */
	private String tssnrioid	   ; /*테스트케이스ID  */
	private String tssnrioname	;  /*테스트케이스명  */
	private String teststartyms;	/*테스트시작일시  */
	private String testendyms	;  /*테스트종료일시	*/
	private String teststgename;	/*테스트단계명    */
	private String rsultsucssyn;	/*거래결과성공여부*/
	private String acmplnth	   ; /*수행회차        */
	private String tstrname	   ; /*테스터명        */
	
	//-- 테스트케이스  데이터 리스트--
	private String tsdataid	   ;   /*테스트데이터ID      */
	private String tsdataacmplnth;	/*테스트데이터수행회차*/
	private String chekyn		;	/*테스트데이터체크포인트설정여부*/
	public String getProjno() {
		return projno;
	}
	public void setProjno(String projno) {
		this.projno = projno;
	}
	public String getProjname() {
		return projname;
	}
	public void setProjname(String projname) {
		this.projname = projname;
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
	public String getTeststgename() {
		return teststgename;
	}
	public void setTeststgename(String teststgename) {
		this.teststgename = teststgename;
	}
	public String getRsultsucssyn() {
		return rsultsucssyn;
	}
	public void setRsultsucssyn(String rsultsucssyn) {
		this.rsultsucssyn = rsultsucssyn;
	}
	public String getAcmplnth() {
		return acmplnth;
	}
	public void setAcmplnth(String acmplnth) {
		this.acmplnth = acmplnth;
	}
	public String getTstrname() {
		return tstrname;
	}
	public void setTstrname(String tstrname) {
		this.tstrname = tstrname;
	}
	public String getTsdataid() {
		return tsdataid;
	}
	public void setTsdataid(String tsdataid) {
		this.tsdataid = tsdataid;
	}
	public String getTsdataacmplnth() {
		return tsdataacmplnth;
	}
	public void setTsdataacmplnth(String tsdataacmplnth) {
		this.tsdataacmplnth = tsdataacmplnth;
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
	public String getChekyn() {
		return chekyn;
	}
	public void setChekyn(String chekyn) {
		this.chekyn = chekyn;
	}
	
}
