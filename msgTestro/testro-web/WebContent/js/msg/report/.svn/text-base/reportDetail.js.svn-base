// iframe resize
function autoResize(i)
{
    var iframeHeight=
    (i).contentWindow.document.body.scrollHeight;
    (i).height=iframeHeight+20;
}
function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}

var tabIdx = 0;	//탭인덱스(0:테스트결과,1:입력데이터,2:출력데이터,3:체크포인트,4:결함관리,5:결함조치)
var tsDataId; //테스트데이터ID
var tsDataAcmplnth;	//테스트데이터수행회차

$(document).ready(function(){

	$("#apDiv2").find("font").click( function() {//datalist click
		
		var laselokid    = $("#apDiv2").find(".tap_box_ok").attr("id");
		var laselfaultid = $("#apDiv2").find(".tap_box_fault").attr("id");
		var laseltbid    = "";
		
		if(laselokid){
			laseltbid    = laselokid.replace('td','tb');
			$("#"+laselokid).removeClass('tap_box_ok');
			$("#"+laseltbid).addClass('tap_box_ok_off');
		}
		
		if(laselfaultid){
			laseltbid    = laselfaultid.replace('td','tb');
			$("#"+laselfaultid).removeClass('tap_box_fault');
			$("#"+laseltbid).addClass('tap_box_fault_off');
		}
		
		//${status.count}||${datalist.rsultsucssyn}||${datalist.tscaseid}||${datalist.acmplnth}||${datalist.tsdataid}||${datalist.tsdataacmplnth}
		var temp = $(this).attr("id").split('||'); //tag id ||성공실패여부||케이스아이디||케이스회차||데이타아이디||데이타회차
		
		tsDataId = temp[4]; //테스트데이터ID
		tsDataAcmplnth = temp[5];	//테스트데이터수행회차

		leftFocusChange(temp[4]+"_"+temp[5]);//(left data focus)${datalist.tsdataid}+"_"+${datalist.tsdataacmplnth
		reLoadDiv(temp);
		
	});
	
	if($("#tsDataId").val() != '' && $("#tsDataAcmplnth").val() != ''){
		leftFocusChange($("#tsDataId").val()+"_"+$("#tsDataAcmplnth").val());
		
		if($("#tabGubun").val() != null){
			changeTab($("#tabGubun").val());
		} else {
			changeTab(tabIdx);
		}
	}
	
});

//탭별 DIV 데이터 조회
function reLoadDiv(temp){
	//${status.count}||${datalist.rsultsucssyn}||${datalist.tscaseid}||${datalist.acmplnth}||${datalist.tsdataid}||${datalist.tsdataacmplnth}
	//var left_id = $("#apDiv2").find("#ltb_1 font").attr("id").split('||');
	
	var url;
	if(tabIdx == 0){	//테스트결과
		url = "msg.report.getTestResult.do";
	} else if(tabIdx == 1){	//입력데이터
		url = "msg.report.getListInputData.do";
	} else if(tabIdx == 2){	//출력데이터
		url = "msg.report.getListOutputData.do";
	} else if(tabIdx == 3){	//체크포인트
		url = "msg.report.getListCheckPoint.do";
	} else if(tabIdx == 4){	//결함관리
		url = "msg.flaw.flawMng.do";
	} else if(tabIdx == 5){	//결함조치
		url = "msg.flaw.flawTreat.do";
	} 
	
	var tsDataId = temp[4];
	var tsDataAcmplnth = temp[5];
	
	//alert(tsDataId+","+tsDataAcmplnth);
	
	$("#apDiv1").empty();
	
	//var temp = left_id.split('||');
	$.ajax({
	    type: "POST",
	    url:url,
	    dataType:'html',
	    data:{"tsDataId":tsDataId,"tsDataAcmplnth":tsDataAcmplnth,"gubun":$("#gubun").val()},
	    success: function(xhr){
	    	if(xhr != null && xhr.substring(0,1) == '{'){
	    		var data = $.parseJSON(xhr);
	    		//오류코드 처리
				if(data.errCd){
					alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
				}
	    	} else {
				$("#apDiv1").append(xhr);
	        	
	        	if(tabIdx == 4){
	        		initFlaw();
	        	} else if(tabIdx == 5){
	        		initTreat();
	        	}
			}
	    },
	    error: function (request, status, error) { 
			 alert("조회중 오류가 발생하였습니다.[" + error + "]"); 
		}
	});
}

//탭변경(0:테스트결과,1:입력데이터,2:출력데이터,3:체크포인트,4:결함관리,5:결함조치)
function changeTab(tabIndex){
	
	tabIdx = tabIndex;
	var tabTextArray = ["테스트결과","입력데이터","출력데이터","체크포인트","결함관리","결함조치"];
	
	$("#tabs table").each( function(i){
		if(i == tabIdx){
			$(this).html("<TR><TD width=5 background='images/tab_01.gif' height=30></TD>" +
					      "<TD class='tab_tit' onClick='changeTab("+i+");' style='cursor: pointer'>"+tabTextArray[i]+"</TD>" +
					      "<TD width=5 background='images/tab_03.gif'></TD></TR>");
		} else {
			$(this).html("<TR><TD width=3><IMG height=30 src='images/tab01_01.gif' width=4></TD>" +
						 "<TD class='tab_tit02' onClick='changeTab("+i+");' style='cursor: pointer'>"+tabTextArray[i]+"</TD>" +
						 "<TD ><IMG height=30 src='images/tab03_03.gif' width=3></TD></TR>");
		}
	});
	
	var left_id = $("#apDiv2").find("#ltb_"+tsDataId+"_"+tsDataAcmplnth+" font").attr("id").split('||');
	reLoadDiv(left_id);
}

//데이타 리스트 포커스 이벤트
function leftFocusChange(focusId){
	
	tsDataId = focusId.split("_")[0];
	tsDataAcmplnth = focusId.split("_")[1];  
	
	var sucYn = $("#ltd_"+focusId).find("IMG").attr("src");
	if( "images/icon_rep_ok.gif" == sucYn || "images/icon_rep_ok_green.gif" == sucYn){
		$("#ltb_"+focusId).removeClass('tap_box_ok_off');
		$("#ltd_"+focusId).addClass('tap_box_ok');
	} else {
		$("#ltb_"+focusId).removeClass('tap_box_fault_off');
		$("#ltd_"+focusId).addClass('tap_box_fault');			
	}
}

//테스트케이스 화면으로 이동
function moveCase(){
	//테스트 케이스관리
	$.cookie('top_menu', "top_menu_01"); //cookie를 셋트
	$.cookie('left_menu', "leftmenu_1_4"); //cookie를 셋트
	
	var tsCaseID = $("#tsCaseID").val();
	
	try {
		var mainWindow = window.opener;
		self.close();
		if(mainWindow.opener != undefined){	//통계보고서에서 띄운경우(modal > popup)
			mainWindow = mainWindow.opener;
			window.opener.close();
		}		
		mainWindow.location = "msg.tcmng.tcmng.do?tsCaseID=" + tsCaseID;
		
	} catch (e) {
		var mainWindow = window.opener;
		self.close();
		mainWindow.location = "msg.tcmng.tcmng.do?tsCaseID=" + tsCaseID;		
	}
	
}

//테스트시나리오 화면으로 이동
function moveSnrio(){
	//테스트시나리오관리
	$.cookie('top_menu', "top_menu_01"); //cookie를 셋트
	$.cookie('left_menu', "leftmenu_1_5"); //cookie를 셋트
	
	var tssnroId = $("#tssnroId").val();

	try {
		var mainWindow = window.opener;
		self.close();
		if(mainWindow.opener != undefined){	//통계보고서에서 띄운경우(modal > popup)
			mainWindow = mainWindow.opener;
			window.opener.close();
		}		
		mainWindow.location = "msg.tsmng.tsmng.do?tssnroId=" + tssnroId;
		
	} catch (e) {
		var mainWindow = window.opener;
		self.close();
		mainWindow.location = "msg.tsmng.tsmng.do?tssnroId=" + tssnroId;		
	}
}