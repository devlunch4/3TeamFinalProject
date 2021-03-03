package kr.or.ddit.fsurpport.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.farm.model.FarmdiaryVo;

@Repository("fsurpportDao")
public class FsurpportDaoImpl implements FsurpportDao{
	
	private static final Logger logger = LoggerFactory.getLogger(FsurpportDaoImpl.class);
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	// ggy_20210303 : 등록된 영농일지 전체 리스트 조회
	@Override
	public List<FarmdiaryVo> selectAllFsurpportList() {
		return template.selectList("fsurpports.selectAllFsurpportList");
	}
	
	// ggy_20210303 : 등록된 영농일지 전체 리스트 겟수 조회
	@Override
	public int selectAllFsurpportListCnt() {
		return template.selectOne("fsurpports.selectAllFsurpportListCnt");
	}
	
	// ggy_20210303 : 등록된 영농일치 리스트 조회
	@Override
	public List<FarmdiaryVo> selectPagingFarmdiary(PageVo pageVo) {
		logger.debug("dao page {}, pageSize {}", pageVo.getPage(), pageVo.getPageSize());
		logger.debug("{}",template.selectList("fsurpports.selectPagingFarmdiary", pageVo));
		return template.selectList("fsurpports.selectPagingFarmdiary", pageVo);
	}
	
	// ggy_20210303 : 등록된 품목 코드 리스트 조회
	@Override
	public List<CodesVo> selectAllItem_codeList() {
		return template.selectList("fsurpports.selectAllItem_codeList");
	}
	
	// ggy_20210303 : 등록된 작업단계 리스트 조회
	@Override
	public List<CodesVo> selectAllWstep_codeList() {
		return template.selectList("fsurpports.selectAllWstep_codeList");
	}
	
	// ggy_20210303 : 등록된 일지 조건 검색
	@Override
	public List<FarmdiaryVo> searchAllFarmdiaryPagingList(FarmdiaryVo farmdiaryVo) {
		return template.selectList("fsurpports.searchAllFarmdiaryPagingList", farmdiaryVo);
	}

	
	

	
}
