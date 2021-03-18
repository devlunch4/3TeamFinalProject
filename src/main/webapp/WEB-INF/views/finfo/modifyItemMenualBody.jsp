<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>
	
	$(function(){
		/* 20210309_ggy : 첨부파일 삭제 */
		$(document).on('click', '#file_nmDeleteBtn', function() {
			
			
			$('#file_nm').removeAttr('value');
			
		})
	});

	$(document).ready(function() {

		// picture input의 파일 변경시 이벤트 
		$("#picture").change(function() {
			readURL(this);
		});
	});

</script>

<h3 class="mt-4">품목 메뉴얼 수정</h3>

<form action="${pageContext.request.contextPath}/finfo/modifyItemMenual" method="post" enctype="multipart/form-data">
	
	<input type="text" name="writer" value="${S_USER.user_id }" required="required">
	
	<div class="form-group">
		<input type="text" name="manual_code" value="${itemMenualInfo.manual_code }" readonly="readonly">
		<br>
		<input type="text" value="${itemMenualInfo.code_nm }" readonly="readonly">
		<br>		
		<input type="text" name="file_no" value="${itemMenualInfo.file_no }" class="form-control py-4" readonly="readonly">
	</div>
	
		
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">매뉴얼이름</label> 
		<input type="text" name="ifm_nm" value="${itemMenualInfo.ifm_nm }" class="form-control py-4" required="required">
	</div>
		
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">첨부파일:</label> 
		<input type="text" id="file_nm" name="file_nm" value="${itemMenualInfo.file_nm }" class="form-control py-4" readonly="readonly">
		<input type="button" id="file_nmDeleteBtn" value="첨부파일 삭제">
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">파일 등록</label>

		<div class="mailbox-attachments clearfix" >

			<div class="mailbox-attachment-info">
				<div class="">
					<input id="picture" class="form" type="file" name="file_file" accept="*.*" style="height: 37px;" />
				</div>
			</div>
		</div>

	</div>


	<div class="float-right">
		<input type="submit" value="등록"  class="btn btn-primary">
		<input type="button" value="목록으로" class="btn btn-primary" 
		onclick="location.href='${pageContext.request.contextPath }/finfo/itemFarmManualsView'" >
	</div>
</form>
