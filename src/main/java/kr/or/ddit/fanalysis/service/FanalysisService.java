package kr.or.ddit.fanalysis.service;

import java.util.List;

import kr.or.ddit.fanalysis.model.MyMaxMrrecListVo;
import kr.or.ddit.farm.model.FhistoryVo;
import kr.or.ddit.farm.model.FmanageVo;
import kr.or.ddit.farm.model.MsrrecVo;

public interface FanalysisService {

	// 20210304_KJH 내 시설 관측정보 조회 OK
	MyMaxMrrecListVo myfanalysisInfo(MyMaxMrrecListVo mymaxmrreclistVo);

	// 20210305_KJH 내 시설 실시간 관측 조회 OK
	MyMaxMrrecListVo mymaxmsrrecList(FhistoryVo fhistoryVo);

	// 20210315_KJH 내 시설 관측정보 조회 ver 2 - 보유 시설 조회 ok
	List<FmanageVo> selectFmanage(String str);

	// 20210315_KJH 내 시설 평균 관측정보 조회 ver 2 ok
	MsrrecVo avgFmanage(MsrrecVo msrrecVo);

	// 20210315_KJH 작물의 적정온도 조회 ok
	List<MyMaxMrrecListVo> selectTempList();
}
