<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">영농일지 수정</h3>

<form>
	<div class="form-group">
		<label class="small mb-1" for="input_cls_code">등록일</label>
		<input class="form-control py-4" id="input_cls_code" name="" type="text" value="" required="required">
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_grdgd_nm">품목</label>
		<input class="form-control py-4" id="input_grdgd_nm" name="" type="text" value="" required="required">
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_difficulty">작업단계</label>
		<input class="form-control py-4" id="input_difficulty" name="" type="text" value="" required="required">
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">작업내용</label> <br>
		<textarea rows="auto" cols="auto" name="" style="resize: none;" class="form-control py-4">
		</textarea>
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">날씨정보</label>
		<input class="form-control py-4" id="input_plant_prd" name="" type="text" value="" required="required">
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">사진 등록</label> <img src="">
		<input class="form-control py-4" id="input_plant_prd" name="input_plant_prd" type="text" placeholder="재배기간 입력 ex)3개월" required="required">
	</div>
	<input type="submit" value="수정 완료" class="btn btn-primary" >
</form>

