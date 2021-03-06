<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script>
	//2021-03-18 KJH 테이블 검색의 조건을 회원으로만 검색 가능하게 만들고 관리자일 경우에만 검색창 생성
	$(function() {
		// 		<c:if test="${S_USER.user_id ne 'admin'}">
		// 		$.extend( 
		// 				$.fn.dataTable.defaults, 
		// 				{
		// 		    $('#dataTable').dataTable({
		// 				"columnDefs" : [ {
		// 					"searchable" : false,
		// 					"targets" : 0
		// 				}, {
		// 					"searchable" : false,
		// 					"targets" : 1
		// 				}, {
		// 					"searchable" : true,
		// 					"targets" : 2
		// 				}, {
		// 					"searchable" : true,
		// 					"targets" : 3
		// 				} ]
		// 			});
		// 		} );
		// 		</c:if>

		// 		<c:if test="${S_USER.user_id eq 'admin'}">
		// 		$.extend( $.fn.dataTable.defaults, {
		// 			$('#dataTable').dataTable({
		// 				"columnDefs" : [ {
		// 					"searchable" : false,
		// 					"targets" : 0
		// 				}, {
		// 					"searchable" : true,
		// 					"targets" : 1
		// 				}, {
		// 					"searchable" : true,
		// 					"targets" : 2
		// 				}, {
		// 					"searchable" : true,
		// 					"targets" : 3
		// 				} ]
		// 			});
		// 		} );
		// 		</c:if>

		$(".info").on("click", function() {

			/* alert($(this).attr('id')); */

			idval = $(this).attr('id');

			/* alert(idval); */
			$("#manage_no").val($("#manage_no".concat(idval)).val());

			/* alert($("#manage_no".concat(idval)).val()); */

			/* alert($("#manage_no").val()); */
			$("#infoform").submit();

		});

	});
</script>

<h3 class="mt-4">시설관리</h3>
<div class="card mb-4">
	<!-- 	<div class="card-header">시설 리스트</div> -->
	<div class="card-body p-1">
		<div class="table-responsive">
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">

				<div class="row">
					<div class="col-sm-12 col-md-6">
						<div class="dataTables_length" id="dataTable_length"></div>
					</div>

					<div class="col-sm-12 col-md-6">
						<div id="dataTable_filter" class="dataTables_filter"></div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<table class="table table-bordered dataTable table-width small" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
							<thead>
								<tr role="row">
									<th class="sorting_asc " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="No: activate to sort column descending" aria-sort="ascending">
										<!-- GUIDE_CODE(seq) -->시설순번
									</th>
									<th class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column ascending">
										<!-- CLASS_CODE -->소유자
									</th>
									<th class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">
										<!-- ITEM_CODE -->시설위치
									</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="">
										<!-- DIFFICULTY -->등록일
									</th>
								</tr>
							</thead>

							<form action="${pageContext.request.contextPath}/fsurpport/fmanageInfo" method="post" id="infoform">
								<input type="hidden" name="manage_no" id="manage_no" value="">
							</form>

							<tbody>
								<c:forEach items="${fmanageList }" var="fmanage" varStatus="sts">
									<c:set var="dt">
										<fmt:formatDate value="${fmanage.reg_dt}" pattern="yyyy-MM-dd" />
									</c:set>
									<%-- <c:if test="${guidelist.use_yn == 'Y'}"> --%>
									<tr data-guidecode="${sts.count}" class="info" id="${sts.count}">
										<td data-toggle="tooltip" data-placement="top" title="시설 위치명을 클릭하면 해당 상세 페이지로 이동합니다.">${sts.count}</td>
										<td id="seow" class="guidecode" data-guidecode="${sts.count}" data-toggle="tooltip" data-placement="top" title="시설 위치명을 클릭하면 해당 상세 페이지로 이동합니다.">${fmanage.owner }</td>
										<td id="selo" class="guidecode" data-guidecode="${sts.count}" data-toggle="tooltip" data-placement="top" title="시설 위치명을 클릭하면 해당 상세 페이지로 이동합니다.">${fmanage.location}<input type=hidden id="manage_no${sts.count}" value="${fmanage.manage_no}"></td>
										<td id="sedt" data-toggle="tooltip" data-placement="top" title="시설 위치명을 클릭하면 해당 상세 페이지로 이동합니다.">${dt}</td>
									</tr>
									<%-- </c:if> --%>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<input type="button" class="btn btn-primary p-0 col-3 float-right" value="등록" onclick="location.href='${pageContext.request.contextPath}/fsurpport/fmanageInsertPage'">

