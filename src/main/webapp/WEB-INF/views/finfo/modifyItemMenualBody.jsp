<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>
	$(function() {
		/* 20210309_ggy : 첨부파일 삭제 */
		$(document).on('click', '#file_nmDeleteBtn', function() {

			$('#file_nm').removeAttr('value');

		})
	});

	$(document).ready(function() {

		// picture input의 파일 변경시 이벤트 
		$("#picture").change(function() {
			readURL(this);
		});
	});
</script>

<h3 class="mt-4">품목 메뉴얼 수정</h3>

<form action="${pageContext.request.contextPath}/finfo/modifyItemMenual" method="post" enctype="multipart/form-data">

	<!-- ////////// -->
	<div class="form-row">
		<div class="col-md-3">
			<div class="form-group">
				<label class="small" for="writer">접속자</label>
				<input class="form-control py-4" id="writer" name="writer" type="text" readonly="readonly" value="${S_USER.user_id }" required="required">
			</div>
		</div>
		<div class="col-md-3">
			<div class="form-group">
				<label class="small" for="manual_code">매뉴얼순번</label>
				<input class="form-control py-4" id="manual_code" name="manual_code" type="text" value="${itemMenualInfo.manual_code }" readonly="readonly">
			</div>
		</div>
		<div class="col-md-3">
			<div class="form-group">
				<label class="small" for="use_yn">코드이름</label>
				<input class="form-control py-4" type="text" value="${itemMenualInfo.code_nm }" readonly="readonly">
			</div>
		</div>
		<div class="col-md-3">
			<div class="form-group">
				<label class="small" for="file_no">파일번호</label>
				<input class="form-control py-4" id="file_no" name="file_no" type="text" value="${itemMenualInfo.file_no }" readonly="readonly">
			</div>
		</div>
	</div>

	<!-- ////////// -->


	<div class="form-row">
		<div class="col-md-4">
			<div class="form-group">
				<label class="small" for="ifm_nm">메뉴얼이름</label>
				<input class="form-control py-4" id="ifm_nm" name="ifm_nm" type="text" value="${itemMenualInfo.ifm_nm }" required="required">
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<label class="small" for="file_nm">첨부파일</label>
				<input class="form-control py-4" id="file_nm" name="file_nm" type="text" value="${itemMenualInfo.file_nm }" readonly="readonly">
			</div>
		</div>
		<div class="col-md-2">
			<div class="form-group">
				<label class="small" for="file_nmx">첨부삭제버튼</label>
				<input class="form-control btn btn-danger" type="button" id="file_nmDeleteBtn" value="기존첨부삭제">
			</div>
		</div>
	</div>

	<div class="form-row">
		<div class="col-md-12">
			<label class="small mb-1" for="file_file">파일등록</label>
			<input class="" id="picture" type="file" name="file_file" accept="*.*" style="height: 37px;" />
		</div>
	</div>

	<div class="group-row text-right ">
		<input type="submit" value="등록" class="btn btn-primary mt-2">
		<input type="button" value="목록으로" class="btn btn-secondary mt-2" onclick="location.href='${pageContext.request.contextPath }/finfo/itemFarmManualsView'">
	</div>
</form>
