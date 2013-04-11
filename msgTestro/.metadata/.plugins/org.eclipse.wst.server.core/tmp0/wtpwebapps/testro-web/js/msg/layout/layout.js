$(window).load(function(){
	
	jqGridD();
	$("#layoutDiv").html("<div id='headerDataDiv'></div><div id='inviDataDiv'></div>");
	doSearch("view1");
	if($("#fldDiv").val() == "01"){    //헤더부만 조회인 경우 개별부는 숨김처리 
		$("#fldDivH").hide();			//헤더부 숨김처리 
		$("#fldDivI").hide();			//개별부 숨김처리 
		$("#fldDivI2").show();			//개별부 이름을 헤더부 이름으로 변경한 ID
	}

	setAllSearch('tranCd');
	setAllSearch('tranName');
	
	$("#layoutList").focus();
	layoutList();
	
});

function fldDivData()
{
	if($("#fldDivData").val() == "01"){     //헤더부 개별부 조회 일시 ,헤더부만 선택일때   개별부이름을 헤더부로 변경  올래 헤더부 숨김처리
		$("#fldDivH").hide();
		$("#fldDivI").hide();
		$("#fldDivI2").show();
	
	}else if($("#fldDivData").val() == "02"){   //개별부
		$("#fldDivH").show();
		$("#fldDivI").show();
		$("#fldDivI2").hide();
	}	
}

function layoutList()
{
	//$("#layoutList").focus();
	//document.body.focus();
	var colorCSS =$("#tranCd").css("color");
	var colorCSS2 =$("#tranName").css("color");
	if(colorCSS != "#ababab" && colorCSS != "rgb(171, 171, 171)"){
		
		if(trim(document.layout.tranCd.value) != "" && document.layout.tranCd.value.length < 2){
			alert("거래코드를 2자 이상 입력하십시오.");
			document.layout.tranCd.focus();
			document.layout.tranCd.value = "";
			return;
		}
		
	}	
	
	var tranCd= "";
	if(colorCSS != "#ababab" && colorCSS != "rgb(171, 171, 171)"){
		$("#tranCd").val($("#tranCd").val().toUpperCase());
		tranCd = $("#tranCd").val();	
	}
	
	var tranName = "";
	if(colorCSS2 != "#ababab" && colorCSS2 != "rgb(171, 171, 171)"){
		tranName = $("#tranName").val();
	}
	
	var chnlDstcd = $("#chnlDstcd").val();	//채널구분 (전문관리 화면에서 값을 세팅)
	var fldDiv = $("#fldDiv").val();	//필드구성 (전문관리 화면에서 값을 세팅)
	if(fldDiv == "all"){
		//전문관리 화면에서 호출시 헤더부와 개별부 목록 모두조회
		fldDiv = "";
	} else if(fldDiv == ""){
		//전문관리외의 화면에서 개별부 목록만 조회
		fldDiv = "02";
	}
	
	
	
	
	$('#list').setGridParam({page: 1,
	    url:'msg.layout.getListLayout.do',
	    postData: {
            tranCd: tranCd,
            tranName: tranName,
            chnlDstcd: chnlDstcd,
            fldDiv: fldDiv
        }
	});
	$('#list').trigger("reloadGrid");
	$("#layoutDiv").html("<div id='headerDataDiv'></div><div id='inviDataDiv'></div>");
		
}
	
// iframe resize
function autoResize(i)
{
    var iframeHeight=
    (i).contentWindow.document.body.scrollHeight;
    (i).height=iframeHeight+20;
}


//테스트케이스 상세 탭 선택시 
function doSearch(str){
	var idx = str.substring(4,5); //버튼순서	  	
	document.layout.tabGb.value = str;  
  
	//버튼바꾸기 개별부 헤더부 활성화 비활성화
	for(var i = 0; i < 2; i++){   
		if(parseInt(idx) == i){
			$("#view"+i+"_on").show();
			$("#view"+i+"_off").hide();
			$("#headerDataDiv").hide();
        	$("#inviDataDiv").show();
		}else{  
			$("#view"+i+"_on").hide();
			$("#view"+i+"_off").show();
			$("#headerDataDiv").show();
        	$("#inviDataDiv").hide();
		}
	}
}

var lastsel2;
var opener = window.dialogArguments;

function jqGridD(){
	var	colNames1 ="";
	var	colNames2 ="";
	var	colNames3 ="";
	var	colNames4 ="";
	var	colNames5 ="";
	var	colModel ="";
	if($("#fldDiv").val() == "01"){   //헤더부  ,헤더부코드hidden
		colNames1 ="구분";
		colNames2 ="헤더부코드";
		colNames3 ="헤더부명";
		colNames4 ="헤더부코드";
		colNames5 ="채널코드";
		colModel ={name: 'refTranCd',index: 'REFTRANCD', width:150, editable:false, align:"left", hidden:true};
	}else if($("#fldDiv").val() == "all"){   //헤더부,개별부
		colNames1 ="구분";
		colNames2 ="헤더부/거래코드";
		colNames3 ="헤더부/거래명";
		colNames4 ="헤더부코드";
		colNames5 ="채널코드";
		colModel ={name: 'refTranCd',index: 'REFTRANCD', width:100, editable:false, align:"left"};
	}else{   						//거래테스트
		colNames1 ="구분";
		colNames2 ="거래코드";
		colNames3 ="거래명";
		colNames4 ="헤더부코드";
		colNames5 ="채널코드";
		colModel ={name: 'refTranCd',index: 'REFTRANCD', width:100, editable:false, align:"left"};
	}
	var fldDiv = $("#fldDiv").val();	//필드구성 (전문관리 화면에서 값을 세팅)
	if(fldDiv == "all"){
		//전문관리 화면에서 호출시 헤더부와 개별부 목록 모두조회
		fldDiv = "";
	} else if(fldDiv == ""){
		//전문관리외의 화면에서 개별부 목록만 조회
		fldDiv = "02";
	}
	var param ="&fldDiv="+fldDiv;
	jQuery("#list").jqGrid({
		url:'msg.layout.getListLayout.do?'+param,
		mtype:'POST',    // 한글 인코딩 깨지는 문제 방지하기 위해 POST로 쓴다
		async : true,
		datatype: "json",
		
	    colNames:[
	               colNames1 ,
	               colNames2 ,
	               colNames3 ,
	               colNames4 ,
	               colNames5  
		],
	    colModel:[
	              	{name: 'fldDiv',index: 'FLDDIV', width:100, editable:false, align:"center",formatter:gridCodeFmatter, formatoptions: {cdclMnName:'FLDDIV'}, unformat:gridCodeUnFmatter},
					{name: 'tranCd' ,index: 'TRANCD' , width:100, editable:false, align:"left", key:true},
					{name: 'tranName',index: 'TRANNAME', width:570, editable:false, align:"left"},
					colModel,
					{name: 'chnlDstcd' ,index: 'CHNLDSTCD' , width:100, editable:false, align:"center",hidden:true, formatter:gridCodeFmatter, formatoptions: {cdclMnName:'CHLDIV'}, unformat:gridCodeUnFmatter}

	    ],
	    
	   	rowNum:20,
	   	rowList:[20,30,50],
	   	pager: '#pager',
	   	sortname: 'TRANCD',  
	    viewrecords: true,
	    sortorder: "asc",
	    rownumbers: true,
	    gridview: true,
	    width:'100%',
	    height:144,
	    loadComplete: function(xhr) {
			$("#list").jqGrid("setGridHeight",145); //스크롤
			reloadGridWidthSize('list',30);
			if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
		},
	    jsonReader : {
	        root: "rows",
	        page: "page",
	        total: "total",
	        records: "records",
	        repeatitems: false,
	        cell: "cell",
	        id: "CHNLDSTCD"
	    },
	    
	    
	    onCellSelect: function(rowid) { //1.원클릭 이벤트( 로우 데이터 가져오기),상세정보 표시 
	    	doSearch("view1");
	    	if(rowid != 0){
		    	var rowdata = jQuery("#list").jqGrid('getRowData',rowid);
					$.ajax({
				        type:"POST",
				        data:{"chnlDstcd":rowdata.chnlDstcd,
				        	  "tranCd":rowdata.tranCd
					        },
					       
				        dataType:"html",
				        url:"msg.layout.getlayoutDiv.do",
				        success:function(data, status) {
					        	if(data.errCd){
					        		alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
					        	}else{
					        	    $("#layoutDiv").html("");
						        	$("#layoutDiv").html(data);
						        	$("#headerDataDiv").hide();
						        	$("#inviDataDiv").show();
						        	fldDivData();
					        	}
					    
				        },
				        error:function(request, status,error) {
				        	alert("조회 중에 오류가 발생하였습니다.[" + error + "]"); 
				        }
				   });	
					
	    		}
			}
	    
	}); 
	
	$("#getData").click( function() {
		var ckrow = jQuery("#list").jqGrid('getGridParam','selrow'); //체크된row값
		if( ckrow != null )
		{
			var getdata =  jQuery("#list").getRowData(ckrow); 
			var tranCd =	trim(getdata.tranCd);
			//리턴값
			var rtnArr = new Array();
			rtnArr[0] = getdata.chnlDstcd;	//채널구분코드
			rtnArr[1] = tranCd;				//거래코드
			rtnArr[2] = getdata.tranName;	//거래코드명
			rtnArr[3] = getdata.fldDiv;		//필드구성
			window.returnValue = rtnArr;
			self.close(); 
		}else{
			alert("선택해주세요.!");
		}
	});
	
	
	//jQuery("#list").jqGrid('navGrid',{edit:false,add:false,del:false});
	//jQuery("#list").setGridWidth(925,true); //가로스크롤

}
