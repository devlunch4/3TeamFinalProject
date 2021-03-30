<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="data" value="100" />
<script type="text/javascript">


$(function(){
	$("#category").change(function(){
		var num = $("#category").val();
// 		alert("부류코드 값:"+num);
		if(num == 100){
			$("#item2").hide();
			$("#item1").show();
		}
		else if(num == 200){
			$("#item2").show();
			$("#item1").hide();
		}
	});
	
	$("#btn_search").on("click",function(){
		$(".loadspin").show();
		var item;
		if($("#category").val() == 100){
			item = $("#item1").val();
		}else if($("#category").val() == 200){
			item = $("#item2").val();
		}
		
		
	    $.ajax({
	        // type을 설정합니다.
	        type : 'GET',
	        url : "${pageContext.request.contextPath}/main/mainquote",
	        data : {"parent_code" : $("#category").val(),
	        	"code_no" : item,
	        	"sdate" : $("#dateserch").val()
	        },
	        success : function (data) {
	        	$('#quote2').html(data);
	        	$(".loadspin").hide();
	        }
	    });
		
// 		<form id="select" action="${pageContext.request.contextPath}/main/mainquote">
// 		<input type="hidden" id="c_code" name="parent_code" value="">
// 		<input type="hidden" id="i_code" name="code_no" value="">
// 		<input type="hidden" id="d_code" name="sdate" value="">
// 	</form>
		
		
// 		$("#c_code").val($("#category").val());
// 		$("#i_code").val(item);
// 		$("#d_code").val($("#dateserch").val());
// 		$("#select").submit();
	})
	
	$("#category").val("${itemcategorycode}").prop("selected",true);
	if(${itemcategorycode}=='100'){
		$("#item2").css("display","none")
		$("#item1").css("display","")
	$("#item1").val("${itemcode}").prop("selected",true);
	}else if(${itemcategorycode}=='200'){
		$("#item1").css("display","none")
		$("#item2").css("display","")
		
	$("#item2").val("${itemcode}").prop("selected",true);
	}
})

</script>



<div class="form-group row mb-0">
		<div class="col-md-4 p-1">
			<table class="table table-bordered " style="font-size: 15px;">
				<tr>
					<td class="table-active text-center py-1">날짜선택</td>
				</tr>
				<tr class="p-2">
					<td >
						<!-- 현재날짜를 넘지 않게 max값 지정 --> <c:set var="now" value="<%=new java.util.Date()%>" /> <c:set var="sysd">
							<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" />
						</c:set> <input type="date" id="dateserch" class="form-control" value="${mydate}" max="${sysd}">
					</td>
				</tr>
			</table>
		</div>
		<div class="col-md-4 p-1">
			<table class="table table-bordered " style="font-size: 15px;">
				<tr>
					<td class="table-active text-center py-1">부류</td>
				</tr>
				<tr class="p-2">
					<td><select id="category" class="form-control">
							<option value="100">식량작물</option>
							<option value="200">채소류</option>
					</select></td>
				</tr>
			</table>
		</div>



		<div class="col-md-4 p-1">
<!-- 			<div class="gohere" id="gohere"></div> -->
			<table class="table table-bordered" style="font-size: 15px;">
				<tr>
					<td class="table-active text-center py-1">품목</td>
				</tr>
				<tr class="p-2">
					<td><select id="item1" class="form-control">
							<c:forEach items="${codesList}" var="codes">
								<c:if test="${codes.parent_code=='100'}">
									<option value="${codes.code_no}">${codes.code_nm}</option>
								</c:if>
							</c:forEach>
					</select> <select id="item2" class="form-control" style="display: none">
							<c:forEach items="${codesList}" var="codes">
								<c:if test="${codes.parent_code=='200'}">
									<option value="${codes.code_no}">${codes.code_nm}</option>
								</c:if>
							</c:forEach>
					</select></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- spinner -->
<!-- 	<div class="loading loadspin " style="position: relative; z-index: 1; width: 100%; height: 100%; display: none;"> -->
<!-- 		<div class="spinner-border loadspin" role="status" style="position: fixed; z-index: 1031; top: 35%; left: 48%; display: none;"> -->
<!-- 			<span class="sr-only loadspin " style="display: none;">Loading...</span> -->
<!-- 		</div> -->
<!-- 	</div> -->

	<div class="form-group text-right">
		<button id="btn_search" class="btn btn-primary col-md-3">조회하기</button>
	</div>

	<div class="form-group ">
		<div class="table-responsive"> 
			<table class="table table-bordered dataTable small" style="font-size: 15px;">
				<tr>
					<th class="table-active px-2 py-1 text-center" style="width: 50px;">구분</th>
					<c:forEach items="${target}" var="tar">
						<th class="text-center py-1 px-0">${tar}</th>
					</c:forEach>
				</tr>
 
				<tr>
					<td class="table-active px-2 py-1 text-center">평균</td>
					<c:forEach items="${average}" var="avg">
						<td class="text-center p-1">${avg}</td>
					</c:forEach>
				</tr>

				<tr>
					<td class="table-active px-2 py-1 text-center">최고값</td>
					<c:forEach items="${maxvalue}" var="maxval">
						<td class="text-center p-1">${maxval}</td>
					</c:forEach>
				</tr>

				<tr>
					<td class="table-active px-2 py-1 text-center">최저값</td>
					<c:forEach items="${minvalue}" var="minval">
						<td class="text-center p-1">${minval}</td>
					</c:forEach>
				</tr>

				<tr>
					<td class="table-active px-2 py-1 text-center">등락률</td>
					<c:forEach items="${flrate}" var="rate">
						<td class="text-center p-1">${rate}</td>
					</c:forEach>
				</tr>
			</table>
		</div>
	</div> 
 <div class="form-group" id="mychartfirst"> 
<canvas id="myChart" style="height:300px; width:auto;"></canvas>
 </div> 


<script> 
$(function(){
		
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
			options: {
				
				maintainAspectRatio: false
				
			} }); 
	});
</script>
