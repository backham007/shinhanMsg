var opener = window.dialogArguments;
var tranUrl = "msg.exeSts.getExeSts.do";
 	      
$(document).ready(function(){
	jQuery("#list2").jqGrid({
	   	url:tranUrl,
	   	postData:getPostData(),
	   	mtype:'POST',    // 한글 인코딩 깨지는 문제 방지하기 위해 POST로 쓴다
	   	datatype: "json",
	   	colNames:['ID','명','수행회차','테스트대상시스템','TD개수','성공TD','실패TD','미실행TD','테스트일시','작성자','테스터','성공유무','설명','ID','명','수행회차','테스트대상시스템','TD개수','성공TD','실패TD','미실행TD','테스트일시','작성자','테스터','성공유무','설명'],
	   	colModel:[
	   		{name:'tscaseId',index:'tscaseId' ,hidden:true},
	   		{name:'tscaseName',index:'tscaseName' ,hidden:true},
	   		{name:'acmplNth',index:'acmplNth' ,hidden:true,formatter:'integer'},
	   		{name:'connsevrDstcd',index:'connsevrDstcd' ,hidden:true},
	   		{name:'tdCount',index:'tdCount' ,hidden:true,formatter:'integer'},
	   		{name:'succTdData',index:'succTdData' ,hidden:true,formatter:'integer'},
	   		{name:'failTdData',index:'failTdData' ,hidden:true,formatter:'integer'},
	   		{name:'noneExeTdData',index:'noneExeTdData' ,hidden:true,formatter:'integer'},
	   		{name:'testStartYMS',index:'testStartYMS' ,hidden:true,align:"center",formatter:gridDateFmatter, formatoptions: {srcformat:'yMdhms', newformat:'y-M-d h:m:s'}, unformat:gridDateUnFmatter},
	   		{name:'writeName',index:'writeName',hidden:true},
	   		{name:'tstrName',index:'tstrName' ,hidden:true},
	   		{name:'rsultSucssYn',index:'rsultSucssYn' ,hidden:true},
	   		{name:'tscaseDesc',index:'tscaseDesc' ,hidden:true},
	   		{name:'tscaseId',index:'tscaseId' , width:180,align:"center",sortable:false},
	   		{name:'tscaseName',index:'tscaseName' , width:250,align:"left",sortable:false},
	   		{name:'acmplNth',index:'acmplNth' , width:70,formatter:'integer',align:"center",sortable:false},
	   		{name:'connsevrDstcd',index:'connsevrDstcd' , width:70,align:"center",sortable:false},
	   		{name:'tdCount',index:'tdCount' , width:70,formatter:'integer',align:"center",sortable:false},
	   		{name:'succTdData',index:'succTdData' , width:70,formatter:'integer',align:"center",sortable:false},
	   		{name:'failTdData',index:'failTdData' , width:70,formatter:'integer',align:"center",sortable:false},
	   		{name:'noneExeTdData',index:'noneExeTdData' , width:70,formatter:'integer',align:"center",sortable:false},
	   		{name:'testStartYMS',index:'testStartYMS' , width:150,align:"center",formatter:gridDateFmatter, formatoptions: {srcformat:'yMdhms', newformat:'y-M-d h:m:s'}, unformat:gridDateUnFmatter,sortable:false},
	   		{name:'writeName',index:'writeName' , width:100,align:"center",sortable:false},
	   		{name:'tstrName',index:'tstrName' , width:100,align:"center",sortable:false},
	   		{name:'rsultSucssYn',index:'rsultSucssYn' , width:80,align:"center",sortable:false},
	   		{name:'tscaseDesc',index:'tscaseDesc' , width:250,sortable:false}
	   	],
		rownumbers: true, //scroll paging config 
	   	rowNum:-1,
	   	rowList:[10,20,30],
	   	//sortname: 'id',
	    viewrecords: true,
	    width:1600,
	    height:400,
	    sortorder: "desc",
		loadComplete:function(){
	
			$("#list2").tuiTableRowSpan("14");
			
	
		},
		ondblClickRow: function(rowid) { 
			moveReport(rowid);
		},
		onRightClickRow: function (rowid, iRow, iCol, e) {//우클릭 브라우져메뉴 block
		},
		jsonReader : {
	    root: "rows",
	    page: false,
	    total: false,
	    records: false,
	    repeatitems: false,
	    cell: "cell"
		}
		
	    
	});
	jQuery("#list2").setGridWidth(1115,false); //가로스크롤 
	//jQuery("#list2").jqGrid('setFrozenColumns'); //헤더고정 
	
	jQuery("#list2").jqGrid('navGrid','#pager2',{edit:false,add:false,del:false});
	
	$("#testStgeName").text($("#testStgeName",opener.document).val());
	$("#projName").text($("#projName",opener.document).val());
	
	// 결과보고서 상제 팝업 조회
	function moveReport(rowid) {
		
		var url = "msg.report.reportDetail.do?";
		var gubun,tscaseid,acmplnth,tsdataid,tsdataacmplnth;
		gubun = getSearchGubun($("#list2").getCell(rowid,'tscaseId'));
		tscaseid = $("#list2").getCell(rowid,'tscaseId');
		acmplnth = $("#list2").getCell(rowid,'acmplNth');
		var param = "gubun="+gubun+"&tscaseid="+tscaseid+"&tssnrioid="+tscaseid+"&acmplnth="+acmplnth+"&tsdataid=&tsdataacmplnth=";
		window.open(url+param,"결과상세보고서","location=no,resizable=no,status=no,width=980,height=770");
		
	}

	gridExcelInit();

});

// 테스트케이스/테스트시나리오 구분.
function getSearchGubun(objId){
	var gubun = "";
	if(objId.substr(0,1) == "C" || objId.substr(0,1) == "B"){
		gubun = "01";
	}else if(objId.substr(0,1) == "S"){
		gubun = "02";
	}
	return gubun;
}


//엑셀다운로드 버튼
function downExcelExeSts() { 
	var callback = function(rowid) {
		var rowdata = new Array();
		rowdata.push($("#list2").getCell(rowid,'tscaseId'));
		rowdata.push($("#list2").getCell(rowid,'tscaseName'));
		rowdata.push($("#list2").getCell(rowid,'acmplNth'));
		rowdata.push($("#list2").getCell(rowid,'connsevrDstcd'));
		rowdata.push($("#list2").getCell(rowid,'tdCount'));
		rowdata.push($("#list2").getCell(rowid,'succTdData'));
		rowdata.push($("#list2").getCell(rowid,'failTdData'));
		rowdata.push($("#list2").getCell(rowid,'noneExeTdData'));
		var date = getDateFormatForExcel($("#list2").getCell(rowid,'testStartYMS'));
		rowdata.push(date);
		rowdata.push($("#list2").getCell(rowid,'writeName'));
		rowdata.push($("#list2").getCell(rowid,'tstrName'));
		rowdata.push($("#list2").getCell(rowid,'rsultSucssYn'));
		rowdata.push($("#list2").getCell(rowid,'tscaseDesc'));
		
		return rowdata;
	};
	gridCustomExportExcel('list2', [13,14,15,16,17,18,19,20,21,22,23,24,25], '테스트수행현황',callback);
} 

// POST data 얻기
function getPostData(){

	var postData = {testStartYMS:$("#testStartYMS",opener.document).val(),testEndYMS:$("#testEndYMS",opener.document).val(),projNo:$("#projNo",opener.document).val(),testStgeName:$("#testStgeName",opener.document).val(),tranCd:$("#tranCd",opener.document).val(),tranName:$("#tranName",opener.document).val(),tstrName:$("#tstrId",opener.document).val(),searchGubun:$("#searchGubun",opener.document).val(),connSevrDstcd:$("#connSevrDstcd",opener.document).val()};
	return postData;
}