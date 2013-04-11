<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>전문 테스트로(TESTRO)</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="Cache-Control" content="no-cache"/> 
<meta http-equiv="Expires" content="0"/> 
<meta http-equiv="Pragma" content="no-cache"/>
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
<script type="text/javascript" src="js/cmn/utils/json2.js" charset="utf-8"></script>
<script type="text/javascript" src="js/msg/statistics/statistics.js" charset="utf-8"></script>
<script type="text/javascript" src="js/msg/exeSts/exeSts.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/util.js" charset="utf-8"></script>
<script language="javascript">

</script>
</head>
<body leftmargin="0" topmargin="0">
	<form name="frm" method="POST">
	<input type="hidden" id="testStartYMS">
	<input type="hidden" id="testEndYMS">
	<input type="hidden" id="projNo">
	<input type="hidden" id="tranCd">
  	<input type="hidden" id="tstrName">
    <input type="hidden" id="searchGubun">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		    <td width="43"><img src="images/pop_tit_01.gif" width="43" height="51"></td>
		    <td background="images/pop_tit_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
		      <tr>
		        <td class="pop_tit">테스트 수행현황</td>
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
		                            <td width="80" class="box_txt">프로젝트 :</td>
		                            <td id="projName"></td>
		                            </tr>
		                          <tr>
		                            <td class="box_txt">테스트단계 :</td>
		                            <td id="testStgeName"></td>
		                            </tr>
		                      </table></td>
		                    </tr>
		                </table></td>
		              </tr>
		            </table>
		            <table width="100%" border="0" cellspacing="0" cellpadding="0">
		              <tr>
		                <td height="10"></td>
		              </tr>
		            </table>
 			  	   <table width="100%" height="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
	                   <tr>
		                   <td valign="top" bgcolor="#FFFFFF">
		                   	  <table id="list2"></table>
				           </td>
			           </tr>
                   </table>
		              <table width="100%" border="0" cellspacing="0" cellpadding="1">
		                <tr>
		                  <td height="5" colspan="4"></td>
		                </tr>
		                <tr>
		                  <td width="100"><table align="left" border="0" cellpadding="0" cellspacing="0">
		                    <tr>
		                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
		                      <td background="images/btn_img_02.gif" class="btn_text" style="cursor: pointer" onclick="downExcelExeSts()">엑셀다운로드</td>
		                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
		                    </tr>
		                  </table></td>
		                  <td align="center"><span class="input_result">[해당항목을 더블클릭하시면 상세조회가 가능합니다.]</span></td>
		                  <td width="100" ><table align="right" border="0" cellpadding="0" cellspacing="0">
		                        <tr>
		                          <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
		                          <td background="images/btn_img_02.gif" class="btn_text" onclick="self.close()" style="cursor: pointer">닫 기</td>
		                          <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
		                        </tr>
		                      </table>                    </td>
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
