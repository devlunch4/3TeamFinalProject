<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<main>

	<script>
		$(document).ready(function(){
			
			/* 게시글 추가를 위해 추가한 코드 */
			$('#summernote').summernote();
		});
		
		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
			  
				reader.onload = function (e) {
					$('#pictureViewImg').attr('src', e.target.result);  
				}
				reader.readAsDataURL(input.files[0]);
			}
		}
		
	</script>
	
	<div class="container-fluid">
		<h3 class="mt-4">영농일지 등록</h3>
		<br>

		<form action="" method="post">
		
			<div class="form-group col-md-2">
				<label class="small mb-1" for="input_cls_code">등록일</label> 
				<input id="input_cls_code" name="input_cls_code" name="" 
					type="date" class="form-control py-4" >
			</div>
			
			<div class="form-group col-md-6" >
				<label class="small mb-6" for="input_grdgd_nm">품목</label>
				<select name=""  >
					<option value=""  >선택</option>
				</select> 
				<input name="input_grdgd_nm" type="button" value="간편 등록">
			</div>
			
			<div class="form-group col-md-6" >
				<label class="small mb-6" for="input_difficulty">작업단계</label>
				<select name="" >
					<option value="">선택</option>
				</select>
				<input name="input_grdgd_nm" type="button" value="간편 등록"> 
			</div>
			
			<div class="form-group">
				<label class="small mb-1" for="input_plant_prd">작업내용</label>
				<br>
				
				<div class="summernote">
					<textarea id="summernote" rows="13" cols="100" name="" style="resize: none;"
					class="form-control py-4" >
					</textarea> 
				</div>
			</div>
			
			<div class="form-group">
				<label class="small mb-1" for="input_plant_prd">날씨정보</label>
				<input id="input_cls_code" name="input_cls_code" name="" 
					type="date" class="form-control py-4" >
			</div>
			
			<div class="form-group">
				<label class="small mb-1" for="input_plant_prd">사진 등록</label> 
				<input id="picture" class="form-control py-4"
				type="file" name="picture" accept=".gif, .jpg, .png" style="height:37px;"/>
			</div>

				<input type="submit" value="등록" class="btn btn-primary">
		</form>


	</div>
	
</main>
<footer class="py-4 bg-light mt-auto">
	<div class="container-fluid">
		<div class="d-flex align-items-center justify-content-between small">
			<div class="text-muted">Copyright &copy; Your Website 2020</div>
			<div>
				<a href="#">Privacy Policy</a> &middot; <a href="#">Terms &amp;
					Conditions</a>
			</div>
		</div>
	</div>
</footer>