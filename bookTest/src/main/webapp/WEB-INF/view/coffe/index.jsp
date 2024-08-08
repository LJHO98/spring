<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/default.css">
</head>
<body>
	<div id="wrap">
		<h2> 카페메뉴관리 </h2>
		<div id="mainTitle">
			<h3>등록 메뉴 목록</h3>
			<a href="/coffeReg" id="enroll">메뉴등록</a>
		</div>
		<div id="bookListWrap">
			<ul id="bookList">
				<li class="blist">
						<span class="itemId">번호</span>
						<span class="itemName">이름</span>
						<span class="price">가격</span>
						<span class="decaffein">디카페인 여부</span>
				</li>
				<c:forEach var="row" items="${list }">
					<li class="blist">
						<span class="itemId">${row.coffeId }</span>
						<span class="itemName">${row.itemName }</span>
						<span class="price">${row.price }</span>
						<span class="decaffein">${row.decaffein == true ? "예" : "아니요"}</span>
					</li>
				</c:forEach>
			</ul>
		
		</div>
	</div>
</body>
</html>