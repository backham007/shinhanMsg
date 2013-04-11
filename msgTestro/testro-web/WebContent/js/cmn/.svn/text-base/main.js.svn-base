/*
 * 1.메뉴가이드
 * 구성 : topMenu.jsp,leftMenu.jsp, main.js
 * topMenu : top_menu_area안에 id(top_menu_01~06)로 구성됨
 * leftMenu : left_menu_area 안에 테이블(left01_tb~06)로 그룹되어 있음 탑메뉴number와 맞춤
 * 테이블안에leftmenu_1_1~leftmenu_6_1 구성됨
 * ex) leftmenu_테이블그룹_순번
 * */

function menu_load(top_menu, left_menu){
	
	if(top_menu){
		$("#top_menu_area").find("img").map(function() {
			$(this).attr('src',$(this).attr("src").replace('02.jpg','01.jpg'));
		});
		$("#"+top_menu).attr('src',$("#"+top_menu).attr("src").replace('01.jpg','02.jpg'));
		
		var left_menu_id = "";
		if("top_menu_01" == top_menu){
			left_menu_id = "left01_tb";	
		}else if("top_menu_02" == top_menu){
			left_menu_id = "left02_tb";
		}else if("top_menu_03" == top_menu){
			left_menu_id = "left03_tb";
		}else if("top_menu_04" == top_menu){
			left_menu_id = "left04_tb";
		}else if("top_menu_05" == top_menu){
			left_menu_id = "left05_tb";
		}else if("top_menu_06" == top_menu){
			left_menu_id = "left06_tb";
		}
		
		
		$("#left_menu_area").find("table").map(function() {
			if("left01_tb" == $(this).attr('id') || "left02_tb" == $(this).attr('id') || "left03_tb" == $(this).attr('id') || "left04_tb" == $(this).attr('id') ){
				$(this).css({'display':'none'});				
			}
		});
		$("#"+left_menu_id).css({'display':''});
		if(left_menu){
			$("#left_menu_area").find("span img").map(function() {
				$("#"+$(this).attr("id")).attr('src',$("#"+$(this).attr("id")).attr("src").replace('02.jpg','03.jpg'));
			});
			$("#"+left_menu+"_img").attr('src',$("#"+left_menu+"_img").attr("src").replace('03.jpg','02.jpg'));
		}
	}
}

function menuFlipChk(){ //left메뉴 접기여부 false 접힘
	var body_bg = $("body").attr("background");
	var showYn; 
	if("images/left_menu_bg.jpg" == body_bg){ //left 메뉴 show
		showYn = true;
	}else if("images/left_menu_bg_t_02.jpg" == body_bg){ //left 메뉴 hidden
		showYn = false;
	}
	
}

$(document).ready(function(){
	var top_menu = $.cookie('top_menu');
	var left_menu = $.cookie('left_menu');
	menu_load(top_menu,left_menu);
	
	$("#logout_btn").click( function() {//로그아웃처리 
	    if( confirm("로그아웃 하시겠습니까?") )
	    {
	    	$.cookie('top_menu', null);
	    	$(location).attr('href',"cmn.login.excutelogout.do");
	    }
	});
	
	$("#top_menu_area").find("img").click( function() { //topmenu click event
		
		if("" == $("#top_projno").val()){
			alert("프로젝트 정보설정을 하신 후 사용할수 있습니다.");
			return;
		}
		
		if("" == $("#top_connsevrdstcd").val()){
			alert("접속시스템 정보설정을 하신 후 사용할수 있습니다.");
			return;
		}
		
		var top_menu_id = $(this).attr("id");
		$.cookie('top_menu', top_menu_id); //cookie를 셋트
		
		if("top_menu_01" == top_menu_id){ //전문테스트
			$.cookie('left_menu', "leftmenu_1_1"); //cookie를 셋트
			$(location).attr('href',"msg.myLatestWork.myLatestWork.do");
		}else if("top_menu_02" == top_menu_id){ //통계보고서
			$.cookie('left_menu', "leftmenu_2_1"); //cookie를 셋트
			$(location).attr('href',"msg.statistics.TestPrgsSts.do");
		}else if("top_menu_03" == top_menu_id){ //나의테스트환경
			$.cookie('left_menu', "leftmenu_3_1"); //cookie를 셋트
			$(location).attr('href',"msg.myQalty.myQalty.do");
		}else if("top_menu_04" == top_menu_id){ //시스템관리
			$.cookie('left_menu', "leftmenu_4_1"); //cookie를 셋트
			$(location).attr('href',"cmn.sysmng.loggerMng.do");
		}else if("top_menu_05" == top_menu_id){ //예약실행
			$.cookie('left_menu', "leftmenu_5_1"); //cookie를 셋트
			$(location).attr('href',"msg.schedule.scheduleMng.do");
		}else if("top_menu_06" == top_menu_id){ //결함관리
			$.cookie('left_menu', "leftmenu_6_1"); //cookie를 셋트
			$(location).attr('href',"msg.flaw.myFlawList.do");
		}
		
	});
	
	$("#left_menu_area").find("a").click( function() {//lftmenu event
		var left_menu_id = $(this).attr("id");
		if( ("leftmenu_3_3" != left_menu_id)&&("leftmenu_3_2" != left_menu_id) &&("leftmenu_3_4" != left_menu_id) && ("leftmenu_3_1" != left_menu_id) ){ //로그인한 유저의 프로젝트정보와 접속시스템정보 수정을 위해 접근 허용 
			if(!$("#left_menu_area").attr("lmenuChk1")){
				alert("프로젝트 정보설정을 하신 후 사용할수 있습니다.");
				return;
			}
			
			if(!$("#left_menu_area").attr("lmenuChk2")){
				alert("테스트대상시스템 정보설정을 하신 후 사용할수 있습니다.");
				return;
			}
		}
		if($(this).attr("mvUrl")){
			$.cookie('left_menu', left_menu_id); //cookie를 셋트
			$(location).attr('href',$(this).attr("mvUrl"));
		}else{
			if( "leftmenu_3_4" == left_menu_id ){
				var url = "msg.popUserPass.popUserPass.do";
				window.showModalDialog(url,window,'center:yes;dialogWidth=540px; dialogHeight=206px; scroll:no; status:no; help:no; resizable:no; location:no; ');
			} else if( "leftmenu_4_4" == left_menu_id ){
				var url = "cmn.sysmng.popLicense.do";
				window.showModalDialog(url,window,'center:yes;dialogWidth=400px; dialogHeight=110px; scroll:no; status:no; help:no; resizable:no; location:no; ');
			}
		}

	});
	$("#left_menu_area").find("img").click( function() {//숨기기
		var img_src = $(this).attr("src");
		if( "images/left_tab_hide.jpg" == img_src){
			$("body").attr("background","images/left_menu_bg_t_02.jpg");
			$("body").css({'background-repeat':'repeat-y'});
			$("#left_menu_area").css({'display':'none'});
			$("#h_left_menu_area").css({'display':''});
			$("body").attr("hideYn","Y");
			bodyreload();
		}
	});

	$("#h_left_menu_area").find("img").click( function() {//보이기
		var img_src = $(this).attr("src");
		if( "images/left_tab_hide.jpg" == img_src){
			$("body").attr("background","images/left_menu_bg.jpg");
			$("#left_menu_area").css({'display':''});
			$("#h_left_menu_area").css({'display':'none'});
			$("body").attr("hideYn","N");
			bodyreload();
		}
	});
	
	$("#img_logo").click( function() {//로고 클릭시 메인페이지 이동
		$.cookie('top_menu', "top_menu_03"); //cookie를 셋트
		$.cookie('left_menu', "leftmenu_3_1"); //cookie를 셋트
		$(location).attr('href',"msg.myQalty.myQalty.do");
	});
});

//비밀번호 변경
function passChacnge(){
	var url = "msg.popUserPass.popUserPass.do";
	window.showModalDialog(url,window,'center:yes;dialogWidth=470px; dialogHeight=206px; scroll:no; status:no; help:no; resizable:no; location:no; ');
}

function fileDownload(x){
	myTempWindow = window.open(encodeURI(x),'','left=10000,screenX=10000');
	myTempWindow.document.execCommand('SaveAs','null',encodeURI(x));
	//myTempWindow.close(); 
}