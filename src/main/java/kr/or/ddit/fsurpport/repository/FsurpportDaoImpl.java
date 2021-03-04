package kr.or.ddit.fsurpport.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.farm.model.FcltmngVo;
import kr.or.ddit.farm.model.MsrrecVo;

@Repository("fsurpportDao")
public class FsurpportDaoImpl implements FsurpportDao {

	private static final Logger logger = LoggerFactory.getLogger(FsurpportDaoImpl.class);

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate template;

	// ggy_20210303 : 등록된 영농일지 전체 리스트 조회
	@Override
	public List<FarmdiaryVo> selectAllFsurpportList() {
		return template.selectList("fsurpports.selectAllFsurpportList");
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
	public List<FarmdiaryVo> searchAllFarmdiaryList(FarmdiaryVo farmdiaryVo) {
		return template.selectList("fsurpports.searchAllFarmdiaryList", farmdiaryVo);
	}

	/* 시설관리 영역 */

	// 20210302_KJH 시설리스트 조회
	@Override
	public List<FcltmngVo> myfcltmngList() {
		return template.selectList("fcltmng.myfcltmngList");
	}
	// 20210302_KJH 시설 상세조회
	@Override
	public FcltmngVo fcltmngInfo(String str) {
		return template.selectOne("fcltmng.fcltmngInfo", str);
	}
	// 20210304_KJH 시설 최근 측정정보 조회
	@Override
	public MsrrecVo latelyData(String msr_code) {
		return template.selectOne("fcltmng.latelyData",msr_code);
	}
}
