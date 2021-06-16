<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

.formT {
	display: inline_block;
}

.formParent {
	display: inline_block;
}

.delBtn {
	display: inline-block;
}

.commentPart {
	width: 100%;
}

.comment {
	padding: 1rem;
}

.commentWriter {
	display: inline-block;
	width: 25%;
}

.writerField {
	display: inline-block;
	width: 25%;
}

.contentField {
	display: inline-block;
	width: 50%;
}

.commentInsertDiv {
	display: inline-block;
	width: 100%;
	
}

.commentInsertForm{
	display: inline-block;
	width:70%;
	margin : 1rem auto;
	
}

.insertComment {
	margin: 1rem auto;
	width: 50%;
	display: inline-block;
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

				<input type="submit" class="formT" value="글 수정"
					onclick="javascript: form.action='/board/update?id=${board.board_Id}';" />
			</form>
			<form method="post">
				<input type="hidden" value=${board.board_Id } name="board_id">

				<input type="submit" class="formT" value="글 삭제"
					onclick="javascript: form.action='/board/delete';" />
			</form>
		</div>
		<br> <br> <br>
		<div class="commentPart">
			<div>
				<strong>댓글</strong>
			</div>
			<div class="comment">
				<strong class="writerField">작성자</strong><strong class="contentField">내용</strong><strong class="timeField">시간</strong>
			</div>
			<c:forEach var="comment" items="${comments}">
				<div class="comment">
					<span class="commentWriter"> <span>${comment.mem_id }</span>
					</span> <span class="contentField">${comment.contents }</span>
					<span class="timeField">${comment.regdate }</span>

					<c:if test="${member.mem_Id ==comment.mem_id }">
						<div class="delBtn">
							<form method="post" action="deletecomment">
								<input type="hidden" value="${board.board_Id }" name="board_id">
								<input type="hidden" value="${comment.comment_Id }"
									name="comment_id"> <input type="submit" value="댓글 삭제">
							</form>
						</div>
					</c:if>

				</div>
			</c:forEach>
			<div class="commentInsertDiv">
				<form method="post" action="insertcomment" class="commentInsertForm">
					<input type="hidden" value="${board.board_Id }" name="board_id">
					<input type="text" name="content" class="insertComment"> <input
						type="submit" value="댓글 작성">
				</form>
			</div>
		</div>
	</div>

</body>
</html>