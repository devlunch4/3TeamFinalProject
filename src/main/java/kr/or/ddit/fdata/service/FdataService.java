package kr.or.ddit.fdata.service;

import java.util.List;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.farm.model.MsrrecVo;

public interface FdataService {
	// 20210302_KJH
	// codes 리스트 전체조회
	List<CodesVo> selectAllCodes();

	CodesVo selectCode(String str);

	//OK
	List<FarmdiaryVo> farmCount();

	// 20210310_KJH 날짜조건 품목비율 OK
	List<FarmdiaryVo> datefarmCount(FarmdiaryVo vo);
	
	// 20210330 KJH 측정값저장
	int addData(MsrrecVo vo);
}