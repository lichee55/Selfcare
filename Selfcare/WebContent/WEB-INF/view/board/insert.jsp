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
		<label for="uname"><b>제목</b></label> <input type="text" name="title">
		<br> <label for="uname"><b>내용</b></label>
		<textarea type="text" name="contents" rows=10></textarea>
		<br>
		<button type="submit">등록</button>
	</form>

</body>
</html>