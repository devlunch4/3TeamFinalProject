<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="layoutAuthentication">
	<div id="layoutAuthentication_content">
		<main>
			<div class="row justify-content-center">
				<div class="card-header">
					<h3 class="text-center font-weight-light my-4">본인인증</h3>
				</div>
				<div class="card-body">
					<form action="${pageContext.request.contextPath}/user/userCheck2" method="post">
						<div class="form-group"></div>
						<div class="form-group">
							<label class="small mb-1" for="user_pw">비밀번호</label>
							 <input class="form-control py-4" id="user_pw" name="input_pass" type="password" placeholder="비밀번호를 입력하세요."  />
						</div>
						<div class="form-group"></div>
						<div class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
							<button class="btn btn-primary" type="submit">인증</button>
						</div>
					</form>
				</div>
			</div>
		</main>
	</div>

</div>