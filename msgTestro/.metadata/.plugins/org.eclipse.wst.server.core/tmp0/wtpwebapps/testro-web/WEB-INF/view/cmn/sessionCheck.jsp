<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>세션정보</title>
</head>
<body>
사용자id       :   ${sessionScope.userinfo.usrid}       <br>    
이름           :   ${sessionScope.userinfo.usrname}     <br>              
유저레벨       :   ${sessionScope.userinfo.usrlevel}    <br>            
프로젝트번호   :   ${sessionScope.userinfo.projno}      <br> 
프로젝트명     :   ${sessionScope.userinfo.projname}    <br>  
테스트 단계명  :   ${sessionScope.userinfo.teststgename}<br> 
테스트 시작일시:   ${sessionScope.userinfo.teststartyms}<br>
테스트 종료일시:   ${sessionScope.userinfo.testendyms}  <br>
접속서버구분코드:   ${sessionScope.userinfo.connsevrdstcd}  <br>
</body>
</html>