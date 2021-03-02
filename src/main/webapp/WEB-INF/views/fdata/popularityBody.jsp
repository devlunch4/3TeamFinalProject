<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="row">
<ul>
<c:forEach items="${most}" var="mostList" varStatus="status1" end="4">
		<ui>${mostList}</ui>
</c:forEach>
</ul>
</div>
<ul>
<c:forEach items="${most}" var="mostList" varStatus="status1" begin="5" end="9">
		<ui>${mostList}</ui>
</c:forEach>
</ul>
 <br>
<c:forEach items="${most}" var="mostList" varStatus="status1" begin="10" end="14">
		${mostList}
</c:forEach>
 <br>
 
 
 

<li class="list-group-item" style="font-size: 13px;">
					<ul class="list-group list-group-flush">
						 <li class="list-group-item">데이터명 : 실시간 경락가격(전자경매속보)</li>
					<li class="list-group-item"></li>
					</ul>
					
					<ul class="list-group list-group-flush">
						<li class="list-group-item">제공 : 전국 35개 도매시장 관리사무소(공사)</li>
						<li class="list-group-item"></li>
					</ul>
					
					<dl class="tool">
						<li class="list-group-item">조사방법</li>
						<li class="list-group-item"><span>도매법인별 전자경매결과</span> → <span>관리사무소(공사)</span> → <span>인터넷(경락정보 전송표준) </span> → <span>농정원[농업ON]전송</span></li>
					</dl>
					
					<ul class="list-group list-group-flush">

						<li class="list-group-item">제공주기 : 매일 (실시간)</li>

					</ul>
					<dl class="tool">
						<li class="list-group-item">특이사항</li>
						<li class="list-group-item">품목 분류 체계는 농수산물 표준코드 기준입니다</li>
						<li class="list-group-item">일부 도매시장의 경우 전자경매시스템 및 전송시스템 장애로 인하여 지연될 수 있습니다.</li>
					</dl>
</li>
<br>