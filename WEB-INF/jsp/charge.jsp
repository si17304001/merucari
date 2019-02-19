<%@ page language="java" contentType="text/html; charset=windows-31J" pageEncoding="windows-31J"%>
<html>
	<head><title>チャージ</title></head>
	<body>
	<form method='post' action='charge'>
		${sessionScope.loginname}のアカウントへチャージ<br>
		<input type='hidden' name='user_id' value=${sessionScope.loginid}>
		金額<input type='number' name='charge_amount'>
		<input type='submit' value='チャージ'>
	</form>
	
	
	コードでチャージ(未作成)
	<form>
		ユーザーID<input type='text' name='user_id'>
		コード<input type='text' name ='charge_amount'>
	</form>
	
	</body>
</html>