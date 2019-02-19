<%@ page language="java" contentType="text/html; charset=windows-31J" pageEncoding="windows-31J"%>
<html>
	<head><title>商品登録</title></head>
	<body>
	<form method='post' action='edit'>
		商品ID<input type='hidden' name='item_id' value="${data.item_id}">
		商品名<input type='text' name = 'name' value="${data.name}"><br>
		カテゴリー番号<input type='text' name='category' value="${data.category}"><br>
		画像1<input type='text' name='image1' value="${data.image1}"><br>
		商品サイズ<select name = size value="${data.size}">
		<option value="1">S</option>
		<option value="2">M</option>
		<option value="3">L</option>
		</select><br>
		商品説明<input type='text' name='description' value="${data.description}"><br>
		状態<input type='text' name='state' value="${data.state}"><br>
		発送までの日時<input type='text' name='postage' value="${data.shipping}"><br>
		価格<input type='text' name='price' value="${data.price}"><br>
		
		<input type='submit' value='修正'>
	</form>
	</body>
</html>