<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
			<label for="uname"><b>����</b></label> 
			<textarea type="text" name="content" rows=10 readonly>${diary.content}</textarea>
			<br>
			<label for="uname"><b>�Խ���</b></label> 
			<input type="text" value=${diary.regdate} name="regdate" readonly>
			<br>
	<form method="get">
		<input type="hidden" value=${diary.diary_Id} name="board_id">
			
		<input type="submit" value="����" onclick="javascript: form.action='/diary/update?id=${diary.diary_Id}';"/>
	</form>
</body>
</html>