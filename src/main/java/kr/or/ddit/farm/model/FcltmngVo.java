package kr.or.ddit.farm.model;

import java.util.Date;

public class FcltmngVo {
	private String control_no;
	private String msr_code;
	private String owner;
	private String location;
	private String info;
	private String item_code;
	private String use;
	private Date reg_dt;
	
	public String getControl_no() {
		return control_no;
	}
	public void setControl_no(String control_no) {
		this.control_no = control_no;
	}
	public String getMsr_code() {
		return msr_code;
	}
	public void setMsr_code(String msr_code) {
		this.msr_code = msr_code;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	
	@Override
	public String toString() {
		return "FcltmngVo [control_no=" + control_no + ", msr_code=" + msr_code + ", owner=" + owner + ", location="
				+ location + ", info=" + info + ", item_code=" + item_code + ", use=" + use + ", reg_dt=" + reg_dt
				+ "]";
	}
	
}
