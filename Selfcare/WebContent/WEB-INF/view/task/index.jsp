<%@page import="java.util.List"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page= "../layout/header.jsp"/>
	<br />�ù�
	<br />
	<c:forEach var="tasks0" items="${task0}" varStatus="status">
		${tasks0.contents}<br />
	</c:forEach>
	<c:forEach var="tasks1" items="${task1 }">
		${tasks1.contents}<br />
	</c:forEach>
	<c:forEach var="tasks2" items="${task2 }" varStatus="status">
		<div>�������ͽ� �ε��� ${status.index}</div>
		<div>
			�½�ũ2 ������ ${tasks2.contents}<br />
		</div>
	</c:forEach>
	<c:forEach var="tasks3" items="${task3 }">
		${tasks3.contents}<br />
	</c:forEach>
	<c:forEach var="tasks4" items="${task4 }">
		${tasks4.contents}<br />
	</c:forEach>
</body>
</html>