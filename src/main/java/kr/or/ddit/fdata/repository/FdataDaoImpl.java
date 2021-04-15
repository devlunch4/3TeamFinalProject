package kr.or.ddit.fdata.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.farm.model.MsrrecVo;

@Repository("fdataDao")
public class FdataDaoImpl implements FdataDao {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate tempplate;

	// 20210302_KJH
	// codes 리스트 전체조회
	@Override
	public List<CodesVo> selectAllCodes() {
		return tempplate.selectList("codes.selectAllCodes");
	}

	@Override
	public CodesVo selectCode(String str) {
		return tempplate.selectOne("codes.selectCode", str);
	}

	@Override
	public List<FarmdiaryVo> farmCount() {
		return tempplate.selectList("fsurpports.farmCount");
	}

	// 20210310_KJH 날짜조건 품목비율
	@Override
	public List<FarmdiaryVo> datefarmCount(FarmdiaryVo vo) {
		return tempplate.selectList("fsurpports.datefarmCount", vo);
	}
	// 20210330 KJH 측정값저장
	@Override
	public int addData(MsrrecVo vo) {
		return tempplate.insert("fmanage.addData",vo);
	}

}