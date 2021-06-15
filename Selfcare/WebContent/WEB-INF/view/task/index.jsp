<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
.taskContainer {
	width: 90%;
	margin: 3rem auto;
}

.day {
	display: inline-block;
	width: 18%;
	text-align: center;
	vertical-align: top;
}

.delBtn {
	display: inline-block;
}
</style>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />


	<div class="taskContainer">
		<div class="day">
			<span><strong>D + 2</strong></span>
			<c:forEach var="tasks0" items="${task0}">
				<div>
					<span>${tasks0.contents}</span>
					<div class="delBtn">
						<form action="delete" method="post">
							<input type="hidden" value="${tasks0.task_Id } id=" task_id" />
							<input type="submit" value="삭제" />
						</form>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="day">
			<span><strong>D + 1</strong></span>
			<c:forEach var="tasks1" items="${task1 }">
				<div>
					<span>${tasks1.contents}</span>
					<div class="delBtn">
						<form action="delete" method="post">
							<input type="hidden" value="${tasks1.task_Id } id=" task_id" />
							<input type="submit" value="삭제" />
						</form>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="day">
			<span><strong>D - Day</strong></span>
			<c:forEach var="tasks2" items="${task2 }">
				<div>
					<span>${tasks2.contents}</span>
					<div class="delBtn">
						<form action="delete" method="post">
							<input type="hidden" value="${tasks2.task_Id } id=" task_id" />
							<input type="submit" value="삭제" />
						</form>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="day">
			<span><strong>D - 1</strong></span>
			<c:forEach var="tasks3" items="${task3 }">
				<div>
					<span>${tasks3.contents}</span>
					<div class="delBtn">
						<form action="delete" method="post">
							<input type="hidden" value="${tasks3.task_Id } id=" task_id" />
							<input type="submit" value="삭제" />
						</form>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="day">
			<span><strong>D - 2</strong></span>
			<c:forEach var="tasks4" items="${task4 }">
				<div>
					<span>${tasks4.contents}</span>
					<div class="delBtn">
						<form action="delete" method="post">
							<input type="hidden" value="${tasks4.task_Id } id=" task_id" />
							<input type="submit" value="삭제" />
						</form>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>