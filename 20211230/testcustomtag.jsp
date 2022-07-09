<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="eric" uri="http://www.eric.com.tw/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 採用xml tag -->
	<eric:hello/>
	<!-- 下面這行拿掉 -->
	<eric:hello>裡面有內容，就不是空元素寫法，會爆掉，因為body-content已描述為empty</erric:hello>
</body>
</html>
