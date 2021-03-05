package kr.or.ddit.finfo.repository;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.farm.model.GardenguidesVo;

@Repository("finfoDao")
public class FinfoDaoImpl implements FinfoDao {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate tempplate;

	// 20210305 KWS 텃밭 가이드 조회 (텃밭코드로 조회)
	@Override
	public GardenguidesVo selectGuide(int xgrdgd_code) {
		return tempplate.selectOne("guides.selectguide", xgrdgd_code);
	}

}
