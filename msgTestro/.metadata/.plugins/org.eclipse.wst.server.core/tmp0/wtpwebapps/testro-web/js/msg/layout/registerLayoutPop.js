//초기로딩
$(document).ready( function(){
	getListMngCode('chnlDstcd', 'CHLDIV', '01');	//채널구분
	getListMngCode('fldDiv', 'FLDDIV', '00');	//필드구성
	
	var param = window.dialogArguments;	//부모창 전달값
	
	if(param.chnlDstcd != ""){
		$("#chnlDstcd").val(param.chnlDstcd);	//채널구분
	}
	if(param.fldDiv != ""){
		$("#fldDiv").val(param.fldDiv);	//필드구성
	}
	
	setRefTranCd();	//헤더부참조코드 표시변경
	$("#refTranCd").val(param.refTranCd);	//헤더부참조코드
	
	$("#tranCd").val(param.tranCd);	//거래코드
	$("#tranName").val(param.tranName);	//거래명
});

//적용
function submit(){
	
	if($("#fldDiv").val() == '00'){	//필드구성
		alert("필드구성을 선택하세요");
		$("#fldDiv").focus();
		return;
	}
	
	//필수입력값 체크
	if($("#tranCd").val() == ''){	//거래코드
		alert("저장할 거래코드가 없습니다");
		$("#tranCd").focus();
		return;
	}
	
	/*
	if($("#fldDiv").val() == '02' && $("#refTranCd").val() == ''){	//헤더부참조코드
		alert("헤더부참조코드를 선택하세요");
		return;
	}*/
	
	//레이아웃 존재여부 체크
	$.ajax({
		type : "POST",
		url : "msg.layout.getLayoutCnt.do",
		data:{"chnlDstcd":$("#chnlDstcd").val(),
			  "tranCd":$("#tranCd").val()},
		success: function(data){
			if(data.result == "fail"){
				if(!confirm("이미 존재하는 거래코드입니다\n기존 데이터에 덮어쓰겠습니까?")){
					return;
				}
			}
			
			//리턴값
			var rtnArr = new Array();
			rtnArr[0] = $("#chnlDstcd").val();	//채널구분코드
			rtnArr[1] = $("#chnlDstcd option:selected").text();	//채널구분명
			rtnArr[2] = $("#tranCd").val();	//거래코드
			rtnArr[3] = $("#tranName").val();	//거래명
			rtnArr[4] = $("#fldDiv").val();	//필드구성
			rtnArr[5] = $("#fldDiv option:selected").text();	//필드구성명
			rtnArr[6] = $("#refTranCd").val();	//헤더부참조코드
			
			window.returnValue = rtnArr;
			self.close();
		}
	});
}

//필드구성,채널구분 변경시 헤더부참조코드 표시변경
function setRefTranCd(){
	if($("#fldDiv").val() == "01"){
		$("#refTranCdTitle").hide();	//헤더부참조코드 표시안함
		$("#refTranCd").hide();	//헤더부참조코드 표시안함
		$("#refTranCdImg").hide();	//헤더부참조코드 표시안함
		
		$("#refTranCd").val("");
		
		$("#tranCdTitle").text("헤더부코드 :");
		$("#tranNameTitle").text("헤더부명 :");
	} else if($("#fldDiv").val() == "02"){
		$("#refTranCdTitle").show();	//헤더부참조코드 표시
		$("#refTranCd").show();	//헤더부참조코드 표시
		$("#refTranCdImg").show();	//헤더부참조코드 표시
		
		$("#refTranCd").val("");
		
		$("#tranCdTitle").text("거래코드 :");
		$("#tranNameTitle").text("거래명 :");
	}
}

//헤더리스트 조회
function getHeaderList(){
	
	//레이아웃조회 팝업
    var url = "msg.layout.layout.do?chnlDstcd="+$("#chnlDstcd").val()+"&fldDiv=01";
    var returnValue = window.showModalDialog(url,window,'center:yes;dialogWidth=960px; dialogHeight=665px; dialogLeft=100px; dialogTop=50px; scroll=no; status=no; help=no; resizable:no;');
    
    if(returnValue != null){
		$("#refTranCd").val(returnValue[1]);
    }
}