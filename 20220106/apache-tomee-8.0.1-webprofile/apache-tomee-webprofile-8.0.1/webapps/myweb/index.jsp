<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>AIoT監控台系統</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <!-- 含入(include Page)一個共用版面 提供Banner與功能表樣式 -->
    <!-- Action Element 動作元素 自訂標籤  -->
    <jsp:include page="banner.jsp"></jsp:include>
    <p></p>
    <p></p>
    <div>
    	<img src="images/aiiotlogo.jpg" style="width:100%;height:400px;"/>
   </div>
    
    <%=basePath%>
  </body>
</html>
