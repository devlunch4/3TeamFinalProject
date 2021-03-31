<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">영농일지 조회</h3>

<div class="form-group">
	<label>등록일 : </label>
	<fmt:formatDate value="${farmdiaryList.reg_dt }" pattern="yyyy.MM.dd" />
	<br> <label>품목 : </label> ${farmdiaryList.item_code } <br> <label>작업단계 : </label> ${farmdiaryList.w_step_code } <br> <label class="mb-0">작업내용 : </label>
	<div class="border">${farmdiaryList.content }</div>
	<label>날씨정보 : </label> ${farmdiaryList.weather } <br> <label>최저온도 : </label> ${farmdiaryList.low_temp } 도 <br> <label>최고온도 : </label> ${farmdiaryList.high_temp } 도<br> <label>강수량 : </label> ${farmdiaryList.rainfall } mm<br> <label>습도 : </label> ${farmdiaryList.humid } %<br> <label>수확량 : </label> ${farmdiaryList.yield } kg<br> <label>면적 : </label> ${farmdiaryList.area } m<sup>2</sup><br> <label>사진 : </label> <img src="${pageContext.request.contextPath}/fsurpport/filePath?file_nm=${farmdiaryList.file_nm }" alt="none" height="100px">
</div>
<div class="form-group ">
	<div class="row float-right">
		<c:choose>
			<c:when test="${S_USER.user_id == farmdiaryList.writer }">
				<%-- 					<a class="btn btn-warning" href="${pageContext.request.contextPath }/fsurpport/ModifyView?writer=${S_USER.user_id }&f_diary_no=${farmdiaryList.f_diary_no }&my_simple_code=${farmdiaryList.my_simple_code }">수정</a> --%>
				<form action="${pageContext.request.contextPath }/fsurpport/ModifyView" method="post">
					<input type="hidden" name="writer" value="${S_USER.user_id }">
					<input type="hidden" name="f_diary_no" value="${farmdiaryList.f_diary_no }">
					<input type="hidden" name="my_simple_code" value="${farmdiaryList.my_simple_code }">
					<input type="submit" value="수정" class="btn btn-warning  m-1">
				</form>

				<%-- 					<a class="btn btn-danger" href="${pageContext.request.contextPath }/fsurpport/deleteFarmdiary?writer=${S_USER.user_id }&f_diary_no=${farmdiaryList.f_diary_no }" onclick="alert('삭제합니다.');">삭제</a> --%>
				<form action="${pageContext.request.contextPath }/fsurpport/deleteFarmdiary" method="post">
					<input type="hidden" name="writer" value="${S_USER.user_id }">
					<input type="hidden" name="f_diary_no" value="${farmdiaryList.f_diary_no }">
					<input type="submit" value="삭제" onclick="alert('삭제합니다.');" class="btn btn-danger  m-1">
				</form>
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
		<input class="btn btn-primary m-1" type="button" value="취소" onClick="history.go(-1)">
		<button type="button" class="btn btn-primary m-1" onclick="location.href='${pageContext.request.contextPath }/fsurpport/main?user_id=${S_USER.user_id }'">목록이동</button>
	</div>
</div>
<br>
<br>
<hr>