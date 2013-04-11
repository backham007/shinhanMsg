<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>전문 테스트로(TESTRO)</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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

<script type="text/javascript" src="js/cmn/utils/json2.js" charset="utf-8"></script>

<script type="text/javascript" src="jqgrid/js/jquery-1.5.2.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/jquery.blockUI.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/src/i18n/grid.locale-en.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/jquery.jqGrid.src.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/jquery.contextmenu-fixed.js" charset="utf-8"></script>
<script type="text/javascript" src="js/msg/tsmng/tsmng.js?201202141819" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/util.js" charset="utf-8"></script>

</head>


<body bgcolor="#FFFFFF" background="images/left_menu_bg.jpg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<input id="tsDataMaxCnt" type="hidden" value="${tsDataMaxCnt}">
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
                                    <form name="frmname" method="POST" action="">
                                        <input type="hidden" id="currentTsSnrioID" name="currentTsSnrioID" value="${tssnroId}"/>
                                        <input type="hidden" id="teststartyms" name="teststartyms" value="${teststartyms}" />
                                        <input type="hidden" id="testendyms" name="testendyms" value="${testendyms}" />
                                        <input type="hidden" id="resultTssnrioid" name="resultTssnrioid"  />
                                        <input type="hidden" id="resultAcmplnth" name="resultAcmplnth" />
                                        
                                        <input type="hidden" name="usrname" id="usrname" value="${sessionScope.userinfo.usrname}" />
                                        <input type="hidden" name="tranCd" id="tranCd" />
                                        <input type="hidden" name="returnExecute" id="returnExecute" />
                                        
                                        <input type="hidden" name="isGridSave" id="isGridSave" />
                                  
                                       <table border=0 cellpadding=0 cellspacing=0 width=100%>
                                            <tr> 
                                                <td width="20"><img src="images/title_bullet1.gif"></td>
                                                <td width="150" class="sub_tit">테스트시나리오관리</td>
                                                <td valign="bottom" class="point_text" id="flowMsg"></td>
                                                <td height="2" align="right">
                                                    <a href="#" id="btnNew">
                                                        <img src="images/btn_newtc_01.jpg" name="Image56" width="65" height="19" hspace="2" border="0">
                                                    </a>
                                                    <a href="#" id="btnLoad">
                                                        <img src="images/btn_import_01.jpg" name="Image57" width="65" height="19" hspace="2" border="0">
                                                    </a>
                                                    <a href="#" id="btnSave">
                                                        <img src="images/btn_savetc_01.jpg" name="Image58" width="48" height="19" hspace="2" border="0">
                                                    </a>
                                                    <a href="#" id="btnReset">
                                                        <img src="images/btn_initialize_01.jpg" name="Image59" width="57" height="19" hspace="2" border="0">
                                                    </a>
                                                </td>
                                            </tr>
                                            <tr > 
                                                <td background="images/tit_line_bg.gif" height="6" colspan="4"><img src="images/tit_line_bg.gif"></td>
                                            </tr>
                                            <tr > 
                                                <td height="10" colspan="4"></td>
                                            </tr>
                                      </table>
                                    
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                            <tr>
                                              <td class="sub_tit02"> 테스트시나리오 정보</td>
                                          </tr>
                                            <tr>
                                                <td height="1" colspan="2"></td>
                                            </tr>
                                      </table>
                                    
                                      <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc">
                                          <tr>
                                            <td width="10%" class="tm_left">시나리오 ID</td>
                                            <td width="40%" id="titleTsSnrioID" class="tm_text">&nbsp;</td>
                                            <td width="10%" class="tm_left">시나리오 명</td>
                                            <td width="40%" id="titleTsSnrioName" class="tm_text">&nbsp;</td>
                                          </tr>
                                          <tr>
                                            <td class="tm_left">시나리오 설명</td>
                                            <td id="titleTsSnrioDesc" class="tm_text" colspan="3">&nbsp;</td>
                                          </tr>
                                        </table>
                                      <table width="100%" border="0" cellspacing="0" cellpadding="1">
                                      <tr>
                                        <td height="10" colspan="2"></td>
                                      </tr>
                                      <tr>
                                        <td class="sub_tit02">테스트시나리오 구성</td>
                                        <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                                          <tr>
                                            <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                            <td id="btnDelete" background="images/btn_img_02.gif" class="btn_text">
                                                <font style="cursor: pointer;">삭 제</font>
                                            </td>
                                            <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                          </tr>
                                        </table>
                                          <table border="0" align="right" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                              <td id="btnUseIO" background="images/btn_img_02.gif" class="btn_text">
                                                <font style="cursor: pointer">입출력값 활용</font>
                                              </td>
                                              <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                            </tr>
                                          </table>
                                          <table border="0" align="right" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                              <td id="btnAddTc" background="images/btn_img_02.gif" class="btn_text">
                                                <font style="cursor: pointer">기존테스트케이스추가</font>
                                              </td>
                                              <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                            </tr>
                                          </table>
                                          <table border="0" align="right" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                              <td id="btnMoveDown" background="images/btn_img_02.gif" class="btn_text">
                                                <font style="cursor: pointer">▼</font>
                                              </td>
                                              <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                            </tr>
                                          </table>
                                          <table border="0" align="right" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                              <td id="btnMoveUp" background="images/btn_img_02.gif" class="btn_text">
                                                <font style="cursor: pointer">▲</font>
                                              </td>
                                              <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                            </tr>
                                          </table></td>
                                      </tr>
                                    </table>
                                    
                                    <table width="100%" height="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                                        <tr>
                                            <td id="case" height="100%" valign="top" bgcolor="#FFFFFF">
                                                <table id="jqGridTable"></table>
                                                <!-- 우클릭 메뉴 -->
				                                <div class="contextMenu" id="myMenu1" style="display:none"> 
							                        <ul style="width:400px">
							                            <li id="liUseIO">
							                                <div style="font-size:130%; font-family:Verdana">입출력값 활용</div>
							                                <span class="contextMenuList" style="font-size:130%; font-family:Verdana"></span>
							                            </li>
							                        </ul> 
							                    </div>
							                    <!-- 우클릭 메뉴 -->
							                </td>
							            </tr>
							        </table>
        
                                    <table width="100%" border="0" cellspacing="0" cellpadding="1">
                                      <tr>
                                        <td height="5" colspan="3"></td>
                                      </tr>
                                      <tr>
                                        <td width="100" height="10"><table border="0" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                              <td id="btnExecute" background="images/btn_img_02.gif" class="btn_text">
                                                <font style="cursor:pointer;">테스트 실행</font>
                                              </td>
                                              <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                            </tr>
                                        </table></td>
                                        <td width="130" height="10"><table class="btnResult" border="0" cellpadding="0" cellspacing="0" style="display: none;">
                                            <tr>
                                              <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                              <td id="btnResult" background="images/btn_img_02.gif" class="btn_text">
                                                <font style="cursor:pointer;">결과보고서 보기</font>
                                              </td>
                                              <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                            </tr>
                                        </table></td>
                                        <td width="500" height="10"><table border="0" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td id="btnExecute">
                                                <span id="prcssMsg" style="color: red; font-size: 15px"></span>
                                              </td>
                                            </tr>
                                        </table></td>
                                        <td></td>
                                        <td >&nbsp;</td>
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