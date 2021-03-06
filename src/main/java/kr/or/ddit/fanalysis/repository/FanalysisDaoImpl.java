package kr.or.ddit.fanalysis.repository;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.farm.model.MsrrecVo;

@Repository("fanalysisDao")
public class FanalysisDaoImpl implements FanalysisDao {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate tempplate;

	// 20210304_KJH 내 시설 관측정보 조회
	@Override
	public MsrrecVo myfanalysisInfo(MsrrecVo msrrecVo) {
		return tempplate.selectOne("fmanage.myfanalysisInfo", msrrecVo);
	}
	
	// 20210305_KJH 내 시설 실시간 관측 조회
//	@Override
//	public MyMaxMrrecListVo mymaxmsrrecList(MsrrecVo msrrecVo) {
//		return tempplate.selectOne("fmanage.mymaxmsrrecList",msrrecVo);
//	}

}
