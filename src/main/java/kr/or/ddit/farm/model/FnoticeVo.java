package kr.or.ddit.farm.model;

import java.util.Date;

// 20210311 공지사항 VO생성 (경찬)
public class FnoticeVo {

	public int notice_no;
	public String writer;
	public String title;
	public String content;
	public Date reg_dt;
	public int file_no;
	public int hit;
	public String use_yn;

	public int getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	@Override
	public String toString() {
		return "FnoticeVo [notice_no=" + notice_no + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", reg_dt=" + reg_dt + ", file_no=" + file_no + ", hit=" + hit + ", use_yn=" + use_yn + "]";
	}

}
