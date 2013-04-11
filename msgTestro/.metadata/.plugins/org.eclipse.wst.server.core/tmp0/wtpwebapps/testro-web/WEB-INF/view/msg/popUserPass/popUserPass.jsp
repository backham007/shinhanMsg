<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>전문 테스트로(TESTRO)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="jqgrid/css/ui-lightness/jquery-ui-1.7.3.custom.css" media="screen" />
<link rel="stylesheet" type="text/css" href="jqgrid/js/src/css/ui.jqgrid.css" media="screen" />
<link rel="shortcut icon" href="images/TESTRO.ico" type="image/ico" />
<style>
html, body {
    margin: 0;
    padding: 0;
    font-size: 75%;
}
</style>
<script type="text/javascript" src="jqgrid/js/jquery-1.5.2.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/jquery.blockUI.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/src/i18n/grid.locale-en.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/jquery.jqGrid.src.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/popupcalendar.js"></script>
<script type="text/javascript" src="js/cmn/util.js" charset="utf-8"></script>
<script type="text/javascript">
// iframe resize
function autoResize(i)
{
    var iframeHeight=
    (i).contentWindow.document.body.scrollHeight;
    (i).height=iframeHeight+20;
}
function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}
//비밀번호 저장
function doPassSave(){
	var usrID = '${sessionScope.userinfo.usrid}';    //사용자id
	var oldPass = $("#oldPass").val();
	var newPass1 = $("#newPass1").val();
	var newPass2 = $("#newPass2").val();
	if(oldPass == ""){
		alert("기존 비밀번호를 입력하세요");
		frm.oldPass.focus();
		return false;
	}
	if(newPass1 == ""){
		alert("신규 비밀번호를 입력하세요");
		frm.newPass1.focus();
		return false;
	}
	if(newPass1.length < 5){
		alert("비밀번호는 5자 이상입니다.");
		frm.newPass1.focus();
		return false;
	}
	if(newPass2 == ""){
		alert("신규 비밀번호확인을 입력하세요");
		frm.newPass2.focus();
		return false;
	}
	if(newPass1 != newPass2){
		alert("신규 비밀번호가 확인과 동일하지 않습니다.");
		frm.newPass1.focus();
		return false;
	}
	$.blockUI(); //block시작
	$.ajax({
        type:"POST",
		data:{
			"usrID":usrID,
			"oldPass":$("#oldPass").val(),
			"newPass1":$("#newPass1").val(),
			"newPass2":$("#newPass2").val()
		},
        dataType:"json",
        async : true,
        url:"msg.userPassSave.popUserPass.do",
        success:function(data, status) {
        	if (data.errCd){
	        	alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
	        	$.unblockUI(); //block시작
        	}else{
	            var intupdate = data.intupdate;
	            if(intupdate == 1){								//비밀번호가 변경 되었을 경우
					alert("비밀번호가 변경되었습니다.");
					$.unblockUI(); //block시작
					window.returnValue = intupdate;
					window.close();
	            }else{											//비밀번호가 틀리게 입력한 경우
	            	alert("기존 비밀번호가 틀립니다.");
	            	$.unblockUI(); //block시작
	            	return false;
	            }
        	}
        },
        error:function(request, status, error) {
        	alert("비밀번호 변경중에 오류가 발생하였습니다.[" + error + "]"); 
        	$.unblockUI(); //block시작
        	return false;
        }
    });
}
</script>
</head>

<body leftmargin="0" topmargin="0">
<form name="frm" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="43"><img src="images/pop_tit_01.gif" width="43" height="51"></td>
    <td background="images/pop_tit_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="pop_tit">비밀번호 변경</td>
      </tr>
    </table></td>
    <td width="216"><img src="images/pop_tit_03.gif" width="216" height="51"></td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="3">
  <tr>
    <td valign="top"><table width="100%" height="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#baccdc">
      <tr>
        <td bgcolor="#e1e9f0"><table width="100%" height="100%" border="0" cellpadding="5" cellspacing="0">
          <tr>
            <td valign="top" bgcolor="#FFFFFF"><table width="100%" border="0" cellpadding="5" cellspacing="1"  bgcolor="#baccdc">
              <tr>
                <td bgcolor="#e1e9f0"><table width="100%" border="0" cellspacing="0" cellpadding="5">
                    <tr>
                      <td bgcolor="#FFFFFF"><table width="100%" border="0" cellpadding="2" cellspacing="0">
                          <tr>
                            <td width="130" class="box_txt_red">기존 비밀번호 :</td>
                            <td><input name="oldPass" id="oldPass" type="password" class="input_topinq" style="width:200px" maxlength="15" onpaste="javascript:return false;"></td>
                            </tr>
	                         <tr>
		                     	<td height="5" colspan="3"></td>
		                     </tr>
                          <tr>
                            <td class="box_txt_red">신규 비밀번호 :</td>
                            <td><input name="newPass1" id="newPass1"type="password" class="input_topinq" style="width:200px" maxlength="15" onpaste="javascript:return false;">
                              <span class="point_result">(5자 이상)</span></td>
                            </tr>
                          <tr>
                            <td class="box_txt_red">신규 비밀번호 확인 :</td>
                            <td><input name="newPass2" id="newPass2" type="password" class="input_topinq" style="width:200px" maxlength="15" onpaste="javascript:return false;"></td>
                          </tr>
                        </table>
                          </td>
                    </tr>
                </table></td>
              </tr>
            </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="5" colspan="3"></td>
                </tr>
                <tr>
                  <td><table border="0" align="left" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                        <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="doPassSave(); return false;" >저 장</td>
                        <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                      </tr>
                  </table>
                    </td>
                  <td ><table align="right" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                          <td background="images/btn_img_02.gif" class="btn_text" style="cursor: pointer;" onclick="window.close(); return false;">닫 기</td>
                          <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                        </tr>
                      </table>
                    </td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
<!-- Start of wrap -->
</form>
</body>
</html>