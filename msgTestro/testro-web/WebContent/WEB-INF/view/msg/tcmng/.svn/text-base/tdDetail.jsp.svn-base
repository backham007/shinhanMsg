<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<script type="text/javascript" src="js/cmn/utils/json2.js" charset="utf-8"></script>

<div id="dataDetailDiv">
<table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc" style="table-layout: fixed;">
	<c:set var="curRptCnt" value="" />
	<c:set var="fleldIndex" value="0"/>
	<c:forEach var="list1" items="${dataDetailDto.headerList}" varStatus="status">
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
		<c:set var="tsdataFldName" value="${list1.tsdataFldName}" />
		<c:set var="tsdataFldData" value="${list1.tsdataFldData}" />
		<c:set var="rptName" value="${list1.rptName}" />
		<c:set var="rptCnt" value="${list1.rptCnt}" />
		<c:set var="tscsFldType" value="${list1.tscsFldType}" />
		<c:choose>
			<c:when test='${empty rptName}'>
				 ${startHtml}
		   		      <c:choose>
		     		      <c:when test='${(tscsFldType) == "hex"}'>
			     		      <td width="30%" style="word-break:break-all"  class="tm_left_slim">${tsdataFldName}</td>
			     		      <td width="20%" style="word-break:break-all"  class="tm_text_slim">
			     		      	0x${tsdataFldData}
			     		      </td>
		     		      </c:when>
		     		      <c:otherwise>
							  <td width="30%" style="word-break:break-all"  class="tm_left_slim">${tsdataFldName}</td>
			     		      <td width="20%" style="word-break:break-all"  class="tm_text_slim">
			     		      	${tsdataFldData}
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
		  		      			<td width="50%" style="word-break:break-all"  class="tm_text_slim" colspan="2"></td>
			     		    </tr>
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
			     		      <td width="50%" style="word-break:break-all"  class="tm_left_slim">${tsdataFldName}</td>
			     		      <td width="50%" style="word-break:break-all"  class="tm_text_slim" colspan="3">
			     		      	0x${tsdataFldData}
			     		      </td>
		     		      </c:when>
		     		      <c:otherwise>
							  <td width="50%" style="word-break:break-all"  class="tm_left_slim">${tsdataFldName}</td>
			     		      <td width="50%" style="word-break:break-all"  class="tm_text_slim" colspan="3">
			     		      	${tsdataFldData}
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

<div id="inviDataDiv">
<table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc" style="table-layout: fixed;">
	<c:set var="curRptCnt" value="" />
	<c:set var="fleldIndex" value="0"/>
	<c:forEach var="list2" items="${dataDetailDto.inviList}" varStatus="status">
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
		<c:set var="tsdataFldData" value="${list2.tsdataFldData}" />
		<c:set var="rptName" value="${list2.rptName}" />
		<c:set var="rptCnt" value="${list2.rptCnt}" />
		<c:set var="tscsFldType" value="${list2.tscsFldType}" />
		<c:choose>
			<c:when test='${empty rptName}'>
				 ${startHtml}
		   		      <c:choose>
		     		      <c:when test='${(tscsFldType) == "hex"}'>
			     		      <td width="30%" style="word-break:break-all"  class="tm_left_slim">${tsdataFldName}</td>
			     		      <td width="20%" style="word-break:break-all"  class="tm_text_slim">
			     		      	0x${tsdataFldData}
			     		      </td>
		     		      </c:when>
		     		      <c:otherwise>
							  <td width="30%" style="word-break:break-all"  class="tm_left_slim">${tsdataFldName}</td>
			     		      <td width="20%" style="word-break:break-all"  class="tm_text_slim">
			     		      	${tsdataFldData}
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
			     		        <td width="50%" style="word-break:break-all"  class="tm_text_slim" colspan="2"></td>
			     		    </tr>
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
			     		      <td width="50%" style="word-break:break-all"  class="tm_left_slim">${tsdataFldName}</td>
			     		      <td width="50%" style="word-break:break-all"  class="tm_text_slim" colspan="3">
			     		      	0x${tsdataFldData}
			     		      </td>
		     		      </c:when>
		     		      <c:otherwise>
							  <td width="50%" style="word-break:break-all"  class="tm_left_slim">${tsdataFldName}</td>
			     		      <td width="50%" style="word-break:break-all"  class="tm_text_slim" colspan="3">
			     		      	${tsdataFldData}
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