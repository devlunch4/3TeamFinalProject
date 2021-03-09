package kr.or.ddit.fcommunity.service;

import java.util.List;

import kr.or.ddit.farm.model.FcommunityVo;

public interface FcommunityService {
	
	// 20210308_SHS - 미니장터 게시글 리스트 조회
	List<FcommunityVo> selectmarket();
	
	// 20210309_SHS - 미니장터 게시글 상세조회
	FcommunityVo selectonemarket(int market_no);
	
	// 20210309_SHS - 미니장터 게시글 작성
	int registermarket(FcommunityVo coVo);
}
