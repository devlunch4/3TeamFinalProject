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

<title>UserFrom</title>

<!-- Font Awesome Icons -->
<link rel="stylesheet"
	href="../resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="../resources/bootstrap/dist/css/adminlte.min.css">


<!-- 주소설정 -->
<script src="<c:url value="/js/jquery.min.js" />"></script>
<!-- 주소 입력 부분/ DAUM API 활용 -->
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script>
	$(function() {
		$("#addrBtn").on("click", function() {
			new daum.Postcode({
				oncomplete : function(data) {
					$("#addr1").val(data.roadAddress); // 도로명 주소
					$("#zipcode").val(data.zonecode); // 우편주소
					$("#addr2").focus();
				}
			}).open();
		});
	});
</script>

<script type="text/javascript">
	//문서 로딩이 완료 되었을때
	//사용자 수정 : method : get, action = /userModify
	//사용자 수정 : method : get, action = /userDelete
	//파라미터는 둘다 userid 하나만 있으면 가능
	$(function() {
		$("#modifyBtn").on("click", function() {
			$("#frm").attr("method", "get");
			$("#frm").attr("action", "${cp }/user/userModify");
			$("#frm").submit();
		});

		$("#deleteBtn").on("click", function() {
			alert("아이디 ["+"${user.userid }" + "] 사용자 삭제 됩니다.");
			
			$("#frm").attr("method", "post");
			$("#frm").attr("action", "${cp }/user/userDelete");
			$("#frm").submit();
		});
		
		$("#gopageBtn").on("click", function() {
			$("#frm").attr("method", "get");
			$("#frm").attr("action", "${cp }/user/allUser");
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
						<b>사용자 상세 조회</b>
					</div>

					<!-- form start -->
					<div class="card">
						<div class="register-card-body">

							<form class="form-horizontal" role="form" id="frm">
								<input type="hidden" name="userid" value="${user.userid }" />

								<div class="form-group">
									<label class="col-sm-2 control-label">사용자 사진</label>
									<div class="col-sm-10">
										<%-- <img src="${cp }/profile/${user.userid }.png" /> --%>

										<a href="/user/profileDownload?userid=${user.userid }"> <img
											src="/user/profile?userid=${user.userid }"
											style="width: auto; height: 100px;" />
										</a>
									</div>
								</div>

								<div class="form-group row">
									<label for="userId" class="col-sm-2 control-label">사용자
										아이디</label>
									<div class="col-sm-10">
										<label class="control-label">${user.userid }</label>
									</div>
								</div>

								<div class="form-group row">
									<label for="userNm" class="col-sm-2 control-label">사용자
										이름</label>
									<div class="col-sm-10">
										<label class="control-label">${user.usernm }</label>
									</div>
								</div>

								<div class="form-group row">
									<label for="pass" class="col-sm-2 control-label">비밀번호</label>
									<div class="col-sm-10">
										<label class="control-label">${user.pass}</label>
									</div>
								</div>

								<div class="form-group row">
									<label for="reg_dt" class="col-sm-2 control-label">사용자등록일</label>
									<div class="col-sm-10">
										<label class="control-label"><fmt:formatDate
												value="${user.reg_dt }" pattern="yyyy.MM.dd" /></label>
									</div>
								</div>

								<div class="form-group row">
									<label for="alias" class="col-sm-2 control-label">별명</label>
									<div class="col-sm-10">
										<label class="control-label">${user.alias }</label>
									</div>
								</div>

								<div class="form-group row">
									<label for="addr1" class="col-sm-2 control-label">주소</label>
									<div class="col-sm-10">
										<label class="control-label"><c:choose>
															<c:when test="${user.addr1 != null }"> ${user.addr1 } </c:when>
															<c:otherwise> [empty]</c:otherwise>
														</c:choose></label>
									</div>
								</div>

								<div class="form-group row">
									<label for="addr2" class="col-sm-2 control-label">상세주소</label>
									<div class="col-sm-10">
										<label class="control-label">${user.addr2 }</label>
									</div>
								</div>

								<div class="form-group row">
									<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
									<div class="col-sm-10">
										<label class="control-label">${user.zipcode }</label>
									</div>
								</div>

								<div class="form-group row">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="button" id="modifyBtn" class="btn btn-default">사용자
											수정</button>
										<button type="button" id="deleteBtn" class="btn btn-default">사용자
											삭제</button>
										<button type="button" id="gopageBtn" class="btn btn-default" >목록보기</button>
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
