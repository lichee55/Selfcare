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
			<input type="text" value=${board.title} name="title" readonly>
			<br>
			<label for="uname"><b>����</b></label> 
			<textarea type="text" name="contents" rows=10 readonly>${board.contents}</textarea>
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
	<form method="get">
		<input type="hidden" value=${board.board_Id} name="board_id">
			
		<input type="submit" value="����" onclick="javascript: form.action='/board/update?id=${board.board_Id}';"/>
	</form>
</body>
</html>