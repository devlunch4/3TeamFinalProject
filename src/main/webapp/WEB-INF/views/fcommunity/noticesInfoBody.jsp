<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">공지사항 조회</h3>

<div class="form-group">
	<label class="small mb-1" for="input_cls_code">제목</label> 
	<input class="form-control py-4" id="input_cls_code" name="" type="text"
		value="" readonly="readonly">
</div>
<div class="form-group">
	<label class="small mb-1" for="input_grdgd_nm">작성일시</label> 
	<input class="form-control py-4" id="input_grdgd_nm" name="" type="text"
		value="" readonly="readonly">
</div>
<div class="form-group">
	<label class="small mb-1" for="input_difficulty">내용</label><br>
	<textarea rows="auto" cols="auto" name="" style="resize: none;" class="form-control py-4" readonly="readonly">
	</textarea>
</div>

<%-- <c:if test="${S_USER.user_id.equals('admin') }"> --%>
	<a class="btn btn-primary"
		href="${pageContext.request.contextPath }/fcommunity/noticesModify">수정</a>
	<a class="btn btn-primary" href="#">삭제</a>
<%-- </c:if> --%>

