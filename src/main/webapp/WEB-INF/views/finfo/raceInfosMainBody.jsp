<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">품종정보</h3>

<div>
	<c:if test="${S_USER.user_id.equals('admin') }">
		<button type="button" class="btn btn-success btn-lg btn-block col-md-3 float-right" 
			onclick="location.href='#'" class=" btn btn-outline-dark m-1">품종정보 등록</button>
	</c:if>
</div>

<div>
	<div class="card mt-2 col-sm-12">
		<div class="card-body text-left p-1">
<%-- 			<c:choose> --%>
<%-- 				<c:when test=""> --%>
	<%-- 			<c:forEach items="" var="" > --%>
					<button type="button" onclick="#" 
					class=" btn btn-primary m-1">ㅅ</button>
	<%-- 			</c:forEach> --%>
<%-- 				</c:when> --%>
<%-- 				<c:otherwise> --%>
						<button type="button" onclick="#" 
						class=" btn btn-outline-dark m-1">ㄱ</button>
<%-- 				</c:otherwise> --%>
<%-- 			</c:choose> --%>
		
		</div>
		<div class="card-body text-left p-1">
			<span class="">품명</span> <br>
			
<%-- 			<c:choose> --%>
<%-- 				<c:when test=""> --%>
	<%-- 			<c:forEach items="" var="" > --%>
						<button type="button" onclick="#" 
						class=" btn btn-primary m-1">품명</button>
	<%-- 			</c:forEach> --%>
<%-- 				</c:when> --%>
<%-- 				<c:otherwise> --%>
					<button type="button" onclick="#" 
					class=" btn btn-outline-dark m-1">품명</button>
<%-- 				</c:otherwise> --%>
<%-- 			</c:choose>	 --%>
				
		</div>
	</div>
	
	<div class="card-body text-left p-1" style="float: right;">
		<form action="#" method="post">
				<select name="" >
					<option value="">전체</option>
<%-- 					<c:forEach items="" var=""> --%>
						<option value=""></option>
<%-- 					</c:forEach> --%>
				</select>
				<input type="text" name="" >
				<input type="submit" value="검색">
		</form>
	</div>
	
	<!-- 설명 시작 -->
<div class="card mt-2 col-sm-12 px-0">
	<div class="card-header">
		<svg class="svg-inline--fa fa-table fa-w-16 mr-1" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="table" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" data-fa-i2svg="">
               		<path fill="currentColor" d="M464 32H48C21.49 32 0 53.49 0 80v352c0 26.51 21.49 48 48 48h416c26.51 0 48-21.49 48-48V80c0-26.51-21.49-48-48-48zM224 416H64v-96h160v96zm0-160H64v-96h160v96zm224 160H288v-96h160v96zm0-160H288v-96h160v96z"></path>
                </svg>
		<h3>임시 품종 테이블 목록</h3>
		
		
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
									<th class="sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" 
									aria-label="Image: activate to sort column descending" aria-sort="ascending">사진</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" 
									aria-label="RINFO_NM: activate to sort column ascending">작물명</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" 
									aria-label="DEV_YEAR: activate to sort column ascending">육성년도</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" 
									aria-label="INC_CODE: activate to sort column ascending">육성기관</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" 
									aria-label="VRT_NM: activate to sort column ascending">품종명</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" 
									aria-label="SPEC: activate to sort column ascending">주요특성</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" 
									aria-label="FILE_NO: activate to sort column ascending">첨부파일</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th rowspan="1" colspan="1">사진</th>
									<th rowspan="1" colspan="1">작물명</th>
									<th rowspan="1" colspan="1">육성년도</th>
									<th rowspan="1" colspan="1">육성기관</th>
									<th rowspan="1" colspan="1">품종명</th>
									<th rowspan="1" colspan="1">주요특성</th>
									<th></th>
								</tr>
							</tfoot>
							<tbody>
<%-- 								<c:forEach items="${farmdiaryList }" var="farmdiaryList"> --%>
									<tr >
										<td>
											<img src="#" >
										</td>
										<td>
											<fmt:formatDate value="${farmdiaryList.reg_dt }" pattern="yyyy.MM.dd" />
										</td>
										<td>${farmdiaryList.item_code }</td>
										<td>${farmdiaryList.wstep_code }</td>
										<td></td>
										<td></td>
										<td>
											<input type="button" value="다운로드"
												onclick="location.href=''">
										</td>
									</tr>
<%-- 								</c:forEach> --%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>