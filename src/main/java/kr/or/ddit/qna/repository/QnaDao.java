package kr.or.ddit.qna.repository;

import java.util.List;

import kr.or.ddit.farm.model.QnaVo;

//20210316 LYS  - 문의게시판 다오 인터페이스
public interface QnaDao {

	// 20210317_LYS_Q&A4 문의게시판 전체목록
	List<QnaVo> selectAllQna();

	// 20210317_LYS_Q&A4 문의게시판 상세조회
	QnaVo selectOneListQna(int qna_no);

	// 20210317_LYS_Q&A4 문의게시판 상세페이지 이동시 조회수 상승
	int updateHitCnt(int qna_no);

	// 20210317_LYS_Q&A4 문의게시판 게시글 등록
	int insertQna(QnaVo qnaVo);

	// 20210322_LYS 문의게시판 답글 등록- 관리자용
	int insertQnaAdminReply(QnaVo qnaVo);

	// 20210319_LYS_Q&A5 문의게시판 게시글 수정
	int updateQna(QnaVo qnaVo);

	// 20210319_LYS_Q&A5 문의게시판 게시글 삭제
	int updateUseynToN(int qna_no);

}