package kr.or.ddit.finfo.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.farm.model.GardenguideVo;
import kr.or.ddit.farm.model.GuideSqlVo;
import kr.or.ddit.farm.model.ItemmanualVo;
import kr.or.ddit.farm.model.WeeklyFarmInfosVo;

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

	// 20210312 KJH 텃밭가이드 작물명과 일치하는 대상조회 test ok
	@Override
	public GardenguideVo guide_codeselect(String str) {
		return tempplate.selectOne("guides.guide_codeselect", str);
	}

	// ////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////
	// 20210316_ggy : 품목 리스트 조회
	@Override
	public List<CodesVo> itemFarmManualsList(String code_no) {
		return tempplate.selectList("guides.itemFarmManualsList", code_no);
	}

	// 20210316_ggy : 품목 분류 리스트 조회
	@Override
	public List<CodesVo> itemClassList() {
		return tempplate.selectList("guides.itemClassList");
	}

	// 20210316_ggy : 품목 메뉴얼 등록
	@Override
	public int registItemMenual(ItemmanualVo itemmanualVo) {
		return tempplate.insert("guides.registItemMenual", itemmanualVo);
	}

	// 20210316_ggy : 파일 다운로드를 위한 영농메뉴얼 조회
	@Override
	public List<ItemmanualVo> selectItemmanualFilenmList() {
		return tempplate.selectList("guides.selectItemmanualFilenmList");
	}

	// 20210317_ggy : 품목 메뉴얼 수정을 위한 정보 조회
	@Override
	public ItemmanualVo selectModifyItemMenualInfo(int manual_code) {
		return tempplate.selectOne("guides.selectModifyItemMenualInfo", manual_code);
	}

	// 20210317_ggy : 품목 메뉴얼 수정
	@Override
	public int modifyItemMenualInfo(ItemmanualVo itemmanualVo) {
		return tempplate.update("guides.modifyItemMenualInfo", itemmanualVo);
	}

	// 20210317_ggy : 품목 메뉴얼 삭제
	@Override
	public int deleteItemMenualInfo(ItemmanualVo itemmanualVo) {
		return tempplate.update("guides.deleteItemMenualInfo", itemmanualVo);
	}
	
	// 20210326_ggy : 주간 농사정보 조회 
	@Override
	public List<WeeklyFarmInfosVo> selectWeeklyFarmInfosList() {
		
		return tempplate.selectList("guides.selectWeeklyFarmInfosList");
	}

	// 20210326_ggy : 주간 농사정보 등록
	@Override
	public int registWeeklyFarmInfos(Map<String, String> map) {
		return tempplate.insert("guides.registWeeklyFarmInfos", map);
	}

	// 20210326_ggy : 주간 농사정보 수정을 위한 조회
	@Override
	public WeeklyFarmInfosVo selectWeeklyFarmInfosInfo(Map<String, String> map) {
		return tempplate.selectOne("guides.selectWeeklyFarmInfosInfo", map);
	}
	

	// 20210326_ggy : 주간 농사정보 첨부파일 삭제
	@Override
	public int deleteWeeklyFarmInfosFiles(int file_no1) {
		return tempplate.update("guides.deleteWeeklyFarmInfosFiles", file_no1);
	}

	// 20210326_ggy : 주간 농사정보 수정
	@Override
	public int modifyWeeklyFarmInfos(Map<String, String> map) {
		return tempplate.update("guides.modifyWeeklyFarmInfos", map);
	}
	
	// 20210326_ggy : 주간 농사정보 삭제
	@Override
	public int deleteWeeklyFarmInfos(int w_info_no) {
		return tempplate.update("guides.deleteWeeklyFarmInfos", w_info_no);
	}

}
