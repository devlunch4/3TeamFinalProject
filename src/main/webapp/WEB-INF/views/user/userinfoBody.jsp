<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script>
	$(function() {

		$("#modifyBtn").on("click", function() {
			$("#frm").attr("method", "post");
			$("#frm").attr("action", "modifyUser");
			$("#frm").submit();
		});

		$("#deleteBtn").on("click", function() {
			var con_test = confirm("정말로 탈퇴하시겠습니까??");
			if (con_test == true) {
				 alert("탈퇴완료");
				$("#frm").attr("method", "post");
				$("#frm").attr("action", "deleteUser2");
				$("#frm").submit();
			} else if (con_test == false) {
				alert("취소");
			}

		});

	});
</script>

<main>
	<%-- 							<label class="form-control">${S_USER.addr1 }테스트주소1</label> --%>

	<div class="container-fluid">
		<h3 class="mt-4">마이페이지</h3>
		<form class="form-horizontal" id="frm" role="form">
			<input type="hidden" name="user_id" value="${S_USER.user_id }" />

			<div class="form-group">
				<label class="small mb-3" for="input_cls_code">성명</label>
				<div class="col-sm-10">
					<input readonly="readonly" name="user_nm" class="form-control" value="${S_USER.user_nm }" />
				</div>
			</div>

			<div class="form-group">
				<label class="small mb-1" for="input_cls_code">아이디</label>
				<div class="col-sm-10">
					<input readonly="readonly" name="user_id2" class="form-control" value="${S_USER.user_id }" />
				</div>
			</div>

			<div class="form-group">
				<label class="small mb-1" for="input_cls_code">비밀번호</label>
				<div class="col-sm-10">
					<input readonly="readonly" name="user_pw" class="form-control" value="${S_USER.user_pw }" />
				</div>
			</div>

			<div class="form-group">
				<label class="small mb-1" for="input_cls_code">이메일</label>
				<div class="col-sm-10">
					<input readonly="readonly" name="email" class="form-control" value="${S_USER.email }" />
				</div>
			</div>

			<div class="form-group">
				<label class="small mb-1" for="input_cls_code">전화번호</label>
				<div class="col-sm-10">
					<input readonly="readonly" name="mobile" class="form-control" value="${S_USER.mobile }" />
				</div>
			</div>

			<div class="form-group">
				<label class="small mb-1" for="input_cls_code">주소</label> <br>

				<div class="col-sm-10 mb-1">
					<input readonly="readonly" id="addr1" class="form-control" value="${S_USER.addr1 }" />
				</div>
				<div class="col-sm-10 mb-1">
					<input readonly="readonly" id="addr2" class="form-control" value="${S_USER.addr2 }" />
				</div>
				<div class="col-sm-10 mb-1">
					<input readonly="readonly" id="zip" class="form-control" value="${S_USER.zip }" />
				</div>
			</div>

			<div class="form-group text-right">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" id="deleteBtn" class="btn btn-danger">회원탈퇴</button>
					<button type="button" id="modifyBtn" class="btn btn-warning">정보수정</button>
				</div>
			</div>

		</form>
	</div>
</main>