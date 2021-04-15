<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>

	$(document).ready(function() {

		// picture input의 파일 변경시 이벤트 
		$("#picture").change(function() {
			readURL(this);
		});
		
		/* 20210326_ggy : 첨부파일 삭제 */
		$(document).on('click', '#file_nmDeleteBtn1', function() {
			
			
			$('#file_nm1').removeAttr('value');
		});
		
	});

</script>

<h3 class="mt-4">주간 농사정보 수정</h3>

<form action="${pageContext.request.contextPath}/finfo/modifyWeeklyFarmInfos" method="post" enctype="multipart/form-data">
	
	<input type="text" name="writer" value="${weeklyFarmInfosInfo.writer }" readonly="readonly">
	<input type="text" name="w_info_no" value="${weeklyFarmInfosInfo.w_info_no }" readonly="readonly">
	
		
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">제목</label> 
		<input type="text" name="title" value="${weeklyFarmInfosInfo.title }" class="form-control py-4" required="required">
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">첨부파일</label>
		
		<input type="text" id="file_nm1" name="file_nm1" value="${weeklyFarmInfosInfo.file_nm }" readonly="readonly">
		<input type="text" name="file_no_check1" value="${weeklyFarmInfosInfo.file_no }" readonly="readonly">
		<input type="button" id="file_nmDeleteBtn1" value="삭제">
	</div>
	
	
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">파일 등록</label>

		<div class="mailbox-attachments clearfix" >

			<div class="mailbox-attachment-info">
				<div class="">
					<input id="picture" class="form" type="file" name="file_file1" accept="*.*" style="height: 37px;" />
				</div>
			</div>
		</div>

	</div>


	<div class="float-right">
		<input type="submit" value="수정"  class="btn btn-primary">
		<input type="button" value="목록으로" class="btn btn-primary" 
		onclick="location.href='${pageContext.request.contextPath }/finfo/weeklyFarmInfosView'" >
	</div>
</form>
