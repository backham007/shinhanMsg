<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>전문 테스트로(TESTRO)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="jqgrid/css/ui-lightness/jquery-ui-1.7.3.custom.css" media="screen" />
<link rel="stylesheet" type="text/css" href="jqgrid/js/src/css/ui.jqgrid.css" media="screen" />
<link rel="stylesheet" type="text/css" href="jqgrid/themes/ui.datepicker.css" media="screen" />
<link rel="shortcut icon" href="images/TESTRO.ico" type="image/ico" />
<style>
html, body {
    margin: 0;
    padding: 0;
    font-size: 75%;
}
</style>
<script type="text/javascript" src="js/cmn/utils/json2.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/jquery-1.5.2.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/jquery.blockUI.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/src/i18n/grid.locale-en.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/jquery.jqGrid.src.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/ui.datepicker.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/popupcalendar.js"></script>
<script type="text/javascript">
//JQ그리드 그리기
//저장 여부 변수
var saveDivision = false;
//그리드 데이터 변경 여부 변수
var changeGrid = false;
//필드 번호를 위한 변수
var fldNum = "";

var lastsel2;
var lastsel3;

$(document).ready(function(){
	var maxWidth= 700;
	$(window).bind('resize', function() {
		var windwoWindth = $(window).width()-35;
		if (windwoWindth > maxWidth) {
			$("#list1").setGridWidth(windwoWindth, true);
		} else {
			jQuery("#list1").jqGrid('gridResize',{minWidth:maxWidth ,maxWidth:'100%'});
			$("#list1").setGridWidth(windwoWindth, false);
		}
			
	}).trigger('resize');
	var maxWidth= 700;
	$(window).bind('resize', function() {
		var windwoWindth = $(window).width()-35;
		if (windwoWindth > maxWidth) {
			$("#list2").setGridWidth(windwoWindth, true);
		} else {
			jQuery("#list2").jqGrid('gridResize',{minWidth:maxWidth ,maxWidth:'100%'});
			$("#list2").setGridWidth(windwoWindth, false);
		}
			
	}).trigger('resize');
	$("#rowDelete").attr("disabled",true);
	$("#rowInsert").attr("disabled",true);
	$("#rowUp").attr("disabled",true);
	$("#rowDown").attr("disabled",true);
	
	jQuery("#list1").jqGrid({
		url: 'msg.searchList.usrinputdatamng.do',
		mtype:'POST',    // 한글 인코딩 깨지는 문제 방지하기 위해 POST로 쓴다
		datatype: "json",
		colNames:['순번','필드명', '작성자', '작성자ID','신규확인'],
	   	colModel:[
	   		{name:'fldId',index:'FLDID', width:70, align:"center", hidden:true}, //hideen
	   		{name:'fldName',index:'FLDNAME', width:305, editable:true, align:"center",sortable:true,editoptions:{maxlength:100, style:"text-align:center"}},
	   		{name:'writeName',index:'WRITENAME', width:140, align:"center",sortable:true},
	   		{name:'writeId',index:'WRITEID', width:110, align:"center",sortable:true},
	   		{name:'newInsert',index : 'NEWINSERT',width : 100, align : "center", hidden:true} //hideen
	   	],
	   	gridview: true,
	   	rownumbers: true,//리스트 seq 사용 여부 
		scroll:1, //scroll paging config 
		rowNum:10, //scroll paging config 
		pager: '#pager1', //record text area 
	   	rowNum:100,
	    viewrecords: true,
	    editurl:'clientArray',
	    loadComplete: function(xhr){
        	if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
		},
	    jsonReader : {
	        root: "rows",
	        page: "page",
	        total: "total",
	        records: "records",
	        repeatitems: false,
	        cell: "cell"
	    },
    	ondblClickRow: function(rowid, iRow, iCol, e) { //1.더블클릭 이벤트( 로우 데이터 가져오기)
	    	var ret = jQuery("#list1").getRowData(rowid);	
	    	if("0" != iCol){ // 싱글선택:0 , 멀티선택:0,1
				jQuery('#list1').jqGrid('editRow',rowid, true);	
				$("input, select",e.target).focus();   					// 포커스위치 설정		
			}
	    	lastsel2=rowid;
	    	saveDivision = true;
   			
		},
		onSelectRow: function(id){ 
			/* editCheck =$("#list1").find("input[type=text], textarea").map(function(){ 
   			return $(this).attr("name"); 
   			}).get(); 
   			if( "" != editCheck){ 
   				alert("수정완료후다른 행을 선택하세요."); 
   			return; 
   			}else{ */
   				
   				$("#list1").jqGrid("saveRow",lastsel2);
				$("#list2").jqGrid("saveRow",lastsel3);
			
				if(id == lastsel2) return;
				
   				var dstCd1;
   				var cklst= jQuery("#list1").jqGrid('getGridParam','selrow'); //체크된 리스트
   				
   				if(cklst != 1){
	   				if( cklst != "" ){
	   					if( cklst.length > 0 ) { 
	   						var array1 = new Array();
	   						var array2 = new Array();
	   						var totalarray = new Array();
							var ret1 = jQuery("#list1").getRowData(cklst);
							dstCd1 = ret1.fldName;
	   					}
	   				}
	   				$("#filName").html(dstCd1);
	   				$(document).unbind("ajaxStart").unbind("ajaxStop");
					doDetailSearch();	
					$(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);
   				}
   				
   				lastsel2 = id;
   			/* } */
    	},
    	onRightClickRow: function (rowid, iRow, iCol, e) { 
   		}
	});
	//jQuery("#list1").jqGrid('navGrid','#pager1',{edit:false,add:false,del:false,search:false});
	jQuery("#list2").jqGrid({
		datatype: "json",
	   	colNames:['fldId순번','순번','필드데이터','세션이름','세션아이디','신규확인'],
	   	colModel:[
			{name:'fldId',index:'FLDID', width:80, align:"center", hidden:true},  	//hideen
	   		{name:'outptseqNo',index:'OUTPTSEQNO', width:80, align:"center", key:true, hidden:true},
	   		{name:'dtailFldName',index:'DTAILFLDNAME', width:540, editable:true, align:"center",sortable:false,editoptions:{maxlength:100, style:"text-align:center"}},
	   		{name:'writeName',index:'WRITENAME', width:100, align:"center", hidden:true},//hideen
	   		{name:'writeId',index:'WRITEID', width:140, align:"center", hidden:true},//hideen
	   		{name:'newInsert',index : 'NEWINSERT',width : 100, align : "center", hidden:true} //hideen
	   	],
	   	gridview: true,
	   	rownumbers: true,//리스트 seq 사용 여부 
	   	scroll:1, //scroll paging config 
		rowNum:10, //scroll paging config 
		pager: '#pager2', //record text area 
	   	sortname: 'OUTPTSEQNO',
	    viewrecords: true,
	    sortorder: "asc",
		multiselect: true,
		scrollrows : true, //포커스이동시 스크롤 자동맞춤.,
	    editurl:'clientArray',
	    loadComplete: function(xhr) {
			if (xhr.errCd){ 
				alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
			}
		},
	    jsonReader : {
	        root: "rows",
	        page: "page",
	        total: "total",
	        records: "records",
	        repeatitems: false,
	        cell: "cell",
	        id: "OUTPTSEQNO"
	    },
	    ondblClickRow: function(rowid, iRow, iCol, e) { //1.더블클릭 이벤트( 로우 데이터 가져오기)
	    	/* editCheck =$("#list2").find("input[type=text], textarea").map(function(){ 
   			return $(this).attr("name"); 
   			}).get(); 
   			if( "" != editCheck){ 
   				alert("수정완료후다른 행을 선택하세요."); 
   			return; 
   			}else{ */
   				
   				$("#list1").jqGrid("saveRow",lastsel2);
				$("#list2").jqGrid("saveRow",lastsel3);
			
		    	var ret = jQuery("#list2").getRowData(rowid);
		    	if("1" != iCol){ // 싱글선택:0 , 멀티선택:0,1
					jQuery('#list2').jqGrid('editRow',rowid,true);	
					$("input, select",e.target).focus();   					// 포커스위치 설정		
				} 
				var editCheck = ""; 		
		    	lastsel3=rowid;
		    	saveDivision = true; 
   			/* } */			
		},
		onCellSelect: function(rowid, index, contents, event) {//checkbox 선택시만 row선택 
			if("1" != index){ 
				$("#list2").jqGrid('setSelection', rowid, false); 
				$("#list2").jqGrid("saveRow",lastsel3);
			} 
		},
		onRightClickRow: function (rowid, iRow, iCol, e) { 
   		}
	});
	//jQuery("#list2").jqGrid('navGrid','#pager2',{edit:false,add:false,del:false,search:false});

	//조회
	$("#listSearch").click( function() {
		if(saveDivision == false){
			
			$("#filName").text("");
			//버튼 처리
			$("#rowDelete").attr("disabled",true);
			$("#rowInsert").attr("disabled",true);
			$("#rowUp").attr("disabled",true);
			$("#rowDown").attr("disabled",true);
			
			var nameCheck = $("#userInptFldName").css("color");			//조회시 체크해야할 값
			var userInptFldName;
			if(nameCheck == "#ababab" && nameCheck != "rgb(171, 171, 171)"){									//색이 #ababab일 경우 없다고 생각하고 조회
				userInptFldName = "";
			}else{														//입력값으로 조회
				userInptFldName = $("#userInptFldName").val();		//필드명
			}
			var writPnm = $("#writPnm").val();					//작성자
			$('#list1').setGridParam({
				url:'msg.searchList.usrinputdatamng.do',
				postData: {
					fldName: userInptFldName,
					writeName: writPnm
				}
			});
			$('#list1').trigger("reloadGrid");
			
			var ids = $("#list2").getDataIDs();
			for(var i=0, n=ids.length; i<n; i++){
				jQuery("#list2").delRowData(ids[i]); 	
			}
		}else{
			if (confirm("저장 하시겠습니까?")){
				allSave(1);							//저장후에 조회
			}else{
				doSearch();							//그냥 조회
			}
			
		}
	});
	$("#dedata").click( function() {				//신규 버튼
		if(saveDivision == false){
			var ids = $("#list1").getDataIDs();
			for(var i=0, n=ids.length; i<n; i++){			//list1행 모두 삭제
				jQuery("#list1").delRowData(ids[i]); 	
			}
			var ids = $("#list2").getDataIDs();
			for(var i=0, n=ids.length; i<n; i++){			//list2행 모두 삭제
				jQuery("#list2").delRowData(ids[i]); 	
			}
			//행 추가
			$("#list1").jqGrid('addRowData',1,{fldId:"1",fldName:"",writeName:"${sessionScope.userinfo.usrname}",writeId:"${sessionScope.userinfo.usrid}",newInsert:"true"});
			//세션값 담아주기
			//$("#writPnm").val("${sessionScope.userinfo.usrname}");
			//버튼 활성화 
			$("#rowDelete").attr("disabled",true);
			$("#rowInsert").attr("disabled",true);
			$("#rowUp").attr("disabled",true);
			$("#rowDown").attr("disabled",true);
			
		}else{
			if (confirm("저장 하시겠습니까?")){
				allSave(2);							//저장후 신규 생성
			}else{
				basicNew();							//그냥 리셋후 신규로 생성
			}
		}
	}); 
	doSearch();
	//입력에 ==전체== 값을 주고 포커스 해줄경우 사라지게 하기
	$('#userInptFldName').attr('value','== 전체 ==')
	.css({'color':'#ababab'})
	.focus(function(){
		if(this.value == '== 전체 =='){
			this.value = '';
			this.style.color = '#000';
		} 		   
	})
	.blur(function(){
		if(this.value == ''){
			this.style.color = '#ababab';
			this.value = '== 전체 ==';
		}  
	});
	$("#listSearch").focus();
});
// iframe resize
function autoResize(i)
{
    var iframeHeight=
    (i).contentWindow.document.body.scrollHeight;
    (i).height=iframeHeight+20;
}
//작성자 클리어 버튼
function doClear(){ 
	document.frmNm.writPnm.value = "" ;
}
//사용자 입력데이터 기본 조회
function doSearch(){
	$("#filName").text("");
	//버튼 처리
	$("#rowDelete").attr("disabled",true);
	$("#rowInsert").attr("disabled",true);
	$("#rowUp").attr("disabled",true);
	$("#rowDown").attr("disabled",true);
	
	var nameCheck = $("#userInptFldName").css("color");			//조회시 체크해야할 값
	var userInptFldName;
	if(nameCheck == "#ababab" && nameCheck != "rgb(171, 171, 171)"){									//색이 #ababab일 경우 없다고 생각하고 조회
		userInptFldName = "";
	}else{														//입력값으로 조회
		userInptFldName = $("#userInptFldName").val();		//필드명
	}
	var writPnm = $("#writPnm").val();							//작성자
	$('#list1').setGridParam({
	    url:'msg.searchList.usrinputdatamng.do',
	    postData: {
	    	fldName: userInptFldName,
	    	writeName: writPnm
        }
	});
	$('#list1').trigger("reloadGrid");
	//상세 데이터 삭제
	var ids = $("#list2").getDataIDs();
	for(var i=0, n=ids.length; i<n; i++){
		jQuery("#list2").delRowData(ids[i]); 	
	}
	saveDivision = false;
	$("#listSearch").focus();						//조회후 포커스 처리
}
//상세 데이터 조회
function doDetailSearch(){

	var par = "";
	var select = jQuery("#list1").getGridParam("selrow");
	var rows= jQuery("#list1").jqGrid('getRowData',select);
	
	var fldId = rows.fldId;
	fldNum = fldId;	
	$('#list2').setGridParam({url:'msg.detailSearchList.usrinputdatamng.do',
		postData: {
			fldId: fldId
    	}
    });
	$('#list2').trigger("reloadGrid");
	//버튼 처리
	$("#rowDelete").attr("disabled",false);
	$("#rowInsert").attr("disabled",false);
	$("#rowUp").attr("disabled",false);
	$("#rowDown").attr("disabled",false);

}
//신규 행 추가
function basicNew(){
	$("#filName").text("");
	//버튼 처리
	$("#rowDelete").attr("disabled",true);
	$("#rowInsert").attr("disabled",true);
	$("#rowUp").attr("disabled",true);
	$("#rowDown").attr("disabled",true);
	//조회 삭제
	var ids = $("#list1").getDataIDs();
	for(var i=0, n=ids.length; i<n; i++){
		jQuery("#list1").delRowData(ids[i]); 	
	}
	//상세 데이터 삭제
	var ids = $("#list2").getDataIDs();
	for(var i=0, n=ids.length; i<n; i++){
		jQuery("#list2").delRowData(ids[i]); 	
	}
	$("#list1").jqGrid('addRowData',1,{fldId:"01",fldName:"",writeName:"${sessionScope.userinfo.usrname}",writeId:"${sessionScope.userinfo.usrid}",newInsert:"true"});
	//$("#writPnm").val("${sessionScope.userinfo.usrname}");			//writPnm 세션값 입력
}
function saveCheck(){
	if(confirm("저장하시겠습니까?")){
		allSave(3);
	}
}
//데이터 저장
function allSave(str){
	//$("#filName").text("");
	var ids = $("#list1").getDataIDs();
	var num = "";
	var alretMng ="";
	for(var i=0, n=ids.length; i<n; i++){
		var ret = jQuery("#list1").getRowData(ids[i]);
		if(ret.fldName  == ""){
			num = i + 1;
			alretMng = num + "번째 필드명을 입력해 주세요.";
			alert(alretMng);
			return false;
		}
	}
	var rows = jQuery("#list2").jqGrid('getRowData');
	if(ids.length != 0){
		/* editCheck =$("#list1").find("input[type=text], textarea").map(function(){ 
		return $(this).attr("name"); 
		}).get(); 
		editCheck2 =$("#list2").find("input[type=text], textarea").map(function(){ 
		return $(this).attr("name"); 
		}).get(); 
		if( "" != editCheck){ 
			alert("수정완료후 저장하세요."); 
			return; 
		}else{
			if( "" != editCheck2){ 
				alert("수정완료후  저장하세요."); 
				return; 
			}else{ */
				
				$("#list1").jqGrid("saveRow",lastsel2);
				$("#list2").jqGrid("saveRow",lastsel3);
				
				var ids = $("#list1").getDataIDs();
				var newInsertCheck = 0;
				for(var i=0, n=ids.length; i<n; i++){
					var ret = jQuery("#list1").getRowData(ids[i]);
					if(ret.newInsert  == "true"){
						newInsertCheck = 1;
					}
				}
				//기존 있을 경우
				if(newInsertCheck == 0){
					var gridData= jQuery("#list1").jqGrid('getRowData');
					var postData = JSON.stringify(gridData);
					$.ajax({
				        type:"POST",
						data:{"jgGridData":postData},
				        dataType:"json",
				        async : true,
				        url:"msg.insertList.usrinputdatamng.do",
				        success:function(data, status) {
				        	if (data.errCd){
					        	alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
				        	}else{
						        if(rows == 0){
							        if(str ==1){
							        	alert("저장 되었습니다.");
							        	doSearch();
							        }else if(str == 2){
							        	alert("저장 되었습니다.");
							        	basicNew();
							        }else{
							        	alert("저장 되었습니다.");
							        }
						        }else{
						        	datailGridSave();
						        }  
				        	}
				        },
				        error:function(request, status, error) {
				        	alert("저장중 오류가 발생하였습니다.[" + error + "]"); 
				        	return false;
				        }
				    });
				//신규 일 경우
				}else{
					var ret = jQuery("#list1").getRowData(ids[0]);
					if(ret.fldName  == ""){
						alert("필드 명을 입력해 주세요.");
						return false;
					}
					var gridData= jQuery("#list1").jqGrid('getRowData');
					var postData = JSON.stringify(gridData);
					$.ajax({
				        type:"POST",
						data:{"jgGridData":postData},
				        dataType:"json",
				        async : true,
				        url:"msg.newinsertList.usrinputdatamng.do",
				        success:function(data, status) {
				        	if (data.errCd){
					        	alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
				        	}else{
						        alert("저장하였습니다.");
						        var fidId = data.fidId;
						        reSearch(fidId);
						        //alert("데이터 필드를 입력하세요");
				        	}
				        },
				        error:function(request, status, error) {
				        	alert("저장중 오류가 발생하였습니다.[" + error + "]"); 
				        	return false;
				        }
				    });
				}
			}	
			saveDivision = false;
	/* 	}
	} */
}
//상세 데이터 저장
function datailGridSave(){
	var ids = $("#list2").getDataIDs();
	var num = "";
	var alretMng ="";
	//필드값 체크 
	for(var i=0, n=ids.length; i<n; i++){
		var ret = jQuery("#list2").getRowData(ids[i]);
		if(ret.dtailFldName  == ""){
			num = i + 1;
			alretMng = num + "번째 필드데이터를 입력해 주세요.";
			alert(alretMng);
			return false;
		}
	}
	var gridData= jQuery("#list2").jqGrid('getRowData');
	var postData = JSON.stringify(gridData);
	$.ajax({
        type:"POST",
		data:{"jgGridData":postData,
			"fldNum": fldNum},
        dataType:"json",
        async : true,
        url:"msg.detailInsertList.usrinputdatamng.do",
        success:function(data, status) {
        	if (data.errCd){
	        	alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
        	}else{
		        alert("저장하였습니다.");
		        //doSearch();
        	}
        },
        error:function(request, status, error) {
        	alert("저장중에 오류가 발생하였습니다.[" + error + "]"); 
        	return false;
        }
    });
	changeGrid = false;
}
//재조회
function reSearch(fidId){
	
	$("#filName").text("");
	//버튼 처리
	$("#rowDelete").attr("disabled",true);
	$("#rowInsert").attr("disabled",true);
	$("#rowUp").attr("disabled",true);
	$("#rowDown").attr("disabled",true);
	
	var par = "";
	par = "?fldId=" + encodeURIComponent(fidId);
	$('#list1').setGridParam({url:'msg.researchList.usrinputdatamng.do'+par});
	$('#list1').trigger("reloadGrid");
}
//상세 데이터 행 추가
function detailRow(){
	$("#list2").jqGrid('addRowData',1,{fldId:"01",fldName:"1",dtailFldName:"",writeName:"${sessionScope.userinfo.usrname}",writeId:"${sessionScope.userinfo.usrid}",newInsert:"true"});
}
//행 삭제
function basicDelete(){
	/* editCheck =$("#list1").find("input[type=text], textarea").map(function(){ 
	return $(this).attr("name"); 
	}).get(); 
	if( "" != editCheck){ 
		alert("수정완료후 삭제하세요."); 
	return; 
	}else{ */
		
		$("#list1").jqGrid("saveRow",lastsel2);
		$("#list2").jqGrid("saveRow",lastsel3);
	
		var select = jQuery("#list1").getGridParam("selrow");
		var rows= jQuery("#list1").jqGrid('getRowData',select);
		var fldId = rows.fldId;
		var postData = JSON.stringify(rows);
		if(select == null){
			alert("삭제할 데이터 필드를 선택해주세요.");	
			return false;
		}else{	
			if(confirm("선택한 데이터 필드를 삭제 하시겠습니까?")){
				$.ajax({
			        type:"POST",
					data:{"fldId":fldId},
			        dataType:"json",
			        async : true,
			        url:"msg.getdelete.usrinputdatamng.do",
			        success:function(data, status) {
			        	if (data.errCd){
				        	alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
			        	}else{
				        	alert("삭제 되었습니다.");
				        	doSearch();
			        	}
			        },
			        error:function(request, status, error) {
			        	alert("삭제중에 오류가 발생하였습니다.[" + error + "]"); 
			        	return false;
			        }
			    });	
			}
		}
		$("#filName").html("");
	/* } */
}
//행 올리기
function rowUp(){
	/* editCheck =$("#list2").find("input[type=text], textarea").map(function(){ 
	return $(this).attr("name"); 
	}).get(); 
	if( "" != editCheck){ 
		alert("수정완료후 이동하세요."); 
	return; 
	}else{ */
		
		$("#list1").jqGrid("saveRow",lastsel2);
		$("#list2").jqGrid("saveRow",lastsel3);
	
		var fromArray = jQuery("#list2").jqGrid('getGridParam','selarrrow'); //체크된 리스트 검색 
		if(fromArray.length == 1){
			var gridArr = $("#list2").getDataIDs();
			var retrunValue = "";
			var i = 0;
			//바꿀 위치 구하기
			for(var i = 0; i<gridArr.length; i++){
				if(	gridArr[i] == fromArray){
					i--;
					retrunValue = gridArr[i];
					i++;
				}
			}
			var row1 = $("#list2").getRowData(retrunValue);
			var row2 = $("#list2").getRowData(fromArray);
			$("#list2").setRowData(retrunValue, row2);
			$("#list2").setRowData(fromArray, row1);
			$("#list2").setSelection(retrunValue);
			var selectArray = parseInt(fromArray[0]);
			if(selectArray > 1){
				$("#list2").jqGrid('setSelection', selectArray);
			}
			changeGrid = true;
		}else if( fromArray.length > 1 ) {
			alert('1건씩만 이동 가능합니다.');
			return;
		}else{
			alert('체크박스를 선택하세요');
			return;
		}
	/* } */
}
//행 내리기
function rowDown(){	
	/* editCheck =$("#list2").find("input[type=text], textarea").map(function(){ 
	return $(this).attr("name"); 
	}).get(); 
	if( "" != editCheck){ 
		alert("수정완료후 이동하세요."); 
	return; 
	}else{ */
		
		$("#list1").jqGrid("saveRow",lastsel2);
		$("#list2").jqGrid("saveRow",lastsel3);
	
		var fromArray = jQuery("#list2").jqGrid('getGridParam','selarrrow'); //체크된 리스트 검색 
		if(fromArray.length == 1){
			var gridArr = $("#list2").getDataIDs();
			var retrunValue = "";
			var i = 0;
		
			for(var i = 0; i<gridArr.length; i++){	
				if(	gridArr[i] == fromArray){
					i++;
					retrunValue = gridArr[i];
					i--;
				}
			}
			var row1 = $("#list2").getRowData(fromArray);
			var row2 = $("#list2").getRowData(retrunValue);
			$("#list2").setRowData(fromArray, row2);
			$("#list2").setRowData(retrunValue, row1);
			$("#list2").setSelection(retrunValue);
			var selectArray = parseInt(fromArray[0]);
			var max = gridArr[0];
			for(var i=1; i<parseInt(gridArr.length); i++){ // 1~배열의 크기 만큼
				if(parseInt(max) < parseInt(gridArr[i])){ // 현재 인덱스의 값이 max 보다 크면
					max = gridArr[i]; // max 값을 그 값으로 변경
				}
			}
			if(parseInt(selectArray) < parseInt(max)){
				$("#list2").jqGrid('setSelection', selectArray);
			}
			changeGrid = true;
		}else if( fromArray.length > 1 ) {
			alert('1건씩만 이동 가능합니다.');
			return;
		}else{
			alert('체크박스를 선택하세요');
			return;
		}
	/* } */
}
//행 추가
function rowInsert(){
	var select = jQuery("#list1").getGridParam("selrow");
	if(select == null){
		alert("필드 선택후 행을 추가하세요.");	
		return false;
	}else{
		var ids = $("#list2").getDataIDs();
		if(ids == ""){
			$("#list2").jqGrid('addRowData',ids.length+1,{fldId:fldNum,outptseqNo:"1",dtailFldName:"",writeName:"${sessionScope.userinfo.usrname}",writeId:"${sessionScope.userinfo.usrid}",newInsert:"true"});
		}else{
			var cklst= jQuery("#list1").jqGrid('getGridParam','selrow'); //체크된 리스트 
			var cklst2= jQuery("#list1").jqGrid('getGridParam'); //모든 리스트 
			var ary = new Array(); 
			var Nmax = 0; 
	
			var max = ids[0];
			for(var i=1; i<parseInt(ids.length); i++){ // 1~배열의 크기 만큼		
				if(parseInt(max) < parseInt(ids[i])){ // 현재 인덱스의 값이 max 보다 크면
					max = ids[i]; // max 값을 그 값으로 변경
				}
			}
			number =parseInt(max,10)+1;
			$("#list2").jqGrid('addRowData',number,{fldId:fldNum,outptseqNo:number,dtailFldName:"",writeName:"${sessionScope.userinfo.usrname}",writeId:"${sessionScope.userinfo.usrid}",newInsert:"true"});
			var maxKey = number;
			var height = $("#"+maxKey).attr('offsetHeight');         
			$(".ui-jqgrid-bdiv").scrollTop(height*maxKey);
		}
	}
	changeGrid = true;
}
//행 삭제
function rowDelete(){
	/* editCheck =$("#list2").find("input[type=text], textarea").map(function(){ 
	return $(this).attr("name"); 
	}).get(); 
	if( "" != editCheck){ 
		alert("수정완료후 삭제하세요."); 
	return; 
	}else{ */
		
		$("#list1").jqGrid("saveRow",lastsel2);
		$("#list2").jqGrid("saveRow",lastsel3);
	
		var fromArray = jQuery("#list2").jqGrid('getGridParam','selarrrow'); //체크된 리스트 검색
		if( fromArray.length > 0 ){ 
			var gr = jQuery("#list2").jqGrid('getGridParam','selrow'); 
			if( gr != null ){ 
				jQuery("#list2").delRowData(gr); 
				//alert('삭제되었습니다.'); 
			} 
		}else{ 
			alert("삭제할 필드 데이터를 선택하세요"); 
		} 	
		changeGrid = true;
	/* } */
}
//적용 및 덮어쓰기
function onInsertData(str){
	/* editCheck =$("#list1").find("input[type=text], textarea").map(function(){ 
	return $(this).attr("name"); 
	}).get(); 
	editCheck2 =$("#list2").find("input[type=text], textarea").map(function(){ 
	return $(this).attr("name"); 
	}).get(); 
	if( "" != editCheck){ 
		alert("수정완료후 눌러주세요."); 
		return; 
	}else{
		if( "" != editCheck2){ 
			alert("수정완료후 눌러주세요."); 
			return; 
		}else{ */
			
			$("#list1").jqGrid("saveRow",lastsel2);
			$("#list2").jqGrid("saveRow",lastsel3);
		
			if(changeGrid == false){
				var cklst= jQuery("#list2").jqGrid('getGridParam','selarrrow'); //체크된 리스트 
				if(str == 0){													//신규 생성일 경우
					if( cklst != "" ){
						if( cklst.length > 0 ) { 
							var array = new Array();
							array[0] = "신규";
							$.each(cklst, function (index1, value) { 
								var ret1 = jQuery("#list2").getRowData(cklst[index1]);
								var fldId1 = ret1.outptseqNo;
								var idx = 1;
								$.each(cklst, function (index2, value) {
									var ret2 = jQuery("#list2").getRowData(cklst[index2]);
									if(fldId1 > ret2.outptseqNo){
										idx++;
									}
								});
								array[idx] = ret1.dtailFldName; 
							});
							window.returnValue = array;
							self.close(); 		
						}
					}else{
						alert("선택된 행이 없습니다");
					}
				}else if(str == 1){												//덮어쓰기일 경우
					if('${listCount}'< cklst.length){							//갯수 체크
						alert("덮어쓸 수 있는 테스트케이스의 숫자인["+'${listCount}' +"]개를 초과 하였습니다.(선택수 : ["+ cklst.length +"])" );
					}else{
						if( cklst != "" ){
							if( cklst.length > 0 ) { 
								var array = new Array();
								array[0] = "덮어쓰기";
								$.each(cklst, function (index1, value) { 
									var ret1 = jQuery("#list2").getRowData(cklst[index1]);
									var fldId1 = ret1.outptseqNo;
									var idx = 1;
									$.each(cklst, function (index2, value) {
										var ret2 = jQuery("#list2").getRowData(cklst[index2]);
										if(fldId1 > ret2.outptseqNo){
											idx++;
										}
									});
									array[idx] = ret1.dtailFldName; 
								});
								window.returnValue = array;
								self.close(); 		
							}
						}else{
							alert("선택된 행이 없습니다");
						}
					}
				}
			}else if(changeGrid == true){
				alert("변경 사항을 저장 후에 적용해주세요");
			}
	/* 	}
	} */
}

function onClose(){
	window.close();
}



</script>
</head>

<body leftmargin="0" topmargin="0">
<form action="ExecuteUsrInputDataAct.tran" name="frmNm"	method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="43"><img src="images/pop_tit_01.gif" width="43" height="51"></td>
    <td background="images/pop_tit_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="pop_tit">사용자 입력데이터 관리</td>
      </tr>
    </table></td>
    <td width="216"><img src="images/pop_tit_03.gif" width="216" height="51"></td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="3">
  <tr>
    <td valign="top"><table width="100%" height="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#baccdc">
      <tr>
        <td bgcolor="#e1e9f0"><table width="100%" height="100%" border="0" cellpadding="5" cellspacing="0">
          <tr>
            <td valign="top" bgcolor="#FFFFFF"><table width="100%" border="0" cellpadding="5" cellspacing="1"  bgcolor="#baccdc">
              <tr>
                <td bgcolor="#e1e9f0"><table width="100%" border="0" cellspacing="0" cellpadding="5">
                    <tr>
                      <td bgcolor="#FFFFFF"><table width="100%" border="0" cellpadding="2" cellspacing="0">
                          <tr>
                            <td width="60" class="box_txt">필드 명:</td>
                            <td><input name="userInptFldName" id="userInptFldName" type="text" class="input_topinq" style="width:150px" onKeyDown="if(event.keyCode ==13){javascript:doSearch();}"></td>
                            <td width="60" class="box_txt">작성자 :</td>
                            <td><input id="writPnm" name="writPnm" type="text" class="input_topinq" style="width:150px" maxlength="40" onKeyDown="if(event.keyCode ==13){javascript:doSearch();}">
                              <img src="images/btn_eraser.gif" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer" onclick="doClear();"></td>
                            <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                              <tr>
                                <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                <td background="images/btn_img_02.gif" id="listSearch" class="btn_text" style="cursor:pointer">조 회</td>
                                <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                              </tr>
                            </table></td>
                          </tr>
                        </table>
                          </td>
                    </tr>
                </table></td>
              </tr>
            </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="5"></td>
                </tr>
                <tr>
                  <td height="10"><table border="0" align="right" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                      <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onClick="basicDelete(); return false;">삭 제</td>
                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                    </tr>
                  </table>
                  <table border="0" align="right" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                      <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onClick="saveCheck(); return false;">저 장</td>
                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                    </tr>
                  </table>
                  <table border="0" align="right" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                        <td background="images/btn_img_02.gif" id="dedata" class="btn_text" style="cursor:pointer" >신 규</td>
                        <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                      </tr>
                  </table></td>
                </tr>
              </table>
              <table width="100%" height="100" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                <tr>
					<td height="150" valign="top" bgcolor="#FFFFFF">
						<table id="list1"></table>
						<div id="pager1"></div> 
					</td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="10"></td>
                </tr>
                <tr>
                  <td class="sub_tit02"> 사용자 입력 데이터 상세</td>
                </tr>
              </table>
              <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#baccdc">
                <tr>
                  <td width="120" class="tm_left">필드 명</td>
                  <td id="filName" class="tm_text"></td>
                  </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="5"></td>
                </tr>
                <tr>
                  <td height="10"><table border="0" align="right" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                      <td background="images/btn_img_02.gif" id="rowDelete" class="btn_text" style="cursor:pointer" onclick="rowDelete(); return false;">행 삭제</td>
                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                    </tr>
                  </table>
                  <table border="0" align="right" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                        <td background="images/btn_img_02.gif" id="rowInsert" class="btn_text" style="cursor:pointer" onclick="rowInsert(); return false;">행 추가</td>
                        <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                      </tr>
                    </table>
                      <table border="0" align="right" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                          <td background="images/btn_img_02.gif" id="rowDown" class="btn_text" style="cursor:pointer" onclick="rowDown(); return false;">▼</td>
                          <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                        </tr>
                      </table>
                    <table border="0" align="right" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                          <td background="images/btn_img_02.gif" id="rowUp" class="btn_text" style="cursor:pointer" onclick="rowUp(); return false;" >▲</td>
                          <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                        </tr>
                    </table></td>
                </tr>
              </table>
              <table width="100%" height="100" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                <tr>
                  <td height="150" valign="top" bgcolor="#FFFFFF">
                  	<table id="list2"></table>
                  	<div id="pager2"></div> 
                  </td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="5" colspan="3"></td>
                </tr>
                <tr>
                  <td><table border="0" align="left" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                        <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="onInsertData(0); return false;">신규생성</td>
                        <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                      </tr>
                  </table>
                    <table border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                        <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="onInsertData(1); return false;" >덮어쓰기</td>
                        <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                      </tr>
                    </table></td>
                  <td ><table align="right" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                          <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="onClose(); return false;" >닫 기</td>
                          <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                        </tr>
                      </table>
                    </td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
<!-- Start of wrap -->
</body>
</html>