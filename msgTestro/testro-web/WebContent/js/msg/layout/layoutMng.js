
var maxWidth= 880; //전체사이즈(그리드전체사이즈)
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

var lastsel3;

//초기로딩
$(document).ready( function(){

	gridExcelInit();	//엑셀입출력 초기화
	$("#refTranCdTitle").hide();	//헤더부참조코드 숨김
	
	$("#list1").jqGrid({
		datatype: '',
		mtype:'POST',    // 한글 인코딩 깨지는 문제 방지하기 위해 POST로 쓴다
	   	colNames:['입출력구분', '필드명', '데이터','타입','속성(HIDDEN)','사이즈','설명','정렬타입','채움값','필수여부(HIDDEN)','편집여부(HIDDEN)','반복부명','필드가이드(HIDDEN)'],
	   	colModel:[
	   		{name:'fldIO',index:'fldIO', width:80, align:'center', editable:true, edittype:'select', formatter:'select', editoptions: { value: "I:I;B:I/O;O:O" }, sortable:false },
	   		{name:'fldName',index:'fldName', width:170, align:'left', editable:true, editoptions:{maxlength:"200"}, sortable:false},
	   		{name:'fldData',index:'fldData', width:50, align:'left', editable:true, editoptions:{maxlength:"4000"}, sortable:false},
	   		{name:'fldType',index:'fldType', width:40, align:'center', editable:true, edittype:'select', editoptions: { value: "text:text;num:num;hex:hex" }, sortable:false },		
	   		{name:'fldAttrib2',index:'fldAttrib2', width:70, align:'center', editable:true, edittype:'select',formatter:'select', editoptions: { value: "01:일반;02:체크포인트" }, sortable:false, hidden:true },		
	   		{name:'tscsFldSize',index:'tscsFldSize', width:50, align:'right', editable:true, editoptions:{maxlength:"4", style:"text-align:right"}, sortable:false},
	   		{name:'tscsFldDesc',index:'tscsFldDesc', width:170, align:'left', editable:true, editoptions:{maxlength:"300"}, sortable:false},
	   		{name:'ranType',index:'ranType', width:60, align:'center', editable:true, edittype:'select', formatter:'select', editoptions: { value: "L:좌측정렬;R:우측정렬" }, sortable:false },
	   		{name:'fillData',index:'fillData', width:50, align:'left', editable:true, editoptions:{maxlength:"1"}, sortable:false},
	   		{name:'reqYn',index:'reqYn', width:60, align:'center', editable:true, edittype:'select', formatter:'select', editoptions: { value: "Y:Y;N:N" }, sortable:false, hidden:true },
	   		{name:'editYn',index:'editYn', width:60, align:'center', editable:true, edittype:'select', formatter:'select', editoptions: { value: "Y:Y;N:N" }, sortable:false, hidden:true },
	   		{name:'rptName',index:'rptName', width:150, align:'left', editable:true, editoptions:{maxlength:"200"}, sortable:false},
	   		{name:'rmark',index:'rmark', width:300, align:'left', editable:true, editoptions:{maxlength:"4000"}, sortable:false, hidden:true}
	   	],
	   	gridview: true,	//can not use treeGrid, subGrid, or afterInsertRow event
	   	rownumbers: true, //scroll paging config  
		scroll:1, //scroll paging config 
		pager: '#pager1', //record text area
		rowNum:1000000, //scroll paging config -1로 설정시 조회를 계속하면 오류가 나서 백만으로 세팅
		scrollrows : true, //포커스이동시  스크롤 자동맞춤.
		editurl:'clientArray',
	   	viewrecords: true, 
	   	jsonReader : {
	   	    root: "rows",
	   	    page: false,
	   	    total: false,
	   	    records: false,
	   	    repeatitems: false,
	   	    cell: false
	   	},
		loadComplete: function(xhr){	//레이아웃 조회시 기본정보 세팅
	   		
	   		if (xhr.errCd){
	   			alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
	   			return;
	   		}
	   		
			$("#chnlDstcd").val(xhr.layout.chnlDstcd);	//채널구분코드(Hidden)
	        $("#chnlDstName").text(xhr.layout.chnlDstcdName);	//채널구분명
	        $("#tranCd").text(xhr.layout.tranCd);	//거래코드
	        $("#tranName").text(xhr.layout.tranName);	//거래명
	        $("#fldDiv").val(xhr.layout.fldDiv);	//필드구성
	        $("#fldDivName").text(xhr.layout.fldDivName);	//필드구성명
	        if(xhr.layout.fldDiv == "02"){	//개별부일경우 헤더부참조코드를 표시한다
	        	$("#tranCdTitle").text("거래코드 :").attr('width','65');
	        	$("#tranNameTitle").text("거래명 :").attr('width','110');
	        	$("#refTranCdTitle").show();
	        	$("#refTranCd").text(xhr.layout.refTranCd);	//헤더부참조코드
	        } else {
	        	$("#tranCdTitle").text("헤더부코드 :").attr('width','80');
	        	$("#tranNameTitle").text("헤더부명 :").attr('width','65');
	        	$("#refTranCdTitle").hide();
	        	$("#refTranCd").text(xhr.layout.refTranCd);	//헤더부참조코드
	        }
	        $("#writeId").val(xhr.layout.writeId);	//작성자ID
	        $("#writeName").val(xhr.layout.writeName);	//작성자명
	        $("#cretnYMS").val(xhr.layout.cretnYMS);	//생성일시
	        
	        //저장버튼 활성화
	        $("#Image58").unbind('mouseover');
	    	$("#Image58").unbind('click');
	    	$("#Image58").click(registerLayout);
	    	$("#Image58").bind('mouseover',function(){
	    		MM_swapImage('Image58','','images/btn_savetc_02.jpg',1);
	    	});;
	    	$("#Image58 img").attr("src","images/btn_savetc_01.jpg");
	        //삭제버튼 활성화
	        $("#Image31").unbind('mouseover');
	    	$("#Image31").unbind('click');
	    	$("#Image31").click(deleteLayout);
	    	$("#Image31").bind('mouseover',function(){
	    		MM_swapImage('Image31','','images/btn_del_02.jpg',1);
	    	});;
	    	$("#Image31 img").attr("src","images/btn_del_01.jpg");
	        //초기화버튼 활성화
	        $("#Image59").unbind('mouseover');
	    	$("#Image59").unbind('click');
	    	$("#Image59").click(init);
	    	$("#Image59").bind('mouseover',function(){
	    		MM_swapImage('Image59','','images/btn_initialize_02.jpg',1);
	    	});;
	    	$("#Image59 img").attr("src","images/btn_initialize_01.jpg");
	        
	        $("#btnArea").attr("disabled", "");	//그리드버튼 활성화
	        $("#btnArea2").attr("disabled", "");	//그리드버튼 활성화
		},
		ondblClickRow: function (rowid, iRow, iCol, e) { //더블클릭 이벤트(edit)
			if("0" != iCol){ // 싱글선택:0 , 멀티선택:0,1
				jQuery('#list1').jqGrid('editRow',rowid,true); 
				$("input, select",e.target).focus();   // 포커스위치 설정
				lastsel3=rowid;
			} 
		},
		onCellSelect: function(rowid, index, contents, event) {		//클릭저장
			$("#list1").jqGrid("saveRow",lastsel3);
		},
		onRightClickRow: function (rowid, iRow, iCol, e) {//우클릭 브라우져메뉴 block
		}
	});
	
	
	//윈도우사이즈와 맞춰 조절됨
	$(window).bind('resize', function() {
		var windwoWindth = $(window).width()-leftTemp;
		if (windwoWindth > maxWidth) {
			$("#list1").setGridWidth(windwoWindth, true);
		} else {
			jQuery("#list1").jqGrid('gridResize',{minWidth:maxWidth ,maxWidth:'100%'});
			$("#list1").setGridWidth(windwoWindth, false);
		}
	              //-------- 그리드 hight ------------------------------
		var windowHeight = $(window).height()-340;           // 마이너스값 수정. 
		$("#list1").setGridHeight(windowHeight, true);         
	              //---------------------------------------------------
			
	}).trigger('resize');
	
});

//신규생성
function newLayout(){
	
	var isConfirmYn = true;
	if($("#btnArea").attr("disabled") == false){
		isConfirmYn = confirm("작업중인 모든 정보가 초기화 됩니다.\n\n신규생성하시겠습니까?");
	}
	
	if(isConfirmYn){
		$("#chnlDstcd").val("");	//채널구분코드(Hidden)
        $("#chnlDstName").text("");	//채널구분명
        $("#tranCd").text("");	//거래코드
        $("#tranName").text("");	//거래명
        $("#fldDiv").val("");	//필드구성
        $("#fldDivName").text("");	//필드구성명
        $("#refTranCd").text("");	//헤더부참조코드
        $('#list1').jqGrid('setGridParam',{url:''});
        $("#list1").jqGrid('clearGridData');	//그리드데이터삭제
        
        $("#writeId").val("");	//작성자Id
        $("#writeName").val("");	//작성자명
        $("#cretnYMS").val("");	//생성일시
        
        //저장버튼 활성화
        $("#Image58").unbind('mouseover');
    	$("#Image58").unbind('click');
    	$("#Image58").click(registerLayout);
    	$("#Image58").bind('mouseover',function(){
    		MM_swapImage('Image58','','images/btn_savetc_02.jpg',1);
    	});;
    	$("#Image58 img").attr("src","images/btn_savetc_01.jpg");
        //삭제버튼 비활성화
        $("#Image31").unbind('mouseover');
    	$("#Image31").unbind('click');
    	$("#Image31 img").attr("src","images/btn_del_03.jpg");
        //초기화버튼활성화
        $("#Image59").unbind('mouseover');
    	$("#Image59").unbind('click');
    	$("#Image59").click(init);
    	$("#Image59").bind('mouseover',function(){
    		MM_swapImage('Image59','','images/btn_initialize_02.jpg',1);
    	});;
    	$("#Image59 img").attr("src","images/btn_initialize_01.jpg");
    	MM_swapImage();
        
        $("#btnArea").attr("disabled", "");	//그리드버튼 활성화
        $("#btnArea2").attr("disabled", "");	//그리드버튼 활성화
        $("#refTranCdTitle").hide();	//헤더부참조코드 숨김
        
        $('#flowMsg').html('전문을 편집 후 저장 할 수 있습니다.');
	}
}

//불러오기
function getLayout(){
	//레이아웃조회 팝업
    var url = "msg.layout.layout.do?fldDiv=all";
    var returnValue = window.showModalDialog(url,window,'center:yes;dialogWidth=960px; dialogHeight=665px; dialogLeft=100px; dialogTop=50px; scroll=no; status=no; help=no; resizable:no;');
    
    if(returnValue != null){
		var param = {chnlDstcd:returnValue[0],
					tranCd:returnValue[1]};
		
		$('#list1').jqGrid('setGridParam',{url:"msg.layout.getLayout.do?"+param, datatype:"json", postData:param});
		$('#list1').trigger("reloadGrid");
		
		$('#flowMsg').html('전문을 편집 후 저장 할 수 있습니다.');
    }
}

//저장
function registerLayout(){
	
	//현재데이터 편집을 save
	$("#list1").jqGrid("saveRow",$("#list1").jqGrid('getGridParam', "selrow" ));
	
	var gridData = $("#list1").jqGrid('getRowData');	//그리드의 데이터를 얻는다
	
	//데이터 입력확인
	if($("#btnArea").attr("disabled") == true || gridData.length == 0){
		alert("입력된 데이터가 없습니다.");
		return;
	}
	
	//그리드 필수값 체크
	for(var i = 0 ; i < gridData.length ; i++){
		if(gridData[i].fldName == ''){	//필드명
			alert("필드명을 입력하세요");
			//rowid배열
			var ids = $("#list1").jqGrid("getDataIDs");
			//선택행 변경
			$("#list1").jqGrid('setSelection', ids[i], true);
			jQuery('#list1').jqGrid('editRow',ids[i],true);
			lastsel3 = ids[i];
			return;
		}
		
		if(gridData[i].tscsFldSize == ''){	//필드사이즈
			alert("필드사이즈를 입력하세요");
			var ids = $("#list1").jqGrid("getDataIDs");
			//선택행 변경
			$("#list1").jqGrid('setSelection', ids[i], true);
			jQuery('#list1').jqGrid('editRow',ids[i],true);
			lastsel3 = ids[i];
			return;
		}
		
		//필드사이즈의 최대크기 체크
		if(gridData[i].tscsFldSize > 4000){
			alert("필드사이즈는 4000을 초과할 수 없습니다");
			var ids = $("#list1").jqGrid("getDataIDs");
			//선택행 변경
			$("#list1").jqGrid('setSelection', ids[i], true);
			jQuery('#list1').jqGrid('editRow',ids[i],true);
			lastsel3 = ids[i];
			return;
		}
		
		var fldDataLength = 0;	//필드데이터의 길이를 구한다(한글은 2byte)
		for(var j = 0 ; j < gridData[i].fldData.length ; j++){
            chr = escape(gridData[i].fldData.charAt(j));
            if(chr.length < 6){
            	//한글아님 1byte
            	fldDataLength++;
            } else {
            	//한글 2byte
            	fldDataLength = fldDataLength + 2;
            }
		}
		
		//필드데이터의 길이체크
		if(fldDataLength > gridData[i].tscsFldSize){
			alert("필드데이터의 길이가 필드사이즈보다 큽니다");
			var ids = $("#list1").jqGrid("getDataIDs");
			//선택행 변경
			$("#list1").jqGrid('setSelection', ids[i], true);
			jQuery('#list1').jqGrid('editRow',ids[i],true);
			lastsel3 = ids[i];
			return;
		}
		
		//반복부명이 필드명에 존재하는지 체크
		if(gridData[i].rptName != ''){
			for(var j = 0 ; j < gridData.length ; j++){
				if(gridData[j].rptName == '' &&
					gridData[j].fldName == gridData[i].rptName &&
				   (gridData[j].fldDiv == gridData[i].fldDiv || gridData[j].fldDiv == 'B')){
					break;
				}
				
				if(j == gridData.length-1){
					alert("반복부명에 입력된 반복부회차필드가 존재하지 않습니다");
					var ids = $("#list1").jqGrid("getDataIDs");
					//선택행 변경
					$("#list1").jqGrid('setSelection', ids[i], true);
					jQuery('#list1').jqGrid('editRow',ids[i],true);
					lastsel3 = ids[i];
					return;
				}
			}
		}
	}
	
	//저장팝업
	var param = {chnlDstcd:$("#chnlDstcd").val(),
			tranCd:$("#tranCd").text(),
			tranName:$("#tranName").text(),
			fldDiv:$("#fldDiv").val(),
			refTranCd:$("#refTranCd").text()};
	
    var url = "msg.layout.registerLayoutPop.do";
    var returnValue = window.showModalDialog(url,param,'center:yes;dialogWidth=600px; dialogHeight=210px; location=no; scroll=no; status=no; help=no; resizable=no; ');
    
    if(returnValue != null){
    	
    	//필드값세팅
    	$("#chnlDstcd").val(returnValue[0]);	//채널구분코드
    	$("#chnlDstName").text(returnValue[1]);	//채널구분명
    	$("#tranCd").text(returnValue[2]);	//거래코드
    	$("#tranName").text(returnValue[3]);	//거래명
    	$("#fldDiv").val(returnValue[4]);	//필드구성
    	$("#fldDivName").text(returnValue[5]);	//필드구성명
    	if(returnValue[4] == "02"){	//개별부일경우 헤더부참조코드를 표시한다
    		$("#tranCdTitle").text("거래코드 :");
        	$("#tranNameTitle").text("거래명 :");
        	$("#refTranCdTitle").show();
        	$("#refTranCd").text(returnValue[6]);	//헤더부참조코드
        } else {
        	$("#tranCdTitle").text("헤더부코드 :");
        	$("#tranNameTitle").text("헤더부명 :");
        	$("#refTranCdTitle").hide();
        	$("#refTranCd").text(returnValue[6]);	//헤더부참조코드
        }
    	
		//파라미터
		var chnlDstcd = $("#chnlDstcd").val();	//채널구분코드
		var tranCd = $("#tranCd").text();	//거래코드
	    var tranName = $("#tranName").text();	//거래명
	    var fldDiv = $("#fldDiv").val();	//필드구성
	    var refTranCd = $("#refTranCd").text();	//헤더부참조코드
	    var writeId = $("#writeId").val();	//작성자Id
	    var writeName = $("#writeName").val();	//작성자명
	    var cretnYMS = $("#cretnYMS").val();	//생성일시
		var postData = JSON.stringify(gridData);
		
		$.ajax({
			type : "POST",
			url : "msg.layout.registerLayout.do",
			data:{"jgGridData":postData,
				  "chnlDstcd":chnlDstcd,
				  "tranCd":tranCd,
				  "tranName":tranName,
				  "fldDiv":fldDiv,
				  "refTranCd":refTranCd,
				  "writeId":writeId,
				  "writeName":writeName,
				  "cretnYMS":cretnYMS},
			success: function(xhr){
				//오류코드 처리
				if(xhr.errCd){
					alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
				} else {
					alert("저장되었습니다");
					//삭제버튼 활성화
			        $("#Image31").unbind('mouseover');
			    	$("#Image31").unbind('click');
			    	$("#Image31").click(deleteLayout);
			    	$("#Image31").bind('mouseover',function(){
			    		MM_swapImage('Image31','','images/btn_del_02.jpg',1);
			    	});;
			    	$("#Image31 img").attr("src","images/btn_del_01.jpg");
			        
				}
			},
			error: function (request, status, error) { 
				 alert("전문 저장중에 오류가 발생하였습니다.[" + error + "]"); 
			}
		});
		
		$('#flowMsg').html('전문을 편집 후 저장 할 수 있습니다.');
    }
}

//삭제
function deleteLayout(){
	
	//필수값 체크
	if($("#tranCd").text() == ''){	//거래코드
		alert("삭제할 거래코드가 없습니다");
		return;
	}
	
	if(confirm("삭제 후 해당 전문레이아웃은 복구할 수 없습니다.\n해당전문을 정말로 삭제하시겠습니까?")){
		//파라미터
		var chnlDstcd = $("#chnlDstcd").val();	//채널구분코드
		var tranCd = $("#tranCd").text();	//거래코드
		var tranName = $("#tranName").val();	//거래명
		
		$.ajax({
			type : "POST",
			url : "msg.layout.deleteLayout.do",
			data:{"chnlDstcd":chnlDstcd,
				  "tranCd":tranCd,
				  "tranName":tranName},
			success: function(xhr){
				//오류코드 처리
				if(xhr.errCd){
					alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
				} else {
					alert("삭제되었습니다");
					//초기화
					$("#chnlDstcd").val("");	//채널구분코드(Hidden)
			        $("#chnlDstName").text("");	//채널구분명
			        $("#tranCd").text("");	//거래코드
			        $("#tranName").text("");	//거래명
			        $("#fldDiv").val("");	//필드구성
			        $("#fldDivName").text("");	//필드구성명
			        $("#refTranCd").text("");	//헤더부참조코드
			        $('#list1').jqGrid('setGridParam',{url:''});
			        $("#list1").jqGrid('clearGridData');	//그리드데이터삭제
			        $("#writeId").val("");	//작성자Id
			        $("#writeName").val("");	//작성자명
			        $("#cretnYMS").val("");	//생성일시
			        
			        //저장버튼 비활성화
			        $("#Image58").unbind('mouseover');
			    	$("#Image58").unbind('click');
			    	$("#Image58 img").attr("src","images/btn_savetc_03.jpg");
			        //삭제버튼 비활성화
			        $("#Image31").unbind('mouseover');
			    	$("#Image31").unbind('click');
			    	$("#Image31 img").attr("src","images/btn_del_03.jpg");
			        //초기화버튼 비활성화
			        $("#Image59").unbind('mouseover');
			    	$("#Image59").unbind('click');
			    	$("#Image59 img").attr("src","images/btn_initialize_03.jpg");
			    	MM_swapImage();
			        
			        $("#btnArea").attr("disabled", "disabled");	//그리드버튼 비활성화
			        $("#btnArea2").attr("disabled", "disabled");	//그리드버튼 비활성화
				}
			},
			error: function (request, status, error) { 
				 alert("전문 삭제중에 오류가 발생하였습니다.[" + error + "]"); 
			}
		});
	}
}

//초기화
function init(){
	if(confirm("초기화를 하게되면 작업중인 모든 데이터가 사라지게 됩니다.\n\n초기화 하시겠습니까?")){
		$("#chnlDstcd").val("");	//채널구분코드(Hidden)
        $("#chnlDstName").text("");	//채널구분명
        $("#tranCd").text("");	//거래코드
        $("#tranName").text("");	//거래명
        $("#fldDiv").val("");	//필드구성
        $("#fldDivName").text("");	//필드구성명
        $("#refTranCd").text("");	//헤더부참조코드
        $('#list1').jqGrid('setGridParam',{url:''});
        $("#list1").jqGrid('clearGridData');	//그리드데이터삭제
        
        $("#writeId").val("");	//작성자Id
        $("#writeName").val("");	//작성자명
        $("#cretnYMS").val("");	//생성일시
        
        //저장버튼 비활성화
        $("#Image58").unbind('mouseover');
    	$("#Image58").unbind('click');
    	$("#Image58 img").attr("src","images/btn_savetc_03.jpg");
        //삭제버튼 비활성화
        $("#Image31").unbind('mouseover');
    	$("#Image31").unbind('click');
    	$("#Image31 img").attr("src","images/btn_del_03.jpg");
        //초기화버튼 비활성화
        $("#Image59").unbind('mouseover');
    	$("#Image59").unbind('click');
    	$("#Image59 img").attr("src","images/btn_initialize_03.jpg");
    	MM_swapImage();
    	
        $("#btnArea").attr("disabled", "disabled");	//그리드버튼 비활성화
        $("#btnArea2").attr("disabled", "disabled");	//그리드버튼 비활성화
        
        $('#flowMsg').html('신규생성 및 불러오기를 하실 수 있습니다.');
	}
}

//행추가
function insertRow(){
	
	if($("#btnArea").attr("disabled") == true){	//버튼 비활성 체크
		return;
	}
	
	var maxKey = 0;
	var ids = $("#list1").getDataIDs();
	$.each(ids, function (index, value) {
		if(parseInt(value) > parseInt(maxKey)){
			maxKey = value;
		}
	});
	
	$("#list1").jqGrid('addRowData',parseInt(maxKey)+1,{fldIO:"B", fldType:"text", fldAttrib2:"01", ranType:"L", reqYn:"N", editYn:"Y"});
	$("#list1").jqGrid('setSelection', parseInt(maxKey)+1);
}

//행삭제
function deleteRow(){
	
	if($("#btnArea").attr("disabled") == true){	//버튼 비활성 체크
		return;
	}
	
	if($("#list1").jqGrid('getGridParam', "selrow" ) == null){
		alert("선택된 행이 없습니다");
		return;
	}
	
	//rowid배열
	var ids = $("#list1").jqGrid("getDataIDs");
	
	//현재행의 rowid
	var curRowid = $("#list1").jqGrid('getGridParam', "selrow" );

	//아래행의 rowid를 찾고 아래행이 없으면 위의행의 rowid를 찾는다
	var moveRowid;
	for(var i = 0 ; i < ids.length ; i++){
		if(ids[i] == curRowid){
			if(i == ids.length - 1){
				if(i == 0){
					break;
				}
				moveRowid = ids[i-1];
				break;
			}
			moveRowid = ids[i+1];
			break;
		}
	}
	
	$("#list1").jqGrid('delRowData', curRowid);
	
	$("#list1").jqGrid('setSelection', moveRowid);
}

//행 위로 이동
function upRow(){
	
	//rowid배열
	var ids = $("#list1").jqGrid("getDataIDs");
	
	//현재행의 rowid
	var curRowid = $("#list1").jqGrid('getGridParam', "selrow" );

	//윗행의 rowid를 찾는다
	var upRowid;
	for(var i = 0 ; i < ids.length ; i++){
		if(ids[i] == curRowid){
			if(i == 0){
				return;
			}
			upRowid = ids[i-1];
			break;
		}
	}
	
	//현재데이터 편집을 save
	$("#list1").jqGrid("saveRow",curRowid);
	
	//데이터 얻기
	var curRowData = $("#list1").jqGrid('getRowData', curRowid);
	var upRowData = $("#list1").jqGrid('getRowData', upRowid);
	
	//데이터 교체
	$("#list1").jqGrid('setRowData', curRowid, upRowData);
	$("#list1").jqGrid('setRowData', upRowid, curRowData);
	
	//선택행 변경
	$("#list1").jqGrid('setSelection', upRowid, true);
}

//행 아래로 이동
function downRow(){
	
	//rowid배열
	var ids = $("#list1").jqGrid("getDataIDs");
	
	//현재행의 rowid
	var curRowid = $("#list1").jqGrid('getGridParam', "selrow" );

	//아래행의 rowid를 찾는다
	var downRowid;
	for(var i = 0 ; i < ids.length ; i++){
		if(ids[i] == curRowid){
			if(i == ids.length - 1){
				return;
			}
			downRowid = ids[i+1];
			break;
		}
	}
	
	//현재데이터 편집을 save
	$("#list1").jqGrid("saveRow",curRowid);
	
	//데이터 얻기
	var curRowData = $("#list1").jqGrid('getRowData', curRowid);
	var upRowData = $("#list1").jqGrid('getRowData', downRowid);
	
	//데이터 교체
	$("#list1").jqGrid('setRowData', curRowid, upRowData);
	$("#list1").jqGrid('setRowData', downRowid, curRowData);
	
	//선택행 변경
	$("#list1").jqGrid('setSelection', downRowid, true);
}

//헤더리스트 조회
function getHeaderList(){
	
	//필수값 체크
	if($("#tranCd").text() == ''){	//거래코드
		alert("선택된 거래코드가 없습니다");
		return;
	}
	
	//레이아웃조회 팝업
    var url = "msg.layout.layout.do?chnlDstcd="+$("#chnlDstcd").val()+"&fldDiv=01";
    var returnValue = window.showModalDialog(url,window,'center:yes;dialogWidth=960px; dialogHeight=665px; dialogLeft=100px; dialogTop=50px; scroll=no; status=no; help=no; resizable:no;');
    
    if(returnValue != null){
		$("#refTranCd").val(returnValue[1]);
    }
}

//엑셀내려받기
function exportExcel() {
	
	if($("#btnArea2").attr("disabled") == true) {
		return;
	}
	
	//현재데이터 편집을 save
	$("#list1").jqGrid("saveRow",$("#list1").jqGrid('getGridParam', "selrow" ));
	
	gridExportExcel('list1', [4], '전문관리');

}

//엑셀업로드 팝업 호출
function importExcel() {
	
	if($("#btnArea2").attr("disabled") == true) {
		return;
	}
	
	MM_openBrWindow('cmn.grid.popImportExcel.do','엑셀업로드','status=yes,width=520,height=155');
}

//mapping callback함수 : 변수명은 "mappingExcel"로 정의해야 합니다.
var mappingExcel = function (excelRowData, excelIndex){
	
	if(excelIndex == 0) $("#list1").jqGrid('clearGridData');	//그리드데이터삭제
	
	//데이터 그리드칼럼 index name 세팅
	var colNames = $("#list1").jqGrid('getGridParam', "colNames" );
	var colModel = $("#list1").jqGrid('getGridParam', "colModel" );
	
	for(var index in excelRowData){
		for(var i in colNames){
			if(colNames[i].split(" ").join("") == index){
				excelRowData[colModel[i].name] = excelRowData[index];
				break;
			} 
		}
	}
	
	//그리드에 추가
	var maxKey = 0;
	var ids = $("#list1").getDataIDs();
	$.each(ids, function (index, value) {
		if(parseInt(value) > parseInt(maxKey)){
			maxKey = value;
		}
	});
	$("#list1").jqGrid('addRowData',parseInt(maxKey)+1,excelRowData);
};