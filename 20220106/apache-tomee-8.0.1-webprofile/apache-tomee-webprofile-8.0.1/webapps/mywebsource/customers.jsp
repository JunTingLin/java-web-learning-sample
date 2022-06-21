<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="CustomersAddServlet">
		<div>客戶編號</div>
		<input type="text" name="customerid"/>
		<div>公司行號</div>
		<input type="text" name="companyname"/>
		<div>聯絡地址</div>
		<input type="text"  name="address"/>
		<div>連絡電話</div>
		<input type="text" name="phone"/>
		<br/>
		<input type="submit" value="新增"/>
	</form>
</body>
</html>