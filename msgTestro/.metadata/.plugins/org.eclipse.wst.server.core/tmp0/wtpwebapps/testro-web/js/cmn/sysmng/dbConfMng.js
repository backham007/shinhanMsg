var lastsel; 

$(document).ready(function(){ 
	
    jQuery("#list").jqGrid({ 
	 url:'cmn.sysmng.getListDBConfInfo.do', 
	 mtype:'POST', 
	 datatype: "json", 
	 colNames:['데이터소스명' 
	 ,'type' 
	 ,'transaction'
	 ,'configLocation'
	 ,'jndiName'
	 ,'url'
	 ,'driverClassName'
	 ,'username'
	 ,'password'
	 ,'initialSize'
	 ,'maxActive'
	 ,'maxIdle'
	 ,'minIdle'
	 ,'minEvictableIdleTimeMillis'
	 ,'timeBetweenEvictionRunsMillis'
	 ], 
	 colModel:[ 
	 {name: 'dsName' ,index: 'dsName' , width:320, editable:true, align:"left" ,editoptions:{size:"50",maxlength:"50"}, sortable:false}, 
	 {name: 'type' ,index: 'type' , hidden: true, width:200, editable:false, align:"left", sortable:false},
	 {name: 'transaction' ,index: 'transaction' , hidden: true, width:700, editable:false, align:"left", sortable:false},
	 {name: 'configLocation' ,index: 'configLocation' , hidden: true, width:700, editable:false, align:"left", sortable:false},
	 {name: 'jndiName' ,index: 'jndiName' , hidden: true, width:700, editable:false, align:"left", sortable:false},
	 {name: 'url' ,index: 'url' , hidden: true, width:700, editable:false, align:"left", sortable:false},
	 {name: 'driverClassName' ,index: 'driverClassName' , hidden: true, width:700, editable:false, align:"left", sortable:false},
	 {name: 'username' ,index: 'username' , hidden: true, width:700, editable:false, align:"left", sortable:false},
	 {name: 'password' ,index: 'password' , hidden: true, width:700, editable:false, align:"left", sortable:false},
	 {name: 'initialSize' ,index: 'initialSize' , hidden: true, width:700, editable:false, align:"left", sortable:false},
	 {name: 'maxActive' ,index: 'maxActive' , hidden: true, width:700, editable:false, align:"left", sortable:false},
	 {name: 'maxIdle' ,index: 'maxIdle' , hidden: true, width:700, editable:false, align:"left", sortable:false},
	 {name: 'minIdle' ,index: 'minIdle' , hidden: true, width:700, editable:false, align:"left", sortable:false},
	 {name: 'minEvictableIdleTimeMillis' ,index: 'minEvictableIdleTimeMillis' , hidden: true, width:700, editable:false, align:"left", sortable:false},
	 {name: 'timeBetweenEvictionRunsMillis' ,index: 'timeBetweenEvictionRunsMillis' , hidden: true, width:700, editable:false, align:"left", sortable:false}
	 
	 ], 
	 rownumbers: true,	//scroll paging config 
	 scroll:1,  
	 rowNum:-1,
	 pager: '#pager', //record text area 
	 height:281,
	 viewrecords: true, 
	 
	 editurl:'clientArray', 
	 
	 jsonReader : { 
	 root: "rows", 
	 page: "page", 
	 total: "total", 
	 records: "records", 
	 repeatitems: false, 
	 cell: "cell", 
	 id: "dsName"
	 },
	 ondblClickRow: function(id){ 
		 if(id && id!==lastsel){ 
			 jQuery('#list').jqGrid('restoreRow',lastsel);
		 }
		 jQuery("#list").jqGrid('setSelection',id);
		 jQuery('#list').jqGrid('editRow',id,true);
		 
		 lastsel=id; 
	 },
	 onRightClickRow: function (rowid, iRow, iCol, e) {//우클릭 브라우져메뉴 block
	 },
	 onSelectRow: function(id){
		 
		 if(id && id!==lastsel){ 
			 jQuery('#list').jqGrid('restoreRow',lastsel);
		 }
		 
		 var rowData = jQuery("#list").jqGrid('getRowData', id);
		 
		 typeShowHide(rowData.type);
		 
		 $('#dsName').text(rowData.dsName);
		 
		 var element = $('#type')[0];
		 var optionsArr = element.options;
		 if (!rowData.type) optionsArr[0].selected = true;
		 for ( i =0; i< optionsArr.length; i++ ) {
			 if (optionsArr[i].value == rowData.type ) {
				element.options[i].selected = true;
			 }
		 }
		 
		 element = $('#transaction')[0];
		 optionsArr = element.options;
		 if (!rowData.transaction) optionsArr[0].selected = true;
		 for ( i =0; i< optionsArr.length; i++ ) {
			 if (optionsArr[i].value == rowData.transaction ) {
				element.options[i].selected = true;
			 }
		 }
		 
		 $('#configLocation')[0].value = rowData.configLocation;
		 $('#driverClassName')[0].value = rowData.driverClassName;
		 $('#url')[0].value = rowData.url;
		 $('#username')[0].value = rowData.username;
		 $('#password')[0].value = rowData.password;
		 $('#initialSize')[0].value = rowData.initialSize;
		 $('#maxActive')[0].value = rowData.maxActive;
		 $('#maxIdle')[0].value = rowData.maxIdle;
		 $('#minIdle')[0].value = rowData.minIdle;
		 $('#minEvictableIdleTimeMillis')[0].value = rowData.minEvictableIdleTimeMillis;
		 $('#timeBetweenEvictionRunsMillis')[0].value = rowData.timeBetweenEvictionRunsMillis;
		 lastsel = id;
		 
	 },
	 loadComplete: function(){
		 var rowData = jQuery("#list").jqGrid('getRowData');
		 if (!$('#dsName').text() && rowData.length > 0) {
			 jQuery("#list").jqGrid('setSelection',rowData[0].dsName);
		 }
	 }
	 
	 });
    
    $('#type').change(function() {
    	$("#type option:selected").each(function () {
    		if ($(this).text()=="JDBC") {
    			typeShowHide('jdbc');
    		} else {
    			typeShowHide('jndi');
    		}
         });
    });
});

// row 추가
function addRow() { 
	jQuery('#list').jqGrid('restoreRow',lastsel);
	
    var ids = $("#list").jqGrid('getDataIDs'); //전체리스트의 id리스트 
    var newRowData = { 
    "dsName" : "New Name" 
    ,"type" : "" 
    ,"transaction" : "" 
    ,"configLocation" : "" 
    ,"jndiName" : "" 
    ,"url" : "" 
    ,"driverClassName": "" 
    ,"username" : ""
    ,"password" : ""
    ,"initialSize" : ""
    ,"maxActive" : ""
    ,"maxIdle" : ""
    ,"minIdle" : ""
    ,"minEvictableIdleTimeMillis" : ""
    ,"timeBetweenEvictionRunsMillis" : ""
    }; 
    
    jQuery('#list').jqGrid('addRowData',ids.length+1,newRowData);
    var newIds = $("#list").jqGrid('getDataIDs');
    jQuery("#list").jqGrid('setSelection',newIds[ids.length]);
    jQuery('#list').jqGrid('editRow', newIds[ids.length],true);
    lastsel = newIds[ids.length];
}

// row 삭제
function delRow() { 
	 var selrow = jQuery("#list").jqGrid('getGridParam','selrow'); //체크된 리스트 검색 
	 if (selrow) {
		 jQuery('#list').jqGrid('restoreRow',selrow);
		 var rowData = jQuery("#list").jqGrid('getRowData', selrow);
		 var isConfirm = confirm(rowData.dsName + "를 정말 삭제하시겠습니까?");
		 if (isConfirm) {
			 var postData = JSON.stringify(rowData);
			 $.ajax({ 
				 type: "POST",
				 async: true,
				 data:{"jgGridData":postData}, 
				 url:'cmn.sysmng.deleteDBconfInfo.do', 
				 success: function(data){
				 	jQuery("#list").delRowData(selrow);
			   	 },
			   	 error: function (request, status, error) { 
			   		 alert("삭제중 오류가 발생하였습니다.[" + error + "]"); 
			   	 }
			 });
			 
		 }
	 } else{ 
		 alert("삭제항목을 선택하세요"); 
	 } 
}


//row 저장
function saveRow() { 
	 var selrow = jQuery("#list").jqGrid('getGridParam','selrow'); //체크된 리스트 검색 
	 if (selrow) {
		 jQuery('#list').jqGrid('restoreRow',selrow);
		 var rowData = jQuery("#list").jqGrid('getRowData', selrow);
		 var isConfirm = confirm("데이터소스 [" + rowData.dsName + "]를 저장합니다.\n데이터소스 설정이 초기화되는 과정에서 응답이 지연될 수 있습니다.");
		 if (isConfirm) {
			 
			 var isNotEdited = true;
			 
			 var element = $('#type')[0];
			 var optionsArr = element.options;
			 for ( i =0; i< optionsArr.length; i++ ) {
				 if (optionsArr[i].selected) {
					 
					 if (isNotEdited) {
						 if (rowData.type != optionsArr[i].value) isNotEdited = false;
					 }
					 jQuery("#list").jqGrid('setRowData',selrow,{type:optionsArr[i].value});
				 }
			 }
			 
			 
			 element = $('#transaction')[0];
			 optionsArr = element.options;
			 for ( i =0; i< optionsArr.length; i++ ) {
				 if (optionsArr[i].selected) {
					 
					 if (isNotEdited) {
						 if (rowData.transaction != optionsArr[i].value) isNotEdited = false;
					 }
					 jQuery("#list").jqGrid('setRowData',selrow,{transaction:optionsArr[i].value});
				 }
			 }
			 
			 if (isNotEdited) {
				 if (rowData.configLocation != $('#configLocation')[0].value) isNotEdited = false;
			 }
			 jQuery("#list").jqGrid('setRowData',selrow,{configLocation : $('#configLocation')[0].value});
			 
			 if (isNotEdited) {
				 if (rowData.driverClassName != $('#driverClassName')[0].value) isNotEdited = false;
			 }
			 jQuery("#list").jqGrid('setRowData',selrow,{driverClassName : $('#driverClassName')[0].value});
			 
			 if (isNotEdited) {
				 if (rowData.url != $('#url')[0].value) isNotEdited = false;
			 }
			 jQuery("#list").jqGrid('setRowData',selrow,{url : $('#url')[0].value});
			 
			 if (isNotEdited) {
				 if (rowData.username != $('#username')[0].value) isNotEdited = false;
			 }
			 jQuery("#list").jqGrid('setRowData',selrow,{username : $('#username')[0].value});
			 
			 if (isNotEdited) {
				 if (rowData.password != $('#password')[0].value) isNotEdited = false;
			 }
			 jQuery("#list").jqGrid('setRowData',selrow,{password : $('#password')[0].value});
			 
			 if (isNotEdited) {
				 if (rowData.initialSize != $('#initialSize')[0].value) isNotEdited = false;
			 }
			 jQuery("#list").jqGrid('setRowData',selrow,{initialSize : $('#initialSize')[0].value});
			 
			 if (isNotEdited) {
				 if (rowData.maxActive != $('#maxActive')[0].value) isNotEdited = false;
			 }
			 jQuery("#list").jqGrid('setRowData',selrow,{maxActive : $('#maxActive')[0].value});
			 
			 if (isNotEdited) {
				 if (rowData.maxIdle != $('#maxIdle')[0].value) isNotEdited = false;
			 }
			 jQuery("#list").jqGrid('setRowData',selrow,{maxIdle : $('#maxIdle')[0].value});
			 
			 if (isNotEdited) {
				 if (rowData.minIdle != $('#minIdle')[0].value) isNotEdited = false;
			 }
			 jQuery("#list").jqGrid('setRowData',selrow,{minIdle : $('#minIdle')[0].value});
			 
			 if (isNotEdited) {
				 if (rowData.minEvictableIdleTimeMillis != $('#minEvictableIdleTimeMillis')[0].value) isNotEdited = false;
			 }
			 jQuery("#list").jqGrid('setRowData',selrow,{minEvictableIdleTimeMillis : $('#minEvictableIdleTimeMillis')[0].value});
			 
			 if (isNotEdited) {
				 if (rowData.timeBetweenEvictionRunsMillis != $('#timeBetweenEvictionRunsMillis')[0].value) isNotEdited = false;
			 }
			 jQuery("#list").jqGrid('setRowData',selrow,{timeBetweenEvictionRunsMillis : $('#timeBetweenEvictionRunsMillis')[0].value});
			 
			 
			 if (!isNotEdited) {
				 // 상세창에 있는 값을 그리드로 복사하고 다시 그리드에서 값을 읽어옴
				 rowData = jQuery("#list").jqGrid('getRowData', selrow);
				 
				 var postData = JSON.stringify(rowData);
				 $.ajax({ 
					 type: "POST",
					 async: true,
					 data:{"jgGridData":postData}, 
					 url:'cmn.sysmng.modifyDBConfInfo.do', 
					 success: function(data){
						 alert("데이터소스가 정상적으로 저장되었습니다.");
					 },
					 error: function (request, status, error) { 
						 alert("데이터소스 저장중에 오류가 발생하였습니다.[" + error + "]"); 
					 }
				 });
			 } else {
				 alert("변경된 설정이 없습니다. 다시 확인한 후에 저장하세요.");
			 }
			 
			 
		 }
	 }
}


function typeShowHide(type) {
	if ('jndi'==type) {
		$('#detail TR:eq(4)').css('display', 'none');
		$('#detail TR:eq(5)').css('display', 'none');
		$('#detail TR:eq(6)').css('display', 'none');
		$('#detail TR:eq(7)').css('display', 'none');
		$('#detail TR:eq(8)').css('display', 'none');
		$('#detail TR:eq(9)').css('display', 'none');
		$('#detail TR:eq(10)').css('display', 'none');
		$('#detail TR:eq(11)').css('display', 'none');
		$('#detail TR:eq(12)').css('display', 'none');
		$('#detail TR:eq(13)').css('display', 'none');
		$('#detail TR:eq(14)').css('display', '');
	 } else {
		 $('#detail TR:eq(4)').css('display', '');
		 $('#detail TR:eq(5)').css('display', '');
		 $('#detail TR:eq(6)').css('display', '');
		 $('#detail TR:eq(7)').css('display', '');
		 $('#detail TR:eq(8)').css('display', '');
		 $('#detail TR:eq(9)').css('display', '');
		 $('#detail TR:eq(10)').css('display', '');
		 $('#detail TR:eq(11)').css('display', '');
		 $('#detail TR:eq(12)').css('display', '');
		 $('#detail TR:eq(13)').css('display', '');
		 $('#detail TR:eq(14)').css('display', 'none');
	 }
}

