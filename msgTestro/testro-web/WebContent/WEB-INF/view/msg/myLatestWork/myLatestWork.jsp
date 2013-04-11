<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>전문 테스트로(TESTRO)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<link rel="shortcut icon" href="images/TESTRO.ico" type="image/ico" />
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="jqgrid/css/ui-lightness/jquery-ui-1.7.3.custom.css" media="screen" />
<link rel="stylesheet" type="text/css" href="jqgrid/js/src/css/ui.jqgrid.css" media="screen" />
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
<script type="text/javascript" src="jqgrid/js/jquery.contextmenu-fixed.js" charset="utf-8"></script>
<script type="text/javascript" src="js/msg/myLatestWork/myLatestWork.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/util.js" charset="utf-8"></script>
<script type="text/javascript">
<!--
var userid=  "${sessionScope.userinfo.usrid}";
var tranUrl = "msg.myLatestWork.getListMyLatestWork.do";


$(document).ready(function(){
	getListMngCode('searchGubun','TES2DIV');
	getListMngCode('rsultSucssYn','EXRESULT');
	getListMngCode('subSearch','TC1DIV');

	JQGridReload(true);

	
	gridExcelInit();

	getList();
	
});

//disabledObject(['excelDlBtn']);
-->
</script>
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

</head>


<body bgcolor="#FFFFFF" background="images/left_menu_bg.jpg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="MM_preloadImages('images/top_menu_01_02.jpg','images/top_menu_05_02.jpg','images/top_menu_06_02.jpg','images/top_menu_message_02.jpg','images/top_menu_statistics_02.jpg','images/top_menu_mytest_02.jpg','images/top_menu_system_02.jpg')">
<form name="frm" method="POST">
<input type="hidden" name="tsCaseID" id="tsCaseID" >
<input type="hidden" name="tssnroId" id="tssnroId" >
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
                                                <td width="140" class="sub_tit">나의 최근작업 조회</td>
                                                <td valign="bottom" class="point_text" id="flowMsg" >목록에서 마우스오른쪽 버튼을 누르신후, 테스트화면이동/결과보고서보기 메뉴를 사용 할 수 있습니다. </td>
                                            </tr>
                                            <tr > 
                                                <td background="images/tit_line_bg.gif" height="6" colspan="4"><img src="images/tit_line_bg.gif"></td>
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
                                                                        <td width="65" class="box_txt_red">조회유형 :</td>
                                                                      <td>
                                                                      	<select name="searchGubun" id="searchGubun" class="menu" style="width:120px" onchange="changeType(this.value)">
                                                                        </select></td>
                                                                        <td width="65" class="box_txt">실행결과 :</td>
                                                                      <td>
                                                                        <select name="rsultSucssYn"  id="rsultSucssYn" class="menu" style="width:100px">
                                                                        </select>
                                                                        </td>
                                                                        <td width="65" class="box_txt">조회조건 :</td>
                                                                      <td>
                                                                        <select name="subSearch" id="subSearch"   class="menu" style="width:120px">
                                                                        </select>
                                                                        <input name="keyword" id="keyword" type="text" class="input_topinq" style="width:120px">
<!--                                                                        <img src="images/btn_pop.gif" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" onClick="">-->
																	  </td>
																	  <td id="tstrNameTd" style="display: none;">
																	  <table>
																		  <td width="85" class="box_txt">테스터ID/명 :</td>
																		  <td>
																		  	  <input name="tstrName" id="tstrName" type="text" class="input_topinq" style="width:80px">
																		  </td>
																	  </table>
																	  </td>
                                                                        <td>
                                                                            <table border="0" align="right" cellpadding="0" cellspacing="0">
                                                                                <tr>
                                                                                    <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                                                                    <td background="images/btn_img_02.gif" class="btn_text" id="srchBtn" style="cursor:pointer" >조 회</td>
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
                                                <td class="sub_tit02" id="objLabel"></td>
                                                <td height="10">
	                                                 <table border="0" align="right" cellpadding="0" cellspacing="0" id="delBtn" style="cursor:pointer">
	                                                        <tr>
	                                                            <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
	                                                            <td background="images/btn_img_02.gif" class="btn_text" >삭 제</td>
	                                                            <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
	                                                        </tr>
	                                                 </table>
                                                 </td>
                                            </tr>
                                            <tr>
                                                <td height="1" colspan="2"></td>
                                            </tr>
                                        </table>
                                    
                                        <table width="100%" height="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
		                                      <tr>
		                                        <td valign="top" bgcolor="#FFFFFF">
		                                        	<table id="list2"></table>
		                                        	<div id="pager2"></div>
		                                        </td>
		                                      </tr>
                                   	 	</table>
                                   	 	 <!-- 우클릭 메뉴 -->
									    <div class="contextMenu" id="myMenu1" style="display:none"> 
											     <ul style="width: 200px"> 
												     <li id="moveTest"> 
													     <span style="font-size:130%; font-family:Verdana">테스트화면</span> 
												     </li> 
												     <li id="moveReport">  
													     <span style="font-size:130%; font-family:Verdana">결과보고서</span> 
												     </li>
											     </ul> 
										</div> 
									    <div class="contextMenu" id="myMenu2" style="display:none">
									        <ul style="width: 200px">
									            <li id="moveReport">  
													     <span style="font-size:130%; font-family:Verdana">결과보고서</span> 
											    </li>
									        </ul>
									    </div>
                                    <!-- 우클릭 메뉴 -->
                                    
                                        <table width="100%" border="0" cellspacing="0" cellpadding="1">
                                            <tr>
                                                <td height="5" colspan="3"></td>
                                            </tr>
                                            <tr>
                                            	<td width="320" height="10">&nbsp;</td>
<!--                                            	<td align="Center"><span class="input_result">[최근 500건만 조회 됩니다.]</span></td>-->
                                                <td height="10">
                                                    <table border="0" align="right" cellpadding="0" cellspacing="0" id="excelBtn" style="cursor:pointer">
                                                        <tr>
                                                            <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                                            <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="excelDown()"> 엑셀다운로드</td>
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
</form>    
</body>
</html>