package kr.or.ddit.farm.model;

import java.util.Date;

//shs_20210308 : FcommuintyVo 수정
public class MarketVo {

	private int market_no;
	private String writer;
	private int head_code;
	private String title;
	private String item_code;
	private String content;
	private String price;
	private Date reg_dt;
	private String thumbnail;
	private String mobile;
	private int hit;
	private String use_yn;

	public MarketVo() {
	}

	public MarketVo(int market_no, String writer, int head_code, String title, String item_code, String content,
			String price, Date reg_dt, String thumbnail, String mobile, int hit, String use_yn) {
		super();
		this.market_no = market_no;
		this.writer = writer;
		this.head_code = head_code;
		this.title = title;
		this.item_code = item_code;
		this.content = content;
		this.price = price;
		this.reg_dt = reg_dt;
		this.thumbnail = thumbnail;
		this.mobile = mobile;
		this.hit = hit;
		this.use_yn = use_yn;
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

	public int getHead_code() {
		return head_code;
	}

	public void setHead_code(int head_code) {
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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
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

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	@Override
	public String toString() {
		return "FcommunityVo [market_no=" + market_no + ", writer=" + writer + ", head_code=" + head_code + ", title="
				+ title + ", item_code=" + item_code + ", content=" + content + ", price=" + price + ", reg_dt="
				+ reg_dt + ", thumbnail=" + thumbnail + ", mobile=" + mobile + ", hit=" + hit + ", use_yn=" + use_yn
				+ "]";
	}

}
