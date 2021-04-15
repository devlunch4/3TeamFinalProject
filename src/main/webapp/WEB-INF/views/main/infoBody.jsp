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
	$(function() {
		var offset = $('#gohere').offset();
		$('html').animate({
			scrollTop : offset.top
		}, 300);
	});
</script>

<h3 class="mt-4">웹사이트소개</h3>

<div>
	반갑습니다.
	<br>
	똑똑한 농부들 웹사이트에 접속해주셔서 감사합니다.
	<br>
	본 웹사이트는 농사을 시작하는 분들을 위한 정보 제공을 목적으로 합니다.
	<br>
	제공 하는 주요 서비스로는
	<br>
	영농일지작성, 영농일지작성을 통한 정보 분석, 품목별 시세정보,
	<br>
	똑똑한 농부들을 사용하는 사람들의 영농 품목 분포 확인, 나의 수확량 분석을 제공합니다.
	<br>
	<br>
	추가적으로 저의가 보유한 데이터중 일부 분석 정보를 API로 제공합니다.
	<br>
	<br>
	그외 서비스 사용에 문의사항은 문의 게시판을 이용해주시기 바랍니다.
	<br>
	<br>
	2021.03.31
	<br>
	개발자 : 김강영 김경찬 김준혁 김우성 이예슬
</div>

<div class="form-group pt-4">
	<div class="gohere" id="gohere"></div>
	<!-- spinner -->
</div>
