<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<script type="text/javascript">
	$(function() {
		$("#btn_join").on("click", function() {

			user_nm = $("#user_nm").val().trim();
			email = $("#email").val().trim();

			$.ajax({
				url : "${pageContext.request.contextPath}/user/findId2",
				type : "post",
				data : {
					"user_nm" : user_nm,
					"email" : email
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
			<div class="container p-0">
				<div class="row ">
					<div class="col">
						<div class="card shadow-lg border-0 rounded-lg mt-5 ">
							<div class="card-header">
								<h3 class="text-center font-weight-light my-4">ID찾기</h3>
							</div>
							<div class="card-body">
								<form action="">
									<div class="form-group">
										<label class="small mb-1" for="user_nm">
											이름<span class="red_star"> </span>
										</label>
										<input class="form-control py-4" id="user_nm" name="user_nm" type="text" placeholder="이름을 입력하세요." />
									</div>

									<div class="form-row">
										<div class="col-md-8">
											<div class="form-group">
												<label class="small mb-1" for="email">
													이메일<span class="red_star"> </span>
												</label>
												<input class="form-control py-4" id="email" name="email" type="email" aria-describedby="이메일" placeholder="이메일주소를 입력하세요." />
											</div>
										</div>
									</div>

									<div class="form-group mt-4 mb-0">
										<p class="status_txt btn_join_txt"></p>
									</div>

									<div class="form-group mt-4 mb-0">
										<button type="button" id="btn_join" class="btn btn-primary btn-block">아이디 찾기</button>
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
