<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">품목별 영농 메뉴얼</h3>

<c:if test="${S_USER.user_id.equals('admin') }">
	<button type="button" class=" btn btn-success " 
	onclick="location.href='#'" class=" btn btn-outline-dark m-1">간편 등록</button>
</c:if>

<div class="card mt-2 col-sm-12">
	<div class="card-body text-left p-1">
		<span class="">품목</span> <br>
		<%-- 		<c:forEach items="${farmdiaryList }" var="farmdiaryList"> --%>
			
			<c:choose>
				<c:when test="">
					<button type="button" onclick="location.href='#'" 
					class=" btn btn-primary m-1">ㄱ</button>
				</c:when>
				
				<c:otherwise>
					<button type="button" onclick="location.href='#'" 
					class=" btn btn-outline-dark m-1">ㄱ</button>
				</c:otherwise>
			</c:choose>
			
		<%-- 		</c:forEach> --%>
	</div>
</div>

<div class="card mt-2 col-sm-12">
	<div class="card-body text-left p-1">
		<span class="">품목</span> <br>
		<c:forEach items="${itemList }" var="itemList">
			<ul>
				<li>${itemList.code_nm }
				<li>test<input onclick="location.href='#'" type="button" value="다운로드"></li>
			</ul>
		</c:forEach>
	</div>
</div>
