package kr.or.ddit.farm.model;

public class MsrequipVo {

	private String msr_code;
	private String msr_nm;
	private String owner;
	private String use_yn;

	public MsrequipVo() {
	}

	public String getMsr_code() {
		return msr_code;
	}

	public void setMsr_code(String msr_code) {
		this.msr_code = msr_code;
	}

	public String getMsr_nm() {
		return msr_nm;
	}

	public void setMsr_nm(String msr_nm) {
		this.msr_nm = msr_nm;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	@Override
	public String toString() {
		return "MsrequipVo [msr_code=" + msr_code + ", msr_nm=" + msr_nm + ", owner=" + owner + ", use_yn=" + use_yn
				+ "]";
	}

}
