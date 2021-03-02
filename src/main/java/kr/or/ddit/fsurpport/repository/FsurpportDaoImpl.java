package kr.or.ddit.fsurpport.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.farm.model.ItemsVo;
import kr.or.ddit.farm.model.WorkstepsVo;

@Repository("fsurpportDao")
public class FsurpportDaoImpl implements FsurpportDao{
	
	private static final Logger logger = LoggerFactory.getLogger(FsurpportDaoImpl.class);
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	// ggy_20210227 : 등록된 영농일지 조회
	@Override
	public List<FarmdiaryVo> selectAllFsurpportList() {
		logger.debug("in selectAllFsurpportList()");
		return template.selectList("fsurpports.selectAllFsurpportList");
	}
	
	// ggy_20210227 : 등록된 작업단계 조회
	@Override
	public List<WorkstepsVo> selectAllWorkstepsList() {
		return template.selectList("fsurpports.selectAllWorkstepsList");
	}
	
	// ggy_20210227 : 등록된 품목 조회
	@Override
	public List<ItemsVo> selectAllItemsList() {
		return template.selectList("fsurpports.selectAllItemsList");
	}

	@Override
	public List<FarmdiaryVo> searchAllFsurpportList(FarmdiaryVo farmdiaryVo) {
		return template.selectList("fsurpports.searchAllFsurpportList", farmdiaryVo);
	}
	
}
