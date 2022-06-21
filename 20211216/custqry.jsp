<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*,javax.sql.DataSource,java.util.*,com.gjun.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客戶資料查詢結果</title>
</head>
<body>
	<!-- action element 建立一個新的JavaBean預設attribute範圍page -->
	<jsp:useBean id="dao" class="com.gjun.domain.CustomersDao"></jsp:useBean>
	<jsp:useBean id="datasource" class="com.mysql.cj.jdbc.MysqlDataSource" 
	scope="application"></jsp:useBean>
	<!-- 擷取前一個頁面表單欄位內容 -->
	<%
		//向應用系統物件ServletContext 使用內建物件appliction
		//DataSource source=(DataSource)application.getAttribute("datasource");
		//Scriptlet使用內建物件 request
		String country=request.getParameter("country");
		//進行資料查詢(DAO設計模式)
		//互動
		dao.setDataSource(datasource); //datasource attribute
		//查詢
		List<Customers> result=dao.selectForList(country);
	
		//回應 直接使用內建物件(response) 最後配合到標籤
		

	%>
	<div>查詢國家別:<%out.println(country); %></div>
	<%
		//透過內建response(HttpServletResponse) 獨立運作 不配合UI 標籤刻板 相對輸出
		PrintWriter writer=response.getWriter();
		writer.println(country);
	
	%>
	<div>查詢國家別:<%=country%></div>
	<div>查詢記錄數:<%=result.size()%></div>
	<!-- 呈現結果 -->
	<table style="width:auto;border:solid;border-width:1;">
		<thead>
			<tr>
				<td>客戶編號</td>
				<td>姓名</td>
				<td>聯絡地址</td>
				<td>聯絡電話</td>
				<td>國家別</td>
			</tr>
		</thead>
		<tbody>
			<%for(Customers customer:result){ %>
			<tr>
				<td><%=customer.getId()%></td>
				<td><%=customer.getName()%></td>
				<td><%=customer.getAddress()%></td>
				<td><%=customer.getPhone()%></td>
				<td><%=customer.getCountry()%></td>
			</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>