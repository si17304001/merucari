<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
	</head>
	
	
	
	<body>
	
	
	<header>	
	
		<h3>キーワード検索</h3><a href="keysearch"></a>
			<form action="keysearch" method="get" class="form1">
				<input type="search" name="key" placeholder="キーワードから探す" class="searchkey">
				
				<i class="fas fa-search"></i>
				 <input type="submit" name="submit" value="検索" class="submit">
			</form>
			<header >
			<ul class="user">
		<% if(session.getAttribute("loginid")==null){ %>
				<h3>
				<li><a href="category">カテゴリー</a>
					<ul class="category">
						<li><a href="category">チャージ</a></li>
						<li><a href="category">レディース</a></li>
						<li><a href="category">メンズ</a></li>
					</ul>
				</li>
				
				<li><a href="loginuser">ログイン</a></li>
				<li><a href="userregist">新規アカウント作成</a></li>
				</h3>
			<% }else{ %>
				<h3>マイページ${sessionScope.loginname}</h3>
				<h1><a href="exhibit">出品</a></h1>
				<a href="XXXX">マイページ(リンク先未作成)</a>
				<a href="logout">ログアウト</a>
			<% } %>
			</ul>
			
			<h1><a href="chargejsp">ポイントチャージ</a></h1>
	</header>
	
	
	

	<p>名前:${data.ub.nickname}</p>
	<p>評価</p>
	<p>よい:${data.ub.good}</p>
	<p>ふつう:${data.ub.general}</p>
	<p>わるい:${data.ub.bad}</p>
	
	
	
	
	<p>data.SListの値${data.SList}</p>
	<p>data.ubの値${data.ub}</p>
	<h1>出品</h1>
	<h1>出品中の商品</h1>
	<c:forEach var="product" items="${data.SList}">
		<a href="detail?item_id=${product.item_id}" style="text-decoration:none;" onclick='document.submit(); return false;'>
			<div class="parent">
				<!--<div>アイテムID(${product.item_id})</div>-->
				<div><img src="<c:url value='/images/${product.image1}'/>">
				</div>
				<div>商品名[${product.name}]</div>
				<div>${product.price}円</div>
				<div>${product.available}</div>
		</div>
		
	</a>
	</c:forEach>
	
	
	
	</body>
	
</html>