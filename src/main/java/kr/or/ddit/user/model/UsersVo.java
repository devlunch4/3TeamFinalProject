package kr.or.ddit.user.model;

import java.util.List;

public class UsersVo {
	
	private List<UserVo> usersVoList;

	public List<UserVo> getUsersVoList() {
		return usersVoList;
	}

	public void setUsersVoList(List<UserVo> usersVoList) {
		this.usersVoList = usersVoList;
	}

	@Override
	public String toString() {
		return "UsersVo [usersVoList=" + usersVoList + "]";
	}

//	private List<String> userid;
//
//	public List<String> getUserid() {
//		return userid;
//	}
//
//	public void setUserid(List<String> userid) {
//		this.userid = userid;
//	}
//
//	@Override
//	public String toString() {
//		return "UsersVo [userid=" + userid + "]";
//	}

	

}
