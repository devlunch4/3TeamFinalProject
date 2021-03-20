package kr.or.ddit.fcommunity.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.farm.model.MarketFilesVo;
import kr.or.ddit.farm.model.MiniMarketVo;
import kr.or.ddit.fcommunity.repository.FcommunityDaoImpl;

// 20210318_ggy : FcommunityServiceImpl 생성

@Service("fcommunityService")
public class FcommunityServiceImpl implements FcommunityService{
	
	@Resource(name = "fcommunityDao")
	private FcommunityDaoImpl fcommunityDao;
	
	// 20210318_ggy : 미니장터 글 전체 조회
	@Override
	public List<MiniMarketVo> selectAllMiniMarketList(MiniMarketVo miniMarketVo) {
		return fcommunityDao.selectAllMiniMarketList(miniMarketVo);
	}
	
	// 20210319_ggy: 미니장터 등록을 위한 머릿맛 코드 조회
	@Override
	public List<CodesVo> selectMiniMarketList() {
		return fcommunityDao.selectMiniMarketList();
	}
	
	// 20210319_ggy : 미니장터 게시글 품목 종류 조회
	@Override
	public List<CodesVo> selectItemList() {
		return fcommunityDao.selectItemList();
	}
	
	// 20210319_ggy : 미니장터 게시글 등록
	@Override
	public int registMiniMarketPost(MiniMarketVo miniMarketVo) {
		return fcommunityDao.registMiniMarketPost(miniMarketVo);
	}
	
	// 20210319_ggy : 미니장터파일 등록
	@Override
	public int registmarketfiles(MarketFilesVo marketFilesVo) {
		return fcommunityDao.registmarketfiles(marketFilesVo);
	}

	// 20210319_ggy : 미니장터 게시글 상세 조회
	@Override
	public MiniMarketVo miniMarketInfo(MiniMarketVo miniMarketVo) {
		return fcommunityDao.miniMarketInfo(miniMarketVo);
	}
	
	// 20210319_ggy : 미니장터파일 조회
	@Override
	public List<MarketFilesVo> selectMarketFileList(int market_no) {
		return fcommunityDao.selectMarketFileList(market_no);
	}
	
	// 20210320 : 미니장터 게시글 조회수 증가
	@Override
	public int addHitMiniMarket(int market_no) {
		return fcommunityDao.addHitMiniMarket(market_no);
	}


}
