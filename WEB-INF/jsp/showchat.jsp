<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>チャット一覧</title>
	</head>
	
	<body>
	<h1>状態${data.flag}</h>
	
	<script>
		var shipping ='<form method="post" action="shipping"><input type="hidden" name="item_id" value="${data.itemid}"><input type="hidden" name="user_id" value="${sessionScope.loginid}"><p><input type="submit" value="発送通知"></p>'
		var receipt='<form method="post" action="receipt"><input type="hidden" name="item_id" value="${data.itemid}"><input type="hidden" name="user_id" value="${sessionScope.loginid}"><p><input type="submit" value="受け取り送信"></p>'
		var eval ='<form method="post" action="eval"><input type="hidden" name="item_id" value="${data.itemid}"><input type="hidden" name="user_id" value="${sessionScope.loginid}"><p>評価<br><input type="radio" name="eval" value="2"> わるい<input type="radio" name="eval" value="1"> ふつう<input type="radio" name="eval" value="3"> よい</p><p><input type="submit" value="評価する"></p>'
		if(${data.btnava}==1){
			if(${data.flag}==0){
			}else if(${data.flag}==1){
				document.write(shipping);
			}else if(${data.flag}==2){
				document.write(receipt);
			}else if(${data.flag}==3||${data.flag}==4||${data.flag}==5){
				document.write(eval);
			}
		}else{}
	</script>
	</form>
		
	
	
	<table>
	<c:forEach var="chat" items="${data.resList}">
	<table border="1">
		<tr><th>送信者${chat.userid}</th></tr>
		<tr><th>内容${chat.content}</th></tr>
		<tr><th>時間[${chat.timestamp}]</th></tr>
	</table>
	
	
	</c:forEach>
	
	
	<form method="post" action="sendchat">
<p>チャット</p>
<input type="text" name="content" size="30" maxlength="10"></p>
<input type="hidden" name="item_id" value="${data.itemid}">
<input type="hidden" name="user_id" value="${sessionScope.loginid}">
<p><input type="submit" value="送信"></p>

</form>
	

	</body>
</html>