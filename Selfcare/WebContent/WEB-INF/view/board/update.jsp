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
	background-color: #f0f0f0
}

.infoPart {
	width: 100%;
	margin-bottom: 2rem;
}

.title {
	display: inline-block;
	width: 45%;
	line-height: 3rem;
}

.info {
	display: inline-block;
	width: 45%;
	line-height: 3rem;
}

.contentPart {
	display: inline-block;
	width: 100%;
	height: auto;
}
.inputContent{
	border:none;
	border-right:0px; 
	border-top:0px; 
	boder-left:0px; 	
	boder-bottom:0px;
	width: 99.5%;
	height: 6rem;
	background-color: #f0f0f0
}
.inputTitle{
	border:none;
	border-right:0px; 
	border-top:0px; 
	boder-left:0px; 	
	boder-bottom:0px;
	background-color: #f0f0f0
}
@media ( max-width :1100px) {
	.info {
		display: block;
		width: 100%;
		line-height: 3rem;
	}
}
</style>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<form method="post">
	<div class="contentContainer">
		<div class="infoPart">
			<div class="title">
				<input type="hidden" value=${board.board_Id } name="board_id">
				<span> <strong>글 제목</strong></span> 
				<input class="inputTitle" type="text" value=${board.title } name="title">
			</div>
			<div class="info">
				<span> <strong>글 작성자</strong>
				</span> <span class="writerContent">${board.mem_id }</span> <span> <strong>글
						작성시간</strong>
				</span> <span class="regdateContent">${board.regdate }</span>
			</div>
		</div>

		<div class="contentPart">
			<span><strong>글 내용</strong></span>
			<div class="content">
				<textarea class="inputContent" type="text" name="contents" rows=10>${board.contents}</textarea>
			</div>
		</div>
		<br>
		<input type="submit" value="수정" onclick="javascript: form.action='/board/update';"/>
		</div>
	</form>
</body>
</html>