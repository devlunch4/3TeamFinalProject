<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<script type="text/javascript">
	$(function() {
		$("#btn_join").on("click", function() {
			$.ajax({
				url : "${pageContext.request.contextPath}/user/findId2",
				type : "post",
				data : {
					"result" : email_value
				},
				success : function(res){
					code = res.code;
					$(".email_status_not_ok").css("display", "none");
					$(".email_status_ok").css("display", "block");
    				$(".email_status").html("인증코드가 발송되었습니다. 해당 이메일을 확인해주세요.");
				},
				error : function(xhr){
					alert("상태 : " + xhr.status)
				},
				dataType : "json"
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
								<h3 class="text-center font-weight-light my-4">ID찾기</h3>
							</div>
							<div class="card-body">
								<form id="frm" role="form" method="post" action="${pageContext.request.contextPath}/join/process">
									<div class="form-group">
										<label class="small mb-1" for="user_nm">이름<span class="red_star"> </span></label> <input class="form-control py-4" id="user_nm" name="user_nm" type="text" placeholder="이름을 입력하세요." />
										<p class="status_txt name_status"></p>
									</div>

									<div class="form-row">
										<div class="col-md-8">
											<div class="form-group">
												<label class="small mb-1" for="email">이메일<span class="red_star"> </span></label> <input class="form-control py-4" id="email" name="email" type="email" aria-describedby="이메일" placeholder="이메일주소를 입력하세요." />
												<p class="email_status email_status_ok"></p>
												<p class="email_status email_status_not_ok"></p>
											</div>
										</div>
									</div>

									<div class="form-group mt-4 mb-0">
										<button type="button" id="btn_join" class="btn btn-primary btn-block">아이디 찾기</button>
										<p class="status_txt btn_join_txt"></p>
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
