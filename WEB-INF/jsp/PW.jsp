<%@ page language="java" contentType="text/html; charset=Windows-31J" pageEncoding="windows-31J" %>
<html>
<head><title>���O�C���ł��Ȃ��ꍇ�̂��葱��</title></head>
<body>

<form action="pw" method="post">
	<span style="color: red">${requestScope.sendMailMsg}</span>
	���[���A�h���X�F<input type="text" name="em" /><span style="color: red">${requestScope.errorMsg}</span><br/>
	<input type="submit" value="����" /><a href=""></a>
</form>
</body>
</html>


