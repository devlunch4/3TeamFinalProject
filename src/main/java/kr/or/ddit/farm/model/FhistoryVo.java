package kr.or.ddit.farm.model;

import java.util.Date;

public class FhistoryVo {

	private String history_no;
	private String manage_no;
	private String msr_code;
	private Date release_dt;
	private Date setup_dt;
	private String use_yn;

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

	public String getMsr_code() {
		return msr_code;
	}

	public void setMsr_code(String msr_code) {
		this.msr_code = msr_code;
	}

	public Date getRelease_dt() {
		return release_dt;
	}

	public void setRelease_dt(Date release_dt) {
		this.release_dt = release_dt;
	}

	public Date getSetup_dt() {
		return setup_dt;
	}

	public void setSetup_dt(Date setup_dt) {
		this.setup_dt = setup_dt;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	@Override
	public String toString() {
		return "FhistoryVo [history_no=" + history_no + ", manage_no=" + manage_no + ", msr_code=" + msr_code
				+ ", release_dt=" + release_dt + ", setup_dt=" + setup_dt + ", use_yn=" + use_yn + "]";
	}

}
