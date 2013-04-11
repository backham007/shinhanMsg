<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>전문 테스트로(TESTRO)</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" href="images/TESTRO.ico" type="image/ico" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url();
	background-repeat: repeat;
	background-color: #bebebe;
}

-->
</style></head>
<script type="text/javascript" src="jqgrid/js/jquery-1.5.2.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/jquery.blockUI.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/login.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/common.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/jquery.cookie.js" charset="utf-8"></script>


<script type="text/javascript">
$(document).ready(function(){
	$.cookie('top_menu', '', { expires: -1 });
	$.cookie('left_menu', '', { expires: -1 });
});
function loginCheck(){
	var usrid = trim(document.frm.usrid.value);
	var usrpwd =  trim(document.frm.usrpwd.value);
	if(usrid == ""){
		alert('아이디를 입력하세요.');
		document.frm.usrid.focus();
		return;
	}
	if(usrpwd == ""){
		alert('패스워드를 입력하세요.');
		document.frm.usrpwd.focus();
		return;
	}			

	
	if($("#checkbox").is(":checked")){
		setCookie("usrid", document.frm.usrid.value);
	}else{
		setCookie("usrid", "");
	}
	
	$.ajax({
	    type: "POST",
	    url:'cmn.login.excutelogin.do',
	    dataType:'json',
	    data:{"usrid":usrid,"usrpwd":usrpwd},
	    success: function(xhr){
		    
			//오류코드 처리
			if(xhr.errCd){
				alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
				return;
			}
			
	    	if("" != xhr.message && 'undefined' != xhr.message){ //로그인 오류 메세지
	    		alert(xhr.message);
	    		return;
	    	}
	    	
	    	var left = 0;
			var top = 0;
			var screenWidth = screen.availWidth;
			var screenHeight = screen.availHeight;
			
			var width, height;

			if(screenWidth <= 1024 || screenHeight <= 768){ // 1024 X 768
				width = 1020;
				height = 680;
			}else{	// 1280 X 1024
				width = 1276;
				height = 800;
			}
			
	    	var temp = xhr.userinfo;
	    	if("testro01" == temp.usrpwd){ //초기생성자의 경우 패스워드 변경을 꼭해야함.
	    		var url = "msg.popUserPass.popUserPass.do";
	    	    var returnValue = window.showModalDialog(url,window,'center:yes;dialogWidth=470px; dialogHeight=206px; scroll:no; status:no; help:no; resizable:no; location:no; ');
	    	    
	    	    if( "1" != returnValue ){//패스워드를 변경안하고 창을 닫으면 다음페이지로 이동불가.
	    	    	$.ajax({
	    				type : "POST",
	    				async : true,
	    				url : "cmn.login.excutelogout.do",
	    				success: function(data){

	    				}
	    			});
	    	    	return;
	    	    }
	    	}
	    	$.cookie('top_menu', 'top_menu_03');
	    	$(location).attr('href',"msg.myQalty.myQalty.do"); 
	    },
	    error: function (request, status, error) { 
	    	alert("로그인중에 오류가 발생하였습니다.[" + error + "]"); 
	    }
	});
}
</script>
<body onload="loadpage();">
<form name = "frm" action="#" method="post">
<div align="center">
  <table width="747" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td colspan="4"><img src="images/login_01.jpg" width="747" height="208"></td>
    </tr>
    <tr>
      <td height="303" rowspan="2"><img src="images/login_02_01.jpg" width="85" height="303"></td>
      <td rowspan="2"><img src="images/login_02_02.jpg" width="236" height="303"></td>
      <td width="307"><img src="images/login_logo_message.jpg" width="307" height="138"></td>
      <td rowspan="2"><img src="images/login_02_04.jpg" width="119" height="303"></td>
    </tr>
    <tr>
      <td height="165" valign="top" style="text-align: " background="images/login_input_bg.jpg">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="51" colspan="3">&nbsp;</td>
        </tr>
        <tr>
          <td><img src="images/login_input_02.jpg" width="85" height="22" /></td>
          <td width="133"><input name="usrid" id="usrid" maxlength="30" type="text" class="login_input" style="width:120px;ime-mode:disabled;" onkeydown="if(event.keyCode ==13){javascript:loginCheck();}" /></td>
          <td rowspan="2" width="87"><a style="cursor: pointer; " onclick="javascript:loginCheck();"><img src="images/login_input_04.jpg" width="69" height="40" style="border:0px"/></a></td>
        </tr>
        <tr>
          <td><img src="images/login_input_03.jpg" width="85" height="22" /></td>
          <td><input name="usrpwd" id="usrpwd" type="password" maxlength="30" class="login_input" style="width:120px;ime-mode:disabled;" onkeydown="if(event.keyCode ==13){javascript:loginCheck();}"/></td>
          </tr>
        <tr>
          <td colspan="3">&nbsp;</td>
        </tr>
        <tr>
          <td colspan="3" align="right"><label>
            <input type="checkbox" name="checkbox" id="checkbox">
            <img src="images/login_save.jpg" width="82" height="17" vspace="5" align="absmiddle"></label></td>
        </tr>
      </table>
      <span  class="point_text">*TestRo는 화면 해상도 1280*1024에 최적화 되어 있습니다.</span>
      </td>
    </tr>
    
    <tr>
      <td colspan="4"><img src="images/login_03.jpg" width="747" height="115"></td>
    </tr>
  </table>
</div>
</form>
</body>
</html>

