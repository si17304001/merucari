<%@ page language="java" contentType="text/html; charset=windows-31J" pageEncoding="windows-31J"%>
<html>
	<head><title>¤io^</title></head>
	<body>
	<form method='post' action='edit'>
		¤iID<input type='hidden' name='item_id' value="${data.item_id}">
		¤i¼<input type='text' name = 'name' value="${data.name}"><br>
		JeS[Ô<input type='text' name='category' value="${data.category}"><br>
		æ1<input type='text' name='image1' value="${data.image1}"><br>
		¤iTCY<select name = size value="${data.size}">
		<option value="1">S</option>
		<option value="2">M</option>
		<option value="3">L</option>
		</select><br>
		¤ià¾<input type='text' name='description' value="${data.description}"><br>
		óÔ<input type='text' name='state' value="${data.state}"><br>
		­ÜÅÌú<input type='text' name='postage' value="${data.shipping}"><br>
		¿i<input type='text' name='price' value="${data.price}"><br>
		
		<input type='submit' value='C³'>
	</form>
	</body>
</html>