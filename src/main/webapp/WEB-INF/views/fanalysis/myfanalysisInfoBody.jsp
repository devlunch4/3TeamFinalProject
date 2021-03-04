<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script> <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

<link rel="stylesheet" href="../resources/datepicker/css/bootstrap-datepicker.css">
<script src="../resources/datepicker/js/bootstrap-datepicker.js"></script>
<script src="../resources/datepicker/locales/bootstrap-datepicker.ko.min.js"></script>
<c:set var="data" value="100" />

<script type="text/javascript">
$(function(){

})
</script>

<!-- 20210304_KJH items -> 내 시설 관측 -->
<h3 class="mt-4">내 시설 관측</h3>

<c:forEach items="${msrequipList}" var="msrequip">
${msrequip.msr_nm}<br>
</c:forEach>

<c:forEach items="${msrrecVo}" var="msrrec">
${msrrec.msr_temp},${msrrec.msr_humid},${msrrec.msr_bright}<br>
</c:forEach>

<button class="btn btn-primary" id = "week">일주일</button>
<button class="btn btn-primary" id = "mm">한달</button>

<div class="form-group">
	<!-- 현재날짜를 넘지 않게 max값 지정 -->
	<c:set var="now" value="<%=new java.util.Date()%>" />
	<c:set var="sysd">
		<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" />
	</c:set>
	<input type="date" id="dateserch" class="form-control" value="${mydate}" max="${sysd}"> 
	
	<br>

	<form id="select" action="${pageContext.request.contextPath}/user/main">
		<input type="hidden" id="c_code" name="parent_code" value="">
		<input type="hidden" id="i_code" name="code_no" value=""> 
		<input type="hidden" id="d_code" name="sdate" value="">
	</form>

	<button id="btn_search" class="btn btn-secondary">조회하기</button>
	<br>
	<br>

	<canvas id="myChart" width="600" height="300">This text is displayed if your browser does not support HTML5 Canvas.</canvas>
</div>
	

<script> 
	$(document).ready(function(){
		
		<c:forEach items="${target}" var="tg" varStatus="status">
			var tg${status.count} = ('${tg}');
		</c:forEach>
		
		<c:forEach items="${average}" var="avg" varStatus="status">
			var avg${status.count} = ('${avg}').replaceAll(",","");
		</c:forEach>
		
		<c:forEach items="${maxvalue}" var="maxval" varStatus="status">
		var maxval${status.count} = ('${maxval}').replaceAll(",","");
		</c:forEach>
		
		<c:forEach items="${minvalue}" var="minval" varStatus="status">
		var minvalue${status.count} = ('${minval}').replaceAll(",","");
		</c:forEach>
		
		var ctx = document.getElementById('myChart').getContext('2d');
		var chart = new Chart(ctx, 
				{ // 챠트 종류를 선택 
			type: 'line', 
			// 챠트를 그릴 데이타 
			data: { labels: [tg5,tg4,tg3,tg2,tg1], 
				datasets: [{ label: '평균가', 
					backgroundColor: 'transparent', 
					borderColor: 'red', 
					data: [avg5,avg4,avg3,avg2,avg1] },
					
					{ label: '최고가', 
						backgroundColor: 'transparent', 
						borderColor: 'blue', 
						data: [maxval5,maxval4,maxval3,maxval2,maxval1] },
					{
					label: '최저가', 
					backgroundColor: 'transparent', 
					borderColor: 'yellow', 
					data: [minvalue5,minvalue4,minvalue3,minvalue2,minvalue1] }
				
					] },
		
			// 옵션 
			options: {} }); 
	})
</script>