package com.igo.testro.msg.cmn.dto;

import java.util.ArrayList;
import com.igo.testro.dto.AbstractDTO;
public class ConditionDto extends AbstractDTO{

	private String testBzwkOsidInstiID;
	private String testBzwkOsidBzwkCdID;
	private String lastModfiEmad;
	private String testSnrioID;
	private String inqType; 
	private String inqComd;
	private String msgID;
	private String tranType;
	private String startDt;
	private String endDt;
	private String tstrName;
	private String tranRsultSucssYn;
	private String qaltyMgtProjNo;		
	private String qaltyMgtProjName;
	private String testStgeDstcd;
	private String mciChnlDstcd;
	private String tscsAttriDstcd;
	private int totCnt;
	private String listCnt;
	private String stListCnt;
	private String lastModfiEmpid;
	private String writPnm;
	private String testFlawPrgrsDstcd;
	private String tbTestFlawPrgrsDstcd;
	private String tsTestFlawPrgrsDstcd;
	private String inqSelect;
	private String inqValue;
	private String intnlUserYn;	
	
	
	private String[] arrTestSnrioID; 
	private String[] arrTestBndlID; 
	private String systemName;
	private String successYN;

	private String tranResult;
	private String execSevrDstcd; 
	private String scrptIDName;
	
	public String getScrptIDName() {
		return scrptIDName;
	}
	public void setScrptIDName(String scrptIDName) {
		this.scrptIDName = scrptIDName;
	}
	/**
	 * Return testBzwkOsidInstiID to Requester
	 *
	 * @return testBzwkOsidInstiID
	 */
	public String getTestBzwkOsidInstiID() {
		return testBzwkOsidInstiID;
	}
	/**
	 * Set testBzwkOsidInstiID
	 *
	 * @param testBzwkOsidInstiID testBzwkOsidInstiID.
	 */
	public void setTestBzwkOsidInstiID(String testBzwkOsidInstiID) {
		this.testBzwkOsidInstiID = testBzwkOsidInstiID;
	}
	/**
	 * Return testBzwkOsidBzwkCdID to Requester
	 *
	 * @return testBzwkOsidBzwkCdID
	 */
	public String getTestBzwkOsidBzwkCdID() {
		return testBzwkOsidBzwkCdID;
	}
	/**
	 * Set testBzwkOsidBzwkCdID
	 *
	 * @param testBzwkOsidBzwkCdID testBzwkOsidBzwkCdID.
	 */
	public void setTestBzwkOsidBzwkCdID(String testBzwkOsidBzwkCdID) {
		this.testBzwkOsidBzwkCdID = testBzwkOsidBzwkCdID;
	}
	/**
	 * Return lastModfiEmad to Requester
	 *
	 * @return lastModfiEmad
	 */
	public String getLastModfiEmad() {
		return lastModfiEmad;
	}
	/**
	 * Set lastModfiEmad
	 *
	 * @param lastModfiEmad lastModfiEmad.
	 */
	public void setLastModfiEmad(String lastModfiEmad) {
		this.lastModfiEmad = lastModfiEmad;
	}
	/**
	 * Return intnlUserYn to Requester
	 *
	 * @return intnlUserYn
	 */
	public String getIntnlUserYn() {
		return intnlUserYn;
	}
	/**
	 * Set intnlUserYn
	 *
	 * @param intnlUserYn intnlUserYn.
	 */
	public void setIntnlUserYn(String intnlUserYn) {
		this.intnlUserYn = intnlUserYn;
	}
	/**
	 * Return tranResult to Requester
	 *
	 * @return tranResult
	 */
	public String getTranResult() {
		return tranResult;
	}
	/**
	 * Set tranResult
	 *
	 * @param tranResult tranResult.
	 */
	public void setTranResult(String tranResult) {
		this.tranResult = tranResult;
	}
	/**
	 * Return inqSelect to Requester
	 *
	 * @return inqSelect
	 */
	public String getInqSelect() {
		return inqSelect;
	}
	/**
	 * Set inqSelect
	 *
	 * @param inqSelect inqSelect.
	 */
	public void setInqSelect(String inqSelect) {
		this.inqSelect = inqSelect;
	}
	/**
	 * Return inqValue to Requester
	 *
	 * @return inqValue
	 */
	public String getInqValue() {
		return inqValue;
	}
	/**
	 * Set inqValue
	 *
	 * @param inqValue inqValue.
	 */
	public void setInqValue(String inqValue) {
		this.inqValue = inqValue;
	}
	/**
	 * Return successYN to Requester
	 *
	 * @return successYN
	 */
	public String getSuccessYN() {
		return successYN;
	}
	/**
	 * Set successYN
	 *
	 * @param successYN successYN.
	 */
	public void setSuccessYN(String successYN) {
		this.successYN = successYN;
	}
	/**
	 * Return arrTestBndlID to Requester
	 *
	 * @return arrTestBndlID
	 */
	public String[] getArrTestBndlID() {
		return arrTestBndlID;
	}
	/**
	 * Set arrTestBndlID
	 *
	 * @param arrTestBndlID arrTestBndlID.
	 */
	public void setArrTestBndlID(String[] arrTestBndlID) {
		this.arrTestBndlID = arrTestBndlID;
	}
	/**
	 * Return systemName to Requester
	 *
	 * @return systemName
	 */
	public String getSystemName() {
		return systemName;
	}
	/**
	 * Set systemName
	 *
	 * @param systemName systemName.
	 */
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	/**
	 * Return stListCnt to Requester
	 *
	 * @return stListCnt
	 */
	public String getStListCnt() {
		return stListCnt;
	}
	/**
	 * Set stListCnt
	 *
	 * @param stListCnt stListCnt.
	 */
	public void setStListCnt(String stListCnt) {
		this.stListCnt = stListCnt;
	}
	/**
	 * Return arrTestSnrioID to Requester
	 *
	 * @return arrTestSnrioID
	 */
	public String[] getArrTestSnrioID() {
		return arrTestSnrioID;
	}
	/**
	 * Set arrTestSnrioID
	 *
	 * @param arrTestSnrioID arrTestSnrioID.
	 */
	public void setArrTestSnrioID(String[] arrTestSnrioID) {
		this.arrTestSnrioID = arrTestSnrioID;
	}
	/**
	 * Return tbTestFlawPrgrsDstcd to Requester
	 *
	 * @return tbTestFlawPrgrsDstcd
	 */
	public String getTbTestFlawPrgrsDstcd() {
		return tbTestFlawPrgrsDstcd;
	}
	/**
	 * Set tbTestFlawPrgrsDstcd
	 *
	 * @param tbTestFlawPrgrsDstcd tbTestFlawPrgrsDstcd.
	 */
	public void setTbTestFlawPrgrsDstcd(String tbTestFlawPrgrsDstcd) {
		this.tbTestFlawPrgrsDstcd = tbTestFlawPrgrsDstcd;
	}
	/**
	 * Return tsTestFlawPrgrsDstcd to Requester
	 *
	 * @return tsTestFlawPrgrsDstcd
	 */
	public String getTsTestFlawPrgrsDstcd() {
		return tsTestFlawPrgrsDstcd;
	}
	/**
	 * Set tsTestFlawPrgrsDstcd
	 *
	 * @param tsTestFlawPrgrsDstcd tsTestFlawPrgrsDstcd.
	 */
	public void setTsTestFlawPrgrsDstcd(String tsTestFlawPrgrsDstcd) {
		this.tsTestFlawPrgrsDstcd = tsTestFlawPrgrsDstcd;
	}
	/**
	 * Return testFlawPrgrsDstcd to Requester
	 *
	 * @return testFlawPrgrsDstcd
	 */
	public String getTestFlawPrgrsDstcd() {
		return testFlawPrgrsDstcd;
	}
	/**
	 * Set testFlawPrgrsDstcd
	 *
	 * @param testFlawPrgrsDstcd testFlawPrgrsDstcd.
	 */
	public void setTestFlawPrgrsDstcd(String testFlawPrgrsDstcd) {
		this.testFlawPrgrsDstcd = testFlawPrgrsDstcd;
	}
	private String bzwkInitCd;    
	private String tbTreatFnshYn; 
	private String tsTreatFnshYn; 
	private String treatFnshYn;   
	private String mgrLvelDstcd;  

	private String testId; 
	private String testNm; 
	private int acmplNth;
	private String tesSerno;
	private String TscsSourcDstcd; 
	

	private ArrayList<String> tscsId; 
	private ArrayList<String> tscsName; 
	

	private String empid; 
	private String empName; 

	private String gb; 
	private String flag; 
	
	public String getBzwkInitCd() {
		return bzwkInitCd;
	}
	public void setBzwkInitCd(String bzwkInitCd) {
		this.bzwkInitCd = bzwkInitCd;
	}
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public int getAcmplNth() {
		return acmplNth;
	}
	public void setAcmplNth(int acmplNth) {
		this.acmplNth = acmplNth;
	}
	public String getInqType() {
		return inqType;
	}
	public void setInqType(String inqType) {
		this.inqType = inqType;
	}
	public String getInqComd() {
		return inqComd;
	}
	public void setInqComd(String inqComd) {
		this.inqComd = inqComd;
	}
	public String getMsgID() {
		return msgID;
	}
	public void setMsgID(String msgID) {
		this.msgID = msgID;
	} 
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public String getStartDt() {
		return startDt;
	}	
	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}
	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}	
	public String getTstrName() {
		return tstrName;
	}
	public void setTstrName(String tstrName) {
		this.tstrName = tstrName;
	}	
	public String getTranRsultSucssYn() {
		return tranRsultSucssYn;
	}
	public void setTranRsultSucssYn(String tranRsultSucssYn) {
		this.tranRsultSucssYn = tranRsultSucssYn;
	}
	public String getQaltyMgtProjNo() {
		return qaltyMgtProjNo;
	}
	public void setQaltyMgtProjNo(String qaltyMgtProjNo) {
		this.qaltyMgtProjNo = qaltyMgtProjNo;
	}
	public String getTestStgeDstcd() {
		return testStgeDstcd;
	}
	public void setTestStgeDstcd(String testStgeDstcd) {
		this.testStgeDstcd = testStgeDstcd;
	}
	public String getMciChnlDstcd() {
		return mciChnlDstcd;
	}
	public void setMciChnlDstcd(String mciChnlDstcd) {
		this.mciChnlDstcd = mciChnlDstcd;
	}
	public String getTestNm() {
		return testNm;
	}
	public void setTestNm(String testNm) {
		this.testNm = testNm;
	}
	public String getTscsAttriDstcd() {
		return tscsAttriDstcd;
	}
	public void setTscsAttriDstcd(String tscsAttriDstcd) {
		this.tscsAttriDstcd = tscsAttriDstcd;
	}
	public String getTscsSourcDstcd() {
		return TscsSourcDstcd;
	}
	public void setTscsSourcDstcd(String tscsSourcDstcd) {
		TscsSourcDstcd = tscsSourcDstcd;
	}
	public int getTotCnt() {
		return totCnt;
	}
	public void setTotCnt(int totCnt) {
		this.totCnt = totCnt;
	}
	public ArrayList<String> getTscsId() {
		return tscsId;
	}
	public void setTscsId(ArrayList<String> tscsId) {
		this.tscsId = tscsId;
	}
	public ArrayList<String> getTscsName() {
		return tscsName;
	}
	public void setTscsName(ArrayList<String> tscsName) {
		this.tscsName = tscsName;
	}
	public String getQaltyMgtProjName() {
		return qaltyMgtProjName;
	}
	public void setQaltyMgtProjName(String qaltyMgtProjName) {
		this.qaltyMgtProjName = qaltyMgtProjName;
	}
	public String getListCnt() {
		return listCnt;
	}
	public void setListCnt(String listCnt) {
		this.listCnt = listCnt;
	}
	public String getLastModfiEmpid() {
		return lastModfiEmpid;
	}
	public void setLastModfiEmpid(String lastModfiEmpid) {
		this.lastModfiEmpid = lastModfiEmpid;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getTesSerno() {
		return tesSerno;
	}
	public void setTesSerno(String tesSerno) {
		this.tesSerno = tesSerno;
	}
	public String getGb() {
		return gb;
	}
	public void setGb(String gb) {
		this.gb = gb;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getTestSnrioID() {
		return testSnrioID;
	}
	public void setTestSnrioID(String testSnrioID) {
		this.testSnrioID = testSnrioID;
	}
	public String getTbTreatFnshYn() {
		return tbTreatFnshYn;
	}
	public void setTbTreatFnshYn(String tbTreatFnshYn) {
		this.tbTreatFnshYn = tbTreatFnshYn;
	}
	public String getTsTreatFnshYn() {
		return tsTreatFnshYn;
	}
	public void setTsTreatFnshYn(String tsTreatFnshYn) {
		this.tsTreatFnshYn = tsTreatFnshYn;
	}
	public String getWritPnm() {
		return writPnm;
	}
	public void setWritPnm(String writPnm) {
		this.writPnm = writPnm;
	}
	public String getTreatFnshYn() {
		return treatFnshYn;
	}
	public void setTreatFnshYn(String treatFnshYn) {
		this.treatFnshYn = treatFnshYn;
	}
	public String getMgrLvelDstcd() {
		return mgrLvelDstcd;
	}
	public void setMgrLvelDstcd(String mgrLvelDstcd) {
		this.mgrLvelDstcd = mgrLvelDstcd;
	}
	/**
	 * @return the execSevrDstcd
	 */
	public String getExecSevrDstcd() {
		return execSevrDstcd;
	}
	/**
	 * @param execSevrDstcd the execSevrDstcd to set
	 */
	public void setExecSevrDstcd(String execSevrDstcd) {
		this.execSevrDstcd = execSevrDstcd;
	}
}
