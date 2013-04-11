function MM_swapImgRestore() { //v3.0
var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
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
function MM_openBrWindow(theURL,winName,features) { //v2.0
window.open(theURL,winName,features);
}

// iframe resize
function autoResize(i)
{
var iframeHeight=
(i).contentWindow.document.body.scrollHeight;
(i).height=iframeHeight+20;
}
var maxWidth= 1100;
var leftTemp = 230;
var windowHeight = 0;
$(document).ready(function(){
	
	

	$(window).bind('resize', function() {
		var windwoWindth = $(window).width()-leftTemp;
		if (windwoWindth > maxWidth) {
			$("#list1").setGridWidth(windwoWindth, true);
		} else {
			jQuery("#list1").jqGrid('gridResize',{minWidth:maxWidth ,maxWidth:'100%'});
			$("#list1").setGridWidth(windwoWindth, false);
		}
		
        //-------- 그리드 hight ------------------------------
		windowHeight = $(window).height()-379;           // 마이너스값 수정. 
		$("#list1").setGridHeight(windowHeight, true);         
        //---------------------------------------------------
	}).trigger('resize');
	var colNames1 = ['테스트케이스ID'
	                             ,'수행회차'
	                             ,'실행서버'
	                             ,'테스트케이스명'
	                             ,'프로젝트명'
	                             ,'단계구분'
	                             ,'테스트시작일시'
	                             ,'테스트종료일시'
	                             ,'실행결과'
	                             ,'성공건수'
	                             ,'실패건수'
	                             ,'테스터ID'
	                             ,'테스터명'
	                ];
    var colModel1 = [
 					{name: 'tscaseid'        ,index: 'tscaseid'         ,width:140 ,  align:'center'},
					{name: 'acmplnth'        ,index: 'acmplnth'         ,width:70 ,  align:'center'},
					{name: 'connsevrdstcdnm' ,index: 'connsevrdstcdnm'  ,width:90 ,  align:'center'},
					{name: 'tscasename'      ,index: 'tscasename'       ,width:200 ,  align:'left'},
					{name: 'projname'        ,index: 'projname'         ,width:200 ,  align:'left'},
					{name: 'teststgename'    ,index: 'teststgename'     ,width:70 ,  align:'center'},
					{name: 'teststartyms'    ,index: 'teststartyms'     ,width:140 ,  align:'center',formatter:gridDateFmatter, formatoptions: {srcformat:'yMdhms', newformat:'y-M-d h:m:s'}},
					{name: 'testendyms'      ,index: 'testendyms'       ,width:140 ,  align:'center',formatter:gridDateFmatter, formatoptions: {srcformat:'yMdhms', newformat:'y-M-d h:m:s'}},
					{name: 'rsultsucssyn'    ,index: 'rsultsucssyn'     ,width:70 ,  align:'center'},
					{name: 'successcnt'      ,index: 'successcnt'       ,width:70 ,  align:'center'},
					{name: 'failcnt'         ,index: 'failcnt'          ,width:70 ,  align:'center'},
					{name: 'writeid'         ,index: 'writeid'          ,width:70 ,  align:'center'},
					{name: 'writename'       ,index: 'writename'        ,width:70 ,  align:'center'}
	  				];
	var colNames2 = [
						"테스트시나리오ID"
						,"수행회차"
						,"실행서버"
						,"테스트시나리오명"
						,"프로젝트명"
						,"테스트시작일시"
						,"테스트종료일시"
						,"실행결과"
						,"성공건수"
						,"실패건수"
						,"테스터ID"
						,"테스터명"
					];
	var colModel2 = [
					{name: 'tssnrioid'    ,index: 'tssnrioid'    ,width:140 , align: 'center'},
					{name: 'acmplnth'     ,index: 'acmplnth'     ,width:70 , align: 'center'},
					{name: 'connsevrdstcd',index: 'connsevrdstcd',width:90 , align: 'center'},
					{name: 'tssnrioname'  ,index: 'tssnrioname'  ,width:200 , align: 'left'},
					{name: 'projname'     ,index: 'projname'     ,width:200 , align: 'left'},
					{name: 'teststartyms' ,index: 'teststartyms' ,width:140 , align: 'center',formatter:gridDateFmatter, formatoptions: {srcformat:'yMdhms', newformat:'y-M-d h:m:s'}},
					{name: 'testendyms'   ,index: 'testendyms'   ,width:140 , align: 'center',formatter:gridDateFmatter, formatoptions: {srcformat:'yMdhms', newformat:'y-M-d h:m:s'}},
					{name: 'rsultsucssyn' ,index: 'rsultsucssyn' ,width:70 , align: 'center'},
					{name: 'successcnt'   ,index: 'successcnt'   ,width:70 , align: 'center'},
					{name: 'failcnt'      ,index: 'failcnt'      ,width:70 , align: 'center'},
					{name: 'writeid'      ,index: 'writeid'      ,width:70 , align: 'center'},
					{name: 'writename'    ,index: 'writename'    ,width:70 , align: 'center'}
					];
	
	$("#tesdiv").bind('change',function() { //조회구분 선택시 조회구분 select 변경 이벤트
		tesdiv();
	});
	
	$("#prt_srch").click(function(){ //프로젝트 조회
		//프로젝트조회 팝업
	    var url = "msg.cmn.projPop.do";
	    var returnValue = window.showModalDialog(url,window,'center:yes;dialogWidth=950px; dialogHeight=570px; scroll=no; status=no; help=no; resizable:no; ');
    	//프로젝트조회후 선택된 값이 있을경우
	    if(returnValue != null){
	    	$("#projNo").val(returnValue[0]);	//프로젝트번호
	    	$("#projName").val(returnValue[1]);	//프로젝트명
	    	getTestInfo(returnValue[0]);
	    }
	});
	
	$("#img_eraser").click(function(){ //실행자 id/명 삭제
		$("#writename").val("");
	});
	
	$("#tesdiv_sub").change(function() { //조회구분 select box change event
		var tesdiv_sub_val= $(this).val();
		
		if( "00" == tesdiv_sub_val){//00:선택 텍스트 비활성화
			$("#tesdiv_sub_text").val("");
			$("#tesdiv_sub_text").attr('disabled', true);
		}else{
			$("#tesdiv_sub_text").attr('disabled', false);
		}
	});
	

	$("#rpt_srch").click(function(){ //조회
		srch();
	});

	$("#testendyms_eraser").click(function(){ //달력삭제
		$("#teststartyms").val("");
		$("#testendyms").val("");
	});
	
	$("#emp_button").click(function(){
	    var url = "msg.report.empSrchpop.do";
	    var returnValue = window.showModalDialog(url,window,'center:yes;dialogWidth=683px; dialogHeight=577px; scroll=no; status=no; help=no; resizable:no; ');
	    if( null != returnValue){
	    	alert("id:"+returnValue[0]+"name:"+returnValue[1]);
	    }
	});
	
	function tesdiv(){
		var tesdiv_val= $("#tesdiv").val();
		$("#tesdiv_sub").empty();
		if( "01" == tesdiv_val){//케이스
			getListMngCode('tesdiv_sub','TC1DIV','00');//테스트케이스
		}else if( "02" == tesdiv_val){//시나리오
			getListMngCode('tesdiv_sub','TS1DIV','00');//테스트시나리오		
		}
		
		var colname;
		var colmodel;
		var sortname;
		if( "01" == tesdiv_val){//케이스
			colname = colNames1;
			colmodel = colModel1;
			sortname = "tscaseid";
		}else if( "02" == tesdiv_val){//시나리오
			colname = colNames2;
			colmodel = colModel2;
			sortname = "tssnrioid";
		}
		//$(window).trigger('resize');
		$("#list1").jqGrid('GridUnload');
		$("#list1").jqGrid({
			mtype:'POST',
		   	colNames: colname,
		   	colModel: colmodel,
			datatype: "json",
		    rownumbers: true,
		   	rowNum:10,
		   	//height:435,
		   	sortname: 'testendyms',
		   	pager: '#pager1',
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
		    onRightClickRow: function (rowid, iRow, iCol, e) {//우클릭 브라우져메뉴 block
		    }


		}); 
		$(window).trigger('resize');
	}
	
	function getTestInfo(returnValue){
    	
    	//프로젝트조회후 테스트단계 select box 조회
    	if(returnValue != ''){
	    	$.ajax({
				type : "POST",
				async : true,
				url : "msg.cmn.getListTestStgeName.do",
				data:{"projNo":returnValue},
				success: function(data){
					//테스트단계명 select box 데이터삭제
					$("#testStgeName option:gt(0)").remove();
					//테스트단계명 추가
					for(var i = 0 ; i < data.list.length ; i++){
						$("#testStgeName").append("<option value='"+data.list[i].testStgeName+"'>"+data.list[i].testStgeName+"</option>");
					}
				}
			});
    	}
	}
	
	
	function srch(){
		//조회구분(케이스,시나리오)
		var tesdiv = $("#tesdiv").val();
		var testStgeName    = $("#testStgeName").val();                    //테스트단계
		var tesdiv_sub      = $("#tesdiv_sub").val();                      //조회구분
		var tesdiv_sub_text = $("#tesdiv_sub_text").val();                 //조회구분text
		var writename       = $("#writename").val();                       //실행자id/명
		var projNo          = $("#projNo").val();                          //프로젝트번호
		var projName        = $("#projName").val();                        //프로젝트명
		var connSevrDstcd   = $("#connSevrDstcd").val();                   //실행서버
		var teststartyms    = $("#teststartyms").val().split("-").join("");//조회기간시작
		var testendyms      = $("#testendyms").val().split("-").join("");  //조회기간종료
		var exresult        = $("#exresult").val();                        //실행결과
		
		if("00" == tesdiv){
			alert("조회구분을 선택하세요.");
			return;
		}
		//$("#tesdiv").trigger("change");
		if("" != tesdiv_sub_text){
			
			if("01" == tesdiv){ //케이스
				if("01" == tesdiv_sub){//테스트케이스명
					if(tesdiv_sub_text.length >150){
						alert('테스트케이스명은 150자리까지 입력가능합니다.');
						$("#tesdiv_sub_text").focus();
						return;
					}
				}else if("02" == tesdiv_sub){//테스트케이스id
					if(tesdiv_sub_text.length >20){
						alert('테스트케이스id는 20자리까지 입력가능합니다.');
						$("#tesdiv_sub_text").focus();
						return;
					}					
				}else if("03" == tesdiv_sub){//거래코드
					if(tesdiv_sub_text.length >30){
						alert('거래코드는 30자리까지 입력가능합니다.');
						$("#tesdiv_sub_text").focus();
						return;
					}									
				}
			}
			
			if("02" == tesdiv){ //시나리오
				
				if("01" == tesdiv_sub){//시나리오명
					if(tesdiv_sub_text.length >100){
						alert('시나리오명은 100자리까지 입력가능합니다.');
						$("#tesdiv_sub_text").focus();
						return;
					}												
				}else if("02" == tesdiv_sub){//테스트시나리오id
					if(tesdiv_sub_text.length >20){
						alert('테스트시나리오id는 20자리까지 입력가능합니다.');
						$("#tesdiv_sub_text").focus();
						return;
					}										
				}
			}			
		}
		
		if( ( teststartyms.length > 0 )||( testendyms.length > 0 )){
			if( teststartyms.length < 8 ){
				alert('조회기간 시작일을 입력하세요');
				return;
			}
			if( testendyms.length < 8 ){
				alert('조회기간 종료일을 입력하세요');
				return;
			}
			if( teststartyms > testendyms){
				alert('시작일은 종료일보다 클수 없습니다.');
				return;				
			}
		}
		
		
		
		var param = "?tesdiv="+tesdiv
				    +"&testStgeName="+testStgeName   
			   		+"&tesdiv_sub="+tesdiv_sub     
			   		+"&tesdiv_sub_text="+tesdiv_sub_text
			   		+"&writename="+writename      
			   		+"&projNo="+projNo         
			   		+"&projName="+projName       
			   		+"&connSevrDstcd="+connSevrDstcd  
			   		+"&teststartyms="+teststartyms   
			   		+"&testendyms="+testendyms     
			   		+"&exresult="+exresult;
		
		var colname;
		var colmodel;
		var sortname;
		if( "01" == tesdiv){//케이스
			colname = colNames1;
			colmodel = colModel1;
			sortname = "tscaseid";
		}else if( "02" == tesdiv){//시나리오
			colname = colNames2;
			colmodel = colModel2;
			sortname = "tssnrioid";
		}

		$("#list1").jqGrid('GridUnload');
		$("#list1").jqGrid({
			url:'msg.report.resultReportSearch.do',
			postData: {
				tesdiv          :tesdiv         ,
				testStgeName    :testStgeName   ,
				tesdiv_sub      :tesdiv_sub     ,
				tesdiv_sub_text :tesdiv_sub_text,
				writename       :writename      ,
				projNo          :projNo         ,
				projName        :projName       ,
				connSevrDstcd   :connSevrDstcd  ,
				teststartyms    :teststartyms   ,
				testendyms      :testendyms     ,
				exresult        :exresult},
			mtype:'POST',
		   	colNames: colname,
		   	colModel: colmodel,
			datatype: "json",
		    rownumbers: true,
		   	rowNum:30,
	    	rowList:[20,30,50], 
		   	sortname: 'testendyms',
		   	pager: '#pager1',
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
		    onRightClickRow: function (rowid, iRow, iCol, e) {//우클릭 브라우져메뉴 block
		    },
		    ondblClickRow: function (rowid) { //더블클릭 이벤트
		    	var temp = jQuery("#list1").getRowData(rowid);
		    	var param="";
		    	
				if( "01" == tesdiv){//케이스
					param ="tscaseid="+temp.tscaseid+"&acmplnth="+temp.acmplnth+"&gubun="+tesdiv;
				}else if( "02" == tesdiv){//시나리오
					param ="tssnrioid="+temp.tssnrioid+"&acmplnth="+temp.acmplnth+"&gubun="+tesdiv;
				}
                
				//	파라미터
				//	gubun - 01:케이스 02:시나리오
				//	tscaseid - 케이스ID
				//	tssnrioid - 시나리오ID
				//	acmplnth - 수행회차

			    var url = "msg.report.reportDetail.do?";
			    window.open(url+param,'결과상세보고서','location=no,resizable=no,status=yes,width=980,height=770');
			    
	        },
	        afterInsertRow : function(rowid, rowdata, rowelem) {
	        	if("성공" == rowdata.rsultsucssyn){
	        		$("#list1").setCellHtml(rowid,'rsultsucssyn',"<IMG src='images/icon_rep_ok.gif' width=34 height=16 hspace='2' vspace='3' align='absmiddle' border=0 style='cursor:pointer;'>",{});
	        	}else if("실패" == rowdata.rsultsucssyn){
	        		$("#list1").setCellHtml(rowid,'rsultsucssyn',"<IMG src='images/icon_rep_fail.gif' width=34 height=16 hspace='2' vspace='3' align='absmiddle' border=0 style='cursor:pointer;'>",{});
	        	}
	                 
	         },
	         loadComplete: function(xhr){
	             if (xhr.errCd) alert('에러코드 : ' + xhr.errCd + "\n에러메시지 : " + xhr.errMsg);
	             $("#list1").setGridHeight(windowHeight-1, true);
	         }

		}); 
		
		$(window).trigger('resize');
		$('#list1').trigger("reloadGrid");	
	}

	function init_option(){
		getListMngCode('tesdiv','TESDIV','01');//조회구분
		getListMngCode('exresult','EXRESULT','00');//실행결과
		tesdiv();
		getTestInfo($("#projNo").val());
		srch();
	}
	init_option();
	$("input,select").keydown(function(e){
	   	if(e.keyCode == 13){
	   		srch();
	   	}
	});
});

function bodyreload(){//그리드 리사이즈
	var hidenYn = $("body").attr("hideYn");
	if("Y" == hidenYn){ //left 메뉴 hidden
		leftTemp=55;
	}else{ //left 메뉴 show
		leftTemp=230;
	}
	$(window).trigger('resize');
}