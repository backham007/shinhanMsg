<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>▒▒ 테스트자동화시스템 ▒▒</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="jqgrid/js/jquery-1.5.2.min.js" charset="utf-8"></script>
<script type="text/javascript">
<!--
function MM_swapImgRestore() { //v3.0
var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
function MM_openBrWindow(theURL,winName,features) { //v2.0
window.open(theURL,winName,features);
}
//-->

// iframe resize
function autoResize(i)
{
var iframeHeight=
(i).contentWindow.document.body.scrollHeight;
(i).height=iframeHeight+20;
}
</script>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#rptCall_btn").click( function() {//결과보고서상세  임시 호출 버턴(gubun 01:테스트케이스 02:테스트 시나리오)
	    var url = "msg.report.rptDtlInit.do?gubun=01&tscaseid=C2000000000000000001&acmplnth=1";
	    window.showModalDialog(url,window,'center:yes;dialogWidth=980px; dialogHeight=777px; scroll=no; status=no; help=no; resizable:no; ');
	});
});

</script>
</head>


<body bgcolor="#FFFFFF" background="images/left_menu_bg.jpg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="MM_preloadImages('images/top_menu_01_02.jpg','images/top_menu_05_02.jpg','images/top_menu_06_02.jpg','images/top_menu_message_02.jpg','images/top_menu_statistics_02.jpg','images/top_menu_mytest_02.jpg','images/top_menu_system_02.jpg')">

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
                                                <td class="sub_tit">나의 최근작업 조회 </td>
                                            </tr>
                                            <tr > 
                                                <td background="images/tit_line_bg.gif" height="6" colspan="2"><img src="images/tit_line_bg.gif"></td>
                                            </tr>
                                            <tr > 
                                                <td height="10" colspan="2"></td>
                                            </tr>
                                        </table>
                                    
                                        <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#baccdc">
                                            <tr>
                                                <td bgcolor="#e1e9f0">
                                                    <table width="100%" border="0" cellspacing="0" cellpadding="5">
                                                        <tr>
                                                            <td bgcolor="#FFFFFF">
                                                                <table width="100%" border="0" cellspacing="0" cellpadding="2">
                                                                    <tr>
                                                                        <td width="85" class="box_txt_red">조회유형 :</td>
                                                                      <td><select name="select3"   class="menu" style="width:140px">
                                                                        <option>== 선 택 ==</option>
                                                                        <option>테스트케이스유형</option>
                                                                            </select></td>
                                                                        <td width="85" class="box_txt">실행결과 :</td>
                                                                      <td>
                                                                        <select name="select4"   class="menu" style="width:140px">
                                                                        <option>== 선 택 ==</option>
                                                                        </select>
                                                                        </td>
                                                                        <td width="85" class="box_txt">조회조건 :</td>
                                                                      <td>
                                                                        <select name="select5"   class="menu" style="width:140px">
                                                                        <option>== 선 택 ==</option>
                                                                        </select>
                                                                        <input name="textfield2" type="text" class="input_topinq" style="width:120px">
                                                                        <img id="rptCall_btn" src="images/btn_pop.gif" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" ></td>
                                                                        <td>
                                                                            <table border="0" align="right" cellpadding="0" cellspacing="0">
                                                                                <tr>
                                                                                    <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                                                                    <td background="images/btn_img_02.gif" class="btn_text">조 회</td>
                                                                                    <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                                                                </tr>
                                                                            </table>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </td>
                                            </tr>
                                        </table>
                                    
                                        <table width="100%" border="0" cellspacing="0" cellpadding="1">
                                            <tr> 
                                                <td height="20">&nbsp;</td>
                                            </tr>
                                        </table> 
                                    
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                            <tr>
                                                <td class="sub_tit02">그리드색상스타일</td>
                                            </tr>
                                            <tr>
                                                <td height="1" colspan="2"></td>
                                            </tr>
                                        </table>
                                    
                                        <table width="100%" height="100" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                                            <tr>
                                                <td height="150" valign="top" bgcolor="#FFFFFF"><img src="images/gridcolor.gif" alt="" width="1018" height="322"></td>
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
                                                            <td background="images/btn_img_02.gif" class="btn_text">삭 제</td>
                                                            <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                                        </tr>
                                                    </table>
                                                    <table border="0" align="right" cellpadding="0" cellspacing="0">
                                                        <tr>
                                                            <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                                            <td background="images/btn_img_02.gif" class="btn_text"> 엑셀다운로드</td>
                                                            <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                                        </tr>
                                                    </table>
                                                </td>
                                            </tr>
                                        </table>
                                    
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