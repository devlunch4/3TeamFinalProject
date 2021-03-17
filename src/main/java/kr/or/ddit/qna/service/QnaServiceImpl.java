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

	@Override
	public List<QnaVo> selectAllQna() {
		return dao.selectAllQna();
	}

	@Override
	public QnaVo selectOneListQna(int qna_no) {
		return dao.selectOneListQna(qna_no);
	}

	
}
