package kr.or.ddit.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.repository.UserDaoImpl;

@Service("userService")
public class UserService implements UserServiceImpl {

	@Resource(name = "UserDao")
	private UserDaoImpl userDao;

	public UserService() {
	}

	public UserService(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

	// 20210304_LYS_Login3 - 로그인 구현
	// userid에 해당하는 사용자 한명의 정보 조회
	@Override
	public UserVo selectUser(String user_id) {
		return userDao.selectUser(user_id);
	}

	// 20210309_LYS_Q&A - 로그인 할 때
	// 로그인을 한 사용자의 사용여부(use_yn) 확인
	@Override
	public String selectUse_yn(String user_id) {
		return userDao.selectUse_yn(user_id);
	}

	// 20210309_LYS_Q&A - 로그인 실패시
	// 로그인 실패하면 login_fail_cnt 카운트
	@Override
	public int updateLoginFailCnt(String user_id) {
		return userDao.updateLoginFailCnt(user_id);
	}

	// 20210309_LYS_Q&A - 지금까지 실패한 로그인 카운트
	@Override
	public int sumLoginFailCnt(String user_id) {
		return userDao.sumLoginFailCnt(user_id);
	}

	// 20210311_LYS_Q&A2 - 로그인 성공했을때 login_fail_cnt 카운트 0으로 리셋
	@Override
	public int updateLoginFailCnt_reset(String user_id) {
		return userDao.updateLoginFailCnt_reset(user_id);
	}
	
	// 20210304_LYS_Login3 - 회원가입 구현
	// 사용자 정보 추가
	@Override
	public int insertUser(UserVo userVo) {
		return userDao.insertUser(userVo);
	}

	// 20210304_LYS_Login3 - 회원가입 시, 아이디 중복체크
	@Override
	public String checkForDuplicateId(String user_id) {
		return userDao.checkForDuplicateId(user_id);
	}

	// 전체 사용자 정보 조회 (경찬)
	@Override
	public List<UserVo> selectAllUser() {
		return userDao.selectAllUser();
	}

	// 사용자 삭제 03/04 (경찬)
	@Override
	public UserVo deleteUser(String user_id) {
		return userDao.deleteUser(user_id);
	}

	// 관리자가 사용자 수정 03/05 (경찬)
	@Override
	public UserVo modifyUser(UserVo userVo) {
		return userDao.modifyUser(userVo);
	}

	//20210310_KKC_1110
	@Override
	public UserVo modifyUser2(UserVo userVo) {
		return userDao.modifyUser2(userVo);
	}


}