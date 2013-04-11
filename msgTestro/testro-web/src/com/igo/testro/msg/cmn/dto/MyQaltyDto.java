package com.igo.testro.msg.cmn.dto;
import java.util.List;

import com.igo.testro.dto.AbstractDTO;

/**
 * <p>
 * 프로그램명:MyQaltyDto.java<br/>
 * 설명 : 나의 프로젝트 정보설정<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */
public class MyQaltyDto extends AbstractDTO {
	//사용자ID
	private String usrID;			
	//
	private String testNO;
	//프로젝트번호
	private String projNo;				
	//테스트단계명
	private String testStgeName;		
	//프로젝트명
	private String projName;			
	//시작일자
	private String testStartYMS;
	//시작일자 변경
	private String testStartYMS2;
	//종료일자
	private String testEndYMS;	
	//종료일자 변경
	private String testEndYMS2;	
	//최종변경자ID
	private String lastModfiEmpid;
	//최종변경일시
	private String lastModfiYMS;
	//비고
	private String rmark;
	//아이디체크카운터
	private int cntYn; 				
	//접속서버구분코드
	private String connSevrDstcd;
	//에디트 여부
	private String editYN;
	//리트스 담기
	private List<MyQaltyDto> myQaltyList;
	//기본테스트
	private String defaultTest;
	//프로젝트번호
	private String qaltyMgtProjNo;
	//프로젝트명
	private String qaltyMgtProjName;
	//로그아웃URL주소
	private String loutURLAddr;
	//로그인URL주소
	private String lginURLAddr;
	//스크립트응답대기시간
	private String scrptRspnsWaitTtm;
	//신규 , 수정 구분
	private String newInsert;
	//사용자 ID체크 
	private int check;
	
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	public String getNewInsert() {
		return newInsert;
	}
	public void setNewInsert(String newInsert) {
		this.newInsert = newInsert;
	}
	public List<MyQaltyDto> getMyQaltyList() {
		return myQaltyList;
	}
	public void setMyQaltyList(List<MyQaltyDto> myQaltyList) {
		this.myQaltyList = myQaltyList;
	}
	
	public String getEditYN() {
		return editYN;
	}
	public void setEditYN(String editYN) {
		this.editYN = editYN;
	}
	public String getUsrID() {
		return usrID;
	}
	public void setUsrID(String usrID) {
		this.usrID = usrID;
	}
	public String getTestNO() {
		return testNO;
	}
	public void setTestNO(String testNO) {
		this.testNO = testNO;
	}
	public String getProjNo() {
		return projNo;
	}
	public void setProjNo(String projNo) {
		this.projNo = projNo;
	}
	public String getTestStgeName() {
		return testStgeName;
	}
	public void setTestStgeName(String testStgeName) {
		this.testStgeName = testStgeName;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public String getTestStartYMS() {
		return testStartYMS;
	}
	public void setTestStartYMS(String testStartYMS) {
		this.testStartYMS = testStartYMS;
	}
	public String getTestStartYMS2() {
		return testStartYMS2;
	}
	public void setTestStartYMS2(String testStartYMS2) {
		this.testStartYMS2 = testStartYMS2;
	}
	public String getTestEndYMS() {
		return testEndYMS;
	}
	public void setTestEndYMS(String testEndYMS) {
		this.testEndYMS = testEndYMS;
	}
	public String getTestEndYMS2() {
		return testEndYMS2;
	}
	public void setTestEndYMS2(String testEndYMS2) {
		this.testEndYMS2 = testEndYMS2;
	}
	public String getLastModfiEmpid() {
		return lastModfiEmpid;
	}
	public void setLastModfiEmpid(String lastModfiEmpid) {
		this.lastModfiEmpid = lastModfiEmpid;
	}
	public String getLastModfiYMS() {
		return lastModfiYMS;
	}
	public void setLastModfiYMS(String lastModfiYMS) {
		this.lastModfiYMS = lastModfiYMS;
	}
	public String getRmark() {
		return rmark;
	}
	public void setRmark(String rmark) {
		this.rmark = rmark;
	}
	public int getCntYn() {
		return cntYn;
	}
	public void setCntYn(int cntYn) {
		this.cntYn = cntYn;
	}
	
	
	
	
	public String getConnSevrDstcd() {
		return connSevrDstcd;
	}
	public void setConnSevrDstcd(String connSevrDstcd) {
		this.connSevrDstcd = connSevrDstcd;
	}
	public String getDefaultTest() {
		return defaultTest;
	}
	public void setDefaultTest(String defaultTest) {
		this.defaultTest = defaultTest;
	}
	public String getQaltyMgtProjNo() {
		return qaltyMgtProjNo;
	}
	public void setQaltyMgtProjNo(String qaltyMgtProjNo) {
		this.qaltyMgtProjNo = qaltyMgtProjNo;
	}
	public String getQaltyMgtProjName() {
		return qaltyMgtProjName;
	}
	public void setQaltyMgtProjName(String qaltyMgtProjName) {
		this.qaltyMgtProjName = qaltyMgtProjName;
	}
	public String getLoutURLAddr() {
		return loutURLAddr;
	}
	public void setLoutURLAddr(String loutURLAddr) {
		this.loutURLAddr = loutURLAddr;
	}
	public String getLginURLAddr() {
		return lginURLAddr;
	}
	public void setLginURLAddr(String lginURLAddr) {
		this.lginURLAddr = lginURLAddr;
	}
	public String getScrptRspnsWaitTtm() {
		return scrptRspnsWaitTtm;
	}
	public void setScrptRspnsWaitTtm(String scrptRspnsWaitTtm) {
		this.scrptRspnsWaitTtm = scrptRspnsWaitTtm;
	}

}
