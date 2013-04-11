<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                       <td id="left_menu_area" lmenuChk1="${sessionScope.userinfo.projno}" lmenuChk2="${sessionScope.userinfo.connsevrdstcd}" width="191" valign="top" background="images/left_menu_bg.jpg">
                            <table border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td><img src="images/left_menu_img_01.jpg" alt="" width="186" height="28"></td>
                                </tr>
                                <tr>
                                    <td background="images/left_menu_img_02.jpg">
                                    	<!-- 01 전문테스트 LEFT 시작 -->
                                    	<table id="left01_tb" border="0" cellspacing="0" cellpadding="0" style="display: none;">
                                            <tr>
                                            <td height="26" >
                                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                        <td width="5" background="images/left_menu_bg_t_01.jpg"><img src="images/left_menu_bg_t_01.jpg" width="5" height="33"></td>
                                                        <td width="171" valign="top" bgcolor="#FFFFFF"><img src="images/lrft_menu_message.jpg" alt="" width="171" height="47">
                                                      <table width="160" border="0" align="center" cellpadding="0" cellspacing="0">
                                                                <tr>
                                                                    <td class="left_menu_1D_on"><img src="images/left_menu_bullet.gif" width="11" height="14" hspace="5" vspace="3" align="absmiddle">나의 최근작업관리</td>
                                                                </tr>
                                                                <tr>
                                                                    <td height="4"></td>
                                                                        </tr>
                                                                            <tr>
                                                                                <td>
                                                                                    <table width="150" border="0" align="center" cellpadding="0" cellspacing="0">
                                                                                        <tr>
                                                                                            <td><span class="left_menu_2D_off"><img id="leftmenu_1_1_img" src="images/left_menu_bullet_03.jpg" align="absmiddle" hspace="6" width="3" height="8"><a id="leftmenu_1_1" style="cursor: pointer;" mvUrl="msg.myLatestWork.myLatestWork.do">나의 최근작업 조회</a></span></td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td height="3" background="images/left_menu_line_02.jpg"></td>
                                                                                        </tr>
                                                                                    </table>
                                                                                </td>
                                                                            </tr>
                                                                        <tr>
                                                                    <td height="10" valign="bottom">&nbsp;</td>
                                                                </tr>
                                                            </table>
                                                            <table width="160" border="0" align="center" cellpadding="0" cellspacing="0">
                                                              <tr>
                                                                <td class="left_menu_1D_on"><img src="images/left_menu_bullet.gif" width="11" height="14" hspace="5" vspace="3" align="absmiddle">전문관리</td>
                                                              </tr>
                                                              <tr>
                                                                <td height="4"></td>
                                                              </tr>
                                                              <c:if test="${'01' == sessionScope.userinfo.usrlevel || '02' == sessionScope.userinfo.usrlevel}">
                                                              <tr>
                                                                <td><table width="150" border="0" align="center" cellpadding="0" cellspacing="0">
                                                                    <tr>
                                                                      <td><span class="left_menu_2D_off"><img id="leftmenu_1_2_img" src="images/left_menu_bullet_03.jpg" align="absmiddle" hspace="6" width="3" height="8"><a id="leftmenu_1_2" style="cursor: pointer;" mvUrl="msg.layout.layoutMng.do">전문관리</a></span></td>
                                                                    </tr>
                                                                    <tr>
                                                                      <td height="3" background="images/left_menu_line_02.jpg"></td>
                                                                    </tr>
                                                                </table></td>
                                                              </tr>
                                                              </c:if>
                                                              <tr>
                                                                <td height="10" valign="bottom">&nbsp;</td>
                                                              </tr>
                                                            </table>
                                                      <table width="160" border="0" align="center" cellpadding="0" cellspacing="0">
                                                                <tr>
                                                                    <td height="18" class="left_menu_1D_on"><img src="images/left_menu_bullet.gif" width="11" height="14" hspace="5" vspace="3" align="absmiddle">테스트케이스/실행</td>
                                                                </tr>
                                                                <tr>
                                                                    <td height="4"></td>
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        <table width="150" border="0" align="center" cellpadding="0" cellspacing="0">
                                                                            <tr>
                                                                                <td height="20"><span class="left_menu_2D_off"><img id="leftmenu_1_3_img" src="images/left_menu_bullet_03.jpg" align="absmiddle" hspace="6" width="3" height="8"><a id="leftmenu_1_3" style="cursor: pointer;" mvUrl="msg.pretst.pretst.do">거래테스트</a></span></td>
                                                                          </tr>
                                                                            <tr>
                                                                                <td height="7" background="images/left_menu_line.jpg"></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td><span class="left_menu_2D_off"><img id="leftmenu_1_4_img" src="images/left_menu_bullet_03.jpg" align="absmiddle" hspace="6" width="3" height="8"><a id="leftmenu_1_4" style="cursor: pointer;" mvUrl="msg.tcmng.tcmng.do">테스트케이스 관리</a></span></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td height="7" background="images/left_menu_line.jpg"></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td><span class="left_menu_2D_off"><img id="leftmenu_1_5_img" src="images/left_menu_bullet_03.jpg" align="absmiddle" hspace="6" width="3" height="8"><a id="leftmenu_1_5" style="cursor: pointer;" mvUrl="msg.tsmng.tsmng.do">테스트시나리오 관리</a></span></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td height="7" background="images/left_menu_line.jpg"></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td><span class="left_menu_2D_off"><img id="leftmenu_1_6_img" src="images/left_menu_bullet_03.jpg" align="absmiddle" hspace="6" width="3" height="8"><a id="leftmenu_1_6" style="cursor: pointer;" mvUrl="msg.report.resultReport.do">결과보고서 조회</a></span></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td height="7" background="images/left_menu_line_02.jpg"></td>
                                                                            </tr>
                                                                        </table>
                                                                  </td>
                                                                </tr>
                                                                <tr>
                                                                    <td height="15">&nbsp;</td>
                                                                </tr>
                                                            </table>
                                                            
                                                        </td>
                                                      <td width="15" valign="top"><img id="hide_1" src="images/left_tab_hide.jpg" style="cursor: pointer;" name="Image29" width="15" height="77" border="0"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            </tr>
                                        </table>
                                    	<!-- 01 전문테스트 LEFT 끝 -->
                                    	
                                    	<!-- 05예약실행 LEFT 시작 -->
                                        <table id="left05_tb" border="0" cellspacing="0" cellpadding="0" style="display: none;">
			                                <tr>
			                                  <td height="26" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
			                                      <tr>
			                                        <td width="5" background="images/left_menu_bg_t_01.jpg"><img src="images/left_menu_bg_t_01.jpg" width="5" height="33"></td>
			                                        <td width="171" valign="top" bgcolor="#FFFFFF"><img src="images/lrft_menu_reserve.jpg" alt="" width="171" height="47">
			                                          <table width="160" border="0" align="center" cellpadding="0" cellspacing="0">
			                                              <tr>
			                                                <td height="18" class="left_menu_1D_on"><img src="images/left_menu_bullet.gif" width="11" height="14" hspace="5" vspace="3" align="absmiddle">테스트예약 실행관리</td>
			                                              </tr>
			                                              <tr>
			                                                <td height="4"></td>
			                                              </tr>
			                                              <tr>
			                                                <td><table width="150" border="0" align="center" cellpadding="0" cellspacing="0">
			                                                    <tr>
			                                                      <td height="20"><span class="left_menu_2D_off"><img id="leftmenu_5_1_img" src="images/left_menu_bullet_03.jpg" align="absmiddle" hspace="6" width="3" height="8"><a id="leftmenu_5_1" style="cursor: pointer;" mvUrl="msg.schedule.scheduleMng.do">테스트예약 실행관리</a></span></td>
			                                                    </tr>
			                                                    <tr>
			                                                      <td height="7" background="images/left_menu_line_02.jpg"></td>
			                                                    </tr>
			                                                </table></td>
			                                              </tr>
			                                              <tr>
			                                                <td height="15">&nbsp;</td>
			                                              </tr>
			                                          </table></td>
			                                        <td width="15" valign="top"><img id="hide_5" src="images/left_tab_hide.jpg" style="cursor: pointer;" name="Image29" width="15" height="77" border="0"></td>
			                                      </tr>
			                                  </table></td>
			                                </tr>
                                        </table>
                                        <!-- 05예약실행 LEFT 끝 -->
                                        
                       					<!-- 06결함관리 LEFT 시작 -->
                                        <table id="left06_tb" border="0" cellspacing="0" cellpadding="0" style="display: none;">
			                                <tr>
			                                  <td height="26" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
			                                      <tr>
			                                        <td width="5" background="images/left_menu_bg_t_01.jpg"><img src="images/left_menu_bg_t_01.jpg" width="5" height="33"></td>
			                                        <td width="171" valign="top" bgcolor="#FFFFFF"><img src="images/lrft_menu_defect.jpg" alt="" width="171" height="47">
			                                          <table width="160" border="0" align="center" cellpadding="0" cellspacing="0">
			                                              <tr>
			                                                <td height="18" class="left_menu_1D_on"><img src="images/left_menu_bullet.gif" width="11" height="14" hspace="5" vspace="3" align="absmiddle">나의 테스트 결함관리</td>
			                                              </tr>
			                                              <tr>
			                                                <td height="4"></td>
			                                              </tr>
			                                              <tr>
			                                                <td><table width="150" border="0" align="center" cellpadding="0" cellspacing="0">
			                                                    <tr>
			                                                      <td height="20"><span class="left_menu_2D_off"><img id="leftmenu_6_1_img" src="images/left_menu_bullet_03.jpg" align="absmiddle" hspace="6" width="3" height="8"><a id="leftmenu_6_1" style="cursor: pointer;" mvUrl="msg.flaw.myFlawList.do">나의 결함조회</a></span></td>
			                                                    </tr>
			                                                    <tr>
			                                                      <td height="7" background="images/left_menu_line.jpg"></td>
			                                                    </tr>
			                                                    <tr>
			                                                      <td height="20" ><span class="left_menu_2D_off"><img id="leftmenu_6_2_img" src="images/left_menu_bullet_03.jpg" align="absmiddle" hspace="6" width="3" height="8"><a id="leftmenu_6_2" style="cursor: pointer;" mvUrl="msg.flaw.myReTestList.do">나의 재테스트 조회</a></span></td>
			                                                    </tr>
			                                                    <tr>
			                                                      <td height="7" background="images/left_menu_line.jpg"></td>
			                                                    </tr>
			                                                    <tr>
			                                                      <td height="20" class="left_menu_2D_on"><img id="leftmenu_6_3_img" src="images/left_menu_bullet_03.jpg" align="absmiddle" hspace="6" width="3" height="8"><a id="leftmenu_6_3" style="cursor: pointer;" mvUrl="msg.statistics.defPrgsSts.do">결함총괄표</a></td>
			                                                    </tr>
			                                                    <tr>
			                                                      <td height="7" background="images/left_menu_line_02.jpg"></td>
			                                                    </tr>
			                                                </table></td>
			                                              </tr>
			                                              <tr>
			                                                <td height="15">&nbsp;</td>
			                                              </tr>
			                                            </table></td>
			                                        <td width="15" valign="top"><img id="hide_6" src="images/left_tab_hide.jpg" style="cursor: pointer;" name="Image29" width="15" height="77" border="0"></td>
			                                      </tr>
			                                  </table></td>
			                                </tr>
                                        </table>
                                        <!-- 06결함관리 LEFT 끝 -->

                                    	<!-- 02통계보고서 LEFT 시작 -->
			                            <table id="left02_tb" border="0" cellspacing="0" cellpadding="0" style="display: none;">
			                                <tr>
			                                  <td height="26" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
			                                      <tr>
			                                        <td width="5" background="images/left_menu_bg_t_01.jpg"><img src="images/left_menu_bg_t_01.jpg" width="5" height="33"></td>
			                                        <td width="171" valign="top" bgcolor="#FFFFFF"><img src="images/lrft_menu_statistics.jpg" alt="" width="171" height="47">
			                                            <table width="160" border="0" align="center" cellpadding="0" cellspacing="0">
			                                              <tr>
			                                                <td class="left_menu_1D_on"><img src="images/left_menu_bullet.gif" width="11" height="14" hspace="5" vspace="3" align="absmiddle">진척현황</td>
			                                              </tr>
			                                              <tr>
			                                                <td height="4"></td>
			                                              </tr>
			                                              <tr>
			                                                <td><table width="150" border="0" align="center" cellpadding="0" cellspacing="0">
			                                                    <tr>
			                                                      <td height="20"><span class="left_menu_2D_off"><img id="leftmenu_2_1_img" src="images/left_menu_bullet_03.jpg" align="absmiddle" hspace="6" width="3" height="8"><a id="leftmenu_2_1" style="cursor: pointer;" mvUrl="msg.statistics.TestPrgsSts.do">단계별 진척현황</a></span></td>
			                                                    </tr>
			                                                    <tr>
			                                                      <td height="7" background="images/left_menu_line.jpg"></td>
			                                                    </tr>
			                                                    <tr>
			                                                      <td><span class="left_menu_2D_off"><img id="leftmenu_2_2_img" src="images/left_menu_bullet_03.jpg" align="absmiddle" hspace="6" width="3" height="8"><a id="leftmenu_2_2" style="cursor: pointer;" mvUrl="msg.statistics.prvtTestPrgsSts.do">개인별 진척현황</a></span></td>
			                                                    </tr>
			                                                    <tr>
			                                                      <td height="7" background="images/left_menu_line_02.jpg"></td>
			                                                    </tr>
			                                                </table></td>
			                                              </tr>
			                                              <tr>
			                                                <td height="10" valign="bottom">&nbsp;</td>
			                                              </tr>
			                                            </table></td>
			                                        <td width="15" valign="top"><img id="hide_2" src="images/left_tab_hide.jpg" style="cursor: pointer;" name="Image29" width="15" height="77" border="0"></td>
			                                      </tr>
			                                  </table></td>
			                                </tr>
			                            </table>
                                    	<!-- 02통계보고서 LEFT 끝 -->
                                    	
                                    	<!-- 03나의 테스트환경 LEFT 시작 -->
                                        <table id="left03_tb" border="0" cellspacing="0" cellpadding="0" style="display: none;">
			                                <tr>
			                                  <td height="26" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
			                                      <tr>
			                                        <td width="5" background="images/left_menu_bg_t_01.jpg"><img src="images/left_menu_bg_t_01.jpg" width="5" height="33"></td>
			                                        <td width="171" valign="top" bgcolor="#FFFFFF"><img src="images/lrft_menu_mytest.jpg" alt="" width="171" height="47">
			                                            <table width="160" border="0" align="center" cellpadding="0" cellspacing="0">
			                                              <tr>
			                                                <td height="18" class="left_menu_1D_on"><img src="images/left_menu_bullet.gif" width="11" height="14" hspace="5" vspace="3" align="absmiddle">나의 프로젝트 정보관리</td>
			                                              </tr>
			                                              <tr>
			                                                <td height="4"></td>
			                                              </tr>
			                                              <tr>
			                                                <td><table width="150" border="0" align="center" cellpadding="0" cellspacing="0">
			                                                    <tr>
			                                                      <td height="20"><span class="left_menu_2D_off"><img id="leftmenu_3_1_img" src="images/left_menu_bullet_02.jpg" align="absmiddle" hspace="6" width="3" height="8"><a id="leftmenu_3_1" style="cursor: pointer;" mvUrl="msg.myQalty.myQalty.do">나의 프로젝트 정보설정</a></span></td>
			                                                    </tr>
			                                                    <tr>
			                                                      <td height="7" background="images/left_menu_line.jpg"></td>
			                                                    </tr>
			                                                    <tr>
			                                                      <td height="20"><span class="left_menu_2D_off"><img id="leftmenu_3_3_img" src="images/left_menu_bullet_03.jpg" align="absmiddle" hspace="6" width="3" height="8"><a id="leftmenu_3_3" style="cursor: pointer;" mvUrl="msg.myConfiguration.myConfiguration.do">테스트대상시스템 설정</a></span></td>
			                                                    </tr>
			                                                    <tr>
			                                                      <td height="7" background="images/left_menu_line.jpg"></td>
			                                                    </tr>
			                                                    <c:if test="${sessionScope.userinfo.usrlevel != '03' }">
			                                                    <tr>
			                                                      <td><span class="left_menu_2D_off"><img id="leftmenu_3_2_img" src="images/left_menu_bullet_03.jpg" align="absmiddle" hspace="6" width="3" height="8"><a id="leftmenu_3_2" style="cursor: pointer;" mvUrl="msg.mngUser.mngUser.do">사용자 정보관리</a></span></td>
			                                                    </tr>
			                                                    <tr>
			                                                      <td height="7" background="images/left_menu_line_02.jpg"></td>
			                                                    </tr>
			                                                    </c:if>
			                                                    <tr>
			                                                      <td height="20"><span class="left_menu_2D_off"><img id="leftmenu_3_4_img" src="images/left_menu_bullet_03.jpg" align="absmiddle" hspace="6" width="3" height="8"><a id="leftmenu_3_4" style="cursor: pointer;" >비밀번호 변경</a></span></td>
			                                                    </tr>
			                                                    <tr>
			                                                      <td height="7" background="images/left_menu_line.jpg"></td>
			                                                    </tr>
			                                                </table></td>
			                                              </tr>
			                                              <tr>
			                                                <td height="15">&nbsp;</td>
			                                              </tr>
			                                            </table></td>
			                                        <td width="15" valign="top"><img id="hide_3" src="images/left_tab_hide.jpg" style="cursor: pointer;" name="Image29" width="15" height="77" border="0"></td>
			                                      </tr>
			                                  </table></td>
			                                </tr>
                                        </table>
                                        <!-- 03 테스트환경 LEFT 끝 -->
                                        <!-- 04 시스템 관리 LEFT 시작 -->
                                        <table id="left04_tb" border="0" cellspacing="0" cellpadding="0" style="display: none;">
			                                <tr>
			                                  <td height="26" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
			                                      <tr>
			                                        <td width="5" background="images/left_menu_bg_t_01.jpg"><img src="images/left_menu_bg_t_01.jpg" width="5" height="33"></td>
			                                        <td width="171" valign="top" bgcolor="#FFFFFF"><img src="images/lrft_menu_system.jpg" alt="" width="171" height="47">
			                                          <table width="160" border="0" align="center" cellpadding="0" cellspacing="0">
			                                            <tr>
			                                              <td height="18" class="left_menu_1D_on"><img src="images/left_menu_bullet.gif" width="11" height="14" hspace="5" vspace="3" align="absmiddle">시스템 관리</td>
			                                            </tr>
			                                            <tr>
			                                              <td height="4"></td>
			                                            </tr>
			                                            <tr>
			                                              <td><table width="150" border="0" align="center" cellpadding="0" cellspacing="0">
			                                                  <tr>
			                                                    <td height="20"><span class="left_menu_2D_off"><img id="leftmenu_4_1_img" src="images/left_menu_bullet_03.jpg" align="absmiddle" hspace="6" width="3" height="8"><a id="leftmenu_4_1" style="cursor: pointer;" mvUrl="cmn.sysmng.loggerMng.do">로그레벨 관리</a></span></td>
			                                                  </tr>
			                                                  <tr>
			                                                    <td height="7" background="images/left_menu_line.jpg"></td>
			                                                  </tr>
			                                                  <tr>
			                                                    <td><span class="left_menu_2D_off"><img id="leftmenu_4_2_img" src="images/left_menu_bullet_03.jpg" align="absmiddle" hspace="6" width="3" height="8"><a id="leftmenu_4_2" style="cursor: pointer;" mvUrl="cmn.sysmng.sysEnvVarMng.do">시스템 환경변수 조회</a></span></td>
			                                                  </tr>
			                                                  <tr>
			                                                    <td height="7" background="images/left_menu_line.jpg"></td>
			                                                  </tr>
			                                                  <tr>
			                                                    <td><span class="left_menu_2D_off"><img id="leftmenu_4_3_img" src="images/left_menu_bullet_03.jpg" align="absmiddle" hspace="6" width="3" height="8"><a id="leftmenu_4_3" style="cursor: pointer;" mvUrl="cmn.sysmng.dBConfMng.do">DB 설정 관리</a></span></td>
			                                                  </tr>
			                                                  <tr>
			                                                    <td height="7" background="images/left_menu_line_02.jpg"></td>
			                                                  </tr>
			                                                  <!-- <tr>
			                                                    <td><span class="left_menu_2D_off"><img id="leftmenu_4_4_img" src="images/left_menu_bullet_03.jpg" align="absmiddle" hspace="6" width="3" height="8"><a id="leftmenu_4_4" style="cursor: pointer;" >라이센스</a></span></td>
			                                                  </tr>
			                                                  <tr>
			                                                    <td height="7" background="images/left_menu_line_02.jpg"></td>
			                                                  </tr> -->
			
			                                              </table></td>
			                                            </tr>
			                                            <tr>
			                                              <td height="15">&nbsp;</td>
			                                            </tr>
			                                          </table>
			                                    </td>
			                                        <td width="15" valign="top"><img id="hide_4" src="images/left_tab_hide.jpg" style="cursor: pointer;" name="Image29" width="15" height="77" border="0"></td>
			                                      </tr>
			                                  </table></td>
			                                </tr>
			                            </table>
                                        <!-- 04 시스템 관리 LEFT 끝 -->
                                    </td>
                                </tr>
                                <tr>
                                    <td><img src="images/left_menu_img_03.jpg" alt="" width="186" height="2"></td>
                                </tr>
                            </table>
                            <!-- 접속 서버 시작 -->
                           <c:if test="${null != sessionScope.userinfo.connsevrdstcd}">
                           <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                            	<td height="10" colspan="3"></td>
                               </tr>
                              <tr>
                                <td width="4"></td>
                                <td width="173" valign="middle" bgcolor="#c2c2c2" >
                                <table width="100%" border="0" align="center" cellpadding="1" cellspacing="1">
                                  <tr>
                                    <td height="30" bgcolor="#FFFFFF" align="center">
                                    	<img src="images/img_server.jpg" width="22" height="21" align="absmiddle"> <strong>테스트대상시스템<br/>
                                    	<span class="sub_titid" style="padding-left: 0px">[ ${sessionScope.userinfo.connsevrdstcdnm} ]</span></strong>
                                    </td>
                                  </tr>
                                </table></td>
                                <td width="14" valign="top">&nbsp;</td>
                              </tr>
                            </table>
                            </c:if>
                            <!-- 접속 서버 끝 -->
                             <!-- <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                            	<td height="10" colspan="3"></td>
                               </tr>
                              <tr>
                                <td width="4"></td>
                                <td width="173" valign="middle" bgcolor="#c2c2c2" >
                                <table width="100%" border="0" align="center" cellpadding="1" cellspacing="1">
                                  <tr>
                                    <td height="30" bgcolor="#FFFFFF">&nbsp;<img src="images/ico_pdf.gif" width="13" height="13" align="absmiddle">&nbsp;&nbsp;&nbsp;<a href="javascript:fileDownload('document/messageTestRo_menual_V1.0.pdf');" ><strong>사용자메뉴얼 </strong></span></td>
                                  </tr>
                                </table></td>
                                <td width="14" valign="top">&nbsp;</td>
                              </tr>
                            </table> -->
                       </td>
                       
                       <td id="h_left_menu_area" width="0" width="0" valign="top" background="" style="display: none;">
                            <table border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td><img src="images/left_menu_img_01.jpg" alt="" width="0" height="28"></td>
                                </tr>
                                <tr>
                                    <td background="">

                                        <!-- 04 시스템 관리 LEFT 시작 -->
                                        <table id="left04_tb" border="0" cellspacing="0" cellpadding="0" >
			                                <tr>
			                                  <td height="26" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
			                                      <tr>


			                                        <td  valign="top"><img id="show_1" src="images/left_tab_hide.jpg" name="Image29" width="15" height="77" border="0" style="cursor: pointer;"></td>
			                                      </tr>
			                                  </table></td>
			                                </tr>
			                            </table>
                                        <!-- 04 시스템 관리 LEFT 끝 -->
                                    </td>
                                </tr>
                                <tr>
                                    <td><img src="images/left_menu_img_03.jpg" alt="" width="0" height="0"></td>
                                </tr>
                            </table>
                            </td>