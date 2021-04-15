package kr.or.ddit.farm.model;

// ggy_20210306 : MySimpleCodeVo 수정
public class MySimpleCodeVo {

	private int my_simple_code;
	private String owner;
	private String item_code;
	private String b_type_code;
	private String code_alias;
	private int area;
	private String use_yn;

	public int getMy_simple_code() {
		return my_simple_code;
	}

	public void setMy_simple_code(int my_simple_code) {
		this.my_simple_code = my_simple_code;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public String getB_type_code() {
		return b_type_code;
	}

	public void setB_type_code(String b_type_code) {
		this.b_type_code = b_type_code;
	}

	public String getCode_alias() {
		return code_alias;
	}

	public void setCode_alias(String code_alias) {
		this.code_alias = code_alias;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

}
