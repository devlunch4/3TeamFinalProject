/**
 * 
 */

//이름 정규식 체크 - 한글과 영어만 가능
function user_nm_check(){
	user_nm_value = $('#user_nm').val().trim();
	
	nm_regex = /([^가-힣\x20a-zA-Z])/i; 
	if(!(nm_regex.test(user_nm_value))){
		return false;
	}
	return true;
}

//아이디 정규식 체크
function user_id_check(){
	user_id_value = $('#user_id').val().trim();
	
	id_regex = /^[a-z]+[a-z0-9]{5,19}$/;
	if(!(id_regex.test(user_id_value))){
		return false;
	}
	return true;
}

//비밀번호 정규식 체크
function user_pw_check(){
	user_pw_value = $('#user_pw').val().trim();
	
	pw_regex = /^(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,15}$/;
	if (!(pw_regex.test(user_pw_value))) {
		return false;
	}
	return true;
}










