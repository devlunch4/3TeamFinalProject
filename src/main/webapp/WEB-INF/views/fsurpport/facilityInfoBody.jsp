<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<script>
	//20210304_KJH 5초마다 새로고침
	$(function() {

		setTimeout("location.reload()", 5000);

	});
</script>

<!-- 20210302_KJH 시설정보 조회 -->
<h3 class="mt-4">시설관리</h3>

<div class="card mt-2 col-sm-12 px-0">
	<h3 class="card-header">총게시글 :</h3>
	<div class="card-body text-left ">
		<div class="">
			<div class="row">
				<table class="table table-bordered col-sx-12" style="text-align: center;">
					<tr>
						<td style="width: 50%;">${facility.manage_no}</td>
						<td style="width: 50%;">${facility.owner}</td>
					</tr>
					<tr>
						<td style="width: 50%;">${facility.item_code}</td>
						<td style="width: 50%;">${facility.location}</td>
					</tr>
					<tr>
					<!--20210308_KJH 장비명을 use_yn으로 받고있음 -->
						<td style="width: 50%;">장비명:${msrrec.use_yn}</td>
						<td style="width: 50%;">온도:${msrrec.msr_temp}</td>
					</tr>
					<tr>
						<td style="width: 50%;">습도:${msrrec.msr_humid}</td>
						<td style="width: 50%;">조도:${msrrec.msr_bright}</td>
					</tr>
				</table>
			</div>
			<button type="button" class="btn btn-warning float-left" onclick="location.href = '${pageContext.request.contextPath }/fsurpport/facilityupdate?manage_no=${facility.manage_no}'">수정하기</button>
			<button type="button" class="btn btn-danger float-left" style="margin-left: 5px;">삭제하기</button>
		</div>
	</div>
</div>
