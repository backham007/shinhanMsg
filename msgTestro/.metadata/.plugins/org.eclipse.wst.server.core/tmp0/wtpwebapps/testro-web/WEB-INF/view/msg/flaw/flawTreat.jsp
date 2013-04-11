<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<input id="treatTsDataId" type="hidden" value="${tsDataId}"/>
<input id="treatAcmplNth" type="hidden" value="${acmplNth}"/>
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
                                <td height="10"></td>
                              </tr>
                            </table>
                            <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc">
                              <tr>
                                <td width="150" class="tm_center_slim">결함유형</td>
                                <td colspan="3" class="tm_text"><select id="tscsDefRnDstCd" name="tscsDefRnDstCd"  class="menu" style="width:200px" disabled>
                                </select></td>
                                </tr>
                              <tr>
                                <td class="tm_center_slim">결함내용</td>
                                <td colspan="3" class="tm_text"><textarea id="testOpinCtnt" name="testOpinCtnt" class="input_topinq" style="width:100%; height:50px;" readOnly></textarea></td>
                              </tr>
                              <tr>
                                <td class="tm_center_slim">결함발생영역</td>
                                <td class="tm_text"><select id="defDomainCd" name="defDomainCd" class="menu" style="width:200px" onChange="setDefCauseCd();">
                                </select></td>
                                <td width="150" class="tm_center_slim">결함발생원인</td>
                                <td class="tm_text"><select id="defCauseCd" name="defCauseCd"   class="menu" style="width:200px">
                                </select></td>
                              </tr>
                              <tr>
                                <td class="tm_center_slim">조치내용</td>
                                <td colspan="3" class="tm_text"><textarea id="defActContent" name="defActContent" class="input_topinq" style="width:100%; height:60px;"></textarea></td>
                                </tr>
                              <tr>
                                <td class="tm_center_slim">재테스트일시</td>
                                <td class="tm_text"><input id="reTestYMS" name="reTestYMS" type="text" class="input_topinq" style="width:65px" maxlength="10" readOnly>
                                  <img src="images/un_sub_cen_cal.gif" alt="달력" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer" onclick="javascript:popUpCalendar(this, 'reTestYMS', 'yyyy-mm-dd','CENTER','MIDDLE');">
                                  <img src="images/btn_eraser.gif" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer" onClick="deleteReTestYMS();">
                                </td>
                                <td class="tm_center_slim">재테스트결과</td>
                                <td class="tm_text"><select id="reTestRsult" name="reTestRsult"   class="menu" style="width:200px">
                                </select></td>
                              </tr>
                              <tr>
                                <td class="tm_center_slim">결함진행상태</td>
                                <td colspan="3" class="tm_text"><select id="defCd" name="defCd" class="menu" style="width:200px">
                                </select></td>
                                </tr>
                            </table>
                            <table width="100%" border="0" cellspacing="0" cellpadding="1">
                              <tr>
                                <td height="5" colspan="4"></td>
                              </tr>
                              <tr>
                                <td width="80"><table align="left" border="0" cellpadding="0" cellspacing="0">
                                  <tr>
                                    <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                    <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onClick="modifyTreat();">저 장</td>
                                    <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                  </tr>
                                </table></td>
                                <td align="center" class="point_text">&nbsp;</td>
                                <td width="80" >&nbsp;</td>
                              </tr>
                            </table>
