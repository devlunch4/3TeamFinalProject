<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">미니장터</h3>

	<c:if test="${S_USER != null }">
		<button type="button" class=" btn btn-success " 
		onclick="location.href='${pageContext.request.contextPath}/fcommunity/minimarketRegistView'" 
		class=" btn btn-outline-dark m-1">미니장터 글 작성</button>
	</c:if>
		<button type="button" class=" btn btn-success " 
		onclick="location.href='${pageContext.request.contextPath}/fcommunity/minimarketRegistView'" 
		class=" btn btn-outline-dark m-1">미니장터 글 작성</button>


<!-- 설명 시작 -->
<div class="card mt-2 col-sm-12 px-0">
	<div class="card-header">
		<svg class="svg-inline--fa fa-table fa-w-16 mr-1" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="table" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" data-fa-i2svg="">
               		<path fill="currentColor" d="M464 32H48C21.49 32 0 53.49 0 80v352c0 26.51 21.49 48 48 48h416c26.51 0 48-21.49 48-48V80c0-26.51-21.49-48-48-48zM224 416H64v-96h160v96zm0-160H64v-96h160v96zm224 160H288v-96h160v96zm0-160H288v-96h160v96z"></path>
                </svg>
		<h3>미니장터</h3>
		
		
		
	</div>
</div>

	<div class="card-body text-left p-1" style="float: right;">
	
		<form action="#" method="post">
				<select name="" >
					<option value="">카테고리 선택</option>
<%-- 					<c:forEach items="" var=""> --%>
						<option value=""></option>
<%-- 					</c:forEach> --%>
				</select>
				<input type="text" name="" >
				<input type="submit" value="검색">
		</form>
	</div>

<div class="card mt-2 col-sm-12 px-0">
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
									<th class="sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
									 aria-label="MHEAD_CODE: activate to sort column descending" aria-sort="ascending">판매상태</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" 
									aria-label="IMAGE: activate to sort column ascending">(사진)</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" 
									aria-label="TITLE: activate to sort column ascending">제목</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" 
									aria-label="WRITER: activate to sort column ascending">작성자</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" 
									aria-label="REG_DT: activate to sort column ascending">작성일시</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th rowspan="1" colspan="1">판매상태</th>
									<th rowspan="1" colspan="1"></th>
									<th rowspan="1" colspan="1">제목</th>
									<th rowspan="1" colspan="1">작성자</th>
									<th rowspan="1" colspan="1">작성일시</th>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach items="${farmdiaryList }" var="farmdiaryList">
									<tr onclick="location.href='${pageContext.request.contextPath}/fcommunity/minimarketInfoView'" >
										<td></td>
										<td><img src=""></td>
										<td>${farmdiaryList.item_code }</td>
										<td>${farmdiaryList.w_step_code }</td>
										<td>
											<fmt:formatDate value="${farmdiaryList.reg_dt }" pattern="yyyy.MM.dd" />
										</td>
									</tr>
								</c:forEach>
								
								<tr onclick="location.href='${pageContext.request.contextPath}/fcommunity/minimarketInfoView'" >
								  <c:forEach items="${noticelist }" var="notice">
										<td>${noticelist. }</td>
										<td><img src=""></td>
										<td></td>
										<td></td>
										<td></td>
								  </c:forEach>
								</tr>
								
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

