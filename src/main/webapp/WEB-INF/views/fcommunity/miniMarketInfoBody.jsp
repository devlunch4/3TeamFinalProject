<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>
	$(document).ready(
			function() {
				/* 댓글 수정 버튼 누르면 숨겨진 수정 모드 보여줌 */
				$(".modifyMarketReplyBtn").on(
						"click",
						function() {
							trid = $(this).attr('name');
							if ($("#modifyMarketReplyDiv" + trid)
									.css("display") == "none") {
								$("#modifyMarketReplyDiv" + trid).show();
								$("#modifyMarketReplyContent" + trid).hide();
							} else {
								$("#modifyMarketReplyDiv" + trid).hide();
								$("#modifyMarketReplyContent" + trid).show();
							}
						});

				/* 댓글 수정완료 버튼 누르면 숨겨진 댓글 원본 모드 보여줌 */
				$(".modifyMarketReplySubmitBtn").on(
						"click",
						function() {
							trid = $(this).attr('name');
							if ($("#modifyMarketReplyContent" + trid).css(
									"display") == "none") {
								$("#modifyMarketReplyContent" + trid).show();
								$("#modifyMarketReplyDiv" + trid).hide();
							} else {
								$("#modifyMarketReplyContent" + trid).hide();
								$("#modifyMarketReplyDiv" + trid).show();
							}
						});

				/* 취소 버튼 누르면 원본 댓글 보이고 수정모드 숭김 */
				$(".modifyMarketReplyCancleBtn").on(
						"click",
						function() {
							trid = $(this).attr('name');
							if ($("#modifyMarketReplyContent" + trid).css(
									"display") == "none") {
								$("#modifyMarketReplyContent" + trid).show();
								$("#modifyMarketReplyDiv" + trid).hide();
							} else {
								$("#modifyMarketReplyContent" + trid).hide();
								$("#modifyMarketReplyDiv" + trid).show();
							}
						});
			});
</script>
<h3 class="mt-4">똑똑한 장터 게시글 조회</h3>
<div class="form-group mb-1">
	<label class="mb-1 ">[ ${miniMarketInfo.head_code_nm } ]</label>
	<br>
	<label class="mb-1">제목 : ${miniMarketInfo.title }</label>

	<label class="mb-1 float-right">조회수 : ${miniMarketInfo.hit }</label>
	<br>
	<label class="mb-1 ">작성자 : ${miniMarketInfo.writer }</label>
	<label class="mb-1 float-right">
		등록일 :
		<fmt:formatDate value="${miniMarketInfo.reg_dt }" pattern="yyyy.MM.dd" />
	</label>

</div>
<hr>
<div class="form-group">
	<label class=" mb-1">품목 : ${miniMarketInfo.item_code_nm }</label>
	<br>
	<label class="mb-1" for="input_plant_prd">가격 : </label>
	<fmt:formatNumber value="${miniMarketInfo.price }" pattern="#,###" />
	<br>
	<label class=" mb-1" for="input_plant_prd">설명 : </label>
	<label> ${miniMarketInfo.content } </label>
</div>
<hr>
<div class="form-group">
	<label class="mb-1" for="input_plant_prd">썸네일 사진</label>
	<br> <img src="${pageContext.request.contextPath}/fcommunity/filePath?file_nm=${miniMarketInfo.thumbnail_file_nm }" width="auto;" height="100px">
</div>

<div class="form-group">
	<label class="mb-1" for="input_plant_prd">등록된 파일 목록 : </label>
	<br>
	<c:if test="${marketFileList != null }">
		<c:forEach items="${marketFileList }" var="marketFileList">
			<input type="button" value="${marketFileList.file_nm }" readonly="readonly" onclick="location.href='${pageContext.request.contextPath}/fcommunity/fileDownloadPath?file_nm=${marketFileList.file_nm }'">
			<br>
		</c:forEach>
	</c:if>
</div>
<hr>
<div class="form-group">
	<div class="row">
		<form action="${pageContext.request.contextPath }/fcommunity/registMarketReply" method="post">
			<textarea name="content" rows="2" cols="42" class="text-left"></textarea>
			<input type="hidden" name="writer" value="${S_USER.user_id }">
			<input type="hidden" name="market_no" value="${miniMarketInfo.market_no }">
			<input type="submit" value="댓글 등록">
		</form>
		<hr>
		<br>
		<label class="small mb-1" for="input_plant_prd">댓글</label>
		<br>
		<hr>
		<c:forEach items="${marketReplyList }" var="marketReplyList">
			<div id="modifyMarketReplyContent${marketReplyList.reply_code }" class="row">
				<div>${marketReplyList.content }</div>
				<label>&nbsp;&nbsp;&nbsp;${marketReplyList.writer }&nbsp;&nbsp;&nbsp;</label>
				<fmt:formatDate value="${marketReplyList.reg_dt }" pattern="yyyy.MM.dd" />
			</div>
			<c:choose>

				<c:when test="${S_USER.user_id == miniMarketInfo.writer }">
					<input type="button" name="${marketReplyList.reply_code }" value="댓글수정" class="modifyMarketReplyBtn btn btn-warning  m-1">

					<form action="${pageContext.request.contextPath }/fcommunity/deleteMarketReply" method="post" class="text-right">
						<input type="hidden" name="writer" value="${S_USER.user_id }" readonly="readonly">
						<input type="hidden" name="market_no" value="${miniMarketInfo.market_no }" readonly="readonly">
						<input type="hidden" name="reply_code" value="${marketReplyList.reply_code }" readonly="readonly">
						<input type="submit" value="댓글삭제" onclick="alert('삭제합니다.');" class="btn btn-danger  m-1">
					</form>


					<div id="modifyMarketReplyDiv${marketReplyList.reply_code }" style="display: none;">
						<form action="${pageContext.request.contextPath }/fcommunity/modifyMarketReply" method="post" class="text-right">
							--%>
							<textarea name="content" rows="2" cols="42" class="text-left">
								${marketReplyList.content }
							</textarea>
							<input type="hidden" name="writer" value="${S_USER.user_id }" readonly="readonly">
							<input type="hidden" name="market_no" value="${miniMarketInfo.market_no }" readonly="readonly">
							<input type="hidden" name="reply_code" value="${marketReplyList.reply_code }" readonly="readonly">
							<input type="submit" name="${marketReplyList.reply_code }" value="댓글수정저장" class="modifyMarketReplySubmitBtn btn btn-warning  m-1">
							<input type="button" name="${marketReplyList.reply_code }" value="취소" class="modifyMarketReplyCancleBtn btn btn-primary m-1">
						</form>
					</div>
					<br>
					<br>
					<br>
					<br>
				</c:when>
				<c:otherwise></c:otherwise>
			</c:choose>
		</c:forEach>
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


