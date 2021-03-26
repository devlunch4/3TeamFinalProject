package kr.or.ddit.fanalysis.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.fanalysis.model.MyMaxMrrecListVo;
import kr.or.ddit.farm.model.FhistoryVo;
import kr.or.ddit.farm.model.FmanageVo;
import kr.or.ddit.farm.model.MsrrecVo;

@Repository("fanalysisDao")
public class FanalysisDaoImpl implements FanalysisDao {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate tempplate;

	// 20210304_KJH 내 시설 관측정보 조회
	@Override
	public MyMaxMrrecListVo myfanalysisInfo(MyMaxMrrecListVo mymaxmrreclistVo) {
		return tempplate.selectOne("fmanage.myfanalysisInfo", mymaxmrreclistVo);
	}

//	 20210305_KJH 내 시설 실시간 관측 조회
	@Override
	public MyMaxMrrecListVo mymaxmsrrecList(FhistoryVo fhistoryVo) {
		return tempplate.selectOne("fmanage.mymaxmsrrecList", fhistoryVo);
	}

	// 20210315_KJH 내 시설 관측정보 조회 ver 2 - 보유 시설 조회
	public List<FmanageVo> selectFmanage(String str) {
		return tempplate.selectList("fmanage.selectFmanage", str);
	}

	// 20210315_KJH 내 시설 관측정보 조회 ver 2 - 보유 시설 조회
	public MsrrecVo avgFmanage(MsrrecVo msrrecVo) {
		return tempplate.selectOne("fmanage.avgFmanage", msrrecVo);
	}

	@Override
	public List<MyMaxMrrecListVo> selectTempList() {
		// TODO Auto-generated method stub
		return tempplate.selectList("fmanage.selectTempList");
	}
}
