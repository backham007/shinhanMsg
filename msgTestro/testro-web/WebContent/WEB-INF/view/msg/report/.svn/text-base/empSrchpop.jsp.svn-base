<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
<script type="text/javascript" src="jqgrid/js/jquery-1.5.2.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/jquery.blockUI.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/src/i18n/grid.locale-en.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/jquery.contextmenu-fixed.js" charset="utf-8"></script>  
<script type="text/javascript" src="jqgrid/js/jquery.jqGrid.src.js" charset="utf-8"></script>

<script type="text/javascript" src="js/cmn/util.js" charset="utf-8"></script>
<script type="text/javascript" src="js/msg/report/empSrchpop.js" charset="utf-8"></script>
</head>

<body leftmargin="0" topmargin="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="43"><img src="images/pop_tit_01.gif" width="43" height="51"></td>
    <td background="images/pop_tit_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="pop_tit">사용자 조회</td>
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
                          <tr>
                            <td width="120" class="box_txt_red">프로젝트 번호/명 :</td>
                            <td><input id="projNo" name="projNo" type="text" class="input_topinq" style="width:120px"  value="${sessionScope.userinfo.projno}" maxlength="20">
                              <img id="prt_srch" src="images/btn_pop.gif" alt="프로젝트조회" width="23" height="21" hspace="4" align="absmiddle" style="cursor: pointer;">
                              <input id="projName" name="projName" type="text" class="input_topinq" style="width:290px" value="${sessionScope.userinfo.projname}" maxlength="250"></td>
                            </tr>
                          <tr>
                            <td class="box_txt">사용자 명 :</td>
                            <td><input id="usrname" name=usrname type="text" class="input_topinq" style="width:150px" maxlength="15"></td>
                          </tr>
                        </table>
                          </td>
                    </tr>
                </table></td>
              </tr>
            </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="5"></td>
                </tr>
                <tr>
                  <td height="10"><table border="0" align="right" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                      <td id="rpt_srch" background="images/btn_img_02.gif" class="btn_text" style="cursor: pointer;">조 회</td>
                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                    </tr>
                  </table>
                  </td>
                </tr>
              </table>
              <table width="100%" height="100" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                <tr>
                  <td height="360" valign="top" bgcolor="#FFFFFF"><table id="list"></table> 
					<div id="pager"></div></td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="5" colspan="3"></td>
                </tr>
                <tr>
                  <td><table  align="left" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                        <td id="btn_app" background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer">적 용</td>
                        <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                      </tr>
                  </table>
                    </td>
                  <td ><table align="right" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                          <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer;" onclick="window.close();return false;">닫 기</td>
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
