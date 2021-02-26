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
                    	<form action="#" method="post">
                    		
	                    	<input type="date" name="">
	                    	<input type="date" name="">
	                    	<br>
                    		
                    		<label>*품목</label>
                    		<label>*작업단계</label>
                    		
                    		<br>
                    		
                    		<select>
                    			<option>전체</option>
                    		</select>
                    		
                    		<select>
                    			<option>전체</option>
                    		</select>
                    		
                    		<br>
                    		총게시글 : 
                    		<br>
                    		
                   			<input type="submit" value="조회	" style="margin-left:40%;" >
                    		
                    		
                    	</form>
                    	
                    	<table border="1" style="padding: 100px;" >
                    		<tr><th>사진</th><th>일자</th><th>품목</th><th>작업단계</th></tr>
                    		
                    		<tr>
                    			<c:choose>
	                    			<c:when test="${ fsupportList != null }">
	                    				<td><img src="" ></td>
	                    				<td><fmt:formatDate value="${fsupportList.reg_dt }" pattern="yyyy.MM.dd" /></td>
	                    				<td>1</td>
	                    				<td>1</td>
		                    		</c:when>
		                    		
		                    		<c:otherwise>
		                    			<td>1</td><td>1</td><td>1</td><td>1</td>
		                    		</c:otherwise>
                    			</c:choose>
	                    	</tr>
	                    	
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
               
