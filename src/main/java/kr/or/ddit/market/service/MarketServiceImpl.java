package kr.or.ddit.market.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.farm.model.MarketVo;
import kr.or.ddit.market.repository.MarketDao;

@Service("FcommuintyService")
public class MarketServiceImpl implements MarketService {
	
	@Resource(name="FcommunityDao")
	private MarketDao dao;
	
	//	20210308_SHS - 미니장터 게시글 리스트 조회
	@Override
	public List<MarketVo> selectmarket() {
		
		return dao.selectmarket();
	}
	
	//	20210308_SHS - 미니장터 게시글 상세 조회
	@Override
	public MarketVo selectonemarket(int market_no) {
		
		return dao.selectonemarket(market_no);
	}
	
	//	20210309_SHS - 미니장터 게시글 작성
	@Override
	public int registermarket(MarketVo coVo) {
		
		return dao.registermarket(coVo);
	}

	
}
