<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관리</title>
<link rel = "stylesheet" href="/css/default.css">
</head>
<body>
	<div id="wrap">
		<h2> 도서 관리 </h2>
		<div id="mainTitle">
			<h3>등록 도서 목록</h3>
			<a href="/bookWrite" id="enroll">도서등록</a>
		</div>
		<div id="bookListWrap">
			<ul id="bookList">
				<c:forEach var="row" items="${list }">
					<li class="blist">
						<span class="title"><a href="/book/view?id=${row.bookId}">${row.bookTitle }</a></span>
						<span class="auth">${row.bookAuthor }</span>
						<span class="bookCode">${row.bookId }</span>
						<span class="category">${row.publisher }</span>
					</li>
				</c:forEach>
				<li class="blist">
					<span class="title">자바의 기초</span>
					<span class="auth">홍길동</span>
					<span class="bookCode">ca1231421</span>
					<span class="category">컴퓨터 프로그래밍 언어</span>
				</li>
				<li class="blist">
					<span class="title">엄준식은 살아있다</span>
					<span class="auth">랄로</span>
					<span class="bookCode">ds2114</span>
					<span class="category">소설</span>
				</li>
				<li class="blist">
					<span class="title">이상한나라의 앨리스</span>
					<span class="auth">안드레센</span>
					<span class="bookCode">ze31414</span>
					<span class="category">동화</span>
				</li>
				<li class="blist">
					<span class="title">비트코인으로 돈복사하기</span>
					<span class="auth">워렌 버핏</span>
					<span class="bookCode">da3155135</span>
					<span class="category">경제</span>
				</li>
				<li class="blist">
					<span class="title">나 찾기</span>
					<span class="auth">김자</span>
					<span class="bookCode">qw31533</span>
					<span class="category">자기개발</span>
				</li>
			</ul>
		
		</div>
		
	</div>

</body>
</html>