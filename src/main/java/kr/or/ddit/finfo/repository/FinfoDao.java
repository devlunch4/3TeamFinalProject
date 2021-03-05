package kr.or.ddit.finfo.repository;

import kr.or.ddit.farm.model.GardenguidesVo;

public interface FinfoDao {

	
	// 20210305 KWS 텃밭 가이드 조회 (텃밭코드로 조회)
	GardenguidesVo selectGuide(int xgrdgd_code);
}
