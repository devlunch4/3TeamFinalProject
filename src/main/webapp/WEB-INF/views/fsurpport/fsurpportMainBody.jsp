<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<main>
	<div class="container-fluid">
		<h3 class="mt-4">영농일지</h3>
		<button type="button" class=" btn btn-success " onclick="location.href='${pageContext.request.contextPath}/fsurpport/insertView'" class=" btn btn-outline-dark m-1">영농일지 등록</button>
		
		<button type="button" class=" btn btn-success " onclick="location.href='${pageContext.request.contextPath}/fsurpport/infoView'" class=" btn btn-outline-dark m-1">영농일지 임시 조회</button>
		<div class="row">
		
			<div class="card mt-2 col-sm-12">
				<!-- 품목 선택 해서 조회하는 부분 -->
                <form action="${pageContext.request.contextPath }/fsurpport/searchAllFsurpportList" method="post">
                    	
					<div class="card-body text-left p-1">
						<span class="">가나다순</span> <br>
						
						<input type="date" name="startDate" value="" class=" btn btn-outline-dark m-1" >
	                    <input type="date" name="endDate" value="" class=" btn btn-outline-dark m-1" >
						
					</div>
					<div class="card-body text-left p-1">
						<label>*품목</label>
                    	<label style="margin-left:10%;" >*작업단계</label>
                    	<br>
                    		
                    	<select name="item_code">
                    		<option  value="">전체</option>
                    		<c:forEach items="${itemsList }" var="itemsList">
                    			<option  value="${itemsList.item_code }">${itemsList.item_nm }</option>
                    		</c:forEach>
                    	</select>
                    	
                    		
                    	<select name="wstep_code" style="margin-left:10%;" >
                    		<option value="">전체</option>
                    		<c:forEach items="${workstepsList }" var="workstepsList">
                    			<option  value="${workstepsList.wstep_code }">${workstepsList.wstep_nm }</option>
                    		</c:forEach>
                    	</select>
					</div>
					
                   	<input type="submit" value="조회	" style="margin-left:20%;" >
					
				</form>
			</div>

			<!-- 설명 시작 -->
			<br>
			<div class="card mt-2 col-sm-12 px-0">
				<h3 class="card-header">총게시글 :</h3>
				<div class="card-body text-left ">
					<div class="">
						<div class="row">
							<div class="imgwrap">
								<img src="/images/upload/farm_guide_info/144609103235500023.jpg"
									alt="144609103235500023.jpg"
								>
							</div>

							<table border="1" style="padding: 100px;" class="table table-bordered col-sx-12" >
                    		<tr><th>사진</th><th>일자</th><th>품목</th><th>작업단계</th></tr>
                    		
                    			<c:choose>
                    				
	                    			<c:when test="${farmdiaryList != null }">
	                    				<c:forEach items="${farmdiaryList }" var="farmdiaryList">
	                    					<tr >
			                    				<td><img src="#" ></td>
			                    				<td><fmt:formatDate value="${farmdiaryList.reg_dt }" pattern="yyyy.MM.dd" /></td>
			                    				<td>${farmdiaryList.item_code }</td>
			                    				<td>${farmdiaryList.wstep_code }</td>
	                    					</tr>
		                    			</c:forEach>
		                    		</c:when>
		                    		
		                    		<c:otherwise>
		                    			<tr><td>1</td><td>1</td><td>1</td><td>1</td></tr>
		                    		</c:otherwise>
                    			</c:choose>
	                    	
                    	</table>
							
							<!-- 페이징 번호 부분 -->
							<ul class="pagination justify-content-center m-0">
								<li class="page-item"><a class="page-link"
									href="${pageContext.request.contextPath}/fsurpport/main?page=1&pageSize=${pageVo.pageSize}"><i
										class="fas fa-angle-double-left"></i></a></li>
								<c:choose>
									<c:when test="${pageVo.page > 1 }">
										<li class="page-item"><a class="page-link"
											href="${pageContext.request.contextPath}/fsurpport/main?page=${pageVo.page-1 }&pageSize=${pageVo.pageSize}"><i
												class="fas fa-angle-left"></i></a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link" href="#"><i
												class="fas fa-angle-left"></i></a></li>
									</c:otherwise>

								</c:choose>
								<%-- 번호 시작 --%>
								<c:choose>

									<c:when test="${pagination > 0 }">
										<c:forEach begin="1" end="${pagination }" var="i">
											<c:choose>
												<c:when test="${pageVo.page == i }">
													<li class="page-item active"><a class="page-link"
														href="#">${i }</a></li>
												</c:when>
												<c:otherwise>
													<li><a class="page-link"
														href="${pageContext.request.contextPath}/fsurpport/main?page=${i }&pageSize=${pageVo.pageSize}">${i }</a></li>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</c:when>

									<c:otherwise>
										<li class="page-item active"><a class="page-link"
											href="#">1</a></li>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${pageVo.page == pagination}">
										<li class="page-item"><a class="page-link"
											href="${pageContext.request.contextPath}/fsurpport/main?page=${pagination }&pageSize=${pageVo.pageSize}"><i
												class="fas fa-angle-right"></i></a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="${pageContext.request.contextPath}/fsurpport/main?page=${pageVo.page+1 }&pageSize=${pageVo.pageSize}"><i
												class="fas fa-angle-right"></i></a></li>
									</c:otherwise>
								</c:choose>

								<li class="page-item"><a class="page-link"
									href="${pageContext.request.contextPath}/fsurpport/main?page=${pagination }&pageSize=${pageVo.pageSize}"><i
										class="fas fa-angle-double-right"></i></a></li>

							</ul>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>
<footer class="py-4 bg-light mt-auto">
	<div class="container-fluid">
		<div class="d-flex align-items-center justify-content-between small">
			<div class="text-muted">Copyright &copy; Your Website 2020</div>
			<div>
				<a href="#">Privacy Policy</a>
				&middot;
				<a href="#">Terms &amp; Conditions</a>
			</div>
		</div>
	</div>
</footer>