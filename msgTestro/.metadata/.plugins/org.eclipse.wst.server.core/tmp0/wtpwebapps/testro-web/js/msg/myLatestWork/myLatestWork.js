var maxWidth= 900;
var leftTemp= 230;
var caseColName = [
                    
            		{name:'lastModfiYMS',index:'lastModfiYMS' ,align:"center", width:120,formatter:gridDateFmatter, formatoptions: {srcformat:'yMdhms', newformat:'y-M-d h:m:s'}, unformat:gridDateUnFmatter,sortable:true,title:false},
            		{name:'objId',index:'objId' , width:120,align:'center',sortable:true,title:false},
               		{name:'acmplnth',index:'acmplnth', width:60,align:"center",sortable:true,title:false},
               		{name:'tranName',index:'tranName', width:180,align:"left",sortable:true,title:false},
               		{name:'objName',index:'objName' , width:230,align:"left",sortable:true,title:false},
               		{name:'tcCount',index:'tcCount' , width:60,align:"center",sortable:true,title:false},
               		{name:'exeYn',index:'exeYn' , width:80,align:"center",sortable:true,title:false},
               		{name:'rsultSucssYn',index:'rsultSucssYn' , width:80,align:"center",sortable:false,title:false},
               		{name:'rsultSucssYnExcl',index:'rsultSucssYnExcl' , hidden:true,title:false}
               		];
var snroColName = [
               		{name:'lastModfiYMS',index:'lastModfiYMS',align:"center" , width:120,formatter:gridDateFmatter, formatoptions: {srcformat:'yMdhms', newformat:'y-M-d h:m:s'}, unformat:gridDateUnFmatter,sortable:true,title:false},
               		{name:'objId',index:'objId' , width:120,align:'center',sortable:true,title:false},
                  	{name:'acmplnth',index:'acmplnth', width:60,align:"center",sortable:true,title:false},
                  	{name:'objName',index:'objName' , width:230,align:"left",sortable:true,title:false},
                  	{name:'tcCount',index:'tcCount' , width:60,align:"center",sortable:true,title:false},
                  	{name:'exeYn',index:'exeYn' , width:80,align:"center",sortable:true,title:false},
                  	{name:'rsultSucssYn',index:'rsultSucssYn' , width:80,align:"center",sortable:false,title:false},
                  	{name:'rsultSucssYnExcl',index:'rsultSucssYnExcl' , hidden:true,title:false}
                  	];
var reportColName = [
               		{name:'reportGubun',index:'reportGubun' , width:100,align:'center',sortable:true,title:false},
               		{name:'cretnYMS',index:'cretnYMS' , width:120,align:'center',formatter:gridDateFmatter, formatoptions: {srcformat:'yMdhms', newformat:'y-M-d h:m:s'}, unformat:gridDateUnFmatter,sortable:true,title:false},
               		{name:'objId',index:'objId' , width:120,align:'center',sortable:true,title:false},
                  	{name:'acmplnth',index:'acmplnth', width:60,align:"center",sortable:true,title:false},
                  	{name:'objName',index:'objName' , width:230,align:"left",sortable:true,title:false},
                  	{name:'tcCount',index:'tcCount' , width:60,align:"center",sortable:true,title:false},
                  	{name:'rsultSucssYn',index:'rsultSucssYn' , width:80,align:"center",sortable:true,title:false},
                  	{name:'rsultSucssYnExcl',index:'rsultSucssYnExcl' , hidden:true,title:false},
                  	{name:'objExeCnt',index:'objExeCnt' , width:70,align:"center",sortable:true,title:false},
                  	{name:'objMissCnt',index:'objMissCnt' , width:70,align:"center",sortable:true,title:false}
                  	];
function getColModel(){
	var Data ="";
	if($("#searchGubun").val() == "01"){
		Data = caseColName;
	}else if($("#searchGubun").val() == "02"){
		Data = snroColName;
		
	}else if($("#searchGubun").val() == "03"){
		Data = reportColName;
		
	}
	return Data;
}
               	

function colNameData(){
	var colName = "";
	if($("#searchGubun").val() == "01"){
		colName = ['작업일시','테스트케이스ID','수행회차','거래명','테스트케이스명','TD개수','실행여부','실행결과','실행결과'];
	}else if($("#searchGubun").val() == "02"){
		colName = ['작업일시','테스트시나리오ID','수행회차','테스트시나리오명','TD개수','실행여부','실행결과','실행결과'];
	}else if($("#searchGubun").val() == "03"){
		colName = ['보고서구분','작업일시','테스트ID','수행회차','테스트명','TD개수','실행결과','실행결과','성공건수','실패건수'];
	}
	
	return colName;
}
var beRightButton = false;
var menuName = "";
function JQGridReload(beUnload){
	if(beUnload){
		$("#list2").jqGrid('GridUnload');
	}
	setObjLabel();
	var colName = "";
	var colData = "";
	colName = colNameData();
	colData = getColModel();
	jQuery("#list2").jqGrid({
	   	url: tranUrl,
	   	postData:getPostData(),
	   	mtype:'POST',    // 한글 인코딩 깨지는 문제 방지하기 위해 POST로 쓴다
		datatype: '',
	   	colNames: colName,
	   	colModel: colData,
	   	rowNum:30,
	   	gridView:true,
	   	rowList:[20,30,50],
	   	pager: '#pager2',
	   	sortname: 'lastModfiYMS',
	   	sortorder: 'desc',
	    viewrecords: true,
	    //width:'100%',
		multiselect: true, //멀티셀렉트 설정 
	    afterInsertRow : function(rowid, rowdata, rowelem) {
			if("성공" == rowdata.rsultSucssYn){
	    		$("#list2").setCellHtml(rowid,'rsultSucssYn',"<IMG src='images/icon_rep_ok.gif' width=34 height=16 hspace='2' vspace='3' align='absmiddle' border=0 >",{});
	    	}else if("실패" == rowdata.rsultSucssYn){
	    		$("#list2").setCellHtml(rowid,'rsultSucssYn',"<IMG src='images/icon_rep_fail.gif' width=34 height=16 hspace='2' vspace='3' align='absmiddle' border=0 >",{});
	    	}
                 
        },
	    ondblClickRow: function(rowid) { 
		    
		},
		loadComplete:function(xhr){
			if (xhr.errCd){
				alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
				return;
			}
			
			if($('#searchGubun').val() == '03'){
				initGrid('myMenu2');
			}else{
				initGrid('myMenu1');
			}
			
			var row = jQuery("#list2").getRowData();  //데이터
			if(row.length > 1){ 
				$("#excelBtn").attr('disabled','');
				$("#delBtn").attr('disabled','');
			
			}
			else if(row.length < 1){
				$("#excelBtn").attr('disabled','true');
				$("#delBtn").attr('disabled','true');
			
			}
			
			reloadGridSize();
		 },
		onCellSelect: function(rowid, index, contents, event) {//checkbox 선택시만 row선택 
				if("0" != index){ 
				$("#list2").jqGrid('setSelection', rowid, false); 
				} 
		},
		onRightClickRow: function (rowid, iRow, iCol, e) {//우클릭 브라우져메뉴 block
			   
			   
		},
		onSelectRow: function (rowid,status){
			
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
	
	$('#list2').mousedown(function(event) {
	});

}

function changeType(val){
	tranUrl = null;
	
	if(val == "01"){
		getListMngCode('subSearch','TC1DIV');
	}else if(val == "02"){
		getListMngCode('subSearch','TS1DIV');
	}else if(val == "03"){
		getListMngCode('subSearch','REDIV');

		
	}
	
	// 조회유형 변경시 엑셀다운로드, 삭제 버튼 비활성 처리.
	$("#excelBtn").attr('disabled','true');
	$("#delBtn").attr('disabled','true');
	
	JQGridReload(true);
	reloadGridSize();
	
}

// get방식 파라메터 값 얻기.
function getParameter(){
		var param = "";
	
		var rsultSucssYn = $("#rsultSucssYn").val();
		
		if(rsultSucssYn == "00"){
			rsultSucssYn = "";
		}else if(rsultSucssYn == "01"){
			rsultSucssYn = "Y";
		}else if(rsultSucssYn == "02"){
			rsultSucssYn = "N";
		}
		param = "rsultSucssYn="+rsultSucssYn+"&searchGubun="+$("#searchGubun").val()+"&subSearch="+$("#subSearch").val()+"&keyword="+encodeURIComponent($("#keyword").val())+"&tstrName="+encodeURIComponent($("#tstrName").val());
		return param;
	
}

// 포스트 데이터 얻기.
function getPostData(){
	var rsultSucssYn = $("#rsultSucssYn").val();
	
	if(rsultSucssYn == "00"){
		rsultSucssYn = "";
	}else if(rsultSucssYn == "01"){
		rsultSucssYn = "Y";
	}else if(rsultSucssYn == "02"){
		rsultSucssYn = "N";
	}
	var postData = {rsultSucssYn:rsultSucssYn,searchGubun:$("#searchGubun").val(),subSearch:$("#subSearch").val(),keyword:$("#keyword").val(),tstrName:$("#tstrName").val(),lastModfiId:userid};
	return postData;
}


// 전역변수
var contextCi;    // cell 인덱스
var contextRowid; // row id
// 마우스 오른쪽 버튼 클릭 팝업 메뉴 초기화
function initGrid(menuName)
{
    jQuery(".jqgrow", "#list2").contextMenu(menuName, {
            bindings: {
                'moveTest': function(t) {
    				moveTest();
                },
                'moveReport': function(t) {
                	 if ($('#moveReport').hasClass('ui-state-disabled') == false) { 
                		 moveReport();   
                	 }
                }
                
            },
            onContextMenu : function(event, menu)
             {	
            	
            	contextRowid = $(event.target).parent("tr").attr("id");
            	if($("#list2").getCell(contextRowid,'acmplnth') == ''){
            		$('#moveReport').attr("disabled","disabled").addClass('ui-state-disabled');
            	}else{
            		$('#moveReport').removeAttr("disabled").removeClass('ui-state-disabled');
            	}
            	
            	var getCellIndex = function (cell) {
            		var c = $(cell);
            		if (c.is('tr')) { return -1; }
            		c = (!c.is('td') && !c.is('th') ? c.closest("td,th") : c)[0];
            		if ($.browser.msie) { return $.inArray(c, c.parentNode.cells); }
            		return c.cellIndex;
            	};
            	
            	contextCi = getCellIndex(event.target);
            	
            var grid = $("#list2");
                return true;                                    
             }
  });             
}

//테스트화면으로 이동.
function moveTest() {
	var objId = $("#list2").getCell(contextRowid,'objId');
	if(getSearchGubun(objId) == "01"){
		frm.action = 'msg.tcmng.tcmng.do';
		$('#tsCaseID').val(objId);
		$.cookie('left_menu', "leftmenu_1_4");
	}else if(getSearchGubun(objId) == "02"){
		frm.action = 'msg.tsmng.tsmng.do';
		$('#tssnroId').val(objId);
		$.cookie('left_menu', "leftmenu_1_5");
	}
	frm.submit();
	
}

// 결과보고서 상세 조회 팝업.
function moveReport() {
	
	var url = "msg.report.reportDetail.do?";
	var gubun,tscaseid,acmplnth,tsdataid,tsdataacmplnth;
	gubun = getSearchGubun($("#list2").getCell(contextRowid,'objId'));
	tscaseid = $("#list2").getCell(contextRowid,'objId');
	acmplnth = $("#list2").getCell(contextRowid,'acmplnth');
	var param = "gubun="+gubun+"&tscaseid="+tscaseid+"&tssnrioid="+tscaseid+"&acmplnth="+acmplnth+"&tsdataid=&tsdataacmplnth=";
	window.open(url+param,"결과상세보고서","location=no,resizable=no,status=no,width=980,height=770");
}

function getSearchGubun(objId){
	var gubun = "";
	if(objId.substr(0,1) == "C" || objId.substr(0,1) == "B"){
		gubun = "01";
	}else if(objId.substr(0,1) == "S"){
		gubun = "02";
	}
	return gubun;
}

$(document).ready(function(){
	// 조회 버튼 클릭
	jQuery("#srchBtn").click(function (){
		getList();
	});
	// 삭제 버튼 클릭
	$("#delBtn").click( function() { //row삭제 
		if($("#delBtn").attr('disabled') == true){
			return;
		}
		
	     var fromArray;//select row 
	     fromArray = jQuery("#list2").jqGrid('getGridParam','selarrrow'); //체크된 리스트 검색 
	     var objIds = [];
	     var acmplnths = [];
	     if( fromArray.length > 0 ){ 
	    	 var conMsg = "";
			 if($('#searchGubun').val() == 01){
				 conMsg = "선택한 테스트케이스를 삭제 하시겠습니까?";
			 }else if($('#searchGubun').val() == 02){
				 conMsg = "선택한 시나리오를 삭제 하시겠습니까?";
			 }else if($('#searchGubun').val() == 03){
				 conMsg = "선택한 결과보고서를 삭제 하시겠습니까?";
			 }
			 var bCon = confirm(conMsg);
			 if(!bCon) return;
	     var i = 0;
	     for(var j = fromArray.length-1; j>=0 ; j--){ 
	     objIds.push($("#list2").getCell(fromArray[j],'objId'));
	     acmplnths.push($("#list2").getCell(fromArray[j],'acmplnth'));
	     
	     jQuery("#list2").delRowData(fromArray[j]);
	     
	     i++;
	     }
	     //삭제 ajax 호출
	      ajaxCall('msg.myLatestWork.deleteMyLatestWork.do', objIds,acmplnths);
	     }else{ 
	     alert("삭제항목을 선택하세요"); 
	     } 
	});
	
	$("input,select").keydown(function(e){
		if(e.keyCode == 13){
			getList();
		}
	});
	
	


});

function ajaxCall(action,objId,acmplnth){
	  jQuery.ajaxSettings.traditional = true;
	$.ajax({
		type : "POST",
		async : true,
		url : action,
		data:{"acmplnths":acmplnth,"objIds":objId,"searchGubun":$('#searchGubun').val()},
		success: function(data){
			alert("삭제를 완료하였습니다.");
		}
	});
}

// 조회버튼 클릭
function getList(){
	tranUrl = "msg.myLatestWork.getListMyLatestWork.do";
	$('#list2').setGridParam({url:tranUrl,datatype:'json',page: 1});
	$('#list2').setGridParam({postData:getPostData()});
	$('#list2').trigger("reloadGrid");
}

// 마우스 오른쪽 버튼 클릭 팝업메뉴 
function getMyMenu(rowid){
	var myMenuName = "myMenu1";
	if($("#searchGubun").val() == "03"){
		myMenuName = "myMenu3";
	}else{
		if($("#list2").getCell(rowid,'acmplnth') == ''){
			myMenuName = "myMenu2";
		}else{
			myMenuName = "myMenu1";
		}
	}
	return myMenuName;
}

function setObjLabel(){
		if($('#searchGubun').val() == '01'){
				$('#objLabel').text('테스트케이스');
		}else if($('#searchGubun').val() == '02'){
			$('#objLabel').text('테스트시나리오');
		}else if($('#searchGubun').val() == '03'){
			$('#objLabel').text('결과보고서');
		}
}

// 엑셀다운로드 버튼 클릭 
function excelDown(){
	if($("#excelBtn").attr('disabled') == true ){
		return;
	}
	if($('#searchGubun').val() == '01'){
		downExcelTscs();
	}else if($('#searchGubun').val() == '02'){
		downExcelSnro();
	
	}else if($('#searchGubun').val() == '03'){
		downExcelRep();
	
	}
	
}
// 엑셀다운로드[결과보고서]
function downExcelRep() { 
	var callback = function(rowid) {
		var rowdata = new Array();
		rowdata.push($("#list2").getCell(rowid,'reportGubun'));
		var defRegYMS = $("#list2").getCell(rowid,'cretnYMS');
		defRegYMS = getDateFormatForExcel(defRegYMS);
		rowdata.push(defRegYMS);
		rowdata.push($("#list2").getCell(rowid,'objId'));
		rowdata.push($("#list2").getCell(rowid,'acmplnth'));
		rowdata.push($("#list2").getCell(rowid,'objName'));
		rowdata.push($("#list2").getCell(rowid,'tcCount'));
		rowdata.push($("#list2").getCell(rowid,'rsultSucssYnExcl'));
		rowdata.push($("#list2").getCell(rowid,'objExeCnt'));
		rowdata.push($("#list2").getCell(rowid,'objMissCnt'));
		
		return rowdata;
	};
	
	gridCustomExportExcel('list2', [6], '결과보고서',callback);
} 
// 엑셀다운로드[시나리오]
function downExcelSnro() { 
	var callback = function(rowid) {
		//alert($("#list2").getCell(rowid,'connSevrDstcd'));
		var rowdata = new Array();
		var defRegYMS = $("#list2").getCell(rowid,'lastModfiYMS');
		defRegYMS = getDateFormatForExcel(defRegYMS);
		rowdata.push(defRegYMS);
		rowdata.push($("#list2").getCell(rowid,'objId'));
		rowdata.push($("#list2").getCell(rowid,'acmplnth'));
		rowdata.push($("#list2").getCell(rowid,'objName'));
		rowdata.push($("#list2").getCell(rowid,'tcCount'));
		rowdata.push($("#list2").getCell(rowid,'exeYn'));
		rowdata.push($("#list2").getCell(rowid,'rsultSucssYnExcl'));
		
		return rowdata;
	};
	
	gridCustomExportExcel('list2', [6], '테스트시나리오',callback);
} 

//엑셀다운로드[테스트케이스]
function downExcelTscs() { 
	var callback = function(rowid) {
		var rowdata = new Array();
		var defRegYMS = $("#list2").getCell(rowid,'lastModfiYMS');
		defRegYMS = getDateFormatForExcel(defRegYMS);
		rowdata.push(defRegYMS);
		rowdata.push($("#list2").getCell(rowid,'objId'));
		rowdata.push($("#list2").getCell(rowid,'acmplnth'));
		rowdata.push($("#list2").getCell(rowid,'tranName'));
		rowdata.push($("#list2").getCell(rowid,'objName'));
		rowdata.push($("#list2").getCell(rowid,'tcCount'));
		rowdata.push($("#list2").getCell(rowid,'exeYn'));
		rowdata.push($("#list2").getCell(rowid,'rsultSucssYnExcl'));
		
		return rowdata;
	};
	
	gridCustomExportExcel('list2', [7], '테스트케이스',callback);
} 


//그리드 리사이즈..
function reloadGridSize(){
	$(window).bind('resize', function() {
		var windwoWindth = $(window).width()-leftTemp;
		if (windwoWindth > maxWidth) {
			$("#list2").setGridWidth(windwoWindth, true);
		} else {
			jQuery("#list2").jqGrid('gridResize',{minWidth:maxWidth ,maxWidth:'100%'});
			$("#list2").setGridWidth(windwoWindth, false);
		}
		var windowHeight = $(window).height()-320;
		$("#list2").setGridHeight(windowHeight, true);
			
	}).trigger('resize');

}


