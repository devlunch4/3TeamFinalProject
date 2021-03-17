package kr.or.ddit.finfo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.farm.model.GardenguideVo;
import kr.or.ddit.farm.model.GuideSqlVo;
import kr.or.ddit.farm.model.ItemmanualVo;
import kr.or.ddit.finfo.repository.FinfoDaoImpl;

@Service("finfoService")
public class FinfoServiceImpl implements FinfoService {

	@Resource(name = "finfoDao")
	private FinfoDaoImpl finfoDao;

	// 20210305 KWS 텃밭 가이드 조회 (텃밭코드로 조회)
	@Override
	public GardenguideVo selectGuide(int xgrdgd_code) {
		return finfoDao.selectGuide(xgrdgd_code);
	}

	// 20210305 KWS 텃밭 가이드 리스트 초성 조회 (쿼리문으로 조회)
	@Override
	public List<GardenguideVo> selectGuideList(GuideSqlVo guideSqlVo) {
		return finfoDao.selectGuideList(guideSqlVo);
	}

	// 20210308 KWS 텃밭 가이드 신규 등록
	@Override
	public int insertGuide(GardenguideVo gardenguideVo) {
		return finfoDao.insertGuide(gardenguideVo);
	}

	// 20210308 KWS 텃밭 가이드 수정
	@Override
	public int updateGuide(GardenguideVo gardenguideVo) {
		return finfoDao.updateGuide(gardenguideVo);
	}

	// 20210308 KWS 텃밭 가이드 삭제(use_yn값 N 수정)
	@Override
	public int deleteGuide(GardenguideVo gardenguideVo) {
		return finfoDao.deleteGuide(gardenguideVo);
	}

	// 20210316_ggy : 품목 리스트 조회
	@Override
	public List<CodesVo> itemFarmManualsList(String code_no) {
		return finfoDao.itemFarmManualsList(code_no);
	}
	
	// 20210316_ggy : 품목 분류 리스트 조회
	@Override
	public List<CodesVo> itemClassList() {
		return finfoDao.itemClassList();
	}

	// 20210316_ggy : 품목 메뉴얼 등록
	@Override
	public int registItemMenual(ItemmanualVo itemmanualVo) {
		return finfoDao.registItemMenual(itemmanualVo);
	}

	// 20210316_ggy : 파일 다운로드를 위한 영농메뉴얼 조회
	@Override
	public List<ItemmanualVo> selectItemmanualFilenmList() {
		return finfoDao.selectItemmanualFilenmList();
	}

	// 20210311 KWS 텃밭가이드 전체 글조회-관리자용
	@Override
	public List<GardenguideVo> selectGuideAll() {
		return finfoDao.selectGuideAll();
	}
	
	// 20210312 KJH 텃밭가이드 작물명과 일치하는 대상조회 test ok
	@Override
	public GardenguideVo guide_codeselect(String str) {
		return finfoDao.guide_codeselect(str);
	}

	// 20210311 KWS 제철정보 조회
	@Override
	public List<GardenguideVo> selectSeasons(String season) {
		return finfoDao.selectSeasons(season);
	}
	
	// 20210317_ggy : 품목 메뉴얼 수정을 위한 정보 조회
	@Override
	public ItemmanualVo selectModifyItemMenualInfo(int manual_code) {
		return finfoDao.selectModifyItemMenualInfo(manual_code);
	}
	
	// 20210317_ggy : 품목 메뉴얼 수정
	@Override
	public int modifyItemMenualInfo(ItemmanualVo itemmanualVo) {
		return finfoDao.modifyItemMenualInfo(itemmanualVo);
	}
	
	// 20210317_ggy : 품목 메뉴얼 삭제
	@Override
	public int deleteItemMenualInfo(ItemmanualVo itemmanualVo) {
		return finfoDao.deleteItemMenualInfo(itemmanualVo);
	}
	

}
