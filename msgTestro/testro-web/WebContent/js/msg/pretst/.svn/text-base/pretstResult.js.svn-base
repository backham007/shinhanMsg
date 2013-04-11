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
//-->

// iframe resize
function autoResize(i)
{
var iframeHeight=
(i).contentWindow.document.body.scrollHeight;
(i).height=iframeHeight+20;
}

$(document).ready(function(){
	doSearch("view1");
	doSearch2("view1");
});


var maxWidth= 1100; //전체사이즈
var leftTemp = 230; //left메뉴사이즈
function bodyreload(){
	var hidenYn = $("body").attr("hideYn");
	if("Y" == hidenYn){ //left 메뉴 hidden
		leftTemp=40;
	}else{ //left 메뉴 show
		leftTemp=230;
	}
	$(window).trigger('resize');
}

function doSearch(str){
	var idx = str.substring(4,5); //버튼순서	  	
	document.pretstResult.tabGb.value = str;  
  
	//버튼바꾸기
	for(i = 0; i < 3; i++){   
		if(parseInt(idx) == i){
			$("#view"+i+"_on").show();
			$("#view"+i+"_off").hide();
			$("#inputDiv"+i).show();
		}else{   
			$("#view"+i+"_on").hide();
			$("#view"+i+"_off").show();
			$("#inputDiv"+i).hide();
			
		}
	}
}


function doSearch2(str){
	var idx = str.substring(4,5); //버튼순서	  	
	document.pretstResult.tabGb2.value = str;  
  
	//버튼바꾸기
	for(i = 0; i < 3; i++){   
		if(parseInt(idx) == i){
			$("#view"+i+"_on2").show();
			$("#view"+i+"_off2").hide();
			$("#outDiv"+i).show();
		
		}else{   
			$("#view"+i+"_on2").hide();
			$("#view"+i+"_off2").show();
			$("#outDiv"+i).hide();
		
		}
	}
}
function back(){
	history.go(-1);

}

function excuteSave(){
	var frm = document.pretstResult;
	var rsultSucssYn =$("#rsultSucssYn").val();
	$.cookie('left_menu', "leftmenu_1_4");
	
	if(rsultSucssYn == "Y"){ //거래성공한 경우
		if(frm.tsdataName.value=="") {
			
			alert("테스트케이스명은 필수 입력사항입니다.");
			frm.tsdataName.value="";
			frm.tsdataName.focus();
			return;
		}
		frm.action="msg.pretst.excuteTcMng.do";
		frm.submit();
	}else{    //거래 실패한 경우
		
		
			if(frm.tsdataName.value=="") {
				alert("테스트케이스명은 필수 입력사항입니다.");
				frm.tsdataName.value="";
				frm.tsdataName.focus();
				return;
			}
			var chkYn = confirm("거래테스트의 실행에 실패하였습니다.\n\n입력데이터를 테스트케이스로  활용하시겠습니까?");
				if(chkYn == true){
					frm.action="msg.pretst.excuteTcMng.do";
					frm.submit();
				}else{
				return;
			}
	}
}
