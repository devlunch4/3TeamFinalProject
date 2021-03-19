package kr.or.ddit.farm.model;

import java.util.Date;

// 20210308_ggy : MiniMarketVo 생성
public class MiniMarketVo {
	
	private int market_no;
	private String writer;
	private String head_code;
	private String title;
	private String item_code;
	private String content;
	private String price;
	private Date reg_dt;
	private int thumbnail;
	private String mobile;
	private int hit;
	private String code_nm;
	
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
	public String getHead_code() {
		return head_code;
	}
	public void setHead_code(String head_code) {
		this.head_code = head_code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	public int getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(int thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getCode_nm() {
		return code_nm;
	}
	public void setCode_nm(String code_nm) {
		this.code_nm = code_nm;
	}
	
	@Override
	public String toString() {
		return "MiniMarketVo [market_no=" + market_no + ", writer=" + writer + ", head_code=" + head_code + ", title="
				+ title + ", item_code=" + item_code + ", content=" + content + ", price=" + price + ", reg_dt="
				+ reg_dt + ", thumbnail=" + thumbnail + ", mobile=" + mobile + ", hit=" + hit + ", code_nm=" + code_nm
				+ "]";
	}
	
	
	
	
	
	
	
	

}
