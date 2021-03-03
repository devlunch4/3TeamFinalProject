<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- <script>document.location="create"</script> -->

<div class="container-fluid">
		<h3 class="mt-4">${user.user_nm } 님의 정보</h3>
			<form class="form-horizontal" id="frm" role="form">
					<input type="hidden" name="userid" value="${S_USER.userid }" />
					
					<div class="form-group">
						<label class="small mb-3" for="input_cls_code">아이디</label>
						<div class="col-sm-10">
							<input name="userid" class="form-control" value="${user.user_id }" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="small mb-1" for="input_cls_code">비밀번호</label>
						<div class="col-sm-10">
							<input name="userid" class="form-control" value="${user.user_pw }" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="small mb-1" for="input_cls_code">이름</label>
						<div class="col-sm-10">
							<input name="userid" class="form-control" value="${user.user_nm }" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="small mb-1" for="input_cls_code">이메일</label>
						<div class="col-sm-10">
							<input name="userid" class="form-control" value="${user.email }" />
						</div>
					</div>

					<div class="form-group">
						<label class="small mb-1" for="input_cls_code">전화번호</label>
						<div class="col-sm-10">
							<input name="userid" class="form-control" value="${user.mobile }" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="small mb-1" for="input_cls_code">등록일</label>
						<div class="col-sm-10">
							<input name="userid" class="form-control" readonly="readonly" value="<fmt:formatDate value="${user.reg_dt }" pattern="yyyy.MM.dd"/>"></input>
						</div>
					</div>
					
					<div class="form-group">
						<label class="small mb-1" for="input_cls_code">로그인실패 횟수</label>
						<div class="col-sm-10">
							<input name="userid" class="form-control" value="${user.loginfail_cnt }" />
						</div>
					</div>

					<div class="form-group">
						<label class="small mb-1" for="input_cls_code">주소</label>
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" id="addrBtn" class="btn btn-primary">주소검색</button>
						</div>
						<br>
						<div class="col-sm-10">
							<input id="addr1" class="form-control" value="${user.addr1 }" />
						</div>
						<div class="col-sm-10">
							<input id="zipcode" class="form-control" value="${user.addr2 }" />
						</div>
						<div class="col-sm-10">
							<input id="zipcode" class="form-control" value="${user.zip }" />
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" id="modifyBtn" class="btn btn-primary">회원탈퇴 </button>
							<button type="button" id="deleteBtn" class="btn btn-primary">정보수정 </button>
							<button type="button" id="deleteBtn" class="btn btn-primary">뒤로가기 </button>
						</div>
					</div>
					
				</form>
			</div>