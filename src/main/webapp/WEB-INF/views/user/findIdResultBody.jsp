<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="layoutAuthentication">
	<div id="layoutAuthentication_content">
		<main>
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-7">
						<div class="card shadow-lg border-0 rounded-lg mt-5">
							<div class="card-header">
								<h3 class="text-center font-weight-light my-4">ID찾기</h3>
							</div>
							<div class="card-body">
								<form id="frm" role="form" method="post" action="${pageContext.request.contextPath}/user/findId2">
									<div class="form-group">
										<label class="small mb-1" for="user_nm">이름<span class="red_star"> </span></label> <input class="form-control py-4" id="user_nm" name="user_nm" type="text" value="${user_id }" />
										<p class="status_txt name_status"></p>
									</div>
								</form>
							</div>
							<div class="card-footer text-center">
								<div class="small">
									<a href="${pageContext.request.contextPath}/login/view">이미 똑똑한 농부들의 회원이신가요? 로그인 후 이용하세요.</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
	</div>

</div>
<script src="${pageContext.request.contextPath}/resources/src/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/src/js/scripts.js"></script>
