package kr.or.ddit.common.model;

//검색 값과 페이징 처리를 위한 객체
public class PageVoSearch {
	private int page;
	private int pageSize;
	private String serachvalue;

	public PageVoSearch() {

	}

	public PageVoSearch(int page, int pageSize, String serachvalue) {
		this.page = page;
		this.pageSize = pageSize;
		this.serachvalue = serachvalue;

	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSerachvalue() {
		return serachvalue;
	}

	public void setSerachvalue(String serachvalue) {
		this.serachvalue = serachvalue;
	}

}
