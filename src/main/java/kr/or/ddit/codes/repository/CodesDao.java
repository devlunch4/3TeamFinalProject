package kr.or.ddit.codes.repository;

import java.util.List;

import kr.or.ddit.common.model.CodesVo;

public interface CodesDao {

	// 모든 코드정보 조회 03/06 (경찬)
	List<CodesVo> allCodes();
	
	// 해당 코드상세 정보 조회 03/08 (경찬)
	CodesVo selectCodes(String code_seq);
}
