<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>

<!-- 품목별 비율 통계 페이지 -->
<!-- 20210302_KJH main 추가 -->
<h3 class="mt-4">품목별 비율</h3>
<div class="card mt-2 col-sm-12 px-0">
	<h5 class="card-header">총게시글 :</h5>
	<div class="card-body text-left ">
		<div class="">
			<div class="row">
				<div class="container">
					<div class="row my-3">
						<div class="col-12">
							<h4>Bootstrap 4 Chart.js - Chart</h4>
						</div>
					</div>
					<div class="row my-2">
						<div class="col-lg-6">
							<div class="card">
								<div class="card-body">
									<canvas id="myChart2"></canvas>
								</div>
								<div class="card card-body text-center bg-primary">
									<h3>Doughnut</h3>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>


data = { datasets: [{ 
	backgroundColor: ['red','yellow','blue'],
	data: [10, 20, 30] }], // 라벨의 이름이 툴팁처럼 마우스가 근처에 오면 나타남 
	labels: ['red','yellow','blue'] }; // 가운데 구멍이 없는 파이형 차트 
	// 도넛형 차트 
	var ctx2 = document.getElementById("myChart2"); 
	var myDoughnutChart = new Chart(ctx2, {
		type: 'doughnut', data: data, options: {} 
	}); 

</script>