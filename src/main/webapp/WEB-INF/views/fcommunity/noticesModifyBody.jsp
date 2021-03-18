<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">공지사항 수정</h3>

<form action="#" method="post">
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
	
	<input class="btn btn-primary" type="submit" value="수정 완료">
</form>

