var tranUrl = "msg.statistics.getTestPrgsSts.do";
var param = "";
var maxWidth= 700;
var leftTemp= 230;
var postData = "";
$(document).ready(function(){
	//setCurrentDate();
	getListMngCode('searchGubun','TES4DIV','01');
	getListMngCode('connSevrDstcd','CONNSEVRDSTCD2','00');
	$("#testStartYMS").val(getDateFormat(testStartYMS));
	$("#testEndYMS").val(getDateFormat(testEndYMS));
	setTestStgeName("testStgeName2");
	
	param = 'searchGubun='+$("#searchGubun").val()+'&testStartYMS='+$("#testStartYMS").val()+'&testEndYMS='+$("#testEndYMS").val()+'&projNo='+encodeURIComponent($("#projNo").val());
jQuery("#list2").jqGrid({
   	url:tranUrl,
   	mtype:'POST',    // 한글 인코딩 깨지는 문제 방지하기 위해 POST로 쓴다
   	postData:getPostData(),
	datatype: "json",
   	colNames:['거래코드','거래명','테스트단계','거래명(거래코드)','수행건수','성공건수','실패건수','성공율(%)','테스트단계','거래명(거래코드)','수행건수','성공건수','실패건수','성공율(%)'],
   	colModel:[
		{name:'tranCd',index:'tranCd' , width:100,hidden:true},
		{name:'tranName',index:'tranName' , width:100,hidden:true},
   		{name:'testStgeName',index:'testStgeName', hidden:true},
   		{name:'tempTranNameforExcel',index:'tempTranNameforExcel' , hidden:true},
   		{name:'tscsExeCnt',index:'tscsExeCnt' , hidden:true,formatoptions:{thousandsSeparator:","}, formatter:'integer',summaryType:'sum',align:"center"},
   		{name:'tscsSucssCnt',index:'tscsSucssCnt' , hidden:true,formatter:'integer',formatoptions:{thousandsSeparator:","}, summaryType:'sum',align:"center"},
   		{name:'tscsMissCnt',index:'tscsMissCnt' , hidden:true,formatter:'integer',formatoptions:{thousandsSeparator:","}, summaryType:'sum',align:"center"},
   		{name:'tscsPercent',index:'tscsPercent' , hidden:true,formatter:'number',align:"center"},
   		{name:'testStgeName',index:'testStgeName', width:100,align:"center"},
   		{name:'tempTranName',index:'tempTranName' , width:400,align:"left"},
   		{name:'tscsExeCnt',index:'tscsExeCnt' , width:50,formatoptions:{thousandsSeparator:","}, formatter:'integer',summaryType:'sum',align:"center"},
   		{name:'tscsSucssCnt',index:'tscsSucssCnt' , width:50,formatter:'integer',formatoptions:{thousandsSeparator:","}, summaryType:'sum',align:"center"},
   		{name:'tscsMissCnt',index:'tscsMissCnt' , width:50,formatter:'integer',formatoptions:{thousandsSeparator:","}, summaryType:'sum',align:"center"},
   		{name:'tscsPercent',index:'tscsPercent' , width:50,formatter:'number',align:"center"}
   	],
   	rowNum:-1,
   	sortname: 'tranName',
   	sortorder: 'desc',
    viewrecords: true,
    gridView : true,
    width:'100%',
    footerrow : true,
    //userDataOnFooter: true,
    afterInsertRow:function(id){
		
	},
	onCellSelect:function(id){

	},
	ondblClickRow: function(rowid) { 
		
	    var targetUrl = "msg.exeSts.exeSts.do?";
	    var testStartYMS = $("#testStartYMS").val();
	    var testEndYMS =  $("#testEndYMS").val();
	    var projNo = $("#projNo").val();
	    $("#testStgeName").val($("#list2").jqGrid('getCell',rowid,'testStgeName')); //단위테스트
	    $("#tranCd").val($("#list2").jqGrid('getCell',rowid,'tranCd'));         //거래 코드
	    $("#tranName").val($("#list2").jqGrid('getCell',rowid,'tranName'));     //거래 코드 명
		var returnValue = window.showModalDialog(targetUrl,window,'center:yes;dialogWidth=1150px; dialogHeight=615px; dialogLeft=100px; dialogTop=50px; scroll=no; status=no; help=no; resizable:no;');
	},
	loadComplete:function(xhr){
		if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
		
		var tscsExeCntSum = $("#list2").jqGrid('getCol','tscsExeCnt','false','sum');
		var tscsSucssCntSum = $("#list2").jqGrid('getCol','tscsSucssCnt','false','sum');
		var tscsMissCntSum = $("#list2").jqGrid('getCol','tscsMissCnt','false','sum');
		var tscsPercent = $("#list2").jqGrid('getCol','tscsPercent','false','avg');
		
		if(tscsExeCntSum != 0 && tscsSucssCntSum != 0){
			tscsPercent = tscsSucssCntSum * 100 / tscsExeCntSum ;   // 테스트케이스 성공율(%)
			tscsPercent = tscsPercent.toFixed(2); // 소수점 아래 두자리 까지 표현
		}

		$("#list2").tuiTableRowSpan("8");
		
		var row = jQuery("#list2").getRowData();  //데이터
		
		if(row.length > 1)  $("#excelBtn").attr('disabled','');
		else if(row.length < 1) $("#excelBtn").attr('disabled','true');
		
		jQuery("#list2").footerData('set',{testStgeName:'합계',tscsExeCnt:tscsExeCntSum,tscsSucssCnt:tscsSucssCntSum,
			tscsMissCnt:tscsMissCntSum,tscsPercent:tscsPercent});
		
		reloadGridSize();

	},
	onRightClickRow: function (rowid, iRow, iCol, e) {//우클릭 브라우져메뉴 block
	},
	jsonReader : {
    root: "rows",
    page: false,
    repeatitems: false
	}
});

jQuery("#list2").jqGrid('navGrid','#pager2',{edit:false,add:false,del:false});

jQuery("#srch_btn").click(function (){

	getList();
	

});



$("input,select").keydown(function(e){
	if(e.keyCode == 13){
		getList();
	}
});

reloadGridSize();

gridExcelInit();
});

// 조회 버튼 클릭
function getList(){
	if($("#projNo").val() == ""){
		alert("프로젝트를 선택하십시오.");
		$("#projNo").focus();
		return;

	}else if($("#testStartYMS").val() == ""){
		alert("조회기간을 입력하십시오.");
		$("#testStartYMS").focus();
		return;

	}else if($("#testEndYMS").val() == ""){
		alert("조회기간을 입력하십시오.");
		$("#testEndYMS").focus();
		return;

	}
	var searchGubun = "";
	if($("#searchGubun").val() == "01"){
		searchGubun = "01";
		jQuery('#list2').jqGrid('showCol',['tempTranName']);
		
	}else if($("#searchGubun").val() == "02"){
		jQuery('#list2').jqGrid('hideCol',['tempTranName']);
		searchGubun = "02";
	}else{
		alert("조회구분을 선택하십시오");
		$("#searchGubun").focus();
		return;
	}
	var param = 'testStartYMS='+$("#testStartYMS").val()+'&testEndYMS='+$("#testEndYMS").val()+'&projNo='+encodeURIComponent($("#projNo").val())+"&searchGubun="+searchGubun;
	
	$('#list2').setGridParam({url:tranUrl});
	$('#list2').setGridParam({postData:getPostData()});
	$('#list2').trigger("reloadGrid");
	
}

// POST DATA 얻기
function getPostData(){
	var postData = {searchGubun:$("#searchGubun").val(),testStartYMS:$("#testStartYMS").val(),testEndYMS:$("#testEndYMS").val(),projNo:$("#projNo").val(),connSevrDstcd:$("#connSevrDstcd").val(),testStgeName:$("#testStgeName2").val()};
	return postData;
}

//엑셀다운로드. 
function downExcelTestPrgsSts() {
	if($("#excelBtn").attr('disabled') == true ){

		return;
	}
	var callback = function(rowid) {
		var rowdata = new Array();
		rowdata.push($("#list2").getCell(rowid,'testStgeName'));
		if($("#searchGubun").val() == "01") //테스트 케이스일경우 거래코드 명도 얻어옴.
			rowdata.push($("#list2").getCell(rowid,'tempTranNameforExcel'));
		rowdata.push($("#list2").getCell(rowid,'tscsExeCnt'));
		rowdata.push($("#list2").getCell(rowid,'tscsSucssCnt'));
		rowdata.push($("#list2").getCell(rowid,'tscsMissCnt'));
		rowdata.push($("#list2").getCell(rowid,'tscsPercent'));
		
		return rowdata;
	};
	if($("#searchGubun").val() == "01")            //테스트케이스
		gridCustomExportExcel('list2', [0,1,3,4,5,6,7,8], '단계별 진척현황',callback);
	else if($("#searchGubun").val() == "02")       //테스트시나리오
		gridCustomExportExcel('list2', [0,1,3,4,5,6,7,8,9], '단계별 진척현황',callback);
}

