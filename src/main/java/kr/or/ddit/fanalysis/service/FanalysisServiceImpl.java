package kr.or.ddit.fanalysis.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.fanalysis.model.MyMaxMrrecListVo;
import kr.or.ddit.fanalysis.repository.FanalysisDao;
import kr.or.ddit.farm.model.FhistoryVo;
import kr.or.ddit.farm.model.FmanageVo;
import kr.or.ddit.farm.model.MsrrecVo;

@Service("fanalysisService")
public class FanalysisServiceImpl implements FanalysisService {

	@Resource(name = "fanalysisDao")
	private FanalysisDao fanalysisDao;

	public FanalysisServiceImpl() {
	}

	// 20210304_KJH 내 시설 관측정보 조회 test ok
	@Override
	public MyMaxMrrecListVo myfanalysisInfo(MyMaxMrrecListVo mymaxmrreclistVo) {

		return fanalysisDao.myfanalysisInfo(mymaxmrreclistVo);
	}

	// 20210305_KJH 내 시설 실시간 관측 조회 test ok
	@Override
	public MyMaxMrrecListVo mymaxmsrrecList(FhistoryVo fhistoryVo) {
		return fanalysisDao.mymaxmsrrecList(fhistoryVo);
	}

	@Override
	public List<FmanageVo> selectFmanage(String str) {
		return fanalysisDao.selectFmanage(str);
	}

	@Override
	public MsrrecVo avgFmanage(MsrrecVo msrrecVo) {
		return fanalysisDao.avgFmanage(msrrecVo);
	}

	@Override
	public List<MyMaxMrrecListVo> selectTempList() {
		// TODO Auto-generated method stub
		return fanalysisDao.selectTempList();
	}
}
