<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員註冊</title>
<script type="text/javascript">
	//事件程序 採用function 網頁下載之後 進行初始化設定
	function init(){
		//alert('Hello JavaScript');
		//參考出標籤button物件
		var btnEL=document.getElementById('btnAdd');
		btnEL.value="會員註冊";
		//執行階段委派一個click事件程序 
		btnEL.addEventListener('click',memberAdd,false)
		//alert(btnEL);
	}
	
	//按鈕click事件程序function
	function memberAdd(e){
		//使用DOM 參照出相對id物件
		var username=document.getElementById('username');
		var password=document.getElementById('password');
		var email=document.getElementById('email');
		var phone=document.getElementById('phone');
		var realname=document.getElementById('realname');
		var msg='';
		//Client Validation 前端驗證(RequiredField)
		if(username.value.length==0){
			msg='使用者名必須要填寫!!\n';
		}
		if(password.value.length==0){
			msg=msg+'使用者密碼必須要填寫!!\n';
		}
		if(email.value.length==0){
			msg=msg+'EMAIL使用者密碼必須要填寫!!\n';
		}
		if(phone.value.length==0){
			msg=msg+'電話必須要填寫!!\n'
		}
		if(realname.value.length==0){
			msg=msg+'真實姓名必須要填寫!!';
		}
		if(msg!=''){
			alert(msg);
		}else{
			//AJAX進行非同步處理 進行會員註冊作業
			// 先建立一個XMLHTTPRequest物件
			var xhr=new XMLHttpRequest();
			//服務位址...
			var urlString='v1/member/add/rawdata';
			
			//2. body 傳送JSON String
			//2.1 先整理一個JavaScript物件
			var obj={userName:username.value,password:password.value,email:email.value,
					phone:phone.value,realName:realname.value};
			//Dumps Json String
			var jsonString=JSON.stringify(obj);
			//alert(jsonString);
			//開啟請求 採用Http Request Method-POST配合服務端
			xhr.open('POST',urlString);
			//1.設定Request Content-Type:application/json
			xhr.setRequestHeader("Content-Type","application/json")
			//準備埋入回呼相關事件程序onreadystatechange Event
			xhr.onreadystatechange=function(e){
				//alert(xhr.readyState+' '+xhr.status);
				//status(Http status=200 readState=4 callback處理)
				if(xhr.readyState==4 && xhr.status==200){
					//取回回應的資料Json格式字串 反序列化成JavaScript物件
					var result=xhr.responseText;
					//借助JSON類型static method parse() 分析與反序列化字串變成物件
					var data=JSON.parse(result);
					//alert(data.message);
					//鋪畫面
					document.getElementById('result').innerText=data.message;
				}
				
			}
			//正式送出
			xhr.send(jsonString);
			
		}
	}
</script>
</head>
<!-- sayHello 委派(delegate)在這一個事件點上 事件發生 引發這一個程序 -->
<body onload="init()">
<fieldset>
	<legend>會員註冊</legend>
	<div>使用者帳號</div>
	<input type="text" id="username"/>
	<div>使用者密碼</div>
	<input type="password" id="password"/>
	<div>EMAIL</div>
	<input type="text" id="email"/>
	<div>連絡電話</div>
	<input type="text" id="phone"/>
	<div>真實姓名</div>
	<input type="text" id="realname"/>
	<br/>
	<input type="button" value="註冊" id="btnAdd"/>
</fieldset>
<br/>
<div id="result" style="color:blue;font-size:24px;"></div>
</body>
</html>