package kr.or.ddit.farm.model;

//20210305 KWS
public class GuideSqlVo {

	private String sqlwhere1;
	private String sqlwhere2;

	public GuideSqlVo() {
	}

	public GuideSqlVo(String sqlwhere1, String sqlwhere2) {
		super();
		this.sqlwhere1 = sqlwhere1;
		this.sqlwhere2 = sqlwhere2;
	}

	public String getSqlwhere1() {
		return sqlwhere1;
	}

	public void setSqlwhere1(String sqlwhere1) {
		this.sqlwhere1 = sqlwhere1;
	}

	public String getSqlwhere2() {
		return sqlwhere2;
	}

	public void setSqlwhere2(String sqlwhere2) {
		this.sqlwhere2 = sqlwhere2;
	}

	@Override
	public String toString() {
		return "GuideSqlVo [sqlwhere1=" + sqlwhere1 + ", sqlwhere2=" + sqlwhere2 + "]";
	}

}