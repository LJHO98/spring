<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/board">목록으로</a>
	<h2> 게시글 보기 </h2>
	<div>제목 : ${list.getTitle() }</div>
	<div>작성자 : ${list.writer }</div>
	<div>내용 : ${list.getContent() }</div>

</body>
</html>