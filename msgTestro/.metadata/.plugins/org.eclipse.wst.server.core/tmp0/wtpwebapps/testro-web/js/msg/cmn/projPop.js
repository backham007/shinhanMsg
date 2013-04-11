//초기로딩
$(window).load( function(){
	
	$("#list1").jqGrid({
	   	//url:"msg.cmn.getListProj.do",
	   	mtype:'POST',    // 한글 인코딩 깨지는 문제 방지하기 위해 POST로 쓴다
		datatype: "json",
		//postData: param,
	   	colNames:['프로젝트번호', '프로젝트명', '프로젝트시작일','프로젝트종료일'],
	   	colModel:[
	   	    {name:'projNo',index:'projNo', width:150, align:'center'},
	   		{name:'projName',index:'projName', width:420, align:'left'},
	   		{name:'testStartYMS',index:'testStartYMS', width:150, align:'center'},
	   		{name:'testEndYMS',index:'testEndYMS', width:150, align:'center'}
	   	],
	   	gridview: true,	//can not use treeGrid, subGrid, or afterInsertRow event
	   	rownumbers: true, //scroll paging config 
		//scroll:1, //scroll paging config 
		rowNum:20, //scroll paging config
		rowList:[20,30,50],
		pager: '#pager1', //record text area
	   	height : 349,
	   	viewrecords: true,
	   	sortname: "projNo",
	   	sortorder: "asc",
	    jsonReader : { 
	        root: "rows", 
	        page: "page", 
	        total: "total", 
	        records: "records",
	        repeatitems: false, 
	        cell: "cell"
	    },
	   	ondblClickRow:function(){
	   		submit();
	   	},
	   	loadComplete: function(xhr){
	   		$("#list1").jqGrid("setGridHeight",350); //스크롤
	   		if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
	   	}
	});
	
	$('#projNoName').focus(function(){
		if(this.style.color == '#ababab' || this.style.color == "rgb(171, 171, 171)"){
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
	
	$("#search").focus();
	getListProj();	//초기조회
});

//조회
function getListProj(){

	if($('#projNoName').val() == ''){
		$('#projNoName').val("== 전체 ==");
		$('#projNoName').css({'color':'#ababab'});
		$('#projNoName').blur();
	}
	
	//시작일, 종료일 체크
	if($("#testStartYMS").val() != '' &&
		$("#testEndYMS").val() != '' &&
		$("#testStartYMS").val().split("-").join("") > $("#testEndYMS").val().split("-").join("")){
		alert('시작일은 종료일보다 클수 없습니다.');
		return;
	}
	
	var projNoName;
	if($("#projNoName").css("color") == "#ababab" || $("#projNoName").css("color") == "rgb(171, 171, 171)"){
		projNoName = ""; 
	} else {
		$("#projNoName").val($("#projNoName").val().toUpperCase());
		projNoName = $("#projNoName").val();
	}
	
    var param  = {projNoName:projNoName,
				testStartYMS:$("#testStartYMS").val().split("-").join("") + "000000",
				testEndYMS:$("#testEndYMS").val().split("-").join("") + "235959"};
	    
	$('#list1').jqGrid('setGridParam',{url:"msg.cmn.getListProj.do", postData: param, page:1});
	$('#list1').trigger("reloadGrid");
}

//적용
function submit(){
	//필수입력값 체크
	if($("#list1").jqGrid('getGridParam', "selrow" ) == null){
		alert("프로젝트를 선택해 주십시오");
		return;
	}
	
	//선택값
	var curRowData = $("#list1").jqGrid('getRowData', $("#list1").jqGrid('getGridParam', "selrow" ));
	
	//리턴값
	var rtnArr = new Array();
	rtnArr[0] = curRowData.projNo;	//프로젝트번호
	rtnArr[1] = curRowData.projName;	//프로젝트명
	rtnArr[2] = curRowData.testStartYMS.split("-").join("");	//프로젝트시작일
	rtnArr[3] = curRowData.testEndYMS.split("-").join("");	//프로젝트종료일
	
	window.returnValue = rtnArr;
	self.close();
}

//프로젝트기간 입력값 삭제
function deleteDate(){
	$("#testStartYMS").val("");
	$("#testEndYMS").val("");
}