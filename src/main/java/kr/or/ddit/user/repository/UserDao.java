package kr.or.ddit.user.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.common.model.PageVoSearch;
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
	
	
	
	
	// 전체 사용자 정보 조회
	@Override
	public List<UserVo> selectAllUser() {
		return template.selectList("users.selectAllUser");
	}

	// 페이지 처리
	@Override
	public List<UserVo> selectPagingUser(PageVo pageVo) {
		return template.selectList("users.selectPagingUser", pageVo);
	}

	// 사용자 전체수 조회
	@Override
	public int selectAllUserCnt() {
		return template.selectOne("users.selectAllUserCnt");
	}

	
	
	
	
	
//	// 사용자 정보 수정
//	@Override
//	public int modifyUser(UserVo userVo) {
//		return template.update("users.modifyUser", userVo);
//	}

	

//	// 사용자 삭제
//	@Override
//	public int deleteUser(String userid) {
//		return template.delete("users.deleteUser", userid);
//	}

//	// 아이디로 검색
//	@Override
//	public List<UserVo> idSearchUser(String userid) {
//		return template.selectList("users.idSearchUser", userid);
//	}

//	// 아이디로 검색한 회원수
//	@Override
//	public int idSearchUserCnt(String userid) {
//		return template.selectOne("users.idSearchUserCnt", userid);
//	}

//	// 아이디로 검색한 회원 페이징
//	@Override
//	public List<UserVo> idSearchUserPaging(PageVoSearch pageVoSearch) {
//		return template.selectList("users.idSearchUserPaging", pageVoSearch);
//	}

//	// 이름으로 검색
//	@Override
//	public List<UserVo> nameSearchUser(String usernm) {
//		//
//		return template.selectList("users.nameSearchUser", usernm);
//	}

//	// 이름으로 검색한 회원수
//	@Override
//	public int nameSearchUserCnt(String usernm) {
//		return template.selectOne("users.nameSearchUserCnt", usernm);
//	}

//	// 이름으로 검색한 회원 페이징
//	@Override
//	public List<UserVo> nameSearchUserPaging(PageVoSearch pageVoSearch) {
//		return template.selectList("users.nameSearchUserPaging", pageVoSearch);
//	}

//	// 별명으로 검색
//	@Override
//	public List<UserVo> aliasSearchUser(String alias) {
//		return template.selectList("users.aliasSearchUser", alias);
//	}

//	// 별명으로 검색한 회원 수
//	@Override
//	public int aliasSearchUserCnt(String alias) {
//		return template.selectOne("users.aliasSearchUserCnt", alias);
//	}

//	// 별명으로 검색한 회원 페이징
//	@Override
//	public List<UserVo> aliasSearchUserPaging(PageVoSearch pageVoSearch) {
//		return template.selectList("users.aliasSearchUserPaging", pageVoSearch);
//	}

}
