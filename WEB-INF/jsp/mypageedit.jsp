<%@ page language="java" contentType="text/html; charset=windows-31J" pageEncoding="windows-31J"%>
<html>
	<head><title>���ҏW</title></head>
	<body>
	<form method='post' action='mypageedit'>
		�j�b�N�l�[��<input type='text' name='user_nickname' value="${data.nickname}">
		���ȏЉ�<input type='text' name='user_introduction' value="${data.introduction}">
		����<input type='text' name='user_name' value="${data.name}">
		�X�֔ԍ�<input type='text' name = 'user_zipcode' value="${data.zip_code}"><br>
		�s���{���i�ԍ�)<input type='number' name='user_prefcode' value="${data.pref_code}">
		�s�����ȉ�<input type='text' name='user_address2' value="${data.address2}">
		
		<input type='submit' value='����'>
	</form>
	</body>
</html>