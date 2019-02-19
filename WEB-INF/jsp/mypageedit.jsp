<%@ page language="java" contentType="text/html; charset=windows-31J" pageEncoding="windows-31J"%>
<html>
	<head><title>情報編集</title></head>
	<body>
	<form method='post' action='mypageedit'>
		ニックネーム<input type='text' name='user_nickname' value="${data.nickname}">
		自己紹介<input type='text' name='user_introduction' value="${data.introduction}">
		氏名<input type='text' name='user_name' value="${data.name}">
		郵便番号<input type='text' name = 'user_zipcode' value="${data.zip_code}"><br>
		都道府県（番号)<input type='number' name='user_prefcode' value="${data.pref_code}">
		市町村以下<input type='text' name='user_address2' value="${data.address2}">
		
		<input type='submit' value='完了'>
	</form>
	</body>
</html>