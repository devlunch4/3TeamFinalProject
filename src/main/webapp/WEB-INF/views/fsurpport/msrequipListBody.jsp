<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- <style> -->
<!-- /* table{table-layout : fixed; */ -->
<!-- /* text-overflow: ellipsis; */ -->
<!-- /* white-space: nowrap;  */ -->
<!-- /* } */ -->
<!-- </style> -->
<script type="text/javascript">
$(function(){
var tables = $('#tb').DataTable({
		    "bLengthChange": false, 
		    "ordering": false,
		    "columnDefs" : [ {
				"searchable" : true,
				"targets" : 0
			}, {
				"searchable" : false,
				"targets" : 1
			}, {
				"searchable" : false,
				"targets" : 2
			}, {
				"searchable" : false,
				"targets" : 3
			} ],
			
		}); 
		
	$('.dataTables_filter input[type="search"]').css(
			     {'width':'10em'}
// 				     ,'display':'inline-block'
			  );
		$("#tb_filter").addClass('text-right');

		
$("#choice").change(function(){
	if($("#choice").val()=="msr_code"){
	$('#tb').DataTable({
		bDestroy : true,
	    "bLengthChange": false, 
	    "ordering": false,
	    "columnDefs" : [ {
			"searchable" : true,
			"targets" : 0
		}, {
			"searchable" : false,
			"targets" : 1
		}, {
			"searchable" : false,
			"targets" : 2
		}, {
			"searchable" : false,
			"targets" : 3
		}, ],
	});

	}else if($("#choice").val()=="msr_nm"){
		$('#tb').DataTable({
			bDestroy : true,
		    "bLengthChange": false, 
		    "ordering": false,
		    "columnDefs" : [ {
				"searchable" : false,
				"targets" : 0
			}, {
				"searchable" : true,
				"targets" : 1
			}, {
				"searchable" : false,
				"targets" : 2
			}, {
				"searchable" : false,
				"targets" : 3
			}, ],
		}); 
	}else if($("#choice").val()=="owner"){
		$('#tb').DataTable({
			bDestroy : true,
		    "bLengthChange": false, 
		    "ordering": false,
		    "columnDefs" : [ {
				"searchable" : false,
				"targets" : 0
			}, {
				"searchable" : false,
				"targets" : 1
			}, {
				"searchable" : true,
				"targets" : 2
			}, {
				"searchable" : false,
				"targets" : 3
			}, ],
		}); 
	}
	
	$('.dataTables_filter input[type="search"]').css(
		     {'width':'10em'}
		  );
	$("#tb_filter").addClass('text-right');
});


// $("#choice").change(function(){
// 	if($("#choice").val()=="msr_nm"){
// 	$('#tb').DataTable({
// 		bDestroy : true,
// 	    "bLengthChange": false, 
// 	    "ordering": false,
// 	    "columnDefs" : [ {
// 			"searchable" : false,
// 			"targets" : 0
// 		}, {
// 			"searchable" : true,
// 			"targets" : 1
// 		}, {
// 			"searchable" : false,
// 			"targets" : 2
// 		}, {
// 			"searchable" : false,
// 			"targets" : 3
// 		}, ],
// 	}); 
// 	$('.dataTables_filter input[type="search"]').css(
// 		     {'width':'10em'}
// 		  );
// 	$("#tb_filter").addClass('text-right');
// 	}
	
	
// });

$(".save").on("click",function(){
	
	alert($(this).attr('id'));
	
	idval= $(this).attr('id');
	
	$("#msr_code").val($("#msr_code".concat(idval)).val());
	$("#msr_nm").val($("#msr_nm".concat(idval)).val());
	$("#owner").val($("#owner".concat(idval)).val());
	$("#form").submit();
	
// 	alert($("#msr_code").val());
// 	alert($("#owner").val());
// 	alert($("#msr_nm").val());
});

$("#setBtn").on("click",function(){
	
	$("#msrSet").val($("#setInput").val());
	$("#setForm").submit();
})
});
</script>

<!-- 20210302_KJH 등록한 시설 리스트 -->
<h3 class="mt-4">장비관리</h3>
<div class="card mt-2 px-0">
	<h3 class="card-header">장비관리 :</h3>
	<div class="card-body text-left p-0">
<!-- 		<div class="mt-2 col-sm-2 px-0 float-right"> -->
<%-- 			<a href="${pageContext.request.contextPath}/fsurpport/fmanageInsertPage" class="btn btn-primary p-2 float-right">장비등록</a> --%>
<!-- 		</div> -->
		<div class="table-responsive small p-0">
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
				<div class="form group">
					<div class="col-sm-6 m-0">
						<div class="dataTables_length" id="dataTable_length"></div>
					</div>

					<div class="text-right p-2 mr-1">
						<select class="text-right" id="choice" style="width: 140px;">
							<option value="msr_code">장비코드</option>
							<option value="msr_nm">장비명</option>
							<option value="owner">농장주</option>
						</select>
						<div id="dataTable_filter" class="dataTables_filter"></div>
					</div>
				</div>
				<table class="table table-bordered text-center  p-1" id="tb">
					<thead>
						<tr role="row">
							<th class="p-0 table-active" role="row" aria-controls="dataTable"
								rowspan="1" colspan="1" style="width: 24%">장비코드</th>
							<th class="p-0 table-active" role="row" aria-controls="dataTable"
								rowspan="1" colspan="1" style="width: 35%">장비명</th>
							<th class="p-0 table-active" role="row" aria-controls="dataTable"
								rowspan="1" colspan="1" style="width: 31%">사용자</th>
							<th class="p-0 table-active" role="row" aria-controls="dataTable"
								rowspan="1" colspan="1" style="width: 10%">버튼</th>
						</tr>
					</thead>
					<form
						action="${pageContext.request.contextPath}/fsurpport/msrUpdate"
						method="get" id="form">
						<input type="hidden" name="msr_code" id="msr_code" value="">
						<input type="hidden" name="owner" id="owner" value=""> <input
							type="hidden" name="msr_nm" id="msr_nm" value="">
					</form>
					<tbody>
						<c:forEach items="${msrList}" var="msr" varStatus="sts">
							<tr>
								<c:if test="${S_USER.user_id ne 'admin'}">
									<input type="hidden" id="msr_code${sts.count}"
										value="${msr.msr_code}">
									<input type="hidden" id="owner${sts.count}"
										value="${S_USER.user_id}">
									<td class="p-0" data-placement="top">${msr.msr_code}</td>
									<td class="p-1" data-guidecode="${sts.count}"><input
										type="text" id="msr_nm${sts.count}" value="${msr.msr_nm}"
										class="col-12">
										<div style="display: none;">${msr.msr_nm}</div></td>
									<td class="p-0" data-guidecode="${sts.count}">${msr.owner}</td>
									<td class="p-0"><input class="save btn btn-info btn-sm"
										type="submit" value="저장" id="${sts.count}"></td>
							</tr>
							</c:if>
							<c:if test="${S_USER.user_id eq 'admin'}">
								<input type="hidden" name="msr_code" value="${msr.msr_code}" />
								<tr data-guidecode="${sts.count}">
									<td class="px-0 py-1" data-placement="top">${msr.msr_code}</td>
									<td class="px-0 py-1" data-guidecode="${sts.count}"><input
										class="col-10" type="text" name="msr_nm" value="${msr.msr_nm}">
										<div style="display: none;">${msr.msr_nm}</div></td>
									<td class="px-0 py-1" data-guidecode="${sts.count}"><input
										class="col-10" type="text" name="owner" value="${msr.owner}">
										<div style="display: none;">${msr.owner}</div></td>
									<td class="px-0 py-1"><input
										class="save btn btn-info btn-sm" type="submit" value="저장"
										id="${sts.count}"></td>
								</tr>
							</c:if>

						</c:forEach>

					</tbody>

					<c:if test="${S_USER.user_id ne 'admin'}">
							<tr class="table-active">
								<th class="p-0">등록할 장비코드</th>
								<td class="py-0 pl-3" colspan="2">
								<input class="form-control col-11" type="text" id="setInput" />
								</td>
								<td class="p-0">
								<input class="btn btn-outline-info btn-sm"
									type="button" value="등록" id="setBtn"/></td>
							</tr>
					</c:if>
				</table>
			</div>
			<lable class="text-danger">${check}</lable>
			<form action="${pageContext.request.contextPath}/fsurpport/msrSet"
				method="get" id="setForm">
			<input type="hidden" name="msr_code" id="msrSet"/></td>
			</form>
		</div>
		<!-- 		<div class="mt-2 col-sm-2 px-0 float-right"> -->
<%-- 			<a href="${pageContext.request.contextPath}/fsurpport/fmanageInsertPage" class="btn btn-primary p-2 float-right">장비등록</a> --%>
<!-- 		</div> -->
	</div>
</div>
