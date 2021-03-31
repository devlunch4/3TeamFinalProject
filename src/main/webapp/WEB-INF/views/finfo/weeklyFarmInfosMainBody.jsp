<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">주간 농사정보</h3>

<div>
	<c:if test="${S_USER.user_id.equals('admin') }">
		<!-- 		<button type="button" class="btn btn-success btn-lg btn-block col-md-3 float-right" -->
		<!-- 			onclick="location.href='#'" class=" btn btn-outline-dark m-1">주간 농사정보 등록</button> -->
		<form action="${pageContext.request.contextPath}/finfo/registWeeklyFarmInfosView" method="post">
			<input type="hidden" name="user_id" value="${S_USER.user_id }">
			<input type="submit" value="주간 농사정보 등록">
		</form>
	</c:if>
</div>

<!-- 설명 시작 -->
<div class="card mt-2 col-sm-12 px-0">
	<!-- 	<div class="card-header">
		<svg class="svg-inline--fa fa-table fa-w-16 mr-1" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="table" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" data-fa-i2svg="">
               		<path fill="currentColor" d="M464 32H48C21.49 32 0 53.49 0 80v352c0 26.51 21.49 48 48 48h416c26.51 0 48-21.49 48-48V80c0-26.51-21.49-48-48-48zM224 416H64v-96h160v96zm0-160H64v-96h160v96zm224 160H288v-96h160v96zm0-160H288v-96h160v96z"></path>
                </svg>
		<h3>주간 농사정보</h3>
		
		
	</div> -->
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
						<table class="table table-bordered table-width dataTable" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
							<thead>
								<tr role="row">
									<th class="sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="NUMBER: activate to sort column descending" aria-sort="ascending">번호</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="TITLE: activate to sort column ascending">제목</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="WRITER: activate to sort column ascending">작성자</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="REG_DT: activate to sort column ascending">등록일</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="FILE_CODE: activate to sort column ascending">첨부파일</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="ETC activate to sort column ascending">기타</th>
								</tr>
							</thead>
							<!-- 	<tfoot>
								<tr>
									<th rowspan="1" colspan="1">번호</th>
									<th rowspan="1" colspan="1">제목</th>
									<th rowspan="1" colspan="1">작성자</th>
									<th rowspan="1" colspan="1">등록일</th>
									<th rowspan="1" colspan="1">첨부파일</th>
									<th rowspan="1" colspan="1">기타</th>
								</tr>
							</tfoot> -->
							<tbody>
								<c:forEach items="${weeklyFarmInfosList }" var="weeklyFarmInfosList">
									<tr>
										<td class="text-center">${weeklyFarmInfosList.w_info_no }</td>
										<td>${weeklyFarmInfosList.title }</td>
										<td>${weeklyFarmInfosList.writer }</td>
										<td><fmt:formatDate value="${weeklyFarmInfosList.reg_dt }" pattern="yyyy.MM.dd" /></td>
										<td class="p-0"><c:if test="${weeklyFarmInfosList.file_no > 0 }">
												<button class="btn btn-primary m-0" onclick="location.href='${pageContext.request.contextPath}/finfo/weeklyFarmInfosFilePath?file_nm=${weeklyFarmInfosList.file_nm }'">${weeklyFarmInfosList.file_nm }</button>
											</c:if></td>
										<td><c:if test="${S_USER.user_id.equals('admin') }">
												<form action="${pageContext.request.contextPath}/finfo/modifyWeeklyFarmInfosView" method="post">
													<input type="hidden" name="w_info_no" value="${weeklyFarmInfosList.w_info_no }">
													<input type="hidden" name="writer" value="${weeklyFarmInfosList.writer }">
													<input type="submit" value="수정">
												</form>
												<form action="${pageContext.request.contextPath}/finfo/deleteWeeklyFarmInfos" method="post">
													<input type="hidden" name="w_info_no" value="${weeklyFarmInfosList.w_info_no }">
													<input type="submit" value="삭제">
												</form>
											</c:if></td>
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