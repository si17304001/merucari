<%@ page language="java" contentType="text/html; charset=Windows-31J" pageEncoding="Windows-31J"%>
<html>
	<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/images/createuser.css" type="text/css">
	<title>���i�o�^</title>
	</head>
	<body>
	<div class="createuser">
	<form method='post' action='adduser'>
		<h2>���������</h2>
		<hr>
		���[�UID<br><input type='text' name='ui' placeholder="���[�UID"class="ui"><br>
		�j�b�N�l�[��<br><input type='text' name = 'nn' placeholder="�j�b�N�l�[��" class="nn"><br>
		�p�X���[�h<br><input type='text' name='ps' placeholder="�p�X���[�h" class="ps"><br>
		���[��<br><input type='text' name='em' placeholder="���[��" class="em"><br>
		
		<h3>�{�l�m�F</h3>
		����<br><input type='text' name='n' placeholder="����" class="n"><br>
		�X�֔ԍ�<br><input type='number' name='zc' placeholder="�X�֔ԍ�" class="zc"><br>
		�s���{��<br><select name="pc" class="pc">
<option value="01">�k�C��</option>
<option value="02">�X��</option>
<option value="03">��茧</option>
<option value="04">�{�錧</option>
<option value="05">�H�c��</option>
<option value="06">�R�`��</option>
<option value="07">������</option>
<option value="08">��錧</option>
<option value="09">�Ȗ،�</option>
<option value="10">�Q�n��</option>
<option value="11">��ʌ�</option>
<option value="12">��t��</option>
<option value="13">�����s</option>
<option value="14">�_�ސ쌧</option>
<option value="15">�V����</option>
<option value="16">�x�R��</option>
<option value="17">�ΐ쌧</option>
<option value="18">���䌧</option>
<option value="19">�R����</option>
<option value="20">���쌧</option>
<option value="21">�򕌌�</option>
<option value="22">�É���</option>
<option value="23">���m��</option>
<option value="24">�O�d��</option>
<option value="25">���ꌧ</option>
<option value="26">���s�{</option>
<option value="27">���{</option>
<option value="28">���Ɍ�</option>
<option value="29">�ޗǌ�</option>
<option value="30">�a�̎R��</option>
<option value="31">���挧</option>
<option value="32">������</option>
<option value="33">���R��</option>
<option value="34">�L����</option>
<option value="35">�R����</option>
<option value="36">������</option>
<option value="37">���쌧</option>
<option value="38">���Q��</option>
<option value="39">���m��</option>
<option value="40">������</option>
<option value="41">���ꌧ</option>
<option value="42">���茧</option>
<option value="43">�F�{��</option>
<option value="44">�啪��</option>
<option value="45">�{�茧</option>
<option value="46">��������</option>
<option value="47">���ꌧ</option>
</select><br>
		�s�撬���ȉ�<br><input type='text' name='add2' placeholder="�s�����ȉ�" class="add"><br>
		<input type='submit' value='�o�^' class="submit">
	</form>
	</div>
	</body>
</html>