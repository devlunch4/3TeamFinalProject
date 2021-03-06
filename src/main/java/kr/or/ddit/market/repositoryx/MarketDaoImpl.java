package kr.or.ddit.market.repositoryx;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.farm.model.MarketVo;

@Repository("marketDao")
public class MarketDaoImpl implements MarketDao {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate template;

	// 20210308_SHS - 미니장터 게시글 리스트 조회
	@Override
	public List<MarketVo> selectmarket() {

		return template.selectList("market.selectmarket");
	}

	// 20210309_SHS - 미니장터 게시글 조회
	@Override
	public MarketVo selectonemarket(int market_no) {

		return template.selectOne("market.selectonemarket", market_no);
	}

	// 20210309_SHS - 미니장터 게시글 작성
	@Override
	public int registermarket(MarketVo coVo) {

		return template.insert("market.registermarket", coVo);
	}

	// 20210312_SHS - 미니장터 게시글 작성완료
	@Override
	public int modifymarket(MarketVo coVo) {

		return template.update("market.modifymarket", coVo);
	}

	// 20210312_SHS - 미니장터 게시글 카테고리 별 조회
	@Override
	public List<MarketVo> selectkate(int head_code) {

		return template.selectList("market.selectkate", head_code);
	}

}
