package kr.or.ddit.user.repository;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

public interface UserDaoImpl {
	// 사용자 아이디로 사용자 조회 - 로그인 LYS
	UserVo selectUser(String user_id);

	// 사용자 정보 추가 - 회원가입 LYS
	int insertUser(UserVo userVo);

	// 아이디 중복체크 LYS
	String checkForDuplicateId(String user_id);

	// 전체 사용자 정보 조회 (경찬)
	List<UserVo> selectAllUser();

	// 사용자 전체수 조회 (경찬)
	int selectAllUserCnt();

	// 사용자 삭제 03/04 (경찬)
	UserVo deleteUser(String user_id);

	// 관리자가 사용자 수정 03/05 (경찬)
	UserVo modifyUser(UserVo userVo);
	
}
