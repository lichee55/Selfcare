<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<label for="uname"><b>제목</b></label> 
		<input type="text" name="title">
		<label for="uname"><b>작성자</b></label>
		<input type="text" name="mem_id">
		<br>
		<label for="uname"><b>내용</b></label> 
		<textarea type="text" name="contents" rows=10 ></textarea>
		<br>
		<button type="submit">등록</button>
	</form>
	
</body>
</html>