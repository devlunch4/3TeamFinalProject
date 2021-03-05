<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- <script>document.location="create"</script> -->

<script>
$(function(){
	$("#modifyBtn").on("click", function(){
		$("#frm").attr("method", "get");
		$("#frm").attr("action", "modifyUser2");
		$("#frm").submit();
	});
	
	$("#deleteBtn").on("click", function(){
		$("#frm").attr("method", "get");
		$("#frm").attr("action", "deleteUser");
		$("#frm").submit();
	});
})
</script>

<div class="container-fluid">
		<h3 class="mt-4">${user.user_nm } 님의 정보</h3>
			<form class="form-horizontal" id="frm" role="form">
<%-- 					<input type="hidden" name="user_id" value="${user.user_id} " /> --%>
					
					<div class="form-group">
						<label class="small mb-3" for="input_cls_code">아이디</label>
						<div class="col-sm-10">
							<input name="user_id" class="form-control" readonly="readonly" value="${user.user_id }" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="small mb-1" for="input_cls_code">비밀번호</label>
						<div class="col-sm-10">
							<input name="user_pw" class="form-control" value="${user.user_pw }" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="small mb-1" for="input_cls_code">이름</label>
						<div class="col-sm-10">
							<input name="user_nm" class="form-control" readonly="readonly" value="${user.user_nm }" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="small mb-1" for="input_cls_code">이메일</label>
						<div class="col-sm-10">
							<input name="email" class="form-control" readonly="readonly" value="${user.email }" />
						</div>
					</div>
	
					<div class="form-group">
						<label class="small mb-1" for="input_cls_code">전화번호</label>
						<div class="col-sm-10">
							<input name="mobile" class="form-control" readonly="readonly" value="${user.mobile }" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="small mb-1" for="input_cls_code">등록일</label>
						<div class="col-sm-10">
							<input name="" class="form-control" readonly="readonly" value="<fmt:formatDate value="${user.reg_dt }" pattern="yyyy/MM/dd"/>"></input>
						</div>
					</div>
					
					<div class="form-group">
						<label class="small mb-1" for="input_cls_code">로그인실패 횟수</label>
						<div class="col-sm-10">
							<input name="login_fail_cnt" class="form-control"  value="${user.login_fail_cnt }" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="small mb-1" for="input_cls_code">주소</label>
						<div class="col-sm-10">
							<input id="addr1"  name="addr1" class="form-control" readonly="readonly" value="${user.addr1 }" />
						</div>
						<div class="col-sm-10">
							<input id="zipcode" name="addr2" class="form-control" readonly="readonly" value="${user.addr2 }" />
						</div>
						<div class="col-sm-10">
							<input id="zipcode" name="zip" class="form-control" readonly="readonly" value="${user.zip }" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="small mb-1" for="input_cls_code">등록된 시설 갯수 </label>
						<div class="col-sm-10">
							<input  class="form-control" readonly="readonly" value="${count }" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="small mb-1" for="input_cls_code">등록된 영농일지 갯수</label>
						<div class="col-sm-10">
							<input  class="form-control" readonly="readonly" value="${ffcount }" />
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" id="deleteBtn" class="btn btn-primary">회원탈퇴 </button>
							<button type="button" id="modifyBtn" class="btn btn-primary">정보수정 </button>
						</div>
					</div>
					
				</form>
			</div>