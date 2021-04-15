<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<script>
	$(function() {
		$('#tb').DataTable({
			// 			bDestroy : true
			"bLengthChange" : false,
			"ordering" : false,
			"dom" : 'lfirt <"col-sm-7" p>'
		});
		$('.dataTables_filter input[type="search"]').css({
			'width' : '10em'
		}
		// 				     ,'display':'inline-block'
		);
		$("#tb_filter").addClass('text-right');
		$("#tb_paginate").addClass('text-center');
		$("#tb_info").addClass('text-left p-0');
		setInterval(
				function() {
					$.ajax({
								// type을 설정합니다.
								type : 'POST',
								url : "${pageContext.request.contextPath}/fanalysis/mymaxmsrrecList",
								data : '',
								success : function(data) {
									$('#tb').html(data);
									$('#tb').DataTable({
										bDestroy : true,
										"bLengthChange" : false,
										"ordering" : false,
										"dom" : 'lfirt <"col-sm-7" p>'
									});
									$('.dataTables_filter input[type="search"]')
											.css({
												'width' : '10em'
											}
											//							 				     ,'display':'inline-block'
											);
									$("#tb_filter").addClass('text-right');
									$("#tb_paginate").addClass('text-center');
									$("#tb_info").addClass('text-left p-0');
								}
							});
				}, 5000);
		console.log("출력출력출력5초간격");
		$("#choice").change(function() {
			if ($("#choice").val() == "location") {
				$('#tb').DataTable({
					bDestroy : true,
					"bLengthChange" : false,
					"ordering" : false,
					"dom" : 'lfirt <"col-sm-7" p>',
					"columnDefs" : [ {
						"searchable" : true,
						"targets" : 0
					}, {
						"searchable" : false,
						"targets" : 1
					}, {
						"searchable" : false,
						"targets" : 2
					}, {
						"searchable" : false,
						"targets" : 3
					}, {
						"searchable" : false,
						"targets" : 4
					}, {
						"searchable" : false,
						"targets" : 5
					}, {
						"searchable" : false,
						"targets" : 6
					}, ],
				});
			} else if ($("#choice").val() == "msr_nm") {
				$('#tb').DataTable({
					bDestroy : true,
					"bLengthChange" : false,
					"ordering" : false,
					"dom" : 'lfirt <"col-sm-7" p>',
					"columnDefs" : [ {
						"searchable" : false,
						"targets" : 0
					}, {
						"searchable" : true,
						"targets" : 1
					}, {
						"searchable" : false,
						"targets" : 2
					}, {
						"searchable" : false,
						"targets" : 3
					}, {
						"searchable" : false,
						"targets" : 4
					}, {
						"searchable" : false,
						"targets" : 5
					}, {
						"searchable" : false,
						"targets" : 6
					}, ],
				});
			} else if ($("#choice").val() == "code") {
				$('#tb').DataTable({
					bDestroy : true,
					"bLengthChange" : false,
					"ordering" : false,
					"dom" : 'lfirt <"col-sm-7" p>',
					"columnDefs" : [ {
						"searchable" : false,
						"targets" : 0
					}, {
						"searchable" : false,
						"targets" : 1
					}, {
						"searchable" : true,
						"targets" : 2
					}, {
						"searchable" : false,
						"targets" : 3
					}, {
						"searchable" : false,
						"targets" : 4
					}, {
						"searchable" : false,
						"targets" : 5
					}, {
						"searchable" : false,
						"targets" : 6
					}, ],
				});
			} else if ($("#choice").val() == "dt") {
				$('#tb').DataTable({
					bDestroy : true,
					"bLengthChange" : false,
					"ordering" : false,
					"dom" : 'lfirt <"col-sm-7" p>',
					"columnDefs" : [ {
						"searchable" : false,
						"targets" : 0
					}, {
						"searchable" : false,
						"targets" : 1
					}, {
						"searchable" : false,
						"targets" : 2
					}, {
						"searchable" : false,
						"targets" : 3
					}, {
						"searchable" : false,
						"targets" : 4
					}, {
						"searchable" : false,
						"targets" : 5
					}, {
						"searchable" : true,
						"targets" : 6
					}, ],
				});
			}
			$('.dataTables_filter input[type="search"]').css({
				'width' : '10em'
			});
			$("#tb_filter").addClass('text-right');
			$("#tb_paginate").addClass('text-center');
			$("#tb_info").addClass('text-left p-0');
		});

	});
</script>

<!-- 20210305_KJH 시설정보 조회 시설관리-->
<h3 class="mt-4">실시간 측정</h3>

<div class="card mt-2 px-0">
	<!-- <h3 class="card-header">총게시글 :</h3> -->
	<div class="card-body text-left p-1">

		<div class="table-responsive small">
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">

				<div class="form group">
					<div class="col-sm-6 col-md-2 m-0">
						<div class="dataTables_length" id="dataTable_length"></div>
					</div>

					<div class="col-sm-6 col-md-2 m-0">
						<div id="dataTable_filter" class="dataTables_filter p-0 text-right form-group"></div>
					</div>
				</div>

				<div class="text-right py-1 mr-0">
					<div class="text-right">
						<select class="text-right form-control-sm" id="choice" style="width: 140px;">
							<option value="location">장소</option>
							<option value="msr_nm">장비명</option>
							<option value="code">작물명</option>
							<option value="dt">마지막 측정일</option>
						</select>
					</div>
					<div id="dataTable_filter" class="dataTables_filter"></div>
				</div>
				<table class="table table-bordered text-center" id="tb">

					<thead style="width: 33%;">
						<tr role="row">
							<th class="p-0" role="row" class=" " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1">장소</th>
							<th class="p-0" role="row" class=" " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1">장비명</th>
							<th class="p-0" role="row" class=" " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1">작물명</th>
							<th class="p-0" role="row" class=" " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1">온도</th>
							<th class="p-0" role="row" class=" " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1">습도</th>
							<th class="p-0" role="row" class=" " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1">조도</th>
							<th class="p-0" role="row" class=" " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1">등록일</th>
						</tr>
					</thead>
					<tbody class="text-center">
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
								<td class="p-0" data-toggle="tooltip" data-placement="top">${mrrecList.location}</td>
								<td class="p-0" data-guidecode="${sts.count}">${mrrecList.msr_nm}</td>
								<td class="p-0" data-guidecode="${sts.count}">${mrrecList.item_code}</td>
								<td class="p-0">${mrrecList.msr_temp}</td>
								<td class="p-0">${mrrecList.msr_humid}</td>
								<td class="p-0">${mrrecList.msr_bright}</td>
								<td class="p-0" data-guidecode="${sts.count}">${dt}</td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>