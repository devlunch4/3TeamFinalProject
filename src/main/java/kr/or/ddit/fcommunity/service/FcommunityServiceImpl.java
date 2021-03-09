package kr.or.ddit.fcommunity.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.farm.model.FcommunityVo;
import kr.or.ddit.fcommunity.repository.FcommunityDao;

@Service("FcommuintyService")
public class FcommunityServiceImpl implements FcommunityService {
	
	@Resource(name="FcommunityDao")
	private FcommunityDao dao;
	
	//	20210308_SHS - 미니장터 게시글 리스트 조회
	@Override
	public List<FcommunityVo> selectmarket() {
		
		return dao.selectmarket();
	}
	
	//	20210308_SHS - 미니장터 게시글 상세 조회
	@Override
	public FcommunityVo selectonemarket(int market_no) {
		
		return dao.selectonemarket(market_no);
	}
	
	//	20210309_SHS - 미니장터 게시글 작성
	@Override
	public int registermarket(FcommunityVo coVo) {
		
		return dao.registermarket(coVo);
	}

	
}
