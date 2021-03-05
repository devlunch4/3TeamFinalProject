package kr.or.ddit.fanalysis.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.fanalysis.repository.FanalysisDao;
import kr.or.ddit.farm.model.MsrrecVo;


@Service("fanalysisService")
public class FanalysisServiceImpl implements FanalysisService{
	
	@Resource(name = "fanalysisDao")
	private FanalysisDao fanalysisDao;

	public FanalysisServiceImpl() {
	}
	//20210304_KJH 내 시설 관측정보 조회
	@Override
	public MsrrecVo myfanalysisInfo(MsrrecVo msrrecVo) {
		
		return fanalysisDao.myfanalysisInfo(msrrecVo);
	}

}
