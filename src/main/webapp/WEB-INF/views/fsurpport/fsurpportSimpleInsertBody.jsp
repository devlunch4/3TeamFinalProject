<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<main>
	<div class="container-fluid">
		<h3 class="mt-4">간편등록</h3>
<!-- 		<button type="button" class=" btn btn-success "  -->
<%-- 		onclick="location.href='${pageContext.request.contextPath}/finfo/gardenguidesInsert'"  --%>
<!-- 		class=" btn btn-outline-dark m-1">텃밭가이드 등록</button> -->

		<button type="button" class=" btn btn-success " onclick="location.href='#'" 
			class=" btn btn-outline-dark m-1">간편 등록</button>
			
		<div class="row">
			<div class="card mt-2 col-sm-12">
				<div class="card-body text-left p-1">
					<span class="">품목</span> <br>
					<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㄱ</button>
					<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㄴ</button>
					<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㄷ</button>
					<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㄹ</button>
					<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㅁ</button>
					<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㅂ</button>
					<button type="button" onclick="#" class=" btn btn-primary m-1">ㅅ</button>
					<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㅇ</button>
					<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㅈ</button>
					<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㅊ</button>
					<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㅋ</button>
					<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㅌ</button>
					<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㅍ</button>
					<button type="button" onclick="#" class=" btn btn-outline-dark m-1">ㅎ</button>
					<button type="button" onclick="#" class=" btn btn-outline-dark m-1">기타</button>
				</div>
				<div class="card-body text-left p-1">
					<span class="">품명</span> <br>
					<button type="button" onclick="#" class=" btn btn-outline-dark m-1">아스파라거스</button>
					<button type="button" onclick="#" class=" btn btn-outline-dark m-1">양배추</button>
					<button type="button" onclick="#" class=" btn btn-primary m-1">양상추</button>
					<button type="button" onclick="#" class=" btn btn-outline-dark m-1">양파</button>
					<button type="button" onclick="#" class=" btn btn-outline-dark m-1">오이</button>
					<button type="button" onclick="#" class=" btn btn-outline-dark m-1">옥수수</button>
				</div>
			
			
				<div class="form-group col-md-6" >
					<label class="small mb-6" for="input_grdgd_nm">품목</label>
					<select name=""  >
						<option value=""  >선택</option>
					</select> 
				</div>
				
				<div class="form-group col-md-6" >
					<label class="small mb-6" for="input_grdgd_nm">사업유형</label>
					<select name=""  >
						<option value=""  >선택</option>
					</select> 
				</div>
				
				<div class="form-group">
					<label class="small mb-1" for="input_plant_prd">면적(m2)</label>
					<input id="input_cls_code" name="input_cls_code" name="" 
						type="text" class="form-control py-4" >
				</div>
			
			</div>

		</div>
	</div>
</main>
<footer class="py-4 bg-light mt-auto">
	<div class="container-fluid">
		<div class="d-flex align-items-center justify-content-between small">
			<div class="text-muted">Copyright &copy; Your Website 2020</div>
			<div>
				<a href="#">Privacy Policy</a>
				&middot;
				<a href="#">Terms &amp; Conditions</a>
			</div>
		</div>
	</div>
</footer>