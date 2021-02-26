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
        <title>Page Title - SB Admin</title>
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
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
                                        <form>
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputName">이름</label>
                                                        <input class="form-control py-4" id="inputName" type="text" placeholder="이름을 입력하세요." />
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputId">아이디</label>
                                                        <input class="form-control py-4" id="inputId" type="text" placeholder="아이디를 입력하세요." />
                                                    </div>
                                                </div>
                                                 <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputPassword">비밀번호</label>
                                                        <input class="form-control py-4" id="inputPassword" type="text" placeholder="비밀번호를 입력하세요." />
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputConfirmPassword">비밀번호 확인</label>
                                                        <input class="form-control py-4" id="inputConfirmPassword" type="text" placeholder="비밀번호 확인" />
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputEmailAddress">생년월일</label>
                                                <input class="form-control py-4" id="inputEmailAddress" type="email" aria-describedby="emailHelp" placeholder="" />
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputEmailAddress">이메일</label>
                                                <input class="form-control py-4" id="inputEmailAddress" type="email" aria-describedby="emailHelp" placeholder="이메일주소를 입력하세요." />
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputEmailAddress">전화번호</label>
                                                <input class="form-control py-4" id="inputEmailAddress" type="email" aria-describedby="emailHelp" placeholder="전화번호를 입력하세요." />
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputEmailAddress">주소</label>
                                                <input class="form-control py-4" id="inputEmailAddress" type="email" aria-describedby="emailHelp" placeholder="" />
                                            </div>
                                            <div class="form-group mt-4 mb-0"><a class="btn btn-primary btn-block" href="login.html">회원가입하기</a></div>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center">
                                        <div class="small"><a href="login.html">이미 똑똑한 농부들의 회원이신가요? 로그인 후 이용하세요.</a></div>
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
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
