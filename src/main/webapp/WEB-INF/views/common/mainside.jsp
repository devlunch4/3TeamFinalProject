<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
	<!-- Brand Logo -->
	<a href="/user/main" class="brand-link"> <img
		src="../resources/images/line.png"
		class="brand-image img-circle elevation-3" style="opacity: .8">
		<span class="brand-text font-weight-light">사용자관리</span>
	</a>
	<!-- Sidebar -->
	<div class="sidebar">
		<!-- Sidebar user panel (optional) -->
		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<div class="image">
				<img src="../profile/sally.png" class="img-circle elevation-2"
					alt="User Image">
			</div>
			<div class="info">
				<div class="row">
					<a class="col-md-8" href="#" class="d-block">접속자아이디 [${S_USER.userid }]</a>
				</div>
			</div>
		</div>
		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<div class="image">
				<img src="../profile/sally.png" class="img-circle elevation-2"
					alt="User Image">
			</div>
			<div class="info">
				<div class="row">
					<a class="col-md-8" href="#" class="d-block">접속자별명 [${S_USER.alias }]</a>
				</div>
			</div>
		</div>
		

		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<div class="image">
				<img src="../profile/sally.png" class="img-circle elevation-2"
					alt="User Image">
			</div>
			<div class="info">
				<div class="row">
					<a class="col-md-8" href="/user/allUser" class="d-block">한페이지로 보기</a>
				</div>
			</div>
		</div>

		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<div class="image">
				<img src="../profile/sally.png" class="img-circle elevation-2"
					alt="User Image">
			</div>
			<div class="info">
				<div class="row">
					<a class="col-md-8" href="/user/pagingUser" class="d-block">페이지별 보기</a>
				</div>
			</div>
		</div>

		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<div class="image">
				<img src="../profile/sally.png" class="img-circle elevation-2"
					alt="User Image">
			</div>
			<div class="info">
				<div class="row">
					<a class="col-md-8" href="${cp }/login/logout" class="d-block">로그아웃</a>
				</div>
			</div>
		</div>


		<!-- Sidebar Menu -->
		<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column subMenuList"
				data-widget="treeview" data-accordion="false">

			</ul>
		</nav>
		<!-- /.sidebar-menu -->
	</div>
	<!-- /.sidebar -->
</aside>