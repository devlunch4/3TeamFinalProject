<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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

<title>userRegist</title>

<!-- Font Awesome Icons -->
<link rel="stylesheet"
	href="../resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="../resources/bootstrap/dist/css/adminlte.min.css">


<!-- 주소 입력 부분 다음 API 활용 -->
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<%
UserVo userVo = (UserVo) request.getAttribute("userVo");
%>

<script src="<c:url value="/js/jquery.min.js" />"></script>
<script>
	$(function() {

		//주소 검색 버튼이 클릭 되었을 때 다음주소API 팝업을 연다			
		$("#addrBtn").on("click", function() {
			new daum.Postcode({
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
					// 예제를 참고하여 다양한 활용법을 확인해 보세요.
					$("#addr1").val(data.roadAddress); // 도로명 주소
					$("#zipcode").val(data.zonecode); // 우편주소

					//사용자 편의성을 위해 상세주소 입력 input 태그로 focus 설정
					$("#addr2").focus();
				}
			}).open();
		});

		//입력 리셋
		$("#resetBtn").on("click", function() {
			$("#frm").attr("method", "get");
			$("#frm").attr("action", "${cp }/user/userRegist");
			$("#frm").submit();
		});

	});
</script>

<script type="text/javascript">
	function initData() {
		$("#userId").val("1234");
		$("#userNm").val("테스터");
		$("#userAlias").val("tester");
		$("#pass").val("1234");
		$("#reg_dt").val("2021.01.01");
		$("#addr1").val("테스트주소1");
		$("#addr2").val("테스트주소2");
		$("#zipcode").val("123456");
	}
</script>
</head>

<body>
	<div class="wrapper">

		<!-- Navbar -->
		<%@ include file="/WEB-INF/views/common/navi.jsp"%>
		<!-- Main Sidebar Container -->
		<%@ include file="/WEB-INF/views/common/mainside.jsp"%>
		<form class="form-horizontal" role="form" id="frm"></form>


		<!-- 	<div id="if_list_div"
			style="position: relative; padding: 0; overflow: hidden;"> -->
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<section class="content register-page" style="height: 100%;">
				<div class="container-fluid">
					<div class="login-logo">
						<b>회원 등록</b>
					</div>
					<!-- form start -->
					<div class="card">
						<div class="register-card-body">
							<form class="form-horizontal" role="form"
								action="${cp }/user/userRegist" method="POST"
								enctype="multipart/form-data">
								<input type="hidden" name="userId" value="" />

								<div class="form-group">
									<label for="userId" class="col-sm-2 control-label">사용자
										아이디</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="userid"
											name="userid" placeholder="사용자 아이디" value="${param.userid}" required="required">

										<!-- 사용자 이름 글자수 제한 관련 msg-->
										<span style="color: red;"> <form:errors
												path="userVo.userid" />
										</span> <input type="file" class="form-control" name="profile">
									</div>
								</div>

								<div class="form-group">
									<label for="userNm" class="col-sm-2 control-label">사용자
										이름</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="usernm"
											name="usernm" placeholder="사용자 이름" value="${param.usernm}" required="required">
									</div>
								</div>

								<div class="form-group">
									<label for="pass" class="col-sm-2 control-label">비밀번호</label>
									<div class="col-sm-10">
										<input type="password" class="form-control" id="pass"
											name="pass" placeholder="Password" value="${param.pass}" required="required">
									</div>
								</div>

								<div class="form-group">
									<label for="reg_dt" class="col-sm-2 control-label">사용자등록일</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="reg_dt2"
											name="reg_dt2" placeholder="사용자 등록일" value="${param.reg_dt}" />
									</div>
								</div>

								<div class="form-group">
									<label for="userNm" class="col-sm-2 control-label">별명</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="alias"
											name="alias" placeholder="별명" value="${param.alias}" />
									</div>
								</div>

								<div class="form-group">
									<label for="addr1" class="col-sm-2 control-label">도로주소</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" id="addr1"
											name="addr1" placeholder="주소 검색 버튼 클릭" value="${param.addr1}"
											readonly />
									</div>
									<div class="col-sm-2">
										<button type="button" id="addrBtn" class="btn btn-default">주소
											검색</button>
									</div>
								</div>

								<div class="form-group">
									<label for="addr2" class="col-sm-2 control-label">상세주소</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="addr2"
											name="addr2" placeholder="상세주소" value="${param.addr2}" />
									</div>
								</div>

								<div class="form-group">
									<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="zipcode"
											name="zipcode" placeholder="우편번호" value="${param.zipcode}"
											readonly />
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" class="btn btn-default">등록 완료</button>&nbsp;&nbsp;&nbsp;
										<button type="button" class="btn btn-default" id="resetBtn">등록
											초기화</button>
									</div>

								</div>
							</form>
						</div>
					</div>
				</div>
			</section>
		</div>
	</div>


</body>
</html>
