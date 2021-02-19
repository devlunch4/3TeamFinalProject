package kr.or.ddit.common.model;

public class PageVo {
	private int page;
	private int pageSize;

	public PageVo() {
	}

	public PageVo(int page, int pageSize) {
		this.page = page;
		this.pageSize = pageSize;
	}

	// jpa --> page:0 jpa의 경우 0부터 사용하게 된다.
	public int getPage() {
		return page == 0 ? 1 : page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize == 0 ? 5 : pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "PageVo [page=" + page + ", pageSize=" + pageSize + "]";
	}

}
