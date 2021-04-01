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

<h3 class="mt-4">장터 게시글 등록</h3>

<form action="${pageContext.request.contextPath}/fcommunity/registMiniMarket" method="post" enctype="multipart/form-data">
	
	<input type="text" name="writer" value="${S_USER.user_id }" readonly="readonly" required="required">
	
	<div class="form-group col-md-2">
		<label class="small mb-1" for="input_cls_code">머릿말:</label>
		<select name="head_code" required="required" >
			<option value="" disabled="disabled">선택</option>
			<c:forEach items="${miniMarketList }" var="miniMarketList">
				<option value="${miniMarketList.code_no }">
					${miniMarketList.code_nm }
				</option>
			</c:forEach>
		</select>
		
	</div>
	
	<div class="form-group col-md-2">
		<label class="small mb-1" for="input_cls_code">품목:</label>
		<select name="item_code" required="required" >
			<option value="" disabled="disabled">선택</option>
			<c:forEach items="${itemList }" var="itemList">
				<option value="${itemList.code_no }">
					${itemList.code_nm }
				</option>
			</c:forEach>
		</select>
		
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">제목</label> 
		<input type="text" name="title" value="" class="form-control py-4" required="required">
	</div>

	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">게시글내용</label> <br>

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
		          ['insert', ['link', 'picture']],
		          //['insert', ['link', 'picture', 'video']],
		          //['view', ['fullscreen', 'codeview', 'help']]
		        ]
	   	   });
    	</script>

	</div>
		
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">가격</label> 
		<input type="number" name="price" value="0" min="0"  step="1" class="form-control py-4" required="required">
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">썸네일 등록</label>

		<div class="mailbox-attachments clearfix" style="text-align: center; width: 100%;">
			<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;">
				<img id="pictureViewImg" style="width: 100%; height: 100%;" />
			</div>

			<div class="mailbox-attachment-info">
				<div class="">
					<input id="picture" class="form" type="file" name="thumbnail_file" accept=".gif, .jpg, .png" style="height: 37px;" />
				</div>
			</div>
		</div>

	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">전화번호</label> 
		<input type="text" name="mobile" value="" class="form-control py-4" required="required">
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">첨부파일1</label>
		<div class="mailbox-attachment-info">
			<div class="">
				<input id="file_file1" class="form" type="file" name="file_file1" accept="*.*" style="height: 37px;" />
			</div>
		</div>
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">첨부파일2</label>
		<div class="mailbox-attachment-info">
			<div class="">
				<input id="file_file2" class="form" type="file" name="file_file2" accept="*.*" style="height: 37px;" />
			</div>
		</div>
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">첨부파일3</label>
		<div class="mailbox-attachment-info">
			<div class="">
				<input id="file_file3" class="form" type="file" name="file_file3" accept="*.*" style="height: 37px;" />
			</div>
		</div>
	</div>
	



	<div class="float-right">
		<input type="submit" value="등록"  class="btn btn-primary">
		<input type="button" value="목록으로" class="btn btn-primary" 
		onclick="location.href='${pageContext.request.contextPath }/fcommunity/miniMarketView'" >
	</div>
</form>
