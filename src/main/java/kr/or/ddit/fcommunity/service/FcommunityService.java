package kr.or.ddit.fcommunity.service;

import java.util.List;

import kr.or.ddit.farm.model.MiniMarketVo;

// 20210318_ggy : FcommunityService 생성
public interface FcommunityService {
	
	
	// 20210318_ggy : 미니장터 글 전체 조회
	List<MiniMarketVo> selectAllMiniMarketList();
	
}
