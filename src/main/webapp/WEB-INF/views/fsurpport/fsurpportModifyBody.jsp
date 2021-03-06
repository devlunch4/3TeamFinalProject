<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">영농일지 수정</h3>

<form>
	<div class="form-group">
		<label class="small mb-1" for="input_cls_code">등록일</label>
		<input class="form-control py-4" id="input_cls_code" name="" type="text" value="" required="required">
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_grdgd_nm">품목</label>
		<input class="form-control py-4" id="input_grdgd_nm" name="" type="text" value="" required="required">
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_difficulty">작업단계</label>
		<input class="form-control py-4" id="input_difficulty" name="" type="text" value="" required="required">
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_difficulty">작업내용</label><br>
			<textarea id="summernote" name="summernote"></textarea>
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">날씨정보</label>
		<input class="form-control py-4" id="input_plant_prd" name="" type="text" value="" required="required">
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">사진 등록</label>
				
		<div class="mailbox-attachments clearfix"
			style="text-align: center; width: 100%;">
			<div class="mailbox-attachment-icon has-img" id="pictureView"
					style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;">
				<img id="pictureViewImg" style="width: 100%; height: 100%;" />
			</div>
					
			<div class="mailbox-attachment-info">
				<div class="">
					<input id="picture" class="form-control"
					type="file" name="picture" accept=".gif, .jpg, .png" style="height:37px;"/>
				</div>
			</div>
		</div>
				
	</div>

	<input type="submit" value="수정 완료" class="btn btn-primary" >
</form>

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
