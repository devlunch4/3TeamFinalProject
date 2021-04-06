<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
$('#tb').DataTable({
	bDestroy : true,
	"dom": 'l f i r t <"col-sm-7" p>',
	"columnDefs" : [ {
		"searchable" : true,
		"targets" : 0
	}, {
		"searchable" : false,
		"targets" : 1
	} ]
	});
	//20210325 KJH 검색제한 - 작물명으로만 가능
$('.dataTables_filter input[type="search"]').css(
	     {'width':'9em'}
	  );
 
$("#tb_paginate").addClass('text-center');
$("#tb_info").addClass('text-left p-0 small');
$("#tb_info").css( "width", "40%" );
$("#tb_info").css( "float", "left" );

$("#tb_length").addClass('text-left p-0 small');
$("#tb_length").css( "width", "40%" );
$("#tb_length").css( "float", "left" );
 
$("#tb_paginate").addClass('text-center');



$("#tb_filter").addClass('text-right pl-1');
$("#tb_filter").css( "width", "59%" );
$("#tb_filter").css( "float", "left" );
}); 
</script>

<!-- 품목별 비율 통계 페이지 -->
<!-- 20210302_KJH main 추가 -->
<h3 class="mt-4">품목별 비율</h3>
<div class="card mt-4 col-sm-12 px-0">
	<!-- <h5 class="card-header">총게시글 :</h5> -->

	<form action="${pageContext.request.contextPath}/fdata/ratio" id="selec">
		<input type="hidden" id="selctype" name="selec" value="all">
		<input type="hidden" id="sval" name="sdate">
		<input type="hidden" id="eval" name="edate">
	</form>

	<div class="form-group row text-center m-0">
		<button id="all" class="btn btn-outline-dark col m-2">전체</button>
		<button id="week" class="btn btn-outline-dark col m-2 ">주별</button>
		<button id="month" class="btn btn-outline-dark col m-2">월별</button>
		<button id="year" class="btn btn-outline-dark col m-2 ">년별</button>
	</div>

	<div></div>


	<c:set var="now" value="<%=new java.util.Date()%>" />
	<c:set var="sysd">
		<fmt:formatDate value="${now}" pattern="yyyy-'01'" />
	</c:set>
	<c:set var="now2" value="<%=new java.util.Date()%>" />
	<c:set var="sysd2">
		<fmt:formatDate value="${now2}" pattern="yyyy-MM" />
	</c:set>



	<div class="form-group m-0">
		<label class=" small mb-1 ml-2 mb-1" for="time">기간선택 : ${choice}</label>
	</div>
	<div class="form-group row text-center m-0">
		<input type="text" id="allpick" value="전체조회" name="alls" class="btn btn-info col m-2" readonly>
		<input type="text" id="week-picker" value="주간 선택" name="week" class="btn btn-info col m-2" style="display: none;" readonly>
		<input type="text" id="smonth-picker" value="${sysd}" name="smonth-picker" style="display: none;" class="col  btn btn-info m-2" readonly>
		<input type="text" id="emonth-picker" value="${sysd2}" name="emonth-picker" style="display: none;" class="col  btn btn-info m-2" readonly>
		<input type="text" id="syear-picker" name="syear" style="display: none;" class="col  btn btn-info m-2" readonly>
		<input type="text" id="eyear-picker" name="eyear" style="display: none;" class="col  btn btn-info m-2" readonly>
		<button id="sel" class="btn btn-primary col-3 m-2 float-right">조 회</button>

	</div>

	<div class="align-center px-0 mb-4">
		<div class="container px-0">
			<div class="col-12">
				<h4 class="mt-2 text-center">품목별 비율</h4>
				<div id="multilineLabel"></div>
			</div>
			<c:if test="${fn:length(farmCount) == 0}">
				<div class="col-12 text-center">검색된 통계가 없습니다.</div>
			</c:if>
		</div>
	</div>

	<div class="form-group col-xs-12 pt-5">
		<div class="float-left col-md-12 p-1  text-center">
			<table id="tb" class="table table-bordered " style="font-size: 15px;">
				<thead>
					<tr>
						<td class="table-active px-0 py-2">작물명</td>
						<td class="table-active px-0 py-2">수확량</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${farmCount}" var="fcount">
						<tr>
							<td class="px-0 py-1">${fcount.content}</td>
							<td class="px-0 py-1">${fcount.yield}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>




<script>
$(function() {
	
    $.datepicker.setDefaults({
        dateFormat: 'yy-mm-dd',
        prevText: '이전 달',
        nextText: '다음 달',
//         changeMonth: true, // 월을 바꿀수 있는 셀렉트 박스를 표시한다.
        changeYear: true, // 년을 바꿀 수 있는 셀렉트 박스를 표시한다.
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        showMonthAfterYear: true,
        yearSuffix: '년'
    });
	
    var sstartDate;
    var sendDate;
    
    var estartDate;
    var eendDate;
    
    $('#week-picker').datepicker( {
        showOtherMonths: true,
        selectOtherMonths: true,
        changeMonth: true,
  selectWeek:true,
        onSelect: function(dateText, inst) { 
            var date = $(this).datepicker('getDate');
            sstartDate = new Date(date.getFullYear(), date.getMonth(), date.getDate() - date.getDay() + 0);
            sendDate = new Date(date.getFullYear(), date.getMonth(), date.getDate() - date.getDay() + 6);
   var dateFormat = 'yy-mm-dd'
	   		sstartDate = $.datepicker.formatDate( dateFormat, sstartDate, inst.settings );
            sendDate = $.datepicker.formatDate( dateFormat, sendDate, inst.settings );
   $('#week-picker').val(sstartDate + '~' + sendDate);
            
            setTimeout("applyWeeklyHighlight()", 100);
        },
  beforeShow : function() {
   setTimeout("applyWeeklyHighlight()", 100);
  }
    });
    
    
    var soptions = {
            pattern: 'yyyy-mm'       // input태그에 표시될 형식
           ,monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']         // 화면에 보여줄 월이름
           ,openOnFocus: true       // focus시에 달력이 보일지 유무
           ,disableMonths : [ ]     // 월 비활성화
        };
    
    $("#smonth-picker").monthpicker(soptions,'-1M');
    
    var eoptions = {
            pattern: 'yyyy-mm'       // input태그에 표시될 형식
           ,monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']         // 화면에 보여줄 월이름
           ,openOnFocus: true       // focus시에 달력이 보일지 유무
           ,disableMonths : [ ]     // 월 비활성화
        };
    
    $("#emonth-picker").monthpicker(eoptions);
    
    $("#syear-picker").datepicker({
        dateFormat: 'yy' //Input Display Format 변경
        ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
        ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
        ,changeYear: true //콤보박스에서 년 선택 가능          
        ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
        ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
        ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
        ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
        ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
        ,minDate: "-10Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
        ,maxDate: "+0M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)                
    });                    
    
    //초기값을 오늘 날짜로 설정
    $('#syear-picker').datepicker('setDate', '-1Y'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)            
    
    $("#eyear-picker").datepicker({
        dateFormat: 'yy' //Input Display Format 변경
        ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
        ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
        ,changeYear: true //콤보박스에서 년 선택 가능          
        ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
        ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
        ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
        ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
        ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
        ,minDate: "-10Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
        ,maxDate: "+0M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)                
    });                    
    
    //초기값을 오늘 날짜로 설정
    $('#eyear-picker').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)            


    if("all" == "${selec}"){
    	$("#allpick").show();
    	$("#week-picker").hide();
    	$("#smonth-picker").hide();
    	$("#emonth-picker").hide();
    	$("#syear-picker").hide();
    	$("#eyear-picker").hide();
    }

    if("week" == "${selec}"){
    	$("#selctype").val("week");
    	$("#week-picker").show();
    	$("#smonth-picker").hide();
    	$("#emonth-picker").hide();
    	$("#syear-picker").hide();
    	$("#eyear-picker").hide();
    	$("#allpick").hide();
    	$("#week-picker").val("${sdate}");
    }
    else if("month" == "${selec}"){
    		$("#selctype").val("month");
    		$("#week-picker").hide();
    		$("#smonth-picker").show();
    		$("#emonth-picker").show();
    		$("#syear-picker").hide();
    		$("#eyear-picker").hide();
        	$("#allpick").hide();
    		
    		$("#smonth-picker").val("${sdate}");
    		$("#emonth-picker").val("${edate}");
    }else if("year" == "${selec}"){
    		$("#selctype").val("year");
    		$("#week-picker").hide();
    		$("#smonth-picker").hide();
    		$("#emonth-picker").hide();
    		$("#syear-picker").show();
    		$("#eyear-picker").show();
        	$("#allpick").hide();
    		
    		$("#syear-picker").val("${sdate}");
    		$("#eyear-picker").val("${edate}");
    }

});
function applyWeeklyHighlight() {
 $('.ui-datepicker-calendar tr').each(function() {
  if ($(this).parent().get(0).tagName == 'TBODY') {
   $(this).mouseover(function() {
    $(this).find('a').css({
     'background' : '#ffffcc',
     'border' : '1px solid #dddddd'
    });
    $(this).find('a').removeClass('ui-state-default');
    $(this).css('background', '#ffffcc');
   });
   
   $(this).mouseout(function() {
    $(this).css('background', '#ffffff');
    $(this).find('a').css('background', '');
    $(this).find('a').addClass('ui-state-default');
   });
  }
 });
}




$("#week").on("click",function(){
	$("#selctype").val("week");
	$("#week-picker").show();
	$("#smonth-picker").hide();
	$("#emonth-picker").hide();
	$("#syear-picker").hide();
	$("#eyear-picker").hide();
	$("#allpick").hide();
});	
	$("#month").on("click",function(){
		$("#selctype").val("month");
		$("#week-picker").hide();
		$("#smonth-picker").show();
		$("#emonth-picker").show();
		$("#syear-picker").hide();
		$("#eyear-picker").hide();
    	$("#allpick").hide();
});
	$("#year").on("click",function(){
		$("#selctype").val("year");
		$("#week-picker").hide();
		$("#smonth-picker").hide();
		$("#emonth-picker").hide();
		$("#syear-picker").show();
		$("#eyear-picker").show();
    	$("#allpick").hide();
});
	$("#sel").on("click",function(){
		
		
		
		if($("#selctype").val() == "week"){
			if($("#week-picker").val() =="클릭하여 주 선택"){
				alert("주를 선택해야합니다.");
				return;
			}else{
			$("#sval").val($("#week-picker").val());
			}
		}
		else if($("#selctype").val() == "month" ){
			$("#sval").val($("#smonth-picker").val());
			$("#eval").val($("#emonth-picker").val());
		}
		else if($("#selctype").val() == "year"){
			$("#sval").val($("#syear-picker").val());
			$("#eval").val($("#eyear-picker").val());
		}
		else if($("#selctype").val() == "all"){
			$("#sval").val($("#syear-picker").val());
			$("#eval").val($("#eyear-picker").val());
		}
		
		$("#selec").submit();
	});
	
	$("#all").on("click",function(){
		$("#selctype").val("all")
		$("#selec").submit();
	});
				<c:set var = "total" value = "0" />
				<c:forEach items="${farmCount}" var="fcount">
				<c:set var= "total" value="${total + fcount.yield}"/>
     		    </c:forEach>
     	
     	var chart = bb.generate({
     		  data: {
     		    columns: [
     		    	<c:forEach items="${farmCount}" var="fcount">
     		     	['${fcount.content}',${fcount.yield}],
     		     	</c:forEach>
     		    ],
     		    type: "gauge", // for ESM specify as: gauge()
     		  },
     		  gauge: {
     		    type: "single",
     		    max: ${total},
     		    min: 0,
     		    fullCircle: true,
     		    arcLength: 100
     		  },
     		  size: {
     		    height: 300
     		  },
     		  bindto: "#multilineLabel"
     		});
     		setTimeout(function() {
     			chart.config("gauge.arcLength", 75, false);
     			chart.flush(true);
     		}, 2000);
     		setTimeout(function() {
     			chart.config("gauge.arcLength", 50, false);
     			chart.flush(true);
     		}, 4000);
     		setTimeout(function() {
     			chart.config("gauge.arcLength", 25, false);
     			chart.flush(true);
     		}, 6000);
     		setTimeout(function() {
     			chart.config("gauge.arcLength", -25, false);
     			chart.flush(true);
     		}, 8000);
     		setTimeout(function() {
     			chart.config("gauge.arcLength", -50, false);
     			chart.flush(true);
     		}, 10000);
     		setTimeout(function() {
     			chart.config("gauge.arcLength", -75, false);
     			chart.flush(true);
     		}, 12000);
     		setTimeout(function() {
     			chart.config("gauge.arcLength", -100, false);
     			chart.flush(true);
     		}, 14000);
</script>