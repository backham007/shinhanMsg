<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  	
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
	<script type="text/javascript" src="js/msg/pretst/pretst.js" charset="UTF-8"></script>
	<script type="text/javascript">
	$(document).ready(function(){

		var frm = document.frmName;
		var repeat_cookie = $.parseJSON(frm.rptMap.value);
		if(repeat_cookie != null){
			rptMap = repeat_cookie;
		}
		
		inputTranName();
		if($("#value").val() == ""){    //데이터가 없을시 버튼 처리
			$("#execstart").hide(0);     //테스트실행버튼
			$("#inputhelp_1").hide(0);     //입력도우미버튼
			$("#inputhelp_2").show(0);     //입력도우미버튼
		}else{
			$("#execstart").show(0);
			$("#inputhelp_1").show(0);
			$("#inputhelp_2").hide(0);
		}
			});

	$(window).load(function () {
		if($("#value").val() == ""){
			alert("조회 내역이 없습니다.");
		}
	});
	</script>
	</head>
 
 	<c:set var="tranName" value="${layout.tranName}" />
	<c:set var="chnlDstcd" value="${layout.chnlDstcd}" />
	<c:set var="fldDiv" value="${layout.fldDiv}" />
	<c:set var="tranCd" value="${layout.tranCd}" />
	<c:set var="value" value="${result}" />
	
	
	<body bgcolor="#FFFFFF" background="images/left_menu_bg.jpg" rightmargin="0" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="MM_preloadImages('images/top_menu_01_02.jpg','images/top_menu_02_02.jpg','images/top_menu_03_02.jpg','images/top_menu_04_02.jpg','images/top_menu_05_02.jpg','images/top_menu_06_02.jpg','images/top_menu_07_02.jpg')">
	<input id="connSevrDstcd" type="hidden" value="${sessionScope.userinfo.connsevrdstcd}"/>
	<input id="searchTranCd" type="hidden" value="${tranCd}">
	
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
                        
                        
				        	<form name="frmName" method="post">
				        	<div id="rept_hid"></div>
							<input name="chnlDstcd" id="chnlDstcd" type="hidden" value="${chnlDstcd}"/>
							<input name="fldDiv" id="fldDiv" type="hidden" value="${fldDiv}"/>
							<input name="rptMap" id="rptMap" type="hidden" />
							<input name="value" id="value" type="hidden" value="${value}"/>
							
                            <table width="100%" height="100%" border="0" cellpadding="15" cellspacing="0">
                                <tr> 
                                    <td valign="top">
                                    
                                        <table border=0 cellpadding=0 cellspacing=0 width=100%>
                                            <tr> 
                                                <td width="20"><img src="images/title_bullet1.gif"></td>
                                                <td width="90" class="sub_tit">거래테스트</td>
                                                <td valign="bottom" class="point_text" id="flowMsg" >테스트실행버튼을 클릭하여 테스트를 실행하십시오.</td>
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
                                                                      <td width="200"><input name="tranCd" id="tranCd" type="text" class="input_topinq" style="width:160px;ime-mode:disabled;" value="${tranCd}" onKeyDown="if(event.keyCode ==13){javascript:getDataList();}">
                                                                        <img src="images/btn_pop.gif" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer" onClick="getLayoutOpen();"></td>
                                                                        <td width="55" class="box_txt">거래명 :</td>
                                                                      <td><input name="tranName" id="tranName" type="text" class="input_topinq" style="width:100%" value="${tranName}" readonly="readonly"></td>
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
                                                <td height="5">&nbsp;</td>
                                            </tr>
                                        </table> 
                                        <div id="invislen">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
										         	<tr id="inputhelp_2">
										         		<td class="sub_tit02">헤더부 </td>
										         	</tr>
										         	<tr id="inputhelp_1">
										             	<td class="sub_tit02">헤더부 </td>
										             		<c:if test="${!empty layout.headerList}">
						          							<!-- <td align="right" width="15" height="21" background="images/btn_img_01.gif">&nbsp;</td>
						          							<td background="images/btn_img_02.gif" align="center" width="70" class="btn_text" style="cursor:pointer" onclick="javascript:getHeaderTemplate();">헤더유형입력</td>
						          							<td width="10" background="images/btn_img_03.gif" align="right">&nbsp;</td> -->
						          							<td align="right" width="15" height="21" background="images/btn_img_01.gif">&nbsp;</td>
						          							<td background="images/btn_img_02.gif" align="center" width="120" class="btn_text" style="cursor:pointer" onclick="javascript:createAutoData('header');">입력도우미(헤더+개별)</td>
						          							<td width="10" background="images/btn_img_03.gif" align="right">&nbsp;</td>
						          							<td align="right" width="15" height="21" background="images/btn_img_01.gif">&nbsp;</td>
	                                                        <td background="images/btn_img_02.gif" align="center" width="100" class="btn_text" style="cursor:pointer" onclick="javascript:createAutoData('invi');">입력도우미(개별)</td>
	                                                        <td width="10" background="images/btn_img_03.gif" align="right">&nbsp;</td>
						          							</c:if>
													</tr>
										         	<tr>
										             <td height="1" colspan="2"></td>
										         	</tr>
										        
										     </table>
										  
											<table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
											  <tr>
											     <td valign="top" bgcolor="#FFFFFF">
											         <div id="divHeader" style="height:200px; padding-right: 18px" class="apDiv1">
														<table width="100%" border="0" cellpadding="0" cellspacing="0">
																<c:set var="fleldIndex" value="0"/>
																	<c:forEach var="list" items="${layout.headerList}" varStatus="status">
																		<c:choose>
																			<c:when test='${(fleldIndex%2) == "0"}'>
																				<c:set var="startHtml" value="<tr>" />
																				<c:set var="endHtml" value="" />
																			</c:when>
																			<c:when test='${(fleldIndex%2)== "1"}'>
																				<c:set var="startHtml" value="" />
																				<c:set var="endHtml" value="</tr>" />
																			</c:when>
																		</c:choose>
																		<c:set var="fldName" value="${list.fldName}" />
																		<c:set var="tscsFldSize" value="${list.tscsFldSize}" />
																		<c:set var="fldType" value="${list.fldType}" />
																		<c:set var="tscsFldDesc" value="${list.tscsFldDesc}" /> 
																		<c:set var="fldData" value="${list.fldData}" />
																		<c:set var="rptName" value="${list.rptName}" />
																		<c:set var="fldAttrib" value="${list.fldAttrib}" />
																		<c:set var="reqYn" value="${list.reqYn}" />
																		<c:set var="editYn" value="${list.editYn}" />
																		<c:set var="rmark" value="${list.rmark}" />
																		<c:choose>
																			<c:when test='${(fldType) == "hex"}'>	
																				<c:choose>
																					<c:when test='${(fldAttrib) == "03"}'>
																						${startHtml}
																						<td width="50%"><table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc" style="table-layout: fixed;">
																						<tr>
																							<td width="310" style="word-break:break-all" class="tm_left_slim">${fldName} (${tscsFldSize}) [${fldType}] /${tscsFldDesc}</td>
																							<td class="tm_text_slim">
																								<table width="100%" border="0" cellpadding="0" cellspacing="0">
														                                            <tr>
														                                              <td><input name="fldData1" type="text" id="rptid_${status.count}_N_${fldName}" class="input_topinq" style="width:95%" maxlength="${tscsFldSize * '2'}" value="${fillData}" slen="${tscsFldSize}" readonly></td>
														                                              <td width="80"><table  border="0" cellpadding="0" cellspacing="0">
														                                                  <tr>
														                                                    <td width="6" height="20" background="images/btn_intable_01.jpg"></td>
														                                                    <td background="images/btn_intable_02.jpg" class="btn_intable" onclick="javascript:rptInput('01','${fldName}',${status.count});" style="cursor:pointer;">반복부 입력</td> 
														                                                    <td width="4" background="images/btn_intable_03.jpg">&nbsp;</td>
														                                                  </tr>
														                                              </table>
														                                              </td>
														                                            </tr>
														                                        </table>
														                                    </td>
													                                    	<c:set var="fleldIndex" value="${fleldIndex+1}"/>
													                                    </tr>
													                                    </table></td>
																	    				${endHtml}
																				   	</c:when>
																					<c:otherwise>
																						<c:choose>
																							<c:when test='${empty rptName}'>
																								${startHtml}
																								<td width="50%"><table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc" style="table-layout: fixed;">
																								<tr>
																									<td width="310" style="word-break:break-all" class="tm_left_slim">${fldName} (${tscsFldSize}) [${fldType}] /${tscsFldDesc}</td>
																									<td class="tm_text_slim"><input id="${fldName}" name="fldData1" type="text" class="input_topinq" style="width:98%;ime-mode:inactive;" maxlength="${tscsFldSize * '2'}" value="${fldData}" slen="${tscsFldSize}"/></td>
																									<c:set var="fleldIndex" value="${fleldIndex+1}"/>
																								</tr>
																								</table></td>
																	    						${endHtml}
																							</c:when>
																						</c:choose>
																					</c:otherwise>
																				</c:choose>
																		
																			</c:when>
																			<c:otherwise>
																					<c:choose>
																						<c:when test='${(fldAttrib) == "03"}'>
																							${startHtml}
																							<td width="50%"><table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc" style="table-layout: fixed;">
																							<tr>
																								<td width="310" style="word-break:break-all" class="tm_left_slim"><a title='${rmark}' style="text-decoration: none;" class="tm_left_slim">${fldName} (${tscsFldSize}) [${fldType}] /${tscsFldDesc}</a></td>
																								<td class="tm_text_slim">
																								<table width="100%" border="0" cellpadding="0" cellspacing="0">
														                                            <tr>
														                                              <td><input name="fldData1" type="text" id="rptid_${status.count}_N_${fldName}" class="input_topinq" style="width:95%;<c:if test="${editYn == 'N'}">background-color: threedlightshadow;</c:if>" maxlength="${tscsFldSize}" value="${fillData}" slen="${tscsFldSize}" readonly></td>
														                                              <td width="80">
														                                              <c:if test="${editYn == 'Y'}">
														                                              	<table  border="0" cellpadding="0" cellspacing="0">
														                                                  <tr>
														                                                    <td width="6" height="20" background="images/btn_intable_01.jpg"></td>
														                                                    <td background="images/btn_intable_02.jpg" class="btn_intable" onclick="javascript:rptInput('01','${fldName}',${status.count});" style="cursor:pointer;">반복부 입력</td>
														                                                    <td width="4" background="images/btn_intable_03.jpg">&nbsp;</td>
														                                                  </tr>
														                                              </table>
														                                              </c:if>
														                                              </td>
														                                            </tr>
														                                        </table>
														                                    	</td>
													                                    		<c:set var="fleldIndex" value="${fleldIndex+1}"/>
													                                    	</tr>
													                                    	</table></td>
																	    					${endHtml}
																					   	</c:when>
																						<c:otherwise>
																						<c:choose>
																							<c:when test='${empty rptName}'>
																								${startHtml}
																								<td width="50%"><table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc" style="table-layout: fixed;">
																								<tr>
																									<td width="310" style="word-break:break-all" class="tm_left_slim"><a title='${rmark}' style="text-decoration: none;" class="tm_left_slim">${fldName} (${tscsFldSize}) [${fldType}] /${tscsFldDesc}<c:if test="${reqYn == 'Y'}">＊</c:if></a></td>
																									<td class="tm_text_slim"><input id="${fldName}" name="fldData1" type="text" class="input_topinq" style="width:98%;ime-mode:inactive;<c:if test="${editYn == 'N'}">background-color: threedlightshadow;</c:if>" maxlength="${tscsFldSize}" value="${fldData}" slen="${tscsFldSize}" <c:if test="${editYn == 'N'}">readonly</c:if>/></td>
																									<c:set var="fleldIndex" value="${fleldIndex+1}"/>
																								</tr>
																								</table></td>
																	    						${endHtml}
																							</c:when>
																							<c:otherwise>
																							<input name="fldData3" type="hidden" class="input_topinq" style="width:98%;ime-mode:inactive;" maxlength="${tscsFldSize}" slen="${tscsFldSize}" rptName="${rptName}" fldName="${fldName}"/>
																							</c:otherwise>
																						</c:choose>
																						</c:otherwise>
																					</c:choose>
																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
																</table>
											       	 	</div>
											    	</td>
											  	</tr>
											</table>
											 <table width="100%" border="0" cellspacing="0" cellpadding="1">
	                                           <tr> 
	                                           	   <td height="5" align="left">※ 필드명에 마우스 포인터를 이동하면 필드가이드 툴팁이 표시됩니다</td>
	                                               <td height="5" align="right">(＊) : 필수필드&nbsp;</td>
	                                        	</tr>
                                        	</table> 
											
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
											  	<tr>
											    	<td class="sub_tit02"> 개별부</td>
											  	</tr>
											  	<tr>
											    	<td height="1" colspan="2"></td>
											  	</tr>
											</table>
											<table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
											  <tr>
											     <td valign="top" bgcolor="#FFFFFF">
											         <div id="divInvi" style="height:200px; padding-right: 18px" class="apDiv1">
											         <table width="100%" border="0" cellpadding="0" cellspacing="0">
											         	<c:set var="fleldIndex" value="0"/>
														<c:forEach var="list" items="${layout.inviList}" varStatus="status">
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
																	<c:set var="fldName" value="${list.fldName}" />
																	<c:set var="tscsFldSize" value="${list.tscsFldSize}" />
																	<c:set var="fldType" value="${list.fldType}" />
																	<c:set var="tscsFldDesc" value="${list.tscsFldDesc}" />
																	<c:set var="fldData" value="${list.fldData}" />
																	<c:set var="fldAttrib" value="${list.fldAttrib}" />
																	<c:set var="rptName" value="${list.rptName}" />
																	<c:set var="fillData" value="${list.fillData}" />
																	<c:set var="fldDiv" value="${list.fldDiv}" />
																<c:choose>
																	<c:when test='${(fldType) == "hex"}'>	
																		<c:choose>
																			<c:when test='${(fldAttrib) == "03"}'>
																				${startHtml}
																				<td width="50%"><table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc" style="table-layout: fixed;">
																				<tr>
																					<td width="310" class="tm_left_slim">${fldName} (${tscsFldSize}) [${fldType}] /${tscsFldDesc}</td>
																					<td class="tm_text_slim">
																						<table width="100%" border="0" cellpadding="0" cellspacing="0">
												                                            <tr>
												                                              <td><INPUT name="fldData2" id="rptid_${status.count}_N_${fldName}" type="text" class="input_topinq" style="width:95%" maxlength="${tscsFldSize * '2'}" value="${fillData}" slen="${tscsFldSize * '2'}" readonly ></td>
												                                              <td width="80"><table  border="0" cellpadding="0" cellspacing="0">
												                                                  <tr>
												                                                    <td width="6" height="20" background="images/btn_intable_01.jpg"></td>
												                                                    <td background="images/btn_intable_02.jpg" class="btn_intable" onclick="javascript:rptInput('02','${fldName}',${status.count});" style="cursor:pointer;">반복부 입력</td>
												                                                    <td width="4" background="images/btn_intable_03.jpg">&nbsp;</td>
												                                                  </tr>
												                                              </table>
												                                              </td>
												                                            </tr>
												                                        </table>
												                                    </td>
												                                    <c:set var="fleldIndex" value="${fleldIndex+1}"/>
											                                    </tr>
											                                    </table></td>
															    				${endHtml}
																		   	</c:when>
																			<c:otherwise>
																				<c:choose>
																					<c:when test='${empty rptName}'>
																						${startHtml}
																						<td width="50%"><table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc" style="table-layout: fixed;">
																						<tr>
																							<td width="310" class="tm_left_slim">${fldName} (${tscsFldSize}) [${fldType}] /${tscsFldDesc}</td>
																							<td class="tm_text_slim"><input id="${fldName}" name="fldData2" type="text" class="input_topinq" style="width:98%;ime-mode:inactive;" maxlength="${tscsFldSize * '2'}" value="${fldData}" slen="${tscsFldSize * '2'}"/></td>
																							<c:set var="fleldIndex" value="${fleldIndex+1}"/>
																						</tr>
													                                    </table></td>
																	    				${endHtml}
																					</c:when>
																				</c:choose>
																			</c:otherwise>
																		</c:choose>
																
																	</c:when>
																	<c:otherwise>
																			<c:choose>
																				<c:when test='${(fldAttrib) == "03"}'>
																					${startHtml}
																					<td width="50%"><table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc" style="table-layout: fixed;">
																					<tr>
																						<td width="310" class="tm_left_slim"><a title='${fldName} (${tscsFldSize}) [${fldType}] /${tscsFldDesc}' style="text-decoration: none;" class="tm_left_slim">${fldName} (${tscsFldSize}) [${fldType}] /${tscsFldDesc}</a></td>
																						<td class="tm_text_slim">
																						<table width="100%" border="0" cellpadding="0" cellspacing="0">
												                                            <tr>
												                                            
												                                              <td><input name="fldData2" id="rptid_${status.count}_N_${fldName}" type="text" class="input_topinq" style="width:95%" maxlength="${tscsFldSize}" value="${fillData}" slen="${tscsFldSize}" readonly ></td>
												                                              <td width="80"><table  border="0" cellpadding="0" cellspacing="0">
												                                                  <tr>
												                                                    <td width="6" height="20" background="images/btn_intable_01.jpg"></td>
												                                                    <td background="images/btn_intable_02.jpg" class="btn_intable" id="${status.count}" onclick="javascript:rptInput('02','${fldName}',${status.count});"  style="cursor:pointer;">반복부 입력</td>
												                                                    <td width="4" background="images/btn_intable_03.jpg">&nbsp;</td>
												                                                  </tr>
												                                              </table></td>
												                                            </tr>
												                                        </table>
												                                    	</td>
												                                    	<c:set var="fleldIndex" value="${fleldIndex+1}"/>
												                                    </tr>
												                                    </table></td>
																    				${endHtml}
																			   	</c:when>
																				<c:otherwise>
																					<c:choose>
																						<c:when test='${empty rptName}'>
																							${startHtml}
																							<td width="50%"><table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc" style="table-layout: fixed;">
																							<tr>
																								<td width="310" class="tm_left_slim"><a title='${fldName} (${tscsFldSize}) [${fldType}] /${tscsFldDesc}' style="text-decoration: none;" class="tm_left_slim">${fldName} (${tscsFldSize}) [${fldType}] /${tscsFldDesc}</a></td>
																								<td class="tm_text_slim"><input id="${fldName}" name="fldData2" type="text" class="input_topinq" style="width:98%;ime-mode:inactive;" maxlength="${tscsFldSize}" value="${fldData}" slen="${tscsFldSize}"/></td>
																								<c:set var="fleldIndex" value="${fleldIndex+1}"/>
																							</tr>
														                                    </table></td>
																		    				${endHtml}
																						</c:when>
																						<c:otherwise>
																						<input name="fldData3" type="hidden" class="input_topinq" style="width:98%;ime-mode:inactive;" maxlength="${tscsFldSize}" slen="${tscsFldSize}" rptName="${rptName}" fldName="${fldName}"/>
																						</c:otherwise>
																					</c:choose>
																				</c:otherwise>
																			</c:choose>
																	</c:otherwise>
																</c:choose>
															</c:forEach>
														</table>
										               </div>
										           </td>
										         </tr>
										       </table>
										       </div>
										       <table width="100%" border="0" cellspacing="0" cellpadding="1">
										         <tr>
										             <td height="5" colspan="2"></td>
										         </tr>
										         <tr>
										             <td width="100" height="10">
										               <table border="0" cellpadding="0" cellspacing="0">
										                   <tr id="execstart">
										                     <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
										                     <td background="images/btn_img_02.gif"  class="btn_text" style="cursor:pointer" onclick="javascript:getExecuteTest();"> 테스트 실행</td>
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
                        </td>
                    </tr>
                </table>
            	
            </div>
        </div>
    </div>
 
</body>
</html>