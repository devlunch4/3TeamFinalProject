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
		<input class="form-control py-4" id="input_grdgd_nm" name="" type="text" value="${farmdiaryList.item_code }" required="required" readonly="readonly">
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_difficulty">작업단계</label>
		<input class="form-control py-4" id="input_difficulty" name="" type="text" value="${farmdiaryList.w_step_code }" required="required" readonly="readonly">
	</div>
	<div class="form-group ">
		<label class="small mb-1" for="input_plant_prd">작업내용</label> <br>
			<div name="content" >
				${farmdiaryList.content }
			</div>
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">날씨정보</label>
		<input class="form-control py-4" id="input_plant_prd" name="" type="text" value="${farmdiaryList.weather }" readonly="readonly">
		<label class="small mb-1" for="input_plant_prd">최저온도</label> 
		<input class="form-control py-4" id="input_plant_prd" name="" type="text" value="${farmdiaryList.low_temp }" readonly="readonly">
		<label class="small mb-1" for="input_plant_prd">최고온도</label> 
		<input class="form-control py-4" id="input_plant_prd" name="" type="text" value="${farmdiaryList.high_temp }" readonly="readonly">
		<label class="small mb-1" for="input_plant_prd">강수량</label> 
		<input class="form-control py-4" id="input_plant_prd" name="" type="text" value="${farmdiaryList.rainfall }" readonly="readonly">
		<label class="small mb-1" for="input_plant_prd">습도</label> 
		<input class="form-control py-4" id="input_plant_prd" name="" type="text" value="${farmdiaryList.humid }" readonly="readonly">
		<label class="small mb-1" for="input_plant_prd">수확량</label> 
		<input class="form-control py-4" id="input_plant_prd" name="" type="text" value="${farmdiaryList.yield }" readonly="readonly">
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">면적</label><br> 
		<input class="form-control py-4" id="input_plant_prd" name="" type="text" value="${farmdiaryList.area }" readonly="readonly">
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">사진</label><br> 
		<img src="${pageContext.request.contextPath}/fsurpport/filePath?file_nm=${farmdiaryList.file_nm }"  >
	</div>
	
	<c:choose>
		<c:when test="${S_USER.user_id == farmdiaryList.writer }">
			<a class="btn btn-primary" href="${pageContext.request.contextPath }/fsurpport/ModifyView?writer=${S_USER.user_id }&f_diary_no=${farmdiaryList.f_diary_no }&my_simple_code=${farmdiaryList.my_simple_code }">수정</a> 
			<a class="btn btn-primary" href="${pageContext.request.contextPath }/fsurpport/deleteFarmdiary?writer=${S_USER.user_id }&f_diary_no=${farmdiaryList.f_diary_no }"
				onclick="alert('삭제합니다.');">삭제</a>
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
	
	<input class="btn btn-primary" type="button" value="취소" onClick="history.go(-1)">
<!-- 	<button type="button" class="btn btn-primary" style="float: rigth;" -->
<%-- onclick="location.href='${pageContext.request.contextPath }/fsurpport/main?user_id=${S_USER.user_id}'" >목록이동</button> --%>
	
</form>

