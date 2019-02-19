<%--
まず初めに、pageでなんの言語を使うかを指定 contentTypeでtextをなに使うかを指定 文字コードの指定
必ず%で初めて閉じること

つぎにタグリブライブラリを定義
jsp内で使用するカスタムタグの仕様を宣言

taglib prefix属性の接頭辞(タグBGLの接頭辞)uriメソッドのURL属性(TDLファイルをURLで表示)

そのつぎにhtmlを書く
商品データ表示のjspだから
tableタグのborder属性でテーブルの枠線を表示
forEachタグのvar属性で繰り返し処理した値が格納する変数名を指定
Product属性に式が読み込まれた時点で変数name,priceに入ってる値が渡される

forEachタグとtableタグで宣言しているためforEach,tableで閉じる
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>商品詳細</title>
		<style>
		.parent{
		display:inline-block;
		text-align: center;
		padding: 18px;
		border: none;
		text-align:start;
		margin-left:60px;
		}
		.sold{
		margin-right:auto;
		position:absolute;
		left:0;
		top:0;
		
		}
		.table{
		box-sizign: border-box;
		text-align:start;
		width:300px;
		}
		
		div{  
		border-style: solid;  
		border-color: black; 
		position:relative;
		text-align: center;
		width:300px;
		text-decoration: none;
		font-weight: bold;
		color: black;
		}

		</style>
	</head>
	
	<body>
	<h1>商品詳細</h1>
	<div class="parent">
		
		<div>アイテムID(${data.item_id})</div>
		<div>商品名[${data.name}]</div>
		<div><img src="<c:url value='/images/${data.image1}'/>">
		<script>
		var sold1=`<img src="<c:url value='images/sold.png'/>" class="sold">`
		if(${data.available}==1){
			document.write(sold1)
		}else{}
	</script>
		</div>
		<div>${data.price}円</div>
		<div>${data.salerNickname}</div>
		<div>${data.salerGood}</div><div>${data.salerNormal}</div>
		<div>${data.salerBad}</div>
		
		
		
		<form method='post' action='buy'>
		<input type='hidden' name='price' value=${data.price}>
		<input type='hidden' name='item_id' value=${data.item_id}>
		
		<div>
		<!--購入ボタンON/OFF-->
		<!--購入ボタン表示、要修正-->
		<script>
			var ava = ${data.available};
			
			
			var userid = '<input type="hidden" name="user_id" value=${sessionScope.loginid}>'
			var buy = '<input type="submit" value="購入" ></button>'
			
			
			
			var chat1 = '<form method="post" action="showchat">'
			var chat2 = '<input type="hidden" name = "item_id" value=${data.item_id}>'
			var chat3 = '<button><input type ="submit" value="チャットを表示(試作)"></button></form>'
			if(ava==0){
				document.write(userid)
				document.write(buy)
			}else{
					document.write("SOLDOUT")		
			}
			
		</script>
		
		</div>
		</form>
		<form method="post" action="showchat"><input type="hidden" name = "item_id" value=${data.item_id}>
		<input type="hidden" name = "user_id" value=${sessionScope.loginid}>
		<button><input type ="submit" value="チャットを表示(試作)"></button></form>
	
	</div>
	 <img id="gazo" onclick="changeIMG()" src="images/like.jpg"
   width="100" height="100" border="0" alt="">


<script>

//画像を配列に格納する
var img = new Array();

img[0] = new Image();
img[0].src = "images/like.jpg";
img[1] = new Image();
img[1].src = "images/like2.png";
//画像番号用のグローバル変数
var cnt=0;


//画像切り替え関数
function changeIMG(){
  
  //画像番号を進める
  if (cnt == 2)
  { cnt=0; }
  else
  { cnt++; }
  
  //画像を切り替える
  document.getElementById("gazo").src=img[cnt].src;
}
</script>
</div>
	</body>
</html>