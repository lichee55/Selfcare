<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  table {
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
  @media 
only screen and (max-width: 1100px),(min-device-width: 768px) and (max-device-width: 1024px){

	/* Force table to not be like tables anymore */
	table, thead, tbody, th, td, tr { 
		display: block; 
	}
	
	/* Hide table headers (but not display: none;, for accessibility) */
	thead tr { 
		position: absolute;
		top: -9999px;
		left: -9999px;
	}
	table
	{
		table-layout: fixed;
	}
	tr { border: 1px solid #ccc; }
	
	td { 
		/* Behave  like a "row" */
		border: none;
		border-bottom: 1px solid #eee; 
		position: relative;
		padding-left: 50%;
		white-space: normal;
		word-wrap: break-word;
	}
	
	td:before { 
		/* Now like a table header */
		position: absolute;
		/* Top/left values mimic padding */
		top: 6px;
		left: 6px;
		width: 45%; 
		padding-right: 10px; 
		white-space: nowrap;
	}
	
	/*
	Label the data
	*/
	td:nth-of-type(1):before { content: "no"; }
	td:nth-of-type(2):before { content: "내용"; }
	td:nth-of-type(3):before { content: "작성일"; }
	td:nth-of-type(4):before { content: " "; }
	td:nth-of-type(5):before { content: " "; }

}
</style>
</head>
<body>
	<jsp:include page= "../layout/header.jsp"/>
	<div class="tableDiv">
	<table width="700" border="3" bordercolor="lightgray" align="center" style="white-space: normal;">
		<thead>
			<tr>
				<td>no</td>
				<td>내용</td>
				<td>작성일</td>
				<td></td>
				<td></td>
			</tr>
		</thead>
		<c:forEach var="diary" items="${diarys}">
			<tr>
				<td>${diary.diary_Id}</td>
				<!--게시글 조회를 위한 href는 query string 사용, method = GET
				href는 상대경로 사용 -> 현재경로 board/board-list, 요청경로 board/detail + request parameter -->
				<td>${diary.content}</td>
				<td>${diary.regdate}</td>
				<td><a href="/diary/update?id=${diary.diary_Id }" method="get">글
						수정</a></td>
				<form method="post">
					<input type="hidden" value="${diary.diary_Id}" name="diary_id">
					<td><input type="submit" value="삭제"
						onclick="javascript: form.action='/diary/delete';" /></td>
				</form>
			</tr>
		</c:forEach>
	</table>
	</div>
	<div align="center">
		<c:forEach var="cnt" begin="1" end="${totalPage}">
			<a href="list?page=${cnt}">${cnt}</a>
		</c:forEach>
	</div>
	<a href="/diary/insert" method="GET">새 일기 작성</a>
	<script>
        window.onkeydown = function(){
            if(event.keyCode==37){
                location.href="/board/list";
            }
            else if(event.keyCode==39){
                location.href="/task/";
            }
        }
    </script>
</body>
</html>