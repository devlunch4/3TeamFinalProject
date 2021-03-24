<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="mt-4">문의사항</h3>

<div class="board_wrap">
	<table>
		<tr>
			<th>작성자</th>
			<td>${qna.writer}</td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td>${qna.reg_dt}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${qna.title}</td>
		</tr>
		<tr>
			<th class="content_title">내용</th>
			<td class="content">${qna.content}</td>
		</tr>
	</table>
</div>

<div class="text-right mt-3">
	<!-- 세션으로 받아온 아이디가 admin과 일치 또는 작성자와 일치하는경우 -->
	<c:if test="${S_USER.user_id.equals('admin') || S_USER.user_id.equals(qna.writer)}">
		<a class="btn btn-primary" href="qnaModifyView?qna_no=${qna.qna_no}">수정</a>
		<a class="btn btn-primary" href="qnaDelete?qna_no=${qna.qna_no}">삭제</a>
	</c:if>
	
	<!-- 세션으로 받아온 아이디가 admin과 일치하는경우 -->
	<c:if test="${S_USER.user_id.equals('admin')}">
		<a class="btn btn-primary" href="qnaRegistAdminReplyView?qna_no=${qna.qna_no}">답글등록</a>
	</c:if>
</div>
