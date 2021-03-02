<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<main>


	<div class="container-fluid">
		<h3 class="mt-4">텃밭가이드 등록(재배정보)</h3>
		<br>

		<form>
		<!-- 글쓰기 summernote-->
			 <textarea id="summernote" name="summernote"></textarea>
			<script>
      $('#summernote').summernote({
        placeholder: 'Hello SUMMERNOTE',
        tabsize: 2,
        height: 120,
        toolbar: [
          ['style', ['style']],
          ['font', ['bold', 'underline', 'clear']],
          ['color', ['color']],
          ['para', ['ul', 'ol', 'paragraph']],
          ['table', ['table']],
          ['insert', ['link', 'picture', 'video']],
          ['view', ['fullscreen', 'codeview', 'help']]
        ]
      });
    </script> 


			<div class="form-group">
				<label class="small mb-1" for="input_cls_code">분류명</label> <input
					class="form-control py-4" id="input_cls_code" name="input_cls_code"
					type="text" placeholder="분류명 입력 ex)가지과" required="required">
			</div>
			<div class="form-group">
				<label class="small mb-1" for="input_grdgd_nm">품목명</label> <input
					class="form-control py-4" id="input_grdgd_nm" name="input_grdgd_nm"
					type="text" placeholder="품목명 입력 ex)가지" required="required">
			</div>
			<div class="form-group">
				<label class="small mb-1" for="input_difficulty">난이도(숫자)</label> <input
					class="form-control py-4" id="input_difficulty"
					name="input_difficulty" type="number" placeholder="난이도 입력(숫자) ex)2"
					required="required">
			</div>
			<div class="form-group">
				<label class="small mb-1" for="input_plant_prd">재배시기</label> <input
					class="form-control py-4" id="input_plant_prd"
					name="input_plant_prd" type="text"
					placeholder="재배시기 입력 ex)3월중순~6월하순" required="required">
			</div>
			<div class="form-group">
				<label class="small mb-1" for="input_plant_prd">재배시기</label> <input
					class="form-control py-4" id="input_plant_prd"
					name="input_plant_prd" type="text" placeholder="재배기간 입력 ex)3개월"
					required="required">
			</div>

			<a class="btn btn-primary" href="index.html">등록</a>
		</form>


		<div class="row">

			<!-- 설명 시작 -->
			<br>
			<div class="card mt-2 col-sm-12 px-0">
				<h3 class="card-header">가지</h3>
				<div class="card-body text-left ">
					<div class="">
						<div class="row">
							<div class="imgwrap">
								<img src="/images/upload/farm_guide_info/144609103235500023.jpg"
									alt="144609103235500023.jpg">
							</div>




							<table class="table table-bordered col-sx-12">
								<tr>
									<td style="width: 30%">품명</td>
									<td style="width: 70%"></td>
								</tr>

								<tr>
									<td style="width: 30%">분류</td>
									<td style="width: 70%">국화과</td>
								</tr>
								<tr>
									<td style="width: 30%">싹트이는온도</td>
									<td style="width: 70%">15~20℃</td>
								</tr>
								<tr>
									<td style="width: 30%">원산지</td>
									<td style="width: 70%">남유럽 및 서아시아</td>
								</tr>
								<tr>
									<td style="width: 30%">생육온도</td>
									<td style="width: 70%">15~20℃</td>
								</tr>
								<tr>
									<td style="width: 30%">연작피해</td>
									<td style="width: 70%">없음</td>
								</tr>
								<tr>
									<td style="width: 30%">제철</td>
									<td style="width: 70%">사계절</td>
								</tr>
								<tr>
									<td style="width: 30%">효과</td>
									<td style="width: 70%">락투카리움 성분이 있어, 불면증, 신경장애에 좋으며, 철분이
										많이 함유되어 혈액을 늘리는 작용을 한다.</td>
								</tr>
								<tr>
									<td style="width: 30%">주요성분</td>
									<td style="width: 70%">락투카리움, 철분</td>
								</tr>
								<tr>
									<td style="width: 30%">재배TIP!</td>
									<td style="width: 70%">*잘 자라는 온도 : 생육 15∼20℃, 결구 10∼16℃<br>
										*양상추의 비대와 충실도는 밤 온도가 10℃부터 15℃정도의 약간 차갑고 서늘한 온도가 적당하다. 낮과 밤의
										온도가 20℃ 이상이 계속되면 줄기가 자라기 시작하고 마침내는 꽃눈이 분화하게 된다. 그러므로 고온기 재배 때는
										낮 온도뿐만 아니라 밤의 온도도 포기비대, 충실에 제한요인이 된다.<br> *햇빛의 세기 : 생육
										초기에 광이 부족하면 엽육이 얇아지고, 엽면적도 작아진다.<br> *토양조건 : 건조한 사질토나,
										지하수위가 높은 점질 땅에서는 생육이 나쁘므로 유기질이 풍부하고 관수하기 편리한 포장인 양토에서 재배하는 것이
										좋다.
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>
<footer class="py-4 bg-light mt-auto">
	<div class="container-fluid">
		<div class="d-flex align-items-center justify-content-between small">
			<div class="text-muted">Copyright &copy; Your Website 2020</div>
			<div>
				<a href="#">Privacy Policy</a> &middot; <a href="#">Terms &amp;
					Conditions</a>
			</div>
		</div>
	</div>
</footer>