package kr.or.ddit.qna.repository;

import java.util.List;

import kr.or.ddit.farm.model.QnaVo;

//20210316 LYS  - 문의게시판 다오 인터페이스
public interface QnaDao {
	
	//문의게시판 전체목록
	List<QnaVo> selectAllQna();

	
}
