<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">미니장터</h3>

<button type="button" class=" btn btn-success " 
onclick="location.href='${pageContext.request.contextPath}/fsurpport/insertView?owner=${S_USER.user_id }'" >미니장터게시글 등록</button>

<div class="card mt-2 col-sm-12">
	<!-- 품목 선택 해서 조회하는 부분 -->
	<form action="${pageContext.request.contextPath }/fsurpport/searchAllFsurpportList" method="post">

		<div class="card-body text-left p-1">
			<span class="">가나다순</span> <br>
			<c:choose>
				<c:when test="${searchFarmdiaryValue != null }">
					<input type="date" name="startDate" 
					value="${searchFarmdiaryValue.startDate }" class=" btn btn-outline-dark m-1">
					<input type="date" name="endDate" 
					value="${searchFarmdiaryValue.endDate }" class=" btn btn-outline-dark m-1">
				</c:when>
				
				<c:otherwise>
					<input type="date" name="startDate" value="" class=" btn btn-outline-dark m-1">
					<input type="date" name="endDate" value="" class=" btn btn-outline-dark m-1">
				</c:otherwise>			
			</c:choose>
		</div>
		<div class="card-body text-left p-1">
			<label>*품목</label> <br>
			<select name="item_code">
				<option value="">전체</option>
				<c:forEach items="${itemsList }" var="itemsList">
					<option value="${itemsList.code_no }" 
					<c:if test="${searchFarmdiaryValue.item_code eq itemsList.code_no }">selected="selected"</c:if>
					>${itemsList.code_nm }</option>
				</c:forEach>
			</select>
		</div>
		
		<input type="hidden" name="writer" value="${S_USER.user_id }" style="margin-left: 20%;" readonly="readonly">
		<input type="submit" value="조회" style="margin-left: 20%;">
	</form>
</div>


<!-- 설명 시작 -->
<div class="card mt-2 col-sm-12 px-0">
	<div class="card-header">
		<svg class="svg-inline--fa fa-table fa-w-16 mr-1" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="table" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" data-fa-i2svg="">
               		<path fill="currentColor" d="M464 32H48C21.49 32 0 53.49 0 80v352c0 26.51 21.49 48 48 48h416c26.51 0 48-21.49 48-48V80c0-26.51-21.49-48-48-48zM224 416H64v-96h160v96zm0-160H64v-96h160v96zm224 160H288v-96h160v96zm0-160H288v-96h160v96z"></path>
                </svg>
		<h3>미니장터</h3>
		
		
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
					<div class="col-xs-12 col-md-12 col-sm-12 ">
					
<!-- 					<input type="button" value="EXCEL다운로드" class="float-right btn btn-success col-xs-2 col-md-2   "  -->
<%-- 					onclick="location.href='${pageContext.request.contextPath}/fsurpport/excelFamrdiaryList?user_id=${S_USER.user_id }'"> --%>
							
<!-- 					<input type="button" value="PDF다운로드" class="float-right btn btn-success col-xs-2 col-md-2  "  -->
<%-- 					onclick="location.href='${pageContext.request.contextPath}/fsurpport/farmdiaryListPDF.pdf?user_id=${S_USER.user_id }'"> --%>
							
						<table class="col-xs-6 col-md-12 table table-bordered dataTable" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
							<thead>
								<tr role="row">
									<th class="sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Image: activate to sort column descending" aria-sort="ascending">사진</th>
									<th class="sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="TITLE: activate to sort column descending" aria-sort="ascending">제목</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="WRITER: activate to sort column ascending">작성자</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="ITEM_CODE_NM: activate to sort column ascending">종류</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="REG_DT: activate to sort column ascending">작성날짜</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th rowspan="1" colspan="1">사진</th>
									<th rowspan="1" colspan="1">제목</th>
									<th rowspan="1" colspan="1">작성자</th>
									<th rowspan="1" colspan="1">종류</th>
									<th rowspan="1" colspan="1">작성날짜</th>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach items="${miniMarketList }" var="miniMarketList">
									<tr onclick="location.href='${pageContext.request.contextPath}/fsurpport/infoView?f_diary_no=${miniMarketList.market_no }'" >
										<td>
<%-- 											<img src="${pageContext.request.contextPath}/fsurpport/filePath?file_nm=${miniMarketList.thumbnail }" width="50" height="50" > --%>
											<img>
										</td>
										<td>${miniMarketList.title }</td>
										<td>${miniMarketList.writer }</td>
										<td>${miniMarketList.code_nm }</td>
										<td>
											<fmt:formatDate value="${miniMarketList.reg_dt }" pattern="yyyy.MM.dd" />
										</td>
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
