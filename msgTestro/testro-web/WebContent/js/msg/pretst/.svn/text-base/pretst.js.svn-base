function MM_swapImgRestore() { //v3.0
	var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
	}
	function MM_preloadImages() { //v3.0
	var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
	var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
	if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
	}
	 
	function MM_findObj(n, d) { //v4.01
	var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
	d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
	if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
	for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
	if(!x && d.getElementById) x=d.getElementById(n); return x;
	}
	 
	function MM_swapImage() { //v3.0
	var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
	if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
	}
	function MM_openBrWindow(theURL,winName,features) { //v2.0
	window.open(theURL,winName,features);
}
	 
// iframe resize
function autoResize(i)
{
	var iframeHeight=
	(i).contentWindow.document.body.scrollHeight;
	(i).height=iframeHeight+20;
}
var maxWidth= 1100; //전체사이즈
var leftTemp = 230; //left메뉴사이즈
function bodyreload(){
	var hidenYn = $("body").attr("hideYn");
	if("Y" == hidenYn){ //left 메뉴 hidden
		leftTemp=40;
	}else{ //left 메뉴 show
		leftTemp=230;
	}
	$(window).trigger('resize');
}


var rptMap = {};   //반복부

//전문레이아웃 팝업
function getLayoutOpen(){
	var url = "msg.layout.layout.do";
	var style = "dialogWidth:960px;dialogHeight:665px;center:1;help:0;scroll:0;status:0"; 
	var rtnArr = window.showModalDialog(url,window,style);
    if(rtnArr != null){
    	$("#chnlDstcd").val(rtnArr[0]);	//채널구분코드
        $("#tranCd").val(rtnArr[1]);	//거래코드
        $("#tranName").val(rtnArr[2]);	//거래코드명
        $("#fldDiv").val(rtnArr[3]);	//필드구성
        getDataList(true);
        
        $('#flowMsg').html('테스트실행버튼을 클릭하여 테스트를 실행하십시오.');
        
    }

}


//입력도우미
function createAutoData(gubun){
	
	var url = "msg.pretst.createAutoData.do";
	var style = "dialogWidth:640px;dialogHeight:510px;center:1;help:0;scroll:0;status:0"; 
	var reParam = window.showModalDialog(url,window,style);
	if(reParam == undefined) {
		return;
	} else {
	
		var headerCharLength = 0;
		var totalInputs = invislen.getElementsByTagName("input");				//거래개별부 Div id=invislen 안에 input
		var headerInputs = divHeader.getElementsByTagName("input");
		
		var startIndex = headerCharLength;
		
		var fldName;               								//반복부 구분하기 위한 필드네임
		var setCnt = 0;
		
		for(var i = 0 ; i < totalInputs.length ; i++){							//input 갯수만큼
			//alert(i+") "+idFullName+" : "+ totalInputs[i].value);
			if(totalInputs[i].rptName == null){
				var byteLength = 0;
				var endIndex = startIndex;
				while(byteLength < Math.floor(totalInputs[i].slen)){								//필드길이
				
					//한글인 경우 2byte
					var chr = escape(reParam.charAt(endIndex));
		            if (chr.length < 6){
	                //한글아님 1byte
	                	
	                } else {
	                	//한글 2byte
	                	byteLength++;
	                }
	            	            
					byteLength++;
					endIndex++;
	
				}
				
				var value;
				
				//hex 변경
				if(totalInputs[i].id == "hex"){
					var hexName = reParam.substring(startIndex,endIndex);
					$.ajax({
						type : "POST",
						async : false,
						url :"msg.pretst.hexString.do",
						data:{
							  "hexName":hexName},
						success: function(data){
							value = data.hexString;       //hex값을 채움
					
						}
					});
				}else{
					//alert(startIndex+","+endIndex+" : "+reParam.substring(startIndex,endIndex));
					value = reParam.substring(startIndex,endIndex);    	//값을 채움
				}
				
				if(gubun == "header" || i >= headerInputs.length){
					totalInputs[i].value = value;
				}

				var idFullName=totalInputs[i].id;
				var idName = idFullName.substr(0,6);
				if(idName == "rptid_"){
					fldName = (totalInputs[i].id).split("_N_")[1];     			//fidName 만 가져오기 
					setCnt = parseInt(value);
					if(gubun == "header" || i >= headerInputs.length){
						rptMap[fldName] = new Array();
					}
				}
				
				startIndex = endIndex;
				
			} else {
				
				var a = i;
				
				for(var j=0; j < setCnt; j++){  								//반복부값 밀어넣기
					
					var rowData = {};
					
		    		for(a = i; a < totalInputs.length && totalInputs[a].rptName == fldName; a++){							//input 갯수만큼
		    			var byteLength = 0;
						var endIndex = startIndex;
			    		while(byteLength < Math.floor(totalInputs[a].slen)){			      	//필드길이				
			    			
			    			//한글인 경우 2byte
							var chr = escape(reParam.charAt(endIndex));
				            if (chr.length < 6){
			                //한글아님 1byte
			                	
			                } else {
			                	//한글 2byte
			                	byteLength++;
			                }
			            
		    				byteLength++;
		    				endIndex++;
			    		}
			    		
			    		if(gubun == "header" || a >= headerInputs.length){
				    		//hex 변경
							if(totalInputs[a].id == "hex"){
								var hexName = reParam.substring(startIndex,endIndex);
								$.ajax({
									type : "POST",
									async : false,
									url :"msg.pretst.hexString.do",
									data:{
										  "hexName":hexName},
									success: function(data){
//									    rptMap[fldName].push(data.hexString);       
									    rowData[totalInputs[a].fldName] = data.hexString;	//hex값을 채움
									}
								});
								
								
							}else{
//								rptMap[fldName].push(reParam.substring(startIndex,endIndex));		//반복부  값 저장
								rowData[totalInputs[a].fldName] = reParam.substring(startIndex,endIndex);
							}
			    		}
						startIndex = endIndex;
		    		}
		    		
		    		if(gubun == "header" || a >= headerInputs.length) rptMap[fldName].push(rowData);
//		    		alert(rptMap[fldName]);
		    	}
				
				if(i < a) i = a-1;
//				alert(JSON.stringify(rptMap));
				//if(gubun == "header" || i >= headerInputs.length) $.cookie('repeat_cookie', JSON.stringify(rptMap));   //쿠키에 값저장
			}
		}
		
		//정책금융공사 전문길이와 레이아웃길이 비교
		if(startIndex != reParam.length && reParam.substr(startIndex,1) != '@'){
			alert("입력된 전문과 레이아웃의 길이가 일치하지 않습니다");
		}
	}
}

//거래명 비활성화
function inputTranName(){
	var value = $("#tranName").val();
	if(value == ""){
		$("#tranName").attr("disabled", "disabled");
	}else{
		$("#tranName").attr("disabled", "");
	}
}



// 거래코드 조회
function getDataList(isPop)
{
	
	var frm = document.frmName;
	frm.tranCd.value = frm.tranCd.value.trim();
	if(frm.tranCd.value == ""){
		alert("거래코드를 입력하시기 바랍니다.");
		frm.tranCd.focus();
		return;
	} else {
		if(frm.tranCd.value.length < 6){
			alert("거래코드는 6글자 이상 입력하십시오.");
			frm.tranCd.value="";
			frm.tranCd.focus();
			return;
		}
		
//		if(!isNotAlphaOrNum(frm.tranCd.value)){
//			alert("영문과 숫자만 입력가능합니다. 확인 후  입력하시기 바랍니다.");
//			frm.tranCd.value="";
//			frm.tranCd.focus();
//			return;
//		}
		
		//$.cookie('repeat_cookie','');
		
		if(!isPop) $("#tranCd").val($("#tranCd").val().toUpperCase());
		
		//$.cookie('repeat_cookie','');
		
		$.blockUI();
		frm.action="msg.layout.getPretstDiv.do";
		frm.submit();
		
	}
	
}



// 반복부입력
function rptInput(fldDiv, fldName, count){    //반복부 필드네임 , 위치
	var par="";
	var chnlDstcd = $("#chnlDstcd").val();
	var tranCd = $("#searchTranCd").val();
	//전문레이아웃 반복부필드조회 하기위에 필요한값
	par = "?chnlDstcd="+chnlDstcd+"&tranCd="+tranCd+"&fldDiv="+fldDiv+"&fldName="+fldName;   
	var url = "msg.pretst.rptInput.do"+par;
	var style = "dialogWidth:950px;dialogHeight:680px;center:1;help:0;scroll:0;status:0"; 
	var postData = window.showModalDialog(url,window,style);
	if(postData != undefined){
		var gridData = postData.gridData;     //그리드값
		var fldName = postData.fldName;       //필드Name
		rptMap[fldName] = gridData;
	
		/*
    	for(var i=0, cnt=gridData.length; i<cnt; i++){
    		for(var key in gridData[i]){
    			rptMap[fldName].push(gridData[i][key]);     //입력값만 뽑아서 담음
    			
    	    }
    	}*/
//    	$.cookie('repeat_cookie', JSON.stringify(rptMap));   //쿠키에 값저장  뒤로가기 버튼 사용
    	
    	$("#rptid_"+count+"_N_"+fldName).val(gridData.length);       //반복부 횟수 셋팅
    }
//	if(cnt == undefined){
//	}else{
//		$("#rptid_"+count+"_N_"+fldName).val(cnt);       //반복부 횟수 셋팅
//	}
}

$(document).ready(function(){
	//init_check();
});



//테스트 실행
function getExecuteTest()
{
	var frm = document.frmName;
		if(frm.tranCd.value == ""){
			alert("메시지ID를 입력하시기 바랍니다.");
			frm.tranCd.focus();
			return;
		}
		
		var connSevrDstcd = $("#connSevrDstcd").val();
		var tranCd = $("#searchTranCd").val();
		frm.tranCd.value = tranCd;
		
		if((connSevrDstcd=="03"||connSevrDstcd=="04"||connSevrDstcd=="05"||connSevrDstcd=="06") && tranCd != "BIE9901C") {
			alert("대외MCI거래(BIE9901C)가 아닙니다. 접속서버를 확인해 주세요.");
			return;
		} else if((connSevrDstcd=="01"||connSevrDstcd=="02") && tranCd == "BIE9901C") {
			alert("대외MCI거래(BIE9901C)입니다. 접속서버를 확인해 주세요.");
			return;
		}
		
		frm.rptMap.value = JSON.stringify(rptMap);  //반복부 데이터
		//alert(frm.rptMap.value);
		//$.cookie('repeat_cookie', frm.rptMap.value);   //쿠키에 값저장  뒤로가기 버튼 사용
		frm.action="msg.pretst.getPretstResult.do";
		$.blockUI();
		frm.submit();
}

//쿠키값
function init_check(){
//	var repeat_cookie = $.parseJSON($.cookie('repeat_cookie'));
//	if(repeat_cookie != null){
//		rptMap = repeat_cookie;
//	}
}