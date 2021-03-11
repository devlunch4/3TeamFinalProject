<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script>
	//20210305_KJH 10초마다 새로고침
	$(function() {

		setTimeout("location.reload()", 10000);

	});
</script>

<!-- 20210305_KJH 시설정보 조회 -->
<h3 class="mt-4">시설관리</h3>

<div class="card mt-2 col-sm-12 px-0">
	<h3 class="card-header">총게시글 :</h3>
	<div class="card-body text-left ">
		<div class="">
			<div class="row">
				<table class="table table-bordered col-sx-12" style="text-align: center;">
					<tr>
						<th style="width: 25%;">장소</th>
						<th style="width: 15%;">장비명</th>
						<th style="width: 15%;">작물명</th>
						<th style="width: 15%;">등록일</th>
						<th style="width: 10%;">온도</th>
						<th style="width: 10%;">습도</th>
						<th style="width: 10%;">조도</th>
					</tr>
					<c:forEach items="${maxmrrecList}" var="mrrecList">
					<c:if test="${fn:length(mrrecList.location) gt 0}">
						<c:set var="dt">
							<fmt:formatDate value="${mrrecList.reg_dt}" pattern="yyyy-MM-dd" />
						</c:set>
					
					<tr>
						<td style="width: 25%;">${mrrecList.location}</td>
						<td style="width: 15%;">${mrrecList.msr_nm}</td>
						<td style="width: 15%;">${mrrecList.item_code}</td>
						<td style="width: 15%;">${dt}</td>
						<td style="width: 10%;">${mrrecList.msr_temp}</td>
						<td style="width: 10%;">${mrrecList.msr_humid}</td>
						<td style="width: 10%;">${mrrecList.msr_bright}</td>
					</tr>
					</c:if>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>
