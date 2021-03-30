<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="sb-sidenav accordion sb-sidenav-light" id="sidenavAccordion">

	<div class="sb-sidenav-menu">
		<div class="nav">
			<!-- 채팅 -->
			<%-- <c:choose>
				<c:when test="${S_USER ne null }">
					<a class="nav-link" href="${pageContext.request.contextPath}/fcommunity/chatting">
						<div class="sb-nav-link-icon">
							<i class="fas fa-users-cog fa-fw"></i>
						</div> 채팅
					</a>
				</c:when>
				<c:otherwise></c:otherwise> 
			</c:choose> --%>
			<!-- 관리자 로그인시 확인 -->
			<c:choose>
				<c:when test="${S_USER.getUser_id() eq 'admin' }">
					<div class="sb-sidenav-menu-heading pb-0">관리자</div>
					<a class="nav-link" href="${pageContext.request.contextPath}/user/allUser">
						<div class="sb-nav-link-icon">
							<i class="fas fa-users-cog fa-fw"></i>
						</div>
						회원관리
					</a>
					<a class="nav-link" href="${pageContext.request.contextPath}/user/codesView">
						<div class="sb-nav-link-icon">
							<i class="fas fa-users-cog fa-fw"></i>
						</div>
						코드관리
					</a>
				</c:when>
				<c:otherwise></c:otherwise>
			</c:choose>


			<!--똑똑한영농시작 부분 -->
			<div class="sb-sidenav-menu-heading pb-0">똑똑한 영농의 시작</div>
			<c:if test="${!empty S_USER}"></c:if>
			<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts1" aria-expanded="false" aria-controls="collapseLayouts1">
				<div class="sb-nav-link-icon">
					<i class="fas fa-tractor fa-fw"> </i>
				</div>
				똑똑한 영농
				<div class="sb-sidenav-collapse-arrow">
					<i class="fas fa-angle-down"></i>
				</div>
			</a>
			<div class="collapse" id="collapseLayouts1" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
				<nav class="sb-sidenav-menu-nested nav">
					<a class="nav-link" href="${pageContext.request.contextPath}/fsurpport/main?user_id=${S_USER.user_id}">
						영농일지<i class="far fa-edit ml-2"></i>
					</a>
					<a class="nav-link" href="${pageContext.request.contextPath }/fsurpport/fmanageList">
						시설관리<i class="fas fa-tools ml-2"></i>
					</a>
					<a class="nav-link" href="${pageContext.request.contextPath }/fsurpport/msrequipList">
						장비관리<i class="fas fa-tools ml-2"></i>
					</a>
				</nav>
			</div>
			<!--  -->
			<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts2" aria-expanded="false" aria-controls="collapseLayouts2">
				<div class="sb-nav-link-icon">
					<i class="fas fa-microscope fa-fw"></i>
				</div>
				내 정보분석
				<div class="sb-sidenav-collapse-arrow">
					<i class="fas fa-angle-down"></i>
				</div>
			</a>
			<div class="collapse" id="collapseLayouts2" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
				<nav class="sb-sidenav-menu-nested nav">
					<a class="nav-link" href="${pageContext.request.contextPath }/fanalysis/myfanalysisInfo">
						측정 기록<i class="fas fa-binoculars ml-2 fa-fw"></i>
					</a>
					<a class="nav-link" href="${pageContext.request.contextPath }/fsurpport/myYield">
						수확량 분석<i class="fas fa-chart-pie ml-2"></i>
					</a>
					<a class="nav-link" href="${pageContext.request.contextPath }/fanalysis/mymaxmsrrecList">
						실시간 측정<i class="fas fa-binoculars ml-2"></i>
					</a>
				</nav>
			</div>
			<a class="nav-link collapsed" href="${pageContext.request.contextPath }/fcommunity/miniMarketView">
				<div class="sb-nav-link-icon">
					<i class="fas fa-store"></i>
				</div>
				똑똑한 장터
				<!-- 				<div class="sb-sidenav-collapse-arrow">
					<i class="fas fa-angle-down"></i>
				</div> -->
			</a>
			<!--똑똑한영농시작 부분 끝-->



			<div class="sb-sidenav-menu-heading pb-0">똑똑한 영농 정보</div>
			<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts3" aria-expanded="false" aria-controls="collapseLayouts3">
				<div class="sb-nav-link-icon">
					<i class="fas fa-chart-bar fa-fw"></i>
				</div>
				농업데이터
				<div class="sb-sidenav-collapse-arrow">
					<i class="fas fa-angle-down"></i>
				</div>
			</a>
			<div class="collapse" id="collapseLayouts3" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
				<nav class="sb-sidenav-menu-nested nav">
					<a class="nav-link" href="${pageContext.request.contextPath}/user/main">
						시세분석<i class="fas fa-won-sign ml-2"></i>
					</a>
					<a class="nav-link" href="${pageContext.request.contextPath}/fdata/ratio">
						품목별 비율<i class="fas fa-balance-scale-right ml-2"></i>
					</a>
					<a class="nav-link" href="${pageContext.request.contextPath}/fdata/popularity">
						인기농작물<i class="far fa-thumbs-up ml-2"></i>
					</a>
				</nav>
			</div>


			<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts4" aria-expanded="false" aria-controls="collapseLayouts4">
				<div class="sb-nav-link-icon">
					<i class="fas fa-info-circle fa-fw"></i>
				</div>
				농업정보
				<div class="sb-sidenav-collapse-arrow">
					<i class="fas fa-angle-down"></i>
				</div>
			</a>
			<div class="collapse" id="collapseLayouts4" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
				<nav class="sb-sidenav-menu-nested nav">
					<a class="nav-link" href="${pageContext.request.contextPath}/finfo/gardenguides">
						텃밭가이드<i class="fas fa-book-open ml-2"></i>
					</a>
					<a class="nav-link" href="${pageContext.request.contextPath}/finfo/seasonInfos">
						제철작물 <i class="fas fa-tree ml-2"></i>
					</a>
					<%-- <a class="nav-link" href="${pageContext.request.contextPath}/finfo/raceInfosView">품종정보</a> --%>
					<a class="nav-link" href="${pageContext.request.contextPath}/finfo/weeklyFarmInfosView">
						주간 농사정보 <i class="fas fa-calendar-week ml-2"></i>
					</a>
					<a class="nav-link" href="${pageContext.request.contextPath}/finfo/itemFarmManualsView">
						품목별 매뉴얼 <i class="fas fa-book ml-2"></i>
					</a>
				</nav>
			</div>

			<div class="sb-sidenav-menu-heading pb-0">고객지원</div>
			<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts5" aria-expanded="false" aria-controls="collapseLayouts5">
				<div class="sb-nav-link-icon">
					<i class="fas fa-handshake fa-fw"></i>
				</div>
				공지/문의
				<div class="sb-sidenav-collapse-arrow">
					<i class="fas fa-angle-down"></i>
				</div>
			</a>
			<div class="collapse" id="collapseLayouts5" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
				<nav class="sb-sidenav-menu-nested nav">
					<a class="nav-link" href="${pageContext.request.contextPath }/fnotice/noticesView">
						공지게시판 <i class="far fa-flag ml-2"></i>
					</a>
					<a class="nav-link" href="${pageContext.request.contextPath }/qna/view">
						문의게시판 <i class="far fa-question-circle ml-2"></i>
					</a>
				</nav>
			</div>
		</div>
	</div>
</nav>

