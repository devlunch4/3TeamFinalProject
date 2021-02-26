<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="card-header with-border">
	<button type="button" class="btn btn-primary"
		onclick="location.href='/user/userRegist'">회원등록</button>
	<div id="keyword" class="card-tools" style="width: 550px;">
		<form id="frm2" >
			<div class="input-group row">
				<!-- sort num -->
				<select class="form-control col-md-3" name=pageSize id="pageSize">
					<option value="" disabled>정렬개수</option>
					<option value="3" <c:if test="${pageSize ==3}"> selected </c:if> >3개씩보기</option>
					<option value="5" <c:if test="${pageSize ==5}"> selected </c:if> >5개씩보기</option>
					<option value="7" <c:if test="${pageSize ==6}"> selected </c:if> >7개씩보기</option>
				</select>
				<!-- search bar -->
				<select class="form-control col-md-3" name="searchType"
					id="searchType" >
					<option value="" disabled>검색구분</option>
					<option value="i" <c:if test="${searchType == '1' }"> selected </c:if> >아이디</option>
					<option value="n" <c:if test="${searchType == 'n' }"> selected </c:if>>이름</option>
					<option value="a" <c:if test="${searchType == 'a' }"> selected </c:if>>별명</option>
				</select> <input class="form-control" type="text" name="keyword"
					placeholder="검색어를 입력하세요." value="${keyword}"> <span
					class="input-group-append">
					<button class="btn btn-primary" type="button" id="searchBtn"
						data-card-widget="search" >
						<i class="fa fa-fw fa-search"></i>
					</button>
				</span>
				<!-- end : search bar -->
			</div>
		</form>
	</div>
</div>
