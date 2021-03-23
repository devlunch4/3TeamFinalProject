<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>
	$(function() {
		var offset = $('#gohere').offset();
		$('html').animate({
			scrollTop : offset.top
		}, 300);
	});

	// 수정 버튼 클릭시 이동 
	$(function() {
		$("#modifyBtn").on("click", function() {
			var xguide_code = ${xguide_code	};
			console.log("xguide_code : "+xguide_code)
			$("#xguide_code").val(xguide_code);
			$("#frm").attr("method", "post");
			$("#frm").attr("action", "gardenguidesUpdate");
			$("#frm").submit();
		});
	});

	//초성검색
	$(function() {
		$(".chosungc").on("click", function() {
			var chosung = $(this).data("chosung");
			$("#chosung").val(chosung);
			$("#frm").attr("method", "post");
			$("#frm").attr("action", "gardenguides");
			$("#frm").submit();
		});
	});
	// 해당 가이드 클릭시
	$(function() {
		$(".onebtn").on("click", function() {
			var onebtn = $(this).data("onebtn");
			$("#xguide_code").val(onebtn);
			console.log("onebtn : "+onebtn);
			$("#frm").attr("method", "post");
			$("#frm").attr("action", "gardenguides");
			$("#frm").submit();
		});
	});
</script>

<h3 class="mt-4">텃밭가이드(재배정보)</h3>
<div class="">
	<div class="text-right col-12 p-0">
		<!-- 관리자 전용 등록 이동 버튼 활성 -->
		<c:if test="${S_USER.user_id.equals('admin') }">
			<button type="button" class="btn-success btn-lg col-xs-4 col-md-3 mb-2" onclick="location.href='${pageContext.request.contextPath}/finfo/gardenguidesInsert'">신규등록</button>
			<button type="button" class="btn-success btn-lg col-xs-4 col-md-3 mb-2" onclick="location.href='${pageContext.request.contextPath}/finfo/gardenguidesAll'">글목록보기</button>
		</c:if>
	</div>
</div>

<div>
	<form id="frm" role="form">
		<input type="hidden" id="chosung" name="chosung" value="${chosung }">
		<input type="hidden" id="xguide_code" name="xguide_code" value="">
		<div class="card mt-2 col-sm-12">
			<div class="card-body text-left p-1">
				<span class="">가나다순</span> <br>
				<!-- 과거 기본 코드 -->
				<!-- <button type="button" class=" btn btn-outline-dark m-1 chosungc" data-chosung="ㄱ">ㄱ</button> -->
				<!-- 코어 태그 사용 -->

				<c:forEach var="chosungArr" items="${chosungArr}">
					<button type="button" <c:set var="checkc" value="${chosung }" /> <c:choose>
    <c:when test="${checkc  eq chosungArr }">
       class=" btn btn-primary m-1 chosungc"
    </c:when>
    <c:otherwise>
        class=" btn btn-outline-dark m-1 chosungc"
    </c:otherwise>
</c:choose> data-chosung="${chosungArr }">${chosungArr }</button>
				</c:forEach>
				<div class="gohere" id="gohere"></div>
			</div>
			<!-- 위의 가나다 순에 따른 결과 보여주기 -->
			<div class="card-body text-left p-1">
				<span class="">품명</span> <br>
				<!-- 과거 기본 코드 -->
				<!-- <button type="button" onclick="#" class=" btn btn-outline-dark m-1">아스파라거스</button> -->
				<!-- 코어 태그 사용 -->
				<c:set var="chkList" value="${gardenguidesList.size() }" />
				<div>
					<c:if test="${chkList == 0 }">
						<span class="bg-warning">조회된 값이 없습니다.</span>
					</c:if>
				</div>
				<c:forEach var="gardenguidesList" items="${gardenguidesList}">
					<button type="button" <c:set var="checkcode" value="${gardenguidesList.guide_code}" /> <c:choose>
    <c:when test="${checkcode  eq xguide_code }">
       class="btn btn-primary m-1  onebtn"
    </c:when>
    <c:otherwise>
        class="btn btn-outline-dark m-1  onebtn"
    </c:otherwise>
</c:choose> data-onebtn="${gardenguidesList.guide_code }">${gardenguidesList.item_code}</button>
				</c:forEach>
			</div>

		</div>

		<!-- 설명 시작 -->
		<br>
		<div class="card mt-2 col-sm-12 px-0">
			<h3 class="card-header">${gardenguidesVo.item_code }</h3>
			<div class="card-body">
				<!-- 이미지 보이기 -->
				<!-- 리소스에서 -->
				<div class="text-center">
					<%-- 	<img src="${pageContext.request.contextPath}/resources/guide_img/${gardenguidesVo.item_code }.jpg" alt="${gardenguidesVo.file_no }"> --%>
					<!-- 로컬 저장에서 -->
					<img class="mb-4" src="${pageContext.request.contextPath}/finfo/guideimg?guide_code=${gardenguidesVo.guide_code }" alt="${gardenguidesVo.guide_code }" style="width: 100%; max-width: 200px; height: 100%;" align="middle">
				</div>



				<table class="table table-bordered col-sx-12 small">
					<tr>
						<td class="table-active text-center" style="width: 30%" >분류</td>
						<td style="width: 70%">${gardenguidesVo.class_code }</td>
					</tr>
					<tr>
						<td class="table-active text-center" style="width: 30%">원산지</td>
						<td style="width: 70%">${gardenguidesVo.origin }</td>
					</tr>
					<tr>
						<td class="table-active text-center" style="width: 30%">생육온도</td>
						<td style="width: 70%">${gardenguidesVo.temperature }</td>
					</tr>
					<tr>
						<td class="table-active text-center" style="width: 30%">연작피해</td>
						<td style="width: 70%">${gardenguidesVo.damage }</td>
					</tr>
					<tr>
						<td class="table-active text-center" style="width: 30%">제철</td>
						<td style="width: 70%">${gardenguidesVo.season }</td>
					</tr>
					<tr>
						<td class="table-active text-center"  style="width: 30%">효과</td>
						<td style="width: 70%">${gardenguidesVo.effect }</td>
					</tr>
					<tr>
						<td class="table-active text-center" style="width: 30%">주요성분</td>
						<td style="width: 70%">${gardenguidesVo.ingredient }</td>
					</tr>
					<tr>
						<td class="table-active text-center" style="width: 30%">재배TIP!</td>
						<td style="width: 70%">${gardenguidesVo.plant_tip }</td>
					</tr>
					<tr>
						<td class="table-active text-center" style="width: 30%">재배내용</td>
						<td style="width: 70%">${gardenguidesVo.plant_content }</td>
					</tr>
					<%-- <tr>
								<td style="width: 30%">작성일</td>
								<td style="width: 70%">${gardenguidesVo.reg_dt }</td>
							</tr> --%>
				</table>
			</div>
		</div>
	</form>

	<div>

		<c:if test="${S_USER.user_id.equals('admin') }">
			<!-- 관리자 전용 삭제 이동 버튼 활성 -->
			<!-- <button type="button" id="deleteBtn" class="btn btn-danger btn-lg  col-md-3 float-left mt-4">텃밭가이드 삭제</button> -->
			<!-- 관리자 전용 수정 이동 버튼 활성 -->
			<button type="button" id="modifyBtn" class="btn-warning btn-lg col-xs-1 col-md-2 float-right mt-4">수정</button>
		</c:if>
	</div>
</div>
