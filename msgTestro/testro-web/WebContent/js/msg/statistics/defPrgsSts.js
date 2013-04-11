var tranUrl = "msg.statistics.getDefPrgsSts.do";
var maxWidth= 1370;
var leftTemp= 230;
$(document).ready(function(){
	$("#testStartYMS").val(getDateFormat(testStartYMS));
	$("#testEndYMS").val(getDateFormat(testEndYMS));
	setTestStgeName("testStgeName");
	getListMngCode('defCd','DEFSTATUS','00');
	getListMngCode('connSevrDstcd','CONNSEVRDSTCD2','00');


	var connSevrDstcd = $("#connSevrDstcd").val();
	var param = 'connSevrDstcd='+encodeURIComponent(connSevrDstcd)+'&testStartYMS='+$("#testStartYMS").val()+'&testEndYMS='+$("#testEndYMS").val()+'&projNo='+encodeURIComponent($("#projNo").val())
	+'&tranCd='+$("#tranCd").val()+'&testStgeName='+encodeURIComponent($("#testStgeName").val())+'&defCd='+$("#defCd").val();
	jQuery("#list2").jqGrid({
	   	url: tranUrl,
	   	postData:getPostData(),
	   	mtype:'POST',    // 한글 인코딩 깨지는 문제 방지하기 위해 POST로 쓴다
		datatype: "json",
	   	colNames:['테스트대상시스템','테스트데이터수행회차','테스트대상시스템','테스트케이스/시나리오 ID','테스트케이스/시나리오 명','테스트데이터ID','테스트데이터명','결함ID','거래코드','결함진행상태','결함내용','결함등록자ID','결함등록자명','결함등록일시','테스트대상시스템','테스트케이스/시나리오 ID','테스트케이스/시나리오 명','테스트데이터ID','테스트데이터명','결함ID','거래코드','결함진행상태','결함내용','결함등록자ID','결함등록자명','결함등록일시'],
	   	colModel:[
			{name:'acmplNth',index:'acmplNth' ,hidden:true},
			{name:'tsdataAcmplNth',index:'tsdataAcmplNth' ,hidden:true},
		    {name:'connSevrDstcd',index:'connSevrDstcd' ,hidden:true},
			{name:'objId',index:'objId' ,hidden:true},
			{name:'objName',index:'objName' ,hidden:true},
			{name:'tsdataId',index:'tsdataId' ,hidden:true},
			{name:'tsdataName',index:'tsdataName' ,hidden:true},
			{name:'flawId',index:'flawId' ,hidden:true},
			{name:'tranCd',index:'tranCd',hidden:true},
			{name:'defCd',index:'defCd' ,hidden:true},
			{name:'defErrCd',index:'defErrCd' ,hidden:true},
			{name:'defRegId',index:'defRegId' ,hidden:true},
			{name:'defRegNm',index:'defRegNm' ,hidden:true},
			{name:'defRegYMS',index:'defRegYMS' ,hidden:true},
	   		{name:'connSevrDstcd',index:'connSevrDstcd' , width:120,align:"center"},
	   		{name:'objId',index:'objId' , width:200,align:"center"},
	   		{name:'objName',index:'objName' , width:250},
	   		{name:'tsdataId',index:'tsdataId' , width:220,align:"center"},
	   		{name:'tsdataName',index:'tsdataName' , width:250},
	   		{name:'flawId',index:'flawId' , width:230,align:"center", sortable:false},
	   		{name:'tranCd',index:'tranCd' , width:150,align:"center"},
	   		{name:'defCd',index:'defCd' , width:150,align:"center"},
	   		{name:'defErrCd',index:'defErrCd' , width:150,align:"center"},
	   		{name:'defRegId',index:'defRegId' , width:150,align:"center"},
	   		{name:'defRegNm',index:'defRegNm' , width:150,align:"center"},
	   		{name:'defRegYMS',index:'defRegYMS' , width:150,align:"center",formatter:gridDateFmatter, formatoptions: {srcformat:'yMdhms', newformat:'y-M-d h:m:s'}, unformat:gridDateUnFmatter , sortable:true}
	   	],
	   	rownumbers: true, //scroll paging config  
	   	rowNum:30,
	   	rowList:[20,30,50],
	   	pager: '#pager2',
	   	sortname: 'defRegYMS',
	   	sortorder: 'desc',
	    viewrecords: true,
	    //width:'100%',
	    gridView : true, 
	    afterInsertRow: function(id){
			
		},
	    ondblClickRow: function(rowid) { 
			moveReport(rowid);
		},
		loadComplete:function(xhr){
			if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
			$("#list2").tuiTableRowSpan("15");
			var row = jQuery("#list2").getRowData();  //데이터
			if(row.length > 1)  $("#excelBtn").attr('disabled','');
			else if(row.length < 1) $("#excelBtn").attr('disabled','true');
			
			reloadGridSize();
		},
		onRightClickRow: function (rowid, iRow, iCol, e) {//우클릭 브라우져메뉴 block
		},
		jsonReader : {
			 root: "rows",
			 page: "page",
			 total: "total",
			 records: "records",
			 repeatitems: false,
			 cell: false
		}
	
	});
	jQuery("#srch_btn").click(function (){
		getList();		
	});

	$("input,select").keydown(function(e){
		if(e.keyCode == 13){
			getList();
		}
	});
	gridExcelInit();
});

// 결과보고서 상세팝업 띄우기.
function moveReport(rowid) {
	
	var url = "msg.report.reportDetail.do?";
	var gubun,tscaseid,acmplnth,tsdataid,tsdataacmplnth;
	gubun = getSearchGubun($("#list2").getCell(rowid,'objId'));
	tscaseid = $("#list2").getCell(rowid,'objId');
	acmplnth = $("#list2").getCell(rowid,'acmplNth');
	tsdataid = $("#list2").getCell(rowid,'tsdataId');
	tsdataacmplnth = $("#list2").getCell(rowid,'tsdataAcmplNth');
	var param = "gubun="+gubun+"&tscaseid="+tscaseid+"&tssnrioid="+tscaseid+"&acmplnth="+acmplnth+"&tsdataid="+tsdataid+"&tsdataacmplnth="+tsdataacmplnth;
	window.open(url+param,"결과상세보고서","location=no,resizable=no,status=no,width=980,height=770");
}

// 테스트조회 구분(테스트케이스/테스트시나리오)
function getSearchGubun(objId){
	var gubun = "";
	if(objId.substr(0,1) == "C" || objId.substr(0,1) == "B"){ //테스트케이스
		gubun = "01";
	}else if(objId.substr(0,1) == "S"){ //테스트시나리오
		gubun = "02";
	}
	return gubun;
}

// 조회 버튼 클릭
function getList(){
	$('#list2').setGridParam({postData:getPostData(),page: 1});
	$('#list2').trigger("reloadGrid");
}

//엑셀내려받기 
//gridName : 그리드 아이디
//val : 제외 컬럼 ex - [0,1,4]
//excelName : 저장할 엑셀 파일 명
function downExcelDefPrgsSts() { 
	if($("#excelBtn").attr('disabled') == true ){
		return;
	}
	var callback = function(rowid) {
		var rowdata = new Array();
		rowdata.push($("#list2").getCell(rowid,'connSevrDstcd'));
		rowdata.push($("#list2").getCell(rowid,'objId'));
		rowdata.push($("#list2").getCell(rowid,'objName'));
		rowdata.push($("#list2").getCell(rowid,'tsdataId'));
		rowdata.push($("#list2").getCell(rowid,'tsdataName'));
		rowdata.push($("#list2").getCell(rowid,'flawId'));
		rowdata.push($("#list2").getCell(rowid,'tranCd'));
		rowdata.push($("#list2").getCell(rowid,'defCd'));
		rowdata.push($("#list2").getCell(rowid,'defErrCd'));
		rowdata.push($("#list2").getCell(rowid,'defRegId'));
		rowdata.push($("#list2").getCell(rowid,'defRegNm'));
		var defRegYMS = $("#list2").getCell(rowid,'defRegYMS'); 
		defRegYMS = getDateFormatForExcel(defRegYMS);
		rowdata.push(defRegYMS);
		
		return rowdata;
	};
	
	gridCustomExportExcel('list2', [1,2,14,15,16,17,18,19,20,21,22,23,24,25], '결함 총괄표',callback);
} 

// POST Data 얻어 오기.
function getPostData(){
	var postData = {tranCd:$("#tranCd").val(),testStgeName:$("#testStgeName").val(),defCd:$("#defCd").val(),connSevrDstcd:$("#connSevrDstcd").val(),testStartYMS:$("#testStartYMS").val(),testEndYMS:$("#testEndYMS").val(),projNo:$("#projNo").val()};
	return postData;
}
