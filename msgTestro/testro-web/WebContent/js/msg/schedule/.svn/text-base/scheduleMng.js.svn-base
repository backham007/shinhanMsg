var leftTemp = 230; //left메뉴사이즈
var maxWidth= 1140;
var retvalue;
$(document).ready(function(){
	
     jQuery("#list").jqGrid({ 
	 //url:'msg.schedule.getListSchedule.do', 
	 mtype:'POST', 
	 datatype: "",
	 colNames:['케이스/시나리오 ID' 
	 ,'실행순번'
	 ,'수행회차'
	 ,'구 분' 
	 ,'예약실행설명'
	 ,'예약실행일시'
	 ,'실행상태'
	 ,'실행완료시간'
	 ,'예약작업성공여부'
	 ,'등록일시'
	 ,'등록자'
	 ], 
	 colModel:[ 
	 {name: 'tsDataId' ,index: 'tsDataId', width: '140', title:false, editable:false, align:"left"}, 
	 {name: 'jobSno' ,index: 'jobSno' , hidden:true, title:false, editable:false, align:"left"},
	 {name: 'acmplnTh' ,index: 'acmplnTh' , hidden:true, title:false, editable:false, align:"left"},
	 {name: 'testUnitCd' ,index: 'testUnitCd', width: '100', title:false, editable:false, align:"left", formatter:gridCodeFmatter, formatoptions: {cdclMnName:'TES3DIV'}, unformat:gridCodeUnFmatter},
	 {name: 'jobResrvCnt' ,index: 'jobResrvCnt', width: '200', title:false, editable:false, align:"left"},
	 {name: 'jobResrvYms' ,index: 'jobResrvYms', width: '120', title:false, editable:false, align:"center", formatter:gridDateFmatter, formatoptions: {srcformat:'yMdhms', newformat:'y-M-d h:m'}},
	 {name: 'jobExeStusCd' ,index: 'jobExeStusCd', width: '80', title:false, editable:false, align:"center", formatter:gridCodeFmatter, formatoptions: {cdclMnName:'EXSTAUTS'}},
	 {name: 'jobExeYms' ,index: 'jobExeYms' , width: '120', title:false, editable:false, align:"center", formatter:gridDateFmatter, formatoptions: {srcformat:'yMdhms', newformat:'y-M-d h:m:s'}},
	 {name: 'jobSucssYn' ,index: 'jobSucssYn' , width: '120', title:false, editable:false, align:"center"},
	 {name: 'cretnYms' ,index: 'cretnYms' , width: '120', title:false, editable:false, align:"center", formatter:gridDateFmatter, formatoptions: {srcformat:'yMdhms', newformat:'y-M-d h:m:s'}},
	 {name: 'writeName' ,index: 'writeName' ,  width: '130', title:false, editable:false, align:"left"}
	 ],
	 rownumbers: true,	//scroll paging config 
	 rowNum:30,
	 rowList:[20,30,50],
	 pager: '#pager', //record text area 
	 autoHeight: true,
	 width:'100%',
	 viewrecords: true,
	 sortname: 'cretnYms',
	 sortorder: "desc",
	 multiselect: true, //멀티셀렉트 설정 
	 editurl:'clientArray',
	 jsonReader : { 
	 root: "rows", 
	 page: "page", 
	 total: "total", 
	 records: "records", 
	 repeatitems: false, 
	 cell: "cell", 
	 id: "jobSno"
	 },
	 onCellSelect: function(rowid, index, contents, event) {
		if("1" != index){
			$("#list").jqGrid('setSelection', rowid, false);
		}
	 },
     loadComplete: function(xhr){
		 if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
    	 initGrid();
    	 
    	 reloadGridSize();
	 },
	 afterInsertRow : function(rowid, rowdata, rowelem) {
	         // 1행 생성후 이벤트
		if("Y" == rowdata.jobSucssYn){
		                      //로우id, insert할 cell명, 이미지,{옵션}
		$("#list").setCell(rowid,'jobSucssYn',"성공",{});
		}else if("N" == rowdata.jobSucssYn){
		                      //로우id, insert할 cell명, 이미지,{옵션}
		$("#list").setCell(rowid,'jobSucssYn',"실패",{});
		}
		 
		}
	 });
     
     getListMngCode('testUnitCd','TES3DIV','00');
     getListMngCode('jobExeStusCd','EXSTAUTS','00');
     
     $("input,select").keydown(function(e){
 		if(e.keyCode == 13){
 			search();
 		}
 	});
     
    $("#img_eraser").click(function(){
 		$("#startJobResrvYms").val("");
 		$("#endJobResrvYms").val("");
 	});
    
    $("#img_eraserId").click(function(){
 		$("#tsDataId").val("");
 	});
    
    $("#img_eraserName").click(function(){
 		$("#writeName").val("");
 	});
     
     search();
});


function bodyreload(){
	var hidenYn = $("body").attr("hideYn");
	if("Y" == hidenYn){ //left 메뉴 hidden
		leftTemp=48;
	}else{ //left 메뉴 show
		leftTemp=224;
	}
	$(window).trigger('resize');
}

// 예약등록 팝업 호출
function popRegisterSchedule(theURL,winName) {
	var retvalue = window.showModalDialog(theURL,winName,'center:yes;dialogWidth=890px; dialogHeight=745px; dialogLeft=100px; dialogTop=50px; scroll=no; status=yes; help=no; resizable:no;');
	if (retvalue == true) {
		search();
	}
}

// 전역변수
var contextCi;    // cell 인덱스
var contextRowid; // row id
function initGrid()
{	
    jQuery(".jqgrow", "#list").contextMenu('myMenu1', {
            bindings: {
                'edit': function(e) {
    				var rowData = jQuery("#list").jqGrid('getRowData', contextRowid);
    				var tsDataId = rowData.tsDataId;
    				var jobSno = rowData.jobSno;
    				var retvalue = window.showModalDialog('msg.schedule.popModifySchedule.do?tsDataId='+tsDataId+'&jobSno='+jobSno, '테스트예약설정','center:yes;dialogWidth=700px; dialogHeight=278px; dialogLeft=100px; dialogTop=50px; scroll=no; status=no; help=no; resizable:no;');
    				if (retvalue == true) {
    					search();
    				}
    				
    				
//    				MM_openBrWindow('msg.schedule.popModifySchedule.do?tsDataId='+tsDataId+'&jobSno='+jobSno ,'테스트예약설정','status=yes,width=700,height=252');
    				
                },
                'viwreport': function(t) {
                	var rowData = jQuery("#list").jqGrid('getRowData',contextRowid);
                	
                	if (rowData.jobSucssYn=='실패') {
                		alert("해당 예약목록은 실행 중 오류가 발생하여 결과보고서를 조회할 수 없습니다.");
                		return;
                	}
                	
                	
                	if (!rowData.acmplnTh || rowData.acmplnTh==0) {
                		alert("실행이 안된 테스트 예약목록 입니다.");
                		return;
                	}
                		
                	var param = "gubun=" + rowData.testUnitCd; //구분(01:테스트케이스, 02:시나리오)
                	
                	param    += "&tscaseid=" + rowData.tsDataId; //테스트케이스ID
                	param    += "&tssnrioid=" + rowData.tsDataId; //테스트시나리오ID
                	param    += "&acmplnth=" + rowData.acmplnTh; //수행회차
                	
                	var url = "msg.report.reportDetail.do?";
                	window.open(url+param,"결과상세보고서","location=no,resizable=no,status=no,width=980,height=770"); 
                }
            },
            onContextMenu : function(event, menu)
             {	
            	
            	var getCellIndex = function (cell) {
            		var c = $(cell);
            		if (c.is('tr')) { return -1; }
            		c = (!c.is('td') && !c.is('th') ? c.closest("td,th") : c)[0];
            		if ($.browser.msie) { return $.inArray(c, c.parentNode.cells); }
            		return c.cellIndex;
            	};
            	
            	contextCi = getCellIndex(event.target);
            	contextRowid = $(event.target).parent("tr").attr("id");
            	
            	
            	var rowData = jQuery("#list").jqGrid('getRowData',contextRowid);
            	
            	if (!rowData.acmplnTh || rowData.acmplnTh==0 || rowData.jobSucssYn=='실패') {
            		$('#viwreport').attr("disabled","disabled").addClass('ui-state-disabled');
            	} else {
            		$('#viwreport').removeAttr("disabled").removeClass('ui-state-disabled');
            	}
                return true;                                    
             }
  });             
}

function deleteRow() {
	var fromArray;//select row 
	fromArray = jQuery("#list").jqGrid('getGridParam','selarrrow'); //체크된 리스트 검색 
	
	var rows = new Array();
	
	if( fromArray.length > 0 ){ 
		for(var j = fromArray.length-1; j>=0 ; j--){
			var rowData = jQuery("#list").jqGrid('getRowData',fromArray[j]);
			rows.push({tsDataId: rowData.tsDataId, jobSno: rowData.jobSno});
		} 
	}else{ 
		alert("삭제항목을 선택하세요");
		return;
	}
	
	var result = confirm("선택한 테스트 예약설정을 정말 삭제하겠습니까?");
	if (!result) return;
	
	
	 var postData = JSON.stringify(rows);
	
	$.ajax({ 
		 type: "POST",
		 async: true,
		 data:{"jgGridData":postData},
		 url:'msg.schedule.deleteSchedule.do', 
		 success: function(data){
			 if (data.errCd) alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
			 $('#list').trigger('reloadGrid');
		 },
		 error: function (request, status, error) { 
			 alert("테스트 예약설정 삭제중에 오류가 발생하였습니다.[" + error + "]"); 
		 }
	 });
	
}


function search() {
	var testUnitCd;
	var tsDataId;
	var jobExeStusCd;
	var startJobResrvYms;
	var endJobResrvYms;
	var writeName;
	
	// 케이스/시나리오 구분
	var element = $('#testUnitCd')[0];
	var optionsArr = element.options;
	for (var i =0; i< optionsArr.length; i++ ) {
		if (optionsArr[i].selected) {
			if (optionsArr[i].value != '00') {
				testUnitCd = optionsArr[i].value;
			} else {
				testUnitCd = "";
			}	
		 }
	}
	
	// 케이스/시나리오 ID
	tsDataId = $('#tsDataId')[0].value;
	
	// 실행상태
	element = $('#jobExeStusCd')[0];
	optionsArr = element.options;
	for ( i =0; i< optionsArr.length; i++ ) {
		if (optionsArr[i].selected) {
			if (optionsArr[i].value != '00') {
				jobExeStusCd = optionsArr[i].value;
			} else {
				jobExeStusCd = "";
			}	
		 }
	}
	
	// 시작실행일자
	startJobResrvYms = $('#startJobResrvYms')[0].value;
	
	if (startJobResrvYms) {
		startJobResrvYms = startJobResrvYms.split('-').join('')+'000000';
	}
	
	// 마지막실행일자
	endJobResrvYms = $('#endJobResrvYms')[0].value;
	if (endJobResrvYms) endJobResrvYms = endJobResrvYms.split('-').join('')+'000000';
	
	// 등록자
	writeName = $('#writeName')[0].value;
	
	jQuery("#list").jqGrid('setGridParam',{
	url: 'msg.schedule.getListSchedule.do',
	datatype: "json",
	postData: {
		testUnitCd: testUnitCd,
		tsDataId: tsDataId,
		jobExeStusCd: jobExeStusCd,
		startJobResrvYms: startJobResrvYms,
		endJobResrvYms: endJobResrvYms,
		writeName: writeName
	}});
	$('#list').trigger('reloadGrid'); 
}

//그리드 리사이즈..
function reloadGridSize(){
	$(window).bind('resize', function() {
		var windwoWindth = $(window).width()-leftTemp;
		if (windwoWindth > maxWidth) {
			$("#list").setGridWidth(windwoWindth, true);
		} else {
			jQuery("#list").jqGrid('gridResize',{minWidth:maxWidth ,maxWidth:'100%'});
			$("#list").setGridWidth(windwoWindth, false);
		}
		var windowHeight = $(window).height()-320;
		$("#list").setGridHeight(windowHeight, true);
			
	}).trigger('resize');

}

