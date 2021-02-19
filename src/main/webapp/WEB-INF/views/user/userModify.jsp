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

<title>UserModify</title>

<%--common_lib.jsp == 공통 라이브러리 --%>
<%-- <%@ include file="/WEB-INF/views/common/common_lib.jsp"%>
<link href="${cp }/css/dashboard.css" rel="stylesheet">
<link href="${cp }/css/blog.css" rel="stylesheet"> --%>




<!-- Font Awesome Icons -->
<link rel="stylesheet"
	href="../resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="../resources/bootstrap/dist/css/adminlte.min.css">

<!-- 주소설정 -->
<script src="<c:url value="/js/jquery.min.js" />"></script>
<!-- 주소 입력 부분 다음 API 활용 -->
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	//주소 검색 버튼이 클릭 되었을 때 다음주소API 팝업을 연다
	$(function() {
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

		$("#gopageBtn").on("click", function() {
			$("#frm").attr("method", "get");
			$("#frm").attr("action", "${cp }/user/pagingUser");
			$("#frm").submit();
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

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">

			<!-- Main content -->
			<section class="content register-page" style="height: 100%;">

				<div class="container-fluid">
					<div class="login-logo">
						<b>회원 정보 수정</b>
					</div>
					<div class="card">


						<div class="register-card-body">

							<form class="form-horizontal" role="form"
								action="${cp }/user/userModify" method="POST"
								enctype="multipart/form-data">
								<input type="hidden" name="userid" value="${user.userid }" />


								<div class="form-group row">
									<label for="userId" class="col-sm-2 control-label">사용자
										사진</label>
									<div class="col-sm-10">

										<div class="mailbox-attachment-icon has-img" id="pictureView">
											<img src="${cp }/user/profile?userid=${user.userid }"
												id="pictureViewImg" style="width: auto; height: 100px;" />
										</div>

										<div class="mailbox-attachment-info">
											<div class="input-group input-group-sm">
												<input type="file" class="form-control" id="profile"
													name="profile" accept=".gif, .jpg, .png"
													style="height: 37px;">
											</div>
										</div>

									</div>
								</div>

								<div class="form-group row">
									<label for="userId" class="col-sm-2 control-label">사용자
										아이디</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="userId"
											name="userId" placeholder="사용자 아이디" value="${user.userid }"
											readonly />
									</div>
								</div>

								<div class="form-group row">
									<label for="userNm" class="col-sm-2 control-label">사용자
										이름</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="usernm"
											name="usernm" placeholder="사용자 이름" value="${user.usernm }"
											required="required" />
									</div>
								</div>

								<div class="form-group row">
									<label for="pass" class="col-sm-2 control-label">비밀번호</label>
									<div class="col-sm-10">
										<input type="password" class="form-control" id="pass"
											name="pass" placeholder="Password" value="${user.pass}"
											required="required" />
									</div>
								</div>

								<div class="form-group row">
									<label for="reg_dt" class="col-sm-2 control-label">사용자등록일</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="reg_dt2"
											name="reg_dt2" placeholder="사용자등록일"
											value="<fmt:formatDate
									value="${user.reg_dt }" pattern="yyyy.MM.dd" />"
											readonly />
									</div>
								</div>

								<div class="form-group row">
									<label for="userNm" class="col-sm-2 control-label">별명</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="alias"
											name="alias" placeholder="별명" value="${user.alias }" />
									</div>
								</div>

								<div class="form-group row">
									<label for="addr1" class="col-sm-2 control-label">도로주소</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" id="addr1"
											name="addr1" placeholder="주소" value="${user.addr1 }" readonly />
									</div>
									<div class="col-sm-2">
										<button type="button" id="addrBtn" class="btn btn-default">주소
											검색</button>
									</div>
								</div>

								<div class="form-group row">
									<label for="addr2" class="col-sm-2 control-label">상세주소</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="addr2"
											name="addr2" placeholder="상세주소" value="${user.addr2 }" />
									</div>
								</div>

								<div class="form-group row">
									<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="zipcode"
											name="zipcode" placeholder="우편번호" value="${user.zipcode }"
											readonly />
									</div>
								</div>


								<div class="form-group row">
									<div class="">
										<button type="submit" class="btn btn-default">수정 완료</button>
										&nbsp;&nbsp;&nbsp;
										<button type="button" id="cancelBtn"
											class="btn btn-default float-right"
											onClick="location.href='/user/pagingUser'">수정취소/목록이동</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</section>
		</div>
	</div>

	<script>
		$(document).ready(function() {
			// picture input의 파일 변경시 이벤트 
			$("#profile").change(function() {
				readURL(this);
			});
		});

		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#pictureViewImg').attr('src', e.target.result);
				}
				reader.readAsDataURL(input.files[0]);
			}
		}
	</script>
</body>
</html>