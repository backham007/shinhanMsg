<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
// iframe resize
var opener = window.dialogArguments;
var EngAutoDataHeader = $.parseJSON(opener.document.frmname.EngAutoDataHeader.value);		//영문명
var KorAutoDataHeader = $.parseJSON(opener.document.frmname.KorAutoDataHeader.value);		//한글명
var EngAutoDataHeaderKey = $.parseJSON(opener.document.frmname.EngAutoDataHeaderKey.value);	//영문 실제 키값
var autoMaxLength = $.parseJSON(opener.document.frmname.autoMaxLength.value);				//최대값(maxLength)
var gridCnt = $.parseJSON(opener.document.frmname.gridCnt.value);							//부모창 그리드 갯수

function autoResize(i)
{
    var iframeHeight=
    (i).contentWindow.document.body.scrollHeight;
    (i).height=iframeHeight+20;
}

$(document).ready(function() {
	var maxWidth= 663;
	$(window).bind('resize', function() {
		var windwoWindth = $(window).width()-230;
		if (windwoWindth > maxWidth) {
			$("#list1").setGridWidth(windwoWindth, true);
		} else {
			jQuery("#list1").jqGrid('gridResize',{minWidth:maxWidth ,maxWidth:'100%'});
			$("#list1").setGridWidth(windwoWindth, false);
		}
			
	}).trigger('resize');
	jQuery("#list").jqGrid( {
		mtype:'POST',    // 한글 인코딩 깨지는 문제 방지하기 위해 POST로 쓴다
		datatype : "json",
		colNames : [ '순번', '영문key', '영문명', '한글명', '맥스값' ],
		colModel : [ 
			{name : 'projNo',index : 'PROJNO',width : 30,align : "center",frozen : true, key:true,sortable:false}, 
			{name : 'engNameKey',index : 'ENGNAMEKEY',width : 200,align : "left",sortable:false, hidden:true}, 
			{name : 'engName',index : 'ENGNAME',width : 200,align : "left",sortable:false}, 
			{name : 'korName',	index : 'KORNAME',	width : 200,align : "left",sortable:false}, 
			{name : 'autoMaxLength', index : 'AUTOMAXLENGTH', width : 100,align : "left",sortable:false, hidden:true}
		],	
		height:350, // 높이
		width:'100%',
		gridview: true,
		rowNum : 100,
		viewrecords : true,
		multiselect: true,
		autowidth: true,
		loadComplete : function(xhr) {
			if (xhr.errCd){ 
				alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
			}
		},
		jsonReader : {
			root : "rows",
			page : "page",
			total : "total",
			records : "records",
			repeatitems : false,
			cell : "cell",
			id : "ProjNo"
		},
	    onCellSelect: function(rowid, index, contents, event) {//checkbox 선택시만 row선택 
			if("0" != index){ 
				$("#list").jqGrid('setSelection', rowid, false); 
			} 
		},
		onRightClickRow: function (rowid, iRow, iCol, e) { 
   		}
	});
	rowAdd();
});
//부모창에서 보내준 값을 그리드에 뿌려주기
function rowAdd(){
	var listNumber = 1;										//순번 초기값
	for(var i = 0; i < KorAutoDataHeader.length; i++){
		if(KorAutoDataHeader[i]!= null){
			var listName  = {
					projNo: listNumber,						//순번
					engNameKey:EngAutoDataHeaderKey[i],		//영문 키값(실제 name명)
					engName: EngAutoDataHeader[i],			//영문명
					korName: KorAutoDataHeader[i],			//한글명
					autoMaxLength: autoMaxLength[i]			//맥스값
			};	
			$("#list").jqGrid('addRowData',listNumber,listName);
			listNumber++;
		}
	}
	var row = jQuery("#list").getRowData();
	$('#totalCount').text("[총 "+row.length+" 건]");
}
//체크된 리스트 값을 데이터 자동입력으로 넘기기
function doInputList(){
	var cklst= jQuery("#list").jqGrid('getGridParam','selarrrow'); //체크된 리스트 
	if( cklst != "" ){
		if( cklst.length > 0 ) { 
			
			$('#EngAutoDataHeader').val(JSON.stringify(EngAutoDataHeader));		//영문명
			$('#KorAutoDataHeader').val(JSON.stringify(KorAutoDataHeader));		//한글명
			$('#gridCnt').val(JSON.stringify(gridCnt));							//부모창에 그리드 갯수
			
			var array1 = new Array();											//영문명 담기
			var array2 = new Array();											//한글명 담기
			var array3 = new Array();											//그리드 갯수 담기
			var totalarray = new Array();										//3개 total로 담기
			
			//체크된 행의 rowid를 순서대로 정렬한다
			for(var i = 0 ; i < cklst.length ; i++){
				for(var j = i+1 ; j < cklst.length ; j++){
					if(parseInt(cklst[i]) > parseInt(cklst[j])){
						var temp = cklst[i];
						cklst[i] = cklst[j];
						cklst[j] = temp;
					}
				}
		    }
			
			//체크된 리스트 넘기기
			$.each(cklst, function (index1, value) { 
				var ret1 = jQuery("#list").getRowData(cklst[index1]);
				
				array1.push(ret1.korName);	//한글명
				array2.push(ret1.engNameKey);	//영문명
				array3.push(ret1.autoMaxLength);	//MaxLength값
			});
			
			//totalarray에 체크한 영문명, 한글명, 최대값 담기
			totalarray[0] = array1;				
			totalarray[1] = array2;
			totalarray[2] = array3;

			window.returnValue = totalarray;
			self.close(); 
		}
	}else{
		alert("선택해주세요.!");
	}
}
//창 닫기
function doClose(){
	window.close();
}
</script>
</head>

<body leftmargin="0" topmargin="0">
<form name="frmname" method="post">
<input type="hidden" name="gridCnt" id="gridCnt" value="" />
<input type="hidden" name="EngAutoDataHeader" id="EngAutoDataHeader" value="" />
<input type="hidden" name="KorAutoDataHeader" id="KorAutoDataHeader" value="" />
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="43"><img src="images/pop_tit_01.gif" width="43" height="51"></td>
    <td background="images/pop_tit_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="pop_tit">항목 지정</td>
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
            <td valign="top" bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td class="sub_tit02"> 입력항목</td>
                <td id="totalCount" align="right" class="point_result"></td>
              </tr>
            </table>
              <table width="100%" height="100" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                <tr>
                  <td height=320 valign="top" bgcolor="#FFFFFF">
                  	<table id="list"></table>
                  </td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="5" colspan="3"></td>
                </tr>
                <tr>
                  <td><table align="left" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                      <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="doInputList(); return false;" >확 인</td>
                      <td width="10" background="images/btn_img_03.gif">&nbsp;</td>
                    </tr>
                  </table></td>
                  <td ><table align="right" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                          <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer" onclick="doClose(); return false;" >닫 기</td>
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