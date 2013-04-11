<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
                            <table width="100%" border="0" cellspacing="0" cellpadding="1">
                              <tr>
                                <td height="10" colspan="2"></td>
                              </tr>                              
                              <tr>
                                <td class="sub_tit02">헤더부</td>
                              </tr>
                            </table>
                            <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc">
	                            <tr>
		                          <td width="10%" class="tr_center">설정여부</td>
		                          <td width="30%" class="tr_center">항목</td>
		                          <td width="25%" class="tr_center">예상결과</td>
		                          <td width="25%" class="tr_center">거래결과값</td>
		                          <td width="10%" class="tr_center">성공여부</td>
		                        </tr>
	                            <c:set var="curRptName" value=""/>
	                            <c:set var="curRptCnt" value=""/>
	                            <c:set var="fleldYn" value="N"/>
	                            <c:forEach var="data" items="${dataList}" varStatus="status">
	                            	<c:if test="${data.tscsflddiv == '01'}">
		                    			<c:choose>
		                              		<c:when test="${!empty data.rptname}">
		                              			<c:if test="${data.rptname != curRptName || data.rptcnt != curRptCnt}">
													<c:set var="curRptName" value="${data.rptname}"/>
													<c:set var="curRptCnt" value="${data.rptcnt}"/>
													<tr>
														<td width="200" colspan="4" class="tm_center_slim">반복${data.rptcnt}</td>
													</tr>
												</c:if>
		                              		</c:when>
		                              	</c:choose>
				                        <tr>
				                          <td width="10%" class="tr_text_center">${data.chkyn}</td>
				                          <td width="30%" class="tm_text">${data.tsdatafldname}(${data.tscsflddesc})</td>
				                          <td width="25%" class="tm_text">
				                          	<pre class="tm_text" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all"><c:if test="${data.tscsfldtype == 'hex'}">0x</c:if>${data.chkpointexpcctnt}</pre>
				                          </td>
				                           <td width="25%" class="tm_text">
				                          	<pre class="tm_text" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all"><c:if test="${data.tscsfldtype == 'hex'}">0x</c:if>${data.chkpointoutptctnt}</pre>
				                          </td>
				                          <td width="10%" class="tr_text_center">
				                          	<c:if test="${data.chkpointsucssyn == 'Y'}"><IMG src='images/icon_rep_ok.gif' width=34 height=16 hspace='2' vspace='3' align='absmiddle' border=0></c:if>
				                          	<c:if test="${data.chkpointsucssyn == 'N'}"><IMG src='images/icon_rep_fail.gif' width=34 height=16 hspace='2' vspace='3' align='absmiddle' border=0></c:if>
				                          </td>
				                        </tr>
				                        <c:set var="fleldYn" value="Y"/>
									</c:if>
								</c:forEach>
								<c:if test="${fleldYn == 'N'}">
									<tr>
										<td colspan="5" class="tr_text_center">데이터가 없습니다</td>
									</tr>
								</c:if>
							</table>
                            <table width="100%" border="0" cellspacing="0" cellpadding="1">
                              <tr>
                                <td height="10" colspan="2"></td>
                              </tr>
                              <tr>
                                <td class="sub_tit02">개별부</td>
                              </tr>
                            </table>
                            <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc" style="table-layout: fixed;">
                            	<tr>
		                          <td width="10%" class="tr_center">설정여부</td>
		                          <td width="30%" class="tr_center">항목</td>
		                          <td width="25%" class="tr_center">예상결과</td>
		                          <td width="25%" class="tr_center">거래결과값</td>
		                          <td width="10%" class="tr_center">성공여부</td>
		                        </tr>
	                            <c:set var="curRptName" value=""/>
	                            <c:set var="curRptCnt" value=""/>
	                            <c:set var="fleldYn" value="N"/>
	                            <c:forEach var="data" items="${dataList}" varStatus="status">
	                            	<c:if test="${data.tscsflddiv == '02'}">
		                    			<c:choose>
		                              		<c:when test="${!empty data.rptname}">
		                              			<c:if test="${data.rptname != curRptName || data.rptcnt != curRptCnt}">
													<c:set var="curRptName" value="${data.rptname}"/>
													<c:set var="curRptCnt" value="${data.rptcnt}"/>
													<tr>
														<td width="200" colspan="4" class="tm_center_slim">반복${data.rptcnt}</td>
													</tr>
												</c:if>
		                              		</c:when>
		                              	</c:choose>
				                        <tr>
				                          <td width="10%" class="tr_text_center">${data.chkyn}</td>
				                          <td width="30%" class="tm_text">${data.tsdatafldname}(${data.tscsflddesc})</td>
				                          <td width="25%" class="tm_text">
				                          	<pre class="tm_text" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all"><c:if test="${data.tscsfldtype == 'hex'}">0x</c:if>${data.chkpointexpcctnt}</pre>
				                          </td>
				                          <td width="25%" class="tm_text">
				                          	<pre class="tm_text" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all"><c:if test="${data.tscsfldtype == 'hex'}">0x</c:if>${data.chkpointoutptctnt}</pre>
				                          </td>
				                          <td width="10%" class="tr_text_center">
				                          	<c:if test="${data.chkpointsucssyn == 'Y'}"><IMG src='images/icon_rep_ok.gif' width=34 height=16 hspace='2' vspace='3' align='absmiddle' border=0></c:if>
				                          	<c:if test="${data.chkpointsucssyn == 'N'}"><IMG src='images/icon_rep_fail.gif' width=34 height=16 hspace='2' vspace='3' align='absmiddle' border=0></c:if>
				                          </td>
				                        </tr>
				                        <c:set var="fleldYn" value="Y"/>
									</c:if>
								</c:forEach>
								<c:if test="${fleldYn == 'N'}">
									<tr>
										<td colspan="5" class="tr_text_center">데이터가 없습니다</td>
									</tr>
								</c:if>
                            </table>