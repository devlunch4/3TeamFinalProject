package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.common.model.PageVoSearch;
import kr.or.ddit.user.model.UserVo;

public interface UserServiceImpl {

	// userid에 해당하는 사용자 한명의 정보 조회 (경찬)
	UserVo selectUser(String userid);

	// 전체 사용자 정보 조회 (경찬)
	List<UserVo> selectAllUser();

	// 사용자 삭제 03/04 (경찬)
	UserVo deleteUser(String user_id);
	
	// 관리자가 사용자 수정 03/05 (경찬)
	UserVo modifyUser(UserVo userVo);

}
