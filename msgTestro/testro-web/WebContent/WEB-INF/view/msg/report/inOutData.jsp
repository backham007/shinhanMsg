<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
                            <table width="100%" border="0" cellspacing="0" cellpadding="1">
                              <tr>
                                <td height="10" colspan="2"></td>
                              </tr>
                              <tr>
                                <td class="sub_tit02">테스트데이터 기본정보</td>
                              </tr>
                            </table>
                            <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc">
                              <tr>
                                <td width="20%" class="tm_left_slim">테스트데이터 명</td>
                                <td colspan="3" class="tm_text">${master.tsdataname}</td>
                                </tr>
                              <tr>
                                <td width="20%" class="tm_left_slim">거래코드</td>
                                <td width="30%" class="tm_text">${master.trancd}</td>
                                <td width="20%" class="tm_left_slim">거래결과</td>
                                <td width="30%" class="tm_text">${master.rsultsucssyn}</td>
                              </tr>
                            </table>
                            <table width="100%" border="0" cellspacing="0" cellpadding="1">
                              <tr>
                                <td height="10" colspan="2"></td>
                              </tr>
                              <tr>
                                <td class="sub_tit02">헤더부</td>
                              </tr>
                            </table>
                            <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc" style="table-layout:fixed;">
                            <c:set var="curRptName" value=""/>
                            <c:set var="curRptCnt" value=""/>
                            <c:set var="fleldIndex" value="0"/>
                            <c:forEach var="data" items="${headerList}" varStatus="status">
                    			<c:choose>
                              		<c:when test="${empty data.rptname}">
			                            <c:choose>
											<c:when test="${(fleldIndex%2) == 0}">
				                              <tr>
				                                <td width="20%" style="word-break:break-all" class="tm_left_slim">${data.tsdatafldname} (${data.tscsflddesc})</td>
				                                <td width="30%" style="word-break:break-all" class="tm_text">
				                                	<pre class="tm_text" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all"><c:if test="${data.tscsfldtype == 'hex'}">0x</c:if>${data.tsdataflddata}</pre>
				                                </td>
				                              <c:if test="${status.last}">
				                                <td width="50%" colspan="2" class="tm_text"></td>
				                              </c:if>
				                             </c:when>
											 <c:when test="${(fleldIndex%2) == 1}">
				                                <td width="20%" style="word-break:break-all" class="tm_left_slim">${data.tsdatafldname} (${data.tscsflddesc})</td>
				                                <td width="30%" style="word-break:break-all" class="tm_text">
				                                	<pre class="tm_text" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all"><c:if test="${data.tscsfldtype == 'hex'}">0x</c:if>${data.tsdataflddata}</pre>
				                                </td>
				                              </tr>
				                        	</c:when>
										</c:choose>
										<c:set var="curRptCnt" value=""/>
										<c:set var="fleldIndex" value="${fleldIndex+1}"/>
									</c:when>
									<c:otherwise>
										<c:if test="${data.rptname != curRptName || data.rptcnt != curRptCnt}">
											<c:if test='${(fleldIndex%2) == "1"}'>
						  		      			<td width="50%" style="word-break:break-all"  class="tm_text" colspan="2"></td>
							     		    </tr>
						  		      		</c:if>
											<c:set var="curRptName" value="${data.rptname}"/>
											<c:set var="curRptCnt" value="${data.rptcnt}"/>
											<tr>
												<td width="100%" colspan="4" class="tm_center_slim">반복${data.rptcnt}</td>
											</tr>
										</c:if>
										<tr>
											<td width="40%" style="word-break:break-all" class="tm_left_slim">${data.tsdatafldname} (${data.tscsflddesc})</td>
						      				<td width="60%" style="word-break:break-all" class="tm_text_slim" colspan="3">
						      					<pre class="tm_text" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all"><c:if test="${data.tscsfldtype == 'hex'}">0x</c:if>${data.tsdataflddata}</pre>
						      				</td>
						      		 	</tr>
						      		 	<c:set var="fleldIndex" value="0"/>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							</table>
                            <table width="100%" border="0" cellspacing="0" cellpadding="1">
                              <tr>
                                <td height="10" colspan="2"></td>
                              </tr>
                              <tr>
                                <td class="sub_tit02">개별부</td>
                              </tr>
                            </table>
                            <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc" style="table-layout:fixed;">
                            <c:set var="curRptName" value=""/>
                            <c:set var="curRptCnt" value=""/>
                            <c:set var="fleldIndex" value="0"/>
                            <c:forEach var="data" items="${inviList}" varStatus="status">
                    			<c:choose>
                              		<c:when test="${empty data.rptname}">
			                            <c:choose>
											<c:when test="${(status.index%2) == 0}">
				                              <tr>
				                                <td width="20%" style="word-break:break-all" class="tm_left_slim">${data.tsdatafldname} (${data.tscsflddesc})</td>
				                                <td width="30%" style="word-break:break-all" class="tm_text">
				                                	<pre class="tm_text" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all"><c:if test="${data.tscsfldtype == 'hex'}">0x</c:if>${data.tsdataflddata}</pre>
				                                </td>
				                              <c:if test="${status.last}">
				                                <td width="50%" colspan="2" class="tm_text"></td>
				                              </c:if>
				                             </c:when>
											 <c:when test="${(status.index%2) == 1}">
				                                <td width="20%" style="word-break:break-all" class="tm_left_slim">${data.tsdatafldname} (${data.tscsflddesc})</td>
				                                <td width="30%" style="word-break:break-all" class="tm_text">
				                                	<pre class="tm_text" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all"><c:if test="${data.tscsfldtype == 'hex'}">0x</c:if>${data.tsdataflddata}</pre>
				                                </td>
				                              </tr>
				                        	</c:when>
										</c:choose>
										<c:set var="curRptCnt" value=""/>
										<c:set var="fleldIndex" value="${fleldIndex+1}"/>
									</c:when>
									<c:otherwise>
										<c:if test="${data.rptname != curRptName || data.rptcnt != curRptCnt}">
											<c:if test='${(fleldIndex%2) == "1"}'>
						  		      			<td width="50%" style="word-break:break-all"  class="tm_text" colspan="2"></td>
							     		    </tr>
						  		      		</c:if>
											<c:set var="curRptName" value="${data.rptname}"/>
											<c:set var="curRptCnt" value="${data.rptcnt}"/>
											<tr>
												<td width="100%" colspan="4" class="tm_center_slim">반복${data.rptcnt}</td>
											</tr>
										</c:if>
										<tr>
											<td width="40%" style="word-break:break-all" class="tm_left_slim">${data.tsdatafldname} (${data.tscsflddesc})</td>
						      				<td width="60%" style="word-break:break-all" class="tm_text_slim" colspan="3">
						      					<pre class="tm_text" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all"><c:if test="${data.tscsfldtype == 'hex'}">0x</c:if>${data.tsdataflddata}</pre>
						      				</td>
						      		 	</tr>
						      		 	<c:set var="fleldIndex" value="0"/>
									</c:otherwise>
								</c:choose>
							</c:forEach>
                            </table>