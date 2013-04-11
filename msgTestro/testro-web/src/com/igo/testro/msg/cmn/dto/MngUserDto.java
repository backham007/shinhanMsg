package com.igo.testro.msg.cmn.dto;

import com.igo.testro.dto.AbstractDTO;

/**
 * <p>
 * 프로그램명:MngUserDto.java<br/>
 * 설명 : 사용자 정보 관리<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */

public class MngUserDto extends AbstractDTO{
	
	//사용자ID
	private String UsrID;
	//사용자비밀번호
	private String UsrPwd;
	//사용자명
	private String UsrName;
	//사용자권한
	private String UsrLevel;
	//삭제여부
	private String DelYN;
	//최종변경자ID
	private String LastModfiID;
	//최종변경일시
	private String LastModfiYMS;
	//비고
	private String Rmark;
	//프로젝트 번호
	private String ProjNo;
	//프로젝트 명
	private String ProjName;
	
	
	//테스트순번
	private String TestNO;
	//기본테스트
	private String DefaultTest;
	//프로젝트번호
	private String QaltyMgtProjNo;
	//프로젝트명
	private String QaltyMgtProjName;
	//테스트단계명
	private String TestStgeName;
	//접속서버구분코드
	private String ConnSevrDstcd;
	//로그아웃URL주소
	private String LoutURLAddr;
	//로그인URL주소
	private String LginURLAddr;
	//스크립트응답대기시간
	private String ScrptRspnsWaitTtm;
	//최종변경자ID
	private String LastModfiEmpid;
	//최종변경일시
	private String LastModfiEmpLevel;
	//사용자 체크 카운터
	private int CntYn;
	//사용자 레벨명
	private String UsrLevelName;
	
	public int getCntYn() {
		return CntYn;
	}
	public void setCntYn(int cntYn) {
		CntYn = cntYn;
	}
	public String getUsrID() {
		return UsrID;
	}
	public void setUsrID(String usrID) {
		UsrID = usrID;
	}
	public String getUsrPwd() {
		return UsrPwd;
	}
	public void setUsrPwd(String usrPwd) {
		UsrPwd = usrPwd;
	}
	public String getUsrName() {
		return UsrName;
	}
	public void setUsrName(String usrName) {
		UsrName = usrName;
	}
	public String getUsrLevel() {
		return UsrLevel;
	}
	public void setUsrLevel(String usrLevel) {
		UsrLevel = usrLevel;
	}
	public String getDelYN() {
		return DelYN;
	}
	public void setDelYN(String delYN) {
		DelYN = delYN;
	}
	public String getLastModfiID() {
		return LastModfiID;
	}
	public void setLastModfiID(String lastModfiID) {
		LastModfiID = lastModfiID;
	}
	public String getLastModfiYMS() {
		return LastModfiYMS;
	}
	public void setLastModfiYMS(String lastModfiYMS) {
		LastModfiYMS = lastModfiYMS;
	}
	public String getRmark() {
		return Rmark;
	}
	public void setRmark(String rmark) {
		Rmark = rmark;
	}
	public String getTestNO() {
		return TestNO;
	}
	public void setTestNO(String testNO) {
		TestNO = testNO;
	}
	public String getDefaultTest() {
		return DefaultTest;
	}
	public void setDefaultTest(String defaultTest) {
		DefaultTest = defaultTest;
	}
	public String getQaltyMgtProjNo() {
		return QaltyMgtProjNo;
	}
	public void setQaltyMgtProjNo(String qaltyMgtProjNo) {
		QaltyMgtProjNo = qaltyMgtProjNo;
	}
	public String getQaltyMgtProjName() {
		return QaltyMgtProjName;
	}
	public void setQaltyMgtProjName(String qaltyMgtProjName) {
		QaltyMgtProjName = qaltyMgtProjName;
	}
	public String getTestStgeName() {
		return TestStgeName;
	}
	public void setTestStgeName(String testStgeName) {
		TestStgeName = testStgeName;
	}
	public String getConnSevrDstcd() {
		return ConnSevrDstcd;
	}
	public void setConnSevrDstcd(String connSevrDstcd) {
		ConnSevrDstcd = connSevrDstcd;
	}
	public String getLoutURLAddr() {
		return LoutURLAddr;
	}
	public void setLoutURLAddr(String loutURLAddr) {
		LoutURLAddr = loutURLAddr;
	}
	public String getLginURLAddr() {
		return LginURLAddr;
	}
	public void setLginURLAddr(String lginURLAddr) {
		LginURLAddr = lginURLAddr;
	}
	public String getScrptRspnsWaitTtm() {
		return ScrptRspnsWaitTtm;
	}
	public void setScrptRspnsWaitTtm(String scrptRspnsWaitTtm) {
		ScrptRspnsWaitTtm = scrptRspnsWaitTtm;
	}
	public String getLastModfiEmpid() {
		return LastModfiEmpid;
	}
	public void setLastModfiEmpid(String lastModfiEmpid) {
		LastModfiEmpid = lastModfiEmpid;
	}
	public String getProjNo() {
		return ProjNo;
	}
	public void setProjNo(String projNo) {
		ProjNo = projNo;
	}
	public String getProjName() {
		return ProjName;
	}
	public void setProjName(String projName) {
		ProjName = projName;
	}
	public String getUsrLevelName() {
		return UsrLevelName;
	}
	public void setUsrLevelName(String usrLevelName) {
		UsrLevelName = usrLevelName;
	}
	public String getLastModfiEmpLevel() {
		return LastModfiEmpLevel;
	}
	public void setLastModfiEmpLevel(String lastModfiEmpLevel) {
		LastModfiEmpLevel = lastModfiEmpLevel;
	}
	
	
	
	
}
