
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script>
$(function(){
	//주소검색 버튼이 클릭 되었을 때 다음주소 api 팝업을 연다
	$("#addrBtn").on("click", function(){
		new daum.Postcode({
	        oncomplete: function(data) {
	             
	            $("#addr1").val(data.roadAddress);		//도로주소
	            $("#zipcode").val(data.zonecode);		//우편번호
	            
	            //사용자 편의성을 위해 상세주소 입력 input 태그로 focus 설정
	            $("#addr2").focus();
	        }
	    }).open();	
	});
});
    
</script>
	
<main>
<%-- 							<label class="form-control">${S_USER.addr1 }테스트주소1</label> --%>

	<div class="container-fluid">
		<h3 class="mt-4">마이페이지</h3>
			<form class="form-horizontal" id="frm" role="form">
					<input type="hidden" name="userid" value="${S_USER.userid }" />
					
					<div class="form-group">
						<label class="small mb-3" for="input_cls_code">성명</label>
						<div class="col-sm-10">
							<input name="userid" class="form-control" value="테스트이름" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="small mb-1" for="input_cls_code">아이디</label>
						<div class="col-sm-10">
							<input name="userid" class="form-control" value="테스트아이디" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="small mb-1" for="input_cls_code">비밀번호</label>
						<div class="col-sm-10">
							<input name="userid" class="form-control" value="테스트비밀번호" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="small mb-1" for="input_cls_code">이메일</label>
						<div class="col-sm-10">
							<input name="userid" class="form-control" value="테스트이메일" />
						</div>
					</div>

					<div class="form-group">
						<label class="small mb-1" for="input_cls_code">전화번호</label>
						<div class="col-sm-10">
							<input name="userid" class="form-control" value="테스트전화번호" />
						</div>
					</div>

					<div class="form-group">
						<label class="small mb-1" for="input_cls_code">주소</label>
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" id="addrBtn" class="btn btn-primary">주소검색</button>
						</div>
						<br>
						<div class="col-sm-10">
							<input id="addr1" class="form-control" value="" />
						</div>
						<div class="col-sm-10">
							<input id="zipcode" class="form-control" value="" />
						</div>
						<div class="col-sm-10">
							<input id="zipcode" class="form-control" value="상세주소 입력" />
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" id="modifyBtn" class="btn btn-primary">회원탈퇴 </button>
							<button type="button" id="deleteBtn" class="btn btn-primary">정보수정 </button>
							<button type="button" id="deleteBtn" class="btn btn-primary">뒤로가기 </button>
						</div>
					</div>
					
				</form>
			</div>
</main>