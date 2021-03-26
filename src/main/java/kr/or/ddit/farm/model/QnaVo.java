package kr.or.ddit.farm.model;

import java.sql.Date;

//20210309_LYS_Q&A : FqnaVo 생성
//20210313_LYS_Q&A3(03-16) : QnaVo수정
public class QnaVo {

	private int qna_no;
	private int qna_parent_no;
	private String writer;
	private String title;
	private String content;
	private Date reg_dt;
	private int hit;
	private String use_yn;

	public int getQna_no() {
		return qna_no;
	}

	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}

	public int getQna_parent_no() {
		return qna_parent_no;
	}

	public void setQna_parent_no(int qna_parent_no) {
		this.qna_parent_no = qna_parent_no;
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
		return "QnaVo [qna_no=" + qna_no + ", qna_parent_no=" + qna_parent_no + ", writer=" + writer + ", title="
				+ title + ", content=" + content + ", reg_dt=" + reg_dt + ", hit=" + hit + ", use_yn=" + use_yn + "]";
	}

}
