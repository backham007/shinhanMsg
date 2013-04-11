<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>전문 테스트로(TESTRO)</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />

<script type="text/javascript" src="js/cmn/utils/json2.js" charset="utf-8"></script>
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="jqgrid/css/ui-lightness/jquery-ui-1.7.3.custom.css" media="screen" />
<link rel="stylesheet" type="text/css" href="jqgrid/js/src/css/ui.jqgrid.css" media="screen" />
<link rel="shortcut icon" href="images/TESTRO.ico" type="image/ico" />
<style>
html, body {
    margin: 0;
    padding: 0;
    font-size: 75%;
}
</style>

<script type="text/javascript" src="js/cmn/common.js" charset="UTF-8"></script>
<script type="text/javascript" src="jqgrid/js/jquery-1.5.2.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/jquery.blockUI.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/src/i18n/grid.locale-en.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/jquery.jqGrid.src.js" charset="utf-8"></script>

<c:set var="colNames" value="" />
<c:set var="colModel" value="" />


<c:forEach var="list2" items="${rows}" varStatus="status2">

	<c:choose>
		<c:when test='${(status2.last) == false}'>
			<c:set var="fldName" value="${list2.fldName}"/>
			<c:set var="fldType" value="${list2.fldType}"/>
			<c:set var="fldData" value="${list2.fldData}"/>
			<c:set var="rptName" value="${list2.rptName}"/>
			<c:choose>
				<c:when test='${(fldType) == "hex"}'>
					<c:set var="tscsFldSize" value="${list2.tscsFldSize * '2'}"/>
				</c:when>
				<c:otherwise>
					<c:set var="tscsFldSize" value="${list2.tscsFldSize}"/>
				</c:otherwise>
			</c:choose>
			<c:set var="tscsFldDesc" value="${list2.tscsFldDesc}"/>
			<c:set var="colNames" value="${colNames}'${fldName} (${tscsFldSize}) [${fldType}] /${tscsFldDesc}', " />
			<c:set var="colModel" value="${colModel}{name: '${fldName}',index: '${fldName}', width:300,editable:true, align:'left', sortable:false, editoptions:{maxlength:'${tscsFldSize}'}}," />	
		</c:when>
		<c:when test='${(status2.last) == true}'>
			<c:set var="fldName" value="${list2.fldName}"/>
			<c:set var="fldType" value="${list2.fldType}"/>
			<c:set var="fldData" value="${list2.fldData}"/>
			<c:set var="rptName" value="${list2.rptName}"/>
			<c:choose>
				<c:when test='${(fldType) == "hex"}'>
					<c:set var="tscsFldSize" value="${list2.tscsFldSize * '2'}"/>
				</c:when>
				<c:otherwise>
					<c:set var="tscsFldSize" value="${list2.tscsFldSize}"/>
				</c:otherwise>
			</c:choose>
			<c:set var="tscsFldDesc" value="${list2.tscsFldDesc}"/>
			<c:set var="colNames" value="${colNames}'${fldName} (${tscsFldSize}) [${fldType}] /${tscsFldDesc}' " />
			<c:set var="colModel" value="${colModel}{name: '${fldName}',index: '${fldName}', width:400,editable:true, align:'left',sortable:false ,editoptions:{maxlength:'${tscsFldSize}'}}" />
		
		</c:when>
		
	</c:choose>
	
</c:forEach>
 <script type="text/javascript">
var opener = window.dialogArguments;

// iframe resize
function autoResize(i)
{
    var iframeHeight=
    (i).contentWindow.document.body.scrollHeight;
    (i).height=iframeHeight+20;
}


var lastsel3;
$(document).ready(function(){
	
	gridExcelInit();	//엑셀입출력 초기화
	
	//테스트케이스 목록
	jQuery("#list").jqGrid({
		mtype:'POST',    // 한글 인코딩 깨지는 문제 방지하기 위해 POST로 쓴다
		async : true,
		datatype: "json",
	    colNames:[${colNames}],
	    colModel:[${colModel}],
	    rownumbers	: true, 		//rownum
	  	scroll:1,
	    viewrecords: true,
	   	editurl:'clientArray',
	    scrollrows : true, //포커스이동시 스크롤 자동맞춤.
	    height : 510,
	    loadComplete: function(xhr) {
			if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
		},
	    jsonReader 	: {
	        root: "rows",
  	 		page: "page",
  	        total: "total",
  	  		scroll:1, //scroll paging config 
  	        records: "records",
  	        repeatitems: false,
  	        cell: "cell",
	        id		: "${colModel}"
	    },

	  	//Edit 수정
	    ondblClickRow: function (rowid, iRow, iCol, e) { //더블클릭 이벤트
			if("0" != iCol){
		    	jQuery('#list').jqGrid('editRow',rowid,true); 
		    	$("input, select",e.target).focus();   // 포커스위치 설정
		    	lastsel3=rowid; 
			}
		},
        onCellSelect: function(rowid, index, contents, event) {		//클릭저장
    		$("#list").jqGrid("saveRow",lastsel3);
    	}
	});

	//반복부입력 다시 클릭 수정시
	var rpt = opener.rptMap[fldName];
	
	for(var i in rpt){
		rpt[i]["rowid"] = parseInt(i)+1;
	}

	$("#list").jqGrid('addRowData',"rowid",rpt);
	
	/*
	if(rpt != undefined && rpt != '' && rpt.length > 0){
		var colModel = [${colModel}];
		for(var i=0, cnt=rpt.length; i<cnt; i=i+colModel.length){
			var rowData = new Object();
			for(var j=0 ; j < colModel.length ; j++){
				rowData[colModel[j].name] = rpt[i + j];
			}
			jQuery('#list').addRowData((i/colModel.length)+1, rowData);
		}
	}*/
	
	//윈도우사이즈와 맞춰 조절됨 
	var maxWidth= 1000;
	$(window).bind('resize', function() {
		var windwoWindth = $(window).width()-30;
		if (windwoWindth > maxWidth) {
			$("#list").setGridWidth(windwoWindth, true);
		} else {
			jQuery("#list").jqGrid('gridResize',{minWidth:maxWidth ,maxWidth:'100%'});
			$("#list").setGridWidth(windwoWindth, false);
		}
			
	}).trigger('resize');
	//jQuery("#list").setGridWidth(915,true); 	//가로스크롤
	//jQuery("#list").setGridHeight(510,true);   //그리드 높이
	
});


//행추가
function rowInsert(){
	var maxKey = 0;
	var ids = $("#list").getDataIDs();
	$.each(ids, function (index, value) {
		if(parseInt(value) > parseInt(maxKey)){
			maxKey = value;
		}
	});
	
	$("#list").jqGrid('addRowData',parseInt(maxKey)+1,{});
	$("#list").jqGrid('setSelection', parseInt(maxKey)+1);
}


function rowDelete() { //row삭제
	
	//rowid배열
	var ids = $("#list").jqGrid("getDataIDs");
	
	//현재행의 rowid
	var curRowid = $("#list").jqGrid('getGridParam', "selrow" );

	//아래행의 rowid를 찾고 아래행이 없으면 위의행의 rowid를 찾는다
	var moveRowid;
	for(var i = 0 ; i < ids.length ; i++){
		if(ids[i] == curRowid){
			if(i == ids.length - 1){
				if(i == 0){
					break;
				}
				moveRowid = ids[i-1];
				break;
			}
			moveRowid = ids[i+1];
			break;
		}
	}
	
	$("#list").jqGrid('delRowData', curRowid);
	
	$("#list").jqGrid('setSelection', moveRowid);
 }



function rowCopy(){  // row복사 
    var cklst = jQuery("#list").jqGrid('getGridParam','selrow'); //체크된 리스트
        if( cklst != null ) { 
	    	//현재데이터 편집을 save
	    	$("#list").jqGrid("saveRow",cklst);
	    	var ids = $("#list").getDataIDs();
	    	
		    var ret = jQuery("#list").getRowData(cklst); 
		    jQuery("#list").jqGrid('addRowData',ids.length+1,ret);
		    
		    ids = $("#list").getDataIDs();
		    $("#list").jqGrid('setSelection', ids[ids.length-1]);
		    //var height = $("#"+maxKey).attr('offsetHeight'); 
		    //$(".ui-jqgrid-bdiv").scrollTop(height*maxKey); //scroll bottom으로 이동
	    }else{ 
	    	alert("복사할 row를 선택하세요!!!!!"); 
	    }
    }





//행위로버튼
function rowUp(){

	//rowid배열
	var ids = $("#list").jqGrid("getDataIDs");
	
	//현재행의 rowid
	var curRowid = $("#list").jqGrid('getGridParam', "selrow" );
	$("#list").jqGrid("saveRow",curRowid);
	
	//윗행의 rowid를 찾는다
	var upRowid;
	for(var i = 0 ; i < ids.length ; i++){
		if(ids[i] == curRowid){
			
			if(i == 0){//첫번째 row를 선택한경우 
			     return; 
			     } 
			upRowid = ids[i-1];
			break;
		}
	}
	
	//데이터 얻기
	var curRowData = $("#list").jqGrid('getRowData', curRowid);
	var upRowData = $("#list").jqGrid('getRowData', upRowid);
	
	//데이터 교체
	$("#list").jqGrid('setRowData', curRowid, upRowData);
	$("#list").jqGrid('setRowData', upRowid, curRowData);
	
	//선택행 변경
	$("#list").jqGrid('resetSelection');
	$("#list").jqGrid('setSelection', upRowid);

	
}
//행아래로버튼
function rowDown(){	
	//rowid배열
	var ids = $("#list").jqGrid("getDataIDs");
	
	//현재행의 rowid
	var curRowid = $("#list").jqGrid('getGridParam', "selrow" );
	$("#list").jqGrid("saveRow",curRowid);
	
	//다음행의 rowid를 찾는다
	var downRowid;
	for(var i = 0 ; i < ids.length ; i++){
		if(ids[i] == curRowid){
			if(i == (ids.length-1)){//마지막 row를 선택한경우 
			     return; 
			     } 
			downRowid = ids[i+1];
			break;
		}
	}
	
	//데이터 얻기
	var curRowData = $("#list").jqGrid('getRowData', curRowid);
	var downRowData = $("#list").jqGrid('getRowData', downRowid);
	
	//데이터 교체
	$("#list").jqGrid('setRowData', curRowid, downRowData);
	$("#list").jqGrid('setRowData', downRowid, curRowData);
	
	//선택행 변경
	$("#list").jqGrid('resetSelection');
	$("#list").jqGrid('setSelection', downRowid);
}


var fldName = '${fldName2}';   //반복부fidName 반복부가 여러개 있을경우 구분
//반복부 적용버튼
function getRptSave(){
	$("#list").jqGrid("saveRow",lastsel3);
    var gridData	= jQuery("#list").jqGrid('getRowData'); 
    var postData 	= new Object();
	    postData.gridData 	= gridData;
	    postData.fldName 	= fldName;
	  	window.returnValue 	= postData;
	  	self.close(); 
} 

//엑셀내려받기
function exportExcel() {
	
	//현재데이터 편집을 save
	$("#list").jqGrid("saveRow",$("#list").jqGrid('getGridParam', "selrow" ));
	
	gridExportExcel('list', [], '반복부 입력');

}

//엑셀업로드 팝업 호출
function importExcel() {
	
	window.open('cmn.grid.popImportExcel.do','엑셀업로드','status=yes,width=520,height=155');
}

var excelFlag;
var excelData = [];
//mapping callback함수 : 변수명은 "mappingExcel"로 정의해야 합니다.
var mappingExcel = function (excelRowData, excelIndex, lastIndex){
	
	if(excelIndex == 0){
		$("#list").jqGrid('clearGridData');	//그리드데이터삭제
		excelFlag = false;
		excelData = [];
	}
	
	//데이터 그리드칼럼 index name 세팅
	var colNames = $("#list").jqGrid('getGridParam', "colNames" );
	var colModel = $("#list").jqGrid('getGridParam', "colModel" );
	
	var addData = {};
	for(var index in excelRowData){
		var i = 0;
		for(i ; i < colNames.length ; i++){
			if(colNames[i].split(" ").join("") == index){
				addData[colModel[i].name] = excelRowData[index];
				break;
			}
		}
		
		if(i == (colNames.length)) excelFlag = true;
	}
	
	//그리드에 추가
	/* var maxKey = 0;
	var ids = $("#list").getDataIDs();
	$.each(ids, function (index, value) {
		if(parseInt(value) > parseInt(maxKey)){
			maxKey = value;
		}
	}); */
	
	excelData[excelData.length] = addData;
	excelData[excelData.length-1]["rowid"] = excelIndex + 1;
	
	if(excelIndex == lastIndex){
		$("#list").jqGrid('addRowData',"rowid",excelData);
		if(excelFlag)alert("엑셀헤더와 전문레이아웃이 불일치합니다");
	}
};

</script>
</head>
 
<body leftmargin="0" topmargin="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td width="43"><img src="images/pop_tit_01.gif" width="43" height="51"></td>
    <td background="images/pop_tit_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="pop_tit">반복부 입력</td>
      </tr>
    </table></td>
    <td width="216"><img src="images/pop_tit_03.gif" width="216" height="51"></td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="3">
  <tr>
    <td valign="top"><table width="100%" height="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#baccdc">
      <tr>
        <td bgcolor="#e1e9f0"><table width="100%" height="100%" border="0" cellpadding="5" cellspacing="0">
          <tr>
            <td valign="top" bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table align="right" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                    <td background="images/btn_img_02.gif" class="btn_text" onclick="exportExcel();" style="cursor:pointer;">엑셀다운로드</td>
                    <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                  </tr>
                </table>
                <table align="right" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                    <td background="images/btn_img_02.gif" class="btn_text" onclick="importExcel();" style="cursor:pointer;">엑셀업로드</td>
                    <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                  </tr>
                </table>
                <table align="right" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                    <td background="images/btn_img_02.gif" class="btn_text" onclick="rowDelete();" style="cursor:pointer;">행삭제</td>
                    <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                  </tr>
                </table>
                  <table align="right" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                      <td background="images/btn_img_02.gif" class="btn_text" onclick="rowCopy();" style="cursor:pointer;">행복사</td>
                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                    </tr>
                  </table>
                  <table align="right" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                      <td background="images/btn_img_02.gif" class="btn_text" onclick="rowInsert();" style="cursor:pointer;">행추가</td>
                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                    </tr>
                  </table>
                  <table align="right" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="16" height="21" background="images/btn_img_01.gif" >&nbsp;</td>
                      <td background="images/btn_img_02.gif" class="btn_text" onclick="rowDown();" style="cursor:pointer;">▼</td>
                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                    </tr>
                  </table>
                  <table align="right" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                    <td background="images/btn_img_02.gif" class="btn_text" onclick="rowUp();" style="cursor:pointer;">▲</td>
                    <td width="10" background="images/btn_img_03.gif" >&nbsp;</td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="5"></td>
              </tr>
            </table>
              <table width="100%" height="100" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                <tr>
                  <td height="530" valign="top" bgcolor="#FFFFFF">
	                  <!--  그리드  -->
	                  <table id="list"></table>
                  </td>
                </tr>
                </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>  
                  <td height="5" colspan="3">
                 </td>
                </tr>
                <tr>
                  <td> <table align="left" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                      <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer;" onclick="getRptSave();">적 용</td>
                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                    </tr>
                  </table></td>
                  <td ><table align="right" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                          <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer;" onclick="self.close();">닫 기</td>
                          <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                        </tr>
                      </table>
                    </td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
<!-- Start of wrap -->
</body>
 
</html>