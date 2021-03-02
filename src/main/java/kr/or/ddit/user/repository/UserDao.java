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
	private SqlSessionTemplate tempplate;

//	// 사용자 아이디로 사용자 조회
//	@Override
	public UserVo selectUser(String userid) {
		return tempplate.selectOne("users.selectUser", userid);
	}
//	
//	// 전체 사용자 정보 조회
//	@Override
//	public List<UserVo> selectAllUser() {
//		return tempplate.selectList("users.selectAllUser");
//	}

//	// 페이지 처리
//	@Override
//	public List<UserVo> selectPagingUser(PageVo pageVo) {
//		return tempplate.selectList("users.selectPagingUser", pageVo);
//	}
//
//	// 사용자 전체수 조회
//	@Override
//	public int selectAllUserCnt() {
//		return tempplate.selectOne("users.selectAllUserCnt");
//	}
//
//	// 사용자 정보 수정
//	@Override
//	public int modifyUser(UserVo userVo) {
//		return tempplate.update("users.modifyUser", userVo);
//	}
//
//	// 사용자 정보 추가
//	@Override
//	public int insertUser(UserVo userVo) {
//		return tempplate.update("users.insertUser", userVo);
//	}
//
//	// 사용자 삭제
//	@Override
//	public int deleteUser(String userid) {
//		return tempplate.delete("users.deleteUser", userid);
//	}
//
//	// 아이디로 검색
//	@Override
//	public List<UserVo> idSearchUser(String userid) {
//		return tempplate.selectList("users.idSearchUser", userid);
//	}
//
//	// 아이디로 검색한 회원수
//	@Override
//	public int idSearchUserCnt(String userid) {
//		return tempplate.selectOne("users.idSearchUserCnt", userid);
//	}
//
//	// 아이디로 검색한 회원 페이징
//	@Override
//	public List<UserVo> idSearchUserPaging(PageVoSearch pageVoSearch) {
//		return tempplate.selectList("users.idSearchUserPaging", pageVoSearch);
//	}
//
//	// 이름으로 검색
//	@Override
//	public List<UserVo> nameSearchUser(String usernm) {
//		//
//		return tempplate.selectList("users.nameSearchUser", usernm);
//	}
//
//	// 이름으로 검색한 회원수
//	@Override
//	public int nameSearchUserCnt(String usernm) {
//		return tempplate.selectOne("users.nameSearchUserCnt", usernm);
//	}
//
//	// 이름으로 검색한 회원 페이징
//	@Override
//	public List<UserVo> nameSearchUserPaging(PageVoSearch pageVoSearch) {
//		return tempplate.selectList("users.nameSearchUserPaging", pageVoSearch);
//	}
//
//	// 별명으로 검색
//	@Override
//	public List<UserVo> aliasSearchUser(String alias) {
//		return tempplate.selectList("users.aliasSearchUser", alias);
//	}
//
//	// 별명으로 검색한 회원 수
//	@Override
//	public int aliasSearchUserCnt(String alias) {
//		return tempplate.selectOne("users.aliasSearchUserCnt", alias);
//	}
//
//	// 별명으로 검색한 회원 페이징
//	@Override
//	public List<UserVo> aliasSearchUserPaging(PageVoSearch pageVoSearch) {
//		return tempplate.selectList("users.aliasSearchUserPaging", pageVoSearch);
//	}

}
