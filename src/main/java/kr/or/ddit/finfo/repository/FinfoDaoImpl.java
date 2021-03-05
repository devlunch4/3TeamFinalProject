package kr.or.ddit.finfo.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.farm.model.GardenguidesVo;
import kr.or.ddit.farm.model.GuideSqlVo;

@Repository("finfoDao")
public class FinfoDaoImpl implements FinfoDao {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate tempplate;

	// 20210305 KWS 텃밭 가이드 조회 (텃밭코드로 조회)
	@Override
	public GardenguidesVo selectGuide(int xgrdgd_code) {
		return tempplate.selectOne("guides.selectGuide", xgrdgd_code);
	}

	// 20210305 KWS 텃밭 가이드 리스트 초성 조회 (쿼리문으로 조회)
	@Override
	public List<GardenguidesVo> selectGuideList(GuideSqlVo guideSqlVo) {
		return tempplate.selectList("guides.selectGuideList", guideSqlVo);
	}

}
