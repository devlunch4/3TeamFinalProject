package kr.or.ddit.user.repository;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.common.model.PageVoSearch;
import kr.or.ddit.user.model.UserVo;

public interface UserDaoImpl {
	// 사용자 아이디로 사용자 조회
	UserVo selectUser(String userid);

	// 전체 사용자 정보 조회
	List<UserVo> selectAllUser();

	// 페이지 처리
	List<UserVo> selectPagingUser(PageVo pageVo);

	// 사용자 전체수 조회
	int selectAllUserCnt();

	// 사용자 정보 수정
	int modifyUser(UserVo userVo);

	// 사용자 정보 추가
	int insertUser(UserVo userVo);

	// 사용자 삭제
	int deleteUser(String userid);

	// 검색
	// 검색
	// 검색
	// 아이디로 검색
	List<UserVo> idSearchUser(String userid);

	int idSearchUserCnt(String userid);

	List<UserVo> idSearchUserPaging(PageVoSearch pageVoSearch);

	// 이름으로 검색
	List<UserVo> nameSearchUser(String usernm);

	int nameSearchUserCnt(String usernm);

	List<UserVo> nameSearchUserPaging(PageVoSearch pageVoSearch);

	// 별명으로 검색
	List<UserVo> aliasSearchUser(String alias);

	int aliasSearchUserCnt(String alias);

	List<UserVo> aliasSearchUserPaging(PageVoSearch pageVoSearch);

}
