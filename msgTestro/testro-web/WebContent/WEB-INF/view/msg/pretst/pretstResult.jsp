<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>전문 테스트로(TESTRO)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" href="images/TESTRO.ico" type="image/ico" />
<script type="text/javascript" src="js/cmn/utils/json2.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/jquery-1.5.2.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/jquery.blockUI.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/common.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/msg/pretst/pretstResult.js" charset="UTF-8"></script>
</head>
 <body bgcolor="#FFFFFF" background="images/left_menu_bg.jpg" leftmargin="0" rightmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="MM_preloadImages('images/top_menu_01_02.jpg','images/top_menu_02_02.jpg','images/top_menu_03_02.jpg','images/top_menu_04_02.jpg','images/top_menu_05_02.jpg','images/top_menu_06_02.jpg','images/top_menu_07_02.jpg')">

		   <div id="Minwidth">
		       <div id="Page">
		           <div id="contents">
		          <!-- top menu 시작 --> 
		          <table width="100%" border="0" cellspacing="0" cellpadding="0">
				<jsp:include page="/WEB-INF/view/cmn/topMenu.jsp" flush="true"></jsp:include>
				 </table>
		           <!-- top menu 끝 -->   
		           
		               <table width="100%" border="0" cellpadding="0" cellspacing="0" id="Table_01">
		                   <tr> 
							<!-- left menu 시작 -->
							<jsp:include page="/WEB-INF/view/cmn/leftMenu.jsp" flush="true"></jsp:include>
							<!-- left menu 끝 -->
		                       <td valign="top">
		                      <div id="resultDiv">
                                     <form name="pretstResult" id="pretstResult" method="post">
										<input type="hidden" name="tabGb">
										<input type="hidden" name="tabGb2">
								 <table width="100%" height="100%" border="0" cellpadding="15" cellspacing="0">
                                <tr> 
                                    <td valign="top">		
										
										
                                      <table border=0 cellpadding=0 cellspacing=0 width=100%>
                                            <tr> 
                                                <td width="20"><img src="images/title_bullet1.gif"></td>
                                                <td width="150" class="sub_tit">거래테스트 실행결과</td>
                                              <td valign="bottom"><span class="point_text">기본 테스트데이터명과 기본 테스트데이터 설명을 입력한 후 테스트케이스로 활용하십시오.</span></td>
                                        </tr>
                                            <tr > 
                                                <td background="images/tit_line_bg.gif" height="6" colspan="3"><img src="images/tit_line_bg.gif"></td>
                                            </tr>
                                            <tr > 
                                                <td height="10" colspan="3"></td>
                                            </tr>
                                      </table>
                                    
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                            <tr>
                                                <td class="sub_tit02"> 테스트 실행결과</td>
                                              <td align="right"></td>
                        				  </tr>
                                            <tr>
                                                <td height="1" colspan="2"></td>
                                            </tr>
                                      </table>
                                    <input type="hidden" name="rsultSucssYn" id="rsultSucssYn" value="${executeDto.rsultSucssYn}"/>
                                    <input type="hidden" name="tranName" id="tranName" value="${tranName}"/>
                                    <input type="hidden" name="tranCd" id="tranCd" value="${executeDto.tranCd}"/>
                                    <input type="hidden" name="chnlDstcd" id="chnlDstcd" value="${executeDto.chnlDstcd}"/>
                                        <table width = "100%" border = "0" cellpadding = "0" cellspacing = "1" bgcolor="#baccdc" >
                                          <tr>
                                            <td width="130px" class="tm_left">거래코드</td>
                                            <td class="tm_text1">${executeDto.tranCd}</td>
                                            <td width="140px" class="tm_left">거래명</td>
                                            <td class="tm_text1">${tranName}</td>
                                          </tr>
                                          <tr>
                                            <td class="tm_left">거래결과여부</td>
                                            	<c:choose>
	                                            	<c:when test='${(executeDto.rsultSucssYn) == "Y"}'>
														<td class="tm_text1"><img src="images/icon_rep_ok.gif"></td>
													</c:when>
													<c:otherwise>
														<td class="tm_text1"><img src="images/icon_rep_fail.gif"></td>
													</c:otherwise>
												</c:choose>
                                            <td class="tm_left">결과메시지</td>
                                            	<c:choose>
	                                            	<c:when test='${(executeDto.rsultSucssYn) == "Y"}'>
														<td class="tm_text1">거래 성공</td>
													</c:when>
													<c:otherwise>
														<td class="tm_text1">${executeDto.rsultMsg}</td>
													</c:otherwise>
												</c:choose>
                                          </tr>
                                          <tr>
                                            <td class="tm_left">테스트시작일시</td>
                                            <td class="tm_text1" >&nbsp;${executeDto.startTime}</td>
                                            <td class="tm_left">경과시간</td>
                                            <td class="tm_text1" >&nbsp;${executeDto.elapsedTime}&nbsp;ms</td>
                                          </tr>
                                          <tr>
                                            <td class="tm_left">기본 테스트데이터명</td>
                                            <td class="tm_text1" ><input name="tsdataName" id="tsdataName" type="text" class="input_topinq" style="width:99%" value="${executeDto.tranCd}의 기본테스트"></td>
                                            <td class="tm_left">기본 테스트데이터설명</td>
                                            <td class="tm_text1"><input name="tsdataDesc" id="tsdataDesc" type="text" class="input_topinq" style="width:99%"></td>
                                          </tr>
                                        </table>
                                      <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                          <td height="10" colspan="2"></td>
                                        </tr>
                                      <tr>
                                        <td class="sub_tit02">입력 데이터</td>
                                        <td align="right"></td>
                                      </tr>
                                      <tr>
                                        <td height="1" colspan="2"></td>
                                      </tr>
                                    </table>
                                    <TABLE cellSpacing="0" cellPadding="0" width="100%" border="0">
                                      <TR>
                                        <TD width="4"><IMG height="31" src="images/tabbg_01_01.gif" width="4"></TD>
                                        <TD background="images/tabbg_01_02.gif"><!-- Menu -->
                                        <TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
                                              <TR>
                                                <TD>&nbsp;</TD>
                                                <TD>
                                                <TABLE cellspacing="0" cellpadding="0" border="0">
                                                    <TR>
                                                      <TD width=2>&nbsp;</TD>
                                                      <TD>
                                                      <DIV id="view0_on">
                                                          <TABLE cellSpacing=0 cellPadding=0 border=0>
                                                            <TR>
                                                              <TD width=5 background=images/tab_01.gif height=30>&nbsp;</TD>
                                                              <TD class=tab_tit onclick="javascript:doSearch('view0');" background=images/tab_02.gif><FONT style="CURSOR:pointer">헤더부</FONT></TD>
                                                              <TD width=5 background=images/tab_03.gif>&nbsp;</TD>
                                                            </TR>
                                                          </TABLE>
                                                      </DIV>
                                                          <DIV id="view0_off">
                                                            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                                                              <TR>
                                                                <TD width=3 background=images/btn_bg_02_01.jpg><IMG height=30 src="images/tab01_01.gif" width=4></TD>
                                                                <TD class=tab_tit02  vAlign=center background=images/tab01_02.gif onclick="javascript:doSearch('view0');"><FONT style="CURSOR:pointer">헤더부</FONT></TD>
                                                                <TD vAlign=bottom background=images/btn_bg_02_02.jpg><IMG height=30 src="images/tab03_03.gif" width=3></TD>
                                                              </TR>
                                                            </TABLE>
                                                          </DIV></TD>
                                                      <TD width=2>&nbsp;</TD>
                                                      <TD><DIV id="view1_on">
                                                          <TABLE cellSpacing=0 cellPadding=0 border=0>
                                                            <TR>
                                                              <TD width=5 background=images/tab_01.gif height=30>&nbsp;</TD>
                                                              <TD class=tab_tit onClick="javascript:doSearch('view1');" background=images/tab_02.gif style="CURSOR:pointer">개별부</TD>
                                                              <TD width=5 background=images/tab_03.gif>&nbsp;</TD>
                                                            </TR>
                                                          </TABLE>
                                                      </DIV>
                                                          <DIV id="view1_off">
                                                            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                                                              <TR>
                                                                <TD width=3 background=images/btn_bg_02_01.jpg><IMG height=30 src="images/tab01_01.gif" width=4></TD>
                                                                <TD class=tab_tit02  vAlign=center background=images/tab01_02.gif onClick="javascript:doSearch('view1');"><FONT style="cursor:pointer">개별부</FONT></TD>
                                                                <TD vAlign=bottom background=images/btn_bg_02_02.jpg><IMG height=30 src="images/tab03_03.gif" width=3></TD>
                                                              </TR>
                                                            </TABLE>
                                                      </DIV></TD>
                                                          <TD width=20>&nbsp;</TD>
                                                      <TD><DIV id="view2_on">
                                                          <TABLE cellSpacing=0 cellPadding=0 border=0>
                                                            <TR>
                                                              <TD width=5 background=images/tab_01.gif height=30>&nbsp;</TD>
                                                              <TD class=tab_tit onClick="javascript:doSearch('view2');" background=images/tab_02.gif><FONT style="cursor:pointer">송신[원본테이터]</FONT></TD>
                                                              <TD width=5 background=images/tab_03.gif>&nbsp;</TD>
                                                            </TR>
                                                          </TABLE>
                                                      </DIV>
                                                          <DIV id="view2_off">
                                                            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                                                              <TR>
                                                                <TD width=3 background="images/btn_bg_02_01.jpg"><IMG height=30 src="images/tab01_01.gif" width=4></TD>
                                                                <TD class="tab_tit02"  vAlign="center" background="images/tab01_02.gif" onclick="javascript:doSearch('view2');" style="cursor:pointer">송신[원본테이터]</TD>
                                                                <TD valign="bottom" background="images/btn_bg_02_02.jpg"><IMG height=30 src="images/tab03_03.gif" width=3></TD>
                                                              </TR>
                                                            </TABLE>
                                                          </DIV></TD>
                                                    </TR>
                                                </TABLE></TD>
                                              </TR>
                                          </TABLE>
                                        </TD>
                                        <TD width=4><IMG height=31 src="images/tabbg_01_03.gif" width=4></TD>
                                      </TR>
                                      <TR>
                                        <TD width=3 background="images/tabbg_02_01.gif" bgColor=#456788></TD>
                                        <TD vAlign=top width="100%" >

                                               	<div id="inputDiv0" style="DISPLAY:none">
                                             		<div id="apDiv1" style=" height:155px; padding-right: 18px" class="apDiv1">
		                                              	<table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc" style="table-layout: fixed;">
		                                                	<c:set var="list" value="${executeDto.inputDto}" />
		                                                	<c:set var="curRptCnt" value="" />
		                                                	<c:set var="fleldIndex" value="0"/>
		                                                	<c:forEach var="list2" items="${list.headerList}" varStatus="status">
																<c:choose>
																	<c:when test='${(fleldIndex%2) == "0"}'>
																		<c:set var="startHtml" value="<tr>" />
																		<c:set var="endHtml" value="" />
																	</c:when>
																	<c:when test='${(fleldIndex%2) == "1"}'>
																		<c:set var="startHtml" value="" />
																		<c:set var="endHtml" value="</tr>" />
																	</c:when>
																</c:choose>
																<c:set var="tsdataFldName" value="${list2.tsdataFldName}" />
																<c:set var="tscsFldDesc" value="${list2.tscsFldDesc}" />
																<c:set var="tsdataFldData" value="${list2.tsdataFldData}" />
																<c:set var="tscsFldDiv" value="${list2.tscsFldDiv}" />
																<c:set var="rptName" value="${list2.rptName}" />
																<c:set var="rptCnt" value="${list2.rptCnt}" />
																<c:set var="tscsFldType" value="${list2.tscsFldType}" />
																<c:choose>
																	
																	<c:when test='${empty rptName}'>
																	
																		 ${startHtml}
															    		      <c:choose>
															      		      <c:when test='${(tscsFldType) == "hex"}'>
															      		       <td width="25%" style="word-break:break-all" class="tm_left_slim">${tsdataFldName}(${tscsFldDesc})</td>
															      		          <td width="25%" style="word-break:break-all" class="tm_text_slim">
															      		          	<pre class="tm_text_slim" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all">0x${tsdataFldData}</pre>
															      		          </td>
															      		      </c:when>
															      		      <c:otherwise>
															      		     	 <td width="25%" style="word-break:break-all" class="tm_left_slim">${tsdataFldName}(${tscsFldDesc})</td>
															      		          <td width="25%" style="word-break:break-all" class="tm_text_slim">
															      		          	<pre class="tm_text_slim" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all">${tsdataFldData}</pre>
															      		          </td>
															      		      </c:otherwise>
															    		      </c:choose>
																	      ${endHtml}
																	      <c:set var="curRptCnt" value="" />
																	      <c:set var="fleldIndex" value="${fleldIndex+1}"/>
																	 </c:when> 
																	 <c:otherwise>
														 				<c:choose>
												      		      			<c:when test='${curRptCnt != rptCnt}'>
												      		      				<c:if test='${(fleldIndex%2) == "1"}'>
														      		          		<td width="50%" style="word-break:break-all" class="tm_text_slim" colspan="2"></td>
														      		          	${endHtml}
												      		      				</c:if>
												      		      				<tr>
												      		      					<c:set var="curRptCnt" value="${rptCnt}" />
														 							<td colspan="4" class="tm_center_slim">반복${rptCnt}</td>
														 						</tr>
														 					</c:when>
														 				</c:choose>
																 		<tr>
																			<c:choose>
																      		    <c:when test='${(tscsFldType) == "hex"}'>
																	      		    <td width="25%" style="word-break:break-all" class="tm_left_slim">${tsdataFldName}(${tscsFldDesc})</td>
																	      		    <td width="25%" style="word-break:break-all" class="tm_text_slim" colspan="3">
																	      		    	<pre class="tm_text_slim" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all">0x${tsdataFldData}</pre>
																	      		    </td>
																      		    </c:when>
																      		    <c:otherwise>
																	      		    <td width="25%" style="word-break:break-all"  class="tm_left_slim">${tsdataFldName}(${tscsFldDesc})</td>
																	      		    <td width="25%" style="word-break:break-all" class="tm_text_slim" colspan="3">
																	      		    	<pre class="tm_text_slim" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all">${tsdataFldData}</pre>
																	      		    </td>
																      		    </c:otherwise>
															    		    </c:choose>
														      		 	</tr>
														      		 	<c:set var="fleldIndex" value="0"/>
																	 </c:otherwise>   
																</c:choose>
															</c:forEach>
														</table>
                                          			</div>
												</div>
												<div id="inputDiv1" style="DISPLAY:none">
													<div id="apDiv1" style=" height:155px; padding-right: 18px" class="apDiv1">
                                              			<table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc" style="table-layout: fixed;">
															<c:set var="list" value="${executeDto.inputDto}" />
															<c:set var="curRptCnt" value="" />
															<c:set var="fleldIndex" value="0"/>
																<c:forEach var="list2" items="${list.inviList}" varStatus="status">
																	<c:choose>
																		<c:when test='${(fleldIndex%2) == "0"}'>
																			<c:set var="startHtml" value="<tr>" />
																			<c:set var="endHtml" value="" />
																		</c:when>
																		<c:when test='${(fleldIndex%2) == "1"}'>
																			<c:set var="startHtml" value="" />
																			<c:set var="endHtml" value="</tr>" />
																		</c:when>
																	</c:choose>
																	<c:set var="tsdataFldName" value="${list2.tsdataFldName}" />
																	<c:set var="tscsFldDesc" value="${list2.tscsFldDesc}" />
																	<c:set var="tsdataFldData" value="${list2.tsdataFldData}" />
																	<c:set var="tscsFldDiv" value="${list2.tscsFldDiv}" />
																	<c:set var="rptName" value="${list2.rptName}" />
																	<c:set var="rptCnt" value="${list2.rptCnt}" />
																	<c:set var="tscsFldType" value="${list2.tscsFldType}" />
																	<c:choose>
																	
																		<c:when test='${empty rptName}'>
																		
																			 ${startHtml}
																    		      <c:choose>
																      		      <c:when test='${(tscsFldType) == "hex"}'>
																      		       <td width="25%" style="word-break:break-all" class="tm_left_slim">${tsdataFldName}(${tscsFldDesc})</td>
																      		          <td width="25%" style="word-break:break-all" class="tm_text_slim">
																      		          	<pre class="tm_text_slim" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all">0x${tsdataFldData}</pre>
																      		          </td>
																      		      </c:when>
																      		      <c:otherwise>
																      		     	 <td width="25%" style="word-break:break-all" class="tm_left_slim">${tsdataFldName}(${tscsFldDesc})</td>
																      		          <td width="25%" style="word-break:break-all" class="tm_text_slim">
																      		          	<pre class="tm_text_slim" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all">${tsdataFldData}</pre>
																      		          </td>
																      		      </c:otherwise>
																    		      </c:choose>
																		      ${endHtml}
																		      <c:set var="curRptCnt" value="" />
																		      <c:set var="fleldIndex" value="${fleldIndex+1}"/>
																		 </c:when> 
																		 <c:otherwise>
															 				<c:choose>
													      		      			<c:when test='${curRptCnt != rptCnt}'>
													      		      				<c:if test='${(fleldIndex%2) == "1"}'>
													      		      					<td width="50%" style="word-break:break-all" class="tm_text_slim" colspan="2"></td>
															      		          	${endHtml}
													      		      				</c:if>
													      		      				<tr>
													      		      					<c:set var="curRptCnt" value="${rptCnt}" />
															 							<td colspan="4" class="tm_center_slim">반복${rptCnt}</td>
															 						</tr>
															 					</c:when>
															 				</c:choose>
																	 		<tr>
																				<c:choose>
																	      		    <c:when test='${(tscsFldType) == "hex"}'>
																		      		    <td width="25%" style="word-break:break-all" class="tm_left_slim">${tsdataFldName}(${tscsFldDesc})</td>
																		      		    <td width="25%" style="word-break:break-all" class="tm_text_slim" colspan="3">
																		      		    	<pre class="tm_text_slim" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all">0x${tsdataFldData}</pre>
																		      		    </td>
																	      		    </c:when>
																	      		    <c:otherwise>
																		      		    <td width="25%" style="word-break:break-all"  class="tm_left_slim">${tsdataFldName}(${tscsFldDesc})</td>
																		      		    <td width="25%" style="word-break:break-all" class="tm_text_slim" colspan="3">
																		      		    	<pre class="tm_text_slim" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all">${tsdataFldData}</pre>
																		      		    </td>
																	      		    </c:otherwise>
																    		    </c:choose>
															      		 	</tr>
															      		 	<c:set var="fleldIndex" value="0"/>
																		 </c:otherwise>   
																	</c:choose> 
																</c:forEach>	
															</table>
                                          				</div>
													</div>
													
													<div id="inputDiv2" style="DISPLAY:none">
														<div id="apDiv1" style=" height:155px; padding-right: 18px" class="apDiv1">
                                              				<table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc" style="table-layout: fixed;">
																<tr>
																	<td class="tm_text_slim">
																		<pre class="tm_text_slim" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all">${inputHexFlet}</pre>
																	</td>
																</tr>
															</table>
                                          				</div>
													</div>	
                                       
                                        </TD>
                                        <TD width=3 height="100%" background="images/tabbg_02_03.gif" bgColor=#456788></TD>
                                      </TR>
                                      <TR>
                                        <TD width=4 height=4><IMG height=4 src="images/tabbg_03_01.gif" width=4></TD>
                                        <TD background=images/tabbg_03_02.gif><IMG height=4 src="images/tabbg_03_02.gif" width=3></TD>
                                        <TD width=4 height=4><IMG height=4 src="images/tabbg_03_03.gif" width=4></TD>
                                      </TR>
                                    </TABLE>
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                      <tr>
                                        <td height="10" colspan="2"></td>
                                      </tr>
                                      <tr>
                                        <td class="sub_tit02">출력 데이터</td>
                                        <td align="right"></td>
                                      </tr>
                                      <tr>
                                        <td height="1" colspan="2"></td>
                                      </tr>
                                    </table>
                                    <TABLE cellSpacing="0" cellPadding="0" width="100%" border="0">
                                      <TR>
                                        <TD width="4"><IMG height="31" src="images/tabbg_01_01.gif" width="4"></TD>
                                        <TD background="images/tabbg_01_02.gif"><!-- Menu -->
                                            <TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
                                              <TR>
                                                <TD>&nbsp;</TD>
                                                <TD><TABLE cellspacing="0" cellpadding="0" border="0">
                                                    <TR>
                                                      <TD width=2>&nbsp;</TD>
                                                      <TD><DIV id="view0_on2">
                                                          <TABLE cellSpacing=0 cellPadding=0 border=0>
                                                            <TR>
                                                              <TD width=5 background=images/tab_01.gif height=30>&nbsp;</TD>
                                                              <TD class=tab_tit onClick="javascript:doSearch2('view0');" background=images/tab_02.gif><FONT style="cursor:pointer">헤더부</FONT></TD>
                                                              <TD width=5 background=images/tab_03.gif>&nbsp;</TD>
                                                            </TR>
                                                          </TABLE>
                                                      </DIV>
                                                          <DIV id="view0_off2">
                                                            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                                                              <TR>
                                                                <TD width=3 background=images/btn_bg_02_01.jpg><IMG height=30 src="images/tab01_01.gif" width=4></TD>
                                                                <TD class=tab_tit02  vAlign=center background=images/tab01_02.gif onClick="javascript:doSearch2('view0');"><FONT style="cursor:pointer">헤더부</FONT></TD>
                                                                <TD vAlign=bottom background=images/btn_bg_02_02.jpg><IMG height=30 src="images/tab03_03.gif" width=3></TD>
                                                              </TR>
                                                            </TABLE>
                                                          </DIV></TD>
                                                      <TD width=2>&nbsp;</TD>
                                                      <TD><DIV id="view1_on2">
                                                          <TABLE cellSpacing=0 cellPadding=0 border=0>
                                                            <TR>
                                                              <TD width=5 background=images/tab_01.gif height=30>&nbsp;</TD>
                                                              <TD class=tab_tit onClick="javascript:doSearch2('view1');" background=images/tab_02.gif style="cursor:pointer">개별부</TD>
                                                              <TD width=5 background=images/tab_03.gif>&nbsp;</TD>
                                                            </TR>
                                                          </TABLE>
                                                      </DIV>
                                                          <DIV id="view1_off2">
                                                            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                                                              <TR>
                                                                <TD width=3 background=images/btn_bg_02_01.jpg><IMG height=30 src="images/tab01_01.gif" width=4></TD>
                                                                <TD class=tab_tit02  vAlign=center background=images/tab01_02.gif onClick="javascript:doSearch2('view1');"><FONT style="cursor:pointer">개별부</FONT></TD>
                                                                <TD vAlign=bottom background=images/btn_bg_02_02.jpg><IMG height=30 src="images/tab03_03.gif" width=3></TD>
                                                              </TR>
                                                            </TABLE>
                                                          </DIV></TD>
                                                      <TD width=20>&nbsp;</TD>
                                                      <TD><DIV id="view2_on2">
                                                          <TABLE cellSpacing=0 cellPadding=0 border=0>
                                                            <TR>
                                                              <TD width=5 background=images/tab_01.gif height=30>&nbsp;</TD>
                                                              <TD class=tab_tit onClick="javascript:doSearch2('view2');" style="cursor:pointer" background=images/tab_02.gif><FONT style="cursor:pointer">수신[원본테이터]</FONT></TD>
                                                              <TD width=5 background=images/tab_03.gif>&nbsp;</TD>
                                                            </TR>
                                                          </TABLE>
                                                      </DIV>
                                                          <DIV id="view2_off2">
                                                            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                                                              <TR>
                                                                <TD width=3 background="images/btn_bg_02_01.jpg"><IMG height=30 src="images/tab01_01.gif" width=4></TD>
                                                                <TD class="tab_tit02"  vAlign="center" background="images/tab01_02.gif" style="cursor:pointer" onclick="javascript:doSearch2('view2');">수신[원본테이터]</TD>
                                                                <TD valign="bottom" background="images/btn_bg_02_02.jpg"><IMG height=30 src="images/tab03_03.gif" width=3></TD>
                                                              </TR>
                                                            </TABLE>
                                                          </DIV></TD>
                                                    </TR>
                                                </TABLE></TD>
                                              </TR>
                                          </TABLE></TD>
                                        <TD width=4><IMG height=31 src="images/tabbg_01_03.gif" width=4></TD>
                                      </TR>
                                      <TR>
                                        <TD width=3 background="images/tabbg_02_01.gif" bgColor=#456788></TD>
                                        <TD vAlign=top width="100%" >
                                             <div id="outDiv0" style="DISPLAY:none">
                                             	<div id="apDiv2" style=" height:155px; padding-right: 18px" class="apDiv1">
                                            		<table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc" style="table-layout: fixed;">
		          										<c:set var="list" value="${executeDto.outputDto}" />
		          										<c:set var="curRptCnt" value="" />
		          										<c:set var="fleldIndex" value="0"/>
		                                                <c:forEach var="list2" items="${list.headerList}" varStatus="status">
															<c:choose>
																<c:when test='${(fleldIndex%2) == "0"}'>
																	<c:set var="startHtml" value="<tr>" />
																	<c:set var="endHtml" value="" />
																</c:when>
																<c:when test='${(fleldIndex%2) == "1"}'>
																	<c:set var="startHtml" value="" />
																	<c:set var="endHtml" value="</tr>" />
																</c:when>
															</c:choose>
															<c:set var="tsdataFldName" value="${list2.tsdataFldName}" />
															<c:set var="tscsFldDesc" value="${list2.tscsFldDesc}" />
															<c:set var="tsdataFldData" value="${list2.tsdataFldData}" />
															<c:set var="tscsFldDiv" value="${list2.tscsFldDiv}" />
															<c:set var="rptName" value="${list2.rptName}" />
															<c:set var="rptCnt" value="${list2.rptCnt}" />
															<c:set var="tscsFldType" value="${list2.tscsFldType}" />
															<c:choose>
																<c:when test='${empty rptName}'>
																	${startHtml}
													    		      <c:choose>
													      		      <c:when test='${(tscsFldType) == "hex"}'>
													      		          <td width="25%" style="word-break:break-all" class="tm_left_slim">${tsdataFldName}(${tscsFldDesc})</td>
													      		          <td width="25%" style="word-break:break-all" class="tm_text_slim">
													      		          	<pre class="tm_text_slim" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all">0x${tsdataFldData}</pre>
													      		          </td>
													      		      </c:when>
													      		      <c:otherwise>
													      		     	  <td width="25%" style="word-break:break-all" class="tm_left_slim">${tsdataFldName}(${tscsFldDesc})</td>
													      		          <td width="25%" style="word-break:break-all" class="tm_text_slim">
													      		          	<pre class="tm_text_slim" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all">${tsdataFldData}</pre>
													      		          </td>
													      		      </c:otherwise>
													    		      </c:choose>
																    ${endHtml}
																    <c:set var="curRptCnt" value="" />
																    <c:set var="fleldIndex" value="${fleldIndex+1}"/>
																 </c:when> 
																 <c:otherwise>
													 				<c:choose>
											      		      			<c:when test='${curRptCnt != rptCnt}'>
											      		      				<c:if test='${(fleldIndex%2) == "1"}'>
											      		      					<td width="50%" style="word-break:break-all" class="tm_text_slim" colspan="2"></td>
													      		          	${endHtml}
											      		      				</c:if>
											      		      				<tr>
											      		      					<c:set var="curRptCnt" value="${rptCnt}" />
													 							<td colspan="4" class="tm_center_slim">반복${rptCnt}</td>
													 						</tr>
													 					</c:when>
													 				</c:choose>
															 		<tr>
																 		<c:choose>
															      		    <c:when test='${(tscsFldType) == "hex"}'>
																      		    <td width="25%" style="word-break:break-all" class="tm_left_slim">${tsdataFldName}(${tscsFldDesc})</td>
																      		    <td width="25%" style="word-break:break-all" class="tm_text_slim" colspan="3">
																      		    	<pre class="tm_text_slim" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all">0x${tsdataFldData}</pre>
																      		    </td>
															      		    </c:when>
															      		    <c:otherwise>
																      		    <td width="25%" style="word-break:break-all"  class="tm_left_slim">${tsdataFldName}(${tscsFldDesc})</td>
																      		    <td width="25%" style="word-break:break-all" class="tm_text_slim" colspan="3">
																      		    	<pre class="tm_text_slim" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all">${tsdataFldData}</pre>
																      		    </td>
															      		    </c:otherwise>
														    		    </c:choose>
													      		 	</tr>
													      		 	<c:set var="fleldIndex" value="0"/>
																 </c:otherwise> 
															</c:choose>	 
															</c:forEach>
														</table>
													</div>
												</div>
												<div id="outDiv1" style="DISPLAY:none">
													<div id="apDiv2" style=" height:155px; padding-right: 18px" class="apDiv1">
                                            			<table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc" style="table-layout: fixed;">
															<c:set var="list" value="${executeDto.outputDto}" />
															<c:set var="curRptCnt" value="" />
															<c:set var="fleldIndex" value="0"/>
															<c:forEach var="list2" items="${list.inviList}" varStatus="status">
																<c:choose>
																	<c:when test='${(fleldIndex%2) == "0"}'>
																		<c:set var="startHtml" value="<tr>" />
																		<c:set var="endHtml" value="" />
																	</c:when>
																	<c:when test='${(fleldIndex%2) == "1"}'>
																		<c:set var="startHtml" value="" />
																		<c:set var="endHtml" value="</tr>" />
																	</c:when>
																</c:choose>
																<c:set var="tsdataFldName" value="${list2.tsdataFldName}" />
																<c:set var="tscsFldDesc" value="${list2.tscsFldDesc}" />
																<c:set var="tsdataFldData" value="${list2.tsdataFldData}" />
																<c:set var="tscsFldDiv" value="${list2.tscsFldDiv}" />
																<c:set var="rptName" value="${list2.rptName}" />
																<c:set var="rptCnt" value="${list2.rptCnt}" />
																<c:set var="tscsFldType" value="${list2.tscsFldType}" />
															<c:choose>
																<c:when test='${empty rptName}'>
																	 ${startHtml}
														    		      <c:choose>
														      		      <c:when test='${(tscsFldType) == "hex"}'>
														      		       <td width="25%" style="word-break:break-all" class="tm_left_slim">${tsdataFldName}(${tscsFldDesc})</td>
														      		          <td width="25%" style="word-break:break-all" class="tm_text_slim">
														      		          	<pre class="tm_text_slim" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all">0x${tsdataFldData}</pre>
														      		          </td>
														      		      </c:when>
														      		      <c:otherwise>
														      		     	 <td width="25%" style="word-break:break-all"  class="tm_left_slim">${tsdataFldName}(${tscsFldDesc})</td>
														      		          <td width="25%" style="word-break:break-all" class="tm_text_slim">
														      		          	<pre class="tm_text_slim" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all">${tsdataFldData}</pre>
														      		          </td>
														      		      </c:otherwise>
														    		      </c:choose>
																      ${endHtml}
																      <c:set var="curRptCnt" value="" />
																      <c:set var="fleldIndex" value="${fleldIndex+1}"/>
																 </c:when> 
																 <c:otherwise>
													 				<c:choose>
											      		      			<c:when test='${curRptCnt != rptCnt}'>
											      		      				<c:if test='${(fleldIndex%2) == "1"}'>
											      		      					<td width="50%" style="word-break:break-all" class="tm_text_slim" colspan="2"></td>
													      		          	${endHtml}
											      		      				</c:if>
											      		      				<tr>
											      		      					<c:set var="curRptCnt" value="${rptCnt}" />
													 							<td colspan="4" class="tm_center_slim">반복${rptCnt}</td>
													 						</tr>
													 					</c:when>
													 				</c:choose>
															 		<tr>
															 			<c:choose>
															      		    <c:when test='${(tscsFldType) == "hex"}'>
																      		    <td width="25%" style="word-break:break-all" class="tm_left_slim">${tsdataFldName}(${tscsFldDesc})</td>
																      		    <td width="25%" style="word-break:break-all" class="tm_text_slim" colspan="3">
																      		    	<pre class="tm_text_slim" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all">0x${tsdataFldData}</pre>
																      		    </td>
															      		    </c:when>
															      		    <c:otherwise>
																      		    <td width="25%" style="word-break:break-all"  class="tm_left_slim">${tsdataFldName}(${tscsFldDesc})</td>
																      		    <td width="25%" style="word-break:break-all" class="tm_text_slim" colspan="3">
																      		    	<pre class="tm_text_slim" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all">${tsdataFldData}</pre>
																      		    </td>
															      		    </c:otherwise>
														    		    </c:choose>
													      		 	</tr>
													      		 	<c:set var="fleldIndex" value="0"/>
																 </c:otherwise>   
															</c:choose> 
														</c:forEach>
														</table>
													</div>
												</div>
												<div id="outDiv2" style="DISPLAY:none">
													<div id="apDiv2" style=" height:155px; padding-right: 18px" class="apDiv1">
                                            			<table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc" style="table-layout: fixed;">
															<tr>
																<td class="tm_text_slim">
																	<pre class="tm_text_slim" style="margin-bottom:-1px; word-wrap:break-word; white-space:pre-wrap; word-break:break-all">${outputHexFlet}</pre>
																</td>
															</tr>
														</table>
													</div>
												</div>
											</TD>
                                        <TD width=3 height="100%" background="images/tabbg_02_03.gif" bgColor=#456788></TD>
                                      </TR>
                                      <TR>
                                        <TD width=4 height=4><IMG height=4 src="images/tabbg_03_01.gif" width=4></TD>
                                        <TD background=images/tabbg_03_02.gif><IMG height=4 src="images/tabbg_03_02.gif" width=3></TD>
                                        <TD width=4 height=4><IMG height=4 src="images/tabbg_03_03.gif" width=4></TD>
                                      </TR>
                                    </TABLE>
                                    <table width="100%" border="0" cellspacing="0" cellpadding="1">
                                            <tr>
                                                <td height="5" colspan="2"></td>
                                            </tr>
                                            <tr>
                                                <td width="100" height="10">
                                   				 <table border="0" cellpadding="0" cellspacing="0">
                                                      <tr>
                                                        <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                                        <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="javascript:back();"> 뒤 로</td>
                                                        <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                                      </tr>
                                                  </table>                                                    </td>
                                              <td align="center"><span class="input_result">[테스트케이스로 활용 시 해당 전문의 기본 테스트데이터로 저장됩니다 .]</span></td>
                                              <td align="right"><table border="0" cellpadding="0" cellspacing="0">
                                                <tr>
                                                  <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                                  <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="javascript:excuteSave();">테스트케이스로 활용</td>
                                                  <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                                </tr>
                                              </table>
                                              </td>
                                            </tr>
                                      </table>
                                    </td>
                                    </tr>
                                    </table>
                                    </form>
                                    </div>
                                  </td>
                                </tr>
                            </table>
	            </div>
	        </div>
	    </div>
</body>
</html>
