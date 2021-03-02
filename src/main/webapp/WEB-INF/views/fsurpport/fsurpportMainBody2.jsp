<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<main>
	
    <div class="container-fluid">
    
        <p>영농일지</p>
        
        <div class="row">
            <div class="col-xl-6">
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-chart-area mr-1"></i>
                        영농일지 조회 메인화면
                    </div>
                    <div class="card-body">
                    	
                    	<!-- 품목 선택 해서 조회하는 부분 -->
                    	<form action="${pageContext.request.contextPath }/fsurpport/searchAllFsurpportList" method="post">
                    		
	                    	<input type="date" name="startDate" value="" >
	                    	<input type="date" name="endDate" value="" >
	                    	<br>
                    		
                    		<label>*품목</label>
                    		<label style="margin-left:30%;" >*작업단계</label>
                    		
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
                    		
                    		<br>
                   			<input type="submit" value="조회	" style="margin-left:20%;" >
                    		
                    	</form>
                    	
                    	<br>
                    	총게시글 : 
                    	<br>
                    	
                    	<table border="1" style="padding: 100px;" >
                    		<tr><th>사진</th><th>일자</th><th>품목</th><th>작업단계</th></tr>
                    		
                    			<c:choose>
                    				
	                    			<c:when test="${farmdiaryList != null }">
	                    				<c:forEach items="${farmdiaryList }" var="farmdiaryList">
	                    					<tr >
			                    				<td><img src="${farmdiaryList.file2 }" ></td>
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
                    	
                    	<br><a href="#"><input type="button" value="등록"></a><br>
                    	
                    	
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
               
