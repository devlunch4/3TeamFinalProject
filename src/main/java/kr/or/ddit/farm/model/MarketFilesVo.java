package kr.or.ddit.farm.model;

public class MarketFilesVo {
	
	private int file_record_no;
	private int market_no;
	private int file_no;
	private String use_yn;
	
	public int getFile_record_no() {
		return file_record_no;
	}
	public void setFile_record_no(int file_record_no) {
		this.file_record_no = file_record_no;
	}
	public int getMarket_no() {
		return market_no;
	}
	public void setMarket_no(int market_no) {
		this.market_no = market_no;
	}
	public int getFile_no() {
		return file_no;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	
	@Override
	public String toString() {
		return "MarketFilesVo [file_record_no=" + file_record_no + ", market_no=" + market_no + ", file_no=" + file_no
				+ ", use_yn=" + use_yn + "]";
	}
	
	
	
}
