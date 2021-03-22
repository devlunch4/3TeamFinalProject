package kr.or.ddit.user.repository;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

public interface UserDao {
	// 사용자 아이디로 사용자 조회 - 로그인 LYS
	UserVo selectUser(String user_id);

	// 로그인을 한 사용자의 사용여부(use_yn) 확인 LYS - 03/11
	String selectUse_yn(String user_id);

	// 로그인 실패하면 login_fail_cnt 카운트 LYS - 03/11
	int updateLoginFailCnt(String user_id);

	// login_fail_cnt 몇개인지 더한거 select LYS - 03/11
	// - 지금까지 실패한 로그인 카운트
	int sumLoginFailCnt(String user_id);
	
	// 로그인 성공하면 login_fail_cnt 0으로 리셋 LYS - 03/11
	int updateLoginFailCnt_reset(String user_id);

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

	// 사용자가 개인정보 수정 03/10 (경찬)
	UserVo modifyUser2(UserVo userVo);

}
