<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>


<main>
    <div class="container-fluid">
    <br>
    <table class="table table-bordered" style="font-size: 15px;">
		<tr>
			<td class="table-active">구분</td>
    		<td class="table-active">당일</td>
    		<td class="table-active">7일전</td>
    		<td class="table-active">1개월전</td>
    		<td class="table-active">1년전</td>
    	</tr>
    	
    	<tr>
    		<td class="table-active">평균</td>
    		<td>${average1}</td>
    		<td>${average2}</td>
    		<td>${average3}</td>
    		<td>${average4}</td>
    	</tr>
    	
    	<tr>
    		<td class="table-active">최고값</td>
    		<td>${maxvalue1}</td>
    		<td>${maxvalue2}</td>
    		<td>${maxvalue3}</td>
    		<td>${maxvalue4}</td>
    	</tr>
    	
    	<tr>
    		<td class="table-active">최저값</td>
    		<td>${minvalue1}</td>
    		<td>${minvalue2}</td>
    		<td>${minvalue3}</td>
    		<td>${minvalue4}</td>
    	</tr>
    	
    	<tr>
    		<td class="table-active">등락률</td>
    		<td></td>
    		<td>${flrate2}</td>
    		<td>${flrate3}</td>
    		<td>${flrate4}</td>
    	</tr>
    
    </table>
    
    <canvas id="myChart" width="600" height="600">
    This text is displayed if your browser does not support HTML5 Canvas.
	</canvas>
    
    
        <p>똑똑한 농부들</p>
        <div class="row">
            <div class="col-xl-6">
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-chart-area mr-1"></i>
                        농산물 시세분석
                    </div>
                    <div class="card-body"><canvas id="myAreaChart" width="100%" height="40"></canvas></div>
                </div>
            </div>
            <div class="col-xl-6">
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-chart-bar mr-1"></i>
                        Bar Chart Example
                    </div>
                    <div class="card-body"><canvas id="myBarChart" width="100%" height="40"></canvas></div>
                </div>
            </div>
        </div>
        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table mr-1"></i>
                DataTable Example
            </div>
            
        </div>
    </div>
</main>
<footer class="py-4 bg-light mt-auto">
    <div class="container-fluid">
        <div class="d-flex align-items-center justify-content-between small">
            <div class="text-muted">Copyright &copy; Your Website 2020</div>
            <div>
                <a href="#">Privacy Policy</a>
                &middot;
                <a href="#">Terms &amp; Conditions</a>
            </div>
        </div>
    </div>
</footer>
           
           
<script> 
$(document).ready(function(){

var num1 = ('${average1}').replaceAll(",","");
var num2 = ('${average2}').replaceAll(",","");
var num3 = ('${average3}').replaceAll(",","");
var num4 = ('${average4}').replaceAll(",","");


var ctx = document.getElementById('myChart').getContext('2d');
var chart = new Chart(ctx, 
		{ // 챠트 종류를 선택 
	type: 'line', 
	// 챠트를 그릴 데이타 
	data: { labels: ['오늘', '7일전', '1개월전', '1년전'], 
		datasets: [{ label: 'My First dataset', 
			backgroundColor: 'transparent', 
			borderColor: 'red', 
			data: [num1,num2,num3,num4] },{ label: 'My irst dataset', 
				backgroundColor: 'transparent', 
				borderColor: 'red', 
				data: [num4,num3,num2,num1] }] },
	// 옵션 
	options: {} }); 
	
})
</script>
	
	