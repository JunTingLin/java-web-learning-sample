<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客戶資料維護</title>
</head>
<body>
	<form method="post" action="customerssave.jsp">
		<div>客戶編號</div>
		<input type="text" name="customerId"/>
		<div>公司行號</div>
		<input type="text" name="companyName"/>
		<div>聯絡地址</div>
		<input type="text" name="address"/>
		<div>聯絡電話</div>
		<input type="text" name="phone"/>
		<div>EMAIL</div>
		<input type="text" name="email"/>
		<div>國家別</div>
		<input type="text" name="country"/>
		<br/>
		<input type="submit" value="新增"/>
		<input type="reset" value="取消"/>
	</form>
</body>
</html>