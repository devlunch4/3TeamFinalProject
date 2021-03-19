<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<thead>
	<tr role="row">
		<th style="width: 25%;" role="row" class="sorting_asc " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="No: activate to sort column descending" aria-sort="ascending">장소</th>
		<th style="width: 15%;" role="row" class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column ascending">장비명</th>
		<th style="width: 15%;" role="row" class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">작물명</th>
		<th style="width: 10%;" role="row" class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">온도</th>
		<th style="width: 10%;" role="row" class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">습도</th>
		<th style="width: 10%;" role="row" class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">조도</th>
		<th style="width: 15%;" role="row" class="sorting " tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">등록일</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${maxmrrecList}" var="mrrecList" varStatus="stat">
		<c:if test="${fn:length(mrrecList.location) gt 0}">
			<c:set var="dt">
				<fmt:formatDate value="${mrrecList.reg_dt}" pattern="yyyy-MM-dd" />
			</c:set>
			<c:forEach items="${tempList}" var="temp" varStatus="sts">

				<c:if test="${temp.item_code == mrrecList.item_code}">
					<c:choose>
						<c:when test="${mrrecList.msr_temp >= temp.number1 && mrrecList.msr_temp <= temp.number2}">
							<tr class="table-success" data-guidecode="${sts.count}">
						</c:when>

						<c:when test="${mrrecList.msr_temp < temp.number1}">
							<tr class="table-primary" data-guidecode="${sts.count}">
						</c:when>

						<c:when test="${mrrecList.msr_temp > temp.number2}">
							<tr class="table-danger" data-guidecode="${sts.count}">
						</c:when>
					</c:choose>
				</c:if>
				<c:if test="${temp.item_code ne mrrecList.item_code and stat.end}">
					<tr data-guidecode="${sts.count}">
				</c:if>
			</c:forEach>
			<td style="width: 25%;" data-toggle="tooltip" data-placement="top">${mrrecList.location}</td>
			<td style="width: 15%;" data-guidecode="${sts.count}">${mrrecList.msr_nm}</td>
			<td style="width: 15%;" data-guidecode="${sts.count}">${mrrecList.item_code}</td>
			<td style="width: 10%;">${mrrecList.msr_temp}</td>
			<td style="width: 10%;">${mrrecList.msr_humid}</td>
			<td style="width: 10%;">${mrrecList.msr_bright}</td>
			<td style="width: 15%;" data-guidecode="${sts.count}">${dt}</td>
			</tr>
		</c:if>
	</c:forEach>
</tbody>