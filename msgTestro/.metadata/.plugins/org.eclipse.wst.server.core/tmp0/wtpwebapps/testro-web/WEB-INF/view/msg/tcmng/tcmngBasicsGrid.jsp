<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<script type="text/javascript" src="js/cmn/utils/json2.js" charset="utf-8"></script>

<c:set var="colNames" value="" />
<c:set var="colModel" value="" />
<c:set var="widthSize" value="0" />

<script type="text/javascript">
	var rptColIdx 		= 6;				//반복부 시작 위치
	var rptCol 			= new Array;		//반복부 위치 저장
</script>

<!-- 그리드 그리기 -->
<c:forEach var="list" items="${layout.detailAllList}" varStatus="status">
	<c:set var="fldName" value="${list.fldName}" />
	<c:set var="fldAttrib" value="${list.fldAttrib}" />
	<c:set var="fldType" value="${list.fldType}" />
	<c:set var="fldDesc" value="${list.tscsFldDesc}" />
	<c:set var="fldData" value="${list.fldData}" />
	<c:set var="fldSize" value="${list.tscsFldSize}" />
	<c:set var="fldDiv" value="${list.fldDiv}" />

	<c:set var="widthSize" value="${widthSize + 1}" />
	
	<c:choose>
		<c:when test='${(fldDiv) == "01"}'>
			<c:set var="fldDivNm" value="||-H" />
			<c:set var="colModelNm" value="${fldName}${fldDivNm}" />
		</c:when>
		<c:when test='${(fldDiv) == "02"}'>
			<c:set var="fldDivNm" value="||-I" />
			<c:set var="colModelNm" value="${fldName}${fldDivNm}" />
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test='${(status.first) == true}'>
			<!-- 그리드 헤더 정의 -->
			<c:set var="colNames" value="${colNames}'${fldName}(${fldSize})<br/>${fldDesc}(${fldType})'" />	
			<c:set var="colModel" value="${colModel}{name:'${colModelNm}', index:'${colModelNm}', width:120, align:'left', sortable:false,  editoptions:{style:'text-align:left'}}" />
			<!--// 그리드 헤더 정의 -->
		</c:when>
		<c:when test='${(status.first) == false}'>
			<!-- 그리드 헤더 정의 -->
			<c:set var="colNames" value="${colNames}, '${fldName}(${fldSize})<br/>${fldDesc}(${fldType})'" />	
			<c:set var="colModel" value="${colModel}, {name:'${colModelNm}', index:'${colModelNm}', width:120, align:'left', sortable:false, editoptions:{style:'text-align:left'}}" />
			<!--// 그리드 헤더 정의 -->
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test='${(fldAttrib) == "03"}'>
			<c:set var="colNames" value="${colNames}, '반복부'" />	
			<c:set var="colModel" value="${colModel}, {name: '${fldName}${fldDivNm}G',index: '${colModelNm}${fldDivNm}', hidden:true}" />
			<script type="text/javascript">
				rptCol[rptCol.length] = ${widthSize} + rptColIdx;
			</script>
			<c:set var="widthSize" value="${widthSize + 1}" />
		</c:when>
	</c:choose>
</c:forEach>
	
<script type="text/javascript">
	var colData = ${rows};
	
	//테스트케이스 목록
	var lastsel2;

	var $grid1 = $("#basicsList"),
	fixPositionsOfFrozenDivs1 = function () { 
	}; 
	
	
	jQuery("#basicsList").jqGrid({
		mtype:'POST',    // 한글 인코딩 깨지는 문제 방지하기 위해 POST로 쓴다
		datatype: "json",
	    colNames:[
	              '테스트데이터ID' , 
	              '테스트데이터명' ,
	              '테스트데이터설명' ,
	              '체크포인트' ,
	              ${colNames}
		],
	    colModel:[
					{name: 'tsdataID',index: 'TsdataID', width:188, align:"center", sortable:false, frozen:true, key:true},
					{name: 'tsdataName',index: 'TsdataName', width:130, editable:true,  align:"left", sortable:false, frozen:true},
					{name: 'tsdataDesc',index: 'TsdataDesc', width:233, editable:true, align:"left", sortable:false},
					{name: 'chkYN',index: 'ChkYN', width:80, editable:true, align:"center", hidden:true},
					${colModel}
	    ],
	    editurl		: 'clientArray',
	    viewrecords	: true,
	    loadComplete: function(xhr){
    		if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
    		$(".ui-jqgrid-sortable").css('height','auto');
		},
		onCellSelect: function(rowid, index, contents, event) {//checkbox 선택시만 row선택
			$("#basicsList").jqGrid('resetSelection'); 
	    },
	    onRightClickRow: function (rowid, iRow, iCol, e) {//우클릭 브라우져메뉴 block
		}
	});

	jQuery('#basicsList').jqGrid('addRowData', 0 ,colData);
</script>

<table id="basicsList"></table>