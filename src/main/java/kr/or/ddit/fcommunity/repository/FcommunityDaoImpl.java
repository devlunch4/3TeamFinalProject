package kr.or.ddit.fcommunity.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.farm.model.MarketFilesVo;
import kr.or.ddit.farm.model.MiniMarketVo;

//20210318_ggy : FcommunityDaoImpl 생성
@Repository("fcommunityDao")
public class FcommunityDaoImpl implements FcommunityDao {
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate template;

	// 20210318_ggy : 미니장터 글 전체 조회
	@Override
	public List<MiniMarketVo> selectAllMiniMarketList() {
		return template.selectList("miniMarkets.selectAllMiniMarketList");
	}
	
	// 20210319_ggy: 미니장터 등록을 위한 머릿맛 코드 조회
	@Override
	public List<CodesVo> selectMiniMarketList() {
		return template.selectList("miniMarkets.selectMiniMarketList");
	}
	
	// 20210319_ggy : 미니장터 게시글 품목 종류 조회
	@Override
	public List<CodesVo> selectItemList() {
		return template.selectList("miniMarkets.selectItemList");
	}
	
	// 20210319_ggy : 미니장터 게시글 등록
	@Override
	public int registMiniMarketPost(MiniMarketVo miniMarketVo) {
		template.insert("miniMarkets.registMiniMarketPost", miniMarketVo);
		
		return miniMarketVo.getMarket_no(); 
	}
	
	// 20210319_ggy : 미니장터파일 등록
	@Override
	public int registmarketfiles(MarketFilesVo marketFilesVo) {
		return template.insert("miniMarkets.registmarketfiles", marketFilesVo);
	}
	
	// 20210319_ggy : 미니장터 게시글 상세 조회
	@Override
	public MiniMarketVo miniMarketInfo(MiniMarketVo miniMarketVo) {
		return template.selectOne("miniMarkets.miniMarketInfo", miniMarketVo);
	}
	
	
	
	
	
	
}
