package kr.or.ddit.farm.model;

import java.util.Date;

// ggy_20210326 : WeeklyFarmInfosVo 생성
public class WeeklyFarmInfosVo {

	private String w_info_no;
	private String writer;
	private String title;
	private Date reg_dt;
	private int hit;

	private int file_no;
	private String file_nm;
	
	public String getW_info_no() {
		return w_info_no;
	}
	public void setW_info_no(String w_info_no) {
		this.w_info_no = w_info_no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getFile_no() {
		return file_no;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}
	public String getFile_nm() {
		return file_nm;
	}
	public void setFile_nm(String file_nm) {
		this.file_nm = file_nm;
	}
	
	@Override
	public String toString() {
		return "WeeklyFarmInfosVo [w_info_no=" + w_info_no + ", writer=" + writer + ", title=" + title + ", reg_dt="
				+ reg_dt + ", hit=" + hit + ", file_no=" + file_no + ", file_nm=" + file_nm + "]";
	}
	
	

}
