<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 20210302_KJH 등록한 시설 리스트 -->
<h3 class="mt-4">시설관리</h3>
<div class="card mt-2 col-sm-12 px-0">
	<h3 class="card-header">총게시글 :</h3>
	<div class="card-body text-left ">
		<div class="">
			<div class="row">
				<table class="table table-bordered col-sx-12" >
					<tr>
						<th style="width: 10%;">시설번호</th>
						<th style="width: 10%;">소유자</th>
						<th style="width: 50%;">시설위치</th>
						<th style="width: 30%;">등록일</th>
					</tr>
					<c:forEach items="${fcltmngList}" var="fcltmng">
						<c:set var="dt"><fmt:formatDate value="${fcltmng.reg_dt}" pattern="yyyy-MM-dd" /></c:set>
						<tr>
							<td style="width: 10%;">${fcltmng.control_no}</td>
							<td style="width: 10%;">${fcltmng.owner}</td>
							<td style="width: 50%;"><a href="${pageContext.request.contextPath}/fsurpport/facilityInfo?control_no=${fcltmng.control_no}">${fcltmng.location}</a></td>
							<td style="width: 30%;">${dt}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<a href="${pageContext.request.contextPath}/fsurpport/facilityInsert" class="btn btn-primary">시설등록</a>
		</div>
	</div>
</div>
