<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<tr>
	<td style="width: 50%;">게시글 번호:${fmanage.manage_no}</td>
	<td style="width: 50%;">소유자 이름:${fmanage.owner}</td>
</tr>
<tr>
	<td style="width: 50%;">작물명:${fmanage.item_code}</td>
	<td style="width: 50%;">위치:${fmanage.location}</td>
</tr>
<tr>
	<!--20210308_KJH 장비명을 use_yn으로 받고있음 -->
	<td style="width: 50%;">장비명:${fmanage.use_yn}</td>
	<td style="width: 50%;" id="temp">온도:${msrrec.msr_temp}</td>
<tr>

	<td style="width: 50%;">습도:${msrrec.msr_humid}</td>
	<td style="width: 50%;">조도:${msrrec.msr_bright}</td>
</tr>
<tr>
	<td colspan="2">${fmanage.info}</td>
</tr>
