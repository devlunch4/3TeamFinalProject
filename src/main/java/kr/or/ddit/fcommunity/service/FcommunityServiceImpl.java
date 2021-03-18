package kr.or.ddit.fcommunity.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.farm.model.MiniMarketVo;
import kr.or.ddit.fcommunity.repository.FcommunityDaoImpl;

// 20210318_ggy : FcommunityServiceImpl 생성

@Service("fcommunityService")
public class FcommunityServiceImpl implements FcommunityService{
	
	@Resource(name = "fcommunityDao")
	private FcommunityDaoImpl fcommunityDao;
	
	// 20210318_ggy : 미니장터 글 전체 조회
	@Override
	public List<MiniMarketVo> selectAllMiniMarketList() {
		return fcommunityDao.selectAllMiniMarketList();
	}

}
