<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
	<title>전문 테스트로(TESTRO)</title>
	<meta http-equiv="Content-Type" content="text/html; charse=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<link rel="shortcut icon" href="images/TESTRO.ico" type="image/ico" />
	<script type="text/javascript" src="js/cmn/utils/json2.js" charset="utf-8"></script>
	<script type="text/javascript" src="jqgrid/js/jquery-1.5.2.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="js/cmn/jquery.blockUI.js" charset="utf-8"></script>
	<script type="text/javascript" src="js/msg/pretst/pretst.js" charset="UTF-8"></script>
	<script type="text/javascript" src="js/cmn/common.js" charset="UTF-8"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$.cookie('repeat_cookie','');
		inputTranName();
	});

	</script>
	</head>
<body bgcolor="#FFFFFF" background="images/left_menu_bg.jpg" leftmargin="0" rightmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="MM_preloadImages('images/top_menu_01_02.jpg','images/top_menu_02_02.jpg','images/top_menu_03_02.jpg','images/top_menu_04_02.jpg','images/top_menu_05_02.jpg','images/top_menu_06_02.jpg','images/top_menu_07_02.jpg')">
   <div id="Minwidth">
       <div id="Page">
           <div id="contents">
		<jsp:include page="/WEB-INF/view/cmn/topMenu.jsp" flush="true"></jsp:include>
               <table width="100%" border="0" cellpadding="0" cellspacing="0" id="Table_01">
                   <tr> 
					<!-- left menu 시작 -->
					<jsp:include page="/WEB-INF/view/cmn/leftMenu.jsp" flush="true"></jsp:include>
					<!-- left menu 끝 -->
                       <td valign="top">
				        	<form name="frmName" method="post">
							<input type="hidden" id="chnlDstcd" name="chnlDstcd" />
				
                            <table width="100%" height="100%" border="0" cellpadding="15" cellspacing="0">
                                <tr> 
                                    <td valign="top"> 
                                        <table border=0 cellpadding=0 cellspacing=0 width=100%>
                                            <tr> 
                                                <td width="20"><img src="images/title_bullet1.gif"></td>
                                                <td width="90" class="sub_tit">거래테스트</td>
                                                <td valign="bottom" class="point_text" id="flowMsg" >돋보기 버튼을 클릭하여 거래코드를 불러 올 수 있습니다.</td>
                                            </tr>
                                            <tr > 
                                                <td background="images/tit_line_bg.gif" height="6" colspan="4"><img src="images/tit_line_bg.gif"></td>
                                            </tr>
                                            <tr > 
                                                <td height="10" colspan="2"></td>
                                            </tr>
                                        </table>
                                        <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#baccdc">
                                            <tr>
                                                <td bgcolor="#e1e9f0">
                                                    <table width="100%" border="0" cellspacing="0" cellpadding="5">
                                                        <tr>
                                                            <td bgcolor="#FFFFFF">
                                                                <table width="100%" border="0" cellspacing="0" cellpadding="2">
                                                                    <tr>
                                                                        <td width="65" class="box_txt_red">거래코드 :</td>
                                                                      <td width="200"><input name="tranCd" id="tranCd" type="text" class="input_topinq" style="width:160px;ime-mode:disabled;" value="" onKeyDown="if(event.keyCode ==13){javascript:getDataList();}">
                                                                        <img src="images/btn_pop.gif" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer" onClick="getLayoutOpen();"></td>
                                                                        <td width="55" class="box_txt">거래명 :</td>
                                                                        <td><input name="tranName" id="tranName" type="text" class="input_topinq" style="width:100%" value="" readonly="readonly">
                                                                     </td>
                                                                      <td width="90" align="right">
                                                                        <table border="0" cellpadding="0" cellspacing="0">
                                                                          <tr>
                                                                            <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                                                            <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="getDataList();">조 회</td>
                                                                            <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                                                          </tr>
                                                                        </table>
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
                                                <td height="20">&nbsp;</td>
                                            </tr>
                                        </table> 
                                  </td>
                                </tr>
                            </table>
                         </form>  
                    </tr>
                </table>
            	
            </div>
        </div>
    </div>
 
</body>
</html>
