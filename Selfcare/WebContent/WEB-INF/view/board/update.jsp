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
		<form method="post">
			<input type="hidden" value=${board.board_Id} name="board_Id">
			<label for="uname"><b>����</b></label> 
			<input type="text" value=${board.title} name="title">
			<br>
			<label for="uname"><b>����</b></label> 
			<textarea type="text" name="contents" rows=10>${board.contents}</textarea>
			<br>
			<label for="uname"><b>�ۼ���</b></label> 
			<input type="text" value=${board.mem_id} name="mem_id" readonly>
			<br>
			<label for="uname"><b>�Խ���</b></label> 
			<input type="text" value=${board.regdate} name="regdate" readonly>
			<br>
			<label for="uname"><b>��ȸ��</b></label> 
			<input type="text" value=${board.hit} name="hit" readonly>
			<br>
			<input type="submit" value="����" onclick="javascript: form.action='/board/update';"/>
			<input type="submit" value="����" onclick="javascript: form.action='/board/delete';"/>
		</form>
	</legend>
</fieldset>
</body>
</html>