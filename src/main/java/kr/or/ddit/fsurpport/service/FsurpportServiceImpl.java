package kr.or.ddit.fsurpport.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.farm.model.ItemsVo;
import kr.or.ddit.farm.model.WorkstepsVo;
import kr.or.ddit.fsurpport.repository.FsurpportDao;

@Service("fsurpportService")
public class FsurpportServiceImpl implements FsurpportService {

	private static final Logger logger = LoggerFactory.getLogger(FsurpportServiceImpl.class);

	@Resource(name = "fsurpportDao")
	private FsurpportDao fsurpportDao;

	public FsurpportServiceImpl() {
	}

	public FsurpportServiceImpl(FsurpportDao fsurpportDao) {
		this.fsurpportDao = fsurpportDao;
	}

	// ggy_20210227 : 등록된 영농일지 조회
	@Override
	public List<FarmdiaryVo> selectAllFsurpportList() {
		logger.debug("in selectAllFsurpportList()");
		return fsurpportDao.selectAllFsurpportList();
	}

	// ggy_20210227 : 등록된 작업단계 조회
	@Override
	public List<WorkstepsVo> selectAllWorkstepsList() {
		return fsurpportDao.selectAllWorkstepsList();
	}

	// ggy_20210227 : 등록된 품목 조회
	@Override
	public List<ItemsVo> selectAllItemsList() {
		return fsurpportDao.selectAllItemsList();
	}

	// ggy_20210227 : 등록된 품목 검색
	@Override
	public List<FarmdiaryVo> searchAllFsurpportList(FarmdiaryVo farmdiaryVo) {
		return fsurpportDao.searchAllFsurpportList(farmdiaryVo);
	}
}
