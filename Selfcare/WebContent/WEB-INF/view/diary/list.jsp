<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="700" border="3" bordercolor="lightgray" align="center">
		<thead>
			<tr>
				<td>no</td>
				<td>내용</td>
				<td>작성일</td>
			</tr>
		</thead>
		<c:forEach var="diary" items="${diarys}">
			<tr>
				<td>${diary.diary_Id}</td>
				<!--게시글 조회를 위한 href는 query string 사용, method = GET
				href는 상대경로 사용 -> 현재경로 board/board-list, 요청경로 board/detail + request parameter -->
				<td>${diary.content}</a></td>
				<td>${diary.regdate}</td>
				<td><a href="/diary/update?id=${diary.diary_Id }" method="get">글
						수정</a></td>
				<form method="post">
					<input type="hidden" value="${diary.diary_Id}" name="diary_id">
					<td><input type="submit" value="삭제"
						onclick="javascript: form.action='/diary/delete';" /></td>
				</form>
			</tr>
		</c:forEach>
	</table>
	<div align="center">
		<c:forEach var="cnt" begin="1" end="${totalPage}">
			<a href="list?page=${cnt}">${cnt}</a>
		</c:forEach>
	</div>
	<a href="/diary/insert" method="GET">새 일기 작성</a>
</body>
</html>