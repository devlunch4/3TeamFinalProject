package kr.or.ddit.fcommunity.repository;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("FcommunityDao")
public class FcommunityDaoImpl implements FcommunityDao {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate template;

}
