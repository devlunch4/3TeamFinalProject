package kr.or.ddit.notice.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.farm.model.FnoticeVo;
import kr.or.ddit.notice.repository.FnoticeDao;

@Service("FnoticeService")
public class FnoticeServiceImpl implements FnoticeService {

	@Resource(name = "FnoticeDao")
	private FnoticeDao FnoticeDao;

	public FnoticeServiceImpl() {
	}

	// 20210311 전체 공지사항 조회 (경찬)
	@Override
	public List<FnoticeVo> selectAllNoticeList() {
		return FnoticeDao.selectAllNoticeList();
	}

	// 20210312 해당 공지사항 상세조회 (경찬)
	@Override
	public FnoticeVo selcetNotice(int notice_no) {
		return FnoticeDao.selcetNotice(notice_no);
	}

	@Override
	public FnoticeVo deletenotice(int notice_no) {
		return FnoticeDao.deletenotice(notice_no);
	}

}
