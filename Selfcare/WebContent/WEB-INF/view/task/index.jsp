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

.controlField {
	display: inline-block;
	width: 100%
}

.addTask {
	display: inline-block;
	width: 60%
}

.memoField {
	display: inline-block;
	width: 30%
}
</style>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />

	<div class="taskContainer">
		<div class="controlField">
			<div class="addTask">
				<a href="/task/insert">할 일 추가(링크)</a>
			</div>
			<div class="memoField">
				<span>메모 추가</span> <input type="text" class="memoContent"> <input
					type="button" value="추가" class="addMemo">
				<div class="memoContents"></div>
				<input type="button" value="메모 전체삭제" class="delMemo">
			</div>
		</div>
		<br> <br>
		<div class="day">
			<span><strong>D + 2</strong></span>
			<c:forEach var="tasks0" items="${task0}">
				<div>
					<span>${tasks0.contents}</span>
					<div class="delBtn">
						<form action="delete" method="POST">
							<input type="hidden" value="${tasks0.task_Id }" name="task_id" />
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
						<form method="POST" action="delete">
							<input type="hidden" value="${tasks1.task_Id }" name="task_id" />
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
						<form action="delete" method="POST">
							<input type="hidden" value="${tasks2.task_Id }" name="task_id" />
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
						<form method="POST" action="delete">
							<input type="hidden" value="${tasks3.task_Id }" name="task_id" />
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
						<form action="delete" method="POST">
							<input type="hidden" value="${tasks4.task_Id }" name="task_id" />
							<input type="submit" value="삭제" />
						</form>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<script>
		window.onkeydown = function() {
			if (event.keyCode == 37) {
				location.href = "";
			} else if (event.keyCode == 39) {
				location.href = "";
			}
		}

		addBtn = document.querySelector(".addMemo");
		addBtn.addEventListener("click", function() {
			memoFiled = document.querySelector(".memoContents");
			memo = document.querySelector(".memoContent");
			memoFiled.innerHTML += "<div>" + memo.value + "</div>";
			memo.value = "";
		});

		delBtn = document.querySelector(".delMemo");
		delBtn.addEventListener("click", function() {
			memoFiled = document.querySelector(".memoContents");
			memoFiled.innerHTML = "";
		});
	</script>
</body>
</html>