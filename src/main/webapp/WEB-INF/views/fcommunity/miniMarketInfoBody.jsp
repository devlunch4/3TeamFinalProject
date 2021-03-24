<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">미니장터 게시글 조회</h3>


	<div class="form-group">
		<label class="small mb-1" for="input_cls_code">제목</label>
		<p class="form-control py-4">${miniMarketInfo.title }</p>
	</div>

	<div class="form-group">
		<label class="small mb-1" for="input_cls_code">머릿말</label>
		<p class="form-control py-4">${miniMarketInfo.head_code_nm }</p>
	</div>

	<div class="form-group">
		<label class="small mb-1" for="input_cls_code">등록일</label>
		<p class="form-control py-4">
			<fmt:formatDate value="${miniMarketInfo.reg_dt }" pattern="yyyy.MM.dd" />
		</p>
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_grdgd_nm">품목</label>
		<input class="form-control py-4" id="input_grdgd_nm" name="" type="text" value="${miniMarketInfo.item_code_nm }" required="required" readonly="readonly">
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_difficulty">조회수</label>
		<input class="form-control py-4" id="input_difficulty" name="" type="text" value="${miniMarketInfo.hit }" required="required" readonly="readonly">
	</div>
	<div class="form-group ">
		<label class="small mb-1" for="input_plant_prd">작업내용</label> <br>
		<div name="content">${miniMarketInfo.content }</div>
	</div>

	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">가격</label><br>
		<fmt:formatNumber value="${miniMarketInfo.price }" pattern="#,###" />
	</div>
	<div class="form-group">
		<label class="small mb-1" for="input_plant_prd">썸네일</label><br> 
		<img src="${pageContext.request.contextPath}/fcommunity/filePath?file_nm=${miniMarketInfo.thumbnail_file_nm }">
	</div>

	<div class="form-group">
		<c:if test="${marketFileList != null }">
			<c:forEach items="${marketFileList }" var="marketFileList">
				<input type="text" value="${marketFileList.file_nm }" readonly="readonly">
				<br>
			</c:forEach>
		</c:if>
	</div>

<div class="form-group">
	<div class="row">
		<form action="${pageContext.request.contextPath }/fcommunity/registMarketReply" method="post">
			<textarea name="content" rows="2" cols="42" class="text-left"></textarea>
			<input type="hidden" name="writer" value="${S_USER.user_id }" >
			<input type="hidden" name="market_no" value="${miniMarketInfo.market_no }" >
			<input type="submit" value="댓글 등록">
		</form>
		<label class="small mb-1" for="input_plant_prd">댓글</label><br>
		<c:forEach items="${marketReplyList }" var="marketReplyList">
			<div>
				${marketReplyList.content }
			</div>
			<input type="text" value="${marketReplyList.content }" readonly="readonly">
			<input type="text" value="${marketReplyList.writer }" readonly="readonly">
			<fmt:formatDate value="${marketReplyList.reg_dt }" pattern="yyyy.MM.dd" />
		</c:forEach>

		<c:choose>

			<c:when test="${S_USER.user_id == miniMarketInfo.writer }">
				<form action="${pageContext.request.contextPath }/fcommunity/modifyMiniMarketView" method="post" class="text-right">
					<input type="hidden" name="writer" value="${S_USER.user_id }" readonly="readonly">
					<input type="hidden" name="market_no" value="${miniMarketInfo.market_no }" readonly="readonly">
					<input type="submit" value="댓글수정" class="btn btn-warning  m-1">
				</form>

				<form action="${pageContext.request.contextPath }/fcommunity/deleteMiniMarketPost" method="post" class="text-right">
					<input type="hidden" name="writer" value="${S_USER.user_id }" readonly="readonly">
					<input type="hidden" name="market_no" value="${miniMarketInfo.market_no }" readonly="readonly">
					<input type="submit" value="댓글삭제" onclick="alert('삭제합니다.');" class="btn btn-danger  m-1">
				</form>
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>

	</div>
</div>



<div class="form-group">
	<div class="row float-right">

		<c:choose>
			<c:when test="${S_USER.user_id == miniMarketInfo.writer }">
				<%-- 				<a class="btn btn-primary" href="${pageContext.request.contextPath }/fcommunity/modifyMiniMarketView?writer=${S_USER.user_id }&market_no=${miniMarketInfo.market_no }">수정</a> --%>
				<form action="${pageContext.request.contextPath }/fcommunity/modifyMiniMarketView" method="post" class="text-right">
					<input type="hidden" name="writer" value="${S_USER.user_id }" readonly="readonly">
					<input type="hidden" name="market_no" value="${miniMarketInfo.market_no }" readonly="readonly">
					<input type="submit" value="수정" class="btn btn-warning  m-1">
				</form>

				<%-- 				<a class="btn btn-primary" href="${pageContext.request.contextPath }/fcommunity/deleteMiniMarketPost?writer=${S_USER.user_id }&market_no=${miniMarketInfo.market_no }" --%>
				<!-- 					onclick="alert('삭제합니다.');">삭제</a> -->
				<form action="${pageContext.request.contextPath }/fcommunity/deleteMiniMarketPost" method="post" class="text-right">
					<input type="hidden" name="writer" value="${S_USER.user_id }" readonly="readonly">
					<input type="hidden" name="market_no" value="${miniMarketInfo.market_no }" readonly="readonly">
					<input type="submit" value="삭제" onclick="alert('삭제합니다.');" class="btn btn-danger  m-1">
				</form>
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
		<input class="btn btn-primary m-1" type="button" value="취소" onClick="history.go(-1)">
		<button type="button" class="btn btn-primary m-1" onclick="location.href='${pageContext.request.contextPath }/fcommunity/miniMarketView'">목록이동</button>


	</div>
</div>


