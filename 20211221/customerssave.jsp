<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客戶資料儲存</title>
</head>
<body>
	<!-- 透過Action Element建構一個MyCustomers JavaBean物件 -->
	<jsp:useBean id="customers" class="com.gjun.beans.MyCustomers" 
	scope="session"></jsp:useBean>
	<!-- 去跟應用系統問出被參考的DataSource物件 -->
	
	
	<!-- 建構一個dao物件 -->
	<jsp:useBean id="dao" class="com.gjun.domain.MyCustomersDao"></jsp:useBean>
	<!-- 設定JavaBean setXxx() 注入內容 attribute支援runtime expression是有規範-->
	<!-- 不是所有屬性都可以穿插運算式 -->
	<!-- <jsp:setProperty property="customerId" name="customers" value='<%=request.getParameter("customerId") %>'/> -->
	<jsp:setProperty property="*" name="customers"/>
	<!-- 自動封存 -->
	<!-- 不用問了⏬ -->
	<!-- <jsp:useBean id="datasource" class="com.mysql.cj.jdbc.MysqlDataSource" scope="application"></jsp:useBean> -->
	<!-- 改用EL ${} 寫法， -->
	<!-- 因為沒有其他層面有定datasource，所以不寫"applicationScope."也可 -->
	<jsp:setProperty property="dataSource" name="dao" value="${applicationScope.datasource}"/>
	<!-- 資料維護 進行新增流程 -->
	<!-- dao透過屬性注入datasource -->
	
	<%
		
		dao.insert(customers);
	%>
	<!-- 取出屬性 getXxxx() -->
	<jsp:getProperty property="customerId" name="customers"/>
	<jsp:getProperty property="companyName" name="customers"/>

	<!-- 改用 -->
	<jsp:forward page="myCustomersshowresult.jsp">
		<jsp:param value="新增記錄完成" name="state"/>
	</jsp:forward>
	<!-- 臨時需求的參數parameter包在forward帶過去 -->
	<!-- 可回想之前request.getPatameter("state")，並沒有進入attribute -->