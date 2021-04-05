<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">영농일지</h3>
<div class="text-right">
	<button type="button" class="btn btn-primary mb-2" onclick="location.href='${pageContext.request.contextPath}/fsurpport/insertView?owner=${S_USER.user_id }'">영농일지 등록</button>
</div>

<!-- 품목 선택 해서 조회 검색 부분 -->
<form action="${pageContext.request.contextPath }/fsurpport/searchAllFsurpportList" method="post">
	<div class="card ">
		<div class="card-header">
			<h4>기간/품목 검색</h4>
		</div>
		<div class="form-group p-1 mb-0">
			<div class="col">
				<label class="small ml-2 mb-0" for="">기간 선택</label>
				<div class="">
					<c:choose>
						<c:when test="${searchFarmdiaryValue != null }">
							<input type="date" name="startDate" value="${searchFarmdiaryValue.startDate }" class="btn btn-outline-dark  col-md-5">
							<input type="date" name="endDate" value="${searchFarmdiaryValue.endDate }" class="btn btn-outline-dark  col-md-5">
						</c:when>
						<c:otherwise>
							<input type="date" name="startDate" value="" class=" btn btn-outline-dark m-1 col-md-5">
							<input type="date" name="endDate" value="" class=" btn btn-outline-dark m-1 col-md-5">
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
		
		
		<div class="form-group p-1 mb-0">
			<div class="col">
				<label class="small ml-2 mb-0" for="">품목 선택</label>
				<div>
					<select name="item_code" class="btn btn-outline-dark m-1 col-md-5" style="width: auto%;">
						<option value="">전체</option>
						<c:forEach items="${itemsList }" var="itemsList">
							<option value="${itemsList.code_no }" <c:if test="${searchFarmdiaryValue.item_code eq itemsList.code_no }">selected="selected"</c:if>>${itemsList.code_nm }</option>
						</c:forEach>
					</select>
					<input type="hidden" name="writer" value="${S_USER.user_id }" readonly="readonly">
					<input class="btn btn-info m-1 col-md-5" type="submit" value="조회">
				</div>

			</div>
		</div>
	</div>
</form>

<!-- 설명 시작 -->
<div class="card mt-2">
	<div class="card-header">
		<h4>영농일지 목록</h4>
	</div>
	<div class="card-body">
		<div class="text-right">
			<input type="button" value="EXCEL다운로드" class=" btn btn-primary col-xs-2 col-md-2 mt-2" onclick="location.href='${pageContext.request.contextPath}/fsurpport/excelFamrdiaryList?user_id=${S_USER.user_id }'">
			<input type="button" value="PDF다운로드" class=" btn btn-primary col-xs-2 col-md-2 mt-2" onclick="location.href='${pageContext.request.contextPath}/fsurpport/farmdiaryListPDF.pdf?user_id=${S_USER.user_id }'">
		</div>

		<div class="table-responsive mt-2">
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
					<div class="col-xs-12 col-md-12 col-sm-12 ">
						<table class="table table-bordered dataTable table-width small" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
							<thead class="thead-light">
								<tr role="row" class="small">
									<th class="sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Image: activate to sort column descending" aria-sort="ascending">사진</th>
									<th class="sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="CODE_ALIAS: activate to sort column descending" aria-sort="ascending">간편등록</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="REG_DT: activate to sort column ascending">일자</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="ITEM_CODE: activate to sort column ascending">품목</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="W_STEP_CODE: activate to sort column ascending">작업단계</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${farmdiaryList }" var="farmdiaryList">
									<tr onclick="location.href='${pageContext.request.contextPath}/fsurpport/infoView?f_diary_no=${farmdiaryList.f_diary_no }'">
										<td class="text-center "><img src="${pageContext.request.contextPath}/fsurpport/filePath?file_nm=${farmdiaryList.file_nm }" alt="사진없음" width="30px" height="30px"></td>
										<td class="text-left ">${farmdiaryList.code_alias }</td>
										<td class="text-center "><fmt:formatDate value="${farmdiaryList.reg_dt }" pattern="yyyy.MM.dd" /></td>
										<td class="text-left ">${farmdiaryList.item_code }</td>
										<td class="text-left ">${farmdiaryList.w_step_code }</td>
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