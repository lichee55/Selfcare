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
	margin-bottom: 5rem;
}
.formT
{
	display: inline_block;
}
.formParent
{
	display: inline_block;
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

	<div class="contentContainer">
		<div class="infoPart">
			<div class="title">
				<span> <strong>글 제목</strong>
				</span> <span class="titleContent">${board.title }</span>
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
			<div class="content">${board.contents }</div>
		</div>
		<div class="formParent">
		<form method="get">
			<input type="hidden" value=${board.board_Id } name="board_id">

			<input type="submit" class="formT" value="수정"
				onclick="javascript: form.action='/board/update?id=${board.board_Id}';" />
		</form>
		<form method="post">
			<input type="hidden" value=${board.board_Id } name="board_id">

			<input type="submit" class="formT" value="삭제" onclick="javascript: form.action='/board/delete';"/>
		</form>
		</div>
	</div>

</body>
</html>