<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- <script>document.location="create"</script> -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	$(function() {
		$("#modifyBtn").on("click", function() {
			$("#frm").attr("method", "post");
			$("#frm").attr("action", "modifyCode2");
			$("#frm").submit();
		});

		$("#category").on("change", function() {
			var aa = $("#category").val()

			if (aa == 'Y') {
				$('#use_yn').val('Y').trigger('change');
			} else if (aa == 'N') {
				$('#use_yn').val('N').trigger('change');
			}
		});

	})
</script>

<div class="container-fluid">
	<h3 class="mt-4">코드이름 [ ${code.code_nm } ] 의 코드 수정</h3>
	<form class="form-horizontal" id="frm" role="form">
		<input type="hidden" name="code_seq" value="${code.code_seq} " />

		<div class="form-group row">
			<div class="col-sm-4">
				<label class="small mb-1" for="code_seq1">코드 순서</label>
				<input name="code_seq1" class="form-control" readonly="readonly" value="${code.code_seq }" />
			</div>
			<div class="col-sm-4">
				<label class="small mb-1" for="input_cls_code">코드번호</label>
				<input name="code_no" class="form-control" value="${code.code_no }" />
			</div>
			<div class="col-sm-4">
				<label class="small mb-1" for="input_cls_code">코드이름</label>
				<input name="code_nm" class="form-control" value="${code.code_nm }" />
			</div>
		</div>


		<div class="form-group row">
			<div class="col-sm-4">
				<label class="small mb-1" for="input_cls_code">상위코드</label>
				<input name="parent_code" class="form-control" value="${code.parent_code }" />
			</div>
			<div class="col-sm-4">
				<label class="small mb-1" for="input_cls_code">사용여부변경</label> <select id="category" class="form-control" data-style>
					<option value="x" selected="selected">사용관리</option>
					<option id="Y" value="Y">코드사용</option>
					<option id="N" value="N">코드미사용</option>
				</select>
			</div>
			<div class="col-sm-4">
				<label class="small mb-1" for="input_cls_code">사용여부상태</label>
				<input id="use_yn" name="use_yn" readonly="readonly" class="form-control" value="${code.use_yn }" />
			</div>
		</div>

		<div class="form-group">
			<div class="text-right">
				<div class="m-2 p-1">
					<button type="button" id="modifyBtn" class="btn btn-warning col-sm-3">코드수정</button>
				</div>
			</div>
		</div>

	</form>
</div>