package com.igo.testro.dto;

public class TestroLoginDTO extends AbstractDTO{
	private static final long serialVersionUID = 1L;
	
	private String usrid       ;//사용자id
	private String usrpwd      ;//패스워드
	private String usrname     ;//이름
	public String getUsrid() {
		return usrid;
	}
	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}
	public String getUsrpwd() {
		return usrpwd;
	}
	public void setUsrpwd(String usrpwd) {
		this.usrpwd = usrpwd;
	}
	public String getUsrname() {
		return usrname;
	}
	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}
}
