<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script>
<!-- 수정 버튼 클릭시 이동 -->
$(function(){
	$("#modifyBtn").on("click", function(){
		$("#frm").attr("method", "post");
		$("#frm").attr("action", "gardenguidesUpdate");
		$("#frm").submit();
	});
})
<!-- 삭제 버튼 클릭시 이동 -->
$(function(){
	$("#deleteBtn").on("click", function(){
		$("#frm").attr("method", "post");
		$("#frm").attr("action", "gardenguidesDelete");
		$("#frm").submit();
	});
})
</script>


<h3 class="mt-4">텃밭가이드(재배정보)</h3>


<div>
	<c:if test="${S_USER.user_id.equals('admin') }">
		<!-- 관리자 전용 등록 이동 버튼 활성 -->
		<button type="button"
			class="btn btn-success btn-lg btn-block col-md-3 float-right mb-4"
			onclick="location.href='${pageContext.request.contextPath}/finfo/gardenguidesInsert'">텃밭가이드
			등록</button>
	</c:if>
</div>



<div>
	<form id="frm" role="form">
		<div class="card mt-2 col-sm-12">
			<div class="card-body text-left p-1">
				<span class="">가나다순</span> <br>
				<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㄱ</button>
				<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㄴ</button>
				<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㄷ</button>
				<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㄹ</button>
				<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㅁ</button>
				<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㅂ</button>
				<button type="button" onclick="#" class=" btn btn-primary m-1">ㅅ</button>
				<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㅇ</button>
				<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㅈ</button>
				<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㅊ</button>
				<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㅋ</button>
				<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㅌ</button>
				<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㅍ</button>
				<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㅎ</button>
			</div>

			<!-- 위의 가나다 순에 따른 결과 보여주기 -->
			<div class="card-body text-left p-1">
				<span class="">품명</span> <br>
				<button type="button" onclick="#" class=" btn btn-outline-dark m-1">아스파라거스</button>
				<button type="button" onclick="#" class=" btn btn-outline-dark m-1">양배추</button>
				<button type="button" onclick="#" class=" btn btn-primary m-1">양상추</button>
				<button type="button" onclick="#" class=" btn btn-outline-dark m-1">양파</button>
				<button type="button" onclick="#" class=" btn btn-outline-dark m-1">오이</button>
				<button type="button" onclick="#" class=" btn btn-outline-dark m-1">옥수수</button>
			</div>
		</div>

		<!-- 설명 시작 -->
		<br>
		<div class="card mt-2 col-sm-12 px-0">
			<h3 class="card-header">${gardenguidesVo.grdgd_nm }</h3>
			<div class="card-body text-left ">
				<div class="">
					<div class="row">
						<div class="imgwrap">
							<img src="/images/upload/farm_guide_info/144609103235500023.jpg"
								alt="144609103235500023.jpg">
						</div>

						<table class="table table-bordered col-sx-12">
							<tr>
								<td style="width: 30%">분류</td>
								<td style="width: 70%">${gardenguidesVo.cls_code }</td>
							</tr>
							<tr>
								<td style="width: 30%">원산지</td>
								<td style="width: 70%">${gardenguidesVo.origin }</td>
							</tr>
							<tr>
								<td style="width: 30%">생육온도</td>
								<td style="width: 70%">${gardenguidesVo.cls_code }</td>
							</tr>
							<tr>
								<td style="width: 30%">연작피해</td>
								<td style="width: 70%">${gardenguidesVo.damage }</td>
							</tr>
							<tr>
								<td style="width: 30%">제철</td>
								<td style="width: 70%">${gardenguidesVo.season }</td>
							</tr>
							<tr>
								<td style="width: 30%">효과</td>
								<td style="width: 70%">${gardenguidesVo.effect }</td>
							</tr>
							<tr>
								<td style="width: 30%">주요성분</td>
								<td style="width: 70%">${gardenguidesVo.ingredient }</td>
							</tr>
							<tr>
								<td style="width: 30%">재배TIP!</td>
								<td style="width: 70%">${gardenguidesVo.plant_tip }</td>
							</tr>
							<%-- <tr>
								<td style="width: 30%">작성일</td>
								<td style="width: 70%">${gardenguidesVo.reg_dt }</td>
							</tr> --%>
						</table>
					</div>
				</div>
			</div>
		</div>
	</form>

	<div>
		<c:if test="${S_USER.user_id.equals('admin') }">
			<!-- 관리자 전용 삭제 이동 버튼 활성 -->
			<button type="button" id="deleteBtn"
				class="btn btn-warning btn-lg btn-block col-md-3 float-left mt-4">텃밭가이드
				삭제</button>
			<!-- 관리자 전용 수정 이동 버튼 활성 -->
			<button type="button" id="modifyBtn"
				class="btn btn-success btn-lg btn-block col-md-3 float-right mt-4">텃밭가이드
				수정</button>
		</c:if>
	</div>
</div>
