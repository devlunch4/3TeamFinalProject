package kr.or.ddit.farm.model;

public class FilesVo {
	
	private int file_no;
	private String file_nm;
	private String file_path;
	private String use_yn;
	
	public FilesVo () {}
	
	
	
	public FilesVo(int file_no, String file_nm, String file_path, String use_yn) {
		super();
		this.file_no = file_no;
		this.file_nm = file_nm;
		this.file_path = file_path;
		this.use_yn = use_yn;
	}



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
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	@Override
	public String toString() {
		return "FilesVo [file_no=" + file_no + ", file_nm=" + file_nm + ", file_path=" + file_path + ", use_yn="
				+ use_yn + "]";
	}
	
	
	
	
	
	

}
