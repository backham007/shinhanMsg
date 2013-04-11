var extBoolean = false;		//true:실행가능, false:실행불가
var regBoolean = false;		//true:저장가능, false:저장불가
var clrBoolean = false;		//true:화면초기화가능, false:화면초기화불가
var loopExecuteIdx = 0;		//실행시 loop 위치값을 가진다.
var regStatus = false;		//true:진행중, false:미진행중
var lastsel2;

var maxWidth= 1100; //전체사이즈(그리드전체사이즈)
var leftTemp = 230; //left메뉴사이즈
$(document).ready(function(){
	if($("#tsCaseID").val() != ""){
		tsCaseGrid();
	}else{
		if($("#tsdataID").val() != ""){
			tsDataGrid();
		}else{
			defaultGrid();
		}
	}
	gridResize();
	$('#flowMsg').html('신규생성 및 불러오기를 하실 수 있습니다.');
});

function gridResize(){
	$(window).bind('resize', function() {
		var windwoWindth = $(window).width()-leftTemp;
		if (windwoWindth > maxWidth) {
			$("#basicsList").setGridWidth(windwoWindth, false);
			$("#list").setGridWidth(windwoWindth, false);
		} else {
			jQuery("#basicsList").jqGrid('gridResize',{minWidth:maxWidth ,maxWidth:'100%'});
			$("#basicsList").setGridWidth(windwoWindth, false);
			jQuery("#list").jqGrid('gridResize',{minWidth:maxWidth ,maxWidth:'100%'});
			$("#list").setGridWidth(windwoWindth, false);
		}
		
		$("#basicsList").setGridHeight(41, true);
		
		var windowHeight = $(window).height()-480;           // 마이너스값 수정. 
		$("#list").setGridHeight(windowHeight, true);
	}).trigger('resize');
}


function bodyreload(){
	var hidenYn = $("body").attr("hideYn");
	if("Y" == hidenYn){ //left 메뉴 hidden
		leftTemp=55;
	}else{ //left 메뉴 show
		leftTemp=230;
	}
	$(window).trigger('resize');
}


//그리드 기본 보여주기
function defaultGrid(){
	//기본테스트 데이터 그리드
	jQuery("#basicsList").jqGrid({
		mtype:'POST',    // 한글 인코딩 깨지는 문제 방지하기 위해 POST로 쓴다
		datatype: "json",
	    colNames:[
					'테스트데이터ID' , 
					'테스트데이터명' ,
					'테스트데이터설명' ,
		],
	    colModel:[
					{name: 'tsdataID',index: 'TsdataID', width:188, editable:true, align:"center", sortable:false, key:true},
					{name: 'tsdataName',index: 'TsdataName', width:130, editable:true, align:"center", sortable:false},
					{name: 'tsdataDesc',index: 'TsdataDesc', width:233, editable:true, align:"center", sortable:false}
	    ],
	    viewrecords	: true,
	    height		: 23
	});
	
	//테스트케이스 구성 그리드
	jQuery("#list").jqGrid({
		mtype:'POST',    // 한글 인코딩 깨지는 문제 방지하기 위해 POST로 쓴다
		datatype: "json",
	    colNames:[
	              '테스트데이터ID' , 
	              '테스트데이터명' ,
	              '테스트데이터설명' ,
	              '체크<br/>포인트'
		],
	    colModel:[
					{name: 'tsdataID',index: 'TsdataID', width:130, editable:true, align:"left", sortable:false, key:true},
					{name: 'tsdataName',index: 'TsdataName', width:130, editable:true, align:"left", sortable:false},
					{name: 'tsdataDesc',index: 'TsdataDesc', width:150, editable:true, align:"left", sortable:false},
					{name: 'chkYN',index: 'chkYN', width:80, editable:true, align:"center", sortable:false}
	    ],
	    rownumbers	: true, 		//rownum
	   	multiselect	: true, //멀티셀렉트 설정
	    viewrecords	: true
	});
	$(".ui-jqgrid-sortable").css('height','auto');
	
	regBoolean = false;	//True:저장가능, False:저장불가
	extBoolean = false;	//True:실행가능, False:실행불가
	clrBoolean = false;		//true:화면초기화가능, false:화면초기화불가
	
	//그리드 리사이즈
	gridResize();
}


//테스트데이터 활용
function tsDataGrid(){
	var chnlDstcd = $("#chnlDstcd").val();
	var tranCd = $("#tranCd").val();
	var tranName = $("#tranName").val();
	
	$("#txtTranCD").html(tranCd);    	//헤더 정보 TEXT_거래코드
	$("#txtTranName").html(tranName);  	//헤더 정보 TEXT_거래코드명
	
	//기본테스트데이터
	$.ajax({
        type:"POST",
        async: false,
        data:{
				"chnlDstcd"	: chnlDstcd,
				"tranCd"	: tranCd
	    },
        dataType:"html",
        url:"msg.tcmng.getBasicsData.do",
        success:function(data, status) {
	    	// 오류코드 처리
			if (data.errCd){
				alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
				$('#basicsList').trigger('reloadGrid');
			}else{
				$("#basicsListDiv").empty();
				$("#basicsListDiv").html(data);
				$(".ui-jqgrid-sortable").css('height','auto');
			}
        },
        error:function(request, status) {
            alert(status);
        }
    });
	
	//테스트케이스 구성
	$.ajax({
        type:"POST",
        data:{
				"chnlDstcd"	: chnlDstcd,
				"tranCd"	: tranCd
	    },
        dataType:"html",
        async: false,
        url:"msg.tcmng.getLayoutDefault.do",
        success:function(data, status) {
	    	// 오류코드 처리
			if (data.errCd){
				alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
				$('#list').trigger('reloadGrid');
			}else{
		        $("#listDiv").html(data);
		        $(".ui-jqgrid-sortable").css('height','auto');
			}
        },
        error:function(request, status) {
            alert(status);
        }
    });	
	
	//기본테스트데이터 존재 여부 확인 위한 index
	var basicsGrid = $("#basicsList").jqGrid('getDataIDs');
	
	//기본테스트데이터 존재 시
	if( basicsGrid.length > 0 ) {
		var ret = jQuery("#basicsList").getRowData(0);
		ret.tsdataID = "신규생성";
		ret.chkYN = "미설정";
		var idx = $("list").jqGrid('getDataIDs'); //전체리스트의 id리스트
				
		jQuery("#list").jqGrid('addRowData',idx.length, ret);
		//체크포인트 밑줄, 손가락 표시
		jQuery('#list').find("#" + idx.length + " td[aria-describedby='list_chkYN']").css('cursor','pointer').css('text-decoration','underline').css('font','bold');
		//반복부 밑줄, 손가락 표시
		$.each(rptCol, function (index, value) {
			jQuery('#list').find("#" + idx.length + " td:eq("+(parseInt(value)+1)+")").css('cursor','pointer').css('text-decoration','underline').css('font','bold');
		});
		//jQuery("#list").jqGrid('setCellHtml', idx.length, "chkYN", "<a style='cursor:pointer;text-decoration: underline;'>미설정</a>");
	}
	
	//저장버튼 활성화
    $("#Image58").unbind('mouseover');
	$("#Image58").unbind('click');
	$("#Image58").click(doTcSave);
	$("#Image58").bind('mouseover',function(){
		MM_swapImage('Image58','','images/btn_savetc_02.jpg',1);
	});;
	$("#Image58 img").attr("src","images/btn_savetc_01.jpg");
    //초기화버튼 활성화
    $("#Image59").unbind('mouseover');
	$("#Image59").unbind('click');
	$("#Image59").click(reload);
	$("#Image59").bind('mouseover',function(){
		MM_swapImage('Image59','','images/btn_initialize_02.jpg',1);
	});;
	$("#Image59 img").attr("src","images/btn_initialize_01.jpg");
	
	$("#btnArea2").attr("disabled", "");
	$("#btnArea3").attr("disabled", "");
	
	regBoolean = true;	//True:저장가능, False:저장불가
	extBoolean = false;	//True:실행가능, False:실행불가
	clrBoolean = true;		//true:화면초기화가능, false:화면초기화불가
}

//결과보고서의 테스트케이스 보기
function tsCaseGrid(){
	var chnlDstcd 	= $("#chnlDstcd").val();
	var tranCd 		= $("#tranCd").val();
	var tranName 	= $("#tranName").val();
	var tsCaseID 	= $("#tsCaseID").val();
	var tsCaseName 	= $("#tsCaseName").val();
	var tsCaseDesc 	= $("#tsCaseDesc").val();
	
	$("#txtTranCD").html(tranCd);    		//헤더 정보 TEXT_거래코드
	$("#txtTranName").html(tranName);  		//헤더 정보 TEXT_거래코드명
	$("#txtTcID").html(tsCaseID);  			//헤더 정보 TEXT_테스트케이스ID
	$("#txtTcName").html(tsCaseName);  		//헤더 정보 TEXT_테스트케이스명
	$("#txtTcDesc").html(tsCaseDesc);		//헤더 정보 TEXT_테스트케이스설명
	
	//기본테스트데이터
	$.ajax({
        type:"POST",
        async: false,
        data:{
				"chnlDstcd"	: chnlDstcd,
				"tranCd"	: tranCd
	    },
        dataType:"html",
        url:"msg.tcmng.getBasicsData.do",
        success:function(data, status) {
	    	// 오류코드 처리
			if (data.errCd){
				alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
				$('#basicsList').trigger('reloadGrid');
			}else{
		        $("#basicsListDiv").html(data);
		        $(".ui-jqgrid-sortable").css('height','auto');
			}
        },
        error:function(request, status) {
            alert(status);
        }
    });
	
	//테스트케이스의 그리드 호출
	$.ajax({
        type:"POST",
        data:{"tsCaseID"	:tsCaseID,
                "chnlDstcd"	: chnlDstcd,
				"tranCd"	: tranCd
	    },
        dataType:"html",
        url:"msg.tcmng.getChkTcInfo.do",
        success:function(data, status) {
	    	// 오류코드 처리
			if (data.errCd){
				alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
				$('#list').trigger('reloadGrid');
			}else{
				$("#listDiv").html(data);
				$(".ui-jqgrid-sortable").css('height','auto');
			}
        },
        error:function(request, status) {
            alert(status);
        }
    });
	
	//저장버튼 활성화
    $("#Image58").unbind('mouseover');
	$("#Image58").unbind('click');
	$("#Image58").click(doTcSave);
	$("#Image58").bind('mouseover',function(){
		MM_swapImage('Image58','','images/btn_savetc_02.jpg',1);
	});;
	$("#Image58 img").attr("src","images/btn_savetc_01.jpg");
    //초기화버튼 활성화
    $("#Image59").unbind('mouseover');
	$("#Image59").unbind('click');
	$("#Image59").click(reload);
	$("#Image59").bind('mouseover',function(){
		MM_swapImage('Image59','','images/btn_initialize_02.jpg',1);
	});;
	$("#Image59 img").attr("src","images/btn_initialize_01.jpg");
	
	$("#btnArea2").attr("disabled", "");
	$("#btnArea3").attr("disabled", "");
	
	regBoolean = true;	//True:저장가능, False:저장불가
	extBoolean = true;	//True:실행가능, False:실행불가
	clrBoolean = true;		//true:화면초기화가능, false:화면초기화불가
};



//신규생성
function getTcmngIoMap(){
	
	var chkYN = true;
	if(clrBoolean){
		var chkYN = confirm("신규생성을 하게되면 작업중인 모든 데이터가 사라지게 됩니다.\n\n신규생성 하시겠습니까? ");		//초기화여부확인 chkYN = confirm();
	}
	if(!chkYN){
		return;
	}
	
	var returnList = window.showModalDialog("msg.layout.layout.do",window,'dialogWidth=960px; dialogHeight=665px;center:1;help:0;status:0;scroll:0;location:0;');
	
	if(returnList != null){
		$("#tsCaseID").val("");					//테스트케이스ID
		$("#tsCaseName").val("");					//테스트케이스 명
		$("#tsCaseDesc").val("");					//테스트케이스 설명
		$("#chnlDstcd").val(returnList[0]);		//hidden 채널코드
		$("#tranCd").val(returnList[1]);    	//hidden 거래코드
		$("#tranName").val(returnList[2]);		//hidden 거래코드명
		
		$("#txtTcID").html("신규생성");			//헤더 정보 TEXT_테스트케이스ID
		$("#txtTcName").html("");    			//헤더 정보 TEXT_테스트케이스명
		$("#txtTcDesc").html("");				//헤더 정보 TEXT_테스트케이스설명
		$("#txtTranCD").html(returnList[1]);    //헤더 정보 TEXT_거래코드
		$("#txtTranName").html(returnList[2]);  //헤더 정보 TEXT_거래코드명
		
		//기본테스트데이터
		$.ajax({
	        type:"POST",
	        async: false,
	        data:{
					"chnlDstcd"	: returnList[0],
					"tranCd"	: returnList[1]
		    },
	        dataType:"html",
	        url:"msg.tcmng.getBasicsData.do",
	        success:function(data, status) {
					$("#basicsListDiv").html(data);
					$(".ui-jqgrid-sortable").css('height','auto');
	        },
	        error:function(request, status) {
	            alert(status);
	        }
	    });
		
		//테스트케이스 구성
		$.ajax({
	        type:"POST",
	        data:{
					"chnlDstcd"	: returnList[0],
					"tranCd"	: returnList[1]
		    },
	        dataType:"html",
	        async: false,
	        url:"msg.tcmng.getLayoutDefault.do",
	        success:function(data, status) {
					$("#listDiv").html(data);
					$(".ui-jqgrid-sortable").css('height','auto');
	        },
	        error:function(request, status) {
	            alert(status);
	        }
	    });	
		
		//기본테스트데이터 존재 여부 확인 위한 index
		var basicsGrid = $("#basicsList").jqGrid('getDataIDs');
		
		//기본테스트데이터 존재 시
		if( basicsGrid.length > 0 ) {
			var ret = jQuery("#basicsList").getRowData(0);
			ret.tsdataID = "신규생성";
			ret.chkYN = "미설정";
			var idx = $("list").jqGrid('getDataIDs'); //전체리스트의 id리스트
					
			jQuery("#list").jqGrid('addRowData',idx.length, ret);
			//체크포인트 밑줄, 손가락 표시
			jQuery('#list').find("#" + idx.length + " td[aria-describedby='list_chkYN']").css('cursor','pointer').css('text-decoration','underline').css('font','bold');
			//반복부 밑줄, 손가락 표시
			$.each(rptCol, function (index, value) {
				jQuery('#list').find("#" + idx.length + " td:eq("+(parseInt(value)+1)+")").css('cursor','pointer').css('text-decoration','underline').css('font','bold');
			});
			//jQuery("#list").jqGrid('setCellHtml', idx.length, "chkYN", "<a style='cursor:pointer;text-decoration: underline;'>미설정</a>");
		}
		
		//저장버튼 활성화
	    $("#Image58").unbind('mouseover');
		$("#Image58").unbind('click');
		$("#Image58").click(doTcSave);
		$("#Image58").bind('mouseover',function(){
			MM_swapImage('Image58','','images/btn_savetc_02.jpg',1);
		});;
		$("#Image58 img").attr("src","images/btn_savetc_01.jpg");
	    //초기화버튼 활성화
	    $("#Image59").unbind('mouseover');
		$("#Image59").unbind('click');
		$("#Image59").click(reload);
		$("#Image59").bind('mouseover',function(){
			MM_swapImage('Image59','','images/btn_initialize_02.jpg',1);
		});;
		$("#Image59 img").attr("src","images/btn_initialize_01.jpg");
		
	    $("#list").hideCol('rsultsucssyn');	//실행결과를 hidden 처리
	    //결과보고서 및 메시지 감추기
	    $("#prcssMsg").html("");
	    $('.btnResult').hide();
	    
		$("#btnArea2").attr("disabled", "");
		$("#btnArea3").attr("disabled", "");
		
		regBoolean = true;	//True:저장가능, False:저장불가
		extBoolean = false;	//True:실행가능, False:실행불가
		clrBoolean = true;		//true:화면초기화가능, false:화면초기화불가
		
		$('#flowMsg').html('기존 테스트케이스 추가 버튼을 클릭하여 테스트케이스를 추가해 주십시오.');
	}
} 

//테스트케이스 불러오기
function getTcmngInfo(){
	var chkYN = true;
	if(clrBoolean){
		var chkYN = confirm("불러오기를 하게되면 작업중인 모든 데이터가 사라지게 됩니다.\n\n불러오기 하시겠습니까? ");		//초기화여부확인 chkYN = confirm();
	}
	if(!chkYN){
		return;
	}
	
	var returnList = window.showModalDialog('msg.tcmng.getTcmngInfo.do',window,'dialogWidth=950px; dialogHeight=760px; center:1;help:0;status:0;scroll:0;location:0;');

	if(returnList != null){
		$("#chnlDstcd").val(returnList[0]);		//hidden 채널코드
		$("#tranCd").val(returnList[1]);    	//hidden 거래코드
		$("#tranName").val(returnList[2]);		//hidden 거래코드명
		$("#tsCaseID").val(returnList[3]);		//hidden 테스트케이스ID
		$("#tsCaseName").val(returnList[4]);	//hidden 테스트케이스Name
		$("#tsCaseDesc").val(returnList[5]);	//hidden 테스트케이스설명
		
		$("#txtTcID").html(returnList[3]);		//헤더 정보 TEXT_테스트케이스ID
		$("#txtTcName").html(returnList[4]);    //헤더 정보 TEXT_테스트케이스명
		$("#txtTcDesc").html(returnList[5]);	//헤더 정보 TEXT_테스트케이스설명
		$("#txtTranCD").html(returnList[1]);    //헤더 정보 TEXT_거래코드
		$("#txtTranName").html(returnList[2]);  //헤더 정보 TEXT_거래코드명
		
		//기본테스트데이터
		$.ajax({
	        type:"POST",
	        data:{
					"chnlDstcd"	: returnList[0],
					"tranCd"	: returnList[1]
		    },
	        dataType:"html",
	        url:"msg.tcmng.getBasicsData.do",
	        success:function(data, status) {
		    	// 오류코드 처리
				if (data.errCd){
					alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
					$('#basicsList').trigger('reloadGrid');
				}else{
					$("#basicsListDiv").html(data);
					$(".ui-jqgrid-sortable").css('height','auto');
				}
	        },
	        error:function(request, status) {
	            alert(status);
	        }
	    });
		
		//테스트케이스의 그리드 호출
		$.ajax({
	        type:"POST",
	        data:{"tsCaseID":returnList[3],
	                "chnlDstcd"	: returnList[0],
					"tranCd"	: returnList[1]
		    },
	        dataType:"html",
	        url:"msg.tcmng.getChkTcInfo.do",
	        success:function(data, status) {
		    	// 오류코드 처리
				if (data.errCd){
					alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
					$('#list').trigger('reloadGrid');
				}else{
					$("#listDiv").html(data);
					$(".ui-jqgrid-sortable").css('height','auto');
				}
	        },
	        error:function(request, status) {
	            alert(status);
	        }
	    });
		
		//저장버튼 활성화
	    $("#Image58").unbind('mouseover');
		$("#Image58").unbind('click');
		$("#Image58").click(doTcSave);
		$("#Image58").bind('mouseover',function(){
			MM_swapImage('Image58','','images/btn_savetc_02.jpg',1);
		});;
		$("#Image58 img").attr("src","images/btn_savetc_01.jpg");
	    //초기화버튼 활성화
	    $("#Image59").unbind('mouseover');
		$("#Image59").unbind('click');
		$("#Image59").click(reload);
		$("#Image59").bind('mouseover',function(){
			MM_swapImage('Image59','','images/btn_initialize_02.jpg',1);
		});;
		$("#Image59 img").attr("src","images/btn_initialize_01.jpg");
		
        $("#list").hideCol('rsultsucssyn');	//실행결과를 hidden 처리
        //결과보고서 및 메시지 감추기
        $("#prcssMsg").html("");
        $('.btnResult').hide();
		
		$("#btnArea2").attr("disabled", "");
		$("#btnArea3").attr("disabled", "");
		
		regBoolean = true;	//True:저장가능, False:저장불가
		extBoolean = true;	//True:실행가능, False:실행불가
		clrBoolean = true;		//true:초기화버튼 데이터 삭제 메시지 출력, false:수초기화버튼 데이터 삭제 메시지 미출력
		
		$('#flowMsg').html('테스트케이스를 편집 후 저장하거나 실행할 수 있습니다.');
	}
} 


//기본테스트데이터 추가
function addTestData(){
	if($("#btnArea2").attr("disabled") == true) {
		return;
	}
	
	var maxKey = 0;
	var ids = $("#list").jqGrid('getDataIDs');
	
	var tcDataMaxCnt = $("#tcDataMaxCnt").val(); 
	//테스트케이스 MAX건수 체크 
	if(ids.length + 1 > parseInt(tcDataMaxCnt)){
		alert("테스트데이터의 총 갯수는 "+tcDataMaxCnt+"건을 초과할 수 없습니다");
		return;
	}
	
	$.each(ids, function (index, value) {
		if(parseInt(value) > parseInt(maxKey)){
			maxKey = value;
		}
	});
	maxKey = parseInt(maxKey) + 1;
	
	//기본테스트데이터 존재 시
	var ret = jQuery("#basicsList").getRowData(0);
	
	if(ret.tsdataID){
		ret.tsdataID = "신규생성";
		ret.chkYN = "미설정";
		
		jQuery("#list").jqGrid('addRowData',maxKey, ret);
		//체크포인트 밑줄, 손가락 표시
		jQuery('#list').find("#" + maxKey + " td[aria-describedby='list_chkYN']").css('cursor','pointer').css('text-decoration','underline').css('font','bold');
		//반복부 밑줄, 손가락 표시
		$.each(rptCol, function (index, value) {
			jQuery('#list').find("#" + maxKey + " td:eq("+(parseInt(value)+1)+")").css('cursor','pointer').css('text-decoration','underline').css('font','bold');
		});
		
	    var height = $("#"+maxKey).attr('offsetHeight');
	    $(".ui-jqgrid-bdiv").scrollTop(height*maxKey);
	}else{
		alert("기본 테스트데이터가 없습니다.");
	}
	
	$("#list").hideCol('rsultsucssyn');	//실행결과를 hidden 처리
	//결과보고서 및 메시지 감추기
    $("#prcssMsg").html("");
    $('.btnResult').hide();
	
	extBoolean = false;	//True:실행가능, False:실행불가
} 


//기존테스트케이스 추가
function getTcmngAdd(){
	if($("#btnArea2").attr("disabled") == true) {
		return;
	}
	//테스트데이터 ID목록을 Array()로 받음
	var returnList = window.showModalDialog('msg.tcmng.getTcmngAdd.do',window,'dialogWidth=950px; dialogHeight=760px; center:1;help:0;status:0;scroll:0;location:0;');
	
	if(returnList == null){
		return;
	}
	
	//테스트케이스의 그리드 호출
	$.ajax({
        type:"POST",
        data:{"tsDataIDList":JSON.stringify(returnList)
	    },
        dataType:"json",
        url:"msg.tcmng.getTcmngAddList.do",
        success:function(data, status) {
	    	// 오류코드 처리
			if (data.errCd){
				alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
			}else{
				var maxKey = 0;

				
				//테스트케이스 MAX건수 체크 
				var tcDataMaxCnt = $("#tcDataMaxCnt").val(); 
				var maxChkIds = $("#list").jqGrid('getDataIDs');
				if(maxChkIds.length + data.gridDataList.length > parseInt(tcDataMaxCnt)){
					alert("테스트데이터의 총 갯수는 "+tcDataMaxCnt+"건을 초과할 수 없습니다");
					return;
				}
				
				if(data.gridDataList.length > 0 ) {
					$.each(data.gridDataList, function (index1, value1) {
						
						var ids = $("#list").jqGrid('getDataIDs'); //전체리스트의 id리스트
						
						//처음 한번만 maxkey 값을 구한다.
						if(index1 == 0){
							$.each(ids, function (index, value) {
								if(parseInt(value) > parseInt(maxKey)){
									maxKey = value;
								}
							});
						}
						maxKey = Number(maxKey) + 1;
						
						value1["tsdataID"] = value1["tsdataID"] + "-사본";
						jQuery("#list").jqGrid('addRowData',maxKey, value1);
						//체크포인트 밑줄, 손가락 표시
						jQuery('#list').find("#" + maxKey + " td[aria-describedby='list_chkYN']").css('cursor','pointer').css('text-decoration','underline').css('font','bold');
						//반복부 밑줄, 손가락 표시
						$.each(rptCol, function (index, value) {
							jQuery('#list').find("#" + maxKey + " td:eq("+(parseInt(value)+1)+")").css('cursor','pointer').css('text-decoration','underline').css('font','bold');
						});
						
						var height = $("#"+maxKey).attr('offsetHeight');         
						$(".ui-jqgrid-bdiv").scrollTop(height*maxKey);
					}); 
				}
			}
        },
        error:function(request, status) {
            alert(status);
        }
    });	
	
	$("#list").hideCol('rsultsucssyn');	//실행결과를 hidden 처리
	//결과보고서 및 메시지 감추기
    $("#prcssMsg").html("");
    $('.btnResult').hide();
	
	extBoolean = false;	//True:실행가능, False:실행불가
	$('#flowMsg').html('테스트케이스를 편집 후 저장하거나 실행할 수 있습니다.');
} 

//데이터 자동생성
function setDataAutoCreate(){
	if($("#btnArea2").attr("disabled") == true) {
		return;
	}
	
	var ids = $("#list").jqGrid("getDataIDs");
	
	$("#gridCnt").val(JSON.stringify(ids));
	$("#EngAutoDataHeaderKey").val(JSON.stringify(EngAutoDataHeaderKey));
	$("#EngAutoDataHeader").val(JSON.stringify(EngAutoDataHeader));
	$("#KorAutoDataHeader").val(JSON.stringify(KorAutoDataHeader));
	$("#autoMaxLength").val(JSON.stringify(autoMaxLength));
	
	var returnList = window.showModalDialog('msg.inTitle.inTitle.do?Gubun=1',window,'dialogWidth=600px; dialogHeight=508px; center:1;help:0;status:0;scroll:0;location:0;');
	if(returnList != null){
		$("#totalarray").val(JSON.stringify(returnList));
		var url = "msg.autoData.autoData.do";
		var returnValue = window.showModalDialog(url, window, 'dialogWidth=650px; dialogHeight=582px; center:1;help:0;status:0;scroll:0;location:0;');
		
		if(returnValue != null){
			
			$("#list").hideCol('rsultsucssyn');	//실행결과를 hidden 처리
			//결과보고서 및 메시지 감추기
		    $("#prcssMsg").html("");
		    $('.btnResult').hide();
			
			var tcDataMaxCnt = $("#tcDataMaxCnt").val();
			if($("#NMcheck").val()== "1"){
				var NMlength = 0;
				for (key in returnValue) {
					NMlength++;
				}
				
				//테스트케이스 MAX건수 체크 
				if(ids.length + NMlength > parseInt(tcDataMaxCnt)){
					alert("테스트데이터의 총 갯수는 "+tcDataMaxCnt+"건을 초과할 수 없습니다");
					return;
				}
			}else{
				//테스트케이스 MAX건수 체크 
				if(ids.length + returnValue.length > parseInt(tcDataMaxCnt)){
					alert("테스트데이터의 총 갯수는 "+tcDataMaxCnt+"건을 초과할 수 없습니다");
					return;
				}
			}
			
			var ids = $("#list").getDataIDs();
			//실행결과 데이터 초기화, 실행할 테스트데이터ID 가져오기
		    for(var i = 0 ; i < ids.length ; i++){
		    	$("#list").jqGrid('setCell',ids[i],"rsultsucssyn"," ");
		    }
		    
			if($("#cellEditMode").val()== "신규"){
				var selrow = $("#autoDataPosition").val();
				
				var ret;
				if(selrow > 0){
					ret = $('#list').jqGrid('getRowData',selrow-1);
				}else{
					ret = $('#list').jqGrid('getRowData',selrow);
				}
				//데이터 담아 두기!!!!!!!!!!
		   	 	var contextRowid = selrow;
				if(contextRowid){//edit 컬럼 저장 
					$.each(ids, function (index, value) { 
						$("#list").jqGrid("saveRow",ids[index]); 
					}); 
				} 
				//다음행의 rowid를 찾는다 
				var downRowData = []; 
				for(var i = contextRowid ; i < ids.length ; i++){ 
					downRowData.push($("#list").jqGrid('getRowData', ids[i]));
				}  	
				//선택 한거 아래꺼 다 삭제
		   	 	for(var i=selrow, n=ids.length; i<n; i++){
		   	 		jQuery("#list").delRowData(ids[i]); 	
		   	 	}
		   	 	
		   	 	ids = $("#list").getDataIDs();
		   	 	var maxKey = 0;
				
				$.each(ids, function (index, value) {
					if(parseInt(value) > parseInt(maxKey)){
						maxKey = value;
					}
				});
				maxKey = parseInt(maxKey) + 1;
				
				if($("#NMcheck").val()== "1"){
					for (key in returnValue) {
						var retrunVal = {};
						retrunVal = returnValue[key];
						var nameSplit = new Array();
						var newRowData = {};
						for(name in ret){
							if(name == "tsdataID"){
								if(ret[name].indexOf("-사본") > 0){
									newRowData[name] = ret[name];
								}else{
									newRowData[name] = ret[name]+"-사본";
								}
							}else{
								newRowData[name] = ret[name];
							}
						}
						for(name in EngAutoDataHeaderKey){
							var EngName = EngAutoDataHeaderKey[name];
							for (name in retrunVal) {
								nameSplit = retrunVal[name].split(":");
								if(EngName == nameSplit[0]){
									newRowData[nameSplit[0]] = nameSplit[1];
								}
							}
						}
						$("#list").jqGrid('addRowData', maxKey, newRowData);
						//체크포인트 밑줄, 손가락 표시
						jQuery('#list').find("#" + maxKey + " td[aria-describedby='list_chkYN']").css('cursor','pointer').css('text-decoration','underline').css('font','bold');
						//반복부 밑줄, 손가락 표시
						$.each(rptCol, function (index, value) {
							jQuery('#list').find("#" + maxKey + " td:eq("+(parseInt(value)+1)+")").css('cursor','pointer').css('text-decoration','underline').css('font','bold');
						});
						maxKey++;
					}	
				}else{
					for(var i = 0; i < returnValue.length; i++){
						var newRowData = {};
						for(name in ret){
							if(name == "tsdataID"){
								if(ret[name].indexOf("-사본") > 0){
									newRowData[name] = ret[name];
								}else{
									newRowData[name] = ret[name]+"-사본";
								}
							}else{
								newRowData[name] = ret[name];
							}
						}
						for(name in EngAutoDataHeaderKey){
							var EngName = EngAutoDataHeaderKey[name];
							for(name in returnValue[i]){
								if(EngName==name){
									newRowData[name] = returnValue[i][name];
								}
							}
						}
						$("#list").jqGrid('addRowData', maxKey, newRowData);
						//체크포인트 밑줄, 손가락 표시
						jQuery('#list').find("#" + maxKey + " td[aria-describedby='list_chkYN']").css('cursor','pointer').css('text-decoration','underline').css('font','bold');
						//반복부 밑줄, 손가락 표시
						$.each(rptCol, function (index, value) {
							jQuery('#list').find("#" + maxKey + " td:eq("+(parseInt(value)+1)+")").css('cursor','pointer').css('text-decoration','underline').css('font','bold');
						});
						maxKey++;
					}
				}
				
				for(var p = 0; p < downRowData.length; p++){	
					$('#list').jqGrid('addRowData',maxKey,downRowData[p]);
					//체크포인트 밑줄, 손가락 표시
					jQuery('#list').find("#" + maxKey + " td[aria-describedby='list_chkYN']").css('cursor','pointer').css('text-decoration','underline').css('font','bold');
					//반복부 밑줄, 손가락 표시
					$.each(rptCol, function (index, value) {
						jQuery('#list').find("#" + maxKey + " td:eq("+(parseInt(value)+1)+")").css('cursor','pointer').css('text-decoration','underline').css('font','bold');
					});
					maxKey++;
				}
			}else if($("#cellEditMode").val()== "덮어쓰기"){
				var selrow = $("#autoDataPosition").val() - 1;
				if($("#NMcheck").val()== "1"){
					for (key in returnValue) {
						var retrunVal = {};
						var retrunValArray = {};
						retrunVal = returnValue[key];
						var nameSplit = new Array();
						for (name in retrunVal) {
							nameSplit = retrunVal[name].split(":");
							retrunValArray[nameSplit[0]] = nameSplit[1];
						}
						$("#list").jqGrid('setRowData', ids[selrow], retrunValArray);
						selrow++;
					}
				}else{
					for(var i = 0; i < returnValue.length; i++){
						$("#list").jqGrid('setRowData', ids[selrow], returnValue[i]);
						selrow++;
					}
				}
			}
		}
		
		extBoolean = false;	//True:실행가능, False:실행불가
	}
}

//테스트케이스 저장
function doTcSave(){
	var ids = $("#list").jqGrid("getDataIDs");
	if(ids.length <= 0){
		alert("테스트데이터가 존재하지 않습니다.");
		return;
	}
	
	$("#list").jqGrid("saveRow",lastsel2);
	
	var gridData = $("#list").jqGrid('getRowData');	//그리드의 데이터를 얻는다
	
	//테스트데이터명 필수입력체크
	for(var i = 0 ; i < gridData.length ; i++){
		if(gridData[i].tsdataName == ""){
			alert("테스트데이터명을 입력하세요");
			//var ids = $("#list").jqGrid("getDataIDs");
			//선택행 변경
			//$("#list").jqGrid('setSelection', ids[i], $("#list").jqGrid('setSelection', ids[i]));
			return;
		}
	}
	
	if(!regBoolean){
		return;
	}
    
    var returnData = window.showModalDialog('msg.tcmng.tcmngReg.do',window,'center:yes;dialogWidth=640px; dialogHeight=205px; dialogLeft=100px; dialogTop=50px; scroll=no; status=no; help=no; resizable:no;');
    
    //팝업에서 닫기 여부
    if(returnData == null){
    	return;
    }
    $("#tsCaseID").val(returnData[0]);		//헤더 정보 TEXT_테스트케이스ID
	$("#tsCaseName").val(returnData[1]);
	$("#tsCaseDesc").val(returnData[2]);	
		
	
	$("#txtTcID").html(returnData[0]);		//헤더 정보 TEXT_테스트케이스ID
	$("#txtTcName").html(returnData[1]);	//헤더 정보 TEXT_테스트케이스명
	$("#txtTcDesc").html(returnData[2]);	//헤더 정보 TEXT_테스트케이스설명
	
    var gridData		= jQuery("#list").jqGrid('getRowData'); 
    var postData 		= JSON.stringify(gridData); 
    var chnlDstcd 		= $("#chnlDstcd").val(); 
	var tranCd 			= $("#tranCd").val();
	var tranName 		= $("#tranName").val();
	var tsCaseID 		= $("#tsCaseID").val();
	var tsCaseName 		= $("#tsCaseName").val();
	var tsCaseDesc 		= $("#tsCaseDesc").val();	
	
	//사용자정보
	var usrid 			= $("#usrid").val();
	var usrname 		= $("#usrname").val();
    $.ajax({ 
	    type: "POST", 
	    url:'msg.tcmng.doTcSave.do', 
	    data:{
    		"jgGridData"	: postData,
    		"chnlDstcd"		: chnlDstcd,
    		"tranCd"		: tranCd,
    		"tranName"		: tranName,
    		"tsCaseID"		: tsCaseID,
    		"tsCaseName"	: tsCaseName,
    		"tsCaseDesc"	: tsCaseDesc,
    		"usrid"			: usrid,
    		"usrname"		: usrname
    	}, 
	    success: function(data){ 
    		// 오류코드 처리
			if (data.errCd){
				alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
			}else{
				var tsDataIDList = data.tsDataIDList;
				
				//기본테스트데이터 존재 여부 확인 위한 index
				var listGrid = $("#list").jqGrid('getDataIDs');
				
				$.each(listGrid, function (index, value) {
					//var ret = jQuery("#list").getRowData(value);
					//ret.tsdataID =  tsDataIDList[index];
					//$("#list").jqGrid('setRowData', value, ret);
					
					$("#list").jqGrid('setCell', value, "tsdataID",tsDataIDList[index]);
				});
				
				
				$("#txtTcID").html(data.tsCaseID);
				$("#tsCaseID").val(data.tsCaseID);
				
				$('#flowMsg').html('테스트 실행 버튼을 클릭하여 테스트케이스를 재실행 할 수 있습니다.');
				
				$("#list").hideCol('rsultsucssyn');	//실행결과를 hidden 처리
			    //결과보고서 및 메시지 감추기
			    $("#prcssMsg").html("");
			    $('.btnResult').hide();
			    
			    extBoolean = true;	//True:실행가능, False:실행불가
			    alert("테스트케이스가 저장 되었습니다.");
			}
	    } 
    });
} 

//초기화
function reload(){
	
	
	if("images/btn_initialize_03.jpg" == $("#Image59 img").attr("src")){
		return;
	}
	
	var chkYN = confirm("초기화를 하게되면 작업중인 모든 데이터가 사라지게 됩니다.\n\n초기화 하시겠습니까? ");		//초기화여부확인 chkYN = confirm();
	
	if(!chkYN){
		return;
	}
	if(!regBoolean){
		return;
	}
	
	window.location="msg.tcmng.tcmng.do";
}

//선택된 로우를 한칸 위로 이동
function doRowUp(){
	if($("#btnArea2").attr("disabled") == true) {
		return;
	}
	
	var ids = $("#list").jqGrid("getDataIDs");//rowid배열
	var cklst = jQuery("#list").jqGrid('getGridParam','selarrrow'); //체크된 리스트
	
	//현재행의 rowid
	var curRowid = lastsel2;
	$("#list").jqGrid("saveRow",lastsel2);
	
	//윗행의 rowid를 찾는다
	var upRowid;
	for(var i = 0 ; i < ids.length ; i++){
		if(ids[i] == curRowid){
			
			if(i == 0){//첫번째 row를 선택한경우 
			     return; 
			     } 
			upRowid = ids[i-1];
			break;
		}
	}
	
	if(cklst.length == 1){
		curRowid = cklst[0];
		$.each(ids, function (index, value) {
			$("#list").jqGrid("saveRow",ids[index]);
		});
	}else if( cklst.length > 1 ) {
		alert('1건씩만 이동 가능합니다.');
		return;
	}else{
		alert('체크박스를 선택하세요');
		return;
	}

	for(var i = 0 ; i < ids.length ; i++){
		if(ids[i] == curRowid){
			if(i == 0){//첫번째 row를 선택한경우
				return;
			}
			upRowid = ids[i-1];
			break;
		}
	}
	
	//데이터 얻기
	var curRowData = $("#list").jqGrid('getRowData', curRowid);
	var upRowData = $("#list").jqGrid('getRowData', upRowid);
	
	//데이터 교체
	$("#list").jqGrid('setRowData', curRowid, upRowData);
	$("#list").jqGrid('setRowData', upRowid, curRowData);
	
	//선택행 변경
	$('#list').jqGrid('saveRow',curRowid); 
    $("#list").jqGrid('resetSelection'); 
    $("#list").jqGrid('setSelection', upRowid); 

    $("#list").hideCol('rsultsucssyn');	//실행결과를 hidden 처리
    //결과보고서 및 메시지 감추기
    $("#prcssMsg").html("");
    $('.btnResult').hide();
    
	extBoolean = false; //실행가능여부체크(True:실행가능, False:실행불가)
	
}

//선택된 로우를 한칸 아래로 이동
function doRowDown(){
	if($("#btnArea2").attr("disabled") == true) {
		return;
	}
	//rowid배열
	var ids = $("#list").jqGrid("getDataIDs");
	//체크된 리스트
	var cklst = jQuery("#list").jqGrid('getGridParam','selarrrow');
	$("#list").jqGrid("saveRow",curRowid);
	
	//현재행의 rowid
	var curRowid;

	if(cklst.length == 1){
		curRowid = cklst[0];
        $.each(ids, function (index, value) {
		    $("#list").jqGrid("saveRow",ids[index]);
        });
	}else if( cklst.length > 1 ) {
		alert('1건씩만 이동 가능합니다.');
		return;
	}else{
		alert('체크박스를 선택하세요');
		return;
	}
	
	//다음행의 rowid를 찾는다
	var downRowid;
	for(var i = 0 ; i < ids.length ; i++){
		if(ids[i] == curRowid){
			if(i == (ids.length-1)){//마지막 row를 선택한경우 
			     return; 
			     } 
			downRowid = ids[i+1];
			break;
		}
	}
	
	//데이터 얻기
	var curRowData = $("#list").jqGrid('getRowData', curRowid);
	var downRowData = $("#list").jqGrid('getRowData', downRowid);
	
	//데이터 교체
	$("#list").jqGrid('setRowData', curRowid, downRowData);
	$("#list").jqGrid('setRowData', downRowid, curRowData);
	
	//선택행 변경 
	$('#list').jqGrid('saveRow',curRowid); 
    $("#list").jqGrid('resetSelection'); 
    $("#list").jqGrid('setSelection', downRowid); 
    
    $("#list").hideCol('rsultsucssyn');	//실행결과를 hidden 처리
    //결과보고서 및 메시지 감추기
    $("#prcssMsg").html("");
    $('.btnResult').hide();    
	
	extBoolean = false; //실행가능여부체크(True:실행가능, False:실행불가)
}


//선택된 로우를 복사
function doRowCopy(){
	if($("#btnArea2").attr("disabled") == true) {
		return;
	}
   
	var editCheck = ""; 
    	editCheck =$("#list").find("input[type=radio]:checked, input[type=text], textarea, select").map(function(){ 
    	return $(this).attr("name"); 
    }).get(); 
    
    if( "" != editCheck){ 
	    alert("수정중인 데이터를 수정완료 후 복사 하십시오."); 
	    return; 
    }
    var maxChkIds = $("#list").jqGrid('getDataIDs'); //전체리스트의 id리스트
    var cklst = jQuery("#list").jqGrid('getGridParam','selarrrow'); //체크된 리스트
    
    //테스트케이스 MAX건수 체크 
    var tcDataMaxCnt = $("#tcDataMaxCnt").val();
	if(maxChkIds.length + cklst.length > parseInt(tcDataMaxCnt)){
		alert("테스트데이터의 총 갯수는 "+tcDataMaxCnt+"건을 초과할 수 없습니다");
		return;
	}
	
	var maxKey = 0;
	if( cklst.length > 0 ) {
		
		var ids = $("#list").jqGrid('getDataIDs'); 						//전체리스트의 id리스트
		//실행결과 데이터 초기화, 실행할 테스트데이터ID 가져오기
	    for(var i = 0 ; i < ids.length ; i++){
	    	$("#list").jqGrid('setCell',ids[i],"rsultsucssyn"," ");
	    }
		$("#list").hideCol('rsultsucssyn');	//실행결과를 hidden 처리
	    //결과보고서 및 메시지 감추기
	    $("#prcssMsg").html("");
	    $('.btnResult').hide();	
		
		$.each(cklst, function (index, value) {
			
			//처음 한번만 maxkey 값을 구한다.
			if(index == 0){
				$.each(ids, function (index1, value1) {
					if(parseInt(value1) > parseInt(maxKey)){
						maxKey = value1;
					}
				});
			}
			maxKey =  parseInt(maxKey) + 1;
			
			var ret = jQuery("#list").getRowData(cklst[index]);
			
			var tsdataID = ret.tsdataID;
			
			if(tsdataID == "신규생성"){
				ret.tsdataID = ret.tsdataID + "-사본";
			}else if(tsdataID.substring(tsdataID.indexOf("-")+1,tsdataID.length)=="사본"){
				ret.tsdataID = ret.tsdataID;
			}else if(tsdataID.substring(tsdataID.indexOf("-")+1,tsdataID.length)=="신규"){
				ret.tsdataID = tsdataID.substring(0,tsdataID.indexOf("-")+1);
				ret.tsdataID = ret.tsdataID + "-사본";
			}else{
				ret.tsdataID = ret.tsdataID + "-사본";
			}
			
			jQuery("#list").jqGrid('addRowData', maxKey, ret);
			//체크포인트 밑줄, 손가락 표시
			jQuery('#list').find("#" + maxKey + " td[aria-describedby='list_chkYN']").css('cursor','pointer').css('text-decoration','underline').css('font','bold');
			//반복부 밑줄, 손가락 표시
			$.each(rptCol, function (index, value) {
				jQuery('#list').find("#" + maxKey + " td:eq("+(parseInt(value)+1)+")").css('cursor','pointer').css('text-decoration','underline').css('font','bold');
			});
			
			var height = $("#"+maxKey).attr('offsetHeight');         
		    $(".ui-jqgrid-bdiv").scrollTop(height*maxKey);
		}); 
	}else{
		alert("복사할 테스트데이터가 없습니다."); 
	} 
	
	extBoolean = false; //실행가능여부체크(True:실행가능, False:실행불가)
}


//선택된 로우를 삭제
function doRowDel(){
	if($("#btnArea2").attr("disabled") == true) {
		return;
	}
	
	var chkYn = confirm("선택된 테스트데이터를 목록에서 삭제하시겠습니까?");		//삭제여부확인 chkYn = confirm();
	
	if(chkYn == true){
		var cklst = jQuery("#list").jqGrid('getGridParam','selarrrow'); //체크된 리스트 검색 
	    
	    if( cklst.length > 0 ){ 
	    	$.blockUI(); //block시작
		    for(var j = cklst.length-1; j>=0 ; j--){
		    	jQuery("#list").delRowData(cklst[j]); 
		    }
		    $.unblockUI(); //block시작
	    }else{ 
	    	alert("삭제할 테스트데이터가 없습니다"); 
	    } 
	}

	$("#list").hideCol('rsultsucssyn');	//실행결과를 hidden 처리
    //결과보고서 및 메시지 감추기
    $("#prcssMsg").html("");
    $('.btnResult').hide();
    
	extBoolean = false; //실행가능여부체크(True:실행가능, False:실행불가)
}

//그리드 Edit모드 실행시 호출(jsp가 다르기에 전역변수를 사용할 수 없다.)
function chkRegBoolean(str){
	
	$("#list").hideCol('rsultsucssyn');	//실행결과를 hidden 처리
    //결과보고서 및 메시지 감추기
    $("#prcssMsg").html("");
    $('.btnResult').hide();
    
	extBoolean = false; //실행가능여부체크(True:실행가능, False:실행불가)
}

//체크포인트 팝업 호출
function checkPointPop(rowid, iRow, iCol){
	
	//var ret = jQuery("#list").getRowData(rowid);
	
	//그리드에서 선택된 tsdataID
	var tsdataID = jQuery("#list").jqGrid('getCell', rowid, "tsdataID");
	//json 데이터 그리드
	var chkYNVal = jQuery("#list").jqGrid('getCell', rowid, "chkYNVal");
	
	if(tsdataID == "신규생성" || tsdataID == "신규생성-사본"){
		$("#tsdataID").val("");
	}else if(tsdataID.substring(tsdataID.indexOf("-")+1,tsdataID.length)=="사본"){
		$("#tsdataID").val(tsdataID.substring(0, tsdataID.indexOf("-")));
	}else{
		$("#tsdataID").val(tsdataID);
	}
	
	$("#chkYNVal").val(chkYNVal);
	
	var returnList = window.showModalDialog('msg.tcmng.getTesCheck.do',window,'dialogWidth=640px; dialogHeight=575px; center:1;help:0;status:0;scroll:0;location:0;');
	
	var chkYN = "N";
	if(returnList != null && returnList != "" && returnList != "undefined"){
		for(var i = 0; i < $.parseJSON(returnList).length; i++){
			if($.parseJSON(returnList)[i].chkYN == "Y"){
				chkYN= "Y";
				break;
			}
		}
		//그리드에 입력받은 값을 체크포인트 값들을 SET!
		jQuery("#list").jqGrid('setCell', rowid, "chkYNVal", returnList);
		if(chkYN == "Y"){
			jQuery("#list").jqGrid('setCellHtml', rowid, "chkYN", "설정");
		}else{
			jQuery("#list").jqGrid('setCellHtml', rowid, "chkYN", "미설정");
		}
		
		$("#list").hideCol('rsultsucssyn');	//실행결과를 hidden 처리
	    //결과보고서 및 메시지 감추기
	    $("#prcssMsg").html("");
	    $('.btnResult').hide();
	    
		extBoolean = false; //실행가능여부체크(True:실행가능, False:실행불가)
	}
};

//반복부
var rptMap = new Object();   
function rptPop(rowid, iRow, iCol){
	var chnlDstcd = $("#chnlDstcd").val();			//채널코드
	var tranCd = $("#tranCd").val();				//거래코드
	var fldDiv = "";								//헤더부|개별부 코드
	
	//var ret = jQuery("#list").getRowData(rowid);
	var colModel = $("#list").jqGrid("getGridParam","colModel");
	var fldColName = colModel[iCol].name;
	
	fldName = fldColName.substring(0,fldColName.indexOf("||-"));
	
	//헤더부|개별부 구분
	if(fldColName.substring(fldName.length+3, fldName.length+4) == "H"){
		fldDiv = "01";
	}else{
		fldDiv = "02";
	}
	//그리드데이터 세팅
	rptMap[fldName] = $.parseJSON(jQuery("#list").jqGrid('getCell', rowid, iCol+1));
	
	par = "?chnlDstcd="+chnlDstcd+"&tranCd="+tranCd+"&fldDiv="+fldDiv+"&fldName="+fldName;
	var url = "msg.pretst.rptInput.do"+par;
	var postData = window.showModalDialog(url,window,'dialogWidth=950px; dialogHeight=680px;center:1;help:0;status:0;scroll:0;location:0;');
	
	if(postData != undefined){
		var gridData = postData.gridData;
		
    	jQuery("#list").jqGrid('setCell', rowid, iCol+1, JSON.stringify(gridData));
    	jQuery("#list").jqGrid('setCell', rowid, iCol, gridData.length);
    	
    	$("#list").hideCol('rsultsucssyn');	//실행결과를 hidden 처리
        //결과보고서 및 메시지 감추기
        $("#prcssMsg").html("");
        $('.btnResult').hide();
        
    	extBoolean = false; //실행가능여부체크(True:실행가능, False:실행불가)
    }
}

//테스트케이스 실행
function btnExecute(){
	//현재 실행중인지 확인
	if(!regStatus){
		//regStatus = true;			//실행중 값 설정
	}else{
		return;
	}
	
	var ids 			= $("#list").jqGrid('getDataIDs'); 						//전체리스트의 id리스트 
	var cklst 			= jQuery("#list").jqGrid('getGridParam','selarrrow'); 	//체크된 리스트
	var tsDataIDList 	= new Array();
	
	if(document.getElementById("btnArea3").disabled == true) {
		return;
	}
	
	
	if(!extBoolean){
		alert("변경된 내용이 있습니다\n저장 후 실행해 주세요.");
		regStatus = false;
		return;
	}
	
	if( ids.length == 0 ) {
		alert("실행할 테스트데이터가 존재하지 않습니다.");
		regStatus = false;
		return;
	} 
	
	var connSevrDstcd = $("#connsevrdstcd").val();
	var tranCd = $("#tranCd").val();
	if((connSevrDstcd=="03"||connSevrDstcd=="04"||connSevrDstcd=="05"||connSevrDstcd=="06") && tranCd != "BIE9901C") {
		alert("대외MCI거래(BIE9901C)가 아닙니다. 접속서버를 확인해 주세요.");
		return;
	} else if((connSevrDstcd=="01"||connSevrDstcd=="02") && tranCd == "BIE9901C") {
		alert("대외MCI거래(BIE9901C)입니다. 접속서버를 확인해 주세요.");
		return;
	}
	
	if( cklst.length == 0 ) {
		alert("선택된  테스트데이터가 존재하지 않습니다.");
		regStatus = false;
		return;
	}
	
	//체크된 행의 rowid를 순서대로 정렬한다
	for(var i = 0 ; i < cklst.length ; i++){
		for(var j = i+1 ; j < cklst.length ; j++){
			if(parseInt(cklst[i]) > parseInt(cklst[j])){
				var temp = cklst[i];
				cklst[i] = cklst[j];
				cklst[j] = temp;
			}
		}
    }
	
	$.each(cklst, function (index, value) { 
		//var ret = jQuery("#list").getRowData(cklst[index]);
		var tsdataID = jQuery("#list").jqGrid('getCell', cklst[index], "tsdataID");
		
		tsDataIDList[index] = tsdataID;
	});
	
	//실행결과 데이터 초기화, 실행할 테스트데이터ID 가져오기
    for(var i = 0 ; i < ids.length ; i++){
    	$("#list").jqGrid('setCell',ids[i],"rsultsucssyn"," ");
    }
	
	$("#list").hideCol('rsultsucssyn');	//실행을 했었던 상태에서 또 실행을 누를시 실행결과를 hidden 처리
	loopExecuteIdx = 0;					//실행루프Index 초기화
	$("#acmplNth").val("");				//실행회차 초기화
	$("#cklst").val(jQuery("#list").jqGrid('getGridParam','selarrrow')); 	//체크된 리스트
	//결과보고서 및 메시지 감추기
    $("#prcssMsg").html("");
    $('.btnResult').hide();
	loopExecute(tsDataIDList, "");		//인자값(테스트케이스ID, 테스트데이터ID, 수행회차)
}

//테스트케이스 건별실행 Ajax
function loopExecute(tsDataIDList, acmplNth){
	var cklst = $("#cklst").val().split(",") ;
    $("#list").resetSelection().setSelection(cklst[loopExecuteIdx]);
	
	$.ajax({ 
	    type: "POST", 
	    url:'msg.tcmng.excuteTc.do',
	    data:{
    		"tsCaseID"		: $("#tsCaseID").val(),
    		"acmplNth"		: $("#acmplNth").val(),
    		"tsDataID"		: tsDataIDList[loopExecuteIdx++],
    		"usrid"			: $("#usrid").val()
    	}, 
	    success: function(data){
    		// 오류코드 처리
			if (data.errCd){
				alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
			}else{
				$('#prcssMsg').html("총 " + tsDataIDList.length + "건중 " + (loopExecuteIdx) +"건이 실행 되었습니다.");
				
				if(tsDataIDList.length == loopExecuteIdx){
					$("#acmplNth").val(data.acmplNth);
					$('.btnResult').show();
					$("#list").resetSelection();
					setGridResult(data.sussYN, true);			//그리드에 실행결과 버튼 만들기|보이기
					regStatus = false;							//실행종료 설정
					
					alert("테스트 실행이 완료 되었습니다.\n\n결과보고서를 클릭하여\n자동 수행 결과를 확인하실 수 있습니다.");
					$('#flowMsg').html('결과보고서보기 버튼을 클릭하여 테스트결과를 확인하십시오.');
				}else{
					setGridResult(data.sussYN, false);			//그리드에 실행결과 버튼 만들기|안보이기
					$("#acmplNth").val(data.acmplNth);
					
					loopExecute(tsDataIDList, data.acmplNth);	//다음건 실행
				}
			}
	    }, 
	    error:function(request, status) {
            alert("실행을 실패하였습니다.");
        }
    });
}

//결과보고서
function btnResult(){
	var url = "msg.report.reportDetail.do?";
	var param = "gubun=01";
	param    += "&tscaseid=" + $("#tsCaseID").val(); //테스트케이스ID
	param    += "&acmplnth="+ $("#acmplNth").val(); //수행회차
		
	window.open(url+param,"결과상세보고서","location=no,resizable=no,status=no,width=980,height=770");
	
}

//실행시 그리드에 성공실패 셋팅
function setGridResult(rsultSucssYN, boolean){
	var cklst = $("#cklst").val().split(",") ;
    
    if(rsultSucssYN != undefined){
        var imgSuccess = "";
        
        if($("#list").jqGrid("getCell",cklst[loopExecuteIdx-1],"chkYN") == "설정"){
        	imgSuccess = "<img src='images/icon_rep_ok_green.gif' width=34 height=16 hspace='2' vspace='3' align='absmiddle' border=0 style='cursor:pointer;' />";
        } else {
        	imgSuccess = "<img src='images/icon_rep_ok.gif' width=34 height=16 hspace='2' vspace='3' align='absmiddle' border=0 style='cursor:pointer;' />";
        }
        var imgFail = "<img src='images/icon_rep_fail.gif' width=34 height=16 hspace='2' vspace='3' align='absmiddle' border=0 style='cursor:pointer;' />";
        
        $("#list").setCellHtml(cklst[loopExecuteIdx-1], 'rsultsucssyn', (rsultSucssYN == 'Y')? imgSuccess: imgFail);
        
        if(boolean){
        	$("#list").showCol('rsultsucssyn');
        }else{
        	$("#list").hideCol('rsultsucssyn');
        }
    }else{
    	 $("#list").hideCol('rsultsucssyn');
    }
}

//헤더고정
function setFrozen(){
	$grid1.jqGrid('setFrozenColumns2'); 
	$grid1[0].p._complete.call($grid1[0]); 
	fixPositionsOfFrozenDivs1.call($grid1[0]);
	
	$grid2.jqGrid('setFrozenColumns2'); 
	$grid2[0].p._complete.call($grid2[0]); 
	fixPositionsOfFrozenDivs2.call($grid2[0]);
}



//엑셀내려받기
function exportExcel() {
	var tempRptCol = new Array(); 
	tempRptCol = $.merge([], rptCol);
	
	tempRptCol[tempRptCol.length] = 0;	//hidden 값 위치(실행성공여부)
	tempRptCol[tempRptCol.length] = 5;	//hidden 값 위치(체크포인트값)
	
	var excludeHiddenColumnIdx = tempRptCol;
	
	$("#list").jqGrid("saveRow",lastsel2);
	
	// 'list' : 그리드 아이디, excludeColumnIdx: 엑셀출력에 제외할 컬럼,  '테스트' : 엑셀명과 시트명으로 사용할명
	gridExportExcel('list', excludeHiddenColumnIdx, '테스트케이스구성');

}

// 엑셀업로드 팝업 호출
var newColumnNames = new Array();
var excludeColumnIdx;
function importExcel() {
	extBoolean = false;		//True:실행가능, False:실행불가
	clrBoolean = true;		//true:화면초기화가능, false:화면초기화불가
	
	var tempRptCol = new Array(); 
	tempRptCol = $.merge([], rptCol);
	
	tempRptCol[tempRptCol.length] = 0;	//hidden 값 위치(실행성공여부)
	tempRptCol[tempRptCol.length] = 5;	//hidden 값 위치(체크포인트값)
	
	excludeColumnIdx = tempRptCol;
	
	var columnNames = $('#list').jqGrid('getGridParam','colNames');
	if (jQuery('#list').jqGrid('getGridParam','rownumbers')) {
		var tempArray = new Array();
		for (var i=0; i<columnNames.length; i++ ) {
			if (i==0) continue;
			tempArray.push(columnNames[i]);
		}
		columnNames = tempArray;
	}
	
	if (jQuery('#list').jqGrid('getGridParam','multiselect')) {
		var tempArray = new Array();
		for (var i=0; i<columnNames.length; i++ ) {
			if (i==0) continue;
			tempArray.push(columnNames[i]);
		}
		columnNames = tempArray;
	}
	
	for (var i=0; i<columnNames.length; i++ ) {
		var isExclude = false;
		for (var j=0; j<columnNames.length; j++ ) {
			if (i==excludeColumnIdx[j]) {
				isExclude = true;
				break;
			}
		}
		if (!isExclude){
			var tempColumnNames = ""; 
			tempColumnNames = columnNames[i].split('<br/>').join('');
			newColumnNames.push(tempColumnNames.split(' ').join(''));
		}	
	}
	
	$("#list").hideCol('rsultsucssyn');	//실행결과를 hidden 처리
	//결과보고서 및 메시지 감추기
    $("#prcssMsg").html("");
    $('.btnResult').hide();
    
    ////테스트케이스 MAX건수 
    var tcDataMaxCnt = $("#tcDataMaxCnt").val();
    var limitRowCnt = tcDataMaxCnt - $("#list").jqGrid('getDataIDs').length;
	MM_openBrWindow('cmn.grid.popImportExcel.do?limitRowCnt='+limitRowCnt+'&tcDataMaxCnt='+tcDataMaxCnt,'엑셀업로드','status=yes,width=520,height=155');
}

// mapping callback함수 : 변수명은 "mappingExcel"로 정의해야 합니다.
var mappingExcel = function (excelRowData){
	var dataIds=$('#list').getDataIDs();
	var rowData=$('#list').getRowData(dataIds[0]);
    var colNames=new Array();
    var colIdx=0;
    var rowDataCnt=0;
    for (var i in rowData){
    	var isExclude = false;
    	for (var k=0; k<excludeColumnIdx.length; k++ ) {
    		if (rowDataCnt==excludeColumnIdx[k]) {
    			isExclude = true;
    			break;
    		}
    	}
    	if (!isExclude) colNames[colIdx++]=i;
    	rowDataCnt++;
    }
    
    var newRowData ="{";
    
	for ( var int = 0; int < colNames.length; int++) {
		
		var chkBoolean = false;		//키값 tsdataID이 엑셀의 키값과 동일한지 여부
		if (colNames[int] == "tsdataID"){
			//키값 중복여부 확인
			/*
			for(var i = 0; i < ids.length; i++) {
				var ret = jQuery("#list").getRowData(i);
				if(ret.tsdataID == excelRowData[newColumnNames[int]]){
					chkBoolean = true;
					break;
				}
			};
			*/
			chkBoolean = true;
		} 
		
		//반복부 위치 확인
		var rptBoolean = false;
		for(var i = 0; i < rptCol.length; i++){
			if(int == (parseInt(rptCol[i])-3-i)){
				rptBoolean = true;
				break;
			}
		}
		
		//첫번째 if : 반복부 일경우 값을 0으로 초기화 하여 업로드
		if(rptBoolean){
			newRowData = newRowData + '"' + colNames[int] + '":"0",';
		}else{
			//두번째 if : 키값 tsdataID이 엑셀의 키값과 동일한지 확인
			if(chkBoolean){
				//세번째 if : 엑셀의 키값이 사본일 경우 엑셀의 값을 그대로 저장 아닐경우 중복되는 값이기 때문에 -사본을 붙여서 업로드한다. 
				if(excelRowData[newColumnNames[int]].substring(excelRowData[newColumnNames[int]].indexOf("-")+1,excelRowData[newColumnNames[int]].length) == "사본"){
					newRowData = newRowData + '"' + colNames[int] + '":"' + excelRowData[newColumnNames[int]] + '",';
				}else{
					newRowData = newRowData + '"' + colNames[int] + '":"' + excelRowData[newColumnNames[int]] + '-사본",';
				}
			}else{
				//그리드의 헤더 이름에 해당하는 데이터가 엑셀에 존재 하는지 여부 파악
				if(excelRowData[newColumnNames[int]] == undefined){
					newRowData = newRowData + '"' + colNames[int] + '":"",';
				}else{
					newRowData = newRowData + '"' + colNames[int] + '":"' + excelRowData[newColumnNames[int]] + '",';
				}
			}
		}
	}
	
	newRowData = newRowData.substring(0, newRowData.length-1) + "}";
	
	var myObject = jQuery.parseJSON( newRowData );

	var maxKey = 0;
	var ids = $("#list").jqGrid('getDataIDs');
	
	$.each(ids, function (index, value) {
		if(parseInt(value) > parseInt(maxKey)){
			maxKey = value;
		}
	});
	maxKey = parseInt(maxKey) + 1;
	
	jQuery('#list').jqGrid('addRowData',maxKey,myObject);
	//체크포인트 밑줄, 손가락 표시
	jQuery('#list').find("#" + maxKey + " td[aria-describedby='list_chkYN']").css('cursor','pointer').css('text-decoration','underline').css('font','bold');
	//반복부 밑줄, 손가락 표시
	$.each(rptCol, function (index, value) {
		jQuery('#list').find("#" + maxKey + " td:eq("+(parseInt(value)+1)+")").css('cursor','pointer').css('text-decoration','underline').css('font','bold');
	});
};
