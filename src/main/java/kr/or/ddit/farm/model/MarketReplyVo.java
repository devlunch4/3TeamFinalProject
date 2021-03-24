package kr.or.ddit.farm.model;

import java.util.Date;

// 20210324_ggy : MarketReplyVo 생성
public class MarketReplyVo {

	private int reply_code;
	private int market_no;
	private String writer;
	private String content;
	private Date reg_dt;
	private String use_yn;
	
	public int getReply_code() {
		return reply_code;
	}
	public void setReply_code(int reply_code) {
		this.reply_code = reply_code;
	}
	public int getMarket_no() {
		return market_no;
	}
	public void setMarket_no(int market_no) {
		this.market_no = market_no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	
	@Override
	public String toString() {
		return "MarketReplyVo [reply_code=" + reply_code + ", market_no=" + market_no + ", writer=" + writer
				+ ", content=" + content + ", reg_dt=" + reg_dt + ", use_yn=" + use_yn + "]";
	}
	
	
	

}
