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

	@Override
	public List<QnaVo> selectAllQna() {
		return template.selectList("qna.selectAllQna");
	}

	@Override
	public QnaVo selectOneListQna(int qna_no) {
		return template.selectOne("qna.selectOneListQna", qna_no);
	}

	
	
}
