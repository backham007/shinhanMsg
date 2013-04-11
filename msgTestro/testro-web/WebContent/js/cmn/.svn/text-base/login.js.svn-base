//아이디 정보 쿠키에 저장
function setCookie(name, value) {
    var today = new Date();
    var expire = new Date(today.getTime() + 60*60*24*5*1000);
    document.cookie = name + "=" + escape(value) + "; expires=" + expire.toGMTString();
}
 
//아이디 쿠키에서 불러오기
function getCookie(uName) {
	var flag = document.cookie.indexOf(uName+'=');
	if (flag != -1) { 
		flag += uName.length + 1;
		end = document.cookie.indexOf(';', flag); 
	
		if (end == -1) end = document.cookie.length;
		return unescape(document.cookie.substring(flag, end));
	}
}

function loadpage(){
	//쿠키에 저장된아이디 정보 가져오기
	var usrid = getCookie("usrid");
	//저장된 아이디 정보가 있다면 필드에 기본 세팅
	if(usrid!=null&&usrid!=undefined&&usrid!="") {
		document.frm.usrid.value=usrid;
		document.frm.checkbox.checked=true;
		document.frm.usrpwd.focus();
	} else {	//쿠키에 아이디 정보가 없을 경우 아이디 필드에 기본 포커스
		document.frm.usrid.focus();
	}
}

