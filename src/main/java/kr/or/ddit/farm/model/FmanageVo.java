package kr.or.ddit.farm.model;

import java.util.Date;

public class FmanageVo {
	private String manage_no;
	private String owner;
	private String location;
	private String history_no;
	private String item_code;
	private Date reg_dt;
	private String use_yn;// 시설 상세조회에서 장비명을 받을때도 사용함
	private String info;

	public String getManage_no() {
		return manage_no;
	}

	public void setManage_no(String manage_no) {
		this.manage_no = manage_no;
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

	public String getHistory_no() {
		return history_no;
	}

	public void setHistory_no(String history_no) {
		this.history_no = history_no;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "FmanageVo [manage_no=" + manage_no + ", owner=" + owner + ", location=" + location + ", history_no="
				+ history_no + ", item_code=" + item_code + ", reg_dt=" + reg_dt + ", use_yn=" + use_yn + ", info="
				+ info + "]";
	}

}
