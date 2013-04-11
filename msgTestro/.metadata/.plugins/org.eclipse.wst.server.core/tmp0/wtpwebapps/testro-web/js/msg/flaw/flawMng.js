
//초기로딩
function initFlaw(){
	
	getListMngCode('tscsTranTypeCd', 'TSCSTRANTYPECD', '01');	//거래유형
	getListMngCode('tscsDefRnDstCd', 'DEFPTRNCD', '06');	//결함유형
	getListMngCode('defSeverity', 'DEFSEVERITY', '02');	//결함심각도
	getListMngCode('priActionsCd', 'PRIACTIONSCD', '02');	//조치우선순위
	getListMngCode('defCd', 'DEFCD', '01');	//결함진행상태
		
	$("#list1").jqGrid({
	   	url:"msg.flaw.getListFlaw.do?tsDataId="+$("#flawTsDataId").val()+"&acmplNth="+$("#flawAcmplNth").val(),
		datatype: "json",
	   	colNames:['결함순번',
	   	          '결함ID',
	   	          '결함유형',
	   	          '결함심각도',
	   	          '에러코드',
	   	          '에러프로그램',
	   	          '결함내용(hidden)',
	   	          '조치자명',
	   	          '등록자명',
	   	          '결함진행상태',
	   	          '거래유형(hidden)',
	   	          '조치우선순위(hidden)',
	   	          '결함배분자ID(hidden)',
	   	    	  '결함배분자명(hidden)',
	   	 		  '결함조치자ID(hidden)',
	   	    	  '조치완료예정일(hidden)'],
	   	colModel:[
	   		{name:'defNo',index:'defNo', width:80, align:'center', sortable:false},
	   		{name:'flawId',index:'flawId', width:180, align:'left', sortable:false},
	   		{name:'tscsDefRnDstCd',index:'tscsDefRnDstCd', width:140, align:'left', formatter:gridCodeFmatter, formatoptions: {cdclMnName:'DEFPTRNCD'}, unformat:gridCodeUnFmatter, sortable:false},
	   		{name:'defSeverity',index:'defSeverity', width:100, align:'center', formatter:gridCodeFmatter, formatoptions: {cdclMnName:'DEFSEVERITY'}, unformat:gridCodeUnFmatter, sortable:false},
	   		{name:'defErrCd',index:'defErrCd', width:100, align:'left', sortable:false},
	   		{name:'defErrPrg',index:'defErrPrg', width:120, align:'left', sortable:false},
	   		{name:'testOpinCtnt',index:'testOpinCtnt', hidden:true},
	   		{name:'actUsrNm',index:'actUsrNm', width:100, align:'center', sortable:false},
	   		{name:'defRegNm',index:'defRegNm', width:100, align:'center', sortable:false},
	   		{name:'defCd',index:'defCd', width:120, align:'center', formatter:gridCodeFmatter, formatoptions: {cdclMnName:'DEFSTATUS'}, unformat:gridCodeUnFmatter, sortable:false},
	   		{name:'tscsTranTypeCd',index:'tscsTranTypeCd', hidden:true},
	   		{name:'priActionsCd',index:'priActionsCd', hidden:true},
	   		{name:'defDisusrId',index:'defDisusrId', hidden:true},
	   		{name:'defDisusrNm',index:'defDisusrNm', hidden:true},
	   		{name:'actUsrId',index:'actUsrId', hidden:true},
	   		{name:'actCloseYMS',index:'actCloseYMS', hidden:true}
	   	],
	   	gridview: true,	//can not use treeGrid, subGrid, or afterInsertRow event
		rownumbers: true, //scroll paging config  
		scroll:1, //scroll paging config 
		pager: '#pager1', //record text area
		rowNum:-1,
	   	height : 180,
	   	//autowidth: true,
	   	viewrecords: true, 
	   	scrollrows : true, //포커스이동시  스크롤 자동맞춤.
	   	jsonReader : {
	   	    root: "rows",
	   	    page: false,
	   	    total: false,
	   	    records: false,
	   	    repeatitems: false,
	   	    cell: false
	   	},
	   	onSelectRow: function(rowid) {
	   		
	   		$("#tscsTranTypeCd").val($("#list1").jqGrid('getCell',rowid,"tscsTranTypeCd"));	//거래유형
	   	    $("#tscsDefRnDstCd").val($("#list1").jqGrid('getCell',rowid,"tscsDefRnDstCd"));	//결함유형
	   	    $("#defSeverity").val($("#list1").jqGrid('getCell',rowid,"defSeverity"));	//결함심각도
	   	    $("#priActionsCd").val($("#list1").jqGrid('getCell',rowid,"priActionsCd"));	//조치우선순위
	   	    $("#defErrCd").val($("#list1").jqGrid('getCell',rowid,"defErrCd"));	//에러코드
	   	    $("#defErrPrg").val($("#list1").jqGrid('getCell',rowid,"defErrPrg"));	//에러프로그램
	   	    $("#testOpinCtnt").val($("#list1").jqGrid('getCell',rowid,"testOpinCtnt"));	//결함내용
	   	    $("#defDisusrId").val($("#list1").jqGrid('getCell',rowid,"defDisusrId"));	//결함배분자ID
	   	    $("#defDisusrNm").val($("#list1").jqGrid('getCell',rowid,"defDisusrNm"));	//결함배분자명
	   	    $("#actUsrId").val($("#list1").jqGrid('getCell',rowid,"actUsrId"));	//결함조치자ID
	   	    $("#actUsrNm").val($("#list1").jqGrid('getCell',rowid,"actUsrNm"));	//결함조치자명
	   	    $("#defCd").val($("#list1").jqGrid('getCell',rowid,"defCd"));	//결함진행상태
	   	    $("#actCloseYMS").val($("#list1").jqGrid('getCell',rowid,"actCloseYMS"));	//조치완료예정일
	   	},
	   	onRightClickRow: function (rowid, iRow, iCol, e) {//우클릭 브라우져메뉴 block
	   	},
	   	loadComplete: function(xhr){
	   		if (xhr.errCd){
	   			alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
	   		} else {
	   			//rowid배열
	   			if($("#paramDefNo").val()){
	   				
	   				var ids = $("#list1").jqGrid("getDataIDs");
		   			
	   				for(var i = 0 ; i < ids.length ; i++){
	   					if($("#list1").jqGrid("getCell",ids[i],"defNo") == $("#paramDefNo").val()){
	   						$("#list1").jqGrid('setSelection', ids[i], true);
	   						break;
	   					}
	   				}
	   				
	   				$("#paramDefNo").val("");
	   			}
	   		}
	   	}
	});
	
	//윈도우사이즈와 맞춰 조절됨 
	var maxWidth= 1040;
	$(window).bind('resize', function() {
		var windwoWindth = $(window).width()-255;
		if (windwoWindth > maxWidth) {
			$("#list1").setGridWidth(windwoWindth, true);
		} else {
			jQuery("#list1").jqGrid('gridResize',{minWidth:maxWidth ,maxWidth:'100%'});
			$("#list1").setGridWidth(windwoWindth, false);
		}
			
	}).trigger('resize');
	
	//결함리스트 조회
	getListFlaw();
}

//조회
function getListFlaw(){
	var param  = "tsDataId="+$("#flawTsDataId").val();
    param += "&acmplNth="+$("#flawAcmplNth").val();

	$('#list1').jqGrid('setGridParam',{url:"msg.flaw.getListFlaw.do?"+param});
	$('#list1').trigger("reloadGrid");
	
	//초기화
	initFlawInput();
}

//신규추가
function newFlaw(){
	//그리드 선택 제거
	$("#list1").jqGrid('resetSelection');
	
	//초기화
	initFlawInput();
}

//저장
function saveFlaw(){
	
	//필수값 체크
	if($("#tscsDefRnDstCd").val() == '00'){	//결함유형
		alert("결함유형을 선택하세요");
		$("#tscsDefRnDstCd").focus();
		return;
	}
	if($("#testOpinCtnt").val() == ''){	//결함내용
		alert("결함내용을 입력하세요");
		$("#testOpinCtnt").focus();
		return;
	}
	if($("#defDisusrId").val() == ''){	//결함배분자
		alert("결함배분자를 선택하세요");
		return;
	}
	if($("#actUsrId").val() == '' && ($("#defCd").val() == '03' || $("#defCd").val() == '04')){	//결함조치자
		alert("결함조치자를 선택하세요");
		return;
	}
	
	if(confirm("저장 하시겠습니까?")){

		//파라미터
		var tsDataId = $("#flawTsDataId").val();	//테스트데이터ID
		var acmplNth = $("#flawAcmplNth").val();	//수행회차
		var defNo = "";	//결함순번
		var tscsTranTypeCd = $("#tscsTranTypeCd").val();	//거래유형
	    var tscsDefRnDstCd = $("#tscsDefRnDstCd").val();	//결함유형
	    var defSeverity = $("#defSeverity").val();	//결함심각도
	    var priActionsCd = $("#priActionsCd").val();	//조치우선순위
	    var defErrCd = $("#defErrCd").val();	//에러코드
	    var defErrPrg = $("#defErrPrg").val();	//에러프로그램
	    var testOpinCtnt = $("#testOpinCtnt").val();	//결함내용
	    var defDisusrId = $("#defDisusrId").val();	//결함배분자ID
	    var defDisusrNm = $("#defDisusrNm").val();	//결함배분자명
	    var actUsrId = $("#actUsrId").val();	//결함조치자ID
	    var actUsrNm = $("#actUsrNm").val();	//결함조치자명
	    var defCd = $("#defCd").val();	//결함진행상태
	    var actCloseYMS = "";	//조치완료예정일
	    if($("#actCloseYMS").val() != ''){
	    	actCloseYMS = $("#actCloseYMS").val().split("-").join("") + "000000";
	    }
	    
	    var url;
	    if($("#list1").jqGrid('getGridParam', "selrow" ) == null){
	    	//신규
	    	url = "msg.flaw.registerFlaw.do";
	    } else {
	    	//수정
	    	url = "msg.flaw.modifyFlaw.do";
	    	defNo = $("#list1").jqGrid('getCell',$("#list1").jqGrid('getGridParam', "selrow" ),"defNo");
	    }
	    
		$.ajax({
			type : "POST",
			url : url,
			data:{"tsDataId":tsDataId,
				  "acmplNth":acmplNth,
				  "defNo":defNo,
				  "tscsTranTypeCd":tscsTranTypeCd,
				  "tscsDefRnDstCd":tscsDefRnDstCd,
				  "defSeverity":defSeverity,
				  "priActionsCd":priActionsCd,
				  "priActionsCd":priActionsCd,
				  "defErrCd":defErrCd,
				  "defErrPrg":defErrPrg,
				  "testOpinCtnt":testOpinCtnt,
				  "defDisusrId":defDisusrId,
				  "defDisusrNm":defDisusrNm,
				  "actUsrId":actUsrId,
				  "actUsrNm":actUsrNm,
				  "defCd":defCd,
				  "actCloseYMS":actCloseYMS},
			success: function(xhr){
				//오류코드 처리
				if(xhr.errCd){
					alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
				} else {
					alert("저장되었습니다");
					getListFlaw();
				}
			},
			error: function (request, status, error) { 
				alert("결함 저장중에 오류가 발생하였습니다.[" + error + "]"); 
			}
		});
	}
}

//삭제
function deleteFlaw(){
	
	//필수값 체크
	if($("#list1").jqGrid('getGridParam', "selrow" ) == null){
		alert("삭제할 결함을 선택하세요");
		return;
	}
	
	if(confirm("삭제 하시겠습니까?")){
		//파라미터
		var tsDataId = $("#flawTsDataId").val();	//테스트데이터ID
		var acmplNth = $("#flawAcmplNth").val();	//수행회차
		var defNo = $("#list1").jqGrid('getCell',$("#list1").jqGrid('getGridParam', "selrow" ),"defNo");	//결함순번
		
		$.ajax({
			type : "POST",
			url : "msg.flaw.deleteFlaw.do",
			data:{"tsDataId":tsDataId,
				  "acmplNth":acmplNth,
				  "defNo":defNo},
			success: function(xhr){
				//오류코드 처리
				if(xhr.errCd){
					alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
				} else {
					alert("삭제되었습니다");
					//초기화
					getListFlaw();
				}
			},
			error: function (request, status, error) { 
				alert("결함 저장중에 오류가 발생하였습니다.[" + error + "]"); 
			}
		});
	}
}

//초기화
function initFlawInput(){
	//초기화
	$("#tscsTranTypeCd").val("01");	//거래유형
    $("#tscsDefRnDstCd").val("06");	//결함유형
    $("#defSeverity").val("02");	//결함심각도
    $("#priActionsCd").val("02");	//조치우선순위
    $("#defErrCd").val("");	//에러코드
    $("#defErrPrg").val("");	//에러프로그램
    $("#testOpinCtnt").val("");	//결함내용
    $("#defDisusrId").val("");	//결함배분자ID
    $("#defDisusrNm").val("");	//결함배분자명
    $("#actUsrId").val("");	//결함조치자ID
    $("#actUsrNm").val("");	//결함조치자명
    $("#defCd").val("01");	//결함진행상태
    $("#actCloseYMS").val("");	//조치완료예정일
}

//직원정보조회 팝업
function openUserPop(gubun){
	var url = "msg.report.empSrchpop.do";
	var returnValue = window.showModalDialog(url,window,'center:yes;dialogWidth=650px; dialogHeight=565px; dialogLeft=100px; dialogTop=50px; scroll=no; status=yes; help=no; resizable:no;');
    if( null != returnValue){
    	if(gubun == 'defDisusr'){
    		$("#defDisusrId").val(returnValue[0]);
    		$("#defDisusrNm").val(returnValue[1]);
    	} else if(gubun == 'actUsr'){
    		$("#actUsrId").val(returnValue[0]);
    		$("#actUsrNm").val(returnValue[1]);
    	}
    }
}

//결함배분자 삭제
function deleteDefDisusr(){
	$("#defDisusrId").val("");
	$("#defDisusrNm").val("");
}

//결함조치자 삭제
function deleteActUsr(){
	$("#actUsrId").val("");
	$("#actUsrNm").val("");
}