<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>
	$(document).ready(function() {

		// picture input의 파일 변경시 이벤트 
		$("#picture").change(function() {
			readURL(this);
		});
	});

</script>

<h3 class="mt-4">주간 농사정보 등록</h3>

<form action="${pageContext.request.contextPath}/finfo/registWeeklyFarmInfos" method="post" enctype="multipart/form-data">
	
	<input type="text" name="writer" value="${S_USER.user_id }" required="required">
	
		
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">제목</label> 
		<input type="text" name="title" value="" class="form-control py-4" required="required">
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
		<input type="submit" value="등록"  class="btn btn-primary">
		<input type="button" value="목록으로" class="btn btn-primary" 
		onclick="location.href='${pageContext.request.contextPath }/finfo/weeklyFarmInfosView'" >
	</div>
</form>
