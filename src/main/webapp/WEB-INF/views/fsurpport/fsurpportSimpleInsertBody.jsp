<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">간편등록</h3>


<form action="${pageContext.request.contextPath}/fsurpport/registMySimpleCode" method="post">
	<input type="text" name="owner" value="${S_USER.user_id }">
	<input type="text" name="user_id" value="${S_USER.user_id }">
	
	<div class="card mt-2 col-sm-12">
	
		<div class="form-group col-md-6">
			<label class="small mb-6" for="input_grdgd_nm">사업유형</label> 
			<select name="b_type_code">
				<option value="">선택</option>
				<c:forEach items="${b_typeList }" var="b_typeList">
					<option value="${b_typeList.code_no }">${b_typeList.code_nm }</option>
				</c:forEach>
			</select>
		</div>
	
		<div class="form-group col-md-6">
			<label class="small mb-6" for="input_grdgd_nm">품목</label> 
			<select name="item_code">
				<option value="">선택</option>
				<c:forEach items="${itemsList }" var="itemsList">
					<option value="${itemsList.code_no }">${itemsList.code_nm }</option>
				</c:forEach>
			</select>
		</div>
	
		<div class="form-group">
			<label  class="small mb-1" for="input_plant_prd">면적(m2)</label> 
			<input name="area" id="input_cls_code" type="text" class="form-control py-4" required="required">
		</div>
		
		
	</div>
	<input type="submit"  value="간편등록" class="btn btn-primary">
	<input class="btn btn-primary" type="button" value="취소" onClick="history.go(-1)">	

</form>