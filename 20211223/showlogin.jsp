<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入狀態</title>
</head>
<body>
	<!-- 使用EL 針對特定範圍Scope狀態進行取得與呈現 -->
	<%
		//區域變數
		String com="巨匠電腦";
		//設定網頁狀態Attribute
		pageContext.setAttribute("message", "我是網頁層級的attribute");
	%>
	<!-- EL不運算區域變數 -->
	${com}
	<h1>100X50=${100*50}</h1>
	<h1>${requestScope.message}</h1>
	<h1>${pageScope.message}</h1>
	<h1>${message}</h1>
	<!-- 萬一message有兩個會抓最小範圍的那一個 -->
	<h1>應用系統範圍:${applicationScope.datasource}</h1>
	<h1>Session狀態:${sessionScope.cred}</h1>
</body>
</html>