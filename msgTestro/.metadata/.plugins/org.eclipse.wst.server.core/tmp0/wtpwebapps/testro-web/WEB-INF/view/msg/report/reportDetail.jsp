<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>전문 테스트로(TESTRO)</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
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
<script type="text/javascript" src="js/cmn/jquery.cookie.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/utils/json2.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/util.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/popupcalendar.js" charset="utf-8"></script>
<script type="text/javascript" src="js/msg/report/reportDetail.js"></script>
<script type="text/javascript" src="js/msg/flaw/flawMng.js"></script>
<script type="text/javascript" src="js/msg/flaw/flawTreat.js"></script>
</head>

<body leftmargin="0" topmargin="0">
<input id="gubun" type="hidden" value="${gubun}" />
<input id="tsCaseID" type="hidden" value="${tsCaseID}" />
<input id="tssnroId" type="hidden" value="${tssnroId}" />
<input id="tsDataId" type="hidden" value="${tsDataId}" />
<input id="tsDataAcmplnth" type="hidden" value="${tsDataAcmplnth}" />
<input id="tabGubun" type="hidden" value="${tabGubun}" />
<input id="paramDefNo" type="hidden" value="${defNo}" />
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="43"><img src="images/pop_tit_01.gif" width="43" height="51"></td>
    <td background="images/pop_tit_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="pop_tit">결과보고서 상세조회</td>
      </tr>
    </table></td>
    <td width="216"><img src="images/pop_tit_03.gif" width="216" height="51"></td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="3">
  <tr>
    <td valign="top">
<table width="100%" height="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#baccdc">
<tr>
<td bgcolor="#e1e9f0">
    <table width="100%" height="100%" border="0" cellpadding="5" cellspacing="0">
        <tr>
            <td valign="top" bgcolor="#FFFFFF">
                <table width="100%" border="0" cellpadding="5" cellspacing="1"  bgcolor="#baccdc">
                    <tr>
                        <td bgcolor="#e1e9f0">
                            <table width="100%" border="0" cellspacing="0" cellpadding="5">
                                <tr>
                                    <td bgcolor="#FFFFFF">
                          				<table width="100%" border="0" cellpadding="2" cellspacing="0">
                                            <tr>
                                                <td width="145" class="box_txt">프로젝트 ID/명 :</td>
                                                <td>[${rptMaster.projno}]${rptMaster.projname}</td>
                                              <td width="95" class="box_txt">테스트 단계 :</td>
                                                <td width="160">${rptMaster.teststgename}</td>
                                          </tr>
                                            <tr>
                                                <td class="box_txt">
                                            	<c:choose>
	                                            	<c:when test="${'01' == gubun}">
														테스트 케이스 ID/명 :
													</c:when>
	                                            	<c:when test="${'02' == gubun}">
														테스트 시나리오 ID/명 :
													</c:when>
												</c:choose>
												</td>
                                                <td>
                                            	<c:choose>
	                                            	<c:when test="${'01' == gubun}">
														[${rptMaster.tscaseid}]${rptMaster.tscasename}
													</c:when>
	                                            	<c:when test="${'02' == gubun}">
														[${rptMaster.tssnrioid}]${rptMaster.tssnrioname}
													</c:when>
												</c:choose>
                                                </td>
                                                <td class="box_txt">실행결과/회차 :</td>
                                                <td><IMG src="${rptMaster.rsultsucssyn == 'Y' ? 'images/icon_rep_ok.gif' : 'images/icon_rep_fail.gif'}" width=34 height=16 hspace="2" vspace="3" align="absmiddle" border=0>  ${rptMaster.acmplnth}회차</td>
                                            </tr>
                                            <tr>
                                                <td class="box_txt">테스트 시작/종료일시 :</td>
                                                <td>${rptMaster.teststartyms} ~ ${rptMaster.testendyms}</td>
                                                <td class="box_txt">테스트 실행자 :</td>
                                                <td>${rptMaster.tstrname}</td>
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
                  <td height="10" colspan="2"></td>
                </tr>
              </table>
              <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                <TR>
                  <TD width=4><IMG height=31 src="images/tabbg_01_01.gif" width=4></TD>
                  <TD background=images/tabbg_01_02.gif><!-- Menu -->
                      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                        <TR>
                          <TD width="200">&nbsp;</TD>
                          <TD><TABLE id="tabs" cellSpacing=0 cellPadding=0 border=0>
                            <TR>
                              <TD><TABLE cellSpacing=0 cellPadding=0 border=0>
                                <TR>
                                  <TD width=5 background="images/tab_01.gif" height=30></TD>
                                  <TD class="tab_tit" onClick="changeTab(0);" style='cursor: pointer'>테스트 결과</TD>
                                  <TD width=5 background="images/tab_03.gif"></TD>
                                </TR>
                              </TABLE>
                              </TD>
                              <TD width=2>&nbsp;</TD>
                              <td><TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                                <TR>
                                  <TD width=3><IMG height=30 src="images/tab01_01.gif" width=4></TD>
                                  <TD class="tab_tit02" onClick="changeTab(1);" style='cursor: pointer'>입력데이터</TD>
                                  <TD ><IMG height=30 src="images/tab03_03.gif" width=3></TD>
                                </TR>
                              </TABLE></TD>
                              <TD width=2>&nbsp;</TD>
                              <TD><TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                                  <TR>
                                    <TD width=3><IMG height=30 src="images/tab01_01.gif"></TD>
                                    <TD class="tab_tit02" onClick="changeTab(2);" style='cursor: pointer'>출력데이터</TD>
                                    <TD><IMG height=30 src="images/tab03_03.gif"></TD>
                                  </TR>
                              </TABLE></TD>
                              <TD width=2>&nbsp;</TD>
                              <TD><TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                                  <TR>
                                    <TD width=3><IMG height=30 src="images/tab01_01.gif"></TD>
                                    <TD class="tab_tit02" onClick="changeTab(3);" style='cursor: pointer'>체크포인트</TD>
                                    <TD><IMG height=30 src="images/tab03_03.gif" width=3></TD>
                                  </TR>
                              </TABLE></TD>
                              <TD width=2>&nbsp;</TD>
                              <TD><TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                                  <TR>
                                    <TD width=3><IMG height=30 src="images/tab01_01.gif" ></TD>
                                    <TD class="tab_tit02" onClick="changeTab(4);" style='cursor: pointer'>결함관리</TD>
                                    <TD ><IMG height=30 src="images/tab03_03.gif" width=3></TD>
                                  </TR>
                              </TABLE></TD>
                              <TD width=2>&nbsp;</TD>
                              <TD><TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                                  <TR>
                                    <TD width=3 ><IMG height=30 src="images/tab01_01.gif" width=4></TD>
                                    <TD class="tab_tit02" onClick="changeTab(5);" style='cursor: pointer'>결함조치</TD>
                                    <TD ><IMG height=30 src="images/tab03_03.gif" width=3></TD>
                                  </TR>
                              </TABLE></TD>
                            </TR>
                          </TABLE></TD>
                        </TR>
                      </TABLE>
                    <!-- Menu --></TD>
                  <TD width=4><IMG height=31 src="images/tabbg_01_03.gif" width=4></TD>
                </TR>
                <TR height="480">
                  <TD width=3 background="images/tabbg_02_01.gif" bgColor=#456788></TD>
                  <TD vAlign=top width="100%" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="200" valign="top"><TABLE cellSpacing=1 cellPadding=1 width=100% bgColor=#baccdc border=0>
                            <TR>
                              <TD height=25 class=tm_center>테스트데이터ID</TD>
                            </TR>
                          </TABLE>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="1"></td>
                              </tr>
                            </table>
                          <div id="apDiv2" style="height:480px;" class="apDiv1">
                              <TABLE height="100%" cellSpacing=1 cellPadding=2 width="100%" bgColor=#baccdc border=0>
                                <TR height="100%">
                                  <TD id="dataId_tb" vAlign=top align=top bgColor=#ffffff>
                                   	<!--<TABLE width="100%" border=0 cellPadding=0 cellSpacing=1 bordercolor="#FFFFFF" class="tap_box_fault_off">
                                      <TR>
                                        <TD><IMG src="images/icon_rep_fail.gif" width=34 height=16  hspace="2" vspace="3" align="absmiddle"  border=0><FONT style="cursor:pointer">&quot;tap_box_fault_off&quot;</FONT></TD>
                                      </TR>
                                    </TABLE>
                                    <TABLE width="100%" border=0 cellPadding=0 cellSpacing=1 bordercolor="#FFFFFF" >
                                      <TR>
                                        <TD class="tap_box_fault"><IMG src="images/icon_rep_fail.gif" width=34 height=16  hspace="2" vspace="3" align="absmiddle"  border=0><FONT style="cursor:pointer">C3CAR210000005</FONT></TD>
                                      </TR>
                                    </TABLE>
                                    <TABLE width="100%" border=0 cellPadding=0 cellSpacing=1 bordercolor="#FFFFFF" >
                                      <TR>
                                        <TD class="tap_box_ok"><IMG src="images/icon_rep_ok.gif" width=34 height=16 hspace="2" vspace="3" align="absmiddle" border=0><FONT style="cursor:pointer">&quot;tap_box_ok&quot;</FONT></TD>
                                      </TR>
                                    </TABLE>
                                    <TABLE width="100%" border=0 cellPadding=0 cellSpacing=1 bordercolor="#FFFFFF" class="tap_box_ok_off">
                                        <TR>
                                          <TD><IMG src="images/icon_rep_ok.gif" width=34 height=16 hspace="2" vspace="3" align="absmiddle" border=0><FONT style="cursor:pointer">C3CAR210000007</FONT></TD>
                                        </TR>
                                    </TABLE> -->
                                    <!-- table focus(성공/실패) --><!-- image button(성공/실패) -->
                                    <c:if  test="${!empty dataList}">
	                                    <c:forEach var="datalist" items="${dataList}" varStatus="status">
	                                    	<c:set var="td_class" value="" />
		                                    <c:choose>
		                                        <c:when test="${'Y' == datalist.rsultsucssyn && datalist.chekyn == 'N'}">
		                                        	<c:set var="tb_class" value="tap_box_ok_off" />
													<c:set var="img_src" value="images/icon_rep_ok.gif" />
												</c:when>
												<c:when test="${'Y' == datalist.rsultsucssyn && datalist.chekyn == 'Y'}">
		                                        	<c:set var="tb_class" value="tap_box_ok_off" />
													<c:set var="img_src" value="images/icon_rep_ok_green.gif" />
												</c:when>
		                                        <c:when test="${'N' == datalist.rsultsucssyn}">
		                                        	<c:set var="tb_class" value="tap_box_fault_off" />
													<c:set var="img_src" value="images/icon_rep_fail.gif" />
												</c:when>
											</c:choose>
											
		                                    <TABLE id="ltb_${datalist.tsdataid}_${datalist.tsdataacmplnth}" width="100%" border=0 cellPadding=0 cellSpacing=1 bordercolor="#FFFFFF" class="${tb_class}">
		                                      <TR>
		                                        <TD id="ltd_${datalist.tsdataid}_${datalist.tsdataacmplnth}" class="${td_class}">
		                                        <c:choose>
	                                            	<c:when test="${'01' == gubun}">
			                                        	<IMG src="${img_src}" width=34 height=16 hspace="2" vspace="3" align="absmiddle" border=0><FONT id="${status.count}||${datalist.rsultsucssyn}||${datalist.tscaseid}||${datalist.acmplnth}||${datalist.tsdataid}||${datalist.tsdataacmplnth}" style="cursor: pointer;">${datalist.tsdataid}</FONT>
		                                        	</c:when>
		                                        	<c:when test="${'02' == gubun}">
		                                        		<IMG src="${img_src}" width=34 height=16 hspace="2" vspace="3" align="absmiddle" border=0><FONT id="${status.count}||${datalist.rsultsucssyn}||${datalist.tssnrioid}||${datalist.acmplnth}||${datalist.tsdataid}||${datalist.tsdataacmplnth}" style="cursor: pointer;">${datalist.tsdataid}</FONT>
		                                        	</c:when>
		                                        </c:choose>
		                                        </TD>
		                                      </TR>
		                                    </TABLE>
	                                    </c:forEach>
                                    </c:if>
                                  </TD>
                                </TR>
                              </TABLE>
                          </div></td>
                        <td width="2" valign="top">&nbsp;</td>
                        <td valign="top"><div id="apDiv1" style=" height:507px; padding:1px;" class="apDiv1">
						<!-- tab 변경부 -->
                        </div></td>
                      </tr>
                  </table></TD>
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
                  <td><table align="left" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                      <c:if test="${gubun == '01'}">
                      	<td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer;" onclick="moveCase();">테스트화면</td>
                      </c:if>
                      <c:if test="${gubun == '02'}">
                      	<td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer;" onclick="moveSnrio();">테스트화면</td>
                      </c:if>
                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                    </tr>
                  </table></td>
                  <td ><table align="right" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                          <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onClick="self.close();">닫 기</td>
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
<!-- Start of wrap -->
</body>
</html>