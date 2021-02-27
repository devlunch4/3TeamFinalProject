package kr.or.ddit.farm.model;

import java.util.Date;


public class FarmdiaryVo {
	
	private int fdiary_no;
	private String writer;
	private String content;
	
	private Date reg_dt;
	
	private String weather;
	private int low_temp;
	private int high_temp;
	private int rainfall;
	private int humid;
	private int yield;
	private String file1;
	private String file2;
	private int area;
	private int active;
	private int btype_code;
	private int item_code;
	private int wstep_code;
	
	private String startDate;
	private String endDate;
	
	
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getFdiary_no() {
		return fdiary_no;
	}
	public void setFdiary_no(int fdiary_no) {
		this.fdiary_no = fdiary_no;
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
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public int getLow_temp() {
		return low_temp;
	}
	public void setLow_temp(int low_temp) {
		this.low_temp = low_temp;
	}
	public int getHigh_temp() {
		return high_temp;
	}
	public void setHigh_temp(int high_temp) {
		this.high_temp = high_temp;
	}
	public int getRainfall() {
		return rainfall;
	}
	public void setRainfall(int rainfall) {
		this.rainfall = rainfall;
	}
	public int getHumid() {
		return humid;
	}
	public void setHumid(int humid) {
		this.humid = humid;
	}
	public int getYield() {
		return yield;
	}
	public void setYield(int yield) {
		this.yield = yield;
	}
	public String getFile1() {
		return file1;
	}
	public void setFile1(String file1) {
		this.file1 = file1;
	}
	public String getFile2() {
		return file2;
	}
	public void setFile2(String file2) {
		this.file2 = file2;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public int getBtype_code() {
		return btype_code;
	}
	public void setBtype_code(int btype_code) {
		this.btype_code = btype_code;
	}
	public int getItem_code() {
		return item_code;
	}
	public void setItem_code(int item_code) {
		this.item_code = item_code;
	}
	public int getWstep_code() {
		return wstep_code;
	}
	public void setWstep_code(int wstep_code) {
		this.wstep_code = wstep_code;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
