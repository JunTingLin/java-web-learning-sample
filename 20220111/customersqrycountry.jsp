<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客戶資料查詢</title>
<script src="https://cdn.jsdelivr.net/npm/vue@2.6.14/dist/vue.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/themes/base/jquery-ui.css" type="text/css" media="all" /> 
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.min.js" type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/jquery-ui.min.js" type="text/javascript"></script>
</head>
<body onload="init()">
	<!-- 沒有撰寫表單頁面 採用JavaScript非同步呼喚後端RESTful Service -->
	<fieldset id="panel">
		<legend>客戶查詢</legend>
		<div>國家別</div>
		<input type="text" id="country" v-model:text="countryKey" style="font-size:24px;" class="text-primary"/>
		<button id="btnGo">查詢</button>
		<br/>
		<div>您輸入查詢國家別:{{countryKey}}</div>
		<br/>
		<div style="font-size:24px;color:red;">{{messageData.msg}}</div>
		<fieldset v-if="isShow">
			<legend>查詢結果</legend>
			<table class="table table-dark table-hover">
				<thead>
					<tr>
						<td>客戶編號</td>
						<td>公司行號</td>
						<td>聯絡地址</td>
						<td>EMAIL</td>
						<td>國家別</td>
					</tr>
				</thead>
				<tbody>
					<!-- 經由Vue渲染 走訪所有紀錄 -->
					<tr v-for="cust in resultData">
						<td>{{cust.customerId}}</td>
						<td>{{cust.companyName}}</td>
						<td>{{cust.address}}</td>
						<td>{{cust.email}}</td>
						<td>{{cust.country}}</td>
						<td><Button v-on:click="editForm(cust.customerId)">編輯</Button></td>
					</tr>
				</tbody>
			</table>
		</fieldset>
		<!-- 對話盒 -->
		<div v-if="isEdit">
			<div id="editForm">
				<fieldset>
					<legend>資料編輯</legend>
				</fieldset>
			</div>
		</div>
	</fieldset>
	
	<!-- 建構一個個體Vue物件 -->
	<script type="text/javascript">
	//建構Vue物件
	var app=new Vue(
			//settings 多參數 不確定數量 採用JavaScript物件
			{
				//綁定的區塊DOM
				el:'#panel',
				//資料模組屬性
				data:{
					countryKey:'TW',
					//查詢結果
					resultData:[], //是一個陣列
					//查詢結果訊息
					messageData:{}, //JavaScript物件
					isShow:false,
					isEdit:false
				},
				methods:{
					//事件程序或者函數
					editForm:function(cid){
							app.isEdit=true;
							$('#editForm').dialog();
							
					}
				}
			}
			);
	//網頁下載時進行初始化(Load Initializer)
	//函數當作一個事件程序(Event Procedure)
	function init(){
		//參考出標籤物件(DOM-Document Object Model) 設定為區域變數
		//let區域變數定物
		let btnGo=document.getElementById('btnGo');
		//alert(btnGo);
		//針對那一個按鈕物件執行階段 委派click事件程序
		btnGo.addEventListener('click',
				//Lambda expresion
				()=>{
					//alert('我是按鈕');
					//1.使用DOM去參考文字輸入方塊輸入內容(國家別)
					//<input type='text' value='xxxx'/>
					let txtKey=document.getElementById('country').value;
					//輸出到瀏覽器主控台Console
					console.log(txtKey);
					//2.採用AJAX引擎支援的XMLHttpRequest /XMLHttpResponse物件進行非同步處理
					//服務位址
					let urlString='http://localhost:8080/myweb/api/customers/custqry/rawdata?count='+txtKey;
					//建構一個XMLHttpRequest物件
					let xhr=new XMLHttpRequest();
					//埋入非同步進行callbck事件程序
					xhr.onreadystatechange=function(){
						//問一下處理非同步過程(輪播狀態回來)
						console.log('非同步處理過程:'+xhr.readyState);
						console.log('Http處理狀態碼:'+xhr.status);
						//判斷處理成功
						if(xhr.readyState==4 && xhr.status==200){
							//查詢完成有資料
							let result=xhr.responseText;
							console.log(typeof(result));
							//回應是一個字串 轉換成可以操作的Json物件(array or Object)
							//使用現成JSON class
							let jsonObject=JSON.parse(result);
							console.log(jsonObject);
							//將結果指派Vue Data Model
							app.resultData=jsonObject;
							app.messageData={}; //reset {}
							//Vue Data Model isShow定義為true
							app.isShow=true;
						}else if(xhr.readyState==4 && xhr.status==400){
							console.log(xhr.responseText);
							app.messageData=JSON.parse(xhr.responseText)
							//Vue Data Model isShow定義為true
							app.isShow=false;
						}
					}
					console.log(xhr);
					//Request Client 請求要件:URL/採用哪一種傳送方法GET/傳遞資訊/回應內容JSON文件格式
					xhr.open('GET',urlString,true); //預設為true 可以不下
					
					//等待一下 不是立即執行
					//正式提出非同步請求
					xhr.send(); //..還在併行處理
					//繼續了
					
					
				}
		);
	}
</script>
</body>
</html>