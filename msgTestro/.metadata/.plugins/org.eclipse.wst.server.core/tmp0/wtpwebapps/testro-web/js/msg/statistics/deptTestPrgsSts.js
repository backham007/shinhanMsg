// ColName 얻기(01: testcase , 02: testsinario)
function colNameData(){
	var colName = "";
	if($('#searchGubun').val() == "01"){
		colName =  ['거래코드','부서번호','테스터(id)','테스트단계','업무구분','부서명','테스터','테스트단계','거래명(거래코드)','수행건수','성공건수','실패건수','성공율(%)','부서명','테스터','테스트단계','거래명(거래코드)','수행건수','성공건수','실패건수','성공율(%)'];
	}else if($('#searchGubun').val() == "02"){
		colName =  ['거래코드','부서번호','테스터(id)','테스트단계','업무구분','부서명','테스터','테스트단계','거래명(거래코드)','수행건수','성공건수','실패건수','성공율(%)','부서명','테스터','테스트단계','수행건수','성공건수','실패건수','성공율(%)'];
	}
	return colName;
}

// ColModel 얻기 (01: testcase , 02: testsinario)
function getColModel(){
	var colModel = "";
	if($('#searchGubun').val() == "01"){
		colModel = [
		    	{name:'tranCd',index:'tranCd' , hidden:true},
		    	{name:'deptNo',index:'deptNo' , hidden:true},
			    {name:'tstrId',index:'tstrId' , hidden:true},
				{name:'testStgeName',index:'testStgeName', hidden:true},
				{name:'tranName',index:'tranName', hidden:true},
				{name:'tempDeptName',index:'tempDeptName' , hidden:true},
				{name:'tempTstrName',index:'tempTstrName' , hidden:true},
				{name:'testStgeName',index:'testStgeName', hidden:true},
				{name:'tempTranName',index:'tranName' , hidden:true,summaryType:'count',summaryTpl :'합계 ({0}건)'},
				{name:'tscsExeCnt',index:'tscsExeCnt' , hidden:true,formatoptions:{thousandsSeparator:","}, formatter:'integer',summaryType:'sum',align:"center"},
				{name:'tscsSucssCnt',index:'tscsSucssCnt' , hidden:true,formatoptions:{thousandsSeparator:","}, formatter:'integer',summaryType:'sum',align:"center"},
				{name:'tscsMissCnt',index:'tscsMissCnt' , hidden:true,formatoptions:{thousandsSeparator:","}, formatter:'integer',summaryType:'sum',align:"center"},
				{name:'tscsPercent',index:'tscsPercent', hidden:true,formatter:'number',summaryType:myAvg,align:"center"},
				{name:'deptName',index:'deptName' , width:100,align:"center",sortable:true},
				{name:'tstrName',index:'tstrName' , width:100,align:"center",sortable:true},
				{name:'testStgeName',index:'testStgeName', width:100,align:"left",sortable:true},
				{name:'tempTranName',index:'tranName' , width:300,align:"left",summaryType:'count',summaryTpl :'합계 ({0}건)',sortable:true},
				{name:'tscsExeCnt',index:'tscsExeCnt' , width:50,formatoptions:{thousandsSeparator:","}, formatter:'integer',summaryType:'sum',align:"center",sortable:true},
				{name:'tscsSucssCnt',index:'tscsSucssCnt' , width:50,formatoptions:{thousandsSeparator:","}, formatter:'integer',summaryType:'sum',align:"center",sortable:true},
				{name:'tscsMissCnt',index:'tscsMissCnt' , width:50,formatoptions:{thousandsSeparator:","}, formatter:'integer',summaryType:'sum',align:"center",sortable:true},
				{name:'tscsPercent',index:'tscsPercent' , width:60,formatter:'number',summaryType:myAvg2,align:"center",sortable:true}];
	}else if($('#searchGubun').val() == "02"){
	 colModel = [
				{name:'tranCd',index:'tranCd' , hidden:true},
				{name:'deptNo',index:'deptNo' , hidden:true},
			    {name:'tstrId',index:'tstrId' , hidden:true},
			    {name:'testStgeName',index:'testStgeName', hidden:true},
			    {name:'tranName',index:'tranName', hidden:true},
			    {name:'tempDeptName',index:'tempDeptName' , hidden:true},
				{name:'tempTstrName',index:'tempTstrName',align:'center', hidden:true},
			    {name:'testStgeName',index:'tempTestStgeName', hidden:true,summaryType:'count',summaryTpl :'합계 ({0}건)',align:"left"},
			    {name:'tempTranName',index:'tranName' , hidden:true},
			    {name:'tscsExeCnt',index:'tscsExeCnt' , hidden:true,formatoptions:{thousandsSeparator:","}, formatter:'integer',summaryType:'sum',align:"center"},
			    {name:'tscsSucssCnt',index:'tscsSucssCnt' , hidden:true,formatoptions:{thousandsSeparator:","}, formatter:'integer',summaryType:'sum',align:"center"},
			    {name:'tscsMissCnt',index:'tscsMissCnt' , hidden:true,formatoptions:{thousandsSeparator:","}, formatter:'integer',summaryType:'sum',align:"center"},
			    {name:'tscsPercent',index:'tscsPercent' , hidden:true,formatter:'number',summaryType:myAvg,align:"center"},
			    {name:'deptName',index:'deptName' , width:100,align:"center",sortable:true},
				{name:'tstrName',index:'tstrName',align:'center',width:100, sortable:true},
			    {name:'testStgeName',index:'testStgeName', width:100,summaryType:'count',summaryTpl :'합계 ({0}건)',align:"left",sortable:true},
			    {name:'tscsExeCnt',index:'tscsExeCnt' , width:100,formatoptions:{thousandsSeparator:","}, formatter:'integer',summaryType:'sum',align:"center",sortable:true},
			    {name:'tscsSucssCnt',index:'tscsSucssCnt' , width:100,formatoptions:{thousandsSeparator:","}, formatter:'integer',summaryType:'sum',align:"center",sortable:true},
			    {name:'tscsMissCnt',index:'tscsMissCnt' , width:100,formatoptions:{thousandsSeparator:","}, formatter:'integer',summaryType:'sum',align:"center",sortable:true},
			    {name:'tscsPercent',index:'tscsPercent' , width:100,formatter:'number',summaryType:myAvg2,align:"center",sortable:true}];
	}
	return colModel;
}

	function JQGridReload(beUnload){
		if(beUnload){
			$("#list2").jqGrid('GridUnload');
		}
		//setObjLabel();
		var colName = "";
		var colData = "";
		colName = colNameData();
		colData = getColModel();

		jQuery("#list2").jqGrid({
		   	url:tranUrl,
		   	mtype:'POST',    // 한글 인코딩 깨지는 문제 방지하기 위해 POST로 쓴다
		   	postData:getPostData(),
			datatype: '',
		   	colNames:colName,
		   	colModel:colData,
		   	rowNum:-1,
			sortname: 'deptName',
		   	sortorder: 'asc',
		    viewrecords: true,
		    gridView:true,
		    width:'100%',
		    footerrow: true, 
		    userDataOnFooter: true, 
		    afterInsertRow: function(id){
				
			},
		    ondblClickRow: function(rowid, iRow, iCol, e) {
		    	
			    var targetUrl = "msg.exeSts.exeSts.do?";
			    var testStartYMS = $("#testStartYMS").val();
			    var testEndYMS = $("#testEndYMS").val();
			    var projNo = $("#projNo").val();
			    $("#testStgeName").val($("#list2").jqGrid('getCell',rowid,'testStgeName'));       //단위테스트
			    $("#tranCd").val($("#list2").jqGrid('getCell',rowid,'tranCd'));      //거래 코드
			    $("#tstrId").val($("#list2").jqGrid('getCell',rowid,'tstrId')) ;     //테스트ID
			    $("#tranName").val($("#list2").jqGrid('getCell',rowid,'tranName'));  //거래명 
			    
				var returnValue = window.showModalDialog(targetUrl,window,'center:yes;dialogWidth=1150px; dialogHeight=615px; dialogLeft=100px; dialogTop=50px; scroll=no; status=no; help=no; resizable:no;');
			},
			loadComplete:function(xhr){

				 if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
					
				 var tscsExeCntSum = $("#list2").jqGrid('getCol','tscsExeCnt',false,'sum'); //총합 
				 var tscsSucssCntSum = $("#list2").jqGrid('getCol','tscsSucssCnt',false,'sum'); //총합 
				 var tscsMissCntSum = $("#list2").jqGrid('getCol','tscsMissCnt',false,'sum'); //총합 
			     var tscsPercent = "";
				if(tscsExeCntSum != 0 && tscsSucssCntSum != 0){
					tscsPercent = tscsSucssCntSum / tscsExeCntSum * 100;   // 테스트케이스 성공율(%)
					tscsPercent = tscsPercent.toFixed(2); // 소수점 아래 두자리 까지 표현
				}
				$("#list2").tuiTableRowSpan("14,13");
				
				var ids = $("#list2").jqGrid("getDataIDs");
				if(ids.length > 1)  $("#excelBtn").attr('disabled','');
				else if(ids.length < 1) $("#excelBtn").attr('disabled','true');

			    $("#list2").footerData('set',{deptName:'합계', tscsExeCnt:tscsExeCntSum, tscsSucssCnt:tscsSucssCntSum,tscsMissCnt:tscsMissCntSum, tscsPercent:tscsPercent}); // 컬럼name:보여줄 텍스트
			    //reloadGridSize();
			 },
			onRightClickRow: function (rowid, iRow, iCol, e) {//우클릭 브라우져메뉴 block
			},
			jsonReader : {
		    root: "rows",
		    page: "page",
		    total: "total",
		    records: "records",
		    repeatitems: false,
		    cell:false
			},
			grouping: true,
			groupingView : {
				groupField : ['deptName'],
		   		groupColumnShow : [true],
		   		groupText : ['<b>{0}</b>'],
		   		groupCollapse : false,
				groupOrder: ['asc'],
				groupSummary : [true],
				showSummaryOnHide: true,
				groupDataSorted : false
			}
		});

		jQuery("#srch_btn").click(function (){
			
			getList();
		});

		$('#searchGubun').change(function(){

			$('#searchGubun option:selected').each(function(){
				tranUrl = null;
				if($(this).val() == "01"){
				JQGridReload(true);
				}else if($(this).val() == "02"){

				JQGridReload(true);
				} 
				
				$("#excelBtn").attr('disabled','true');
				
			});
			
		});
		
		function resolveAlignmentJqgridBug() {    
			/*     Without the below line, the "jqgfirstrow" has child <TD> for every hidden column.     These <TD>s have non zero width and with "display: none".     Setting the style of these <TD>s to "width: '0px', display: 'block'" resolves the problem. */   
			jQuery(".jqgfirstrow").find(":hidden").css({width: '0px', display: 'block'});  
		}

		$("input,select").keydown(function(e){
			if(e.keyCode == 13){
				getList();
			}
		});

		reloadGridSize();
	
	}
	
// 라인별 PERCENT 구하기.( 성공갯수 * 100 / 총갯수 )	
var a;
var tscsTo = 0;
var tscsSucc = 0;
function myAvg(val,option,rowObj){
	if(rowObj.deptName == a){
		tscsTo += rowObj.tscsExeCnt;
		tscsSucc += rowObj.tscsSucssCnt;
	} else{
		
		tscsTo = 0;
		tscsSucc = 0;
		tscsTo += rowObj.tscsExeCnt;
		tscsSucc += rowObj.tscsSucssCnt;
		
	}
	a = rowObj.deptName;
	return (tscsSucc*100/tscsTo).toFixed(2);
}

//라인별 PERCENT 구하기.( 성공갯수 * 100 / 총갯수 )
var a2;
var tscsTo2 = 0;
var tscsSuc2 = 0;
function myAvg2(val,option,rowObj){
	if(rowObj.deptName == a2){
		tscsTo2 += rowObj.tscsExeCnt;
		tscsSucc2 += rowObj.tscsSucssCnt;
	} else{
		
		tscsTo2 = 0;
		tscsSucc2 = 0;
		tscsTo2 += rowObj.tscsExeCnt;
		tscsSucc2 += rowObj.tscsSucssCnt;
		
	}
	a2 = rowObj.deptName;
	return (tscsSucc*100/tscsTo).toFixed(2);
}

// 조회 버튼 클릭
function getList(){

	tranUrl = "msg.statistics.getDeptTestPrgsSts.do";
	
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
	
	if($("#searchGubun").val() == "01"){
		searchGubun = "01";
	}else if($("#searchGubun").val() == "02"){
		searchGubun = "02";
	}else{
		alert("조회구분을 선택하십시오");
		$("#searchGubun").focus();
		return;
	}
	$('#list2').setGridParam({url:tranUrl,datatype:'json'});
	$('#list2').setGridParam({postData:getPostData()});
	$('#list2').trigger("reloadGrid");
	
}

//엑셀다운로드 
function downExcelDeptTestPrgsSts() { 
	
	if($("#excelBtn").attr('disabled') == true ){
		return;
	}
	
	var fData = $("#list2").footerData('get');
	var callback = function(rowid) {
		var rowdata = new Array();
		rowdata.push($("#list2").getCell(rowid,'tempDeptName'));
		rowdata.push($("#list2").getCell(rowid,'tempTstrName'));
		rowdata.push($("#list2").getCell(rowid,'testStgeName'));
		if($("#searchGubun").val() == "01")
		rowdata.push($("#list2").getCell(rowid,'tempTranName'));
		rowdata.push($("#list2").getCell(rowid,'tscsExeCnt'));
		rowdata.push($("#list2").getCell(rowid,'tscsSucssCnt'));
		rowdata.push($("#list2").getCell(rowid,'tscsMissCnt'));
		rowdata.push($("#list2").getCell(rowid,'tscsPercent'));
		
		return rowdata;
	};
	if($("#searchGubun").val() == "01")       // 테스트 케이스
		gridCustomExportExcel('list2', [0,1,2,3,4,13,14,15,16,17,18,19,20], '부서별 진척현황',callback);
	else if($("#searchGubun").val() == "02")  // 시나리오
		gridCustomExportExcel('list2', [0,1,2,3,4,8,13,14,15,16,17,18,19], '부서별 진척현황',callback);
} 

// get방식 파라메터 얻기.
function getParam(){
	var deptName = $("#deptName").val();
	var connSevrDstcd = $("#connSevrDstcd").val();
	param = 'connSevrDstcd='+connSevrDstcd+'&deptName='+encodeURIComponent(deptName)+'&searchGubun='+$("#searchGubun").val()+'&testStartYMS='+$("#testStartYMS").val()+'&testEndYMS='+$("#testEndYMS").val()+'&projNo='+encodeURIComponent($("#projNo").val());
	return param;
}

// post data 얻기.
function getPostData(){
	var postData = {connSevrDstcd:$("#connSevrDstcd").val(),deptName:$("#deptName").val(),searchGubun:$("#searchGubun").val(),testStartYMS:$("#testStartYMS").val(),testEndYMS:$("#testEndYMS").val(),projNo:$("#projNo").val(),testStgeName:$("#testStgeName2").val()};
	return postData;
}

