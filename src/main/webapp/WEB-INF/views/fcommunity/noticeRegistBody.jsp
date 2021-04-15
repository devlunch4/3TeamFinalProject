<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<h3 class="mt-4">공지사항 등록</h3>



<form action="insertNotice2" method="post", enctype="multipart/form-data">

	<div class="form-group">
		<label class="small mb-1" for="input_cls_code">제목</label> 
		<input class="form-control py-4" id="input_cls_code" name="title" type="text"
			value=""  >
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
	  placeholder: '공지사항 내용 작성',
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

