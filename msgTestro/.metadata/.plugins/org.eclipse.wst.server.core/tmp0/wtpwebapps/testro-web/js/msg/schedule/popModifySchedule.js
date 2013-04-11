var opener = window.dialogArguments;
$(document).ready(function(){
	var jobResrvYms = $('#jobResrvYms')[0].value;
	
	var prevDate = jobResrvYms.substring(0, 8);
	var endDateHH = jobResrvYms.substring(8, 10);
	var endDateMM = jobResrvYms.substring(10, 12);
	
	prevDate = addDateDelimiterEdit(prevDate);
	
	// 시간, 분 리스트 설정
    for ( var int = 0; int < 24; int++) {
    	var value = "";
    	if (int < 10) {
    		value = "0" + int;
    	} else {
    		value = int+ "";
    	}
    	
    	$('#hour').append("<option value='" + value + "'>" + value + "</option>");
	}
    
    for ( var int = 0; int < 60; int++) {
    	var value = "";
    	if (int < 10) {
    		value = "0" + int;
    	} else {
    		value = int+ "";
    	}
    	$('#min').append("<option value='" + value + "'>" + value + "</option>");
	}
    
    var currentDate = getTimeStampYMD();
    $('#prevDate')[0].value = prevDate;
    $('#hour')[0].value = endDateHH;
    $('#min')[0].value = endDateMM;
    
    //테스트대상시스템 세팅
    getListMngCode('connSevrDstCd','CONNSEVRDSTCD',$('#pConnSevrDstCd').val());
});



function validation() {
	if(isNull($('input[name="jobResrvCnt"]')[0].value)) {
		alert("테스트 예약실행 설명을 반드시 입력하셔야 합니다.");
		$('input[name="jobResrvCnt"]')[0].focus();
		return false;
	}
	
	return true;
}


function save() {
	if (!validation()) return;
	var jobResrvYms = $('#prevDate')[0].value.split('-').join('') + $('#hour')[0].value + $('#min')[0].value + '00';
	
	$('#jobResrvYms')[0].value = jobResrvYms;
	dataString = $("#form").serialize();
	$.ajax({ 
		 type: "POST",
		 async: true,
		 data:dataString, 
		 url:'msg.schedule.modifySchedule.do', 
		 success: function(data){
			 alert("테스트 예약설정이 저장되었습니다.");
			 if (opener) {
				 window.returnValue=true;
				 window.close();
			} 

		 },
		 error: function (request, status, error) { 
			 alert("테스트 예약설정이 저장중에 오류가 발생하였습니다.[" + error + "]"); 
		 }
	 });
	
}

