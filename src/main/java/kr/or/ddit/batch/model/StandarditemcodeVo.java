package kr.or.ddit.batch.model;

public class StandarditemcodeVo {
	
	private String lclasscode;	//부류코드
	private String lclassname;	//부류명
	private String mclasscode;	//품목코드
	private String mclassname;	//품목명
	private String sclasscode;	//품종코드
	private String sclassname;	//품종명
	private String reg_dt;	//등록일
	private String mod_dt;	//수정일
	
	public String getLclasscode() {
		return lclasscode;
	}
	public void setLclasscode(String lclasscode) {
		this.lclasscode = lclasscode;
	}
	public String getLclassname() {
		return lclassname;
	}
	public void setLclassname(String lclassname) {
		this.lclassname = lclassname;
	}
	public String getMclasscode() {
		return mclasscode;
	}
	public void setMclasscode(String mclasscode) {
		this.mclasscode = mclasscode;
	}
	public String getMclassname() {
		return mclassname;
	}
	public void setMclassname(String mclassname) {
		this.mclassname = mclassname;
	}
	public String getSclasscode() {
		return sclasscode;
	}
	public void setSclasscode(String sclasscode) {
		this.sclasscode = sclasscode;
	}
	public String getSclassname() {
		return sclassname;
	}
	public void setSclassname(String sclassname) {
		this.sclassname = sclassname;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getMod_dt() {
		return mod_dt;
	}
	public void setMod_dt(String mod_dt) {
		this.mod_dt = mod_dt;
	}
	@Override
	public String toString() {
		return "StandarditemcodeVo [lclasscode=" + lclasscode + ", lclassname=" + lclassname + ", mclasscode="
				+ mclasscode + ", mclassname=" + mclassname + ", sclasscode=" + sclasscode + ", sclassname="
				+ sclassname + ", reg_dt=" + reg_dt + ", mod_dt=" + mod_dt + "]";
	}
	
	
	
}
