<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
<script type="text/javascript">
var lastsel2;
// iframe resize
$(document).ready(function(){
	$("#startDate").attr("readonly",true);
	$("#endDate").attr("readonly",true);
	var maxWidth= 600;
	$(window).bind('resize', function() {
		var windwoWindth = $(window).width()-35;
		if (windwoWindth > maxWidth) {
			$("#list").setGridWidth(windwoWindth, true);
		} else {
			jQuery("#list").jqGrid('gridResize',{minWidth:maxWidth ,maxWidth:'100%'});
			$("#list").setGridWidth(windwoWindth, false);
		}
			
	}).trigger('resize');
	
	jQuery("#list").jqGrid({
		datatype: "json",
	   	colNames:['일련번호','구분명', '입력값'],
	   	colModel:[
	   		{name:'dstCd',index:'dstCd', width:80, align:"right",sortable:false},
	   		{name:'dstName',index:'dstName', width:80, align:"right",sortable:false},
	   		{name:'resultData',index:'ResultData', width:286, editable:true, align:"right",sortable:false,editoptions:{maxlength:30, style:"text-align:right"} }
	   	],
	   	height:410, // 높이
	   	gridview: true,
 		rowNum:100,
	    viewrecords: true,
	    multiselect: true,
	    editurl:'clientArray',
	    loadComplete: function(xhr) {
			if (xhr.errCd){ 
				alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
			}
		},
	    jsonReader : {
	        total: "total",
	        records: "records",
	        repeatitems: false,
	        cell: "cell",
	        id: "dstCd"
	    },

	    ondblClickRow: function(rowid, iRow, iCol, e) { //1.더블클릭 이벤트( 로우 데이터 가져오기)
	    	if(rowid){ 
   				jQuery('#list').jqGrid('restoreRow',lastsel2);
   				jQuery('#list').jqGrid('editRow',rowid,true);	
   				$("input, select",e.target).focus();   					// 포커스위치 설정
	   			lastsel2=rowid;
   			}
		},
	    onCellSelect: function(rowid, index, contents, event) {//checkbox 선택시만 row선택 
			if("0" != index){ 
				$("#list").jqGrid('setSelection', rowid, false);
			}
			$("#list").jqGrid("saveRow",lastsel2);
		},
		onRightClickRow: function (rowid, iRow, iCol, e) {//우클릭 브라우져메뉴 block
		}
	});
});
//초기 날짜 값
function LoadPage(){
		document.fname.startDate.value = '${date}';
		document.fname.endDate.value = '${date}';
}
//그리드 데이터 생성
function onWorkType()
{
	/* editCheck =$("#list").find("input[type=text], textarea").map(function(){ 
	return $(this).attr("name"); 
	}).get(); 
	if( "" != editCheck){ 
		alert("수정 완료후 생성하세요."); 
	return; 
	}else{ */
		
		$("#list").jqGrid("saveRow",lastsel2);
	
		if(document.fname.inqrGbn.value == ""){
			alert("생성할 증감데이터 구분을 선택해주세요.");
			return;
		}
		var sCondParam = document.fname.inqrGbn.value;						//구분 값
		var startVal = parseInt(document.fname.startVal.value);				//시작 값
		var endVal = parseInt(document.fname.endVal.value);					//종료값
		var step = parseInt(document.fname.step.value);						//간격
		if("amt" == document.fname.inqrGbn.value){							//숫자로 생성할 경우
			if(document.fname.startVal.value == "" || document.fname.endVal.value == ""){
				alert("생성할 증감데이타  범위값을 입력하세요");
				return;
			}
			if(document.fname.step.value == ""){
				alert("간격은 필수 입력사항입니다.");
				return;
			}else{
				if(startVal <= endVal){
					var sv = parseFloat(document.fname.startVal.value); 		//시작값
					var ev = parseFloat(document.fname.endVal.value);			//종료값
					var st = parseFloat(document.fname.step.value); 			//스텝
						
					if(!onChCon(document.fname.startVal.value,"시작값")){return;}
					if(!onChCon(document.fname.endVal.value,"종료값")){return;}
					if(!onChCon(document.fname.step.value,"스텝")){return;}
					if(((ev-sv+1)/st) > 100){ 							//예상결과가 100개가 넘을시에 실행 
						alert("조회되는 내용은 100개가 넘을수 없습니다.");
						return;
					}
					$('#list').setGridParam({
					url: 'msg.incdecdatamng.createlist.do',	
					postData: {
						startVal: sv,
						endVal: ev,
						step: st,
						inqrGbn: sCondParam
					}});
					$('#list').trigger("reloadGrid");
					
				}else if(startVal > endVal){
					alert("시작값은 종료값보다 작아야 합니다. 확인 후 다시 입력해주세요.");
				}
			}
		}
		if("date" == document.fname.inqrGbn.value){									//날짜로 생성할 경우
			var startDate = document.fname.startDate.value;							//시작일
			var endDate = document.fname.endDate.value;								//종료일
			if(document.fname.startDate.value == "" || document.fname.endDate.value == ""){
				alert("생성할 증감데이타  범위 일자를  입력하세요");
				return;
			}else if(startDate > endDate){
				alert("시작날짜는 종료날짜보다 작아야 합니다. 확인 후 다시 입력해주세요.");
			}else{
				par = sCondParam;
				$('#list').setGridParam({
					url:'msg.incdecdatamng.createlist.do',
					postData: {
						inqrGbn: sCondParam,
						startDate: startDate,
						endDate: endDate
					}
				});
				$('#list').trigger("reloadGrid");
			}
		}
	/* } */
}
//입력 숫자 범위 지정
function onChCon(str,inname)
{
	if(str.indexOf(".") < 0){
		if(str.length > 15){
			alert(inname+"의 정수가 15자리를 넘었습니다. 15자리로 입력해 주십시오.");
			return false;
		}
	}else{
		var pr = str.split(".");	
		if(pr.length > 2){
			alert(inname+"은 잘못된 숫자형입니다.");
			return false;
		}
		if(pr[0].length > 14){
			alert(inname+"의 정수가 14자리를 넘었습니다. 14자리로 입력해 주십시오.");
			return false;
		}
		if(pr[1].length > 6){
			alert(inname+"의 소수점이 6자가 넘었습니다.");
			return false;
		}
	}
	return true;
}
function autoResize(i)
{
    var iframeHeight=
    (i).contentWindow.document.body.scrollHeight;
    (i).height=iframeHeight+20;
}
//셀렉한 경우에 따라 보이는 화면
function diva(){
	var str = document.fname.inqrGbn.value;
	if (str == "date"){
		$("#dateView1").hide();
		$("#amtView1").show();
	}else if(str == "amt"){
		$("#dateView1").show();
		$("#amtView1").hide();
	}else{
		$("#dateView1").hide();
		$("#amtView1").hide();
	}
}
//데이터 생성
function onInsertData(str){
	/* editCheck =$("#list").find("input[type=text], textarea").map(function(){ 
	return $(this).attr("name"); 
	}).get(); 

	if( "" != editCheck){ 
		alert("수정완료후 눌러주세요."); 
		return; 
	}else{ */
		
		$("#list").jqGrid("saveRow",lastsel2);
	
		var cklst= jQuery("#list").jqGrid('getGridParam','selarrrow'); //체크된 리스트 
		if(str == 0){													//신규 생성일 경우
			if( cklst != "" ){	
				if( cklst.length > 0 ) { 
					var array = new Array();
					array[0] = "신규";									//부모창에 신규인지 덮어쓰기인지 값 담아주기
					if("amt" == $("#inqrGbn").val()){					//숫자일 경우
						$.each(cklst, function (index1, value) { 		//체크한 값 담아주기
							var ids = $("#list").jqGrid('getDataIDs'); //전체리스트의 id리스트 
							var ret1 = jQuery("#list").getRowData(cklst[index1]);
							var tsdataID = ret1.tsdataID;
							var dstCd1 = ret1.dstCd;
							var idx = 1;
							//순서대로 담아주기 위함
							$.each(cklst, function (index2, value) {
								var ret2 = jQuery("#list").getRowData(cklst[index2]);
								if(parseInt(dstCd1) > parseInt(ret2.dstCd)){
									idx++;
								}
							});
							array[idx] = ret1.resultData; 
						});
					}else if("date" == $("#inqrGbn").val()){			//날짜일 경우
						$.each(cklst, function (index1, value) { 
							var ids = $("#list").jqGrid('getDataIDs'); //전체리스트의 id리스트 
							var ret1 = jQuery("#list").getRowData(cklst[index1]);
							var tsdataID = ret1.tsdataID;
							var dstCd1 = ret1.dstCd;
							var idx = 1;
							$.each(cklst, function (index2, value) {
								var ret2 = jQuery("#list").getRowData(cklst[index2]);
								if(dstCd1 > ret2.dstCd){
									idx++;
								}
							});
							array[idx] = ret1.resultData; 
						});
					}
					window.returnValue = array;
					self.close(); 
				}
			}else{
				alert("선택해주세요.!");
			}
		}else if(str == 1){											//덮어쓰기일 경우
			if('${listCount}'< cklst.length){						//덮을 갯수 체크
				alert("덮어쓸 수 있는 테스트케이스의 숫자인["+'${listCount}' +"]개를 초과 하였습니다.(선택수 : ["+ cklst.length +"])" );
			}else{
				if( cklst != "" ){	
					if( cklst.length > 0 ) { 
						var array = new Array();
						array[0] = "덮어쓰기";
						if("amt" == $("#inqrGbn").val()){	
							$.each(cklst, function (index1, value) { 
								var ids = $("#list").jqGrid('getDataIDs'); //전체리스트의 id리스트 
								var ret1 = jQuery("#list").getRowData(cklst[index1]);
								var tsdataID = ret1.tsdataID;
								var dstCd1 = ret1.dstCd;
								var idx = 1;
								$.each(cklst, function (index2, value) {
									var ret2 = jQuery("#list").getRowData(cklst[index2]);
									if(parseInt(dstCd1) > parseInt(ret2.dstCd)){
										idx++;
									}
								});
								array[idx] = ret1.resultData; 
							});
						}else if("date" == $("#inqrGbn").val()){
							$.each(cklst, function (index1, value) { 
								var ids = $("#list").jqGrid('getDataIDs'); //전체리스트의 id리스트 
								var ret1 = jQuery("#list").getRowData(cklst[index1]);
								var tsdataID = ret1.tsdataID;
								var dstCd1 = ret1.dstCd;
								var idx = 1;
								$.each(cklst, function (index2, value) {
									var ret2 = jQuery("#list").getRowData(cklst[index2]);
									if(dstCd1 > ret2.dstCd){
										idx++;
									}
								});
								array[idx] = ret1.resultData; 
							});
						}
						window.returnValue = array;
						self.close(); 
					}
				}else{
					alert("선택해주세요.!");
				}
			}
		}
	/* } */
}
//창 닫기
function onClose(){
	window.close();
}
//숫자만 입력 가능하게 만들기
var filterInputData = function(filter, e) {
	if (filter) {
		if(e.keyCode) {							
			var sKey = String.fromCharCode(e.keyCode);
			var re = new RegExp(filter);
			if (!re.test(sKey)) {
				e.returnValue = false;
			}
		}else if(e.which) {						//파폭
			var sKey = String.fromCharCode(e.which);
			var re = new RegExp(filter);
			if (!re.test(sKey)) {
				e.preventDefault();
			}
		}
		return false;
	}
};
</script>
</head>
<body leftmargin="0" topmargin="0" onload="LoadPage()">
<form name="fname" method="post" id="fname" > 
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="43"><img src="images/pop_tit_01.gif" width="43" height="51"></td>
    <td background="images/pop_tit_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="pop_tit">증감데이터입력</td>
      </tr>
    </table></td>
    <td width="216"><img src="images/pop_tit_03.gif" width="216" height="51"></td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="3">
  <tr>
    <td valign="top"><table width="100%" height="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#baccdc">
      <tr>
        <td bgcolor="#e1e9f0"><table width="100%" height="100%" border="0" cellpadding="5" cellspacing="0">
          <tr>
            <td valign="top" bgcolor="#FFFFFF"><table width="100%" border="0" cellpadding="5" cellspacing="1"  bgcolor="#baccdc">
              <tr>
                <td bgcolor="#e1e9f0"><table width="100%" border="0" cellspacing="0" cellpadding="5">
                    <tr>
                      <td bgcolor="#FFFFFF">
                      	<table width="100%" border="0" cellpadding="2" cellspacing="0">
                          <tr>
                            <td width="50" class="box_txt_red">선 택 :</td>
                            <td>
                            	<select name="inqrGbn" id ="inqrGbn" class="menu" style="width:130" onChange="diva();">
                                <option value="">== 선 택 ==</option>
                                <option value="amt">숫자</option>
                                <option value="date">일자</option>
                            	</select>
                            </td>
                            <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                              <tr>
                                <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                                <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="onWorkType();" >생 성<br></td>
                                <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                              </tr>
                            </table></td>
                          </tr>
                        </table>
                          <table width="100%" border="0" cellpadding="0" cellspacing="0">
                            <tr id="dateView1" style="display:none">
                              <td width="55" class="box_txt_red">시작값 :</td>
                              <td width="90"><input name="startVal" id="startVal" type="text" class="input_topinq" style="width:70px; ime-mode:disabled;" onkeypress="filterInputData('[0-9]',event);"></td>
                              <td width="55" class="box_txt_red">종료값 :</td>
                              <td width="90"><input name="endVal" id="endVal" type="text" class="input_topinq" style="width:70px; ime-mode:disabled;" onkeypress="filterInputData('[0-9]',event);"></td>
                              <td width="45" class="box_txt_red">간 격 :</td>
                              <td><input name="step" id="step" type="text" class="input_topinq" style="width:70px; ime-mode:disabled;" onkeypress="filterInputData('[0-9]',event);"></td>
                            </tr>
                            <tr id="amtView1" style="display:none">
                              <td width="55" class="box_txt_red">시작일 :</td>
                              <td width="167"><input id="startDate" name="startDate" type="text" class="input_topinq" style="width:110px;" value="" readonly="readonly"/>
                                  <img src="images/un_sub_cen_cal.gif" width="23" height="21" align="absmiddle" hspace="4" style="cursor:pointer" onclick="popUpCalendar(this, 'startDate', 'yyyy-mm-dd','CENTER','MIDDLE');"></td>
                              <td width="55" class="box_txt_red">종료일 :</td>
                              <td><input id="endDate" name="endDate" type="text" class="input_topinq" style="width:110px" value="" readonly="readonly" />
                                <img src="images/un_sub_cen_cal.gif" width="23" height="21" align="absmiddle" hspace="4" style="cursor:pointer" onclick="popUpCalendar(this, 'endDate', 'yyyy-mm-dd','CENTER','MIDDLE');"></td>
                            </tr>
                          </table>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0">
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
              </table>
              <table width="100%" height="100" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                <tr>
					<td height="350" valign="top" bgcolor="#FFFFFF">
						<table id="list"></table> 
					</td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="5" colspan="3"></td>
                </tr>
                <tr>
                  <td><table border="0" align="left" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                        <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="onInsertData(0); return false;" >신규생성</td>
                        <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                      </tr>
                  </table>
                    <table border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                        <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="onInsertData(1); return false;">덮어쓰기</td>
                        <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                      </tr>
                    </table></td>
                  <td ><table align="right" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                          <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="onClose(); return false;">닫 기</td>
                          <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                        </tr>
                      </table>
                    </td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
<!-- Start of wrap -->
</body>

</html>