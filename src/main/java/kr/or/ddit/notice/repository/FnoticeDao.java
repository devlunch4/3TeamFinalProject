package kr.or.ddit.notice.repository;

import java.util.List;

import kr.or.ddit.farm.model.FnoticeVo;

public interface FnoticeDao {

	// 20210311 전체 공지사항 조회 (경찬)
	List<FnoticeVo> selectAllNoticeList();

	// 20210312 해당 공지사항 상세조회 (경찬)
	FnoticeVo selcetNotice(int notice_no);

	// 공지사항 삭제 하는거 03/15 (경찬)
	FnoticeVo deletenotice(int notice_no);

	// 관리자가 공지사항 등록하는거 03/16(경찬)
	int insertNotice(FnoticeVo noticeVo);
}
