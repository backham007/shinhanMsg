package com.igo.testro.msg.cmn.dto;

import com.igo.testro.dto.AbstractDTO;

/**
 * <p>
 * 프로그램명:PopMngUserDto.java<br/>
 * 설명 : 나의 프로젝트 관리<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 2. 29. : 노찬균 : 최초작성</li>
 * </ul> 
 * </p>
 */
public class PopMngUserDto extends AbstractDTO{
	//사용자ID
	private String usrID;
	//사용자 ID 체크
	private String userIdCheck;
	//사용자명
	private String usrName;
	//사용자비밀번호
	private String usrPWD;
	//사용자권한
	private String usrLevel;
	//신규,수정 여부
	private String newInsert;
	//최종변경일시
	private String lastModfiYMS;
	//최종변경자ID
	private String lastModfiId;
	
	
	public String getLastModfiId() {
		return lastModfiId;
	}
	public void setLastModfiId(String lastModfiId) {
		this.lastModfiId = lastModfiId;
	}
	public String getUsrID() {
		return usrID;
	}
	public void setUsrID(String usrID) {
		this.usrID = usrID;
	}
	
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	
	public String getUsrPWD() {
		return usrPWD;
	}	
	public void setUsrPWD(String usrPWD) {
		this.usrPWD = usrPWD;
	}
	
	public String getUsrLevel() {
		return usrLevel;
	}
	public void setUsrLevel(String usrLevel) {
		this.usrLevel = usrLevel;
	}
	
	public String getUserIdCheck() {
		return userIdCheck;
	}
	public void setUserIdCheck(String userIdCheck) {
		this.userIdCheck = userIdCheck;
	}
	
	public String getNewInsert() {
		return newInsert;
	}
	public void setNewInsert(String newInsert) {
		this.newInsert = newInsert;
	}
	public String getLastModfiYMS() {
		return lastModfiYMS;
	}
	public void setLastModfiYMS(String lastModfiYMS) {
		this.lastModfiYMS = lastModfiYMS;
	}
	
	
}
