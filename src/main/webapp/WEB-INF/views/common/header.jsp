<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <a class="navbar-brand" href="index.html">똑똑한 농부들</a>
    <button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button>
    <!-- Navbar Search-->
    <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
        <div class="input-group">
            <input class="form-control" type="text" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2" />
            <div class="input-group-append">
                <button class="btn btn-primary" type="button"><i class="fas fa-search"></i></button>
            </div>
        </div>
    </form>
    <!-- Navbar-->
    <ul class="navbar-nav ml-auto ml-md-0">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
            
            	<c:if test="${S_USER != null}">
            	<form action="myPage">
              	  <a class="dropdown-item" href="${pageContext.request.contextPath}/user/myPage">마이페이지</a>
                </form>
                <div class="dropdown-divider"></div>
                <form action="logOut">
               	  <a class="dropdown-item" href="${pageContext.request.contextPath}/login/logout">로그아웃</a>
                </form>
				</c:if>
				
				<c:if test="${S_USER == null}">
                <a class="dropdown-item" href="${pageContext.request.contextPath}/login/view">로그인</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="">회원가입</a>
				</c:if>
				
            </div>
        </li>
    </ul>
</nav>