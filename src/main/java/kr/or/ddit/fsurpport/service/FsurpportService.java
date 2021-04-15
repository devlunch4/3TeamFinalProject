package kr.or.ddit.fsurpport.service;

import java.util.List;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.common.model.FilesVo;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.farm.model.FhistoryVo;
import kr.or.ddit.farm.model.FmanageVo;
import kr.or.ddit.farm.model.MsrequipVo;
import kr.or.ddit.farm.model.MsrrecVo;
import kr.or.ddit.farm.model.MySimpleCodeVo;

public interface FsurpportService {

	// ggy_20210309: 유저의 등록된 품목 리스트 조회
	List<FarmdiaryVo> selectAllFsurpportList(String user_id);

	// ggy_20210303: 등록된 품목 조회
	List<CodesVo> selectAllItem_codeList();

	// ggy_20210315 : 등록된 작업단계 조회 수정
	List<CodesVo> selectAllW_step_codeList(String parent_code);

	// ggy_20210305 : 등록된 사업유형 조회
	List<CodesVo> selectAllB_type_codeList();

	// ggy_20210305 : 등록한 나만의 영농일지-간편등록 목록 조회
	List<MySimpleCodeVo> selectMySimpleCodeList(String user_id);

	// ggy_20210305 : 등록한 나만의 영농일지-나의 간편등록 조회 해서 배치
	MySimpleCodeVo selectMySimpleCodeInfo(MySimpleCodeVo mySimpleCodeVo);

	// ggy_20210308 : 농업지원-영농일지 내 간편등록을 위해 사업 유형 코드 조회
	CodesVo selectB_type_code_no(String code_no);

	// ggy_20210308 : 농업지원-영농일지 내 간편등록을 위해 품목 코드 조회
	CodesVo selectItem_type_code_no(String code_no);

	// ggy_20210308 : 농업지원-영농일지 내 간편등록 작성한걸 등록
	int registMySimpleCode(MySimpleCodeVo mySimpleCodeVo);

	// ggy_20210303 : 등록된 일지 조건 검색
	List<FarmdiaryVo> searchAllFarmdiaryList(FarmdiaryVo farmdiaryVo);

	// ggy_20210305 : 해당 일지 정보 조회
	FarmdiaryVo selectFarmdiaryInfo(int f_diary_no);

	// ggy_20210308 : 일지 등록을 위해 일지 정보 가져오기
	MySimpleCodeVo selectMySimpleCode_noInfo(MySimpleCodeVo mySimpleCodeVo);

	// ggy_20210305 : 일지 등록때 파일 있으면 파일 등록
	int registFiles(FilesVo filesVo);

	// ggy_20210308 : 일지 등록을 위한 등록된 파일 정보 가져오기
	FilesVo selectFilesInfo(int file_no);

	// ggy_20210305 : 일지 등록
	int registFarmdiary(FarmdiaryVo farmdiaryVo);

	// ggy_20210309 : 영농일지 일지내용 수정
	int modifyFarmdiaryInfo(FarmdiaryVo farmdiaryVo);

	// ggy_20210309 : 영농일지 파일 삭제 시파일 코드 삭제
	int deleteFile_no(int file_no);

	// ggy_20210309 : 해당 영농일지 삭제
	int deleteFarmdiary(FarmdiaryVo farmdiaryVo);

	/* 시설관리 영역 */

	// 20210308_KJH 시설리스트 조회 수정 ok
	List<FmanageVo> myfmanageList();
	
	//20210330_KJH 시설 리스트 유저로조회
	List<FmanageVo> selmyfmanageList(String str);

	// 20210308_KJH 시설 상세조회 수정 ok
	FmanageVo fmanageInfo(String str);

	// 20210304_KJH 시설 최근 측정정보 조회 ok
	MsrrecVo latelyData(FhistoryVo fhistoryVo);

	// 20210308_KJH 보유 장비 조회 수정 ok
	List<MsrequipVo> msrequipList(String owner);

	// 등록된 시설 카운트 03/04 (경찬)
	int fmanageCount(String user_id);

	// 등록된 일지 카운트 03/04 (경찬)
	int fsurCount(String user_id);

	// 20210310_KJH 사용 가능한 장비 체크 ok
	int availableList(MsrequipVo vo);

	// 20210310_KJH 내 장비리스트 조회 ok
	List<MsrequipVo> msrList(String str);

	// 20210311_KJH 시설등록 ok
	int insertFmanage(FmanageVo fmanagvo);

	// 20210311_KJH fhistory 등록 ok
	int insertFhistory(FhistoryVo fhistoryVo);

	// 20210311_KJH Fmanage 조회 ok
	FmanageVo updatefmanageInfo(String str);
	
	// 20210311_KJH Fmanage 업데이트 ok
	int fmanageUpdate(FmanageVo fmanageVo);
	
	// 20210311_KJH Fmanage 업데이트(삭제) ok
	int fmanageDelete(FmanageVo fmanageVo);
	
	// 20210311_KJH fhistory 업데이트(삭제) ok
	int fhistoryDelete(FmanageVo fmanageVo);
	
	// 20210311_KJH 내 수확량 조회 ok
	List<FarmdiaryVo> myYield(FarmdiaryVo vo);
	
	// 20210317_KJH 전체 장비 조회 ok
	List<MsrequipVo> msrallList();
	
	// 20210317_KJH 장비 업데이트 ok
	int msrUpdate(MsrequipVo vo);
	
	// 20210317_KJH 사용자의 장비 등록 ok
	int msrSet(MsrequipVo vo);
	
	//20210317_KJH 사용 가능한 장비인지 체크 ok
	int msrSelect(String str);
}
