package kr.or.ddit.finfo.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.farm.model.GardenguideVo;
import kr.or.ddit.farm.model.GuideSqlVo;

@Repository("finfoDao")
public class FinfoDaoImpl implements FinfoDao {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate tempplate;

	// 20210305 KWS 텃밭 가이드 조회 (텃밭코드로 조회)
	@Override
	public GardenguideVo selectGuide(int xgrdgd_code) {
		return tempplate.selectOne("guides.selectGuide", xgrdgd_code);
	}

	// 20210305 KWS 텃밭 가이드 리스트 초성 조회 (쿼리문으로 조회)
	@Override
	public List<GardenguideVo> selectGuideList(GuideSqlVo guideSqlVo) {
		return tempplate.selectList("guides.selectGuideList", guideSqlVo);
	}

	// 20210308 KWS 텃밭 가이드 신규 등록
	@Override
	public int insertGuide(GardenguideVo gardenguideVo) {
		return tempplate.insert("guides.insertGuide", gardenguideVo);
	}

	// 20210308 KWS 텃밭 가이드 수정
	@Override
	public int updateGuide(GardenguideVo gardenguideVo) {
		return tempplate.update("guides.updateGuide", gardenguideVo);
	}

	// 20210308 KWS 텃밭 가이드 삭제(use_yn값 N 수정)
	@Override
	public int deleteGuide(GardenguideVo gardenguideVo) {
		return tempplate.update("guides.deleteGuide", gardenguideVo);
	}

	// 20210311 KWS 텃밭가이드 전체 글조회-관리자용
	@Override
	public List<GardenguideVo> selectGuideAll() {
		return tempplate.selectList("guides.selectGuideAll");
	}

	// 20210311 KWS 제철정보 조회
	@Override
	public List<GardenguideVo> selectSeasons(String season) {
		return tempplate.selectList("seasons.selectSeasons", season);
	}

	// ////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////

	// 20210311_ggy : 품목 리스트 조회
	@Override
	public List<CodesVo> itemFarmManualsList() {
		return tempplate.selectList("guides.itemFarmManualsList");
	}

}
