<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>전문 테스트로(TESTRO)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="jqgrid/js/jquery-1.5.2.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/jquery.blockUI.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/util.js" charset="utf-8"></script>
<script type="text/javascript" src="js/msg/layout/registerLayoutPop.js" charset="utf-8"></script>
<script>
// iframe resize
function autoResize(i)
{
    var iframeHeight=
    (i).contentWindow.document.body.scrollHeight;
    (i).height=iframeHeight+20;
}
</script>
</head>

<body leftmargin="0" topmargin="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="43"><img src="images/pop_tit_01.gif" width="43" height="51"></td>
    <td background="images/pop_tit_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="pop_tit">전문저장</td>
      </tr>
    </table></td>
    <td width="216"><img src="images/pop_tit_03.gif" width="216" height="51"></td>
  </tr>
</table>
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
                          <tr style="display: none">
                            <td width="100" class="box_txt_red">채널구분 :</td>
                            <td><select id="chnlDstcd" name="select" class="menu" style="width:120px" onChange="setRefTranCd();">
                            </select></td>
                          </tr>
                          <tr>
                            <td width="100" class="box_txt_red">필드구성 :</td>
                            <td>
                            	<select id="fldDiv" name="select" class="menu" style="width:120px" onChange="setRefTranCd();"></select>
                            </td>
                            <td id="refTranCdTitle" class="box_txt">헤더부참조코드 :</td>
                            <td>
                            	<input id="refTranCd" name="refTranCd" type="text" class="input_topinq" maxlength="30" style="width:120px" readOnly>
                            	<img id="refTranCdImg" src="images/btn_pop.gif" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer" onClick="getHeaderList();">
                            </td>
                          </tr>
                          <tr>
                            <td id="tranCdTitle" class="box_txt_red">거래코드 :</td>
                            <td colspan="3"><input id="tranCd" name="textfield2" type="text" class="input_topinq" maxlength="30" style="width:100%; ime-mode:disabled;" onPaste="javascript:return false;"></td>
                            </tr>
                          <tr>
                            <td id="tranNameTitle" class="box_txt">거래명 :</td>
                            <td colspan="3"><input id="tranName" name="textfield" type="text" class="input_topinq" maxlength="500" style="width:100%"></td>
                            </tr>
                        </table>
                          </td>
                    </tr>
                </table></td>
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
                      <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onClick="submit();">저 장</td>
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