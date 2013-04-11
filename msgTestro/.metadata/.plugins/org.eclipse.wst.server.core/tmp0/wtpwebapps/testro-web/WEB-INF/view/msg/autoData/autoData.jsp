<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<jsp:include page="/WEB-INF/view/cmn/common.jsp" flush="true"></jsp:include>
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
<script type="text/javascript" src="jqgrid/js/jquery.contextmenu-fixed.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/util.js" charset="utf-8"></script>

<script type="text/javascript">
var opener = window.dialogArguments;
var EngAutoDataHeader = $.parseJSON(opener.document.frmname.EngAutoDataHeader.value);
var KorAutoDataHeader = $.parseJSON(opener.document.frmname.KorAutoDataHeader.value);
var gridCnt = $.parseJSON(opener.document.frmname.gridCnt.value);
var autoDataPosition = $.parseJSON(opener.document.frmname.autoDataPosition.value);
var EngAutoDataHeaderKey = $.parseJSON(opener.document.frmname.EngAutoDataHeaderKey.value);
var autoMaxLength = $.parseJSON(opener.document.frmname.autoMaxLength.value);
var totalarray = $.parseJSON(opener.document.frmname.totalarray.value);

// iframe resize
// 리턴값 Array로 받기
var colNames = new Array();				//그리드 name 설정
var colModel = new Array();				//그리드 model 설정
var colNames1 = new Array();			//colName값 다시 담아주기
var colModel1 = new Array();			//colModel값 다시 담아주기
var colMaxLength = new Array();			//최대값 담아주기
var contextCi; 							// cell 인덱스 
var contextRowid; 						// row id 
var listNumber = 0;						//순번 때문에 사용하는 변수
var updateNuber = 0;					//cell 인덱스 값 담기
var totalLength = 1;					//필드데이터 조합시 총 갯수에 필요한 변수
var listValue = new Object();			//조합 생성시 값을 저장
var listValue2 = new Object();			//조합 생성시에 이름과 값을 저장했던것을 한곳으로 저장하여 리턴해주는 변수 
var colnum = 0;							//조합생성으로 루프 돌릴때 사용하는 변수
var p = 1;								//조합생성에서 for문 돌릴때 사용하는 변수 
function autoResize(i)
{
    var iframeHeight=
    (i).contentWindow.document.body.scrollHeight;
    (i).height=iframeHeight+20;
}
//그리드 컴럼 생성하기 위한 colNames,colModel 설정
$(document).ready(function() {
	var returnValue = totalarray;							//그리드 컬럼을 만들 값
	var sel = document.getElementById("autoDataPosition"); 		//데이터 위치 지정해주는 값
	var selLength = gridCnt.length+1;							//부모창에서 가지고온 갯수로 데이터 위치 설정값 만들기 위한 값
	var selOpthion = 0;											//아래 for문에 필요한 변수
	//for문으로 셀렉트 박스 만들기(데이터삽입위치 셀렉트 박스)
	for(var i = 1; i< selLength; i++){ 							
		sel.options[selOpthion] = new Option(i,i); 
		selOpthion++;
	} 

	if(returnValue != null){
		
		var ids = $("#list").jqGrid('getDataIDs'); 

		colNames = new Array();					
		colModel = new Array();
		colNames1 = new Array();
		colModel1 = new Array();
		
		colNames = returnValue[0];	
		colModel = returnValue[1];	
		colMaxLength = returnValue[2];

		colNames1 = colNames;
		//colModel1에 생성할 값을 push해서 담는다
		for(var i =0; i < colModel.length; i++){	
			var retValue = colModel[i];
			var retMaxLength = colMaxLength[i];
			colModel1.push({
				name: retValue,
				index: retValue,
				width: '200',
				title:false,
				editable: true,
				align : 'center',
				sortable:false,
				editoptions:{maxlength:retMaxLength, style:"text-align:center"}
			});
		
		}
		newHeaderGrid();
	}
});
//입력 항목 팝업
function inputList(){
	var url = "msg.inTitle.inTitle.do";
	$("#EngAutoDataHeader").val(JSON.stringify(EngAutoDataHeader));			//영문명
	$("#KorAutoDataHeader").val(JSON.stringify(KorAutoDataHeader));			//한글명
	$("#EngAutoDataHeaderKey").val(JSON.stringify(EngAutoDataHeaderKey));	//영문 실제 키값
	$("#autoMaxLength").val(JSON.stringify(autoMaxLength));					//최대값(maxLength)
	
	var returnValue = window.showModalDialog(url,window,'center:yes;dialogWidth=650px; dialogHeight=510px; scroll=no; status=no; help=no; resizable:no; ');
	if(returnValue != null){
		var ids = $("#list").jqGrid('getDataIDs'); 
		//그리드 컴럼 생성하기 위한 colNames,colModel 설정
		colNames = new Array();
		colModel = new Array();
		colNames1 = new Array();
		colModel1 = new Array();	
		colNames = returnValue[0];	
		colModel = returnValue[1];	
		colNames1 = colNames;
		
		for(var i =0; i < colModel.length; i++){	
			var retValue = colModel[i];
			var retMaxLength = colMaxLength[i];
			colModel1.push({
				name: retValue,
				index: retValue,
				width: '200',
				title:false,
				editable: true,
				align : 'center',
				sortable:false,
				editoptions:{maxlength:retMaxLength, style:"text-align:center"}
			});
		}
		//그리드 생성 함수 
		newHeaderGrid();
	}
}

//그리드 생성 함수 
function newHeaderGrid(){
	var lastsel;
	var lastsel2;
	var lastsel3;
	var Object1 = colNames1;
	var Object2 = colModel1;
	$("#listDiv").html("");
	$("#listDiv").html("<table id='list2'></table>");		//그리드 생성
	jQuery("#list2").jqGrid( {
		mtype:'POST',    // 한글 인코딩 깨지는 문제 방지하기 위해 POST로 쓴다
		datatype : "json",
		colNames :  
					Object1
					
					,
		colModel :  
					Object2
		            ,	
        height:410, // 높이
   		autowidth: (Object1.length<=3),
   		gridview: true,
	   	rownumbers: true,//리스트 seq 사용 여부 
	   	scroll:1, //scroll paging config 
		rowNum:10, //scroll paging config 
	    viewrecords: true,
		scrollrows : true, //포커스이동시 스크롤 자동맞춤.,
	    editurl:'clientArray',

	    loadComplete : function() {
   		},
   		jsonReader : {
   			root : "rows",
   			page : "page",
   			total : "total",
   			records : "records",
   			repeatitems : false,
   			cell : "cell",
   			id : "ProjNo"
   		},
   		onRightClickRow: function (rowid, iRow, iCol, e) { 
   		},
		loadComplete: function(xhr){ 
			if (xhr.errCd){ 
				alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
			}
			initGrid(); 		//마우스 우클릭시에  한번 클릭후에 위치값을 초기화 해주기 위해 사용
		}, 
   	   		
  		ondblClickRow: function(rowid, iRow, iCol, e) { //1.더블클릭 이벤트( 로우 데이터 가져오기)
			jQuery('#list2').jqGrid('editRow',rowid,true);	
			$("input, select",e.target).focus();   					// 포커스위치 설정
   			lastsel3=rowid;
   		},
		onCellSelect: function(rowid, index, contents, event) {		//다른 라인 선택시 수정내용 저장
			$("#list2").jqGrid("saveRow",lastsel3);
	 	}
   				
   	});
	jQuery("#list2").setGridWidth(610, false); //가로스크롤
	listNumber = 1;
	$("#list2").jqGrid('addRowData',listNumber,{listNum:listNumber,projNo:"",projName:""});
	initGrid();   
}
function initGrid() { 
     jQuery(".jqgrow", "#list2").contextMenu('myMenu1', { 
		bindings: { 
			'dataCount': function(t) { 
				dataCountRow(); 						//증값데이터 팝업
			}, 
			'userData': function(t) { 
				userDataRow(); 							//사용자 입력데이터 팝업
			}
		}, 
		menuStyle :{width: '120px'},					//마우스 우클릭시 링크 사이즈 조절
		onContextMenu : function(event, menu) 
		{ 
		var getCellIndex = function (cell) { 
			var c = $(cell); 
			if (c.is('tr')) { return -1; } 
			c = (!c.is('td') && !c.is('th') ? c.closest("td,th") : c)[0]; 
			if ($.browser.msie) { return $.inArray(c, c.parentNode.cells); } 
			return c.cellIndex; 
		}; 

		// 맨앞에 넘버링은 제외해야 함으로 -1을 해준다.
		contextCi = getCellIndex(event.target)-1; 
		updateNuber = contextCi;
		contextRowid = $(event.target).parent("tr").attr("id"); 
		var grid = $("#list2"); 
		grid.setSelection(contextRowid); 
		return true; 
       	   	     
     
		}
	}); 
}

//증감 데이터 팝업 
function dataCountRow() { 
	var listCount = 1;
	var ids = $("#list2").jqGrid('getDataIDs'); //전체리스트의 id리스트 
	var selr = jQuery('#list2').jqGrid('getGridParam','selrow');
	//선택한 행의 포함하여 맨 아래까지 그리드 갯수 
	for(var i =0; i<ids.length; i++){
		if(selr < parseInt(ids[i])){
			listCount++;
		}
	}
	var url = "msg.incdecdatamng.incdecdatamng.do?listCount="+listCount;
	var returnValue = window.showModalDialog(url,window,'center:yes;dialogWidth=520px; dialogHeight=620px; scroll=no; status=no; help=no; resizable:no; ');
	if(returnValue != null){
   		if(returnValue[0] == "신규"){      //신규일 경우
   			
	   	 	var selrow = jQuery("#list2").jqGrid('getGridParam','selrow');
	   	 	var ids = $("#list2").getDataIDs();
	   	 	contextRowid = selrow;
			if(contextRowid){//edit 컬럼 저장 
				$.each(ids, function (index, value) { 
					$("#list2").jqGrid("saveRow",ids[index]); 
				}); 
			} 
			//데이터 담아 두기!!!!!!!!!!
			var curRowid; 
			var curRowData; 
			var downRowData = [];
			for(var i = contextRowid ; i < ids.length ; i++){

				// 현재선택한 로우id는 1부터 시작하지만 ids의 index는 0부터시작함으로 -1을 해줘야함
				downRowData.push($("#list2").jqGrid('getRowData', ids[i-1]));
			}  
			//선택 한거 아래꺼 다 삭제
	   	 	for(var i=selrow, n=ids.length; i<n; i++){
	   	 		jQuery("#list2").delRowData(ids[i]); 	
	   	 	}  
	   		//가지고 온값 set하고 add시키기
	   		var colModelName = colModel[updateNuber];				
			var listRow = 0;
			var selrList = new Array();
			var p = 0;  
	
			listNumber = selrow;
			var ret = $('#list2').jqGrid('getRowData',selrow);
			for(var i =0; i < returnValue.length-1; i++){
				listRow++;
				var retValue = returnValue[listRow];
	   			var newRowData = {};
				if(i==0){
					//기존값에 set시켜 덮어쓰기
		   			newRowData[colModelName] = retValue;
		   			jQuery('#list2').jqGrid('setRowData',selrow, newRowData );
				}else{
					//기존 값 가지고 오기
					for(name in ret){
						newRowData[name] = ret[name];
					}
					//기존값에 일부만 수정하고 add로 신규 생성
					newRowData[colModelName] = retValue;
					$('#list2').jqGrid('addRowData',listNumber,newRowData);
				}	
				listNumber++;		
	   		}
	   		//저장되어있던 로우 맨 아래부분에 생성
			for(var p = 0; p < downRowData.length; p++){	
				$('#list2').jqGrid('addRowData',listNumber,downRowData[p]);
				listNumber++;	
			}   		
			initGrid();
   		}else if(returnValue[0] == "덮어쓰기"){					//덮어 쓰기일 경우
   	   		//기존에 있던 데이터에 덮어쓰기
 	   		var colModelName = colModel[updateNuber];			//우클릭 위치 값
			var listRow = 0;									//selrList를 돌려 값을 뺴올때 사용할 변수
			var selrList = new Array();							//변경할 위치 담을 변수
			var j = 0;
			//변경할 순번 담아주기
			for(var i =0; i<ids.length; i++){
				if(selr == parseInt(ids[i])){
					selrList[j] = ids[i];
					j++;
				}
				if(selr < parseInt(ids[i])){
					selrList[j] = ids[i];
					j++;
				}
			}
			//값 setRowData 시키기
			for(var i =0; i < returnValue.length; i++){
				listRow++;
	   			var retValue = returnValue[listRow];
	   			var newRowData = {};
	   			newRowData[colModelName] = retValue;
	   		    jQuery('#list2').jqGrid('setRowData',selrList[i], newRowData ); 	 	
	   		}
   		}
	}
}
//사용자 입력 데이터 팝업
function userDataRow() { 
	/* editCheck =$("#list2").find("input[type=text], textarea").map(function(){ 
	return $(this).attr("name"); 
	}).get(); 
	if( "" != editCheck){ 
		alert("수정완료후다른 행을 선택하세요."); 
	return; 
	}else{ */
		
		//현재데이터 편집을 save
		$("#list2").jqGrid("saveRow",$("#list2").jqGrid('getGridParam', "selrow" ));
		
		var listCount = 1;
		var ids = $("#list2").jqGrid('getDataIDs'); //전체리스트의 id리스트 
		var selr = jQuery('#list2').jqGrid('getGridParam','selrow');
		for(var i =0; i<ids.length; i++){
			if(selr < parseInt(ids[i])){
				listCount++;
			}
		}
		var url = "msg.usrinputdatamng.usrinputdatamng.do?listCount="+listCount;
		var returnValue = window.showModalDialog(url,window,'center:yes;dialogWidth=634px; dialogHeight=662px; scroll=no; status=no; help=no; resizable:no; ');
		if(returnValue != null){
	   		if(returnValue[0] == "신규"){								//신규일 경우
	   		
		   	 	var selrow = jQuery("#list2").jqGrid('getGridParam','selrow');
		   	 	var ids = $("#list2").getDataIDs();
		   	 	contextRowid = selrow;
				if(contextRowid){//edit 컬럼 저장 
					$.each(ids, function (index, value) { 
						$("#list2").jqGrid("saveRow",ids[index]); 
					}); 
				} 
				//데이터 담아 두기!!!!!!!!!!
				var curRowid; 
				var curRowData; 
				var downRowData = []; 
				for(var i = contextRowid ; i < ids.length ; i++){ 
					downRowData.push($("#list2").jqGrid('getRowData', ids[i]));
				}  	
				//선택 한거 아래꺼 다 삭제
		   	 	for(var i=selrow, n=ids.length; i<n; i++){
		   	 		jQuery("#list2").delRowData(ids[i]); 	
		   	 	}  
		   		//가지고 온값 set하고 add시키기
		   		var colModelName = colModel[updateNuber];				
				var listRow = 0;
				var selrList = new Array();
				var p = 0;  
		
				listNumber = selrow;
				var ret = $('#list2').jqGrid('getRowData',selrow);
				for(var i =0; i < returnValue.length-1; i++){
					listRow++;
					var retValue = returnValue[listRow];
		   			var newRowData = {};
					if(i==0){
			   			newRowData[colModelName] = retValue;
			   			jQuery('#list2').jqGrid('setRowData',selrow, newRowData );
					}else{
						for(name in ret){
							newRowData[name] = ret[name];
						}
						newRowData[colModelName] = retValue;
						$('#list2').jqGrid('addRowData',listNumber,newRowData);
					}	
					listNumber++;		
		   		}
				for(var p = 0; p < downRowData.length; p++){	
					$('#list2').jqGrid('addRowData',listNumber,downRowData[p]);
					listNumber++;	
				}   		
				initGrid();
	   		}else if(returnValue[0] == "덮어쓰기"){						//덮어쓰기일 경우
	 	   		var colModelName = colModel[updateNuber];
			
				var listRow = 0;
				var selrList = new Array();
				var j = 0;
				
				for(var i =0; i<ids.length; i++){
					if(selr == parseInt(ids[i])){
						selrList[j] = ids[i];
						j++;
					}
					if(selr < parseInt(ids[i])){
						selrList[j] = ids[i];
						j++;
					}
				}
				
				for(var i =0; i < returnValue.length; i++){
					listRow++;
		   			var retValue = returnValue[listRow];
		   			var newRowData = {};
		   			newRowData[colModelName] = retValue;
		   		    jQuery('#list2').jqGrid('setRowData',selrList[i], newRowData ); 	 	
		   		}
	   		}
		}
	/* } */
}
// 행추가 
function addRow() { 
	/* editCheck =$("#list2").find("input[type=text], textarea").map(function(){ 
	return $(this).attr("name"); 
	}).get(); 
	if( "" != editCheck){ 
		alert("수정완료후다른 행을 선택하세요."); 
	return; 
	}else{ */
		
		//현재데이터 편집을 save
		$("#list2").jqGrid("saveRow",$("#list2").jqGrid('getGridParam', "selrow" ));
		
		var ids = $("#list2").jqGrid('getDataIDs'); //전체리스트의 id리스트 
		listNumber++;
		var newRowData = {};
		//처음 순번 지정
		newRowData[0] = "listnum:"+listNumber;
		//순번 이후 값을 빈값으로채우기
		for(var i = 1; i <colModel.length; i++){
			newRowData[i] = colModel[i]+":''";
		}
		var maxKey = listNumber;     //스크롤 따라가기에 필요한 변수
		jQuery('#list2').jqGrid('addRowData',listNumber,newRowData);
		//추가후에 스크롤 따라가기
		var height = $("#"+maxKey).attr('offsetHeight');         
		$(".ui-jqgrid-bdiv").scrollTop(height*maxKey);
		initGrid();
	/* } */
} 
//행 복사
function cpData() {
	/* editCheck =$("#list2").find("input[type=text], textarea").map(function(){ 
	return $(this).attr("name"); 
	}).get(); 
	if( "" != editCheck){ 
		alert("수정완료후다른 행을 선택하세요."); 
	return; 
	}else{ */
		
		//현재데이터 편집을 save
		$("#list2").jqGrid("saveRow",$("#list2").jqGrid('getGridParam', "selrow" ));
		
		var ids = $("#list2").jqGrid("getDataIDs"); 
		var selrow = jQuery("#list2").jqGrid('getGridParam','selrow');
		if( selrow != null ) { 
			contextRowid = selrow;
		    if(contextRowid){//edit 컬럼 저장 
			    $.each(ids, function (index, value) { 
			   		$("#list2").jqGrid("saveRow",ids[index]); 
			    }); 
		    } 
		    //다음행의 rowid를 찾는다 
		    var curRowid; 
		    var curRowData; 
		    var downRowData; 
		    for(var i = 0 ; i < ids.length ; i++){ 
		    	if(ids[i] == contextRowid){
		    		listNumber++; 
				    curRowid = contextRowid;
				    curRowData={};
				    for(var k = 1; k <colModel.length; k++){
				    	curRowData[i] = colModel[i]+":''";
					}
				    for(var j = i ; j < ids.length ; j++){
					    downRowData = $("#list2").jqGrid('getRowData', curRowid); 
					    $("#list2").jqGrid('setRowData', curRowid, curRowData); 
					    curRowData = downRowData; 
					    curRowid = ids[j+1]; 
			    	} 
				    $('#list2').jqGrid('addRowData',listNumber,curRowData); 
			    } 
		    }
		    initGrid();
		}else{
			alert("복사할 row를 선택하세요!!!!!"); 
		}
	/* } */
} 
//행 삭제
function delRow() { 
	/* editCheck =$("#list2").find("input[type=text], textarea").map(function(){ 
	return $(this).attr("name"); 
	}).get(); 
	if( "" != editCheck){ 
		alert("수정완료후다른 행을 선택하세요."); 
	return; 
	}else{ */
		
		//현재데이터 편집을 save
		$("#list2").jqGrid("saveRow",$("#list2").jqGrid('getGridParam', "selrow" ));
		
		var selrow = jQuery("#list2").jqGrid('getGridParam','selrow'); 
		if( selrow != null ){ 
			jQuery("#list2").delRowData(selrow); 
			alert('삭제되었습니다.'); 
		}else{ 
			alert("삭제할 row를 선택하세요."); 
		} 
	/* } */
}
//신규 버튼
function doInsertData(){
	/* editCheck =$("#list2").find("input[type=text], textarea").map(function(){ 
	return $(this).attr("name"); 
	}).get(); 
	if( "" != editCheck){ 
		alert("수정완료후다른 행을 선택하세요."); 
	return; 
	}else{ */
		
		//현재데이터 편집을 save
		$("#list2").jqGrid("saveRow",$("#list2").jqGrid('getGridParam', "selrow" ));
		
		opener.document.getElementById("autoDataPosition").value = $("#autoDataPosition").val();			//삽입또는 덮어쓰기 할 위치 지정
		opener.document.getElementById("cellEditMode").value = "신규";										//신규인지 덮어쓰기 인지 구분
		if($("#checkbox2").is(":checked")){													//조합에 check 되어있을경우
			opener.document.getElementById("NMcheck").value = "1";							//체크 여부
			var gridData= jQuery("#list2").jqGrid('getRowData');
			//listValue의 key값 설정
			for(var i=0, n=colModel.length; i<n; i++){
				listValue[colModel[i]] = new Array();
			}
			var ids = $("#list2").getDataIDs();
			//컬럼에 따라 값을 저장
			for(var i=0, n=ids.length; i<n; i++){
				var ret1 = jQuery("#list2").getRowData(ids[i]);
				for(var name in ret1){
					if($.inArray(ret1[name], listValue[name]) < 0){							//중복이 있을경우 제거
						listValue[name].push(ret1[name]);	
					}
				}
			}
			//조합 토탈값 구하기
			for(var name in listValue){
				totalLength *= listValue[name].length;
			}
			//listValue2의 key값 설정
			for(var i=0; i<totalLength; i++){
				listValue2[i] = new Array();
			}
			test();
		}else{																				//조합에 check 되어있지 않을 경우
			opener.document.getElementById("NMcheck").value = "0";							//체크 여부
			var gridData= jQuery("#list2").jqGrid('getRowData');				
			window.returnValue = gridData;
			self.close(); 
		}
	/* } */
}
//데이터 조합으로 생성
function test(){
	//컬럼에 따라 값 담아주기
	for(name in colModel){
		totalLength = totalLength/listValue[colModel[colnum]].length;						//토탈값 구해주기
		var y = 0;
		for(var q = 0; q < p; q++){
			for(var j =0; j<listValue[colModel[colnum]].length; j++){
				for(var k = 0; k <totalLength; k++){
					listValue2[y].push(colModel[colnum]+":"+listValue[colModel[colnum]][j]);
					y++;
				}
			}	
		}
		p *= listValue[colModel[colnum]].length; 
		colnum++;
	}
	
	window.returnValue = listValue2;
	self.close();
}

//덮어쓰기 버튼 
function doUpdateData(){
	/* editCheck =$("#list2").find("input[type=text], textarea").map(function(){ 
	return $(this).attr("name"); 
	}).get(); 
	if( "" != editCheck){ 
		alert("수정완료후다른 행을 선택하세요."); 
	return; 
	}else{ */
		
		//현재데이터 편집을 save
		$("#list2").jqGrid("saveRow",$("#list2").jqGrid('getGridParam', "selrow" ));
		
		var gridCount = gridCnt.length;
		var autoCount = $("#autoDataPosition").val();
		if(autoCount > 1){ 
			gridCount = gridCount - autoCount + 1;
		}
		opener.document.getElementById("autoDataPosition").value = $("#autoDataPosition").val();
		opener.document.getElementById("cellEditMode").value = "덮어쓰기";
		if($("#checkbox2").is(":checked")){
			opener.document.getElementById("NMcheck").value = "1";
			var gridData= jQuery("#list2").jqGrid('getRowData');
			
			for(var i=0, n=colModel.length; i<n; i++){
				listValue[colModel[i]] = new Array();
			}
			var ids = $("#list2").getDataIDs();
			for(var i=0, n=ids.length; i<n; i++){
				var ret1 = jQuery("#list2").getRowData(ids[i]);
				for(var name in ret1){
					if($.inArray(ret1[name], listValue[name]) < 0){
						listValue[name].push(ret1[name]);	
					}
				}
			}
			for(var name in listValue){
				totalLength *= listValue[name].length;
			}
			for(var i=0; i<totalLength; i++){
				listValue2[i] = new Array();
			}
			//덮어쓰기 갯수 체크 
			if(gridCount < totalLength){
				alert("덮어쓸 수 있는 테스트케이스의 숫자인["+ gridCount +"]개를 초과 하였습니다.(선택수 : ["+ totalLength +"])" );
				totalLength = 1;
				return false;
			}
			//조합 하기
			test();
		}else{
			opener.document.getElementById("NMcheck").value = "0";
			var gridData= jQuery("#list2").jqGrid('getRowData');
			var gridDataCount = gridData.length;
			if(gridCount < gridDataCount){
				alert("덮어쓸 수 있는 테스트케이스의 숫자인["+ gridCount +"]개를 초과 하였습니다.(선택수 : ["+ gridDataCount +"])" );
				return false;
			}
			window.returnValue = gridData;
			self.close(); 
		}
	/* } */
}
//창 닫기
function doClose(){
	window.close();
}

</script>
</head>
<input type="hidden" id="colNames" name="colNames" />
<input type="hidden" id="colModel" name="colModel" />
<body leftmargin="0" topmargin="0">
<form name="frmname" method="post">
<!-- 데이터자동생성 -->
<input type="hidden" name="gridCnt" id="gridCnt" value="" />
<input type="hidden" name="EngAutoDataHeader" id="EngAutoDataHeader" value="" />
<input type="hidden" name="KorAutoDataHeader" id="KorAutoDataHeader" value="" />
<input type="hidden" name="EngAutoDataHeaderKey" id="EngAutoDataHeaderKey" value="" />
<input type="hidden" name="autoMaxLength" id="autoMaxLength" value="" />
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="43"><img src="images/pop_tit_01.gif" width="43" height="51"></td>
    <td background="images/pop_tit_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="pop_tit">데이터 자동생성</td>
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
            <td valign="top" bgcolor="#FFFFFF">
            <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="10" colspan="2"></td>
                </tr>
                <tr>
                
                  <td class="sub_tit02" style="width:80px">테스트데이터</td>
                  <td>
                  			
                  			
		                  <table border="0" align="right" cellpadding="0" cellspacing="0">
		                      <tr>
		                        <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
		                        <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="inputList(); return false;">입력 항목</td>
		                        <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
		                      </tr>
		                    </table>
		                  <table border="0" align="right" cellpadding="0" cellspacing="0">
		                    <tr>
		                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
		                      <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="delRow(); return false;">행 삭제</td>
		                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
		                    </tr>
		                  </table>
		                  <table border="0" align="right" cellpadding="0" cellspacing="0">
		                    <tr>
		                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
		                      <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="cpData(); return false;">행 복사</td>
		                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
		                    </tr>
		                  </table>
		                    <table border="0" align="right" cellpadding="0" cellspacing="0">
		                    <tr>
		                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
		                      <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="addRow(); return false;">행 추가</td>
		                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
		                    </tr>
		                  </table>
		                  <table border="0" align="left" cellpadding="0" cellspacing="0">
				              <tr>
				                <td class="tit"><img src="images/bullet_round_blue.gif" width="8" height="10" hspace="4"><span class="board_title">데이터 삽입 위치 :</span>
				                <select name="autoDataPosition" id="autoDataPosition"  class="menu" style="width:70px">
               					</select>
				                </td>
				              </tr>
				          </table>
                    
                    </td>
                </tr>
              </table>
            
              <table width="100%" height="100" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                <tr>
                  <td height="435" valign="top" bgcolor="#FFFFFF">
                  	<div id="listDiv">
	                  	<table id="list"></table>
	                  	<div id="pager"></div> 
                  	</div>
                  	
                  	<!-- 우클릭 메뉴 --> 
				    <div class="contextMenu" id="myMenu1" style="display:none"> 
				     <ul style="width:500px"> 
					     <li id="dataCount"> 
					     <span style="font-size:130%; font-family:Verdana">증감 데이터</span> 
					     </li> 
					     <li id="userData"> 
					     <span style="font-size:130%; font-family:Verdana">사용자 입력 데이터</span> 
					     </li> 
				     </ul> 
				    </div> 
				    <!-- 우클릭 메뉴 --> 
                  	
                  </td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="5" colspan="3"></td>
                </tr>
                <tr>
                  <td><input type="checkbox" name="checkbox2" id="checkbox2">
                    <span class="point_text">필드 데이터 조합 생성</span></td>
                  <td ><table align="right" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                          <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="doClose(); return false;" >닫 기</td>
                          <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                        </tr>
                      </table>
                    <table align="right" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                        <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="doUpdateData(); return false;">덮어쓰기</td>
                        <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                      </tr>
                    </table>
                    <table align="right" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                        <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="doInsertData(); return false;">신규생성</td>
                        <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                      </tr>
                    </table></td>
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