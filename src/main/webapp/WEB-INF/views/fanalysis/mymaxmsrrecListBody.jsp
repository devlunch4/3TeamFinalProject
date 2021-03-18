<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script>
	$(function() {
		$('#tb').DataTable({
			bDestroy : true
		});
		setInterval(
				function() {
					$
							.ajax({
								// type을 설정합니다.
								type : 'POST',
								url : "${pageContext.request.contextPath}/fanalysis/mymaxmsrrecList",
								data : '',
								success : function(data) {
									$('#tb').html(data);
									$('#tb').DataTable({
										bDestroy : true
									});
								}
							});
				}, 5000);

	});
</script>

<!-- 20210305_KJH 시설정보 조회 -->
<h3 class="mt-4">시설관리</h3>

<div class="card mt-2 px-0">
	<h3 class="card-header">총게시글 :</h3>
	<div class="card-body text-left p-1">

		<div class="table-responsive small">
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">

				<div class="row">
					<div class="col-sm-12 col-md-6">
						<div class="dataTables_length" id="dataTable_length"></div>
					</div>

					<div class="col-sm-12 col-md-6">
						<div id="dataTable_filter" class="dataTables_filter"></div>
					</div>
				</div>
				<table class="table table-bordered text-center" id="tb">

					<thead>
						<tr role="row">
							<th style="width: 25%;" role="row" class="sorting_asc " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="No: activate to sort column descending" aria-sort="ascending">장소</th>
							<th style="width: 15%;" role="row" class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column ascending">장비명</th>
							<th style="width: 15%;" role="row" class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">작물명</th>
							<th style="width: 10%;" role="row" class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">온도</th>
							<th style="width: 10%;" role="row" class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">습도</th>
							<th style="width: 10%;" role="row" class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">조도</th>
							<th style="width: 15%;" role="row" class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">등록일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${maxmrrecList}" var="mrrecList" varStatus="stat">
							<c:if test="${fn:length(mrrecList.location) gt 0}">
								<c:set var="dt">
									<fmt:formatDate value="${mrrecList.reg_dt}" pattern="yyyy-MM-dd" />
								</c:set>
								<c:forEach items="${tempList}" var="temp" varStatus="sts">

									<c:if test="${temp.item_code == mrrecList.item_code}">
										<c:choose>
											<c:when test="${mrrecList.msr_temp >= temp.number1 && mrrecList.msr_temp <= temp.number2}">
												<tr class="table-success" data-guidecode="${sts.count}">
											</c:when>

											<c:when test="${mrrecList.msr_temp < temp.number1}">
												<tr class="table-primary" data-guidecode="${sts.count}">
											</c:when>

											<c:when test="${mrrecList.msr_temp > temp.number2}">
												<tr class="table-danger" data-guidecode="${sts.count}">
											</c:when>
										</c:choose>
									</c:if>
									<c:if test="${temp.item_code ne mrrecList.item_code and stat.end}">
										<tr data-guidecode="${sts.count}">
									</c:if>
								</c:forEach>
								<td style="width: 25%;" data-toggle="tooltip" data-placement="top">${mrrecList.location}</td>
								<td style="width: 15%;" data-guidecode="${sts.count}">${mrrecList.msr_nm}</td>
								<td style="width: 15%;" data-guidecode="${sts.count}">${mrrecList.item_code}</td>
								<td style="width: 10%;">${mrrecList.msr_temp}</td>
								<td style="width: 10%;">${mrrecList.msr_humid}</td>
								<td style="width: 10%;">${mrrecList.msr_bright}</td>
								<td style="width: 15%;" data-guidecode="${sts.count}">${dt}</td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>