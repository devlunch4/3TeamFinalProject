<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<script>
	function goBack() {
		window.history.back();
	}
	$(function() {
		setInterval(
				function() {
					$
							.ajax({
								// type을 설정합니다.
								type : 'POST',
								url : "${pageContext.request.contextPath}/fsurpport/fmanageInfoajax",
								// 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
								data : {
									"manage_no" : '${fmanage.manage_no}'
								},
								//         dataType : "json",
								// 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
								success : function(data) {
									$('#tb').html(data);
								}
							});
				}, 10000);

		$("#formbtn").on("click", function() {

			if ($("#chform").css("display") == 'none') {
				$("#chform").show();
				$("#save").show();
			} else {
				$("#chform").hide();
				$("#save").hide();
			}
		});

		$("#updatebtn").on("click", function() {
			alert("수정페이지로 이동합니다.");
			$("#updateform").submit();
		});

	});
</script>

<!-- 20210302_KJH 시설정보 조회 -->
<h3 class="mt-4">시설관리 상세</h3>
<div class="card mt-2 col-sm-12 px-0">
	<!-- <h3 class="card-header">시설조회 : <label class="small">해당 시설의 정보를 확인하는 페이지입니다.<label></h3> -->
	<div class="card-body text-left ">
		<div class="">
			<div class="text-right">
				<input type="button" class="btn-sm btn-primary mb-2" value="목록으로" onclick="location.href = '${pageContext.request.contextPath }/fsurpport/fmanageList'">
			</div>
			<div class="row table-responsive" id="info">

				<form action="${pageContext.request.contextPath }/fsurpport/fmanageUpdatePage" method="post" id="updateform">
					<input type="hidden" name="manage_no" value="${fmanage.manage_no}">
				</form>
				<table class="table table-bordered  col-sx-12" style="text-align: center;" id="tb">
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
				</table>
			</div>
			<form style="display: none;">
				<select>
					<option>ok</option>
				</select>
			</form>
		</div>
	</div>
	<div class="col-sm-12  text-right mb-2">
		<div class="text-right ">
			<button type="button" class="btn-sm btn-info  col-md-2 my-1" id="formbtn">장비변경</button>
			<button type="button" class="btn-sm btn-warning  col-md-1 my-1" id="updatebtn">수정</button>
			<button type="button" class="btn-sm btn-danger  col-md-1 my-1 " onclick="location.href = '${pageContext.request.contextPath }/fsurpport/fmanageDelete?manage_no=${fmanage.manage_no}&msr_code=${fmanage.use_yn}'">삭제</button>
		</div>


		<form action="${pageContext.request.contextPath }/fsurpport/msrequipChange" method="post">
			<select id="chform" name="msr_code" style="display: none;">
				<option>장비없음</option>
				<c:forEach items="${okList}" var="ok">
					<option value="${ok.msr_code}">${ok.msr_nm}</option>
				</c:forEach>
			</select>
			<input type="hidden" name="manage_no" value="${fmanage.manage_no}" />
			<button type="submit" style="display: none;" id="save">저장</button>
		</form>
	</div>
</div>
