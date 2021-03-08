<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<!-- 20210227 LYS - 회원가입 jsp -->

<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        
        <title>똑똑한 농부들 회원가입 페이지</title>
        
        <link href="${pageContext.request.contextPath}/resources/src/css/styles.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/src/css/f_styles.css" rel="stylesheet" />
        <script src="${pageContext.request.contextPath}/resources/src/js/all.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/src/js/regex.js"></script>
        <script	src="${pageContext.request.contextPath}/resources/summernote/jquery-3.5.1.min.js"></script>
        <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
        <script type="text/javascript">
	    	
        
        
        
        $(function(){
	    		
        		//전역변수
	    		verify_cnt = 0;
	    		code="";

	    		
	    		//이름 입력
	    		$("#user_nm").keyup(function(){
					// 정규식체크 regex.js 에 있는 함수
	    			if(!user_nm_check()){
	    				return false;
	    			}
	    		})
	    		
	    		//아이디입력
	    		$("#user_id").keyup(function(){
	    			if(!user_id_check()){
	    				return false;
	    			}
	    			
	    			user_id_value = $("#user_id").val().trim();
	    			if(user_id_value < 3 && user_id_value > 18){
	    				return true;
	    			}
	    			
	    			$.ajax({
	    				url : "${pageContext.request.contextPath}/join/id_check",
	    				type : "post",
	    				data : {
	    					"user_id" : user_id_value
	    				},
	    				success : function(res){
	    					
	    					if(res.id_status_taken){
	    						id_status_taken_from_idCheck = res.id_status_taken
			    				$(".id_status_ok").css("display", "none");
			    				$(".id_status_taken").css("display", "block");
			    				$(".id_status_taken").html(id_status_taken_from_idCheck);
	    				
	    					}else if(res.id_status_ok){
	    						id_status_ok_from_idCheck = res.id_status_ok;
	    						$(".id_status_taken").css("display", "none");
			    				$(".id_status_ok").css("display", "block");
			    				$(".id_status_ok").html(id_status_ok_from_idCheck);
	    					}
	    				},
	    				error : function(xhr){
	    					alert("상태 : " + xhr.status)
	    				},
	    				dataType : "json"
	    			})
	    			
	    		})
	    		
	    		
	    		//비밀번호 입력
	    		$("#user_pw").keyup(function(){
	    			if(!user_pw_check()){
	    				return false;
	    			}
	    		})
	    		
	    		//두번째 비밀번호 입력 확인
	    		$("#confirm_user_pw").keyup(function(){
	    			
	    			user_pw_value = $('#user_pw').val().trim();
	    			confirm_user_pw_value = $('#confirm_user_pw').val().trim();
	    			
	    			if(user_pw_value!=confirm_user_pw_value){
	    				$(".confirm_pw").html("비밀번호가 일치하지 않습니다.");
	    			}else{
	    				$(".confirm_pw").css("display", "none");
	    			}
	    		})
	    		
	    		
	    		//핸드폰 정규식 체크
	    		$("#mobile").keyup(function(){
	    			if(!mobile_check()){
	    				return false;
	    			}
	    		})
	    		
	    		
	    		
	    		//핸드폰 인증하기 버튼 눌렀을때 
	    		$("#btn_mobile").on("click", function(){
	    			
	    			mobile_value = $('#mobile').val().trim();
	    			
	    			//핸드폰번호 형식 안맞으면 인증버튼 실행 안되게
	    			if(!mobile_check()){
	    				return false;
	    			}
	    			
// 	    			$.ajax()({
// 	    				url : "${pageContext.request.contextPath}/join/mobile_verify",
// 	    				type : "post",
// 	    				data : {
// 	    					"mobile" : mobile_value
// 	    				},
// 	    				success : function(res){
	    					
// 	    				}
// 	    			})
	    			
	    			
	    		})
	    		
	    		
	    		//이메일 정규식 체크
	    		$("#email").keyup(function(){
	    			if(!email_check()){
	    				return false;
	    			}
	    		})
	    		
	    		//이메일 인증하기 버튼 눌렀을때 
	    		$("#btn_email").on("click", function(){
	    			email_value = $('#email').val().trim();
	    			
	    			//이메일 형식 안맞으면 인증버튼 실행 안되게
	    			if(!email_check()){
	    				return false;
	    			}
	    			
	    			$.ajax({
	    				url : "${pageContext.request.contextPath}/join/email_verify",
	    				type : "post",
	    				data : {
	    					"email" : email_value
	    				},
	    				success : function(res){
	    					code = res.code;
	    					$(".email_status").css("display", "block");
		    				$(".email_status").html("인증코드가 발송되었습니다. 해당 이메일을 확인해주세요.");
	    				},
	    				error : function(xhr){
	    					alert("상태 : " + xhr.status)
	    				},
	    				dataType : "json"
	    			})
	    		})
	    	
	    		
	    		//이메일 인증코드 입력시
	    		$("#confirm_email").keyup(function(){
	    			confirm_email_value = $("#confirm_email").val().trim();
	    			
	    			if(confirm_email_value > 5){
	    				return true;
	    			}
	    			
	    			if(confirm_email_value == code){
		    			$(".confirm_email_fail").css("display", "none");
		    			$(".email_status").css("display", "none");
		    			$("#btn_email").attr("disabled", true);
		    			$(".confirm_email_success").css("display", "block");
		    			$(".confirm_email_status").html("이메일 인증 확인되었습니다.");
	    			}else{
		    			$(".confirm_email_success").css("display", "none");
		    			$(".confirm_email_fail").css("display", "block");
		    			$(".confirm_email_status").html("인증번호가 맞지 않습니다. 다시 입력해주세요.");
	    			}
	    		})
	    		
	    		
	    		//주소 검색 버튼이 클릭 되었을 때 다음 주소 api 팝업을 연다.
	    		$("#addrBtn").on("click", function(){
	    		    new daum.Postcode({
	    		        oncomplete: function(data) {
	    		            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	    		            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	    		            console.log(data);
	    		            
	    		            $("#addr1").val(data.roadAddress); //주소 
	    		            $("#zip").val(data.zonecode);  //우편번호
	    		            
	    		            //사용자 편의성을 위해 상세주소 입력 input태그로 focus설정
	    		            $("#addr2").focus(); //이러면 커서가 이리로 딱 간다
	    		        }
	    		    }).open();
	    		})
	    		
	    		
	    	})
	    	
	    	
	    	
	    	
	    	
	    	$("#join_btn").on('click', function(){
	    		alert("sdsd")
	    		
	    		
	    	})
	    	
	    	
	    	
	    	
	    	
	    	
        </script>
        
        
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">회원가입</h3></div>
                                    <div class="card-body">
                                        <form id="frm" role="form" method="post" action="${pageContext.request.contextPath}/join/process">
                                            <div class="form-group">
                                                <label class="small mb-1" for="user_nm">이름</label>
                                                <input class="form-control py-4" id="user_nm" name="user_nm" type="text" placeholder="이름을 입력하세요." />
                                                <p class="status_txt name_status"></p>
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="user_id">아이디</label>
                                                <input class="form-control py-4" id="user_id" name="user_id" type="text" placeholder="아이디를 입력하세요." />
                                                <p class="status_txt id_status"></p>
                                                <p class="id_status_ok status_ok"></p>
                                                <p class="id_status_taken"></p>
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="user_pw">비밀번호</label>
                                                <input class="form-control py-4" id="user_pw" name="user_pw" type="password" placeholder="비밀번호를 입력하세요." />
                                                <p class="status_txt pw_status"></p>
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="confirm_user_pw">비밀번호 확인</label>
                                                <input class="form-control py-4" id="confirm_user_pw" name="confirm_user_pw" type="password" placeholder="비밀번호 확인" />
                                                <p class="status_txt confirm_pw"></p>
                                            </div>
                                            
                                            <div class="form-row">
                                                <div class="col-md-8">
		                                            <div class="form-group">
		                                                <label class="small mb-1" for="mobile">핸드폰번호</label>
		                                                <input class="form-control py-4" id="mobile" name="mobile" type="text" aria-describedby="전화번호" placeholder="핸드폰번호를 숫자만 입력하세요." />
		                                                <p class="status_txt mobile_status"></p>
		                                            </div>
	                                            </div>
	                                            <div class="col-md-4">
		                                            <div class="form-group">
		                                                <label class="small mb-1 display-none-767">&nbsp;</label> 
	                                                	<input class="btn btn-primary2 btn-block f-py-3" id="btn_mobile" type="button" value="인증하기" />
	                                                </div>
	                                            </div>
		                                    </div>
                                            <div class="form-group">
                                                <input class="form-control py-4" id="confirm_mobile" name="confirm_mobile" type="text" aria-describedby="핸드폰번호 인증" placeholder="해당 번호로 받은 인증번호를 입력하세요." />
                                                <p class="status_txt"></p>
                                            </div>           	
		                                                	
                                            <div class="form-row">
                                                <div class="col-md-8">
		                                            <div class="form-group">
		                                                <label class="small mb-1" for="email">이메일</label>
		                                                <input class="form-control py-4" id="email" name="email" type="email" aria-describedby="이메일" placeholder="이메일주소를 입력하세요." />
		                                           		<p class="email_status"></p>
		                                            </div>
	                                            </div>
	                                            <div class="col-md-4">
		                                            <div class="form-group">
		                                                <label class="small mb-1 display-none-767">&nbsp;</label>
		                                                <input class="btn btn-primary2 btn-block f-py-3" id="btn_email" type="button" value="이메일인증하기" />
		                                            </div>
	                                            </div>
                                            </div>
                                            <div class="form-group">
                                                <input class="form-control py-4" id="confirm_email" name="confirm_email" type="email" aria-describedby="이메일" placeholder="해당 이메일로 받은 인증번호를 입력하세요." />
                                           		<p class="confirm_email_status confirm_email_fail"></p>
                                           		<p class="confirm_email_status confirm_email_success"></p>
                                            </div>
		                                            
                                            <div class="form-group">
                                                <label class="small mb-1" for="addr1">주소</label>
                                                <input class="form-control py-4" id="addr1" name="addr1" type="text" aria-describedby="주소" placeholder="주소" readonly />
                                            </div>
                                            <div class="form-group">
                                                <input class="form-control py-4" id="addr2" name="addr2" type="text" placeholder="상세주소" />
                                            </div>
                                    
                                            <div class="form-row">
                                                <div class="col-md-8">
                                                    <div class="form-group">
                                                        <input class="form-control py-4" id="zip" name="zip" type="text" placeholder="우편번호" readonly />
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
		                                                <button type="button" class="btn btn-primary2 btn-block f-py-3" id="addrBtn">주소검색하기</button>
	                                                </div>
                                                </div>
                                            </div>
                                            <div class="form-group mt-4 mb-0">
                                            	<button type="submit" id="join_btn" class="btn btn-primary btn-block">회원가입하기</button>
                                           	</div>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center">
                                        <div class="small"><a href="${pageContext.request.contextPath}/login/view">이미 똑똑한 농부들의 회원이신가요? 로그인 후 이용하세요.</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
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
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/resources/src/js/bootstrap.bundle.min.js" ></script>
        <script src="${pageContext.request.contextPath}/resources/src/js/scripts.js"></script>
    </body>
</html>
