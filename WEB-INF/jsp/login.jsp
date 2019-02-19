<%@ page language="java" contentType="text/html; charset=Windows-31J" pageEncoding="windows-31J" %>
<html>
<head><title>ログイン</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/images/login.css" type="text/css">

</head>
<body>
			<h3>キーワード検索</h3><a href="keysearch"></a>
			<form action="keysearch" method="get" class="form1">
				<input type="search" name="key" placeholder="キーワードから探す" class="searchkey">
				
				<!--<i class="fas fa-search"></i>-->
				 <input type="image" src="images/虫眼鏡のアイコン.png" width="15" height="15" alt="検索" name="submit" value="検索" class="submit">
				 
			</form>
							<div class="loginuser">
							<header >
			<a href="category"><div class="login">カテゴリー</div></a>
					<div class="loginuser1">
					<div id="nav-drawer">
      <input id="nav-input" type="checkbox" class="nav-unshown">
      <label id="nav-open" for="nav-input"><span></span></label>
      <label class="nav-unshown" id="nav-close" for="nav-input"></label>
      
      <div id="nav-content">
      <div class="logintest">
      
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
                
                <div class="categorytclothes">
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
			<div class="usertest">
	<form method='post' action='loginu'>
	<a href="userregist"><div class="account">新規アカウント作成</div></a><br>
	<input type='text' name='em' placeholder="メール" class="email"><br>
	<input type='text' name='ps' placeholder="パスワード" class="password"><br>
		<% if(session.getAttribute("loginid")==null){ %>
	<input type='submit' value='ログイン' class="loginbutton">
			<% }else{ %>
				<h3><div class="page">マイページ${sessionScope.loginname}</div></h3>
				
				<h3><a href="exhibit"><div class="exhibit">出品</div></a></h3>
				<a href="XXXX">マイページ(リンク先未作成)</a>
				<a href="chargejsp"><div class="button2">ポイントチャージ</div></a>
				<a href="logout"><div class="logout">ログアウト</div></a>
			<% } %>
	</form>
	</div>
</body>
</html>