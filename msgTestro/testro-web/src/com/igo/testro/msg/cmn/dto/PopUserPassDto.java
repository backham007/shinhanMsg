package com.igo.testro.msg.cmn.dto;

/**
 * <p>
 * 프로그램명:PopUserPassDto.java<br/>
 * 설명 : 비밀번호 변경<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */

public class PopUserPassDto {
	//사용자ID
	private String usrID;
	//기존 비밀번호
	private String oldPass;
	//신규 비밀번호
	private String newPass1;
	//신규 비밀번호 확인
	private String newPass2;
	//최종변경자ID
	private String lastModfiEmpid;
	//최종변경일시
	private String lastModfiYMS;
	
	
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
	public String getUsrID() {
		return usrID;
	}
	public void setUsrID(String usrID) {
		this.usrID = usrID;
	}
	public String getOldPass() {
		return oldPass;
	}
	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}
	public String getNewPass1() {
		return newPass1;
	}
	public void setNewPass1(String newPass1) {
		this.newPass1 = newPass1;
	}
	public String getNewPass2() {
		return newPass2;
	}
	public void setNewPass2(String newPass2) {
		this.newPass2 = newPass2;
	}
	
}
