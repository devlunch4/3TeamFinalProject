package kr.or.ddit.fsurpport.service;

import java.util.Map;

import kr.or.ddit.common.model.PageVo;

public interface FsurpportService {
	
	// ggy_20210302 : 등록된 영농일지 페이징 조회
	Map<String, Object> selectPagingFarmdiary(PageVo pageVo);
	
	// ggy_20210302 : 페이징 하기 위한 등록된 영농일지 리스트 전체 갯수 조회
	int selectAllFsurpportListCnt();
	
//	
//	// ggy_20210227 : 등록된 영농일지 조회
//	List<FarmdiaryVo> selectAllFsurpportList();
//	
//	// ggy_20210227 : 등록된 작업단계 조회
//	List<WorkstepsVo> selectAllWorkstepsList();
//	
//	// ggy_20210227 : 등록된 품목 조회
//	List<ItemsVo> selectAllItemsList();
//	
//	// ggy_20210227 : 등록된 품목 검색
//	List<FarmdiaryVo> searchAllFsurpportList(FarmdiaryVo fsurpportVo);
//	
//	
	
}
