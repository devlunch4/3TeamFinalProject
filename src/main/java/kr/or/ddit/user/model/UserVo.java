package kr.or.ddit.user.model;

import java.util.Date;

// 20210226_KKC_MyPage
// UserVo 생성 02-27 10시16분 (경찬)
public class UserVo {

	public String user_id; // 유저아이디
	public String user_nm; // 유저이름
	public String user_pw; // 패스워드
	public String addr1; // 주소
	public String addr2; // 상세주소
	public String zip; // 우편번호
	public String phone; // 전화번호
	public Date reg_dt; // 가입일
	public String file1; // 파일명
	public String file2; // 파일경로
	public int loginfallcnt; // 로그인 실패수
	public Date logout_dt; // 로그아웃 시간
	public int active; // 활성
	public String email;

	public void UserVo() {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getFile1() {
		return file1;
	}

	public void setFile1(String file1) {
		this.file1 = file1;
	}

	public String getFile2() {
		return file2;
	}

	public void setFile2(String file2) {
		this.file2 = file2;
	}

	public int getLoginfallcnt() {
		return loginfallcnt;
	}

	public void setLoginfallcnt(int loginfallcnt) {
		this.loginfallcnt = loginfallcnt;
	}

	public Date getLogout_dt() {
		return logout_dt;
	}

	public void setLogout_dt(Date logout_dt) {
		this.logout_dt = logout_dt;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserVo [user_id=" + user_id + ", user_nm=" + user_nm + ", user_pw=" + user_pw + ", addr1=" + addr1
				+ ", addr2=" + addr2 + ", zip=" + zip + ", phone=" + phone + ", reg_dt=" + reg_dt + ", file1=" + file1
				+ ", file2=" + file2 + ", loginfallcnt=" + loginfallcnt + ", logout_dt=" + logout_dt + ", active="
				+ active + ", email=" + email + "]";
	}

}