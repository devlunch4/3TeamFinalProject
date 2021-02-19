<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<!-- 사용하지 않으므로 삭제 <link rel="icon" href="../../favicon.ico"> -->
<title>Signin Template for Bootstrap **</title>
<%@ include file="/WEB-INF/views/common/common_lib.jsp"%>
<!-- Custom styles for this template -->
<link href="${cp }/css/signin.css" rel="stylesheet">


<!-- 쿠키 저장 -->
<script
	src="https://cdn.jsdelivr.net/npm/js-cookie@rc/dist/js.cookie.min.js"></script>
<script type="text/javascript">
	//문서 로딩이 완료되고나서 실행되는 코드
	//remember check 함수
	$(function() {
		
		//로그인 실패시
		<c:if test="${msg != null }">
		alert("${msg }");
		<c:remove var="msg"/>
		</c:if>

		//userid rememberme 쿠키를 확인하여 존재할 경우 값설정, 체크
		if (Cookies.get("userid") != undefined) {
			$("#userid").val(Cookies.get("userid"));
			$("#rememberme").prop("checked", true);
		}
		//signin 아이디를 select
		$("#signin").on("click", function() {
			//rememberme 체크박스가 체크 되어있는지 확인
			//체크되어있을 경우
			if ($("#rememberme").is(":checked") == true) {
				//userid input에 있는 값을 userid쿠키로 저장
				Cookies.set("userid", $("#userid").val());
				//rememberme 쿠키로 y 값을 저장
				Cookies.set("rememberme", "Y");
			}
			//해제 되어있는 경우 : 더이상 사용하지 않는 다는 의미이므로 userid, rememberme 쿠키 삭제
			else {
				Cookies.remove("userid");
				Cookies.remove("rememberme");
			}
			//form 태그를 이용하여 signin 요청 [[[무조건 submit으로 설정할 필요는 없다. ]]]
			$("#frm").submit();
		});
	});
</script>
</head>
<body>
	<div
		style="margin-left: auto; margin-right: auto; margin-top: 130px; ,margin-bottom: auto; 	">
		<div class="">
			<form class="form-signin" id="frm" action="${cp }/login/process"
				method="post">
				<h2>FINAL PROJECT DB SET TEST PAGE</h2>
				<h2>Please sign in</h2>
				<label for="userid" class="sr-only">userid</label> <input
					type="text" name="userid" id="userid" class="form-control"
					placeholder="사용자 계정" required autofocus value="${param.userid}">
				<label for="inputPassword" class="sr-only">Password</label> <input
					type="password" name="pass" id="inputPassword" class="form-control"
					placeholder="Password" required>
				<div class="checkbox">
					<label> <input type="checkbox" value="remember-me"
						id="rememberme"> Remember me
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="button"
					id="signin">Sign in</button>
			</form>
		</div>
	</div>
	<!-- /container -->

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<!-- <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script> -->
</body>
</html>
