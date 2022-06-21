<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我是首頁</title>
</head>
<body>
	<!-- 一段小小的Java Scriptlet -->
	<%
		//問一下傳送方法是?
		String method=request.getMethod();
		out.println("傳送方法:"+method);
		for(int s=1;s<=3;s++){
			//使用內建物件輸出
			out.print("<font size='7' color='red'>Hello</br>");
		}
	%>
</body>
</html>