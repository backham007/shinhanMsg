// 코드 목록 조회(셀렉트 박스 데이터 조회 ) ex)getListMngCode(아이디, 파라메터 , 선택값(value));
function getListMngCode(objId,paramVal,seletedValue){
	
	var temp = $.blockUI.defaults.message;
	$.blockUI.defaults.message = "";	//AJAX Blocking 메시지표시 안함
	
	$.ajax({
		type : "POST",
		async : false,
		url : "msg.cmn.getListMngCode.do",
		data:{"useYN":"Y","sidx":"OUTPTSEQNO","cdclMnName":paramVal},
		success: function(data){
			
			if (data.errCd){
				alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
				return;
			}
			
			//테스트단계명 select box 데이터삭제
			$("#"+objId+" option").remove();
			
			//테스트단계명 추가
			for(var i = 0 ; i < data.list.length ; i++){
				if(seletedValue == data.list[i].dtailCd)
					$('#'+objId).append("<option value='"+data.list[i].dtailCd+"' selected>"+data.list[i].dtailName+"</option>");
				else
					$('#'+objId).append("<option value='"+data.list[i].dtailCd+"'>"+data.list[i].dtailName+"</option>");
			}
		},
		 error: function (request, status, error) { 
			 alert("코드목록 조회중 오류가 발생하였습니다.[" + error + "]"); 
		 }

	});
	
	$.blockUI.defaults.message = temp;	//AJAX Blocking 메시지표시 함
}

function getDateFormat(date){
	
	var tranDate = date.substr(0,4)+"-"+date.substr(4,2)+"-"+date.substr(6,2)
	return tranDate;
}

function disabledObject(val){
	
	for ( var i = 0; i < val.length; i++) {
		$('#'+val[i]).attr('disabled', 'true');
		
	}
	
}

function getDateFormatForExcel(defRegYMS){
	var val =  defRegYMS.substr(0,4)+"-"+defRegYMS.substr(4,2)+"-"+defRegYMS.substr(6,2)+" "+defRegYMS.substr(8,2)+":"+defRegYMS.substr(10,2)+":"+defRegYMS.substr(12,2);
	return val;
}

function bodyreload(){//그리드 리사이즈
	var hidenYn = $("body").attr("hideYn");
	if("Y" == hidenYn){ //left 메뉴 hidden
		leftTemp=55;
	}else{ //left 메뉴 show
		leftTemp=230;
	}
	$(window).trigger('resize');
}

// 첫번째 row 선택
function setSelection(gridId){
	var dataIds=new Array();
	dataIds=$('#' + gridId).getDataIDs();
	
	 if(dataIds.length > 0) $('#'+gridId).jqGrid('setSelection', dataIds[0], false); 
    //for(i=0;i<dataIds.length;i++) {
}

//그리드 width 리사이즈..
function reloadGridWidthSize(gridId,leftTemp){
	var windwoWindth = $(window).width()-leftTemp;
	$("#"+gridId).setGridWidth(windwoWindth, true);
}

// form 에 '== 전체 ==' 문자열 세팅
function setAllSearch(objId){
	
	$('#'+objId).attr('value','== 전체 ==') 
	.css({'color':'#ababab'})
	.focus(function(){
		if(this.style.color == '#ababab' || this.style.color == "rgb(171, 171, 171)"){
			this.value = '';
			this.style.color = '#000';
		} 		   
	})
	.blur(function(){
		if(this.value == ''){
			this.style.color = '#ababab';
			this.value = '== 전체 ==';
		}  
	});
	
}

// 조회시,  == 전체 == 문자열 처리
function getAllSearchValue(objId){
	var colorCSS = $('#'+objId).css('color');
	var result = "";
	if(colorCSS != "#ababab" && colorCSS != "rgb(171, 171, 171)"){
		result = $('#'+objId).val();
	}else{
		result = "";
	}
	return result;
}

