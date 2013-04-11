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
<script type="text/javascript">

//창 띄울때 레벨에 따라서 보이고 안보이고, 수정이냐 신규에 따라 화면 변경
function insertYN()
{
	//기본 값들
	var projectNo = '${projNo}';
	var projectName = '${projName}';
	var projectStep = '${TestStgeName}';
	var startDate = '${startDate}';
	var endDate = '${endDate}';
	var newSave = '${newSave}';
	//달력 필드 입력 불가
	$("#startDate").attr("readonly",true);
	$("#endDate").attr("readonly",true);
	//수정일 경우
	if(newSave == "N"){				
		$("#projectNo").val(projectNo);
		$("#projectName").val(projectName);
		$("#projectStep").val(projectStep);
		$("#startDate").val(startDate);
		$("#endDate").val(endDate);
		$("#projectNo").attr("disabled",true);
		$("#projectStep").attr("disabled",true);
		$("#Check").hide();
		$("#titleName").text('나의 프로젝트 수정');
	}
}
// iframe resize
function autoResize(i)
{
    var iframeHeight=
    (i).contentWindow.document.body.scrollHeight;
    (i).height=iframeHeight+20;
}
// 프로젝트 번호, 단계 체크 
function projectStepCheck(){
	var projectNo = $("#projectNo").val();
	var projectStep = $("#projectStep").val();
	if(projectNo  == ""){
		alert("프로젝트 번호를 입력해 주세요.");
		frm.projectNo.focus();
		return false;
	}
	if(projectStep  == ""){
		alert("테스트단계를 입력해 주세요.");
		frm.projectStep.focus();
		return false;
	}
	$.blockUI(); //block시작
	$.ajax({
        type:"POST",
		data:{
			"projectNo": projectNo,
			"projectStep":projectStep
		},
        dataType:"json",
        async : true,
        url:"msg.projectStepCheckMngUser.popMyQalty.do",
        success:function(data, status) {
        	if (data.errCd){
	        	alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
	        	$.unblockUI(); //block시작
        	}else{
	            if(data.check == "1"){												//같은 프로젝트 번호에 동일한 테스트 단계가 있을경우
	            	alert(projectNo+"의 프로젝트에 동일한 테스트 단계가 있습니다.");
	            	$.unblockUI(); //block시작
	            	return false;
	            }else{																//사용가능할 경우
	            	alert("사용 가능한 테스트 단계입니다.");
	            	$.unblockUI(); //block시작
	            	return false;
	            }
        	}
        },
        error:function(request, status, error) {
        	alert("테스트 단계 중복확인중에 오류가 발생하였습니다.[" + error + "]"); 
        	$.unblockUI(); //block시작
        	return false;
        }
    });
	
}
//프로젝트 저장
function projSave(){
	
	var projectNo = $("#projectNo").val();
	var projectName = $("#projectName").val();
	var projectStep = $("#projectStep").val();
	var startDate = $("#startDate").val();
	var endDate = $("#endDate").val();
	var newInsert = '${newSave}';					//구분자
	var usrid = '${sessionScope.userinfo.usrid}';    //사용자id
	if(projectNo  == ""){
		alert("프로젝트 번호를 입력해 주세요.");
		frm.projectNo.focus();
		return false;
	}
	if(projectName  == ""){
		alert("프로젝트명을 입력해 주세요.");
		frm.projectName.focus();
		return false;
	}
	if(projectStep  == ""){
		alert("테스트단계명을 입력해 주세요.");
		frm.projectStep.focus();
		return false;
	}
	if(startDate == ""){
		alert("시작일을 설정해주세요.");
		frm.startDate.focus();
		return false;
	}
	if(endDate == ""){
		alert("종료일을 설정해주세요.");
		frm.endDate.focus();
		return false;
	}
	if(startDate > endDate){
		alert("시작일이 종료일보다 큽니다.");
		frm.endDate.focus();
		return false;
	}
	$.blockUI(); //block시작
	$.ajax({
        type:"POST",
		data:{"usrId": usrid,
			"projNo":projectNo,
			"projName":projectName,
			"TestStgeName":projectStep,
			"startDate":startDate,
			"endDate":endDate,
			"newInsert":newInsert
			},
        dataType:"json",
        async : true,
        url:"msg.saveMyQalty.popMyQalty.do",
        success:function(data, status) {
        	if (data.errCd){
	        	alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
	        	$.unblockUI(); //block시작
        	}else{
	            if(data.userIdSave == "1"){											//중복일 경우
	            	alert(projectNo+"의 프로젝트에 동일한 테스트 단계가 있습니다.");
	            	$.unblockUI(); //block시작
	           		return false;
	            }else  if(data.userIdSave == "2"){									//수정했을 경우
	            	alert("프로젝트 정보가 수정되었습니다.");
	            	$.unblockUI(); //block시작
	            	window.returnValue = 1;
	            	doClose();
	            }else{																//저장 했을 경우
	            	alert("프로젝트 정보가 저장되었습니다.");
	            	$.unblockUI(); //block시작
	            	window.returnValue = 1;
	            	doClose();
	            }
        	}
        },
        error:function(request, status, error) {
        	alert("테스트 단계 중복확인중에 오류가 발생하였습니다.[" + error + "]"); 
        	$.unblockUI(); //block시작
        	return false;
        }
    });
}
//창 닫기
function doClose(){
	window.close();	
}
//값 초기화
function doClear(){ 
	$("#startDate").val("");
	$("#endDate").val("");
}

</script>
</head>

<body leftmargin="0" topmargin="0" onLoad="insertYN()">
<form name="frm" method="post">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td width="43"><img src="images/pop_tit_01.gif" width="43" height="51"></td>
	    <td background="images/pop_tit_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td id="titleName" class="pop_tit">나의 프로젝트 등록</td>
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
                            <td width="95" class="box_txt_red">프로젝트 번호 :</td>
                            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                  <td width="120"><input name="projectNo" id="projectNo" type="text" class="input_topinq" style="width:230px;ime-mode:disabled;" maxlength="20" onpaste="javascript:return false;"></td>
                                </tr>
                              </table></td>
                            </tr>
                          <tr>
                            <td class="box_txt_red">프로젝트 명 :</td>
                            <td><input name="projectName" id="projectName" type="text" class="input_topinq" style="width:230px" maxlength="60"></td>
                            </tr>
                          <tr>
                            <td class="box_txt_red">테스트 단계 :</td>
                            <td>
                            	<table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                	<td width="120"><input name="projectStep" id="projectStep" type="text" class="input_topinq" style="width:230px" maxlength="20"></td>
                                	<td>
                              <table border="0" cellpadding="0" cellspacing="0">
                                <tr id="Check">
                                  <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                  <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="projectStepCheck(); return false;">중복확인</td>
                                  <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                </tr>
                              </table>
                            </td>
                            	</tr>
                              </table>
                             </td>
                             
                          </tr>
                          <tr>
                            <td class="box_txt_red">테스트 기간 :</td>
                            <td><input id="startDate" name="startDate" type="text" class="input_topinq" style="width:65px">
                              <img src="images/un_sub_cen_cal.gif" alt="달력" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer" onclick="popUpCalendar(this, 'startDate', 'yyyy-mm-dd','CENTER','MIDDLE');"> ~
                              <input id="endDate" name="endDate" type="text" class="input_topinq" style="width:65px">
                              <img src="images/un_sub_cen_cal.gif" alt="달력" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer" onclick="popUpCalendar(this, 'endDate', 'yyyy-mm-dd','CENTER','MIDDLE');">
                              <img src="images/btn_eraser.gif" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer" onclick="doClear();">
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
                  <td><table border="0" align="left" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                        <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="projSave(); return false;">저 장</td>
                        <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                      </tr>
                  </table>
                    </td>
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