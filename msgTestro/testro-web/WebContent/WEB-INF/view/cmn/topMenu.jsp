<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="js/cmn/jquery.cookie.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/login.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/main.js" charset="utf-8"></script>
                
            	<!--메뉴 시작--> 
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td height="64" background="images/top_bg_prt_01.jpg">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="215" rowspan="2" class="menu_tit02"><img id="img_logo" src="images/top_logo.jpg" alt="" style="cursor: pointer;"></td>
                                    <td>
	                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
	                                      <tr>
	                                        <td width="34" background="images/top_bg_prt_02.jpg"><img src="images/top_img_R_01.jpg"  alt=""></td>
	                                        <td height="23"  background="images/top_bg_prt_02.jpg" valign="bottom" >
		                                        <table border="0" cellspacing="0" cellpadding="0" >
		                                            <tr>
		                                            	<td valign="bottom" class="user_login" style="padding-bottom: 0px; padding-top: 3px; line-height: 10px;"><strong>ㆍ프로젝트명 : </strong>${sessionScope.userinfo.projname}<strong> ㆍ테스트단계 : </strong>${sessionScope.userinfo.teststgename}</td>
		                                            </tr>
		                                        </table>
	                                        </td>
	                                        <td valign="bottom" background="images/top_bg_prt_02.jpg">
		                                        <table border="0" align="right" cellpadding="0" cellspacing="0">
		                                            <tr>
		                                              <td><img src="images/top_img_R_02.jpg" alt="" width="16" height="23"></td>
		                                              <td valign="bottom" background="images/top_bg_prt_01.jpg"  class="user_login"><strong>${sessionScope.userinfo.usrname}님</strong>이 접속중입니다<!-- <a href="cmn.login.sessionCheck.do">.</a> -->&nbsp;</td>
		                                              <td align="right" background="images/top_bg_prt_01.jpg"><img id="logout_btn" src="images/btn_logout.gif" alt="" hspace="2" align="absmiddle" style="cursor: pointer;"></td>
		                                              <td align="right"><img src="images/top_img_R_03.jpg" alt="" width="6" height="23"></td>
		                                            </tr>
		                                        </table>
		                                    </td>
	                                      </tr>
	                                    </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr id="top_menu_area">
											<input type="hidden" id="top_projno" value="${sessionScope.userinfo.projno}" />
											<input type="hidden" id="top_connsevrdstcd" value="${sessionScope.userinfo.connsevrdstcd}"  />
											<td width="110"><a style="cursor: pointer;" target="_parent" onMouseOver="MM_swapImage('Image26','','images/top_menu_message_02.jpg',1)"    onMouseOut="MM_swapImgRestore()"><img id="top_menu_01"  src="images/top_menu_message_01.jpg" name="Image26" width="110" height="39" border="0"></a></td>
											
	                                        <td width="110"><a style="cursor: pointer;" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image23','','images/top_menu_reserve_02.jpg',1)"><img id="top_menu_05" src="images/top_menu_reserve_01.jpg" name="Image23" width="110" height="39" border="0"></a></td>
	                                        <td width="110"><a style="cursor: pointer;" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image24','','images/top_menu_defect_02.jpg',1)"><img id="top_menu_06" src="images/top_menu_defect_01.jpg" name="Image24" width="110" height="39" border="0"></a></td>
	                                        
											<td width="110"><a style="cursor: pointer;" target="_parent" onMouseOver="MM_swapImage('Image27','','images/top_menu_statistics_02.jpg',1)" onMouseOut="MM_swapImgRestore()"><img id="top_menu_02"  src="images/top_menu_statistics_01.jpg" name="Image27" width="110" height="39" border="0"></a></td>
											<td align="right"><a style="cursor: pointer;" target="_parent" onMouseOver="MM_swapImage('Image28','','images/top_menu_mytest_02.jpg',1)"     onMouseOut="MM_swapImgRestore()"><img id="top_menu_03"  src="images/top_menu_mytest_01.jpg" name="Image28" width="140" height="39" border="0"></a></td>
											<c:if test="${'01' == sessionScope.userinfo.usrlevel}">
											<td align="right" width="110"><a style="cursor: pointer;" target="_parent" onMouseOver="MM_swapImage('Image30','','images/top_menu_system_02.jpg',1)"     onMouseOut="MM_swapImgRestore()"><img id="top_menu_04"  src="images/top_menu_system_01.jpg" name="Image30" width="110" height="39" border="0"></a></td>
											</c:if>
										</tr>
                                    </table></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            	<!--메뉴 끝-->  