
var maxWidth= 1280; //전체사이즈(그리드전체사이즈)
var leftTemp = 230; //left메뉴사이즈

function bodyreload(){
	var hidenYn = $("body").attr("hideYn");
	if("Y" == hidenYn){ //left 메뉴 hidden
		leftTemp=55;
	}else{ //left 메뉴 show
		leftTemp=230;
	}
	$(window).trigger('resize');
}

//초기로딩
$(document).ready( function(){
	
	//공통코드 콤보세팅
	getListMngCode('defCd1', 'DEFSTATUS', '00');	//결함상태
	getListMngCode('defCd2', 'DEFSTATUS', '00');	//결함상태
	
	$("#list1").jqGrid({
	   	url:'',
		datatype: '',
		mtype:'POST',
	   	colNames:['프로젝트명', '테스트단계', '테스트케이스명','수행회차','테스트데이터명','결함ID','결함등록자','결함유형','결함상태','신규등록일자','승인일자','테스트케이스ID(HIDDEN)','테스트케이스수행회차(HIDDEN)','테스트데이터ID(HIDDEN)','테스트데이터수행회차(HIDDEN)','결함순번(HIDDEN)'],
	   	colModel:[
	   		{name:'projName',index:'projName', width:150, align:'left', title : false},
	   		{name:'testStgeName',index:'testStgeName', width:100, align:'left', title : false},
	   		{name:'tsCaseName',index:'tsCaseName', width:150, align:'left', title : false},
	   		{name:'acmplNth',index:'acmplNth', width:60, align:'center', title : false},
	   		{name:'tsdataName',index:'tsdataName', width:150, align:'left', title : false},
	   		{name:'flawId',index:'flawId', width:160, align:'center', title : false, sortable:false},
	   		{name:'defRegNm',index:'defRegNm', width:100, align:'center', title : false},
	   		{name:'tscsDefRnDstCd',index:'tscsDefRnDstCd', width:150, align:'left', formatter:gridCodeFmatter, formatoptions: {cdclMnName:'DEFPTRNCD'}, unformat:gridCodeUnFmatter, title : false},
	   		{name:'defCd',index:'defCd', width:60, align:'center', formatter:gridCodeFmatter, formatoptions: {cdclMnName:'DEFSTATUS'}, unformat:gridCodeUnFmatter, title : false},
	   		{name:'defRegYMS',index:'defRegYMS', width:100, align:'center', formatter:gridDateFmatter, formatoptions: {srcformat:'yMdhms', newformat:'y-M-d'}, unformat:gridDateUnFmatter, title : false},
	   		{name:'treatFnshYMS',index:'treatFnshYMS', width:100, align:'center', formatter:gridDateFmatter, formatoptions: {srcformat:'yMdhms', newformat:'y-M-d'}, unformat:gridDateUnFmatter, title : false},
	   		{name:'tsCaseId',index:'tsCaseId', hidden:true},
	   		{name:'acmplNth',index:'acmplNth', hidden:true},
	   		{name:'tsDataId',index:'tsDataId', hidden:true},
	   		{name:'tsdataAcmplNth',index:'tsdataAcmplNth', hidden:true},
	   		{name:'defNo',index:'defNo', hidden:true}	   		
	   	],
	   	gridview: true,	//can not use treeGrid, subGrid, or afterInsertRow event
	   	rownumbers: true, //scroll paging config 
		//scroll:1, //scroll paging config 
		rowNum:20, //scroll paging config
		rowList:[20,30,50],
		pager: '#pager1', //record text area
	   	viewrecords: true,
	    jsonReader : { 
	        root: "rows", 
	        page: "page", 
	        total: "total", 
	        records: "records",
	        repeatitems: false, 
	        cell: "cell"
	    },
		loadComplete: function(xhr){
	    	if (xhr.errCd){
	    		alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
	    	} else {
	    		initGrid1();
	    	}
		}
	});
	
	$("#list2").jqGrid({
	   	url:'',
		datatype: "",
		mtype:'POST',
	   	colNames:['프로젝트명', '테스트단계', '테스트시나리오명','수행회차','테스트데이터명','결함ID','결함등록자','결함유형','결함상태','신규등록일자','승인일자','테스트시나리오ID(HIDDEN)','테스트시나리오수행회차(HIDDEN)','테스트데이터ID(HIDDEN)','테스트데이터수행회차(HIDDEN)','결함순번(HIDDEN)'],
	   	colModel:[
	   		{name:'projName',index:'projName', width:150, align:'left', title : false},
	   		{name:'testStgeName',index:'testStgeName', width:100, align:'left', title : false},
	   		{name:'tsSnrioName',index:'tsSnrioName', width:150, align:'left', title : false},
	   		{name:'acmplNth',index:'acmplNth', width:60, align:'center', title : false},
	   		{name:'tsdataName',index:'tsdataName', width:150, align:'left', title : false},
	   		{name:'flawId',index:'flawId', width:160, align:'center', title : false, sortable:false},
	   		{name:'defRegNm',index:'defRegNm', width:100, align:'center', title : false},
	   		{name:'tscsDefRnDstCd',index:'tscsDefRnDstCd', width:150, align:'left', formatter:gridCodeFmatter, formatoptions: {cdclMnName:'DEFPTRNCD'}, unformat:gridCodeUnFmatter, title : false},
	   		{name:'defCd',index:'defCd', width:60, align:'center', formatter:gridCodeFmatter, formatoptions: {cdclMnName:'DEFSTATUS'}, unformat:gridCodeUnFmatter, title : false},
	   		{name:'defRegYMS',index:'defRegYMS', width:100, align:'center', formatter:gridDateFmatter, formatoptions: {srcformat:'yMdhms', newformat:'y-M-d'}, unformat:gridDateUnFmatter, title : false},
	   		{name:'treatFnshYMS',index:'treatFnshYMS', width:100, align:'center', formatter:gridDateFmatter, formatoptions: {srcformat:'yMdhms', newformat:'y-M-d'}, unformat:gridDateUnFmatter, title : false},
	   		{name:'tsSnrioId',index:'tsSnrioId', hidden:true},
	   		{name:'acmplNth',index:'acmplNth', hidden:true},
	   		{name:'tsDataId',index:'tsDataId', hidden:true},
	   		{name:'tsdataAcmplNth',index:'tsdataAcmplNth', hidden:true},
	   		{name:'defNo',index:'defNo', hidden:true}
	   	],
	   	gridview: true,	//can not use treeGrid, subGrid, or afterInsertRow event
	   	rownumbers: true, //scroll paging config 
		//scroll:1, //scroll paging config 
		rowNum:20, //scroll paging config
		rowList:[20,30,50],
		pager: '#pager2', //record text area
	   	viewrecords: true,
	    jsonReader : { 
	        root: "rows", 
	        page: "page", 
	        total: "total", 
	        records: "records",
	        repeatitems: false, 
	        cell: "cell"
	    },
	    loadComplete: function(xhr){
	    	if (xhr.errCd){
	    		alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
	    	} else {
	    		initGrid2();
	    	}
		}
	});
	
	//윈도우사이즈와 맞춰 조절됨
	$(window).bind('resize', function() {
		var windwoWindth = $(window).width()-leftTemp;
		if (windwoWindth > maxWidth) {
			$("#list1").setGridWidth(windwoWindth, true);
			$("#list2").setGridWidth(windwoWindth, true);
		} else {
			jQuery("#list1").jqGrid('gridResize',{minWidth:maxWidth ,maxWidth:'100%'});
			$("#list1").setGridWidth(windwoWindth, false);
			jQuery("#list2").jqGrid('gridResize',{minWidth:maxWidth ,maxWidth:'100%'});
			$("#list2").setGridWidth(windwoWindth, false);
		}
	              //-------- 그리드 hight ------------------------------
		var windowHeight = $(window).height()-400;           // 마이너스값 수정. 
		$("#list1").setGridHeight(windowHeight/2, true);
		$("#list2").setGridHeight(windowHeight/2, true);
	              //---------------------------------------------------
			
	}).trigger('resize');
	
	
	//테스트단계 select box 조회
	if($("#projNo").val()){
				
    	$.ajax({
			type : "POST",
			url : "msg.cmn.getListTestStgeName.do",
			data:{"projNo":$("#projNo").val()},
			success: function(xhr){
				
				//테스트단계명 select box 데이터삭제
				$("#testStgeName option:gt(0)").remove();
				
				//오류코드 처리
				if(xhr.errCd){
					alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
				} else {
					//테스트단계명 추가
					for(var i = 0 ; i < xhr.list.length ; i++){
						$("#testStgeName").append("<option value='"+xhr.list[i].testStgeName+"'>"+xhr.list[i].testStgeName+"</option>");
						$("#testStgeName").val($("#sessionTestStgeName").val());
					}
					
					getListMyFlaw();
				}
			},
			error: function (request, status, error) { 
				 alert("테스트단계 조회중에 오류가 발생하였습니다.[" + error + "]"); 
			}
		});
	}
});

//전역변수
var contextCi1;    // cell 인덱스
var contextRowid1; // row id
function initGrid1()
{
    jQuery(".jqgrow", "#list1").contextMenu('myMenu1', {
        bindings: {
            'moveTest': function(t) {
				moveTest1();
            },
            'moveReport': function(t) { 
            	moveReport1();
            }
            
        },
        onContextMenu : function(event, menu) 
        {
            var getCellIndex = function (cell) { 
	            var c = $(cell); 
	            if (c.is('tr')) { return -1; } 
	            c = (!c.is('td') && !c.is('th') ? c.closest("td,th") : c)[0]; 
	            if ($.browser.msie) { return $.inArray(c, c.parentNode.cells); } 
	            return c.cellIndex; 
            };
            
            contextCi1 = getCellIndex(event.target); 
            contextRowid1 = $(event.target).parent("tr").attr("id"); 
            var grid = $("#list1"); 
            grid.setSelection(contextRowid1); 
            return true; 
        }
  });             
}
   
function moveTest1() {
	//테스트 케이스관리
	$.cookie('top_menu', "top_menu_01"); //cookie를 셋트
	$.cookie('left_menu', "leftmenu_1_4"); //cookie를 셋트
	
	window.location = "msg.tcmng.tcmng.do?tsCaseID=" + $("#list1").getCell(contextRowid1,'tsCaseId');
}

function moveReport1() {
	var url = "msg.report.reportDetail.do?";
	var param = "gubun=01";
	param    += "&tscaseid="+$("#list1").getCell(contextRowid1,'tsCaseId');
	param    += "&acmplnth="+$("#list1").getCell(contextRowid1,'acmplNth');
	param    += "&tsdataid="+$("#list1").getCell(contextRowid1,'tsDataId');
	param    += "&tsdataacmplnth="+$("#list1").getCell(contextRowid1,'tsdataAcmplNth');
	param    += "&tabgubun=4";
	param    += "&defNo="+$("#list1").getCell(contextRowid1,'defNo');
	
	window.open(url+param,"결과상세보고서","location=no,resizable=no,status=no,width=980,height=770");
	//window.showModalDialog(url+param,window,'center:yes;dialogWidth=980px; dialogHeight=800px; scroll=no; status=no; help=no; resizable:no; ');
}

//전역변수
var contextCi2;    // cell 인덱스
var contextRowid2; // row id
function initGrid2()
{
    jQuery(".jqgrow", "#list2").contextMenu('myMenu2', {
        bindings: {
            'moveTest': function(t) {
				moveTest2();
            },
            'moveReport': function(t) { 
            	moveReport2();
            }
            
        },
        onContextMenu : function(event, menu) 
        {
            var getCellIndex = function (cell) { 
	            var c = $(cell); 
	            if (c.is('tr')) { return -1; } 
	            c = (!c.is('td') && !c.is('th') ? c.closest("td,th") : c)[0]; 
	            if ($.browser.msie) { return $.inArray(c, c.parentNode.cells); } 
	            return c.cellIndex; 
            };
            
            contextCi2 = getCellIndex(event.target); 
            contextRowid2 = $(event.target).parent("tr").attr("id"); 
            var grid = $("#list2"); 
            grid.setSelection(contextRowid2); 
            return true; 
        }
  });             
}
   
function moveTest2() {
	//테스트시나리오관리
	$.cookie('top_menu', "top_menu_01"); //cookie를 셋트
	$.cookie('left_menu', "leftmenu_1_5"); //cookie를 셋트
	
	window.location = "msg.tsmng.tsmng.do?tssnroId=" + $("#list2").getCell(contextRowid2,'tsSnrioId');
}

function moveReport2() {
	var url = "msg.report.reportDetail.do?";
	var param = "gubun=02";
	param    += "&tssnrioid="+$("#list2").getCell(contextRowid2,'tsSnrioId');
	param    += "&acmplnth="+$("#list2").getCell(contextRowid2,'acmplNth');
	param    += "&tsdataid="+$("#list2").getCell(contextRowid2,'tsDataId');
	param    += "&tsdataacmplnth="+$("#list2").getCell(contextRowid2,'tsdataAcmplNth');
	param    += "&tabgubun=4";
	param    += "&defNo="+$("#list2").getCell(contextRowid2,'defNo');
	
	window.open(url+param,"결과상세보고서","location=no,resizable=no,status=no,width=980,height=770");
	//window.showModalDialog(url+param,window,'center:yes;dialogWidth=980px; dialogHeight=800px; scroll=no; status=no; help=no; resizable:no; ');
}

//나의결함 전체조회
function getListMyFlaw(){
	getListMyTCFlaw();
	getListMyTSFlaw();
}

//테스트케이스 나의결함조회
function getListMyTCFlaw(){
	
	var projNo;
	if($("#projNo").css("color") == "#ababab"){
		projNo = ""; 
	} else {
		projNo = $("#projNo").val();
	}
	
	var param = {projNo:projNo,
			 	testStgeName:$("#testStgeName").val(),
			 	defCd:$("#defCd1").val()};

	$('#list1').jqGrid('setGridParam',{url:"msg.flaw.getListMyTCFlaw.do", datatype:"json", postData:param, page:1});
	$('#list1').trigger("reloadGrid");
}

//테스트시나리오 나의결함조회
function getListMyTSFlaw(){
	
	var projNo;
	if($("#projNo").css("color") == "#ababab"){
		projNo = ""; 
	} else {
		projNo = $("#projNo").val();
	}
	
	var param = {projNo:projNo,
				 testStgeName:$("#testStgeName").val(),
				 defCd:$("#defCd2").val()};

	$('#list2').jqGrid('setGridParam',{url:"msg.flaw.getListMyTSFlaw.do", datatype:"json", postData:param, page:1});
	$('#list2').trigger("reloadGrid");
}

//프로젝트조회 팝업 호출
function openProjPop(){
	//프로젝트조회 팝업
    var url = "msg.cmn.projPop.do";
    var returnValue = window.showModalDialog(url,window,'center:yes;dialogWidth=950px; dialogHeight=570px; scroll=no; status=no; help=no; resizable:no; ');
    
    if(returnValue != null){
    	//프로젝트조회후 선택된 값이 있을경우
    	//alert("프로젝트번호 : "+returnValue[0]+", 프로젝트명 : "+returnValue[1]+", 프로젝트시작일 : "+returnValue[2]+", 프로젝트종료일 : "+returnValue[3]);
    	$("#projNo").val(returnValue[0]);	//프로젝트번호
    	$('#projNo').css({'color':'#000'});
    	$("#projName").val(returnValue[1]);	//프로젝트명
    	
    	//프로젝트조회후 테스트단계 select box 조회
    	if(returnValue[0] != ''){
	    	$.ajax({
				type : "POST",
				url : "msg.cmn.getListTestStgeName.do",
				data:{"projNo":returnValue[0]},
				success: function(xhr){
					
					//테스트단계명 select box 데이터삭제
					$("#testStgeName option:gt(0)").remove();
					
					//오류코드 처리
					if(xhr.errCd){
						alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
					} else {
						//테스트단계명 추가
						for(var i = 0 ; i < xhr.list.length ; i++){
							$("#testStgeName").append("<option value='"+xhr.list[i].testStgeName+"'>"+xhr.list[i].testStgeName+"</option>");
						}
						
						getListMyFlaw();
					}
				},
				error: function (request, status, error) { 
					 alert("테스트단계 조회중에 오류가 발생하였습니다.[" + error + "]"); 
				}
			});
    	}
    }
}

//프로젝트정보 삭제
function deleteProj(){
	
	$('#projNo').val("== 전체 ==");	//프로젝트번호
	$('#projNo').css({'color':'#ababab'});
	
	$("#projName").val("");	//프로젝트명
	//단계명
	$("#testStgeName option:gt(0)").remove();
}