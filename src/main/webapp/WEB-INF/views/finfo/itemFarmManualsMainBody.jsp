<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">품목별 영농 메뉴얼</h3>


<div class="card mt-2 col-sm-12">
	<div class="col-xs-12 col-md-12 card-body text-left p-1">
		<span class="">품목</span> <br>
		
			<c:forEach items="${itemClassList }" var="itemClassList">
					
				<c:choose>
					<c:when test="${itemClassList.code_no eq selectItemCode_ode_no }">
							
						<button class="btn btn-primary" 
						onclick="location.href='${pageContext.request.contextPath}/finfo/itemManualsList?code_no=${itemClassList.code_no }'"
						>${itemClassList.code_nm }</button>
					</c:when>
					
					<c:otherwise>
						<button class="btn btn" onclick="location.href='${pageContext.request.contextPath}/finfo/itemManualsList?code_no=${itemClassList.code_no }'"
						>${itemClassList.code_nm }</button>
						
					</c:otherwise>
				</c:choose>
					
			</c:forEach>
		
		
			
	</div>
</div>

<div class="card mt-2 col-sm-12">
	<div class="card-body text-left p-1">
		<span class="">품목</span> <br> <br>결과33 <br>

		<div class="col-xs-12 col-md-12 col-sm-12 text-left">
		
			<c:forEach items="${itemList }" var="itemList">
				<c:forEach items="${selectItemmanualFilenmList }" var="selectItemmanualFilenmList">

					<c:choose>
						<c:when test="${selectItemmanualFilenmList.item_code eq itemList.code_no}">
							<button onclick="location.href='${pageContext.request.contextPath}/finfo/filePath?file_nm=${selectItemmanualFilenmList.file_nm }'" class="col-xs-3">${itemList.code_nm }</button>
							<c:if test="${S_USER.user_id.equals('admin') }">
								<button 
								onclick="location.href='${pageContext.request.contextPath}/finfo/modifyItemMenualView?manual_code=${selectItemmanualFilenmList.manual_code }'" 
								class="col-xs-3">수정</button>
								<button 
								onclick="location.href='${pageContext.request.contextPath}/finfo/deleteItemMenualInfo?manual_code=${selectItemmanualFilenmList.manual_code }&writer=${selectItemmanualFilenmList.writer }'" 
								class="col-xs-3">삭제</button>
							</c:if>
						</c:when>

						<c:otherwise>
						</c:otherwise>

					</c:choose>

				</c:forEach>
			</c:forEach>
			
		</div>




	</div>
</div>
<c:if test="${S_USER.user_id.equals('admin') }">
	<button 
		onclick="location.href='${pageContext.request.contextPath}/finfo/registItemMenualView?user_id=${S_USER.user_id }'"
		class="float-right btn btn-primary">등록</button>
	</c:if>
