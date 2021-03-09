<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- <script>document.location="create"</script> -->
<script>
	//문서 로딩이 완료되고 나서 실행되는 영역
	$(function() {
		$(".code").on("click", function() {
			var code_seq = $(this).data("codeseq");
			$("#code_seq").val(code_seq);
			$("#frm").submit();
		});
	});
</script>

<form id="frm" action="${pageContext.request.contextPath}/user/codeDetail" method="post">
	<input type="hidden" id="code_seq" name="code_seq" value="" />
</form>

<h3 class="mt-4">코드저장소</h3>

<div class="card mb-4">
	<div class="card-header">
		<svg class="svg-inline--fa fa-table fa-w-16 mr-1" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="table" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" data-fa-i2svg="">
                                <path fill="currentColor" d="M464 32H48C21.49 32 0 53.49 0 80v352c0 26.51 21.49 48 48 48h416c26.51 0 48-21.49 48-48V80c0-26.51-21.49-48-48-48zM224 416H64v-96h160v96zm0-160H64v-96h160v96zm224 160H288v-96h160v96zm0-160H288v-96h160v96z"></path>
                                </svg>
		<!-- <i class="fas fa-table mr-1"></i> Font Awesome fontawesome.com -->
		코드현황
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
									<th class="sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column descending" style="width: 101px;" aria-sort="ascending">코드번호</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending" style="width: 164px;">코드이름</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending" style="width: 71px;">사용여부</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${codeList }" var="code">
									<tr class="code" data-codeseq="${code.code_seq }">
										<td>${code.code_no }</td>
										<td>${code.code_nm }</td>
										<td>${code.use_yn }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

						<div class="col-sm-offset-2 col-sm-10">
							<button type="" id="" class="btn btn-primary ">
								<a class="btn btn-default pull-right" href="CodeExcelDownload">코드 엑셀다운로드</a>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>