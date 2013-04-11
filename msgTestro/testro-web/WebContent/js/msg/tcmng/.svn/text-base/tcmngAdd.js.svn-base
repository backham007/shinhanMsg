var opener = window.dialogArguments;
var IE6 = true;
var _tranCd = "";
// 페이지 로드시 실행
function loadPage(){
	
	defaultGrid();
	
	$("#layoutDiv").html("<div id='headerDataDiv'></div><div id='inviDataDiv'></div>");
	$("#writeName").val(opener.document.frmname.usrname.value);
	
	doSearch('view1');
	
	//selectBox 초기화
	_tranCd = opener.document.frmname.tranCd.value;
	
	if(_tranCd != ""){
		$("#inqType").attr("value", "tranCd").attr("selected", "selected").attr("disabled","disabled");
		$("#delImg").attr("style","display :none");
		doChkSeleted();
	}else{
		setAllSearch('textfield');
	}
	getTcList();
	$("input,select").keydown(function(e){
	   	if(e.keyCode == 13){
	   		getTcList();
	   	}
	 });
	
	reloadGridWidthSize('list1',30);
	reloadGridWidthSize('list2',30);
	
}


function doChkSeleted(){
	var value = $("#inqType").val();
	if(value == "tranCd"){
		$("#textfield").val(_tranCd);
		if(_tranCd != ""){
			$("#textfield").attr("disabled", "disabled");
		}
	}else{
		$("#textfield").attr("disabled", "");
		$("#textfield").val("");
	}
}

//테스트케이스 상세 탭 선택시 
function doSearch(str){
	var idx = str.substring(4,5); //버튼순서	 
	  
	//버튼바꾸기
	for(i = 0; i < 2; i++){   
		if(parseInt(idx) == i){
			eval("document.all.view"+i+"_on").style.display = "block";            
			eval("document.all.view"+i+"_off").style.display = "none";
		}else{
			eval("document.all.view"+i+"_on").style.display = "none";   
			eval("document.all.view"+i+"_off").style.display = "block";
		}
	}
	
	if(idx == 0){
		$("#dataDetailDiv").show();
		$("#inviDataDiv").hide();
	}else{
		$("#dataDetailDiv").hide();
		$("#inviDataDiv").show();
	}
}


//화면 각 부분별 초기화
function doSubTitle(divNm, id, val){

	if(divNm == "titleDiv1"){
		$("#titleDiv1").html("[ "+ id +" : "+ val +" ]");
		$("#titleDiv2").html("");
	}else if(divNm == "titleDiv2"){
		$("#titleDiv2").html("[ "+ id +" : "+ val +" ]");
	}else{
		$("#titleDiv1").html("");
		$("#titleDiv2").html("");
		$("#layoutDiv").html("<div id='headerDataDiv'></div><div id='inviDataDiv'></div>");
	}
}

//날짜 지우기
function doNameClear(){
	$('#writeName').val("");
}

//날짜 지우기
function doClear(){
	$('#startDt').val("");
	$('#endDt').val("");
}

//테스트케이스  기본조회
function getTcList(){
	var textfield = getAllSearchValue('textfield');
	doSubTitle("", "", "");
	$("#list2").clearGridData();
	$("#layoutDiv").html("<div id='headerDataDiv'></div><div id='inviDataDiv'></div>");

	if(document.frmName.textfield.value == '') {
		if(trimmed(document.frmName.writeName.value) == '') {
		    if(document.frmName.inqType.value == "tsCaseName") {
				alert('테스트케이스명을 한글자 이상 입력해 주십시오.' );
				document.frmName.textfield.focus();
				return;
			}
		    if(document.frmName.inqType.value == "tsCaseDesc") {
				alert('테스트케이스설명을 한글자 이상 입력해 주십시오.' );
				document.frmName.textfield.focus();
				return;
			}
		    if(document.frmName.inqType.value == "tsCaseID") {
				alert('테스트케이스ID를 한글자 이상 입력해 주십시오.' );
				document.frmName.textfield.focus();
				return;
			}
		    if(document.frmName.inqType.value == "tranCd") {
				alert('거래코드를 한글자 이상 입력해 주십시오.' );
				document.frmName.textfield.focus();
				return;
			}
	    }
	}
	
	//테스트예정일 
	var startDt = document.frmName.startDt.value;
	var endDt 	= document.frmName.endDt.value;
	
	//-문자 제거
	startDt = startDt.split("-").join("");
	endDt 	= endDt.split("-").join("");
	
	//시작일과 종료일 비교
	if(new Number(startDt) > new Number(endDt)) {
		alert("테스트예정 시작일은 종료일보다 작거나 같아야 합니다.");
		return;
	}else{
		//메시지ID를 포함하여 조회
		var postData ={
				inqType: document.frmName.inqType.value
				, textfield: textfield
				, writeName: document.frmName.writeName.value
				, tranCd: _tranCd
				, startDt: startDt
				, endDt: endDt
		};
		
		$('#list1').setGridParam({url:'msg.tcmng.getTcmngAddTcList.do', postData: postData});
		$('#list1').trigger("reloadGrid");
	}
}


//테스트케이스 적용버튼 선택시
function doApply(){
	var chkRows = jQuery("#list2").jqGrid('getGridParam','selarrrow');
	
	var list = new Array();
	
	if(chkRows.length > 0){
		$.each(chkRows, function (index, value) { 
			var getdata = jQuery("#list2").getRowData(chkRows[index]); 
			list[index] = getdata.tsdataID;
		}); 
		window.returnValue = list;
		self.close();
	}else{
		alert("선택된 테스트데이터가 없습니다. 테스트데이터를 선택하여 주십시오.");
	}
}

//기본 그리드 출력
function defaultGrid(){
	//테스트케이스 목록
	jQuery("#list1").jqGrid({
		mtype:'POST',    // 한글 인코딩 깨지는 문제 방지하기 위해 POST로 쓴다
		datatype: "json",
	    colNames:['케이스ID' ,
	              '케이스명' ,
	              '케이스설명' , 
	              '작성자ID' ,
	              '작성자명' ,
	              '작성일자' ,
	              '거래코드' ,
	              '거래코드명' ,
	              '채널구분'
		],
	    colModel:[
					{name: 'tsCaseID',index: 'TsCaseID', width:150, editable:false, align:"center", key:true},
					{name: 'tsCaseName',index: 'TsCaseName', width:175, editable:false, align:"left"},
					{name: 'tsCaseDesc',index: 'TsCaseDesc', width:240, editable:false, align:"left"},
					{name: 'writeID',index: 'WriteID', width:100, editable:false, align:"center"},
					{name: 'writeName',index: 'WriteName', width:100, editable:false, align:"center"},
					{name: 'cretnYMS',index: 'CretnYMS', width:100, editable:false, align:"center", formatter:gridDateFmatter, formatoptions: {srcformat:'yMdhms', newformat:'y-M-d'}, unformat:gridDateUnFmatter},
					{name: 'tranCd',index: 'TranCd', hidden:true},
					{name: 'tranName',index: 'TranName', hidden:true},
					{name: 'chnlDstcd',index: 'ChnlDstcd', hidden:true}
	    ],
	    rownumbers	: true, 		//rownum
	   	rowNum		: 20,
	   	rowList		: [20,30,50],
	   	pager		: '#pager1',
	   	sortname	: 'TsCaseID',
	   	height      : 120,
	    viewrecords	: true,
	    sortorder	: "desc",
	    gridview: true,
	    loadComplete: function(xhr){
        	if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
        	reloadGridWidthSize('list1',30);
		},
	    jsonReader 	: {
	        root	: "rows",
	        page	: "page",
	        total	: "total",
	        records	: "records",
	        repeatitems: false,
	        cell	: "cell",
	        id		: "TsCaseID"
	    },
	    onCellSelect: function(rowid) { //1.더블클릭 이벤트( 로우 데이터 가져오기)
			if(rowid != 0){
		    	var rowdata 	= jQuery("#list1").jqGrid('getRowData',rowid);
		    	var tsCaseID 	=  rowdata.tsCaseID;
		    	var tsCaseName 	=  rowdata.tsCaseName;
		    	
		    	doSubTitle('titleDiv1', tsCaseID, tsCaseName);
		    	
				var pram = "?tsCaseID="+tsCaseID;
				$('#list2').setGridParam({url:'msg.tcmng.getTdList.do'+pram});
				$('#list2').trigger("reloadGrid");
	    	}
		}
	}); 
	jQuery("#list1").setGridWidth(917,true); 	//가로스크롤
	
	//테스트데이터 목록
	jQuery("#list2").jqGrid({
		mtype:'POST',    // 한글 인코딩 깨지는 문제 방지하기 위해 POST로 쓴다
		datatype: "json",
	    colNames:['데이터ID' ,
	              '데이터명' ,
	              '데이터설명' , 
	              '작성자명' ,
	              '작성일자' ,
	              '체크포인트설정여부',
	              '거래코드',
	              '채널구분'
		],
	    colModel:[
					{name: 'tsdataID',index: 'TsdataID', width:150, editable:false, align:"center", sortable:false, key:true},
					{name: 'tsdataName',index: 'TsdataName', width:150, editable:false, align:"left", sortable:false},
					{name: 'tsdataDesc',index: 'TsdataDesc', width:230, editable:false, align:"left", sortable:false},
					{name: 'writeName',index: 'WriteName', width:100, editable:false, align:"center", sortable:false},
					{name: 'cretnYMS',index: 'CretnYMS', width:100, editable:false, align:"center", sortable:false, formatter:gridDateFmatter, formatoptions: {srcformat:'yMdhms', newformat:'y-M-d'}, unformat:gridDateUnFmatter},
					{name: 'chkYN',index: 'ChkYN', width:135, editable:false, align:"center", sortable:false},
					{name: 'tranCd',index: 'TranCd', hidden:true},
					{name: 'chnlDstcd',index: 'ChnlDstcd', hidden:true}
	    ],
	    rownumbers	: true, 		//rownum
	    editurl		: 'clientArray',
	    rowNum		: 500,
	   	height      : 130,
	    viewrecords	: true,
	    multiselect : true, //멀티셀렉트 설정
	    scrollrows  : true,
	    gridview: true,
	    loadComplete: function(xhr){
	    	if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
	    	
	    	var row = jQuery("#list2").getRowData();
        	$('#totalCount').text("[총 "+row.length+" 건]");
	    	reloadGridWidthSize('list2',30);
	    	
		},
	    jsonReader 	: {
	        root	: "rows",
	        repeatitems: false
	    },
	    onCellSelect: function(rowid, index, contents, event) {//checkbox 선택시만 row선택
			if(index != 1){
		    	var rowdata 	= jQuery("#list2").jqGrid('getRowData',rowid);
				var tsDataID 	= rowdata.tsdataID;
				var tsDataName 	= rowdata.tsdataName;

				$("#list2").jqGrid('setSelection', rowid, false);
				$.ajax({
			        type:"POST",
			        data:{"tsdataID":rowdata.tsdataID
				        },
			        dataType:"html",
			        url:"msg.layout.getTdDetailList.do",
			        success:function(data, status) {
				        // 오류코드 처리
						if (data.errCd){
							alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
							$('#list').trigger('reloadGrid');
						}else{
					        $("#layoutDiv").html("");
				        	$("#layoutDiv").html(data);
				        	
				        	doSearch('view1');
				        	doSubTitle('titleDiv2', tsDataID, tsDataName);   //선택된 값 표시 타이틀변경
						}
			        },
			        error:function(request, status) {
			            alert(status);
			        }
			    });	
	    	}
		}
	}); 
	jQuery("#list2").setGridWidth(917,true); 	//가로스크롤
}
