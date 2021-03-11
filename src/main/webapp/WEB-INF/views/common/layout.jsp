<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />

<title>똑똑한 농부들 - 해당 게시판 EL로 넣기</title>

<link href="${pageContext.request.contextPath}/resources/src/css/styles.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/src/css/f_styles.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/src/css/dataTables.bootstrap4.min.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/resources/src/js/all.min.js"></script>

<!-- summernote -->
<script src="${pageContext.request.contextPath}/resources/summernote/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/summernote/summernote-lite.js"></script>
<script src="${pageContext.request.contextPath}/resources/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/summernote/summernote-lite.css">

</head>

<body class="sb-nav-fixed bg-primary">

	<!-- 탑 메뉴 네비게이션 -->
	<tiles:insertAttribute name="header" />

	<div id="layoutSidenav">
		<!-- 왼쪽 메뉴 네비게이션 div-->
		<div id="layoutSidenav_nav">
			<tiles:insertAttribute name="left" />
		</div>

		<!-- 실제 컨텐트가 들어가는 div -->
		<div id="layoutSidenav_content">
			<main>
			    <div class="container-fluid">
					<tiles:insertAttribute name="body"/>
				</div>
			</main>	
			<footer class="py-4 bg-light mt-auto footer">
                <div class="container-fluid">
                    <div class="d-flex align-items-center justify-content-between small">
                        <div class="text-muted">Copyright &copy; 똑똑한 농부들 2021</div>
                        <div>
                            <a href="#">Privacy Policy</a>
                            &middot;
                            <a href="#">Terms &amp; Conditions</a>
                        </div>
                    </div>
                </div>
            </footer>
		</div>
	</div>

<%-- 	<script src="${pageContext.request.contextPath}/resources/src/js/jquery.slim.min.js"></script> --%>
	<script src="${pageContext.request.contextPath}/resources/src/js/bootstrap.bundle.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/src/js/scripts.js"></script>
<%-- 	<script src="${pageContext.request.contextPath}/resources/src/js/Chart.min.js"></script> --%>
<%-- 	<script src="${pageContext.request.contextPath}/resources/src/assets/demo/chart-area-demo.js"></script> --%>
<%-- 	<script src="${pageContext.request.contextPath}/resources/src/assets/demo/chart-bar-demo.js"></script> --%>
	<script src="${pageContext.request.contextPath}/resources/src/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/src/js/dataTables.bootstrap4.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/src/assets/demo/datatables-demo.js"></script>

</body>
</html>