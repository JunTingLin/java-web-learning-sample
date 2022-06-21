<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教室環境服務機器人</title>
<style type="text/css">
	#panel{
		padding-left:50px;
	}
</style>

</head>
<body>
 <jsp:include page="banner.jsp"></jsp:include>
 <!-- 載入jquery選擇器selector -->

 
 <div style="hight:20px"></div>
 <div id="panel">
 <div>
 	<fieldset>
 		<legend>教室智能機器人-溫濕度</legend>
 		<div>輸入口語化查詢敘述</div>
 		<!-- vue 使用 v-xxx attribute進行功能操作 -->
 		<input v-model="question" id="question" name="question" class="text text-danger text-center" 
 		style="width:400px;"/>
 		<input type="button" value="送出" class="btn-dark" id="btnGo"/>
 	</fieldset>
 </div>
 <!-- 鋪資料 -->
 <div> 
 	<fieldset class="text text-danger display-4">
 		<legend>您問的問題:{{question}}</legend>
 		<label>溫度:</label>
 		<label>{{temperData.temper}}</label>
 		<br/>
 		<label>濕度:</label>
 		<label>{{temperData.humi}}</label>
 		<br/>
 		<label>感測器編號:</label>
 		<label>{{temperData.sensorid}}</label>
 		<br/>
 		<label>日期與時間:</label>
 		<label>{{temperData.time}}</label>
 	</fieldset>
 </div>
 </div>
 <script>

 	//建構一個Vue物件 配置跟標籤可以Binding Data(MVVM  -ViewandModel-Data Binding)
 	var vue=new Vue(
 		//建置一個JavaScript物件
 		{
 			//綁定標籤區塊
 			el:'#panel',
 			data:{
 				question:'關於教室801溫溼度狀態',
 				temperData:{
 					sensorid:'',
 					time:'',
 					temper:0,
 					humi:0
 				}
 			}
 		}
 	);
	//自訂函數
	function sayHello(){
		alert('您好');
	}
	//ready() 事件點 網頁下載瀏覽起引發起來  進行初始化設定
	//jQuery選擇器 選網頁物件 $() 選擇器
	//選取文件(Page)當下載完成引發事件xxx(event procedure)
	//進入jQuery模租 面對jQuery物件模組
	$(document).ready(
		//埋入事件程序 匿名函數 無須命名
		function(){
			//1.選取jquery按鈕 使用#id
			$('#btnGo').click(
				function(){
					//參考出文字輸入方塊的標籤物件.val() Method採用多載 val() 取出來 val('內容') 設定
					//var question=$('#question').val();
					//alert(question);
					//進行非同步處理 呼喚REST Service,傳遞所發問的問題
					var settings={
							id:1,
							name:'張三丰',
							address:'高雄市',
							sayHello:function(){
								alert(this.name);
							}
					}
					//settings.sayHello();
					
					//請求服務網址 加上問題 URL出現中文字串串連 採用URL Encode編碼
					var urlString='v1/linebot/webbase/question/rawdata?q='
							+encodeURI(vue.question);
					console.log("服務端點:"+urlString);
					//規劃一個符合ajax()參數物件
					var requestSettings={
						url:urlString,
						type:'GET',
						//後端處理ok callback
						success:function(data,status,xhr){
							var sensorid=data.id;
							var time=data.time;
							//取出相對溫溼度值
							var jarray=data.value;
							//取出第一個元素
							var valueString=jarray[0];
							//反序列化字串為一個Json物件
							var valueObject=JSON.parse(valueString);
							
							var temper=valueObject.temper;
							var humi=valueObject.humi;
							//輸出前端瀏覽器監控台
							console.log('溫度:'+temper);
							console.log('濕度:'+humi);
							//將資料設定vue物件的屬性tmperData
							vue.temperData.sensorid=sensorid;
							vue.temperData.time=time;
							vue.temperData.temper=temper;
							vue.temperData.humi=humi;
							
							
							//綁定畫面進行更新資料呈現
						},
						error:function(xhr,status,error){
							//xhr XMLHttpRequest物件
							//後端服務設定Response Http status code=4xx or 5xxx
							//alert("錯誤:"+xhr.status);
							console.log(xhr.responseText);
							//錯誤訊息是一樣
							var msg=xhr.responseText;
							//反序列化成Json物件
							//var errorObject=JSON.parse(msg);
							alert(msg);
						}
						
					}
					$.ajax(requestSettings);
					
				}		
			);
		}
	); 
</script>
</body>
</html>