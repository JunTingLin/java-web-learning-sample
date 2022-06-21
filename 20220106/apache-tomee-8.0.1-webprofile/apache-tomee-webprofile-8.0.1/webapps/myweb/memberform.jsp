<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員註冊</title>
</head>
<body>
	<!-- Relative Doc 相對位址架構 -->
	<form method="post" action="v1/member/add/form">
		<div>使用者名稱</div>
		<input type="text" name="UserName"/>
		<div>使用者密碼</div>
		<input type="password" name="Password"/>
		<div>EMAIL</div>
		<input type="text" name="Email"/>
		<div>連絡電話</div>
		<input type="text" name="Phone"/>
		<div>真實姓名</div>
		<input type="text" name="RealName"/>
		<br/>
		<input type="submit" value="註冊"/>
	</form>
</body>
</html>