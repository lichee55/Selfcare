<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post">
		<input type="hidden" value=${diary.diary_Id} name="diary_id">
		<label for="uname"><b>내용</b></label> 
		<textarea type="text" name="contents" rows=10>${diary.contents}</textarea>
		<br>
		<label for="uname"><b>게시일</b></label> 
		<input type="text" value=${diary.regdate} name="regdate" readonly>
		<br>
		<input type="submit" value="수정" onclick="javascript: form.action='/diary/update';"/>
		<input type="submit" value="삭제" onclick="javascript: form.action='/diary/delete';"/>
	</form>

</body>
</html>