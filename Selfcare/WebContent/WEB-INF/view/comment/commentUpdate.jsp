<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form method = "post">
		<input type ="hidden" value="${comment.comment_Id}" name="comment_id">
		<input type = "hidden" value="${comment.regdate}" name="regdate">
		<input type = "hidden" value="${comment.board_Id}" name="board_id">
		<input type = "hidden" value="${comment.mem_id}" name="member_id">
		<td><textarea rows="7" cols="50" name="content">${comment.contents}</textarea></td>
		<button type="submit" value="수정" onclick="javascript: form.action='/board/detail?id=${board.board_Id}">수정</button>
	</form>
</body>
</html>