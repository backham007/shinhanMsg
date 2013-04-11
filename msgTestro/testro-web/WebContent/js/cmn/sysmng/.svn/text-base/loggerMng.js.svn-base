var leftTemp = 230; //left메뉴사이즈
var maxWidth= 970;

$(document).ready(function(){ 
	
	$(window).bind('resize', function() {
		var windwoWindth = $(window).width()-leftTemp;
		if (windwoWindth > maxWidth) {
			$("#list").setGridWidth(windwoWindth, true);
		} else {
			jQuery("#list").jqGrid('gridResize',{minWidth:maxWidth ,maxWidth:'100%'});
			$("#list").setGridWidth(windwoWindth, false);
		}
		
		var windowHeight = $(window).height()-240;           // 마이너스값 수정. 
		$("#list").setGridHeight(windowHeight, true);
			
	}).trigger('resize');
	
	var lastsel; 
    jQuery("#list").jqGrid({ 
	 url:'cmn.sysmng.getListLoggerInfo.do', 
	 mtype:'POST', 
	 datatype: "json", 
	 colNames:['로그명' 
	 ,'로그파일경로' 
	 ,'로그레벨' 
	 ,'적 용' 
	 ,'기본레벨'
	 ,'hidden'
	 ], 
	 colModel:[ 
	 {name: 'logName' ,index: 'logName' , width:180, editable:false, align:"left", sortable:false}, 
	 {name: 'logFilePath' ,index: 'logFilePath' , width:500, editable:false, align:"left", sortable:false}, 
	 {name: 'logLevel' ,index: 'logLevel' , width:100, editable:true, align:"center" , formatter:'select',edittype:"select",
		 editoptions:{value:"TRACE:TRACE;DEBUG:DEBUG;INFO:INFO;ERROR:ERROR;FATAL:FATAL"}},
	 {name: 'apply' ,index: 'apply' , width:70, editable:true, edittype:"button", editoptions:{value:"적 용", 
			 dataEvents: [{type:'click', fn:function(e){modifyLevel(e);}}]}, align:"center", sortable:false}, 
	 {name: 'baseLogLevel' ,index: 'baseLogLevel' , width:100, editable:false, align:"center", sortable:false},
	 {name: 'orgLogLevel' ,index: 'orgLogLevel' , hidden: true, width:100, editable:false, align:"center", sortable:false}
			 
			 
	 ], 
	 rownumbers: true, 
	 scroll:-1,  
	 rowNum:0,
	 pager: '#pager', //record text area 
	 autoWidth: true,
	 autoHeight: true,
	 viewrecords: true, 
	 editurl:'clientArray', 
	 jsonReader : { 
	 root: "rows", 
	 page: "page", 
	 total: "total", 
	 records: "records", 
	 repeatitems: false, 
	 cell: "cell", 
	 id: "logName" 
	 },
	 onSelectRow: function(id){ 
		 if(id && id!==lastsel){ 
			 jQuery('#list').jqGrid('restoreRow',lastsel);
		 }
		 jQuery('#list').jqGrid('editRow',id,true);
		 lastsel=id; 
		},
	 loadComplete: function(){
			
			var rowData = jQuery("#list").jqGrid('getRowData');
			
			for (var i=0; i<rowData.length; i++) {
				if (rowData[i].logLevel != rowData[i].orgLogLevel) {
					jQuery("#list").jqGrid('setRowData',rowData[i].logName,{baseLogLevel:"<font color='red'>"+ rowData[i].orgLogLevel +"</font>"});
				}
			}
			
	 },
	 onRightClickRow: function (rowid, iRow, iCol, e) {//우클릭 브라우져메뉴 block
	 }
	 });
    
    var windwoWindth = $(window).width()-leftTemp;
	if (windwoWindth > maxWidth) {
		$("#list").setGridWidth(windwoWindth, true);
	} else {
		jQuery("#list").jqGrid('gridResize',{minWidth:maxWidth ,maxWidth:'100%'});
		$("#list").setGridWidth(windwoWindth, false);
	}
	
	var windowHeight = $(window).height()-240;           // 마이너스값 수정. 
	$("#list").setGridHeight(windowHeight, true);
    
});

// 로거 수정
function modifyLevel(e) {
	var selr = jQuery('#list').jqGrid('getGridParam','selrow');
	var preRowData = jQuery("#list").jqGrid('getRowData',selr);
	jQuery('#list').jqGrid('saveRow',selr);
	jQuery('#list').jqGrid('restoreRow',selr);
	var rowData = jQuery("#list").jqGrid('getRowData',selr);
	if (rowData.logLevel != rowData.orgLogLevel) {
		jQuery("#list").jqGrid('setRowData',selr,{baseLogLevel:rowData.orgLogLevel});
	} else {
		jQuery("#list").jqGrid('setRowData',selr,{baseLogLevel:""});
	}
	jQuery("#list").jqGrid('setRowData',selr,{apply:""});
	
	var postData = JSON.stringify(rowData);
	
	$.ajax({ 
	   	 type: "POST",
	   	 url:'cmn.sysmng.modifyLoggerLevel.do', 
	   	 data:{"jgGridData":postData}, 
	   	 success: function(data){
		   	 alert("로그레벨이 정상적으로 적용되었습니다."); 
	   	 },
	   	 error: function() {
             alert("로그레벨이 정상적으로 적용에 오류가 발생하였습니다.");
        }
   	 }); 
}


function bodyreload(){
	var hidenYn = $("body").attr("hideYn");
	if("Y" == hidenYn){ //left 메뉴 hidden
		leftTemp=50;
	}else{ //left 메뉴 show
		leftTemp=230;
	}
	$(window).trigger('resize');
}
