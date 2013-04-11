<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<input id="flawTsDataId" type="hidden" value="${tsDataId}"/>
<input id="flawAcmplNth" type="hidden" value="${acmplNth}"/>
                            <table width="100%" height="180" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                              <tr>
                                <td height="100%" valign="top" bgcolor="#FFFFFF">
                                	<table id="list1"></table>
									<div id="pager1"></div>
                                </td>
                              </tr>
                            </table>
                            <table width="100%" border="0" cellspacing="0" cellpadding="1">
                              <tr>
                                <td height="5" colspan="3"></td>
                              </tr>
                              <tr>
                                <td>&nbsp;</td>
                                <td><table align="right" border="0" cellpadding="0" cellspacing="0">
                                  <tr>
                                    <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                    <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onClick="newFlaw();">신규추가</td>
                                    <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                  </tr>
                                </table></td>
                              </tr>
                            </table>
                            <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc">
                              <tr>
                                <td width="150" class="tm_center_slim">거래유형</td>
                                <td class="tm_text"><select id="tscsTranTypeCd" name="tscsTranTypeCd" class="menu" style="width:200px">
                                                                </select></td>
                                <td width="150" class="tm_center_slim">결함유형</td>
                                <td class="tm_text"><select id="tscsDefRnDstCd" name="tscsDefRnDstCd"   class="menu" style="width:200px">
                                </select></td>
                              </tr>
                              <tr>
                                <td class="tm_center_slim">결함심각도</td>
                                <td class="tm_text"><select id="defSeverity" name="defSeverity"   class="menu" style="width:200px">
                                                                </select></td>
                                <td class="tm_center_slim">조치우선순위</td>
                                <td class="tm_text"><select id="priActionsCd" name="priActionsCd"   class="menu" style="width:200px">
                                </select></td>
                              </tr>
                              <tr>
                                <td class="tm_center_slim">에러코드</td>
                                <td colspan="3" class="tm_text"><input id="defErrCd" name="defErrCd" type="text" class="input_topinq" style="width:100%" maxlength="400"></td>
                              </tr>
                              <tr>
                                <td class="tm_center_slim">에러프로그램</td>
                                <td colspan="3" class="tm_text"><input id="defErrPrg" name="defErrPrg" type="text" class="input_topinq" style="width:100%" maxlength="400"></td>
                              </tr>
                              <tr>
                                <td class="tm_center_slim">결함내용</td>
                                <td colspan="3" class="tm_text"><textarea id="testOpinCtnt" name="testOpinCtnt" class="input_topinq" style="width:100%; height:50px;"></textarea></td>
                                </tr>
                              <tr>
                                <td class="tm_center_slim">결함배분자</td>
                                <td class="tm_text"><input id="defDisusrId" name="defDisusrId" type="text" class="input_topinq" style="width:55px" readOnly>
                                  <img src="images/btn_pop.gif" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer" onClick="openUserPop('defDisusr');">
                                  <input id="defDisusrNm" name="defDisusrNm" type="text" class="input_topinq" style="width:60px" readOnly>
                                  <img src="images/btn_eraser.gif" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer" onClick="deleteDefDisusr();">
                                </td>
                                <td class="tm_center_slim">결함조치자</td>
                                <td class="tm_text"><input id="actUsrId" name="actUsrId" type="text" class="input_topinq" style="width:55px" readOnly>
                                  <img src="images/btn_pop.gif" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer" onClick="openUserPop('actUsr');">
                                  <input id="actUsrNm" name="actUsrNm" type="text" class="input_topinq" style="width:60px" readOnly>
                                  <img src="images/btn_eraser.gif" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer" onClick="deleteActUsr();">
                                </td>
                              </tr>
                              <tr>
                                <td class="tm_center_slim">결함진행상태</td>
                                <td class="tm_text"><select id="defCd" name="defCd" class="menu" style="width:200px">
                                </select></td>
                                <td class="tm_center_slim">조치완료예정일</td>
                                <td class="tm_text"><input id="actCloseYMS" name="actCloseYMS" type="text" class="input_topinq" style="width:65px" maxlength="10">
                                  <img src="images/un_sub_cen_cal.gif" alt="달력" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer" onclick="javascript:popUpCalendar(this, 'actCloseYMS', 'yyyy-mm-dd','CENTER','MIDDLE');"></td>
                              </tr>
                            </table>
                            <table width="100%" border="0" cellspacing="0" cellpadding="1">
                              <tr>
                                <td height="5" colspan="4"></td>
                              </tr>
                              <tr>
                                <td width="80"><table border="0" align="left" cellpadding="0" cellspacing="0">
                                    <tr>
                                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                      <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onClick="saveFlaw();">저 장</td>
                                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                    </tr>
                                </table></td>
                                <td align="center" class="point_text"></td>
                                <td width="80" ><table align="right" border="0" cellpadding="0" cellspacing="0">
                                    <tr>
                                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                      <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onClick="deleteFlaw();">삭 제</td>
                                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                    </tr>
                                </table></td>
                              </tr>
                            </table>
