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
	<form action="comment" method="post">
		<table border="3">
			<c:forEach var="comment" items="${comments}">
				<tr>
					<td>${comment.mem_id}</td>
					<td>${comment.regdate}</td>
					<td>${comment.contents}</td>
					<button type="submit" value="수정" onclick="location.href='commentUpdate.jsp'">수정</button>
					<button type="submit" value="삭제">삭제</button>
				</tr>
			</c:forEach>
		</table>
		
		<td><textarea rows="7" cols="50" name="comment_content"></textarea></td>
		<button type="submit" value="저장">저장</td>
		
	</form>
</body>
</html>