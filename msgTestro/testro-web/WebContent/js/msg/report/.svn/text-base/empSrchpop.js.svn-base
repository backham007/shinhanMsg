function autoResize(i)
{
    var iframeHeight=
    (i).contentWindow.document.body.scrollHeight;
    (i).height=iframeHeight+20;
}

$(document).ready(function(){
	
	jQuery("#list").jqGrid({
		mtype:'POST',    // 한글 인코딩 깨지는 문제 방지하기 위해 POST로 쓴다
		datatype: "json",
	    colNames:['사용자명'
	              ,'사용자ID'
	              ,'프로젝트번호'
	              ,'프로젝트명'
		],
	    colModel:[
					{name: 'usrname'        ,index: 'usrname'        , width:100, editable:true, align:"center"},
					{name: 'usrid'       ,index: 'usrid'       , width:100, editable:true, align:"center"},
					{name: 'projno'      ,index: 'projno'      , width:100, editable:true, align:"center"},
					{name: 'projname'     ,index: 'projname'     , width:100, editable:true, align:"center"}

	    ],
	    pager: '#pager',
	    rownumbers: true,
	   	rowNum:20,
    	rowList:[20,30,50], 
	   	height:305,
	   	sortname: 'usrid',
	    viewrecords: true,
	    sortorder: "desc",
	    jsonReader : {
	        root: "rows",
	        page: "page",
	        total: "total",
	        records: "records",
	        repeatitems: false,
	        cell: "cell"
	    },
	    onRightClickRow: function () {//우클릭 브라우져메뉴 block
	    },
	    ondblClickRow: function (rowid) { //더블클릭 이벤트
	    	var temp = jQuery("#list").getRowData(rowid);
			var rtnArr = new Array();
			rtnArr[0] = temp.usrid;	//id
			rtnArr[1] = temp.usrname;	//이름
			window.returnValue = rtnArr;
			self.close();
        },
        loadComplete: function(xhr){
            if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
            reloadGridWidthSize('list',30);
        }

	});
	$("#list").setGridWidth(610, true);
	$("#rpt_srch").click(function(){//조회
		srch();
	});
	
	$("#prt_srch").click(function(){ //프로젝트 조회
		//프로젝트조회 팝업
	    var url = "msg.cmn.projPop.do";
	    var returnValue = window.showModalDialog(url,window,'center:yes;dialogWidth=950px; dialogHeight=570px; scroll=no; status=no; help=no; resizable:no; ');
	    
	    if(returnValue != null){
	    	//프로젝트조회후 선택된 값이 있을경우
	    	$("#projNo").val(returnValue[0]);	//프로젝트번호
	    	$("#projName").val(returnValue[1]);	//프로젝트명
	    }
	});
	
	$("#btn_app").click(function(){ //적용
		var selectrow = jQuery("#list").jqGrid('getGridParam','selrow');
    	var temp = jQuery("#list").getRowData(selectrow);
		var rtnArr = new Array();
		rtnArr[0] = temp.usrid;	//id
		rtnArr[1] = temp.usrname;	//이름
		window.returnValue = rtnArr;
		self.close();
	});
	
	function srch(){
		var projNo    = $("#projNo").val().split("-").join("");//프로젝트번호
		var projName  = $("#projName").val().split("-").join("");  //프로젝트명
		var usrname   = $("#usrname").val();                        //사용자명
		
		$('#list').setGridParam({'page':1,url:'msg.report.getPjtEmpLst.do',postData: {
			projNo      :projNo     ,
			projName    :projName   ,
			usrname     :usrname     }});
		$('#list').trigger("reloadGrid");
	}
	srch();
	$("input,select").keydown(function(e){
	   	if(e.keyCode == 13){
	   		srch();
	   	}
	});
}); 