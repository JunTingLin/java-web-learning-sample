<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String com="巨匠電腦";
%>
<!-- 設定某種範圍的attribute 狀態管理 -->
<c:set var="company" value="<%=com%>" scope="page"></c:set>
<c:out value="${company}"></c:out>

<!-- EL 只能操作某種範圍attribute -->
${company}
</body>
</html>