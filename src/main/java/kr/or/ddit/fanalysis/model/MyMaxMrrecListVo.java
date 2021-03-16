package kr.or.ddit.fanalysis.model;

import java.util.Date;

public class MyMaxMrrecListVo {

	private String history_no;
	private String manage_no;
	private String location;
	private String owner;
	private String item_code;
	private String msr_nm;
	private Date reg_dt;
	private String msr_temp;
	private String msr_humid;
	private String msr_bright;
	private int number;
	private int number1;
	private int number2;
	public String getHistory_no() {
		return history_no;
	}
	public void setHistory_no(String history_no) {
		this.history_no = history_no;
	}
	public String getManage_no() {
		return manage_no;
	}
	public void setManage_no(String manage_no) {
		this.manage_no = manage_no;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getMsr_nm() {
		return msr_nm;
	}
	public void setMsr_nm(String msr_nm) {
		this.msr_nm = msr_nm;
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getNumber1() {
		return number1;
	}
	public void setNumber1(int number1) {
		this.number1 = number1;
	}
	public int getNumber2() {
		return number2;
	}
	public void setNumber2(int number2) {
		this.number2 = number2;
	}
	@Override
	public String toString() {
		return "MyMaxMrrecListVo [history_no=" + history_no + ", manage_no=" + manage_no + ", location=" + location
				+ ", owner=" + owner + ", item_code=" + item_code + ", msr_nm=" + msr_nm + ", reg_dt=" + reg_dt
				+ ", msr_temp=" + msr_temp + ", msr_humid=" + msr_humid + ", msr_bright=" + msr_bright + ", number="
				+ number + ", number1=" + number1 + ", number2=" + number2 + "]";
	}

	
	
}
