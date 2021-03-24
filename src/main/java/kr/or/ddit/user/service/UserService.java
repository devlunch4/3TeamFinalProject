package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

public interface UserService {

	// 20210304_LYS_Login3 - 로그인 구현
	// userid에 해당하는 사용자 한명의 정보 조회
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

	// 20210304_LYS_Login3 - 회원가입 구현
	// 사용자 정보 추가
	int insertUser(UserVo userVo);

	// 20210304_LYS_Login3 - 회원가입 시, 아이디 중복체크
	String checkForDuplicateId(String user_id);

	// 전체 사용자 정보 조회 (경찬)
	List<UserVo> selectAllUser();

	// 사용자 삭제 03/04 (경찬)
	UserVo deleteUser(String user_id);

	// 관리자가 사용자 수정 03/05 (경찬)
	UserVo modifyUser(UserVo userVo);

	// 사용자가 개인정보 수정 03/10 (경찬)
	UserVo modifyUser2(UserVo userVo);

	// 이름과 이메일로 아이디 찾는거 03/23 (경찬)
	UserVo findId(UserVo userVo);

}
