<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<label for="uname"><b>내용</b></label> 
			<textarea type="text" name="content" rows=10 readonly>${diary.content}</textarea>
			<br>
			<label for="uname"><b>게시일</b></label> 
			<input type="text" value=${diary.regdate} name="regdate" readonly>
			<br>
	<form method="get">
		<input type="hidden" value=${diary.diary_Id} name="board_id">
			
		<input type="submit" value="수정" onclick="javascript: form.action='/diary/update?id=${diary.diary_Id}';"/>
	</form>
</body>
</html>