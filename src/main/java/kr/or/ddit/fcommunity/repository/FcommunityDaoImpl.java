package kr.or.ddit.fcommunity.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.farm.model.MiniMarketVo;

//20210318_ggy : FcommunityDaoImpl 생성
@Repository("fcommunityDao")
public class FcommunityDaoImpl implements FcommunityDao {
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate template;

	// 20210318_ggy : 미니장터 글 전체 조회
	@Override
	public List<MiniMarketVo> selectAllMiniMarketList() {
		return template.selectList("miniMarkets.selectAllMiniMarketList");
	}
	
	// 20210319_ggy: 미니장터 등록을 위한 머릿맛 코드 조회
	@Override
	public List<CodesVo> selectMiniMarketList() {
		return template.selectList("miniMarkets.selectMiniMarketList");
	}
	
	
	
	
}
