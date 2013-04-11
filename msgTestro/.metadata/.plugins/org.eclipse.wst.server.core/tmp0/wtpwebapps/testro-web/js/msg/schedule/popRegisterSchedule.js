var opener = window.dialogArguments;
$(document).ready(function(){
	
	var currentDate = getTimeStampYMD();
	
     jQuery("#list").jqGrid({ 
	 url:'msg.schedule.getListTestCase.do', 
	 mtype:'POST', 
	 datatype: "json",
	 colNames:['케이스/시나리오 ID' 
	 ,'구 분'          
	 ,'케이스/시나리오명'
	 ,'케이스/시나리오 설명'
	 ,'등록일시'
	 ], 
	 colModel:[ 
	 {name: 'tsDataId' ,index: 'tsDataId', width: '120', editable:false, align:"left"}, 
	 {name: 'testUnitCd' ,index: 'testUnitCd', width:'100', editable:false, align:"left", formatter:gridCodeFmatter, formatoptions: {cdclMnName:'TES3DIV'}, unformat:gridCodeUnFmatter},
	 {name: 'testName' ,index: 'testName', width: '220', editable:false, align:"left"},
	 {name: 'testDesc' ,index: 'testDesc', width: '240', editable:false, align:"left"},
	 {name: 'cretnYms' ,index: 'cretnYms', width: '120', editable:false, align:"center", formatter:gridDateFmatter, formatoptions: {srcformat:'yMdhms', newformat:'y-M-d h:m:s'}, unformat:gridDateUnFmatter},
	 ], 
	 rownumbers: true,	//scroll paging config 
	 //scroll:0,  
	 rowNum:20,
	 rowList:[20,30,50],
	 pager: '#pager', //record text area 
	 height: 349,
//	 autoHeight: true,
//	 autoWidth: true,
//	 scrollOffset:0,
	 viewrecords: true,
	 sortname: 'cretnYms',
	 sortorder: "desc",
	 editurl:'clientArray',
	 jsonReader : { 
	 root: "rows", 
	 page: "page", 
	 total: "total", 
	 records: "records", 
	 repeatitems: false, 
	 cell: "cell", 
	 id: "tsDataId"
	 },
	 onSelectRow: function(id){
		 var rowData = jQuery("#list").jqGrid('getRowData',id);
		 $('#tsDataId')[0].value = rowData.tsDataId;
		 $('#testName')[0].value = rowData.testName;
		 $('#testDesc')[0].value = rowData.testDesc;
		 $('#testUnitCd')[0].value = rowData.testUnitCd;
		 $('#prevDate')[0].value = currentDate;
		 $('#hour')[0].value = "00";
		 $('#min')[0].value = "00";
	 },
	 onRightClickRow: function (rowid, iRow, iCol, e) {//우클릭 브라우져메뉴 block
	 },
	 loadComplete: function(xhr){
		 $("#list").setGridHeight(350, true);
	 }
	 
	 });
     
     
     getListMngCode('search_testUnitCd','TES3DIV','00');
     getListMngCode('connSevrDstCd','CONNSEVRDSTCD','01');
     
     $("input,select").keydown(function(e){
 		if(e.keyCode == 13){
 			search();
 		}
 	});
     
     
    // 시간, 분 리스트 설정
    for ( var int = 0; int < 24; int++) {
    	var value = "";
    	if (int < 10) {
    		value = "0" + int;
    	} else {
    		value = int+ "";
    	}
    	$('#hour').append("<option value='" + value + "'>" + value + "</option>");
	}
    
    for ( var int = 0; int < 60; int++) {
    	var value = "";
    	if (int < 10) {
    		value = "0" + int;
    	} else {
    		value = int+ "";
    	}
    	$('#min').append("<option value='" + value + "'>" + value + "</option>");
	}
    
    $('#prevDate')[0].value = currentDate;
    
});


function validation() {
	var isValid = true;
	
	if (isNull($('#tsDataId')[0].value) || isNull($('#testName')[0].value) || isNull($('#testDesc')[0].value)) {
		alert("테스트케이스/시나리오 목록을 반드시 선택하셔야 합니다.");
		return false;
	}
	
	var prevDate = $('#prevDate')[0].value; 
	if (isNull(prevDate)) {
		alert("달력을 통해 예약실행 일자를 반드시 선택하셔야 합니다.");
		$('#calendar').trigger('click');
		
		return false;
	}
	
	if(isNull($('input[name="jobResrvCnt"]')[0].value)) {
		alert("테스트 예약실행 설명을 반드시 입력하셔야 합니다.");
		$('input[name="jobResrvCnt"]')[0].focus();
		return false;
	}
	
	if (isNull($('#connSevrDstCd').val())) {
		alert("테스트 대상시스템을 반드시 선택하셔야 합니다.");
		$('#connSevrDstCd').trigger('click');
		
		return false;
	}
	
	return true;
}

function search() {
	var search_testUnitCd;
	var search_tsDataId;
	var search_testName;
	
	// 케이스/시나리오 구분
	var element = $('#search_testUnitCd')[0];
	var optionsArr = element.options;
	for ( i =0; i< optionsArr.length; i++ ) {
		if (optionsArr[i].selected) {
			if (optionsArr[i].value != '00') {
				search_testUnitCd = optionsArr[i].value;
			} else {
				search_testUnitCd = "";
			}
		 }
	}
	
	search_tsDataId = $('#search_tsDataId')[0].value;
	search_testName = $('#search_testName')[0].value;
	
	jQuery("#list").jqGrid('setGridParam',{
		//url:'msg.schedule.getListTestCase.do',
		postData: {
		testUnitCd: search_testUnitCd,
		tsDataId: search_tsDataId,
		testName: search_testName
	}});
	$('#list').trigger('reloadGrid'); 
}

function save() {
	if (!validation()) return;
	//var jobResrvYms = $('#prevDate')[0].value.split('-').join('') + $('#endDate')[0].value.split(':').join('') + '00';
	var jobResrvYms = $('#prevDate')[0].value.split('-').join('') + $('#hour')[0].value + $('#min')[0].value + '00';
	
	$('#jobResrvYms')[0].value = jobResrvYms;
	dataString = $("#form").serialize();
	$.ajax({ 
		 type: "POST",
		 async: true,
		 data:dataString, 
		 url:'msg.schedule.registerSchedule.do', 
		 success: function(data){
		 alert("테스트 예약설정이 저장되었습니다.");
			 if (opener) {
				 window.returnValue=true;
				 window.close();
			} 

		 },
		 error: function (request, status, error) { 
			 alert("테스트 예약설정이 저장중에 오류가 발생하였습니다.[" + error + "]"); 
		 }
	});
}
