<%@ page language="java" contentType="text/html; charset=windows-31J" pageEncoding="windows-31J"%>
<html>
	<head><title>�`���[�W</title></head>
	<body>
	<form method='post' action='charge'>
		${sessionScope.loginname}�̃A�J�E���g�փ`���[�W<br>
		<input type='hidden' name='user_id' value=${sessionScope.loginid}>
		���z<input type='number' name='charge_amount'>
		<input type='submit' value='�`���[�W'>
	</form>
	
	
	�R�[�h�Ń`���[�W(���쐬)
	<form>
		���[�U�[ID<input type='text' name='user_id'>
		�R�[�h<input type='text' name ='charge_amount'>
	</form>
	
	</body>
</html>