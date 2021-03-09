package kr.or.ddit.fcommunity.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.farm.model.FcommunityVo;

@Repository("FcommunityDao")
public class FcommunityDaoImpl implements FcommunityDao {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	// 20210308_SHS - 미니장터 게시글 리스트 조회
	@Override
	public List<FcommunityVo> selectmarket() {
		
		return template.selectList("community.selectmarket");
	}
	
	// 20210309_SHS - 미니장터 게시글 작성
	@Override
	public FcommunityVo selectonemarket(int market_no) {
		
		return template.selectOne("community.selectonemarket", market_no);
	}
	
	// 20210309_SHS - 미니장터 게시글 작성
	@Override
	public int registermarket(FcommunityVo coVo) {
		
		return template.insert("community.registermarket", coVo);
	}


}
