<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<title>Main</title>

<!-- Font Awesome Icons -->
<link rel="stylesheet"
	href="../resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="../resources/bootstrap/dist/css/adminlte.min.css">


<script src="<c:url value="/js/jquery.min.js" />"></script>
<script type="text/javascript">
	$(function() {
		
		//검색
		$("#searchBtn").on("click", function() {
			searchType = $("#searchType").val();
			keyword = $("#keyword").val();
			$("#searchType").val(searchType);
			$("#keyword").val(keyword);
			$("#pageSize").val("${pageVo.pageSize }");
			$("#frm2").attr("action", "${cp}/user/pagingUserSearch");
			$("#frm2").submit();
		});
	});
</script>

</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<!-- Navbar -->
		<%@ include file="/WEB-INF/views/common/navi.jsp"%>
		<!-- Main Sidebar Container -->
		<%@ include file="/WEB-INF/views/common/mainside.jsp"%>


		<div id="if_list_div"
			style="position: relative; padding: 0; overflow: scroll; height: 750px;">
			<div class="content-wrapper" style="min-height: 584px;">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<div class="container-fluid">
						<div class="row md-2">
							<div class="col-sm-6">
								<h1>회원리스트</h1>회원 상세 정보는 회원 관리에서 사용자 클릭
							</div>
							<div class="col-sm-6">
								<ol class="breadcrumb float-sm-right">
									<li class="breadcrumb-item">완료 내역</li>
									<li class="breadcrumb-item">목록</li>
								</ol>
							</div>
						</div>
					</div>
				</section>
				<!-- Main content -->
				<section class="content">
					<div class="card">
						<!-- card header -->
						<%@ include file="/WEB-INF/views/common/cardheadersearchbar.jsp"%>

						<div class="card-body" style="text-align: center;">
							<div class="row">
								<div class="col-sm-12">
									<h1>메인 페이지입니다.</h1>
								</div>
								<!-- col-sm-12 -->
							</div>
							<!-- row -->
						</div>
						<!-- card-body -->
						<!-- card-footer -->
					</div>
					<!-- card  -->
				</section>
			</div>
		</div>
	</div>



	<!-- Main Footer -->

	<!-- ./wrapper -->

	<!-- REQUIRED SCRIPTS -->
</body>
</html>







