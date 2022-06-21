<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" 
href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library javascript framework 走CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<style>
	#menu {
	background: #CC3FC7;
	color: #FFF;
	height: 45px;
	padding-left: 18px;
	border-radius: 10px;
	border: 1px solid #6D6D6D;
}
#menu ul, #menu li {
	margin: 0 auto;
	padding: 0;
	list-style: none
}
#menu ul {
	width: 100%;
}
#menu li {
	float: left;
	display: inline;
	position: relative;
}
#menu a {
	display: block;
	line-height: 43px;
	padding: 0 14px;
	text-decoration: none;
	color: #FFFFFF;
	font-size: 16px;
}
#menu a.dropdown-arrow:after {
	content: "\25BE";
	margin-left: 5px;
}
#menu li a:hover {
	color: #0099CC;
	background: #F2F2F2;
}
#menu input {
	display: none;
	margin: 0;
	padding: 0;
	height: 45px;
	width: 100%;
	opacity: 0;
	cursor: pointer
}
#menu label {
	display: none;
	line-height: 43px;
	text-align: center;
	position: absolute;
	left: 35px
}
#menu label:before {
	font-size: 1.6em;
	content: "\2261"; 
	margin-left: 20px;
}
#menu ul.sub-menus{
	height: auto;
	overflow: hidden;
	width: 170px;
	background: #444444;
	position: absolute;
	z-index: 99;
	display: none;
}
#menu ul.sub-menus li {
	display: block;
	width: 100%;
}
#menu ul.sub-menus a {
	color: #FFFFFF;
	font-size: 16px;
}
#menu li:hover ul.sub-menus {
	display: block
}
#menu ul.sub-menus a:hover{
	background: #F2F2F2;
	color: #444444;
}
@media screen and (max-width: 800px){
	#menu {position:relative}
	#menu ul {background:#111;position:absolute;top:100%;right:0;left:0;z-index:3;height:auto;display:none}
	#menu ul.sub-menus {width:100%;position:static;}
	#menu ul.sub-menus a {padding-left:30px;}
	#menu li {display:block;float:none;width:auto;}
	#menu input, #menu label {position:absolute;top:0;left:0;display:block}
	#menu input {z-index:4}
	#menu input:checked + label {color:white}
	#menu input:checked + label:before {content:"\00d7"}
	#menu input:checked ~ ul {display:block}
}
</style>

<%
	//借助前端封裝進來HttpServletRequest取出Content Path
	String path = request.getContextPath();
	out.println(path); // /myweb 
	//取出Scheme 採用http fpt...
	String basePath = request.getScheme()+"://"+request.getServerName()+":"
	+request.getServerPort()+path+"/";
%>
<script src="<%=basePath%>/js/vue.min.js"></script>
<img src="<%=basePath%>images/aiiotbanner.jpg" style="width:100%;height:100px;"/>
<nav id='menu'>
  <input type='checkbox' id='responsive-menu' onclick='updatemenu()'><label></label>
  <ul>
    <li><a href='<%=basePath%>index.jsp'>首頁</a></li>
    <li><a class='dropdown-arrow' href='http://'>教室環境監控</a>
      <ul class='sub-menus'>
        <li><a href='<%=basePath%>nlpans.jsp'>自然語言方式詢問</a></li>
        <li><a href='http://'>801教室</a></li>
        <li><a href='http://'>802教室</a></li>
        <li><a href='http://'>803教室</a></li>
      </ul>
    </li>
    <li><a href='<%=basePath%>about/me.jsp'>關於我們...</a></li>
    <li><a class='dropdown-arrow' href='http://'>服務</a>
      <ul class='sub-menus'>
        <li><a href='http://'>物聯網監控台設計</a></li>
        <li><a href='http://'>人工智慧</a></li>
        
      </ul>
    </li>
    <li><a href=''>聯絡我們</a></li>
  </ul>
</nav>