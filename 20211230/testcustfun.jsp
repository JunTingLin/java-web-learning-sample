<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://www.eric.com.tw/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>測試自訂函數庫</title>
</head>
<body>
	<!-- 定義一個Attribaute名稱與內容 -->
	<c:set var="names" value="eric,linda,bill,tony,sam,helen"></c:set>
	<!-- 配合走訪 -->
	<c:forEach var="name" items='${fn:separate(names,",")}'>
		<div>${name}</div>
	</c:forEach>
	<br/>
	<!-- 呼叫自訂函數 轉換成大寫 -->
	<label>字串大寫內容:${fn:upper(names)}</label>
</body>
</html>