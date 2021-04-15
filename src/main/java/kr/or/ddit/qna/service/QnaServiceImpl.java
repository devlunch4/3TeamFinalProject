package kr.or.ddit.qna.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.farm.model.QnaVo;
import kr.or.ddit.qna.repository.QnaDao;

//20210316 LYS - 문의게시판 서비스 구현체
@Service("QnaService")
public class QnaServiceImpl implements QnaService {

	@Resource(name = "QnaDao")
	private QnaDao dao;

	// 20210317_LYS_Q&A4 문의게시판 전체목록
	@Override
	public List<QnaVo> selectAllQna() {
		return dao.selectAllQna();
	}

	// 20210317_LYS_Q&A4 문의게시판 상세조회
	@Override
	public QnaVo selectOneListQna(int qna_no) {
		return dao.selectOneListQna(qna_no);
	}

	// 20210317_LYS_Q&A4 문의게시판 상세페이지 이동시 조회수 상승
	@Override
	public int updateHitCnt(int qna_no) {
		return dao.updateHitCnt(qna_no);
	}

	// 20210317_LYS_Q&A4 문의게시판 게시글 등록
	@Override
	public int insertQna(QnaVo qnaVo) {
		return dao.insertQna(qnaVo);
	}

	// 20210322_LYS 문의게시판 답글 등록- 관리자용
	@Override
	public int insertQnaAdminReply(QnaVo qnaVo) {
		return dao.insertQnaAdminReply(qnaVo);
	}

	// 20210319_LYS_Q&A5 문의게시판 게시글 수정
	@Override
	public int updateQna(QnaVo qnaVo) {
		return dao.updateQna(qnaVo);
	}

	// 20210319_LYS_Q&A5 문의게시판 게시글 삭제
	@Override
	public int updateUseynToN(int qna_no) {
		return dao.updateUseynToN(qna_no);
	}

}
