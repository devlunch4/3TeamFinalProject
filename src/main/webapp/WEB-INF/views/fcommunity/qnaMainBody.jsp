<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">문의사항</h3>


<!-- 설명 시작 -->
<div class="mt-2 col-sm-12 px-0">
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
								<th class="sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="NOTICE_NO: activate to sort column descending" aria-sort="ascending">번호</th>
								<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="TITLE: activate to sort column ascending">제목</th>
								<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="WRITER: activate to sort column ascending">작성자</th>
								<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="REG_DT: activate to sort column ascending">작성일시</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${qnaList}" var="qna">
								<tr onclick="location.href='${pageContext.request.contextPath}/qna/detailView?qna_no=${qna.qna_no}'">
									<td>${qna.qna_no}</td>
									<td>${qna.title}</td>
									<td>${qna.writer}</td>
									<td>
										<fmt:formatDate value="${qna.reg_dt }" pattern="yyyy.MM.dd" />
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
