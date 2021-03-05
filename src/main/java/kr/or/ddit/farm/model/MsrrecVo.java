package kr.or.ddit.farm.model;

import java.util.Date;

public class MsrrecVo {

	// 20210304_KJH 측정기록 Vo
	private int msr_no;
	private String msr_code;
	private Date msr_reg_dt;
	private int msr_temp;
	private int msr_humid;
	private int msr_bright;

	public int getMsr_no() {
		return msr_no;
	}

	public void setMsr_no(int msr_no) {
		this.msr_no = msr_no;
	}

	public String getMsr_code() {
		return msr_code;
	}

	public void setMsr_code(String msr_code) {
		this.msr_code = msr_code;
	}

	public Date getMsr_reg_dt() {
		return msr_reg_dt;
	}

	public void setMsr_reg_dt(Date msr_reg_dt) {
		this.msr_reg_dt = msr_reg_dt;
	}

	public int getMsr_temp() {
		return msr_temp;
	}

	public void setMsr_temp(int msr_temp) {
		this.msr_temp = msr_temp;
	}

	public int getMsr_humid() {
		return msr_humid;
	}

	public void setMsr_humid(int msr_humid) {
		this.msr_humid = msr_humid;
	}

	public int getMsr_bright() {
		return msr_bright;
	}

	public void setMsr_bright(int msr_bright) {
		this.msr_bright = msr_bright;
	}

	@Override
	public String toString() {
		return "MsrrecVo [msr_no=" + msr_no + ", msr_code=" + msr_code + ", msr_reg_dt=" + msr_reg_dt + ", msr_temp="
				+ msr_temp + ", msr_humid=" + msr_humid + ", msr_bright=" + msr_bright + "]";
	}

}
