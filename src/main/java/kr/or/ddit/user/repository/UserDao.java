package kr.or.ddit.user.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.user.model.UserVo;

//<bean id="" class=""
//@Repository에서 별다른 설정을 하지 않으면 스프링 빈 이름을 class 이름에서 첫글자를 소문자로 한
// 문자열이 스프링 빈의 이름으로 설정된다
// UserDaoImpl ==> userDaoImpl

//UserDao /UserDaoImpl ==> @resourse(name="UserDaoImpl") 
//UserDaoI /UserDao ==> @resourse(name="UserDao) 

@Repository("UserDao")
public class UserDao implements UserDaoImpl {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate template;

	// 20210304_LYS_Login3 - 로그인 구현
	// userid에 해당하는 사용자 한명의 정보 조회
	// 사용자 아이디로 사용자 조회 (경찬)a
	@Override
	public UserVo selectUser(String user_id) {
		return template.selectOne("users.selectUser", user_id);
	}

	// 20210304_LYS_Login3 - 회원가입 구현
	// 사용자 정보 추가
	@Override
	public int insertUser(UserVo userVo) {
		return template.update("users.insertUser", userVo);
	}
	
	// 20210305_LYS_Join - 아이디 중복 체크
	@Override
	public String checkForDuplicateId(String user_id) {
		return template.selectOne("users.checkForDuplicateId", user_id);
	}

	// 전체 사용자 정보 조회 (경찬)
	@Override
	public List<UserVo> selectAllUser() {
		return template.selectList("users.selectAllUser");
	}

	// 사용자 전체수 조회 (경찬)
	@Override
	public int selectAllUserCnt() {
		return template.selectOne("users.selectAllUserCnt");
	}

	// 사용자 삭제 03/04 (경찬)
	@Override
	public UserVo deleteUser(String user_id) {
		return template.selectOne("users.deleteUser", user_id);
	}

	// 관리자가 사용자 수정 03/05 (경찬)
	@Override
	public UserVo modifyUser(UserVo userVo) {
		return template.selectOne("users.modifyUser", userVo);
	}

}
