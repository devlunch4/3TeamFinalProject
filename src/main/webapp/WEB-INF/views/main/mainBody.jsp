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
	
	
	$("#category").change(function(){
		
		var num = $("#category").val();
// 		alert("부류코드 값:"+num);
		if(num == 100){
			$("#item2").css("display","none")
			$("#item1").css("display","")
		}
		
		if(num == 200){
			$("#item2").css("display","")
			$("#item1").css("display","none")
			}
		
	})
	
	
	$("#btn_search").on("click",function(){
		var item;
		if($("#category").val() == 100){
			item = $("#item1").val();
		}else if($("#category").val() == 200){
			item = $("#item2").val();
		}
		
		$("#c_code").val($("#category").val());
		$("#i_code").val(item);
		$("#d_code").val($("#dateserch").val());
		
		$("#select").submit();
		
	})
	
	$("#category").val("${itemcategorycode}").prop("selected",true);
	if(${itemcategorycode}=='100'){
		
		$("#item2").css("display","none")
		$("#item1").css("display","")
		
	$("#item1").val("${itemcode}").prop("selected",true);
	}else if(${itemcategorycode}=='200'){
		
		$("#item2").css("display","")
		$("#item1").css("display","none")
		
	$("#item2").val("${itemcode}").prop("selected",true);
	}
})
</script>


<main>

    <div class="container-fluid">
    
    <br>
    <div class="form-group">

	<!-- 현재날짜를 넘지 않게 max값 지정 -->
	<c:set var="now" value="<%=new java.util.Date()%>" />
	<c:set var="sysd"><fmt:formatDate value="${now}" pattern="yyyy-MM-dd" /></c:set> 
	<input type="date" id="dateserch" class="form-control" value="${mydate}" max="${sysd}">

    <br>
    
    
    <form id ="select" action="${pageContext.request.contextPath}/user/main">
    
    <input type="hidden" id = "c_code" name ="category_code" value="">
    <input type="hidden" id = "i_code" name ="item_code" value="">
    <input type="hidden" id = "d_code" name ="sdate" value="">
    
    </form>
    
    <table class="table table-bordered" style="font-size: 15px;">
    <tr><td class="table-active">부류</td>
    </tr><tr><td>
     <select id = "category" class="form-control data-style="btn-primary">
     <option value="100">식량작물</option>
     <option value="200">채소류</option>
  	</select></td></tr>
    </table>
    <table class="table table-bordered" style="font-size: 15px;">
    <tr><td class="table-active">품목</td>
    </tr><tr>
    
    <td>
     <select id = "item1" class="form-control data-style="btn-primary">
     <c:forEach items="${itemsList}" var="item">
     <c:if test="${item.category_code==100}">
     <option value="${item.item_code}">${item.item_nm}</option>
     </c:if>
     </c:forEach>
  	</select>
  	 
  	
  	<select id = "item2" class="form-control data-style="btn-primary" style="display:none">
     <c:forEach items="${itemsList}" var="item">
     <c:if test="${item.category_code==200}">
     <option value="${item.item_code}">${item.item_nm}</option>
     </c:if>
     </c:forEach>
  	</select>
  	
  	</td></tr>
    </table>
    <button id = "btn_search" class="btn btn-secondary">조회하기</button>
    
    
    
    <br><br>
    <table class="table table-bordered" style="font-size: 15px;">
    	
    	<tr>
    		<th class="table-active">구분</th>
    		<c:forEach items="${target}" var="tar">
    		<th>${tar}</th>
    		
    		</c:forEach>
    	</tr>
    	
    	<tr>
    		<td class="table-active">평균</td>
    		<c:forEach items="${average}" var="avg">
    		<td>${avg}</td>
    		
    		</c:forEach>
    	</tr>
    	
    	<tr>
    		<td class="table-active">최고값</td>
    		<c:forEach items="${maxvalue}" var="maxval">
    		<td>${maxval}</td>
    		</c:forEach>
    	</tr>
    	
    	<tr>
    		<td class="table-active">최저값</td>
    		<c:forEach items="${minvalue}" var="minval">
    		<td>${minval}</td>
    		</c:forEach>
    	</tr>
    	
    	<tr>
    		<td class="table-active">등락률</td>
    		<c:forEach items="${flrate}" var="rate">
    		<td>${rate}</td>
    		</c:forEach>
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
	
	