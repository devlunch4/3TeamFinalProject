<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">미니장터 게시판 상세 조회</h3>
 	

<div class="form-group">
	<label class="small mb-1" for="input_cls_code">제목</label> 
	<input class="form-control py-4" id="input_cls_code" name="title" type="text"
		value="${detaillist.title }" readonly="readonly">
</div>
<div class="form-group">
	<label class="small mb-1" for="input_grdgd_nm">작성일시</label> 
	<input class="form-control py-4" id="input_grdgd_nm" name="reg_dt" type="text"
		value="<fmt:formatDate value="${detaillist.reg_dt }" pattern="yyyy-MM-dd"/>" readonly="readonly">
</div>
<div class="form-group">
	<label class="small mb-1" for="input_difficulty">작성자</label><br>
	<input class="form-control py-4" id="input_grdgd_nm" name="writer" type="text"
		value="${detaillist.writer }" readonly="readonly">
</div>

<div class="form-group">
	<label class="small mb-1" for="input_difficulty">내용</label><br>
	<textarea rows="auto" cols="auto" name="content" style="resize: none;" class="form-control py-4" readonly="readonly">
	${detaillist.content }</textarea>
</div>

<div class="form-group">
	<img src="">
</div>

<div class="form-group">
	<label class="small mb-1" for="input_difficulty">댓글</label><br>
	
	<c:forEach items="${farmdiaryList }" var="farmdiaryList">
		<textarea rows="auto" cols="auto" name="" style="resize: none;" class="form-control py-4" readonly="readonly">
		</textarea>
<%-- 		<c:if test="${S_USER.user_id.equals('admin') }"> --%>
			<a class="btn btn-primary"
				href="${pageContext.request.contextPath }/fcommunity/noticesModify">댓글 수정</a>
			<a class="btn btn-primary" href="#">댓글 삭제</a>
<%-- 		</c:if> --%>
	</c:forEach>
	
	
	<textarea rows="auto" cols="auto" name="" style="resize: none;" class="form-control py-4" readonly="readonly">
	</textarea>
</div>

<div class="form-group">
	<form action="#" method="post">
		<textarea rows="auto" cols="auto" name="" style="resize: none;" class="form-control py-4" >
		</textarea><br>
		<input type="submit" value="댓글등록">
	</form>
	
</div>

<%-- <c:if test="${S_USER.user_id.equals('admin') }"> --%>
	<a class="btn btn-primary"
		href="${pageContext.request.contextPath }/fcommunity/minimarketModifyView">수정</a>
	<a class="btn btn-primary" href="#">삭제</a>
<%-- </c:if> --%>

