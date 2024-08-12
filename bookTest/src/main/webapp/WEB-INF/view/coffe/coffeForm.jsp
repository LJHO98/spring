<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/write.css">
</head>
<body>
<div id=wrap>
	<h2>커피 등록</h2>
	<a href="/coffe">HOME</a>
	<form method="post" action="/coffeWrite">
		<div id="formWrap">
			<div class="inputField">
				<label for="coffeName">커피</label>
				<input type="text" name="itemName" id="itemName">
			</div>
			<div class="inputField">
				<label for="price">가격</label>
				<input type="number" name="price" id="price">
			</div>
			<div class="inputField">
				<label for="isDecaffein">디카페인 여부</label>
				<input type="checkbox" name="decaffein" id="decaffein">
			</div>
			<button id="bt">등록</button>
		</div>
	</form>
</div>
</body>
</html>