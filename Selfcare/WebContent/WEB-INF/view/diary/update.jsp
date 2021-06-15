
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.contentContainer {
	width: 90%;
	height: auto;
	display: block;
	margin: 2rem auto;
}
.inputContent{
	border:none;
	border-right:0px; 
	border-top:0px; 
	boder-left:0px; 	
	boder-bottom:0px;
	width: 100%;
	height: 300px;
}

@media ( max-width :1100px) {
	.info {
		display: block;
		width: 100%;
		line-height: 3rem;
	}
}

}
</style>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	
	<div class="contentContainer">
	<span> <strong>일기 작성</strong></span>
	<form method="post">
		<textarea type="text" name="contents" class="inputContent">${diary.content}</textarea>
		<br>
		<input type="hidden" value=${diary.diary_Id} name="diary_id">
		<input type="submit" value="수정" onclick="javascript: form.action='/diary/update';"/>
	</form>
	</div>

</body>
</html>

