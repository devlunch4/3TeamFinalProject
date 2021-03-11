package kr.or.ddit.market.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.farm.model.MarketVo;

@Repository("FcommunityDao")
public class MarketDaoImpl implements MarketDao {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate template;

	// 20210308_SHS - 미니장터 게시글 리스트 조회
	@Override
	public List<MarketVo> selectmarket() {

		return template.selectList("market.selectmarket");
	}

	// 20210309_SHS - 미니장터 게시글 작성
	@Override
	public MarketVo selectonemarket(int market_no) {

		return template.selectOne("market.selectonemarket", market_no);
	}

	// 20210309_SHS - 미니장터 게시글 작성
	@Override
	public int registermarket(MarketVo coVo) {

		return template.insert("market.registermarket", coVo);
	}

}
