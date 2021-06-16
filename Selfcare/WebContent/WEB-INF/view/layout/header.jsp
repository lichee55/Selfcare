<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
html, body {
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
}

a {
	text-decoration: none;
}

.container {
	position: static;
	width: 100%;
	top: 0;
	left: 0;
	padding: 0;
	display: inline-block;
	height: 6.375rem;
	background-color: #50bcdf;
}

.navbar-brand {
	position: absolute;
}

#top-menu {
	position: static;
	width: auto;
	float: right;
	display: block;
	margin: 0;
	border: 0;
	border-radius: 0;
}

#span-side {
	float: right;
}

#top-menu .navbar-nav {
	float: none;
	height: auto;
	padding-right: 3rem;
	padding-left: 0;
	list-style: none;
}

#top-menu .navbar-nav>li>a {
	display: block;
	text-align: center;
	height: 50px;
	font-size: 1rem;
	font-weight: 700;
	padding: 0 0 0 0;
}

#top-menu ul>li {
	border: 1px solid #fff;
	display: inline-block;
	text-align: center;
	width: 100px;
	height: 50px;
	line-height: 50px;
}

@media ( max-width : 1100px) {
	#top-menu {
		display: none;
	}
	#mySidenav {
		width: 0;
	}
}

@media ( min-width : 1101px) {
	#span-side {
		display: none;
	}
	#mySidenav {
		display: none;
	}
}

.sidenav {
	height: 20rem;
	width: 100%;
	display: inline-block;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: #111;
	overflow-x: hidden;
	transition: 0.5s;
	padding-top: 60px;
}

.sidenav a {
	padding: 8px 8px 8px 32px;
	width: 100px;
	font-size: 25px;
	color: #818181;
	display: block;
	transition: 0.3s;
}

.sidenav .closebtn {
	position: absolute;
	top: 0;
	right: 25px;
	font-size: 36px;
	margin-left: 50px;
}
</style>
</head>
<body>
	<div class="container">
		<h1 class="navbar-brand">
			<a href="/main/index" class="active" onmouseout="blackStyle(this)"
				onmouseover="redStyle(this)">Self Care</a>
		</h1>

		<div id="mySidenav" class="sidenav">
			<a href="javascript:void(0)" class="closebtn" onclick="closeNav()"
				onmouseout="grayStyle(this)" onmouseover="redStyle(this)">&times;</a>
			<a href="/diary/list" onmouseout="grayStyle(this)"
				onmouseover="redStyle(this)">일기</a> <a href="/task/"
				onmouseout="grayStyle(this)" onmouseover="redStyle(this)">할 일</a> <a
				href="/board/list" onmouseout="grayStyle(this)"
				onmouseover="redStyle(this)">게시판</a> <a href="/main/login"
				onmouseout="grayStyle(this)" onmouseover="redStyle(this)">로그인</a>
		</div>
		<span id="span-side" style="font-size: 30px; cursor: pointer"
			onclick="openNav()" onmouseout="blackStyle(this)"
			onmouseover="redStyle(this)">&#9776;</span>

		<div id="top-menu">
			<ul class="navbar-nav">
				<li><a href="/diary/list" class="active"
					onmouseout="blackStyle(this)" onmouseover="redStyle(this)">일기</a></li>
				<li><a href="/task/" class="active"
					onmouseout="blackStyle(this)" onmouseover="redStyle(this)">할 일</a>
				</li>
				<li><a href="/board/list" class="active"
					onmouseout="blackStyle(this)" onmouseover="redStyle(this)">게시판</a>
				</li>
				<c:choose>
					<c:when test="${empty sessionScope.member }">
						<li><a href="/main/login" class="active"
							onmouseout="blackStyle(this)" onmouseover="redStyle(this)">로그인</a>
						</li>
					</c:when>
					<c:otherwise>
				 안녕하세요! ${member.name } 님!
					<li><a href="/main/logout" class="active"
							onmouseout="blackStyle(this)" onmouseover="redStyle(this)">로그아웃</a>
						</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
	<script>
		function openNav() {
			document.getElementById("mySidenav").style.width = "100%"
		}
		function closeNav() {
			document.getElementById("mySidenav").style.width = "0"
		}

		function redStyle(x) {
			x.style.color = "#ff0000";
		}
		function blackStyle(x) {
			x.style.color = "#444444";
		}
		function grayStyle(x) {
			x.style.color = "#818181";
		}
	</script>
</body>
</html>