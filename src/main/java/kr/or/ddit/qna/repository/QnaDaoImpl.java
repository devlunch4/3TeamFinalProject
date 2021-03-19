package kr.or.ddit.qna.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.farm.model.QnaVo;

//20210316 LYS - 문의게시판 다오 구현체
@Repository("QnaDao")
public class QnaDaoImpl implements QnaDao {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate template;

	//20210317_LYS_Q&A4 문의게시판 전체목록
	@Override
	public List<QnaVo> selectAllQna() {
		return template.selectList("qna.selectAllQna");
	}

	//20210317_LYS_Q&A4 문의게시판 상세조회
	@Override
	public QnaVo selectOneListQna(int qna_no) {
		return template.selectOne("qna.selectOneListQna", qna_no);
	}

	//20210317_LYS_Q&A4 문의게시판 상세페이지 이동시 조회수 상승
	@Override
	public int updateHitCnt(int qna_no) {
		return template.update("qna.updateHitCnt", qna_no);
	}

	//20210317_LYS_Q&A4 문의게시판 게시글 등록
	@Override
	public int insertQna(QnaVo qnaVo) {
		return template.insert("qna.insertQna", qnaVo);
	}

	//20210319_LYS_Q&A5 문의게시판 게시글 수정
	@Override
	public int updateQna(QnaVo qnaVo) {
		return template.update("qna.updateQna", qnaVo);
	}

	//20210319_LYS_Q&A5 문의게시판 게시글 삭제
	@Override
	public int updateUseynToN(int qna_no) {
		return template.update("qna.updateUseynToN", qna_no);
	}

	
	
}
