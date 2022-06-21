<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>國家別客戶查詢</title>
</head>
<body>
	<div>${country.size()}</div>
	<form>
		<div>國家別</div>
		<select>
			<!-- 走回圈將傳遞進來的attribute 國家別清單逐一產生option標籤內容 -->
			<c:forEach var="item" items="${country}">
				<option value="${item.toString()}">${item.toString()}</option>
			</c:forEach>
		</select>
	</form>
</body>
</html>