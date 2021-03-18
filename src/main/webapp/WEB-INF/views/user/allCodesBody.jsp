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

<h3 class="mt-4">코드관리 PC최적화</h3>
<div class="col-xs-12 text-right mb-2">
	<button type="button" id="" class="btn btn-primary col-xs-3 " onClick="location.href='CodeExcelDownload'">코드 엑셀다운로드</button>
</div>

<div class="card mb-4">
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
							<thead class="thead-light">
								<tr role="row">
									<th class="sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column descending" style="width: 101px;" aria-sort="ascending">코드번호</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending" style="width: 164px;">코드이름</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending" style="width: 71px;">사용여부</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${codeList }" var="code">
									<tr class="code" data-codeseq="${code.code_seq }">
										<td class="text-left">${code.code_no }</td>
										<td class="text-left">${code.code_nm }</td>
										<td class="text-center">${code.use_yn }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>


					</div>
				</div>
			</div>
		</div>
	</div>
</div>