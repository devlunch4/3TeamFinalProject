package kr.or.ddit.fsurpport.repository;

import java.util.List;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.farm.model.FcltmngVo;
import kr.or.ddit.farm.model.WorkstepsVo;

public interface FsurpportDao {
	
	// ggy_20210227 : 등록된 영농일지 조회
	List<FarmdiaryVo> selectAllFsurpportList();
	
	// ggy_20210227 : 등록된 작업단계 조회
	List<WorkstepsVo> selectAllWorkstepsList();
		
	// ggy_20210227 : 등록된 품목 조회
	List<CodesVo> selectAllItemsList();
	
	// ggy_20210227 : 등록된 품목 검색
	List<FarmdiaryVo> searchAllFsurpportList(FarmdiaryVo fsurpportVo);

	
	
	
	
	
	/*시설관리 영역*/
	//20210302_KJH 시설리스트 조회
	List<FcltmngVo> myfcltmngList();
	
	//20210302_KJH 시설 상세조회
	FcltmngVo fcltmngInfo(String str);
}
