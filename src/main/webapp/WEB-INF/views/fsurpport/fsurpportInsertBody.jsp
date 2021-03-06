<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>
	$(document).ready(function() {

		// picture input의 파일 변경시 이벤트 
		$("#picture").change(function() {
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

<h3 class="mt-4">영농일지 등록</h3>

<form action="#" method="post">
	
	<div class="form-group col-md-2">
		<label class="small mb-1" for="input_cls_code">등록일</label>
		<input id="input_cls_code" name="input_cls_code" name="reg_dt" type="date" class="form-control py-4">
	</div>
	
	<div class="form-group col-md-2">
		<label class="small mb-1" for="input_cls_code">간편 등록</label>
		<select name="" onchange="location.href=this.value">
			<option value="">선택</option>
			<c:forEach items="${mySimpleCodeList }" var="mySimpleCodeList">
				<option 
					value="${pageContext.request.contextPath}/fsurpport/selectMySimpleCodeInfo?my_simple_code=${mySimpleCodeList.my_simple_code }&user_id=${S_USER.user_id}">
					${mySimpleCodeList.alias }
				</option>
			</c:forEach>
		</select>
		
	</div>
	

	<div class="form-group col-md-6">
		<label class="small mb-6" for="input_difficulty">작업단계</label>
		<select name="">
			<option value="">선택</option>
			<c:forEach items="${workstepsList }" var="workstepsList" >
				<option value="${workstepsList.code_no }"
				<c:if test="${selectMySimpleCodeInfo.b_type_code eq workstepsList.code_nm }">selected</c:if>
				>${workstepsList.code_nm }</option>
			</c:forEach>
		</select>
	</div>

	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">작업내용</label> <br>

		<!-- 글쓰기 summernote-->
		<textarea id="summernote" name="summernote"></textarea>
		<script>
	      	$('#summernote').summernote({
		        placeholder: 'Hello SUMMERNOTE',
		        tabsize: 2,
		        height: 120,
		        toolbar: [
		          ['style', ['style']],
		          ['font', ['bold', 'underline', 'clear']],
		          ['color', ['color']],
		          ['para', ['ul', 'ol', 'paragraph']],
		          ['table', ['table']],
		          ['insert', ['link', 'picture', 'video']],
		          ['view', ['fullscreen', 'codeview', 'help']]
		        ]
	   	   });
    	</script>

	</div>

	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">날씨정보</label>
		
		<select>
			<option></option>
		</select>
		
	</div>

	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">사진 등록</label>

		<div class="mailbox-attachments clearfix" style="text-align: center; width: 100%;">
			<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;">
				<img id="pictureViewImg" style="width: 100%; height: 100%;" />
			</div>

			<div class="mailbox-attachment-info">
				<div class="">
					<input id="picture" class="form" type="file" name="picture" accept=".gif, .jpg, .png" style="height: 37px;" />
				</div>
			</div>
		</div>

	</div>



	<input type="submit" value="등록" class="btn btn-primary">
</form>
