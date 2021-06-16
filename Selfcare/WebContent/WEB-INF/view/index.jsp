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
			<strong>��� �Ұ�</strong>

		</p>
		<p class="greeting">
			<strong>Self Care</strong>
		</p>
		<p class="summary">'Self Care' �ϱ�, �� �ϸ���Ʈ, �Խ����� ���� ���� ������ �⸣��, ��ǥ��
			�޼��ϸ�, �ٸ� ������ �Բ� �̾߱��ϸ� ������ �� �־��.</p>
		<div class="contents-area">
			<h4 class="title0401">�ϱ�</h4>
			<div class="contents-box">
				<p class="word-type01">
					<strong>�ϻ� �� ������ ������ ����غ�����</strong><br> ����� ������ �Ϸ縦 �ϱ�� ���� ��
					�־��.
				</p>
			</div>
		</div>
		<div class="contents-area">
			<br>
			<h4 class="title0401">�� �ϸ���Ʈ</h4>
			<div class="contents-box">
				<p class="word-type01">
					<strong>�̷��� �ʴ� ������ ����������</strong><br> ���ϸ��� �ؾ� �� �ϵ��� ����ϸ� ��������
					�� �ϵ��� �����ϸ� �̷��� �ʵ��� ����� ������.
				</p>
			</div>
		</div>
		<div class="contents-area">
			<br>
			<h4 class="title0401">�Խ���</h4>
			<div class="contents-box">
				<p class="word-type01">
					<strong>�����ϰ� �����ϸ� �����ؿ�</strong><br> ���� ��ǥ�� �ϱ⸦ �Խ��ǿ� �����ϰ� ���
					������� �ٸ� ������ �����̳� ������ �ְ���� �� �־��.
				</p>
			</div>
		</div>
	</div>
</body>
</html>