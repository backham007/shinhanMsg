var leftTemp = 230; //left메뉴사이즈
var maxWidth= 920;

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
	 url:'cmn.sysmng.getListSysConfInfo.do', 
	 mtype:'POST', 
	 datatype: "json", 
	 colNames:['구 분' 
	 ,'환경변수' 
	 ,'변수값' 
	 ], 
	 colModel:[ 
	 {name: 'type' ,index: 'type' , width:80, editable:false, align:"center", sortable:false}, 
	 {name: 'sysEnvVar' ,index: 'sysEnvVar' , width:200, editable:false, align:"left", sortable:false},
	 {name: 'sysEnvVarValue' ,index: 'sysEnvVarValue' , width:640, editable:false, align:"left", sortable:false}
	 ], 
	 rownumbers: true,	//scroll paging config 
	 scroll:1,  
	 rowNum:0,
	 pager: '#pager', //record text area 
	 height:'auto',
	 viewrecords: true, 
	 
	 editurl:'clientArray', 
	 
	 jsonReader : { 
	 root: "rows", 
	 page: "page", 
	 total: "total", 
	 records: "records", 
	 repeatitems: false, 
	 cell: "cell", 
	 id: "sysEnvVar",
	 cellattr: function (rowId, tv, rawObject, cm, rdata) { 
         return 'style="white-space: normal;' 
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


function bodyreload(){
	var hidenYn = $("body").attr("hideYn");
	if("Y" == hidenYn){ //left 메뉴 hidden
		leftTemp=50;
	}else{ //left 메뉴 show
		leftTemp=230;
	}
	$(window).trigger('resize');
}

// 다시 불러오기
function reload() {
	 $.ajax({ 
		 type: "POST", 
		 url:'cmn.sysmng.executeReload.do', 
		 success: function(data){
		 	alert("다시 불러오기가 정상적으로 실행되었습니다."); 
		 	$('#list').trigger('reloadGrid'); 
	   	 },
	   	 error: function (request, status, error) { 
	   		 alert(error); 
	   	 }
	 }); 
}
