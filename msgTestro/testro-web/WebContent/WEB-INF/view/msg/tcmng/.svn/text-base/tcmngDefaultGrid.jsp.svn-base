<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<script type="text/javascript" src="js/cmn/utils/json2.js" charset="utf-8"></script>

<c:set var="colNames" value="" />
<c:set var="colModel" value="" />

<script type="text/javascript">
	var widthSize = 0;
	var EngAutoDataHeaderKey = new Array(); //자동증감데이터 팝업 호출시 그리드칼럼 명 
	var EngAutoDataHeader = new Array();  	//자동증감데이터 팝업 호출시 그리드칼럼 영문명
	var KorAutoDataHeader = new Array();  	//자동증감데이터 팝업 호출시 그리드칼럼 한글명
	var autoMaxLength = new Array();		//자동증감데이터 팝업 호출시 그리드 칼럼의 maxlength 사이즈 
	var autoIdx = 0; 				   		//자동증감데이터 Array의 index값
	var rptColIdx 		= 6;				//반복부 시작 위치
	var rptCol = new Array;					//반복부 위치를 저장
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
	<c:set var="fldSizeCnt" value="${list.tscsFldSize}" />

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
		<c:when test='${(fldType) == "hex"}'>
			<c:set var="fldSize" value="${fldSizeCnt * '2'}"/>
		</c:when>
		<c:otherwise>
			<c:set var="fldSize" value="${fldSizeCnt}"/>
		</c:otherwise>
	</c:choose>
	
	<script type="text/javascript">
		autoIdx = '${widthSize}';
		EngAutoDataHeaderKey[autoIdx] = '${colModelNm}';
		EngAutoDataHeader[autoIdx] = '${fldName}';
		KorAutoDataHeader[autoIdx] = '${fldDesc}';
		autoMaxLength[autoIdx]	=	 '${fldSize}';
	</script>
	
	<c:choose>
		<c:when test='${(fldAttrib) == "03"}'>
			<c:set var="editable" value="false" />	
		</c:when>
		<c:otherwise>
			<c:set var="editable" value="true"/>
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test='${(status.first) == true}'>
			<!-- 그리드 헤더 정의 -->
			<c:set var="colNames" value="${colNames}'${fldName}(${fldSize})<br/>${fldDesc}(${fldType})'" />	
			<c:set var="colModel" value="${colModel}{name:'${colModelNm}', index:'${colModelNm}', width:120, align:'left', sortable:false, editable:${editable}, editoptions:{maxlength:'${fldSize}', style:'text-align:left'}}" />
			<!--// 그리드 헤더 정의 -->
		</c:when>
		<c:when test='${(status.first) == false}'>
			<!-- 그리드 헤더 정의 -->
			<c:set var="colNames" value="${colNames}, '${fldName}(${fldSize})<br/>${fldDesc}(${fldType})'" />	
			<c:set var="colModel" value="${colModel}, {name:'${colModelNm}', index:'${colModelNm}', width:120, align:'left', sortable:false, editable:${editable}, editoptions:{maxlength:'${fldSize}', style:'text-align:left'}}" />
			<!--// 그리드 헤더 정의 -->
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test='${(fldAttrib) == "03"}'>
			<c:set var="colNames" value="${colNames}, '반복부'" />	
			<c:set var="colModel" value="${colModel}, {name: '${colModelNm}G',index: '${colModelNm}G', hidden:true}" />
			<script type="text/javascript">
				rptCol[rptCol.length] = ${widthSize} + rptColIdx;
			</script>
			<c:set var="widthSize" value="${widthSize + 1}" />
		</c:when>
	</c:choose>
</c:forEach>


<script type="text/javascript">
//테스트케이스 목록
	var lastsel2;

	var $grid2 = $("#list"),
	fixPositionsOfFrozenDivs2 = function () { 
	}; 
	
	jQuery("#list").jqGrid({
		mtype:'POST',    // 한글 인코딩 깨지는 문제 방지하기 위해 POST로 쓴다
		datatype: "json",
	    colNames:[
	      	      '실행결과',
	              '테스트데이터ID' , 
	              '테스트데이터명' ,
	              '테스트데이터설명' ,
	              '체크<br/>포인트' ,
	              '체크포인트값' ,
	              ${colNames}
		],
	    colModel:[
					{name: 'rsultsucssyn',index:'rsultsucssyn', width:80, align:"center", hidden: true},
					{name: 'tsdataID',index: 'TsdataID', width:130, align:"center", sortable:false, key:true},
					{name: 'tsdataName',index: 'TsdataName', width:130, editable:true,  align:"left", sortable:false, editoptions:{maxlength:'200'}},
					{name: 'tsdataDesc',index: 'TsdataDesc', width:150, editable:true, align:"left", sortable:false, editoptions:{maxlength:'300'}},
					{name: 'chkYN',index: 'ChkYN', width:80, align:"center", sortable:false},
					{name: 'chkYNVal',index: 'ChkYNVal', hidden:true},
					${colModel}
	    ],
	    rownumbers	: true, 		//rownum
	    editurl		: 'clientArray',
	    scroll		: 1, 	//scroll paging config 
	   	multiselect	: true, 		//멀티셀렉트 설정
	    scrollrows  : true,
	    viewrecords	: true,
	    gridview    : true,
	    loadComplete: function(xhr){
			if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
			$(".ui-jqgrid-sortable").css('height','auto');
		},
	    ondblClickRow: function (rowid, iRow, iCol, e) { //더블클릭 이벤트
		    //더블클릭한 위치 iCol의 값과 반복문의 열의 일치 여부 판단
		    var rptChk = false;
			$.each(rptCol, function (index, value) {
				if(parseInt(value) + 1 == iCol){
					rptChk = true;
				}
			});
			if(iCol == rptColIdx){
				checkPointPop(rowid, iRow, iCol);
			}else if(rptChk){
				rptPop(rowid, iRow, iCol);
			}else{
				jQuery('#list').jqGrid('editRow',rowid,true);

				chkRegBoolean("False");
			}
			lastsel2=rowid;
			if("0" != iCol){ // 싱글선택:0 , 멀티선택:0,1
				$("input, select",e.target).focus();   // 포커스위치 설정
				lastsel2=rowid;
			}
			$("input, select",e.target).focus();   					// 포커스위치 설정
	    }, 
	    onCellSelect: function(rowid, index, contents, event) {//checkbox 선택시만 row선택
	    	if("1" != index){ 
	    		$("#list").jqGrid('setSelection', rowid, false); 
	    	} 
	    	$("#list").jqGrid("saveRow",lastsel2);
	    },
	    onRightClickRow: function (rowid, iRow, iCol, e) {//우클릭 브라우져메뉴 block
		}
	});
	// grid 초기화 
    gridExcelInit();

	//setFrozen();
	gridResize();
</script>

<table id="list"></table>	