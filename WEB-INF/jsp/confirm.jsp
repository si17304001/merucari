<%@ page language="java" contentType="text/html; charset=windows-31J" pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
	<script>
		var url = ["CantReSend"];
		var count = 0;
		// URL�����X�ɏ���������
		setInterval(function() {
    		var path = location.pathname;
    		// URL��������
    		window.history.pushState(null, null, path + '#' + url[count]);
    		if(count < url.length - 1) {
        		count++;
    		} else {
        		count = 0;
    		}
		}, 1);
	
	</script>
	
	<title>���i�ꗗ</title>

	</head>
	<body><h1>�o�i�����I</h1>
		<h1><a href="home">�z�[���֖߂�</a></h1>
		
		
		
		
	</body>
</html>