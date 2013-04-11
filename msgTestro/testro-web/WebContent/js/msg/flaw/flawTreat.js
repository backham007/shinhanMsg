
//초기로딩
function initTreat(){
	
	getListMngCode('tscsDefRnDstCd', 'DEFPTRNCD', '');	//결함유형
	getListMngCode('defDomainCd', 'DEFDOMAINCD', '01');	//결함발생영역
	getListMngCode('defCauseCd', 'DEFCAUSECD_HW', '01');	//결함발생원인
	getListMngCode('reTestRsult', 'RETESTRSULT', '02');	//재테스트결과
	getListMngCode('defCd', 'DEFCD', '01');	//결함진행상태
	
	$("#list1").jqGrid({
	   	url:"msg.flaw.getListFlaw.do?tsDataId="+$("#treatTsDataId").val()+"&acmplNth="+$("#treatAcmplNth").val(),
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
	   	          '결함발생영역(hidden)',
	   	          '결함발생원인(hidden)',
	   	          '조치내용(hidden)',
	   	          '재테스트일시(hidden)',
	   	          '재테스트결과(hidden)'],
	   	colModel:[
	   		{name:'defNo',index:'defNo', width:80, align:'center', sortable:false},
	   		{name:'flawId',index:'flawId', width:180, align:'left', sortable:false},
	   		{name:'tscsDefRnDstCd',index:'tscsDefRnDstCd', width:140, align:'left', formatter:gridCodeFmatter, formatoptions: {cdclMnName:'DEFPTRNCD'}, unformat:gridCodeUnFmatter, sortable:false},
	   		{name:'defSeverity',index:'defSeverity', width:100, align:'center', formatter:gridCodeFmatter, formatoptions: {cdclMnName:'DEFSEVERITY'}, unformat:gridCodeUnFmatter, sortable:false},
	   		{name:'defErrCd',index:'defErrCd', width:100, align:'left', sortable:false},
	   		{name:'defErrPrg',index:'defErrPrg', width:120, align:'left', sortable:false},
	   		{name:'testOpinCtnt',index:'testOpinCtnt',hidden:true},
	   		{name:'actUsrNm',index:'actUsrNm', width:100, align:'center', sortable:false},
	   		{name:'defRegNm',index:'defRegNm', width:100, align:'center', sortable:false},
	   		{name:'defCd',index:'defCd', width:120, align:'center', formatter:gridCodeFmatter, formatoptions: {cdclMnName:'DEFSTATUS'}, unformat:gridCodeUnFmatter, sortable:false},
	   		{name:'defDomainCd',index:'defDomainCd',hidden:true},
	   		{name:'defCauseCd',index:'defCauseCd',hidden:true},
	   		{name:'defActContent',index:'defActContent',hidden:true},
	   		{name:'reTestYMS',index:'reTestYMS',hidden:true},
	   		{name:'reTestRsult',index:'reTestRsult',hidden:true}
	   	],
	   	gridview: true,	//can not use treeGrid, subGrid, or afterInsertRow event
		rownumbers: true, //scroll paging config  
		scroll:1, //scroll paging config 
		pager: '#pager1', //record text area
		rowNum:-1,
		shrinkToFit: false,
	   	height : 180,
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
	   		
			$("#tscsDefRnDstCd").val($("#list1").jqGrid('getCell',rowid,"tscsDefRnDstCd"));	//결함유형
			$("#testOpinCtnt").val($("#list1").jqGrid('getCell',rowid,"testOpinCtnt"));	//결함내용
			$("#defDomainCd").val($("#list1").jqGrid('getCell',rowid,"defDomainCd"));	//결함발생영역
			setDefCauseCd();	//결함발생원인 select box 변경
			$("#defCauseCd").val($("#list1").jqGrid('getCell',rowid,"defCauseCd"));	//결함발생원인
			$("#defActContent").val($("#list1").jqGrid('getCell',rowid,"defActContent"));	//조치내용
			$("#reTestYMS").val($("#list1").jqGrid('getCell',rowid,"reTestYMS"));	//재테스트일시
			if($("#list1").jqGrid('getCell',rowid,"reTestRsult") == ""){
				$("#reTestRsult").val("00");	//재테스트결과
			} else {
				$("#reTestRsult").val($("#list1").jqGrid('getCell',rowid,"reTestRsult"));	//재테스트결과
			}
			$("#defCd").val($("#list1").jqGrid('getCell',rowid,"defCd"));	//결함진행상태
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
	getListFlawTreat();
};

//조회
function getListFlawTreat(){
	var param  = "tsDataId="+$("#treatTsDataId").val();
    param += "&acmplNth="+$("#treatAcmplNth").val();

	$('#list1').jqGrid('setGridParam',{url:"msg.flaw.getListFlaw.do?"+param});
	$('#list1').trigger("reloadGrid");
	
	//초기화
	initTreatInput();
}

//저장
function modifyTreat(){
	
	//등록된 결함이 없을 경우
	if($("#list1").jqGrid('getGridParam', "selrow" ) == null){
		alert("조치내역을 수정할 결함을 선택하세요");
		return;
	}
	
	//필수값 체크
	if($("#defDomainCd").val() == null){	//결함발생영역
		alert("결함발생영역을 선택하세요");
		$("#defDomainCd").focus();
		return;
	}
	if($("#defCauseCd").val() == null){	//결함발생원인
		alert("결함발생원인을 선택하세요");
		$("#defCauseCd").focus();
		return;
	}
	if($("#defActContent").val() == ''){	//조치내용
		alert("조치내용을 입력하세요");
		$("#defActContent").focus();
		return;
	}
	
	if(confirm("조치내역을 수정 하시겠습니까?")){

		//파라미터
		var tsDataId = $("#treatTsDataId").val();	//테스트데이터ID
		var acmplNth = $("#treatAcmplNth").val();	//수행회차
		var defNo = $("#list1").jqGrid('getCell',$("#list1").jqGrid('getGridParam', "selrow" ),"defNo");	//결함순번
		
		var tscsDefRnDstCd = $("#tscsDefRnDstCd").val();	//결함유형
	    var testOpinCtnt = $("#testOpinCtnt").val();	//결함내용
	    var defDomainCd = $("#defDomainCd").val();	//결함발생영역
	    var defCauseCd = $("#defCauseCd").val();	//결함발생원인
	    var defActContent = $("#defActContent").val();	//조치내용
	    var reTestYMS;	//재테스트일시
	    if($("#reTestYMS").val() != ''){
	    	reTestYMS = $("#reTestYMS").val().split("-").join("") + "000000";	//재테스트일시
	    }
	    var reTestRsult = $("#reTestRsult").val();	//재테스트결과
	    var defCd = $("#defCd").val();	//결함진행상태
	    
		$.ajax({
			type : "POST",
			url : "msg.flaw.modifyTreat.do",
			data:{"tsDataId":tsDataId,
				  "acmplNth":acmplNth,
				  "defNo":defNo,
				  "tscsDefRnDstCd":tscsDefRnDstCd,
				  "testOpinCtnt":testOpinCtnt,
				  "defDomainCd":defDomainCd,
				  "defCauseCd":defCauseCd,
				  "defActContent":defActContent,
				  "reTestYMS":reTestYMS,
				  "reTestRsult":reTestRsult,
				  "defCd":defCd},
			success: function(xhr){
				//오류코드 처리
				if(xhr.errCd){
					alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
				} else {
					alert("저장되었습니다");
					getListFlawTreat();
				}
			},
			error: function (request, status, error) { 
				alert("결함 저장중에 오류가 발생하였습니다.[" + error + "]"); 
			}
		});
	}
}

//초기화
function initTreatInput(){
	//초기화
    $("#tscsDefRnDstCd").val("");	//결함유형
    $("#testOpinCtnt").val("");	//결함내용
    $("#defDomainCd").val("01");	//결함발생영역
    $("#defCauseCd").val("01");	//결함발생원인
    $("#defActContent").val("");	//조치내용
    $("#reTestYMS").val("");	//재테스트일시
    $("#reTestRsult").val("02");	//재테스트결과
    $("#defCd").val("01");	//결함진행상태
}

//결함발생원인 select box 변경
function setDefCauseCd(){
	
	//결함발생원인select 값 삭제
	//$("#defCauseCd option:gt(0)").remove();
	
	//결함발생영역 선택에 따른 select box 세팅
	if($("#defDomainCd").val() == "01"){	//하드웨어
		getListMngCode('defCauseCd', 'DEFCAUSECD_HW', '01');	//결함발생원인
	} else if($("#defDomainCd").val() == "02"){	//시스템 S/W
		getListMngCode('defCauseCd', 'DEFCAUSECD_SYSSW', '01');	//결함발생원인
	} else if($("#defDomainCd").val() == "03"){	//업무 S/W
		getListMngCode('defCauseCd', 'DEFCAUSECD_BIZSW', '01');	//결함발생원인
	} else if($("#defDomainCd").val() == "04"){	//NetWork
		getListMngCode('defCauseCd', 'DEFCAUSECD_NET', '01');	//결함발생원인
	} else if($("#defDomainCd").val() == "05"){	//데이터
		getListMngCode('defCauseCd', 'DEFCAUSECD_DATA', '01');	//결함발생원인
	}
}

//재테스트일시 삭제
function deleteReTestYMS(){
	$("#reTestYMS").val("");
}