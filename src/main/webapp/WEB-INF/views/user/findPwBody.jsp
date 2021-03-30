<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<script type="text/javascript">
	$(function() {
		$("#btn_join").on("click", function() {

			user_id = $("#user_id").val().trim();
			user_nm = $("#user_nm").val().trim();

			$.ajax({
				url : "${pageContext.request.contextPath}/user/findPw2",
				type : "post",
				data : {
					"user_nm" : user_nm,
					"user_id" : user_id
				},
				success : function(res) {
					if (res.result) {
						$(".status_txt ").css("display", "block");
						$(".status_txt ").html(res.result);
					} else if (res.user_id) {
						$(".status_txt ").css("display", "block");
						$(".status_txt ").html(res.user_id);
					}
				},
				error : function(xhr) {
					alert("상태 : " + xhr.status)
				},
				dataType : "json"
			})
		})
	})
</script>

<div id="layoutAuthentication">
	<div id="layoutAuthentication_content">
		<main>
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-7">
						<div class="card shadow-lg border-0 rounded-lg mt-5">
							<div class="card-header">
								<h3 class="text-center font-weight-light my-4">비밀번호 찾기</h3>
							</div>
							<div class="card-body">
								<form action="">
									<div class="form-group">
										<label class="small mb-1" for="user_nm">ID<span class="red_star"> </span></label> <input class="form-control py-4" id="user_id" name="user_id" type="text" placeholder="ID를 입력해주세요." />
									</div>

									<div class="form-row">
										<div class="col-md-8">
											<div class="form-group">
												<label class="small mb-1" for="email">이름<span class="red_star"> </span></label> <input class="form-control py-4" id="user_nm" name="user_nm"  placeholder="이름을 입력해주세요." />
											</div>
										</div>
									</div>

									<div class="form-group mt-4 mb-0">
										<p class="status_txt btn_join_txt"></p>
									</div>

									<div class="form-group mt-4 mb-0">
										<button type="button" id="btn_join" class="btn btn-primary btn-block">비밀번호 찾기</button>
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
