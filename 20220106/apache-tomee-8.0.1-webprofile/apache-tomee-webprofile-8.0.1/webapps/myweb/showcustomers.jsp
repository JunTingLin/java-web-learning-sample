<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客戶資料清單</title>

</head>
<body>
<!-- Java Standard Tag Library標準標籤庫(背後是類別支撐) -->
<table style="border:solid;color:darkblue;width:100%;">
	<thead >
		<tr style="background-color:orange;" >
			<td>客戶編號</td>
			<td>公司行號</td>
			<td>聯絡地址</td>
			<td>連絡電話</td>
			<td>國家別</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="customers" items="${requestScope.data}">
		<tr style="background-color:rgb(192, 192, 192);">
			<td>${customers.customerId}</td>
			<td>${customers.companyName}</td>
			<td>${customers.address}</td>
			<td>${customers.phone}</td>
			<td>${customers.country}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>