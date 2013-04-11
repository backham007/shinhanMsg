<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>전문 테스트로(TESTRO)</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" href="images/TESTRO.ico" type="image/ico" />
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
<script type="text/javascript" src="js/cmn/utils/json2.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/src/i18n/grid.locale-en.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/jquery.jqGrid.src.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/sysmng/dbConfMng.js"></script>
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


<body bgcolor="#FFFFFF" background="images/left_menu_bg.jpg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="MM_preloadImages('images/top_menu_01_02.jpg','images/top_menu_05_02.jpg','images/top_menu_06_02.jpg','images/btn_newtc_02.jpg','images/btn_import_02.jpg','images/btn_savetc_02.jpg','images/btn_initialize_02.jpg','images/top_menu_message_02.jpg','images/top_menu_statistics_02.jpg','images/top_menu_mytest_02.jpg','images/top_menu_system_02.jpg')">

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
                                                <td width="110" class="sub_tit">DB설정 관리</td>
                                                 <td valign="bottom" class="point_text" id="flowMsg" >데이터소스를 신규추가 하거나 수정 할 수 있습니다.</td>
                                                <td class="point_text">&nbsp;</td>
                   							 </tr>
                                            <tr> 
                                                <td background="images/tit_line_bg.gif" height="6" colspan="5"><img src="images/tit_line_bg.gif"></td>
                                            </tr>
                                            <tr > 
                                                <td height="10" colspan="5"></td>
                                            </tr>
                                      </table>
                                    	<form>
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                          <tr>
                                            <td width="350" valign="top">
	                                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
	                                              <tr>
	                                                <td class="sub_tit02"> 데이터소스 명</td>
	                                              </tr>
	                                            </table>
	                                             <table width="100%" height="100" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                                                <tr>
                                                 	<td valign="top" bgcolor="#FFFFFF">
	                                                  <table id="list"></table> 
			    									  <div id="pager"></div>
		    										</td>
                                                </tr>
                                              </table>
                                              
	                                            
	                                        </td>
                                            <td width="10">&nbsp;</td>
                                            <td valign="top">
                                            	<table width="100%" border="0" cellspacing="0" cellpadding="0">
                                              	<tr>
                                                	<td class="sub_tit02"> 데이터소스 상세설정</td>
                                              	</tr>
                                            	</table>
                                              <table id="detail" width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc">
                                                <tr>
                                                  <td width="150" class="tm_left_slim">데이터소스 명</td>
                                                  <td class="tm_text_slim"><span id="dsName"></span></td>
                                                </tr>
                                                <tr>
                                                  <td class="tm_left_slim">type</td>
                                                  <td class="tm_text_slim">
                                                  	<select id="type" class="menu">
													  <option value="jdbc">JDBC</option>
													  <option value="jndi">JNDI</option>
													</select>
                                                  </td>
                                                </tr>
                                                <tr>
                                                  <td class="tm_left_slim">transaction</td>
                                                  <td class="tm_text_slim">
                                                  	<select id="transaction" class="menu">
													  <option value="true">TRUE</option>
													  <option value="false">FALSE</option>
													</select>
												  </td>
                                                </tr>
                                                <tr>
                                                  <td class="tm_left_slim">configLocation</td>
                                                  <td class="tm_text_slim"><input id="configLocation" class="input_topinq" type="text" style="width:100%;"/></td>
                                                </tr>
                                                <tr>
                                                  <td  class="tm_left_slim">driverClassName</td>
                                                  <td class="tm_text_slim"><input id="driverClassName" class="input_topinq" type="text" style="width:100%;" /></td>
                                                </tr>
                                                <tr>
                                                  <td class="tm_left_slim">url</td>
                                                  <td class="tm_text_slim"><input id="url" class="input_topinq" type="text"style="width:100%;" /></td>
                                                </tr>
                                                <tr>
                                                  <td class="tm_left_slim">username</td>
                                                  <td class="tm_text_slim"><input id="username"  class="input_topinq" type="text" maxlength="30" size="30" /></td>
                                                </tr>
                                                <tr>
                                                  <td class="tm_left_slim">password</td>
                                                  <td class="tm_text_slim"><input id="password" class="input_topinq" type="text" maxlength="30" size="30" /></td>
                                                </tr>
                                                <tr>
                                                  <td class="tm_left_slim">initialSize</td>
                                                  <td class="tm_text_slim"><input id="initialSize" class="input_topinq" type="text" maxlength="10" size="10" /></td>
                                                </tr>
                                                <tr>
                                                  <td class="tm_left_slim">maxActive</td>
                                                  <td class="tm_text_slim"><input id="maxActive" class="input_topinq" type="text" maxlength="10" size="10" /></td>
                                                </tr>
                                                <tr>
                                                  <td class="tm_left_slim">maxIdle</td>
                                                  <td class="tm_text_slim"><input id="maxIdle" class="input_topinq" type="text" maxlength="10" size="10" /></td>
                                                </tr>
                                                <tr>
                                                  <td class="tm_left_slim">minIdle</td>
                                                  <td class="tm_text_slim"><input id="minIdle" class="input_topinq" type="text" maxlength="10" size="10" /></td>
                                                </tr>
                                                <tr>
                                                  <td class="tm_left_slim">minEvictableIdleTimeMillis</td>
                                                  <td class="tm_text_slim"><input id="minEvictableIdleTimeMillis" class="input_topinq" type="text" maxlength="10" size="10" /></td>
                                                </tr>
                                                <tr>
                                                  <td class="tm_left_slim">timeBetweenEvictionRunsMillis</td>
                                                  <td class="tm_text_slim"><input id="timeBetweenEvictionRunsMillis" class="input_topinq" type="text" maxlength="10" size="10" /></td>
                                                </tr>
                                                <tr>
                                                  <td class="tm_left_slim">jndiName</td>
                                                  <td class="tm_text_slim"><input id="jndiName" class="input_topinq" type="text" maxlength="30" size="30" /></td>
                                                </tr>
                                                
                                              </table></td>
                                          </tr>
                                        </table>
                                        </form>
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                      <tr>
                                        <td height="5" colspan="2"></td>
                                      </tr>
                                      <tr>
                                        <td><table border="0" align="left" cellpadding="0" cellspacing="0">
                                          <tr>
                                            <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                            <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer;" onclick="addRow();">
                                            	추 가
                                            </td>
                                            <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                          </tr>
                                        </table>
                                          <table border="0" align="left" cellpadding="0" cellspacing="0">
                                          <tr>
                                            <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                            <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer;" onclick="delRow();">
                                            	삭 제
                                            </td>
                                            <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                          </tr>
                                        </table></td>
                                        <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                                          <tr>
                                            <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                            
                                            <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer;" onclick="saveRow();">
                                            	저 장
                                            </td>
                                            <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                          </tr>
                                        </table></td>
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
    
</body>
</html>