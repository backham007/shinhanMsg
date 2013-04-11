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
<script type="text/javascript">
// iframe resize
function autoResize(i)
{
    var iframeHeight=
    (i).contentWindow.document.body.scrollHeight;
    (i).height=iframeHeight+20;
}
</script>

<script type="text/javascript" src="js/cmn/utils/json2.js" charset="utf-8"></script>

<script type="text/javascript" src="js/cmn/common.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/popupcalendar.js" charset="utf-8"></script>
<script type="text/javascript" Src="js/cmn/validation_v01.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/jquery-1.5.2.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/jquery.blockUI.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/src/i18n/grid.locale-en.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/jquery.jqGrid.src.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/util.js" charset="utf-8"></script>
<script type="text/javascript" src="js/msg/tsmng/tsList.js?201202141819" charset="utf-8"></script>


</head>

<body leftmargin="0" topmargin="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="43"><img src="images/pop_tit_01.gif" width="43" height="51"></td>
    <td background="images/pop_tit_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="pop_tit">테스트시나리오 불러오기</td>
      </tr>
    </table></td>
    <td width="216"><img src="images/pop_tit_03.gif" width="216" height="51"></td>
  </tr>
</table>
<form id="frm" name="frm" method="post" action="">

<table width="100%" border="0" cellpadding="0" cellspacing="3">
  <tr>
    <td valign="top"><table width="100%" height="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#baccdc">
      <tr>
        <td bgcolor="#e1e9f0"><table width="100%" height="100%" border="0" cellpadding="5" cellspacing="0">
          <tr>
            <td valign="top" bgcolor="#FFFFFF">
            
            <table width="100%" border="0" cellpadding="5" cellspacing="1"  bgcolor="#baccdc">
              <tr>
                <td bgcolor="#e1e9f0"><table width="100%" border="0" cellspacing="0" cellpadding="5">
                    <tr>
                      <td bgcolor="#FFFFFF"><table width="100%" border="0" cellpadding="2" cellspacing="0">
                          <tr>
                            <td class="box_txt" width="65">조회구분 :</td>
                            <td colspan="3">
                                <select id="searchType" name="searchType" class="menu" style="width:120px"></select>
                                <input id="searchText" name="searchText" type="text" class="input_topinq" style="width:482px">
                                <img id="btnSearchTextDel" src="images/btn_eraser.gif" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" style="cursor: pointer" onclick="{$('#searchText').val('').focus()}"></td>
                                </td>
                            <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                              <tr>
                                <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                <td id="btnSearch" background="images/btn_img_02.gif" class="btn_text" style="cursor: pointer">조 회</td>
                                <td width="10" background="images/btn_img_03.gif" >&nbsp;</td>
                              </tr>
                            </table></td>
                            
                          </tr>
                          <tr>
                            <td class="box_txt">작성자명 :</td>
                            <td width="300">
                                <input type="text" id="writeName" name="writeName" style="width: 120px;" maxlength="50" class="input_topinq" value="${sessionScope.userinfo.usrname}">
                                <img id="btnWriterDel" src="images/btn_eraser.gif" alt="작성자명 지우기" width="23" height="21" hspace="4" align="absmiddle" style="cursor: pointer"></td>
                            <td class="box_txt"  width="65">작성일자 :</td>
                            <td width="300">
                              <input name="startDate" id="startDate" type="text" class="input_topinq" style="width:65px" readonly="readonly">
                              <img id="btnStartCalendar" src="images/un_sub_cen_cal.gif" alt="달력" width="23" height="21" hspace="4" align="absmiddle" style="cursor: pointer"> ~
                              <input name="endDate" id="endDate" type="text" class="input_topinq" style="width:65px" readonly="readonly">
                              <img id="btnEndCalendar" src="images/un_sub_cen_cal.gif" alt="달력" width="23" height="21" hspace="4" align="absmiddle" style="cursor: pointer">
                              <img id="btnDateDel" src="images/btn_eraser.gif" alt="작성일자 지우기"  height="21" hspace="4" align="absmiddle" style="cursor: pointer">
                              </td>
                            <td>&nbsp;</td>
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
                  <td width="120" class="sub_tit02">테스트시나리오 목록</td>
                  <td></td>
                </tr>
              </table>
              
              <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
	              <tr>
	                  <td id="case"valign="top" bgcolor="#FFFFFF">
			              <table id="tsSnroLstJqGridTable"></table>
			              <div id="tsSnroLstJqGridPager"></div>
			          </td>
			      </tr>
			  </table>
                                    
              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="10" colspan="3"></td>
                </tr>
                <tr>
                  <td width="120" class="sub_tit02">테스트데이터 목록</td>
                  <td><span id="selectTsTitle" class="point_result"></span></td>
                </tr>
              </table>
              
              <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                  <tr>
                      <td id="case" valign="top" bgcolor="#FFFFFF">
			              <table id="tdSnroLstJqGridTable"></table>
			              <div id="tdSnroLstJqGridPager"></div>
			          </td>
			      </tr>
			  </table>
              
              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="10" colspan="3"></td>
                </tr>
                <tr>
                  <td width="110" class="sub_tit02">테스트데이터 상세</td>
                  <td><span id="selectTdTitle" class="point_result"></span></td>
                </tr>
              </table>

              <table cellspacing="0" cellpadding="0" width="100%" border="0">
                <tr>
                  <td width="4"><img height="31" src="images/tabbg_01_01.gif" width="4"></td>
                  <td background="images/tabbg_01_02.gif"><!-- menu -->
                      <table cellspacing="0" cellpadding="0" width="100%" border="0">
                        <tr>
                          <td>&nbsp;</td>
                          <td><table cellspacing="0" cellpadding="0" border="0">
                             <tr>
                                <td>
                                    <div class="view0_on">
                                        <table cellspacing="0" cellpadding="0" border="0">
                                          <tr>
                                            <td width=5 background="images/tab_01.gif" height=30>&nbsp;</td>
                                            <td class=tab_tit background=images/tab_02.gif  style="cursor: pointer">헤더부</td>
                                            <td width=5 background=images/tab_03.gif>&nbsp;</td>
                                          </tr>
                                        </table>
                                    </div>
                                    <div class="view0_off">
                                      <table cellspacing=0 cellpadding=0 width="100%" border=0>
                                        <tr>
                                          <td width=3 background="images/btn_bg_02_01.jpg"><img height=30 src="images/tab01_01.gif" width=4></td>
                                          <td id="btnView0" class='tab_tit02' valign="middle" background="images/tab01_02.gif"><font style="cursor: pointer">헤더부</font></td>
                                          <td valign=bottom background="images/btn_bg_02_02.jpg"><img height=30 src="images/tab03_03.gif" width=3></td>
                                        </tr>
                                      </table>
                                    </div>
                                </td>
                                <td width=2>&nbsp;</td>
                                <td>
                                    <div class="view1_on">
                                        <table cellspacing=0 cellpadding=0 border=0>
                                          <tr>
                                            <td width=5 background=images/tab_01.gif height=30>&nbsp;</td>
                                            <td class=tab_tit background="images/tab_02.gif"><font style="cursor: pointer">개별부</font></td>
                                            <td width=5 background="images/tab_03.gif">&nbsp;</td>
                                          </tr>
                                        </table>
                                    </div>
                                </td>
                                <td>
                                    <div class="view1_off">
                                        <table cellspacing=0 cellpadding=0 width="100%" border=0>
                                          <tr>
                                            <td width=3 background=images/btn_bg_02_01.jpg><img height=30 src="images/tab01_01.gif" width=4></td>
                                            <td id="btnView1" class=tab_tit02  valign="middle" background="images/tab01_02.gif"><font style="cursor: pointer">개별부</font></td>
                                            <td valign=bottom background=images/btn_bg_02_02.jpg><img height=30 src="images/tab03_03.gif" width=3></td>
                                          </tr>
                                        </table>
                                    </div>
                                </td>
                             </tr>
                          </table></td>
                        </tr>
                    </table></td>
                  <td width=4><img height=31 src="images/tabbg_01_03.gif" width=4></td>
                </tr>
                <tr>
                  <td width=3 background="images/tabbg_02_01.gif" bgcolor=#456788></td>
                  <td valign=top width="100%" >
                    <div id="layoutDiv" style="height:107px;" class="apDiv1">
                    </div>
                  </td>
                  <td width=3 height="100%" background="images/tabbg_02_03.gif" bgcolor=#456788></td>
                </tr>
                <tr>
                  <td width=4 height=4><img height=4 src="images/tabbg_03_01.gif" width=4></td>
                  <td background=images/tabbg_03_02.gif><img height=4 src="images/tabbg_03_02.gif" width=3></td>
                  <td width=4 height=4><img height=4 src="images/tabbg_03_03.gif" width=4></td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="5" colspan="3"></td>
                </tr>
                <tr>
                  <td><table border="0" align="left" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                        <td id="btnSubmit" background="images/btn_img_02.gif" class="btn_text" style="cursor: pointer">적 용</td>
                        <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                      </tr>
                  </table>
                    </td>
                  <td ><table align="right" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                          <td id="btnClose" background="images/btn_img_02.gif" class="btn_text" style="cursor: pointer">닫 기</td>
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
