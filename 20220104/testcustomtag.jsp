<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="eric" uri="http://www.eric.com.tw/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<String> data=new ArrayList<>();
		data.add("Allen");
		data.add("Bill");
		data.add("Cathy");
		pageContext.setAttribute("data",data);
	%>
	<!-- 設定一個attribute pageContext level -->
	<c:set var="myname" value="張三丰"/>
	<!-- 採用xml tag -->
	<eric:hello/>
	<br/>
	<!-- 具有Attribute自訂標籤 -->
	<eric:whoHello information="Hello World 吃飽沒?" who="${myname}"/>
	<br/>
	<eric:whoLoopHello counter="3" information="Hello" who="bill">testing</eric:whoLoopHello>
	<br/>
	<!-- 具有實體標籤內容處理 -->
	<eric:bufferTag>${myname}</eric:bufferTag>
	<br/>
	<eric:includeTag>
		<%
			for(int s=0;s<=3;s++){
				out.println("<font size='7' color='blue'>Hello World</font><br/>");
			}
		%>
	</eric:includeTag>
	<br/>
	<eric:listData data="${data}">客戶名稱</eric:listData>
</body>
</html>