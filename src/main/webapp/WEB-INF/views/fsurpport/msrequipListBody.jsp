<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
$(function(){
	
	if(${check} != null){
		alert(${check});
	}
	
});
</script>

<!-- 20210302_KJH 등록한 시설 리스트 -->
<h3 class="mt-4">시설관리</h3>
<div class="card mt-2 px-0">
	<h3 class="card-header">총게시글 :</h3>
	<div class="card-body text-left p-1">
		<div class="mt-2 col-sm-2 px-0 float-right">
			<a href="${pageContext.request.contextPath}/fsurpport/fmanageInsertPage" class="btn btn-primary p-2 float-right">장비등록</a>
		</div>
		<br> <br> <br>
		<div class="table-responsive small p-1">

			<table class="table table-bordered text-center">
				<tr>
					<th class="p-0 m-auto table-active">장비코드</th>
					<th class="p-0 m-auto table-active">장비명</th>
					<th class="p-0 m-auto table-active">사용자</th>
					<th class="p-0 m-auto table-active">수정버튼</th>
				</tr>

				<c:forEach items="${msrList}" var="msr">
					<form action="${pageContext.request.contextPath}/fsurpport/msrUpdate" method="get">

						<c:if test="${S_USER.user_id ne 'admin'}">
							<input type="hidden" name="msr_code" value="${msr.msr_code}" />
							<input type="hidden" name="owner" value="${S_USER.user_id}" />
							<tr>

								<td class="p-1">${msr.msr_code}</td>
								<td class="p-1 "><input type="text" name="msr_nm" value="${msr.msr_nm}" class="col-12"></td>
								<td class="p-1 ">${msr.owner}</td>
								<td class="p-1 "><input type="submit" value="저장"></td>
							</tr>
						</c:if>
						<c:if test="${S_USER.user_id eq 'admin'}">
							<input type="hidden" name="msr_code" value="${msr.msr_code}" />
							<tr>

								<td class="">${msr.msr_code}</td>
								<td class=""><input type="text" name="msr_nm" value="${msr.msr_nm}"></td>
								<td class=""><input type="text" name="owner" value="${msr.owner}"></td>
								<td class=""><input type="submit" value="저장"></td>
							</tr>
						</c:if>
					</form>
				</c:forEach>
 
				<form action="${pageContext.request.contextPath}/fsurpport/msrSet" method="get">
					<tr class="table-active">
						<th class="p-1">등록할 신규 장비 코드:</th>
						<td class="p-1" colspan="2"><input type="text" name="msr_code" class="col-12" /></td>
						<td class="p-1"><input type="submit" value="신규 장비등록" /></td>
					</tr>
				</form>
			</table>
			<lable class="text-danger">${check}</lable>
		</div>
		<div class="mt-2 col-sm-2 px-0 float-right">
			<a href="${pageContext.request.contextPath}/fsurpport/fmanageInsertPage" class="btn btn-primary p-2 float-right">장비등록</a>
		</div>
	</div>
</div>
