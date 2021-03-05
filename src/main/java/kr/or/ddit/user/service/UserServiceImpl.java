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
	
	
	
	
	
	
	// 전체 사용자 정보 조회
	List<UserVo> selectAllUser();

	// 페이지 처리
	Map<String, Object> selectPagingUser(PageVo pageVo);
//
//	// 사용자 정보 수정
//	int modifyUser(UserVo userVo);
//
	
	
	
//
//	// 사용자 정보 추가 - 삼항연산자 사용
//	int insertUserx(UserVo userVo);
//
//	// 사용자 정보 삭제
//	int deleteUser(String userid);
//
//	// 검색
//	// 검색
//	// 검색
//
//	// 아이디로 검색
//	Map<String, Object> idSearchUser(PageVoSearch pageVoSearch);
//
//	// 이름으로 검색
//	Map<String, Object> nameSearchUser(PageVoSearch pageVoSearch);
//
//	// 별명으로 검색
//	Map<String, Object> aliasSearchUser(PageVoSearch pag@Override
//	eVoSearch);

}
