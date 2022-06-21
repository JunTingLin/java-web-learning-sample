<%@ page language="java" contentType="text/html; charset=UTF-8" import="com.gjun.entity.*"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${customers.companyName}
	
	<%
		CustomersBean customers=(CustomersBean)request.getAttribute("customers");
		out.println(customers.getCompanyName());
	%>
</body>
</html>