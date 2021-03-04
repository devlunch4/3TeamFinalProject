package kr.or.ddit.fsurpport.service;

import java.util.List;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.farm.model.FcltmngVo;

public interface FsurpportService {

	// ggy_20210303: 등록된 품목 리스트 조회
	List<FarmdiaryVo> selectAllFsurpportList();

	// ggy_20210303: 등록된 품목 조회
	List<CodesVo> selectAllItem_codeList();

	// ggy_20210303 : 등록된 작업단계 조회
	List<CodesVo> selectAllWstep_codeList();

	// ggy_20210303 : 등록된 일지 조건 검색
	List<FarmdiaryVo> searchAllFarmdiaryList(FarmdiaryVo farmdiaryVo);

	/* 시설관리 영역 */

	// 20210302_KJH 시설리스트 조회
	List<FcltmngVo> myfcltmngList();

	// 20210302_KJH 시설 상세조회
	FcltmngVo fcltmngInfo(String str);

	// 등록된 시설 카운트 03/04 (경찬)
	int fcltmngCount(String user_id);

	// 등록된 일지 카운트 03/04 (경찬)
	int fsurCount(String user_id);

}
