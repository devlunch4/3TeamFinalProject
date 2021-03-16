<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<style>
/* body { */
/* 	background-color: #f2f2f2 */
/* } */

/* main { */
/* 	margin-bottom: 200% */
/* } */

/* .floating-menu { */
/* 	border-radius: 100px; */
/* 	z-index: 999; */
/* 	padding-top: 10px; */
/* 	padding-bottom: 10px; */
/* 	right: 0; */
/* 	position: fixed; */
/* 	display: inline-block; */
/* 	top: 50%; */
/* 	-webkit-transform: translateY(-50%); */
/* 	-ms-transform: translateY(-50%); */
/* 	transform: translateY(-50%) */
/* } */

/* .main-menu { */
/* 	margin: 0; */
/* 	padding-left: 0; */
/* 	list-style: none */
/* } */

/* .main-menu li a { */
/* 	display: block; */
/* 	padding: 20px; */
/* 	color: #fff; */
/* 	border-radius: 50px; */
/* 	position: relative; */
/* 	-webkit-transition: none; */
/* 	-o-transition: none; */
/* 	transition: none */
/* } */

/* .main-menu li a:hover { */
/* 	background: rgba(244, 244, 244, .3) */
/* } */

/* .menu-bg { */
/* 	background-image: -webkit-linear-gradient(top, #1C5E91 0, #167699 100%); */
/* 	background-image: -o-linear-gradient(top, #1C5E91 0, #167699 100%); */
/* 	background-image: -webkit-gradient(linear, left top, left bottom, from(#1C5E91), */
/* 		to(#167699)); */
/* 	background-image: linear-gradient(to bottom, #1C5E91 0, #167699 100%); */
/* 	background-repeat: repeat-x; */
/* 	position: absolute; */
/* 	width: 100%; */
/* 	height: 100%; */
/* 	border-radius: 50px; */
/* 	z-index: -1; */
/* 	top: 0; */
/* 	left: 0; */
/* 	-webkit-transition: .1s; */
/* 	-o-transition: .1s; */
/* 	transition: .1s */
/* } */

/* .ripple { */
/* 	position: relative; */
/* 	overflow: hidden; */
/* 	transform: translate3d(0, 0, 0) */
/* } */

/* .ripple:after { */
/* 	content: ""; */
/* 	display: block; */
/* 	position: absolute; */
/* 	width: 100%; */
/* 	height: 100%; */
/* 	top: 0; */
/* 	left: 0; */
/* 	pointer-events: none; */
/* 	background-image: radial-gradient(circle, #000 10%, transparent 10.01%); */
/* 	background-repeat: no-repeat; */
/* 	background-position: 50%; */
/* 	transform: scale(10, 10); */
/* 	opacity: 0; */
/* 	transition: transform .5s, opacity 1s */
/* } */

/* .ripple:active:after { */
/* 	transform: scale(0, 0); */
/* 	opacity: .2; */
/* 	transition: 0s */
/* } */
</style>
<script>



	//20210304_KJH 5초마다 새로고침
// 	$(function() {
// 		setTimeout('location.reload()', 10000);
// 		$("#formbtn").on("click",function(){
			
// 			if($("#chform").css("display") == 'none'){
// 				$("#chform").show();
// 				$("#save").show();
// 		}else{
// 			$("#chform").hide();
// 			$("#save").hide();
// 		}
// 		});


// 	setInterval(function() {
        
//         $.ajax({
//             type: "POST",
//             url: "${pageContext.request.contextPath}/fsurpport/fmanageInfo",
//             data: { "manage_no" : ${fmanage.manage_no},
//                 	"history_no" : ${fmanage.history_no},
//                 	dataType:"text",
//             success: function(data) {
//             	 $('#output').val(data);
//             }, error: function() {

//             }
//         } 
//         });
// 	}, 5000);

	
	function goBack() {
	    window.history.back();
	}
$(function(){
setInterval(function() {
    $.ajax({
        // type을 설정합니다.
        type : 'POST',
        url : "${pageContext.request.contextPath}/fsurpport/fmanageInfo",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"manage_no" : '${fmanage.manage_no}'},
//         dataType : "json",
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (data) {
        	$('#tb').html(data);
        }
    });
}, 5000);
});

// setInterval(function(){

// 	$.ajax({
// 	    url: "${pageContext.request.contextPath}/fsurpport/fmanageInfo",
// 	    method: 'GET',
// 	    async : true,
// 	    data : {"manage_no" : '${fmanage.manage_no}'},
// 	    dataType : 'html',
// 	    success : function (res) {
// 	        // 서번단에서 HTML을 반환해서 기존 페이지를 깜빡임없이 새로 고친다.
// 	        document.querySelector("#layoutSidenav_content").innerHTML = res;
// // 	        var id = data;
// // 	        window.opener.location.reload();
// 	    },
// 	    error: function (xhr) {
// 	        alert("fail");
// 	    }
// 	});

// 		},10000);

</script>
<script>
// $(document).ready(function(){
//     $(function () {
//         $('#homeup').click(function () {
//             $('body,html').animate({
//                 scrollTop: 0
//             }, 800);
//             return false;
//         });
// var scrollHeight = $(document).height();
//         $('#homedown').click(function () {
//             $('body,html').animate({
//                 scrollTop: scrollHeight
//             }, 800);
//             return false;
//         });
//     });
  
// });
</script>
<!-- 20210302_KJH 시설정보 조회 -->
<h3 class="mt-4">시설관리</h3>
<!-- <nav class="floating-menu"> -->
<!-- 	<ul class="main-menu"> -->
<!-- 		<li><a href="#homeup" class="ripple" id="homeup"><label>↑</label></i> -->
<!-- 		</a></li> -->
<!-- 		<li><a href="homedown" class="ripple" id="homedown"><label>↓</label></i> -->
<!-- 		</a></li> -->
<!-- 	</ul> -->
<!-- 	<div class="menu-bg"></div> -->
<!-- </nav> -->
<div class="card mt-2 col-sm-12 px-0">
	<h3 class="card-header">총게시글 :</h3>
	<div class="card-body text-left ">
		<div class="">
			<input type="button" class="btn_list" value="목록으로" onclick="goBack()">
			<div class="row" id="info">
				<table class="table table-bordered col-sx-12" style="text-align: center;" id="tb">
					<tr>
						<td style="width: 50%;">게시글 번호:${fmanage.manage_no}</td>
						<td style="width: 50%;">소유자 이름:${fmanage.owner}</td>
					</tr>
					<tr>
						<td style="width: 50%;">작물명:${fmanage.item_code}</td>
						<td style="width: 50%;">위치:${fmanage.location}</td>
					</tr>
					<tr>
						<!--20210308_KJH 장비명을 use_yn으로 받고있음 -->
						<td style="width: 50%;">장비명:${fmanage.use_yn}</td>
						<td style="width: 50%;" id="temp">온도:${msrrec.msr_temp}</td>
					<tr>

						<td style="width: 50%;">습도:${msrrec.msr_humid}</td>
						<td style="width: 50%;">조도:${msrrec.msr_bright}</td>
					</tr>
					<tr>
						<td colspan="2">${fmanage.info}</td>
					</tr>
				</table>
			</div>
			<form style="display: none;">
				<select>
					<option>ok</option>
				</select>
			</form>
		</div>
	</div>
	<div class="card-body text-right pt-0">
		<button type="button" class="btn btn-info  col-md-1 my-1 " id="formbtn">장비변경</button>
		<button type="button" class="btn btn-warning  col-md-1 my-1 " onclick="location.href = '${pageContext.request.contextPath }/fsurpport/fmanageUpdate?manage_no=${fmanage.manage_no}'">수정</button>
		<button type="button" class="btn btn-danger  col-md-1 my-1 " onclick="location.href = '${pageContext.request.contextPath }/fsurpport/fmanageDelete?manage_no=${fmanage.manage_no}&msr_code=${fmanage.use_yn}'">삭제</button>



		<form action="${pageContext.request.contextPath }/fsurpport/msrequipChange">
			<select id="chform" name="msr_code" style="display: none;">
				<option>장비없음</option>
				<c:forEach items="${okList}" var="ok">
					<option value="${ok.msr_code}">${ok.msr_nm}</option>
				</c:forEach>
			</select> <input type="hidden" name="manage_no" value="${fmanage.manage_no}" />
			<button type="submit" style="display: none;" id="save">저장</button>
		</form>
	</div>

</div>
</div>