package kr.or.ddit.farm.model;

public class MsrequipVo {

	// 20210304_KJH 측정장비 Vo
	private String msr_code; // 측정장비코드
	private String msr_nm; // 측정장비명
	private String owner; // 소유자
	private String use_yn; // 사용여부

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

	public String getUse() {
		return use_yn;
	}

	public void setUse(String use) {
		this.use_yn = use;
	}

	@Override
	public String toString() {
		return "MsrequipVo [msr_code=" + msr_code + ", msr_nm=" + msr_nm + ", owner=" + owner + ", use=" + use_yn + "]";
	}

}
