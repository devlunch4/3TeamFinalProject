<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<title>allUser</title>
<link rel="stylesheet"
	href="../resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="../resources/bootstrap/dist/css/adminlte.min.css">
<script src="<c:url value="/js/jquery.min.js" />"></script>
<script type="text/javascript">
	//사용자 클릭시 이동
	$(function() {
		$(".user").on("click", function() {
			//this : 클릭 이벤트가 발생한 element
			//data-속성명 >> data-userid >> $(this).data("userid"),
			//속성명은 대소문자를 무시하고 소문자로 인식
			//console.log($(this).data("userid"))
			var userid = $(this).data("userid");
			$("#userid").val(userid);
			$("#frm").submit();
		});
		
		//페이지 보기 변경 작업
		$("#pageSize").on("change", function() {
			$("#frm2").attr("action", "${cp}/user/pagingUserSearch");
			$("#frm2").submit();
		});
		// $("select").val(${param.lang }); //==> $("select").val(en); 오류발생
		$("#pageSize").val(${pageVo.pageSize });//==> $("select").val("en"); 정상 처리
				
		
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
		<form id="frm" action="/user/userForm">
			<input type="hidden" id="userid" name="userid" value="">
		</form>
		<!-- Navbar -->
		<%@ include file="/WEB-INF/views/common/navi.jsp"%>
		<!-- Main Sidebar Container -->
		<%@ include file="/WEB-INF/views/common/mainside.jsp"%>
		<!-- 		<div id="if_list_div"
			style="position: relative; padding: 0; overflow: scroll; height: 750px;"> -->
		<div class="content-wrapper" style="min-height: 584px;">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row md-2">
						<div class="col-sm-6">
							<h1>회원 리스트 한페이지로 보기</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item">회원리스트</li>
								<li class="breadcrumb-item">목록</li>
							</ol>
						</div>
					</div>
				</div>
			</section>


			<div class="container-fluid">
				<!-- Main content -->
				<section class="content">
					<div class="card">
						<!-- card header -->
						<%@ include file="/WEB-INF/views/common/cardheadersearchbar.jsp"%>

						<div class="card-body" style="text-align: center;">
							<div class="row">
								<div class="col-sm-12">
									<table class="table table-bordered">
										<tbody>
											<tr>
												<th>아이디</th>
												<th>패스워드</th>
												<th>별명</th>
												<th>도로주소</th>
												<th>등록날짜</th>
												<!-- yyyy-MM-dd  -->
											</tr>
											<c:forEach items="${userList }" var="user">
												<tr class="user" data-userid="${user.userid }">
													<td>${user.userid }</td>
													<td>${user.pass }</td>
													<td>${user.alias }</td>
													<td><c:choose>
															<c:when test="${user.addr1 != null }"> ${user.addr1 } </c:when>
															<c:otherwise> [empty]</c:otherwise>
														</c:choose>${user.addr2 }</td>
													<td><fmt:formatDate value="${user.reg_dt }"
															pattern="yyyy-MM-dd" /></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<!-- col-sm-12 -->
							</div>
							<!-- row -->
						</div>
						<!-- card-body -->
						<div class="card-footer">
							<nav aria-label="member list Navigation">
								<ul class="pagination justify-content-center m-0">
									<li class="page-item"><a class="page-link" href="#"><i
											class="fas fa-angle-double-left"></i></a></li>
									<li class="page-item"><a class="page-link" href="#"><i
											class="fas fa-angle-left"></i></a></li>
									<li class="page-item active"><a class="page-link" href="#">1</a></li>
									<li class="page-item"><a class="page-link" href="#"><i
											class="fas fa-angle-right"></i></a></li>
									<li class="page-item"><a class="page-link" href="#"><i
											class="fas fa-angle-double-right"></i></a></li>
								</ul>
							</nav>

						</div>
						<!-- card-footer -->
					</div>
					<!-- card  -->
				</section>

			</div>
		</div>
	</div>
	</div>
</body>
</html>
