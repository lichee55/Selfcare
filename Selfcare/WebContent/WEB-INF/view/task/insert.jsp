<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />

	<div class="insertContainer">
		<form method="post" action="insert">
			할 일 <input type="text" name="content"><br> 날짜 <input
				type="datetime-local" name="taskdate"><br> <input
				type="submit" value="등록">
		</form>
	</div>
</body>
</html>