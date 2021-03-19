<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 인기 농작물 페이지 -->
<!-- 20210308_KJH 인기 농작물 수정 -->
<h1 class="mt-4">인기 농작물</h1>
<div class="card mt-2 col-sm-12 px-0">

	<div class="card-body text-center px-2">
		<div class="form-group row mb-0">
			<div class="form-row">
				<div class="col-sm-12 p-0">
					<c:forEach items="${mostfileList}" var="mostList" varStatus="status1" end="8">
						<button type="button" class="btn-change m-1 " id="img_btn" style="font-size: 0.6em; background-image: url('${pageContext.request.contextPath}/resources/goodslist/${mostList.code_nm}');width: 77px;height: 80px;" onclick="location.href = '${pageContext.request.contextPath }/fdata/popularityselect?Item_code=${mostList.code_no}'">
							<br> <br> <br> <br>${mostList.code_no}</button>
					</c:forEach>
				</div>
			</div>
			<br>
		</div>
		<hr>
		<div class="form-group pl-1 text-left">
			<dl class="name">
				<dt>데이터명</dt>
				<dd>실시간 경락가격(전자경매속보)</dd>
			</dl>
			<dl class="source">
				<dt>제공</dt>
				<dd>전국 35개 도매시장 관리사무소(공사)</dd>
			</dl>
			<dl class="tool">
				<dt>조사방법</dt>
				<dd>
					<span>도매법인별 전자경매결과</span> &rarr; <span>관리사무소(공사)</span> &rarr; <span>인터넷(경락정보 전송표준) </span> &rarr; <span>농정원[농업ON]전송</span>
				</dd>
			</dl>
			<dl class="time">
				<dt>제공주기</dt>
				<dd>매일 (실시간)</dd>
			</dl>
			<dl class="caution">
				<dt>특이사항</dt>
				<dd>품목 분류 체계는 농수산물 표준코드 기준입니다</dd>
				<dd>일부 도매시장의 경우 전자경매시스템 및 전송시스템 장애로 인하여 지연될 수 있습니다.</dd>
			</dl>
		</div>
	</div>
</div>
