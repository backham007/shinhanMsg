<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>전문 테스트로(TESTRO) </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<script type="text/javascript" src="js/cmn/utils/json2.js" charset="utf-8"></script>
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
<script type="text/javascript" src="js/cmn/common.js" charset="UTF-8"></script>
<script type="text/javascript" src="jqgrid/js/jquery-1.5.2.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/jquery.blockUI.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/src/i18n/grid.locale-en.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/jquery.jqGrid.src.js" charset="utf-8"></script>
<script type="text/javascript" src="js/msg/layout/layout.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/util.js" charset="utf-8"></script>

</head>
<body leftmargin="0" topmargin="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="43"><img src="images/pop_tit_01.gif" width="43" height="51"></td>
    <td background="images/pop_tit_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
		<c:choose>
			<c:when test="${fldDiv == 'all'}">
				<td class="pop_tit">헤더부/거래코드 조회</td>
			</c:when>
			<c:when test="${fldDiv == '01'}">
				<td class="pop_tit">헤더부코드 조회</td>
			</c:when>
			<c:otherwise>
				<td class="pop_tit">거래코드 조회</td>
			</c:otherwise>
		</c:choose>
      </tr>
    </table></td>
    <td width="216"><img src="images/pop_tit_03.gif" width="216" height="51"></td>
  </tr>
</table>

 <form name="layout" id="layout" method="post">
<input type="hidden" name="tabGb">
<input type="hidden" id="chnlDstcd" name="chnlDstcd" value="${chnlDstcd}">
<input type="hidden" id="fldDiv" name="fldDiv" value="${fldDiv}">

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
                          <c:choose>
	                          <c:when test="${fldDiv == 'all'}">
	                          		<td width="120" class="box_txt_red">헤더부/거래코드 : </td>
	                          </c:when>
	                          <c:when test="${fldDiv == '01'}">
	                          		<td width="80" class="box_txt_red">헤더부코드 : </td>
	                          </c:when>
	                          <c:otherwise>
	                          		<td width="65" class="box_txt_red">거래코드 : </td>
	                          </c:otherwise>
                            </c:choose>
                            <td>
                            	<input name="tranCd" id="tranCd" type="text" class="input_topinq" style="width:120px; ime-mode:disabled;" value="" onKeyDown="if(event.keyCode ==13){javascript:layoutList();}">
                            	<img src="images/btn_eraser.gif" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" onClick="{$('#tranCd').val('').focus()}" style="cursor: pointer">
                            </td>
                            
                            <c:choose>
	                          <c:when test="${fldDiv == 'all'}">
	                          		<td width="110" class="box_txt">헤더부/거래명 : </td>
	                          </c:when>
	                          <c:when test="${fldDiv == '01'}">
	                          		<td width="70" class="box_txt">헤더부명 : </td>
	                          </c:when>
	                          <c:otherwise>
	                          		<td width="60" class="box_txt">거래명 : </td>
	                          </c:otherwise>
                            </c:choose>
                            <td>
                            	<input name="tranName" id="tranName" type="text" class="input_topinq" style="width:150px" value="" onKeyDown="if(event.keyCode ==13){javascript:layoutList();}">
                            	<img src="images/btn_eraser.gif" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" onClick="{$('#tranName').val('').focus()}" style="cursor: pointer">
                            </td>
                            <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                              <tr>
                                <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                <td background="images/btn_img_02.gif" class="btn_text" id="layoutList" style="cursor:pointer" onClick="layoutList();">조 회</td>
                                  <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                              </tr>
                            </table></td>
                          </tr>
                        </table>
                          </td>
                    </tr>
                </table></td>
              </tr>
            </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="10"></td>
                </tr>
              </table>
              <table width="100%" height="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                <tr>
                  <td height="100%" valign="top" bgcolor="#FFFFFF">
                  	<!-- 그리드 -->	<table id="list"></table> 
  					<div id="pager"></div>
                  </td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="10"></td>
                </tr>
              </table>
              <TABLE cellSpacing="0" cellPadding="0" width="100%" border="0">
                <TR>
                  <TD width="4"><IMG height="31" src="images/tabbg_01_01.gif" width="4"></TD>
                  <TD background="images/tabbg_01_02.gif"><!-- Menu -->
                      <TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
                        <TR>
                          <TD>&nbsp;</TD>
                          <TD><TABLE cellspacing="0" cellpadding="0" border="0">
                              <TR>
                                <TD id="fldDivH"><DIV id="view0_on">
                                    <TABLE cellspacing="0" cellpadding="0" border="0">
                                      <TR>
                                        <TD width=5 background="images/tab_01.gif" height=30>&nbsp;</TD>
                                        <TD class='tab_tit' background=images/tab_02.gif  style="cursor:pointer" onclick="doSearch('view0');">헤더부</TD>
                                        <TD width=5 background=images/tab_03.gif></TD>
                                      </TR>
                                    </TABLE>
                                </DIV>
                                    <DIV id="view0_off">
                                      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                                        <TR>
                                          <TD width=3 background="images/btn_bg_02_01.jpg"><IMG height=30 src="images/tab01_01.gif" width=4></TD>
                                          <TD class='tab_tit02' vAlign="center" background="images/tab01_02.gif" onclick="doSearch('view0');" ><FONT style="cursor:pointer">헤더부</FONT></TD>
                                          <TD vAlign=bottom background="images/btn_bg_02_02.jpg"><IMG height=30 src="images/tab03_03.gif" width=3></TD>
                                        </TR>
                                      </TABLE>
                                    </DIV></TD>
                                <TD width=2>&nbsp;</TD>
                                <TD id="fldDivI" ><DIV id="view1_on">
                                    <TABLE cellSpacing=0 cellPadding=0 border=0>
                                      <TR>
                                        <TD width=5 background="images/tab_01.gif" height=30>&nbsp;</TD>
                                        <TD class='tab_tit' background="images/tab_02.gif" onclick="doSearch('view1');"><FONT style="cursor:pointer" >개별부</FONT></TD>
                                        <TD width=5 background="images/tab_03.gif"></TD>
                                      </TR>
                                    </TABLE>
                                </DIV>
                                <DIV id="view1_off">
                                    <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                                      <TR>
                                        <TD width=3 background=images/btn_bg_02_01.jpg><IMG height=30 src="images/tab01_01.gif" width=4></TD>
                                        <TD class='tab_tit02'  vAlign=center background="images/tab01_02.gif" onclick="doSearch('view1');"><FONT style="cursor:pointer">개별부</FONT></TD>
                                        <TD vAlign=bottom background="images/btn_bg_02_02.jpg"><IMG height=30 src="images/tab03_03.gif" width=3></TD>
                                      </TR>
                                    </TABLE>
                                </DIV></TD>
                                 <TD id="fldDivI2" style="DISPLAY:none"><DIV id="view1_on">
                                    <TABLE cellSpacing=0 cellPadding=0 border=0>
                                      <TR>
                                        <TD width=5 background="images/tab_01.gif" height=30>&nbsp;</TD>
                                        <TD class='tab_tit' background="images/tab_02.gif" onclick="doSearch('view1');"><FONT style="cursor:pointer" >헤더부</FONT></TD>
                                        <TD width=5 background="images/tab_03.gif"></TD>
                                      </TR>
                                    </TABLE>
                                </DIV>
                               </TD>
                                <TD width=2>&nbsp;</TD>
                                </TR>
                          </TABLE></TD>
                        </TR>
                    </TABLE></TD>
                  <TD width=4><IMG height=31 src="images/tabbg_01_03.gif" width=4></TD>
                </TR>
                <TR>
                  <TD width=3 background="images/tabbg_02_01.gif" bgColor=#456788></TD>
                  <TD vAlign=top width="100%" >
                  	<div id="layoutDiv" style=" height:250px; width:925px" class="apDiv1">  
                  	</div>
                  </TD>
                  <TD width=3 height="100%" background="images/tabbg_02_03.gif" bgColor=#456788></TD>
                </TR>
                <TR>
                  <TD width=4 height=4><IMG height=4 src="images/tabbg_03_01.gif" width=4></TD>
                  <TD background=images/tabbg_03_02.gif><IMG height=4 src="images/tabbg_03_02.gif" width=3></TD>
                  <TD width=4 height=4><IMG height=4 src="images/tabbg_03_03.gif" width=4></TD>
                </TR>
              </TABLE>
              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="5" colspan="3"></td>
                </tr>
                <tr>
                  <td><table border="0" align="left" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
						<td background="images/btn_img_02.gif" class="btn_text" id="getData" style="cursor:pointer">적 용</td>
                        <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                      </tr>
                  </table>
                    </td>
                  <td ><table align="right" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                          <td background="images/btn_img_02.gif" class="btn_text" onclick="self.close();" style="cursor:pointer">닫 기</td>
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