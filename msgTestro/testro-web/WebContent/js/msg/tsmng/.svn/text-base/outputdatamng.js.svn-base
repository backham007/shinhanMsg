var opener = window.dialogArguments;

//조건식 클래스
function CndnStylCtnt(){
    this.name = ""; // 조건식 이름
    this.desc = ""; // 조건식 설명
    this.isSingleCndn = false; // 조건식에 파라메터가 있는지 없는지 있으면 false;
}

//조건식 맵
var mapCndnStylCtnt = new Object();
    
var outputdatamng = {
    //더블클릭으로 입출력값을 선택했는지 여부
    isSelectedIOData: false,
    
    getGridData: function(){
        var divisionIO = $('#divisionIO').val();
        var tscsFldAttrib = "";
        var preFldDiv = $('#preFldDiv').val();
        var preFldName = $('#preFldName').val();
        var preFldDesc = $('#preFldDesc').val();
        var preFldAttrib = $('#preFldAttrib').val();
        var preFldRptName = $('#preFldRptName').val();
        var preFldRptCnt = $('#preFldRptCnt').val();
        var preFld = preFldName + "(" + preFldDesc + ")";
        var useFldDiv = $('#useFldDiv').val();
        var useFldName = $('#useFldName').val();
        var useFldDesc = $('#useFldDesc').val();
        var useFldAttrib = $('#useFldAttrib').val();
        var useFldRptName = $('#useFldRptName').val();
        var useFldRptCnt = $('#useFldRptCnt').val();
        var useFld = useFldName + "(" + useFldDesc + ")";
        
        if(preFldAttrib == '03' || preFldRptName != ''){
        	var rptString = "";
        	if(preFldRptCnt == ''){
        		rptString = " [전체]";
        	} else {
        		rptString = " ["+preFldRptCnt+"회차]";
        	}
        	preFld = preFld + rptString;
        }
        
        if(useFldAttrib == '03' || useFldRptName != ''){
        	var rptString = "";
        	if(useFldRptCnt == ''){
        		rptString = " [전체]";
        	} else {
        		rptString = " ["+useFldRptCnt+"회차]";
        	}
        	useFld += rptString;
        }
        
        if("01" == divisionIO){
            tscsFldAttrib = "05";
            divisionIO = "입력";
        }else if("02" == divisionIO){
            tscsFldAttrib = "06";
            divisionIO = "출력";
        }
        
        var rowData = {
            tsSnrioID: $('#currTsSnrioID').val()
            , tsSnrioNO: $('#currTsSnrioNO').val()
            , divisionIO: divisionIO
            , tscsFldAttrib: tscsFldAttrib
            , preSnrioNO: $('#preSnrioNO').val()
            , preFldDiv: preFldDiv
            , preFldName: preFldName
            , preFldDesc: preFldDesc
            , preFldAttrib: preFldAttrib
            , preFldRptName: preFldRptName
            , preFldRptCnt: preFldRptCnt
            , preFld: preFld
            , useFldDiv: useFldDiv
            , useFldName: useFldName
            , useFldDesc: useFldDesc
            , useFldAttrib: useFldAttrib
            , useFldRptName: useFldRptName
            , useFldRptCnt: useFldRptCnt
            , useFld: useFld
            , cndnStylCtnt: $.trim($('#cndnStylCtnt').val())
        };
        
        return rowData;
    },
    
    //등록버튼 이벤트
    registerIOData: function(){
    	
    	if(lastsel2 != null){
    		$("#jqGridTable2").jqGrid("saveRow",lastsel2);
    		if(!outputdatamng.setFldData("jqGridTable2","preFld")) return;
    	}
    	if(lastsel3 != null){
    		$("#jqGridTable3").jqGrid("saveRow",lastsel3);
    		if(!outputdatamng.setFldData("jqGridTable3","preFld")) return;
    	}
    	if(lastsel4 != null){
    		$("#jqGridTable4").jqGrid("saveRow",lastsel4);
    		if(!outputdatamng.setFldData("jqGridTable4","useFld")) return;
    	}
    	if(lastsel5 != null){
    		$("#jqGridTable5").jqGrid("saveRow",lastsel5);
    		if(!outputdatamng.setFldData("jqGridTable5","useFld")) return;
    	}
    	
        //유효성 체크
        if(!outputdatamng.checkValidation()){
            return false;
        }
        
        outputdatamng.gridFunction.append(outputdatamng.getGridData());
        $('#isGridSave', opener.document).val('N');
        
        var ids = $("#jqGridTable").jqGrid('getDataIDs');;
		$('#totalCount').text("[총 "+ids.length+" 건]");
		
		alert("입출력값 활용정보가 등록되었습니다");
    },

    //수정버튼 이벤트
    modifyIOData: function(){
    	
    	if(lastsel2 != null){
    		$("#jqGridTable2").jqGrid("saveRow",lastsel2);
    		if(!outputdatamng.setFldData("jqGridTable2","preFld")) return;
    	}
    	if(lastsel3 != null){
    		$("#jqGridTable3").jqGrid("saveRow",lastsel3);
    		if(!outputdatamng.setFldData("jqGridTable3","preFld")) return;
    	}
    	if(lastsel4 != null){
    		$("#jqGridTable4").jqGrid("saveRow",lastsel4);
    		if(!outputdatamng.setFldData("jqGridTable4","useFld")) return;
    	}
    	if(lastsel5 != null){
    		$("#jqGridTable5").jqGrid("saveRow",lastsel5);
    		if(!outputdatamng.setFldData("jqGridTable5","useFld")) return;
    	}
    	
        if(!outputdatamng.isSelectedIOData){
            alert('수정할 데이터를 선택해주세요.');
            return false;
        }
        
        //유효성 체크
        if(!outputdatamng.checkValidation()){
            return false;
        }
        
        if(!confirm("수정하시겠습니까?")){
            return false;
        }
        
        outputdatamng.gridFunction.modifyRow($('#selTsIONO').val(), outputdatamng.getGridData());
        $('#isGridSave', opener.document).val('N');
        alert("입출력값 활용정보가 수정되었습니다");
    },

    //개별부 일괄매핑
    inviMapping : function(){
//    	if(!outputdatamng.checkTsSnrioNO()){
//            return false;
//        }
        
        if(!outputdatamng.checkDivisionIO()){
            return false;
        }
        
        var preFldIO;
        
        if($('#divisionIO').val() == "01"){
        	preFldIO = "I";
        }else if($('#divisionIO').val() == "02"){
        	preFldIO = "O";
        }
        
        var preSnrioNO = $.trim($('#preSnrioNO').val());
        var arrChnlDstcd = $("#jqGridTable", opener.document).getCol("chnlDstcd");
        var arrTranCd = $("#jqGridTable", opener.document).getCol("tranCd");
        
        var preChnlDstcd = arrChnlDstcd[Number(preSnrioNO)-1];
        var preTranCd = arrTranCd[Number(preSnrioNO)-1];
        
        var useChnlDstcd = $('#currChnlDstcd').val();
        var useTranCd = $('#currTranCd').val();
        var useFldIO = "I";
        
        var param = {
        		preChnlDstcd:preChnlDstcd,
        		preTranCd:preTranCd,
        		preFldIO:preFldIO,
        		useChnlDstcd:useChnlDstcd,
        		useTranCd:useTranCd,
        		useFldIO:useFldIO
        };
        
        $.ajax({
    	    type: "POST",
    	    url:'msg.tsmng.getListInviMapping.do',
    	    dataType:'json',
    	    data:param,
    	    success: function(data){
    		    
    			//오류코드 처리
    			if(data.errCd){
    				alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
    				return;
    			}
    			
    			if(data.list.length == 0){
    				alert("일괄매핑할 필드가 없습니다");
    				return;
    			}
    			
    			var list = data.list;
    			
    			for(var i in list){
    				
    				var divisionIO = $('#divisionIO').val();
    		        var tscsFldAttrib = "";
    		        var preFldDiv = '02';
    		        var preFldName = list[i].preFldName;
    		        var preFldDesc = list[i].preFldDesc;
    		        var preFldAttrib = '01';
    		        var preFldRptName = '';
    		        var preFldRptCnt = '';
    		        var preFld = preFldName + "(" + preFldDesc + ")";
    		        var useFldDiv = '02';
    		        var useFldName = list[i].useFldName;
    		        var useFldDesc = list[i].useFldDesc;
    		        var useFldAttrib = '01';
    		        var useFldRptName = '';
    		        var useFldRptCnt = '';
    		        var useFld = useFldName + "(" + useFldDesc + ")";
    		            		        
    		        if("01" == divisionIO){
    		            tscsFldAttrib = "05";
    		            divisionIO = "입력";
    		        }else if("02" == divisionIO){
    		            tscsFldAttrib = "06";
    		            divisionIO = "출력";
    		        }
    		        
    		        list[i]["tsSnrioID"] = $('#currTsSnrioID').val();
    		        list[i]["tsSnrioNO"] = $('#currTsSnrioNO').val();
    		        list[i]["divisionIO"] = divisionIO;
    		        list[i]["tscsFldAttrib"] = tscsFldAttrib;
    		        list[i]["preSnrioNO"] = $('#preSnrioNO').val();
    		        list[i]["preFldDiv"] = preFldDiv;
    		        list[i]["preFldName"] = preFldName;
    		        list[i]["preFldDesc"] = preFldDesc;
    		        list[i]["preFldAttrib"] = preFldAttrib;
    		        list[i]["preFldRptName"] = preFldRptName;
    		        list[i]["preFldRptCnt"] = preFldRptCnt;
    		        list[i]["preFld"] = preFld;
    		        list[i]["useFldDiv"] = useFldDiv;
    		        list[i]["useFldName"] = useFldName;
    		        list[i]["useFldDesc"] = useFldDesc;
    		        list[i]["useFldAttrib"] = useFldAttrib;
    		        list[i]["useFldRptName"] = useFldRptName;
    		        list[i]["useFldRptCnt"] = useFldRptCnt;
    		        list[i]["useFld"] = useFld;
    		        list[i]["cndnStylCtnt"] = '';
    		        
    			}
    			
    			outputdatamng.gridFunction.append(list);
		        $('#isGridSave', opener.document).val('N');
		        
		        var ids = $("#jqGridTable").jqGrid('getDataIDs');
				$('#totalCount').text("[총 "+ids.length+" 건]");
				
    			alert(list.length + "건의 일괄매핑데이터가 추가 되었습니다");
    	    },
    	    error: function (request, status, error) { 
    	    	alert("일괄매핑 조회중 오류가 발생하였습니다.[" + error + "]"); 
    	    }
    	});
    },
    
    //삭제버튼 이벤트
    deleteIOData: function(){
    	
//        if(!outputdatamng.isSelectedIOData){
//            alert('삭제할 데이터를 선택해주세요.');
//            return false;
//        }
        
    	var selTsIONO = jQuery("#jqGridTable").jqGrid('getGridParam','selarrrow'); //체크된 리스트 검색
        if(selTsIONO == ''){
        	alert('삭제할 데이터를 선택해주세요.');
        	return false;
        }
    	
        if(!confirm("삭제하시겠습니까?")){
            return false;
        }
        
        //var selTsIONO = $("#jqGridTable").jqGrid('getGridParam','selrow');
        
        outputdatamng.gridFunction.remove(selTsIONO);
        //outputdatamng.clearTitle();
        
        $('#preFld').val("");
        $('#useFld').val("");
        $('#titleSelTsIONO').html("");
        $('#selTsIONO').val("");
        outputdatamng.isSelectedIOData = false;
        
        $('#isGridSave', opener.document).val('N');
        
        var ids = $("#jqGridTable").jqGrid('getDataIDs');
		$('#totalCount').text("[총 "+ids.length+" 건]");
    },

    //검색조건 및 타이틀 초기화
    clearTitle: function(){
        $('#preSnrioNO').val("");
        $('#divisionIO').val("00");
        $('#preFld').val("");
        $('#preFldDiv').val("");
        $('#preFldName').val("");
        $('#preFldDesc').val("");
        $('#preFldAttrib').val("");
        $('#preFldRptName').val("");
        $('#preFldRptCnt').val("");
        $('#useFld').val("");
        $('#useFldDiv').val("");
        $('#useFldName').val("");
        $('#useFldDesc').val("");
        $('#useFldAttrib').val("");
        $('#useFldRptName').val("");
        $('#useFldRptCnt').val("");
        $('#cndnStylCtntType').val("");
        $('#cndnStylCtntContent').val("");
        $('#cndnStylCtnt').val("");
        
        $("#jqGridTable2").jqGrid("resetSelection");
        $("#jqGridTable3").jqGrid("resetSelection");
        $("#jqGridTable4").jqGrid("resetSelection");
        $("#jqGridTable5").jqGrid("resetSelection");
        
        $('#titleSelTsIONO').html("");
        $('#selTsIONO').val("");
        
        outputdatamng.isSelectedIOData = false;
    },

    //등록 및 수정시 체크사항
    checkValidation: function(){
        
//    	if(!outputdatamng.checkTsSnrioNO()){
//            return false;
//        }
        
    	if(!outputdatamng.checkDivisionIO()){
            return false;
        }
        
        if($.trim($('#preFld').val()) == ''){
            alert("원데이터필드를 선택해 주십시오.");
            //$('#preFld').focus();
            return false;
        }
        
        if($.trim($('#useFld').val()) == ''){
            alert("대상데이터필드를 선택해 주십시오.");
            //$('#useFld').focus();
            return false;
        }
        
        //원데이터 반복부필드 인덱스 미기입 체크
        if($('#preFldAttrib').val() == '04' && $('#useFldAttrib').val() == '03' && $('#preFldRptCnt').val() == ''){
          	alert("원데이터필드(반복부필드)의 인덱스를 입력해 주십시오.");
          	$("#jqGridTable2").jqGrid('setSelection',$("#jqGridTable2").jqGrid('getGridParam', "selrow" ));
          	$("#jqGridTable3").jqGrid('setSelection',$("#jqGridTable3").jqGrid('getGridParam', "selrow" ));
          	return false;
        }
        
        //대상데이터 반복부필드 인덱스 미기입 체크
        if($('#useFldAttrib').val() == '04' && $('#preFldAttrib').val() == '03' && $('#useFldRptCnt').val() == ''){
        	$("#jqGridTable4").jqGrid('setSelection',$("#jqGridTable4").jqGrid('getGridParam', "selrow" ));
          	$("#jqGridTable5").jqGrid('setSelection',$("#jqGridTable5").jqGrid('getGridParam', "selrow" ));
          	alert("대상데이터필드(반복부필드)의 인덱스를 입력해 주십시오.");
          	return false;
        }
        
        //일반필드,반복부필드와 반복부 매핑체크 
        if((($('#preFldAttrib').val() == '03' && $('#useFldAttrib').val() != '03') ||
           ($('#preFldAttrib').val() != '03' && $('#useFldAttrib').val() == '03')) &&
           $('#useFldAttrib').val() != '05'){
        	alert("일반(단건)데이터와 반복부(다건)데이터는 매핑할 수 없습니다.");
        	return false;
        }
        
        //반복부전체와 반복부행 매핑체크
        if(($('#preFldAttrib').val() == '03' && $('#useFldAttrib').val() == '03') &&
        		(($('#preFldRptCnt').val() != '' && $('#useFldRptCnt').val() == '') ||
        		 ($('#preFldRptCnt').val() == '' && $('#useFldRptCnt').val() != ''))){
        	alert("반복부의 [전체]와 [회차]는 매핑할 수 없습니다");
        	return false;
        }
        
        //단건데이터와 전체필드 매핑체크
        if($('#preFldAttrib').val() != '03' && $('#useFldAttrib').val() == '05'){
        	alert("일반(단건)데이터와 전체필드는 매핑할 수 없습니다");
          	$("#jqGridTable2").jqGrid('setSelection',$("#jqGridTable2").jqGrid('getGridParam', "selrow" ));
          	$("#jqGridTable3").jqGrid('setSelection',$("#jqGridTable3").jqGrid('getGridParam', "selrow" ));
          	return false;
        }
        
        //반복부전체와 필드전체 매핑체크
        if($('#preFldAttrib').val() == '03' && $('#useFldAttrib').val() == '05' && $('#preFldRptCnt').val() == ''){
        	alert("원데이터필드(반복부)의 인덱스를 입력해 주십시오.");
          	$("#jqGridTable2").jqGrid('setSelection',$("#jqGridTable2").jqGrid('getGridParam', "selrow" ));
          	$("#jqGridTable3").jqGrid('setSelection',$("#jqGridTable3").jqGrid('getGridParam', "selrow" ));
          	return false;
        }
        
        //반복부에 조건식 사용 체크
        if(($('#preFldAttrib').val() == '03' || $('#useFldAttrib').val() == '03') &&
        		$('#cndnStylCtnt').val() != ''){
        	alert("반복부(다건)데이터는 조건식을 사용할 수 없습니다");
        	$('#cndnStylCtnt').focus();
        	return false;
        }
      
        return true;
    },

    //이전 수행번호 체크
    checkTsSnrioNO: function(){
        //테스트 수행순서
        var currTsSnrioNO = $('#currTsSnrioNO').val();
        //입력된 이전수행순서
        var preSnrioNO = $.trim($('#preSnrioNO').val());
        
        var msgError = "";
        
        if(preSnrioNO == ''){
            msgError = "이전수행번호는 필수입력사항입니다. \n\n이전수행순서번호을 입력해 주십시오.";
        }else if(isNaN(preSnrioNO)==true || preSnrioNO.substring(0,1) == '+'){
            msgError = "이전수행순서번호는 숫자만 입력받을 수 있습니다.";
        }else if(parseInt(preSnrioNO.value) < 0){
            msgError = "이전수행순서번호는 0보다 큰 숫자만 입력받을 수 있습니다.";
        }else if(preSnrioNO > currTsSnrioNO -1){
            msgError = "이전수행순서번호가 적용할 수행순서보다 크거나 같습니다.";
        }else if(preSnrioNO < 1){
            msgError = "이전수행순서번호가  0이하의 값이 들어 갈수 없습니다.";
        }
        
        if(msgError != ""){
            alert(msgError);
            $('#preSnrioNO').val("");
            $('#preSnrioNO').focus();
            return false;        
        }
      
        return true;
    },

    //입출력 구분체크
    checkDivisionIO: function(){
        if($('#divisionIO').val() == '00'){
            alert("입출력 구분을 선택해 주십시오.");
            $('#divisionIO').focus();
            return false;
        }
        
        return true;
    },

    //조건식 추가 이벤트
    appendCndnStylCtnt: function(){
        var cndnStylCtntType = $('#cndnStylCtntType').val();
        var cndnStylCtntContent = $.trim($('#cndnStylCtntContent').val());
        var cndnStylCtnt = $.trim($('#cndnStylCtnt').val());
        
        if(cndnStylCtntType == '00'){
            alert('조건식이 선택 되지 않았습니다.');
            return false;
        }
        
        //조건식 맵에서 조건식을 가져온다
        var csc = mapCndnStylCtnt[cndnStylCtntType];
        
        //추가할 조건식 내용
        var appendCndnStylCtnt = "";
        
        if(csc.isSingleCndn){//파라메터가 필요없는 조건식이면
            appendCndnStylCtnt = csc.name;
        }else{
            if(cndnStylCtntContent == ''){
                alert('문자열을 입력하셔야 합니다.');
                return false;
            }else if((csc.name+"_") == cndnStylCtntContent.substr(0, csc.name.length+1)){
                alert('문자열을 입력하셔야 합니다.');
                return false;
            }
            appendCndnStylCtnt = csc.name + "_" + cndnStylCtntContent;
        }
        
        if((cndnStylCtnt.length + appendCndnStylCtnt.length) > 50){
            alert("조건식은 50자 이내로 작성이 가능합니다.");
            return false;
        }
        
        if(csc.isSingleCndn){
            alert(csc.desc);
        }
            
        if(cndnStylCtnt == ""){
            $('#cndnStylCtnt').val(appendCndnStylCtnt);
        }else{
            $('#cndnStylCtnt').val(cndnStylCtnt + "," + appendCndnStylCtnt);
        }
        
        $('#cndnStylCtntType').val("");
        $('#cndnStylCtntContent').val("");
    },

    //조건식 셀렉트 박스 변경 이벤트
    changeCndnStylCtnt: function(){
        //조건식 맵에서 조건식을 가져온다
        var cndnStylCtntType = $('#cndnStylCtntType').val();
        if(cndnStylCtntType == "00"){
            $('#cndnStylCtntContent').attr("disabled", "disabled");
            return false;
        }
        
        var csc = mapCndnStylCtnt[cndnStylCtntType];
        
        if(csc.isSingleCndn){
            $('#cndnStylCtntContent').attr("disabled", "disabled");
        }else{
            $('#cndnStylCtntContent').attr("disabled", "");
        }
    },

    //도움말 팝업 이벤트
    openPopupHelp: function(){
        window.open("msg.tsmng.popupHelp.do",'popup_help','width=600,height=484,status=no');
    },

    //원데이터 필드 조회
    getListPreFld: function(rowData){
    	if($('#divisionIO').val()=="00"){
    		//선택
    	} else {
    		
    		var fldIO = "";
            var chnlDstcd = "";
            var tranCd = "";
            
            if($('#divisionIO').val() == "01"){
                fldIO = "I";
            }else if($('#divisionIO').val() == "02"){
                fldIO = "O";
            }
            
            var preSnrioNO = $('#preSnrioNO').val();
            var arrChnlDstcd = $("#jqGridTable", opener.document).getCol("chnlDstcd");
            var arrTranCd = $("#jqGridTable", opener.document).getCol("tranCd");
            
            chnlDstcd = arrChnlDstcd[Number(preSnrioNO)-1];
            tranCd = arrTranCd[Number(preSnrioNO)-1];
            
    		//원데이터 필드 목록 조회
    	    var param = {fldIO: fldIO
    			        , chnlDstcd: chnlDstcd
    			        , tranCd: tranCd};
    	    
    		$.ajax({
    		    type: "POST",
    		    url:'msg.tsmng.getMciIOMap.do',
    		    dataType:'json',
    		    data:param,
    		    success: function(data){
    		    	//오류코드 처리
    				if(data.errCd){
    					alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
    					return;
    				}
    				
    				$("#jqGridTable2").jqGrid('clearGridData');	//그리드데이터삭제
    				$("#jqGridTable3").jqGrid('clearGridData');	//그리드데이터삭제
    				
    				var headerList = data.layout.headerList;
    				$('#jqGridTable2').jqGrid("addRowData","tranNO",headerList);
    				
    				var inviList = data.layout.inviList;
    				$('#jqGridTable3').jqGrid("addRowData","tranNO",inviList);
    				
    				if(rowData){
    					
    					var $grid;
    					
    					if(rowData.preFldDiv == '01'){
    						$grid = $('#jqGridTable2'); 
    					} else if(rowData.preFldDiv == '02'){
    						$grid = $('#jqGridTable3');
    					}
    					
    					var preRowData = $grid.jqGrid("getRowData");
    					
    					for(var i in preRowData){
    						if(preRowData[i].fldName == rowData.preFldName && preRowData[i].rptName == rowData.preFldRptName){
    							var rowid = parseInt(i)+1;
    							$grid.jqGrid('setCell', rowid, 'rptCnt', rowData.preFldRptCnt);
    							$grid.jqGrid("setSelection", rowid);
    							break;
    						}
    					}
    					
    					if(rowData.useFldDiv == '01'){
    						$grid = $('#jqGridTable4'); 
    					} else if(rowData.useFldDiv == '02'){
    						$grid = $('#jqGridTable5');
    					}
    					
    					var useRowData = $grid.jqGrid("getRowData");
    					
    					for(var i in useRowData){
    						if(useRowData[i].fldName == rowData.useFldName && useRowData[i].rptName == rowData.useFldRptName){
    							$grid.jqGrid('setCell', i, 'rptCnt', rowData.useFldRptCnt);
    							$grid.jqGrid("setSelection",i);
    							break;
    						}
    					}
    				}
    		    },
    		    error: function (request, status, error) { 
    		    	alert("원데이터 레이아웃 조회중 오류가 발생하였습니다.[" + error + "]"); 
    		    }
    		});
    	}
    },
    
    //컬럼명 조회 팝업 이벤트
    openPopupColumnName: function(inputBoxName){
        
//        if(!outputdatamng.checkTsSnrioNO()){
//            return false;
//        }
        
        if(!outputdatamng.checkDivisionIO()){
            return false;
        }
        
        var fldIO = "";
        var chnlDstcd = "";
        var tranCd = "";
        if(inputBoxName == "preFld"){
            if($('#divisionIO').val() == "01"){
                fldIO = "I";
            }else if($('#divisionIO').val() == "02"){
                fldIO = "O";
            }
            
            var preSnrioNO = $('#preSnrioNO').val();
            var arrChnlDstcd = $("#jqGridTable", opener.document).getCol("chnlDstcd");
            var arrTranCd = $("#jqGridTable", opener.document).getCol("tranCd");
            
            chnlDstcd = arrChnlDstcd[Number(preSnrioNO)-1];
            tranCd = arrTranCd[Number(preSnrioNO)-1];
        }else if(inputBoxName == 'useFld'){
            fldIO = "I";
            chnlDstcd = $('#currChnlDstcd').val();
            tranCd = $('#currTranCd').val();
        }
        
        var sendUrl = "msg.tsmng.openPopupColNameLst.do";
        sendUrl += "?fldIO=" + fldIO;
        sendUrl += "&chnlDstcd=" + chnlDstcd;
        sendUrl += "&tranCd=" + tranCd;
        sendUrl += "&inputBoxName=" + inputBoxName;
        
        window.showModalDialog(sendUrl,window,'center:yes;dialogWidth=552px; dialogHeight=435px; dialogLeft=100px; dialogTop=50px; scroll=no; status=no; help=no; resizable:no;');
    }, 

    //선택필드 셋팅
    setFldData: function(gridName, inputBox){
		var $grid = $("#"+gridName);
		if($grid == null) return false;
		var rowid = $grid.jqGrid('getGridParam', "selrow");
		if(rowid == null) return false;
   		
   		var fldDiv = $grid.jqGrid('getCell', rowid, 'fldDiv');
        var fldName = $grid.jqGrid('getCell', rowid, 'fldName');
        var tscsFldDesc = $grid.jqGrid('getCell', rowid, 'tscsFldDesc');
        var fldAttrib = $grid.jqGrid('getCell', rowid, 'fldAttrib');
        var rptName = $grid.jqGrid('getCell', rowid, 'rptName');
        var rptCnt = $grid.jqGrid('getCell', rowid, 'rptCnt');
   		
        if(rptCnt != '' && (isNaN(rptCnt)==true || rptCnt.substring(0,1) == '+')){
            alert("인덱스는 숫자만 입력받을 수 있습니다.");
            $grid.jqGrid('setCell', rowid, 'rptCnt', null);
            return false;
        }else if(rptCnt != '' && (rptCnt < 1)){
        	alert("인덱스에 0이하의 값이 들어 갈수 없습니다.");
        	$grid.jqGrid('setCell', rowid, 'rptCnt', null);
            return false;
        }
        
   		outputdatamng.setColData(inputBox, fldDiv, fldName, tscsFldDesc, fldAttrib, rptName, rptCnt);
   		
   		return true;
    },
    
    //컬럼명 셋팅 
    setColData: function(inputBoxName, fldDiv, fldName, tscsFldDesc, fldAttrib, rptName, rptCnt){
        $('#' + inputBoxName).val(fldName + "(" + tscsFldDesc + ")");
        if(fldAttrib == '03' || fldAttrib == '04' || rptName != ''){
        	var rptString = "";
        	if(rptCnt == ''){
        		rptString = " [전체]";
        	} else {
        		rptString = " ["+rptCnt+"회차]";
        	}
        	$('#' + inputBoxName).val($('#' + inputBoxName).val() + rptString);
        }
        $('#' + inputBoxName + "Div").val(fldDiv);
        $('#' + inputBoxName + "Name").val(fldName);
        $('#' + inputBoxName + "Desc").val(tscsFldDesc);
        $('#' + inputBoxName + "Attrib").val(fldAttrib);
        $('#' + inputBoxName + "RptName").val(rptName);
        $('#' + inputBoxName + "RptCnt").val(rptCnt);
    },
    
    //그리드 클릭 이벤트
    setIOData: function(rowid){
        outputdatamng.clearTitle();
        
        var selRow = $("#jqGridTable").getRowData(rowid);
        
        $('#preSnrioNO').val($.trim(selRow.preSnrioNO));
        if(selRow.divisionIO == '입력'){
            $('#divisionIO').val('01');
        }else if(selRow.divisionIO == '출력'){
            $('#divisionIO').val('02');
        }
        $('#preFld').val(selRow.preFld);
        $('#preFldDiv').val(selRow.preFldDiv);
        $('#preFldName').val(selRow.preFldName);
        $('#preFldDesc').val(selRow.preFldDesc);
        $('#preFldAttrib').val(selRow.preFldAttrib);
        $('#preFldRptName').val(selRow.preFldRptName);
        $('#preFldRptCnt').val(selRow.preFldRptCnt);
        $('#useFld').val(selRow.useFld);
        $('#useFldDiv').val(selRow.useFldDiv);
        $('#useFldName').val(selRow.useFldName);
        $('#useFldDesc').val(selRow.useFldDesc);
        $('#useFldAttrib').val(selRow.useFldAttrib);
        $('#useFldRptName').val(selRow.useFldRptName);
        $('#useFldRptCnt').val(selRow.useFldRptCnt);
        $('#cndnStylCtnt').val(selRow.cndnStylCtnt);
        $('#titleSelTsIONO').html('(선택 일련번호 : ' + selRow.tsIONO + ')');
        $('#selTsIONO').val(rowid);
         
        outputdatamng.isSelectedIOData = true;
        
        outputdatamng.getListPreFld(selRow);
    },
    
    //조건식 셀렉트 박스에 추가
    setCndnStylCtnt: function(){
        var cndnStylCtnt = null;
        cndnStylCtnt = new CndnStylCtnt();
        cndnStylCtnt.name = "DelLeft";
        cndnStylCtnt.desc = "입력받은 문자열의 왼쪽을 입력받은 값만큼 자른다. \n사용예) 조건식: DelLeft_3  입력값: abcdef 출력값 : def";
        mapCndnStylCtnt["01"] = cndnStylCtnt;
        
        cndnStylCtnt = new CndnStylCtnt();
        cndnStylCtnt.name = "DelRight";
        cndnStylCtnt.desc = "입력받은 문자열의 오른쪽을 입력받은 값만큼 자른다. \n사용예) 조건식: DelRight_3  abcdef -> abc";
        mapCndnStylCtnt["02"] = cndnStylCtnt;
        
        cndnStylCtnt = new CndnStylCtnt();
        cndnStylCtnt.name = "DelAll";
        cndnStylCtnt.desc = "입력받은 문자열에 입력받은 해당 값을 삭제한다. \n사용예) 조건식: DelAll_-  2008-10-03 -> 20081003";
        mapCndnStylCtnt["03"] = cndnStylCtnt;
        
        cndnStylCtnt = new CndnStylCtnt();
        cndnStylCtnt.name = "FillLeft";
        cndnStylCtnt.desc = "입력받은 문자열의 왼쪽에 입력받은 값을 추가한다. \n사용예) 조건식: FillLeft_ABC  def -> ABCdef";
        mapCndnStylCtnt["04"] = cndnStylCtnt;
        
        cndnStylCtnt = new CndnStylCtnt();
        cndnStylCtnt.name = "FillRight";
        cndnStylCtnt.desc = "입력받은 문자열의 오른쪽에 입력받은 값을 추가한다. \n사용예) 조건식: FillRight_ABC  def -> defABC";
        mapCndnStylCtnt["05"] = cndnStylCtnt;
        
        cndnStylCtnt = new CndnStylCtnt();
        cndnStylCtnt.name = "InsStr";
        cndnStylCtnt.desc = "입력된 문자열에 주어진 Type에 맞게 입력받은 값을 삽입한다. \n사용예) 조건식: InsStr_X2_by_2_2_2  000000 -> 00X200X200";
        mapCndnStylCtnt["06"] = cndnStylCtnt;
        
        cndnStylCtnt = new CndnStylCtnt();
        cndnStylCtnt.name = "Replace";
        cndnStylCtnt.desc = "입력된 문자열의 특정 함옥을 지정된 문자열로 바꾼다. \n사용예) 조건식: Replace_aa_to_DD  aabbccaa -> DDbbccDD";
        mapCndnStylCtnt["07"] = cndnStylCtnt;
        
        cndnStylCtnt = new CndnStylCtnt();
        cndnStylCtnt.name = "ToUpper";
        cndnStylCtnt.desc = "입력된 문자열을 대문자로 바꾼다.";
        cndnStylCtnt.isSingleCndn = true;
        mapCndnStylCtnt["08"] = cndnStylCtnt;
        
        cndnStylCtnt = new CndnStylCtnt();
        cndnStylCtnt.name = "ToLower";
        cndnStylCtnt.desc = "입력된 문자열을 소문자로 바꾼다.";
        cndnStylCtnt.isSingleCndn = true;
        mapCndnStylCtnt["09"] = cndnStylCtnt;
        
        cndnStylCtnt = new CndnStylCtnt();
        cndnStylCtnt.name = "HalfToFull";
        cndnStylCtnt.desc = "입력된 문자열의 반자를 전자로 바꾼다.";
        cndnStylCtnt.isSingleCndn = true;
        mapCndnStylCtnt["10"] = cndnStylCtnt;
    },
    
    resetFld: function(){
        $('#preFld').val("");
        $("#jqGridTable2").jqGrid('clearGridData');	//그리드데이터삭제
        $("#jqGridTable3").jqGrid('clearGridData');	//그리드데이터삭제
    },
    
    //그리드용 함수모음
    gridFunction : {
        //그리드에 추가
        append: function(data, isFirst){
            var maxId = outputdatamng.gridFunction.getMaxId();
            
            if($.isArray(data)){
                $.each(data, function(index, value){
                	data[index]["rowid"] = ++maxId;
                });
                $("#jqGridTable").addRowData("rowid", data);
            }else{
                $("#jqGridTable").addRowData(++maxId, data);
            }
            
            if(isFirst==undefined || !isFirst){
                outputdatamng.gridFunction.resetIds();
                outputdatamng.gridFunction.updateIODatas();
            }
        }, 
        
        //그리드의 아이디중 가장 큰값을 구한다.
        getMaxId: function(){
            var gridSize = outputdatamng.gridFunction.size();
            var gridMaxId = 0;
            if(gridSize != 0){
                gridMaxId = Math.max.apply(null, $("#jqGridTable").jqGrid('getDataIDs'));
            }
            
            return Number(gridMaxId);
        },
        //그리드의 로우수
        size : function(){
            return $("#jqGridTable").getDataIDs().length;
        },
        //일련번호를 다시셋팅
        resetIds: function(){
            var arrIds = $("#jqGridTable").getDataIDs();
            
            $.each(arrIds, function(index, value){
                $("#jqGridTable").setCell(value, "tsIONO", index+1);
            });
        },
        //그리드에서 삭제
        remove: function(ids){
            if($.isArray(ids)){
                var selIds = new Array();
                $.each(ids, function(index, value){
                    selIds.push(value);
                });
                
                $.each(selIds, function(index, value){
                    $("#jqGridTable").delRowData(value);
                });
            }else{
                $("#jqGridTable").delRowData(ids);
            }
            outputdatamng.gridFunction.resetIds();
            outputdatamng.gridFunction.updateIODatas();
        },
        
        //그리드 로우 수정
        modifyRow: function(id, data){
            $("#jqGridTable").setRowData(id, data);
            outputdatamng.gridFunction.updateIODatas();
        },
        
        //부모창 IO 배열에 수정한 내용을 업데이트 한다.
        updateIODatas: function(){
            var datas = $("#jqGridTable").getRowData();
            var currTsSnrioNO = $('#currTsSnrioNO').val();
            
            opener.arrIODataUseDTO.splice(Number(currTsSnrioNO-1), 1, datas);
            
            var isUseIO = outputdatamng.gridFunction.size()>0 ? "Y": "N";
            
            var selOpenerGridId = $("#jqGridTable", opener.document).getDataIDs()[currTsSnrioNO-1];
            $("#jqGridTable", opener.document).setCell(selOpenerGridId, 'useIO', isUseIO);
        }
    }
};

/*그리드 설정 Start*/
var jqGridOptions = {
    mtype:'POST'
    , datatype: "local" 
    , colNames:[
        '사용테스트데이터순번'
        , '일련번호'
        , '이전수행순서' 
        , '입출력구분'
        , '입출력구분1'
        , '원데이터필드'
        , 'preFldDiv(HIDDEN)'
        , 'preFldName(HIDDEN)'
        , 'preFldDesc(HIDDEN)'
        , '원데이터필드속성'
        , 'preFldRptName(HIDDEN)'
        , '원데이터인덱스'
        , '대상데이터필드'
        , 'useFldDiv(HIDDEN)'
        , 'useFldName(HIDDEN)' 
        , 'useFldDesc(HIDDEN)'
        , '대상필드속성'
        , 'useFldRptName(HIDDEN)'
        , '대상데이터인덱스'
        , '조건식' 
    ]
    , colModel:[ 
        {name: 'tsSnrioNO', index: 'tsIONO', hidden: true}
        , {name: 'tsIONO', index: 'tsIONO', width:80, align:"center", sortable:false}
        , {name: 'preSnrioNO', index: 'preSnrioNO', width:80, align:"center", sortable:false} 
        , {name: 'divisionIO', index: 'divisionIO', width:80, align:"center", sortable:false} 
        , {name: 'tscsFldAttrib', index: 'tscsFldAttrib', hidden: true}
        , {name: 'preFld', index: 'preFld', width:200, align:"left", sortable:false}
        , {name: 'preFldDiv', index: 'preFldDiv', hidden: true}
        , {name: 'preFldName', index: 'preFldName', hidden: true}
        , {name: 'preFldDesc', index: 'preFldDesc', hidden: true}
        , {name: 'preFldAttrib', index: 'preFldAttrib', hidden: false, width:120, align:"center", formatter:'select', editoptions: { value: "01:일반;03:반복회차;04:반복부필드;05:전체" }, sortable:false}
        , {name: 'preFldRptName', index: 'preFldRptName', hidden: true}
        , {name: 'preFldRptCnt', index: 'preFldRptCnt', hidden: false, width:120, align:"center", sortable:false}
        , {name: 'useFld', index: 'useFld', width:200, align:"left", sortable:false}
        , {name: 'useFldDiv', index: 'useFldDiv', hidden: true}
        , {name: 'useFldName', index: 'useFldName', hidden: true}
        , {name: 'useFldDesc', index: 'useFldDesc', hidden: true}
        , {name: 'useFldAttrib', index: 'useFldAttrib', hidden: false, width:100, align:"center", formatter:'select', editoptions: { value: "01:일반;03:반복회차;04:반복부필드;05:전체" }, sortable:false}
        , {name: 'useFldRptName', index: 'useFldRptName', hidden: true}
        , {name: 'useFldRptCnt', index: 'useFldRptCnt', hidden: false, width:120, align:"center", sortable:false}
        , {name: 'cndnStylCtnt', index: 'cndnStylCtnt', width:200, align:"center", sortable:false} 
    ]
    , viewrecords: true
    , multiselect: true //멀티셀렉트 설정
    //, width: 824
    , height: 170
    , scrollrows : true //포커스이동시  스크롤 자동맞춤.
    , onCellSelect: function(rowid, index, contents, event) {//checkbox 선택시만 row선택
    	if(0 != index){
    		$("#jqGridTable").jqGrid('setSelection', rowid, false);
    		outputdatamng.setIOData(rowid);
    	}
    }
};

var lastsel2;

var jqGridOptions2 = {
    mtype:'POST'
    , datatype: "json" 
    , colNames:[
		'필드구분(HIDDEN)'
		,'필드명'
		,'한글명'
		,'필드속성'
		,'인덱스'
		,'반복부명(HIDDEN)'
    ]
    , colModel:[ 
		{name: 'fldDiv', index: 'fldDiv', width:50, align:"center", formatter:'select', editoptions: { value: "01:헤더부;02:개별부" }, sortable:false, editable:false, hidden:true}
		,{name: 'fldName', index: 'fldName', width:100, align:"left", sortable:false, editable:false}
		,{name: 'tscsFldDesc', index: 'tscsFldDesc', width:100, align:"left", sortable:false, editable:false}
		,{name: 'fldAttrib', index: 'fldAttrib', width:50, align:"center", formatter:'select', editoptions: { value: "01:일반;03:반복회차;04:반복부필드;05:전체" }, sortable:false, editable:false}
		,{name: 'rptCnt', index: 'rptCnt', width:50, align:"left", sortable:false, editable:true, editoptions:{maxlength:"3"}}
		,{name: 'rptName', index: 'rptName', hidden:true}
    ]
    , viewrecords : true 
    , scroll : 1 //scroll paging config
    , rownumbers: true //scroll paging config  
    , rowNum : -1
    , autowidth: true
    , height: 100
    , scrollrows : true //포커스이동시  스크롤 자동맞춤.
    , editurl:'clientArray'
   	, jsonReader : {
		root: "rows"
		, page: false 
		, total: false 
		, records: false 
		, repeatitems: false 
		, cell: false
    }
	, loadComplete: function(xhr){
	    if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
	}
    , ondblClickRow: function (rowid, iRow, iCol, e) { //더블클릭 이벤트(edit)
		if("0" != iCol){ // 싱글선택:0 , 멀티선택:0,1
			if($("#jqGridTable2").jqGrid('getCell', rowid, 'fldAttrib') == '03' ||
					$("#jqGridTable2").jqGrid('getCell', rowid, 'rptName') != ''){

				jQuery('#jqGridTable2').jqGrid('editRow',rowid,true,'','','','',function(rowid, e){
					outputdatamng.setFldData("jqGridTable2","preFld");
				}); 
				$("input, select",e.target).focus();   // 포커스위치 설정
				lastsel2=rowid;
			}
		} 
	}
	, onCellSelect: function(rowid, index, contents, event) {		//클릭저장
		$("#jqGridTable3").jqGrid("saveRow",lastsel3);
		lastsel3 = null;
		$("#jqGridTable3").jqGrid("resetSelection");
   		$("#jqGridTable2").jqGrid("saveRow",lastsel2);
   		lastsel2 = null;
   		
   		var $grid = $("#jqGridTable2");
   		
   		var fldDiv = $grid.jqGrid('getCell', rowid, 'fldDiv');
        var fldName = $grid.jqGrid('getCell', rowid, 'fldName');
        var tscsFldDesc = $grid.jqGrid('getCell', rowid, 'tscsFldDesc');
        var fldAttrib = $grid.jqGrid('getCell', rowid, 'fldAttrib');
        var rptName = $grid.jqGrid('getCell', rowid, 'rptName');
        var rptCnt = $grid.jqGrid('getCell', rowid, 'rptCnt');
   		
   		outputdatamng.setColData("preFld", fldDiv, fldName, tscsFldDesc, fldAttrib, rptName, rptCnt);
	}
	, onRightClickRow: function (rowid, iRow, iCol, e) {//우클릭 브라우져메뉴 block
	}
};

var lastsel3;

var jqGridOptions3 = {
    mtype:'POST'
    , datatype: "json" 
    , colNames:[
		'필드구분(HIDDEN)'
		,'필드명'
		,'한글명'
		,'필드속성'
		,'인덱스'
		,'반복부명(HIDDEN)'
    ]
    , colModel:[ 
		{name: 'fldDiv', index: 'fldDiv', width:50, align:"center", formatter:'select', editoptions: { value: "01:헤더부;02:개별부" }, sortable:false, editable:false, hidden:true}
		,{name: 'fldName', index: 'fldName', width:100, align:"left", sortable:false, editable:false}
		,{name: 'tscsFldDesc', index: 'tscsFldDesc', width:100, align:"left", sortable:false, editable:false}
		,{name: 'fldAttrib', index: 'fldAttrib', width:50, align:"center", formatter:'select', editoptions: { value: "01:일반;03:반복회차;04:반복부필드;05:전체" }, sortable:false, editable:false}
		,{name: 'rptCnt', index: 'rptCnt', width:50, align:"left", sortable:false, editable:true, editoptions:{maxlength:"3"}}
		,{name: 'rptName', index: 'rptName', hidden:true}
    ]
    , viewrecords : true 
    , scroll : 1 //scroll paging config
    , rownumbers: true //scroll paging config  
    , rowNum : -1
    , autowidth: true
    , height: 100
    , scrollrows : true //포커스이동시  스크롤 자동맞춤.
    , editurl:'clientArray'
   	, jsonReader : {
		root: "rows"
		, page: false 
		, total: false 
		, records: false 
		, repeatitems: false 
		, cell: false
    }
	, loadComplete: function(xhr){
	    if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
	}
    , ondblClickRow: function (rowid, iRow, iCol, e) { //더블클릭 이벤트(edit)
		if("0" != iCol){ // 싱글선택:0 , 멀티선택:0,1
			if($("#jqGridTable3").jqGrid('getCell', rowid, 'fldAttrib') == '03' ||
					$("#jqGridTable3").jqGrid('getCell', rowid, 'rptName') != ''){
				jQuery('#jqGridTable3').jqGrid('editRow',rowid,true,'','','','',function(rowid, e){
					outputdatamng.setFldData("jqGridTable3","preFld");
				}); 
				$("input, select",e.target).focus();   // 포커스위치 설정
				lastsel3=rowid;
			}
		} 
	}
	, onCellSelect: function(rowid, index, contents, event) {		//클릭저장
		$("#jqGridTable2").jqGrid("saveRow",lastsel2);
		lastsel2 = null;
		$("#jqGridTable2").jqGrid("resetSelection");
   		$("#jqGridTable3").jqGrid("saveRow",lastsel3);
   		lastsel3 = null;
   		
   		var $grid = $("#jqGridTable3");
   		
   		var fldDiv = $grid.jqGrid('getCell', rowid, 'fldDiv');
        var fldName = $grid.jqGrid('getCell', rowid, 'fldName');
        var tscsFldDesc = $grid.jqGrid('getCell', rowid, 'tscsFldDesc');
        var fldAttrib = $grid.jqGrid('getCell', rowid, 'fldAttrib');
        var rptName = $grid.jqGrid('getCell', rowid, 'rptName');
        var rptCnt = $grid.jqGrid('getCell', rowid, 'rptCnt');
   		
   		outputdatamng.setColData("preFld", fldDiv, fldName, tscsFldDesc, fldAttrib, rptName, rptCnt);
	}
	, onRightClickRow: function (rowid, iRow, iCol, e) {//우클릭 브라우져메뉴 block
	}
};

var lastsel4;

var jqGridOptions4 = {
    mtype:'POST'
    , datatype: "json" 
    , colNames:[
		'필드구분(HIDDEN)'
		,'필드명'
		,'한글명'
		,'필드속성'
		,'인덱스'
		,'반복부명(HIDDEN)'
    ]
    , colModel:[ 
		{name: 'fldDiv', index: 'fldDiv', width:50, align:"center", formatter:'select', editoptions: { value: "01:헤더부;02:개별부" }, sortable:false, editable:false, hidden:true}
		,{name: 'fldName', index: 'fldName', width:100, align:"left", sortable:false, editable:false}
		,{name: 'tscsFldDesc', index: 'tscsFldDesc', width:100, align:"left", sortable:false, editable:false}
		,{name: 'fldAttrib', index: 'fldAttrib', width:50, align:"center", formatter:'select', editoptions: { value: "01:일반;03:반복회차;04:반복부필드;05:전체" }, sortable:false, editable:false}
		,{name: 'rptCnt', index: 'rptCnt', width:50, align:"left", sortable:false, editable:true, editoptions:{maxlength:"3"}}
		,{name: 'rptName', index: 'rptName', hidden:true}
    ]
    , viewrecords : true 
    , scroll : 1 //scroll paging config
    , rownumbers: true //scroll paging config  
    , rowNum : -1
    , autowidth: true
    , height: 100
    , scrollrows : true //포커스이동시  스크롤 자동맞춤.
    , editurl:'clientArray'
   	, jsonReader : {
		root: "rows"
		, page: false 
		, total: false 
		, records: false 
		, repeatitems: false 
		, cell: false
    }
	, loadComplete: function(xhr){
	    if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
	}
    , ondblClickRow: function (rowid, iRow, iCol, e) { //더블클릭 이벤트(edit)
		if("0" != iCol){ // 싱글선택:0 , 멀티선택:0,1
			if($("#jqGridTable4").jqGrid('getCell', rowid, 'fldAttrib') == '03' ||
					$("#jqGridTable4").jqGrid('getCell', rowid, 'rptName') != ''){
				jQuery('#jqGridTable4').jqGrid('editRow',rowid,true,'','','','',function(){
					outputdatamng.setFldData("jqGridTable4","useFld");
				}); 
				$("input, select",e.target).focus();   // 포커스위치 설정
				lastsel4=rowid;
			}
		} 
	}
	, onCellSelect: function(rowid, index, contents, event) {		//클릭저장
		$("#jqGridTable5").jqGrid("saveRow",lastsel5);
		lastsel5 = null;
		$("#jqGridTable5").jqGrid("resetSelection");
   		$("#jqGridTable4").jqGrid("saveRow",lastsel4);
   		lastsel4 = null;
   		
   		var $grid = $("#jqGridTable4");
   		
   		var fldDiv = $grid.jqGrid('getCell', rowid, 'fldDiv');
        var fldName = $grid.jqGrid('getCell', rowid, 'fldName');
        var tscsFldDesc = $grid.jqGrid('getCell', rowid, 'tscsFldDesc');
        var fldAttrib = $grid.jqGrid('getCell', rowid, 'fldAttrib');
        var rptName = $grid.jqGrid('getCell', rowid, 'rptName');
        var rptCnt = $grid.jqGrid('getCell', rowid, 'rptCnt');
   		
   		outputdatamng.setColData("useFld", fldDiv, fldName, tscsFldDesc, fldAttrib, rptName, rptCnt);
	}
	, onRightClickRow: function (rowid, iRow, iCol, e) {//우클릭 브라우져메뉴 block
	}
};

var lastsel5;

var jqGridOptions5 = {
    mtype:'POST'
    , datatype: "json" 
    , colNames:[
		'필드구분(HIDDEN)'
		,'필드명'
		,'한글명'
		,'필드속성'
		,'인덱스'
		,'반복부명(HIDDEN)'
    ]
    , colModel:[ 
		{name: 'fldDiv', index: 'fldDiv', width:50, align:"center", formatter:'select', editoptions: { value: "01:헤더부;02:개별부" }, sortable:false, editable:false, hidden:true}
		,{name: 'fldName', index: 'fldName', width:100, align:"left", sortable:false, editable:false}
		,{name: 'tscsFldDesc', index: 'tscsFldDesc', width:100, align:"left", sortable:false, editable:false}
		,{name: 'fldAttrib', index: 'fldAttrib', width:50, align:"center", formatter:'select', editoptions: { value: "01:일반;03:반복회차;04:반복부필드;05:전체" }, sortable:false, editable:false}
		,{name: 'rptCnt', index: 'rptCnt', width:50, align:"left", sortable:false, editable:true, editoptions:{maxlength:"3"}}
		,{name: 'rptName', index: 'rptName', hidden:true}
    ]
    , viewrecords : true 
    , scroll : 1 //scroll paging config
    , rownumbers: true //scroll paging config  
    , rowNum : -1
    , autowidth: true
    , height: 100
    , scrollrows : true //포커스이동시  스크롤 자동맞춤.
    , editurl:'clientArray'
   	, jsonReader : {
		root: "rows"
		, page: false 
		, total: false 
		, records: false 
		, repeatitems: false 
		, cell: false
    }
	, loadComplete: function(xhr){
	    if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
	}
    , ondblClickRow: function (rowid, iRow, iCol, e) { //더블클릭 이벤트(edit)
		if("0" != iCol){ // 싱글선택:0 , 멀티선택:0,1
			if($("#jqGridTable5").jqGrid('getCell', rowid, 'fldAttrib') == '03' ||
					$("#jqGridTable5").jqGrid('getCell', rowid, 'rptName') != ''){
				jQuery('#jqGridTable5').jqGrid('editRow',rowid,true,'','','','',function(){
					outputdatamng.setFldData("jqGridTable5","useFld");
				}); 
				$("input, select",e.target).focus();   // 포커스위치 설정
				lastsel5=rowid;
			}
		} 
	}
	, onCellSelect: function(rowid, index, contents, event) {		//클릭저장
		$("#jqGridTable4").jqGrid("saveRow",lastsel4);
		lastsel4 = null;
		$("#jqGridTable4").jqGrid("resetSelection");
   		$("#jqGridTable5").jqGrid("saveRow",lastsel5);
   		lastsel5 = null;
   		
   		var $grid = $("#jqGridTable5");
   		
   		var fldDiv = $grid.jqGrid('getCell', rowid, 'fldDiv');
        var fldName = $grid.jqGrid('getCell', rowid, 'fldName');
        var tscsFldDesc = $grid.jqGrid('getCell', rowid, 'tscsFldDesc');
        var fldAttrib = $grid.jqGrid('getCell', rowid, 'fldAttrib');
        var rptName = $grid.jqGrid('getCell', rowid, 'rptName');
        var rptCnt = $grid.jqGrid('getCell', rowid, 'rptCnt');
   		
   		outputdatamng.setColData("useFld", fldDiv, fldName, tscsFldDesc, fldAttrib, rptName, rptCnt);
	}
	, onRightClickRow: function (rowid, iRow, iCol, e) {//우클릭 브라우져메뉴 block
	}
};
/*그리드 설정 End*/

$(document).ready(function (){
    getListMngCode("divisionIO",'IODIV','00');
    getListMngCode("cndnStylCtntType",'CONDIV','00');
    //조건식 팝업 도움말 셋팅
    outputdatamng.setCndnStylCtnt();
    
    //타이틀에 테스트시나리오 정보 출력
    var currTsSnrioID = $('#currTsSnrioID').val();
    var currTsSnrioNO = $('#currTsSnrioNO').val();
    var currTsdataID = $('#currTsdataID').val();
    
    
    $('#titleTsSnrioID').text(currTsSnrioID);
    $('#titleTsdataID').text(currTsdataID);
    $('#titleTsSnrioNO').text(currTsSnrioNO);
    //이전수행순서
    for(var i = 1; i < currTsSnrioNO ; i++){
    	$('#preSnrioNO').append("<option value='"+i+"'>"+i+"</option>");
    }
    
    //그리드 초기화
    $("#jqGridTable").jqGrid(jqGridOptions);
    $("#jqGridTable2").jqGrid(jqGridOptions2);
    $("#jqGridTable3").jqGrid(jqGridOptions3);
    $("#jqGridTable4").jqGrid(jqGridOptions4);
    $("#jqGridTable5").jqGrid(jqGridOptions5);
    
    //윈도우사이즈와 맞춰 조절됨 
	var maxWidth= 1280;
	$(window).bind('resize', function() {
		var windwoWindth = $(window).width()-35;
		if (windwoWindth > maxWidth) {
			$("#jqGridTable").setGridWidth(windwoWindth, true);
		} else {
			jQuery("#jqGridTable").jqGrid('gridResize',{minWidth:maxWidth ,maxWidth:'100%'});
			$("#jqGridTable").setGridWidth(windwoWindth, false);
		}
			
	}).trigger('resize');
	
	outputdatamng.gridFunction.append(opener.arrIODataUseDTO[Number(currTsSnrioNO-1)], true);
	var ids = $("#jqGridTable").jqGrid('getDataIDs');
	$('#totalCount').text("[총 "+ids.length+" 건]");
    
	//이벤트 등록
	//이전수행순서 변경시
    $('#preSnrioNO').change(function(){
        outputdatamng.resetFld();
        $('#divisionIO').val("00");
        //outputdatamng.checkTsSnrioNO();
    });
    //입출력구분 변경시
    $('#divisionIO').change(function(){
    	
    	outputdatamng.resetFld();
    	outputdatamng.getListPreFld();
    	
    });
    $('#btnSearchColumn1').click(function(){
        outputdatamng.openPopupColumnName('preFld');
    });
    $('#btnSearchColumn2').click(function(){
        outputdatamng.openPopupColumnName('useFld');
    });
    $('#btnAppendCndnStyl').click(outputdatamng.appendCndnStylCtnt);
    $('#btnHelp').click(outputdatamng.openPopupHelp);
    $('#btnRegister').click(outputdatamng.registerIOData);
    $('#btnModify').click(outputdatamng.modifyIOData);
    $('#btnInviMapping').click(outputdatamng.inviMapping);
    $('#btnDelete').click(outputdatamng.deleteIOData);
    $('#btnClose').click(function(){
        window.close();
    });
    
    $(".ui-jqgrid-labels").css("font-size", "12px");
    $(".ui-jqgrid-sortable").css("vertical-align", "middle");
    
    //대상데이터 필드 목록 조회
    var param = {fldIO: "I"
		        , chnlDstcd: $('#currChnlDstcd').val()
		        , tranCd: $('#currTranCd').val()};

//	$('#jqGridTable4').jqGrid('setGridParam',{url:"msg.tsmng.getMciIOMap.do", postData:param});
//	$('#jqGridTable4').trigger("reloadGrid");

    $.ajax({
	    type: "POST",
	    url:'msg.tsmng.getMciIOMap.do',
	    dataType:'json',
	    data:param,
	    success: function(data){
	    	//오류코드 처리
			if(data.errCd){
				alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
				return;
			}
			
			var headerList = data.layout.headerList;
			$('#jqGridTable4').jqGrid("addRowData","0",{fldDiv:"01",fldName:"헤더부 필드",tscsFldDesc:"전체",fldAttrib:"05"});
			$('#jqGridTable4').jqGrid("addRowData","tranNO",headerList);
			
			var inviList = data.layout.inviList;
			$('#jqGridTable5').jqGrid("addRowData","0",{fldDiv:"02",fldName:"개별부 필드",tscsFldDesc:"전체",fldAttrib:"05"});
			$('#jqGridTable5').jqGrid("addRowData","tranNO",inviList);
			
	    },
	    error: function (request, status, error) { 
	    	alert("대상데이터 레이아웃 조회중 오류가 발생하였습니다.[" + error + "]"); 
	    }
	});    
});