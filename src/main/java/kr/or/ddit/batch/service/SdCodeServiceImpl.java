package kr.or.ddit.batch.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.batch.model.StandarditemcodeVo;
import kr.or.ddit.batch.repository.SdCodeDao;

@Service("sdCodeService")
public class SdCodeServiceImpl implements SdCodeService{
	
	@Resource(name = "sdCodeDao")
	private SdCodeDao sdCodeDao;
	
	public SdCodeServiceImpl() {
	}
	
	@Override
	public int sdcodeInsert(StandarditemcodeVo Vo) {
		return sdCodeDao.sdcodeInsert(Vo);
	}
	
	@Override
	public int allsdcodeDelete() {
		return sdCodeDao.allsdcodeDelete();
	}

}
