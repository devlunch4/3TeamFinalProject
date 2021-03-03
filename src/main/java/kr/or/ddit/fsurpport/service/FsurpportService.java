package kr.or.ddit.fsurpport.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.common.model.PageVoSearch_Farmdiary;
import kr.or.ddit.farm.model.FarmdiaryVo;

public interface FsurpportService {
	
	// ggy_20210303: 등록된 품목 리스트 조회
	List<FarmdiaryVo> selectAllFsurpportList();
	
	// ggy_20210303 : 등록된 영농일지 페이징 조회
	Map<String, Object> selectPagingFarmdiary(PageVo pageVo);
	
	// ggy_20210303 : 페이징 하기 위한 등록된 영농일지 리스트 전체 갯수 조회
	int selectAllFsurpportListCnt();
	
	// ggy_20210303: 등록된 품목 조회
	List<CodesVo> selectAllItem_codeList();
	
	// ggy_20210303 : 등록된 작업단계 조회
	List<CodesVo> selectAllWstep_codeList();
	
	// ggy_20210303 : 등록된 일지 조건 검색
	Map<String, Object> searchAllFarmdiaryPagingList(FarmdiaryVo farmdiaryVo);
	
	
	
}
