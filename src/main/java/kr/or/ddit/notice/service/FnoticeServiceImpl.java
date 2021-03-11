package kr.or.ddit.notice.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.farm.model.FnoticeVo;
import kr.or.ddit.notice.repository.FnoticeDao;
import kr.or.ddit.notice.repository.FnoticeDaoImpl;
import kr.or.ddit.user.repository.UserDaoImpl;

@Service("FnoticeService")
public class FnoticeServiceImpl implements FnoticeService {

	@Resource(name = "FnoticeDao")
	private FnoticeDao FnoticeDao;

	public FnoticeServiceImpl() {
	}

	public FnoticeServiceImpl(FnoticeDao FnoticeDao) {
		this.FnoticeDao = FnoticeDao;
	}

	@Override
	public List<FnoticeVo> selectAllNoticeList() {
		return FnoticeDao.selectAllNoticeList();
	}

}
