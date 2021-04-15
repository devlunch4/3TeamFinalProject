<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">문의사항 수정</h3>

<form action="${pageContext.request.contextPath}/qna/qnaModify" method="post" enctype="multipart/form-data">
	<div class="form-group">
		<label class="small mb-1" for="input_grdgd_nm">작성일시</label> 
		<input class="form-control py-4" id="input_grdgd_nm" name="" type="text"
			value="${qna.reg_dt}" readonly="readonly">
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_grdgd_nm">작성자</label> 
		<input class="form-control py-4" id="input_grdgd_nm" name="writer" type="text"
			value="${S_USER.user_id}" readonly="readonly">
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_cls_code">제목</label> 
		<input class="form-control py-4" id="input_cls_code" name="title" type="text"
			value="${qna.title}" >
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_difficulty">내용</label><br>
		<!-- 썸머노트 사용할 때, name="content" 네임속성에 있는 이름이 디비 컬럼이랑 같으면 된다. -->
		<textarea id="summernote" name="content">${qna.content}</textarea>
	</div>
	
	<input type="hidden" name="qna_no" value="${qna.qna_no}">
	<input class="btn btn-primary" type="submit" value="수정 완료">
</form>

<script>

$(document).ready(function() {

	$('#summernote').summernote({
	  placeholder: '내용을 입력해주세요.',
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

});	
</script> 