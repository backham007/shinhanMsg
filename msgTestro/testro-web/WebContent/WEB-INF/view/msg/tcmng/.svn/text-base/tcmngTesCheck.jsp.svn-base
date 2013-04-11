<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>전문 테스트로(TESTRO)</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<script type="text/javascript" src="js/cmn/utils/json2.js" charset="utf-8"></script>
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="jqgrid/css/ui-lightness/jquery-ui-1.7.3.custom.css" media="screen" />
<link rel="stylesheet" type="text/css" href="jqgrid/js/src/css/ui.jqgrid.css" media="screen" />
<link rel="shortcut icon" href="images/TESTRO.ico" type="image/ico" />
<style>
html, body {
    margin: 0;
    padding: 0;
    font-size: 75%;
}
</style>
<script type="text/javascript" src="js/cmn/common.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/jquery-1.5.2.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cmn/jquery.blockUI.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/src/i18n/grid.locale-en.js" charset="utf-8"></script>
<script type="text/javascript" src="jqgrid/js/jquery.jqGrid.src.js" charset="utf-8"></script>

<c:set var="colNames" value="" />
<c:set var="colModel" value="" />
<c:set var="widthSize" value="0" />


<!-- 그리드 그리기 -->

<script type="text/javascript">
var opener = window.dialogArguments;
//테스트케이스 목록
	var lastsel2;
	
	
$(document).ready(function(){
	var gridParam = {
	
		mtype:'POST',    // 한글 인코딩 깨지는 문제 방지하기 위해 POST로 쓴다
		async : true,
		datatype: "local",
	    colNames:[
	              "선택", 
	              "사용자필드명", 
	              "기대값",
	              "fldDiv",
	              "tsDataFldName",
		],
	    colModel:[
			{name: 'chkYN',index: 'chkYN', width:25, align:"center", hidden:true},
			{name: 'tsdataFld',index: 'tsdataFld', width:210, sortable:false, align:"left", editable:false},
			{name: 'chkPointExpcCtnt',index: 'chkPointExpcCtnt', width:210, sortable:false, align:"left", editable:true, editoptions:{maxlength:"300"}},
			{name: 'tscsFldDiv',index: 'tscsFldDiv', width:210, align:"center", hidden:true},
			{name: 'tsdataFldName',index: 'tsdataFldName', width:210, align:"center", hidden:true}
			
	    ],
	    editurl		: 'clientArray',
	    viewrecords	: true,
	    height		: 433,
	    multiselect: true, //멀티셀렉트 설정
	    loadComplete: function(xhr) {
		 if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);

		},

	       afterInsertRow : function(rowid, rowdata, rowelem) {      	//chkYN ==Y 면 체크
	    	   var ret = $("#list").jqGrid("getRowData" ,rowid);
		        if(ret.chkYN == "Y"){
		        	$("#jqg_list_"+rowid).attr("checked","checked");
		        	$("#list").jqGrid('setSelection', rowid, false); 
		        }
                 
         },
         onCellSelect: function(rowid, index, contents, event) {		//checkbox 선택시만 row선택 
       		if("0" != index){ 
        		$("#list").jqGrid('setSelection', rowid, false); 
       		} 
        		$("#list").jqGrid("saveRow",lastsel2);					//저장
       	},
       	ondblClickRow: function (rowid, iRow, iCol, e) { 				//더블클릭 이벤트
   			if("0" != iCol){
   				
   		    	jQuery('#list').jqGrid('editRow',rowid,true); 
   		    	$("input, select",e.target).focus();   					// 포커스위치 설정
   		    	lastsel2=rowid; 
   			}
   		}
	};

	jQuery("#list").jqGrid(gridParam);
	jQuery("#list").setGridWidth(603,true); 	//가로스크롤

	$(".ui-jqgrid-sortable").css('height','auto');
	$.ajax({
        type: "POST"
        , data: {
			chnlDstcd: $('#chnlDstcd', opener.document).val()
            , tranCd: $('#tranCd', opener.document).val()
            , tsdataID: $('#tsdataID', opener.document).val()
            , chkYNVal: $('#chkYNVal', opener.document).val()
        }
        , dataType: "json"
        , url: "msg.tcmng.getListTesCheck.do"
        , success:function(data, status) {
        	if (data.errCd){ alert('에러코드 : ' + data.errCd + "\n에러메시지 : " + data.errMsg);
        	}else{
        		  var addData = data.checkPointDTOs;
                  $.each(addData, function(index, value){
                  	jQuery("#list").addRowData(index, value);
                  });
        	}
        }
        , error:function(request, status, error) {
        	 alert("불러 오는중 오류가 발생하였습니다.[" + error + "]"); 
             
        }
    });
});



function getTesCheck(){
	$("#list").jqGrid("saveRow",lastsel2);    //적용시 저장하고 적용
	var editCheck = ""; 
    editCheck =$("#list").find("input[type=radio]:checked, input[type=text], textarea, select").map(function(){ 
    return $(this).attr("name"); 
    }).get(); 
    
    if( "" != editCheck){ 
	    alert("수정완료후 저장하세요."); 
	    return; 
    } 
	
    var ids = $("#list").jqGrid("getDataIDs");//rowid배열 
    //var cklst = jQuery("#list").jqGrid('getGridParam','selarrrow'); //체크된 리스트 
    
    $.each(ids, function (index, value) {
	//var ret = $("#list").jqGrid("getRowData" ,ids[index]);
		  var chk=$("#jqg_list_"+ids[index]).attr("checked");
		  if(chk){
		 		jQuery("#list").jqGrid('setCell', ids[index], "chkYN", "Y");   //체크가 되어 있을 경우 chkYN 값 Y 셋팅
				}else{
				jQuery("#list").jqGrid('setCell', ids[index], "chkYN", "N");  //체크가 되어 있지 않을 경우 chkYN 값 N 셋팅
		 	}
	   });

    
    var gridData		= jQuery("#list").jqGrid('getRowData'); 
    var chkYNVal 		= JSON.stringify(gridData); 
   	window.returnValue 	= chkYNVal;
   	self.close(); 
} 
</script>
</head>

<body leftmargin="0" topmargin="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="43"><img src="images/pop_tit_01.gif" width="43" height="51"></td>
    <td background="images/pop_tit_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="pop_tit">체크포인트 지정</td>
     
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
            <td valign="top" bgcolor="#FFFFFF"><table width="100%" height="100" border="0" cellpadding="2" cellspacing="1" bgcolor="#baccdc">
                <tr>
                  <td height="461" valign="top" bgcolor="#FFFFFF"><table id="list"></table> </td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="1">
                <tr>
                  <td height="5" colspan="3">
                   
                  </td>
                </tr>
                <tr>
                  <td><table align="left" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                      <td background="images/btn_img_02.gif" class="btn_text" style="cursor:pointer;" onclick="javascript:getTesCheck();">적 용</td>
                      <td width="10" background="images/btn_img_03.gif"></td>
                     
                    </tr>
                  </table></td>
                   <td ><table align="center" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                    <td valign="middle" class="input_result"> 체크포인터는 출력데이터와 기대값을 비교합니다.</td>
                    </tr>
                   </table>
                   </td>
                  <td ><table align="right" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                        
                          <td width="16" height="21" background="images/btn_img_01.gif">&nbsp;</td>
                          <td background="images/btn_img_02.gif" class="btn_text" onclick="javascript:self.close();" style="cursor:pointer;">닫 기</td>
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
<!-- Start of wrap -->
</body>

</html>