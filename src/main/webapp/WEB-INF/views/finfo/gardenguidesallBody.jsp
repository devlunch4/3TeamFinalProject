<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- <script>document.location="create"</script> -->
<script>
	//문서 로딩이 완료되고 나서 실행되는 영역
	$(function() {
		$(".guidecode").on("click", function() {
			var guidecode = $(this).data("guidecode");
			$("#xguide_code").val(guidecode);
			$("#frm").submit();
		});
	});

	$(function() {
		$('[data-toggle="tooltip"]').tooltip()
	})
</script>

<form id="frm" action="${pageContext.request.contextPath}/finfo/gardenguidesUpdate" method="post">
	<input type="hidden" id="xguide_code" name="xguide_code" value="" />
</form>

<h3 class="mt-4">텃밭가이드 글 전체보기(목록)</h3>
<div class="">
	<div class="text-right col-12 p-0">
		<button class="btn-warning btn-lg col-xs-4 col-md-3 mb-2" type="button" id="listBtn" name="listBtn" onclick="location.href='${pageContext.request.contextPath}/finfo/gardenguides'">목록으로</button>
	</div>
</div>
<div class="card mb-4">
	<div class="card-header">
		<svg class="svg-inline--fa fa-table fa-w-16 mr-1" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="table" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" data-fa-i2svg="">
<path fill="currentColor" d="M464 32H48C21.49 32 0 53.49 0 80v352c0 26.51 21.49 48 48 48h416c26.51 0 48-21.49 48-48V80c0-26.51-21.49-48-48-48zM224 416H64v-96h160v96zm0-160H64v-96h160v96zm224 160H288v-96h160v96zm0-160H288v-96h160v96z"></path>
</svg>
		전체 텃밭가이드 조회
	</div>

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
										<!-- GUIDE_CODE(seq) -->-등록순번
									</th>
									<th class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column ascending">
										<!-- CLASS_CODE -->부류명
									</th>
									<th class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">
										<!-- ITEM_CODE -->품목명
									</th>
									<th class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">
										<!-- DIFFICULTY -->난이도
									</th>
									<th class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">
										<!-- ORIGIN -->원산지
									</th>
									<th class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">
										<!-- TEMPERATURE -->생육온도
									</th>
									<th class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">
										<!-- DAMAGE -->피해
									</th>
									<th class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">
										<!-- SEASON -->제철
									</th>
									<th class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">
										<!-- REG_DT -->등록날짜
									</th>
									<th class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">
										<!-- USE_YN -->사용여부
									</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${guidelists }" var="guidelist">
									<%-- <c:if test="${guidelist.use_yn == 'Y'}"> --%>
									<tr data-guidecode="${guidelist.guide_code }">
										<td data-toggle="tooltip" data-placement="top" title="부류명 또는 품명을 클릭하면 해당 상세 페이지로 이동합니다.">${guidelist.guide_code }</td>
										<td class="guidecode" data-guidecode="${guidelist.guide_code }" data-toggle="tooltip" data-placement="top" title="부류명 또는 품명을 클릭하면 해당 상세 페이지로 이동합니다.">${guidelist.class_code }</td>
										<td class="guidecode" data-guidecode="${guidelist.guide_code }" data-toggle="tooltip" data-placement="top" title="부류명 또는 품명을 클릭하면 해당 상세 페이지로 이동합니다.">${guidelist.item_code }</td>
										<td data-toggle="tooltip" data-placement="top" title="부류명 또는 품명을 클릭하면 해당 상세 페이지로 이동합니다.">${guidelist.difficulty }</td>
										<td data-toggle="tooltip" data-placement="top" title="부류명 또는 품명을 클릭하면 해당 상세 페이지로 이동합니다.">${guidelist.origin }</td>
										<td data-toggle="tooltip" data-placement="top" title="부류명 또는 품명을 클릭하면 해당 상세 페이지로 이동합니다.">${guidelist.temperature }</td>
										<td data-toggle="tooltip" data-placement="top" title="부류명 또는 품명을 클릭하면 해당 상세 페이지로 이동합니다.">${guidelist.damage }</td>
										<td data-toggle="tooltip" data-placement="top" title="부류명 또는 품명을 클릭하면 해당 상세 페이지로 이동합니다.">${guidelist.season }</td>
										<td data-toggle="tooltip" data-placement="top" title="부류명 또는 품명을 클릭하면 해당 상세 페이지로 이동합니다.">${guidelist.reg_dt}</td>
										<td data-toggle="tooltip" data-placement="top" title="부류명 또는 품명을 클릭하면 해당 상세 페이지로 이동합니다.">${guidelist.use_yn }</td>
									</tr>
									<%-- </c:if> --%>
								</c:forEach>
							</tbody>
						</table>

						<%--
 						<div class="col-sm-offset-2 col-sm-10">
							<input type="hidden" id="guidelistExcel" name="guidelistExcel" value="${guidelists }" />
							<button type="button" id="" class="btn btn-primary " onclick="">
								<a class="btn" href="">가이드엑셀다운로드</a>
							</button>
						</div>
 --%>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="">
	<div class="text-right col-12 p-0">
		<button class="btn-warning btn-lg col-xs-4 col-md-3 mb-2" type="button" id="listBtn" name="listBtn" onclick="location.href='${pageContext.request.contextPath}/finfo/gardenguides'">목록으로</button>
	</div>
</div>
