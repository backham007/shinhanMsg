var opener = window.dialogArguments;

var tsSave = {
    registerTs: function(isNew){
        var tsSnrioID = $.trim($('#currentTsSnrioID').val());
        var tsSnrioName = $.trim($('#tsSnrioName').val());
        var tsSnrioDesc = $.trim($('#tsSnrioDesc').val());
        
        if(tsSnrioName =="") {
            alert("시나리오명은 필수 입력사항입니다.");
            $('#tsSnrioName').focus();
            return;
        }else if(tsSnrioDesc ==""){
        	alert("시나리오 설명은 필수 입력사항입니다.");
        	$('#tsSnrioDesc').focus();
        	return;
        }
        
        if(isNew){
            tsSnrioID = "";
        }
        
        var testSnrioDetailDTOList = $("#jqGridTable", opener.document).getRowData();
        var iODataUseDTOList = opener.arrIODataUseDTO;
        var testDataDTOList = opener.arrTestDataDTO;
        
        $.ajax({
            type: "POST"
            //, async: false
            , data: {
                tsSnrioID: tsSnrioID
                , tsSnrioName: tsSnrioName
                , tsSnrioDesc: tsSnrioDesc
                , testSnrioDetailDTOList: JSON.stringify(testSnrioDetailDTOList)
                , iODataUseDTOList: JSON.stringify(iODataUseDTOList)
                , testDataDTOList: JSON.stringify(testDataDTOList)
            }
            , dataType: "json"
            , url: "msg.tsmng.registerTsInfo.do"
            , success:function(data, status) {
                if (data.errCd){
                    alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
                    return;
                }
                
                var testSnrioBasicDTO = data.testSnrioBasicDTO;
                window.returnValue = testSnrioBasicDTO;
                window.close(); 
            }
            , error:function(request, status, error) {
                alert("테스트 시나리오 저장중에 오류가 발생하였습니다.[" + error + "]"); 
            }
        });
    }
}

$(document).ready(function(){
    var currentTsSnrioID = $('#currentTsSnrioID').val();
    if(currentTsSnrioID == null || currentTsSnrioID == ''){
        $('#titleTsSnrioID').html('신규생성');
        $('#btnRegNewTs').attr("disabled", "disabled");
        
        //저장 버튼이벤트
        $('#btnRegTs td:eq(1)').click(function(){
            tsSave.registerTs(true);
        }); 
        
    }else{
        //다른이름 저장 버튼이벤트
        $('#btnRegNewTs td:eq(1)').click(function(){
            tsSave.registerTs(true);
        });    
        
        //저장 버튼이벤트
        $('#btnRegTs td:eq(1)').click(function(){
            tsSave.registerTs(false);
        }); 
    }
    
    
    //닫기 버튼이벤트
    $('#btnClose td:eq(1)').click(function(){
        window.close();
    }); 
});
