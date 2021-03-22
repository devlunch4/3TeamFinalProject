<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">미니장터 게시글 수정페이지</h3>

<form>
	
	<div class="form-group">
		<label class="small mb-1" for="input_cls_code">제목</label>
		<p class="form-control py-4">${miniMarketInfo.title }</p>
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_cls_code">머릿말</label>
		<p class="form-control py-4">${miniMarketInfo.head_code_nm }</p>
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_cls_code">등록일</label>
		<p class="form-control py-4"><fmt:formatDate value="${miniMarketInfo.reg_dt }" pattern="yyyy.MM.dd" /></p>
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_grdgd_nm">품목</label>
		<input class="form-control py-4" id="input_grdgd_nm" name="" type="text" value="${miniMarketInfo.item_code_nm }" required="required" readonly="readonly">
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_difficulty">조회수</label>
		<input class="form-control py-4" id="input_difficulty" name="" type="text" value="${miniMarketInfo.hit }" required="required" readonly="readonly">
	</div>
	<div class="form-group ">
		<label class="small mb-1" for="input_plant_prd">작업내용</label> <br>
			<div name="content" >
				${miniMarketInfo.content }
			</div>
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">가격</label><br> 
		<fmt:formatNumber value="${miniMarketInfo.price }" pattern="#,###" />
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">썸네일</label><br> 
		<img src="${pageContext.request.contextPath}/fcommunity/filePath?file_nm=${miniMarketInfo.thumbnail_file_nm }"  >
	</div>
	
	<div class="form-group">
		<c:if test="${marketFileList != null }">
			<c:forEach items="${marketFileList }" var="marketFileList" >
				<input type="text" value="${marketFileList.file_nm }" readonly="readonly">
				<input type="button" value="삭제">
				<br>
			</c:forEach>
		</c:if>
	</div>
		
	<div class="float-right">
		<c:choose>
			<c:when test="${S_USER.user_id == miniMarketInfo.writer }">
				<a class="btn btn-primary" href="${pageContext.request.contextPath }/fsurpport/ModifyView?writer=${S_USER.user_id }&f_diary_no=${farmdiaryList.f_diary_no }&my_simple_code=${farmdiaryList.my_simple_code }">수정</a> 
				<a class="btn btn-primary" href="${pageContext.request.contextPath }/fsurpport/deleteFarmdiary?writer=${S_USER.user_id }&f_diary_no=${farmdiaryList.f_diary_no }"
					onclick="alert('삭제합니다.');">삭제</a>
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
		
		<input class="btn btn-primary" type="button" value="취소" onClick="history.go(-1)">
<!-- 		<button type="button" class="btn btn-primary" style="float: rigth;" -->
<%-- 		onclick="location.href='${pageContext.request.contextPath }/fsurpport/main?user_id=${S_USER.user_id}'" >목록이동</button> --%>
	</div>
</form>

