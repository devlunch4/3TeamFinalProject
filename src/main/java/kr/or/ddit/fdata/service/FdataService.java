package kr.or.ddit.fdata.service;

import java.util.List;

import kr.or.ddit.common.model.CodesVo;

public interface FdataService {
	// 20210302_KJH
	// codes 리스트 전체조회
	List<CodesVo> selectAllCodes();

}