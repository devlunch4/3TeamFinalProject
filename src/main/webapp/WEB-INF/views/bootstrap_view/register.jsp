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
        
        <title>똑똑한 농부들 회원가입 페이지</title>
        
        <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
        <link href="${pageContext.request.contextPath}/resources/src/css/styles.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/src/css/f_styles.css" rel="stylesheet" />
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
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputUser_nm">이름</label>
                                                <input class="form-control py-4" id="inputUser_nm" type="text" placeholder="이름을 입력하세요." />
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputUser_id">아이디</label>
                                                <input class="form-control py-4" id="inputUser_id" type="text" placeholder="아이디를 입력하세요." />
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputUser_pw">비밀번호</label>
                                                <input class="form-control py-4" id="inputUser_pw" type="text" placeholder="비밀번호를 입력하세요." />
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputConfirmUser_pw">비밀번호 확인</label>
                                                <input class="form-control py-4" id="inputConfirmUser_pw" type="text" placeholder="비밀번호 확인" />
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputEmail">이메일</label>
                                                <input class="form-control py-4" id="inputEmail" type="email" aria-describedby="이메일" placeholder="이메일주소를 입력하세요." />
                                                <input class="my-2 btn btn-primary2 btn-block" type="button" value="이메일주소 인증하기" />
                                                <input class="form-control py-4" id="inputConfirmEmail" type="email" aria-describedby="이메일" placeholder="해당 이메일로 받은 인증번호를 입력하세요." />
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputMobile">핸드폰번호</label>
                                                <input class="form-control py-4" id="inputMobile" type="text" aria-describedby="전화번호" placeholder="전화번호를 입력하세요." />
                                                <input class="my-2 btn btn-primary2 btn-block" type="button" value="핸드폰번호 인증하기" />
                                                <input class="form-control py-4" id="inputConfirmMobile" type="text" aria-describedby="핸드폰번호 인증" placeholder="해당 핸드폰번호로 받은 인증번호를 입력하세요." />
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputAddr1">주소</label>
                                                <input class="form-control py-4" id="inputAddr1" type="text" aria-describedby="주소" placeholder="주소" readonly />
                                                <input class="my-2 btn btn-primary2 btn-block" type="button" value="주소검색하기" />
                                            </div>
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputAddr2">상세주소</label>
                                                        <input class="form-control py-4" id="inputAddr2" type="text" placeholder="상세주소" />
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputZip">우편번호</label>
                                                        <input class="form-control py-4" id="inputZip" type="text" placeholder="우편번호" readonly />
                                                    </div>
                                                </div>
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
        <script src="${pageContext.request.contextPath}/resources/src/js/jquery.slim.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/src/js/bootstrap.bundle.min.js" ></script>
        <script src="${pageContext.request.contextPath}/resources/src/js/scripts.js"></script>
    </body>
</html>
