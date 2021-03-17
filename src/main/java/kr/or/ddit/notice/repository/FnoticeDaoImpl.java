package kr.or.ddit.notice.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.farm.model.FnoticeVo;

@Repository("FnoticeDao")
public class FnoticeDaoImpl implements FnoticeDao {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate template;

	// 20210311 전체 공지사항 조회 (경찬)
	@Override
	public List<FnoticeVo> selectAllNoticeList() {
		return template.selectList("community.selectAllNoticeList");
	}

	// 20210312 해당 공지사항 상세조회 (경찬)
	@Override
	public FnoticeVo selcetNotice(int notice_no) {
		return template.selectOne("community.selectNotice", notice_no);
	}

	// 공지사항 삭제 하는거 03/15 (경찬)
	@Override
	public FnoticeVo deletenotice(int notice_no) {
		return template.selectOne("community.deleteNotice", notice_no);
	}

	@Override
	public int insertNotice(FnoticeVo noticeVo) {
		return template.selectOne("community.insertNotice", noticeVo);
	}

}
