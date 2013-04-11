<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<jsp:include page="/WEB-INF/view/cmn/common.jsp" flush="true"></jsp:include>
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
	var lastsel2;
	var lastsel3; 
	var maxWidth= 1100; //전체사이즈
	var maxHeight= $(window).height()-330; //전체사이즈
	var leftTemp = 230; //left메뉴사이즈
	//JQ그리드 그리기
	$(document).ready(function() {
		var connSevrDst = '${sessionScope.userinfo.connsevrdstcd}';
		$("#connSevrDstcd").val(connSevrDst);
		
		var userLevel = '${sessionScope.userinfo.usrlevel}';
		if(userLevel == 03){
			$("#projDepartment").hide();
		}
		jQuery("#list1").jqGrid( {
			mtype:'POST',    // 한글 인코딩 깨지는 문제 방지하기 위해 POST로 쓴다
			url: 'msg.GetMyQaltyAction.myQalty.do',
			datatype : "json",
			colNames : [ '프로젝트번호', '프로젝트명', '테스트단계', '테스트시작일자', '테스트종료일자' ],
			colModel : [ 
				{name : 'projNo',index : 'PROJNO',width : 170,align : "left"},
				{name : 'projName',index : 'PROJNAME',width : 323,editable : true,align : "left"}, 
				{name : 'testStgeName',	index : 'TESTSTGENAME',	width : 170,align : "left"}, 
				{name : 'testStartYMS',	index : 'TESTSTARTYMS',	width : 170,align : "center", formatter:gridDateFmatter, formatoptions: {srcformat:'yMd', newformat:'y-M-d'}, unformat:gridDateUnFmatter}, 
				{name : 'testEndYMS',index : 'TESTENDYMS',width : 170,	align : "center", formatter:gridDateFmatter, formatoptions: {srcformat:'yMd', newformat:'y-M-d'}, unformat:gridDateUnFmatter}
			],	
			height: maxHeight,
			rownumbers: true,//리스트 seq 사용 여부 
			gridview: true,
			rowNum:30, //페이지 row 갯수 
		    rowList:[20,30,50], //페이지 row 갯수 변경 option( bottom selectbox) 
			sortname : 'PROJNO',
			viewrecords : true,
			sortorder : "asc",
			autowidth: true,
			pager: '#pager', //bottom paging 지정 
			loadComplete: function(xhr){
				if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
				 $("#list1").setGridHeight(maxHeight+1, true);

				 setSelection('list1');
			},
			jsonReader : {
				root : "rows",
				page : "page",
				total : "total",
				records : "records",
				repeatitems : false,
				cell : "cell"
			},
			onRightClickRow: function (rowid, iRow, iCol, e) {//우클릭 브라우져메뉴 block
			}
		});
		//윈도우사이즈와 맞춰 조절됨
		$(window).bind('resize', function() {
			var windowWindth = $(window).width()-leftTemp;
			if (windowWindth > maxWidth) {
				$("#list1").setGridWidth(windowWindth, true);
			} else {
				jQuery("#list1").jqGrid('gridResize',{minWidth:maxWidth ,maxWidth:'100%'});
				$("#list1").setGridWidth(windowWindth, false);
			}
			//-------- 그리드 hight ------------------------------
			windowHeight = $(window).height() - 350;           // 마이너스값 수정. 
			$("#list1").setGridHeight(windowHeight, true);         
		    //---------------------------------------------------	
		}).trigger('resize');
		//입력필드에 전체 값 넣어주고 포커스 할경우사라지게 하기
		setAllSearch('qaltyMgtProjName1');

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

	//<!--
	function MM_swapImgRestore() { //v3.0
		var i, x, a = document.MM_sr;
		for (i = 0; a && i < a.length && (x = a[i]) && x.oSrc; i++)
			x.src = x.oSrc;
	}
	function MM_preloadImages() { //v3.0
		var d = document;
		if (d.image) {
			if (!d.MM_p)
				d.MM_p = new Array();
			var i, j = d.MM_p.length, a = MM_preloadimage.arguments;
			for (i = 0; i < a.length; i++)
				if (a[i].indexOf("#") != 0) {
					d.MM_p[j] = new Image;
					d.MM_p[j++].src = a[i];
				}
		}
	}

	function MM_findObj(n, d) { //v4.01
		var p, i, x;
		if (!d)
			d = document;
		if ((p = n.indexOf("?")) > 0 && parent.frames.length) {
			d = parent.frames[n.substring(p + 1)].document;
			n = n.substring(0, p);
		}
		if (!(x = d[n]) && d.all)
			x = d.all[n];
		for (i = 0; !x && i < d.forms.length; i++)
			x = d.forms[i][n];
		for (i = 0; !x && d.layers && i < d.layers.length; i++)
			x = MM_findObj(n, d.layers[i].document);
		if (!x && d.getElementById)
			x = d.getElementById(n);
		return x;
	}

	function MM_swapImage() { //v3.0
		var i, j = 0, x, a = MM_swapImage.arguments;
		document.MM_sr = new Array;
		for (i = 0; i < (a.length - 2); i += 3)
			if ((x = MM_findObj(a[i])) != null) {
				document.MM_sr[j++] = x;
				if (!x.oSrc)
					x.oSrc = x.src;
				x.src = a[i + 2];
			}
	}
	function MM_openBrWindow(theURL, winName, features) { //v2.0
		window.open(theURL, winName, features);
	}
	//-->

	// iframe resize
	function autoResize(i) {
		var iframeHeight = (i).contentWindow.document.body.scrollHeight;
		(i).height = iframeHeight + 20;
	}

	//나의 프로젝트 단계정보 조회 
	function doSearch() {	
		var par = "";
		var projName = getAllSearchValue('qaltyMgtProjName1');
		par = "?projName=" + encodeURIComponent(projName);
		$('#list1').setGridParam({
			page: 1,
			url:'msg.GetMyQaltyAction.myQalty.do',
			postData: {
				projName: projName
			}
		});
		$('#list1').trigger("reloadGrid");	
		$("#search_button1").focus();
	}

	//프로젝트 정보 설정 저장
	function doSave() {
		
		var fromArray;
		fromArray = jQuery("#list1").jqGrid('getGridParam','selarrrow');
		var select = jQuery("#list1").getGridParam("selrow");
		var rows= jQuery("#list1").jqGrid('getRowData',select);
		var usrid = '${sessionScope.userinfo.usrid}';    //사용자id
		var connSevrDstcd = '${sessionScope.userinfo.connsevrdstcd}';    //접속서버
		var postData = JSON.stringify(rows);
		if(select == null){
			alert("설정하고자 하는 프로젝트정보가 없습니다.");	
		}else{	
			if(confirm("프로젝트 정보를 설정하시겠습니까?")){
				$.ajax({
			        type:"POST",
					data:{"jgGridData":postData,
						"usrId":usrid,
						"connSevrDstcd":connSevrDstcd },
			        dataType:"json",
			        async : true,
			        url:"msg.RegisterMyQaltyAction.myQalty.do",
			        success:function(data, status) {
			        	if (data.errCd){
				        	alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
			        	}else{
					        alert("테스트 진행 프로젝트를 다음과 같이 설정하셨습니다.\r\n\r\n프로젝트명 : "+rows.projName+"\r\n테스트단계 : "+rows.testStgeName);
				        	reload();
			        	}
			        },
			        error:function(request, status, error) {
			        	alert("프로젝트 설정중에 오류가 발생하였습니다.[" + error + "]"); 
			        }
			    });	
			}
		}
	}

	//화면 재 출력
	function reload(){
		location.href="msg.myQalty.myQalty.do";
	}
	//프로젝트 명 검색어 초기화
	function doMgtClaer() {
		$("#qaltyMgtProjName2").val("");
	}
	//테스트 환경설정 저장
	function doEnviSave() {
		
		var frm = document.frm3;
		var useEmpid ='${sessionScope.userinfo.usrid}';						//세션 ID
		var connSevrDstcdName = $("#connSevrDstcd > :selected").html();;	//선택한값의 html 값
		//접속서버 없으면 저장 불가
		if (frm.connSevrDstcd.value == "") {
			alert("접속 서버를 지정하세요.");
			frm.connSevrDstcd.focus();
			return;
		}
		$.ajax({
	        type:"POST",
			data:{
				"connSevrDstcdnm":connSevrDstcdName,
				"connSevrDstcd":frm.connSevrDstcd.value,
	    		"usrId":useEmpid},
	        dataType:"json",
	        async : true,
	        url:"msg.RegisterTestEnviAction.myQalty.do",
	        success:function(data, status) {
	        	if (data.errCd){
		        	alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
	        	}else{
			        alert("접속시스템이 '" + connSevrDstcdName + "'으로 설정되었습니다.");
		        	reload();
	        	}
	        },
	        error:function(request, status, error) {
	        	alert("접속시스템 설정중에 오류가 발생하였습니다.[" + error + "]"); 
	        }
	    });
	}
	function insertProject(winName) {
		var lastModfiEmpLevel = '${sessionScope.userinfo.usrlevel}';
		//사용자 관리 수정 
		var theURL = "msg.popMyQalty.popMyQalty.do";
		if(winName == "수정"){
			var select = jQuery("#list1").getGridParam("selrow");
			var rows= jQuery("#list1").jqGrid('getRowData',select);
			var projNo = rows.projNo;
			var testStgeName = rows.testStgeName;
			var postData = JSON.stringify(rows);
			
			if(select == null){
				alert("수정할 프로젝트를 선택해주세요");	
				return false;
			}else{
				theURL = theURL+"?newSave=N&projNo="+encodeURIComponent(projNo)+"&testStgeName="+encodeURIComponent(testStgeName)+"&lastModfiEmpLevel="+ lastModfiEmpLevel;
			}	
			var retrunValue = window.showModalDialog(theURL,winName,'center:yes;dialogWidth=480px; dialogHeight=233px; scroll=no; status=no; help=no; resizable:no; ');
			if(retrunValue == 1){
				doSearch();
			}
		//사용자 관리 신규 등록
		}else if(winName == "신규"){
			theURL = theURL+"?newSave=Y&projNo=&&testStgeName=&lastModfiEmpLevel="+ encodeURIComponent(lastModfiEmpLevel);
			var retrunValue = window.showModalDialog(theURL,winName,'center:yes;dialogWidth=480px; dialogHeight=233px; scroll=no; status=no; help=no; resizable:no; ');
			if(retrunValue == 1){
				doSearch();
			}
		}
	}
	//프로젝트 삭제
	function deleteProject() {
		var select = jQuery("#list1").getGridParam("selrow");
		var rows= jQuery("#list1").jqGrid('getRowData',select);
		var projNo = rows.projNo;
		var projName = rows.projName;
		var testStgeName = rows.testStgeName;
		var postData = JSON.stringify(rows);
		if(select == null){
			alert("삭제할 프로젝트를 선택해주세요.");	
			return false;
		}else{
			if(confirm("프로젝트명 : "+projName+"\r\n테스트단계 : "+testStgeName+"\r\n\r\n선택한 프로젝트/테스트단계 정보를 삭제 하시겠습니까?")){
				$.ajax({
			        type:"POST",
					data:{"projNo":projNo,
						"testStgeName":testStgeName},
			        dataType:"json",
			        async : true,
			        url:"msg.getProjectDelete.MyQalty.do",
			        success:function(data, status) {
			        	if (data.errCd){
				        	alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
			        	}else{
					        if(data.ProjCheck == 0){
						        alert("현재 사용중인 프로젝트 정보는 삭제하실 수 없습니다.\r\n테스트케이스 및 테스트결과서가 존재합니다.");
					        }else{
				        		alert("선택한 프로제트가 삭제 되었습니다.");
				        		doSearch();
					        }
			        	}
			        },
			        error:function(request, status, error) {
			        	alert("프로젝트 삭제중에 오류가 발생하였습니다.[" + error + "]"); 
			        }
			    });	
			}
		}
	}	
	//사용자 비밀번호 변경
	function passChacnge(){
		var url = "msg.popUserPass.popUserPass.do";
	    var returnValue = window.showModalDialog(url,window,'center:yes;dialogWidth=470px; dialogHeight=206px; scroll:no; status:no; help:no; resizable:no; location:no; ');
	}		
</script>
</head>
<body bgcolor="#FFFFFF" background="images/left_menu_bg.jpg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >

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
                                      <td width="165" class="sub_tit">나의 프로젝트 정보설정</td>
                                      <td valign="bottom" class="point_text" id="flowMsg" >프로젝트를 추가 하거나 수정 할 수 있습니다.</td>
                                    </tr>
                                    <tr >
                                      <td background="images/tit_line_bg.gif" height="6" colspan="3"><img src="images/tit_line_bg.gif"></td>
                                    </tr>
                                    <tr >
                                      <td height="10" colspan="3"></td>
                                    </tr>
                                  </table>
                                 <form name="frm1" method="post">
                                 <input name="projNo" type="hidden" />
                                    <table width="100%" border="0" cellspacing="0" cellpadding="1">
                                      <tr>
                                        <td class="sub_tit02">나의 프로젝트 단계정보</td>
                                        <td align="right">
                                        
                                        
                                        
                                        
                                        <img src="images/bullet_round_blue.gif" width="8" height="10" hspace="4"><span class="board_title">프로젝트명 :</span>
                                        <span class="input_result">${sessionScope.userinfo.projname}</span>
                                        
                                        
                                        
                                        
                                        <img src="images/bullet_round_blue.gif" width="8" height="10" hspace="4"><span class="board_title">테스트단계 :</span>
                                        <span class="input_result">${sessionScope.userinfo.teststgename}</span></td>
                                        
                                        
                                        
                                        
                                        
                                      </tr>
                                    </table>
                                    <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#baccdc">
                                          <tr>
                                            <td bgcolor="#e1e9f0">
                                              <table width="100%" border="0" cellspacing="0" cellpadding="5">
                                                    <tr>
                                                      <td bgcolor="#FFFFFF">
                                                          <table width="100%" border="0" cellspacing="0" cellpadding="2">
                                                              <tr>
                                                                <td width="80" class="box_txt">프로젝트 명:</td>
                                                                <td width="344">
                                                                	<input name="qaltyMgtProjName1" id="qaltyMgtProjName1" type="text" class="input_topinq" style="width:300px" maxlength="100">
                                                                	<img src="images/btn_eraser.gif" alt="삭제" width="23" height="21" hspace="4" align="absmiddle" onClick="{$('#qaltyMgtProjName1').val('').focus()}" style="cursor: pointer">
                                                                </td>
                                                                <td>
	                                                                <table border="0" cellpadding="0" cellspacing="0" align="right">
	                                                                  <tr>
	                                                                    <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
	                                                                    <td background="images/btn_img_02.gif" class="btn_text" id="search_button1" style="cursor:pointer" onclick="doSearch(); return false;">조 회</td>
	                                                                    <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
	                                                                  </tr>
	                                                                </table>
                                                                </td>
                                                              </tr>
                                                          </table>
                                                      </td>
                                                    </tr>
                                              </table>
                                            </td>
                                          </tr>
                                        </table>
                                    <table width="100%" border="0" cellspacing="0" cellpadding="1">
                                      <tr>
                                        <td height="10" colspan="3"></td>
                                      </tr>
                                      <tr>
                                        <td class="sub_tit02">프로젝트 목록</td>
					                  <td id="projDepartment">
						                  <table border="0" align="right" cellpadding="0" cellspacing="0">
						                    <tr>
						                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
						                      <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="deleteProject(); return false;">삭제</td>
						                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
						                    </tr>
						                  </table>
						                  <table border="0" align="right" cellpadding="0" cellspacing="0">
						                    <tr>
						                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
						                      <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="insertProject('수정'); return false;">수정</td>
						                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
						                    </tr>
						                  </table>
						                    <table border="0" align="right" cellpadding="0" cellspacing="0">
						                    <tr>
						                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
						                      <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="insertProject('신규'); return false;">프로젝트 추가 </td>
						                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
						                    </tr>
						                  </table>		                    
					                    </td>
                                      </tr>
                                    </table>
                                    <table width="100%" height="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                                      <tr>
                                        <td valign="top" bgcolor="#FFFFFF">
                                        <table id="list1"></table>
                                        <div id="pager"></div> 
                                        </td>
                                      </tr>
                                    </table>
                                    <table width="100%" border="0" cellspacing="0" cellpadding="1">
                                      <tr>
                                        <td height="5"></td>
                                      </tr>
                                      <tr>
                                        <td height="10"><table border="0" align="right" cellpadding="0" cellspacing="0">
                                          <tr>
                                            <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                            <td background="images/btn_img_02.gif" class="btn_text" onclick ="doSave(); return false;" style="cursor:pointer" title="선택한 프로젝트로 프로젝트정보를 설정합니다.">프로젝트 정보설정</td>
                                            <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                          </tr>
                                                                                </table></td>
                                      </tr>
                                    </table>
                            </form>
<!--                        <form name="frm3" method="post">
							<input type="hidden" id="strCd" name="strCd" />
							<input type="hidden" id="strNm" name="strNm" />
                                    <table width="100%" border="0" cellspacing="0" cellpadding="1">
                                      <tr>
                                        <td class="sub_tit02">테스트 환경 설정</td>
                                      </tr>
                                    </table>
                                    <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#baccdc">
                                      <tr>
                                        <td bgcolor="#e1e9f0"><table width="100%" border="0" cellspacing="0" cellpadding="5">
                                            <tr>
                                              <td bgcolor="#FFFFFF">
                                                <table width="100%" border="0" cellspacing="0" cellpadding="2">
                                                    <tr>
                                                        <td width="80" class="box_txt">접속시스템 :</td>
                                                        <td>
                                                          <select name="connSevrDstcd"  id="connSevrDstcd" class="menu" style="width:140px">
                                                          	<option value="" >== 선 택 ==</option>
                                                          	<c:forEach var="list" items="${mciArray}" varStatus="status">
						                                        <option value="${list.key}" >${list.val}</option>
                                                            </c:forEach>
                                                          </select>
                                                      </td>                        
                                                   </tr>     
                                                </table>
                                              </td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                    </table>
                                    <table width="100%" border="0" cellspacing="0" cellpadding="1">
                                      <tr>
                                        <td height="5"></td>
                                      </tr>
                                      <tr>
                                        <td height="10">
                                        <table border="0" align="right" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                              <td background="images/btn_img_02.gif" class="btn_text" onclick="doEnviSave(); return false;" title="입력된 정보로 테스트환경을 설정합니다." style="cursor:pointer">테스트환경설정</td>
                                              <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                                            </tr>
                                        </table>
                                        <table border="0" align="right" cellpadding="0" cellspacing="0">
						                    <tr>
						                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
						                      <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="passChacnge(); return false;">비밀번호 변경</td>
						                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
						                    </tr>
						                  </table>
                                        </td>
                                      </tr>
                                    </table> 
                           			</form> -->   
                            
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