<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<input type="hidden" id="fldDivData" name="fldDivData" value="${layout.fldDiv}"/>
<div id="headerDataDiv" style="DISPLAY:none">
<table width="925" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc">
	<tr>
      <td class="tm_left" colspan="4">
      	<table width="100%" border="0" cellspacing="0" cellpadding="1">
      		<tr>
      			<td class="sub_tit02">입력</td>
      		</tr>
      	</table>
      </td>
    </tr>
    <c:set var="curRptName" value="" />
	<c:set var="fleldIndex" value="0"/>
	<c:set var="fleldYn" value="N"/>
	<c:forEach var="list" items="${layout.headerList}" varStatus="status">
		<c:set var="fldIO" value="${list.fldIO}" />
		<c:if test="${fldIO == 'I' || fldIO == 'B'}">
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
			<c:set var="tscsFldDesc" value="${list.tscsFldDesc}" />
			<c:set var="tscsFldSize" value="${list.tscsFldSize}" />
			<c:set var="rptName" value="${list.rptName}" />
			<c:choose>
				<c:when test='${empty rptName}'>
					${startHtml}
					<td width="25%" style="word-break:break-all"  class="tm_left_slim">${fldName}(${tscsFldSize}) / ${tscsFldDesc}</td>
				    <td width="25%" style="word-break:break-all"  class="tm_text_slim">&nbsp;</td>
				    ${endHtml}
				    <c:set var="curRptName" value="" />
				    <c:set var="fleldIndex" value="${fleldIndex+1}"/>
				</c:when> 
				<c:otherwise>
					<c:choose>
		  		      	<c:when test='${curRptName != rptName}'>
		  		      		<c:if test='${(fleldIndex%2) == "1"}'>
			     		        <td width="50%" style="word-break:break-all" class="tm_text_slim" colspan="2"></td>
			     		    </tr>
		  		      		</c:if>
		  		      		<tr>
		  		      			<c:set var="curRptName" value="${rptName}" />
								<td colspan="4" class="tm_center_slim">반복부</td>
							</tr>
						</c:when>
					</c:choose>
			 		<tr>
						<td width="25%" style="word-break:break-all"  class="tm_left_slim">${fldName}(${tscsFldSize}) / ${tscsFldDesc}</td>
				     	<td width="25%" style="word-break:break-all"  class="tm_text_slim" colspan="3">&nbsp;</td>
			    	</tr>
			    	<c:set var="fleldIndex" value="0"/>
				 </c:otherwise>   
			</c:choose>
			<c:set var="fleldYn" value="Y"/>
		</c:if>
	</c:forEach>
	<c:if test="${fleldYn == 'N'}">
		<tr>
			<td colspan="4" class="tr_text_center">필드가 존재하지 않습니다</td>
		</tr>
	</c:if>
</table>
<br/>
<table width="925" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc">
	<tr>
      <td class="tm_left" colspan="4">
      	<table width="100%" border="0" cellspacing="0" cellpadding="1">
      		<tr>
      			<td class="sub_tit02">출력</td>
      		</tr>
      	</table>
      </td>
    </tr>
    <c:set var="curRptName" value="" />
	<c:set var="fleldIndex" value="0"/>
	<c:set var="fleldYn" value="N"/>
	<c:forEach var="list" items="${layout.headerList}" varStatus="status">
		<c:set var="fldIO" value="${list.fldIO}" />
		<c:if test="${fldIO == 'O' || fldIO == 'B'}">
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
			<c:set var="tscsFldDesc" value="${list.tscsFldDesc}" />
			<c:set var="tscsFldSize" value="${list.tscsFldSize}" />
			<c:set var="rptName" value="${list.rptName}" />
			<c:choose>
				<c:when test='${empty rptName}'>
					${startHtml}
					<td width="25%" style="word-break:break-all"  class="tm_left_slim">${fldName}(${tscsFldSize}) / ${tscsFldDesc}</td>
				    <td width="25%" style="word-break:break-all"  class="tm_text_slim">&nbsp;</td>
				    ${endHtml}
				    <c:set var="curRptName" value="" />
				    <c:set var="fleldIndex" value="${fleldIndex+1}"/>
				</c:when> 
				<c:otherwise>
					<c:choose>
		  		      	<c:when test='${curRptName != rptName}'>
		  		      		<c:if test='${(fleldIndex%2) == "1"}'>
		  		      			<td width="50%" style="word-break:break-all" class="tm_text_slim" colspan="2"></td>
			     		    </tr>
		  		      		</c:if>
		  		      		<tr>
		  		      			<c:set var="curRptName" value="${rptName}" />
								<td colspan="4" class="tm_center_slim">반복부</td>
							</tr>
						</c:when>
					</c:choose>
			 		<tr>
						<td width="25%" style="word-break:break-all"  class="tm_left_slim">${fldName}(${tscsFldSize}) / ${tscsFldDesc}</td>
				     	<td width="25%" style="word-break:break-all"  class="tm_text_slim" colspan="3">&nbsp;</td>
			    	</tr>
			    	<c:set var="fleldIndex" value="0"/>
				 </c:otherwise>   
			</c:choose>
			<c:set var="fleldYn" value="Y"/>
		</c:if>
	</c:forEach>
	<c:if test="${fleldYn == 'N'}">
		<tr>
			<td colspan="4" class="tr_text_center">필드가 존재하지 않습니다</td>
		</tr>
	</c:if>
</table>
</div>


<div id="inviDataDiv" style="DISPLAY:none">
<table width="925" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc">
	<tr>
      <td class="tm_left" colspan="4">
      	<table width="100%" border="0" cellspacing="0" cellpadding="1">
      		<tr>
      			<td class="sub_tit02">입력</td>
      		</tr>
      	</table>
      </td>
    </tr>
    <c:set var="curRptName" value="" />
	<c:set var="fleldIndex" value="0"/>
	<c:set var="fleldYn" value="N"/>
	<c:forEach var="list" items="${layout.inviList}" varStatus="status">
		<c:set var="fldIO" value="${list.fldIO}" />
		<c:if test="${fldIO == 'I' || fldIO == 'B'}">
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
			<c:set var="tscsFldDesc" value="${list.tscsFldDesc}" />
			<c:set var="tscsFldSize" value="${list.tscsFldSize}" />
			<c:set var="rptName" value="${list.rptName}" />
			<c:choose>
				<c:when test='${empty rptName}'>
					${startHtml}
					<td width="25%" style="word-break:break-all"  class="tm_left_slim">${fldName}(${tscsFldSize}) / ${tscsFldDesc}</td>
				    <td width="25%" style="word-break:break-all"  class="tm_text_slim">&nbsp;</td>
				    ${endHtml}
				    <c:set var="curRptName" value="" />
				    <c:set var="fleldIndex" value="${fleldIndex+1}"/>
				</c:when> 
				<c:otherwise>
					<c:choose>
		  		      	<c:when test='${curRptName != rptName}'>
		  		      		<c:if test='${(fleldIndex%2) == "1"}'>
		  		      			<td width="50%" style="word-break:break-all" class="tm_text_slim" colspan="2"></td>
			     		    </tr>
		  		      		</c:if>
		  		      		<tr>
		  		      			<c:set var="curRptName" value="${rptName}" />
								<td colspan="4" class="tm_center_slim">반복부</td>
							</tr>
						</c:when>
					</c:choose>
			 		<tr>
						<td width="25%" style="word-break:break-all"  class="tm_left_slim">${fldName}(${tscsFldSize}) / ${tscsFldDesc}</td>
				     	<td width="25%" style="word-break:break-all"  class="tm_text_slim" colspan="3">&nbsp;</td>
			    	</tr>
			    	<c:set var="fleldIndex" value="0"/>
				 </c:otherwise>   
			</c:choose>
			<c:set var="fleldYn" value="Y"/>
		</c:if>
	</c:forEach>
	<c:if test="${fleldYn == 'N'}">
		<tr>
			<td colspan="4" class="tr_text_center">필드가 존재하지 않습니다</td>
		</tr>
	</c:if>
</table>
<br/>
<table width="925" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc">
	<tr>
      <td class="tm_left" colspan="4">
      	<table width="100%" border="0" cellspacing="0" cellpadding="1">
      		<tr>
      			<td class="sub_tit02">출력</td>
      		</tr>
      	</table>
      </td>
    </tr>
    <c:set var="curRptName" value="" />
	<c:set var="fleldIndex" value="0"/>
	<c:set var="fleldYn" value="N"/>
	<c:forEach var="list" items="${layout.inviList}" varStatus="status">
		<c:set var="fldIO" value="${list.fldIO}" />
		<c:if test="${fldIO == 'O' || fldIO == 'B'}">
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
			<c:set var="tscsFldDesc" value="${list.tscsFldDesc}" />
			<c:set var="tscsFldSize" value="${list.tscsFldSize}" />
			<c:set var="rptName" value="${list.rptName}" />
			<c:choose>
				<c:when test='${empty rptName}'>
					${startHtml}
					<td width="25%" style="word-break:break-all"  class="tm_left_slim">${fldName}(${tscsFldSize}) / ${tscsFldDesc}</td>
				    <td width="25%" style="word-break:break-all"  class="tm_text_slim">&nbsp;</td>
				    ${endHtml}
				    <c:set var="curRptName" value="" />
				    <c:set var="fleldIndex" value="${fleldIndex+1}"/>
				</c:when> 
				<c:otherwise>
					<c:choose>
		  		      	<c:when test='${curRptName != rptName}'>
		  		      		<c:if test='${(fleldIndex%2) == "1"}'>
		  		      			<td width="50%" style="word-break:break-all" class="tm_text_slim" colspan="2"></td>
			     		    </tr>
		  		      		</c:if>
		  		      		<tr>
		  		      			<c:set var="curRptName" value="${rptName}" />
								<td colspan="4" class="tm_center_slim">반복부</td>
							</tr>
						</c:when>
					</c:choose>
			 		<tr>
						<td width="25%" style="word-break:break-all"  class="tm_left_slim">${fldName}(${tscsFldSize}) / ${tscsFldDesc}</td>
				     	<td width="25%" style="word-break:break-all"  class="tm_text_slim" colspan="3">&nbsp;</td>
			    	</tr>
			    	<c:set var="fleldIndex" value="0"/>
				 </c:otherwise>   
			</c:choose>
			<c:set var="fleldYn" value="Y"/>
		</c:if>
	</c:forEach>
	<c:if test="${fleldYn == 'N'}">
		<tr>
			<td colspan="4" class="tr_text_center">필드가 존재하지 않습니다</td>
		</tr>
	</c:if>
</table>
</div>

