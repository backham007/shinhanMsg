<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<title>전문 테스트로(TESTRO)</title>
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
<script type="text/javascript" src="jqgrid/js/jquery.contextmenu-fixed.js" charset="utf-8"></script>

<script type="text/javascript" src="js/cmn/utils/json2.js" charset="utf-8"></script>
<script type="text/javascript" src="js/msg/tcmng/tcmng.js"></script>
<script type="text/javascript" src="js/cmn/util.js"></script>
<script type="text/javascript" src="js/cmn/validation_v01.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/popupcalendar.js" charset="utf-8"></script>


<script type="text/javascript">
<!-- 

function MM_swapImgRestore() { //v3.0
var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadimage() { //v3.0
var d=document; if(d.image){ if(!d.MM_p) d.MM_p=new Array();
var i,j=d.MM_p.length,a=MM_preloadimage.arguments; for(i=0; i<a.length; i++)
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


<body bgcolor="#FFFFFF" background="images/left_menu_bg.jpg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="MM_preloadimage('images/top_menu_01_02.jpg','images/top_menu_02_02.jpg','images/top_menu_03_02.jpg','images/top_menu_04_02.jpg','images/top_menu_05_02.jpg','images/top_menu_06_02.jpg','images/top_menu_07_02.jpg','images/신규생성_02.jpg','images/불러오기_02.jpg','images/저장_02.jpg','images/초기화_02.jpg')">

<form name="frmname" method="post">
	<!-- 세션정보 -->
	<input type="hidden" name="usrName" 	id="usrName" value="테스터"  />
	
	<!-- 테스트케이스 정보 -->
	<input type="hidden" name="chnlDstcd" 	id="chnlDstcd"  	value="${chnlDstcd}" />
	<input type="hidden" name="tranCd" 		id="tranCd" 		value="${tranCd}" />
	<input type="hidden" name="tranName" 	id="tranName"  		value="${tranName}" />
	<input type="hidden" name="fldDiv" 		id="fldDiv"  />
	<input type="hidden" name="tsCaseID" 	id="tsCaseID"  		value="${tsCaseID}" />
	<input type="hidden" name="tsCaseName" 	id="tsCaseName"		value="${tsCaseName}" />
	<input type="hidden" name="tsCaseDesc" 	id="tsCaseDesc"		value="${tsCaseDesc}" />
	<input type="hidden" name="acmplNth" 	id="acmplNth"		value="" />
	
	<!-- 로그인 정보 -->	
	<input type="hidden" name="usrid" 		 id="usrid"  		value="${sessionScope.userinfo.usrid}" />
	<input type="hidden" name="usrname" 	 id="usrname"		value="${sessionScope.userinfo.usrname}" />
	<input type="hidden" name="teststartyms" id="teststartyms"	value="${sessionScope.userinfo.teststartyms}" />
	<input type="hidden" name="testendyms" 	 id="testendyms"	value="${sessionScope.userinfo.testendyms}" />
	<input type="hidden" name="usrlevel" 	  id="usrlevel"		value="${sessionScope.userinfo.projno}" />
	<input type="hidden" name="projno" 	 	  id="projno"		value="${sessionScope.userinfo.projno}" />
	<input type="hidden" name="projname" 	  id="projname"		value="${sessionScope.userinfo.projname}" />
	<input type="hidden" name="teststgename"  id="teststgename"	value="${sessionScope.userinfo.teststgename}" />
	<input type="hidden" name="connsevrdstcd" id="connsevrdstcd" value="${sessionScope.userinfo.connsevrdstcd}" />
	
	<!-- 데이터자동생성 -->
	<input type="hidden" name="gridCnt" id="gridCnt" value="" />
	<input type="hidden" name="EngAutoDataHeaderKey" id="EngAutoDataHeaderKey" value="" />
	<input type="hidden" name="EngAutoDataHeader" id="EngAutoDataHeader" value="" />
	<input type="hidden" name="KorAutoDataHeader" id="KorAutoDataHeader" value="" />
	<input type="hidden" name="autoMaxLength" id="autoMaxLength" value="" />
	<input type="hidden" name="autoDataPosition" id="autoDataPosition" value="" />
	<input type="hidden" name="cellEditMode" id="cellEditMode" value="" />
	<input type="hidden" name="NMcheck" id="NMcheck" value="" />
	<input type="hidden" name="totalarray" id="totalarray" value="" />
	
	<!-- 체크포인트팝업 정보 // 테스트데이터 저장후 활용 정보  -->
	<input type="hidden" name="tsdataID" id="tsdataID" value="${tsDataID}" />
	
	<!-- 반복부 정보 -->
	<input type="hidden" name="rptMap" id="rptMap" value="" />
	
	<!-- 체크포인트팝업 정보 -->
	<input type="hidden" name="chkYNVal" id="chkYNVal" value="" />
	
	<!-- 실행시 체크된 ID List -->
	<input type="hidden" name="cklst" id="cklst" value="" />
	
	<!-- 테스트케이스 테스트데이터 최대등록건수 -->
	<input type="hidden" name="tcDataMaxCnt" id="tcDataMaxCnt" value="${tcDataMaxCnt}" />
	
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
                                                <td width="130" class="sub_tit">테스트케이스관리</td>
                                                <td valign="bottom" class="point_text" id="flowMsg" >테스트실행버튼을 클릭하여 테스트를 실행하십시오.</td>
                                                <td height="2" align="right">
                                                	<a id="btnNew" href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image56','','images/btn_newtc_02.jpg',1)" onclick="getTcmngIoMap();">
                                                		<img src="images/btn_newtc_01.jpg" name="Image56" width="65" height="19" hspace="2" border="0">
                                                	</a>
                                                	<a id="btnLoad" href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image57','','images/btn_import_02.jpg',1)" onclick="getTcmngInfo();">
                                                		<img src="images/btn_import_01.jpg" name="Image57" width="65" height="19" hspace="2" border="0">
                                                	</a>
                                                	<!-- 
                                                	<a id="btnSave" href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image58','','images/btn_savetc_02.jpg',1)"  onclick="doTcSave();"><img src="images/btn_savetc_01.jpg" name="Image58" width="48" height="19" hspace="2" border="0"></a>
                                                	<a id="btnReset" href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image59','','images/btn_initialize_02.jpg',1)" onclick="reload();"><img src="images/btn_initialize_01.jpg" name="Image59" width="57" height="19" hspace="2" border="0"></a>
                                                	 -->
                                                	<a id="Image58" href="#" onMouseOut="MM_swapImgRestore()" onMouseOver=""  onclick="">
                                                		<img src="images/btn_savetc_03.jpg" id="Image58 img" name="Image58" width="48" height="19" hspace="2" border="0">
                                                	</a>
                                                	<a id="Image59" href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="" onclick="">
                                                		<img src="images/btn_initialize_03.jpg" id="Image59 img" name="Image59" width="57" height="19" hspace="2" border="0">
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
                                              <td class="sub_tit02"> 테스트케이스 정보</td>
                        				  </tr>
                                            <tr>
                                                <td height="1" colspan="2"></td>
                                            </tr>
                                      </table>
                                    
                                      <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc">
                                          <tr>
                                            <td width="140px" class="tm_left"> 테스트케이스ID</td>
                                            <td width="35%" class="tm_text" id="txtTcID">&nbsp;</td>
                                            <td width="150px" class="tm_left"> 테스트케이스 명</td>
                                            <td width="35%" class="tm_text" id="txtTcName">&nbsp;</td>
                                          </tr>
                                          <tr>
                                            <td class="tm_left"> 거래코드</td>
                                            <td class="tm_text" id="txtTranCD">&nbsp;</td>
                                            <td class="tm_left" rowspan="2"> 테스트케이스 설명</td>
                                            <td class="tm_text" rowspan="2" id="txtTcDesc">&nbsp;</td>
                                          </tr>
                                          <tr>
                                            <td class="tm_left"> 거래명</td>
                                            <td class="tm_text" id="txtTranName">&nbsp;</td>
                                          </tr>
                                        </table>
                                      <table width="100%" border="0" cellspacing="0" cellpadding="1">
                                        <tr>
                                          <td height="10" colspan="2"></td>
                                        </tr>
                                        <tr>
                                          <td class="sub_tit02">기본 테스트데이터</td>
                                        </tr>
                                      </table>
                                    
                                    <!-- 그리드 영역 시작  -->
                                    <table width="100%" height="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                                      <tr>
                                        <td height="100%" valign="top" bgcolor="#FFFFFF">
	                                        <div id="basicsListDiv">
	                                        	<table id="basicsList"></table>
											</div>
										</td>
                                      </tr>
                                    </table>
                                    <!-- 그리드 영역 종료  -->
                                    
                                    <table width="100%" border="0" cellspacing="0" cellpadding="1">
                                      <tr>
                                        <td height="10" colspan="2"></td>
                                      </tr>
                                      <tr>
                                        <td width="200" class="sub_tit02">테스트케이스 구성</td>
                                        <td>
                                        <div id="btnArea2"  disabled="disabled">
                                        <table border="0" align="right" cellpadding="0" cellspacing="0">
                                          <tr>
                                            <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                            <td background="images/btn_img_02.gif" class="btn_text" onclick="doRowDel();" style="cursor:pointer;">삭 제</td>
                                            <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                          </tr>
                                        </table>
                                          <table border="0" align="right" cellpadding="0" cellspacing="0">
                                          <tr>
                                            <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                            <td background="images/btn_img_02.gif" class="btn_text" onclick="doRowCopy();" style="cursor:pointer;" >복 사</td>
                                            <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                          </tr>
                                        </table>
                                          <table border="0" align="right" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                              <td background="images/btn_img_02.gif" class="btn_text" onclick="setDataAutoCreate();" style="cursor:pointer;">데이터자동생성</td>
                                              <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                            </tr>
                                          </table>
                                          <table border="0" align="right" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                              <td background="images/btn_img_02.gif" class="btn_text" onclick="getTcmngAdd();" style="cursor:pointer;">기존 테스트케이스 추가</td>
                                              <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                            </tr>
                                          </table>
                                          <table border="0" align="right" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                              <td background="images/btn_img_02.gif" class="btn_text" onclick="addTestData();" style="cursor:pointer;">기본 테스트데이터 추가</td>
                                              <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                            </tr>
                                          </table>
                                          <table border="0" align="right" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                              <td background="images/btn_img_02.gif" class="btn_text" onclick="doRowDown();" style="cursor:pointer;" >▼</td>
                                              <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                            </tr>
                                          </table>
                                          <table border="0" align="right" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                              <td background="images/btn_img_02.gif" class="btn_text" onclick="doRowUp();" style="cursor:pointer;" >▲</td>
                                              <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                            </tr>
                                          </table>
                                          </div>
                                          </td>
                                      </tr>
                                    </table>
                                    
                                    <!-- 그리드 영역 시작  -->
                                     <table width="100%" height="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                                      <tr>
                                        <td height="100%" valign="top" bgcolor="#FFFFFF">
	                                        <div id="listDiv">
												<table id="list"></table>
											</div>
										</td>
                                      </tr>
                                    </table>
                                    <!-- 그리드 영역 시작  -->
                                    
                                    <table width="100%" border="0" cellspacing="0" cellpadding="1" id="btnArea3" disabled="disabled">
                                      <tr>
                                        <td height="5" colspan="4"></td>
                                      </tr>
                                      <tr>
                                       <td width="100" height="10"><table border="0" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                              <td id="btnExecute" background="images/btn_img_02.gif" class="btn_text" onclick="btnExecute();" style="cursor:pointer;" >
                                                <font style="cursor:pointer;">테스트 실행</font>
                                              </td>
                                              <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                            </tr>
                                        </table></td>
                                        <td width="130" height="10"><table class="btnResult" border="0" cellpadding="0" cellspacing="0" style="display: none;">
                                            <tr>
                                              <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                              <td id="btnResult" background="images/btn_img_02.gif" class="btn_text" onclick="btnResult();" style="cursor:pointer;" >
                                                <font style="cursor:pointer;">결과보고서 보기</font>
                                              </td>
                                              <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                            </tr>
                                        </table></td>
                                        <td width="300" height="10"><table border="0" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td id="btnExecute">
                                                <span id="prcssMsg" style="color: red; font-size: 15px"></span>
                                              </td>
                                            </tr>
                                        </table></td>
                                        <td>
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



	