package kr.or.ddit.user.model;

import java.util.Date;

// 20210226_KKC_MyPage
// UserVo 생성 02-27 10시16분 (경찬)
// UserVo 수정 03-03 15시06분 (예슬)
// UserVo 수정 03-06 15시18분 (예슬)
// UserVo 생성 03-06 17시06분 (경찬)
public class UserVo {

	public String user_id; // 유저아이디
	public String user_nm; // 유저이름
	public String user_pw; // 패스워드
	public String email; // 이메일
	public String addr1; // 주소
	public String addr2; // 상세주소
	public String zip; // 우편번호
	public String mobile; // 전화번호
	public Date reg_dt; // 가입일
	public int file_no; // 파일번호
	public int login_fail_cnt; // 로그인 실패수
	public Date login_dt; // 로그아웃 시간
	public String use_yn; // 사용여부

	public UserVo() {
	}

	public UserVo(String userid, String pass) {
		setUser_id(userid);
		setUser_pw(pass);
	}

	public UserVo(String user_pw, int login_fail_cnt) {
		setUser_pw(user_pw);
		setLogin_fail_cnt(login_fail_cnt);
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_nm() {
		return user_nm;
	}

	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	public int getFile_no() {
		return file_no;
	}

	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}

	public int getLogin_fail_cnt() {
		return login_fail_cnt;
	}

	public void setLogin_fail_cnt(int login_fail_cnt) {
		this.login_fail_cnt = login_fail_cnt;
	}

	public Date getLogin_dt() {
		return login_dt;
	}

	public void setlogin_dt(Date login_dt) {
		this.login_dt = login_dt;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	@Override
	public String toString() {
		return "UserVo [user_id=" + user_id + ", user_nm=" + user_nm + ", user_pw=" + user_pw + ", email=" + email
				+ ", addr1=" + addr1 + ", addr2=" + addr2 + ", zip=" + zip + ", mobile=" + mobile + ", reg_dt=" + reg_dt
				+ ", file_no=" + file_no + ", login_fail_cnt=" + login_fail_cnt + ", login_dt=" + login_dt
				+ ", use_yn=" + use_yn + "]";
	}

}