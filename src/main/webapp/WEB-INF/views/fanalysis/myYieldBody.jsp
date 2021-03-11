<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


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

<!-- ǰ�� ���� ��� ������ -->
<!-- 20210302_KJH main �߰� -->
<h4 class="mt-2">��Ȯ�� �м�</h4>
<div class="card mt-2 col-sm-12 px-0">
	<h5 class="card-header">�ѰԽñ� :</h5>
		<!-- 20210311_KJH �� ��Ȯ�� ��ȸ-->
	<form action="${pageContext.request.contextPath}/fsurpport/myYield" id="selec">
		<input type="hidden" id="selctype" name = "selec" value="week">
		<input type="hidden" id="sval" name="sdate">
		<input type="hidden" id="eval" name="edate">
	</form>


	<div class="input-group">
		<button id="all" class="col-6">��ü</button>
		<button id="week" class="col-6">�ֺ�</button>
		<button id="month" class="col-6">����</button>
		<button id="year" class="col-6">�⺰</button>
	</div>
	<c:set var="now" value="<%=new java.util.Date()%>" />
	<c:set var="sysd">
		<fmt:formatDate value="${now}" pattern="yyyy-'01'" />
	</c:set>
	<c:set var="now2" value="<%=new java.util.Date()%>" />
	<c:set var="sysd2">
		<fmt:formatDate value="${now2}" pattern="yyyy-MM" />
	</c:set>
	<div class="input-group">
		<input type="text" id="week-picker" value="�Է�ĭ�� Ŭ���Ͽ� �� ����" name="week" class="col-12  text-center"> 
		<input type="text" id="smonth-picker" value="${sysd}" name="smonth-picker" style="display: none;" class="col-6"> 
		<input type="text" id="emonth-picker" value="${sysd2}" name="emonth-picker" style="display: none;" class="col-6"> 
		<input type="text" id="syear-picker" name="syear" style="display: none;" class="col-6"> 
		<input type="text" id="eyear-picker" name="eyear" style="display: none;" class="col-6">
	</div>

	
	<div class="form-group text-center">
		<button id="sel" class="col-4">��ȸ�ϱ�</button>
	</div>
	
	<div class="align-center px-0">
		<div class="container px-0">
			<div class="col-12">
				<h4 class="mt-2 text-center">ǰ�� ����</h4>
				<div id="multilineLabel"></div>

			</div>
				<c:if test="${fn:length(farmCount) == 0}">
				<div class="col-12 text-center">�˻��� ��谡 �����ϴ�.</div>
				</c:if>
		</div>
	</div>
</div>

<script>
$(function() {
	
    $.datepicker.setDefaults({
        dateFormat: 'yy-mm-dd',
        prevText: '���� ��',
        nextText: '���� ��',
//         changeMonth: true, // ���� �ٲܼ� �ִ� ����Ʈ �ڽ��� ǥ���Ѵ�.
        changeYear: true, // ���� �ٲ� �� �ִ� ����Ʈ �ڽ��� ǥ���Ѵ�.
        monthNames: ['1��', '2��', '3��', '4��', '5��', '6��', '7��', '8��', '9��', '10��', '11��', '12��'],
        monthNamesShort: ['1��', '2��', '3��', '4��', '5��', '6��', '7��', '8��', '9��', '10��', '11��', '12��'],
        dayNames: ['��', '��', 'ȭ', '��', '��', '��', '��'],
        dayNamesShort: ['��', '��', 'ȭ', '��', '��', '��', '��'],
        dayNamesMin: ['��', '��', 'ȭ', '��', '��', '��', '��'],
        showMonthAfterYear: true,
        yearSuffix: '��'
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
            pattern: 'yyyy-mm'       // input�±׿� ǥ�õ� ����
           ,monthNames: ['1��', '2��', '3��', '4��', '5��', '6��', '7��', '8��', '9��', '10��', '11��', '12��']         // ȭ�鿡 ������ ���̸�
           ,openOnFocus: true       // focus�ÿ� �޷��� ������ ����
           ,disableMonths : [ ]     // �� ��Ȱ��ȭ
        };
    
    $("#smonth-picker").monthpicker(soptions,'-1M');
    
    var eoptions = {
            pattern: 'yyyy-mm'       // input�±׿� ǥ�õ� ����
           ,monthNames: ['1��', '2��', '3��', '4��', '5��', '6��', '7��', '8��', '9��', '10��', '11��', '12��']         // ȭ�鿡 ������ ���̸�
           ,openOnFocus: true       // focus�ÿ� �޷��� ������ ����
           ,disableMonths : [ ]     // �� ��Ȱ��ȭ
        };
    
    $("#emonth-picker").monthpicker(eoptions);
    
    $("#syear-picker").datepicker({
        dateFormat: 'yy' //Input Display Format ����
        ,showOtherMonths: true //�� ������ ������� �յڿ��� ��¥�� ǥ��
        ,showMonthAfterYear:true //�⵵ ���� ������, �ڿ� �� ǥ��
        ,changeYear: true //�޺��ڽ����� �� ���� ����          
        ,yearSuffix: "��" //�޷��� �⵵ �κ� �ڿ� �ٴ� �ؽ�Ʈ
        ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //�޷��� �� �κ� �ؽ�Ʈ
        ,monthNames: ['1��','2��','3��','4��','5��','6��','7��','8��','9��','10��','11��','12��'] //�޷��� �� �κ� Tooltip �ؽ�Ʈ
        ,dayNamesMin: ['��','��','ȭ','��','��','��','��'] //�޷��� ���� �κ� �ؽ�Ʈ
        ,dayNames: ['�Ͽ���','������','ȭ����','������','�����','�ݿ���','�����'] //�޷��� ���� �κ� Tooltip �ؽ�Ʈ
        ,minDate: "-10Y" //�ּ� ��������(-1D:�Ϸ���, -1M:�Ѵ���, -1Y:�ϳ���)
        ,maxDate: "+0M" //�ִ� ��������(+1D:�Ϸ���, -1M:�Ѵ���, -1Y:�ϳ���)                
    });                    
    
    //�ʱⰪ�� ���� ��¥�� ����
    $('#syear-picker').datepicker('setDate', '-1Y'); //(-1D:�Ϸ���, -1M:�Ѵ���, -1Y:�ϳ���), (+1D:�Ϸ���, -1M:�Ѵ���, -1Y:�ϳ���)            

    
    $("#eyear-picker").datepicker({
        dateFormat: 'yy' //Input Display Format ����
        ,showOtherMonths: true //�� ������ ������� �յڿ��� ��¥�� ǥ��
        ,showMonthAfterYear:true //�⵵ ���� ������, �ڿ� �� ǥ��
        ,changeYear: true //�޺��ڽ����� �� ���� ����          
        ,yearSuffix: "��" //�޷��� �⵵ �κ� �ڿ� �ٴ� �ؽ�Ʈ
        ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //�޷��� �� �κ� �ؽ�Ʈ
        ,monthNames: ['1��','2��','3��','4��','5��','6��','7��','8��','9��','10��','11��','12��'] //�޷��� �� �κ� Tooltip �ؽ�Ʈ
        ,dayNamesMin: ['��','��','ȭ','��','��','��','��'] //�޷��� ���� �κ� �ؽ�Ʈ
        ,dayNames: ['�Ͽ���','������','ȭ����','������','�����','�ݿ���','�����'] //�޷��� ���� �κ� Tooltip �ؽ�Ʈ
        ,minDate: "-10Y" //�ּ� ��������(-1D:�Ϸ���, -1M:�Ѵ���, -1Y:�ϳ���)
        ,maxDate: "+0M" //�ִ� ��������(+1D:�Ϸ���, -1M:�Ѵ���, -1Y:�ϳ���)                
    });                    
    
    //�ʱⰪ�� ���� ��¥�� ����
    $('#eyear-picker').datepicker('setDate', 'today'); //(-1D:�Ϸ���, -1M:�Ѵ���, -1Y:�ϳ���), (+1D:�Ϸ���, -1M:�Ѵ���, -1Y:�ϳ���)            

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
});	
	$("#month").on("click",function(){
		$("#selctype").val("month");
		$("#week-picker").hide();
		$("#smonth-picker").show();
		$("#emonth-picker").show();
		$("#syear-picker").hide();
		$("#eyear-picker").hide();
});
	$("#year").on("click",function(){
		$("#selctype").val("year");
		$("#week-picker").hide();
		$("#smonth-picker").hide();
		$("#emonth-picker").hide();
		$("#syear-picker").show();
		$("#eyear-picker").show();
});

	$("#sel").on("click",function(){
		
		if($("#selctype").val() == "week"){
			if($("#week-picker").val() =="Ŭ���Ͽ� �� ����"){
				alert("�ָ� �����ؾ��մϴ�.");
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
		
		$("#selec").submit();
	});
	
	$("#all").on("click",function(){
		$("#selctype").val("all")
		$("#selec").submit();
	});


//      	var chart = bb.generate({
//      		  data: {
//      		    columns: [
//      		    	<c:forEach items="${farmCount}" var="fcount">
//      		     	['${fcount.content}',${fcount.yield}],
//      		     	</c:forEach>
//      		    ],
//      		    type: "donut",
//      		  },
//      		  donut: {
//      		    label: {
//      		      format: function(value, ratio, id) {		return value       }/*+"\nHours";*/
//      		    }
//      		  },
//      		  bindto: "#multilineLabel"
//      		});
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
     		    min: 1,
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