<%@ page language="java" contentType="text/html; charset=Windows-31J" pageEncoding="windows-31J" %>
<html>
<head><title>���O�C��</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/images/login.css" type="text/css">

</head>
<body>
			<h3>�L�[���[�h����</h3><a href="keysearch"></a>
			<form action="keysearch" method="get" class="form1">
				<input type="search" name="key" placeholder="�L�[���[�h����T��" class="searchkey">
				
				<!--<i class="fas fa-search"></i>-->
				 <input type="image" src="images/���ዾ�̃A�C�R��.png" width="15" height="15" alt="����" name="submit" value="����" class="submit">
				 
			</form>
							<div class="loginuser">
							<header >
			<a href="category"><div class="login">�J�e�S���[</div></a>
					<div class="loginuser1">
					<div id="nav-drawer">
      <input id="nav-input" type="checkbox" class="nav-unshown">
      <label id="nav-open" for="nav-input"><span></span></label>
      <label class="nav-unshown" id="nav-close" for="nav-input"></label>
      
      <div id="nav-content">
      <div class="logintest">
      
					<ul>
            <li><a href="#">�����Y</a></li>
                 
            <li><a href="#">���f�B�[�X</a></li>
                
            <li><a href="#">�L�b�Y</a></li>
            
               <li><a href="#">�C���e���A</a></li>
               
               <li><a href="#">��������</a></li>
               <li><a href="#">�R�X��</a></li>
                  <li><a href="#">�Ɠd</a></li>
                       <li><a href="#">�L�b�Y</a></li>
                       <li><a href="#">�X�|�[�c</a></li>
                 <li><a href="#">�n���h���C�h</a></li>
                       <li><a href="#">�n���h���C�h</a></li>
                    <li><a href="#">�`�P�b�g</a></li>
                       <li><a href="#">���]��</a></li>
                       <li><a href="#">���̑�</a></li>
                       </ul>
                       </div>
                       
                       
                       <div class="tops">
               <ul>
                <li><a href="#">�g�b�v�X </a></li>
                <li><a href="#">�A�E�^�[ </a></li>
                <li><a href="#">�p���c</a></li>
                </ul>
                
                </div>
                
                <div class="categorytclothes">
                    <ul>
                       <li><a href="#">�s�V���c</a></li>
                       <li><a href="#">�V���c</a></li>
                       <li><a href="#">�e�[���[�h�W���P�b�g</a></li>
                       <li><a href="#">�m�[�J���[�W���P�b�g</a></li>
                       <li><a href="#">�f�j��</a></li>
                        <li><a href="#">���[�N�p���c</a></li>
                    </ul>
                    </div>
                    
                    </div>
                    </div>
                   </div>
			</header>
			<div class="usertest">
	<form method='post' action='loginu'>
	<a href="userregist"><div class="account">�V�K�A�J�E���g�쐬</div></a><br>
	<input type='text' name='em' placeholder="���[��" class="email"><br>
	<input type='text' name='ps' placeholder="�p�X���[�h" class="password"><br>
		<% if(session.getAttribute("loginid")==null){ %>
	<input type='submit' value='���O�C��' class="loginbutton">
			<% }else{ %>
				<h3><div class="page">�}�C�y�[�W${sessionScope.loginname}</div></h3>
				
				<h3><a href="exhibit"><div class="exhibit">�o�i</div></a></h3>
				<a href="XXXX">�}�C�y�[�W(�����N�斢�쐬)</a>
				<a href="chargejsp"><div class="button2">�|�C���g�`���[�W</div></a>
				<a href="logout"><div class="logout">���O�A�E�g</div></a>
			<% } %>
	</form>
	</div>
</body>
</html>