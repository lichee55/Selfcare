<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<label for="uname"><b>제목</b></label> 
			<input type="text" value=${board.title} name="title" readonly>
			<br>
			<label for="uname"><b>내용</b></label> 
			<textarea type="text" name="contents" rows=10 readonly>${board.contents}</textarea>
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
	<form method="get">
		<input type="hidden" value=${board.board_Id} name="board_id">
			
		<input type="submit" value="수정" onclick="javascript: form.action='/board/update?id=${board.board_Id}';"/>
	</form>
</body>
</html>