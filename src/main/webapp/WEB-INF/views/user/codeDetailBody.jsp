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
	<h3 class="mt-4">코드이름 [ ${code.code_nm } ] 의 코드 정보</h3>
	<form class="form-horizontal" id="frm" role="form">
		<input type="hidden" name="code_seq" value="${code.code_seq }" />

		<div class="form-group row">
			<div class="col-sm-3">
				<label class="small mb-1" for="code_seq1">코드순번</label>
				<input name="code_seq1" class="form-control text-center" readonly="readonly" value="${code.code_seq }" />
			</div>
			<div class="col-sm-3">
				<label class="small mb-1" for="code_no">코드번호</label>
				<input name="code_no" class="form-control text-center" readonly="readonly" value="${code.code_no }" />
			</div>
			<div class="col-sm-3">
				<label class="small mb-1" for="code_nm">코드이름</label>
				<input name="code_nm" class="form-control text-center" readonly="readonly" value="${code.code_nm }" />
			</div>
			<div class="col-sm-3">
				<label class="small mb-1" for="parent_code">상위코드</label>
				<input name=parent_code class="form-control text-center" readonly="readonly" value="${code.parent_code }" />
			</div>
		</div>

		<div class="form-group row">
			<div class="col-sm-3">
				<label class="small mb-1" for="use_yn">사용여부</label>
				<input name="use_yn" class="form-control text-center" readonly="readonly" value="${code.use_yn }" />
			</div>
		</div>
		<div class="form-group">
			<div class="text-right">
				<button type="button" id="modifyBtn" class="btn btn-warning col-sm-3">코드수정</button>
			</div>
		</div>

	</form>
</div>