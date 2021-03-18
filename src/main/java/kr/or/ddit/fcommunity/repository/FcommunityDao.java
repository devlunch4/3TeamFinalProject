package kr.or.ddit.fcommunity.repository;

import java.util.List;

import kr.or.ddit.farm.model.MiniMarketVo;

// 20210318_ggy : FcommunityDao 생성
public interface FcommunityDao {
	
	// 20210318_ggy : 미니장터 글 전체 조회
	List<MiniMarketVo> selectAllMiniMarketList();
	
}
