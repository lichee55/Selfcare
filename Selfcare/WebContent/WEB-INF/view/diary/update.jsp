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
		<input type="hidden" value=${diary.diary_Id} name="diary_id">
		<label for="uname"><b>����</b></label> 
		<textarea type="text" name="contents" rows=10>${diary.contents}</textarea>
		<br>
		<label for="uname"><b>�Խ���</b></label> 
		<input type="text" value=${diary.regdate} name="regdate" readonly>
		<br>
		<input type="submit" value="����" onclick="javascript: form.action='/diary/update';"/>
		<input type="submit" value="����" onclick="javascript: form.action='/diary/delete';"/>
	</form>

</body>
</html>