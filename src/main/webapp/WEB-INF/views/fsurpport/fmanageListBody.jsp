<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script>
//2021-03-18 KJH 테이블 검색의 조건을 회원으로만 검색 가능하게 만들고 관리자일 경우에만 검색창 생성
	$(function() {
		<c:if test="${S_USER.user_id ne 'admin'}">
		$.extend( $.fn.dataTable.defaults, {
		    searching: false
		} );
		</c:if>
		$('#dataTable').dataTable({
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
			}, ]
		});
	});
</script>

<h3 class="mt-4">텃밭가이드 글 전체보기(목록)</h3>
<div class="card mb-4">
	<div class="card-header">전체 텃밭가이드 조회</div>
	<div class="card-body">
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
						<table class="table table-bordered dataTable" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
							<thead>
								<tr role="row">
									<th class="sorting_asc " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="No: activate to sort column descending" aria-sort="ascending">
										<!-- GUIDE_CODE(seq) -->시설번호
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
							<tbody>
								<c:forEach items="${fmanageList }" var="fmanage">
									<c:set var="dt">
										<fmt:formatDate value="${fmanage.reg_dt}" pattern="yyyy-MM-dd" />
									</c:set>
									<%-- <c:if test="${guidelist.use_yn == 'Y'}"> --%>
									<tr data-guidecode="${fmanage.manage_no }">
										<td data-toggle="tooltip" data-placement="top" title="시설 위치명을 클릭하면 해당 상세 페이지로 이동합니다.">${fmanage.manage_no }</td>
										<td class="guidecode" data-guidecode="${fmanage.manage_no }" data-toggle="tooltip" data-placement="top" title="시설 위치명을 클릭하면 해당 상세 페이지로 이동합니다.">${fmanage.owner }</td>
										<td id = "selo" class="guidecode" data-guidecode="${fmanage.manage_no }" data-toggle="tooltip" data-placement="top" title="시설 위치명을 클릭하면 해당 상세 페이지로 이동합니다."><a href="${pageContext.request.contextPath}/fsurpport/fmanageInfo?manage_no=${fmanage.manage_no}">${fmanage.location}</a></td>
										<td id = "sedt" data-toggle="tooltip" data-placement="top" title="시설 위치명을 클릭하면 해당 상세 페이지로 이동합니다.">${dt}</td>
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

