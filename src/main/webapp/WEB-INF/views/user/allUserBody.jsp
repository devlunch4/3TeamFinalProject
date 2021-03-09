<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- <script>document.location="create"</script> -->
<script>
	//문서 로딩이 완료되고 나서 실행되는 영역
	$(function() {
		$(".user").on("click", function() {
			//this : 클릭 이벤트가 발생한 element
			// data-속성명  data-userid, 속성명은 대소문자 무시하고 소문자로 인식
			// data-userId ==> data-userid
			var user_id = $(this).data("userid");
			$("#userid").val(user_id);
			$("#frm").submit();
		});
	});
</script>

<form id="frm" action="${pageContext.request.contextPath}/user/userDetail" method="post">
	<input type="hidden" id="userid" name="user_id" value="" />
</form>

<h3 class="mt-4">전체사용자 조회</h3>

<div class="card mb-4">
	<div class="card-header">
		<svg class="svg-inline--fa fa-table fa-w-16 mr-1" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="table" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" data-fa-i2svg="">
                                <path fill="currentColor" d="M464 32H48C21.49 32 0 53.49 0 80v352c0 26.51 21.49 48 48 48h416c26.51 0 48-21.49 48-48V80c0-26.51-21.49-48-48-48zM224 416H64v-96h160v96zm0-160H64v-96h160v96zm224 160H288v-96h160v96zm0-160H288v-96h160v96z"></path>
                                </svg>
		<!-- <i class="fas fa-table mr-1"></i> Font Awesome fontawesome.com -->
		전체사용자 조회
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
									<th class="sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column descending" style="width: 101px;" aria-sort="ascending">이름</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending" style="width: 164px;">ID</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending" style="width: 71px;">가입일</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${userList }" var="user">
									<c:if test="${user.use_yn == 'Y'}">
										<tr class="user" data-userid="${user.user_id }">
											<td>${user.user_nm }</td>
											<td>${user.user_id }</td>
											<td><fmt:formatDate value="${user.reg_dt }" pattern="yyyy.MM.dd" /></td>
										</tr>
									</c:if>
								</c:forEach>
							</tbody>
						</table>
						<div class="col-sm-offset-2 col-sm-10">
							<button type="" id="" class="btn btn-primary ">
								<a class="btn btn-default pull-right" href="userExcelDownload">사용자 엑셀다운로드</a>
							</button>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>

