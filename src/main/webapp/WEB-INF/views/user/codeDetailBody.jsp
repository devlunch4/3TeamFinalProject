<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- <script>document.location="create"</script> -->

<script>
	$(function() {
		$("#modifyBtn").on("click", function() {
			$("#frm").attr("method", "post");
			$("#frm").attr("action", "modifyCode");
			$("#frm").submit();
		});

		 
	})
</script>

<div class="container-fluid">
	<h3 class="mt-4">${code.code_no } 의정보</h3>
	<form class="form-horizontal" id="frm" role="form">
		<input type="hidden" name="code_seq" value="${code.code_seq} " />
		
		<div class="form-group">
			<label class="small mb-3" for="input_cls_code">코드 고유번호</label>
			<div class="col-sm-10">
				<input name="user_id" class="form-control" readonly="readonly" value="${code.code_seq }" />
			</div>
		</div>

		<div class="form-group">
			<label class="small mb-1" for="input_cls_code">코드번호</label>
			<div class="col-sm-10">
				<input name="user_pw" class="form-control" readonly="readonly" value="${code.code_no }" />
			</div>
		</div>

		<div class="form-group">
			<label class="small mb-1" for="input_cls_code">코드이름</label>
			<div class="col-sm-10">
				<input name="user_nm" class="form-control" readonly="readonly" value="${code.code_nm }" />
			</div>
		</div>

		<div class="form-group">
			<label class="small mb-1" for="input_cls_code">상위코드</label>
			<div class="col-sm-10">
				<input name="email" class="form-control" readonly="readonly" value="${code.parent_code }" />
			</div>
		</div>

		<div class="form-group">
			<label class="small mb-1" for="input_cls_code">사용여부</label>
			<div class="col-sm-10">
				<input name="mobile" class="form-control" readonly="readonly" value="${code.use_yn }" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="button" id="modifyBtn" class="btn btn-warning">코드수정</button>
			</div>
		</div>

	</form>
</div>