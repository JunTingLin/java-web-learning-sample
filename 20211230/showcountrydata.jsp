<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</head>
<body>
	<c:if test="${requestScope.result.size()==0}">
		<p>查無國家別:${param.country} 資料</p>
	</c:if>
	<!-- else jstl沒有  -->
	<c:if test="${requestScope.result.size()>0}">
		<p>記錄數:${result.size()}</p>
		<!-- 呈現多筆多欄的 -->
		<table class="table table-dark table-hover">
			<thead>
				<tr>
					<td>編號</td>
					<td>公司行號</td>
					<td>聯絡地址</td>
					<td>聯絡電話</td>
					<td>EMAIL</td>
					<td>國家別</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customer" items="${result}">
					<tr>
						<td>${pageScope.customer.customerId}</td>
						<td>${customer.companyName}</td>
						<td>${customer.address}</td>
						<td>${customer.phone}</td>
						<td>${customer.email}</td>
						<td>${customer.country}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>