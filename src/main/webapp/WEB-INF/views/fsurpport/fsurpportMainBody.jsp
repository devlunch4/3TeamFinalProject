<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">영농일지</h3>

<button type="button" class=" btn btn-success " 
onclick="location.href='${pageContext.request.contextPath}/fsurpport/insertView?owner=${S_USER.user_id }'" class=" btn btn-outline-dark m-1">영농일지 등록</button>

<div class="card mt-2 col-sm-12">
	<!-- 품목 선택 해서 조회하는 부분 -->
	<form action="${pageContext.request.contextPath }/fsurpport/searchAllFsurpportList" method="post">

		<div class="card-body text-left p-1">
			<span class="">가나다순</span> <br>
			<input type="date" name="startDate" value="" class=" btn btn-outline-dark m-1">
			<input type="date" name="endDate" value="" class=" btn btn-outline-dark m-1">
		</div>
		<div class="card-body text-left p-1">
			<label>*품목</label> <label style="margin-left: 10%;">*작업단계</label> <br>
			<select name="item_code">
				<option value="">전체</option>
				<c:forEach items="${itemsList }" var="itemsList">
					<option value="${itemsList.code_no }">${itemsList.code_nm }</option>
				</c:forEach>
			</select>
			<select name="w_step_code" style="margin-left: 10%;">
				<option value="">전체</option>
				<c:forEach items="${workstepsList }" var="workstepsList">
					<option value="${workstepsList.code_no }">${workstepsList.code_nm }</option>
				</c:forEach>
			</select>
		</div>
		<input type="submit" value="조회	" style="margin-left: 20%;">
	</form>
</div>

<!-- 설명 시작 -->
<div class="card mt-2 col-sm-12 px-0">
	<div class="card-header">
		<svg class="svg-inline--fa fa-table fa-w-16 mr-1" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="table" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" data-fa-i2svg="">
               		<path fill="currentColor" d="M464 32H48C21.49 32 0 53.49 0 80v352c0 26.51 21.49 48 48 48h416c26.51 0 48-21.49 48-48V80c0-26.51-21.49-48-48-48zM224 416H64v-96h160v96zm0-160H64v-96h160v96zm224 160H288v-96h160v96zm0-160H288v-96h160v96z"></path>
                </svg>
		<h3>총게시글 :</h3>
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
									<th class="sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Image: activate to sort column descending" aria-sort="ascending">사진</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="REG_DT: activate to sort column ascending">일자</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="ITEM_CODE: activate to sort column ascending">품목</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="W_STEP_CODE: activate to sort column ascending">작업단계</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th rowspan="1" colspan="1">사진</th>
									<th rowspan="1" colspan="1">일자</th>
									<th rowspan="1" colspan="1">품목</th>
									<th rowspan="1" colspan="1">작업단계</th>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach items="${farmdiaryList }" var="farmdiaryList">
									<tr onclick="location.href='${pageContext.request.contextPath}/fsurpport/infoView?f_diary_no=${farmdiaryList.f_diary_no }'" >
										<td>
											<img src="${farmdiaryList.file_nm }" >
										</td>
										<td>
											<fmt:formatDate value="${farmdiaryList.reg_dt }" pattern="yyyy.MM.dd" />
										</td>
										<td>${farmdiaryList.item_code }</td>
										<td>${farmdiaryList.w_step_code }</td>
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
