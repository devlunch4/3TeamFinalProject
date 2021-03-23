<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- <script>document.location="create"</script> -->

<script>
	$(function() {
		$("#modifyBtn").on("click", function() {
			$("#frm").attr("method", "post");
			$("#frm").attr("action", "modifyUser2");
			$("#frm").submit();
		});

		$("#deleteBtn").on("click", function() {
			var con_test = confirm("탈퇴시키시겠습니까?");
			if (con_test == true) {
				alert("탈퇴완료");
				$("#frm").attr("method", "post");
				$("#frm").attr("action", "deleteUser");
				$("#frm").submit();
			} else if (con_test == false) {
				alert("취소");
			}
		});

		$("#category").on("change", function() {
			var aa = $("#category").val()
			if (aa == 'Y') {
				$('#use_yn').val('Y').trigger('change');
			} else if (aa == 'N') {
				$('#use_yn').val('N').trigger('change');
			}
		});
	});
</script>

<div class="container">
	<h3 class="mt-4">회원아이디 [ ${user.user_id } ] 님 정보 - 관리자용</h3>
	<form class="form-horizontal" id="frm" role="form">

		<div class="form-group row">
			<div class="col-md-6">
				<label class="small mb-1 " for="user_id">아이디 :</label>
				<input class="form-control text-center col" type="text" name="user_id" readonly="readonly" value="${user.user_id }" />
			</div>
			<div class="col-md-6">
				<label class="small mb-1 btn-outline-danger" for="user_pw">비밀번호 :</label>
				<input class="form-control text-center btn-outline-secondary col" type="text" name="user_pw" value="${user.user_pw }" />
			</div>
		</div>

		<div class="form-group row">
			<div class="col-md-4">
				<label class="small mb-1 " for="user_nm">이름 :</label>
				<input class="form-control text-center col" type="text" name="user_nm" readonly="readonly" value="${user.user_nm }" />
			</div>
			<div class="col-md-4">
				<label class="small mb-1" for="email">이메일 :</label>
				<input class="form-control text-center col" type="text" name="email" readonly="readonly" value="${user.email }" />
			</div>

			<div class="col-md-4">
				<label class="small mb-1" for="mobile">전화번호 :</label>
				<input class="form-control text-center col" type="text" name="mobile" readonly="readonly" value="${user.mobile }" />
			</div>
		</div>


		<div class="form-group row">
			<div class="col-md-8">
				<label class="small mb-1 " for="reg_dt">등록일 :</label>
				<input class="form-control text-center col" type="text" name="user_nm" readonly="readonly" value="${user.reg_dt }" />
			</div>
			<div class="col-md-4">
				<label class="small mb-1 btn-outline-danger" for="login_fail_cnt">로그인실패 횟수 :</label>
				<input class="form-control text-center btn-outline-secondary col" type="text" name="email" value="${user.login_fail_cnt }" />
			</div>
		</div>


		<div class="form-group ">
			<div class="col-md-4">
				<label class="small mb-1" for="zip">우편번호 :</label>
				<input class="form-control text-center col" type="text" name="zip" readonly="readonly" value="${user.zip }" />
			</div>

			<div class="col-md-12">
				<label class="small mb-1 " for="addr1">주소1 :</label>
				<input class="form-control text-left col" type="text" name="addr1" readonly="readonly" value="${user.addr1 }" />
			</div>
			<div class="col-md-12">
				<label class="small mb-1" for="addr2">상세주소2 :</label>
				<input class="form-control text-left col" type="text" name="addr2" readonly="readonly" value="${user.addr2 }" />
			</div>
		</div>


		<div class="form-group row">
			<div class="col-md-6">
				<label class="small mb-1 " for="count">등록된 시설수 :</label>
				<input class="form-control text-center col" type="text" readonly="readonly" value="${count }" />
			</div>
			<div class="col-md-6">
				<label class="small mb-1 " for="ffcount">등록된 영농일지 수 :</label>
				<input class="form-control text-center col" type="text" readonly="readonly" value="${ffcount }" />
			</div>
		</div>




		<div class="form-group row">
			<div class="col-md-12">
				<label class="small mb-1" for="use_yn">사용여부</label>
			</div>

			<div class="col-md-6">
				<select id="category" class="form-control text-center " data-style>
					<option value="x" selected="selected">탈퇴여부</option>
					<option id="Y" value="Y">사용</option>
					<option id="N" value="N">탈퇴</option>
				</select>
			</div>
			<div class="col-md-6">
				<input class="form-control text-center " id="use_yn" name="use_yn" readonly="readonly" value="${user.use_yn }" />
			</div>
		</div>

		<div class="form-group row">
			<div class="col-md-12 text-right">
				<button type="button" id="deleteBtn" class="btn btn-danger col-md-3 mt-2">회원탈퇴</button>
				<button type="button" id="modifyBtn" class="btn btn-primary col-md-3 mt-2">정보수정</button>
			</div>
		</div>

	</form>
</div>