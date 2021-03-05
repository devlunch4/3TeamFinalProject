package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.PageVo;
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
   
   // 20210304_LYS_Login3 - 회원가입 구현
   // 사용자 정보 추가
   @Override
   public int insertUser(UserVo userVo) {
      return userDao.insertUser(userVo);
   }
   
   // 20210304_LYS_Login3 - 회원가입 시, 아이디 중복체크
   @Override
   public String checkForDuplicateId(String user_id) {
   	return null;
   }

   // Original   
   @Override
   public Map<String, Object> selectPagingUser(PageVo pageVo) {
      Map<String, Object> map = new HashMap<String, Object>();
      List<UserVo> userList = userDao.selectPagingUser(pageVo);
      int userCnt = userDao.selectAllUserCnt();
      map.put("userList", userList);
      map.put("userCnt", userCnt);
      return map;
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

}