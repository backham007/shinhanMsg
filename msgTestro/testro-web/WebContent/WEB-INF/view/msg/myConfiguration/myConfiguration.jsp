<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<jsp:include page="/WEB-INF/view/cmn/common.jsp" flush="true"></jsp:include>
<html>
<head>
<title>전문 테스트로(TESTRO)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="jqgrid/css/ui-lightness/jquery-ui-1.7.3.custom.css" media="screen" />
<link rel="stylesheet" type="text/css" href="jqgrid/js/src/css/ui.jqgrid.css" media="screen" />
<link rel="stylesheet" type="text/css" href="jqgrid/themes/ui.datepicker.css" media="screen" />
<link rel="shortcut icon" href="images/TESTRO.ico" type="image/ico" />
<style>
html, body {
    margin: 0;
    padding: 0;
    font-size: 75%;
}
</style>
<script type="text/javascript" src="js/cmn/utils/json2.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/jquery-1.5.2.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/jquery.blockUI.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/src/i18n/grid.locale-en.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/jquery.jqGrid.src.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/ui.datepicker.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/popupcalendar.js"></script>
<script type="text/javascript" src="js/cmn/util.js" charset="utf-8"></script>
<script type="text/javascript">
	
	$(window).trigger('resize');
	function bodyreload(){
		var hidenYn = $("body").attr("hideYn");
		if("Y" == hidenYn){ //left 메뉴 hidden
			leftTemp=40;
		}else{ //left 메뉴 show
			leftTemp=230;
		}
		$(window).trigger('resize');
	}

	//<!--
	function MM_swapImgRestore() { //v3.0
		var i, x, a = document.MM_sr;
		for (i = 0; a && i < a.length && (x = a[i]) && x.oSrc; i++)
			x.src = x.oSrc;
	}
	function MM_preloadImages() { //v3.0
		var d = document;
		if (d.image) {
			if (!d.MM_p)
				d.MM_p = new Array();
			var i, j = d.MM_p.length, a = MM_preloadimage.arguments;
			for (i = 0; i < a.length; i++)
				if (a[i].indexOf("#") != 0) {
					d.MM_p[j] = new Image;
					d.MM_p[j++].src = a[i];
				}
		}
	}

	function MM_findObj(n, d) { //v4.01
		var p, i, x;
		if (!d)
			d = document;
		if ((p = n.indexOf("?")) > 0 && parent.frames.length) {
			d = parent.frames[n.substring(p + 1)].document;
			n = n.substring(0, p);
		}
		if (!(x = d[n]) && d.all)
			x = d.all[n];
		for (i = 0; !x && i < d.forms.length; i++)
			x = d.forms[i][n];
		for (i = 0; !x && d.layers && i < d.layers.length; i++)
			x = MM_findObj(n, d.layers[i].document);
		if (!x && d.getElementById)
			x = d.getElementById(n);
		return x;
	}

	function MM_swapImage() { //v3.0
		var i, j = 0, x, a = MM_swapImage.arguments;
		document.MM_sr = new Array;
		for (i = 0; i < (a.length - 2); i += 3)
			if ((x = MM_findObj(a[i])) != null) {
				document.MM_sr[j++] = x;
				if (!x.oSrc)
					x.oSrc = x.src;
				x.src = a[i + 2];
			}
	}
	function MM_openBrWindow(theURL, winName, features) { //v2.0
		window.open(theURL, winName, features);
	}
	//-->

	// iframe resize
	function autoResize(i) {
		var iframeHeight = (i).contentWindow.document.body.scrollHeight;
		(i).height = iframeHeight + 20;
	}
	$(document).ready(function() {
		var connSevrDst = '${sessionScope.userinfo.connsevrdstcd}';
		$("#connSevrDstcd").val(connSevrDst);
	});

	//테스트 환경설정 저장
	function doEnviSave() {
		
		var frm = document.frm3;
		var useEmpid ='${sessionScope.userinfo.usrid}';
		var connSevrDstcdName = $("#connSevrDstcd > :selected").html();;
		//접속서버 없으면 저장 불가
		if (frm.connSevrDstcd.value == "") {
			alert("테스트 대상 시스템를 지정하세요.");
			frm.connSevrDstcd.focus();
			return;
		}
		if(confirm("테스트환경을 설정하시겠습니까?")){
			$.ajax({
		        type:"POST",
				data:{
					"connSevrDstcdnm":connSevrDstcdName,
					"connSevrDstcd":frm.connSevrDstcd.value,
		    		"usrId":useEmpid},
		        dataType:"json",
		        async : true,
		        url:"msg.RegisterTestEnviAction.myQalty.do",
		        success:function(data, status) {
		        	if (data.errCd){
			        	alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
						$('#list1').trigger('reloadGrid');
		        	}else{
				        alert("테스트 대상 시스템을 다음과 같이 설정하셨습니다.\r\n\r\n대상 시스템 : "+connSevrDstcdName);
			        	reload();
		        	}
		        },
		        error:function(request, status, error) {
		        	alert("테스트 대상 시스템 설정중에 오류가 발생하였습니다.[" + error + "]"); 
		        }
		    });
		}
	}
	//화면 재 출력
	function reload(){
		location.href="msg.myConfiguration.myConfiguration.do";
	}
	//사용자 비밀번호 변경
	function passChacnge(){
		var url = "msg.popUserPass.popUserPass.do";
	    var returnValue = window.showModalDialog(url,window,'center:yes;dialogWidth=470px; dialogHeight=206px; scroll:no; status:no; help:no; resizable:no; location:no; ');
	}		
</script>
</head>
<body bgcolor="#FFFFFF" background="images/left_menu_bg.jpg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >

<div id="Minwidth">
        <div id="Page">
            <div id="contents">
            <!-- top menu 시작 --> 
			<jsp:include page="/WEB-INF/view/cmn/topMenu.jsp" flush="true"></jsp:include>
            <!-- top menu 끝 -->   
            
                <table width="100%" border="0" cellpadding="0" cellspacing="0" id="Table_01">
                    <tr> 
						<!-- left menu 시작 -->
						<jsp:include page="/WEB-INF/view/cmn/leftMenu.jsp" flush="true"></jsp:include>
						<!-- left menu 끝 -->
                        <td valign="top">
                            <table width="100%" height="100%" border="0" cellpadding="15" cellspacing="0">
                                <tr> 
                                  <td valign="top">
                                  <table border=0 cellpadding=0 cellspacing=0 width=100%>
                                    <tr>
                                      <td width="20"><img src="images/title_bullet1.gif"></td>
                                      <td width="175" class="sub_tit">테스트 대상 시스템 설정</td>
                                      <td valign="bottom" class="point_text" id="flowMsg" > 테스트 대상 시스템을 설정 할 수 있습니다.</td>
                                    </tr>
                                    <tr >
                                      <td background="images/tit_line_bg.gif" height="6" colspan="3"><img src="images/tit_line_bg.gif"></td>
                                    </tr>
                                    <tr >
                                      <td height="10" colspan="3"></td>
                                    </tr>
                                  </table>
                            <form name="frm3" method="post">
							<input type="hidden" id="strCd" name="strCd" />
							<input type="hidden" id="strNm" name="strNm" />
                                    <table width="100%" border="0" cellspacing="0" cellpadding="1">
                                      <tr>
                                        <td class="sub_tit02">테스트 환경 설정</td>
                                      </tr>
                                    </table>
                                    <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#baccdc">
                                      <tr>
                                        <td bgcolor="#e1e9f0"><table width="100%" border="0" cellspacing="0" cellpadding="5">
                                            <tr>
                                              <td bgcolor="#FFFFFF">
                                                <table width="100%" border="0" cellspacing="0" cellpadding="2">
                                                    <tr>
                                                        <td width="130" class="box_txt">테스트 대상 시스템 :</td>
                                                        <td>
                                                          <select name="connSevrDstcd"  id="connSevrDstcd" class="menu" style="width:140px">
                                                          	<c:forEach var="list" items="${mciArray}" varStatus="status">
						                                        <option value="${list.key}" >${list.val}</option>
                                                            </c:forEach>
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
                                        <td height="5"></td>
                                      </tr>
                                      <tr>
                                        <td height="10">
                                        <table border="0" align="right" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                              <td background="images/btn_img_02.gif" class="btn_text" onclick="doEnviSave(); return false;" title="입력된 정보로 테스트환경을 설정합니다." style="cursor:pointer">테스트환경설정</td>
                                              <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                            </tr>
                                        </table>
                                        </td>
                                      </tr>
                                    </table>
                           			</form>
                            
                                   </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</body>
</html>