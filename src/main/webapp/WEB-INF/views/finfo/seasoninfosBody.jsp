<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>
	// 해당 버튼 클릭시 가이드 이동
	$(function() {
		$(".selectbtn").on("click", function() {
			var guidecode = $(this).data("guidecode");
			$("#xguide_code").val(guidecode);
			$("#frm").attr("method", "post");
			$("#frm").attr("action", "gardenguides");
			$("#frm").submit();
		});
	});
</script>

<h3 class="mt-4">제철작물</h3>
<div>
	<c:if test="${S_USER.user_id.equals('admin') }">
		<!-- 관리자 전용 수정 이동 버튼 활성 -->
		<button type="button" class="btn-success btn-lg col-md-3 mb-4" onclick="location.href='${pageContext.request.contextPath}/finfo/gardenguidesAll'">재배정보관리</button>
	</c:if>
</div>

<div>
	<form id="frm" role="form">
		<input type="hidden" id="xguide_code" name="xguide_code" value="">

		<br>
		<div class="card mt-2 col-sm-12 px-0">
			<h5 class="card-header">봄</h5>
			<div class="card-body">
				<c:forEach var="springlist" items="${springlist }">
					<button type="button" class="btn btn-outline-dark m-1 selectbtn" data-guidecode="${springlist.guide_code }">${springlist.item_code }</button>
				</c:forEach>
			</div>
		</div>

		<div class="card mt-2 col-sm-12 px-0">
			<h5 class="card-header">여름</h5>
			<div class="card-body">
				<c:forEach var="summerlist" items="${summerlist }">
					<button type="button" class="btn btn-outline-dark m-1 selectbtn" data-guidecode="${summerlist.guide_code }">${summerlist.item_code }</button>
				</c:forEach>
			</div>
		</div>

		<div class="card mt-2 col-sm-12 px-0">
			<h5 class="card-header">가을</h5>
			<div class="card-body">
				<c:forEach var="autumnlist" items="${autumnlist }">
					<button type="button" class="btn btn-outline-dark m-1 selectbtn" data-guidecode="${autumnlist.guide_code }">${autumnlist.item_code }</button>
				</c:forEach>
			</div>
		</div>

		<div class="card mt-2 col-sm-12 px-0">
			<h5 class="card-header">겨울</h5>
			<div class="card-body">
				<c:forEach var="winterlist" items="${winterlist }">
					<button type="button" class="btn btn-outline-dark m-1 selectbtn" data-guidecode="${winterlist.guide_code }">${winterlist.item_code }</button>
				</c:forEach>
			</div>
		</div>
	</form>

	<div></div>
</div>
