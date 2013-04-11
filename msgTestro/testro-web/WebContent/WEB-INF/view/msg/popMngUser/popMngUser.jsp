<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
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
//창 띄울때 레벨에 따라서 보이고 안보이고, 수정이냐 신규에 따라 화면 변경
function insertYN()
{
	var newInsert = '${newSave}';
	var usrID = '${usrID}';
	var usrName = '${usrName}';
	var usrLevel = '${usrLevel}';
	var sessionLevel = '${lastModfiEmpLevel}';
	
	
	if(sessionLevel == "01"){				//레벨 01일때 화면
		getListMngCode('mgrLvelDstcd','USRLEVEL','03');
	}else if(sessionLevel == "02"){			//레벨 02일때 화면
		getListMngCode('mgrLvelDstcd','USRLEVEL2','03');
	}
	
	if(newInsert == "Y"){					//신규일때 화면
		$("#userid").attr("readonly",false);
		$("#userInsert").show();
		$("#userUpdate").hide();
		$("#clearButton").hide();
	}else{									//수정일떄 화면
		$("#userid").val(usrID);
		$("#username").val(usrName);
		$("#mgrLvelDstcd").val(usrLevel);
		$("#userid").attr("disabled",true);
		$("#userInsert").hide();
		$("#userUpdate").show();
		$("#clearButton").show();
		$("#idCheck").hide();
	}
}
//사용자 ID 중복 체크
function doCheck(){
	var userid = $("#userid").val();
	if(userid == ""){
		alert("사용자ID를 입력해주세요.");
		return false;
	}
	$.blockUI(); //block시작
	$.ajax({
        type:"POST",
		data:{"usrID":$("#userid").val()},
        dataType:"json",
        async : true,
        url:"msg.checkMngUser.popMngUser.do",
        success:function(data, status) {
        	if (data.errCd){
	        	alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
        	}else{
	            if(data.check == "1"){
	            	alert("입력하신 사용자 ID는 이미 사용중입니다.");
	            	$.unblockUI(); //block시작
	            	return false;
	            }else{
	            	alert("사용 가능한 아이디 입니다.");
	            	$.unblockUI(); //block시작
	            	return false;
	            }
        	}
        },
        error:function(request, status, error) {
        	alert("사용자 ID 중복확인중에 오류가 발생하였습니다.[" + error + "]"); 
        	$.unblockUI(); //block시작
        	return false;
        }
    });
	
}
//사용자 비밀번호 초기화
function doClear(){
	var userid = $("#userid").val();
	var username = $("#username").val();
	//사용자ID 입력 체크
	if(userid==""){
		alert("사용자 ID를 입력해주세요");
		return false;
	}
	//사용자명 입력체크
	if(username==""){
		alert("사용자명을 입력해주세요");
		return false;
	}
	$.blockUI(); //block시작
	$.ajax({
        type:"POST",
		data:{"usrID":$("#userid").val(),
			"usrName":$("#username").val()},
        dataType:"json",
        async : true,
        url:"msg.clearMngUser.popMngUser.do",
        success:function(data, status) {
        	if (data.errCd){
	        	alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
        	}else{
	            if(data.clearCheck == "1"){
	           		alert("비밀번호가 'testro01'초기화 되었습니다.");
	           		$.unblockUI(); //block시작
	           		return false;
	            }else{
	            	alert("사용자 ID/명이 잘못 되었습니다.");
	            	$.unblockUI(); //block시작
	            	return false;
	            }
        	}
        },
        error:function(request, status, error) {
        	alert("비밀번호 초기화중에 오류가 발생하였습니다.[" + error + "]"); 
        	$.unblockUI(); //block시작
        	return false;
        }
    });
	
}
//사용자 아이디 저장 및 수정
function doSave(){
	var userid = $("#userid").val();						//사용자id
	var username = $("#username").val();					//사용자 name
	var mgrLvelDstcd = $("#mgrLvelDstcd").val();			//권한
	var newInsert = '${newSave}';							//저장, 수정 구분
	var sessionId = '${sessionScope.userinfo.usrid}';		//세션 id
	if(userid==""){
		alert("사용자 ID를 입력해주세요.");
		return false;
	}
	if(username==""){
		alert("사용자 명을 입력해주세요.");
		return false;
	}
	if(mgrLvelDstcd=="00"){
		alert("사용자 권한을 선택해주세요.");
		return false;
	}
	$.blockUI(); //block시작
	$.ajax({
        type:"POST",
		data:{"usrID":$("#userid").val(),
			"usrName":$("#username").val(),
			"usrLevel":$("#mgrLvelDstcd").val(),
			"newInsert":newInsert,
			"sessionId":sessionId},
        dataType:"json",
        async : true,
        url:"msg.saveMngUser.popMngUser.do",
        success:function(data, status) {
        	if (data.errCd){
	        	alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
        	}else{
	            if(data.userIdSave == "1"){							//사용중일경우
	            	alert("입력하신 사용자 ID는 이미 사용중입니다.");
	            	$.unblockUI(); //block시작
	           		return false;
	            }else if(data.userIdSave =="2"){					//비밀번호가 잘못되었을경우
	            	alert("비밀번호가 잘못되었습니다.");
	            	$.unblockUI(); //block시작
	            	return false;
	            }else{
	                if(data.newInsert == "Y"){						//사용자 정보 등록일 경우
		            	alert("다음과 같이 신규 사용자가 등록되었습니다.\r\n\r\n사용자 ID : "+userid+"\r\n사용자 명 : "+username);
		            	$.unblockUI(); //block시작
		            	window.returnValue = 1;
		            	doClose();
	                }else{
	                	alert("사용자 정보가 변경되었습니다.");		//사용자 정보 변경일 경우
	                	$.unblockUI(); //block시작
	                	window.returnValue = 1;
	                	doClose();
	                }
	            }
        	}
        },
        error:function(request, status, error) {
        	alert("사용자 아이디 저장중에 오류가 발생하였습니다.[" + error + "]"); 
        	$.unblockUI(); //block시작
        	return false;
        }
    });
	
}
//창 닫기
function doClose(){
	window.close();	
}
</script>
</head>

<body leftmargin="0" topmargin="0" onLoad="insertYN()">
	<form name="frm" id="frm" method="post">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		    <td width="43"><img src="images/pop_tit_01.gif" width="43" height="51"></td>
		    <td background="images/pop_tit_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
		      <tr>
		        <td class="pop_tit">사용자 관리</td>
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
		                            <td width="70" class="box_txt_red">사용자 ID :</td>
		                            <td ><input name="userid" id="userid" type="text" class="input_topinq" style="width:220px;ime-mode:disabled;" maxlength="30" onpaste="javascript:return false;"></td>
		                            <td width="90"><table border="0" cellpadding="0" cellspacing="0">
		                              <tr id ="idCheck">
		                                <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
		                                <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="doCheck(); return false;">ID중복확인</td>
		                                <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
		                              </tr>
		                            </table></td>
		                          </tr>
		                          <tr>
		                            <td class="box_txt_red">사용자 명 :</td>
		                            <td colspan="2"><input name="username" id="username" type="text" class="input_topinq" style="width:220px" maxlength="15"></td>
		                            </tr>
		                          <tr>
		                            <td class="box_txt">비밀번호 :</td>
		                            <td id="userInsert" >* 초기 비밀번호는 "testro01"입니다.</td>
		                            <td id="userUpdate" >* 비밀번호 초기화 하실려면 오른쪽 버튼을 눌러주세요.</td>
		                            <td>
		                            <table border="0" cellpadding="0" cellspacing="0">
		                              <tr id="clearButton">
		                                <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
		                                <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="doClear(); return false;">초기화</td>
		                                <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
		                              </tr>
		                            </table></td>
		                          </tr>
		                          <tr>
		                            <td class="box_txt_red">권&nbsp;&nbsp;&nbsp;&nbsp;한 :</td>
		                            <td colspan="2">
		                            <select name="mgrLvelDstcd" id="mgrLvelDstcd" class="menu" style="width:120px">
		                            </select>
		                            </td>
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
		                  <td><table align="left" border="0" cellpadding="0" cellspacing="0">
		                    <tr>
		                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
		                      <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="doSave(); return false;" >저 장</td>
		                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
		                    </tr>
		                  </table></td>
		                  <td ><table align="right" border="0" cellpadding="0" cellspacing="0">
		                        <tr>
		                          <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
		                          <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="doClose(); return false;">닫 기</td>
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
	</form>
<!-- Start of wrap -->
</body>
</html>