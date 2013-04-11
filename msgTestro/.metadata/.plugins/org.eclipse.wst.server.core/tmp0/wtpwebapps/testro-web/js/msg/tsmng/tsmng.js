// 전역변수
var contextCi;    // cell 인덱스
var contextRowid; // row id

var maxWidth= 1100; //전체사이즈(그리드전체사이즈)
var maxHeight= 300; //전체사이즈(그리드전체사이즈)
var leftTemp = 230; //left메뉴사이즈

var tsmng = {
    btnEventMap: {
        //실행버튼
        btnExecute: function(){
            if('Y' != $('#isGridSave').val()){
                alert('변경된 내용이 있습니다\n저장 후 실행해 주세요.');
                return;
            }
            
            var tsSnrioID = $('#currentTsSnrioID').val();
            var arrRowData = $("#jqGridTable").getRowData();
            
            //실행시 모든버튼 비활성화
            tsmng.setGridResult();
            tsmng.bindButtonEvent('btnExecute', false);
            tsmng.bindButtonEvent('btnLoad', false);
            tsmng.bindButtonEvent('btnSave', false);
            tsmng.bindButtonEvent('btnUseIO', false);
            tsmng.bindButtonEvent('btnReset', false);
            tsmng.bindButtonEvent('btnDelete', false);
            tsmng.bindButtonEvent('btnMoveDown', false);
            tsmng.bindButtonEvent('btnMoveUp', false);
            tsmng.bindButtonEvent('btnNew', false);
            tsmng.bindButtonEvent('btnAddTc', false);
            $('.btnResult').hide();
            $('#prcssMsg').html("총 " + arrRowData.length + "건중 0건이 실행 되었습니다.");
                    
            tsmng.executeTs(tsSnrioID, arrRowData);
        },
        
        //불러오기
        btnLoad: function(){
            var gridCnt = tsmng.gridFunction.size();
            if(gridCnt > 0){
                if(!confirm("작업중인 모든 정보가 초기화 됩니다.\n\n테스트시나리오를 불러오시겠습니까?")){
                    return;
                }
            }
            
            var returnValue = window.showModalDialog('msg.tsmng.tsList.do',window,'center:yes;dialogWidth=950px; dialogHeight=765px; dialogLeft=100px; dialogTop=50px; scroll=no; status=no; help=no; resizable:no;');
            
            if(returnValue != undefined && returnValue != ""){
                tsmng.loadTsSnrio(returnValue);
            }
        },
        
        //저장
        btnSave: function(){
            if(tsmng.gridFunction.size() < 1) {
                alert("저장할 내역이 없습니다.");
                return;
            }
            
            var sendUrl = 'msg.tsmng.tsSave.do';
            sendUrl += '?tsSnrioID=' + $('#currentTsSnrioID').val();
            
            var returnValue = window.showModalDialog(sendUrl,window,'center:yes;dialogWidth=700px; dialogHeight=200px; dialogLeft=100px; dialogTop=50px; scroll=no; status=no; help=no; resizable:no;');
            
            if(returnValue != undefined){
                tsmng.setGridTs(returnValue);
                
                //isCopy 데이터 초기화
                var ids = $("#jqGridTable").getDataIDs();
                for(var i = 0 ; i < ids.length ; i++){
                	$("#jqGridTable").jqGrid('setCell',ids[i],"isCopy"," ");
                }
                
                $('#flowMsg').html('테스트 실행 버튼을 클릭하여 시나리오를 재실행 할 수 있습니다.');
                alert("테스트시나리오가 저장 되었습니다.");
            }
        },
        
        //입출력값활용
        btnUseIO: function(){
            var arrSelGridId = $("#jqGridTable").jqGrid('getGridParam','selarrrow');
            if(arrSelGridId.length < 1 ){
                alert('입출력값 활용할 테스트데이터를 선택해주십시오.');
                return false;
            }else if(arrSelGridId.length > 1 ){
                alert("다중선택한 상태에서 출력값활용을 할수 없습니다.");
                return false;
            }
            
            var selGridId = $.trim(arrSelGridId[0]);
            var selRow = $("#jqGridTable").getRowData(selGridId);
            
            tsmng.openUseIO(selRow);
        },
        
        //초기화 버튼
        btnReset: function(){
            if(confirm("초기화를 하게되면 작업중인 모든 데이터가 사라지게 됩니다.\n\n초기화 하시겠습니까?")){
                tsmng.gridFunction.clear();
                tsmng.resetTsTitle();
                
                tsmng.setGridResult();
                tsmng.bindButtonEvent('btnExecute', false);
                tsmng.bindButtonEvent('btnLoad', true);
                tsmng.bindButtonEvent('btnSave', false);
                tsmng.bindButtonEvent('btnUseIO', false);
                tsmng.bindButtonEvent('btnReset', false);
                tsmng.bindButtonEvent('btnDelete', false);
                tsmng.bindButtonEvent('btnMoveDown', false);
                tsmng.bindButtonEvent('btnMoveUp', false);
                tsmng.bindButtonEvent('btnNew', true);
                tsmng.bindButtonEvent('btnAddTc', false);
                $('#prcssMsg').html("");
                $('.btnResult').hide();
                
                $('#flowMsg').html('신규생성 및 불러오기를 하실 수 있습니다.');
                
                $('#isGridSave').val('N');    
            }
        },
        
        //삭제버튼
        btnDelete: function(){
            //선택한 컬럼 삭제는 삭제후 선택된 아이디가 남아 있어 아래와 같은 처리를 해준다.
            var arrSelGridId = $("#jqGridTable").jqGrid('getGridParam','selarrrow');
            
            if(arrSelGridId.length < 1 ){
                alert("삭제할 row를 선택하세요."); 
                return
            }
            if(!confirm("선택된 테스트케이스를 목록에서 삭제하시겠습니까?")){
                return;
            }
            
            /*var arrIds = new Array();
            $.each(arrSelGridId, function(index, value){
                arrIds.push(value);
            });*/
            
            var arrIds = $("#jqGridTable").getDataIDs();
            var arrTsSnrioNOs = $("#jqGridTable").getCol("tsSnrioNO");
            
            for(var i=0, cnti=arrSelGridId.length; i<cnti; i++){
                var selInd = $("#jqGridTable").getInd(arrSelGridId[i]);
                //삭제할 수행순서의 입출력값을 활용하는 수행순서를 담는다.
                var arrUseIO = new Array();
                
                //삭제할 수행순서를 활용하는 입출력값이 있는지 확인
                for(var j=selInd, cntj=arrIODataUseDTO.length; j<cntj; j++ ){
                    for(var k=0, cntk=arrIODataUseDTO[j].length; k<cntk; k++ ){
                        var isUse = false;
                        if($.trim(arrTsSnrioNOs[selInd-1]) == $.trim(arrIODataUseDTO[j][k].preSnrioNO)){
                            
                            arrUseIO.push($("#jqGridTable").getCell(arrIds[j], "tsSnrioNO"));
                            isUse = true;
                        }
                        
                        if(isUse) break;
                    }
                }
                
                if(arrUseIO.length > 0){
                    alert("수행순서(" + arrUseIO + ")에서 수행순서 " + arrTsSnrioNOs[selInd-1] + " 의 입출력값활용 있습니다.\n입출력값을 제거한 후 삭제해 주십시요.");
                    return;
                }
            }
            
            //입출력값을 활용한 수행순서가 변경되면 변경한다.
            for(var j=0, cntj=arrIODataUseDTO.length; j<cntj; j++ ){
                for(var k=0, cntk=arrIODataUseDTO[j].length; k<cntk; k++ ){
                    var delCount = 0;
                    var oldNo = Number($.trim(arrIODataUseDTO[j][k].preSnrioNO));
                    
                    for(var i=0, cnti=arrSelGridId.length; i<cnti; i++){
                        var selInd = $("#jqGridTable").getInd(arrSelGridId[i]);
                        
                        var delNo = Number($.trim(arrTsSnrioNOs[selInd-1]));
                        if(delNo < oldNo){
                            delCount++;
                        }
                    }
                    arrIODataUseDTO[j][k].preSnrioNO = String(oldNo-delCount);
                }
            }
                
            tsmng.gridFunction.remove(arrSelGridId);
            
            tsmng.setGridResult();
            $('#prcssMsg').html("");
            $('.btnResult').hide();
            
            $('#isGridSave').val('N');
        },
        
        btnMoveUp: function(){
            tsmng.moveRow('up');
        },
        
        btnMoveDown: function(){
            tsmng.moveRow('down');
        },
        
        btnNew: function(){
            if(tsmng.gridFunction.size() > 0){
                if(!confirm("작업중인 모든 정보가 초기화 됩니다.\n\n신규 테스트시나리오를 생성하시겠습니까?")){
                    return;
                }
            }
            
            tsmng.gridFunction.clear();
            tsmng.resetTsTitle(true);
            tsmng.setGridResult();
            
            tsmng.bindButtonEvent('btnExecute', false);
            tsmng.bindButtonEvent('btnLoad', true);
            tsmng.bindButtonEvent('btnSave', false);
            tsmng.bindButtonEvent('btnUseIO', false);
            tsmng.bindButtonEvent('btnReset', false);
            tsmng.bindButtonEvent('btnDelete', false);
            tsmng.bindButtonEvent('btnMoveDown', false);
            tsmng.bindButtonEvent('btnMoveUp', false);
            tsmng.bindButtonEvent('btnNew', true);
            tsmng.bindButtonEvent('btnAddTc', true);
            $('#prcssMsg').html("");
            $('.btnResult').hide();
            
            $('#flowMsg').html('기존테스트케이스 추가 버튼을 클릭하여 테스트케이스를 추가해 주십시오.');
            
            $('#isGridSave').val('N'); 
        },
        
        btnAddTc: function(){
            //테스트데이터 ID목록을 Array()로 받음
            var returnList = window.showModalDialog('msg.tcmng.getTcmngAdd.do',window,'center:yes;dialogWidth=950px; dialogHeight=760px; dialogLeft=100px; dialogTop=50px; scroll=no; status=no; help=no; resizable:no;');
            
            if(returnList == null){
                return;
            }
            
            $.ajax({
                type: "POST"
                //, async: false
                , data: {
                    jsonTsdataIds: JSON.stringify(returnList)
                }
                , dataType: "json"
                , url: "msg.tsmng.getListTdInfo.do"
                , success:function(data, status) {
                    if (data.errCd){
                        alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
                        return;
                    }
                    
                    if(tsmng.gridFunction.append(data.testSnrioBasicDTO)){
                    
	                    tsmng.setGridResult();
	                    tsmng.bindButtonEvent('btnExecute', true);
	                    tsmng.bindButtonEvent('btnLoad', true);
	                    tsmng.bindButtonEvent('btnSave', true);
	                    tsmng.bindButtonEvent('btnUseIO', true);
	                    tsmng.bindButtonEvent('btnReset', true);
	                    tsmng.bindButtonEvent('btnDelete', true);
	                    tsmng.bindButtonEvent('btnMoveDown', true);
	                    tsmng.bindButtonEvent('btnMoveUp', true);
	                    tsmng.bindButtonEvent('btnNew', true);
	                    tsmng.bindButtonEvent('btnAddTc', true);
	                    $('#prcssMsg').html("");
	                    $('.btnResult').hide(); 
	                    
	                    $('#flowMsg').html('테스트시나리오를 편집 후 저장하십시오.');
	                    
	                    $('#isGridSave').val('N');
	                    
	                    tsmng.initGrid();
	                    
	                    tsmng.gridFunction.scrollBottom();
                    }
                }
                , error:function(request, status, error) {
                    alert("기존 테스트 케이스 추가중에 오류가 발생하였습니다.[" + error + "]"); 
                }
            });
        },
        
        //결과 보고서 보기
        btnResult: function(){
            var tssnrioid = $('#resultTssnrioid').val();
            var acmplnth = $('#resultAcmplnth').val();
            var gubun = "02";
            
            var sendUrl = "msg.report.reportDetail.do";
            sendUrl += "?tssnrioid=" + tssnrioid;
            sendUrl += "&acmplnth=" + acmplnth;
            sendUrl += "&gubun=" + gubun;
            
            window.open(sendUrl,"결과상세보고서","location=no,resizable=no,status=no,width=980,height=770");
            //window.showModalDialog(sendUrl,window,'center:yes;dialogWidth=980px; dialogHeight=777px; scroll=no; status=no; help=no; resizable:no; ');
        }
    },
    
    //버튼 이벤트 설정
    bindButtonEvent: function(btnId, isBind){
        if(isBind){
            $('#' + btnId).unbind('click');
            $('#' + btnId).click(tsmng.btnEventMap[btnId]);
            
            //상위버튼
            if($('#' + btnId).attr("href") != undefined){
                var btnImg = $('#' + btnId).children().attr("src");
                $('#' + btnId).children().attr("src", btnImg.replace("03.", "01."));
                
                tsmng.changeTopButton(btnId, true);
            }else{
                $('#' + btnId).attr("disabled", "");
            }
        }else{
            $('#' + btnId).unbind('click');
            
            //상위버튼
            if($('#' + btnId).attr("href") != undefined){
                var btnImg = $('#' + btnId).children().attr("src");
                $('#' + btnId).children().attr("src", btnImg.replace("01.", "03."));
                tsmng.changeTopButton(btnId, false);
            }else{
                $('#' + btnId).attr("disabled", "disabled");
            }
        }
    },
    
    //상단버튼 활성화 비활성화
    changeTopButton: function(btnId, isBind){
        $('#' + btnId).unbind('mouseover');
        
        var buttonOnOffNum = isBind? "02": "03";
        var buttonImgName = {
            btnNew: ["Image56", "newtc"],
            btnLoad: ["Image57", "import"],
            btnSave: ["Image58", "savetc"],
            btnReset: ["Image59", "initialize"]
        };
        
        $('#' + btnId).unbind('mouseover');
        $('#' + btnId).unbind('mouseout');
        if(isBind){
            $('#' + btnId).bind('mouseout', MM_swapImgRestore);
            $('#' + btnId).bind('mouseover', function(){
                MM_swapImage(buttonImgName[btnId][0],'','images/btn_' + buttonImgName[btnId][1] + '_' + buttonOnOffNum + '.jpg',1);
            });
            
        }
    },
    
    //실행시 현재 실행되고 있는 인덱스
    currentExecuteIndex: 0,
    
    //불러온시나리오를 그리드에 세팅
    setGridTs: function(testSnrioBasicDTO){
        tsmng.gridFunction.clear();
        
        tsmng.printTsTitle(testSnrioBasicDTO);
        tsmng.setGridResult();
        
        tsmng.gridFunction.append(testSnrioBasicDTO);
        
        tsmng.bindButtonEvent('btnExecute', true);
        tsmng.bindButtonEvent('btnLoad', true);
        tsmng.bindButtonEvent('btnSave', true);
        tsmng.bindButtonEvent('btnUseIO', true);
        tsmng.bindButtonEvent('btnReset', true);
        tsmng.bindButtonEvent('btnDelete', true);
        tsmng.bindButtonEvent('btnMoveDown', true);
        tsmng.bindButtonEvent('btnMoveUp', true);
        tsmng.bindButtonEvent('btnNew', true);
        tsmng.bindButtonEvent('btnAddTc', true);
        $('#prcssMsg').html("");
        $('.btnResult').hide();
        
        $('#flowMsg').html('테스트시나리오를 편집 후 저장하거나 실행할 수 있습니다.');
        
        $('#isGridSave').val('Y');
        
        tsmng.initGrid();
    },
    
    //테스트 시나리오 실행
    executeTs: function(tsSnrioID, arrRowData){
        var ids = $("#jqGridTable").getDataIDs();
        $("#jqGridTable").resetSelection().setSelection(ids[tsmng.currentExecuteIndex]);
        
        $.ajax({
            type: "POST"
            //, async: false
            , data: {
                rowData: JSON.stringify(arrRowData[tsmng.currentExecuteIndex])
                , tsSnrioID: (tsmng.currentExecuteIndex==0)? tsSnrioID: ""
                , isLast: tsmng.currentExecuteIndex==arrRowData.length-1
                , iOData: JSON.stringify(arrIODataUseDTO[tsmng.currentExecuteIndex])
            }
            , dataType: "json"
            , url: "msg.tsmng.executeTsAct.do"
            , success:function(data, status) {
                if (data.errCd){
                    alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
                    tsmng.bindButtonEvent('btnExecute', true);
                    tsmng.bindButtonEvent('btnLoad', true);
                    tsmng.bindButtonEvent('btnSave', true);
                    tsmng.bindButtonEvent('btnUseIO', true);
                    tsmng.bindButtonEvent('btnReset', true);
                    tsmng.bindButtonEvent('btnDelete', true);
                    tsmng.bindButtonEvent('btnMoveDown', true);
                    tsmng.bindButtonEvent('btnMoveUp', true);
                    tsmng.bindButtonEvent('btnNew', true);
                    tsmng.bindButtonEvent('btnAddTc', true);
                    return;
                }
                
                $('#returnExecute').val(data.result);
                $('#resultTssnrioid').val(data.resultTssnrioid);
                $('#resultAcmplnth').val(data.resultAcmplnth);
                
                tsmng.currentExecuteIndex++;
                $('#prcssMsg').html("총 " + arrRowData.length + "건중 " + tsmng.currentExecuteIndex + "건이 실행 되었습니다.");
                
                if(tsmng.currentExecuteIndex==arrRowData.length){
                    //실행 후 버튼 활성화
                    tsmng.bindButtonEvent('btnExecute', true);
                    tsmng.bindButtonEvent('btnLoad', true);
                    tsmng.bindButtonEvent('btnSave', true);
                    tsmng.bindButtonEvent('btnUseIO', true);
                    tsmng.bindButtonEvent('btnReset', true);
                    tsmng.bindButtonEvent('btnDelete', true);
                    tsmng.bindButtonEvent('btnMoveDown', true);
                    tsmng.bindButtonEvent('btnMoveUp', true);
                    tsmng.bindButtonEvent('btnNew', true);
                    tsmng.bindButtonEvent('btnAddTc', true);
                    $('.btnResult').show();
                    $('#flowMsg').html('결과보고서보기 버튼을 클릭하여 테스트결과를 확인하십시오.');
                    tsmng.currentExecuteIndex = 0;
                    $("#jqGridTable").resetSelection();
                    
                    $('.btnResult').show();
                    
                    tsmng.setGridResult(data.rptSnrioBasicDTO.rptSnrioDetailDTOs);
                    
                    alert("테스트 실행이 완료 되었습니다.\n\n결과보고서를 클릭하여\n자동 수행 결과를 확인하실 수 있습니다.");
                }else{
                    tsmng.executeTs(tsSnrioID, arrRowData);
                }
            }
            , error: function (request, status, error) { 
                $('#returnExecute').val("fail");
                alert("테스트 시나리오 실행중에 오류가 발생하였습니다.[" + error + "]");
                tsmng.bindButtonEvent('btnExecute', true);
                tsmng.bindButtonEvent('btnLoad', true);
                tsmng.bindButtonEvent('btnSave', true);
                tsmng.bindButtonEvent('btnUseIO', true);
                tsmng.bindButtonEvent('btnReset', true);
                tsmng.bindButtonEvent('btnDelete', true);
                tsmng.bindButtonEvent('btnMoveDown', true);
                tsmng.bindButtonEvent('btnMoveUp', true);
                tsmng.bindButtonEvent('btnNew', true);
                tsmng.bindButtonEvent('btnAddTc', true);
            }
        });
    },
    
    openUseIO: function(selRow){
        if(selRow.tsSnrioNO == '1'){
            alert('첫번째 항목은 출력값 활용을 설정할 수 없습니다.');
            return false;
        }
            
        var sendUrl = 'msg.tsmng.outputdatamng.do';
        sendUrl += "?tsSnrioID=" + $('#currentTsSnrioID').val();
        sendUrl += "&tsSnrioNO=" + selRow.tsSnrioNO;
        sendUrl += "&tsdataID=" + encodeURI(selRow.tsdataID);
        sendUrl += "&chnlDstcd=" + selRow.chnlDstcd;
        sendUrl += "&tranCd=" + selRow.tranCd;
        
        window.showModalDialog(sendUrl ,window,'center:yes;dialogWidth=1200px; dialogHeight=800px; dialogLeft=100px; dialogTop=50px; scroll=no; status=no; help=no; resizable:no;');
        
        tsmng.setGridResult();
        $('#prcssMsg').html("");
        $('.btnResult').hide();
    },
    
    //그리드 성공실패 셋팅
    setGridResult: function(rptSnrioDetailDTOs){
        var ids = $("#jqGridTable").getDataIDs();
        
        if(rptSnrioDetailDTOs != undefined){
            var imgSuccess = "<img src='images/icon_rep_ok.gif' width=34 height=16 hspace='2' vspace='3' align='absmiddle' border=0 style='cursor:pointer;' />";
            var imgSuccess2 = "<img src='images/icon_rep_ok_green.gif' width=34 height=16 hspace='2' vspace='3' align='absmiddle' border=0 style='cursor:pointer;' />";
            var imgFail = "<img src='images/icon_rep_fail.gif' width=34 height=16 hspace='2' vspace='3' align='absmiddle' border=0 style='cursor:pointer;' />";
            
            $.each(rptSnrioDetailDTOs, function(index, value){
                var tsSnrioNO = value.tsSnrioNO;
                var rsultSucssYN = value.rsultSucssYN;
                
                $("#jqGridTable").setCellHtml(ids[index], 'rsultsucssyn', (rsultSucssYN == 'Y')? ((value.chkYN == 'Y')? imgSuccess2 : imgSuccess) : imgFail);
            });
            $("#jqGridTable").showCol('rsultsucssyn');
        }else{
            $("#jqGridTable").hideCol('rsultsucssyn');
        }
    },
    
    //시나리오 불러오기
    loadTsSnrio: function(tsSnrioID){
        $.ajax({
            type: "POST"
            //, async: false
            , data: {
                tsSnrioID: tsSnrioID
            }
            , dataType: "json"
            , url: "msg.tsmng.getTsInfo.do"
            , success:function(data, status) {
                if (data.errCd){
                    alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
                    return;
                }
                    
                var testSnrioBasicDTO = data.testSnrioBasicDTO;
                tsmng.setGridTs(testSnrioBasicDTO);
            }
            , error:function(request, status, error) {
                alert("테스트 시나리오 불러오기중에 오류가 발생하였습니다.[" + error + "]"); 
            }
        });
    },
    
    //시나리오 관리 타이틀에 값 출력
    printTsTitle: function(testSnrioBasicDTO){
        $("#titleTsSnrioID").html(testSnrioBasicDTO.tsSnrioID);
        $("#titleTsSnrioName").html(testSnrioBasicDTO.tsSnrioName);
        $("#titleTsSnrioDesc").html(testSnrioBasicDTO.tsSnrioDesc);
        //$("#titleTsSnrioDate").html($('#teststartyms').val() + " ~ " + $('#testendyms').val());
        
        $('#currentTsSnrioID').val(testSnrioBasicDTO.tsSnrioID);
    },
    
    resetTsTitle: function(isNew){
        $("#titleTsSnrioName").html("");
        $("#titleTsSnrioDesc").html("");
        $('#currentTsSnrioID').val("");
        
        if(isNew === true){
            $("#titleTsSnrioID").html("신규생성");
            //$("#titleTsSnrioDate").html($('#teststartyms').val() + " ~ " + $('#testendyms').val());
        }else{
            $("#titleTsSnrioID").html("");
            //$("#titleTsSnrioDate").html("");
        }
    },
    
    //위, 아래 버튼 이벤트
    moveRow: function(direction){
        var arrSelGridId = $("#jqGridTable").jqGrid('getGridParam','selarrrow');

        if(arrSelGridId.length < 1 ){
            alert('이동할 테스트케이스를 선택해주십시오.');
            return false;
        }else if(arrSelGridId.length > 1 ){
            alert('순서이동은 하나의 테스트케이스만 가능합니다.');
            return false;
        }
        
        var id = arrSelGridId[0];
        var gridIndex = $("#jqGridTable").getInd(id)-1;
            
        if(direction == 'up'){
            if(gridIndex == 0){
                alert('더이상 이동할 수 없습니다.');
                return;
            }
        }else if(direction == 'down'){
            if(gridIndex == tsmng.gridFunction.size()-1){
                alert('더이상 이동할 수 없습니다.');
                return;
            }
        }
        
        var arrTsSnrioNO = $("#jqGridTable").getCol("tsSnrioNO");
        var upTsSnrioNO = "";
        var downTsSnrioNO = "";
        if(direction == 'up'){
            upTsSnrioNO = $.trim(arrTsSnrioNO[gridIndex-1]);
            downTsSnrioNO = $.trim(arrTsSnrioNO[gridIndex]);
        }else if(direction == 'down'){
            upTsSnrioNO = $.trim(arrTsSnrioNO[gridIndex]);
            downTsSnrioNO = $.trim(arrTsSnrioNO[gridIndex+1]);
        }
        
        for(var i=0, cnt=arrIODataUseDTO[downTsSnrioNO-1].length; i<cnt; i++){
            if($.trim(arrIODataUseDTO[downTsSnrioNO-1][i].preSnrioNO) == upTsSnrioNO){
                alert("수행순서 " + downTsSnrioNO + "에서 " + upTsSnrioNO + " 의 입출력값을 활용하여 이동할 수 없습니다.");
                return;
            }    
        }
        
        for(var i=0, cnti=arrIODataUseDTO.length; i<cnti; i++){
            for(var j=0, cntj=arrIODataUseDTO[i].length; j<cntj; j++){
                var preSnrioNO = $.trim(arrIODataUseDTO[i][j].preSnrioNO);
                if(preSnrioNO == upTsSnrioNO){
                    arrIODataUseDTO[i][j].preSnrioNO = downTsSnrioNO;
                }else if(preSnrioNO == downTsSnrioNO){
                    arrIODataUseDTO[i][j].preSnrioNO = upTsSnrioNO;
                }
            }
        }
        
        tsmng.gridFunction.moveRow(direction, id);
        
        tsmng.setGridResult();
        $('#prcssMsg').html("");
        $('.btnResult').hide();
        
        $('#isGridSave').val('N');
        
        tsmng.initGrid();
    },
    
    
    //테스트데이터 수정
    getTdInfo:function(rowid, iRow, iCol, e){
    	
    	if(iCol == 1) return;
    	
        var tsdataID = $("#jqGridTable").getCell(rowid, "tsdataID");
        var isCopy = $("#jqGridTable").getCell(rowid, "isCopy");
        
        var selInd = $("#jqGridTable").getInd(rowid)-1;
        
        var sendUrl = "";
        if(isCopy == 'E'){
            sendUrl = 'msg.tsmng.tdDetail.do';
            sendUrl += "?selInd=" + selInd;
        }else{
            sendUrl = 'msg.tsmng.getTdInfo.do';
            if(isCopy == 'Y'){
                sendUrl += "?tsdataID=" + $.trim(tsdataID.split('-')[0]);
            }else{
                sendUrl += "?tsdataID=" + tsdataID;
            }
        }
        
        var returnValue = window.showModalDialog(sendUrl, window,'center:yes;dialogWidth=1020px; dialogHeight=640px; dialogLeft=100px; dialogTop=50px; scroll=yes; status=no; help=no; resizable:no;');
        if(returnValue != undefined){
            arrTestDataDTO[selInd] = returnValue;
            if(isCopy != "E"){
                $("#jqGridTable").setCell(rowid, "isCopy", "E");
                if(isCopy != "Y"){
                    $("#jqGridTable").setCell(rowid, "tsdataID", tsdataID + " - 사본");                    
                }
            }
            $('#isGridSave').val('N');
        }
    },
    
    //그리드 오른쪽 마우스 적용
    initGrid: function(){
        $(".jqgrow", "#jqGridTable").contextMenu('myMenu1', { 
            bindings: { 
                liUseIO: function(t){
                    var selRow = $("#jqGridTable").getRowData($(t).attr("id"));
                    tsmng.openUseIO(selRow);
                }
            },
            menuStyle: {width: '140px'}, 
            onContextMenu : function(event, menu){
                var getCellIndex = function (cell) { 
                    var c = $(cell); 
                    if (c.is('tr')){
                        return -1;
                    } 
                    c = (!c.is('td') && !c.is('th') ? c.closest("td,th") : c)[0]; 
                    if ($.browser.msie){
                        return $.inArray(c, c.parentNode.cells);
                    } 
                    return c.cellIndex; 
                }; 
        
                contextCi = getCellIndex(event.target); 
                updateNuber = contextCi;
                contextRowid = $(event.target).parent("tr").attr("id");
                
                var tsSnrioNO = $("#jqGridTable").getCell(contextRowid, "tsSnrioNO");
                $('.contextMenuList').html('(테스트데이터 - ' + tsSnrioNO + '번)');
                
                return true; 
            }
        });
    },
    
    //그리드용 함수모음
    gridFunction : {
        //그리드에 추가
        append: function(data){
            var testSnrioDetailDTOList = data.testSnrioDetailDTOList;
            var testDataDtos = data.testDataDtos;
            
            //테스트데이터 MAX건수 체크
            var addCount = testSnrioDetailDTOList.length;
            var tsDataMaxCnt = $("#tsDataMaxCnt").val();
            var reccount = $("#jqGridTable").jqGrid('getGridParam',"reccount");
            if(addCount + reccount > tsDataMaxCnt){
            	alert("테스트데이터의 총 갯수는 "+tsDataMaxCnt+"건을 초과할 수 없습니다");
            	return false;
            }
            
            var maxId = tsmng.gridFunction.getMaxId();
            
            if($.isArray(testSnrioDetailDTOList)){
                $.each(testSnrioDetailDTOList, function(index, value){
                    $("#jqGridTable").addRowData(++maxId, value);
                    arrIODataUseDTO.push(value.ioDataUseDTOList);
                    arrTestDataDTO.push(testDataDtos[index]);
                });
            }else{
                $("#jqGridTable").addRowData(++maxId, testSnrioDetailDTOList);
                arrIODataUseDTO.push(testSnrioDetailDTOList.ioDataUseDTOList);
                arrTestDataDTO.push(testDataDtos[index]);
            }
            
            tsmng.gridFunction.resetIds();
            
            return true;
        }, 
        
        //그리드에서 삭제
        remove: function(ids){
            if($.isArray(ids)){
                var selIds = new Array();
                $.each(ids, function(index, value){
                    selIds.push(value);
                });
                
                $.each(selIds, function(index, value){
                    var gridIndex = $("#jqGridTable").getInd(value);
                    $("#jqGridTable").delRowData(value);
                    arrIODataUseDTO.splice(gridIndex-1, 1);
                    arrTestDataDTO.splice(gridIndex-1, 1);
                });
            }else{
                var gridIndex = $("#jqGridTable").getInd(ids);
                $("#jqGridTable").delRowData(ids);
                arrIODataUseDTO.splice(gridIndex-1, 1);
                arrTestDataDTO.splice(gridIndex-1, 1);
            }
            tsmng.gridFunction.resetIds();
        }, 
        
        //수행순서를 다시셋팅
        resetIds: function(){
            var arrIds = $("#jqGridTable").getDataIDs();
            
            $.each(arrIds, function(index, value){
                $("#jqGridTable").setCell(value, "tsSnrioNO", index+1);
            });
        },
        
        //그리드의 로우수
        size : function(){
            return $("#jqGridTable").getDataIDs().length;
        },
       
        //그리드 로우 아래로 이동
        moveRow: function(direction, id){
            var gridIndex = $("#jqGridTable").getInd(id);
            
            var rowData = $("#jqGridTable").getRowData(id);
            var iOData = arrIODataUseDTO[gridIndex-1];
            var testData = arrTestDataDTO[gridIndex-1];
            
            tsmng.gridFunction.remove(id);
            
            var arrDataIds = $("#jqGridTable").jqGrid('getDataIDs');
            var newId = tsmng.gridFunction.getMaxId()+1;
            if(direction=='up'){
                $("#jqGridTable").addRowData(newId, rowData, "before", arrDataIds[gridIndex-2]);
                arrIODataUseDTO.splice(gridIndex-2, 0, iOData);
                arrTestDataDTO.splice(gridIndex-2, 0, testData);
            }else if(direction=='down'){
                $("#jqGridTable").addRowData(newId, rowData, "after", arrDataIds[gridIndex-1]);
                arrIODataUseDTO.splice(gridIndex, 0, iOData);
                arrTestDataDTO.splice(gridIndex, 0, testData);
            }
            
            tsmng.gridFunction.resetIds();
            
            $("#jqGridTable").setSelection(newId);
        },
        
        //그리드의 아이디중 가장 큰값을 구한다.
        getMaxId: function(){
            var gridSize = tsmng.gridFunction.size();
            var gridMaxId = 0;
            if(gridSize != 0){
                gridMaxId = Math.max.apply(null, $("#jqGridTable").jqGrid('getDataIDs'));
            }
            
            return Number(gridMaxId);
        },
        
        //그리드데이터를 초기화
        clear: function(){
            $("#jqGridTable").clearGridData();
            arrIODataUseDTO = new Array();
            arrTestDataDTO = new Array();
        },
        
        //그리드 추가시 스크롤 제일 하단으로 이동
        scrollBottom : function(){
            var ids = $("#jqGridTable").getDataIDs();
            var maxKey = ids[ids.length-1];
           
            var height = $("#"+maxKey).attr('offsetHeight');         
            $(".ui-jqgrid-bdiv").scrollTop(height*maxKey);
        }
    }
};

/*그리드 설정 Start*/
var arrTestDataDTO = new Array(); //테스트 데이터 리스트
var arrIODataUseDTO = new Array(); //그리드내 테스트 데이터의 입출력값 활용
var jqGridOptions = {
    mtype: 'POST',
    datatype: 'local',
    colNames:[
        '실행결과'
        , 'isCopy(HIDDEN)' //'Y':복사본, 'E':수정본
        , '수행순서(HIDDEN)'
        , '테스트데이터ID'
        , '테스트데이터명'
        , '채널구분코드(HIDDEN)'
        , '거래코드'
        , '거래명'
        , '입출력값'
        , '테스트시나리오ID(HIDDEN)'
        , '테스트케이스ID(HIDDEN)'
        , '비고(HIDDEN)'
    ],
    colModel:[
        {name:'rsultsucssyn',index:'rsultsucssyn', width: 60, align:"center", hidden: true, title:false},
        {name:'isCopy',index:'isCopy', hidden: true},
        {name:'tsSnrioNO',index:'tsSnrioNO', hidden: true},
        {name:'tsdataID',index:'tsdataID', width:140, sortable:false ,title:false},
        {name:'tsdataName',index:'tsdataName', width:360, sortable:false ,title:false},
        {name:'chnlDstcd',index:'chnlDstcd', hidden: true},
        {name:'tranCd',index:'tranCd', width:150, align:"center", sortable:false ,title:false},
        {name:'tranName',index:'tranName', width:250, align:"left", sortable:false ,title:false},      
        {name:'useIO',index:'useIO', width:60,align:"center", sortable:false ,title:false},
        {name:'tsSnrioID',index:'tsSnrioID', hidden: true},
        {name:'tsCaseID',index:'tsCaseID', hidden: true},
        {name:'rmark',index:'rmark', hidden: true}
    ],
    gridview: true,	//can not use treeGrid, subGrid, or afterInsertRow event
    rownumbers: true,
    viewrecords: true,
    //autowidth: true,
    scrollrows : true,
    multiselect: true,
    height: maxHeight,
    ondblClickRow: tsmng.getTdInfo,
    onCellSelect: function(rowid, index, contents, event) {
        //checkbox 선택시만 row선택
        if("1" != index){ 
            $("#jqGridTable").jqGrid('setSelection', rowid, false); 
        }
    },
    loadComplete: function(xhr){
        if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
        
        tsmng.initGrid();
    },
    afterInsertRow: function(id){
    	reloadGridWidthSize('jqGridTable',230);
	}
};

/*그리드 설정 End*/

$(document).ready(function (){
    $("#jqGridTable").jqGrid(jqGridOptions);
    
    tsmng.bindButtonEvent('btnExecute', false);
    tsmng.bindButtonEvent('btnLoad', true);
    tsmng.bindButtonEvent('btnSave', false);
    tsmng.bindButtonEvent('btnUseIO', false);
    tsmng.bindButtonEvent('btnReset', false);
    tsmng.bindButtonEvent('btnDelete', false);
    tsmng.bindButtonEvent('btnMoveDown', false);
    tsmng.bindButtonEvent('btnMoveUp', false);
    tsmng.bindButtonEvent('btnNew', true);
    tsmng.bindButtonEvent('btnAddTc', false);
    tsmng.bindButtonEvent('btnResult', true);
    
    $('#flowMsg').html('신규생성 및 불러오기를 하실 수 있습니다.');
    
    $(window).bind('resize', function() {
        var windwoWindth = $(window).width()-leftTemp;
        if (windwoWindth > maxWidth) {
            $("#jqGridTable").setGridWidth(windwoWindth, true);
        } else {
            $("#jqGridTable").jqGrid('gridResize', {minWidth:maxWidth, maxWidth:'100%'});
            $("#jqGridTable").setGridWidth(windwoWindth, false);
        }
        
        var windowHeight = $(window).height()-maxHeight;           // 마이너스값 수정. 
        $("#jqGridTable").setGridHeight(windowHeight, true);
    
    }).trigger('resize');
    
    var tsSnrioID = $('#currentTsSnrioID').val();
    if("" != $.trim(tsSnrioID)){
        tsmng.loadTsSnrio(tsSnrioID);
    }
    
    
});

function bodyreload(){
    var hidenYn = $("body").attr("hideYn");
    if("Y" == hidenYn){ //left 메뉴 hidden
        leftTemp=55;
    }else{ //left 메뉴 show
        leftTemp=230;
    }
    $(window).trigger('resize');
}