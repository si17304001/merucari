<%@ page language="java" contentType="text/html; charset=Windows-31J" pageEncoding="windows-31J" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>resetPassword</title>
<style type="text/css">
	.error {
		color: red;
		padding-left:5px;
	}
</style>


</head>
<body>
<% 
        String path = request.getContextPath(); 
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
        String name = request.getParameter("Email");//用request得到 
%> 
	<form action="rpw" method="post">
		<span class="error" style="display: block;">${errors.passwordError}</span>
		email：<input type="text" name="em" value="${param.Email}" readonly="readonly"/><br/>
		パスワード：<input type="text" name="ps" /><span class="error">${errors.ps }</span><br/>
		確認パスワード：<input type="text" name="ps2"/><span class="error">${errors.ps2 }</span><br/>
		<input type="submit" value="ok" />
	</form>

</body>
</html>