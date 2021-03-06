package kr.or.ddit.common.model;

public class CodesVo {
	// 2021-03-02KJH Codes테이블 Vo
	private String code_no;
	private String code_nm;
	private String parent_code;
	private String use;

	public String getCode_no() {
		return code_no;
	}

	public void setCode_no(String code_no) {
		this.code_no = code_no;
	}
	
	public String getCode_nm() {

		return code_nm;
	}
	
	public void setCode_nm(String code_nm) {
		this.code_nm = code_nm;
	}
	
	public String getParent_code() {
		return parent_code;
	}
	
	public void setParent_code(String parent_code) {
		this.parent_code = parent_code;
	}
	
	public String getUse() {
		return use;
	}
	
	public void setUse(String use) {
		this.use = use;
	}
	
	@Override
	public String toString() {
		return "CodesVo [code_no=" + code_no + ", code_nm=" + code_nm + ", parent_code=" + parent_code + ", use=" + use
				+ "]";
	}
}
