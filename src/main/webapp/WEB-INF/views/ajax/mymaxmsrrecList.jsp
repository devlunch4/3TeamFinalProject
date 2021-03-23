<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<thead style="width: 33%;">
	<tr>
		<th class="p-0" class=" " aria-controls="dataTable" rowspan="1" colspan="1">장소</th>
		<th class="p-0" class=" " aria-controls="dataTable" rowspan="1" colspan="1">장비명</th>
		<th class="p-0" class=" " aria-controls="dataTable" rowspan="1" colspan="1">작물명</th>
		<th class="p-0" class=" " aria-controls="dataTable" rowspan="1" colspan="1">온도</th>
		<th class="p-0" class=" " aria-controls="dataTable" rowspan="1" colspan="1">습도</th>
		<th class="p-0" class=" " aria-controls="dataTable" rowspan="1" colspan="1">조도</th>
		<th class="p-0" class=" " aria-controls="dataTable" rowspan="1" colspan="1">등록일</th>
	</tr>
</thead>
<tbody class="text-center">
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
			<td class="p-0" data-toggle="tooltip" data-placement="top">${mrrecList.location}</td>
			<td class="p-0" data-guidecode="${sts.count}">${mrrecList.msr_nm}</td>
			<td class="p-0" data-guidecode="${sts.count}">${mrrecList.item_code}</td>
			<td class="p-0">${mrrecList.msr_temp}</td>
			<td class="p-0">${mrrecList.msr_humid}</td>
			<td class="p-0">${mrrecList.msr_bright}</td>
			<td class="p-0" data-guidecode="${sts.count}">${dt}</td>
			</tr>
		</c:if>
	</c:forEach>
</tbody>