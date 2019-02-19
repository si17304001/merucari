
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>		
		<title>商品一覧</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/images/view.css" type="text/css">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	</head>
	
	<body>
		
		<h3>キーワード検索</h3><a href="keysearch"></a>
			<form action="keysearch" method="get" class="form1">
				<input type="search" name="key" placeholder="キーワードから探す" class="searchkey">
				
				<!--<i class="fas fa-search"></i>-->
				 <input type="image" src="images/虫眼鏡のアイコン.png" width="15" height="15" alt="検索" name="submit" value="検索" class="submit">
				 
			</form>
			
				<div class="view">
							<header >
				
							
			<% if(session.getAttribute("loginid")==null){ %>
				<a href="userregist"><div class="account">新規アカウント作成</div></a>
				
				<a href="loginuser"><div class="login">ログイン</div></a>
				
			<% }else{ %>
				<h3><div class="page">マイページ${sessionScope.loginname}</div></h3>
				
				<h3><a href="exhibit"><div class="exhibit">出品</div></a></h3>
				<a href="mypage">マイページ</a>
				<a href="chargejsp"><div class="point">ポイントチャージ</div></a>
				<a href="logout"><div class="logout">ログアウト</div></a>
			<% } %>
			
			
			
			
			<a href="category"><div class="testcategory">カテゴリー</div></a>
					<div class="viewtest">
					<div id="nav-drawer">
      <input id="nav-input" type="checkbox" class="nav-unshown">
      <label id="nav-open" for="nav-input"><span></span></label>
      <label class="nav-unshown" id="nav-close" for="nav-input"></label>
      
      <div id="nav-content">
      <div class="viewcategory">
      
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
                       
                       
                       <div class="tops">
               <ul>
                <li><a href="#">トップス </a></li>
                <li><a href="#">アウター </a></li>
                <li><a href="#">パンツ</a></li>
                </ul>
                
                </div>
                
                <div class="categoryclothes">
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
			
			

		${sessionScope.loginid}
		${sessionScope.loginname}
		
		<div class ="syouhin">
		
		<c:forEach var="product" items="${data}">
			<a href="detail?item_id=${product.item_id}" style="text-decoration:none;" onclick='document.submit(); return false;'>
					
					<div class="parent">
							
							
				<!--<div>アイテムID(${product.item_id})</div>-->
				<div class="img">
				<img src="<c:url value='/images/${product.image1}'/>">
				<script>
								var sold1=`<img src="<c:url value='images/sold.png'/>" class="sold">`
								if(${product.available}==1){
								document.write(sold1)
								}else{}
				</script>
				</div>
				<div>商品名[${product.name}]</div>
				<div>${product.price}円</div>
				<div>${product.available}</div>
		</div>
			</c:forEach>
	</a>
	</div>
	<div class="meruacri">
	<a href="exhibit"><img src="images/merucari.png"></a>
	</div>
	
	</div>
	</body>
	
</html>