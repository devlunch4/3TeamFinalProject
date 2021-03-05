package kr.or.ddit.finfo.service;

import java.util.List;

import kr.or.ddit.farm.model.GardenguidesVo;
import kr.or.ddit.farm.model.GuideSqlVo;

public interface FinfoService {

	// 20210305 KWS 텃밭 가이드 조회 (텃밭코드로 조회)
	GardenguidesVo selectGuide(int xgrdgd_code);

	// 20210305 KWS 텃밭 가이드 리스트 초성 조회 (쿼리문으로 조회)
	List<GardenguidesVo> selectGuideList(GuideSqlVo guideSqlVo);
}
