package kr.or.ddit.finfo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.farm.model.GardenguidesVo;
import kr.or.ddit.farm.model.GuideSqlVo;
import kr.or.ddit.finfo.repository.FinfoDaoImpl;

@Service("finfoService")
public class FinfoServiceImpl implements FinfoService {

	@Resource(name = "finfoDao")
	private FinfoDaoImpl finfoDao;

	// 20210305 KWS 텃밭 가이드 조회 (텃밭코드로 조회)
	@Override
	public GardenguidesVo selectGuide(int xgrdgd_code) {
		return finfoDao.selectGuide(xgrdgd_code);
	}

	// 20210305 KWS 텃밭 가이드 리스트 초성 조회 (쿼리문으로 조회)
	@Override
	public List<GardenguidesVo> selectGuideList(GuideSqlVo guideSqlVo) {
		return finfoDao.selectGuideList(guideSqlVo);
	}

}
