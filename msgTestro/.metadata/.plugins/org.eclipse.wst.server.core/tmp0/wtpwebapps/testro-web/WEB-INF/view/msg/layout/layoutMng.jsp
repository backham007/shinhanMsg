<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="js/cmn/utils/json2.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/util.js" charset="utf-8"></script>
<script type="text/javascript" src="js/msg/layout/layoutMng.js"></script>
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


<body bgcolor="#FFFFFF" background="images/left_menu_bg.jpg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="MM_preloadImages('images/top_menu_01_02.jpg','images/top_menu_02_02.jpg','images/top_menu_03_02.jpg','images/top_menu_04_02.jpg','images/top_menu_05_02.jpg','images/top_menu_06_02.jpg','images/top_menu_07_02.jpg','images/btn_newtc_02.jpg','images/btn_import_02.jpg','images/btn_savetc_02.jpg','images/btn_initialize_02.jpg','images/btn_del_02.jpg')">
<input id="chnlDstcd" name="chnlDstcd" type="hidden"/><!-- hidden 채널구분코드 -->
<input id="fldDiv" name="fldDiv" type="hidden"/><!-- hidden 필드구성 -->
<input id="writeId" name="writeId" type="hidden"/><!-- hidden 작성자ID -->
<input id="writeName" name="writeName" type="hidden"/><!-- hidden 작성자명 -->
<input id="cretnYMS" name="cretnYMS" type="hidden"/><!-- hidden 생성일시 -->
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
                                                <td width="80" class="sub_tit">전문관리</td>
                                                <td valign="bottom" class="point_text" id="flowMsg" >신규생성 및 불러오기를 하실 수 있습니다.</td>
                                                <td height="2" align="right">
                                                	<a href="#" id="Image56" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image56','','images/btn_newtc_02.jpg',1)" onClick="newLayout()">
                                                		<img src="images/btn_newtc_01.jpg" name="Image56" width="65" height="19" hspace="2" border="0">
                                                	</a>
                                                	<a href="#" id="Image57" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image57','','images/btn_import_02.jpg',1)" onClick="getLayout()">
                                                		<img src="images/btn_import_01.jpg" name="Image57" width="65" height="19" hspace="2" border="0">
                                                	</a>
                                                	<a href="#" id="Image58" onMouseOut="MM_swapImgRestore()" onMouseOver="" onClick="">
                                                		<img src="images/btn_savetc_03.jpg" name="Image58" width="48" height="19" hspace="2" border="0">
                                                	</a>
                                                	<a href="#" id="Image31" onMouseOut="MM_swapImgRestore()" onMouseOver="" onClick="">
                                                		<img src="images/btn_del_03.jpg" name="Image31" width="48" height="19" border="0">
                                                	</a>
                                                	<a href="#" id="Image59" onMouseOut="MM_swapImgRestore()" onMouseOver="" onClick="">
                                                		<img src="images/btn_initialize_03.jpg" name="Image59" width="57" height="19" hspace="2" border="0">
                                                	</a>
                                                </td>
                    						</tr>
                                            <tr > 
                                                <td background="images/tit_line_bg.gif" height="6" colspan="6"><img src="images/tit_line_bg.gif"></td>
                                            </tr>
                                            <tr > 
                                                <td height="10" colspan="4"></td>
                                            </tr>
                                      </table>
                                    
                                        <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#baccdc">
                                          <tr>
                                            <td bgcolor="#e1e9f0"><table width="100%" border="0" cellspacing="0" cellpadding="5">
                                                <tr>
                                                  <td bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="2">
                                                      <tr>
                                                        <!-- td width="80" class="box_txt">채널구분 :</td>
                                                        <td id="chnlDstName"></td -->
                                                        <td id="tranCdTitle" width="80" class="box_txt">거래코드 :</td>
                                                        <td id="tranCd" width="300"></td>
                                                        <td id="tranNameTitle" width="110" class="box_txt">거래명 :</td>
                                                        <td id="tranName"></td>
                                                      </tr>
                                                      <tr>
                                                        <td class="box_txt">필드구성 :</td>
                                                        <td id="fldDivName"></td>
                                                        <td id="refTranCdTitle" class="box_txt">헤더부참조코드 :</td>
                                                        <td id="refTranCd"></td>
                                                      </tr>
                                                  </table></td>
                                                </tr>
                                            </table></td>
                                          </tr>
                                        </table>
                                    <table width="100%" border="0" cellspacing="0" cellpadding="1">
                                      <tr>
                                        <td height="10" colspan="2"></td>
                                      </tr>
                                      <tr>
                                        <td class="sub_tit02">전문 구성 필드</td>
                                        <td>
                                        <div id="btnArea" disabled>
                                        <table border="0" align="right" cellpadding="0" cellspacing="0">
                                          <tr>
                                            <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                            <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onClick="deleteRow();">행삭제</td>
                                            <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                          </tr>
                                        </table>
                                          <table border="0" align="right" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                              <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onClick="insertRow();">행추가</td>
                                              <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                            </tr>
                                          </table>
                                          <table border="0" align="right" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                              <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onClick="downRow();">▼</td>
                                              <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                            </tr>
                                          </table>
                                          <table border="0" align="right" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                              <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onClick="upRow();">▲</td>
                                              <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                            </tr>
                                          </table>
                                         </div>
                                         </td>
                                      </tr>
                                    </table>
                                    <table width="100%" height="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                                      <tr>
                                        <td height="100%" valign="top" bgcolor="#FFFFFF">
                                        	<table id="list1"></table>
											<div id="pager1"></div>
                                        </td>
                                      </tr>
                                    </table>
                                    <div id="btnArea2" disabled>
                                    <table align="right" border="0" cellpadding="0" cellspacing="0">
                                      <tr>
                                        <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                        <td background="images/btn_img_02.gif" class="btn_text" onclick="importExcel();" style="cursor:pointer;" >엑셀업로드</td>
                                        <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                      </tr>
                                    </table>
                                    <table align="right" border="0" cellpadding="0" cellspacing="0">
                                     <tr>
                                       <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                       <td background="images/btn_img_02.gif" class="btn_text" onclick="exportExcel();" style="cursor:pointer;" >엑셀다운로드</td>
                                       <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                     </tr>
									</table>
									</div>
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