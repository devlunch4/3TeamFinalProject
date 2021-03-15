<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">품목별 영농 메뉴얼</h3>

<c:if test="${S_USER.user_id.equals('admin') }">
	<button type="button" class=" btn btn-success " 
	onclick="location.href='#'" class=" btn btn-outline-dark m-1">간편 등록</button>
</c:if>

<div class="card mt-2 col-sm-12">
	<div class="col-xs-12 col-md-12 card-body text-left p-1">
		<span class="">품목</span> <br>
		
			<c:forEach items="${itemClassList }" var="itemClassList">
				
					
					<c:choose>
						<c:when test="${itemClassList.code_no eq selectItemCode_ode_no }">
							
							<button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/finfo/itemManualsList?code_no=${itemClassList.code_no }'"
							>
							${itemClassList.code_nm }
							</button>
<%-- 					<c:if test="${itemClassList.code_no eq selectItemCode_ode_no }">selected="selected"</c:if> --%>
					</c:when>
					
					<c:otherwise>
						<button class="btn btn" onclick="location.href='${pageContext.request.contextPath}/finfo/itemManualsList?code_no=${itemClassList.code_no }'"
						>
						${itemClassList.code_nm }
						</button>
						
					</c:otherwise>
					</c:choose>
					
					
			</c:forEach>
		
		
			
	</div>
</div>

<div class="card mt-2 col-sm-12">
	<div class="card-body text-left p-1">
		<span class="">품목</span> <br>
<!-- 			<ul> -->
<!-- 				<li>test<input onclick="location.href='#'" type="button" value="다운로드"></li> -->
<!-- 			</ul> -->
				
				<br>결과22 <br>
				
				<div class="col-xs-12 col-md-12 col-sm-12 text-left" >
				<c:forEach items="${itemList }" var="itemList">
					<button class="col-xs-3">${itemList.code_nm }</button>
					
				</c:forEach>
				</div>
			
		
	
			
	</div>
</div>
