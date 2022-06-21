<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 函數庫 函數配合EL去呼叫的 -->
	<c:forEach var="lan" items='${f:split("java/c#/python/swift","/")}'>
		<div>${lan}</div>
	</c:forEach>
	
</body>
</html>