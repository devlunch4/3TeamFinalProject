package kr.or.ddit.fcommunity.repository;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.farm.model.MarketFilesVo;
import kr.or.ddit.farm.model.MarketReplyVo;
import kr.or.ddit.farm.model.MiniMarketVo;

// 20210318_ggy : FcommunityDao 생성
public interface FcommunityDao {
	
	// 20210318_ggy : 미니장터 글 전체 조회
	List<MiniMarketVo> selectAllMiniMarketList(MiniMarketVo miniMarketVo);
	
	// 20210319_ggy: 미니장터 등록을 위한 머릿맛 코드 조회
	List<CodesVo> selectMiniMarketList();
	
	// 20210319_ggy : 미니장터 게시글 품목 종류 조회
	List<CodesVo> selectItemList();
	
	// 20210319_ggy : 미니장터 게시글 등록
	int registMiniMarketPost(MiniMarketVo miniMarketVo);
	
	// 20210319_ggy : 미니장터파일 등록
	int registmarketfiles(MarketFilesVo marketFilesVo);
	
	// 20210319_ggy : 미니장터 게시글 상세 조회
	MiniMarketVo miniMarketInfo(MiniMarketVo miniMarketVo);
	
	// 20210319_ggy : 미니장터파일 조회
	List<MarketFilesVo> selectMarketFileList(int market_no);
	
	// 20210320 : 미니장터 게시글 조회수 증가
	int addHitMiniMarket(int market_no);

	// 20210322_ggy : 첨부파일 삭제를 위해 파일 이름 정보 찾기
	MarketFilesVo selectMarketFilesInfo(int market_no);

	// 20210322_ggy : 첨부파일 삭제
	int deleteMiniMarketFiles(int file_record_no);

	// 20210322_ggy : 미니장터 게시글 수정
	int modifyMiniMarketInfo(MiniMarketVo miniMarketVo);

	// 20210323_ggy : 미니장터 게시글 삭제
	int deleteMiniMarketPost(Map<String, String> map);
	
	// 20210324_ggy : 미니장터 썸네일 파일 삭제
	int deleteThumbnailFiles(int thumbnail_file_no);

	// 20210324_ggy : 미니장터 게시글 조회
	List<MarketReplyVo> selectMarketReplyList();
	
	// 20210324_ggy : 미니장터 게시글 삭제
	int registMarketReply(Map<String, String> map);
	
}
