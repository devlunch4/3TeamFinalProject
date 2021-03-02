package kr.or.ddit.farm.model;

//품목테이블Vo
public class ItemsVo {

	private int category_code;
	//
	private int item_code;
	private String item_nm;
	//

	public int getCategory_code() {
		return category_code;
	}

	public void setCategory_code(int category_code) {
		this.category_code = category_code;
	}

	public int getItem_code() {
		return item_code;
	}

	public void setItem_code(int item_code) {
		this.item_code = item_code;
	}

	public String getItem_nm() {
		return item_nm;
	}

	public void setItem_nm(String item_nm) {
		this.item_nm = item_nm;
	}

	@Override
	public String toString() {
		return "ItemsVo [category_code=" + category_code + ", item_code=" + item_code + ", item_nm=" + item_nm + "]";
	}

}
