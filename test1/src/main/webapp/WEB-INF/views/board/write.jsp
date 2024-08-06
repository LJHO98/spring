<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 쓰기</h2>
	<form method="post" action="/write">
		제목 : <input type="text" name="title"> <br>
		작성자 : <input type="text" name="writer"> <br>
		내용 : <textarea name="content"></textarea>
		비밀번호 : <input type="password" name="boardPw"> <br>
		<button>작성</button>

	</form>
</body>
</html>