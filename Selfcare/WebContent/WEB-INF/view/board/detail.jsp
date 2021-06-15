<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<fieldset disabled>
	<legend>
		<form method="get">
			<input type="hidden" value=${board.board_Id} name="board_Id">
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
			<input type="submit" value="수정" onclick="javascript: form.action='/board/board/update?id=${board.board_Id}';"/>
		</form>
	</legend>
</fieldset>
</body>
</html>