<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
$(function(){
	$("#json").on("click",function(){
		$("#axml").hide();
		$("#ajson").show();
		$("#selec").show();
	});
	
		$("#xml").on("click",function(){
		$("#ajson").hide();
		$("#axml").show();
		$("#selec").show();
	});
		
		
		$("#all").on("click",function(){
			$("#ajson").text("/finalProject/api/list/all/0/0");
			$("#axml").text("/finalProject/xml/sendxml/all/0/0");
		});
		$("#week").on("click",function(){
			$("#ajson").text("/finalProject/api/list/week/2021-03-21~2022-03-27/0");
			$("#axml").text("/finalProject/xml/sendxml/week/2021-03-21~2022-03-27/0");
		});
		$("#month").on("click",function(){
			$("#ajson").text("/finalProject/api/list/month/2021-01/2021-03");
			$("#axml").text("/finalProject/xml/sendxml/month/2021-01/2021-03");
		});
		$("#year").on("click",function(){
			$("#ajson").text("/finalProject/api/list/year/2020/2022");
			$("#axml").text("/finalProject/xml/sendxml/year/2020/2022");
		});
});
</script>
<!-- 인기 농작물 페이지 -->
<!-- 20210308_KJH 인기 농작물 수정 -->
<h1 class="my-4">API 제공</h1>
<div class="card mt-2 col-sm-12 px-0">

	<div class="card-body text-center px-2">
		<div class="form-group row mb-0">
			<div class="form-row col-12 p-1">
			<div class="col-sm-12 p-0">
				<input type="button" class="btn btn-outline-dark col-5" value="json" id="json"> 
				<input type="button" class="btn btn-outline-dark col-5" value="xml" id="xml">
				</div>
			</div>
			
			<div class="form-row col-12 p-1" id="selec" style="display: none;">
				<div class="col-sm-12 p-0">
					<div class="form-group row text-center m-0 small">
<!-- 					<div clas="text-center"> -->
						<button id="all" class="btn btn-outline-dark col m-1 small">전체</button>
						<button id="week" class="btn btn-outline-dark col m-1 small">주별</button>
						<button id="month" class="btn btn-outline-dark col m-1 samll">월별</button>
						<button id="year" class="btn btn-outline-dark col m-1 small">년별</button>
<!-- 						</div> -->
					</div>
				</div>
			</div>
			<div class="form-row col-12 text-center">
			
				<div class="col-sm-12 p-0"><a id="ajson" style="display: none;">/finalProject/api/list/{selec}/{sdate}/{edate}</a>
					<a id="axml" style="display: none;">/finalProject/xml/sendxml/{selec}/{sdate}/{edate}</a>
				</div>
			</div>
			<br>
		</div>
		<hr>
		<div class="form-group pl-1 text-left small">
			<dl class="name">
				<dt>데이터명</dt>
				<dd>기간별 품목 비율(전자경매속보)</dd>
			</dl>
			<dl class="source">
				<dt>제공</dt>
				<dd>똑똑한 농부들</dd>
			</dl>
			<dl class="tool">
				<dt>조사방법</dt>
				<dd>
					<span>전체 영농일지로부터 얻은 재배정보</span>
				</dd>
			</dl>
			<dl class="time">
				<dt>제공주기</dt>
				<dd>매일 (실시간)</dd>
			</dl>
			<dl class="caution">
				<dt>요청값</dt>
				<dd>응답형식(json,xml)</dd>
				<dd>날짜범위:selec</dd>
				<dd>시작날짜:sdate</dd>
				<dd>마지막날짜:edate</dd>
			</dl>
			
			<dl class="caution">
				<dt>응답값</dt>
				<dd>content:작물명</dd>
				<dd>yield:재배중인 농가 수</dd>
			</dl>
			
			<dl class="caution">
				<dt>참고사항</dt>
				<dd>날짜 형식별 입력되는 양식</dd>
				<dd>전체: 날짜선택 없음</dd>
				<dd>주별: 주 단위 선택</dd>
				<dd>월별: 월단위 날짜범위 지정</dd>
				<dd>연별: 연단위 날짜범위 지정</dd>
			</dl>
		</div>
	</div>
</div>