<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">공지사항 조회</h3>

<div class="form-group">
	<label class="small mb-1" for="input_grdgd_nm">공지번호</label> 
	<input class="form-control py-4" id="input_grdgd_nm" name="" type="text" value="${notice.notice_no }" readonly="readonly">
</div>

<div class="form-group">
	<label class="small mb-1" for="input_cls_code">제목</label> 
	<input class="form-control py-4" id="input_cls_code" name="" type="text" value="${notice.title }" readonly="readonly">
</div>

<div class="form-group">
	<label class="small mb-1" for="input_difficulty">내용</label><br>
	<input class="form-control py-4" id="input_cls_code" name="" type="text" value="${notice.content }" readonly="readonly">
</div>

<c:if test="${S_USER.user_id.equals('admin') }">
<a class="btn btn-primary" href="${pageContext.request.contextPath }/fcommunity/noticesModify">수정</a>
<a class="btn btn-primary" href="noticesDelete">삭제</a>
</c:if>

