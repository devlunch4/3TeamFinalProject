package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.common.model.PageVoSearch;
import kr.or.ddit.user.model.UserVo;

public interface UserServiceImpl {
	
	// 20210304_LYS_Login3 - 로그인 구현
	// userid에 해당하는 사용자 한명의 정보 조회
	UserVo selectUser(String user_id);
	
	
	// 20210304_LYS_Login3 - 회원가입 구현
	// 사용자 정보 추가
	int insertUser(UserVo userVo);
	
	// 20210304_LYS_Login3 - 회원가입 시, 아이디 중복체크
	String checkForDuplicateId(String user_id);
	
	// 페이지 처리
	Map<String, Object> selectPagingUser(PageVo pageVo);

	// 전체 사용자 정보 조회 (경찬)
	List<UserVo> selectAllUser();

	// 사용자 삭제 03/04 (경찬)
	UserVo deleteUser(String user_id);

}
