<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>전문 테스트로(TESTRO)</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
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
<script>
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
<script type="text/javascript" src="js/cmn/util.js" charset="utf-8"></script>
<script type="text/javascript" src="js/msg/tsmng/outputdatamng.js?201203071824" charset="utf-8"></script>

</head>

<body leftmargin="0" topmargin="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="43"><img src="images/pop_tit_01.gif" width="43" height="51"></td>
    <td background="images/pop_tit_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="pop_tit">입출력값 활용 정보관리</td>
      </tr>
    </table></td>
    <td width="200"><img src="images/pop_tit_03.gif" width="200" height="51"></td>
  </tr>
</table>
<form name="frm" method="post" action="">
<input type="hidden" id="currTsSnrioID" name="currTsSnrioID" value="${tsSnrioID}" />
<input type="hidden" id="currTsSnrioNO" name="currTsSnrioNO" value="${tsSnrioNO}" />
<input type="hidden" id="currTsdataID" name="currTsdataID" value="${tsdataID}" />
<input type="hidden" id="currChnlDstcd" name="currTsdataID" value="${chnlDstcd}" />
<input type="hidden" id="currTranCd" name="currTsdataID" value="${tranCd}" />

<input type="hidden" id="preFldDiv" name="preFldDiv" />
<input type="hidden" id="preFldName" name="preFldName" />
<input type="hidden" id="preFldDesc" name="preFldDesc" />
<input type="hidden" id="preFldAttrib" name="preFldAttrib" />
<input type="hidden" id="preFldRptName" name="preFldRptName" />
<input type="hidden" id="preFldRptCnt" name="preFldRptCnt" />
<input type="hidden" id="useFldDiv" name="useFldDiv" />
<input type="hidden" id="useFldName" name="useFldName" />
<input type="hidden" id="useFldDesc" name="useFldDesc" />
<input type="hidden" id="useFldAttrib" name="useFldAttrib" />
<input type="hidden" id="useFldRptName" name="useFldRptName" />
<input type="hidden" id="useFldRptCnt" name="useFldRptCnt" />

<input type="hidden" id="selTsIONO" />

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
                      <td bgcolor="#FFFFFF">
                      <table width="100%" border="0" cellpadding="2" cellspacing="0">
                          <tr>
                            <td width="100" class="box_txt">시나리오 ID :</td>
                            <td width="200" id="titleTsSnrioID" >&nbsp;</td>
                            <td width="110" class="box_txt">테스트데이터 ID :</td>
                            <td width="200" id="titleTsdataID">&nbsp;</td>
                            <td width="110" class="box_txt">테스트수행 순서 :</td>
                            <td id="titleTsSnrioNO">&nbsp;</td>
                          </tr>
                          <tr>
                          	<td class="box_txt_red">이전수행 순서 :</td>
                          	<td><select id="preSnrioNO" name="preSnrioNO" class="menu" style="width:80px"></select></td>
                            <!-- td><input id="preSnrioNO" name="preSnrioNO" type="text" class="input_topinq" style="width:120px"></td -->
                            <td class="box_txt_red">입출력 구분 :</td>
                            <td colspan="2"><select id="divisionIO" name="divisionIO" class="menu" style="width:120px"></select></td>
                          </tr>
                      </table>
                      <table width="100%" border="0" cellpadding="2" cellspacing="0">  
                          <tr>
                          	<td colspan="2">
                          		<table width="85%" border="0" cellpadding="2" cellspacing="1">
                          			<tr>
                          				<td class="sub_tit02">원데이터 헤더부 필드</td>
                          			</tr>
				            		<tr>
				            			<td id="case" valign="top" bgcolor="#FFFFFF">
				            				<table id="jqGridTable2"></table>
				            			</td>
				            		</tr>
				            		<tr>
                          				<td class="sub_tit02">원데이터 개별부 필드</td>
                          			</tr>
				            		<tr>
				            			<td id="case" valign="top" bgcolor="#FFFFFF">
				            				<table id="jqGridTable3"></table>
				            			</td>
				            		</tr>
				            	</table>
                          	</td>
                          	<td colspan="2">
                          		<table width="85%" border="0" cellpadding="2" cellspacing="1">
                          			<tr>
                          				<td class="sub_tit02">대상데이터 헤더부 필드</td>
                          			</tr>
				            		<tr>
				            			<td id="case" valign="top" bgcolor="#FFFFFF">
				            				<table id="jqGridTable4"></table>
				            			</td>
				            		</tr>
				            		<tr>
                          				<td class="sub_tit02">대상데이터 개별부 필드</td>
                          			</tr>
                          			<tr>
				            			<td id="case" valign="top" bgcolor="#FFFFFF">
				            				<table id="jqGridTable5"></table>
				            			</td>
				            		</tr>
				            	</table>
                          	</td>
                          </tr>
                          <tr>
                          	<td class="box_txt_red" width="100">원데이터필드 :</td>
                            <td>
                                <input id="preFld" name=preFld type="text" class="input_topinq" style="width:460px" readonly="readonly">
                                <!-- img id="btnSearchColumn1" src="images/btn_pop.gif" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer"-->
                            </td>
                            <td class="box_txt_red" width="110">대상데이터필드 :</td>
                            <td>
                                <input id="useFld" name="useFld" type="text" class="input_topinq" style="width:440px" readonly="readonly">
                                <!-- img id="btnSearchColumn2" src="images/btn_pop.gif" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer"-->
                            </td>
                          </tr>
                          <tr>
                            <td class="box_txt">조 건 식 :</td>
                            <td colspan="3">
                                <select id="cndnStylCtntType" name="cndnStylCtntType" class="menu" style="width:120px" onchange="outputdatamng.changeCndnStylCtnt();">
                                </select>
                              <input id="cndnStylCtntContent" name="cndnStylCtntContent" type="text" class="input_topinq" style="width:132px" maxlength="45" disabled="disabled">
                              <img id="btnAppendCndnStyl" src="images/btn_add.jpg" width="23" height="21" align="absmiddle" style="cursor:pointer">
                              <input id="cndnStylCtnt" name="cndnStylCtnt" type="text" class="input_topinq" style="width:400px" maxlength="50" />
                              <img id="btnHelp" src="images/btn_qa.jpg" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer">
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
                  <td height="5" colspan="3"></td>
                </tr>
                <tr>
                  <td><table align="left" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                      <td id="btnRegister" background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer;">등 록</td>
                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                    </tr>
                  </table>
                  <table align="left" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                      <td id="btnModify" background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer;">수 정</td>
                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                    </tr>
                  </table>
                  <table align="left" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                      <td id="btnInviMapping" background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer;">개별부 일괄매핑</td>
                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                    </tr>
                  </table></td>
                  <td ><table align="right" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                          <td id="btnDelete" background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer;">삭 제</td>
                          <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                        </tr>
                      </table>
                    </td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td width="18%" height="10"></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td class="sub_tit02">입출력값 활용정보</td>
                  <td id="titleSelTsIONO" style="color: #c10381;"></td>
                  <td id="totalCount" align="right" class="point_result"></td>
                </tr>
              </table>
              
              <table border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                  <tr>
                      <td id="case" valign="top" bgcolor="#FFFFFF">
                          <table id="jqGridTable"></table>
                      </td>
                  </tr>
              </table>
              
              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="5" colspan="3"></td>
                </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td ><table align="right" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                        <td id="btnClose" background="images/btn_img_02.gif" class="btn_text" style="cursor: pointer">닫 기</td>
                        <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                      </tr>
                  </table></td>
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
