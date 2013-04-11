<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>▒▒ 테스트자동화시스템 ▒▒</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Cache-Control" content="no-cache"/> 
<meta http-equiv="Expires" content="0"/> 
<meta http-equiv="Pragma" content="no-cache"/>
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
<script type="text/javascript" src="js/cmn/utils/json2.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/popupcalendar.js" charset="utf-8"></script>
<script type="text/javascript" src="js/msg/statistics/statistics.js" charset="utf-8"></script>
<script type="text/javascript" src="js/msg/statistics/deptTestPrgsSts.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/util.js" charset="utf-8"></script>
<script language="javascript"><!--
var tranUrl = "msg.statistics.getDeptTestPrgsSts.do";
var param = "";
var maxWidth= 750;
var leftTemp= 230;
$(document).ready(function(){

	    getListMngCode('searchGubun','TES4DIV','01');
		getListMngCode('connSevrDstcd','CONNSEVRDSTCD2','00');
		var testStartYMS = "${sessionScope.userinfo.teststartyms}";
		var testEndYMS =  "${sessionScope.userinfo.testendyms}";
		setTestStgeName("testStgeName2");
		$("#testStartYMS").val(getDateFormat(testStartYMS));
		$("#testEndYMS").val(getDateFormat(testEndYMS));

		JQGridReload(false);
	
		gridExcelInit();
		getList();
	});


--></script>
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


<body bgcolor="#FFFFFF" background="images/left_menu_bg.jpg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="MM_preloadImages('images/top_menu_01_02.jpg','images/top_menu_02_02.jpg','images/top_menu_03_02.jpg','images/top_menu_04_02.jpg','images/top_menu_05_02.jpg','images/top_menu_06_02.jpg','images/top_menu_07_02.jpg','images/btn_newtc_02.jpg','images/btn_import_02.jpg','images/btn_savetc_02.jpg','images/btn_initialize_02.jpg')">
	<form name="frm" method="POST">
	<input type="hidden" name="testStgeName" id="testStgeName"/>
	<input type="hidden" name="tranCd" id="tranCd"/>
	<input type="hidden" name="tstrId" id="tstrId"/>
	<input type="hidden" name="tranName" id="tranName"/>
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
	                                  <td valign="top"><table border=0 cellpadding=0 cellspacing=0 width=100%>
	                                    <tr>
	                                      <td width="20"><img src="images/title_bullet1.gif"></td>
	                                      <td width="120" class="sub_tit">부서별 진척현황</td>
	                                      <td valign="bottom" class="point_text" id="flowMsg" >조회된 내용을 더블클릭하여 상세조회를 확인 할 수 있습니다.</td>
	                                    </tr>
	                                    <tr >
	                                      <td background="images/tit_line_bg.gif" height="6" colspan="3"><img src="images/tit_line_bg.gif"></td>
	                                    </tr>
	                                    <tr >
	                                      <td height="10" colspan="3"></td>
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
	                                                                <td width="120" class="box_txt_red">프로젝트 :</td>
	                                                                <td width="360"><input name="projNo" id="projNo" type="text" class="input_topinq" style="width:100px" value="${sessionScope.userinfo.projno}" >
	                                                                    <img src="images/btn_pop.gif" alt="프로젝트조회" width="23" height="21" hspace="4" align="absmiddle" onClick="openProjPop('testStgeName2')" style="cursor: pointer">
	                                                                <input name="projName" id="projName" type="text" class="input_topinq" style="width:200px" value="${sessionScope.userinfo.projname}">
	                                                                
	                                                                <td width="90" class="box_txt">테스트단계 :</td>
	                                                                <td>
		                                                                <select id="testStgeName2" class="menu" style="width:120px">
		                                                                    <option value="">== 전체 ==</option>
		                                                                </select>
		                                                            </td>
	                                                                <td width="60"><table border="0" align="right" cellpadding="0" cellspacing="0">
	                                                                  <tr>
	                                                                    <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
	                                                                    <td background="images/btn_img_02.gif" class="btn_text" id="srch_btn" style="cursor:pointer;">조 회</td>
	                                                                    <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
	                                                                  </tr>
	                                                                </table>
	                                                                </td>
	                                                              </tr>
	                                                              <tr>
	                                                              <td class="box_txt_red">조회구분 :</td>
	                                                              <td>
		                                                              <select name="searchGubun" id="searchGubun" class="menu" style="width:120px">
		                                                              </select>
	                                                              </td>
	                                                              <td class="box_txt_red">조회기간 :</td>
	                                                                <td><input name="testStartYMS" id="testStartYMS" type="text" class="input_topinq" style="width:65px" readonly="readonly">
																					<img src="images/un_sub_cen_cal.gif" alt="달력" width="23" height="21" hspace="4" align="absmiddle" style="cursor: pointer" onclick="popUpCalendar(this, 'testStartYMS', 'yyyy-mm-dd','CENTER','MIDDLE');">
																											 ~
	                                                                    <input name="testEndYMS" id="testEndYMS" type="text" class="input_topinq" style="width:65px" readonly="readonly">
																		<img src="images/un_sub_cen_cal.gif" alt="달력" width="23" height="21" hspace="4" align="absmiddle" style="cursor: pointer" onclick="popUpCalendar(this, 'testEndYMS', 'yyyy-mm-dd','CENTER','MIDDLE');">
																		</td>
	                                                                <td>&nbsp;</td>
	                                                              </tr>
	                                                              <tr>
	                                                              <td class="box_txt">테스트대상시스템 :</td>
	                                                                <td>
	                                                                <select name="connSevrDstcd" id="connSevrDstcd"   class="menu" style="width:120px">
	                                                                </select></td>
	                                                                <td class="box_txt">부서번호/명 :</td>
	                                                                <td>
	                                                                	<input name="deptName" id="deptName" type="text" class="input_topinq" style="width:80px">
	                                                                	<img src="images/btn_eraser.gif" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" onclick="{$('#deptName').val('');}" style="cursor: pointer">
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
	                                        <td height="10"></td>
	                                      </tr>
	                                    </table>
	                                	 <table width="100%" height="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
		                                      <tr>
		                                        <td valign="top" bgcolor="#FFFFFF">
		                                        	<table id="list2"></table>
		                                        </td>
		                                      </tr>
                                   	 	</table>
	                                    <table width="100%" border="0" cellspacing="0" cellpadding="1">
	                                      <tr>
	                                        <td height="5" colspan="3"></td>
	                                      </tr>
	                                      <tr>
	                                        <td width="150" height="10">&nbsp;</td>
	                                        <td align="center"><span class="input_result">[수행건수를 더블클릭하시면 상세조회가 가능합니다.]</span></td>
	                                        <td width="150" id="excelBtn">
		                                        <table border="0" align="right" cellpadding="0" cellspacing="0">
		                                          <tr>
		                                            <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
		                                            <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="downExcelDeptTestPrgsSts()">엑셀다운로드</td>
		                                            <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
		                                          </tr>
		                                        </table>
		                                   </td>
	                                      </tr>
	                                  </table></td>
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