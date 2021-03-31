<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">똑똑한 장터</h3>
<div class="text-right">
<c:if test="${S_USER.user_id != null }">
	<button type="button" class="btn-sm btn-primary " onclick="location.href='${pageContext.request.contextPath}/fcommunity/registMiniMarketView'">장터게시글 등록</button>
</c:if>
</div>



<!-- 설명 시작 -->
<div class="card mt-2 col-sm-12 px-0">
	<!-- 	<div class="card-header">
		<svg class="svg-inline--fa fa-table fa-w-16 mr-1" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="table" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" data-fa-i2svg="">
<path fill="currentColor" d="M464 32H48C21.49 32 0 53.49 0 80v352c0 26.51 21.49 48 48 48h416c26.51 0 48-21.49 48-48V80c0-26.51-21.49-48-48-48zM224 416H64v-96h160v96zm0-160H64v-96h160v96zm224 160H288v-96h160v96zm0-160H288v-96h160v96z"></path>
</svg>
		<h3>미니장터</h3>
	</div> -->
	<div class="card-body">
		<!-- 품목 선택 해서 조회하는 부분 -->
		<form class="float-right mb-1" action="${pageContext.request.contextPath }/fcommunity/miniMarketView" method="post">
			<div class="row px-2" align="right">
				<label class="m-1 p-1">품목선택/제목검색</label> <select name="item_code" class="form-control form-control-sm col-sm-3 m-1">
					<option value="">전체</option>
					<c:forEach items="${itemList }" var="itemList">
						<option value="${itemList.code_no }" <c:if test="${selectItemCodeValue eq itemList.code_no }">selected="selected"</c:if>>${itemList.code_nm }</option>
					</c:forEach>
				</select>
				<input class="form-control form-control-sm col-sm-3 m-1" type="text" name="title" placeholder="제목 검색어 입력" value="${selectTitleValue }">
				<input class="btn-sm col m-1 btn-primary" type="submit" value="조회">
			</div>
		</form>


		<div class="table-responsive mt-4">
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

						<table class="col-xs-6 col-md-12 table dataTable table-width" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
							<thead>
								<tr role="row">
									<th class="sorting_asc text-center" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Head: activate to sort column descending" aria-sort="ascending">머릿말</th>
									<th class="sorting_asc text-center" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Image: activate to sort column descending">사진</th>
									<th class="sorting_asc text-center" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="TITLE: activate to sort column descending">제목</th>
									<th class="sorting text-center" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="WRITER: activate to sort column ascending">작성자</th>
									<th class="sorting text-center" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="ITEM_CODE_NM: activate to sort column ascending">종류</th>
									<th class="sorting text-center" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="REG_DT: activate to sort column ascending">작성날짜</th>
								</tr>
							</thead>
							<!-- footer 삭제 -->
							<tbody>
								<c:forEach items="${miniMarketList }" var="miniMarketList">
									<tr onclick="location.href='${pageContext.request.contextPath}/fcommunity/miniMarketInfoView?writer=${miniMarketList.writer }&market_no=${miniMarketList.market_no }'">
										<td class="text-center">${miniMarketList.head_code_nm }</td>
										<td class="text-center"><img src="${pageContext.request.contextPath}/fcommunity/filePath?file_nm=${miniMarketList.thumbnail_file_nm }" width="auto;" height="25px"></td>
										<td class="text-left">${miniMarketList.title }</td>
										<td class="text-left">${miniMarketList.writer }</td>
										<td class="text-center">${miniMarketList.item_code_nm }</td>
										<td class="text-center"><fmt:formatDate value="${miniMarketList.reg_dt }" pattern="yyyy.MM.dd" /></td>
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
