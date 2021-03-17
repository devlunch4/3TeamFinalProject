package kr.or.ddit.finfo.service;

import java.util.List;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.farm.model.GardenguideVo;
import kr.or.ddit.farm.model.GuideSqlVo;
import kr.or.ddit.farm.model.ItemmanualVo;

public interface FinfoService {

	// 20210305 KWS 텃밭 가이드 조회 (텃밭코드로 조회)
	GardenguideVo selectGuide(int xgrdgd_code);

	// 20210305 KWS 텃밭 가이드 리스트 초성 조회 (쿼리문으로 조회)
	List<GardenguideVo> selectGuideList(GuideSqlVo guideSqlVo);

	// 20210308 KWS 텃밭 가이드 신규 등록
	int insertGuide(GardenguideVo gardenguideVo);

	// 20210308 KWS 텃밭 가이드 수정
	int updateGuide(GardenguideVo gardenguideVo);

	// 20210308 KWS 텃밭 가이드 삭제(use_yn값 N 수정)
	int deleteGuide(GardenguideVo gardenguideVo);

	// 20210316_ggy : 품목 리스트 조회
	List<CodesVo> itemFarmManualsList(String code_no);
	
	// 20210316_ggy : 품목 분류 리스트 조회
	List<CodesVo> itemClassList();
	
	// 20210316_ggy : 파일 다운로드를 위한 영농메뉴얼 조회
	List<ItemmanualVo> selectItemmanualFilenmList();
	
	// 20210316_ggy : 품목 메뉴얼 등록
	int registItemMenual(ItemmanualVo itemmanualVo);
	
	// 20210311 KWS 텃밭가이드 전체 글조회-관리자용
	List<GardenguideVo> selectGuideAll();
	
	// 20210312 KJH 텃밭가이드 작물명과 일치하는 대상조회 test ok
	GardenguideVo guide_codeselect(String str);

	// 20210311 KWS 제철정보 조회
	List<GardenguideVo> selectSeasons(String season);

}
