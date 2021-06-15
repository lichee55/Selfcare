<%@page import="java.util.List"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table width="700" border="3" bordercolor="lightgray" align="center">
		<thead>
			<tr>
				<td>no</td>
				<td>제 목</td>								
				<td>글쓴이</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
		</thead>		
		<c:forEach var="diary" items="${diarys}">
			<tr>
				<td><a href="detail?id=${diary.diary_Id}">${diary.diary_Id}</td>
				<!--게시글 조회를 위한 href는 query string 사용, method = GET
				href는 상대경로 사용 -> 현재경로 board/board-list, 요청경로 board/detail + request parameter -->								
				<td>${diary.content}</a></td>								
				<td>${diary.mem_id}</td>
				<td>${diary.regdate}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/board/insert" method="GET">새 글 작성</a>
</body>
</html>