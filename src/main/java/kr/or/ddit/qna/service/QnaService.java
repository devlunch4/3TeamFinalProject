package kr.or.ddit.qna.service;

import java.util.List;

import kr.or.ddit.farm.model.QnaVo;

//20210316 LYS - 문의게시판 서비스 인터페이스
public interface QnaService {

	//문의게시판 전체목록
	List<QnaVo> selectAllQna();

	//문의게시판 상세조회
	QnaVo selectOneListQna(int qna_no);
		
}
