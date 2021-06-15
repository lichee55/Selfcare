<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page= "../layout/header.jsp"/>
	<form method="post">
		<input type="hidden" value=${board.board_Id} name="board_id">
		<label for="uname"><b>제목</b></label> 
		<input type="text" value=${board.title} name="title">
		<br>
		<label for="uname"><b>내용</b></label> 
		<textarea type="text" name="contents" rows=10>${board.contents}</textarea>
		<br>
		<label for="uname"><b>작성자</b></label> 
		<input type="text" value=${board.mem_id} name="mem_id" readonly>
		<br>
		<label for="uname"><b>게시일</b></label> 
		<input type="text" value=${board.regdate} name="regdate" readonly>
		<br>
		<label for="uname"><b>조회수</b></label> 
		<input type="text" value=${board.hit} name="hit" readonly>
		<br>
		<input type="submit" value="수정" onclick="javascript: form.action='/board/update';"/>
		<input type="submit" value="삭제" onclick="javascript: form.action='/board/delete';"/>
	</form>
 
</body>
</html>