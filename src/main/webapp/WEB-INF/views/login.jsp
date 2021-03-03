<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>똑똑한 농부들 로그인 페이지</title>
        <link href="${pageContext.request.contextPath}/resources/src/css/styles.css" rel="stylesheet" />
        <script src="${pageContext.request.contextPath}/resources/src/js/all.min.js"></script>
	
		<script type="text/javascript">
			
		</script>    
    
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">로그인</h3></div>
                                    <div class="card-body">
                                        <form action="${pageContext.request.contextPath}/login/process" method="post">
                                            <div class="form-group">
                                                <label class="small mb-1" for="user_id">아이디</label>
                                                <input class="form-control py-4" id="user_id" name="user_id"  placeholder="아이디를 입력하세요." />
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="user_pw">비밀번호</label>
                                                <input class="form-control py-4" id="user_pw" name="user_pw" type="password" placeholder="비밀번호를 입력하세요." />
                                            </div>
                                            <div class="form-group">
                                                <div class="custom-control custom-checkbox">
                                                    <input class="custom-control-input" id="rememberId" type="checkbox" />
                                                    <label class="custom-control-label" for="rememberId">아이디 기억하기</label>
                                                </div>
                                            </div>
                                            <div class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                                                <a class="small" href="#">아이디를 잊어버리셨나요?</a>
                                                <a class="small" href="#">비밀번호를 잊어버리셨나요?</a>
                                                <button class="btn btn-primary" type="submit">로그인</button>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center">
                                        <div class="small"><a href="${pageContext.request.contextPath}/login/register">아직 회원이 아니신가요? 똑똑한 농부들 회원 되기!</a></div>
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
        <script src="${pageContext.request.contextPath}/resources/src/js/jquery.slim.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/src/js/bootstrap.bundle.min.js" ></script>
        <script src="${pageContext.request.contextPath}/resources/src/js/scripts.js"></script>
    </body>
</html>
