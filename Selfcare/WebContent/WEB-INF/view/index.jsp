<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
.content-wrap {
	display: inline-block;
	padding-left: 20px;
}

.introduce {
	font-size: 34px;
}

.greeting {
	font-size: 25px;
	color: #00a6f7;
}

.summary {
	font-size: 20px;
}

.title0401 {
	margin: 0 0 10px 0;
	padding-left: 30px;
	color: #333333;
	font-size: 22px;
	line-height: 26px;
	font-weight: 500;
	background-repeat: no-repeat;
	background-position: left 3px;
	background-size: 18px 18px;
	word-break: keep-all;
}

.word-type01 {
	padding-left: 30px;
}

.word-type01>strong {
	font-size: 20px;
}

@media ( max-width :1100px) {
	.background-self {
		display: none;
	}
}

@media ( min-width :1101px) {
	.background-self {
		display: block;
	}
}
</style>
</head>
<body>
	<jsp:include page="./layout/header.jsp" />
	<div class="background-self">
		<img src="https://cdn.discordapp.com/attachments/853855726379204610/854584122454048818/SelfCareIMG.jpg" width=100%>
	</div>
	<div class="content-wrap">
		<p class="introduce">
			<strong>기능 소개</strong>

		</p>
		<p class="greeting">
			<strong>Self Care</strong>
		</p>
		<p class="summary">'Self Care' 일기, 할 일리스트, 게시판을 통해 좋은 습관을 기르고, 목표를
			달성하며, 다른 사람들과 함께 이야기하며 성장할 수 있어요.</p>
		<div class="contents-area">
			<h4 class="title0401">일기</h4>
			<div class="contents-box">
				<p class="word-type01">
					<strong>일상 속 감사한 순간을 기록해보세요</strong><br> 성장과 감사의 하루를 일기로 남길 수
					있어요.
				</p>
			</div>
		</div>
		<div class="contents-area">
			<br>
			<h4 class="title0401">할 일리스트</h4>
			<div class="contents-box">
				<p class="word-type01">
					<strong>미루지 않는 습관을 가져보세요</strong><br> 매일매일 해야 할 일들을 기록하며 빠짐없이
					할 일들을 수행하며 미루지 않도록 노력해 보세요.
				</p>
			</div>
		</div>
		<div class="contents-area">
			<br>
			<h4 class="title0401">게시판</h4>
			<div class="contents-box">
				<p class="word-type01">
					<strong>공유하고 응원하며 성장해요</strong><br> 나의 목표와 일기를 게시판에 공유하고 댓글
					기능으로 다른 사람들과 응원이나 공감을 주고받을 수 있어요.
				</p>
			</div>
		</div>
	</div>
</body>
</html>