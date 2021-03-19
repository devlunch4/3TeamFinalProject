<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script>
	//20210305_KJH 10초마다 새로고침
	// 	$(function() {
	// 		setTimeout("location.reload()", 10000);
	// 	});
	$(function() {
// 		setInterval(
// 				function() {
// 					$
// 							.ajax({
// 								// type을 설정합니다.
// 								type : 'POST',
// 								url : "${pageContext.request.contextPath}/fanalysis/mymaxmsrrecList",
// 								data : '',
// 								success : function(data) {
// 									$('#tb').html(data);
// 								}
// 							});
// 				}, 5000);
	});
</script>

<!-- 20210305_KJH 시설정보 조회 -->
<h3 class="mt-4">시설관리</h3>

<div class="card mt-2 px-0">
<!-- 	<div class="card-body text-left p-1"> -->
<div class="row"> 
		<div class="table-responsive small">
			<table class="table table-bordered text-center" id="tb">
				<tr class="thead-light"> 
					<th class="p-0">장소</th>
					<th class="p-0">장비명</th>
					<th class="p-0">작물명</th>
					<th class="p-0">온도</th>
					<th class="p-0">습도</th>
					<th class="p-0">조도</th>
					<th class="p-0">등록일</th>
				</tr>
				<c:forEach items="${maxmrrecList}" var="mrrecList" varStatus="stat">
					<c:if test="${fn:length(mrrecList.location) gt 0}">
						<c:set var="dt">
							<fmt:formatDate value="${mrrecList.reg_dt}" pattern="yyyy-MM-dd" />
						</c:set>
						<c:forEach items="${tempList}" var="temp">

							<c:if test="${temp.item_code == mrrecList.item_code}">
								<c:choose>
									<c:when test="${mrrecList.msr_temp >= temp.number1 && mrrecList.msr_temp <= temp.number2}">
										<tr class="table-success">
									</c:when>

									<c:when test="${mrrecList.msr_temp < temp.number1}">
										<tr class="table-primary">
									</c:when>

									<c:when test="${mrrecList.msr_temp > temp.number2}">
										<tr class="table-danger">
									</c:when>
								</c:choose>
							</c:if>
							<c:if test="${temp.item_code ne mrrecList.item_code and stat.end}">
								<tr>
							</c:if>
						</c:forEach>
						<td class="p-0">${mrrecList.location}</td>
						<td class="p-0">${mrrecList.msr_nm}</td>
						<td class="p-0">${mrrecList.item_code}</td>
						<td class="p-0">${mrrecList.msr_temp}</td>
						<td class="p-0">${mrrecList.msr_humid}</td>
						<td class="p-0">${mrrecList.msr_bright}</td>
						<td class="p-0">${dt}</td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</div>
		</div>
	</div>
<!-- </div> -->