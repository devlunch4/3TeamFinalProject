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
	
	$(function(){
		/* 20210309_ggy : 첨부파일 삭제 */
		$(document).on('click', '#file_nmDeleteBtn', function() {
			
			
			$('#file_nm').removeAttr('value');
			
		})
	});
	
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#pictureViewImg').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>

<h3 class="mt-4">영농일지 수정</h3>

<form action="${pageContext.request.contextPath}/fsurpport/modifyFarmdiary" method="post" enctype="multipart/form-data">
	
	<input type="text" name="writer" value="${S_USER.user_id }" required="required">
	<input type="text" name="f_diary_no" value="${farmdiaryList.f_diary_no }" required="required">
	
	<c:if test="${selectMySimpleCodeInfo.my_simple_code != null }">
		<label class="small mb-1" for="input_cls_code">my_simple_code코드 : </label>
		<input type="text" name="my_simple_code" value="${selectMySimpleCodeInfo.my_simple_code }" required="required">
	</c:if>
	
	<div class="form-group col-md-2">
	
		<c:if test="${selectMySimpleCodeInfo.b_type_code != null }">
			<label class="small mb-1" for="input_cls_code">사업유형 : </label>
			<input type="text" name="b_type_code" value="${selectMySimpleCodeInfo.b_type_code }" readonly="readonly" required="required">
		</c:if>
		
		<c:if test="${selectMySimpleCodeInfo.item_code != null }">
			<label class="small mb-1" for="input_cls_code">품목 : </label>
			<input type="text" name="item_code" value="${selectMySimpleCodeInfo.item_code }" readonly="readonly" required="required">
		</c:if>
		
		<c:if test="${selectMySimpleCodeInfo.area != null }">
			<label class="small mb-1" for="input_cls_code">면적 : </label>
			<input type="text" name="area" value="${selectMySimpleCodeInfo.area }" readonly="readonly" required="required">
		</c:if>
	</div>

	<div class="form-group col-md-6">
		<label class="small mb-6" for="input_difficulty">작업단계</label>
		<select name="w_step_code">
			<option value="">선택</option>
			<c:forEach items="${workstepsList }" var="workstepsList" >
				<option value="${workstepsList.code_no }"
					<c:if test="${workstepsList.code_nm == farmdiaryList.w_step_code}">selected</c:if>	>${workstepsList.code_nm }</option>
			</c:forEach>
		</select>
	</div>

	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">작업내용</label> <br>

		<!-- 글쓰기 summernote-->
		<textarea id="summernote" name="content">
			${farmdiaryList.content }
		</textarea>
		<script>
	      	$('#summernote').summernote({
		        placeholder: 'Hello SUMMERNOTE',
		        tabsize: 2,
		        height: 120,
		        toolbar: [
		          ['style', ['style']],
		          ['font', ['bold', 'underline', 'clear']],
		          ['color', ['color']],
		          ['para', ['ul', 'ol', 'paragraph']],
		          ['table', ['table']],
		          ['insert', ['link', 'picture' ]],
// 		          ['insert', ['link', 'picture', 'video']],
// 		          ['view', ['fullscreen', 'codeview', 'help']]
		        ]
	   	   });
    	</script>

	</div>

	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">날씨정보</label>
		
		<select name="weather">
			<option value="">선택</option>
			<option value="맑음" <c:if test="${farmdiaryList.weather.equals('맑음')}">selected</c:if>>맑음</option>
			<option value="구름조금"  <c:if test="${farmdiaryList.weather.equals('구름조금')}">selected</c:if>>구름조금</option>
			<option value="구름많음" <c:if test="${farmdiaryList.weather.equals('구름많음')}">selected</c:if>>구름많음</option>
			<option value="흐림" <c:if test="${farmdiaryList.weather.equals('흐림')}">selected</c:if>>흐림</option>
			<option value="비" <c:if test="${farmdiaryList.weather.equals('비')}">selected</c:if>>비</option>
			<option value="눈" <c:if test="${farmdiaryList.weather.equals('눈')}">selected</c:if>>눈</option>
			<option value="비/눈" <c:if test="${farmdiaryList.weather.equals('비/눈')}">selected</c:if>>비/눈</option>
			<option value="흐리고_가끔_비" <c:if test="${farmdiaryList.weather.equals('흐리고_가끔_비')}">selected</c:if>>흐리고 가끔 비</option>
			<option value="흐리고_가끔_눈" <c:if test="${farmdiaryList.weather.equals('흐리고_가끔_눈')}">selected</c:if>>흐리고 가끔 눈</option>
			<option value="흐리고_가끔_비/눈" <c:if test="${farmdiaryList.weather.equals('흐리고_가끔_비/눈')}">selected</c:if>>흐리고 가끔 비/눈</option>
		</select>
		
	</div>
		
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">최저 온도</label> 
		<input type="text" name="low_temp" value="${farmdiaryList.low_temp }" class="form-control py-4" required="required">
	</div>
	
	<div class="form-group">
		<label class="small mb-1"  for="input_plant_prd">최고 온도</label> 
		<input type="text" name="high_temp" value="${farmdiaryList.high_temp }" class="form-control py-4" required="required">
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">강수량</label> 
		<input type="text" name="rainfall" value="${farmdiaryList.rainfall }" class="form-control py-4" required="required">
	</div>
	
	<div class="form-group">
		<label class="small mb-1"  for="input_plant_prd">습도</label> 
		<input type="text" name="humid" value="${farmdiaryList.humid }" class="form-control py-4" required="required">
	</div>
	
	<div class="form-group">
		<label class="small mb-1"  for="input_plant_prd">수확량</label> 
		<input type="text" name="yield" value="${farmdiaryList.yield }" class="form-control py-4"required="required">
	</div>
	
	
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">사진 첨부 파일</label>
		<input type="text" id="file_nm" name="file_nm" value="${farmdiaryList.file_nm }" readonly="readonly">
		<input type="button" id="file_nmDeleteBtn" value="첨부파일 삭제">
	</div>
		
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">사진 등록</label>

		<div class="mailbox-attachments clearfix" style="text-align: center; width: 100%;">
			<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;">
				<img id="pictureViewImg" style="width: 100%; height: 100%;" 
				src="${pageContext.request.contextPath}/fsurpport/filePath?file_nm=${farmdiaryList.file_nm }"/>
			</div>

			<div class="mailbox-attachment-info">
				<div class="">
					<input id="picture" class="form" type="file" name="file_file" accept=".gif, .jpg, .png" style="height: 37px;" />
				</div>
			</div>
		</div>

	</div>


	<div class="float-right">
		<input type="submit"  value="저장" class="btn btn-primary">
		<input class="btn btn-primary" type="button" value="취소" onClick="history.go(-1)">
	</div>
</form>
