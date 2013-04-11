var opener = window.dialogArguments;

var colNameLst = {
    //그리드 더블클릭 이벤트
    setColData: function(){
    	
    	var rowid = $("#jqGridTable").jqGrid('getGridParam', "selrow");
    	
    	if(rowid == null){
    		alert("선택된 행이 없습니다");
    		return;
    	}
    	
    	$("#jqGridTable").jqGrid('saveRow', rowid);
    	
        var inputBoxName = $('#inputBoxName').val();
        
        var fldDiv = $("#jqGridTable").jqGrid('getCell', rowid, 'fldDiv');
        var fldName = $("#jqGridTable").jqGrid('getCell', rowid, 'fldName');
        var tscsFldDesc = $("#jqGridTable").jqGrid('getCell', rowid, 'tscsFldDesc');
        var fldAttrib = $("#jqGridTable").jqGrid('getCell', rowid, 'fldAttrib');
        var rptName = $("#jqGridTable").jqGrid('getCell', rowid, 'rptName');
        var rptCnt = $("#jqGridTable").jqGrid('getCell', rowid, 'rptCnt');
                
        var msgError = "";
        if(rptName != '' && rptCnt == ''){
        	msgError = "반복부필드입니다. 인덱스를 입력해주세요";
        } else if(rptCnt != '' && (isNaN(rptCnt)==true || rptCnt.substring(0,1) == '+')){
            msgError = "인덱스는 숫자만 입력받을 수 있습니다.";
        }else if(rptCnt != '' && (rptCnt < 1)){
            msgError = "인덱스에 0이하의 값이 들어 갈수 없습니다.";
        }
        
        if(msgError != ""){
            alert(msgError);
            jQuery('#jqGridTable').jqGrid('editRow',rowid,true); 
			$("input, select").focus();   // 포커스위치 설정
			lastsel3=rowid;
        	return;        
        }
        
        opener.outputdatamng.setColData(inputBoxName, fldDiv, fldName, tscsFldDesc, fldAttrib, rptName, rptCnt);
        window.close();
    }
};

var lastsel3;

/*그리드 설정 Start*/
var jqGridOptions = {
    mtype:'POST'
    , datatype: "json" 
    , colNames:[
		'필드구분'
		,'필드명'
		,'한글명'
		,'필드속성'
		,'인덱스'
		,'반복부명(HIDDEN)'
    ]
    , colModel:[ 
		{name: 'fldDiv', index: 'fldDiv', width:50, align:"center", formatter:'select', editoptions: { value: "01:헤더부;02:개별부" }, sortable:false, editable:false}
		,{name: 'fldName', index: 'fldName', width:100, align:"left", sortable:false, editable:false}
		,{name: 'tscsFldDesc', index: 'tscsFldDesc', width:100, align:"left", sortable:false, editable:false}
		,{name: 'fldAttrib', index: 'fldAttrib', width:50, align:"center", formatter:'select', editoptions: { value: "01:일반;03:반복회차" }, sortable:false, editable:false}
		,{name: 'rptCnt', index: 'rptCnt', width:50, align:"left", sortable:false, editable:true}
		,{name: 'rptName', index: 'rptName', hidden:true}
    ]
    , viewrecords : true 
    , scroll : 1 //scroll paging config
    , rownumbers: true //scroll paging config  
    , rowNum : -1
    , autowidth: true
    , height: 275
    , editurl:'clientArray'
   	, jsonReader : {
		root: "rows"
		, page: false 
		, total: false 
		, records: false 
		, repeatitems: false 
		, cell: false
    }
	, loadComplete: function(xhr){
	    if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
	}
    , ondblClickRow: function (rowid, iRow, iCol, e) { //더블클릭 이벤트(edit)
		if("0" != iCol){ // 싱글선택:0 , 멀티선택:0,1
			if($("#jqGridTable").jqGrid('getCell', rowid, 'fldAttrib') == '03' ||
					$("#jqGridTable").jqGrid('getCell', rowid, 'rptName') != ''){
				jQuery('#jqGridTable').jqGrid('editRow',rowid,true); 
				$("input, select",e.target).focus();   // 포커스위치 설정
				lastsel3=rowid;
			}
		} 
	}
	, onCellSelect: function(rowid, index, contents, event) {		//클릭저장
   		$("#jqGridTable").jqGrid("saveRow",lastsel3);
	}
	, onRightClickRow: function (rowid, iRow, iCol, e) {//우클릭 브라우져메뉴 block
	}
};

/*그리드 설정 End*/

$(document).ready(function (){
    
    //타이틀에 테스트시나리오 정보 출력
    var fldIO = $('#currentFldIO').val();
    var chnlDstcd = $('#currentChnlDstcd').val();
    var tranCd = $('#currentTranCd').val();
    
    
    //그리드 설정에 url 정보 추가
    jqGridOptions.url = "msg.tsmng.getMciIOMap.do";
    jqGridOptions.postData = {
        fldIO: fldIO
        , chnlDstcd: chnlDstcd
        , tranCd: tranCd
    };
    
    $("#jqGridTable").jqGrid(jqGridOptions);
    
    $(".ui-jqgrid-labels").css("font-size", "12px");
    $(".ui-jqgrid-sortable").css("vertical-align", "middle");
});