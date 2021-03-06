package kr.or.ddit.user.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// 20210226_KKC_MyPage
// UserVo 생성 02-27 10시16분 (경찬)
// UserVo 수정 03-03 15시06분 (예슬)
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
	public Date logout_dt; // 로그아웃 시간
	public String use; // 사용여부

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

	public Date getLogout_dt() {
		return logout_dt;
	}

	public void setLogout_dt(Date logout_dt) {
		this.logout_dt = logout_dt;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	@Override
	public String toString() {
		return "UserVo [user_id=" + user_id + ", user_nm=" + user_nm + ", user_pw=" + user_pw + ", email=" + email
				+ ", addr1=" + addr1 + ", addr2=" + addr2 + ", zip=" + zip + ", mobile=" + mobile + ", reg_dt=" + reg_dt
				+ ", file_no=" + file_no + ", login_fail_cnt=" + login_fail_cnt + ", logout_dt=" + logout_dt + ", use="
				+ use + "]";
	}

}