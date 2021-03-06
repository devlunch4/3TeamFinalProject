package kr.or.ddit.fcommunity.repository;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.farm.model.MarketFilesVo;
import kr.or.ddit.farm.model.MarketReplyVo;
import kr.or.ddit.farm.model.MiniMarketVo;

//20210318_ggy : FcommunityDaoImpl 생성
@Repository("fcommunityDao")
public class FcommunityDaoImpl implements FcommunityDao {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate template;

	// 20210318_ggy : 미니장터 글 전체 조회
	@Override
	public List<MiniMarketVo> selectAllMiniMarketList(MiniMarketVo miniMarketVo) {
		return template.selectList("miniMarkets.selectAllMiniMarketList", miniMarketVo);
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

	// 20210319_ggy : 미니장터파일 조회
	@Override
	public List<MarketFilesVo> selectMarketFileList(int market_no) {
		return template.selectList("miniMarkets.selectMarketFileList", market_no);
	}

	// 20210320 : 미니장터 게시글 조회수 증가
	@Override
	public int addHitMiniMarket(int market_no) {
		return template.update("miniMarkets.addHitMiniMarket", market_no);
	}

	// 20210322_ggy : 첨부파일 삭제를 위해 파일 이름 정보 찾기
	@Override
	public MarketFilesVo selectMarketFilesInfo(int market_no) {
		return template.selectOne("miniMarkets.selectMarketFilesInfo", market_no);
	}

	// 20210322_ggy : 첨부파일 삭제
	@Override
	public int deleteMiniMarketFiles(int file_record_no) {
		return template.update("miniMarkets.deleteMiniMarketFiles", file_record_no);
	}

	// 20210322_ggy : 미니장터 게시글 수정
	@Override
	public int modifyMiniMarketInfo(MiniMarketVo miniMarketVo) {
		return template.update("miniMarkets.modifyMiniMarketInfo", miniMarketVo);
	}

	// 20210323_ggy : 미니장터 게시글 삭제
	@Override
	public int deleteMiniMarketPost(Map<String, String> map) {
		return template.update("miniMarkets.deleteMiniMarketPost", map);
	}

	// 20210324_ggy : 미니장터 썸네일 파일 삭제
	@Override
	public int deleteThumbnailFiles(int thumbnail_file_no) {
		return template.update("miniMarkets.deleteThumbnailFiles", thumbnail_file_no);
	}

	// 20210324_ggy : 미니장터 게시글 조회
	@Override
	public List<MarketReplyVo> selectMarketReplyList( int market_no ) {
		return template.selectList("miniMarkets.selectMarketReplyList", market_no);
	}

	// 20210324_ggy : 미니장터 게시글 삭제
	@Override
	public int registMarketReply(Map<String, String> map) {
		return template.insert("miniMarkets.registMarketReply", map);
	}

	// 20210325_ggy : 미니장터 게시글 댓글 수정
	@Override
	public int modifyMarketReply(Map<String, String> map) {
		return template.update("miniMarkets.modifyMarketReply", map);
	}

	// 20210325_ggy : 미니장터 게시글 댓글 삭제
	@Override
	public int deleteMarketReply(Map<String, String> map) {
		return template.update("miniMarkets.deleteMarketReply", map);
	}

}
