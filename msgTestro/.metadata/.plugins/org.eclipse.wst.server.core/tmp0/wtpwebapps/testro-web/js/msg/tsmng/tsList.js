var opener = window.dialogArguments;

var tsList = {
    // 작성자 지우기
    doClear: function(){
        $('#writeName').val('');
        $('#writeName').focus();
    },

    //조회
    doSearch: function(){
    	
    	var searchText = getAllSearchValue('searchText');
    	
        var frm = document.frm;
        
        var searchType = $('#searchType').val();
        var writeName = $.trim($('#writeName').val());
        var startDate = $.trim($('#startDate').val());
        var endDate = $.trim($('#endDate').val());
        
        if(searchType == "00"){
            alert('조회구분을 선택해 주십시오.' );
            return;
        }
        
        if(startDate != '' || endDate != ''){
           var sDt = 0; 
           var eDt = 0;
           if(startDate != ''){
              sDt = parseInt(delDateDelimiter(frm.startDate));
           }
           if(endDate != ''){
              eDt = parseInt(delDateDelimiter(frm.endDate));       
           }
           
           if(sDt > eDt || sDt == 0 || eDt== 0){
             alert('조회할 작성기간이 올바르지 않습니다.');
             return;
           }   
        }
        
//        if(isNotAlphaOrNum(searchText)) {
//            searchText = searchText.toUpperCase();
//        }
        
        tsList.clearTestDataGrid();
        tsList.clearTestDataDetailTab();
        
        var sendUrl = "msg.tsmng.getListTsInfo.do";
        var sendData = {
            searchType: searchType
            , searchText: searchText
            , writeName: writeName
            , startDate: startDate
            , endDate: endDate
        }

        $("#tsSnroLstJqGridTable").setGridParam({url: sendUrl, postData: sendData}).trigger("reloadGrid");
    },

    clearTestDataGrid: function(){
        $("#tdSnroLstJqGridTable").clearGridData();
        $('#selectTsTitle').html("");
    },

    clearTestDataDetailTab: function(){
        $("#layoutDiv").html("<div id='headerDataDiv'></div><div id='inviDataDiv'></div>");
        $('#selectTdTitle').html("");
    },
    
    //테스트케이스 상세 탭 선택시 
    selectTab: function(str){
        var idx = str.substring(4,5); //버튼순서     
        
        //버튼바꾸기
        for(i = 0; i < 2; i++){   
            if(parseInt(idx) == i){
                $('.view' + i + '_on').show();
                $('.view' + i + '_off').hide();
            }else{
                $('.view' + i + '_on').hide();
                $('.view' + i + '_off').show();
            }
        }
        
        if(idx == 0){
            $("#dataDetailDiv").show();
            $("#inviDataDiv").hide();
        }else if(idx == 1){
            $("#dataDetailDiv").hide();
            $("#inviDataDiv").show();
        }
    },

    //적용버튼 클릭 이벤트
    doAppendOpener: function(){
        var selTsSnrioGridId = $("#tsSnroLstJqGridTable").jqGrid('getGridParam','selrow');
         
        if(selTsSnrioGridId != null){
            var selTsSnrioGridRow = $("#tsSnroLstJqGridTable").jqGrid('getRowData', selTsSnrioGridId);
            window.returnValue = selTsSnrioGridId;
            window.close();    
        }else{
            alert('선택된 테스트시나리오가 없습니다. 테스트시나리오를 선택하여 주십시오.');
        }
    },
    
    //테스트 시나리오 클릭 이벤트
    searchTc: function(rowid){
        var currentData = $("#tsSnroLstJqGridTable").getRowData(rowid);
        
        $('#currentTsSnrioID').val(currentData.tsSnrioID);
        $('#currentTsSnrioName').val(currentData.tsSnrioName);
        $('#currentTsSnrioDesc').val(currentData.tsSnrioDesc);    
        
        var sendUrl = "msg.tsmng.getListTsDetailInfo.do";
        var sendData = {
            tsSnrioID: currentData.tsSnrioID
        }
        
        $("#tdSnroLstJqGridTable").setGridParam({url: sendUrl, postData: sendData}).trigger("reloadGrid");
        
        //테스트시나리오 내용넣기
        if(currentData.tsSnrioName.length > 60){
        	currentData.tsSnrioName = currentData.tsSnrioName.substr(0,60)+"......";
        }
        
        var selectTsTitle = "[";
        selectTsTitle += currentData.tsSnrioID;
        selectTsTitle += " : ";
        selectTsTitle += currentData.tsSnrioName;
        selectTsTitle += "]";
        $('#selectTsTitle').html(selectTsTitle);
        
        tsList.clearTestDataDetailTab();
    },
    
    //테스트 데이터 클릭 이벤트
    searchTd: function(rowid){
        if(rowid != 0){
            var currentData = jQuery("#tdSnroLstJqGridTable").getRowData(rowid);
            
            $.ajax({
                type:"POST",
                //async: false,
                data:{
                    tsdataID : currentData.tsdataID
                },
                dataType:"html",
                url:"msg.layout.getTdDetailList.do",
                success:function(data, status) {
                    if (data.errCd){
                        alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
                        return;
                    }
                
                    $("#layoutDiv").html("");
                    $("#layoutDiv").html(data);
                    
                    tsList.selectTab('view1');
                },
                error:function(request, status, error) {
                    alert("테스트 데이터 조회중에 오류가 발생하였습니다.[" + error + "]"); 
                }
            });
            
            //테스트데이터 내용넣기
            if(currentData.tsdataName.length > 60){
            	currentData.tsdataName = currentData.tsdataName.substr(0,60)+"......";
            }
            
            var selectTdTitle = "[";
            selectTdTitle += currentData.tsdataID;
            selectTdTitle += " : ";
            selectTdTitle += currentData.tsdataName;
            selectTdTitle += "]";
            $('#selectTdTitle').html(selectTdTitle);
        }
    }
}

/*그리드 설정 Start*/
//테스트시나리오 목록 그리드
var tsSnroLstJqGridOptions = {
    mtype: 'POST',
    datatype: 'json',
    colNames:[
       '시나리오ID',
       '시나리오명',
       '시나리오설명',
       '작성일시',
       '작성자명',
    ],
    colModel:[
        {name:'tsSnrioID',index:'tsSnrioID', width:80, align:"center"},
        {name:'tsSnrioName',index:'tsSnrioName', width:180},
        {name:'tsSnrioDesc',index:'tsSnrioDesc', width:220},
        {name:'cretnYMS',index:'cretnYMS', width:90, align:"center", formatter:gridDateFmatter, formatoptions: {srcformat:'yMdhms', newformat:'y-M-d h:m:s'}, unformat:gridDateUnFmatter},
        {name:'writeName',index:'writeName', width:90, align:"center"},
    ],
    gridview: true,	//can not use treeGrid, subGrid, or afterInsertRow event
    rowNum:20,
    scroll:-1,
    rownumbers: true,
    rowList:[20,30,50],
    sortname: 'tsSnrioID',
    pager: '#tsSnroLstJqGridPager',
    viewrecords: true,
    sortorder: "desc",
    jsonReader : {
        root: "rows",
        page: "page",
        total: "total",
        records: "records",
        repeatitems: false,
        cell: "cell",
        id: "tsSnrioID"
    },
    height: 111, 
    onCellSelect: tsList.searchTc,
    loadComplete: function(xhr){
        if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
        
        reloadGridWidthSize('tsSnroLstJqGridTable',30);
    }
};

var tsSnroLstJqGridPagerOptions = {
    edit:false,
    add:false,
    del:false
};

//테스트데이터 목록 그리드
var tdSnroLstJqGridOptions = {
    mtype: 'POST',
    datatype: 'json',
    colNames:[
       '수행순서',
       '테스트테이터ID',
       '거래코드',
       '테스트데이터명',
       '입출력값',
       '작성일시'
    ],
    colModel:[
        {name:'tsSnrioNO',index:'tsSnrioNO', width:50, align:"center", sortable:false},
        {name:'tsdataID',index:'tsdataID', width:80, align:"center", sortable:false},
        {name:'tranCd',index:'tranCd', width:50, align:"center", sortable:false},
        {name:'tsdataName',index:'tsdataName', width:180, sortable:false},
        {name:'useIO',index:'useIO', width:40, align:"center", sortable:false},
        {name:'cretnYMS',index:'cretnYMS', width:60, align:"center", sortable:false, formatter:gridDateFmatter, formatoptions: {srcformat:'yMdhms', newformat:'y-M-d h:m:s'}, unformat:gridDateUnFmatter},
    ],
    gridview: true,	//can not use treeGrid, subGrid, or afterInsertRow event
    scroll:-1,
    rownumbers: true,
    rowNum:20,
    rowList:[20,30,50],
    sortname: 'tsSnrioNO',
    pager: '#tdSnroLstJqGridPager',
    viewrecords: true,
    jsonReader : {
        root: "rows",
        page: "page",
        total: "total",
        records: "records",
        repeatitems: false,
        cell: "cell",
        id: "tsSnrioNO"
    },
    height: 111,
    onCellSelect: tsList.searchTd,
    loadComplete: function(xhr){
        if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
        
        reloadGridWidthSize('tdSnroLstJqGridTable',30);
    }
};

var tdSnroLstJqGridPagerOptions = {
    edit:false,
    add:false,
    del:false
};
/*그리드 설정 End*/

$(document).ready(function(){
    getListMngCode("searchType",'TS1DIV','01');
    
    $("#tsSnroLstJqGridTable").jqGrid(tsSnroLstJqGridOptions);
    //$("#tsSnroLstJqGridTable").jqGrid('navGrid','#tsSnroLstJqGridPager', tsSnroLstJqGridPagerOptions);
    $("#tsSnroLstJqGridTable").setGridWidth(913,true);
    
    $("#tdSnroLstJqGridTable").jqGrid(tdSnroLstJqGridOptions);
    //$("#tdSnroLstJqGridTable").jqGrid('navGrid','#tdSnroLstJqGridPager', tdSnroLstJqGridPagerOptions);
    $("#tdSnroLstJqGridTable").setGridWidth(913,true);
    
    $("#layoutDiv").html("<div id='headerDataDiv'></div><div id='inviDataDiv'></div>");
    tsList.selectTab('view1');
    
    setAllSearch('searchText');
    //이벤트 등록
    $(".validationChar").keydown(function(event){
        var re = /[ \{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi;
        var t = $(this).val();
        if(re.test(t)){
            $(this).val(t.replace(re, ""));
        }
    });
    $('#searchText, #writeName').keydown(function(event){
        if(event.keyCode ==13){
            tsList.doSearch();
        }
    })
    $('#btnSearch').click(tsList.doSearch);
    $('#btnStartCalendar').click(function(){
        popUpCalendar(this, 'startDate', 'yyyy-mm-dd','CENTER','MIDDLE');
    });
    $('#btnEndCalendar').click(function(){
        popUpCalendar(this, 'endDate', 'yyyy-mm-dd','CENTER','MIDDLE');
    });
    $('#btnView0').click(function(){
        tsList.selectTab('view0');
    });
    $('#btnView1').click(function(){
        tsList.selectTab('view1');
    });
    $('#btnSubmit').click(tsList.doAppendOpener);
    $('#btnClose').click(function(){
        window.close();
    });
    
    $('#btnWriterDel').click(tsList.doClear);
    
    $('#btnSearchTextDel').click(function(){
    	$('#searchText').focus();
    	
    });
    
    $('#btnDateDel').click(function(){
    	$('#startDate').val('');
    	$('#endDate').val('');
    });
    
    $(".ui-jqgrid-labels").css("font-size", "12px");
    $(".ui-jqgrid-sortable").css("vertical-align", "middle");
    tsList.doSearch();
    
    reloadGridWidthSize('tsSnroLstJqGridTable',30);
    reloadGridWidthSize('tdSnroLstJqGridTable',30);
});
