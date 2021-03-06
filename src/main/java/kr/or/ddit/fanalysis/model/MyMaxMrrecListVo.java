package kr.or.ddit.fanalysis.model;

import java.util.Date;

public class MyMaxMrrecListVo {
	
	private String location;
	private String msr_code;
	private String code_nm;
	private Date reg_dt;
	private String msr_temp;
	private String msr_humid;
	private String msr_bright;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMsr_code() {
		return msr_code;
	}
	public void setMsr_code(String msr_code) {
		this.msr_code = msr_code;
	}
	public String getCode_nm() {
		return code_nm;
	}
	public void setCode_nm(String code_nm) {
		this.code_nm = code_nm;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getMsr_temp() {
		return msr_temp;
	}
	public void setMsr_temp(String msr_temp) {
		this.msr_temp = msr_temp;
	}
	public String getMsr_humid() {
		return msr_humid;
	}
	public void setMsr_humid(String msr_humid) {
		this.msr_humid = msr_humid;
	}
	public String getMsr_bright() {
		return msr_bright;
	}
	public void setMsr_bright(String msr_bright) {
		this.msr_bright = msr_bright;
	}
	@Override
	public String toString() {
		return "MyMaxMrrecListVo [location=" + location + ", msr_code=" + msr_code + ", code_nm=" + code_nm
				+ ", reg_dt=" + reg_dt + ", msr_temp=" + msr_temp + ", msr_humid=" + msr_humid + ", msr_bright="
				+ msr_bright + "]";
	}
	
	
}
