package kr.or.ddit.fsurpport.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.farm.model.FcltmngVo;
import kr.or.ddit.farm.model.MsrequipVo;
import kr.or.ddit.farm.model.MsrrecVo;
import kr.or.ddit.fsurpport.repository.FsurpportDao;

@Service("fsurpportService")
public class FsurpportServiceImpl implements FsurpportService {

	private static final Logger logger = LoggerFactory.getLogger(FsurpportServiceImpl.class);

	@Resource(name = "fsurpportDao")
	private FsurpportDao fsurpportDao;

	public FsurpportServiceImpl() {
	}

	// ggy_20210303 : 등록된 일지 전체 리스트 조회
	@Override
	public List<FarmdiaryVo> selectAllFsurpportList() {
		return fsurpportDao.selectAllFsurpportList();
	}

	public FsurpportServiceImpl(FsurpportDao fsurpportDao) {
		this.fsurpportDao = fsurpportDao;
	}

	// ggy_20210303 : 등록된 품목코드 리스트 조회
	@Override
	public List<CodesVo> selectAllItem_codeList() {
		return fsurpportDao.selectAllItem_codeList();
	}

	// ggy_20210303 : 등록된 작업단계코드 리스트 조회
	@Override
	public List<CodesVo> selectAllWstep_codeList() {
		return fsurpportDao.selectAllWstep_codeList();
	}

	// ggy_20210303 : 등록된 일지 조건 검색
	@Override
	public List<FarmdiaryVo> searchAllFarmdiaryList(FarmdiaryVo farmdiaryVo) {

		return fsurpportDao.searchAllFarmdiaryList(farmdiaryVo);

	}

	/* 시설관리 영역 */
	@Override
	public List<FcltmngVo> myfcltmngList() {

		return fsurpportDao.myfcltmngList();
	}
	// 20210302_KJH 시설 상세조회
	@Override
	public FcltmngVo fcltmngInfo(String str) {

		return fsurpportDao.fcltmngInfo(str);

	}
	// 20210304_KJH 최근 측정값 조회
	@Override
	public MsrrecVo latelyData(String msr_code) {

		return fsurpportDao.latelyData(msr_code);
	}

	@Override
	public List<MsrequipVo> msrequipList(String owner) {
		return fsurpportDao.msrequipList(owner);
	}
	
	
}
