package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class UserVo {

	@Size(min = 5)
	private String userid;

	private String usernm;
	private String pass;
	private String alias;
	private String addr1;
	private String addr2;
	private String zipcode;
	private String filename;
	private String realfilename;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date reg_dt;
	// private String reg_dt;

//	public void setReg_dt(String reg_dt) {
//		this.reg_dt = reg_dt;
//	}
//
//	public String getReg_dt() {
//		return reg_dt;
//	}

	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date hire_dt;
	// 1,000
	@NumberFormat(pattern = "#,###")
	private int price;

//	private int age;
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// 기본 생성자 (사용할 생성자 활용시 선언 필수!)
	public UserVo() {
	}

	// 사용할 생성자
	public UserVo(String userid, String usernm, String pass) {
		setUserid(userid);
		setUsernm(usernm);
		setPass(pass);
	}

	// 테스트용 사용할 생성자 사용되는 모든 생성자
	public UserVo(String userid, String usernm, String pass, Date reg_dt, String alias, String addr1, String addr2,
			String zipcode, String filename, String realfilename) {
		this.userid = userid;
		this.usernm = usernm;
		this.pass = pass;
		this.reg_dt = reg_dt;
		this.alias = alias;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.zipcode = zipcode;
		this.filename = filename;
		this.realfilename = realfilename;

	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsernm() {
		return usernm;
	}

	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getRealfilename() {
		return realfilename;
	}

	public void setRealfilename(String realfilename) {
		this.realfilename = realfilename;
	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public String getReg_dt_fmt() {
		return new SimpleDateFormat("yyyy-MM-dd").format(reg_dt);
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	public Date getHire_dt() {
		return hire_dt;
	}

	public void setHire_dt(Date hire_dt) {
		this.hire_dt = hire_dt;
	}

	@Override
	public String toString() {
		return "UserVo [userid=" + userid + ", usernm=" + usernm + ", pass=" + pass + ", alias=" + alias + ", addr1="
				+ addr1 + ", addr2=" + addr2 + ", zipcode=" + zipcode + ", filename=" + filename + ", realfilename="
				+ realfilename + ", reg_dt=" + reg_dt + ", hire_dt=" + hire_dt + ", price=" + price + "]";
	}

}
