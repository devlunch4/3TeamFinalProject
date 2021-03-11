package kr.or.ddit.fcommunity.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.fcommunity.repository.FcommunityDao;

@Service("FcommuintyService")
public class FcommunityServiceImpl implements FcommunityService {

	@Resource(name = "FcommunityDao")
	private FcommunityDao dao;

}
