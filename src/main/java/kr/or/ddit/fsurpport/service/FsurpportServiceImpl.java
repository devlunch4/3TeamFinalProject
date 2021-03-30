package kr.or.ddit.fsurpport.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.common.model.FilesVo;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.farm.model.FhistoryVo;
import kr.or.ddit.farm.model.FmanageVo;
import kr.or.ddit.farm.model.MsrequipVo;
import kr.or.ddit.farm.model.MsrrecVo;
import kr.or.ddit.farm.model.MySimpleCodeVo;
import kr.or.ddit.fsurpport.repository.FsurpportDao;

@Service("fsurpportService")
public class FsurpportServiceImpl implements FsurpportService {

	@Resource(name = "fsurpportDao")
	private FsurpportDao fsurpportDao;

	public FsurpportServiceImpl() {
	}

	// ggy_20210303 : 등록된 일지 전체 리스트 조회
	@Override
	public List<FarmdiaryVo> selectAllFsurpportList(String user_id) {
		return fsurpportDao.selectAllFsurpportList(user_id);
	}

	public FsurpportServiceImpl(FsurpportDao fsurpportDao) {
		this.fsurpportDao = fsurpportDao;
	}

	// ggy_20210303 : 등록된 품목코드 리스트 조회
	@Override
	public List<CodesVo> selectAllItem_codeList() {
		return fsurpportDao.selectAllItem_codeList();
	}

	// ggy_20210306 : 등록된 작업단계코드 리스트 조회 수정
	@Override
	public List<CodesVo> selectAllW_step_codeList(String parent_code) {
		return fsurpportDao.selectAllW_step_codeList(parent_code);
	}

	// ggy_20210305 : 등록된 사업유형 조회
	public List<CodesVo> selectAllB_type_codeList() {
		return fsurpportDao.selectAllB_type_codeList();
	}

	// ggy_20210305 : 등록한 나만의 영농일지-간편등록 목록 조회
	@Override
	public List<MySimpleCodeVo> selectMySimpleCodeList(String user_id) {
		return fsurpportDao.selectMySimpleCodeList(user_id);
	}

	// ggy_20210305 : 등록한 나만의 영농일지-나의 간편등록 조회 해서 배치
	@Override
	public MySimpleCodeVo selectMySimpleCodeInfo(MySimpleCodeVo mySimpleCodeVo) {
		return fsurpportDao.selectMySimpleCodeInfo(mySimpleCodeVo);
	}

	// ggy_20210308 : 농업지원-영농일지 내 간편등록을 위해 사업 유형 코드 조회
	@Override
	public CodesVo selectB_type_code_no(String code_no) {
		return fsurpportDao.selectB_type_code_no(code_no);
	}

	// ggy_20210308 : 농업지원-영농일지 내 간편등록을 위해 품목 코드 조회
	@Override
	public CodesVo selectItem_type_code_no(String code_no) {
		return fsurpportDao.selectItem_type_code_no(code_no);
	}

	// ggy_20210308 : 농업지원-영농일지 내 간편등록 작성한걸 등록
	@Override
	public int registMySimpleCode(MySimpleCodeVo mySimpleCodeVo) {
		return fsurpportDao.registMySimpleCode(mySimpleCodeVo);
	}

	// ggy_20210303 : 등록된 일지 조건 검색
	@Override
	public List<FarmdiaryVo> searchAllFarmdiaryList(FarmdiaryVo farmdiaryVo) {

		return fsurpportDao.searchAllFarmdiaryList(farmdiaryVo);

	}

	// ggy_20210305 : 해당 일지 조회
	@Override
	public FarmdiaryVo selectFarmdiaryInfo(int f_diary_no) {
		return fsurpportDao.selectFarmdiaryInfo(f_diary_no);
	}

	// ggy_20210308 : 일지 등록을 위해 일지 정보 가져오기
	@Override
	public MySimpleCodeVo selectMySimpleCode_noInfo(MySimpleCodeVo mySimpleCodeVo) {
		return fsurpportDao.selectMySimpleCode_noInfo(mySimpleCodeVo);
	}

	// ggy_20210305 : 영농일지 등록때 파일 있으면 파일 등록
	@Override
	public int registFiles(FilesVo filesVo) {
		return fsurpportDao.registFiles(filesVo);
	}

	// ggy_20210308 : 영농일지 등록을 위한 등록된 파일 정보 가져오기
	@Override
	public FilesVo selectFilesInfo(int file_no) {
		return fsurpportDao.selectFilesInfo(file_no);
	}

	// ggy_20210305 : 영농일지 등록
	@Override
	public int registFarmdiary(FarmdiaryVo farmdiaryVo) {
		return fsurpportDao.registFarmdiary(farmdiaryVo);
	}

	// ggy_20210309 : 영농일지 일지내용 수정
	@Override
	public int modifyFarmdiaryInfo(FarmdiaryVo farmdiaryVo) {
		return fsurpportDao.modifyFarmdiaryInfo(farmdiaryVo);
	}

	// ggy_20210309 : 영농일지 파일 삭제 시파일 코드 삭제
	@Override
	public int deleteFile_no(int file_no) {
		return fsurpportDao.deleteFile_no(file_no);
	}

	// ggy_20210309 : 해당 영농일지 삭제
	@Override
	public int deleteFarmdiary(FarmdiaryVo farmdiaryVo) {
		return fsurpportDao.deleteFarmdiary(farmdiaryVo);
	}

	/* 시설관리 영역 */
	@Override
	public List<FmanageVo> myfmanageList() {
		return fsurpportDao.myfmanageList();
	}
	
	// 20210330_KJH 시설 리스트 유저조건 검색
	@Override
	public List<FmanageVo> selmyfmanageList(String str) {
		return fsurpportDao.selmyfmanageList(str);
	}

	// 20210308_KJH 시설 상세조회 수정
	@Override
	public FmanageVo fmanageInfo(String str) {
		return fsurpportDao.fmanageInfo(str);

	}

	// 20210308_KJH 최근 측정값 조회 수정
	@Override
	public MsrrecVo latelyData(FhistoryVo fhistoryVo) {

		return fsurpportDao.latelyData(fhistoryVo);
	}

	// 20210308_KJH 보유 장비 조회 수정
	@Override
	public List<MsrequipVo> msrequipList(String owner) {
		return fsurpportDao.msrequipList(owner);
	}

	// 등록된 시설 카운트 03/04 (경찬)
	@Override
	public int fmanageCount(String user_id) {
		return fsurpportDao.fmanageCount(user_id);
	}

	// 등록된 일지 카운트 03/04 (경찬)
	@Override
	public int fsurCount(String user_id) {
		return fsurpportDao.fsurCount(user_id);
	}

	// 20210310_KJH 사용 가능한 장비 체크
	@Override
	public int availableList(MsrequipVo vo) {
		return fsurpportDao.availableList(vo);
	}

	// 20210310_KJH 내 장비리스트 조회
	@Override
	public List<MsrequipVo> msrList(String str) {
		return fsurpportDao.msrList(str);
	}

	// 20210311_KJH 시설등록
	@Override
	public int insertFmanage(FmanageVo fmanagvo) {
		return fsurpportDao.insertFmanage(fmanagvo);
	}

	// 20210311_KJH fhistory 등록
	@Override
	public int insertFhistory(FhistoryVo fhistoryVo) {
		return fsurpportDao.insertFhistory(fhistoryVo);
	}

	// 20210311_KJH Fmanage 조회
	@Override
	public FmanageVo updatefmanageInfo(String str) {
		return fsurpportDao.updatefmanageInfo(str);
	}

	// 20210311_KJH Fmanage 업데이트
	@Override
	public int fmanageUpdate(FmanageVo fmanageVo) {
		return fsurpportDao.fmanageUpdate(fmanageVo);
	}

	// 20210311_KJH Fmanage 업데이트(삭제)
	@Override
	public int fmanageDelete(FmanageVo fmanageVo) {
		return fsurpportDao.fmanageDelete(fmanageVo);
	}

	// 20210311_KJH fhistory 업데이트(삭제)
	@Override
	public int fhistoryDelete(FmanageVo fmanageVo) {
		return fsurpportDao.fhistoryDelete(fmanageVo);
	}

	// 20210311_KJH 내 수확량 조회
	@Override
	public List<FarmdiaryVo> myYield(FarmdiaryVo vo) {
		return fsurpportDao.myYield(vo);
	}

	@Override
	public List<MsrequipVo> msrallList() {
		return fsurpportDao.msrallList();
	}

	@Override
	public int msrUpdate(MsrequipVo vo) {
		return fsurpportDao.msrUpdate(vo);
	}

	@Override
	public int msrSet(MsrequipVo vo) {
		return fsurpportDao.msrSet(vo);
	}

	@Override
	public int msrSelect(String str) {
		return fsurpportDao.msrSelect(str);
	}

}
