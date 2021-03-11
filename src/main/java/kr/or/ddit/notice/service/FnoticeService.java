package kr.or.ddit.notice.service;

import java.util.List;

import kr.or.ddit.farm.model.FnoticeVo;

public interface FnoticeService {

	// 20210311 전체 공지사항 조회 (경찬)
	List<FnoticeVo> selectAllNoticeList();

}
