<%@page import="java.util.List"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="comment" method="post">
		<c:forEach var="comment" items="${comments}">
			<tr>
				<td>${comment.mem_id}</td>
				<td>${comment.regdate}</td>
				<td>${comment.contents}</td>
				<td colspan=2 align="center"><input type="submit" value="수정">
				<td colspan=2 align="center"><input type="submit" value="삭제">
			</tr>
		</c:forEach>
		<td><textarea rows="7" cols="50" name="comment_content"></textarea>
		<td colspan=2 align="center"><input type="submit" value="저장">
	</form>
</body>
</html>