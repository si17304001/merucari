<%@ page language="java" contentType="text/html; charset=windows-31J" pageEncoding="windows-31J"%>
<html>
	<head><title>商品登録</title></head>
	<body>
	<form method='post' action='add'>
		商品ID<input type='text' name='item_id'><br>
		商品名<input type='text' name = 'name'><br>
		カテゴリー番号<input type='text' name='category'><br>
		画像1<input type='text' name='image1'><br>
		商品サイズ<select name = size>
		<option value="1">S</option>
		<option value="2">M</option>
		<option value="3">L</option>
		</select><br>
		商品説明<input type='text' name='description'><br>
		状態<input type='text' name='state'><br>
		発送までの日時<input type='text' name='postage'><br>
		価格<input type='text' name='price'><br>
		出品者ID<input type='text' name='saler'><br>
		
		<input type='submit' value='登録'>
	</form>
	</body>
</html>