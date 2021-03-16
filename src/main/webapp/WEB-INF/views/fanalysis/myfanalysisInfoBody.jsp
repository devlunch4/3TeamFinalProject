<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

<link rel="stylesheet" href="../resources/datepicker/css/bootstrap-datepicker.css">
<script src="../resources/datepicker/js/bootstrap-datepicker.js"></script>
<script src="../resources/datepicker/locales/bootstrap-datepicker.ko.min.js"></script>
<c:set var="data" value="100" />

<script type="text/javascript">
$(function(){
	$("#week").on("click",function(){
		$("#w_date").val("7");
		$("#selec").val($("#select").val());
		$("#read").submit();
	});
	
	$("#month").on("click",function(){
		$("#m_date").val("30");
		$("#selec").val($("#select").val());
		$("#read").submit();
	});
	
	$("#btn_search").on("click",function(){
		$("#d_date").val($("#dateserch").val());
		$("#selec").val($("#select").val());
		$("#read").submit();
	});
	$("#select").val("${selec}").prop("selected", true);
})

</script>

<form action="${pageContext.request.contextPath}/fanalysis/myfanalysisInfo" id="read" method="post">
	<input type="hidden" name= "msr_code" value="${msr_code}">
	<input type="hidden" id = "w_date" name="week" >
	<input type="hidden" id = "m_date" name="month">
	<input type="hidden" id = "d_date" name="day" >
	<input type="hidden" id = "selec" name="selec" >
</form>

<!-- 20210304_KJH items -> 내 시설 관측 -->
<h3 class="mt-4">내 시설 관측</h3>
<select id = "select">
<c:forEach items="${fmanageList}" var="fmanage" varStatus="status">
	<option id = "${status.index}" value="${fmanage.manage_no}">${fmanage.location}</option>
</c:forEach>
</select>
<br>
${manage_no}
<br>
<c:forEach items="${mmmList}" var="msrrec">
<%-- <c:if test="${NULL ne msrrec}"> --%>
${msrrec.msr_temp},${msrrec.msr_humid},${msrrec.msr_bright}<br>
<%-- </c:if> --%>
</c:forEach>

<button class="btn btn-primary float-left" id="week">일주일</button>
&nbsp;
<button class="btn btn-primary float-left" id="month">한달</button>

<div class="form-group">
	<!-- 현재날짜를 넘지 않게 max값 지정 -->
	<c:set var="now" value="<%=new java.util.Date()%>" />
	<c:set var="sysd">
		<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" />
	</c:set>
	
	<c:set var="se" value="${sedate}" />
	<c:set var="sedate">
		<fmt:formatDate value="${se}" pattern="yyyy-MM-dd" />
	</c:set>
	
	<input type="date" id="dateserch" class="form-control" value="${sedate}" max="${sysd}"> <br>
	
	

	<form id="select" action="${pageContext.request.contextPath}/user/main">
		<input type="hidden" id="c_code" name="parent_code" value=""> 
		<input type="hidden" id="i_code" name="code_no" value=""> 
		<input type="hidden" id="d_code" name="sdate" value="">
	</form>

	<button id="btn_search" class="btn btn-secondary">조회하기</button>
	<br> <br>

	<canvas id="myChart" width="600" height="300">This text is displayed if your browser does not support HTML5 Canvas.</canvas>
</div>


<script> 
	$(document).ready(function(){
		
		const colors = ['red','yellow','blue','#c3e6cb','#dc3545','#6c757d']; 
		var chBar = document.getElementById("myChart"); 
		var chartData = { labels: 
			[
				<c:forEach items="${mmmList}" var="msrrec" varStatus="status">

				'${status.index}',

			</c:forEach>
				], 
			datasets: [
				{ data: [

					<c:forEach items="${mmmList}" var="msrrec">
					${msrrec.msr_temp},
					</c:forEach>
					
					], 
					backgroundColor: colors[0] }, 
					{ data: [

						<c:forEach items="${mmmList}" var="msrrec">

						${msrrec.msr_humid},

						</c:forEach>
						
						], 
						backgroundColor: colors[1] }, 
						{ data: [

							<c:forEach items="${mmmList}" var="msrrec">
							${msrrec.msr_bright},
							</c:forEach>
							
							], 
							backgroundColor: colors[2] }
							] 
		};


		var myChart = new Chart(chBar, { // 챠트 종류를 선택 
			type: 'bar', // 챠트를 그릴 데이타 
			data: chartData, // 옵션 
			options: { legend: { display: false } } });
	})
</script>