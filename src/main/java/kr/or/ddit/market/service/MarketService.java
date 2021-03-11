package kr.or.ddit.market.service;

import java.util.List;

import kr.or.ddit.farm.model.MarketVo;

public interface MarketService {

	// 20210308_SHS - 미니장터 게시글 리스트 조회
	List<MarketVo> selectmarket();

	// 20210309_SHS - 미니장터 게시글 상세조회
	MarketVo selectonemarket(int market_no);

	// 20210309_SHS - 미니장터 게시글 작성
	int registermarket(MarketVo coVo);
}
