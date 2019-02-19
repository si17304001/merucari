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
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
		<title>商品詳細</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/images/detail.css" type="text/css">
	</head>
	
	<body>
	<h1>商品詳細</h1>
			<h3>キーワード検索</h3><a href="keysearch"></a>
			<form action="keysearch" method="get" class="form1">
				<input type="search" name="key" placeholder="キーワードから探す" class="searchkey">
				
				<!--<i class="fas fa-search"></i>-->
				 <input type="image" src="images/虫眼鏡のアイコン.png" width="15" height="15" alt="検索" name="submit" value="検索" class="submit">
			</form>
		
							<div class="aaa">
							<header >
				
							
			<% if(session.getAttribute("loginid")==null){ %>
				<a href="userregist"><div class="button1">新規アカウント作成</div></a>
				
				<a href="loginuser"><div class="button">ログイン</div></a>
				
			<% }else{ %>
				<h3>マイページ${sessionScope.loginname}</h3>
				<h1><a href="exhibit">出品</a></h1></li>
				<a href="mypage">マイページ</a>
				<a href="chargejsp"><div class="button2">ポイントチャージ</div></a>
				<a href="logout">ログアウト</a>
			<% } %>
			
			
			
			
			<a href="category"><div class="testcategory">カテゴリー</div></a>
					<div class="test">
					<div id="nav-drawer">
      <input id="nav-input" type="checkbox" class="nav-unshown">
      <label id="nav-open" for="nav-input"><span></span></label>
      <label class="nav-unshown" id="nav-close" for="nav-input"></label>
      
      <div id="nav-content">
      <div class="testaaaa">
      
					<ul>
            <li><a href="#">メンズ</a></li>
                 
            <li><a href="#">レディース</a></li>
                
            <li><a href="#">キッズ</a></li>
            
               <li><a href="#">インテリア</a></li>
               
               <li><a href="#">おもちゃ</a></li>
               <li><a href="#">コスメ</a></li>
                  <li><a href="#">家電</a></li>
                       <li><a href="#">キッズ</a></li>
                       <li><a href="#">スポーツ</a></li>
                 <li><a href="#">ハンドメイド</a></li>
                       <li><a href="#">ハンドメイド</a></li>
                    <li><a href="#">チケット</a></li>
                       <li><a href="#">自転車</a></li>
                       <li><a href="#">その他</a></li>
                       </ul>
                       </div>
                       
                       
                       <div class="god">
               <ul>
                <li><a href="#">トップス </a></li>
                <li><a href="#">アウター </a></li>
                <li><a href="#">パンツ</a></li>
                </ul>
                
                </div>
                
                <div class="category">
                    <ul>
                       <li><a href="#">Ｔシャツ</a></li>
                       <li><a href="#">シャツ</a></li>
                       <li><a href="#">テーラードジャケット</a></li>
                       <li><a href="#">ノーカラージャケット</a></li>
                       <li><a href="#">デニム</a></li>
                        <li><a href="#">ワークパンツ</a></li>
                    </ul>
                    </div>
                    
                    
                    </div>
                    </div>
                   </div>
			</header>
			<hr>
	<div class="parent">
			<h1>キーホルダーかわいい</h1>
		<p>キーホルダー かわいい</p>
	<!--
		<div>アイテムID(${data.item_id})</div>-->
		<div class="name">商品名[${data.name}]</div>
		<div class="img"><img src="<c:url value='/images/${data.image1}'/>">
		
		<script>
			var sold1=`<img src="<c:url value='images/sold.png'/>" class="sold">`
			if(${data.available}==1){
				document.write(sold1)
			}else{}
		</script>
		
		</div>
		
		
		
		<div class="all">
		<div class="nickname"><a href="userpage?user_id=${data.salerId}">出品者:${data.salerNickname}</a></div>
		<div class="good">よい${data.salerGood}</div><div>ふつう${data.salerNormal}</div>
		<div class="bad">わるい${data.salerBad}</div>
		<div class="description">説明${data.description}</div>
		<div class="shipping">0送料込み/1別:${data.shipping}</div>
		<div class="state">状態${data.state}</div>
		<div class="prefcode">発送元${data.prefcode}</div>		
        </div>
		
		<form method='post' action='buy'>
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
			if(${sessionScope.loginid} == ${data.salerId}){
				document.write("出品者のため購入不可");
			}else if(ava==0){
				document.write(userid)
				document.write(buy)
			}else{
					document.write("SOLDOUT")
			}
			
		</script>
		
		</div>
		
		</form>
		<td><form method="post" action="showchat"><input type="hidden" name = "item_id" value=${data.item_id}>
		<input type="hidden" name = "user_id" value=${sessionScope.loginid}>
		<button><input type ="submit" value="チャットを表示(試作)"></button></form>
		<div class="price">${data.price}円</th></tr></div>
		<a><div class="purchase">購入画面に進む</div></a>
		<div class="like"><a href="like?item_id=${data.item_id}">いいね${data.like}
		<script>
		var img1 = "<img src='images/like.jpg'width='50' height='50' border='0' alt=''>";
		var img2 = "<img src='images/like2.png'width='50' height='50' border='0' alt=''/>";
		var a = ${data.like};
		if(a==0){
			document.write(img1);
		}else{
			document.write(img2);
		}
		</script></a></div>
		</div>
	<script>

//画像を配列に格納する
var img = new Array();

img[0] = new Image();
img[0].src = "images/like.jpg";
img[1] = new Image();
img[1].src = "images/like2.png";
//画像番号用のグローバル変数
var cnt=${data.like};


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
	
	</div>
	</body>
</html>