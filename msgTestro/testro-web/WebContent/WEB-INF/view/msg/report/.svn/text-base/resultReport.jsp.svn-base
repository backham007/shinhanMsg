<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>전문 테스트로(TESTRO)</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" href="images/TESTRO.ico" type="image/ico" />
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
<script type="text/javascript" src="js/cmn/popupcalendar.js" charset="utf-8"></script>
<script type="text/javascript" src="js/msg/report/resultReport.js" charset="utf-8"></script>

</head>


<body bgcolor="#FFFFFF" background="images/left_menu_bg.jpg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >

<div id="Minwidth">
        <div id="Page">
            <div id="contents">
	            <!-- top menu 시작 --> 
				<jsp:include page="/WEB-INF/view/cmn/topMenu.jsp" flush="true"></jsp:include>
	            <!-- top menu 끝 -->   
            
                <table width="100%" border="0" cellpadding="0" cellspacing="0" id="Table_01">
                    <tr> 
                        <!-- left menu 시작 -->
						<jsp:include page="/WEB-INF/view/cmn/leftMenu.jsp" flush="true"></jsp:include>
						<!-- left menu 끝 -->
                        <td valign="top">
                            <table width="100%" height="100%" border="0" cellpadding="15" cellspacing="0">
                                <tr> 
                                    <td valign="top">
                                    
                                        <table border=0 cellpadding=0 cellspacing=0 width=100%>
                                            <tr> 
                                                <td width="20"><img src="images/title_bullet1.gif"></td>
                                                <td width="125" class="sub_tit">결과보고서 조회</td>
                                                <td valign="bottom"><span class="point_text">조회된 내용을 더블클릭하여 테스트결과를 확인 할 수 있습니다.</span></td>
                                            </tr>
                                            <tr > 
                                                <td background="images/tit_line_bg.gif" height="6" colspan="3"><img src="images/tit_line_bg.gif"></td>
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
                                                                        <td width="70px" class="box_txt_red">조회구분 :</td>
                                                                      <td><select name="tesdiv" id="tesdiv"   class="menu" style="width:130px">
                                                                      </select></td>
                                                                      
                                                                      <td class="box_txt">테스터ID/명 :</td>
                                                                      <td><input id="writename" name="writename" type="text" class="input_topinq" style="width:130px" value="${sessionScope.userinfo.usrname}" maxlength="15">
                                                                      <img id="img_eraser" src="images/btn_eraser.gif" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" style="cursor: pointer;"></td>

                                                                        <td>
                                                                            <table border="0" align="right" cellpadding="0" cellspacing="0">
                                                                                <tr>
                                                                                    <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                                                                    <td id="rpt_srch" background="images/btn_img_02.gif" class="btn_text" style="cursor: pointer;">조 회</td>
                                                                                    <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                                                                </tr>
                                                                            </table>                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                      <td class="box_txt_red">프로젝트 :</td>
                                                                      <td><input id="projNo" name="projNo" type="text" class="input_topinq" style="width:90px" readonly="readonly" value="${sessionScope.userinfo.projno}">
                                                                      <img id="prt_srch" src="images/btn_pop.gif" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" style="cursor: pointer;">
                                                                      <input id="projName" name="projName" type="text" class="input_topinq" style="width:133px" readonly="readonly" value="${sessionScope.userinfo.projname}"></td>
                                                                        <td width="85" class="box_txt">테스트단계 :</td>
                                                                      <td><select id="testStgeName" name="testStgeName"   class="menu" style="width:130px">
                                                                        <option value="00">== 전체 ==</option>
                                                                      </select></td>
                                                                      <td>&nbsp;</td>
                                                                    </tr>
                                                                    <tr>
                                                                      <td class="box_txt">조회조건 :</td>
                                                                      <td><select name="tesdiv_sub" id="tesdiv_sub" class="menu" style="width:130px">
                                                                      <option value="00">== 전체 ==</option>
                                                                      </select> 
                                                                        <input id="tesdiv_sub_text" name="tesdiv_sub_text" type="text" class="input_topinq" style="width:128px" disabled="disabled"></td>
                                                                      <td class="box_txt">실행서버 :</td>
                                                                      <td><select name="connSevrDstcd"  id="connSevrDstcd"   class="menu" style="width:130px">
                                                                        <option value="00">== 전체 ==</option>
			                                                          	<c:forEach var="list" items="${mciArray}" varStatus="status">
								                      						<c:choose>
										                                        <c:when test="${sessionScope.userinfo.connsevrdstcd == list.key}">
																					<c:set var="sel" value="selected='selected'" />
																				</c:when>
										                                        <c:otherwise>
										                                        	<c:set var="sel" value="" />
																				</c:otherwise>
																			</c:choose>
									                                        <option value="${list.key}"  ${sel}>${list.val}</option>
			                                                            </c:forEach>
                                                                      </select></td>
                                                                      <td>&nbsp;</td>
                                                                    </tr>
                                                                    <tr>
                                                                      <td class="box_txt">조회기간 :</td>
                                                                      <td><input id="teststartyms" name="teststartyms" type="text" class="input_topinq" style="width:65px" readonly="readonly">
                                                                        <img src="images/un_sub_cen_cal.gif" alt="달력" width="23" height="21" hspace="4" align="absmiddle" style="cursor: pointer" onclick="popUpCalendar(this, 'teststartyms', 'yyyy-mm-dd','CENTER','MIDDLE');"> 
                                                                        ~
                                                                        <input id="testendyms" name="testendyms" type="text" class="input_topinq" style="width:65px" readonly="readonly">
                                                                        <img src="images/un_sub_cen_cal.gif" alt="달력" width="23" height="21" hspace="4" align="absmiddle" style="cursor: pointer" onclick="popUpCalendar(this, 'testendyms', 'yyyy-mm-dd','CENTER','MIDDLE');">
                                                                        <img id="testendyms_eraser" src="images/btn_eraser.gif" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" style="cursor: pointer;">
                                                                      </td>
                                                                      <td class="box_txt">실행결과 :</td>
                                                                      <td><select id="exresult" name="exresult" class="menu" style="width:130px">
                                                                      </select></td>
                                                                      <td>&nbsp;</td>
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
                                    
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                            <tr>
                                                <td class="sub_tit02">테스트 케이스 / 테스트시나리오</td>
                                            </tr>
                                            <tr>
                                                <td height="1" colspan="2"></td>
                                            </tr>
                                        </table>
                                    
                                        <table width="100%" height="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                                            <tr>
                                                <td id="case"  valign="top" bgcolor="#FFFFFF" style="display: '';">
				                                    <table id="list1"></table> 
				    								<div id="pager1"></div>
				    								<button id="emp_button" style="display: none;">직원정보조회</button>
                                                </td>
                                          </tr>
                                        </table>
                                    
                                        </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    
</body>
</html>