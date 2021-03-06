package kr.or.ddit.common.model;

public class FilesVo {
	// ggy_20210305 files테이블 Vo

	private int file_no;
	private String file_nm;
	private String file_path;
	private String ori_table_nm;
	private String writer;
	private int ori_post_no;
	private String use;
	
	public int getFile_no() {
		return file_no;
	}
	
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}

	public String getFile_nm() {
		return file_nm;
	}

	public void setFile_nm(String file_nm) {
		this.file_nm = file_nm;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getOri_table_nm() {
		return ori_table_nm;
	}

	public void setOri_table_nm(String ori_table_nm) {
		this.ori_table_nm = ori_table_nm;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getOri_post_no() {
		return ori_post_no;
	}

	public void setOri_post_no(int ori_post_no) {
		this.ori_post_no = ori_post_no;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

}
