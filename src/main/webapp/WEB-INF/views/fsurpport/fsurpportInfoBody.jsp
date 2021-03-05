<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">영농일지 조회</h3>

<form>
	<div class="form-group">
		<label class="small mb-1" for="input_cls_code">등록일</label>
		<p class="form-control py-4"><fmt:formatDate value="${farmdiaryList.reg_dt }" pattern="yyyy.MM.dd" /></p>
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_grdgd_nm">품목</label>
		<input class="form-control py-4" id="input_grdgd_nm" name="" type="text" value="${farmdiaryList.item_code }" required="required">
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_difficulty">작업단계</label>
		<input class="form-control py-4" id="input_difficulty" name="" type="text" value="${farmdiaryList.wstep_code }" required="required">
	</div>
	<div class="form-group ">
		<label class="small mb-1" for="input_plant_prd">작업내용</label> <br>
		<textarea rows="auto" cols="auto" name="" style="resize: none;" class="form-control py-4">
			${farmdiaryList.content }
		</textarea>
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">날씨정보</label>
		<input class="form-control py-4" id="input_plant_prd" name="" type="text" value="${farmdiaryList.weather }" required="required">
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">사진 등록</label> 
		<img src="${farmdiaryList.file_no }">
	</div>
	
	<c:choose>
		<c:when test="${S_USER.user_id.equals('farmdiaryList.writer') }">
			<a class="btn btn-primary" href="${pageContext.request.contextPath }/fsurpport/ModifyView?fdiary_no=${farmdiaryList.fdiary_no }">수정</a> 
			<a class="btn btn-primary" href="#">삭제</a>
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
</form>

