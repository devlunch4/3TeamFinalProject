<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- 	컨트롤러에서 html 태그를 쓰기 힘들어서 -->
<%
	String res_user_nm = (String) request.getAttribute("res_user_nm");
	if (res_user_nm != null) {
%>
{"sw" : "가입된 아이디 입니다."}
<%
	} else {
%>
{"sw" : "사용가능한 아이디 입니다."}
<%
	}
%>