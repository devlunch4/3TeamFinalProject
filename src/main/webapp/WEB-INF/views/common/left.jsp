<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="sb-sidenav accordion sb-sidenav-light" id="sidenavAccordion">
    <div class="sb-sidenav-menu">
        <div class="nav">
        
        
            <div class="sb-sidenav-menu-heading">test</div>
            
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                농업데이터
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="${pageContext.request.contextPath}/user/main">시세분석</a>
                    <a class="nav-link" href="${pageContext.request.contextPath}/fdata/ratio">품목별 비율</a>
                    <a class="nav-link" href="${pageContext.request.contextPath}/fdata/popularity">인기농작물</a>
                </nav>
            </div>
            
            
            
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts2" aria-expanded="false" aria-controls="collapseLayouts">
                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                농업정보
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseLayouts2" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="${pageContext.request.contextPath}/finfo/gardenguides">텃밭가이드</a>
                    <a class="nav-link" href="layout-sidenav-light.html">제철작물</a>
                    <a class="nav-link" href="${pageContext.request.contextPath}/finfo/raceInfosView">품종정보</a>
                    <a class="nav-link" href="${pageContext.request.contextPath}/finfo/weeklyFarmInfosView">주간 농사정보</a>
                    <a class="nav-link" href="${pageContext.request.contextPath}/finfo/itemFarmManualsView">품목별 영농매뉴얼</a>
                </nav>
            </div>
           
           
           
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                농업지원
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="${pageContext.request.contextPath }/fsurpport/main?user_id=${S_USER.user_id}">영농일지</a>
                    <a class="nav-link" href="${pageContext.request.contextPath }/fsurpport/fmanageList">시설관리</a>
                </nav>
                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                        내 정보분석
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="${pageContext.request.contextPath }/fanalysis/myfanalysisInfo">내 시설 관측</a>
                            <a class="nav-link" href="register.html">수확량 분석</a>
                            <a class="nav-link" href="${pageContext.request.contextPath }/fanalysis/mymaxmsrrecList">내 시설 실시간 관측</a>
                        </nav>
                    </div>
                </nav>
            </div>
            <div class="sb-sidenav-menu-heading">test</div>
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts3" aria-expanded="false" aria-controls="collapseLayouts">
                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                커뮤니티
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseLayouts3" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="${pageContext.request.contextPath }/fcommunity/qnaView">문의사항</a>
                    <a class="nav-link" href="${pageContext.request.contextPath }/fcommunity/noticesView">공지사항</a>
                    <a class="nav-link" href="${pageContext.request.contextPath }/fcommunity/minimarketView">미니장터</a>
                </nav>
            </div>
           
        </div>
    </div>
</nav>	