<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.gjun.entity.AppConfig"%>
	<!-- import兩個以上用逗點隔開 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>取得應用系統初始化資料庫組態</title>
</head>
<body>
	<%
		//參照出網站系統物件ServletContext
		//使用內建物件
		//application、out都是內建物件
		AppConfig con=(AppConfig)application.getAttribute("config");
		String company=con.getCompanyName();
		out.println(company);
	%>
</body>
</html>