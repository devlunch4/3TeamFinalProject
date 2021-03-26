<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<!-- 0309_KJH datepiker -->
<link rel="stylesheet" href="../resources/datepicker/jquery-ui.css" type="text/css" />
<script src="../resources/datepicker/jquery-ui.js"></script>
<script src="../resources/datepicker/jquery.mtz.monthpicker.js"></script>

<!-- 0309_KJH billboard chart js,css -->
<script src="https://d3js.org/d3.v5.min.js"></script>
<link rel="stylesheet" href="../resources/billboard/billboard.css">
<script src="../resources/billboard/billboard.js"></script>
<link rel="stylesheet" href="../resources/billboard/billboard.css">
<script src="../resources/billboard/billboard.pkgd.js"></script>




<script type="text/javascript">
$(function(){

     $(".loadspin").show();

    $.ajax({
        // type을 설정합니다.
        type : 'GET',
        url : "${pageContext.request.contextPath}/main/mainquote",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
//         data : ,
//         dataType : "json",
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (data) {

        	$('#quote2').html(data);
        	$(".loadspin").hide();
        }
    });
    
    $.ajax({
        // type을 설정합니다.
        type : 'GET',
        url : "${pageContext.request.contextPath}/main/mainratio",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
//         data : ,
//         dataType : "json",
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (data) {

        	$('#ratio2').html(data);
        }
    });
    
    $.ajax({
        // type을 설정합니다.
        type : 'GET',
        url : "${pageContext.request.contextPath}/main/mainpopularity",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
//         data : ,
//         dataType : "json",
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (data) {

        	$('#popularity2').append(data);
        }
    });

	var offset = $('#gohere').offset();
	$('html').animate({
		scrollTop : offset.top
	}, 300);
	
});


</script>
<div class="form-group pt-4">
<div class="gohere" id="gohere"></div>
	<!-- spinner -->
	<div class="loading loadspin " style="position: relative; z-index: 1; width: 100%; height: 100%; display: none;">
		<div class="spinner-border loadspin" role="status" style="position: fixed; z-index: 1031; top: 35%; left: 48%; display: none;">
			<span class="sr-only loadspin " style="display: none;">Loading...</span>
		</div>
	</div>

<div class="text-center pb-2">	
<button class="btn btn-info col-12" id="quotepse" data-toggle="collapse" data-target="#quote">시세분석</button>
</div>

<div id="quote" class="collapse show">
<div id="quote2">

</div>
</div>

<div class="text-center pb-2">	
<button class="btn btn-info text-center col-12" id="ratiopse" data-toggle="collapse" data-target="#ratio">품목별 비율</button>
</div>
 
<div id="ratio" class="collapse show">
<div id="ratio2">

</div>
</div>

<div class="text-center pb-2">	
<button class="btn btn-info text-center col-12" id="popularitypse" data-toggle="collapse" data-target="#popularity">인기농작물</button>
</div>

<div id="popularity" class="collapse show">
<div id="popularity2">

</div>
</div>


</div>

 