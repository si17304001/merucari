<%@ page language="java" contentType="text/html; charset=Windows-31J" pageEncoding="windows-31J" %>
<html>
<head><title>ログインできない場合のお手続き</title></head>
<body>

<form action="pw" method="post">
	<span style="color: red">${requestScope.sendMailMsg}</span>
	メールアドレス：<input type="text" name="em" /><span style="color: red">${requestScope.errorMsg}</span><br/>
	<input type="submit" value="次へ" /><a href=""></a>
</form>
</body>
</html>


