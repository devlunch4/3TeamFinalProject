package kr.or.ddit.fcommunity.service;

import java.util.List;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.farm.model.MiniMarketVo;

// 20210318_ggy : FcommunityService 생성
public interface FcommunityService {
	
	
	// 20210318_ggy : 미니장터 글 전체 조회
	List<MiniMarketVo> selectAllMiniMarketList();
	
	// 20210319_ggy: 미니장터 등록을 위한 머릿맛 코드 조회
	List<CodesVo> selectMiniMarketList();
	
	
	
	
	
	
	
	
	
}
