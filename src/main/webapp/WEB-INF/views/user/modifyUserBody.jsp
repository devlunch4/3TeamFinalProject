<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(function() {
		
		$("#addrBtn").on("click", function() {
			new daum.Postcode({
				oncomplete : function(data) {
					$("#addr1").val(data.roadAddress);  
					$("#zip").val(data.zonecode);  
					$("#addr2").focus();  
				}
			}).open();
		})
		
		
		
		
		
		
		
		
		
		
	})
</script>

<main>
	<div class="card-header">
		<h3 class="text-center font-weight-light my-4">내 정보수정</h3>
	</div>
	<div class="card-body">
		<form>
			<div class="form-group">
				<label class="small mb-1" for="user_nm">이름</label> <input readonly="readonly" class="form-control py-4" id="user_nm" type="text" value="${S_USER.user_nm }" />
			</div>
			<div class="form-group">
				<label class="small mb-1" for="user_id">아이디</label> <input class="form-control py-4" id="user_id" type="text" value="${S_USER.user_id }" />
			</div>
			<div class="form-group">
				<label class="small mb-1" for="user_pw">비밀번호</label> <input class="form-control py-4" id="user_pw" type="text" value="${S_USER.user_pw }" />
			</div>
			<div class="form-group">
				<label class="small mb-1" for="confirm_user_pw">비밀번호 확인</label> <input class="form-control py-4" id="confirm_user_pw" type="text" />
			</div>
			<div class="form-row">
				<div class="col-md-8">
					<div class="form-group">
						<label class="small mb-1" for="email">이메일</label> <input class="form-control py-4" id="email" type="email" aria-describedby="이메일" value="${S_USER.email }" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label class="small mb-1 display-none-767">&nbsp;</label> <input class="btn btn-primary2 btn-block f-py-3" type="button" value="인증하기" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<input class="form-control py-4" id="confirm_email" type="email" aria-describedby="이메일" placeholder="해당 이메일로 받은 인증번호를 입력하세요." />
			</div>


			<div class="form-row">
				<div class="col-md-8">
					<div class="form-group">
						<label class="small mb-1" for="mobile">핸드폰번호</label> <input class="form-control py-4" id="mobile" type="text" aria-describedby="전화번호" value="${S_USER.mobile }" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label class="small mb-1 display-none-767">&nbsp;</label> <input class="btn btn-primary2 btn-block f-py-3" type="button" value="인증하기" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<input class="form-control py-4" id="confirm_mobile" type="text" aria-describedby="핸드폰번호 인증" placeholder="해당 핸드폰번호로 받은 인증번호를 입력하세요." />
			</div>


			<div class="form-group">
				<label class="small mb-1" for="addr1">주소</label> <input class="form-control py-4" id="addr1" type="text" aria-describedby="주소" value="${S_USER.addr1 }" readonly />
			</div>
			<div class="form-group">
				<input class="form-control py-4" id="addr2" type="text" value="${S_USER.addr2 }" />
			</div>

			<div class="form-row">
				<div class="col-md-8">
					<div class="form-group">
						<input class="form-control py-4" id="zip" type="text" value="${S_USER.zip }" readonly />
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<button type="button" class="btn btn-primary2 btn-block f-py-3" id="addrBtn">주소검색하기</button>
					</div>
				</div>
			</div>
			<div class="form-group mt-4 mb-0">
				<a class="btn btn-primary btn-block" href="login.html">정보 수정하기</a>
			</div>
		</form>
	</div>

</main>

