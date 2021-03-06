package kr.or.ddit.market.repositoryx;

import java.util.List;

import kr.or.ddit.farm.model.MarketVo;

public interface MarketDao {

	// 20210308_SHS - 미니장터 게시글 리스트 조회
	List<MarketVo> selectmarket();

	// 20210309_SHS - 미니장터 게시글 상세조회
	MarketVo selectonemarket(int market_no);
	
	// 20210309_SHS - 미니장터 카테고리 별 조회
	List<MarketVo> selectkate(int head_code);

	// 20210309_SHS - 미니장터 게시글 작성
	int registermarket(MarketVo coVo);
	
	// 20210312_SHS - 미니장터 게시글 수정
	int modifymarket(MarketVo coVo);

}
