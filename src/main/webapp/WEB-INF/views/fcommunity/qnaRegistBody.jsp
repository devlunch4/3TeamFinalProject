<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="today" />

<h3 class="mt-4">문의사항 등록</h3>

<form action="${pageContext.request.contextPath}/qna/qnaRegist" method="post" enctype="multipart/form-data">
	<div class="form-group">
		<label class="small mb-1" for="input_grdgd_nm">작성일시</label> 
		<input class="form-control py-4" id="input_grdgd_nm" name="reg_dt" type="text"
			value="<c:out value="${today}"/>" readonly="readonly">
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_grdgd_nm">작성자</label> 
		<input class="form-control py-4" id="input_grdgd_nm" name="writer" type="text"
			value="${S_USER.user_id}" readonly="readonly">
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_cls_code">제목</label> 
		<input class="form-control py-4" id="input_cls_code" name="title" type="text"
			value="" >
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_difficulty">내용</label><br>
		<!-- 썸머노트 사용할 때, name="content" 네임속성에 있는 이름이 디비 컬럼이랑 같으면 된다. -->
		<textarea id="summernote" name="content"></textarea>
	</div>
	
	<input class="btn btn-primary" type="submit" value="등록 완료">
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