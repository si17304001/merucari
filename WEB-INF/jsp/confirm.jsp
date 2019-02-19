<%@ page language="java" contentType="text/html; charset=windows-31J" pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
	<script>
		var url = ["CantReSend"];
		var count = 0;
		// URLを順々に書き換える
		setInterval(function() {
    		var path = location.pathname;
    		// URL書き換え
    		window.history.pushState(null, null, path + '#' + url[count]);
    		if(count < url.length - 1) {
        		count++;
    		} else {
        		count = 0;
    		}
		}, 1);
	
	</script>
	
	<title>商品一覧</title>

	</head>
	<body><h1>出品完了！</h1>
		<h1><a href="home">ホームへ戻る</a></h1>
		
		
		
		
	</body>
</html>