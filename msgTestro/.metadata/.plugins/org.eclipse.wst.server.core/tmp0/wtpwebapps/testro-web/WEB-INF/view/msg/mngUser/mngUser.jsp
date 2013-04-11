<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>전문 테스트로(TESTRO)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="jqgrid/css/ui-lightness/jquery-ui-1.7.3.custom.css" media="screen" />
<link rel="stylesheet" type="text/css" href="jqgrid/js/src/css/ui.jqgrid.css" media="screen" />
<link rel="stylesheet" type="text/css" href="jqgrid/themes/ui.datepicker.css" media="screen" />
<link rel="shortcut icon" href="images/TESTRO.ico" type="image/ico" />
<style>
html, body {
    margin: 0;
    padding: 0;
    font-size: 75%;
}
</style>
<script type="text/javascript" src="js/cmn/utils/json2.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/jquery-1.5.2.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/jquery.blockUI.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/src/i18n/grid.locale-en.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/jquery.jqGrid.src.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/ui.datepicker.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/popupcalendar.js"></script>
<script type="text/javascript" src="js/cmn/util.js" charset="utf-8"></script>
<script type="text/javascript">


<!--
function MM_swapImgRestore() { //v3.0
var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadimage() { //v3.0
var d=document; if(d.image){ if(!d.MM_p) d.MM_p=new Array();
var i,j=d.MM_p.length,a=MM_preloadimage.arguments; for(i=0; i<a.length; i++)
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

//신규 사용자 등록 및 수정 버튼 
function MM_openBrWindow(theURL,winName,features) { //v2.0	
	//세션 레벨 가지고 오기
	var lastModfiEmpLevel = '${sessionScope.userinfo.usrlevel}';
	//사용자 관리 수정 
	if(winName == "사용자관리수정"){
		var select = jQuery("#list").getGridParam("selrow");
		var rows= jQuery("#list").jqGrid('getRowData',select);
		var usrID = rows.usrID;
		var postData = JSON.stringify(rows);
		if(select == null){
			alert("수정할 사용자 정보를 선택해주세요");	
			return false;
		}else{	
			theURL = theURL+"&usrID="+encodeURIComponent(usrID)+"&lastModfiEmpLevel="+ encodeURIComponent(lastModfiEmpLevel);
		}	
		var returnVal = window.showModalDialog(theURL,winName,features);
		if(returnVal == 1){
			doSearch();
		}
	//사용자 관리 신규 등록
	}else if(winName == "사용자관리신규"){
		theURL = theURL+"&lastModfiEmpLevel="+ encodeURIComponent(lastModfiEmpLevel);
		var returnVal = window.showModalDialog(theURL,winName,features);
		if(returnVal == 1){
			doSearch();
		}
	}
}

//-->
var lastsel2;
var maxWidth= 1100; //전체사이즈
var leftTemp = 230; //left메뉴사이즈
var lastModfiEmpLevel = '${sessionScope.userinfo.usrlevel}'; //사용자 Level
var maxHeight= $(window).height()-330; //전체사이즈
//JQ그리드 그리기
$(document).ready(function() {
	

	jQuery("#list").jqGrid( {
		mtype:'POST',    // 한글 인코딩 깨지는 문제 방지하기 위해 POST로 쓴다
		url: 'msg.MngUserSearch.mngUser.do?lastModfiEmpLevel='+lastModfiEmpLevel,
		datatype : "json",
		colNames : [ '권한', '권한(숫자)', '사용자ID', '사용자명', '프로젝트번호', '프로젝트명', '테스트단계' ],
		colModel : [ 
			{name : 'usrLevelName',index : 'USRLEVELNAME',width : 130,align : "center", sortable:true}, 		
			{name : 'usrLevel',index : 'USRLEVEL',width : 170,align : "center", hidden:true}, 
			{name : 'usrID',index : 'USRID',width : 170, align : "center", sortable:true}, 
			{name : 'usrName',	index : 'USRNAME',	width : 170,align : "center", sortable:true}, 
			{name : 'qaltyMgtProjNo',	index : 'QALTYMGTPROJNO',	width : 170,align : "left", sortable:true}, 
			{name : 'qaltyMgtProjName',index : 'QALTYMGTPROJNAME',width : 170,	align : "left", sortable:true},
			{name : 'testStgeName',index : 'TESTSTGENAME',width : 170,	align : "left", sortable:true}
		],
		height: maxHeight,
		rownumbers: true,//리스트 seq 사용 여부 
		gridview: true,
		rowNum:30, //페이지 row 갯수 
	    rowList:[20,30,50], //페이지 row 갯수 변경 option( bottom selectbox) 
	    sortname : 'USRLEVELNAME',
		viewrecords : true,
		sortorder : "asc",
		autowidth: true,
		pager: '#pager', //bottom paging 지정 
		loadComplete: function(xhr){
       		if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
       		$("#list").setGridHeight(maxHeight+1, true);
       		setSelection('list');
		},
		jsonReader : {
			root : "rows",
			page : "page",
			total : "total",
			records : "records",
			repeatitems : false,
			cell : "cell",
			id : "USRLEVELNAME"
		},
		onRightClickRow: function (rowid, iRow, iCol, e) {//우클릭 브라우져메뉴 block
		}
	});

	$("#삭제버튼ID").click( function() { //row삭제
		var fromArray;//select row
		var result;//copy status true/flase
		fromArray = jQuery("#list").jqGrid('getGridParam','selarrrow');
		if( fromArray.length > 0 ){
			for(var j = fromArray.length-1;  j>=0 ; j--){
				//del select row
				jQuery("#list").delRowData(fromArray[j]);
			}
		}else{
			alert("삭제할 사용자 정보를 선택하세요");
		}
	});
	
	var sessionLevel = '${sessionScope.userinfo.usrlevel}';
	if(sessionLevel == "01"){				//레벨 01일때 화면
		getListMngCode('mgrLvelDstcd2','USRLEVEL','00');
	}else if(sessionLevel == "02"){			//레벨 02일때 화면
		getListMngCode('mgrLvelDstcd2','USRLEVEL2','00');
	}	
	//윈도우사이즈와 맞춰 조절됨

	$(window).bind('resize', function() {
		var windwoWindth = $(window).width()-leftTemp;
		if (windwoWindth > maxWidth) {
			$("#list").setGridWidth(windwoWindth, true);
		} else {
			jQuery("#list").jqGrid('gridResize',{minWidth:maxWidth ,maxWidth:'100%'});
			$("#list").setGridWidth(windwoWindth, false);
		}
		//-------- 그리드 hight ------------------------------
		var windowHeight = $(window).height()-300;           // 마이너스값 수정. 
		$("#list").setGridHeight(windowHeight, true);         
	    //---------------------------------------------------	
	}).trigger('resize');	
	setAllSearch('empid1');

	$("input,select").keydown(function(e){
	   	if(e.keyCode == 13){
	   		doSearch();
	   	}
	});
});
function bodyreload(){
	var hidenYn = $("body").attr("hideYn");
	if("Y" == hidenYn){ //left 메뉴 hidden
		leftTemp=40;
	}else{ //left 메뉴 show
		leftTemp=230;
	}
	$(window).trigger('resize');
}
//조회 버튼
function doSearch(){
	var par = "";
	var usrID = getAllSearchValue('empid1');
	var usrName = $("#empName1").val();
	var usrLevel = $("#mgrLvelDstcd2").val();
	$('#list').setGridParam({
		page: 1,
		url:'msg.MngUserSearch.mngUser.do',
		postData: {
			usrID: usrID,
			usrName: usrName,
			usrLevel: usrLevel,
			lastModfiEmpLevel: lastModfiEmpLevel
		}
	});
	$('#list').trigger("reloadGrid");	
	$("#search_button1").focus();
}
//행 삭제
function doDelete(){
	var select = jQuery("#list").getGridParam("selrow");
	var rows= jQuery("#list").jqGrid('getRowData',select);
	var usrID = rows.usrID;
	var usrName = rows.usrName;
	var projNo = rows.qaltyMgtProjNo;
	var postData = JSON.stringify(rows);
	if(select == null){
		alert("삭제할 사용자 정보를 선택해주세요.");	
		return false;
	}else{	
		if(confirm("사용자 ID : "+usrID+"\r\n사용자 명 : "+usrName+"\r\n\r\n선택하신 사용자를 삭제하시겠습니까?")){
			$.ajax({
		        type:"POST",
				data:{"usrID":usrID,
						"usrName":usrName,
						"projNo":projNo},
		        dataType:"json",
		        async : true,
		        url:"msg.MngUserDelete.mngUser.do",
		        success:function(data, status) {
		        	if (data.errCd){
			        	alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
		        	}else{
			        	alert("사용자 정보가 삭제 되었습니다.");
			        	doSearch();
		        	}
		        },
		        error:function(request, status, error) {
		        	alert("사용자 정보 삭제중에 오류가 발생하였습니다.[" + error + "]"); 
		        }
		    });	
		}
	}	
}
//직원 조회 팝업
function userSearch(){
	var url = "msg.report.empSrchpop.do";
	var rtnArr = window.showModalDialog(url,window,'center:yes;dialogWidth=650px; dialogHeight=575px; dialogLeft=100px; dialogTop=50px; scroll=no; status=no; help=no; resizable:no;');
    if(rtnArr != null){
    	$("#empid1").val(rtnArr[0]);	//채널구분코드
        $("#empName1").val(rtnArr[1]);	//거래코드
    }
}

// iframe resize
function autoResize(i)
{
var iframeHeight=
(i).contentWindow.document.body.scrollHeight;
(i).height=iframeHeight+20;
}

</script>
</head>
<body bgcolor="#FFFFFF" background="images/left_menu_bg.jpg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="MM_preloadimage('images/top_menu_01_02.jpg','images/top_menu_05_02.jpg','images/top_menu_06_02.jpg','images/btn_newtc_02.jpg','images/btn_import_02.jpg','images/btn_savetc_02.jpg','images/btn_initialize_02.jpg','images/top_menu_message_02.jpg','images/top_menu_statistics_02.jpg','images/top_menu_mytest_02.jpg','images/top_menu_system_02.jpg')">

<div id="Minwidth">
        <div id="Page">
            <div id="contents">
            <!-- top menu 시작 --> 
			<jsp:include page="/WEB-INF/view/cmn/topMenu.jsp" flush="true"></jsp:include>
            <!-- top menu 끝 -->   
            
                <table width="100%" border="0" cellpadding="0" cellspacing="0" id="Table_01">
                    <tr> 
						<!-- left menu 시작 -->
						<jsp:include page="/WEB-INF/view/cmn/leftMenu.jsp" flush="true"></jsp:include>
						<!-- left menu 끝 -->
                        <td valign="top">
                            <table width="100%" height="100%" border="0" cellpadding="15" cellspacing="0">
                                <tr> 
                                  <td valign="top">
                                    
										<table border=0 cellpadding=0 cellspacing=0 width=100%>
                                            <tr> 
                                                <td width="20"><img src="images/title_bullet1.gif"></td>
                                                <td width="120" class="sub_tit">사용자 정보관리</td>
                                                <td valign="bottom" class="point_text" id="flowMsg" > 사용자를 신규등록 하거나  수정 할 수 있습니다.</td>
                      						</tr>
                                            <tr > 
                                                <td background="images/tit_line_bg.gif" height="6" colspan="4"><img src="images/tit_line_bg.gif"></td>
                                            </tr>
                                            <tr > 
                                                <td height="10" colspan="4"></td>
                                            </tr>
                                      </table>
                                     <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#baccdc">
                                      <tr>
                                        <td bgcolor="#e1e9f0"><table width="100%" border="0" cellspacing="0" cellpadding="5">
                                            <tr>
                                              <td bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="2">
                                                  <tr>
                                                    <td width="90" class="box_txt">사용자 ID/명 :</td>
                                                    <td>
	                                                    <input name="empid1" id="empid1" type="text" class="input_topinq" style="width:100px">
	                                                    <img src="images/btn_pop.gif" alt="조회" width="23" height="21" hspace="4" align="absmiddle" style="cursor:pointer;" onclick="userSearch(); return false;">
	                                                    <input name="empName1" id="empName1" type="text" class="input_topinq" style="width:160px" >
	                                                    <img src="images/btn_eraser.gif" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" onClick="{$('#empid1').val('').focus();$('#empName1').val('');}" style="cursor: pointer">
                                                    </td>
                                                    <td width="45" class="box_txt">권 한 :</td>
                                                    <td><select name="mgrLvelDstcd2" id="mgrLvelDstcd2"  class="menu" style="width:120px" onKeyDown="if(event.keyCode ==13){doSearch();}">
                                                        </select>
                                                    </td>
                                                    <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                                                        <tr>
                                                          <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                                          <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" id="search_button1" onclick="doSearch(); return false;">조 회</td>
                                                          <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                                        </tr>
                                                    </table></td>
                                                  </tr>
                                              </table></td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                    </table>
                                    <table width="100%" border="0" cellspacing="0" cellpadding="1">
                                      <tr>
                                        <td height="10" colspan="2"></td>
                                      </tr>
                                      <tr>
                                        <td height="10" colspan="2"><table border="0" align="right" cellpadding="0" cellspacing="0">
                                          <tr>
                                            <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                            <td background="images/btn_img_02.gif" class="btn_text" onclick="doDelete(); return false;"  style="cursor:pointer;">삭 제</td>
                                            <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                          </tr>
                                        </table>
                                          <table border="0" align="right" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                              <td background="images/btn_img_02.gif" class="btn_text" onclick="MM_openBrWindow('msg.popMngUser.popMngUser.do?newSave=N','사용자관리수정','center:yes;dialogWidth=540px; dialogHeight=230px; scroll=no; status=no; help=no; resizable:no; ')"  style="cursor:pointer;" >수 정</td>
                                              <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                            </tr>
                                          </table>
                                          <table border="0" align="right" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                              <td background="images/btn_img_02.gif" class="btn_text" onclick="MM_openBrWindow('msg.popMngUser.popMngUser.do?newSave=Y&usrID=&usrName=','사용자관리신규','center:yes;dialogWidth=460px; dialogHeight=228px; scroll=no; status=no; help=no; resizable:no; ')"  style="cursor:pointer;" >신규 사용자 등록</td>
                                              <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                            </tr>
                                          </table></td>
                                      </tr>
                                    </table>
                                    <table width="100%" height="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                                      <tr>
                                        <td valign="top" bgcolor="#FFFFFF">
                                       		<table id="list"></table>
                                       		<div id="pager"></div> 
                                        </td>
                                      </tr>
                                    </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    
</body>
</html>