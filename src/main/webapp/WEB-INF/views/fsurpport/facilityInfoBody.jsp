<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 20210302_KJH 시설정보 조회 -->
<h3 class="mt-4">시설관리</h3>

<div class="card mt-2 col-sm-12 px-0">
	<h3 class="card-header">총게시글 :</h3>
	<div class="card-body text-left ">
		<div class="">
			<div class="row">
				<table class="table table-bordered col-sx-12" style="text-align: center;">
					<tr>
						<td style="width: 50%;">${facility.location}</td>
						<td style="width: 50%;">${facility.owner}</td>
					</tr>
					<tr>
						<td style="width: 50%;">작물</td>
						<td style="width: 50%;">둔산동농장32</td>
					</tr>
					<tr>
						<td style="width: 50%;">장비번호32</td>
						<td style="width: 50%;">현재온도:21도</td>
					</tr>
					<tr>
						<td style="width: 50%;">습도:60%</td>
						<td style="width: 50%;">조도:100</td>
					</tr>
					<tr>
						<td colspan="2">내용없음</td>
					</tr>
				</table>
			</div>
			<button type="button" class="btn btn-warning float-left" onclick="location.href = '${pageContext.request.contextPath }/fsurpport/facilityupdate?control_no=${facility.control_no}'">수정하기</button>
			<button type="button" class="btn btn-danger float-left" style="margin-left: 5px;">삭제하기</button>
		</div>
	</div>
</div>
