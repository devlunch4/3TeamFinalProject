<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">품목별 영농 메뉴얼</h3>

<div class="text-right">
	<c:if test="${S_USER.user_id.equals('admin') }">
		<button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/finfo/registItemMenualView?user_id=${S_USER.user_id }'">등록</button>
	</c:if>
</div>

<div class="card-body row text-left p-1">

	<table class="table table-bordered " style="font-size: 15px;">
		<tr>
			<td class="table-active p-1 font-weight-bold">부류</td>
		</tr>
		<tr>
			<td class="p-1 small text-center"><c:forEach items="${itemClassList }" var="itemClassList">
					<c:choose>
						<c:when test="${itemClassList.code_no eq selectItemCode_ode_no }">
							<button class="btn btn-primary  p-1 " onclick="location.href='${pageContext.request.contextPath}/finfo/itemManualsList?code_no=${itemClassList.code_no }'">${itemClassList.code_nm }</button>
						</c:when>
						<c:otherwise>
							<button class="btn btn-outline-dark  p-1 " onclick="location.href='${pageContext.request.contextPath}/finfo/itemManualsList?code_no=${itemClassList.code_no }'">${itemClassList.code_nm }</button>
						</c:otherwise>
					</c:choose>
				</c:forEach></td>
		</tr>
	</table>
</div>

<div class="card-body text-left p-1">
	<table class="table table-bordered " style="font-size: 15px;">
		<tr>
			<td class="table-active p-1 font-weight-bold">품목</td>
		</tr>
		<tr>
			<td class="p-1 small"><c:forEach items="${itemList }" var="itemList">
					<c:forEach items="${selectItemmanualFilenmList }" var="selectItemmanualFilenmList">
						<c:choose>
							<c:when test="${selectItemmanualFilenmList.item_code eq itemList.code_no}">
								<button class="btn btn-primary " onclick="location.href='${pageContext.request.contextPath}/finfo/filePath?file_nm=${selectItemmanualFilenmList.file_nm }'">${itemList.code_nm }</button>
								<c:if test="${S_USER.user_id.equals('admin') }">
									<div class="mb-2">
										<button class="btn btn-warning " onclick="location.href='${pageContext.request.contextPath}/finfo/modifyItemMenualView?manual_code=${selectItemmanualFilenmList.manual_code }'">수정</button>
										<button class="btn btn-danger " onclick="location.href='${pageContext.request.contextPath}/finfo/deleteItemMenualInfo?manual_code=${selectItemmanualFilenmList.manual_code }&writer=${selectItemmanualFilenmList.writer }'">삭제</button>
									</div>
								</c:if>
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:forEach></td>
		</tr>
	</table>
</div>
