package kr.or.ddit.farm.model;

import java.util.Date;

// 20210316_ggy : ItemmanualVo 생성
public class ItemmanualVo {

	private int manual_code;
	private String writer;
	private String ifm_nm;
	private Date reg_dt;
	private int file_no;
	private String item_code;
	private String file_nm;
	private String code_nm;

	public int getManual_code() {
		return manual_code;
	}

	public void setManual_code(int manual_code) {
		this.manual_code = manual_code;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getIfm_nm() {
		return ifm_nm;
	}

	public void setIfm_nm(String ifm_nm) {
		this.ifm_nm = ifm_nm;
	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	public int getFile_no() {
		return file_no;
	}

	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public String getFile_nm() {
		return file_nm;
	}

	public void setFile_nm(String file_nm) {
		this.file_nm = file_nm;
	}

	public String getCode_nm() {
		return code_nm;
	}

	public void setCode_nm(String code_nm) {
		this.code_nm = code_nm;
	}

	@Override
	public String toString() {
		return "ItemmanualVo [manual_code=" + manual_code + ", writer=" + writer + ", ifm_nm=" + ifm_nm + ", reg_dt="
				+ reg_dt + ", file_no=" + file_no + ", item_code=" + item_code + ", file_nm=" + file_nm + ", code_nm="
				+ code_nm + "]";
	}

}
