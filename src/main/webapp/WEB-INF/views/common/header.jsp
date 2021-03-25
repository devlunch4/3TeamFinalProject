<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
/*플로팅메뉴 스타일*/
/* body { */
/* background-color: #b83737 */
/*#f2f2f2 */
/* } */

/* main { */
/* 	margin-bottom: 200% */
/* } */
.floating-menu {
	border-radius: 100%;
	z-index: 999;
	padding-top: 0px;
	padding-bottom: 0px;
	right: 0;
	position: fixed;
	display: inline-block;
	top: 35%;
	-webkit-transform: translateY(-50%);
	-ms-transform: translateY(-50%);
	transform: translateY(-50%);
	opacity: 0.3;
}

.main-menu {
	margin: 0;
	padding-left: 0;
	list-style: none
}

.main-menu li a {
	display: block;
	padding: 10px;
	color: #fff;
	border-radius: 100%;
	position: relative;
	-webkit-transition: none;
	-o-transition: none;
	transition: none
}

.main-menu li a:hover {
	background: rgba(244, 244, 244, .3)
}

.menu-bg {
	background-image: -webkit-linear-gradient(top, #1C5E91 0, #167699 100%);
	background-image: -o-linear-gradient(top, #1C5E91 0, #167699 100%);
	background-image: -webkit-gradient(linear, left top, left bottom, from(#1C5E91),
		to(#167699));
	background-image: linear-gradient(to bottom, #1C5E91 0, #167699 100%);
	/*백그라운드 색*/
	background-repeat: repeat-x;
	position: absolute;
	width: 100%;
	height: 100%;
	border-radius: 50px;
	z-index: -1;
	top: 0;
	left: 0;
	-webkit-transition: .1s;
	-o-transition: .1s;
	transition: .1s
}

/* .ripple { */
/* 	position: relative; */
/* 	overflow: hidden; */
/* 	transform: translate3d(0, 0, 0) */
/* } */

/* .ripple:after { */
/* 	content: ""; */
/* 	display: block; */
/* 	position: absolute; */
/* 	width: 100%; */
/* 	height: 100%; */
/* 	top: 0; */
/* 	left: 0; */
/* 	pointer-events: none; */
/* 	background-image: radial-gradient(circle, #000 10%, transparent 10.01%); */
/* 	background-repeat: no-repeat; */
/* 	background-position: 50%; */
/* 	transform: scale(10, 10); */
/* 	opacity: 0; */
/* 	transition: transform .5s, opacity 1s */
/* } */

/* .ripple:active:after { */
/* 	transform: scale(0, 0); */
/* 	opacity: .2; */
/* 	transition: 0s */
/* } */
</style>

<!-- floating right topt bottom -->
<script>
	$(document).ready(function() {
		$(function() {
			$('#homeup').click(function() {
				$('body,html').animate({
					scrollTop : 0
				}, 800);
				return false;
			});
			var scrollHeight = $(document).height();
			$('#homedown').click(function() {
				$('body,html').animate({
					scrollTop : document.body.scrollHeight
				}, 800);
				return false;
			});
		});

	});
</script>
<!-- floating right topt bottom -->
<nav class="floating-menu">
	<ul class="main-menu">
		<li><a href="#homeup" id="homeup" style="text-decoration: none;">↑</a></li>
		<li><a href="#homedown" id="homedown" style="text-decoration: none;">↓</a></li>
	</ul>
	<div class="menu-bg"></div>
</nav>
<!-- floating setting 끝 -->

<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
	<a class="navbar-brand" id="logo" href="${pageContext.request.contextPath}/user/main""><img src="${pageContext.request.contextPath}/resources/src/img/logo.png" alt="똑똑한 농부들" /></a>
	<button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#">
		<i class="fas fa-bars"></i>
	</button>
	<!-- Navbar Search-->
	<form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
		<div class="input-group header-search">
			<input class="form-control" type="text" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2" />
			<div class="input-group-append">
				<button class="btn btn-primary" type="button">
					<i class="fas fa-search"></i>
				</button>
			</div>
		</div>
	</form>
	<!-- Navbar-->
	<ul class="navbar-nav ml-auto ml-md-0">
		<c:if test="${S_USER != null}">
			<li class="m-auto"><span class="text-white" style="font-size: 0.5rem">${S_USER.user_id }</span></li>
		</c:if>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
			<div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">

				<c:if test="${S_USER != null}">
					<form action="userCheck" method="POST">
						<a class="" href="#">최근로그인시간</a>
					</form>
					<form action="userCheck" method="POST">
						<a class="dropdown-item" href="${pageContext.request.contextPath}/user/userCheck">마이페이지</a>
					</form>
					<div class="dropdown-divider"></div>
					<form action="logOut">
						<a class="dropdown-item" href="${pageContext.request.contextPath}/login/logout">로그아웃</a>
					</form>
				</c:if>

				<c:if test="${S_USER == null}">
					<a class="dropdown-item" href="${pageContext.request.contextPath}/login/view">로그인</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="${pageContext.request.contextPath}/join/view">회원가입</a>
				</c:if>

			</div></li>
	</ul>
</nav>