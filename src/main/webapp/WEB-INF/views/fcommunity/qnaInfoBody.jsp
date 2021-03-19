<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">문의사항</h3>

<div class="form-group">
	<label class="small mb-1" for="input_grdgd_nm">글번호</label> 
	<input class="form-control py-4" id="input_grdgd_nm" name="qna_no" type="text" value="${qna.qna_no}" readonly="readonly">
</div>

<div class="form-group">
	<label class="small mb-1" for="input_grdgd_nm">조회수</label> 
	<input class="form-control py-4" id="input_grdgd_nm" name="qna_no" type="text" value="${qna.hit}" readonly="readonly">
</div>

<div class="form-group">
	<label class="small mb-1" for="input_grdgd_nm">작성자</label> 
	<input class="form-control py-4" id="input_grdgd_nm" name="qna_no" type="text" value="${qna.writer}" readonly="readonly">
</div>

<div class="form-group">
	<label class="small mb-1" for="input_cls_code">제목</label> 
	<input class="form-control py-4" id="input_cls_code" name="" type="text" value="${qna.title }" readonly="readonly">
</div>

<div class="form-group">
	<label class="small mb-1" for="input_difficulty">내용</label><br>
	<input class="form-control py-4" id="input_cls_code" name="" type="text" value="${qna.content }" readonly="readonly">
	<p>${S_USER.user_id}</p>
	<p>${qna.content }</p>
</div>

<c:if test="${S_USER.user_id.equals('admin') || S_USER.user_id.equals(qna.writer)}">
	<a class="btn btn-primary" href="qnaModifyView?qna_no=${qna.qna_no}">수정</a>
	<a class="btn btn-primary" href="qnaDelete?qna_no=${qna.qna_no}">삭제</a>
</c:if>


