package com.igo.testro.msg.myLatestWork.dto;

import com.igo.testro.cmn.dto.GridBaseDto;

public class myLatestWorkDto extends GridBaseDto{
	
	private static final long serialVersionUID = 1L;
	
	private String cretnYMS;             //생성일
	private String objId;				 //id
	private String[] objIds;			 //id
	private String tranCd;				 //거래코드
	private String tranName;			 //거래명
	private String objName;				 //이름
	private String tcCount;				 //테스트데이터 갯수
	private String rsultSucssYn;		 //결과
	private String chnlDstcd;			 //채널 구분
	private String acmplnth;			 //수행회차
	private String[] acmplnths;			 //수행회차
	private String objMissCnt;			 //테스트데이터 실패 갯수
	private String objExeCnt;			 //테스트데이터 성공 갯수
	private String searchGubun;          //조회구분(01:테스트케이스 02:테스트시나리오 03:결과보고서)
	private String reportGubun;          //결과 보고서 구분
	private String exeYn;                //실행유무
	private String writeId;              //작성자 명
	private String subSearch;            //선택 조건
	private String keyword;              //검색 값
	private String tstrName;             //테스터 명
	private String sidx;        		 // ordey by 필드명
	private String sord;        		 // asc or desc
	private String rsultSucssYnExcl;     // 실행결과(엑셀에서 사용)
	private int totalCount;              // 총카운트
	private String lastModfiId;          // 최종수정자명
	private String lastModfiYMS;         // 최종수정일.
	
	public String getLastModfiId() {
		return lastModfiId;
	}
	public void setLastModfiId(String lastModfiId) {
		this.lastModfiId = lastModfiId;
	}
	public String getLastModfiYMS() {
		return lastModfiYMS;
	}
	public void setLastModfiYMS(String lastModfiYMS) {
		this.lastModfiYMS = lastModfiYMS;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public String getRsultSucssYnExcl() {
		return rsultSucssYnExcl;
	}
	public void setRsultSucssYnExcl(String rsultSucssYnExcl) {
		this.rsultSucssYnExcl = rsultSucssYnExcl;
	}
	public String getSidx() {
		return sidx;
	}
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
	public String getSord() {
		return sord;
	}
	public void setSord(String sord) {
		this.sord = sord;
	}
	public String getTstrName() {
		return tstrName;
	}
	public void setTstrName(String tstrName) {
		this.tstrName = tstrName;
	}
	public String[] getObjIds() {
		return objIds;
	}
	public void setObjIds(String[] objIds) {
		this.objIds = objIds;
	}
	public String[] getAcmplnths() {
		return acmplnths;
	}
	public void setAcmplnths(String[] acmplnths) {
		this.acmplnths = acmplnths;
	}
	public String getSubSearch() {
		return subSearch;
	}
	public void setSubSearch(String subSearch) {
		this.subSearch = subSearch;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getWriteId() {
		return writeId;
	}
	public void setWriteId(String writeId) {
		this.writeId = writeId;
	}
	public String getExeYn() {
		return exeYn;
	}
	public void setExeYn(String exeYn) {
		this.exeYn = exeYn;
	}
	public String getReportGubun() {
		return reportGubun;
	}
	public void setReportGubun(String reportGubun) {
		this.reportGubun = reportGubun;
	}
	public String getSearchGubun() {
		return searchGubun;
	}
	public void setSearchGubun(String searchGubun) {
		this.searchGubun = searchGubun;
	}
	public String getCretnYMS() {
		return cretnYMS;
	}
	public void setCretnYMS(String cretnYMS) {
		this.cretnYMS = cretnYMS;
	}
	public String getObjId() {
		return objId;
	}
	public void setObjId(String objId) {
		this.objId = objId;
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
	public String getObjName() {
		return objName;
	}
	public void setObjName(String objName) {
		this.objName = objName;
	}
	public String getTcCount() {
		return tcCount;
	}
	public void setTcCount(String tcCount) {
		this.tcCount = tcCount;
	}
	public String getRsultSucssYn() {
		return rsultSucssYn;
	}
	public void setRsultSucssYn(String rsultSucssYn) {
		this.rsultSucssYn = rsultSucssYn;
	}
	public String getChnlDstcd() {
		return chnlDstcd;
	}
	public void setChnlDstcd(String chnlDstcd) {
		this.chnlDstcd = chnlDstcd;
	}
	public String getAcmplnth() {
		return acmplnth;
	}
	public void setAcmplnth(String acmplnth) {
		this.acmplnth = acmplnth;
	}
	public String getObjMissCnt() {
		return objMissCnt;
	}
	public void setObjMissCnt(String objMissCnt) {
		this.objMissCnt = objMissCnt;
	}
	public String getObjExeCnt() {
		return objExeCnt;
	}
	public void setObjExeCnt(String objExeCnt) {
		this.objExeCnt = objExeCnt;
	}
	
	
	

}
