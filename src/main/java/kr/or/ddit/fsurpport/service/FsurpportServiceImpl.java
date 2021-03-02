package kr.or.ddit.fsurpport.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.farm.model.FarmdiaryVo;
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

	// ggy_20210302 : 등록된 영농일지 페이징 처리 조회
	@Override
	public Map<String, Object> selectPagingFarmdiary(PageVo pageVo) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<FarmdiaryVo> farmdiaryList = fsurpportDao.selectPagingFarmdiary(pageVo);
		
		int farmdiaryCnt = fsurpportDao.selectAllFsurpportListCnt();
		
		map.put("farmdiaryList", farmdiaryList);
		map.put("farmdiaryCnt", farmdiaryCnt);
		map.put("pageVo", pageVo);
		
		int pagination = (int)Math.ceil((double) farmdiaryCnt / pageVo.getPageSize());
		map.put("pagination", pagination);
		
		return map;
		
	}

	// ggy_20210302 : 등록된 영농일지 전체 리스트 갯수 조회
	@Override
	public int selectAllFsurpportListCnt() {
		return fsurpportDao.selectAllFsurpportListCnt();
	}
	
	
}
