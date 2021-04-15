<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tr>
	<td style="width: 50%;">시설 번호</td>
	<td style="width: 50%;">${fmanage.manage_no}</td>
</tr>
<tr>
	<td style="width: 50%;">소유자</td>
	<td style="width: 50%;">${fmanage.owner}</td>
</tr>

<tr>
	<td style="width: 50%;">작물명</td>
	<td style="width: 50%;">${fmanage.item_code}</td>
</tr>
<tr>
	<td style="width: 50%;">위치</td>
	<td style="width: 50%;">${fmanage.location}</td>
</tr>
<tr>
	<!--20210308_KJH 장비명을 use_yn으로 받고있음 -->
	<td style="width: 50%;">장비명</td>
	<td style="width: 50%;">${fmanage.use_yn}</td>
</tr>
<!-- //값이 없는 경우 분할처리 -->
<c:choose>
	<c:when test="${empty  msrrec}">
		<tr>
			<td style="width: 50%;" id="temp">온도</td>
			<td style="width: 50%;" id="temp2" class="text-danger">측정된값이 없습니다.</td>
		</tr>
		<tr>
			<td style="width: 50%;">습도</td>
			<td style="width: 50%;" class="text-danger">측정된값이 없습니다.</td>
		</tr>
		<tr>
			<td style="width: 50%;">조도</td>
			<td style="width: 50%;" class="text-danger">측정된값이 없습니다.</td>
		</tr>
		<tr>
			<td colspan="2">${fmanage.info}</td>
		</tr>
		<tr>
			<td colspan="2" class="small text-danger">* 조도 값이 높을 경우 어둡습니다.</td>
		</tr>
	</c:when>
	<c:when test="${not empty msrrec}">
		<tr>
			<td style="width: 50%;" id="temp">온도</td>
			<td style="width: 50%;" id="temp2">${msrrec.msr_temp}°C</td>
		</tr>
		<tr>
			<td style="width: 50%;">습도</td>
			<td style="width: 50%;">${msrrec.msr_humid}%</td>
		</tr>
		<tr>
			<td style="width: 50%;">조도</td>
			<td style="width: 50%;">${msrrec.msr_bright}</td>
		</tr>
		<tr>
			<td colspan="2">${fmanage.info}</td>
		</tr>
		<tr>
			<td colspan="2" class="small text-danger">* 조도 값이 높을 경우 어둡습니다.</td>
		</tr>
	</c:when>
</c:choose>