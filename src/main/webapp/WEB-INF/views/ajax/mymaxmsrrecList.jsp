<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<tr>
	<th style="width: 25%;">장소</th>
	<th style="width: 15%;">장비명</th>
	<th style="width: 15%;">작물명</th>
	<th style="width: 10%;">온도</th>
	<th style="width: 10%;">습도</th>
	<th style="width: 10%;">조도</th>
	<th style="width: 15%;">등록일</th>
</tr>
<c:forEach items="${maxmrrecList}" var="mrrecList">

	<c:if test="${fn:length(mrrecList.location) gt 0}">

		<c:set var="dt">
			<fmt:formatDate value="${mrrecList.reg_dt}" pattern="yyyy-MM-dd" />
		</c:set>
		<c:forEach items="${tempList}" var="temp">
			<c:if test="${temp.item_code == mrrecList.item_code}">
				<c:choose>
					<c:when test="${mrrecList.msr_temp >= temp.number1 && mrrecList.msr_temp <= temp.number2}">
						<tr class="table-success">
					</c:when>

					<c:when test="${mrrecList.msr_temp < temp.number1}">
						<tr class="table-primary">
					</c:when>

					<c:when test="${mrrecList.msr_temp > temp.number2}">
						<tr class="table-danger">
					</c:when>
				</c:choose>
			</c:if>
			<c:if test="${temp.item_code ne mrrecList.item_code and stat.end}">
				<tr>
			</c:if>
		</c:forEach>
		<td style="width: 25%;">${mrrecList.location}</td>
		<td style="width: 15%;">${mrrecList.msr_nm}</td>
		<td style="width: 15%;">${mrrecList.item_code}</td>
		<td style="width: 10%;">${mrrecList.msr_temp}</td>
		<td style="width: 10%;">${mrrecList.msr_humid}</td>
		<td style="width: 10%;">${mrrecList.msr_bright}</td>
		<td style="width: 15%;">${dt}</td>
		</tr>
	</c:if>

</c:forEach>