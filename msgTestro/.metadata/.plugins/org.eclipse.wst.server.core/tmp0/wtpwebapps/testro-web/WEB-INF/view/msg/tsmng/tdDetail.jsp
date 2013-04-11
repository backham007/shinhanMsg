<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>전문 테스트로(TESTRO)</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<link href="css/style.css" rel="stylesheet" type="text/css">
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
<script type="text/javascript" src="js/msg/tsmng/tdDetail.js?201202141819" charset="utf-8"></script>

<base target="_self">

</head>

<body leftmargin="0" topmargin="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="43"><img src="images/pop_tit_01.gif" width="43" height="51"></td>
    <td background="images/pop_tit_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="pop_tit">테스트데이터 수정</td>
      </tr>
    </table></td>
    <td width="216"><img src="images/pop_tit_03.gif" width="216" height="51"></td>
  </tr>
</table>

<form name="frm" method="post" action="">
<input type="hidden" id="selInd" name="selInd" value="${selInd}" />
<input type="hidden" id="selTd" name="selTd" />

<input type="hidden" id="tsdataID" name="tsdataID" value="${testDataDto.tsdataID}" />
<input type="hidden" id="tsdataName" name="tsdataName" value="${testDataDto.tsdataName}" />
<input type="hidden" id="tsdataDesc" name="tsdataDesc" value="${testDataDto.tsdataDesc}" />
<input type="hidden" id="chnlDstcd" name="chnlDstcd" value="${testDataDto.chnlDstcd}" />
<input type="hidden" id="scrptID" name="scrptID" value="${testDataDto.scrptID}" />
<input type="hidden" id="tranCd" name="tranCd" value="${testDataDto.tranCd}" />
<input type="hidden" id="tranName" name="tranName" value="${testDataDto.tranName}" />
<input type="hidden" id="mgrLvelDstcd" name="mgrLvelDstcd" value="${testDataDto.mgrLvelDstcd}" />
<input type="hidden" id="createDivCd" name="createDivCd" value="${testDataDto.createDivCd}" />
<input type="hidden" id="osidOferYn" name="osidOferYn" value="${testDataDto.osidOferYn}" />
<input type="hidden" id="chkYN" name="chkYN" value="${testDataDto.chkYN}" />
<input type="hidden" id="rmark" name="rmark" value="${testDataDto.rmark}" />

<input type="hidden" id="chkYNVal" name="chkYNVal" value='${chkYNVal}'/>

<!-- input type="hidden" id="isChangeChkYNVal" name="isChangeChkYNVal" value="N" /-->
<input type="hidden" id="rptMap" name="rptMap" value='${rptMap}'/>

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
                            <td width="115" class="box_txt">테스트데이터 ID :</td>
                            <td width="300">${testDataDto.tsdataID}</td>
                            <td width="115" class="box_txt">테스트데이터 명 :</td>
                            <td width="300">${testDataDto.tsdataName}</td>
                            </tr>
                          <tr>
                            <td class="box_txt">테스트데이터 설명 :</td>
                            <td colspan="3">${testDataDto.tsdataDesc}</td>
                            </tr>
                          <tr>
                            <td class="box_txt">거래코드/명 :</td>
                            <td colspan="3">${testDataDto.tranCd} / ${testDataDto.tranName}</td>
                          </tr>
                        </table>
                          </td>
                    </tr>
                </table></td>
              </tr>
            </table>

              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="10" colspan="3"></td>
                </tr>
                <tr>
                  <td width="120" class="sub_tit02">헤더부</td>
                  <td>&nbsp;</td>
                </tr>
              </table>
              <table width="100%" height="150" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                <tr>
                  <td height="150" valign="top" bgcolor="#FFFFFF">
                   <div id="apDiv1" style=" height:172px;" class="apDiv1">
                      <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc" style="table-layout: fixed;">
                      	<c:set var="fleldIndex" value="0"/>
                        <c:forEach items="${testDataDto.headerList}" var="tdDetailDto" varStatus="status">
                            <c:if test="${tdDetailDto.rptName == null || tdDetailDto.rptName == ''}">
                                <c:if test="${fleldIndex%2 == 0}">
                                    <tr>
                                </c:if>
                                        <td width="25%" class="tm_left_slim">${tdDetailDto.tsdataFldName}(${tdDetailDto.tscsFldSizeCnt})/${tdDetailDto.tscsFldDesc}</td>
                                        <td width="25%" class="tm_text_slim">
                                            <input type="hidden" name="tsdataNO" value="${tdDetailDto.tsdataNO}" />
                                            <input type="hidden" name="tsdataFldName" value="${tdDetailDto.tsdataFldName}" />
                                            <input type="hidden" name="tscsFldDiv" value="${tdDetailDto.tscsFldDiv}" />
                                            <input type="hidden" name="tscsFldType" value="${tdDetailDto.tscsFldType}" />
                                            <input type="hidden" name="tscsFldAttrib" value="${tdDetailDto.tscsFldAttrib}" />
                                            <input type="hidden" name="tscsFldSizeCnt" value="${tdDetailDto.tscsFldSizeCnt}" />
                                            <input type="hidden" name="tscsFldDesc" value="${tdDetailDto.tscsFldDesc}" />
                                            <input type="hidden" name="tscsUsrFldDesc" value="${tdDetailDto.tscsUsrFldDesc}" />
                                            <input type="hidden" name="rmark" value="${tdDetailDto.rmark}" />
                                            <c:choose>
                                                <c:when test='${tdDetailDto.tscsFldAttrib == "03"}'>
                                                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                                        <tr>
                                                            <td>
                                                                <input id="rptCnt_${tdDetailDto.tsdataFldName}" name="tsdataFldData" type="text" class="input_topinq" style="width:95%" maxlength="${tdDetailDto.tscsFldSizeCnt}" value="${tdDetailDto.tsdataFldData}" readonly>
                                                            </td>
                                                            <td width="80">
                                                                <table  border="0" cellpadding="0" cellspacing="0">
                                                                    <tr>
                                                                        <td width="6" height="20" background="images/btn_intable_01.jpg"></td>
                                                                        <td id="${tdDetailDto.tsdataFldName},${tdDetailDto.tscsFldDiv}" background="images/btn_intable_02.jpg" class="btn_intable btnRpt" style="cursor:pointer;">반복부 입력</td>
                                                                        <td width="4" background="images/btn_intable_03.jpg">&nbsp;</td>
                                                                    </tr>
                                                                </table>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </c:when>
                                                <c:otherwise>
                                                    <input type="text" name="tsdataFldData" class="input_topinq" maxlength="${tdDetailDto.tscsFldSizeCnt}" value="${tdDetailDto.tsdataFldData}" style="width: 99%" />
                                                </c:otherwise>
                                            </c:choose>
                                            
                                        </td>
                                <c:if test="${fleldIndex%2 == 1}">
                                    </tr>
                                </c:if>
                                <c:set var="fleldIndex" value="${fleldIndex+1}"/>
                            </c:if>
                        </c:forEach>
                      </table>
                  </div>
                  </td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="10" colspan="3"></td>
                </tr>
                <tr>
                  <td width="120" class="sub_tit02">개별부</td>
                  <td>&nbsp;</td>
                </tr>
              </table>
              <table width="100%" height="150" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                <tr>
                  <td height="150" valign="top" bgcolor="#FFFFFF">
                   <div id="apDiv1" style=" height:172px;" class="apDiv1">
                      <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc" style="table-layout: fixed;">
                      	<c:set var="fleldIndex" value="0"/>
                        <c:forEach items="${testDataDto.inviList}" var="tdDetailDto" varStatus="status">
                            <c:if test="${tdDetailDto.rptName == null || tdDetailDto.rptName == ''}">
	                            <c:if test="${fleldIndex%2 == 0}">
	                                <tr>
	                            </c:if>
		                                <td width="25%" class="tm_left_slim">${tdDetailDto.tsdataFldName}(${tdDetailDto.tscsFldSizeCnt})/${tdDetailDto.tscsFldDesc}</td>
		                                <td width="25%" class="tm_text_slim">
		                                    <input type="hidden" name="tsdataNO" value="${tdDetailDto.tsdataNO}" />
		                                    <input type="hidden" name="tsdataFldName" value="${tdDetailDto.tsdataFldName}" />
		                                    <input type="hidden" name="tscsFldDiv" value="${tdDetailDto.tscsFldDiv}" />
		                                    <input type="hidden" name="tscsFldType" value="${tdDetailDto.tscsFldType}" />
		                                    <input type="hidden" name="tscsFldAttrib" value="${tdDetailDto.tscsFldAttrib}" />
		                                    <input type="hidden" name="tscsFldSizeCnt" value="${tdDetailDto.tscsFldSizeCnt}" />
		                                    <input type="hidden" name="tscsFldDesc" value="${tdDetailDto.tscsFldDesc}" />
		                                    <input type="hidden" name="tscsUsrFldDesc" value="${tdDetailDto.tscsUsrFldDesc}" />
		                                    <input type="hidden" name="rmark" value="${tdDetailDto.rmark}" />
		                                    <c:choose>
			                                    <c:when test='${tdDetailDto.tscsFldAttrib == "03"}'>
			                                        <table width="100%" border="0" cellpadding="0" cellspacing="0">
			                                            <tr>
			                                                <td>
			                                                    <input id="rptCnt_${tdDetailDto.tsdataFldName}" name="tsdataFldData" type="text" class="input_topinq" style="width:95%" maxlength="${tdDetailDto.tscsFldSizeCnt}" value="${tdDetailDto.tsdataFldData}" readonly>
			                                                </td>
			                                                <td width="80">
			                                                    <table  border="0" cellpadding="0" cellspacing="0">
			                                                        <tr>
			                                                            <td width="6" height="20" background="images/btn_intable_01.jpg"></td>
			                                                            <td id="${tdDetailDto.tsdataFldName},${tdDetailDto.tscsFldDiv}" background="images/btn_intable_02.jpg" class="btn_intable btnRpt" style="cursor:pointer;">반복부 입력</td>
			                                                            <td width="4" background="images/btn_intable_03.jpg">&nbsp;</td>
			                                                        </tr>
			                                                    </table>
			                                                </td>
			                                            </tr>
			                                        </table>
			                                    </c:when>
	                                            <c:otherwise>
	                                                <input type="text" name="tsdataFldData" class="input_topinq" maxlength="${tdDetailDto.tscsFldSizeCnt}" value="${tdDetailDto.tsdataFldData}" style="width: 99%" />
	                                            </c:otherwise>
			                                </c:choose>
		                                    
		                                </td>
		                        <c:if test="${fleldIndex%2 == 1}">
	                                </tr>
	                            </c:if>
	                            <c:set var="fleldIndex" value="${fleldIndex+1}"/>
	                        </c:if>
                        </c:forEach>
                      </table>
                  </div>
                  </td>
                </tr>
              </table>

              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="5" colspan="3"></td>
                </tr>
                <tr>
                  <td width="60px"><table border="0" align="left" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                        <td id="btnSave" background="images/btn_img_02.gif" class="btn_text" style="cursor: pointer;">적 용</td>
                        <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                      </tr>
                  </table>
                  <td><table border="0" align="left" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                        <td id="btnMngCheck" background="images/btn_img_02.gif" class="btn_text" style="cursor: pointer;">체크포인트 관리</td>
                        <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                      </tr>
                  </table>
                    </td>
                  <td ><table align="right" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                          <td id="btnClose" background="images/btn_img_02.gif" class="btn_text" style="cursor: pointer;">닫 기</td>
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
