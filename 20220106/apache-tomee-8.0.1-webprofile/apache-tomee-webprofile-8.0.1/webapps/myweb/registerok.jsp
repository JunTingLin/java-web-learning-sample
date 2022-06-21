<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.gjun.entity.IoTMember"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>註冊成功</h1>
	<fieldset>
		<legend>會員資料</legend>
		<div>會員帳號:<%=((IoTMember)request.getAttribute("member")).getUserName()%></div>
		<div>${member['userName']}</div>
		<div>${member.password}</div>
		<div></div>
	</fieldset>
</body>
</html>