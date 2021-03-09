<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<h3 class="mt-4">미니장터 게시판 작성 페이지</h3>



<form action="${pageContext.request.contextPath }/fcommunity/minimarketRegist" method="post">

	<div class="form-group">
		<label class="small mb-1" for="input_cls_code">제목</label> 
		<input class="form-control py-4" id="input_cls_code" name="title" type="text"
			value=""  >
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_grdgd_nm">작성일시</label> 
		<input class="form-control py-4" id="input_grdgd_nm" name="reg_dt" type="text"
			value=""  >
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_difficulty">작성자</label><br>
		<input class="form-control py-4" id="input_grdgd_nm" name="writer" type="text"
			value="" >
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_difficulty">카테고리</label><br>
		
		<select name="">
			<option value="">카테고리 선택</option>
<%-- 			<c:forEach items="" var=""> --%>
<!-- 				<option value=""></option> -->
<%-- 			</c:forEach> --%>
		</select>
		
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
	
	<div class="form-group">
		<label class="small mb-1" for="input_difficulty">내용</label><br>
			<textarea id="summernote" name="content"></textarea>
	</div>
	
	<br>
	<input class="btn btn-primary" type="submit" value="작성 완료">
	
	<a class="btn btn-primary" href="#" style="float: right;">취소</a>
	
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

