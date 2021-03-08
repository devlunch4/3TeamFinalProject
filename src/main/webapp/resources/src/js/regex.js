

//이름 정규식 체크 - 한글과 영어만 가능
function user_nm_check(){
	user_nm_value = $("#user_nm").val().trim();
	
	nm_regex = /^[가-힣]{2,4}$/;
	if(!(nm_regex.test(user_nm_value))){
		$(".name_status").css("display", "block");
		$(".name_status").html("이름을 정확하게 입력하세요.");
		return false;
	}else{
		$(".name_status").css("display", "none");
	}
	return true;
}

//아이디 정규식 체크
function user_id_check(){
	user_id_value = $('#user_id').val().trim();
	
	id_regex = /^[a-z0-9]{3,20}$/;
	if(!(id_regex.test(user_id_value))){
		$(".id_status_ok").css("display", "none");
		$(".id_status").css("display", "block");
		$(".id_status").html("아이디는 영소문자로 시작하는 4~20자 영문자 또는 숫자이어야 합니다.");
		return false;
	}else{
		$(".id_status").css("display", "none");
	}
	return true;
}


//비밀번호 정규식 체크
function user_pw_check(){
	user_pw_value = $('#user_pw').val().trim();
	
	pw_regex = /^(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,99}$/;
	if (!(pw_regex.test(user_pw_value))) {
		$(".pw_status").html("비밀번호는 8자 이상의 문자, 숫자, 특수문자의 조합으로 입력해주세요.");
		return false;
	}else{
		$(".pw_status").css("display", "none");
	}	
	return true;
}

//이메일 정규식 체크
function email_check(){
	email_value = $('#email').val().trim();
	
	email_regex = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	
	if (!(email_regex.test(email_value))) {
		$(".email_status_ok").css("display", "none");
		$(".email_status_not_ok").css("display", "block");
		$(".email_status").html("이메일 주소를 형식에 맞게 입력해주세요.");
		return false;
	}else{
		$(".email_status").css("display", "none");
	}	
	return true;
}


//핸드폰번호 정규식 체크
function mobile_check(){
	mobile_value = $('#mobile').val().trim();
	
	mobile_regex = /^01(?:0|1|[6-9])(?:\d{3}|\d{4})\d{4}$/;

	if (!(mobile_regex.test(mobile_value))) {
		$(".mobile_status_ok").css("display", "none");
		$(".mobile_status_not_ok").css("display", "block");
		$(".mobile_status").html("핸드폰번호를 올바르게 입력해주세요.");
		return false;
	}else{
		$(".mobile_status").css("display", "none");
	}	
	return true;
}






