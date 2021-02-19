package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.common.model.PageVoSearch;
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

	// userid에 해당하는 사용자 한명의 정보 조회
	@Override
	public UserVo selectUser(String userid) {
		return userDao.selectUser(userid);
	}

	// DI getter setter 사용
	public UserDaoImpl getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

	// 전체 사용자 정보 조회
	@Override
	public List<UserVo> selectAllUser() {
		return userDao.selectAllUser();
	}

	// 페이지 처리
	@Override
	public Map<String, Object> selectPagingUser(PageVo pageVo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("pageVo", pageVo);
		resultMap.put("userList", userDao.selectPagingUser(pageVo));
		// resultMap.put("userCnt", userDao.selectAllUserCnt());
		int userCnt = userDao.selectAllUserCnt();

		resultMap.put("pagination", (int) Math.ceil((double) userCnt / pageVo.getPageSize()));
		// "(int)Math.ceil( ((Integer)resultMap.get(""userCnt"")).doubleValue() /
		// pageVo.getPageSize()) );
		// ,
		// (int)Math.ceil( Double.valueOf(resultMap.get(""userCnt"").toString())
		// /pageVo.getPageSize() )"

		return resultMap;
	}

// Original	
//	@Override
//	public Map<String, Object> selectPagingUser(PageVo pageVo) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		List<UserVo> userList = userDao.selectPagingUser(pageVo);
//		int userCnt = userDao.selectAllUserCnt();
//		map.put("userList", userList);
//		map.put("userCnt", userCnt);
//		return map;
//	}

	// 사용자 정보 수정
	@Override
	public int modifyUser(UserVo userVo) {
		return userDao.modifyUser(userVo);
	}

	// 사용자 정보 추가
	@Override
	public int insertUser(UserVo userVo) {
		return userDao.insertUser(userVo);
	}

	// 사용자 정보 추가 - 삼항연산자 사용
	@Override
	public int insertUserx(UserVo userVo) {
		int insertUserres = 0;
		try {
			insertUserres = userDao.insertUser(userVo) == 1 ? 1 : 0;
			return insertUserres;
		} catch (Exception e) {
		}
		return insertUserres;
	}

	// 사용자 정보 삭제
	@Override
	public int deleteUser(String userid) {
		return userDao.deleteUser(userid);
	}

	// 아이디로 검색한 페이징
	@Override
	public Map<String, Object> idSearchUser(PageVoSearch pageVoSearch) {
		Map<String, Object> map = new HashMap<>();

		List<UserVo> userList = userDao.idSearchUserPaging(pageVoSearch);
		int userCnt = userDao.idSearchUserCnt(pageVoSearch.getSerachvalue());

		map.put("userList", userList);
		map.put("userCnt", userCnt);

		return map;
	}

	// 이름으로 검색한 페이징
	@Override
	public Map<String, Object> nameSearchUser(PageVoSearch pageVoSearch) {
		Map<String, Object> map = new HashMap<>();

		List<UserVo> userList = userDao.nameSearchUserPaging(pageVoSearch);
		int userCnt = userDao.nameSearchUserCnt(pageVoSearch.getSerachvalue());

		map.put("userList", userList);
		map.put("userCnt", userCnt);

		return map;
	}

	// 별명으로 검색한 페이징
	@Override
	public Map<String, Object> aliasSearchUser(PageVoSearch pageVoSearch) {
		Map<String, Object> map = new HashMap<>();

		List<UserVo> userList = userDao.aliasSearchUserPaging(pageVoSearch);
		int userCnt = userDao.aliasSearchUserCnt(pageVoSearch.getSerachvalue());

		map.put("userList", userList);
		map.put("userCnt", userCnt);

		return map;
	}

}
