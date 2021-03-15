<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!-- 20210302_KJH 등록한 시설 리스트 -->
<h3 class="mt-4">시설관리</h3>
<div class="card mt-2 col-sm-12 px-0">
	<h3 class="card-header">총게시글 :</h3>
	<div class="card-body text-left ">
	<div class="mt-2 col-sm-2 px-0 float-right">			
		<a href="${pageContext.request.contextPath}/fsurpport/fmanageInsertPage" class="btn btn-primary p-2 float-right">시설등록</a>
		</div> 
		<br><br><br>	
		<div class="">
		<div class="row">
				<table class="table table-bordered col-sx-12">
					<tr>
						<th style="width: 10%;">시설번호</th>
						<th style="width: 10%;">소유자</th>
						<th style="width: 50%;">시설위치</th>
						<th style="width: 30%;">등록일</th>
					</tr>
					<c:forEach items="${fmanageList}" var="fmanage">
						<c:set var="dt">
							<fmt:formatDate value="${fmanage.reg_dt}" pattern="yyyy-MM-dd" />
						</c:set>
						<c:if test="${fmanage.owner == S_USER.user_id && fmanage.use_yn == 'Y'}">
							<tr>
								<td style="width: 10%;">${fmanage.manage_no}</td>
								<td style="width: 10%;">${fmanage.owner}</td>
								<td style="width: 50%;"><a href="${pageContext.request.contextPath}/fsurpport/fmanageInfo?manage_no=${fmanage.manage_no}">${fmanage.location}</a></td>
								<td style="width: 30%;">${dt}</td>
							</tr>
						</c:if>
						<c:if test="${S_USER.user_id == '1'}">
							<tr>
								<td style="width: 10%;">${fmanage.manage_no}</td>
								<td style="width: 10%;">${fmanage.owner}</td>
								<td style="width: 50%;"><a href="${pageContext.request.contextPath}/fsurpport/fmanageInfo?manage_no=${fmanage.manage_no}">${fmanage.location}</a></td>
								<td style="width: 30%;">${dt}</td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
			</div>
			<div class="mt-2 col-sm-2 px-0 float-right">			
		<a href="${pageContext.request.contextPath}/fsurpport/fmanageInsertPage" class="btn btn-primary p-2 float-right">시설등록</a>
		</div> </div>     
	</div>
</div>
