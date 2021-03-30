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


	<!-- 상단 간단 정보 및 간편 등록 입력부분 -->
	<div class="form-group row ">
		<div class="col-xs-3 mr-1">
			<div class="form-group m-0">
				<label class="small m-0" for="writer">접속자</label>
				<input class="form-control " id="writer" name="writer" type="text" readonly="readonly" value="${S_USER.user_id }">
			</div>
		</div>
		<div class="col-xs-3 mr-1">
			<div class="form-group m-0">
				<label class="small m-0" for="">간편코드 생성</label>
				<input type="button" value="간편코드생성" class="btn btn-primary form-control px-1" onclick="location.href='${pageContext.request.contextPath}/fsurpport/simpleInsertView'">
			</div>
		</div>
		<div class="col-xs-3 mr-1">
			<div class="form-group m-0">
				<label class="small m-0" for="input_cls_code">간편코드 선택</label>
				<div class="">
					<select class="form-control " name="" onchange="location.href=this.value" required="required">
						<option value="">선택</option>
						<c:forEach items="${mySimpleCodeList }" var="mySimpleCodeList">
							<option <c:if test="${selectMySimpleCodeInfo.my_simple_code eq mySimpleCodeList.my_simple_code }">selected="selected"</c:if> value="${pageContext.request.contextPath}/fsurpport/selectMySimpleCodeInfo?user_id=${S_USER.user_id }&my_simple_code=${mySimpleCodeList.my_simple_code }">${mySimpleCodeList.code_alias }</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<div class="col-xs-3 mr-1">
			<div class="form-group m-0">
				<label class="small m-0" for="my_simple_code">간편코드</label>
				<input class="form-control text-right" id="my_simple_code" name="my_simple_code" type="text" value="${selectMySimpleCodeInfo.my_simple_code }" required="required" readonly="readonly" style="width: 100px;">
			</div>
		</div>
	</div>




	<%-- 	<c:if test="${selectMySimpleCodeInfo.my_simple_code != null }">
		<label class="small mb-1" for="input_cls_code">my_simple_code코드 : </label>
		<input type="text" name="my_simple_code" value="${selectMySimpleCodeInfo.my_simple_code }" required="required">
	</c:if> --%>


	<div class="form-group row mt-2">
		<div class="col-xs-3 mr-1">
			<div class="form-group m-0">
				<label class="small m-0" for="b_type_code">사업유형</label>
				<input class="form-control " id="b_type_code" name="b_type_code" type="text" value="${selectMySimpleCodeInfo.b_type_code }" readonly="readonly" required="required">
			</div>
		</div>
		<div class="col-xs-3 mr-1">
			<div class="form-group m-0">
				<label class="small m-0" for="item_code">품목명</label>
				<input class="form-control " id="item_code" name="item_code" type="text" value="${selectMySimpleCodeInfo.item_code }" readonly="readonly" required="required">
			</div>
		</div>
		<div class="col-xs-3 mr-1">
			<div class="form-group m-0">
				<label class="small m-0" for="area">면적</label>
				<input class="form-control text-right " id="area" name="area" type="text" value="${selectMySimpleCodeInfo.area }" readonly="readonly" required="required">
			</div>
		</div>
		<div class="col-xs-3 mr-1">
			<div class="form-group m-0">
				<label class="small m-0" for="input_difficulty">작업단계</label> <select class="form-control " name="w_step_code" required="required">
					<option value="" disabled="disabled">선택</option>
					<c:forEach items="${workstepsList }" var="workstepsList">
						<option value="${workstepsList.code_no }">${workstepsList.code_nm }</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</div>

	<div class="form-group">
		<label class="small m-0" for="input_plant_prd">작업내용</label> <br>
		<!-- 글쓰기 summernote-->
		<textarea id="summernote" name="content"></textarea>
		<script>
			$('#summernote')
					.summernote(
							{
								placeholder : '작업내용을 입력하세요.',
								tabsize : 2,
								height : 120,
								toolbar : [
										[ 'style', [ 'style' ] ],
										[ 'font', [ 'bold', 'underline', 'clear' ] ],
										[ 'color', [ 'color' ] ],
										[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
										[ 'table', [ 'table' ] ],
										[ 'insert', [ 'link', 'picture', 'video' ] ],
										[ 'view', [ 'fullscreen', 'codeview', 'help' ] ] ]
							});
		</script>
	</div>

	<div class="form-group row">
		<div class="col-xs-2 mr-1">
			<label class="col-xs-1 small m-0" for="input_plant_prd">날씨정보</label> <select class="form-control col-xs-1" name="weather" required="required" style="width: 100px;">
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

		<div class="col-xs-2 mr-1">
			<label class="col-xs-1 small m-0" for="input_plant_prd">최저 온도</label>
			<input type="text" name="low_temp" value="" class="form-control col-xs-1" required="required" style="width: 100px;">
		</div>

		<div class="col-xs-2 mr-1">
			<label class="col-xs-1 small m-0" for="input_plant_prd">최고 온도</label>
			<input type="text" name="high_temp" value="" class="form-control col-xs-1" required="required" style="width: 100px;">
		</div>

		<div class="col-xs-2 mr-1">
			<label class="col-xs-1 small m-0" for="input_plant_prd">강수량</label>
			<input type="text" name="rainfall" value="" class="form-control col-xs-1" required="required" style="width: 100px;">
		</div>

		<div class="col-xs-2 mr-1">
			<label class="col-xs-1 small m-0" for="input_plant_prd">습도</label>
			<input type="text" name="humid" value="" class="form-control col-xs-1" required="required" style="width: 100px;">
		</div>

		<div class="col-xs-2 mr-1">
			<label class="col-xs-1 small m-0" for="input_plant_prd">수확량</label>
			<input type="text" name="yield" value="" class="form-control col-xs-1" required="required" style="width: 100px;">
		</div>
	</div>

	<!-- 사진부분 -->
	<div class="form-group row">
		<div class="col-xs-3 mr-1">
			<label class="small mb-1" for="input_plant_prd">사진 등록(미리보기)</label>
			<div class="mailbox-attachments clearfix text-center">
				<div class="mailbox-attachment-info">
					<div class="">
						<input id="picture" class="form" type="file" name="file_file" accept=".gif, .jpg, .png" style="height: 37px;" />
					</div>
				</div>
				<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid green; height: 100px; width: 100px; margin: 0 auto;">
					<img id="pictureViewImg" style="width: 100px; height: 100px;" />
				</div>


			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="text-right">
			<input type="submit" value="등록" class="btn btn-primary">
			<input type="button" value="목록으로" class="btn btn-dark" onclick="location.href='${pageContext.request.contextPath }/fsurpport/main?user_id=${S_USER.user_id}'">
		</div>
	</div>
</form>
