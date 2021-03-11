package kr.or.ddit.common.model;

public class CodesVo {

	// 2021-03-02KJH Codes테이블 Vo
	// 2021-03-06 vo수정 (경찬)

	private String code_seq;
	private String code_no;
	private String code_nm;
	private String parent_code;
	private String use_yn;

	public String getCode_seq() {
		return code_seq;
	}

	public void setCode_seq(String code_seq) {
		this.code_seq = code_seq;
	}

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

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

}
