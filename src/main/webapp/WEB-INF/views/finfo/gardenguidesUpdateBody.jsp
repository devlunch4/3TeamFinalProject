<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>
	// 삭제 버튼 클릭시 이동
	$(function() {
		$("#deleteBtn").on("click", function() {
			var xguide_code = ${gardenguidesVo.guide_code};
			$("#xguide_code").val(xguide_code);
			$("#guidefrm").attr("method", "post");
			$("#guidefrm").attr("action", "gardenguidesDelete");
			$("#guidefrm").submit();
		});
	});
</script>


<h3 class="mt-4">재배안내 수정</h3>

<form id="guidefrm" enctype="multipart/form-data" action="${pageContext.request.contextPath}/finfo/gardenguidesUpdateBtn" method="post">
	<input type="hidden" id="xguide_code" name="xguide_code" value="">
	<!-- 글쓰기 summernote-->
	<!-- <textarea id="summernote" name="summernote"></textarea>
			<script>
				$('#summernote')
						.summernote(
								{
									placeholder : 'Hello SUMMERNOTE',
									tabsize : 2,
									height : 120,
									toolbar : [
											[ 'style', [ 'style' ] ],
											[
													'font',
													[ 'bold', 'underline',
															'clear' ] ],
											[ 'color', [ 'color' ] ],
											[ 'para',
													[ 'ul', 'ol', 'paragraph' ] ],
											[ 'table', [ 'table' ] ],
											[
													'insert',
													[ 'link', 'picture',
															'video' ] ],
											[
													'view',
													[ 'fullscreen', 'codeview',
															'help' ] ] ]
								});
			</script> -->
	<label class="small" for="guide_code">가이드글번호</label>
	<input class="form-control py-4" id="guide_code" name="guide_code" type="text" readonly="readonly" value="${gardenguidesVo.guide_code }">

	<div class="form-row">
		<div class="col-md-3">
			<div class="form-group">
				<label class="small" for="writer">작성자</label>
				<input class="form-control py-4" id="writer" name="writer" type="text" readonly="readonly" value="${gardenguidesVo.writer }">
			</div>
		</div>
		<div class="col-md-3">
			<div class="form-group">
				<label class="small" for="reg_dt">등록일</label>
				<input class="form-control py-4" id="reg_dt" name="reg_dt" type="text" value="${gardenguidesVo.reg_dt }" required="required" readonly="readonly">
			</div>
		</div>
		<div class="col-md-3">
			<div class="form-group">
				<label class="small" for="use_yn">사용여부</label>
				<input class="form-control py-4" id="use_yn" name="use_yn" type="text" placeholder="공개='Y'" value="${gardenguidesVo.use_yn }" required="required" readonly="readonly">
			</div>
		</div>
	</div>

	<div class="form-row">
		<div class="col-md-3">
			<div class="form-group ">
				<label class="small mb-1" for="class_code">분류명</label>
				<input class="form-control py-4" id="class_code" name="class_code" type="text" placeholder="분류명 입력 ex)가지과" value="${gardenguidesVo.class_code }" required="required">
			</div>
		</div>
		<div class="col-md-3">
			<div class="form-group ">
				<label class="small mb-1" for="item_code">품목명</label>
				<input class="form-control py-4" id="item_code" name="item_code" type="text" placeholder="품목명 입력 ex)가지" value="${gardenguidesVo.item_code }" required="required">
			</div>
		</div>
		<div class="col-md-3">
			<div class="form-group">
				<label class="small mb-1" for="difficulty">난이도(숫자)</label>
				<input class="form-control py-4" id="difficulty" name="difficulty" type="text" placeholder="난이도 입력(숫자) ex)2" value="${gardenguidesVo.difficulty }" required="required">
			</div>
		</div>
		<div class="col-md-3">
			<div class="form-group">
				<label class="small mb-1" for="origin">원산지</label>
				<input class="form-control py-4" id="origin" name="origin" type="text" placeholder="원산지 ex)한국" value="${gardenguidesVo.origin }" required="required">
			</div>
		</div>
	</div>

	<div class="form-row">
		<div class="col-md-3">
			<div class="form-group">
				<label class="small mb-1" for="grow_start_time">재배시기</label>
				<input class="form-control py-4" id="grow_start_time" name="grow_start_time" type="text" placeholder="재배시기 입력 ex)3월중순~6월하순" value="${gardenguidesVo.grow_start_time }" required="required">
			</div>
		</div>
		<div class="col-md-3">
			<div class="form-group">
				<label class="small mb-1" for="grow_time">재배기간</label>
				<input class="form-control py-4" id="grow_time" name="grow_time" type="text" placeholder="재배기간 입력 ex)3개월" value="${gardenguidesVo.grow_time }" required="required">
			</div>
		</div>

		<div class="col-md-3">
			<div class="form-group">
				<label class="small mb-1" for="temperature">생육온도</label>
				<input class="form-control py-4" id="temperature" name="temperature" type="text" placeholder="생육온도 ex)22~30℃" value="${gardenguidesVo.temperature }" required="required">
			</div>
		</div>
		<div class="col-md-3">
			<div class="form-group">
				<label class="small mb-1" for="season">제철(계절)</label>
				<input class="form-control py-4" id="season" name="season" type="text" placeholder="제철(계절) ex)봄/여름/가을/겨울" value="${gardenguidesVo.season }" required="required">
			</div>
		</div>
	</div>

	<div class="form-row">
		<div class="col-md-8">
			<div class="form-group">
				<label class="small mb-1" for="effect">효과</label>
				<input class="form-control py-4" id="effect" name="effect" type="text" placeholder="효과 ex)소화기 질환의 회복 등" value="${gardenguidesVo.effect }" required="required">
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group">
				<label class="small mb-1" for="damage">연작피해</label>
				<input class="form-control py-4" id="damage" name="damage" type="text" placeholder="연작피해 입력 ex)없음/있음" value="${gardenguidesVo.damage }" required="required">
			</div>
		</div>
	</div>


	<div class="form-group">
		<label class="small" for="ingredient">주요성분</label>
		<input class="form-control py-4" id="ingredient" name="ingredient" type="text" placeholder="주요성분 ex)단백질, 탄수화물, 당 등" value="${gardenguidesVo.ingredient }" required="required">
	</div>

	<div class="form-group">
		<label class="small" for="plant_tip">재배팁</label>
		<textarea class="form-control" id="plant_tip" name="plant_tip" placeholder="재배팁 ex)
유기질 퇴비와 석회를 충분히 넣는다. 
수분을 해 주면 열매 맺음이 좋다." required="required" style="resize: none; overflow-y: visible; height: 100px;">${gardenguidesVo.plant_tip }</textarea>
	</div>

	<div class="form-group">
		<label class="small" for="plant_content">재배내용</label>
		<textarea class="form-control" id="plant_content" name="plant_content" placeholder="재배내용 ex)
▷ 우리나라 사람들에게 가장 사랑받는 채소 중의 하나가 호박이다.
▷ 호박은 사용 용도에 따라 애호박, 단호박, 맷돌호박, 꽃호박, 약호박 등 매우 다양하지만, 일반적으로 텃밭에서는 애호박과 호박잎을 이용하는 종류를 많이 재배한다." required="required" style="resize: none; overflow-y: visible; height: 100px;">${gardenguidesVo.plant_content }</textarea>
	</div>
	<div class="form-group">
		<label class="small" for="file_nm2">파일추가</label><br>
		<input type="file" id="file_nm2" name="file_nm2" accept="image/png, image/jpeg" value="">
		<hr>
	</div>
	<div class="text-right col-12 p-0">
		<!-- 관리자 전용 삭제 이동 버튼 활성 -->
		<button class="btn-danger btn-lg mt-2 col-md-3 " type="button" id="deleteBtn" name="deleteBtn">삭제</button>
		<!-- 관리자 전용 수정완료  버튼 활성 -->
		<button class="btn-warning btn-lg mt-2 col-md-3 " type="submit" id="updateBtn" name="updateBtn">수 정</button>
		<hr>
	</div>
</form>

