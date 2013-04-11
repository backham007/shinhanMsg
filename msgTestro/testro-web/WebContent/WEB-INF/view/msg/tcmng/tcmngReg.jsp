<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전문 테스트로(TESTRO)</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" href="images/TESTRO.ico" type="image/ico" />

<script type="text/javascript" src="jqgrid/js/jquery-1.5.2.min.js" charset="utf-8"></script>


<script>
var opener = window.dialogArguments;

var tsCaseID		= opener.document.frmname.tsCaseID.value;
var tsCaseName		= opener.document.frmname.tsCaseName.value;
var tsCaseDesc		= opener.document.frmname.tsCaseDesc.value;



$(document).ready(function(){

	if(tsCaseID == ""){
		$("#newNameReg").attr("disabled", "disabled");
	}
	
	$("#tsCaseID").html(tsCaseID);
	$("#tsCaseName").val(tsCaseName);
	$("#tsCaseDesc").val(tsCaseDesc);

	$("#newNameReg").click(function(){
		if($("#tsCaseName").val() == ""){
			$("#tsCaseName").focus();
			alert("테스트케이스명은 필수 입력 항목입니다.");
			return;
		}else if($("#tsCaseDesc").val() == ""){
			$("#tsCaseDesc").focus();
			alert("테스트케이스설명은 필수 입력 항목입니다.");
			return;
		}

		var list = new Array();
		list[0] = "";
		list[1] = $("#tsCaseName").val();
		list[2] = $("#tsCaseDesc").val();

		
		window.returnValue = list;
		self.close();
	});

	$("#nameReg").click(function(){
		if($("#tsCaseName").val() == ""){
			$("#tsCaseName").focus();
			alert("테스트케이스명은 필수 입력 항목입니다.");
			return;
		}else if($("#tsCaseDesc").val() == ""){
			$("#tsCaseDesc").focus();
			alert("테스트케이스설명은 필수 입력 항목입니다.");
			return;
		}

		var list = new Array();
		list[0] = tsCaseID;
		list[1] = $("#tsCaseName").val();
		list[2] = $("#tsCaseDesc").val();

		window.returnValue = list;
		self.close();
	});

	$("#close").click(function(){
		self.close();
	});
	
	
});
</script>


</head>

<body leftmargin="0" topmargin="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="43"><img src="images/pop_tit_01.gif" width="43" height="51"></td>
    <td background="images/pop_tit_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="pop_tit">테스트케이스 저장</td>
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
                            <td width="120" class="box_txt_red">테스트케이스 ID:</td>
                            <td id="tsCaseID">&nbsp;</td>
                            </tr>
                          <tr>
                            <td class="box_txt_red">테스트케이스 명:</td>
                            <td><input id="tsCaseName" type="text" class="input_topinq" style="width:100%"></td>
                            </tr>
                          <tr>
                            <td class="box_txt_red">테스트케이스 설명 :</td>
                            <td><input id="tsCaseDesc" type="text" class="input_topinq" style="width:100%"></td>
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
                      <td id="newNameReg" background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer">다른이름으로 저장</td>
                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                    </tr>
                  </table>
                  <table align="left" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                      <td id="nameReg" background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer">저 장</td>
                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                    </tr>
                  </table></td>
                  <td ><table align="right" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                          <td id="close" background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer">닫 기</td>
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
</body>

</html>