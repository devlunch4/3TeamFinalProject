package kr.or.ddit.farm.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// ggy_20210306 : FarmdiaryVo 수정
@XmlRootElement(name ="farmdiaryVo")
@XmlAccessorType(XmlAccessType.FIELD)
public class FarmdiaryVo {

	private int f_diary_no;
	private String writer;
	private int my_simple_code;
	@XmlAttribute
	private String content;
	private Date reg_dt;
	private String weather;
	private int low_temp;
	private int high_temp;
	private int rainfall;
	private int humid;
	@XmlElement
	private int yield;
	private int area;
	private int file_no;
	private String use_yn;
	private String b_type_code;
	private String w_step_code;
	private String item_code;

	private String startDate;
	private String endDate;

	private String file_nm;

	private String code_alias;

	public String getCode_alias() {
		return code_alias;
	}

	public void setCode_alias(String code_alias) {
		this.code_alias = code_alias;
	}

	public String getFile_nm() {
		return file_nm;
	}

	public void setFile_nm(String file_nm) {
		this.file_nm = file_nm;
	}

	public int getF_diary_no() {
		return f_diary_no;
	}

	public void setF_diary_no(int f_diary_no) {
		this.f_diary_no = f_diary_no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getMy_simple_code() {
		return my_simple_code;
	}

	public void setMy_simple_code(int my_simple_code) {
		this.my_simple_code = my_simple_code;
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

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
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

	public String getB_type_code() {
		return b_type_code;
	}

	public void setB_type_code(String b_type_code) {
		this.b_type_code = b_type_code;
	}

	public String getW_step_code() {
		return w_step_code;
	}

	public void setW_step_code(String w_step_code) {
		this.w_step_code = w_step_code;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

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

	@Override
	public String toString() {
		return "FarmdiaryVo [f_diary_no=" + f_diary_no + ", writer=" + writer + ", my_simple_code=" + my_simple_code
				+ ", content=" + content + ", reg_dt=" + reg_dt + ", weather=" + weather + ", low_temp=" + low_temp
				+ ", high_temp=" + high_temp + ", rainfall=" + rainfall + ", humid=" + humid + ", yield=" + yield
				+ ", area=" + area + ", file_no=" + file_no + ", use_yn=" + use_yn + ", b_type_code=" + b_type_code
				+ ", w_step_code=" + w_step_code + ", item_code=" + item_code + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", file_nm=" + file_nm + "]";
	}

}
