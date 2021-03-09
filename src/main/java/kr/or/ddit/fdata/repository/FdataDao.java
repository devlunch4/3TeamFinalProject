package kr.or.ddit.fdata.repository;

import java.util.List;

import kr.or.ddit.common.model.CodesVo;

public interface FdataDao {

	// 20210302_KJH
	// codes 리스트 전체조회
	List<CodesVo> selectcodes();

	CodesVo selectCode(String str);
}
