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

<h3 class="mt-4">영농일지 등록</h3>

<form action="${pageContext.request.contextPath}/fsurpport/registFarmdiary" method="post" enctype="multipart/form-data">
	
	<input type="text" name="writer" value="${S_USER.user_id }" required="required">
	
	<c:if test="${selectMySimpleCodeInfo.my_simple_code != null }">
		<label class="small mb-1" for="input_cls_code">my_simple_code코드 : </label>
		<input type="text" name="my_simple_code" value="${selectMySimpleCodeInfo.my_simple_code }" required="required">
	</c:if>
	
	<div class="form-group col-md-2">
		<label class="small mb-1" for="input_cls_code">간편 등록</label>
		<input type="button" value="간편등록" class="btn btn-primary" 
		onclick="location.href='${pageContext.request.contextPath}/fsurpport/simpleInsertView'">
		<select name="" onchange="location.href=this.value" required="required" >
			<option value=""  >선택</option>
			<c:forEach items="${mySimpleCodeList }" var="mySimpleCodeList">
				<option 
					value="${pageContext.request.contextPath}/fsurpport/selectMySimpleCodeInfo?user_id=${S_USER.user_id }&my_simple_code=${mySimpleCodeList.my_simple_code }">
					${mySimpleCodeList.code_alias }
				</option>
			</c:forEach>
		</select>
		
	</div>
	
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
		<select name="w_step_code" required="required">
			<option value="" disabled="disabled">선택</option>
			<c:forEach items="${workstepsList }" var="workstepsList" >
				<option value="${workstepsList.code_no }">${workstepsList.code_nm }</option>
			</c:forEach>
		</select>
	</div>

	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">작업내용</label> <br>

		<!-- 글쓰기 summernote-->
		<textarea id="summernote" name="content"></textarea>
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
		          ['insert', ['link', 'picture', 'video']],
		          ['view', ['fullscreen', 'codeview', 'help']]
		        ]
	   	   });
    	</script>

	</div>

	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">날씨정보</label>
		
		<select name="weather" required="required">
			<option value="" disabled="disabled">선택</option>
			<option value="맑음">맑음</option>
			<option value="구름조금">구름조금</option>
			<option value="구름많음">구름많음</option>
			<option value="흐림">흐림</option>
			<option value="비">비</option>
			<option value="눈">눈</option>
			<option value="비/눈">비/눈</option>
			<option value="흐리고_가끔_비">흐리고 가끔 비</option>
			<option value="흐리고_가끔_눈">흐리고 가끔 눈</option>
			<option value="흐리고_가끔_비/눈">흐리고 가끔 비/눈</option>
		</select>
		
	</div>
		
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">최저 온도</label> 
		<input type="text" name="low_temp" value="" class="form-control py-4" required="required">
	</div>
	
	<div class="form-group">
		<label class="small mb-1"  for="input_plant_prd">최고 온도</label> 
		<input type="text" name="high_temp" value="" class="form-control py-4" required="required">
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">강수량</label> 
		<input type="text" name="rainfall" value="" class="form-control py-4" required="required">
	</div>
	
	<div class="form-group">
		<label class="small mb-1"  for="input_plant_prd">습도</label> 
		<input type="text" name="humid" value="" class="form-control py-4" required="required">
	</div>
	
	<div class="form-group">
		<label class="small mb-1"  for="input_plant_prd">수확량</label> 
		<input type="text" name="yield" value="" class="form-control py-4"required="required">
	</div>
	
	
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">사진 등록</label>

		<div class="mailbox-attachments clearfix" style="text-align: center; width: 100%;">
			<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;">
				<img id="pictureViewImg" style="width: 100%; height: 100%;" />
			</div>

			<div class="mailbox-attachment-info">
				<div class="">
					<input id="picture" class="form" type="file" name="file_file" accept=".gif, .jpg, .png" style="height: 37px;" />
				</div>
			</div>
		</div>

	</div>



	<input type="submit" value="등록" class="btn btn-primary">
	<input type="button" value="취소" onClick="history.go(-1)">
<!-- 	<button type="button" class=" btn btn-success" style="float: rigth;" -->
<%-- onclick="location.href='${pageContext.request.contextPath }/fsurpport/main?user_id=${S_USER.user_id}'" >취소</button> --%>
</form>
