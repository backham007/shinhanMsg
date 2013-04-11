var opener = window.dialogArguments;

var rptMap = {};

var tdDetail = {
  
    //수정버튼 클릭 이벤트
    modifyTdDetail: function(){
        $('#rptMap').val(JSON.stringify(rptMap));
        
        $.ajax({
            type: "POST"
            //, async: false
            , data: $('form[name=frm]').serialize()
            , dataType: "json"
            , async: false
            , url: "msg.tsmng.modifyTdDetail.do"
            , success:function(data, status) {
                if (data.errCd){
                    alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
                    return;
                }
                
                window.returnValue  = data.testDataDto;
                alert('적용되었습니다.');
                window.close();
            }
            , error:function(request, status, error) {
                alert("테스트 데이터 수정중에 오류가 발생하였습니다.[" + error + "]"); 
            }
        });
    },
    
    mngCheckPoint: function(){
        var returnList = window.showModalDialog('msg.tcmng.getTesCheck.do',window,'center:yes;dialogWidth=640px; dialogHeight=570px; dialogLeft=100px; dialogTop=50px; scroll=no; status=no; help=no; resizable:no;');
        
        if(returnList != undefined && returnList != ""){
            $('#chkYNVal').val(returnList);
            $('#isChangeChkYNVal').val("Y");
        }
    },
    
    inputRpt: function(target){
        var targetID = $(target).attr("id").split(",");
        
        var chnlDstcd = $("#chnlDstcd").val();
        var tranCd = $("#tranCd").val();
        var fldName = targetID[0];
        var fldDiv = targetID[1];
        
        var sendUrl = "msg.pretst.rptInput.do";
        sendUrl += "?chnlDstcd=" + chnlDstcd;
        sendUrl += "&tranCd=" + tranCd;
        sendUrl += "&fldName=" + fldName;
        sendUrl += "&fldDiv=" + fldDiv;
        
        var postData = window.showModalDialog(sendUrl,window,'center:yes;dialogWidth=950px; dialogHeight=680px; dialogLeft=100px; dialogTop=50px; scroll=no; status=no; help=no; resizable:no;');
        
        if(postData != undefined){
            var gridData = postData.gridData;
            var fldName = postData.fldName;
            rptMap[fldName] = gridData;
            
            $('#rptCnt_' + fldName).val(gridData.length);
        }
    }
};

$(document).ready(function(){
    var selInd = $('#selInd').val();
    if(selInd != ''){
        $("#selTd").val(JSON.stringify(opener.arrTestDataDTO[Number(selInd)]));
        
        var frm = document.frm;
        frm.action = "msg.tsmng.getJsonTdInfo.do";
        frm.submit();
    }
    
    $('#btnSave').click(tdDetail.modifyTdDetail);
    $('#btnMngCheck').click(tdDetail.mngCheckPoint);
    $('#btnClose').click(function(){
        window.close();
    });
    $('.btnRpt').click(function(){
        tdDetail.inputRpt(this);
    });
    
    rptMap = $.parseJSON($('#rptMap').val());
});