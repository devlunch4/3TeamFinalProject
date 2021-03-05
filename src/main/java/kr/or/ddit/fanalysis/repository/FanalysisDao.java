package kr.or.ddit.fanalysis.repository;

import kr.or.ddit.farm.model.MsrrecVo;

public interface FanalysisDao {
	// 20210304_KJH 내 시설 관측정보 조회
	MsrrecVo myfanalysisInfo(MsrrecVo msrrecVo);

}
