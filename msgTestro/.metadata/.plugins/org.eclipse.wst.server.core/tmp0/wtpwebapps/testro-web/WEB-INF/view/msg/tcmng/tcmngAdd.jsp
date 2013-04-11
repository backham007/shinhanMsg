<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

<script type="text/javascript" src="js/cmn/utils/json2.js" charset="utf-8"></script>
<script type="text/javascript" src="js/msg/tcmng/tcmngAdd.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/validation_v01.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/popupcalendar.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/util.js" charset="utf-8"></script>

<script type="text/javascript">
// iframe resize
$(document).ready(function(){
	loadPage();
});

function autoResize(i)
{
    var iframeHeight=
    (i).contentWindow.document.body.scrollHeight;
    (i).height=iframeHeight+20;
}

</script>
</head>

<body leftmargin="0" topmargin="0">

<form name="frmName" method="post" action="#">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="43"><img src="images/pop_tit_01.gif" width="43" height="51"></td>
    <td background="images/pop_tit_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="pop_tit">테스트케이스 추가</td>
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
                      <td bgcolor="#FFFFFF">
                      	<table width="100%" border="0" cellpadding="2" cellspacing="0">
                          <tr>
                            <td width="65" class="box_txt">조회구분 :</td>
                            <td colspan="3">
                            	<select name="inqType" id="inqType" class="menu" style="width:150">
									<option value="tsCaseName">테스트케이스명</option>
									<option value="tsCaseDesc">테스트케이스설명</option>
									<option value="tsCaseID">테스트케이스ID</option>
									<option value="tranCd">거래코드</option>
								</select>&nbsp;&nbsp;
                               	<input name="textfield" id="textfield" type="text" class="input_topinq" style="width:472px">
                               	<img src="images/btn_eraser.gif" id="delImg" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer" onclick="{$('#textfield').val('').focus();}">
                            </td>
                            <td>
                            	<table border="0" align="right" cellpadding="0" cellspacing="0">
                            		<tr>
		                                <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
		                                <td background="images/btn_img_02.gif" class="btn_text" onclick="getTcList();" style="cursor:pointer;">조 회</td>
		                                <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
		                    		</tr>
                            	</table>
                            </td>
                          </tr>
                          <tr>
                            <td class="box_txt">작성자명 :</td>
                            <td width="300">
                            	<input name="writeName" id="writeName" type="text" class="input_topinq" style="width:120px">
                            	<img src="images/btn_eraser.gif" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer" onclick="doNameClear();">
                            </td>
                            <td class="box_txt" width="65" >작성일자 :</td>
                            <td width="300">
								<input name="startDt" id="startDt" type="text" class="input_topinq" style="width:65px" readonly="readonly">
								<img src="images/un_sub_cen_cal.gif" alt="달력" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer;" onclick="javascript:popUpCalendar(this, 'startDt', 'yyyy-mm-dd','CENTER','MIDDLE');"> ~
								<input name="endDt" id="endDt" type="text" class="input_topinq" style="width:65px" readonly="readonly">
								<img src="images/un_sub_cen_cal.gif" alt="달력" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer;" onclick="javascript:popUpCalendar(this, 'endDt', 'yyyy-mm-dd','CENTER','MIDDLE');">
								<img src="images/btn_eraser.gif" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer" onclick="doClear();">
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
                  <td height="10" colspan="2"></td>
                </tr>
                <tr>
                  <td class="sub_tit02">테스트케이스 목록</td>
                </tr>
              </table>
              <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                <tr>
                  <td valign="top" bgcolor="#FFFFFF">
		              <!-- 그리드 테스트케이스 리스트 시작 -->
		              <table id="list1"></table>
					  <div id="pager1"></div>
		              <!-- 그리드 테스트케이스 리스트 끝 -->
		          </td>
		        </tr>
			  </table>              
              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="10" colspan="3"></td>
                </tr>
                <tr>
                  <td width="110" class="sub_tit02">테스트데이터 목록</td>
                  <td id="titleDiv1" class="point_result" ></td>
                  <td id="totalCount" class="point_result" align="right"></td>
                </tr>
              </table>
              
              <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                <tr>
                  <td valign="top" bgcolor="#FFFFFF">
		              <!-- 그리드 테스트데이터 리스트 시작 -->
		              <table id="list2"></table>
					  <div id="pager2"></div>
		              <!-- 그리드 테스트데이터 리스트 끝-->
		          </td>
		        </tr>
			  </table>
              
              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="10" colspan="3"></td>
                </tr>
                <tr>
                  <td width="110" class="sub_tit02">테스트데이터 상세</td>
                  <td id="titleDiv2" class="point_result"></td>
                </tr>
              </table>

              <table cellspacing="0" cellpadding="0" width="100%" border="0">
                <tr>
                  <td width="4"><img height="31" src="images/tabbg_01_01.gif" width="4"></td>
                  <td background="images/tabbg_01_02.gif" valign="top"><!-- menu -->
                      <table cellspacing="0" cellpadding="0" width="100%" border="0">
                        <tr>
                          <td>&nbsp;</td>
                          <td><table cellspacing="0" cellpadding="0" border="0">
                             <tr>
                                <td>
                                	<div id="view0_on">
	                                    <table cellspacing="0" cellpadding="0" border="0">
	                                      <tr>
	                                        <td width=5 background="images/tab_01.gif" height=30>&nbsp;</td>
	                                        <td class=tab_tit background=images/tab_02.gif  style="cursor:pointer;">헤더부</td>
	                                        <td width=5 background=images/tab_03.gif>&nbsp;</td>
	                                      </tr>
	                                    </table>
	                                </div>
                                    <div id="view0_off">
                                      <table cellspacing=0 cellpadding=0 width="100%" border=0>
                                        <tr>
                                          <td width=3 background="images/btn_bg_02_01.jpg"><img height=30 src="images/tab01_01.gif" width=4></td>
                                          <td class='tab_tit02' onclick="javascript:doSearch('view0');" valign="middle" background="images/tab01_02.gif"><font style="cursor:pointer;">헤더부</font></td>
                                          <td valign=bottom background="images/btn_bg_02_02.jpg"><img height=30 src="images/tab03_03.gif" width=3></td>
                                        </tr>
                                      </table>
                                    </div>
                                </td>
                                <td width=2>&nbsp;</td>
                                <td>
                                	<div id="view1_on">
	                                    <table cellspacing=0 cellpadding=0 border=0>
	                                      <tr>
	                                        <td width=5 background=images/tab_01.gif height=30>&nbsp;</td>
	                                        <td class=tab_tit background="images/tab_02.gif"><font style="cursor:pointer;">개별부</font></td>
	                                        <td width=5 background="images/tab_03.gif">&nbsp;</td>
	                                      </tr>
	                                    </table>
                                	</div>
                                </td>
                                <td>
	                                <div id="view1_off">
	                                    <table cellspacing=0 cellpadding=0 width="100%" border=0>
	                                      <tr>
	                                        <td width=3 background=images/btn_bg_02_01.jpg><img height=30 src="images/tab01_01.gif" width=4></td>
	                                        <td class=tab_tit02  onclick="javascript:doSearch('view1');" valign="middle" background="images/tab01_02.gif"><font style="cursor:pointer;">개별부</font></td>
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
                        <td background="images/btn_img_02.gif" class="btn_text" onclick="doApply();" style="cursor:pointer;" >적 용</td>
                        <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                      </tr>
                  </table>
                    </td>
                  <td ><table align="right" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                          <td background="images/btn_img_02.gif" class="btn_text" onclick="self.close();" style="cursor:pointer;">닫 기</td>
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