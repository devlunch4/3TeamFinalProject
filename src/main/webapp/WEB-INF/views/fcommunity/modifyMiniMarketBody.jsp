<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">미니장터 게시글 수정페이지</h3>

<script>
	$(document).ready(function() {
		// picture input의 파일 변경시 이벤트 
		$("#picture").change(function() {
			readURL(this);
		});
		
		/* 20210322_ggy : 첨부파일 삭제 */
		$(document).on('click', '#file_nmDeleteBtn1', function() {
			
			
			$('#file_nm1').removeAttr('value');
			
		})
		
		// 첨부파일2 삭제
		$(document).on('click', '#file_nmDeleteBtn2', function() {
			
			
			$('#file_nm2').removeAttr('value');
			
		})
		
		// 첨부파일 3 삭제
		$(document).on('click', '#file_nmDeleteBtn3', function() {
			
			
			$('#file_nm3').removeAttr('value');
			
		})
		
		// 썸네일 파일 삭제
		$(document).on('click', '#thumbnail_file_check_deleteBtn', function() {
			
			
			$('#thumbnail_file_check').removeAttr('value');
			
		})
		
	});
	
// 	$(function(){
		
// 	});
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

<form action="${pageContext.request.contextPath}/fcommunity/modifyMiniMarket" method="post" enctype="multipart/form-data">
	
	<input type="text" name="market_no" value="${miniMarketInfo.market_no }" readonly="readonly" >
	
	<div class="form-group">
		<label class="small mb-1" for="input_cls_code">제목</label>
		<input type="text" name="title" value="${miniMarketInfo.title }" required="required" >
	</div>
	
	<div class="form-group col-md-2">
		<label class="small mb-1" for="input_cls_code">머릿말:</label>
		<select name="head_code" required="required" >
			<option value="" disabled="disabled">선택</option>
			<c:forEach items="${miniMarketList }" var="miniMarketList">
				<option value="${miniMarketList.code_no }"
				
				<c:if test="${miniMarketList.code_nm == miniMarketInfo.item_code_nm}">selected</c:if>
				
				>${miniMarketList.code_nm }
				</option>
			</c:forEach>
		</select>
		
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_cls_code">작성자</label>
		<input type="text" name="writer" value="${miniMarketInfo.writer }" readonly="readonly" >
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_cls_code">머릿말</label>
		<input type="text" name="head_code_nm" value="${miniMarketInfo.head_code_nm }" required="required" >
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_cls_code">등록일</label>
		<p class="form-control py-4"><fmt:formatDate value="${miniMarketInfo.reg_dt }" pattern="yyyy.MM.dd" /></p>
	</div>
	
<!-- 	<div class="form-group"> -->
<!-- 		<label class="small mb-1" for="input_grdgd_nm">품목</label> -->
		
<!-- 		<input class="form-control py-4" id="input_grdgd_nm"  -->
<%-- 		name="" type="text" value="${miniMarketInfo.item_code_nm }"  --%>
<!-- 		required="required" readonly="readonly"> -->
		
<!-- 	</div> -->

	
	<div class="form-group col-md-2">
		<label class="small mb-1" for="input_cls_code">품목:</label>
		<select name="item_code" required="required" >
			<option value="" disabled="disabled">선택</option>
			<c:forEach items="${itemList }" var="itemList">
				<option value="${itemList.code_no }"
				<c:if test="${itemList.code_nm == miniMarketInfo.item_code_nm}">selected</c:if>
				>${itemList.code_nm }
				</option>
			</c:forEach>
		</select>
		
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_difficulty">조회수</label>
		<input class="form-control py-4" id="input_difficulty" name="" type="text" value="${miniMarketInfo.hit }" required="required" readonly="readonly">
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_difficulty">전화번호</label>
		<input class="form-control py-4" name="mobile" type="text" value="${miniMarketInfo.mobile }" required="required" >
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">작업내용</label> <br>

		<!-- 글쓰기 summernote-->
		<textarea id="summernote" name="content">
			${miniMarketInfo.content }
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
		          ['insert', ['link', 'picture', 'video']],
		          ['view', ['fullscreen', 'codeview', 'help']]
		        ]
	   	   });
    	</script>

	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">가격</label><br> 
		<input type="number" name="price" value="${miniMarketInfo.price }"
		required="required">
	</div>
	
	
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">썸네일</label><br> 
		
		<div class="mailbox-attachments clearfix" style="text-align: center; width: 100%;">
			<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;">
				<img id="pictureViewImg" style="width: 100%; height: 100%;" 
				src="${pageContext.request.contextPath}/fcommunity/filePath?file_nm=${miniMarketInfo.thumbnail_file_nm }"/>
			</div>

			<div class="mailbox-attachment-info">
				<div class="">
					<input id="picture" class="form" type="file" name="thumbnail_file" accept=".gif, .jpg, .png" style="height: 37px;" />
					<br>
					<p>썸네일 파일 확인</p>
					<input type="text" id="thumbnail_file_check" name="thumbnail_file_check" value="${miniMarketInfo.thumbnail_file_nm }" readonly="readonly">
					<input type="button" id="thumbnail_file_check_deleteBtn" value="썸네일 삭제">
				</div>
			</div>
		</div>
		
	</div>
	
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">첨부 파일목록:</label><br>
		
		<c:forEach var="marketFileList" items="${marketFileList }" begin="0" end="3" step="1" varStatus="i">
			<c:choose>
				<c:when test="${marketFileList.file_nm != null && !marketFileList.file_nm.equals('')  }">
					<input type="text" name="file_nm${i.count }" id="file_nm${i.count }" value="${marketFileList.file_nm }" readonly="readonly">
					<input type="text" name="file_no_check${i.count }" id="file_nm${i.count }" value="${marketFileList.file_no }" readonly="readonly">
					<button type="button" id="file_nmDeleteBtn${i.count }">삭제</button>
					<br>
				</c:when>
				<c:otherwise>
						<input type="text" name="file_nm${i.count }" value="" readonly="readonly">
					<input type="text" name="file_no_check${i.count }" id="file_nm${i.count }" value="" readonly="readonly">
						<br>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
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
		
		<input class="btn btn-primary" type="submit" value="수정완료" >
		<input class="btn btn-primary" type="button" value="취소" onClick="history.go(-1)">
	</div>
</form>

© 2021 GitHub, Inc.
Terms
Privacy
Security
Status
Docs
Contact GitHub
Pricing
API
Training
Blog
About
