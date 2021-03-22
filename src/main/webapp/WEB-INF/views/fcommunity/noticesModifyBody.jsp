<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">공지사항 수정</h3>

<form action="noticeModify2" method="post">
	<div class="form-group">
		<label class="small mb-1" for="input_cls_code">제목</label> <input class="form-control py-4" id="input_cls_code" name="title" type="text" value="${notice.title }">
	</div>

	<div class="form-group">
		<label class="small mb-1" for="input_difficulty">내용</label><br>
		<textarea rows="auto" cols="auto" name="content" style="resize: none;" class="form-control py-4">
		</textarea>
	</div>

	<input class="btn btn-primary" type="submit" value="수정 완료">
</form>

<script>

$(document).ready(function() {

	$('#summernote').summernote({
	  placeholder: '${notice.content}',
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
